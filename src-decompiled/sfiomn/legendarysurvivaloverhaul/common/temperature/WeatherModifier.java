/*    */ package sfiomn.legendarysurvivaloverhaul.common.temperature;
/*    */ 
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.biome.Biome;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.ModifierBase;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.TemperatureModifierRegistry;
/*    */ import sfiomn.legendarysurvivaloverhaul.util.WorldUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WeatherModifier
/*    */   extends ModifierBase
/*    */ {
/*    */   public float getWorldInfluence(Player player, Level level, BlockPos pos) {
/* 22 */     Biome.Precipitation precipitation = Biome.Precipitation.NONE;
/* 23 */     boolean isUndercover = WorldUtil.isPlayerOrPosUndercover(level, player, pos.above());
/*    */     
/* 25 */     if (!isUndercover) {
/* 26 */       precipitation = WorldUtil.getPrecipitationAt(level, player, pos.above());
/*    */     }
/*    */ 
/*    */     
/* 30 */     if (precipitation == Biome.Precipitation.NONE && !isUndercover)
/*    */     {
/*    */       
/* 33 */       return 0.0F;
/*    */     }
/*    */     
/* 36 */     float weatherTemperature = 0.0F;
/* 37 */     long time = level.getLevelData().getDayTime();
/*    */ 
/*    */     
/* 40 */     if (Config.Baked.shadeTimeModifier != 0.0D && time <= 12000L)
/*    */     {
/* 42 */       if ((((ModifierBase)TemperatureModifierRegistry.BIOME.get()).getWorldInfluence(player, level, pos) + ((ModifierBase)TemperatureModifierRegistry.SERENE_SEASONS
/* 43 */         .get()).getWorldInfluence(player, level, pos) + ((ModifierBase)TemperatureModifierRegistry.ECLIPTIC_SEASONS
/* 44 */         .get()).getWorldInfluence(player, level, pos)) >= Config.Baked.shadeTimeModifierThreshold) {
/*    */ 
/*    */         
/* 47 */         float shadeTemperature = (float)Config.Baked.shadeTimeModifier * (float)Math.sin(time * 2.6179938E-4D);
/* 48 */         weatherTemperature += shadeTemperature;
/*    */       } 
/*    */     }
/*    */     
/* 52 */     if (precipitation == Biome.Precipitation.RAIN) {
/* 53 */       weatherTemperature += (float)Config.Baked.rainTemperatureModifier;
/* 54 */     } else if (precipitation == Biome.Precipitation.SNOW) {
/* 55 */       weatherTemperature += (float)Config.Baked.snowTemperatureModifier;
/*    */     } 
/* 57 */     return weatherTemperature;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\temperature\WeatherModifier.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */