/*     */ package sfiomn.legendarysurvivaloverhaul.common.integration.sereneseasons;
/*     */ 
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Vec3i;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.level.Level;
/*     */ import sereneseasons.api.season.ISeasonState;
/*     */ import sereneseasons.api.season.Season;
/*     */ import sereneseasons.api.season.SeasonHelper;
/*     */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.temperature.ModifierBase;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SereneSeasonsModifier
/*     */   extends ModifierBase
/*     */ {
/*     */   public float getWorldInfluence(Player player, Level level, BlockPos pos) {
/*  26 */     if (!LegendarySurvivalOverhaul.sereneSeasonsLoaded) {
/*  27 */       return 0.0F;
/*     */     }
/*  29 */     if (!Config.Baked.sereneSeasonsEnabled) {
/*  30 */       return 0.0F;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  37 */       return getUncaughtWorldInfluence(level, pos);
/*  38 */     } catch (Exception e) {
/*     */ 
/*     */       
/*  41 */       LegendarySurvivalOverhaul.LOGGER.error("An error has occurred with Serene Seasons compatibility, disabling modifier", e);
/*  42 */       LegendarySurvivalOverhaul.sereneSeasonsLoaded = false;
/*     */       
/*  44 */       return 0.0F;
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getUncaughtWorldInfluence(Level level, BlockPos pos) {
/*     */     Vec3i[] posOffsets;
/*  50 */     ISeasonState seasonState = SeasonHelper.getSeasonState(level);
/*     */     
/*  52 */     if (seasonState == null || !SereneSeasonsUtil.hasSeasons(level)) {
/*  53 */       return 0.0F;
/*     */     }
/*     */     
/*  56 */     if (Config.Baked.ssTropicalSeasonsEnabled) {
/*  57 */       posOffsets = new Vec3i[] { new Vec3i(0, 0, 0), new Vec3i(10, 0, 0), new Vec3i(-10, 0, 0), new Vec3i(0, 0, 10), new Vec3i(0, 0, -10) };
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */       
/*  65 */       posOffsets = new Vec3i[] { new Vec3i(0, 0, 0) };
/*     */     } 
/*  67 */     float value = 0.0F;
/*  68 */     int validSpot = posOffsets.length;
/*  69 */     double targetUndergroundTemperature = 0.0D;
/*     */     
/*  71 */     for (Vec3i offset : posOffsets) {
/*     */       
/*  73 */       SereneSeasonsUtil.SeasonType seasonType = SereneSeasonsUtil.getSeasonType(level.getBiome(pos.offset(offset)));
/*     */       
/*  75 */       if (seasonType == SereneSeasonsUtil.SeasonType.NO_SEASON) {
/*     */         
/*  77 */         validSpot--;
/*     */       
/*     */       }
/*  80 */       else if (seasonType != SereneSeasonsUtil.SeasonType.TROPICAL_SEASON) {
/*     */         
/*  82 */         int timeInSubSeason = seasonState.getSeasonCycleTicks() % seasonState.getSubSeasonDuration();
/*  83 */         targetUndergroundTemperature = SereneSeasonsUtil.averageSeasonTemperature;
/*  84 */         switch (seasonState.getSubSeason()) {
/*     */           
/*     */           case EARLY_DRY:
/*  87 */             value += SereneSeasonsUtil.getSeasonModifier(Config.Baked.ssLateWinterModifier, Config.Baked.ssEarlySpringModifier, Config.Baked.ssMidSpringModifier, timeInSubSeason, seasonState.getSubSeasonDuration());
/*     */             break;
/*     */           case MID_DRY:
/*  90 */             value += SereneSeasonsUtil.getSeasonModifier(Config.Baked.ssEarlySpringModifier, Config.Baked.ssMidSpringModifier, Config.Baked.ssLateSpringModifier, timeInSubSeason, seasonState.getSubSeasonDuration());
/*     */             break;
/*     */           case LATE_DRY:
/*  93 */             value += SereneSeasonsUtil.getSeasonModifier(Config.Baked.ssMidSpringModifier, Config.Baked.ssLateSpringModifier, Config.Baked.ssEarlySummerModifier, timeInSubSeason, seasonState.getSubSeasonDuration());
/*     */             break;
/*     */           case EARLY_WET:
/*  96 */             value += SereneSeasonsUtil.getSeasonModifier(Config.Baked.ssLateSpringModifier, Config.Baked.ssEarlySummerModifier, Config.Baked.ssMidSummerModifier, timeInSubSeason, seasonState.getSubSeasonDuration());
/*     */             break;
/*     */           case MID_WET:
/*  99 */             value += SereneSeasonsUtil.getSeasonModifier(Config.Baked.ssEarlySummerModifier, Config.Baked.ssMidSummerModifier, Config.Baked.ssLateSummerModifier, timeInSubSeason, seasonState.getSubSeasonDuration());
/*     */             break;
/*     */           case LATE_WET:
/* 102 */             value += SereneSeasonsUtil.getSeasonModifier(Config.Baked.ssMidSummerModifier, Config.Baked.ssLateSummerModifier, Config.Baked.ssEarlyAutumnModifier, timeInSubSeason, seasonState.getSubSeasonDuration());
/*     */             break;
/*     */           case null:
/* 105 */             value += SereneSeasonsUtil.getSeasonModifier(Config.Baked.ssLateSummerModifier, Config.Baked.ssEarlyAutumnModifier, Config.Baked.ssMidAutumnModifier, timeInSubSeason, seasonState.getSubSeasonDuration());
/*     */             break;
/*     */           case null:
/* 108 */             value += SereneSeasonsUtil.getSeasonModifier(Config.Baked.ssEarlyAutumnModifier, Config.Baked.ssMidAutumnModifier, Config.Baked.ssLateAutumnModifier, timeInSubSeason, seasonState.getSubSeasonDuration());
/*     */             break;
/*     */           case null:
/* 111 */             value += SereneSeasonsUtil.getSeasonModifier(Config.Baked.ssMidAutumnModifier, Config.Baked.ssLateAutumnModifier, Config.Baked.ssEarlyWinterModifier, timeInSubSeason, seasonState.getSubSeasonDuration());
/*     */             break;
/*     */           case null:
/* 114 */             value += SereneSeasonsUtil.getSeasonModifier(Config.Baked.ssLateAutumnModifier, Config.Baked.ssEarlyWinterModifier, Config.Baked.ssMidWinterModifier, timeInSubSeason, seasonState.getSubSeasonDuration());
/*     */             break;
/*     */           case null:
/* 117 */             value += SereneSeasonsUtil.getSeasonModifier(Config.Baked.ssEarlyWinterModifier, Config.Baked.ssMidWinterModifier, Config.Baked.ssLateWinterModifier, timeInSubSeason, seasonState.getSubSeasonDuration());
/*     */             break;
/*     */           case null:
/* 120 */             value += SereneSeasonsUtil.getSeasonModifier(Config.Baked.ssMidWinterModifier, Config.Baked.ssLateWinterModifier, Config.Baked.ssEarlySpringModifier, timeInSubSeason, seasonState.getSubSeasonDuration());
/*     */             break;
/*     */         } 
/*     */       
/*     */       } else {
/* 125 */         int timeInSubSeason = (seasonState.getSeasonCycleTicks() + seasonState.getSubSeasonDuration()) % seasonState.getSubSeasonDuration() * 2;
/* 126 */         targetUndergroundTemperature = SereneSeasonsUtil.averageTropicalSeasonTemperature;
/* 127 */         switch (seasonState.getTropicalSeason()) {
/*     */           
/*     */           case EARLY_DRY:
/* 130 */             value += SereneSeasonsUtil.getSeasonModifier(Config.Baked.ssLateWetSeasonModifier, Config.Baked.ssEarlyDrySeasonModifier, Config.Baked.ssMidDrySeasonModifier, timeInSubSeason, seasonState.getSubSeasonDuration() * 2);
/*     */             break;
/*     */           case MID_DRY:
/* 133 */             value += SereneSeasonsUtil.getSeasonModifier(Config.Baked.ssEarlyDrySeasonModifier, Config.Baked.ssMidDrySeasonModifier, Config.Baked.ssLateDrySeasonModifier, timeInSubSeason, seasonState.getSubSeasonDuration() * 2);
/*     */             break;
/*     */           case LATE_DRY:
/* 136 */             value += SereneSeasonsUtil.getSeasonModifier(Config.Baked.ssMidDrySeasonModifier, Config.Baked.ssLateDrySeasonModifier, Config.Baked.ssEarlyWetSeasonModifier, timeInSubSeason, seasonState.getSubSeasonDuration() * 2);
/*     */             break;
/*     */           case EARLY_WET:
/* 139 */             value += SereneSeasonsUtil.getSeasonModifier(Config.Baked.ssLateDrySeasonModifier, Config.Baked.ssEarlyWetSeasonModifier, Config.Baked.ssMidWetSeasonModifier, timeInSubSeason, seasonState.getSubSeasonDuration() * 2);
/*     */             break;
/*     */           case MID_WET:
/* 142 */             value += SereneSeasonsUtil.getSeasonModifier(Config.Baked.ssEarlyWetSeasonModifier, Config.Baked.ssMidWetSeasonModifier, Config.Baked.ssLateWetSeasonModifier, timeInSubSeason, seasonState.getSubSeasonDuration() * 2);
/*     */             break;
/*     */           case LATE_WET:
/* 145 */             value += SereneSeasonsUtil.getSeasonModifier(Config.Baked.ssMidWetSeasonModifier, Config.Baked.ssLateWetSeasonModifier, Config.Baked.ssEarlyDrySeasonModifier, timeInSubSeason, seasonState.getSubSeasonDuration() * 2);
/*     */             break;
/*     */         } 
/*     */       
/*     */       } 
/*     */     } 
/* 151 */     value = (validSpot == 0) ? 0.0F : (value / validSpot);
/*     */     
/* 153 */     return applyUndergroundEffect(value, level, pos, (float)targetUndergroundTemperature);
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\sereneseasons\SereneSeasonsModifier.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */