/*     */ package sfiomn.legendarysurvivaloverhaul.client.tooltips;
/*     */ import com.mojang.datafixers.util.Either;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import net.minecraft.ChatFormatting;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.screens.Screen;
/*     */ import net.minecraft.core.Holder;
/*     */ import net.minecraft.core.HolderLookup;
/*     */ import net.minecraft.core.registries.BuiltInRegistries;
/*     */ import net.minecraft.core.registries.Registries;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.network.chat.ComponentContents;
/*     */ import net.minecraft.network.chat.FormattedText;
/*     */ import net.minecraft.network.chat.MutableComponent;
/*     */ import net.minecraft.network.chat.Style;
/*     */ import net.minecraft.network.chat.TextColor;
/*     */ import net.minecraft.network.chat.contents.TranslatableContents;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.world.effect.MobEffect;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.effect.MobEffectUtil;
/*     */ import net.minecraft.world.entity.ai.attributes.Attribute;
/*     */ import net.minecraft.world.inventory.tooltip.TooltipComponent;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.enchantment.Enchantment;
/*     */ import net.neoforged.api.distmarker.Dist;
/*     */ import net.neoforged.bus.api.EventPriority;
/*     */ import net.neoforged.bus.api.SubscribeEvent;
/*     */ import net.neoforged.fml.common.EventBusSubscriber;
/*     */ import net.neoforged.neoforge.client.event.RenderTooltipEvent;
/*     */ import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
/*     */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonHealingConsumable;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonMobEffect;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureConsumable;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonThirstConsumable;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.BodyDamageDataManager;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.TemperatureDataManager;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.ThirstDataManager;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.item.CoatEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemperatureUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.enchantments.ModEnchantments;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.integration.artifacts.ArtifactsUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.integration.beachparty.BeachpartyUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.items.drink.CanteenItem;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.AttributeRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.MobEffectRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.MathUtil;
/*     */ 
/*     */ @EventBusSubscriber(modid = "legendarysurvivaloverhaul", bus = EventBusSubscriber.Bus.GAME, value = {Dist.CLIENT})
/*     */ public class TooltipHandler {
/*     */   @SubscribeEvent(priority = EventPriority.LOWEST)
/*     */   public static void onTooltip(ItemTooltipEvent event) {
/*  58 */     ItemStack stack = event.getItemStack();
/*     */     
/*  60 */     ResourceLocation itemRegistryName = BuiltInRegistries.ITEM.getKey(stack.getItem());
/*     */     
/*  62 */     if (!stack.isEmpty() && itemRegistryName != null) {
/*     */       
/*  64 */       List<Component> tooltips = event.getToolTip();
/*     */       
/*  66 */       for (Component component : tooltips) {
/*     */         
/*  68 */         if (component instanceof MutableComponent) { MutableComponent mutableComponent = (MutableComponent)component;
/*     */           
/*  70 */           if (componentHasOneOfKeys(component, new String[] { ((Attribute)AttributeRegistry.HEATING_TEMPERATURE
/*  71 */                 .get()).getDescriptionId(), ((Attribute)AttributeRegistry.HEAT_RESISTANCE
/*  72 */                 .get()).getDescriptionId() }))
/*  73 */             mutableComponent.withStyle(Style.EMPTY.withColor(TextColor.fromRgb(16420407))); 
/*  74 */           if (componentHasOneOfKeys(component, new String[] { ((Attribute)AttributeRegistry.COOLING_TEMPERATURE
/*  75 */                 .get()).getDescriptionId(), ((Attribute)AttributeRegistry.COLD_RESISTANCE
/*  76 */                 .get()).getDescriptionId() }))
/*  77 */             mutableComponent.withStyle(Style.EMPTY.withColor(TextColor.fromRgb(6466303))); 
/*  78 */           if (componentHasOneOfKeys(component, new String[] { ((Attribute)AttributeRegistry.THERMAL_RESISTANCE.get()).getDescriptionId() })) {
/*  79 */             mutableComponent.withStyle(Style.EMPTY.withColor(TextColor.fromRgb(10040319)));
/*     */           } }
/*     */       
/*     */       } 
/*  83 */       if (Config.Baked.temperatureEnabled) {
/*     */ 
/*     */         
/*  86 */         if (stack.getItem() instanceof net.minecraft.world.item.ArmorItem)
/*     */         {
/*  88 */           addCoatTemperatureOnArmorText(stack, tooltips);
/*     */         }
/*     */         
/*  91 */         addFoodEffectText(stack, tooltips);
/*     */       } 
/*     */       
/*  94 */       if (Config.Baked.localizedBodyDamageEnabled) {
/*  95 */         addHealingText(stack, tooltips);
/*     */       }
/*  97 */       if (LegendarySurvivalOverhaul.beachpartyLoaded) {
/*  98 */         addShadeText(stack, tooltips);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onRenderTooltip(RenderTooltipEvent.GatherComponents event) {
/* 106 */     if (event.isCanceled()) {
/*     */       return;
/*     */     }
/* 109 */     Minecraft mc = Minecraft.getInstance();
/* 110 */     Screen gui = mc.screen;
/* 111 */     if (gui == null) {
/*     */       return;
/*     */     }
/* 114 */     if (Config.Baked.thirstEnabled && Config.Baked.showHydrationTooltip) {
/* 115 */       addHydrationTooltip(event.getItemStack(), event.getTooltipElements());
/*     */     }
/*     */   }
/*     */   
/*     */   private static boolean componentHasOneOfKeys(Component component, String... keys) {
/* 120 */     if (component != null) { ComponentContents componentContents = component.getContents(); if (componentContents instanceof TranslatableContents) { TranslatableContents translatableContents = (TranslatableContents)componentContents; if (translatableContents
/* 121 */           .getArgs() != null)
/*     */         {
/* 123 */           return Arrays.<Object>stream(translatableContents.getArgs()).anyMatch(s -> {
/*     */                 if (s instanceof MutableComponent) {
/*     */                   MutableComponent mutableComponent = (MutableComponent)s; ComponentContents patt0$temp = mutableComponent.getContents(); if (patt0$temp instanceof TranslatableContents) {
/*     */                     TranslatableContents translatableContents1 = (TranslatableContents)patt0$temp; for (String key : keys) {
/*     */                       if (translatableContents1.getKey().equals(key))
/*     */                         return true; 
/*     */                     } 
/*     */                     return false;
/*     */                   } 
/*     */                 } 
/*     */                 return false;
/*     */               }); }  }
/*     */        }
/*     */     
/* 137 */     return false;
/*     */   }
/*     */   
/*     */   private static void addCoatTemperatureOnArmorText(ItemStack stack, List<Component> tooltips) {
/*     */     MutableComponent mutableComponent2;
/* 142 */     String coatId = TemperatureUtil.getArmorCoatTag(stack);
/* 143 */     CoatEnum coat = CoatEnum.getFromId(coatId);
/*     */ 
/*     */ 
/*     */     
/* 147 */     if (coat != null) {
/*     */       
/* 149 */       mutableComponent2 = Component.translatable("tooltip.legendarysurvivaloverhaul.armor_coat." + coatId);
/*     */     } else {
/*     */       return;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 157 */     MutableComponent mutableComponent1 = Component.literal("").withStyle(ChatFormatting.BLUE).append((Component)mutableComponent2);
/*     */     
/* 159 */     tooltips.add(mutableComponent1);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void addFoodEffectText(ItemStack stack, List<Component> tooltips) {
/* 164 */     ResourceLocation itemRegistryName = BuiltInRegistries.ITEM.getKey(stack.getItem());
/* 165 */     List<JsonTemperatureConsumable> jtcs = TemperatureDataManager.getConsumable(itemRegistryName);
/*     */     
/* 167 */     if (jtcs != null)
/*     */     {
/* 169 */       for (JsonTemperatureConsumable jtc : jtcs) {
/*     */         
/* 171 */         MobEffectInstance effectInstance = new MobEffectInstance(Holder.direct(jtc.getEffect()), jtc.duration, Math.abs(jtc.temperatureLevel));
/* 172 */         MutableComponent mutableComponent = Component.translatable(effectInstance.getDescriptionId());
/*     */         
/* 174 */         if (Math.abs(jtc.temperatureLevel) > 1)
/*     */         {
/* 176 */           mutableComponent = Component.translatable("potion.withAmplifier", new Object[] { mutableComponent, Component.translatable("potion.potency." + Math.abs(jtc.temperatureLevel) - 1) });
/*     */         }
/*     */         
/* 179 */         if (jtc.duration > 20)
/*     */         {
/* 181 */           mutableComponent = Component.translatable("potion.withDuration", new Object[] { mutableComponent, MobEffectUtil.formatDuration(effectInstance, 1.0F, 20.0F) });
/*     */         }
/*     */         
/* 184 */         if (jtc.getEffect() == MobEffectRegistry.COLD_FOOD.get() || jtc.getEffect() == MobEffectRegistry.COLD_DRINK.get()) {
/* 185 */           tooltips.add(mutableComponent.withStyle(Style.EMPTY.withColor(TextColor.fromRgb(6466303))));
/*     */         }
/* 187 */         if (jtc.getEffect() == MobEffectRegistry.HOT_FOOD.get()) {
/* 188 */           tooltips.add(mutableComponent.withStyle(Style.EMPTY.withColor(TextColor.fromRgb(16420407))));
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static void addHealingText(ItemStack stack, List<Component> tooltips) {
/* 196 */     ResourceLocation itemRegistryName = BuiltInRegistries.ITEM.getKey(stack.getItem());
/* 197 */     JsonHealingConsumable jsonConsumableHeal = BodyDamageDataManager.getHealingItem(itemRegistryName);
/*     */     
/* 199 */     if (jsonConsumableHeal != null) {
/*     */       
/* 201 */       if (jsonConsumableHeal.healingCharges > 0) {
/*     */         
/* 203 */         tooltips.add(Component.translatable("tooltip.legendarysurvivaloverhaul.body_heal_item.body_part", new Object[] { Integer.valueOf(jsonConsumableHeal.healingCharges) }).withStyle(ChatFormatting.BLUE));
/* 204 */       } else if (jsonConsumableHeal.healingCharges == 0) {
/*     */         
/* 206 */         tooltips.add(Component.translatable("tooltip.legendarysurvivaloverhaul.body_heal_item.whole_body").withStyle(ChatFormatting.BLUE));
/*     */       } 
/* 208 */       tooltips.add(
/* 209 */           Component.translatable("tooltip.legendarysurvivaloverhaul.body_heal_item.healing_value", new Object[] {
/* 210 */               Float.valueOf(jsonConsumableHeal.healingValue), Float.valueOf(MathUtil.round(jsonConsumableHeal.healingTime / 20.0F, 1))
/* 211 */             }).withStyle(ChatFormatting.BLUE));
/*     */       
/* 213 */       MutableComponent mutableComponent = Component.translatable(((MobEffect)MobEffectRegistry.RECOVERY.get()).getDescriptionId());
/*     */       
/* 215 */       if (jsonConsumableHeal.recoveryEffectDuration > 0) {
/*     */         
/* 217 */         if (jsonConsumableHeal.recoveryEffectAmplifier > 0)
/*     */         {
/* 219 */           mutableComponent = Component.translatable("potion.withAmplifier", new Object[] { mutableComponent, Component.translatable("potion.potency." + jsonConsumableHeal.recoveryEffectAmplifier) });
/*     */         }
/*     */         
/* 222 */         MobEffectInstance mei = new MobEffectInstance((Holder)MobEffectRegistry.RECOVERY, jsonConsumableHeal.recoveryEffectDuration, jsonConsumableHeal.recoveryEffectAmplifier);
/* 223 */         mutableComponent = Component.translatable("potion.withDuration", new Object[] { mutableComponent, MobEffectUtil.formatDuration(mei, 1.0F, 20.0F) });
/*     */         
/* 225 */         tooltips.add(mutableComponent.withStyle(Style.EMPTY.withColor(ChatFormatting.BLUE)));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void addShadeText(ItemStack stack, List<Component> tooltips) {
/* 233 */     ResourceLocation itemRegistryName = BuiltInRegistries.ITEM.getKey(stack.getItem());
/*     */     
/* 235 */     if (itemRegistryName != null && (BeachpartyUtil.canProvideShade(itemRegistryName) || ArtifactsUtil.canProvideShade(itemRegistryName)))
/*     */     {
/* 237 */       tooltips.add(
/* 238 */           Component.translatable("tooltip.legendarysurvivaloverhaul.provides_shade")
/* 239 */           .withStyle(ChatFormatting.WHITE));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void addHydrationTooltip(ItemStack stack, List<Either<FormattedText, TooltipComponent>> tooltips) {
/* 246 */     JsonThirstConsumable jsonThirstConsumable = ThirstDataManager.getConsumable(stack);
/*     */     
/* 248 */     HydrationTooltipComponent hydrationTooltipComponent = null;
/* 249 */     List<MutableComponent> hydrationEffectComponents = new ArrayList<>();
/*     */     
/* 251 */     if (jsonThirstConsumable != null) {
/*     */       
/* 253 */       int hydration = jsonThirstConsumable.hydration;
/* 254 */       float saturation = jsonThirstConsumable.saturation;
/*     */ 
/*     */       
/* 257 */       if (stack.getItem() instanceof CanteenItem && CanteenItem.canDrink(stack)) {
/*     */         
/* 259 */         Minecraft mc = Minecraft.getInstance();
/* 260 */         if (mc.player != null && mc.player.level() != null) {
/*     */           
/*     */           try {
/*     */             
/* 264 */             HolderLookup.RegistryLookup<Enchantment> enchantmentRegistry = mc.player.level().registryAccess().lookupOrThrow(Registries.ENCHANTMENT);
/* 265 */             Optional<Holder.Reference<Enchantment>> refreshingEnchOpt = enchantmentRegistry.get(ModEnchantments.REFRESHING);
/* 266 */             if (refreshingEnchOpt.isPresent()) {
/* 267 */               int refreshingLevel = stack.getEnchantmentLevel((Holder)refreshingEnchOpt.get());
/* 268 */               if (refreshingLevel > 0) {
/*     */                 
/* 270 */                 hydration += refreshingLevel;
/* 271 */                 saturation += Math.max(0, refreshingLevel - 1);
/*     */               } 
/*     */             } 
/* 274 */           } catch (IllegalStateException illegalStateException) {}
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 280 */       hydrationTooltipComponent = new HydrationTooltipComponent(hydration, saturation);
/* 281 */       for (JsonMobEffect effect : jsonThirstConsumable.effects) {
/*     */         
/* 283 */         if (effect.chance > 0.0F && effect.duration > 0 && !effect.name.isEmpty())
/*     */         {
/* 285 */           hydrationEffectComponents.add(getHydrationEffectTooltip(effect.chance, effect.name, effect.amplifier, effect.duration));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 290 */     if (hydrationTooltipComponent != null)
/*     */     {
/* 292 */       tooltips.add(Either.right(hydrationTooltipComponent));
/*     */     }
/*     */     
/* 295 */     for (MutableComponent hydrationEffectComponent : hydrationEffectComponents) {
/*     */       
/* 297 */       if (hydrationEffectComponent != null) {
/* 298 */         tooltips.add(Either.left(hydrationEffectComponent));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private static MutableComponent getHydrationEffectTooltip(double effectChance, String effectName, int amplifier, int duration) {
/* 304 */     MobEffect effect = null;
/* 305 */     if (effectName != null && !effectName.isEmpty() && effectChance > 0.0D) {
/* 306 */       effect = (MobEffect)BuiltInRegistries.MOB_EFFECT.get(ResourceLocation.parse(effectName));
/*     */     }
/* 308 */     if (effect == null) {
/* 309 */       return null;
/*     */     }
/* 311 */     MobEffectInstance effectInstance = new MobEffectInstance(Holder.direct(effect), duration, amplifier, false, true);
/* 312 */     MutableComponent mutableComponent = Component.translatable(effectInstance.getDescriptionId());
/*     */     
/* 314 */     if (effectInstance.getAmplifier() > 1)
/*     */     {
/* 316 */       mutableComponent = Component.translatable("potion.withAmplifier", new Object[] { mutableComponent, Component.translatable("potion.potency." + effectInstance.getAmplifier()) });
/*     */     }
/*     */     
/* 319 */     if (effectInstance.getDuration() > 20)
/*     */     {
/* 321 */       mutableComponent = Component.translatable("potion.withDuration", new Object[] { mutableComponent, MobEffectUtil.formatDuration(effectInstance, 1.0F, 20.0F) });
/*     */     }
/*     */     
/* 324 */     if (effectChance < 1.0D) {
/* 325 */       mutableComponent = Component.translatable("tooltip.legendarysurvivaloverhaul.potion_with_effectChance", new Object[] { Integer.valueOf((int)(effectChance * 100.0D)), mutableComponent });
/*     */     }
/* 327 */     return mutableComponent.withStyle(Style.EMPTY.withColor(ChatFormatting.BLUE));
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\client\tooltips\TooltipHandler.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */