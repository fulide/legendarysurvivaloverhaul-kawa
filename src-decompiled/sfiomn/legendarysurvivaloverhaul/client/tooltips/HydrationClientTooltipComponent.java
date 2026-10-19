/*     */ package sfiomn.legendarysurvivaloverhaul.client.tooltips;
/*     */ 
/*     */ import com.mojang.blaze3d.systems.RenderSystem;
/*     */ import net.minecraft.client.gui.Font;
/*     */ import net.minecraft.client.gui.GuiGraphics;
/*     */ import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
/*     */ import net.minecraft.client.renderer.GameRenderer;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*     */ 
/*     */ public class HydrationClientTooltipComponent
/*     */   implements ClientTooltipComponent
/*     */ {
/*  14 */   public static final ResourceLocation ICONS = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "textures/gui/overlay.png");
/*     */   
/*     */   public static final int THIRST_TEXTURE_WIDTH = 9;
/*     */   
/*     */   public static final int THIRST_TEXTURE_HEIGHT = 9;
/*     */   public final int hydration;
/*     */   public final float saturation;
/*     */   public int hydrationIconNumber;
/*     */   public int saturationIconNumber;
/*     */   
/*     */   public HydrationClientTooltipComponent(int hydration, float saturation) {
/*  25 */     this.hydration = hydration;
/*  26 */     this.saturation = saturation;
/*     */     
/*  28 */     this.hydrationIconNumber = Math.min((int)Math.ceil((Math.abs(hydration) / 2.0F)), 10);
/*     */     
/*  30 */     if (Config.Baked.hydrationSaturationDisplayed) {
/*     */       
/*  32 */       this.saturationIconNumber = Math.min((int)Math.ceil((Math.abs(saturation) / 2.0F)), 10);
/*     */     } else {
/*     */       
/*  35 */       this.saturationIconNumber = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHeight() {
/*  42 */     int height = 14;
/*     */ 
/*     */ 
/*     */     
/*  46 */     if (this.saturationIconNumber > 0 && Config.Baked.hydrationSaturationDisplayed)
/*     */     {
/*  48 */       if (this.hydrationIconNumber > 0 && !Config.Baked.mergeHydrationAndSaturationTooltip) {
/*  49 */         height += 10;
/*     */       }
/*     */     }
/*  52 */     return height;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWidth(Font font) {
/*  58 */     return Math.max(this.hydrationIconNumber, this.saturationIconNumber) * 9;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderImage(Font font, int tooltipX, int tooltipY, GuiGraphics gui) {
/*  64 */     RenderSystem.disableDepthTest();
/*  65 */     RenderSystem.enableBlend();
/*  66 */     RenderSystem.defaultBlendFunc();
/*  67 */     RenderSystem.setShader(GameRenderer::getRendertypeTextShader);
/*  68 */     RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/*  70 */     int leftMax = 0;
/*  71 */     leftMax = Math.max(tooltipX + (this.hydrationIconNumber - 1) * 9, tooltipX + (this.saturationIconNumber - 1) * 9);
/*     */ 
/*     */ 
/*     */     
/*  75 */     int left = 0;
/*  76 */     if (!Config.Baked.mergeHydrationAndSaturationTooltip) {
/*  77 */       left = tooltipX + (this.hydrationIconNumber - 1) * 9;
/*     */     } else {
/*  79 */       left = leftMax;
/*  80 */     }  int top = tooltipY + 2;
/*     */     
/*  82 */     int xOffsetTexture = 0;
/*  83 */     if (this.hydration >= 0) {
/*  84 */       xOffsetTexture = 9;
/*     */     } else {
/*  86 */       xOffsetTexture = 36;
/*     */     } 
/*     */     int i;
/*  89 */     for (i = 0; i < this.hydrationIconNumber; i++) {
/*     */       
/*  91 */       int halfIcon = i * 2 + 1;
/*  92 */       int x = left - i * 9;
/*  93 */       int y = top;
/*  94 */       if (halfIcon < Math.abs(this.hydration)) {
/*  95 */         gui.blit(ICONS, x, y, xOffsetTexture, 0.0F, 9, 9, 256, 256);
/*  96 */       } else if (halfIcon == Math.abs(this.hydration)) {
/*  97 */         gui.blit(ICONS, x, y, (xOffsetTexture + 9), 0.0F, 9, 9, 256, 256);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 102 */     if (this.saturationIconNumber > 0 && Config.Baked.hydrationSaturationDisplayed) {
/*     */       
/* 104 */       if (this.hydrationIconNumber > 0 && !Config.Baked.mergeHydrationAndSaturationTooltip)
/* 105 */         top += 10; 
/* 106 */       if (!Config.Baked.mergeHydrationAndSaturationTooltip) {
/* 107 */         left = tooltipX + (this.saturationIconNumber - 1) * 9;
/*     */       } else {
/* 109 */         left = leftMax;
/*     */       } 
/*     */     } 
/* 112 */     if (this.saturation >= 0.0F) {
/*     */       
/* 114 */       xOffsetTexture = 54;
/*     */     } else {
/* 116 */       xOffsetTexture = 126;
/*     */     } 
/*     */     
/* 119 */     for (i = 0; i < this.saturationIconNumber; i++) {
/*     */       
/* 121 */       int halfIcon = i * 2 + 1;
/* 122 */       int x = left - i * 9;
/* 123 */       int y = top;
/*     */       
/* 125 */       if (halfIcon < (int)Math.ceil(Math.abs(this.saturation))) {
/* 126 */         gui.blit(ICONS, x, y, xOffsetTexture, 0.0F, 9, 9, 256, 256);
/* 127 */       } else if (halfIcon == (int)Math.ceil(Math.abs(this.saturation))) {
/* 128 */         gui.blit(ICONS, x, y, (xOffsetTexture + 9), 0.0F, 9, 9, 256, 256);
/*     */       } 
/*     */     } 
/* 131 */     RenderSystem.disableBlend();
/*     */ 
/*     */     
/* 134 */     RenderSystem.disableDepthTest();
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\client\tooltips\HydrationClientTooltipComponent.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */