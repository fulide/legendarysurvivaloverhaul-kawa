/*    */ package sfiomn.legendarysurvivaloverhaul.util;
/*    */ 
/*    */ import com.mojang.blaze3d.systems.RenderSystem;
/*    */ import com.mojang.blaze3d.vertex.BufferBuilder;
/*    */ import com.mojang.blaze3d.vertex.BufferUploader;
/*    */ import com.mojang.blaze3d.vertex.DefaultVertexFormat;
/*    */ import com.mojang.blaze3d.vertex.Tesselator;
/*    */ import com.mojang.blaze3d.vertex.VertexFormat;
/*    */ import net.minecraft.client.gui.GuiGraphics;
/*    */ import net.minecraft.client.renderer.GameRenderer;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import org.joml.Matrix4f;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class RenderUtil
/*    */ {
/*    */   public static void drawTexturedModelRect(Matrix4f matrix, float x, float y, int width, int height, int texX, int texY, int texWidth, int texHeight) {
/* 31 */     float f = 0.00390625F;
/* 32 */     float f1 = 0.00390625F;
/* 33 */     float z = 0.0F;
/*    */     
/* 35 */     RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
/* 36 */     BufferBuilder bufferBuilder = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
/*    */     
/* 38 */     bufferBuilder.addVertex(matrix, x, y + height, z)
/* 39 */       .setUv(texX * f, (texY + texHeight) * f1).setColor(255, 255, 255, 122);
/* 40 */     bufferBuilder.addVertex(matrix, x + width, y + height, z)
/* 41 */       .setUv((texX + texWidth) * f, (texY + texHeight) * f1).setColor(255, 255, 255, 122);
/* 42 */     bufferBuilder.addVertex(matrix, x + width, y, z)
/* 43 */       .setUv((texX + texWidth) * f, texY * f1).setColor(255, 255, 255, 122);
/* 44 */     bufferBuilder.addVertex(matrix, x, y, z)
/* 45 */       .setUv(texX * f, texY * f1).setColor(255, 255, 255, 255);
/* 46 */     BufferUploader.drawWithShader(bufferBuilder.buildOrThrow());
/*    */   }
/*    */ 
/*    */   
/*    */   public static void drawTexturedModelRectWithAlpha(Matrix4f matrix, float x, float y, int width, int height, int texX, int texY, int texWidth, int texHeight, float alpha) {
/* 51 */     RenderSystem.disableDepthTest();
/* 52 */     RenderSystem.depthMask(false);
/* 53 */     RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, alpha);
/*    */     
/* 55 */     drawTexturedModelRect(matrix, x, y, width, height, texX, texY, texWidth, texHeight);
/*    */     
/* 57 */     RenderSystem.depthMask(true);
/* 58 */     RenderSystem.enableDepthTest();
/* 59 */     RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void renderTextureOverlay(GuiGraphics gui, ResourceLocation resourceLocation, int screenWidth, int screenHeight, float alpha) {
/* 64 */     RenderSystem.disableDepthTest();
/* 65 */     RenderSystem.depthMask(false);
/* 66 */     gui.setColor(1.0F, 1.0F, 1.0F, alpha);
/*    */     
/* 68 */     gui.blit(resourceLocation, 0, 0, -90, 0.0F, 0.0F, screenWidth, screenHeight, screenWidth, screenHeight);
/*    */     
/* 70 */     RenderSystem.depthMask(true);
/* 71 */     RenderSystem.enableDepthTest();
/* 72 */     gui.setColor(1.0F, 1.0F, 1.0F, 1.0F);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhau\\util\RenderUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */