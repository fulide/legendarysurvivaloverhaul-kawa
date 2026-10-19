/*    */ package sfiomn.legendarysurvivaloverhaul.api.health;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HealthUtil
/*    */ {
/*    */   public static IHealthUtil internal;
/*    */   
/*    */   public static void updatePlayerMaxHealthAttribute(Player player) {
/* 18 */     internal.updatePlayerMaxHealthAttribute(player);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static double getPlayerMaxHealth(Player player) {
/* 29 */     return internal.getPlayerMaxHealth(player);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static double getPlayerStableMaxHealth(Player player) {
/* 40 */     return internal.getPlayerStableMaxHealth(player);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int getEffectiveBrokenHearts(Player player) {
/* 51 */     return internal.getEffectiveBrokenHearts(player);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void initializeHealthAttributes(Player player) {
/* 61 */     internal.initializeHealthAttributes(player);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static float hurtPlayer(Player player, float damageValue) {
/* 73 */     return internal.hurtPlayer(player, damageValue);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void loseHearth(Player player, int amountLost) {
/* 85 */     internal.loseHearth(player, amountLost);
/*    */   }
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
/*    */   public static void updateBrokenHearts(Player player, UUID attributeUuid, int brokenHearts) {
/* 98 */     internal.updateBrokenHearts(player, attributeUuid, brokenHearts);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\health\HealthUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */