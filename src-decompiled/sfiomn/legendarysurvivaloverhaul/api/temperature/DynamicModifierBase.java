/*    */ package sfiomn.legendarysurvivaloverhaul.api.temperature;
/*    */ 
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureResistance;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DynamicModifierBase
/*    */ {
/*    */   public float applyDynamicPlayerInfluence(Player player, float currentTemperature, float currentResistance) {
/* 19 */     return 0.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public float applyDynamicWorldInfluence(Player player, Level world, BlockPos pos, float currentTemperature, float currentResistance) {
/* 24 */     return 0.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getEffectiveResistance(float currentTemperature, float currentResistance, JsonTemperatureResistance jsonTemperatureResistance) {
/* 29 */     float diffToAverage = currentTemperature - TemperatureEnum.NORMAL.getValue();
/*    */     
/* 31 */     if (diffToAverage == 0.0F)
/*    */     {
/* 33 */       return 0.0F;
/*    */     }
/*    */     
/* 36 */     boolean isHot = (diffToAverage > 0.0F);
/* 37 */     float diff = Math.abs(diffToAverage);
/* 38 */     float adjustedResistance = isHot ? currentResistance : -currentResistance;
/*    */     
/* 40 */     double maxResistance = (jsonTemperatureResistance.thermalResistance + (isHot ? jsonTemperatureResistance.heatResistance : jsonTemperatureResistance.coldResistance));
/*    */     
/* 42 */     float effectiveResistance = (float)Mth.clamp(maxResistance, adjustedResistance, (diff + adjustedResistance));
/* 43 */     return isHot ? -effectiveResistance : effectiveResistance;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\temperature\DynamicModifierBase.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */