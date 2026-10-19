/*    */ package sfiomn.legendarysurvivaloverhaul.common.integration.jsonConfig;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.util.Map;
/*    */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.temperature.JsonTemperatureResistance;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.JsonFileName;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.json_old.JsonConfigRegistration;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JsonIntegrationConfigRegistration
/*    */ {
/*    */   public static void init(File configDir) {
/* 16 */     registerIntegrationDefaults(configDir);
/*    */     
/* 18 */     processAllIntegrationsJson(configDir);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void registerIntegrationDefaults(File configDir) {
/* 26 */     if (LegendarySurvivalOverhaul.originsLoaded) {
/*    */       
/* 28 */       JsonIntegrationConfig.registerDefaultOriginsTemperature("origins:blazeborn", -5.0F, 15.0F, -2.0F, 0.0F);
/* 29 */       JsonIntegrationConfig.registerDefaultOriginsTemperature("origins:merling", 0.0F, 0.0F, 3.0F, 0.0F);
/* 30 */       JsonIntegrationConfig.registerDefaultOriginsTemperature("origins:arachnid", 0.0F, -5.0F, 0.0F, 0.0F);
/* 31 */       JsonIntegrationConfig.registerDefaultOriginsTemperature("origins:feline", 0.0F, 0.0F, 0.0F, 2.0F);
/* 32 */       JsonIntegrationConfig.registerDefaultOriginsTemperature("origins:enderian", 0.0F, 0.0F, 10.0F, 0.0F);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void writeAllIntegrationsToJson(File jsonDir) {
/* 38 */     if (LegendarySurvivalOverhaul.originsLoaded) {
/* 39 */       JsonConfigRegistration.manuallyWriteToJson(JsonFileName.ORIGINS_TEMP, JsonIntegrationConfig.originsTemperatures, jsonDir);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void deleteAllIntegrationsJson(File jsonDir) {
/* 44 */     JsonConfigRegistration.deleteJson(JsonFileName.ORIGINS_TEMP, jsonDir);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void processAllIntegrationsJson(File jsonDir) {
/* 50 */     Map<String, JsonTemperatureResistance> jsonOriginsTemperatures = (Map<String, JsonTemperatureResistance>)JsonConfigRegistration.processJson(JsonFileName.ORIGINS_TEMP, jsonDir);
/*    */     
/* 52 */     if (jsonOriginsTemperatures != null) {
/*    */ 
/*    */ 
/*    */       
/* 56 */       LegendarySurvivalOverhaul.LOGGER.debug("Loaded " + jsonOriginsTemperatures.size() + " origins temperature values from JSON");
/* 57 */       for (Map.Entry<String, JsonTemperatureResistance> entry : jsonOriginsTemperatures.entrySet())
/*    */       {
/* 59 */         JsonIntegrationConfig.registerOriginsTemperature(entry.getKey(), ((JsonTemperatureResistance)entry.getValue()).temperature, ((JsonTemperatureResistance)entry.getValue()).heatResistance, ((JsonTemperatureResistance)entry.getValue()).coldResistance, ((JsonTemperatureResistance)entry.getValue()).thermalResistance);
/*    */       }
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\jsonConfig\JsonIntegrationConfigRegistration.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */