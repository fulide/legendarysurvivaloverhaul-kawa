/*    */ package sfiomn.legendarysurvivaloverhaul.client.shaders;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.PostChain;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.neoforged.api.distmarker.Dist;
/*    */ import net.neoforged.api.distmarker.OnlyIn;
/*    */ 
/*    */ public class FocusShader
/*    */ {
/* 11 */   public static final ResourceLocation BLOBS2_SHADER = ResourceLocation.withDefaultNamespace("shaders/post/blobs2.json");
/* 12 */   public static final ResourceLocation BLUR_SHADER = ResourceLocation.withDefaultNamespace("shaders/post/blur.json");
/*    */   
/*    */   private static boolean shaderLoadAttempted = false;
/*    */   private static boolean shaderAvailable = false;
/* 16 */   private static String loadedShaderName = null;
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(float intensity) {
/* 21 */     if (intensity <= 0.0F)
/*    */       return; 
/* 23 */     Minecraft mc = Minecraft.getInstance();
/* 24 */     PostChain effect = mc.gameRenderer.currentEffect();
/*    */ 
/*    */     
/* 27 */     if (!shaderLoadAttempted) {
/* 28 */       shaderLoadAttempted = true;
/*    */       try {
/* 30 */         mc.gameRenderer.loadEffect(BLOBS2_SHADER);
/* 31 */         effect = mc.gameRenderer.currentEffect();
/* 32 */         shaderAvailable = (effect != null);
/* 33 */         loadedShaderName = shaderAvailable ? effect.getName() : null;
/* 34 */       } catch (Throwable t) {
/*    */         
/*    */         try {
/* 37 */           mc.gameRenderer.loadEffect(BLUR_SHADER);
/* 38 */           effect = mc.gameRenderer.currentEffect();
/* 39 */           shaderAvailable = (effect != null);
/* 40 */           loadedShaderName = shaderAvailable ? effect.getName() : null;
/* 41 */         } catch (Throwable ignored) {
/* 42 */           shaderAvailable = false;
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 47 */     if (!shaderAvailable) {
/*    */       return;
/*    */     }
/* 50 */     if (effect == null || (loadedShaderName != null && !effect.getName().equals(loadedShaderName))) {
/*    */       return;
/*    */     }
/*    */     
/* 54 */     updateIntensity(intensity);
/*    */   }
/*    */   
/*    */   public void stopRender() {
/* 58 */     Minecraft mc = Minecraft.getInstance();
/* 59 */     PostChain effect = mc.gameRenderer.currentEffect();
/* 60 */     if (effect != null) {
/* 61 */       mc.gameRenderer.shutdownEffect();
/*    */     }
/*    */   }
/*    */   
/*    */   @OnlyIn(Dist.CLIENT)
/*    */   public void updateIntensity(float intensity) {
/* 67 */     PostChain effect = (Minecraft.getInstance()).gameRenderer.currentEffect();
/* 68 */     if (effect != null)
/*    */     {
/* 70 */       effect.setUniform("Radius", intensity);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\client\shaders\FocusShader.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */