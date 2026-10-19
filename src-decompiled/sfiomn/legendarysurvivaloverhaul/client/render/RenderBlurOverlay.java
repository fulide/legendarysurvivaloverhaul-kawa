/*    */ package sfiomn.legendarysurvivaloverhaul.client.render;
/*    */ 
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.neoforged.api.distmarker.Dist;
/*    */ import net.neoforged.api.distmarker.OnlyIn;
/*    */ import sfiomn.legendarysurvivaloverhaul.client.shaders.FocusShader;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.attachments.thirst.ThirstAttachment;
/*    */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @OnlyIn(Dist.CLIENT)
/*    */ public class RenderBlurOverlay
/*    */ {
/*    */   private static final float DEFAULT_SHADER_INTENSITY = 0.0F;
/*    */   private static final float MAX_SHADER_INTENSITY = 4.0F;
/*    */   private static final float SHADER_INTENSITY_STEP = 0.05F;
/*    */   private static final int HYDRATION_LEVEL_MIN_EFFECT = 6;
/*    */   private static final int HYDRATION_LEVEL_MAX_EFFECT = 2;
/*    */   private static FocusShader focusShader;
/* 25 */   private static float shaderIntensity = 0.0F;
/* 26 */   private static int updateTimer = 0;
/*    */   
/*    */   private static boolean hasShownBlurWarning = false;
/*    */   
/*    */   public static void render(Player player) {
/* 31 */     if (focusShader != null && (player.isSpectator() || player.isCreative() || shaderIntensity == 0.0F)) {
/*    */       
/* 33 */       focusShader.stopRender();
/* 34 */       focusShader = null;
/* 35 */     } else if (shaderIntensity > 0.0F && !((Minecraft.getInstance()).screen instanceof net.minecraft.client.gui.screens.DeathScreen)) {
/*    */       
/* 37 */       if (focusShader == null)
/* 38 */         focusShader = new FocusShader(); 
/* 39 */       focusShader.render(shaderIntensity);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void updateBlurIntensity(@Nullable Player player) {
/* 45 */     float targetShaderIntensity = 0.0F;
/* 46 */     if (player != null && player.isAlive() && !player.isCreative() && !player.isSpectator()) {
/*    */ 
/*    */       
/* 49 */       ThirstAttachment thirstCap = AttachmentUtil.getThirstAttachment(player);
/*    */       
/* 51 */       int hydration = thirstCap.getHydrationLevel();
/*    */       
/* 53 */       if (hydration <= 6) {
/*    */         
/* 55 */         targetShaderIntensity = (1.0F - (hydration - 2) / 4.0F) * 4.0F;
/*    */ 
/*    */         
/* 58 */         if (!hasShownBlurWarning && targetShaderIntensity > 0.0F) {
/*    */           
/* 60 */           player.displayClientMessage((Component)Component.literal("Vision is getting blurry. Drink some water"), true);
/* 61 */           hasShownBlurWarning = true;
/*    */         } 
/*    */       } 
/*    */       
/* 65 */       if (updateTimer++ % 2 == 0)
/*    */       {
/* 67 */         if (targetShaderIntensity > shaderIntensity) {
/*    */           
/* 69 */           shaderIntensity = Math.min(shaderIntensity + 0.05F, targetShaderIntensity);
/* 70 */         } else if (targetShaderIntensity < shaderIntensity) {
/*    */           
/* 72 */           shaderIntensity = Math.max(shaderIntensity - 0.05F, targetShaderIntensity);
/*    */         } 
/*    */       }
/*    */     } else {
/*    */       
/* 77 */       shaderIntensity = 0.0F;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\client\render\RenderBlurOverlay.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */