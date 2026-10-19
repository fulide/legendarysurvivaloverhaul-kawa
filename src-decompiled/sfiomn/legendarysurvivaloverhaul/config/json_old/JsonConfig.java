/*     */ package sfiomn.legendarysurvivaloverhaul.config.json_old;
/*     */ import com.google.common.collect.Maps;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.block.ThermalTypeEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.BodyPartEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.DamageDistributionEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.JsonPropertyValue;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.bodydamage.JsonBodyPartsDamageSource;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.bodydamage.JsonConsumableHeal;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.temperature.JsonBiomeIdentity;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.temperature.JsonBlockFluidTemperature;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.temperature.JsonConsumableTemperature;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.temperature.JsonTemperature;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.temperature.JsonTemperatureResistance;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.thirst.JsonBlockFluidThirst;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.thirst.JsonConsumableThirst;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.thirst.JsonEffectParameter;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemporaryModifierGroupEnum;
/*     */ 
/*     */ public class JsonConfig {
/*  24 */   public static Map<String, JsonTemperature> dimensionTemperatures = Maps.newHashMap();
/*  25 */   public static Map<String, JsonTemperature> defaultDimensionTemperatures = Maps.newHashMap();
/*  26 */   public static Map<String, JsonBiomeIdentity> biomeOverrides = Maps.newHashMap();
/*  27 */   public static Map<String, JsonBiomeIdentity> defaultBiomeOverrides = Maps.newHashMap();
/*  28 */   public static Map<String, JsonTemperatureResistance> itemTemperatures = Maps.newHashMap();
/*  29 */   public static Map<String, JsonTemperatureResistance> defaultItemTemperatures = Maps.newHashMap();
/*  30 */   public static Map<String, List<JsonBlockFluidTemperature>> blockFluidTemperatures = Maps.newHashMap();
/*  31 */   public static Map<String, List<JsonBlockFluidTemperature>> defaultBlockFluidTemperatures = Maps.newHashMap();
/*  32 */   public static Map<String, JsonTemperature> entityTemperatures = Maps.newHashMap();
/*  33 */   public static Map<String, JsonTemperature> defaultEntityTemperatures = Maps.newHashMap();
/*  34 */   public static Map<String, JsonFuelItem> fuelItems = Maps.newHashMap();
/*  35 */   public static Map<String, JsonFuelItem> defaultFuelItems = Maps.newHashMap();
/*  36 */   public static Map<String, List<JsonBlockFluidThirst>> blockFluidThirst = Maps.newHashMap();
/*  37 */   public static Map<String, List<JsonBlockFluidThirst>> defaultBlockFluidThirst = Maps.newHashMap();
/*  38 */   public static Map<String, List<JsonConsumableTemperature>> consumableTemperature = Maps.newHashMap();
/*  39 */   public static Map<String, List<JsonConsumableTemperature>> defaultConsumableTemperature = Maps.newHashMap();
/*  40 */   public static Map<String, List<JsonConsumableThirst>> consumableThirst = Maps.newHashMap();
/*  41 */   public static Map<String, List<JsonConsumableThirst>> defaultConsumableThirst = Maps.newHashMap();
/*  42 */   public static Map<String, JsonConsumableHeal> consumableHeal = Maps.newHashMap();
/*  43 */   public static Map<String, JsonConsumableHeal> defaultConsumableHeal = Maps.newHashMap();
/*  44 */   public static Map<String, JsonBodyPartsDamageSource> damageSourceBodyParts = Maps.newHashMap();
/*  45 */   public static Map<String, JsonBodyPartsDamageSource> defaultDamageSourceBodyParts = Maps.newHashMap();
/*     */ 
/*     */ 
/*     */   
/*     */   public static void registerDefaultDimensionTemperature(String registryName, float temperature) {
/*  50 */     if (!defaultDimensionTemperatures.containsKey(registryName)) {
/*  51 */       defaultDimensionTemperatures.put(registryName, new JsonTemperature(temperature));
/*     */     }
/*     */   }
/*     */   
/*     */   public static void registerDimensionTemperature(String registryName, float temperature) {
/*  56 */     if (!dimensionTemperatures.containsKey(registryName)) {
/*  57 */       dimensionTemperatures.put(registryName, new JsonTemperature(temperature));
/*     */     }
/*     */   }
/*     */   
/*     */   public static void registerDefaultBiomeOverride(String registryName, float temperature) {
/*  62 */     registerDefaultBiomeOverride(registryName, temperature, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerDefaultBiomeOverride(String registryName, float temperature, boolean isDry) {
/*  67 */     if (!defaultBiomeOverrides.containsKey(registryName)) {
/*  68 */       defaultBiomeOverrides.put(registryName, new JsonBiomeIdentity(temperature, isDry));
/*     */     }
/*     */   }
/*     */   
/*     */   public static void registerBiomeOverride(String registryName, float temperature) {
/*  73 */     registerBiomeOverride(registryName, temperature, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerBiomeOverride(String registryName, float temperature, boolean isDry) {
/*  78 */     if (!biomeOverrides.containsKey(registryName)) {
/*  79 */       biomeOverrides.put(registryName, new JsonBiomeIdentity(temperature, isDry));
/*     */     }
/*     */   }
/*     */   
/*     */   public static void registerDefaultBlockFluidTemperature(String registryName, float temperature, JsonPropertyValue... properties) {
/*  84 */     if (!defaultBlockFluidTemperatures.containsKey(registryName)) {
/*  85 */       defaultBlockFluidTemperatures.put(registryName, new ArrayList<>());
/*     */     }
/*  87 */     List<JsonBlockFluidTemperature> alreadyDefinedConfig = defaultBlockFluidTemperatures.get(registryName);
/*     */     
/*  89 */     JsonBlockFluidTemperature newBlockFluidTemp = new JsonBlockFluidTemperature(temperature, properties);
/*     */     
/*  91 */     if (properties.length > 0) {
/*     */ 
/*     */       
/*  94 */       for (int i = 0; i < alreadyDefinedConfig.size(); i++) {
/*     */         
/*  96 */         JsonBlockFluidTemperature jpt = alreadyDefinedConfig.get(i);
/*  97 */         if (jpt.matchesProperties(properties)) {
/*     */           
/*  99 */           alreadyDefinedConfig.set(i, newBlockFluidTemp);
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 106 */       for (JsonBlockFluidTemperature jpt : alreadyDefinedConfig) {
/*     */         
/* 108 */         if (!jpt.properties.isEmpty()) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 114 */       for (int i = 0; i < alreadyDefinedConfig.size(); i++) {
/*     */         
/* 116 */         JsonBlockFluidTemperature jpt = alreadyDefinedConfig.get(i);
/* 117 */         if (jpt.properties.isEmpty()) {
/*     */           
/* 119 */           alreadyDefinedConfig.set(i, newBlockFluidTemp);
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/* 124 */     alreadyDefinedConfig.add(newBlockFluidTemp);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerBlockFluidTemperature(String registryName, float temperature, JsonPropertyValue... properties) {
/* 129 */     if (!blockFluidTemperatures.containsKey(registryName)) {
/* 130 */       blockFluidTemperatures.put(registryName, new ArrayList<>());
/*     */     }
/* 132 */     List<JsonBlockFluidTemperature> alreadyDefinedConfig = blockFluidTemperatures.get(registryName);
/*     */     
/* 134 */     JsonBlockFluidTemperature newBlockFluidTemp = new JsonBlockFluidTemperature(temperature, properties);
/*     */     
/* 136 */     if (properties.length > 0) {
/*     */ 
/*     */       
/* 139 */       for (int i = 0; i < alreadyDefinedConfig.size(); i++) {
/*     */         
/* 141 */         JsonBlockFluidTemperature jpt = alreadyDefinedConfig.get(i);
/* 142 */         if (jpt.matchesProperties(properties)) {
/*     */           
/* 144 */           alreadyDefinedConfig.set(i, newBlockFluidTemp);
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 151 */       for (JsonBlockFluidTemperature jpt : alreadyDefinedConfig) {
/*     */         
/* 153 */         if (!jpt.properties.isEmpty()) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 159 */       for (int i = 0; i < alreadyDefinedConfig.size(); i++) {
/*     */         
/* 161 */         JsonBlockFluidTemperature jpt = alreadyDefinedConfig.get(i);
/* 162 */         if (jpt.properties.isEmpty()) {
/*     */           
/* 164 */           alreadyDefinedConfig.set(i, newBlockFluidTemp);
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/* 169 */     alreadyDefinedConfig.add(newBlockFluidTemp);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerDefaultFuelItems(String registryName, ThermalTypeEnum thermalType, int fuelValue) {
/* 174 */     if (!defaultFuelItems.containsKey(registryName)) {
/* 175 */       defaultFuelItems.put(registryName, new JsonFuelItem(thermalType, fuelValue));
/*     */     }
/*     */   }
/*     */   
/*     */   public static void registerFuelItems(String registryName, ThermalTypeEnum thermalType, int fuelValue) {
/* 180 */     if (!fuelItems.containsKey(registryName)) {
/* 181 */       fuelItems.put(registryName, new JsonFuelItem(thermalType, fuelValue));
/*     */     }
/*     */   }
/*     */   
/*     */   public static void registerDefaultItemTemperature(String registryName, float temperature) {
/* 186 */     if (!defaultItemTemperatures.containsKey(registryName)) {
/* 187 */       defaultItemTemperatures.put(registryName, new JsonTemperatureResistance(temperature));
/*     */     }
/*     */   }
/*     */   
/*     */   public static void registerDefaultItemTemperature(String registryName, float temperature, float heatResistance, float coldResistance, float thermalResistance) {
/* 192 */     if (!defaultItemTemperatures.containsKey(registryName)) {
/* 193 */       defaultItemTemperatures.put(registryName, new JsonTemperatureResistance(temperature, heatResistance, coldResistance, thermalResistance));
/*     */     }
/*     */   }
/*     */   
/*     */   public static void registerItemTemperature(String registryName, float temperature) {
/* 198 */     if (!itemTemperatures.containsKey(registryName)) {
/* 199 */       itemTemperatures.put(registryName, new JsonTemperatureResistance(temperature));
/*     */     }
/*     */   }
/*     */   
/*     */   public static void registerItemTemperature(String registryName, float temperature, float heatResistance, float coldResistance, float thermalResistance) {
/* 204 */     if (!itemTemperatures.containsKey(registryName)) {
/* 205 */       itemTemperatures.put(registryName, new JsonTemperatureResistance(temperature, heatResistance, coldResistance, thermalResistance));
/*     */     }
/*     */   }
/*     */   
/*     */   public static void registerDefaultEntityTemperature(String registryName, float temperature) {
/* 210 */     if (!defaultEntityTemperatures.containsKey(registryName)) {
/* 211 */       defaultEntityTemperatures.put(registryName, new JsonTemperature(temperature));
/*     */     }
/*     */   }
/*     */   
/*     */   public static void registerEntityTemperature(String registryName, float temperature) {
/* 216 */     if (!entityTemperatures.containsKey(registryName)) {
/* 217 */       entityTemperatures.put(registryName, new JsonTemperature(temperature));
/*     */     }
/*     */   }
/*     */   
/*     */   public static void registerDefaultConsumableTemperature(TemporaryModifierGroupEnum group, String registryName, int temperatureLevel, int duration) {
/* 222 */     if (!defaultConsumableTemperature.containsKey(registryName))
/*     */     {
/* 224 */       defaultConsumableTemperature.put(registryName, new ArrayList<>());
/*     */     }
/*     */     
/* 227 */     List<JsonConsumableTemperature> currentList = defaultConsumableTemperature.get(registryName);
/*     */     
/* 229 */     JsonConsumableTemperature jsonConsumableTemperature = new JsonConsumableTemperature(group, temperatureLevel, duration);
/*     */     
/* 231 */     if (temperatureLevel == 0) {
/*     */       
/* 233 */       LegendarySurvivalOverhaul.LOGGER.debug("Error with consumable " + registryName + " : temperature can't be 0");
/*     */       
/*     */       return;
/*     */     } 
/* 237 */     for (int i = 0; i < currentList.size(); i++) {
/*     */       
/* 239 */       JsonConsumableTemperature jct = currentList.get(i);
/* 240 */       if (Objects.equals(jct.group, jsonConsumableTemperature.group)) {
/*     */         
/* 242 */         currentList.set(i, jsonConsumableTemperature);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 247 */     currentList.add(jsonConsumableTemperature);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerConsumableTemperature(TemporaryModifierGroupEnum group, String registryName, int temperatureLevel, int duration) {
/* 252 */     if (!consumableTemperature.containsKey(registryName))
/*     */     {
/* 254 */       consumableTemperature.put(registryName, new ArrayList<>());
/*     */     }
/*     */     
/* 257 */     List<JsonConsumableTemperature> currentList = consumableTemperature.get(registryName);
/*     */     
/* 259 */     JsonConsumableTemperature jsonConsumableTemperature = new JsonConsumableTemperature(group, temperatureLevel, duration);
/*     */     
/* 261 */     if (temperatureLevel == 0) {
/*     */       
/* 263 */       LegendarySurvivalOverhaul.LOGGER.debug("Error with consumable " + registryName + " : temperature can't be 0");
/*     */       
/*     */       return;
/*     */     } 
/* 267 */     for (int i = 0; i < currentList.size(); i++) {
/*     */       
/* 269 */       JsonConsumableTemperature jct = currentList.get(i);
/* 270 */       if (Objects.equals(jct.group, jsonConsumableTemperature.group)) {
/*     */         
/* 272 */         currentList.set(i, jsonConsumableTemperature);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 277 */     currentList.add(jsonConsumableTemperature);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerDefaultBlockFluidThirst(String registryName, int hydration, float saturation) {
/* 282 */     registerDefaultBlockFluidThirst(registryName, hydration, saturation, new JsonPropertyValue[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerDefaultBlockFluidThirst(String registryName, int hydration, float saturation, JsonPropertyValue... properties) {
/* 287 */     registerDefaultBlockFluidThirst(registryName, hydration, saturation, new JsonEffectParameter[0], properties);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerDefaultBlockFluidThirst(String registryName, int hydration, float saturation, JsonEffectParameter[] effects, JsonPropertyValue... properties) {
/* 292 */     if (!defaultBlockFluidThirst.containsKey(registryName)) {
/* 293 */       defaultBlockFluidThirst.put(registryName, new ArrayList<>());
/*     */     }
/* 295 */     List<JsonBlockFluidThirst> alreadyDefinedConfig = defaultBlockFluidThirst.get(registryName);
/*     */     
/* 297 */     JsonBlockFluidThirst newBlockFluidThirst = new JsonBlockFluidThirst(hydration, saturation, effects, properties);
/*     */     
/* 299 */     if (properties.length > 0) {
/*     */ 
/*     */       
/* 302 */       for (int i = 0; i < alreadyDefinedConfig.size(); i++) {
/*     */         
/* 304 */         JsonBlockFluidThirst jpt = alreadyDefinedConfig.get(i);
/* 305 */         if (jpt.matchesProperties(properties)) {
/*     */           
/* 307 */           alreadyDefinedConfig.set(i, newBlockFluidThirst);
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 314 */       for (int i = 0; i < alreadyDefinedConfig.size(); i++) {
/*     */         
/* 316 */         JsonBlockFluidThirst jpt = alreadyDefinedConfig.get(i);
/* 317 */         if (jpt.properties.isEmpty()) {
/*     */           
/* 319 */           alreadyDefinedConfig.set(i, newBlockFluidThirst);
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/* 324 */     alreadyDefinedConfig.add(newBlockFluidThirst);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerBlockFluidThirst(String registryName, int hydration, float saturation) {
/* 329 */     registerDefaultBlockFluidThirst(registryName, hydration, saturation, new JsonPropertyValue[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerBlockFluidThirst(String registryName, int hydration, float saturation, JsonPropertyValue... properties) {
/* 334 */     registerDefaultBlockFluidThirst(registryName, hydration, saturation, new JsonEffectParameter[0], properties);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerBlockFluidThirst(String registryName, int hydration, float saturation, JsonEffectParameter[] effects, JsonPropertyValue... properties) {
/* 339 */     if (!blockFluidThirst.containsKey(registryName)) {
/* 340 */       blockFluidThirst.put(registryName, new ArrayList<>());
/*     */     }
/* 342 */     List<JsonBlockFluidThirst> alreadyDefinedConfig = blockFluidThirst.get(registryName);
/*     */     
/* 344 */     JsonBlockFluidThirst newBlockFluidThirst = new JsonBlockFluidThirst(hydration, saturation, effects, properties);
/*     */     
/* 346 */     if (properties.length > 0) {
/*     */ 
/*     */       
/* 349 */       for (int i = 0; i < alreadyDefinedConfig.size(); i++) {
/*     */         
/* 351 */         JsonBlockFluidThirst jpt = alreadyDefinedConfig.get(i);
/* 352 */         if (jpt.matchesProperties(properties)) {
/*     */           
/* 354 */           alreadyDefinedConfig.set(i, newBlockFluidThirst);
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 361 */       for (int i = 0; i < alreadyDefinedConfig.size(); i++) {
/*     */         
/* 363 */         JsonBlockFluidThirst jpt = alreadyDefinedConfig.get(i);
/* 364 */         if (jpt.properties.isEmpty()) {
/*     */           
/* 366 */           alreadyDefinedConfig.set(i, newBlockFluidThirst);
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/* 371 */     alreadyDefinedConfig.add(newBlockFluidThirst);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerDefaultConsumableThirst(String registryName, int hydration, float saturation) {
/* 376 */     registerDefaultConsumableThirst(registryName, hydration, saturation, new JsonPropertyValue[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerDefaultConsumableThirst(String registryName, int hydration, float saturation, JsonPropertyValue... nbt) {
/* 381 */     registerDefaultConsumableThirst(registryName, hydration, saturation, new JsonEffectParameter[0], nbt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerDefaultConsumableThirst(String registryName, int hydration, float saturation, JsonEffectParameter[] effects, JsonPropertyValue... nbt) {
/* 386 */     if (!defaultConsumableThirst.containsKey(registryName))
/*     */     {
/* 388 */       defaultConsumableThirst.put(registryName, new ArrayList<>());
/*     */     }
/*     */     
/* 391 */     List<JsonConsumableThirst> alreadyDefinedConfig = defaultConsumableThirst.get(registryName);
/*     */     
/* 393 */     JsonConsumableThirst newThirstConfig = new JsonConsumableThirst(hydration, saturation, effects, nbt);
/*     */     
/* 395 */     if (nbt.length > 0) {
/*     */ 
/*     */       
/* 398 */       for (int i = 0; i < alreadyDefinedConfig.size(); i++) {
/*     */         
/* 400 */         JsonConsumableThirst jct = alreadyDefinedConfig.get(i);
/* 401 */         if (jct.matchesNbt(nbt)) {
/*     */           
/* 403 */           alreadyDefinedConfig.set(i, newThirstConfig);
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 410 */       for (int i = 0; i < alreadyDefinedConfig.size(); i++) {
/*     */         
/* 412 */         JsonConsumableThirst jct = alreadyDefinedConfig.get(i);
/* 413 */         if (jct.nbt.isEmpty()) {
/*     */           
/* 415 */           alreadyDefinedConfig.set(i, newThirstConfig);
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/* 420 */     alreadyDefinedConfig.add(newThirstConfig);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerConsumableThirst(String registryName, int hydration, float saturation) {
/* 425 */     registerDefaultConsumableThirst(registryName, hydration, saturation, new JsonPropertyValue[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerConsumableThirst(String registryName, int hydration, float saturation, JsonPropertyValue... nbt) {
/* 430 */     registerDefaultConsumableThirst(registryName, hydration, saturation, new JsonEffectParameter[0], nbt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerConsumableThirst(String registryName, int hydration, float saturation, JsonEffectParameter[] effects, JsonPropertyValue... nbt) {
/* 435 */     if (!consumableThirst.containsKey(registryName))
/*     */     {
/* 437 */       consumableThirst.put(registryName, new ArrayList<>());
/*     */     }
/*     */     
/* 440 */     List<JsonConsumableThirst> alreadyDefinedConfig = consumableThirst.get(registryName);
/*     */     
/* 442 */     JsonConsumableThirst newThirstConfig = new JsonConsumableThirst(hydration, saturation, effects, nbt);
/*     */     
/* 444 */     if (nbt.length > 0) {
/*     */ 
/*     */       
/* 447 */       for (int i = 0; i < alreadyDefinedConfig.size(); i++) {
/*     */         
/* 449 */         JsonConsumableThirst jct = alreadyDefinedConfig.get(i);
/* 450 */         if (jct.matchesNbt(nbt)) {
/*     */           
/* 452 */           alreadyDefinedConfig.set(i, newThirstConfig);
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 459 */       for (int i = 0; i < alreadyDefinedConfig.size(); i++) {
/*     */         
/* 461 */         JsonConsumableThirst jct = alreadyDefinedConfig.get(i);
/* 462 */         if (jct.nbt.isEmpty()) {
/*     */           
/* 464 */           alreadyDefinedConfig.set(i, newThirstConfig);
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/* 469 */     alreadyDefinedConfig.add(newThirstConfig);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerDefaultConsumableHeal(String registryName, int healingCharges, float healingValue, int healingTime) {
/* 474 */     if (!defaultConsumableHeal.containsKey(registryName))
/* 475 */       if (healingCharges < 0) {
/* 476 */         LegendarySurvivalOverhaul.LOGGER.debug("Error with consumable " + registryName + " : healing charges can't be negative");
/*     */       } else {
/* 478 */         defaultConsumableHeal.put(registryName, new JsonConsumableHeal(healingCharges, healingValue, healingTime));
/*     */       }  
/*     */   }
/*     */   
/*     */   public static void registerConsumableHeal(String registryName, int healingCharges, float healingValue, int healingTime) {
/* 483 */     if (!consumableHeal.containsKey(registryName))
/* 484 */       if (healingCharges < 0) {
/* 485 */         LegendarySurvivalOverhaul.LOGGER.debug("Error with consumable " + registryName + " : healing charges can't be negative");
/*     */       } else {
/* 487 */         consumableHeal.put(registryName, new JsonConsumableHeal(healingCharges, healingValue, healingTime));
/*     */       }  
/*     */   }
/*     */   
/*     */   public static void registerDefaultDamageSourceBodyParts(String damageSource, DamageDistributionEnum damageDistribution, List<BodyPartEnum> bodyParts) {
/* 492 */     if (!defaultDamageSourceBodyParts.containsKey(damageSource)) {
/* 493 */       defaultDamageSourceBodyParts.put(damageSource, new JsonBodyPartsDamageSource(damageDistribution, bodyParts));
/*     */     }
/*     */   }
/*     */   
/*     */   public static void registerDamageSourceBodyParts(String damageSource, DamageDistributionEnum damageDistribution, List<BodyPartEnum> bodyParts) {
/* 498 */     if (!damageSourceBodyParts.containsKey(damageSource))
/* 499 */       damageSourceBodyParts.put(damageSource, new JsonBodyPartsDamageSource(damageDistribution, bodyParts)); 
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\config\json_old\JsonConfig.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */