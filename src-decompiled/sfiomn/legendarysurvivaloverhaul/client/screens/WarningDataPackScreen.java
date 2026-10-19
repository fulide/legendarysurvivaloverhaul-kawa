/*    */ package sfiomn.legendarysurvivaloverhaul.client.screens;
/*    */ 
/*    */ import it.unimi.dsi.fastutil.booleans.BooleanConsumer;
/*    */ import net.minecraft.Util;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.screens.ConfirmScreen;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*    */ 
/*    */ 
/*    */ public class WarningDataPackScreen
/*    */   extends ConfirmScreen
/*    */ {
/*    */   public WarningDataPackScreen() {
/* 15 */     super(getButtonEffect(), 
/* 16 */         (Component)Component.translatable("screen.legendarysurvivaloverhaul.datapack_transfer.title"), 
/* 17 */         (Component)Component.translatable("screen.legendarysurvivaloverhaul.datapack_transfer.text"), 
/* 18 */         (Component)Component.translatable("screen.legendarysurvivaloverhaul.datapack_transfer.open_folder"), 
/* 19 */         (Component)Component.translatable("menu.returnToGame"));
/*    */   }
/*    */ 
/*    */   
/*    */   private static BooleanConsumer getButtonEffect() {
/* 24 */     return confirmButton -> {
/*    */         if (confirmButton) {
/*    */           Util.getPlatform().openFile(LegendarySurvivalOverhaul.modConfigPath.toFile());
/*    */         } else {
/*    */           Minecraft.getInstance().setScreen(null);
/*    */         } 
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\client\screens\WarningDataPackScreen.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */