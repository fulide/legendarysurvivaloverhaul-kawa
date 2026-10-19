/*    */ package sfiomn.legendarysurvivaloverhaul.common.integration.terrafirmacraft;
/*    */ 
/*    */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TerraFirmaCraftUtil
/*    */ {
/*    */   public static boolean shouldUseTerraFirmaCraftTemp() {
/* 11 */     return (LegendarySurvivalOverhaul.terraFirmaCraftLoaded && Config.Baked.tfcTemperatureMultiplier != 0.0D);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\terrafirmacraft\TerraFirmaCraftUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */