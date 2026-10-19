/*    */ package sfiomn.legendarysurvivaloverhaul.common.temperature;
/*    */ 
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.biome.Biome;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.ModifierBase;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.integration.eclipticseasons.EclipticSeasonsUtil;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.integration.terrafirmacraft.TerraFirmaCraftUtil;
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
/*    */ 
/*    */ public class TimeModifier
/*    */   extends ModifierBase
/*    */ {
/*    */   public float getWorldInfluence(Player player, Level level, BlockPos pos) {
/* 25 */     if (level.dimensionType().hasCeiling() || TerraFirmaCraftUtil.shouldUseTerraFirmaCraftTemp())
/*    */     {
/* 27 */       return 0.0F;
/*    */     }
/*    */     
/* 30 */     long time = level.getLevelData().getDayTime();
/*    */ 
/*    */     
/* 33 */     double timeAngle = time * 2.6179938E-4D;
/* 34 */     if (EclipticSeasonsUtil.hasDimensionSeason(level)) {
/*    */       
/* 36 */       long sunRiseTime = EclipticSeasonsUtil.getSunRiseTime(level);
/* 37 */       int dayDuration = EclipticSeasonsUtil.getDayDuration(level);
/* 38 */       long sunSetTime = sunRiseTime + dayDuration;
/*    */ 
/*    */       
/* 41 */       if (time > sunRiseTime && time < sunSetTime % 24000L) {
/*    */         
/* 43 */         timeAngle = Math.PI / dayDuration * ((time - sunRiseTime) % 24000L);
/*    */       } else {
/*    */         
/* 46 */         timeAngle = -(Math.PI / (24000 - dayDuration)) * ((time - sunSetTime) % 24000L);
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 51 */     float timeTemperature = (float)Math.sin(timeAngle) * (float)Config.Baked.timeModifier;
/*    */ 
/*    */     
/* 54 */     float biomeMultiplier = 1.0F + Math.abs(normalizeToPositiveNegative(getNormalizedTempForBiome(level, (Biome)level.getBiome(pos).value()))) * ((float)Config.Baked.biomeTimeMultiplier - 1.0F);
/* 55 */     timeTemperature *= biomeMultiplier;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 61 */     return applyUndergroundEffect(timeTemperature, level, pos, 0.0F);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\temperature\TimeModifier.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */