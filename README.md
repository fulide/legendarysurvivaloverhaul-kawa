# Legendary Survival Overhaul — Kawa

对 **Legendary Survival Overhaul (LSO) 1.21.1 / 2.4.2 (fixed3)** 的个人修复构建，面向 Minecraft **1.21.1 + NeoForge**。

> 这是非官方修改版，与原作者 sfiomn / Alex-Hashtag 无关。安装前请备份存档。

## 修复内容

| # | 问题 | 处理 |
|---|---|---|
| 1 | 口渴模糊与 1.20.1 不一致（fixed3 里 shader 加载失败后直接静默返回，画面完全不模糊） | 随 jar 打包 1.20.1 原版 `blobs2` 后处理链（与 Mojang 1.20.1 客户端逐字节相同），重写 `FocusShader`：命名空间、失败回退、可重复加载、只关闭自己加载的效果 |
| 2 | actionbar 提示 `Vision is getting blurry...` 是硬编码英文 | 改为语言键 `message.legendarysurvivaloverhaul.thirst.blur_warning`，补 `en_us` / `zh_cn` |
| 3 | 水分归零掉血时被击退（1.21 新增 `no_knockback` 规则） | 在 `data/minecraft/tags/damage_type/no_knockback.json` 补上 `legendarysurvivaloverhaul:dehydration` |
| 4 | 肢体回血 / 身体界面每 tick、每帧刷大量 INFO 日志 | 用 ASM 在字节码层删除 7 处 `LOGGER.info(...)` 调用（不是调日志等级），其余字节码未动 |

详细排查过程、证据与验证方法见 [`docs/fixes-zh.md`](docs/fixes-zh.md)。

## 安装

1. 备份存档；
2. 删除旧的 LSO jar；
3. 把 [`dist/legendarysurvivaloverhaul-1.21.1-2.4.2-kawa-fixed6.jar`](dist/legendarysurvivaloverhaul-1.21.1-2.4.2-kawa-fixed6.jar) 放进 `mods/`；
4. 启动游戏。

- Minecraft 1.21.1 / NeoForge 21.1.x
- 文件名里的 `fixed6` 是内部修订号，模组版本号仍是 `2.4.2`

SHA-256：

```
E9AA69BDC19C111941AAD9F8ECB28E9B3DC632D6E44A71F3D266AF2F5E812585
```

## 仓库结构

```
dist/            编译好的模组 jar
patches/         相对原 jar 的改动源码 / 资源
  java/          重写或修改的 Java 源码
  resources/     新增或修改的资源文件
src-decompiled/  2.4.2 (fixed3) 的完整 JD-Core 反编译源码（527 个 .java，仅供对照，不是官方源码）
tools/           ASM 日志清理工具、字节码对比、校验脚本
docs/            修复说明与对比图
```

## 原理摘要

### 1. 口渴模糊

1.21.1 原版删除了 `assets/minecraft/shaders/post/blobs2.json`，而 LSO 1.20.1 直接复用原版这条链。1.21.1 的 `blur.json` 是 6 趟 box blur，观感与 `blobs2`（max/膨胀）完全不同，不能替代。

本构建把 1.20.1 原版 `blobs2` 链随模组带上：

```
assets/legendarysurvivaloverhaul/shaders/post/blobs2.json   # 模组命名空间
assets/minecraft/shaders/program/blobs2.json
assets/minecraft/shaders/program/blobs2.fsh
assets/minecraft/shaders/program/blobs.vsh
```

program JSON 必须放在 `minecraft` 命名空间：1.21.1 的 `PostChain` 只取 pass name 的 `getPath()`，`EffectInstance` 又用 `ResourceLocation.withDefaultNamespace("shaders/program/…")` 固定命名空间。

### 2. 语言键

```java
player.displayClientMessage(Component.translatable("message.legendarysurvivaloverhaul.thirst.blur_warning"), true);
```

### 3. 脱水击退

1.21.1 的 `LivingEntity#hurt` 会对不在 `minecraft:no_knockback` 标签里的伤害执行 `knockback(0.4, 0, 0)`。原模组移植时只给低温和高温加了标签，漏了脱水。

### 4. 日志清理

`tools/StripLoggerCalls.java` 用 ASM 删除语句级 `LOGGER.info(...)`，删除范围内不含跳转目标；归一化字节码对比确认除这 7 处外没有其他指令变化。

## 构建 / 校验

源码基于反编译的 2.4.2 产物，`patches/` 里是可直接阅读的改动文件；完整重建需要对应版本的 NeoForge 开发环境（`javac --release 21` + 1.21.1 classpath）。

`tools/` 下脚本用于校验成品：

```bash
python tools/verify-fixed6.py <新jar> <fixed5.jar>
python tools/bytecode-diff.py <旧jar> <新classes目录> <类名>
```

## 许可与致谢

- 原模组：[Alex-Hashtag/LegendarySurvivalOverhaul](https://github.com/Alex-Hashtag/LegendarySurvivalOverhaul)（作者 sfiomn）
- 原仓库未声明标准开源协议（GitHub 识别为 `Other / NOASSERTION`）。本仓库仅存放针对个人使用的修改产物；**公开分发前请先确认上游作者的许可**，详见 [`NOTICE.md`](NOTICE.md)。
- 1.20.1 的 `blobs2` 着色器取自 Mojang 官方 1.20.1 客户端，仅用于恢复原版行为。
- 本仓库的补丁代码与脚本按 MIT 提供，不提供任何担保。
