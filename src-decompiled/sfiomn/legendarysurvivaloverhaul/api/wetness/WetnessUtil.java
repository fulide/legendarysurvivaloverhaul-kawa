/*    */ package sfiomn.legendarysurvivaloverhaul.api.wetness;
/*    */ 
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WetnessUtil
/*    */ {
/*    */   public static IWetnessUtil internal;
/*    */   
/*    */   public static void addWetness(Player player, int wetness) {
/* 17 */     internal.addWetness(player, wetness);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void deactivateWetness(Player player) {
/* 27 */     internal.deactivateWetness(player);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void activateWetness(Player player) {
/* 37 */     internal.activateWetness(player);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean isWetnessActive(Player player) {
/* 47 */     return internal.isWetnessActive(player);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\wetness\WetnessUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */