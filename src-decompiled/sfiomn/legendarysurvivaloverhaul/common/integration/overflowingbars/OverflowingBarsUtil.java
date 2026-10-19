/*    */ package sfiomn.legendarysurvivaloverhaul.common.integration.overflowingbars;
/*    */ 
/*    */ import fuzs.overflowingbars.OverflowingBars;
/*    */ import fuzs.overflowingbars.config.ClientConfig;
/*    */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OverflowingBarsUtil
/*    */ {
/*    */   public static boolean isHealthBarOverflowing() {
/* 13 */     return (LegendarySurvivalOverhaul.overflowingbarsLoaded && ((ClientConfig)OverflowingBars.CONFIG.get(ClientConfig.class)).health.allowLayers);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\overflowingbars\OverflowingBarsUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */