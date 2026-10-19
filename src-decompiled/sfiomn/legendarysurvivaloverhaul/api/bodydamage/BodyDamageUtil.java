/*     */ package sfiomn.legendarysurvivaloverhaul.api.bodydamage;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.world.effect.MobEffect;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import org.apache.commons.lang3.tuple.Pair;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BodyDamageUtil
/*     */ {
/*     */   public static IBodyDamageUtil internal;
/*     */   
/*     */   public static void applyConsumableHealing(Player player, ItemStack itemStack, boolean itemAlreadyConsumed) {
/*  24 */     internal.applyConsumableHealing(player, itemStack, itemAlreadyConsumed);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<Pair<MobEffect, Integer>> getEffects(MalusBodyPartEnum bodyPart, float headHealthRatio) {
/*  37 */     return internal.getEffects(bodyPart, headHealthRatio);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MobEffectInstance getPlayerPassiveLimbRegenerationEffect(Player player) {
/*  47 */     return internal.getPlayerPassiveLimbRegenerationEffect(player);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean hasPlayerFirstAidSuppliesBoostingEffect(Player player) {
/*  57 */     return internal.hasPlayerFirstAidSuppliesBoostingEffect(player);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void applyHealingTimeBodyPart(Player player, BodyPartEnum bodyPart, float healingValue, int healingTime) {
/*  70 */     internal.applyHealingTimeBodyPart(player, bodyPart, healingValue, healingTime);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void healBodyPart(Player player, BodyPartEnum bodyPart, float healingValue) {
/*  82 */     internal.healBodyPart(player, bodyPart, healingValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void hurtBodyPart(Player player, BodyPartEnum bodyPart, float damageValue) {
/*  95 */     internal.hurtBodyPart(player, bodyPart, damageValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void balancedHurtBodyParts(Player player, List<BodyPartEnum> bodyParts, float damageValue) {
/* 108 */     internal.balancedHurtBodyParts(player, bodyParts, damageValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void randomHurtBodyParts(Player player, List<BodyPartEnum> bodyParts, float damageValue) {
/* 121 */     internal.randomHurtBodyParts(player, bodyParts, damageValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float getHealthRatio(Player player, BodyPartEnum bodyPart) {
/* 133 */     return internal.getHealthRatio(player, bodyPart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float getTotalRemainingHealing(Player player, BodyPartEnum bodyPart) {
/* 145 */     return internal.getTotalRemainingHealing(player, bodyPart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float getMaxHealth(Player player, BodyPartEnum bodyPart) {
/* 157 */     return internal.getMaxHealth(player, bodyPart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void updatePlayerBrokenHeartAttribute(Player player) {
/* 167 */     internal.updatePlayerBrokenHeartAttribute(player);
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\bodydamage\BodyDamageUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */