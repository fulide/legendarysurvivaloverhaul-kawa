# LSO 1.21.1 口渴模糊与 1.20.1 不一致：根因与修复

- 对象：`【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar`（源码来自你提供的 `.jar.src.zip`）
- 对照：`Alex-Hashtag/LegendarySurvivalOverhaul` 的 `1.20.1` 分支 + Mojang 官方 1.20.1 客户端 jar（SHA1 `0c3ec587…`）
- 产物：`…-fixed4.jar`（已装进 `mods`），4 个着色器资源 + 重写的 `FocusShader.class`

---

## 0. 结论

fixed3 的口渴模糊**根本没有生效**：它想加载原版 `blobs2` 后处理链，1.21.1 原版已经删掉这个文件，而加载失败后它的回退分支**永远进不去**，于是每帧直接 `return`，画面既不模糊、也不会报错给玩家看。

修复 = 把 1.20.1 原版的 `blobs2` 后处理链随模组带上（逐字节相同）+ 重写 `FocusShader` 的加载/回退/重载逻辑。现在效果与 1.20.1 是**同一份 shader、同一套强度曲线**。

---

## 1. 日志证据

`D:\minecraft\原版+\.minecraft\logs\latest.log`（你 12:31 那次测试）：

```
[18… 12:31:33.028] [Render thread/WARN] [net.minecraft.client.renderer.GameRenderer/]:
Failed to load shader: minecraft:shaders/post/blobs2.json
java.io.FileNotFoundException: minecraft:shaders/post/blobs2.json
    at …RenderBlurOverlay.render(RenderBlurOverlay.java:39)
```

整份日志里 `blobs2.json` 只出现 2 次（一次是这次失败，一次是类名），**之后再没有重试**。

---

## 2. 根因（四层，缺一不可）

### 2.1 1.21.1 原版删掉了 `blobs2` 后处理链

| | 1.20.1 客户端 jar | 1.21.1 客户端 jar |
|---|---|---|
| `shaders/post/blobs2.json` | 312 B，2 趟（blobs2 → blit） | **不存在** |
| `shaders/program/blobs2.json` | 605 B | **不存在** |
| `shaders/program/blobs2.fsh` | 1022 B（max 型采样） | **不存在** |
| `shaders/program/blobs.vsh` | 301 B（提供 `oneTexel`） | **不存在** |
| `shaders/post/blur.json` | 856 B，2 趟 `blur`，Radius 20 | 2184 B，**6 趟 `box_blur`**，Radius 5 |

1.20.1 的模组源码里就是：

```java
public static final ResourceLocation BLUR_SHADER = new ResourceLocation("shaders/post/blobs2.json");
// 没有命名空间 => minecraft:shaders/post/blobs2.json => 用的就是原版文件
```

`1.20.1` 分支的 `src/main/resources` 下**没有任何 shader 资源**，所以 1.20.1 完全依赖原版自带的 blobs2。

### 2.2 fixed3 的“blur 回退”是死代码

fixed3 的写法（`FocusShader.java` 30–47 行）：

```java
try {
    mc.gameRenderer.loadEffect(BLOBS2_SHADER);
    effect = mc.gameRenderer.currentEffect();
    shaderAvailable = (effect != null);      // 失败时这里是 false
} catch (Throwable t) {
    mc.gameRenderer.loadEffect(BLUR_SHADER); // ← 永远进不来
}
if (!shaderAvailable) return;                // ← 直接退出，什么都不做
```

`GameRenderer.loadEffect` 内部自己 `catch (IOException | JsonSyntaxException)`，只打日志、把 `postEffect` 置空，**不会把异常抛给调用方**。所以 `catch (Throwable)` 是死代码，`shaderAvailable` 永远为 `false`，`render()` 每帧在这里返回。

### 2.3 就算回退成功，1.21.1 的 `blur` 也不是 1.20.1 的效果

- 1.20.1 `blobs2.fsh`：对 `Radius` 半径内的 8 个方向做 **max** 采样（`maxVal`），相当于“把亮部往外抹开/发晕”，半径 0–4 像素。
- 1.21.1 `blur.json`：**6 趟 box blur**（Radius 5，乘数 1/1/0.5/0.5/0.25/0.25，还开了线性过滤），是整屏均匀高斯糊。

两者观感完全不同：前者是“中暑/脱水式的亮部晕开”，后者是“镜头糊了”。所以哪怕修好回退，也不能拿来当替代品。

![算法差异示意（PIL 近似模拟，半径都取 4）](lso/fix4/preview_blur_compare.png)

> 上图只是用截图做的算法近似：A 是 1.20.1 的 blobs2（max/膨胀，边缘亮部外溢，静态图不明显、移动时最明显），B 是 1.21.1 的 `blur.json`（6 趟 box blur，整屏糊掉），C 是原图。游戏里后处理在 GUI 之前，准星/物品栏不受影响。

### 2.4 附带 bug：模糊不会“再次出现”

`shaderLoadAttempted` 是 **static**，只加载一次；而且 `render()` 开头拿到 `effect == null` 时直接 `return`（50–52 行）。

- 喝水把水分补回去 → `shaderIntensity` 归零 → `stopRender()` 关闭效果，`focusShader = null`
- 再次变渴 → 新建 `FocusShader`，但 `shaderLoadAttempted` 仍是 `true`、`effect` 仍是 `null` → 直接返回，**这辈子都不会再模糊**

1.20.1 的写法是每帧判断 `currentEffect == null || 名字不对` 就重新 `loadEffect`，没有这个 latch。

---

## 3. 修复内容

### 3.1 资源：把 1.20.1 原版的 blobs2 随模组带上

| jar 内路径 | 大小 | SHA256 | 说明 |
|---|---|---|---|
| `assets/legendarysurvivaloverhaul/shaders/post/blobs2.json` | 312 B | `18BAF1AB…AEE97F` | 后处理链：blobs2(main→swap) → blit(swap→main) |
| `assets/minecraft/shaders/program/blobs2.json` | 605 B | `68441FBC…C69175` | 与 1.20.1 官方客户端**逐字节相同** |
| `assets/minecraft/shaders/program/blobs2.fsh` | 1022 B | `093BD4CB…D4171D` | 同上 |
| `assets/minecraft/shaders/program/blobs.vsh` | 301 B | `00B172CC…43E0B` | 同上 |

**为什么 program 必须放在 `minecraft` 命名空间**（这是 1.21.1 的硬编码，不是选择）：

1. `PostChain` 解析 pass 名时是 `ResourceLocation.parse(name).getPath()` —— 命名空间被丢掉，只留路径；
2. `EffectInstance` 再拼 `ResourceLocation.withDefaultNamespace("shaders/program/" + name + ".json")` —— 强制 `minecraft`。

所以模组命名空间下的 program JSON 永远查不到（这也是作者 1.21.1 分支里 `assets/legendarysurvivaloverhaul/shaders/program/blobs2.fsh` 是 0 字节、整套 shader 变成死资源的原因）。实例里的 ModernUI 也是用同样方式提供 `assets/minecraft/shaders/post/*.json` + `program/*`，可以正常工作，这条路径是验证过的。

后处理链本身用模组命名空间（`GameRenderer.loadEffect` 接受任意 `ResourceLocation`），这样不会和资源包/其他模组抢 `minecraft:shaders/post/blobs2.json`。

### 3.2 代码：重写 `FocusShader`

- 每帧检查 `currentEffect` 是否是自己要的链，不是就**重新加载**（恢复 1.20.1 的“随用随载”）；
- `loadEffect` 之后判断 `currentEffect() == null` 作为失败信号（不再指望异常）；
- 失败才回退到 `minecraft:shaders/post/blur.json`，并且**只告警一次 + latch**，避免每帧刷日志；
- `stopRender` 只关闭自己加载的效果（fixed3 会把任何后处理效果都关掉，可能误伤别的模组）；
- `Radius` 每帧写入 0..4：`PostChain.setUniform("Radius", intensity)` 会遍历所有 pass，`blit` pass 没有这个 uniform 时走 `DUMMY_UNIFORM` 空操作，不会崩。

### 3.3 与 1.20.1 对齐的点

| 项目 | 1.20.1 | fixed4 |
|---|---|---|
| shader 文件 | 原版 blobs2 | 同一份文件（逐字节相同） |
| 强度 | `Radius` = 0..4 | 相同 |
| 强度曲线 | 水分 6→2 格线性，`updateTimer % 2`（10 Hz） | 未改 `RenderBlurOverlay`，完全相同 |
| 触发阶段 | `RenderLevelStageEvent.AFTER_WEATHER` | 未改，相同 |
| 停止时机 | 创意/旁观/死亡/强度归零 | 相同，且只关自己的效果 |

---

## 4. 验证

1. **25 项静态检查**（`verify_jar.py`）全过：资源存在、后处理链两趟且写回 `minecraft:main`、pass 名按 1.21.1 规则能解析到打包的 program JSON、`Position`/`DiffuseSampler`/`ProjMat`/`InSize`/`Radius` 齐全、三个 shader 文件与 1.20.1 客户端逐字节相同、class 版本 65（Java 21）。
2. **GLSL 实测**：用 LWJGL 建真实 OpenGL 3.2 core 上下文（NVIDIA RTX 4070 SUPER），`blobs.vsh` + `blobs2.fsh` 编译、链接全部通过，`Radius` 是 active uniform（location 3）——保证 `setUniform("Radius", …)` 能生效。
3. **底包完整性**：原 jar 2915 个条目里，除 `FocusShader.class` 外全部逐字节未变（逐个 SHA256 比对，0 差异），新增 4 个资源，共 2919 条。

---

## 5. 安装与回滚

已处理：

- 新 jar：`D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed6.jar`
- 旧 jar 备份：`D:\minecraft\原版+\.minecraft\lso-backup\` 下的 fixed3 / fixed4 / fixed5

回滚：删掉 fixed6，把想要的备份移回 `mods` 即可。

### 进游戏自测

1. 把水分降到 **6 格及以下** → 应出现 actionbar 提示 `Vision is getting blurry. Drink some water`，画面开始出现“亮部晕开”的脱水效果（半径随水分降低从 0 涨到 4 像素）；
2. 喝水恢复 → 效果应在约 1–2 秒内淡出；
3. 再次变渴 → 效果应**重新出现**（这是 fixed3 修不好的那一条）；
4. 看 `logs/latest.log`：
   - 不应再出现 `Failed to load shader: minecraft:shaders/post/blobs2.json`；
   - 若出现 `Thirst blur: legendarysurvivaloverhaul:shaders/post/blobs2.json could not be loaded, falling back…`，说明资源被别的资源包覆盖/挡住了，把那行告警发我。

---

## 6. 文件清单

| 文件 | 用途 |
|---|---|
| `lso/fix4/out/…-fixed4.jar` | 修复后的模组（SHA256 `267F9026…38D6B`） |
| `lso/fix4/src/…/FocusShader.java` | 重写后的源码 |
| `lso/fix4/assets/` | 4 个着色器资源 |
| `lso/fix4/build.ps1` | 重新编译 + 重新打包（改完源码可直接跑） |
| `lso/fix4/verify_jar.py` | 校验脚本（25 项） |
| `lso/dl1201/1.20.1-client.jar` | 官方 1.20.1 客户端，用于取原版 shader（SHA1 已核对） |
| `lso/dl1201/repo1201/` | `1.20.1` 分支源码，用于对照 `FocusShader` / `RenderBlurOverlay` |

### 以后再更新模组怎么办

`FocusShader` 的逻辑和 4 个资源与模组版本无关，更新后：

1. 用 `build.ps1`（把 `-BaseJar` 指向新版 jar）重新打包；或
2. 手动把 4 个资源塞进新 jar + 用新 jar 的 classpath 重编译 `FocusShader`。

如果新版模组自己修好了 `blobs2`（或改了 `RenderBlurOverlay` 的强度曲线），以新版为准，不要覆盖。

---

# 追加修复（fixed5）

## 7.1 actionbar 提示改为语言键

原代码（1.20.1 也是硬编码）：

```java
player.displayClientMessage(Component.literal("Vision is getting blurry. Drink some water"), true);
```

改为：

```java
player.displayClientMessage(Component.translatable("message.legendarysurvivaloverhaul.thirst.blur_warning"), true);
```

新增翻译（键名沿用 `message.legendarysurvivaloverhaul.*` 命名习惯）：

| lang | 文本 |
|---|---|
| `en_us` | `Vision is getting blurry. Drink some water` |
| `zh_cn` | `视线开始模糊了，喝点水吧` |

其它语言没加：1.21.1 的 `ClientLanguage#loadFrom` 会把 `en_us` 和当前语言一起加载，缺键自动回退英文，不会显示成 `message.xxx`。

另外，语言文件是按**资源栈逐键合并**的（`getResourceStack` + `appendFrom`），所以即使 `汉化补充.zip` 里也有本模组的 `zh_cn.json`，其中没有这个键也不会把它“覆盖掉”——最终仍取模组 jar 里的值。想改文案直接改 `assets/legendarysurvivaloverhaul/lang/zh_cn.json` 里的这个键即可，不用动代码。

## 7.2 水分归零后掉血被击退

根因是 1.21 新加的通用规则，不是模组自己写的击退：

```java
// LivingEntity.hurt (1.21.1)
if (!source.is(DamageTypeTags.NO_KNOCKBACK)) {
    double dx = 0, dz = 0;
    ... // projectile / source position 两种方向来源
    this.knockback(0.4, dx, dz);          // 没有方向时 dx=dz=0
    if (!flag) this.indicateDamage(dx, dz);
}
```

`knockback(0.4, 0, 0)` 在 `Vec3(0,0,0).normalize()` 后方向为零向量，结果是**水平速度减半 + 竖直 +0.4**——每 4 秒掉一次血就被“顶”一下。1.20.1 没有 `no_knockback` 这套标签（连这个 tag 文件都不存在），所以当年不会击退。

1.21.1 移植其实已经加了 `data/minecraft/tags/damage_type/no_knockback.json`，但只写了：

```json
"legendarysurvivaloverhaul:hypothermia",
"legendarysurvivaloverhaul:hyperthermia"
```

**漏了 `dehydration`**。补上即可（与 `minecraft:no_knockback` 里的 `starve` / `drown` / `freeze` 同理）：

```json
{
  "replace": false,
  "values": [
    "legendarysurvivaloverhaul:hypothermia",
    "legendarysurvivaloverhaul:hyperthermia",
    "legendarysurvivaloverhaul:dehydration"
  ]
}
```

现在三种自定义伤害（低温/高温/脱水）都不会再击退，和 1.20.1 一致。

## 7.3 验证

`fix5/verify_fix5.py` 共 24 项，全部通过：

- `RenderBlurOverlay.class` 版本 65，常量池里有新键，**不再包含** `Vision is getting blurry` 字面量；
- `en_us` / `zh_cn` 键数各 +1、原有键一个不少、无重复键，`en_us` 的 UTF-8 BOM 保留；
- `no_knockback` 同时包含三种自定义伤害，`replace:false` 不变；
- 4 个着色器资源与 fixed4 完全一致、`blobs2.fsh` 仍与 1.20.1 官方客户端逐字节相同；
- 2919 个条目里只有上述 4 个被替换，其余全部逐字节未变。

## 7.4 文件

| 文件 | 用途 |
|---|---|
| `lso/fix5/out/…-fixed5.jar` | 当前安装版（SHA256 `6C4C85DA…1FA13`） |
| `lso/fix5/src/…/RenderBlurOverlay.java` | 改为语言键的源码 |
| `lso/fix5/res/lang/{en_us,zh_cn}.json` | 加了新键的语言文件 |
| `lso/fix5/res/tags/no_knockback.json` | 补了 dehydration 的伤害标签 |
| `lso/fix5/verify_fix5.py` | 24 项校验脚本 |

---

# 追加修复（fixed6）：删除肢体相关的高频日志

## 8.1 问题

肢体回血 / 身体界面每次 tick、每帧都在写 INFO 日志。你那份 `latest.log` 里 LSO 一共 **374,863 行**，绝大部分来自：

| 日志 | 位置 | 频率 |
|---|---|---|
| `[ITEM HEALING] …has N healing ticks remaining…` | `BodyDamageAttachment.tickUpdate` | 每 20 tick、每个正在回血的肢体一条 |
| `[FIRST AID HEALING] …` | 同上 | 每次急救包回血 |
| `[PASSIVE REGEN HEALING] …` | 同上 | 每次被动回血 |
| `[BodyPartButton] setHealthRatio …` | `BodyPartButton.setHealthRatio` | 打开身体界面时每帧 ×8 个部位 |
| `[BodyPartCondition] get(…): returning …` | `BodyPartButton$BodyPartCondition.get` | 同上，每帧 ×8 |
| `[drawHealthBar] …ratio=…, barWidth=…` | `BodyHealthScreen.drawHealthBar` | 同上，每帧 ×8 |
| `[drawHealthBar] Drawing filled bar at …` | 同上 | 同上 |

合计：`Drawing filled bar` 93,704 行、`returning HEALTHY` 83,014 行、`setHealthRatio` / `barWidth` 各约 1 万行。

## 8.2 处理方式

不是调日志等级“藏起来”，而是**把这些 `LOGGER.info(...)` 调用从字节码里删掉**：

- 用 ASM（`asm-tree`）遍历这 4 个 class，定位 `GETSTATIC LegendarySurvivalOverhaul.LOGGER` → `INVOKEINTERFACE Logger.info` 的整段表达式，连参数一起删除；
- 删除范围内不含跳转/label 目标，删除后原方法其余指令**一条没动**；
- 没有重新编译反编译源码，避免 Vineflower 反编译带来的语义漂移。

被改的 4 个类：

| class | 删除条数 |
|---|---|
| `common/attachments/bodydamage/BodyDamageAttachment.class` | 3 |
| `client/screens/BodyPartButton.class` | 1 |
| `client/screens/BodyPartButton$BodyPartCondition.class` | 1 |
| `client/screens/BodyHealthScreen.class` | 2 |

保留的日志：数据加载时的 `Loaded N …`（每次资源重载一次）、`error`/`warn`，以及其它与肢体无关的日志。调试用的 `debug()` 只在开 debug 时输出，未动。

## 8.3 验证

- 归一化后逐方法对比新旧字节码：这 4 个类**只有**上述 7 处 `LOGGER.info` 指令序列被删除，其余方法指令完全一致；其余 2915 个 jar 条目逐字节未变；
- 4 个类都用 `Class.forName` 实际加载 + 链接通过（无 `VerifyError`）；
- `verify_fix6.py` 13 项全过：条目数 2919、只替换 4 个类、class 版本 65、4 个类里已不含 `[ITEM HEALING]` / `[drawHealthBar]` 等字符串；着色器、语言文件、`no_knockback` 标签未受影响。

## 8.4 文件

| 文件 | 用途 |
|---|---|
| `lso/fix6/out/…-fixed6.jar` | 当前安装版（SHA256 `E9AA69BD…12585`） |
| `lso/fix6/asm/StripLoggerCalls.java` | 删除 `LOGGER.info` 调用的 ASM 工具（可复用于以后版本） |
| `lso/fix6/asm/in/` | 改好的 4 个 class |
| `lso/fix6/bytecode_diff.py` | 归一化字节码对比脚本 |
| `lso/fix6/verify_fix6.py` | 13 项校验脚本 |

以后再更新模组时，这份 ASM 工具可以直接对新 jar 里的同名 class 重跑（`StripLoggerCalls` 只认 `LOGGER.info` 的固定字节码形态，找不到就报错，不会误删）。
