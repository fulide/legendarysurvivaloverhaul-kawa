/*     */ package sfiomn.legendarysurvivaloverhaul.util.internal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.core.Holder;
/*     */ import net.minecraft.core.registries.BuiltInRegistries;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.effect.MobEffect;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import org.apache.commons.lang3.tuple.Pair;
/*     */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.BodyPartEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.DamageDistributionEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.IBodyDamageAttachment;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.IBodyDamageUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.MalusBodyPartEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonHealingConsumable;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.ClientHooks;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.attachments.bodydamage.BodyDamageAttachment;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.AttributeRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.AttributeBuilder;
/*     */ 
/*     */ public class BodyDamageUtilInternal implements IBodyDamageUtil {
/*  33 */   public static final UUID BROKEN_HEART_ATTRIBUTE_UUID = UUID.fromString("2e3cede5-3c18-45c2-8a46-31b89fb9c027");
/*  34 */   public static final AttributeBuilder BODY_RESISTANCE = new AttributeBuilder((Holder)AttributeRegistry.BODY_RESISTANCE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "body_resistance"));
/*  35 */   public static final AttributeBuilder HEAD_RESISTANCE = new AttributeBuilder((Holder)AttributeRegistry.HEAD_RESISTANCE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "head_temperature"));
/*  36 */   public static final AttributeBuilder CHEST_RESISTANCE = new AttributeBuilder((Holder)AttributeRegistry.CHEST_RESISTANCE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "chest_temperature"));
/*  37 */   public static final AttributeBuilder RIGHT_ARM_RESISTANCE = new AttributeBuilder((Holder)AttributeRegistry.RIGHT_ARM_RESISTANCE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "right_arm_resistance"));
/*  38 */   public static final AttributeBuilder LEFT_ARM_RESISTANCE = new AttributeBuilder((Holder)AttributeRegistry.LEFT_ARM_RESISTANCE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "left_arm_resistance"));
/*  39 */   public static final AttributeBuilder LEGS_RESISTANCE = new AttributeBuilder((Holder)AttributeRegistry.LEGS_RESISTANCE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "legs_resistance"));
/*  40 */   public static final AttributeBuilder FEET_RESISTANCE = new AttributeBuilder((Holder)AttributeRegistry.FEET_RESISTANCE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "feet_resistance"));
/*  41 */   public static final Map<BodyPartEnum, AttributeBuilder> bodyPartResistanceAttribute = new HashMap<>();
/*  42 */   public static final Map<EquipmentSlot, UUID> equipmentSlotBodyResistanceUuid = new HashMap<>();
/*  43 */   private static final List<Holder<MobEffect>> firstAidSuppliesBoostingEffects = new ArrayList<>();
/*  44 */   private static final List<Holder<MobEffect>> passiveLimbRegenerationEffects = new ArrayList<>();
/*  45 */   private static final Map<MalusBodyPartEnum, Map<Float, Pair<MobEffect, Integer>>> bodyPartMalusEffects = new HashMap<>();
/*     */ 
/*     */   
/*     */   static {
/*  49 */     bodyPartResistanceAttribute.put(BodyPartEnum.HEAD, HEAD_RESISTANCE);
/*  50 */     bodyPartResistanceAttribute.put(BodyPartEnum.CHEST, CHEST_RESISTANCE);
/*  51 */     bodyPartResistanceAttribute.put(BodyPartEnum.RIGHT_ARM, RIGHT_ARM_RESISTANCE);
/*  52 */     bodyPartResistanceAttribute.put(BodyPartEnum.LEFT_ARM, LEFT_ARM_RESISTANCE);
/*  53 */     bodyPartResistanceAttribute.put(BodyPartEnum.RIGHT_LEG, LEGS_RESISTANCE);
/*  54 */     bodyPartResistanceAttribute.put(BodyPartEnum.LEFT_LEG, LEGS_RESISTANCE);
/*  55 */     bodyPartResistanceAttribute.put(BodyPartEnum.RIGHT_FOOT, FEET_RESISTANCE);
/*  56 */     bodyPartResistanceAttribute.put(BodyPartEnum.LEFT_FOOT, FEET_RESISTANCE);
/*     */     
/*  58 */     equipmentSlotBodyResistanceUuid.put(EquipmentSlot.HEAD, UUID.fromString("e1d9eda1-f904-4ddd-8a9f-720fa592117e"));
/*  59 */     equipmentSlotBodyResistanceUuid.put(EquipmentSlot.CHEST, UUID.fromString("0b743835-b4aa-4c08-aa13-f3646730a749"));
/*  60 */     equipmentSlotBodyResistanceUuid.put(EquipmentSlot.MAINHAND, UUID.fromString("c18151f4-cb03-4df9-994d-e4decbb60b6e"));
/*  61 */     equipmentSlotBodyResistanceUuid.put(EquipmentSlot.OFFHAND, UUID.fromString("0fba64c7-8863-4a17-9458-7bbce1518bf0"));
/*  62 */     equipmentSlotBodyResistanceUuid.put(EquipmentSlot.LEGS, UUID.fromString("e024cc3d-cd24-4bcf-b7a8-f2272e44ac2d"));
/*  63 */     equipmentSlotBodyResistanceUuid.put(EquipmentSlot.FEET, UUID.fromString("53523212-2ebc-4f6b-9044-7f9a1fa96852"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void initMalusConfig() {
/*  72 */     for (MalusBodyPartEnum malus : MalusBodyPartEnum.values()) {
/*     */       
/*  74 */       Map<Float, Pair<MobEffect, Integer>> malusEffects = new HashMap<>();
/*  75 */       if (malus.effects.size() != malus.amplifiers.size() || malus.effects.size() != malus.thresholds.size())
/*     */       {
/*  77 */         LegendarySurvivalOverhaul.LOGGER.debug("{} effects, amplifiers and thresholds elements number doesn't match. The last elements won't be used.", malus.name());
/*     */       }
/*     */       
/*  80 */       for (int i = 0; i < malus.effects.size(); i++) {
/*     */ 
/*     */ 
/*     */         
/*  84 */         MobEffect malusEffect = BuiltInRegistries.MOB_EFFECT.getOptional(ResourceLocation.parse(malus.effects.get(i))).orElse(null);
/*     */ 
/*     */         
/*  87 */         if (malusEffect == null) {
/*     */           
/*  89 */           LegendarySurvivalOverhaul.LOGGER.debug("Unknown effect {} for {}", malus.effects.get(i), malus.name());
/*     */         } else {
/*     */           int malusAmplifier;
/*     */           float malusThreshold;
/*     */           try {
/*  94 */             malusAmplifier = Math.abs(((Integer)malus.amplifiers.get(i)).intValue());
/*  95 */           } catch (IndexOutOfBoundsException e) {
/*     */             
/*  97 */             LegendarySurvivalOverhaul.LOGGER.debug("No amplifier defined for effect {} in {}", malus.effects.get(i), malus.name());
/*     */           } 
/*     */ 
/*     */           
/*     */           try {
/* 102 */             malusThreshold = (float)Mth.clamp(((Double)malus.thresholds.get(i)).doubleValue(), 0.0D, 1.0D);
/* 103 */           } catch (IndexOutOfBoundsException e) {
/*     */             
/* 105 */             LegendarySurvivalOverhaul.LOGGER.debug("No threshold defined for effect {} in {}", malus.thresholds.get(i), malus.name());
/*     */           } 
/*     */           
/* 108 */           malusEffects.put(Float.valueOf(malusThreshold), Pair.of(malusEffect, Integer.valueOf(malusAmplifier)));
/*     */         } 
/* 110 */       }  bodyPartMalusEffects.put(malus, malusEffects);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void initLimbEffects() {
/* 116 */     for (String effectRegistryName : Config.Baked.firstAidSuppliesBoostedOnEffects) {
/*     */       
/* 118 */       if (ResourceLocation.tryParse(effectRegistryName) == null) {
/* 119 */         LegendarySurvivalOverhaul.LOGGER.info("First Aid Supplies boosting effect : not valid effect registry name : {}", effectRegistryName);
/*     */       }
/*     */ 
/*     */       
/* 123 */       MobEffect boostingEffect = BuiltInRegistries.MOB_EFFECT.getOptional(ResourceLocation.parse(effectRegistryName)).orElse(null);
/* 124 */       if (boostingEffect == null) {
/*     */         
/* 126 */         LegendarySurvivalOverhaul.LOGGER.info("Unknown effect {}", effectRegistryName);
/*     */         continue;
/*     */       } 
/* 129 */       firstAidSuppliesBoostingEffects.add(Holder.direct(boostingEffect));
/*     */     } 
/*     */     
/* 132 */     for (String effectRegistryName : Config.Baked.passiveLimbRegenerationEffects) {
/*     */       
/* 134 */       if (ResourceLocation.tryParse(effectRegistryName) == null) {
/* 135 */         LegendarySurvivalOverhaul.LOGGER.info("Limb Regeneration Effect : not valid effect registry name : {}", effectRegistryName);
/*     */       }
/*     */ 
/*     */       
/* 139 */       MobEffect regenerationEffect = BuiltInRegistries.MOB_EFFECT.getOptional(ResourceLocation.parse(effectRegistryName)).orElse(null);
/* 140 */       if (regenerationEffect == null) {
/*     */         
/* 142 */         LegendarySurvivalOverhaul.LOGGER.info("Unknown effect {}", effectRegistryName);
/*     */         continue;
/*     */       } 
/* 145 */       passiveLimbRegenerationEffects.add(Holder.direct(regenerationEffect));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void applyConsumableHealing(Player player, ItemStack itemStack, boolean itemAlreadyConsumed) {
/* 152 */     ResourceLocation itemRegistryName = BuiltInRegistries.ITEM.getKey(itemStack.getItem());
/* 153 */     JsonHealingConsumable jsonConsumableHeal = BodyDamageDataManager.getHealingItem(itemRegistryName);
/*     */     
/* 155 */     if (jsonConsumableHeal == null) {
/*     */       return;
/*     */     }
/* 158 */     if (Config.Baked.localizedBodyDamageEnabled && jsonConsumableHeal.healingCharges > 0) {
/*     */       
/* 160 */       if ((player.level()).isClientSide && (Minecraft.getInstance()).screen == null) {
/* 161 */         ClientHooks.openBodyHealthScreen(player, player.getUsedItemHand(), itemAlreadyConsumed, jsonConsumableHeal.healingCharges, jsonConsumableHeal.healingValue, jsonConsumableHeal.healingTime);
/*     */       }
/*     */     } else {
/*     */       
/* 165 */       if (Config.Baked.localizedBodyDamageEnabled)
/*     */       {
/* 167 */         for (BodyPartEnum bodyPart : BodyPartEnum.values())
/*     */         {
/* 169 */           BodyDamageUtil.applyHealingTimeBodyPart(player, bodyPart, jsonConsumableHeal.healingValue, jsonConsumableHeal.healingTime);
/*     */         }
/*     */       }
/*     */       
/* 173 */       if (jsonConsumableHeal.recoveryEffectDuration > 0)
/*     */       {
/* 175 */         player.addEffect(new MobEffectInstance((Holder)MobEffectRegistry.RECOVERY, jsonConsumableHeal.recoveryEffectDuration, jsonConsumableHeal.recoveryEffectAmplifier, false, false, true));
/*     */       }
/*     */       
/* 178 */       player.level().playSound(null, (Entity)player, (SoundEvent)SoundRegistry.HEAL_BODY_PART.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
/* 179 */       if (!itemAlreadyConsumed) {
/* 180 */         itemStack.shrink(1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public MobEffectInstance getPlayerPassiveLimbRegenerationEffect(Player player) {
/* 187 */     MobEffectInstance passiveLimbRegenerationEffect = null;
/* 188 */     for (Holder<MobEffect> effect : passiveLimbRegenerationEffects) {
/*     */       
/* 190 */       MobEffectInstance regenerationEffect = player.getEffect(effect);
/* 191 */       if (regenerationEffect != null)
/*     */       {
/* 193 */         if (passiveLimbRegenerationEffect == null || regenerationEffect
/* 194 */           .getAmplifier() > passiveLimbRegenerationEffect.getAmplifier())
/*     */         {
/* 196 */           passiveLimbRegenerationEffect = regenerationEffect;
/*     */         }
/*     */       }
/*     */     } 
/* 200 */     return passiveLimbRegenerationEffect;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasPlayerFirstAidSuppliesBoostingEffect(Player player) {
/* 206 */     for (Holder<MobEffect> effect : firstAidSuppliesBoostingEffects) {
/*     */       
/* 208 */       if (player.hasEffect(effect))
/* 209 */         return true; 
/*     */     } 
/* 211 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Pair<MobEffect, Integer>> getEffects(MalusBodyPartEnum bodyPart, float healthRatio) {
/* 217 */     List<Pair<MobEffect, Integer>> effects = new ArrayList<>();
/* 218 */     if (bodyPart == null) {
/* 219 */       return effects;
/*     */     }
/* 221 */     for (Map.Entry<Float, Pair<MobEffect, Integer>> effect : (Iterable<Map.Entry<Float, Pair<MobEffect, Integer>>>)((Map)bodyPartMalusEffects.get(bodyPart)).entrySet()) {
/*     */       
/* 223 */       if (healthRatio <= ((Float)effect.getKey()).floatValue())
/*     */       {
/* 225 */         effects.add(effect.getValue());
/*     */       }
/*     */     } 
/* 228 */     return effects;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void applyHealingTimeBodyPart(Player player, BodyPartEnum bodyPartEnum, float healingValue, int healingTime) {
/* 235 */     if (!Config.Baked.localizedBodyDamageEnabled || bodyPartEnum == null) {
/*     */       return;
/*     */     }
/* 238 */     BodyDamageAttachment bodyDamageAttachment = AttachmentUtil.getBodyDamageAttachment(player);
/*     */     
/* 240 */     int remainingHealingTicks = bodyDamageAttachment.getRemainingHealingTicks(bodyPartEnum);
/* 241 */     float healingPerTicks = bodyDamageAttachment.getHealingPerTicks(bodyPartEnum);
/*     */     
/* 243 */     float healingValuePerTick = (healingValue + remainingHealingTicks * healingPerTicks) / (healingTime + remainingHealingTicks);
/*     */     
/* 245 */     bodyDamageAttachment.applyHealingTime(bodyPartEnum, healingTime + remainingHealingTicks, healingValuePerTick);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void healBodyPart(Player player, BodyPartEnum bodyPartEnum, float healingValue) {
/* 252 */     if (!Config.Baked.localizedBodyDamageEnabled) {
/*     */       return;
/*     */     }
/* 255 */     BodyDamageAttachment bodyDamageAttachment = AttachmentUtil.getBodyDamageAttachment(player);
/*     */     
/* 257 */     bodyDamageAttachment.heal(bodyPartEnum, healingValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hurtBodyPart(Player player, BodyPartEnum bodyPartEnum, float damageValue) {
/* 264 */     if (!Config.Baked.localizedBodyDamageEnabled || bodyPartEnum == null) {
/*     */       return;
/*     */     }
/* 267 */     BodyDamageAttachment bodyDamageAttachment = AttachmentUtil.getBodyDamageAttachment(player);
/* 268 */     double bodyResistance = BODY_RESISTANCE.getAttribute(player).getValue();
/* 269 */     double limbResistance = ((AttributeBuilder)bodyPartResistanceAttribute.get(bodyPartEnum)).getAttribute(player).getValue();
/*     */     
/* 271 */     damageValue *= (float)(1.0D - bodyResistance - limbResistance);
/*     */     
/* 273 */     float remainingDamage = Math.max(0.0F, damageValue - bodyDamageAttachment.getBodyPartMaxHealth(bodyPartEnum) - bodyDamageAttachment.getBodyPartDamage(bodyPartEnum));
/*     */     
/* 275 */     bodyDamageAttachment.hurt(bodyPartEnum, damageValue - remainingDamage);
/*     */     
/* 277 */     if (remainingDamage > 0.0F && !bodyPartEnum.getNeighbours().isEmpty()) {
/*     */       
/* 279 */       remainingDamage /= (float)(1.0D - bodyResistance - limbResistance);
/* 280 */       List<BodyPartEnum> damageableBodyParts = (List<BodyPartEnum>)bodyPartEnum.getNeighbours().stream().filter(bodyPart -> (capability.getBodyPartHealthRatio(bodyPart) > 0.0F)).collect(Collectors.toList());
/* 281 */       if (!damageableBodyParts.isEmpty()) {
/*     */         
/* 283 */         BodyPartEnum bodyPart = DamageDistributionEnum.ONE_OF.getBodyParts(player, damageableBodyParts).get(0);
/* 284 */         limbResistance = ((AttributeBuilder)bodyPartResistanceAttribute.get(bodyPart)).getAttribute(player).getValue();
/* 285 */         bodyDamageAttachment.hurt(bodyPart, remainingDamage * (float)(1.0D - bodyResistance - limbResistance));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void balancedHurtBodyParts(Player player, List<BodyPartEnum> bodyParts, float damageValue) {
/* 294 */     if (!Config.Baked.localizedBodyDamageEnabled || bodyParts.isEmpty()) {
/*     */       return;
/*     */     }
/* 297 */     Collections.shuffle(bodyParts);
/*     */     
/* 299 */     for (BodyPartEnum bodyPart : bodyParts)
/*     */     {
/* 301 */       hurtBodyPart(player, bodyPart, damageValue / bodyParts.size());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void randomHurtBodyParts(Player player, List<BodyPartEnum> bodyParts, float damageValue) {
/* 308 */     if (!Config.Baked.localizedBodyDamageEnabled || bodyParts.isEmpty())
/*     */       return; 
/* 310 */     int bodyPartIndex = (bodyParts.size() == 1) ? 0 : player.getRandom().nextInt(bodyParts.size() - 1);
/*     */     
/* 312 */     hurtBodyPart(player, bodyParts.get(bodyPartIndex), damageValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getHealthRatio(Player player, BodyPartEnum bodyPartEnum) {
/* 318 */     if (!Config.Baked.localizedBodyDamageEnabled || bodyPartEnum == null) {
/* 319 */       return 0.0F;
/*     */     }
/* 321 */     BodyDamageAttachment bodyDamageAttachment = AttachmentUtil.getBodyDamageAttachment(player);
/*     */     
/* 323 */     return bodyDamageAttachment.getBodyPartHealthRatio(bodyPartEnum);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getTotalRemainingHealing(Player player, BodyPartEnum bodyPartEnum) {
/* 329 */     if (!Config.Baked.localizedBodyDamageEnabled || bodyPartEnum == null) {
/* 330 */       return 0.0F;
/*     */     }
/* 332 */     BodyDamageAttachment bodyDamageAttachment = AttachmentUtil.getBodyDamageAttachment(player);
/*     */     
/* 334 */     return bodyDamageAttachment.getRemainingHealingTicks(bodyPartEnum) * bodyDamageAttachment.getHealingPerTicks(bodyPartEnum);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getMaxHealth(Player player, BodyPartEnum bodyPartEnum) {
/* 340 */     if (!Config.Baked.localizedBodyDamageEnabled || bodyPartEnum == null) {
/* 341 */       return 0.0F;
/*     */     }
/* 343 */     BodyDamageAttachment bodyDamageAttachment = AttachmentUtil.getBodyDamageAttachment(player);
/*     */     
/* 345 */     return bodyDamageAttachment.getBodyPartMaxHealth(bodyPartEnum);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updatePlayerBrokenHeartAttribute(Player player) {
/* 351 */     int expectedBrokenHearts = 0;
/* 352 */     if (Config.Baked.localizedBodyDamageEnabled && Config.Baked.healthOverhaulEnabled) {
/*     */       
/* 354 */       BodyDamageAttachment bodyDamageAttachment = AttachmentUtil.getBodyDamageAttachment(player);
/*     */       
/* 356 */       expectedBrokenHearts = bodyDamageAttachment.getExpectedBrokenHearts();
/*     */     } 
/*     */     
/* 359 */     HealthUtil.updateBrokenHearts(player, BROKEN_HEART_ATTRIBUTE_UUID, expectedBrokenHearts);
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhau\\util\internal\BodyDamageUtilInternal.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */