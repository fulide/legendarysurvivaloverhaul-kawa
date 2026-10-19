/*    */ package sfiomn.legendarysurvivaloverhaul.config;
/*    */ import com.google.gson.reflect.TypeToken;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.bodydamage.JsonBodyPartsDamageSource;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.bodydamage.JsonConsumableHeal;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.temperature.JsonBiomeIdentity;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.temperature.JsonBlockFluidTemperature;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.temperature.JsonConsumableTemperature;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.temperature.JsonFuelItem;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.temperature.JsonTemperature;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.temperature.JsonTemperatureResistance;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.thirst.JsonBlockFluidThirst;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.thirst.JsonConsumableThirst;
/*    */ 
/*    */ public class JsonTypeToken {
/*    */   public static Type get(JsonFileName jcfn) {
/* 18 */     switch (jcfn) {
/*    */       
/*    */       case DIMENSION_TEMP:
/* 21 */         return (new TypeToken<Map<String, JsonTemperature>>() {
/*    */           
/* 23 */           }).getType();
/*    */       case BIOME_TEMP:
/* 25 */         return (new TypeToken<Map<String, JsonBiomeIdentity>>() {
/*    */           
/* 27 */           }).getType();
/*    */       case ITEM_TEMP:
/* 29 */         return (new TypeToken<Map<String, JsonTemperatureResistance>>() {
/*    */           
/* 31 */           }).getType();
/*    */       case ENTITY_TEMP:
/* 33 */         return (new TypeToken<Map<String, JsonTemperature>>() {
/*    */           
/* 35 */           }).getType();
/*    */       case BLOCK_TEMP:
/* 37 */         return (new TypeToken<Map<String, List<JsonBlockFluidTemperature>>>() {
/*    */           
/* 39 */           }).getType();
/*    */       case ORIGINS_TEMP:
/* 41 */         return (new TypeToken<Map<String, JsonTemperatureResistance>>() {
/*    */           
/* 43 */           }).getType();
/*    */       case FUEL:
/* 45 */         return (new TypeToken<Map<String, JsonFuelItem>>() {
/*    */           
/* 47 */           }).getType();
/*    */       case CONSUMABLE_TEMP:
/* 49 */         return (new TypeToken<Map<String, List<JsonConsumableTemperature>>>() {
/*    */           
/* 51 */           }).getType();
/*    */       case BLOCK_THIRST:
/* 53 */         return (new TypeToken<Map<String, List<JsonBlockFluidThirst>>>() {
/*    */           
/* 55 */           }).getType();
/*    */       case CONSUMABLE_THIRST:
/* 57 */         return (new TypeToken<Map<String, List<JsonConsumableThirst>>>() {
/*    */           
/* 59 */           }).getType();
/*    */       case CONSUMABLE_HEAL:
/* 61 */         return (new TypeToken<Map<String, JsonConsumableHeal>>() {
/*    */           
/* 63 */           }).getType();
/*    */       case DAMAGE_SOURCE_BODY_PARTS:
/* 65 */         return (new TypeToken<Map<String, JsonBodyPartsDamageSource>>() {
/*    */           
/* 67 */           }).getType();
/*    */     } 
/* 69 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\config\JsonTypeToken.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */