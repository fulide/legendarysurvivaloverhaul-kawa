/*    */ package sfiomn.legendarysurvivaloverhaul.client.screens;
/*    */ 
/*    */ import com.mojang.blaze3d.systems.RenderSystem;
/*    */ import net.minecraft.client.gui.GuiGraphics;
/*    */ import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
/*    */ import net.minecraft.client.renderer.GameRenderer;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.player.Inventory;
/*    */ import net.minecraft.world.inventory.AbstractContainerMenu;
/*    */ import net.neoforged.api.distmarker.Dist;
/*    */ import net.neoforged.api.distmarker.OnlyIn;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.block.ThermalTypeEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.containers.AbstractThermalContainer;
/*    */ 
/*    */ @OnlyIn(Dist.CLIENT)
/*    */ public class ThermalScreen
/*    */   extends AbstractContainerScreen<AbstractThermalContainer> {
/* 20 */   public static final ResourceLocation HEATER_SCREEN = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "textures/gui/heater_screen.png");
/* 21 */   public static final ResourceLocation COOLER_SCREEN = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "textures/gui/cooler_screen.png");
/*    */   
/*    */   public static final int FUEL_LEVEL_WIDTH = 29;
/*    */   public static final int FUEL_LEVEL_HEIGHT = 27;
/*    */   
/*    */   public ThermalScreen(AbstractThermalContainer screenContainer, Inventory playerInventory, Component titleIn) {
/* 27 */     super((AbstractContainerMenu)screenContainer, playerInventory, titleIn);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void init() {
/* 33 */     super.init();
/* 34 */     this.inventoryLabelY = 10000;
/* 35 */     this.titleLabelY = 10000;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(@NotNull GuiGraphics gui, int mouseX, int mouseY, float partialTicks) {
/* 41 */     renderBackground(gui, mouseX, mouseY, partialTicks);
/* 42 */     super.render(gui, mouseX, mouseY, partialTicks);
/* 43 */     renderTooltip(gui, mouseX, mouseY);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renderBg(GuiGraphics gui, float partialTicks, int x, int y) {
/*    */     ResourceLocation TEXTURE;
/* 49 */     if (this.minecraft == null) {
/*    */       return;
/*    */     }
/*    */     
/* 53 */     RenderSystem.setShader(GameRenderer::getPositionTexShader);
/* 54 */     RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
/*    */ 
/*    */     
/* 57 */     if (((AbstractThermalContainer)this.menu).getThermalType() == ThermalTypeEnum.HEATING) {
/*    */       
/* 59 */       TEXTURE = HEATER_SCREEN;
/*    */     } else {
/*    */       
/* 62 */       TEXTURE = COOLER_SCREEN;
/*    */     } 
/*    */     
/* 65 */     RenderSystem.setShaderTexture(0, TEXTURE);
/* 66 */     gui.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
/*    */ 
/*    */     
/* 69 */     int fuelTimeHeight = (int)(((AbstractThermalContainer)this.menu).getFuelTimeScale() * 27.0F);
/* 70 */     gui.blit(TEXTURE, this.leftPos + 73, this.topPos + 35 + 27 - fuelTimeHeight, 176, 24 + 27 - fuelTimeHeight, 29, fuelTimeHeight);
/*    */ 
/*    */     
/* 73 */     if (((AbstractThermalContainer)this.menu).isPowered())
/* 74 */       gui.blit(TEXTURE, this.leftPos + 137, this.topPos + 37, 176, 0, 12, 24); 
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\client\screens\ThermalScreen.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */