/*     */ package sfiomn.legendarysurvivaloverhaul.config.json_old;
/*     */ import com.google.common.collect.MapDifference;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Type;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.world.effect.MobEffect;
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
/*     */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.temperature.JsonFuelItem;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.temperature.JsonTemperature;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.temperature.JsonTemperatureResistance;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.thirst.JsonBlockFluidThirst;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.thirst.JsonConsumableThirst;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.thirst.JsonEffectParameter;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemporaryModifierGroupEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.JsonFileName;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.JsonTypeToken;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.builders.BodyPartsDamageSourceData;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.builders.HealingConsumableData;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.builders.TemperatureBiomeOverrideData;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.builders.TemperatureBlockData;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.builders.TemperatureConsumableData;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.builders.TemperatureFuelItemData;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.builders.TemperatureResistanceData;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.builders.ThirstData;
/*     */ 
/*     */ public class JsonConfigRegistration {
/*  49 */   public static Path customDatapackFolder = Paths.get(LegendarySurvivalOverhaul.modConfigPath.toString(), new String[] { "customDataPack" });
/*     */ 
/*     */ 
/*     */   
/*     */   public static void init(File configDir) {
/*  54 */     if (configDir.exists()) {
/*     */       
/*  56 */       registerDefaults(configDir);
/*     */       
/*  58 */       processAllJson(configDir);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void registerDefaults(File configDir) {
/*  67 */     JsonConfig.registerDefaultDimensionTemperature("minecraft:overworld", 20.0F);
/*  68 */     JsonConfig.registerDefaultDimensionTemperature("minecraft:the_end", -15.0F);
/*  69 */     JsonConfig.registerDefaultDimensionTemperature("minecraft:the_nether", 28.0F);
/*     */     
/*  71 */     JsonConfig.registerDefaultBlockFluidTemperature("minecraft:campfire", 10.0F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "true") });
/*  72 */     JsonConfig.registerDefaultBlockFluidTemperature("minecraft:campfire", 0.0F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "false") });
/*  73 */     JsonConfig.registerDefaultBlockFluidTemperature("minecraft:soul_campfire", -10.0F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "true") });
/*  74 */     JsonConfig.registerDefaultBlockFluidTemperature("minecraft:soul_campfire", 0.0F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "false") });
/*     */     
/*  76 */     JsonConfig.registerDefaultBlockFluidTemperature("minecraft:torch", 1.5F, new JsonPropertyValue[0]);
/*  77 */     JsonConfig.registerDefaultBlockFluidTemperature("minecraft:soul_torch", -1.5F, new JsonPropertyValue[0]);
/*     */     
/*  79 */     JsonConfig.registerDefaultBlockFluidTemperature("minecraft:wall_torch", 1.5F, new JsonPropertyValue[0]);
/*  80 */     JsonConfig.registerDefaultBlockFluidTemperature("minecraft:soul_wall_torch", -1.5F, new JsonPropertyValue[0]);
/*     */     
/*  82 */     JsonConfig.registerDefaultBlockFluidTemperature("minecraft:fire", 7.0F, new JsonPropertyValue[0]);
/*  83 */     JsonConfig.registerDefaultBlockFluidTemperature("minecraft:soul_fire", -7.0F, new JsonPropertyValue[0]);
/*     */     
/*  85 */     JsonConfig.registerDefaultBlockFluidTemperature("minecraft:furnace", 6.0F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "true") });
/*  86 */     JsonConfig.registerDefaultBlockFluidTemperature("minecraft:blast_furnace", 6.0F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "true") });
/*  87 */     JsonConfig.registerDefaultBlockFluidTemperature("minecraft:smoker", 6.0F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "true") });
/*     */     
/*  89 */     JsonConfig.registerDefaultBlockFluidTemperature("minecraft:furnace", 0.0F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "false") });
/*  90 */     JsonConfig.registerDefaultBlockFluidTemperature("minecraft:blast_furnace", 0.0F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "false") });
/*  91 */     JsonConfig.registerDefaultBlockFluidTemperature("minecraft:smoker", 0.0F, new JsonPropertyValue[] { new JsonPropertyValue("false", "true") });
/*     */     
/*  93 */     JsonConfig.registerDefaultBlockFluidTemperature("legendarysurvivaloverhaul:cooler", -15.0F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "true") });
/*  94 */     JsonConfig.registerDefaultBlockFluidTemperature("legendarysurvivaloverhaul:heater", 15.0F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "true") });
/*     */     
/*  96 */     JsonConfig.registerDefaultBlockFluidTemperature("legendarysurvivaloverhaul:cooler", 0.0F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "false") });
/*  97 */     JsonConfig.registerDefaultBlockFluidTemperature("legendarysurvivaloverhaul:heater", 0.0F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "false") });
/*     */     
/*  99 */     JsonConfig.registerDefaultBlockFluidTemperature("legendarysurvivaloverhaul:ice_fern_crop", -1.5F, new JsonPropertyValue[] { new JsonPropertyValue(IceFernBlock.AGE.getName(), String.valueOf(3)) });
/* 100 */     JsonConfig.registerDefaultBlockFluidTemperature("legendarysurvivaloverhaul:sun_fern_crop", 1.5F, new JsonPropertyValue[] { new JsonPropertyValue(SunFernBlock.AGE.getName(), String.valueOf(3)) });
/*     */     
/* 102 */     JsonConfig.registerDefaultBlockFluidTemperature("minecraft:magma_block", 12.0F, new JsonPropertyValue[0]);
/*     */     
/* 104 */     JsonConfig.registerDefaultBlockFluidTemperature("minecraft:jack_o_lantern", 3.0F, new JsonPropertyValue[0]);
/*     */     
/* 106 */     JsonConfig.registerDefaultBlockFluidTemperature("minecraft:lava", 12.5F, new JsonPropertyValue[0]);
/* 107 */     JsonConfig.registerDefaultBlockFluidTemperature("minecraft:flowing_lava", 12.5F, new JsonPropertyValue[0]);
/*     */     
/* 109 */     JsonConfig.registerDefaultItemTemperature("legendarysurvivaloverhaul:snow_boots", 0.0F, 0.0F, 0.5F, 0.0F);
/* 110 */     JsonConfig.registerDefaultItemTemperature("legendarysurvivaloverhaul:snow_leggings", 0.0F, 0.0F, 2.5F, 0.0F);
/* 111 */     JsonConfig.registerDefaultItemTemperature("legendarysurvivaloverhaul:snow_chestplate", 0.0F, 0.0F, 3.0F, 0.0F);
/* 112 */     JsonConfig.registerDefaultItemTemperature("legendarysurvivaloverhaul:snow_helmet", 0.0F, 0.0F, 1.5F, 0.0F);
/*     */     
/* 114 */     JsonConfig.registerDefaultItemTemperature("legendarysurvivaloverhaul:desert_boots", 0.0F, 0.5F, 0.0F, 0.0F);
/* 115 */     JsonConfig.registerDefaultItemTemperature("legendarysurvivaloverhaul:desert_leggings", 0.0F, 2.5F, 0.0F, 0.0F);
/* 116 */     JsonConfig.registerDefaultItemTemperature("legendarysurvivaloverhaul:desert_chestplate", 0.0F, 3.0F, 0.0F, 0.0F);
/* 117 */     JsonConfig.registerDefaultItemTemperature("legendarysurvivaloverhaul:desert_helmet", 0.0F, 1.5F, 0.0F, 0.0F);
/*     */     
/* 119 */     JsonConfig.registerDefaultItemTemperature("legendarysurvivaloverhaul:nether_chalice", 2.0F);
/* 120 */     JsonConfig.registerDefaultItemTemperature("minecraft:lava_bucket", 6.0F);
/* 121 */     JsonConfig.registerDefaultItemTemperature("minecraft:magma_block", 6.0F);
/*     */     
/* 123 */     JsonConfig.registerDefaultItemTemperature("minecraft:leather_boots", 0.0F, 0.0F, 0.5F, 0.0F);
/* 124 */     JsonConfig.registerDefaultItemTemperature("minecraft:leather_leggings", 0.0F, 0.0F, 1.0F, 0.0F);
/* 125 */     JsonConfig.registerDefaultItemTemperature("minecraft:leather_chestplate", 0.0F, 0.0F, 1.5F, 0.0F);
/* 126 */     JsonConfig.registerDefaultItemTemperature("minecraft:leather_helmet", 0.0F, 0.0F, 1.0F, 0.0F);
/*     */     
/* 128 */     JsonConfig.registerDefaultItemTemperature("minecraft:golden_boots", 0.0F, 0.0F, 0.5F, 0.0F);
/* 129 */     JsonConfig.registerDefaultItemTemperature("minecraft:golden_leggings", 0.0F, 0.0F, 1.0F, 0.0F);
/* 130 */     JsonConfig.registerDefaultItemTemperature("minecraft:golden_chestplate", 0.0F, 0.0F, 1.0F, 0.0F);
/* 131 */     JsonConfig.registerDefaultItemTemperature("minecraft:golden_helmet", 0.0F, 0.0F, 0.5F, 0.0F);
/*     */     
/* 133 */     JsonConfig.registerDefaultItemTemperature("minecraft:iron_boots", 0.0F, 0.5F, 0.0F, 0.0F);
/* 134 */     JsonConfig.registerDefaultItemTemperature("minecraft:iron_leggings", 0.0F, 1.0F, 0.0F, 0.0F);
/* 135 */     JsonConfig.registerDefaultItemTemperature("minecraft:iron_chestplate", 0.0F, 1.0F, 0.0F, 0.0F);
/* 136 */     JsonConfig.registerDefaultItemTemperature("minecraft:iron_helmet", 0.0F, 0.5F, 0.0F, 0.0F);
/*     */     
/* 138 */     JsonConfig.registerDefaultItemTemperature("minecraft:diamond_boots", 0.0F, 1.0F, 0.0F, 0.0F);
/* 139 */     JsonConfig.registerDefaultItemTemperature("minecraft:diamond_leggings", 0.0F, 1.0F, 0.0F, 0.0F);
/* 140 */     JsonConfig.registerDefaultItemTemperature("minecraft:diamond_chestplate", 0.0F, 1.5F, 0.0F, 0.0F);
/* 141 */     JsonConfig.registerDefaultItemTemperature("minecraft:diamond_helmet", 0.0F, 0.5F, 0.0F, 0.0F);
/*     */     
/* 143 */     JsonConfig.registerDefaultItemTemperature("minecraft:netherite_boots", 0.0F, 0.0F, 1.5F, 0.0F);
/* 144 */     JsonConfig.registerDefaultItemTemperature("minecraft:netherite_leggings", 0.0F, 0.0F, 1.5F, 0.0F);
/* 145 */     JsonConfig.registerDefaultItemTemperature("minecraft:netherite_chestplate", 0.0F, 0.0F, 2.0F, 0.0F);
/* 146 */     JsonConfig.registerDefaultItemTemperature("minecraft:netherite_helmet", 0.0F, 0.0F, 1.0F, 0.0F);
/*     */     
/* 148 */     JsonConfig.registerDefaultItemTemperature("minecraft:torch", 1.0F);
/* 149 */     JsonConfig.registerDefaultItemTemperature("minecraft:soul_torch", -1.0F);
/* 150 */     JsonConfig.registerDefaultItemTemperature("minecraft:ice", -1.0F);
/* 151 */     JsonConfig.registerDefaultItemTemperature("minecraft:packed_ice", -2.0F);
/* 152 */     JsonConfig.registerDefaultItemTemperature("minecraft:blue_ice", -3.0F);
/*     */     
/* 154 */     JsonConfig.registerDefaultEntityTemperature("minecraft:strider", -3.0F);
/*     */     
/* 156 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "minecraft:mushroom_stew", 1, 1200);
/* 157 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "minecraft:mushroom_stew", 1, 1200);
/* 158 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "minecraft:rabbit_stew", 2, 1200);
/* 159 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "minecraft:suspicious_stew", 1, 1200);
/* 160 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "minecraft:melon_slice", -1, 1200);
/* 161 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "legendarysurvivaloverhaul:melon_juice", -1, 1200);
/* 162 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "legendarysurvivaloverhaul:glistering_melon_juice", -2, 3600);
/*     */     
/* 164 */     JsonConfig.registerDefaultBiomeOverride("minecraft:crimson_forest", 0.75F, false);
/* 165 */     JsonConfig.registerDefaultBiomeOverride("minecraft:warped_forest", 0.75F, false);
/* 166 */     JsonConfig.registerDefaultBiomeOverride("minecraft:nether_wastes", 1.0F, false);
/* 167 */     JsonConfig.registerDefaultBiomeOverride("minecraft:soul_sand_valley", 1.0F, false);
/* 168 */     JsonConfig.registerDefaultBiomeOverride("minecraft:basalt_deltas", 1.45F, false);
/* 169 */     JsonConfig.registerDefaultBiomeOverride("minecraft:frozen_ocean", -0.5F, false);
/* 170 */     JsonConfig.registerDefaultBiomeOverride("minecraft:deep_frozen_ocean", -0.5F, false);
/*     */     
/* 172 */     JsonConfig.registerDefaultFuelItems("minecraft:coal", ThermalTypeEnum.HEATING, 30);
/* 173 */     JsonConfig.registerDefaultFuelItems("minecraft:charcoal", ThermalTypeEnum.HEATING, 30);
/* 174 */     JsonConfig.registerDefaultFuelItems("minecraft:coal_block", ThermalTypeEnum.HEATING, 270);
/* 175 */     JsonConfig.registerDefaultFuelItems("minecraft:ice", ThermalTypeEnum.COOLING, 20);
/* 176 */     JsonConfig.registerDefaultFuelItems("minecraft:snowball", ThermalTypeEnum.COOLING, 20);
/* 177 */     JsonConfig.registerDefaultFuelItems("minecraft:snow_block", ThermalTypeEnum.COOLING, 30);
/* 178 */     JsonConfig.registerDefaultFuelItems("minecraft:blue_ice", ThermalTypeEnum.COOLING, 1620);
/* 179 */     JsonConfig.registerDefaultFuelItems("minecraft:packed_ice", ThermalTypeEnum.COOLING, 180);
/*     */     
/* 181 */     JsonConfig.registerDefaultBlockFluidThirst("minecraft:rain", 1, 0.0F);
/* 182 */     JsonConfig.registerDefaultBlockFluidThirst("minecraft:flowing_water", 3, 0.0F, new JsonEffectParameter[] { new JsonEffectParameter("legendarysurvivaloverhaul:thirst", 0.75F, 300, 0) }new JsonPropertyValue[0]);
/* 183 */     JsonConfig.registerDefaultBlockFluidThirst("minecraft:water", 3, 0.0F, new JsonEffectParameter[] { new JsonEffectParameter("legendarysurvivaloverhaul:thirst", 0.75F, 300, 0) }new JsonPropertyValue[0]);
/* 184 */     JsonConfig.registerDefaultBlockFluidThirst("minecraft:water_cauldron", 3, 0.0F, new JsonEffectParameter[] { new JsonEffectParameter("legendarysurvivaloverhaul:thirst", 0.75F, 300, 0) }new JsonPropertyValue[0]);
/*     */     
/* 186 */     JsonConfig.registerDefaultConsumableThirst("minecraft:melon_slice", 2, 1.0F);
/* 187 */     JsonConfig.registerDefaultConsumableThirst("minecraft:apple", 2, 0.5F);
/* 188 */     JsonConfig.registerDefaultConsumableThirst("minecraft:beetroot_soup", 4, 2.0F);
/* 189 */     JsonConfig.registerDefaultConsumableThirst("minecraft:rabbit_stew", 6, 2.0F);
/* 190 */     JsonConfig.registerDefaultConsumableThirst("minecraft:mushroom_stew", 4, 2.0F);
/* 191 */     JsonConfig.registerDefaultConsumableThirst("minecraft:suspicious_stew", 4, 2.0F);
/* 192 */     JsonConfig.registerDefaultConsumableThirst("minecraft:rotten_flesh", -2, -1.0F, new JsonEffectParameter[] { new JsonEffectParameter("legendarysurvivaloverhaul:thirst", 1.0F, 600, 0) }new JsonPropertyValue[0]);
/* 193 */     JsonConfig.registerDefaultConsumableThirst("legendarysurvivaloverhaul:apple_juice", 6, 3.0F);
/* 194 */     JsonConfig.registerDefaultConsumableThirst("legendarysurvivaloverhaul:beetroot_juice", 9, 4.0F);
/* 195 */     JsonConfig.registerDefaultConsumableThirst("legendarysurvivaloverhaul:cactus_juice", 9, 3.0F);
/* 196 */     JsonConfig.registerDefaultConsumableThirst("legendarysurvivaloverhaul:carrot_juice", 4, 2.0F);
/* 197 */     JsonConfig.registerDefaultConsumableThirst("legendarysurvivaloverhaul:chorus_fruit_juice", 12, 8.0F);
/* 198 */     JsonConfig.registerDefaultConsumableThirst("legendarysurvivaloverhaul:golden_apple_juice", 20, 20.0F);
/* 199 */     JsonConfig.registerDefaultConsumableThirst("legendarysurvivaloverhaul:golden_carrot_juice", 12, 12.0F);
/* 200 */     JsonConfig.registerDefaultConsumableThirst("legendarysurvivaloverhaul:glistering_melon_juice", 16, 16.0F);
/* 201 */     JsonConfig.registerDefaultConsumableThirst("legendarysurvivaloverhaul:melon_juice", 8, 4.0F);
/* 202 */     JsonConfig.registerDefaultConsumableThirst("legendarysurvivaloverhaul:pumpkin_juice", 7, 4.0F);
/* 203 */     JsonConfig.registerDefaultConsumableThirst("legendarysurvivaloverhaul:purified_water_bottle", 6, 1.5F);
/* 204 */     JsonConfig.registerDefaultConsumableThirst("legendarysurvivaloverhaul:water_plant_bag", 3, 0.0F);
/* 205 */     JsonConfig.registerDefaultConsumableThirst("legendarysurvivaloverhaul:canteen", 3, 0.0F, new JsonEffectParameter[] { new JsonEffectParameter("legendarysurvivaloverhaul:thirst", 0.75F, 300, 0) }new JsonPropertyValue[] { new JsonPropertyValue("legendarysurvivaloverhaul:HydrationPurity", HydrationEnum.NORMAL.getName()) });
/* 206 */     JsonConfig.registerDefaultConsumableThirst("legendarysurvivaloverhaul:canteen", 6, 1.5F, new JsonPropertyValue[] { new JsonPropertyValue("legendarysurvivaloverhaul:HydrationPurity", HydrationEnum.PURIFIED.getName()) });
/* 207 */     JsonConfig.registerDefaultConsumableThirst("legendarysurvivaloverhaul:large_canteen", 3, 0.0F, new JsonEffectParameter[] { new JsonEffectParameter("legendarysurvivaloverhaul:thirst", 0.75F, 300, 0) }new JsonPropertyValue[] { new JsonPropertyValue("legendarysurvivaloverhaul:HydrationPurity", HydrationEnum.NORMAL.getName()) });
/* 208 */     JsonConfig.registerDefaultConsumableThirst("legendarysurvivaloverhaul:large_canteen", 6, 1.5F, new JsonPropertyValue[] { new JsonPropertyValue("legendarysurvivaloverhaul:HydrationPurity", HydrationEnum.PURIFIED.getName()) });
/*     */     
/* 210 */     JsonConfig.registerDefaultConsumableThirst("minecraft:potion", 3, 0.0F, new JsonEffectParameter[] { new JsonEffectParameter("legendarysurvivaloverhaul:thirst", 0.75F, 300, 0) }new JsonPropertyValue[] { new JsonPropertyValue("Potion", "minecraft:water") });
/* 211 */     JsonConfig.registerDefaultConsumableThirst("minecraft:potion", 3, 0.0F, new JsonEffectParameter[] { new JsonEffectParameter("legendarysurvivaloverhaul:thirst", 0.75F, 300, 0) }new JsonPropertyValue[] { new JsonPropertyValue("Potion", "minecraft:mundane") });
/* 212 */     JsonConfig.registerDefaultConsumableThirst("minecraft:potion", 3, 0.0F, new JsonEffectParameter[] { new JsonEffectParameter("legendarysurvivaloverhaul:thirst", 0.75F, 300, 0) }new JsonPropertyValue[] { new JsonPropertyValue("Potion", "minecraft:thick") });
/* 213 */     JsonConfig.registerDefaultConsumableThirst("minecraft:potion", 3, 0.0F, new JsonEffectParameter[] { new JsonEffectParameter("legendarysurvivaloverhaul:thirst", 0.75F, 300, 0) }new JsonPropertyValue[] { new JsonPropertyValue("Potion", "minecraft:awkward") });
/* 214 */     JsonConfig.registerDefaultConsumableThirst("minecraft:potion", 0, 0.0F, new JsonEffectParameter[0], new JsonPropertyValue[] { new JsonPropertyValue("Potion", "minecraft:empty") });
/* 215 */     JsonConfig.registerDefaultConsumableThirst("minecraft:potion", 6, 1.5F, new JsonEffectParameter[0], new JsonPropertyValue[0]);
/*     */ 
/*     */     
/* 218 */     JsonConfig.registerDefaultConsumableHeal("legendarysurvivaloverhaul:healing_herbs", 1, 2.0F, 600);
/* 219 */     JsonConfig.registerDefaultConsumableHeal("legendarysurvivaloverhaul:plaster", 1, 3.0F, 400);
/* 220 */     JsonConfig.registerDefaultConsumableHeal("legendarysurvivaloverhaul:bandage", 3, 3.0F, 300);
/* 221 */     JsonConfig.registerDefaultConsumableHeal("legendarysurvivaloverhaul:tonic", 0, 5.0F, 600);
/* 222 */     JsonConfig.registerDefaultConsumableHeal("legendarysurvivaloverhaul:medikit", 0, 8.0F, 400);
/*     */     
/* 224 */     JsonConfig.registerDefaultDamageSourceBodyParts("fall", DamageDistributionEnum.ALL, Arrays.asList(new BodyPartEnum[] { BodyPartEnum.LEFT_FOOT, BodyPartEnum.RIGHT_FOOT }));
/* 225 */     JsonConfig.registerDefaultDamageSourceBodyParts("hotFloor", DamageDistributionEnum.ALL, Arrays.asList(new BodyPartEnum[] { BodyPartEnum.LEFT_FOOT, BodyPartEnum.RIGHT_FOOT }));
/* 226 */     JsonConfig.registerDefaultDamageSourceBodyParts("fallingBlock", DamageDistributionEnum.ALL, Collections.singletonList(BodyPartEnum.HEAD));
/* 227 */     JsonConfig.registerDefaultDamageSourceBodyParts("flyIntoWall", DamageDistributionEnum.ALL, Collections.singletonList(BodyPartEnum.HEAD));
/* 228 */     JsonConfig.registerDefaultDamageSourceBodyParts("anvil", DamageDistributionEnum.ALL, Collections.singletonList(BodyPartEnum.HEAD));
/* 229 */     JsonConfig.registerDefaultDamageSourceBodyParts("lightningBolt", DamageDistributionEnum.ALL, Arrays.asList(BodyPartEnum.values()));
/* 230 */     JsonConfig.registerDefaultDamageSourceBodyParts("onFire", DamageDistributionEnum.ALL, Arrays.asList(BodyPartEnum.values()));
/* 231 */     JsonConfig.registerDefaultDamageSourceBodyParts("explosion", DamageDistributionEnum.ALL, Arrays.asList(BodyPartEnum.values()));
/* 232 */     JsonConfig.registerDefaultDamageSourceBodyParts("bad_respawn_point", DamageDistributionEnum.ALL, Arrays.asList(BodyPartEnum.values()));
/* 233 */     JsonConfig.registerDefaultDamageSourceBodyParts("dragonBreath", DamageDistributionEnum.ALL, Arrays.asList(BodyPartEnum.values()));
/* 234 */     JsonConfig.registerDefaultDamageSourceBodyParts("inFire", DamageDistributionEnum.ALL, Arrays.asList(new BodyPartEnum[] { BodyPartEnum.LEFT_FOOT, BodyPartEnum.RIGHT_FOOT, BodyPartEnum.LEFT_LEG, BodyPartEnum.RIGHT_LEG }));
/* 235 */     JsonConfig.registerDefaultDamageSourceBodyParts("cactus", DamageDistributionEnum.ONE_OF, Arrays.asList(new BodyPartEnum[] { BodyPartEnum.LEFT_FOOT, BodyPartEnum.RIGHT_FOOT, BodyPartEnum.LEFT_LEG, BodyPartEnum.RIGHT_LEG }));
/* 236 */     JsonConfig.registerDefaultDamageSourceBodyParts("sweetBerryBush", DamageDistributionEnum.ONE_OF, Arrays.asList(new BodyPartEnum[] { BodyPartEnum.LEFT_FOOT, BodyPartEnum.RIGHT_FOOT, BodyPartEnum.LEFT_LEG, BodyPartEnum.RIGHT_LEG }));
/* 237 */     JsonConfig.registerDefaultDamageSourceBodyParts("in_wall", DamageDistributionEnum.NONE, Collections.emptyList());
/* 238 */     JsonConfig.registerDefaultDamageSourceBodyParts("drown", DamageDistributionEnum.NONE, Collections.emptyList());
/* 239 */     JsonConfig.registerDefaultDamageSourceBodyParts("starve", DamageDistributionEnum.NONE, Collections.emptyList());
/* 240 */     JsonConfig.registerDefaultDamageSourceBodyParts("magic", DamageDistributionEnum.NONE, Collections.emptyList());
/* 241 */     JsonConfig.registerDefaultDamageSourceBodyParts("wither", DamageDistributionEnum.NONE, Collections.emptyList());
/* 242 */     JsonConfig.registerDefaultDamageSourceBodyParts("legendarysurvivaloverhaul.hypothermia", DamageDistributionEnum.NONE, Collections.emptyList());
/* 243 */     JsonConfig.registerDefaultDamageSourceBodyParts("legendarysurvivaloverhaul.hyperthermia", DamageDistributionEnum.NONE, Collections.emptyList());
/* 244 */     JsonConfig.registerDefaultDamageSourceBodyParts("legendarysurvivaloverhaul.dehydration", DamageDistributionEnum.NONE, Collections.emptyList());
/*     */     
/* 246 */     IntegrationController.initIntegration();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void writeAllToJson(File jsonDir) {
/* 251 */     manuallyWriteToJson(JsonFileName.DIMENSION_TEMP, JsonConfig.defaultDimensionTemperatures, jsonDir);
/* 252 */     manuallyWriteToJson(JsonFileName.BIOME_TEMP, JsonConfig.defaultBiomeOverrides, jsonDir);
/* 253 */     manuallyWriteToJson(JsonFileName.ITEM_TEMP, JsonConfig.defaultItemTemperatures, jsonDir);
/* 254 */     manuallyWriteToJson(JsonFileName.BLOCK_TEMP, JsonConfig.defaultBlockFluidTemperatures, jsonDir);
/* 255 */     manuallyWriteToJson(JsonFileName.FUEL, JsonConfig.defaultFuelItems, jsonDir);
/* 256 */     manuallyWriteToJson(JsonFileName.CONSUMABLE_TEMP, JsonConfig.defaultConsumableTemperature, jsonDir);
/* 257 */     manuallyWriteToJson(JsonFileName.BLOCK_THIRST, JsonConfig.defaultBlockFluidThirst, jsonDir);
/* 258 */     manuallyWriteToJson(JsonFileName.CONSUMABLE_THIRST, JsonConfig.defaultConsumableThirst, jsonDir);
/* 259 */     manuallyWriteToJson(JsonFileName.CONSUMABLE_HEAL, JsonConfig.defaultConsumableHeal, jsonDir);
/* 260 */     manuallyWriteToJson(JsonFileName.DAMAGE_SOURCE_BODY_PARTS, JsonConfig.defaultDamageSourceBodyParts, jsonDir);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void deleteAllJson(File jsonDir) {
/* 265 */     deleteJson(JsonFileName.DIMENSION_TEMP, jsonDir);
/* 266 */     deleteJson(JsonFileName.BIOME_TEMP, jsonDir);
/* 267 */     deleteJson(JsonFileName.ITEM_TEMP, jsonDir);
/* 268 */     deleteJson(JsonFileName.BLOCK_TEMP, jsonDir);
/* 269 */     deleteJson(JsonFileName.FUEL, jsonDir);
/* 270 */     deleteJson(JsonFileName.CONSUMABLE_TEMP, jsonDir);
/* 271 */     deleteJson(JsonFileName.BLOCK_THIRST, jsonDir);
/* 272 */     deleteJson(JsonFileName.CONSUMABLE_THIRST, jsonDir);
/* 273 */     deleteJson(JsonFileName.CONSUMABLE_HEAL, jsonDir);
/* 274 */     deleteJson(JsonFileName.DAMAGE_SOURCE_BODY_PARTS, jsonDir);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void deleteJsonDirs() {
/* 279 */     if (LegendarySurvivalOverhaul.modIntegrationConfigJsons.toFile().exists())
/* 280 */       LegendarySurvivalOverhaul.modIntegrationConfigJsons.toFile().delete(); 
/* 281 */     if (LegendarySurvivalOverhaul.modConfigJsons.toFile().exists()) {
/* 282 */       LegendarySurvivalOverhaul.modConfigJsons.toFile().delete();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static void createDirectories(Path directory) {
/*     */     try {
/* 289 */       Files.createDirectories(directory, (FileAttribute<?>[])new FileAttribute[0]);
/* 290 */     } catch (FileAlreadyExistsException fileAlreadyExistsException) {
/*     */     
/* 292 */     } catch (IOException e) {
/*     */       
/* 294 */       LegendarySurvivalOverhaul.LOGGER.error("Failed to create custom datapack directory {}", directory);
/* 295 */       LegendarySurvivalOverhaul.LOGGER.error(e.getStackTrace());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void writeInFile(File file, JsonObject json) {
/*     */     try {
/* 304 */       FileUtils.write(file, json.toString(), (String)null);
/* 305 */     } catch (IOException err) {
/*     */ 
/*     */       
/* 308 */       LegendarySurvivalOverhaul.LOGGER.error("Failed to create json file {}", file);
/* 309 */       LegendarySurvivalOverhaul.LOGGER.error(err.getStackTrace());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void writeInFile(File file, JsonArray json) {
/*     */     try {
/* 318 */       FileUtils.write(file, json.toString(), (String)null);
/* 319 */     } catch (IOException err) {
/*     */ 
/*     */       
/* 322 */       LegendarySurvivalOverhaul.LOGGER.error("Failed to create json file {}", file);
/* 323 */       LegendarySurvivalOverhaul.LOGGER.error(err.getStackTrace());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void processAllJson(File jsonDir) {
/* 329 */     Gson gson = buildNewGson();
/*     */ 
/*     */     
/* 332 */     Map<String, JsonTemperature> jsonDimensionTemperatures = processJson(JsonFileName.DIMENSION_TEMP, jsonDir);
/*     */     
/* 334 */     if (jsonDimensionTemperatures != null) {
/*     */ 
/*     */ 
/*     */       
/* 338 */       LegendarySurvivalOverhaul.LOGGER.debug("Loaded " + jsonDimensionTemperatures.size() + " dimension temperature overrides from JSON");
/* 339 */       for (Map.Entry<String, JsonTemperature> entry : jsonDimensionTemperatures.entrySet())
/*     */       {
/* 341 */         JsonConfig.registerDimensionTemperature(entry.getKey(), ((JsonTemperature)entry.getValue()).temperature);
/*     */       }
/*     */       
/* 344 */       MapDifference<String, JsonTemperature> diff = Maps.difference((Map)gson.fromJson(gson.toJson(JsonConfig.defaultDimensionTemperatures, Objects.<Type>requireNonNull(JsonTypeToken.get(JsonFileName.DIMENSION_TEMP))), Map.class), (Map)gson.fromJson(gson.toJson(JsonConfig.dimensionTemperatures, Objects.<Type>requireNonNull(JsonTypeToken.get(JsonFileName.DIMENSION_TEMP))), Map.class));
/*     */       
/* 346 */       List<String> entriesToKeep = new ArrayList<>();
/* 347 */       if (!diff.entriesOnlyOnRight().isEmpty() || !diff.entriesDiffering().isEmpty()) {
/*     */         
/* 349 */         entriesToKeep.addAll(diff.entriesOnlyOnRight().keySet());
/* 350 */         entriesToKeep.addAll(diff.entriesDiffering().keySet());
/*     */         
/* 352 */         for (String e : entriesToKeep) {
/*     */           
/* 354 */           ResourceLocation rl = ResourceLocation.parse(e);
/* 355 */           Path endPath = Paths.get(customDatapackFolder.toString(), new String[] { "data", rl.getNamespace(), "legendarysurvivaloverhaul", "temperature", "dimensions" });
/* 356 */           if (!endPath.toFile().exists())
/*     */           {
/* 358 */             createDirectories(endPath);
/*     */           }
/*     */           
/* 361 */           File jsonFile = new File(endPath.toFile(), rl.getPath() + ".json");
/* 362 */           TemperatureDimensionData tdd = new TemperatureDimensionData();
/* 363 */           tdd.temperature(((JsonTemperature)JsonConfig.dimensionTemperatures.get(e)).temperature);
/* 364 */           if (!rl.equals(ResourceLocation.parse("the_nether")) && !rl.equals(ResourceLocation.parse("the_end")))
/*     */           {
/* 366 */             tdd.hasAltitude().seaLevelHeight(64);
/*     */           }
/*     */           
/* 369 */           writeInFile(jsonFile, tdd.build());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 374 */     Map<String, JsonBiomeIdentity> jsonBiomeIdentities = processJson(JsonFileName.BIOME_TEMP, jsonDir);
/*     */     
/* 376 */     if (jsonBiomeIdentities != null) {
/*     */ 
/*     */ 
/*     */       
/* 380 */       LegendarySurvivalOverhaul.LOGGER.debug("Loaded " + jsonBiomeIdentities.size() + " biome temperature overrides from JSON");
/* 381 */       for (Map.Entry<String, JsonBiomeIdentity> entry : jsonBiomeIdentities.entrySet())
/*     */       {
/* 383 */         JsonConfig.registerBiomeOverride(entry.getKey(), ((JsonBiomeIdentity)entry.getValue()).temperature, ((JsonBiomeIdentity)entry.getValue()).isDry);
/*     */       }
/*     */       
/* 386 */       MapDifference<String, JsonBiomeIdentity> diff = Maps.difference((Map)gson.fromJson(gson.toJson(JsonConfig.defaultBiomeOverrides, Objects.<Type>requireNonNull(JsonTypeToken.get(JsonFileName.BIOME_TEMP))), Map.class), (Map)gson.fromJson(gson.toJson(JsonConfig.biomeOverrides, Objects.<Type>requireNonNull(JsonTypeToken.get(JsonFileName.BIOME_TEMP))), Map.class));
/*     */       
/* 388 */       List<String> entriesToKeep = new ArrayList<>();
/* 389 */       if (!diff.entriesOnlyOnRight().isEmpty() || !diff.entriesDiffering().isEmpty()) {
/*     */         
/* 391 */         entriesToKeep.addAll(diff.entriesOnlyOnRight().keySet());
/* 392 */         entriesToKeep.addAll(diff.entriesDiffering().keySet());
/*     */         
/* 394 */         for (String e : entriesToKeep) {
/*     */           
/* 396 */           ResourceLocation rl = ResourceLocation.parse(e);
/* 397 */           Path endPath = Paths.get(customDatapackFolder.toString(), new String[] { "data", rl.getNamespace(), "legendarysurvivaloverhaul", "temperature", "biomes" });
/* 398 */           if (!endPath.toFile().exists())
/*     */           {
/* 400 */             createDirectories(endPath);
/*     */           }
/*     */           
/* 403 */           File jsonFile = new File(endPath.toFile(), rl.getPath() + ".json");
/* 404 */           TemperatureBiomeOverrideData td = new TemperatureBiomeOverrideData();
/* 405 */           td.temperature(((JsonBiomeIdentity)JsonConfig.biomeOverrides.get(e)).temperature);
/* 406 */           td.isDry(((JsonBiomeIdentity)JsonConfig.biomeOverrides.get(e)).isDry);
/*     */           
/* 408 */           writeInFile(jsonFile, td.build());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 413 */     Map<String, JsonTemperatureResistance> jsonItemTemperatures = processJson(JsonFileName.ITEM_TEMP, jsonDir);
/*     */     
/* 415 */     if (jsonItemTemperatures != null) {
/*     */ 
/*     */ 
/*     */       
/* 419 */       LegendarySurvivalOverhaul.LOGGER.debug("Loaded " + jsonItemTemperatures.size() + " item temperature values from JSON");
/* 420 */       for (Map.Entry<String, JsonTemperatureResistance> entry : jsonItemTemperatures.entrySet())
/*     */       {
/* 422 */         JsonConfig.registerItemTemperature(entry.getKey(), ((JsonTemperatureResistance)entry.getValue()).temperature, ((JsonTemperatureResistance)entry.getValue()).heatResistance, ((JsonTemperatureResistance)entry.getValue()).coldResistance, ((JsonTemperatureResistance)entry.getValue()).thermalResistance);
/*     */       }
/*     */       
/* 425 */       MapDifference<String, JsonBiomeIdentity> diff = Maps.difference((Map)gson.fromJson(gson.toJson(JsonConfig.defaultItemTemperatures, Objects.<Type>requireNonNull(JsonTypeToken.get(JsonFileName.ITEM_TEMP))), Map.class), (Map)gson.fromJson(gson.toJson(JsonConfig.itemTemperatures, Objects.<Type>requireNonNull(JsonTypeToken.get(JsonFileName.ITEM_TEMP))), Map.class));
/*     */       
/* 427 */       List<String> entriesToKeep = new ArrayList<>();
/* 428 */       if (!diff.entriesOnlyOnRight().isEmpty() || !diff.entriesDiffering().isEmpty()) {
/*     */         
/* 430 */         entriesToKeep.addAll(diff.entriesOnlyOnRight().keySet());
/* 431 */         entriesToKeep.addAll(diff.entriesDiffering().keySet());
/*     */         
/* 433 */         for (String e : entriesToKeep) {
/*     */           
/* 435 */           ResourceLocation rl = ResourceLocation.parse(e);
/* 436 */           Path endPath = Paths.get(customDatapackFolder.toString(), new String[] { "data", rl.getNamespace(), "legendarysurvivaloverhaul", "temperature", "items" });
/* 437 */           if (!endPath.toFile().exists())
/*     */           {
/* 439 */             createDirectories(endPath);
/*     */           }
/*     */           
/* 442 */           File jsonFile = new File(endPath.toFile(), rl.getPath() + ".json");
/* 443 */           TemperatureResistanceData td = new TemperatureResistanceData();
/* 444 */           td.temperature(((JsonTemperatureResistance)JsonConfig.itemTemperatures.get(e)).temperature);
/* 445 */           td.heatResistance(((JsonTemperatureResistance)JsonConfig.itemTemperatures.get(e)).heatResistance);
/* 446 */           td.coldResistance(((JsonTemperatureResistance)JsonConfig.itemTemperatures.get(e)).coldResistance);
/* 447 */           td.thermalResistance(((JsonTemperatureResistance)JsonConfig.itemTemperatures.get(e)).thermalResistance);
/*     */           
/* 449 */           writeInFile(jsonFile, td.build());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 454 */     Map<String, JsonTemperature> jsonEntityTemperatures = processJson(JsonFileName.ENTITY_TEMP, jsonDir);
/*     */     
/* 456 */     if (jsonEntityTemperatures != null) {
/*     */ 
/*     */ 
/*     */       
/* 460 */       LegendarySurvivalOverhaul.LOGGER.debug("Loaded " + jsonEntityTemperatures.size() + " entity temperature values from JSON");
/* 461 */       for (Map.Entry<String, JsonTemperature> entry : jsonEntityTemperatures.entrySet())
/*     */       {
/* 463 */         JsonConfig.registerEntityTemperature(entry.getKey(), ((JsonTemperature)entry.getValue()).temperature);
/*     */       }
/*     */       
/* 466 */       MapDifference<String, JsonBiomeIdentity> diff = Maps.difference((Map)gson.fromJson(gson.toJson(JsonConfig.defaultEntityTemperatures, Objects.<Type>requireNonNull(JsonTypeToken.get(JsonFileName.ENTITY_TEMP))), Map.class), (Map)gson.fromJson(gson.toJson(JsonConfig.entityTemperatures, Objects.<Type>requireNonNull(JsonTypeToken.get(JsonFileName.ENTITY_TEMP))), Map.class));
/*     */       
/* 468 */       List<String> entriesToKeep = new ArrayList<>();
/* 469 */       if (!diff.entriesOnlyOnRight().isEmpty() || !diff.entriesDiffering().isEmpty()) {
/*     */         
/* 471 */         entriesToKeep.addAll(diff.entriesOnlyOnRight().keySet());
/* 472 */         entriesToKeep.addAll(diff.entriesDiffering().keySet());
/*     */         
/* 474 */         for (String e : entriesToKeep) {
/*     */           
/* 476 */           ResourceLocation rl = ResourceLocation.parse(e);
/* 477 */           Path endPath = Paths.get(customDatapackFolder.toString(), new String[] { "data", rl.getNamespace(), "legendarysurvivaloverhaul", "temperature", "entities" });
/* 478 */           if (!endPath.toFile().exists())
/*     */           {
/* 480 */             createDirectories(endPath);
/*     */           }
/*     */           
/* 483 */           File jsonFile = new File(endPath.toFile(), rl.getPath() + ".json");
/* 484 */           TemperatureData td = new TemperatureData();
/* 485 */           td.temperature(((JsonTemperature)JsonConfig.entityTemperatures.get(e)).temperature);
/*     */           
/* 487 */           writeInFile(jsonFile, td.build());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 492 */     Map<String, List<JsonBlockFluidTemperature>> jsonBlockFluidTemperatures = processJson(JsonFileName.BLOCK_TEMP, jsonDir);
/*     */     
/* 494 */     if (jsonBlockFluidTemperatures != null) {
/*     */ 
/*     */ 
/*     */       
/* 498 */       LegendarySurvivalOverhaul.LOGGER.debug("Loaded " + jsonBlockFluidTemperatures.size() + " block/fluid temperature values from JSON");
/* 499 */       for (Map.Entry<String, List<JsonBlockFluidTemperature>> entry : jsonBlockFluidTemperatures.entrySet()) {
/*     */         
/* 501 */         for (JsonBlockFluidTemperature propTemp : entry.getValue())
/*     */         {
/* 503 */           JsonConfig.registerBlockFluidTemperature(entry.getKey(), propTemp.temperature, propTemp.getPropertyArray());
/*     */         }
/*     */       } 
/*     */       
/* 507 */       MapDifference<String, List<JsonBlockFluidTemperature>> diff = Maps.difference((Map)gson.fromJson(gson.toJson(JsonConfig.defaultBlockFluidTemperatures, Objects.<Type>requireNonNull(JsonTypeToken.get(JsonFileName.BLOCK_TEMP))), Map.class), (Map)gson.fromJson(gson.toJson(JsonConfig.blockFluidTemperatures, Objects.<Type>requireNonNull(JsonTypeToken.get(JsonFileName.BLOCK_TEMP))), Map.class));
/*     */       
/* 509 */       List<String> entriesToKeep = new ArrayList<>();
/* 510 */       if (!diff.entriesOnlyOnRight().isEmpty() || !diff.entriesDiffering().isEmpty()) {
/*     */         
/* 512 */         entriesToKeep.addAll(diff.entriesOnlyOnRight().keySet());
/* 513 */         entriesToKeep.addAll(diff.entriesDiffering().keySet());
/*     */         
/* 515 */         for (String e : entriesToKeep) {
/*     */           
/* 517 */           ResourceLocation rl = ResourceLocation.parse(e);
/* 518 */           Path endPath = Paths.get(customDatapackFolder.toString(), new String[] { "data", rl.getNamespace(), "legendarysurvivaloverhaul", "temperature", "blocks" });
/* 519 */           if (!endPath.toFile().exists())
/*     */           {
/* 521 */             createDirectories(endPath);
/*     */           }
/*     */           
/* 524 */           File jsonFile = new File(endPath.toFile(), rl.getPath() + ".json");
/* 525 */           JsonArray ja = new JsonArray();
/* 526 */           for (JsonBlockFluidTemperature jbft : JsonConfig.blockFluidTemperatures.get(e)) {
/*     */             
/* 528 */             TemperatureBlockData tbd = new TemperatureBlockData();
/* 529 */             tbd.temperature(jbft.temperature);
/* 530 */             for (Map.Entry<String, String> prop : (Iterable<Map.Entry<String, String>>)jbft.properties.entrySet())
/*     */             {
/* 532 */               tbd.addProperty(prop.getKey(), prop.getValue());
/*     */             }
/* 534 */             ja.add((JsonElement)tbd.build());
/*     */           } 
/*     */           
/* 537 */           writeInFile(jsonFile, ja);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 542 */     Map<String, JsonFuelItem> jsonFuelItemIdentities = processJson(JsonFileName.FUEL, jsonDir);
/*     */     
/* 544 */     if (jsonFuelItemIdentities != null) {
/*     */ 
/*     */ 
/*     */       
/* 548 */       LegendarySurvivalOverhaul.LOGGER.debug("Loaded " + jsonFuelItemIdentities.size() + " fuel item values from JSON");
/* 549 */       for (Map.Entry<String, JsonFuelItem> entry : jsonFuelItemIdentities.entrySet())
/*     */       {
/* 551 */         JsonConfig.registerFuelItems(entry.getKey(), ((JsonFuelItem)entry.getValue()).thermalType, ((JsonFuelItem)entry.getValue()).fuelValue);
/*     */       }
/*     */       
/* 554 */       MapDifference<String, JsonFuelItem> diff = Maps.difference((Map)gson.fromJson(gson.toJson(JsonConfig.defaultFuelItems, Objects.<Type>requireNonNull(JsonTypeToken.get(JsonFileName.FUEL))), Map.class), (Map)gson.fromJson(gson.toJson(JsonConfig.fuelItems, Objects.<Type>requireNonNull(JsonTypeToken.get(JsonFileName.FUEL))), Map.class));
/*     */       
/* 556 */       List<String> entriesToKeep = new ArrayList<>();
/* 557 */       if (!diff.entriesOnlyOnRight().isEmpty() || !diff.entriesDiffering().isEmpty()) {
/*     */         
/* 559 */         entriesToKeep.addAll(diff.entriesOnlyOnRight().keySet());
/* 560 */         entriesToKeep.addAll(diff.entriesDiffering().keySet());
/*     */         
/* 562 */         for (String e : entriesToKeep) {
/*     */           
/* 564 */           ResourceLocation rl = ResourceLocation.parse(e);
/* 565 */           Path endPath = Paths.get(customDatapackFolder.toString(), new String[] { "data", rl.getNamespace(), "legendarysurvivaloverhaul", "temperature", "fuel_items" });
/* 566 */           if (!endPath.toFile().exists())
/*     */           {
/* 568 */             createDirectories(endPath);
/*     */           }
/*     */           
/* 571 */           File jsonFile = new File(endPath.toFile(), rl.getPath() + ".json");
/* 572 */           TemperatureFuelItemData td = new TemperatureFuelItemData();
/* 573 */           td.thermalType(((JsonFuelItem)JsonConfig.fuelItems.get(e)).thermalType);
/* 574 */           td.duration(((JsonFuelItem)JsonConfig.fuelItems.get(e)).fuelValue * 20);
/*     */           
/* 576 */           writeInFile(jsonFile, td.build());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 581 */     Map<String, List<JsonConsumableTemperature>> jsonConsumableTemperatures = processJson(JsonFileName.CONSUMABLE_TEMP, jsonDir);
/*     */     
/* 583 */     if (jsonConsumableTemperatures != null) {
/*     */ 
/*     */ 
/*     */       
/* 587 */       LegendarySurvivalOverhaul.LOGGER.debug("Loaded " + jsonConsumableTemperatures.size() + " consumable temperature values from JSON");
/* 588 */       for (Map.Entry<String, List<JsonConsumableTemperature>> entry : jsonConsumableTemperatures.entrySet()) {
/*     */         
/* 590 */         for (JsonConsumableTemperature jct : entry.getValue())
/*     */         {
/* 592 */           JsonConfig.registerConsumableTemperature(jct.group, entry.getKey(), jct.temperatureLevel, jct.duration);
/*     */         }
/*     */       } 
/*     */       
/* 596 */       MapDifference<String, JsonConsumableTemperature> diff = Maps.difference((Map)gson.fromJson(gson.toJson(JsonConfig.defaultConsumableTemperature, Objects.<Type>requireNonNull(JsonTypeToken.get(JsonFileName.CONSUMABLE_TEMP))), Map.class), (Map)gson.fromJson(gson.toJson(JsonConfig.consumableTemperature, Objects.<Type>requireNonNull(JsonTypeToken.get(JsonFileName.CONSUMABLE_TEMP))), Map.class));
/*     */       
/* 598 */       List<String> entriesToKeep = new ArrayList<>();
/* 599 */       if (!diff.entriesOnlyOnRight().isEmpty() || !diff.entriesDiffering().isEmpty()) {
/*     */         
/* 601 */         entriesToKeep.addAll(diff.entriesOnlyOnRight().keySet());
/* 602 */         entriesToKeep.addAll(diff.entriesDiffering().keySet());
/*     */         
/* 604 */         for (String e : entriesToKeep) {
/*     */           
/* 606 */           ResourceLocation rl = ResourceLocation.parse(e);
/* 607 */           Path endPath = Paths.get(customDatapackFolder.toString(), new String[] { "data", rl.getNamespace(), "legendarysurvivaloverhaul", "temperature", "consumables" });
/* 608 */           if (!endPath.toFile().exists())
/*     */           {
/* 610 */             createDirectories(endPath);
/*     */           }
/*     */           
/* 613 */           File jsonFile = new File(endPath.toFile(), rl.getPath() + ".json");
/* 614 */           JsonArray ja = new JsonArray();
/* 615 */           for (JsonConsumableTemperature jct : JsonConfig.consumableTemperature.get(e)) {
/*     */             
/* 617 */             TemperatureConsumableData tcd = new TemperatureConsumableData();
/* 618 */             tcd.group(jct.group);
/* 619 */             tcd.duration(jct.duration);
/* 620 */             tcd.temperatureLevel(jct.temperatureLevel);
/* 621 */             ja.add((JsonElement)tcd.build());
/*     */           } 
/*     */           
/* 624 */           writeInFile(jsonFile, ja);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 631 */     Map<String, List<JsonBlockFluidThirst>> jsonBlockFluidThirsts = processJson(JsonFileName.BLOCK_THIRST, jsonDir);
/*     */     
/* 633 */     if (jsonBlockFluidThirsts != null) {
/*     */ 
/*     */ 
/*     */       
/* 637 */       LegendarySurvivalOverhaul.LOGGER.debug("Loaded " + jsonBlockFluidThirsts.size() + " block/fluid thirst values from JSON");
/* 638 */       for (Map.Entry<String, List<JsonBlockFluidThirst>> entry : jsonBlockFluidThirsts.entrySet()) {
/*     */         
/* 640 */         for (JsonBlockFluidThirst propThirst : entry.getValue())
/*     */         {
/* 642 */           JsonConfig.registerBlockFluidThirst(entry.getKey(), propThirst.hydration, propThirst.saturation, (JsonEffectParameter[])propThirst.effects.toArray((Object[])new JsonEffectParameter[0]), propThirst.getPropertyArray());
/*     */         }
/*     */       } 
/*     */       
/* 646 */       MapDifference<String, List<JsonBlockFluidThirst>> diff = Maps.difference((Map)gson.fromJson(gson.toJson(JsonConfig.defaultBlockFluidThirst, Objects.<Type>requireNonNull(JsonTypeToken.get(JsonFileName.BLOCK_THIRST))), Map.class), (Map)gson.fromJson(gson.toJson(JsonConfig.blockFluidThirst, Objects.<Type>requireNonNull(JsonTypeToken.get(JsonFileName.BLOCK_THIRST))), Map.class));
/*     */       
/* 648 */       List<String> entriesToKeep = new ArrayList<>();
/* 649 */       if (!diff.entriesOnlyOnRight().isEmpty() || !diff.entriesDiffering().isEmpty()) {
/*     */         
/* 651 */         entriesToKeep.addAll(diff.entriesOnlyOnRight().keySet());
/* 652 */         entriesToKeep.addAll(diff.entriesDiffering().keySet());
/*     */         
/* 654 */         for (String e : entriesToKeep) {
/*     */           
/* 656 */           ResourceLocation rl = ResourceLocation.parse(e);
/* 657 */           Path endPath = Paths.get(customDatapackFolder.toString(), new String[] { "data", rl.getNamespace(), "legendarysurvivaloverhaul", "thirst", "blocks" });
/* 658 */           if (!endPath.toFile().exists())
/*     */           {
/* 660 */             createDirectories(endPath);
/*     */           }
/*     */           
/* 663 */           File jsonFile = new File(endPath.toFile(), rl.getPath() + ".json");
/* 664 */           JsonArray ja = new JsonArray();
/* 665 */           for (JsonBlockFluidThirst jbft : JsonConfig.blockFluidThirst.get(e)) {
/*     */             
/* 667 */             ThirstData td = new ThirstData();
/* 668 */             td.hydration(jbft.hydration);
/* 669 */             td.saturation(jbft.saturation);
/* 670 */             for (JsonEffectParameter jep : jbft.effects) {
/*     */               
/* 672 */               MobEffect me = (MobEffect)BuiltInRegistries.MOB_EFFECT.get(ResourceLocation.parse(jep.name));
/* 673 */               if (me != null)
/* 674 */                 td.addEffect(me, jep.duration, jep.chance, jep.amplifier); 
/*     */             } 
/* 676 */             for (Map.Entry<String, String> prop : (Iterable<Map.Entry<String, String>>)jbft.properties.entrySet())
/*     */             {
/* 678 */               td.addProperty(prop.getKey(), prop.getValue());
/*     */             }
/* 680 */             ja.add((JsonElement)td.build());
/*     */           } 
/*     */           
/* 683 */           writeInFile(jsonFile, ja);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 688 */     Map<String, List<JsonConsumableThirst>> jsonConsumableThirsts = processJson(JsonFileName.CONSUMABLE_THIRST, jsonDir);
/*     */     
/* 690 */     if (jsonConsumableThirsts != null) {
/*     */ 
/*     */ 
/*     */       
/* 694 */       LegendarySurvivalOverhaul.LOGGER.debug("Loaded " + jsonConsumableThirsts.size() + " consumable thirst values from JSON");
/* 695 */       for (Map.Entry<String, List<JsonConsumableThirst>> entry : jsonConsumableThirsts.entrySet()) {
/*     */         
/* 697 */         for (JsonConsumableThirst jct : entry.getValue()) {
/* 698 */           JsonConfig.registerConsumableThirst(entry.getKey(), jct.hydration, jct.saturation, (JsonEffectParameter[])jct.effects.toArray((Object[])new JsonEffectParameter[0]), jct.getNbtArray());
/*     */         }
/*     */       } 
/* 701 */       MapDifference<String, List<JsonConsumableThirst>> diff = Maps.difference((Map)gson.fromJson(gson.toJson(JsonConfig.defaultConsumableThirst, Objects.<Type>requireNonNull(JsonTypeToken.get(JsonFileName.CONSUMABLE_THIRST))), Map.class), (Map)gson.fromJson(gson.toJson(JsonConfig.consumableThirst, Objects.<Type>requireNonNull(JsonTypeToken.get(JsonFileName.CONSUMABLE_THIRST))), Map.class));
/*     */       
/* 703 */       List<String> entriesToKeep = new ArrayList<>();
/* 704 */       if (!diff.entriesOnlyOnRight().isEmpty() || !diff.entriesDiffering().isEmpty()) {
/*     */         
/* 706 */         entriesToKeep.addAll(diff.entriesOnlyOnRight().keySet());
/* 707 */         entriesToKeep.addAll(diff.entriesDiffering().keySet());
/*     */         
/* 709 */         for (String e : entriesToKeep) {
/*     */           
/* 711 */           ResourceLocation rl = ResourceLocation.parse(e);
/* 712 */           Path endPath = Paths.get(customDatapackFolder.toString(), new String[] { "data", rl.getNamespace(), "legendarysurvivaloverhaul", "thirst", "consumables" });
/* 713 */           if (!endPath.toFile().exists())
/*     */           {
/* 715 */             createDirectories(endPath);
/*     */           }
/*     */           
/* 718 */           File jsonFile = new File(endPath.toFile(), rl.getPath() + ".json");
/* 719 */           JsonArray ja = new JsonArray();
/* 720 */           for (JsonConsumableThirst jct : JsonConfig.consumableThirst.get(e)) {
/*     */             
/* 722 */             ThirstData td = new ThirstData();
/* 723 */             td.hydration(jct.hydration);
/* 724 */             td.saturation(jct.saturation);
/* 725 */             for (JsonEffectParameter jep : jct.effects) {
/*     */               
/* 727 */               MobEffect me = (MobEffect)BuiltInRegistries.MOB_EFFECT.get(ResourceLocation.parse(jep.name));
/* 728 */               if (me != null)
/* 729 */                 td.addEffect(me, jep.duration, jep.chance, jep.amplifier); 
/*     */             } 
/* 731 */             for (Map.Entry<String, String> prop : (Iterable<Map.Entry<String, String>>)jct.nbt.entrySet())
/*     */             {
/* 733 */               td.addProperty(prop.getKey(), prop.getValue());
/*     */             }
/* 735 */             ja.add((JsonElement)td.build());
/*     */           } 
/*     */           
/* 738 */           writeInFile(jsonFile, ja);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 744 */     Map<String, JsonConsumableHeal> jsonConsumableHeal = processJson(JsonFileName.CONSUMABLE_HEAL, jsonDir);
/*     */     
/* 746 */     if (jsonConsumableHeal != null) {
/*     */ 
/*     */ 
/*     */       
/* 750 */       LegendarySurvivalOverhaul.LOGGER.debug("Loaded " + jsonConsumableHeal.size() + " consumable heal values from JSON");
/* 751 */       for (Map.Entry<String, JsonConsumableHeal> entry : jsonConsumableHeal.entrySet())
/*     */       {
/* 753 */         JsonConfig.registerConsumableHeal(entry.getKey(), ((JsonConsumableHeal)entry.getValue()).healingCharges, ((JsonConsumableHeal)entry.getValue()).healingValue, ((JsonConsumableHeal)entry.getValue()).healingTime);
/*     */       }
/*     */       
/* 756 */       MapDifference<String, JsonConsumableHeal> diff = Maps.difference((Map)gson.fromJson(gson.toJson(JsonConfig.defaultConsumableHeal, Objects.<Type>requireNonNull(JsonTypeToken.get(JsonFileName.CONSUMABLE_HEAL))), Map.class), (Map)gson.fromJson(gson.toJson(JsonConfig.consumableHeal, Objects.<Type>requireNonNull(JsonTypeToken.get(JsonFileName.CONSUMABLE_HEAL))), Map.class));
/*     */       
/* 758 */       List<String> entriesToKeep = new ArrayList<>();
/* 759 */       if (!diff.entriesOnlyOnRight().isEmpty() || !diff.entriesDiffering().isEmpty()) {
/*     */         
/* 761 */         entriesToKeep.addAll(diff.entriesOnlyOnRight().keySet());
/* 762 */         entriesToKeep.addAll(diff.entriesDiffering().keySet());
/*     */         
/* 764 */         for (String e : entriesToKeep) {
/*     */           
/* 766 */           ResourceLocation rl = ResourceLocation.parse(e);
/* 767 */           Path endPath = Paths.get(customDatapackFolder.toString(), new String[] { "data", rl.getNamespace(), "legendarysurvivaloverhaul", "body_damage", "consumables" });
/* 768 */           if (!endPath.toFile().exists())
/*     */           {
/* 770 */             createDirectories(endPath);
/*     */           }
/*     */           
/* 773 */           File jsonFile = new File(endPath.toFile(), rl.getPath() + ".json");
/* 774 */           HealingConsumableData td = new HealingConsumableData();
/* 775 */           td.duration(((JsonConsumableHeal)JsonConfig.consumableHeal.get(e)).healingTime);
/* 776 */           td.healingCharges(((JsonConsumableHeal)JsonConfig.consumableHeal.get(e)).healingCharges);
/* 777 */           td.healingValue(((JsonConsumableHeal)JsonConfig.consumableHeal.get(e)).healingValue);
/*     */           
/* 779 */           writeInFile(jsonFile, td.build());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 785 */     Map<String, JsonBodyPartsDamageSource> jsonDamageSourceBodyParts = processJson(JsonFileName.DAMAGE_SOURCE_BODY_PARTS, jsonDir);
/*     */     
/* 787 */     if (jsonDamageSourceBodyParts != null) {
/*     */ 
/*     */ 
/*     */       
/* 791 */       LegendarySurvivalOverhaul.LOGGER.debug("Loaded " + jsonDamageSourceBodyParts.size() + " damage source body part values from JSON");
/* 792 */       for (Map.Entry<String, JsonBodyPartsDamageSource> entry : jsonDamageSourceBodyParts.entrySet())
/*     */       {
/* 794 */         JsonConfig.registerDamageSourceBodyParts(entry.getKey(), ((JsonBodyPartsDamageSource)entry.getValue()).damageDistribution, ((JsonBodyPartsDamageSource)entry.getValue()).bodyParts);
/*     */       }
/*     */       
/* 797 */       MapDifference<String, JsonBodyPartsDamageSource> diff = Maps.difference((Map)gson.fromJson(gson.toJson(JsonConfig.defaultDamageSourceBodyParts, Objects.<Type>requireNonNull(JsonTypeToken.get(JsonFileName.DAMAGE_SOURCE_BODY_PARTS))), Map.class), (Map)gson.fromJson(gson.toJson(JsonConfig.damageSourceBodyParts, Objects.<Type>requireNonNull(JsonTypeToken.get(JsonFileName.DAMAGE_SOURCE_BODY_PARTS))), Map.class));
/*     */       
/* 799 */       List<String> entriesToKeep = new ArrayList<>();
/* 800 */       if (!diff.entriesOnlyOnRight().isEmpty() || !diff.entriesDiffering().isEmpty()) {
/*     */         
/* 802 */         entriesToKeep.addAll(diff.entriesOnlyOnRight().keySet());
/* 803 */         entriesToKeep.addAll(diff.entriesDiffering().keySet());
/*     */         
/* 805 */         for (String e : entriesToKeep) {
/*     */           
/* 807 */           ResourceLocation rl = ResourceLocation.parse(e);
/* 808 */           Path endPath = Paths.get(customDatapackFolder.toString(), new String[] { "data", rl.getNamespace(), "legendarysurvivaloverhaul", "body_damage", "damage_sources" });
/* 809 */           if (!endPath.toFile().exists())
/*     */           {
/* 811 */             createDirectories(endPath);
/*     */           }
/*     */           
/* 814 */           File jsonFile = new File(endPath.toFile(), rl.getPath() + ".json");
/* 815 */           BodyPartsDamageSourceData td = new BodyPartsDamageSourceData();
/* 816 */           td.addBodyParts(((JsonBodyPartsDamageSource)JsonConfig.damageSourceBodyParts.get(e)).bodyParts);
/* 817 */           td.damageDistribution(((JsonBodyPartsDamageSource)JsonConfig.damageSourceBodyParts.get(e)).damageDistribution);
/*     */           
/* 819 */           writeInFile(jsonFile, td.build());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 824 */     if (customDatapackFolder.toFile().exists()) {
/*     */       
/* 826 */       JsonObject packMcMetaContent = new JsonObject();
/* 827 */       JsonObject packMcMetaContent2 = new JsonObject();
/* 828 */       packMcMetaContent2.addProperty("pack_format", Integer.valueOf(10));
/* 829 */       packMcMetaContent2.addProperty("description", "Legendary Survival Overhaul datapack (modifies temperature/thirst/body damage values)");
/* 830 */       packMcMetaContent.add("pack", (JsonElement)packMcMetaContent2);
/* 831 */       File packMcMeta = new File(customDatapackFolder.toFile(), "pack.mcmeta");
/* 832 */       writeInFile(packMcMeta, packMcMetaContent);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public static <T> T processJson(JsonFileName jfn, File jsonDir) {
/*     */     try {
/* 841 */       return processUncaughtJson(jfn, jsonDir);
/* 842 */     } catch (Exception e) {
/*     */       
/* 844 */       LegendarySurvivalOverhaul.LOGGER.error("Error managing JSON file: " + jfn.get(), e);
/*     */       
/* 846 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public static <T> T processUncaughtJson(JsonFileName jfn, File jsonDir) throws Exception {
/* 854 */     String jsonFileName = jfn.get();
/* 855 */     Type type = JsonTypeToken.get(jfn);
/*     */     
/* 857 */     File jsonFile = new File(jsonDir, jsonFileName);
/*     */     
/* 859 */     if (jsonFile.exists()) {
/*     */       
/* 861 */       Gson gson = buildNewGson();
/*     */       
/* 863 */       return (T)gson.fromJson(new FileReader(jsonFile), type);
/*     */     } 
/* 865 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void deleteJson(JsonFileName jfn, File jsonDir) {
/* 871 */     String jsonFileName = jfn.get();
/* 872 */     File jsonFile = new File(jsonDir, jsonFileName);
/*     */     
/* 874 */     if (jsonFile.exists())
/*     */     {
/* 876 */       jsonFile.delete();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> void manuallyWriteToJson(JsonFileName jfn, T container, File jsonDir) {
/*     */     try {
/* 884 */       manuallyWriteToJson(jfn, container, jsonDir, false);
/* 885 */     } catch (Exception e) {
/*     */       
/* 887 */       LegendarySurvivalOverhaul.LOGGER.error("Error writing " + String.valueOf(jfn) + " JSON file", e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static <T> void manuallyWriteToJson(JsonFileName jfn, T container, File jsonDir, boolean forceWrite) throws Exception {
/* 893 */     String jsonFileName = jfn.get();
/* 894 */     Type type = JsonTypeToken.get(jfn);
/*     */     
/* 896 */     Gson gson = buildNewGson();
/* 897 */     File jsonFile = new File(jsonDir, jsonFileName);
/* 898 */     if (jsonFile.exists()) {
/*     */       
/* 900 */       LegendarySurvivalOverhaul.LOGGER.debug(jsonFile.getName() + " already exists!");
/*     */       
/* 902 */       if (forceWrite) {
/* 903 */         LegendarySurvivalOverhaul.LOGGER.debug("Overriding...");
/*     */       } else {
/*     */         return;
/*     */       } 
/* 907 */     }  FileUtils.write(jsonFile, gson.toJson(container, type), (String)null);
/*     */   }
/*     */ 
/*     */   
/*     */   private static Gson buildNewGson() {
/* 912 */     return (new GsonBuilder()).setPrettyPrinting().excludeFieldsWithModifiers(new int[] { 2 }).create();
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\config\json_old\JsonConfigRegistration.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */