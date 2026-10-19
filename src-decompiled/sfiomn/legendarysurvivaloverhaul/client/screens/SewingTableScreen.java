/*    */ package sfiomn.legendarysurvivaloverhaul.client.screens;
/*    */ 
/*    */ import com.mojang.blaze3d.systems.RenderSystem;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiGraphics;
/*    */ import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
/*    */ import net.minecraft.client.renderer.GameRenderer;
/*    */ import net.minecraft.client.renderer.Rect2i;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.network.chat.MutableComponent;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.player.Inventory;
/*    */ import net.minecraft.world.inventory.AbstractContainerMenu;
/*    */ import net.neoforged.api.distmarker.Dist;
/*    */ import net.neoforged.api.distmarker.OnlyIn;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.containers.SewingTableContainer;
/*    */ 
/*    */ @OnlyIn(Dist.CLIENT)
/*    */ public class SewingTableScreen
/*    */   extends AbstractContainerScreen<SewingTableContainer>
/*    */ {
/* 22 */   public static final ResourceLocation SEWING_TABLE_SCREEN = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "textures/gui/sewing_table_screen.png");
/*    */   
/*    */   Rect2i craftDisabledArea;
/*    */   
/*    */   public SewingTableScreen(SewingTableContainer screenContainer, Inventory playerInventory, Component titleIn) {
/* 27 */     super((AbstractContainerMenu)screenContainer, playerInventory, titleIn);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void init() {
/* 33 */     super.init();
/* 34 */     this.craftDisabledArea = new Rect2i(this.leftPos + 93, this.topPos + 41, 13, 13);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(GuiGraphics gui, int mouseX, int mouseY, float partialTicks) {
/* 40 */     renderBackground(gui, mouseX, mouseY, partialTicks);
/* 41 */     super.render(gui, mouseX, mouseY, partialTicks);
/* 42 */     renderTooltip(gui, mouseX, mouseY);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void renderBg(GuiGraphics gui, float partialTicks, int x, int y) {
/* 48 */     if (this.minecraft == null) {
/*    */       return;
/*    */     }
/*    */ 
/*    */     
/* 53 */     RenderSystem.setShader(GameRenderer::getPositionTexShader);
/* 54 */     RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
/*    */     
/* 56 */     gui.blit(SEWING_TABLE_SCREEN, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
/*    */     
/* 58 */     if (((SewingTableContainer)this.menu).getSlot(0).getItem().getItem() instanceof net.minecraft.world.item.ArmorItem && ((SewingTableContainer)this.menu)
/* 59 */       .getSlot(1).getItem().getItem() instanceof net.minecraft.world.item.Item && 
/* 60 */       !((SewingTableContainer)this.menu).getSlot(2).hasItem())
/*    */     {
/* 62 */       gui.blit(SEWING_TABLE_SCREEN, this.leftPos + 93, this.topPos + 41, 176, 0, 13, 13);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void renderTooltip(GuiGraphics gui, int mouseX, int mouseY) {
/* 69 */     super.renderTooltip(gui, mouseX, mouseY);
/*    */     
/* 71 */     if ((Minecraft.getInstance()).player == null)
/* 72 */       return;  if ((Minecraft.getInstance()).screen == null)
/*    */       return; 
/* 74 */     if (this.craftDisabledArea.contains(mouseX, mouseY))
/*    */     {
/* 76 */       if (((SewingTableContainer)this.menu).getSlot(0).getItem().getItem() instanceof net.minecraft.world.item.ArmorItem && ((SewingTableContainer)this.menu)
/* 77 */         .getSlot(1).getItem().getItem() instanceof net.minecraft.world.item.Item && 
/* 78 */         !((SewingTableContainer)this.menu).getSlot(2).hasItem()) {
/*    */ 
/*    */         
/* 81 */         MutableComponent mutableComponent = Component.translatable("tooltip.legendarysurvivaloverhaul.sewing_table.disabled");
/* 82 */         gui.renderTooltip((Minecraft.getInstance()).font, (Component)mutableComponent, mouseX, mouseY);
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\client\screens\SewingTableScreen.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */