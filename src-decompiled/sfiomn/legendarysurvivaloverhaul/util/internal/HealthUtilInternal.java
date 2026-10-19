/*     */ package sfiomn.legendarysurvivaloverhaul.util.internal;
/*     */ 
/*     */ import java.util.Objects;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.core.Holder;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.ai.attributes.AttributeInstance;
/*     */ import net.minecraft.world.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.health.IHealthUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.attachments.health.HealthAttachment;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.AttributeRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.AttributeBuilder;
/*     */ 
/*     */ 
/*     */ public class HealthUtilInternal
/*     */   implements IHealthUtil
/*     */ {
/*  23 */   public static final UUID HEALTH_ATTRIBUTE_UUID = UUID.fromString("b158dbba-c193-4301-9dfd-82c4347b2cf4");
/*  24 */   public static final UUID INITIAL_PERMANENT_HEART_ATTRIBUTE_UUID = UUID.fromString("81e7fd2b-90d2-4673-84f6-8bd343fd7c5e");
/*  25 */   public static final UUID INITIAL_BROKEN_HEART_RESILIENCE_ATTRIBUTE_UUID = UUID.fromString("eb13fc3b-cc33-4716-a0b0-9f4cdd7704ba");
/*     */   
/*  27 */   public static final AttributeBuilder HEALTH_ATTRIBUTE = new AttributeBuilder(Attributes.MAX_HEALTH, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "max_health"));
/*  28 */   public static final AttributeBuilder BROKEN_HEART_ATTRIBUTE = new AttributeBuilder((Holder)AttributeRegistry.BROKEN_HEART, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "broken_heart"));
/*  29 */   public static final AttributeBuilder PERMANENT_HEART_ATTRIBUTE = new AttributeBuilder((Holder)AttributeRegistry.PERMANENT_HEART, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "permanent_heart"));
/*  30 */   public static final AttributeBuilder BROKEN_HEART_RESILIENCE_ATTRIBUTE = new AttributeBuilder((Holder)AttributeRegistry.BROKEN_HEART_RESILIENCE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "broken_heart_resilience"));
/*     */ 
/*     */ 
/*     */   
/*     */   public void updatePlayerMaxHealthAttribute(Player player) {
/*  35 */     double maxHealth = getPlayerMaxHealth(player);
/*     */     
/*  37 */     double defaultMaxHealth = getDefaultMaxHealth(player);
/*     */     
/*  39 */     HEALTH_ATTRIBUTE.addModifier(player, HEALTH_ATTRIBUTE_UUID, maxHealth - defaultMaxHealth);
/*  40 */     player.setHealth(Math.min(player.getMaxHealth(), player.getHealth()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double getPlayerMaxHealth(Player player) {
/*  46 */     double maxHealth = getDefaultMaxHealth(player);
/*  47 */     maxHealth += Config.Baked.initialHealth - 20.0D;
/*     */     
/*  49 */     if (Config.Baked.healthOverhaulEnabled) {
/*     */       
/*  51 */       HealthAttachment healthAttachment = AttachmentUtil.getHealthAttachment(player);
/*  52 */       float additionalHealth = healthAttachment.getAdditionalHealth();
/*     */       
/*  54 */       int effectiveBrokenHearts = getEffectiveBrokenHearts(player);
/*  55 */       maxHealth += (additionalHealth - (effectiveBrokenHearts * 2));
/*     */     } 
/*  57 */     return maxHealth;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double getPlayerStableMaxHealth(Player player) {
/*  63 */     double maxHealth = getDefaultMaxHealth(player);
/*  64 */     maxHealth += Config.Baked.initialHealth - 20.0D;
/*     */     
/*  66 */     if (Config.Baked.healthOverhaulEnabled) {
/*     */       
/*  68 */       HealthAttachment healthAttachment = AttachmentUtil.getHealthAttachment(player);
/*  69 */       maxHealth += healthAttachment.getAdditionalHealth();
/*     */     } 
/*  71 */     return maxHealth;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getEffectiveBrokenHearts(Player player) {
/*  77 */     if (!Config.Baked.healthOverhaulEnabled) {
/*  78 */       return 0;
/*     */     }
/*  80 */     double maxHealth = getPlayerStableMaxHealth(player);
/*  81 */     int brokenHearts = (int)player.getAttributeValue((Holder)AttributeRegistry.BROKEN_HEART);
/*  82 */     int resilientHearts = (int)player.getAttributeValue((Holder)AttributeRegistry.BROKEN_HEART_RESILIENCE);
/*  83 */     return Mth.clamp(brokenHearts, 0, (int)Math.ceil(maxHealth / 2.0D) - resilientHearts);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initializeHealthAttributes(Player player) {
/*  89 */     PERMANENT_HEART_ATTRIBUTE.addModifier(player, INITIAL_PERMANENT_HEART_ATTRIBUTE_UUID, (Config.Baked.permanentHearts - 1));
/*  90 */     BROKEN_HEART_RESILIENCE_ATTRIBUTE.addModifier(player, INITIAL_BROKEN_HEART_RESILIENCE_ATTRIBUTE_UUID, (Config.Baked.resilientHeartsWithBrokenHearts - 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float hurtPlayer(Player player, float damageValue) {
/*  96 */     HealthAttachment healthAttachment = AttachmentUtil.getHealthAttachment(player);
/*     */     
/*  98 */     float shieldValue = Math.max(healthAttachment.getShieldHealth(), 0.0F);
/*  99 */     healthAttachment.addShieldHealth(-damageValue);
/*     */     
/* 101 */     return Math.max(damageValue - shieldValue, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void loseHearth(Player player, int amountLost) {
/* 107 */     HealthAttachment healthAttachment = AttachmentUtil.getHealthAttachment(player);
/*     */     
/* 109 */     int minhHearthLimit = (int)player.getAttributeValue((Holder)AttributeRegistry.PERMANENT_HEART);
/*     */     
/* 111 */     int actuallyLostHearts = Math.min((int)Math.ceil(getPlayerStableMaxHealth(player) / 2.0D) - minhHearthLimit, amountLost);
/*     */     
/* 113 */     if (actuallyLostHearts > 0)
/*     */     {
/* 115 */       healthAttachment.setAdditionalHealth(healthAttachment.getAdditionalHealth() - (actuallyLostHearts * 2));
/*     */     }
/* 117 */     updatePlayerMaxHealthAttribute(player);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateBrokenHearts(Player player, UUID attributeUuid, int brokenHearts) {
/* 123 */     BROKEN_HEART_ATTRIBUTE.addModifier(player, attributeUuid, brokenHearts);
/* 124 */     updatePlayerMaxHealthAttribute(player);
/*     */   }
/*     */ 
/*     */   
/*     */   private double getDefaultMaxHealth(Player player) {
/* 129 */     if (player.getAttribute(Attributes.MAX_HEALTH) == null) {
/* 130 */       return 20.0D;
/*     */     }
/* 132 */     double defaultMaxHealth = ((AttributeInstance)Objects.<AttributeInstance>requireNonNull(player.getAttribute(Attributes.MAX_HEALTH))).getBaseValue();
/*     */     
/* 134 */     for (AttributeModifier attributeModifier : ((AttributeInstance)Objects.<AttributeInstance>requireNonNull(player.getAttribute(Attributes.MAX_HEALTH))).getModifiers()) {
/*     */       
/* 136 */       ResourceLocation id = attributeModifier.id();
/* 137 */       if (id != null && id.getNamespace().equals("legendarysurvivaloverhaul") && id.getPath().startsWith("max_health_")) {
/*     */         continue;
/*     */       }
/*     */       
/* 141 */       defaultMaxHealth += attributeModifier.amount();
/*     */     } 
/*     */     
/* 144 */     return defaultMaxHealth;
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhau\\util\internal\HealthUtilInternal.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */