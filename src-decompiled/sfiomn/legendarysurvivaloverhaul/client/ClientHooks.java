/*    */ package sfiomn.legendarysurvivaloverhaul.client;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.screens.Screen;
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import sfiomn.legendarysurvivaloverhaul.client.screens.BodyHealthScreen;
/*    */ 
/*    */ public class ClientHooks
/*    */ {
/*    */   public static void openBodyHealthScreen(Player player, InteractionHand hand, boolean alreadyConsumed, int healingCharges, float healingValue, int healingTime) {
/* 12 */     Minecraft.getInstance().setScreen((Screen)new BodyHealthScreen(player, hand, alreadyConsumed, healingCharges, healingValue, healingTime));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void openBodyHealthScreen(Player player) {
/* 17 */     openBodyHealthScreen(player, null, false, 0, 0.0F, 0);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\client\ClientHooks.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */