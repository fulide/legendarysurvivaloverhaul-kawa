/*    */ package sfiomn.legendarysurvivaloverhaul.common.integration.terrafirmacraft;
/*    */ 
/*    */ import net.dries007.tfc.common.component.heat.HeatCapability;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureResistance;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.AttributeModifierBase;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ import sfiomn.legendarysurvivaloverhaul.util.MathUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TerraFirmaCraftHeatItemModifier
/*    */   extends AttributeModifierBase
/*    */ {
/*    */   private static float getUncaughtTemperature(ItemStack stack) {
/* 21 */     return (float)(HeatCapability.getTemperature(stack) * Config.Baked.tfcItemHeatMultiplier);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public JsonTemperatureResistance getItemAttributes(ItemStack stack) {
/* 27 */     JsonTemperatureResistance config = new JsonTemperatureResistance();
/*    */     
/* 29 */     if (!LegendarySurvivalOverhaul.terraFirmaCraftLoaded) {
/* 30 */       return config;
/*    */     }
/* 32 */     if (Config.Baked.tfcItemHeatMultiplier == 0.0D) {
/* 33 */       return config;
/*    */     }
/*    */     
/*    */     try {
/* 37 */       config.temperature = MathUtil.round(getUncaughtTemperature(stack), 1);
/*    */ 
/*    */       
/* 40 */       return config;
/* 41 */     } catch (Exception e) {
/*    */ 
/*    */       
/* 44 */       LegendarySurvivalOverhaul.LOGGER.error("An error has occurred with TerraFirmaCraft compatibility, disabling integration", e);
/* 45 */       LegendarySurvivalOverhaul.terraFirmaCraftLoaded = false;
/*    */       
/* 47 */       return config;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\terrafirmacraft\TerraFirmaCraftHeatItemModifier.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */