/*    */ package sfiomn.legendarysurvivaloverhaul.common.temperature;
/*    */ 
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.ModifierBase;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemperatureImmunityEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemperatureUtil;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OnFireModifier
/*    */   extends ModifierBase
/*    */ {
/*    */   public float getPlayerInfluence(Player player) {
/* 21 */     if (player.getRemainingFireTicks() > 0 && !TemperatureUtil.hasImmunity(player, TemperatureImmunityEnum.ON_FIRE))
/*    */     {
/*    */       
/* 24 */       return (float)Config.Baked.onFireModifier;
/*    */     }
/*    */     
/* 27 */     return 0.0F;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\temperature\OnFireModifier.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */