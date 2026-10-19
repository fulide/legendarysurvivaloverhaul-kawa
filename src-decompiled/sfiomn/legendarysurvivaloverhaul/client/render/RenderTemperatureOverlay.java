/*     */ package sfiomn.legendarysurvivaloverhaul.client.render;
/*     */ 
/*     */ import com.mojang.blaze3d.systems.RenderSystem;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiGraphics;
/*     */ import net.minecraft.client.player.LocalPlayer;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.neoforged.api.distmarker.Dist;
/*     */ import net.neoforged.api.distmarker.OnlyIn;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemperatureEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.attachments.temperature.TemperatureAttachment;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.effects.FrostbiteEffect;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.effects.HeatStrokeEffect;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.SoundRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.MathUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.RenderUtil;
/*     */ 
/*     */ @OnlyIn(Dist.CLIENT)
/*     */ public class RenderTemperatureOverlay {
/*  25 */   private static final ResourceLocation FROSTBITE_EFFECT = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "textures/gui/freeze_effect.png");
/*  26 */   private static final ResourceLocation HEAT_STROKE_EFFECT = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "textures/gui/heat_effect.png");
/*  27 */   private static TemperatureAttachment TEMPERATURE_CAP = null;
/*  28 */   private static ResourceLocation temperatureEffect = null;
/*  29 */   private static float fadeLevel = 0.0F;
/*     */   
/*     */   private static boolean triggerTemperatureSoundEffect;
/*     */   
/*     */   public static void render(Gui gui, GuiGraphics guiGraphics, float partialTicks, int width, int height) {
/*  34 */     if (Config.Baked.temperatureEnabled && temperatureEffect != null) {
/*     */       
/*  36 */       LocalPlayer localPlayer = (Minecraft.getInstance()).player;
/*  37 */       if (localPlayer != null && temperatureEffect != null && !localPlayer.isCreative() && !localPlayer.isSpectator()) {
/*     */         
/*  39 */         RenderSystem.enableBlend();
/*  40 */         RenderSystem.defaultBlendFunc();
/*  41 */         RenderUtil.renderTextureOverlay(guiGraphics, temperatureEffect, width, height, fadeLevel);
/*  42 */         RenderSystem.disableBlend();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void updateTemperatureEffect(Player player) {
/*  49 */     if (player != null && player.isAlive()) {
/*     */       float targetFadeLevel;
/*     */       
/*  52 */       if (TEMPERATURE_CAP == null || player.tickCount % 20 == 0) {
/*  53 */         TEMPERATURE_CAP = AttachmentUtil.getTempAttachment(player);
/*     */       }
/*  55 */       float temperature = TEMPERATURE_CAP.getTemperatureLevel();
/*  56 */       TemperatureEnum tempEnum = TEMPERATURE_CAP.getTemperatureEnum();
/*     */       
/*  58 */       boolean frostbiteLimit = (temperature <= TemperatureEnum.FROSTBITE.getValue() + 1.0F);
/*  59 */       boolean heatstrokeLimit = (temperature >= TemperatureEnum.HEAT_STROKE.getValue() - 1.0F);
/*     */ 
/*     */       
/*  62 */       if (Config.Baked.coldTemperatureOverlay && tempEnum == TemperatureEnum.FROSTBITE && !FrostbiteEffect.playerIsImmuneToFrost(player)) {
/*     */         
/*  64 */         temperatureEffect = FROSTBITE_EFFECT;
/*  65 */         if (frostbiteLimit) {
/*     */           
/*  67 */           targetFadeLevel = 0.75F;
/*  68 */           if (triggerTemperatureSoundEffect) {
/*     */             
/*  70 */             triggerTemperatureSoundEffect = false;
/*  71 */             player.playSound((SoundEvent)SoundRegistry.FROSTBITE.get(), 1.0F, 1.0F);
/*     */           } 
/*     */         } else {
/*     */           
/*  75 */           targetFadeLevel = 0.35F;
/*  76 */           triggerTemperatureSoundEffect = true;
/*  77 */           if (fadeLevel == 0.0F)
/*     */           {
/*  79 */             player.playSound((SoundEvent)SoundRegistry.FROSTBITE_EARLY.get(), 1.0F, 1.0F);
/*     */           }
/*     */         } 
/*  82 */       } else if (Config.Baked.heatTemperatureOverlay && tempEnum == TemperatureEnum.HEAT_STROKE && !HeatStrokeEffect.playerIsImmuneToHeat(player)) {
/*     */         
/*  84 */         temperatureEffect = HEAT_STROKE_EFFECT;
/*     */         
/*  86 */         if (heatstrokeLimit) {
/*     */           
/*  88 */           targetFadeLevel = 0.6F;
/*  89 */           if (triggerTemperatureSoundEffect) {
/*     */             
/*  91 */             triggerTemperatureSoundEffect = false;
/*  92 */             player.playSound((SoundEvent)SoundRegistry.HEAT_STROKE.get(), 1.0F, 1.0F);
/*     */           } 
/*     */         } else {
/*     */           
/*  96 */           targetFadeLevel = 0.25F;
/*  97 */           triggerTemperatureSoundEffect = true;
/*  98 */           if (fadeLevel == 0.0F)
/*     */           {
/* 100 */             player.playSound((SoundEvent)SoundRegistry.HEAT_STROKE_EARLY.get(), 1.0F, 1.0F);
/*     */           }
/*     */         } 
/*     */       } else {
/*     */         
/* 105 */         triggerTemperatureSoundEffect = true;
/* 106 */         targetFadeLevel = 0.0F;
/*     */       } 
/*     */       
/* 109 */       if (targetFadeLevel > fadeLevel)
/*     */       {
/* 111 */         fadeLevel = Math.min(targetFadeLevel, fadeLevel + MathUtil.round(0.05F, 2));
/*     */       }
/* 113 */       if (targetFadeLevel < fadeLevel)
/*     */       {
/* 115 */         fadeLevel = Math.max(targetFadeLevel, fadeLevel - MathUtil.round(0.05F, 2));
/*     */       }
/*     */       
/* 118 */       if (fadeLevel == 0.0F)
/*     */       {
/* 120 */         temperatureEffect = null;
/*     */       }
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\client\render\RenderTemperatureOverlay.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */