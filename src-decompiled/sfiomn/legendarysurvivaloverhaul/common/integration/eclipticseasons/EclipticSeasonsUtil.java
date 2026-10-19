/*     */ package sfiomn.legendarysurvivaloverhaul.common.integration.eclipticseasons;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.biome.Biome;
/*     */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.MathUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EclipticSeasonsUtil
/*     */ {
/*     */   public static double averageSeasonTemperature;
/*     */   
/*     */   public static void initAverageTemperatures() {
/*  19 */     averageSeasonTemperature = 0.0D;
/*  20 */     List<List<? extends Double>> seasonsValues = List.of(Config.Baked.esAutumnModifier, Config.Baked.esSpringModifier, Config.Baked.esWinterModifier, Config.Baked.esSummerModifier);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  26 */     for (List<? extends Double> seasonValues : seasonsValues) {
/*     */       
/*  28 */       for (Double seasonValue : seasonValues)
/*  29 */         averageSeasonTemperature += seasonValue.doubleValue(); 
/*     */     } 
/*  31 */     averageSeasonTemperature /= (Config.Baked.esAutumnModifier
/*  32 */       .size() + Config.Baked.esSpringModifier
/*  33 */       .size() + Config.Baked.esWinterModifier
/*  34 */       .size() + Config.Baked.esSummerModifier
/*  35 */       .size());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double getSeasonModifier(int index) {
/*     */     // Byte code:
/*     */     //   0: iload_0
/*     */     //   1: bipush #24
/*     */     //   3: iadd
/*     */     //   4: bipush #24
/*     */     //   6: irem
/*     */     //   7: istore_0
/*     */     //   8: iload_0
/*     */     //   9: bipush #6
/*     */     //   11: idiv
/*     */     //   12: tableswitch default -> 68, 0 -> 44, 1 -> 50, 2 -> 56, 3 -> 62
/*     */     //   44: getstatic sfiomn/legendarysurvivaloverhaul/config/Config$Baked.esSpringModifier : Ljava/util/List;
/*     */     //   47: goto -> 82
/*     */     //   50: getstatic sfiomn/legendarysurvivaloverhaul/config/Config$Baked.esSummerModifier : Ljava/util/List;
/*     */     //   53: goto -> 82
/*     */     //   56: getstatic sfiomn/legendarysurvivaloverhaul/config/Config$Baked.esAutumnModifier : Ljava/util/List;
/*     */     //   59: goto -> 82
/*     */     //   62: getstatic sfiomn/legendarysurvivaloverhaul/config/Config$Baked.esWinterModifier : Ljava/util/List;
/*     */     //   65: goto -> 82
/*     */     //   68: new java/lang/IllegalStateException
/*     */     //   71: dup
/*     */     //   72: iload_0
/*     */     //   73: <illegal opcode> makeConcatWithConstants : (I)Ljava/lang/String;
/*     */     //   78: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   81: athrow
/*     */     //   82: astore_1
/*     */     //   83: aload_1
/*     */     //   84: invokeinterface size : ()I
/*     */     //   89: bipush #6
/*     */     //   91: if_icmpge -> 98
/*     */     //   94: dconst_0
/*     */     //   95: goto -> 114
/*     */     //   98: aload_1
/*     */     //   99: iload_0
/*     */     //   100: bipush #6
/*     */     //   102: irem
/*     */     //   103: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   108: checkcast java/lang/Double
/*     */     //   111: invokevirtual doubleValue : ()D
/*     */     //   114: dreturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #40	-> 0
/*     */     //   #41	-> 8
/*     */     //   #43	-> 44
/*     */     //   #44	-> 50
/*     */     //   #45	-> 56
/*     */     //   #46	-> 62
/*     */     //   #47	-> 68
/*     */     //   #49	-> 83
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	115	0	index	I
/*     */     //   83	32	1	listConfigValue	Ljava/util/List;
/*     */     // Local variable type table:
/*     */     //   start	length	slot	name	signature
/*     */     //   83	32	1	listConfigValue	Ljava/util/List<+Ljava/lang/Double;>;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float getBlendedSeasonModifier(double previousSeasonModifier, double currentSeasonModifier, double nextSeasonModifier, int time, int subSeasonDuration) {
/*  54 */     if (time < subSeasonDuration / 2) {
/*  55 */       return calculateSinusoidalBetweenSeasons(previousSeasonModifier, currentSeasonModifier, time + subSeasonDuration / 2, subSeasonDuration);
/*     */     }
/*  57 */     return calculateSinusoidalBetweenSeasons(currentSeasonModifier, nextSeasonModifier, time - subSeasonDuration / 2, subSeasonDuration);
/*     */   }
/*     */ 
/*     */   
/*     */   public static float calculateSinusoidalBetweenSeasons(double previousSeasonModifier, double nextSeasonModifier, int time, int subSeasonDuration) {
/*  62 */     double tempDiff = nextSeasonModifier - previousSeasonModifier;
/*     */     
/*  64 */     double seasonModifier = (Math.sin(time * Math.PI / subSeasonDuration - 1.5707963267948966D) + 1.0D) * tempDiff / 2.0D + previousSeasonModifier;
/*  65 */     return MathUtil.round((float)seasonModifier, 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean hasDimensionSeason(Level level) {
/*  70 */     return (LegendarySurvivalOverhaul.eclipticSeasonsLoaded && EclipticSeasonsCompat.isSeasonEnabled(level));
/*     */   }
/*     */ 
/*     */   
/*     */   public static long getSunRiseTime(Level level) {
/*  75 */     if (!LegendarySurvivalOverhaul.eclipticSeasonsLoaded || !hasDimensionSeason(level)) {
/*  76 */       return 6000L;
/*     */     }
/*  78 */     return (30000L - EclipticSeasonsCompat.getSolarTermDayTime(level) / 2L) % 24000L;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Biome.Precipitation getPrecipitation(Level level, BlockPos pos) {
/*  83 */     if (!LegendarySurvivalOverhaul.eclipticSeasonsLoaded) {
/*  84 */       return Biome.Precipitation.NONE;
/*     */     }
/*  86 */     return EclipticSeasonsCompat.getCurrentPrecipitationAt(level, pos);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getDayDuration(Level level) {
/*  91 */     if (!LegendarySurvivalOverhaul.eclipticSeasonsLoaded) {
/*  92 */       return 12000;
/*     */     }
/*  94 */     return EclipticSeasonsCompat.getSolarTermDayTime(level);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getDaysInSolarTerm(Level level) {
/*  99 */     if (!LegendarySurvivalOverhaul.eclipticSeasonsLoaded) {
/* 100 */       return 0;
/*     */     }
/* 102 */     return EclipticSeasonsCompat.getLastingDaysOfEachTerm(level);
/*     */   }
/*     */ 
/*     */   
/*     */   public static double getDayInSeasonCycle(Level level) {
/* 107 */     if (!LegendarySurvivalOverhaul.eclipticSeasonsLoaded) {
/* 108 */       return 0.0D;
/*     */     }
/*     */     
/* 111 */     return EclipticSeasonsCompat.getSolarDays(level) / (24.0F * getDaysInSolarTerm(level));
/*     */   }
/*     */ 
/*     */   
/*     */   public static Component seasonTooltip(Level level) {
/* 116 */     if (!LegendarySurvivalOverhaul.eclipticSeasonsLoaded)
/* 117 */       return (Component)Component.empty(); 
/* 118 */     if (EclipticSeasonsCompat.isSolarTermNone(level) || !hasDimensionSeason(level)) {
/* 119 */       return (Component)Component.translatable("message.legendarysurvivaloverhaul.eclipticseasons.no_season_dimension");
/*     */     }
/* 121 */     return (Component)Component.translatable("message.legendarysurvivaloverhaul.eclipticseasons.season_info", new Object[] {
/* 122 */           EclipticSeasonsCompat.getSolarTermTranslation(level), 
/* 123 */           EclipticSeasonsCompat.getSeasonTranslation(level), 
/* 124 */           Float.valueOf(EclipticSeasonsCompat.getTimeInTerm(level)), 
/* 125 */           Integer.valueOf(getDaysInSolarTerm(level))
/*     */         });
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\eclipticseasons\EclipticSeasonsUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */