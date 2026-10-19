/*    */ package sfiomn.legendarysurvivaloverhaul.common.integration.jsonConfig;
/*    */ 
/*    */ import com.google.common.collect.Maps;
/*    */ import java.util.Map;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.temperature.JsonTemperatureResistance;
/*    */ 
/*    */ 
/*    */ public class JsonIntegrationConfig
/*    */ {
/* 10 */   public static Map<String, JsonTemperatureResistance> originsTemperatures = Maps.newHashMap();
/* 11 */   public static Map<String, JsonTemperatureResistance> defaultOriginsTemperatures = Maps.newHashMap();
/*    */ 
/*    */   
/*    */   public static void registerDefaultOriginsTemperature(String registryName, float temperature, float heatResistance, float coldResistance, float thermalResistance) {
/* 15 */     if (!defaultOriginsTemperatures.containsKey(registryName)) {
/* 16 */       defaultOriginsTemperatures.put(registryName, new JsonTemperatureResistance(temperature, heatResistance, coldResistance, thermalResistance));
/*    */     }
/*    */   }
/*    */   
/*    */   public static void registerOriginsTemperature(String registryName, float temperature, float heatResistance, float coldResistance, float thermalResistance) {
/* 21 */     if (!originsTemperatures.containsKey(registryName))
/* 22 */       originsTemperatures.put(registryName, new JsonTemperatureResistance(temperature, heatResistance, coldResistance, thermalResistance)); 
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\jsonConfig\JsonIntegrationConfig.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */