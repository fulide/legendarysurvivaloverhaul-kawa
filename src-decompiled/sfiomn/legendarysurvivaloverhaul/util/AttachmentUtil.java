/*     */ package sfiomn.legendarysurvivaloverhaul.util;
/*     */ 
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.attachments.ModAttachments;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.attachments.bodydamage.BodyDamageAttachment;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.attachments.food.FoodAttachment;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.attachments.health.HealthAttachment;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.attachments.temperature.TemperatureAttachment;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.attachments.temperature.TemperatureItemAttachment;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.attachments.thirst.ThirstAttachment;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.attachments.wetness.WetnessAttachment;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class AttachmentUtil
/*     */ {
/*     */   public static TemperatureAttachment getTempAttachment(Player player) {
/*  33 */     TemperatureAttachment cap = (TemperatureAttachment)player.getData(ModAttachments.TEMPERATURE.get());
/*  34 */     return (cap != null) ? cap : new TemperatureAttachment();
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
/*     */   public static TemperatureItemAttachment getTempItemAttachment(ItemStack itemStack) {
/*  46 */     return new TemperatureItemAttachment(itemStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static HealthAttachment getHealthAttachment(Player player) {
/*  57 */     HealthAttachment cap = (HealthAttachment)player.getData(ModAttachments.HEALTH.get());
/*  58 */     return (cap != null) ? cap : new HealthAttachment();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WetnessAttachment getWetnessAttachment(Player player) {
/*  69 */     WetnessAttachment cap = (WetnessAttachment)player.getData(ModAttachments.WETNESS.get());
/*  70 */     return (cap != null) ? cap : new WetnessAttachment();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ThirstAttachment getThirstAttachment(Player player) {
/*  81 */     ThirstAttachment cap = (ThirstAttachment)player.getData(ModAttachments.THIRST.get());
/*  82 */     return (cap != null) ? cap : new ThirstAttachment();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FoodAttachment getFoodAttachment(Player player) {
/*  93 */     FoodAttachment cap = (FoodAttachment)player.getData(ModAttachments.FOOD.get());
/*  94 */     return (cap != null) ? cap : new FoodAttachment();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BodyDamageAttachment getBodyDamageAttachment(Player player) {
/* 105 */     BodyDamageAttachment cap = (BodyDamageAttachment)player.getData(ModAttachments.BODY_DAMAGE.get());
/* 106 */     return (cap != null) ? cap : new BodyDamageAttachment();
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhau\\util\AttachmentUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */