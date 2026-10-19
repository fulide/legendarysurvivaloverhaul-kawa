/*     */ package sfiomn.legendarysurvivaloverhaul.common.integration.eclipticseasons;
/*     */ 
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.biome.Biome;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class EclipticSeasonsCompat
/*     */ {
/*     */   private static final String API_CLASS = "com.teamtea.eclipticseasons.api.EclipticSeasonsApi";
/*     */   
/*     */   private static Object apiInstance() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
/*  25 */     Class<?> api = Class.forName("com.teamtea.eclipticseasons.api.EclipticSeasonsApi");
/*  26 */     Method getInstance = api.getMethod("getInstance", new Class[0]);
/*  27 */     return getInstance.invoke(null, new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isSeasonEnabled(Level level) {
/*     */     try {
/*  34 */       Object api = apiInstance();
/*  35 */       Method m = api.getClass().getMethod("isSeasonEnabled", new Class[] { Level.class });
/*  36 */       Object res = m.invoke(api, new Object[] { level });
/*  37 */       if (res instanceof Boolean) { Boolean b = (Boolean)res; if (b.booleanValue()); }  return false;
/*  38 */     } catch (Throwable t) {
/*     */       
/*  40 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object getSolarTerm(Level level) {
/*     */     try {
/*  48 */       Object api = apiInstance();
/*  49 */       Method m = api.getClass().getMethod("getSolarTerm", new Class[] { Level.class });
/*  50 */       return m.invoke(api, new Object[] { level });
/*  51 */     } catch (Throwable t) {
/*     */       
/*  53 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isSolarTermNone(Level level) {
/*  59 */     Object term = getSolarTerm(level);
/*  60 */     if (term == null) return true;
/*     */ 
/*     */     
/*     */     try {
/*  64 */       Method name = term.getClass().getMethod("name", new Class[0]);
/*  65 */       Object n = name.invoke(term, new Object[0]);
/*  66 */       return "NONE".equals(String.valueOf(n));
/*  67 */     } catch (Throwable t) {
/*     */       
/*  69 */       return true;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getSolarTermDayTime(Level level) {
/*  75 */     Object term = getSolarTerm(level);
/*  76 */     if (term == null) return 12000;
/*     */     
/*     */     try {
/*  79 */       Method m = term.getClass().getMethod("getDayTime", new Class[0]);
/*  80 */       Object res = m.invoke(term, new Object[0]);
/*  81 */       Number n = (Number)res; return (res instanceof Number) ? n.intValue() : 12000;
/*  82 */     } catch (Throwable t) {
/*     */       
/*  84 */       return 12000;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getLastingDaysOfEachTerm(Level level) {
/*     */     try {
/*  92 */       Object api = apiInstance();
/*  93 */       Method m = api.getClass().getMethod("getLastingDaysOfEachTerm", new Class[] { Level.class });
/*  94 */       Object res = m.invoke(api, new Object[] { level });
/*  95 */       Number n = (Number)res; return (res instanceof Number) ? n.intValue() : 0;
/*  96 */     } catch (Throwable t) {
/*     */       
/*  98 */       return 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static double getSolarDays(Level level) {
/*     */     try {
/* 106 */       Object api = apiInstance();
/* 107 */       Method m = api.getClass().getMethod("getSolarDays", new Class[] { Level.class });
/* 108 */       Object res = m.invoke(api, new Object[] { level });
/* 109 */       Number n = (Number)res; return (res instanceof Number) ? n.doubleValue() : 0.0D;
/* 110 */     } catch (Throwable t) {
/*     */       
/* 112 */       return 0.0D;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static float getTimeInTerm(Level level) {
/*     */     try {
/* 120 */       Object api = apiInstance();
/* 121 */       Method m = api.getClass().getMethod("getTimeInTerm", new Class[] { Level.class });
/* 122 */       Object res = m.invoke(api, new Object[] { level });
/* 123 */       Number n = (Number)res; return (res instanceof Number) ? n.floatValue() : 0.0F;
/* 124 */     } catch (Throwable t) {
/*     */       
/* 126 */       return 0.0F;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Biome.Precipitation getCurrentPrecipitationAt(Level level, BlockPos pos) {
/*     */     try {
/* 134 */       Object api = apiInstance();
/* 135 */       Method m = api.getClass().getMethod("getCurrentPrecipitationAt", new Class[] { Level.class, BlockPos.class });
/* 136 */       Object res = m.invoke(api, new Object[] { level, pos });
/* 137 */       return (Biome.Precipitation)res;
/* 138 */     } catch (Throwable t) {
/*     */       
/* 140 */       return Biome.Precipitation.NONE;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getSolarTermOrdinal(Level level) {
/* 146 */     Object term = getSolarTerm(level);
/* 147 */     if (term == null) return 0;
/*     */     
/*     */     try {
/* 150 */       Method m = term.getClass().getMethod("ordinal", new Class[0]);
/* 151 */       Object res = m.invoke(term, new Object[0]);
/* 152 */       Number n = (Number)res; return (res instanceof Number) ? n.intValue() : 0;
/* 153 */     } catch (Throwable t) {
/*     */       
/* 155 */       return 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static Component getSolarTermTranslation(Level level) {
/* 161 */     Object term = getSolarTerm(level);
/* 162 */     if (term == null) return (Component)Component.empty();
/*     */     
/*     */     try {
/* 165 */       Method m = term.getClass().getMethod("getTranslation", new Class[0]);
/* 166 */       Object res = m.invoke(term, new Object[0]);
/* 167 */       return (Component)res;
/* 168 */     } catch (Throwable t) {
/*     */       
/* 170 */       return (Component)Component.empty();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static Component getSeasonTranslation(Level level) {
/* 176 */     Object term = getSolarTerm(level);
/* 177 */     if (term == null) return (Component)Component.empty();
/*     */     
/*     */     try {
/* 180 */       Method getSeason = term.getClass().getMethod("getSeason", new Class[0]);
/* 181 */       Object season = getSeason.invoke(term, new Object[0]);
/* 182 */       if (season == null) return (Component)Component.empty(); 
/* 183 */       Method getTranslation = season.getClass().getMethod("getTranslation", new Class[0]);
/* 184 */       Object res = getTranslation.invoke(season, new Object[0]);
/* 185 */       return (Component)res;
/* 186 */     } catch (Throwable t) {
/*     */       
/* 188 */       return (Component)Component.empty();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\eclipticseasons\EclipticSeasonsCompat.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */