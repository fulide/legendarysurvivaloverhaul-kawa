/*    */ package sfiomn.legendarysurvivaloverhaul.common.integration.eclipticseasons;
/*    */ 
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.ModifierBase;
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
/*    */ public class EclipticSeasonsModifier
/*    */   extends ModifierBase
/*    */ {
/*    */   public float getWorldInfluence(Player player, Level level, BlockPos pos) {
/* 23 */     if (!LegendarySurvivalOverhaul.eclipticSeasonsLoaded || !Config.Baked.eclipticSeasonsEnabled) {
/* 24 */       return 0.0F;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 31 */       return getUncaughtWorldInfluence(level, pos);
/* 32 */     } catch (Exception e) {
/*    */ 
/*    */       
/* 35 */       LegendarySurvivalOverhaul.LOGGER.error("An error has occurred with Ecliptic Seasons compatibility, disabling modifier", e);
/* 36 */       LegendarySurvivalOverhaul.eclipticSeasonsLoaded = false;
/*    */       
/* 38 */       return 0.0F;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public float getUncaughtWorldInfluence(Level level, BlockPos pos) {
/* 44 */     if (!EclipticSeasonsUtil.hasDimensionSeason(level)) {
/* 45 */       return 0.0F;
/*    */     }
/* 47 */     if (EclipticSeasonsCompat.isSolarTermNone(level)) {
/* 48 */       return 0.0F;
/*    */     }
/* 50 */     int timeInSubSeason = (int)(EclipticSeasonsCompat.getTimeInTerm(level) * 24000.0F + (float)(level.getLevelData().getDayTime() % 24000L));
/* 51 */     int subSeasonDuration = EclipticSeasonsUtil.getDaysInSolarTerm(level) * 24000;
/* 52 */     int ordinal = EclipticSeasonsCompat.getSolarTermOrdinal(level);
/* 53 */     float value = EclipticSeasonsUtil.getBlendedSeasonModifier(EclipticSeasonsUtil.getSeasonModifier(ordinal - 1), EclipticSeasonsUtil.getSeasonModifier(ordinal), EclipticSeasonsUtil.getSeasonModifier(ordinal + 1), timeInSubSeason, subSeasonDuration);
/* 54 */     double targetUndergroundTemperature = 0.0D;
/*    */     
/* 56 */     return applyUndergroundEffect(value, level, pos, (float)targetUndergroundTemperature);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\eclipticseasons\EclipticSeasonsModifier.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */