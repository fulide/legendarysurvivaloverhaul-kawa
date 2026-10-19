/*      */ package sfiomn.legendarysurvivaloverhaul.config;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.nio.file.FileAlreadyExistsException;
/*      */ import java.nio.file.Files;
/*      */ import java.nio.file.Path;
/*      */ import java.nio.file.attribute.FileAttribute;
/*      */ import java.util.Collections;
/*      */ import java.util.List;
/*      */ import java.util.function.Function;
/*      */ import net.minecraft.resources.ResourceLocation;
/*      */ import net.neoforged.fml.ModLoadingContext;
/*      */ import net.neoforged.fml.config.IConfigSpec;
/*      */ import net.neoforged.fml.config.ModConfig;
/*      */ import net.neoforged.neoforge.common.ModConfigSpec;
/*      */ import org.apache.commons.lang3.tuple.Pair;
/*      */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*      */ import sfiomn.legendarysurvivaloverhaul.config.json_old.JsonConfigRegistration;
/*      */ import sfiomn.legendarysurvivaloverhaul.util.EnumUtil;
/*      */ 
/*      */ 
/*      */ public class Config
/*      */ {
/*      */   public static final ModConfigSpec COMMON_SPEC;
/*      */   public static final Common COMMON;
/*      */   public static final ModConfigSpec CLIENT_SPEC;
/*      */   public static final Client CLIENT;
/*      */   
/*      */   static {
/*   30 */     Pair<Common, ModConfigSpec> common = (new ModConfigSpec.Builder()).configure(Common::new);
/*   31 */     COMMON_SPEC = (ModConfigSpec)common.getRight();
/*   32 */     COMMON = (Common)common.getLeft();
/*      */     
/*   34 */     Pair<Client, ModConfigSpec> client = (new ModConfigSpec.Builder()).configure(Client::new);
/*   35 */     CLIENT_SPEC = (ModConfigSpec)client.getRight();
/*   36 */     CLIENT = (Client)client.getLeft();
/*      */   }
/*      */ 
/*      */   
/*      */   public static void register() {
/*   41 */     for (Path configPath : new Path[] { LegendarySurvivalOverhaul.modConfigPath }) {
/*      */ 
/*      */       
/*      */       try {
/*   45 */         Files.createDirectory(configPath, (FileAttribute<?>[])new FileAttribute[0]);
/*   46 */       } catch (FileAlreadyExistsException fileAlreadyExistsException) {
/*      */       
/*   48 */       } catch (IOException e) {
/*      */         
/*   50 */         LegendarySurvivalOverhaul.LOGGER.error("Failed to create Legendary Survival Overhaul config directory " + String.valueOf(configPath));
/*   51 */         LegendarySurvivalOverhaul.LOGGER.error(e.getStackTrace());
/*      */       } 
/*      */     } 
/*      */     
/*   55 */     ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.CLIENT, (IConfigSpec)CLIENT_SPEC, "legendarysurvivaloverhaul-client.toml");
/*   56 */     ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.COMMON, (IConfigSpec)COMMON_SPEC, "legendarysurvivaloverhaul-common.toml");
/*      */     
/*   58 */     JsonConfigRegistration.init(LegendarySurvivalOverhaul.modConfigJsons.toFile());
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean validateDouble(Object obj) {
/*   63 */     return obj instanceof Double;
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean validatePositiveInt(Object obj) {
/*   68 */     if (obj instanceof Integer) { Integer intValue = (Integer)obj; if (intValue.intValue() >= 0); }  return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean validatePercentDouble(Object obj) {
/*   73 */     if (obj instanceof Double) { Double doubleValue = (Double)obj; if (doubleValue.doubleValue() >= 0.0D && doubleValue.doubleValue() <= 1.0D); }  return false;
/*      */   }
/*      */   
/*      */   private static boolean validateEffectName(Object obj) {
/*      */     String effectName;
/*   78 */     if (obj instanceof String) { effectName = (String)obj; }
/*   79 */     else { return false; }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/*   85 */       ResourceLocation.parse(effectName);
/*   86 */       return true;
/*      */     }
/*   88 */     catch (Exception e) {
/*      */       
/*   90 */       return false;
/*      */     } 
/*      */   }
/*      */   
/*      */   private static boolean validateEntityType(Object obj) {
/*      */     String entityName;
/*   96 */     if (obj instanceof String) { entityName = (String)obj; }
/*   97 */     else { return false; }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/*  103 */       ResourceLocation.parse(entityName);
/*  104 */       return true;
/*      */     }
/*  106 */     catch (Exception e) {
/*      */       
/*  108 */       return false;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static class Common
/*      */   {
/*      */     public final ModConfigSpec.IntValue routinePacketSync;
/*      */     
/*      */     public final ModConfigSpec.BooleanValue hideInfoFromDebug;
/*      */     
/*      */     public final ModConfigSpec.BooleanValue naturalRegenerationEnabled;
/*      */     
/*      */     public final ModConfigSpec.BooleanValue vanillaFreezeEnabled;
/*      */     
/*      */     public final ModConfigSpec.EnumValue<EnumUtil.CompassInfo> compassInfoMode;
/*      */     
/*      */     public final ModConfigSpec.BooleanValue showCoordinateOnMap;
/*      */     
/*      */     public final ModConfigSpec.DoubleValue initialHealth;
/*      */     
/*      */     public final ModConfigSpec.DoubleValue baseFoodExhaustion;
/*      */     
/*      */     public final ModConfigSpec.DoubleValue sprintingFoodExhaustion;
/*      */     
/*      */     public final ModConfigSpec.DoubleValue onAttackFoodExhaustion;
/*      */     
/*      */     public final ModConfigSpec.BooleanValue temperatureEnabled;
/*      */     
/*      */     public final ModConfigSpec.EnumValue<EnumUtil.DifficultyMode> difficultyMode;
/*      */     
/*      */     public final ModConfigSpec.IntValue tempTickTime;
/*      */     
/*      */     public final ModConfigSpec.DoubleValue minTemperatureModification;
/*      */     
/*      */     public final ModConfigSpec.DoubleValue maxTemperatureModification;
/*      */     
/*      */     public final ModConfigSpec.BooleanValue dangerousHeatTemperature;
/*      */     
/*      */     public final ModConfigSpec.BooleanValue dangerousColdTemperature;
/*      */     
/*      */     public final ModConfigSpec.DoubleValue goldFernChance;
/*      */     
/*      */     public final ModConfigSpec.BooleanValue temperatureImmunityOnDeathEnabled;
/*      */     
/*      */     public final ModConfigSpec.IntValue temperatureImmunityOnDeathTime;
/*      */     
/*      */     public final ModConfigSpec.BooleanValue temperatureImmunityOnFirstSpawnEnabled;
/*      */     
/*      */     public final ModConfigSpec.IntValue temperatureImmunityOnFirstSpawnTime;
/*      */     
/*      */     public final ModConfigSpec.BooleanValue heatTemperatureSecondaryEffects;
/*      */     
/*      */     public final ModConfigSpec.BooleanValue coldTemperatureSecondaryEffects;
/*      */     
/*      */     public final ModConfigSpec.DoubleValue heatThirstEffectModifier;
/*      */     
/*      */     public final ModConfigSpec.DoubleValue coldHungerEffectModifier;
/*      */     
/*      */     public final ModConfigSpec.BooleanValue biomeEffectsEnabled;
/*      */     
/*      */     public final ModConfigSpec.DoubleValue biomeDrynessMultiplier;
/*      */     
/*      */     public final ModConfigSpec.DoubleValue biomeTemperatureMultiplier;
/*      */     
/*      */     public final ModConfigSpec.DoubleValue timeModifier;
/*      */     
/*      */     public final ModConfigSpec.DoubleValue biomeTimeMultiplier;
/*      */     
/*      */     public final ModConfigSpec.DoubleValue shadeTimeModifier;
/*      */     
/*      */     public final ModConfigSpec.DoubleValue shadeTimeModifierThreshold;
/*      */     
/*      */     public final ModConfigSpec.DoubleValue altitudeModifier;
/*      */     
/*      */     public final ModConfigSpec.DoubleValue sprintModifier;
/*      */     
/*      */     public final ModConfigSpec.DoubleValue onFireModifier;
/*      */     
/*      */     public final ModConfigSpec.BooleanValue wetnessEnabled;
/*      */     
/*      */     public final ModConfigSpec.ConfigValue<List<? extends String>> wetnessImmunityMounts;
/*      */     
/*      */     public final ModConfigSpec.DoubleValue wetMultiplier;
/*      */     
/*      */     public final ModConfigSpec.IntValue wetnessTickTimer;
/*      */     
/*      */     public final ModConfigSpec.IntValue wetnessDecrease;
/*      */     
/*      */     public final ModConfigSpec.IntValue wetnessRainIncrease;
/*      */     
/*      */     public final ModConfigSpec.IntValue wetnessFluidIncrease;
/*      */     
/*      */     public final ModConfigSpec.IntValue tempInfluenceMaximumDist;
/*      */     
/*      */     public final ModConfigSpec.DoubleValue tempInfluenceUpDistMultiplier;
/*      */     
/*      */     public final ModConfigSpec.DoubleValue tempInfluenceInWaterDistMultiplier;
/*      */     
/*      */     public final ModConfigSpec.DoubleValue tempInfluenceOutsideDistMultiplier;
/*      */     
/*      */     public final ModConfigSpec.DoubleValue undergroundBiomeTemperatureMultiplier;
/*      */     public final ModConfigSpec.IntValue undergroundEffectStartDistanceToWS;
/*      */     public final ModConfigSpec.IntValue undergroundEffectEndDistanceToWS;
/*      */     public final ModConfigSpec.DoubleValue rainTemperatureModifier;
/*      */     public final ModConfigSpec.DoubleValue snowTemperatureModifier;
/*      */     public final ModConfigSpec.DoubleValue maxFreezeTemperatureModifier;
/*      */     public final ModConfigSpec.IntValue maxFreezeEffectTick;
/*      */     public final ModConfigSpec.DoubleValue playerHuddlingModifier;
/*      */     public final ModConfigSpec.IntValue playerHuddlingRadius;
/*      */     public final ModConfigSpec.DoubleValue heatingCoat1Modifier;
/*      */     public final ModConfigSpec.DoubleValue heatingCoat2Modifier;
/*      */     public final ModConfigSpec.DoubleValue heatingCoat3Modifier;
/*      */     public final ModConfigSpec.DoubleValue coolingCoat1Modifier;
/*      */     public final ModConfigSpec.DoubleValue coolingCoat2Modifier;
/*      */     public final ModConfigSpec.DoubleValue coolingCoat3Modifier;
/*      */     public final ModConfigSpec.DoubleValue thermalCoat1Modifier;
/*      */     public final ModConfigSpec.DoubleValue thermalCoat2Modifier;
/*      */     public final ModConfigSpec.DoubleValue thermalCoat3Modifier;
/*      */     public final ModConfigSpec.DoubleValue tfcItemHeatMultiplier;
/*      */     public final ModConfigSpec.DoubleValue tfcTemperatureMultiplier;
/*      */     public final ModConfigSpec.BooleanValue sereneSeasonsEnabled;
/*      */     public final ModConfigSpec.BooleanValue ssTropicalSeasonsEnabled;
/*      */     public final ModConfigSpec.BooleanValue ssSeasonCardsEnabled;
/*      */     public final ModConfigSpec.BooleanValue ssDefaultSeasonEnabled;
/*      */     public final ModConfigSpec.DoubleValue ssEarlySpringModifier;
/*      */     public final ModConfigSpec.DoubleValue ssMidSpringModifier;
/*      */     public final ModConfigSpec.DoubleValue ssLateSpringModifier;
/*      */     public final ModConfigSpec.DoubleValue ssEarlySummerModifier;
/*      */     public final ModConfigSpec.DoubleValue ssMidSummerModifier;
/*      */     public final ModConfigSpec.DoubleValue ssLateSummerModifier;
/*      */     public final ModConfigSpec.DoubleValue ssEarlyAutumnModifier;
/*      */     public final ModConfigSpec.DoubleValue ssMidAutumnModifier;
/*      */     public final ModConfigSpec.DoubleValue ssLateAutumnModifier;
/*      */     public final ModConfigSpec.DoubleValue ssEarlyWinterModifier;
/*      */     public final ModConfigSpec.DoubleValue ssMidWinterModifier;
/*      */     public final ModConfigSpec.DoubleValue ssLateWinterModifier;
/*      */     public final ModConfigSpec.DoubleValue ssEarlyWetSeasonModifier;
/*      */     public final ModConfigSpec.DoubleValue ssMidWetSeasonModifier;
/*      */     public final ModConfigSpec.DoubleValue ssLateWetSeasonModifier;
/*      */     public final ModConfigSpec.DoubleValue ssEarlyDrySeasonModifier;
/*      */     public final ModConfigSpec.DoubleValue ssMidDrySeasonModifier;
/*      */     public final ModConfigSpec.DoubleValue ssLateDrySeasonModifier;
/*      */     public final ModConfigSpec.BooleanValue eclipticSeasonsEnabled;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends Double>> esSpringModifier;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends Double>> esSummerModifier;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends Double>> esAutumnModifier;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends Double>> esWinterModifier;
/*      */     public final ModConfigSpec.BooleanValue thirstEnabled;
/*      */     public final ModConfigSpec.BooleanValue dangerousDehydration;
/*      */     public final ModConfigSpec.BooleanValue cumulativeThirstEffectDuration;
/*      */     public final ModConfigSpec.DoubleValue dehydrationDamageScaling;
/*      */     public final ModConfigSpec.DoubleValue thirstEffectModifier;
/*      */     public final ModConfigSpec.DoubleValue baseHydrationExhaustion;
/*      */     public final ModConfigSpec.DoubleValue sprintingHydrationExhaustion;
/*      */     public final ModConfigSpec.DoubleValue onJumpHydrationExhaustion;
/*      */     public final ModConfigSpec.DoubleValue onBlockBreakHydrationExhaustion;
/*      */     public final ModConfigSpec.DoubleValue onAttackHydrationExhaustion;
/*      */     public final ModConfigSpec.IntValue canteenCapacity;
/*      */     public final ModConfigSpec.BooleanValue selfWateringCanteenEnabled;
/*      */     public final ModConfigSpec.IntValue selfWateringCanteenWetnessIncrease;
/*      */     public final ModConfigSpec.IntValue largeCanteenCapacity;
/*      */     public final ModConfigSpec.BooleanValue allowOverridePurifiedWater;
/*      */     public final ModConfigSpec.IntValue hydrationLava;
/*      */     public final ModConfigSpec.DoubleValue saturationLava;
/*      */     public final ModConfigSpec.BooleanValue glassBottleLootAfterDrink;
/*      */     public final ModConfigSpec.IntValue hydrationLavaBlazeborn;
/*      */     public final ModConfigSpec.DoubleValue saturationLavaBlazeborn;
/*      */     public final ModConfigSpec.DoubleValue extraThirstExhaustionShulk;
/*      */     public final ModConfigSpec.DoubleValue extraThirstExhaustionPhantom;
/*      */     public final ModConfigSpec.BooleanValue thirstEnabledIfVampire;
/*      */     public final ModConfigSpec.BooleanValue healthOverhaulEnabled;
/*      */     public final ModConfigSpec.DoubleValue maxAdditionalHealth;
/*      */     public final ModConfigSpec.DoubleValue maxShieldHealth;
/*      */     public final ModConfigSpec.BooleanValue absorptionEffectOverride;
/*      */     public final ModConfigSpec.IntValue heartsLostOnDeath;
/*      */     public final ModConfigSpec.IntValue permanentHearts;
/*      */     public final ModConfigSpec.IntValue resilientHeartsWithBrokenHearts;
/*      */     public final ModConfigSpec.DoubleValue brokenHeartsPerInjuredLimb;
/*      */     public final ModConfigSpec.EnumValue<EnumUtil.brokenHeartsPerInjuredLimbMode> brokenHeartsPerInjuredLimbMode;
/*      */     public final ModConfigSpec.BooleanValue localizedBodyDamageEnabled;
/*      */     public final ModConfigSpec.DoubleValue headCriticalShotMultiplier;
/*      */     public final ModConfigSpec.DoubleValue bodyDamageMultiplier;
/*      */     public final ModConfigSpec.DoubleValue bodyHealthRatioRecoveredFromSleep;
/*      */     public final ModConfigSpec.DoubleValue healthRatioRecoveredFromSleep;
/*      */     public final ModConfigSpec.DoubleValue bodyHealingFoodExhaustion;
/*      */     public final ModConfigSpec.IntValue minFoodOnBodyHealing;
/*      */     public final ModConfigSpec.IntValue painkillerAddictionDuration;
/*      */     public final ModConfigSpec.BooleanValue passiveLimbRegenerationOnFullHealth;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends String>> passiveLimbRegenerationEffects;
/*      */     public final ModConfigSpec.BooleanValue passiveLimbRegenerationAmplificationEnabled;
/*      */     public final ModConfigSpec.DoubleValue passiveLimbHealthRegenerated;
/*      */     public final ModConfigSpec.IntValue passiveLimbRegenerationTickTimer;
/*      */     public final ModConfigSpec.DoubleValue proportionalLimbRegenMinThreshold;
/*      */     public final ModConfigSpec.DoubleValue proportionalLimbRegenMinHealValue;
/*      */     public final ModConfigSpec.DoubleValue proportionalLimbRegenMaxHealValue;
/*      */     public final ModConfigSpec.IntValue proportionalLimbRegenTickRate;
/*      */     public final ModConfigSpec.DoubleValue proportionalLimbRegenIncreaseRate;
/*      */     public final ModConfigSpec.BooleanValue customHealthRegenEnabled;
/*      */     public final ModConfigSpec.DoubleValue customHealthRegenRate;
/*      */     public final ModConfigSpec.IntValue customHealthRegenTickRate;
/*      */     public final ModConfigSpec.DoubleValue customHealthRegenFoodExhaustion;
/*      */     public final ModConfigSpec.DoubleValue firstAidSuppliesLimbHealthRegenerated;
/*      */     public final ModConfigSpec.EnumValue<EnumUtil.limbRegenerationMode> firstAidSuppliesLimbRegenerationMode;
/*      */     public final ModConfigSpec.BooleanValue firstAidSuppliesHealingOverflow;
/*      */     public final ModConfigSpec.IntValue firstAidSuppliesTickTimer;
/*      */     public final ModConfigSpec.BooleanValue firstAidSuppliesExhaustsFood;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends String>> firstAidSuppliesBoostedOnEffects;
/*      */     public final ModConfigSpec.DoubleValue firstAidSuppliesBoostedTickTimerMultiplier;
/*      */     public final ModConfigSpec.DoubleValue recoveryEffectHealingValue;
/*      */     public final ModConfigSpec.IntValue healingHerbsUseTime;
/*      */     public final ModConfigSpec.IntValue plasterUseTime;
/*      */     public final ModConfigSpec.IntValue bandageUseTime;
/*      */     public final ModConfigSpec.IntValue tonicUseTime;
/*      */     public final ModConfigSpec.IntValue medkitUseTime;
/*      */     public final ModConfigSpec.IntValue morphineUseTime;
/*      */     public final ModConfigSpec.IntValue morphinePainkillerTickDuration;
/*      */     public final ModConfigSpec.EnumValue<EnumUtil.bodyPartHealthMode> bodyPartHealthMode;
/*      */     public final ModConfigSpec.DoubleValue headPartHealth;
/*      */     public final ModConfigSpec.DoubleValue armsPartHealth;
/*      */     public final ModConfigSpec.DoubleValue chestPartHealth;
/*      */     public final ModConfigSpec.DoubleValue legsPartHealth;
/*      */     public final ModConfigSpec.DoubleValue feetPartHealth;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends String>> headPartEffects;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends Integer>> headPartEffectAmplifiers;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends Double>> headPartEffectThresholds;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends String>> armsPartEffects;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends Integer>> armsPartEffectAmplifiers;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends Double>> armsPartEffectThresholds;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends String>> bothArmsPartEffects;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends Integer>> bothArmsPartEffectAmplifiers;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends Double>> bothArmsPartEffectThresholds;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends String>> chestPartEffects;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends Integer>> chestPartEffectAmplifiers;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends Double>> chestPartEffectThresholds;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends String>> legsPartEffects;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends Integer>> legsPartEffectAmplifiers;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends Double>> legsPartEffectThresholds;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends String>> bothLegsPartEffects;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends Integer>> bothLegsPartEffectAmplifiers;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends Double>> bothLegsPartEffectThresholds;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends String>> feetPartEffects;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends Integer>> feetPartEffectAmplifiers;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends Double>> feetPartEffectThresholds;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends String>> bothFeetPartEffects;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends Integer>> bothFeetPartEffectAmplifiers;
/*      */     public final ModConfigSpec.ConfigValue<List<? extends Double>> bothFeetPartEffectThresholds;
/*      */     public final ModConfigSpec.BooleanValue morphineSyringeApplyPainkillerAddiction;
/*      */     
/*      */     Common(ModConfigSpec.Builder builder) {
/*  358 */       builder.comment(new String[] { " Options related to enabling/disabling specific features", " See the data packs to customize the temperature of specific blocks, liquids, armors, etc."
/*      */ 
/*      */           
/*  361 */           }).push("core");
/*  362 */       this
/*      */         
/*  364 */         .temperatureEnabled = builder.comment(" Whether the temperature system is enabled.").define("Temperature Enabled", true);
/*  365 */       this
/*      */         
/*  367 */         .thirstEnabled = builder.comment(" Whether the thirst system is enabled.").define("Thirst Enabled", true);
/*  368 */       this
/*      */         
/*  370 */         .healthOverhaulEnabled = builder.comment(" Whether the overhaul health system is enabled.").define("Health Overhaul Enabled", true);
/*  371 */       this
/*      */         
/*  373 */         .localizedBodyDamageEnabled = builder.comment(" Whether body members receive localized damages.").define("Localized Body Damage Enabled", true);
/*  374 */       this
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  382 */         .difficultyMode = builder.comment(new String[] { " How the mod represents a challenge for the player.", " Accepted values are as follows:", "   PEACEFUL - Temperature doesn't harm the player and the hydration doesn't decrease.", "   EASY - Temperature and Thirst won't hurt the player health below 10 hearts.", "   NORMAL - Temperature and Thirst hurts the player down to 1 heart.", "   HARD - Temperature and Thirst can kill the player.", " Any other value will default to HARD." }).defineEnum("Temperature Difficulty Mode", (Enum)EnumUtil.DifficultyMode.HARD);
/*      */       
/*  384 */       builder.push("advanced");
/*  385 */       this
/*      */ 
/*      */         
/*  388 */         .routinePacketSync = builder.comment(new String[] { " How often player temperature, thirst, body damage and health is regularly synced between the client and server, in ticks.", " Lower values will increase accuracy at the cost of performance." }).defineInRange("Routine Packet Sync", 30, 1, 2147483647);
/*      */       
/*  390 */       builder.pop();
/*      */       
/*  392 */       builder.push("misc");
/*  393 */       this
/*      */         
/*  395 */         .compassInfoMode = builder.comment(" What information the compass returns when player is using it or in an item frame.").defineEnum("Compass Info Mode", (Enum)EnumUtil.CompassInfo.FULL);
/*  396 */       this
/*      */         
/*  398 */         .showCoordinateOnMap = builder.comment(" If enabled, use on a filled map will show destination coordinates.").define("Show Coordinate On Filled Map", true);
/*      */       
/*  400 */       this
/*      */         
/*  402 */         .hideInfoFromDebug = builder.comment(" If enabled, information like position and direction will be hidden from the debug screen (F3).").define("Hide Info From Debug", true);
/*  403 */       this
/*      */         
/*  405 */         .naturalRegenerationEnabled = builder.comment(" If enabled, the player can regenerate health naturally if their hunger is full enough (doesn't affect external healing, such as golden apples, the Regeneration effect, etc.)").define("Natural Regeneration Enabled", false);
/*  406 */       this
/*      */         
/*  408 */         .vanillaFreezeEnabled = builder.comment(" If enabled, the player suffers vanilla freeze when inside powder snow.").define("Vanilla Freeze Enabled", false);
/*  409 */       this
/*      */         
/*  411 */         .initialHealth = builder.comment(" How much health player will have initially.").defineInRange("Initial Player Health", 20.0D, 1.0D, 10000.0D);
/*  412 */       builder.pop();
/*  413 */       builder.pop();
/*      */       
/*  415 */       builder.comment(" Options related to the player food data").push("food");
/*  416 */       this
/*      */         
/*  418 */         .baseFoodExhaustion = builder.comment(" Food exhausted every 10 ticks. Increase the base minecraft food exhaustion.").defineInRange("Base Food Exhaustion", 0.05D, 0.0D, 1000.0D);
/*  419 */       this
/*      */         
/*  421 */         .sprintingFoodExhaustion = builder.comment(" Food exhausted every 10 ticks while sprinting in addition to the sprinting minecraft food exhaustion.").defineInRange("Sprinting Food Exhaustion", 0.1D, 0.0D, 1000.0D);
/*  422 */       this
/*      */         
/*  424 */         .onAttackFoodExhaustion = builder.comment(" Food exhausted on every attack in addition to the minecraft attack food exhaustion.").defineInRange("On Attack Food Exhaustion", 0.1D, 0.0D, 1000.0D);
/*  425 */       builder.pop();
/*      */       
/*  427 */       builder.comment(" Options related to the temperature system").push("temperature");
/*  428 */       this
/*      */         
/*  430 */         .dangerousHeatTemperature = builder.comment(" If enabled, players will take damage from the effects of high temperature.").define("Dangerous Heat Temperature Effects", true);
/*  431 */       this
/*      */         
/*  433 */         .dangerousColdTemperature = builder.comment(" If enabled, players will take damage from the effects of low temperature.").define("Dangerous Cold Temperature Effects", true);
/*  434 */       this
/*      */         
/*  436 */         .goldFernChance = builder.comment(" Chance of the ferns to become a gold fern when grow mature.").defineInRange("Gold Fern Chance", 0.01D, 0.0D, 1.0D);
/*      */       
/*  438 */       builder.push("temperature-immunity");
/*  439 */       this
/*      */         
/*  441 */         .temperatureImmunityOnDeathEnabled = builder.comment(" If enabled, players will be immune to temperature effects after death.").define("Temperature Immunity On Death Enabled", true);
/*  442 */       this
/*      */         
/*  444 */         .temperatureImmunityOnDeathTime = builder.comment(" Temperature immunity period in ticks while the player is immune to temperature effects after death.").defineInRange("Temperature Immunity On Death Time", 1800, 0, 100000);
/*  445 */       this
/*      */         
/*  447 */         .temperatureImmunityOnFirstSpawnEnabled = builder.comment(" If enabled, players will be immune to temperature effects on first spawn in a world.").define("Temperature Immunity On First Spawn Enabled", true);
/*  448 */       this
/*      */         
/*  450 */         .temperatureImmunityOnFirstSpawnTime = builder.comment(" Temperature immunity period in ticks while the player is immune to temperature effects on first spawn.").defineInRange("Temperature Immunity On First Spawn Time", 1800, 0, 100000);
/*  451 */       builder.pop();
/*      */       
/*  453 */       builder.push("secondary_effects");
/*  454 */       this
/*      */ 
/*      */         
/*  457 */         .heatTemperatureSecondaryEffects = builder.comment(new String[] { " If enabled, players will also receive other effects from their current temperature state.", " If the player is too hot, hydration will deplete faster." }).define("Heat Temperature Secondary Effects", true);
/*  458 */       this
/*      */ 
/*      */         
/*  461 */         .coldTemperatureSecondaryEffects = builder.comment(new String[] { " If enabled, players will also receive other effects from their current temperature state.", " If the player is too cold, hunger will deplete faster." }).define("Cold Temperature Secondary Effects", true);
/*  462 */       this
/*      */         
/*  464 */         .heatThirstEffectModifier = builder.comment(" How much thirst exhaustion will be added every 50 ticks with no amplification effect, when the player suffers from heat.").defineInRange("Heat Thirst Effect Modifier", 0.2D, 0.0D, 1000.0D);
/*  465 */       this
/*      */ 
/*      */         
/*  468 */         .coldHungerEffectModifier = builder.comment(new String[] { " How much food exhaustion will be added every 50 ticks with no amplification effect, when the player suffers from frostbite.", " As reference, the hunger effect add 0.025 food exhaustion every 50 ticks." }).defineInRange("Cold Hunger Modifier", 0.1D, 0.0D, 1000.0D);
/*  469 */       builder.pop();
/*      */       
/*  471 */       this
/*      */         
/*  473 */         .onFireModifier = builder.comment(" How much of an effect being on fire has on a player's temperature.").defineInRange("Player On Fire Modifier", 12.5D, -1000.0D, 1000.0D);
/*  474 */       this
/*      */         
/*  476 */         .sprintModifier = builder.comment(" How much of an effect sprinting has on a player's temperature.").defineInRange("Player Sprint Modifier", 1.5D, -1000.0D, 1000.0D);
/*  477 */       this
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  482 */         .altitudeModifier = builder.comment(new String[] { " How much of an effect altitude has on player's temperature.", " Each 64 blocks further from sea level will impact player's temperature by this value.", " The sea level can be defined via datapack under the dimension's temperature.", " As an example, a value of -6 will reduce the player's temperature by 6 for each 64 blocks (the calculus is done linearly)." }).defineInRange("Altitude Modifier", -6.0D, -1000.0D, 1000.0D);
/*      */       
/*  484 */       builder.push("wetness");
/*  485 */       this
/*      */         
/*  487 */         .wetnessEnabled = builder.comment(" Enable the wetness mechanic.").define("Wetness Enabled", true);
/*      */       
/*  489 */       this
/*      */         
/*  491 */         .wetnessImmunityMounts = builder.comment(" List of mounts that provide a wetness immunity.").defineListAllowEmpty("Wetness Immunity Mounts", List.of("alexscaves:submarine", "immersive_machinery:bamboo_bee", "immersive_machinery:tunnel_digger", "immersive_machinery:redstone_sheep", "immersive_machinery:copperfin"), Config::validateEntityType);
/*      */       
/*  493 */       this
/*      */ 
/*      */         
/*  496 */         .wetMultiplier = builder.comment(new String[] { " How much being wet influences the player's temperature.", " It means that for a value of -10, the body temperature of the player is reduced by 10." }).defineInRange("Wetness Modifier", -10.0D, -1000.0D, 1000.0D);
/*      */       
/*  498 */       this
/*      */ 
/*      */         
/*  501 */         .wetnessTickTimer = builder.comment(new String[] { " How frequently the wetness is modified.", " By default, every 10 ticks, the wetness will either increase or decrease, based on the conditions." }).defineInRange("Wetness Tick Timer", 10, 1, 100000);
/*      */       
/*  503 */       this
/*      */         
/*  505 */         .wetnessDecrease = builder.comment(" How much the wetness decrease when out of water.").defineInRange("Wetness Decrease", -3, -1000, 0);
/*  506 */       this
/*      */         
/*  508 */         .wetnessRainIncrease = builder.comment(" How much the wetness increase when under rain.").defineInRange("Wetness Under Rain Increase", 7, 0, 1000);
/*  509 */       this
/*      */ 
/*      */         
/*  512 */         .wetnessFluidIncrease = builder.comment(new String[] { " How much the wetness increase when the player is in a fluid, scale by the amount of fluid in the block.", " The defined value is for a full block of fluid, and goes up to 2 times this value when fully immerge." }).defineInRange("Wetness In Fluid Increase", 10, 0, 1000);
/*  513 */       builder.pop();
/*      */       
/*  515 */       builder.push("huddling");
/*  516 */       this
/*      */         
/*  518 */         .playerHuddlingModifier = builder.comment(new String[] { " How much nearby players increase the ambient temperature by.", " Note that this value stacks!" }).defineInRange("Player Huddling Modifier", 0.5D, -1000.0D, 1000.0D);
/*  519 */       this
/*      */         
/*  521 */         .playerHuddlingRadius = builder.comment(" The radius, in blocks, around which players will add to each other's temperature.").defineInRange("Player Huddling Radius", 1, 0, 10);
/*  522 */       builder.pop();
/*      */       
/*  524 */       builder.push("biomes");
/*  525 */       this
/*      */         
/*  527 */         .biomeTemperatureMultiplier = builder.comment(" How much a biome's temperature effects are multiplied.").defineInRange("Biome Temperature Multiplier", 18.0D, 0.0D, 1000.0D);
/*  528 */       this
/*      */         
/*  530 */         .biomeEffectsEnabled = builder.comment(" Whether biomes will have an effect on a player's temperature.").define("Biomes affect Temperature", true);
/*  531 */       this
/*      */ 
/*      */ 
/*      */         
/*  535 */         .biomeDrynessMultiplier = builder.comment(new String[] { " How much hot biome's dryness will make nights really cold.", " Affects only dry (minecraft down fall <0.2) and hot biome.", " 1 means no dryness effect; 0.5 means the biome temp will be divided by 2 at the middle of the night." }).defineInRange("Biome's Dryness Multiplier", 0.2D, 0.0D, 1.0D);
/*  536 */       builder.pop();
/*      */       
/*  538 */       builder.comment(new String[] { " The underground effect starts apply at Start Distance to the world surface.", " The underground effect will linearly apply a multiplier on the biome temperature, and averages the time and season temperature effects."
/*  539 */           }).push("underground");
/*  540 */       this
/*      */         
/*  542 */         .undergroundBiomeTemperatureMultiplier = builder.comment(" How much a biomes temperature effects are multiplied when player is underground").defineInRange("Underground Biome Temperature Multiplier", 0.8D, 0.0D, 1000.0D);
/*  543 */       this
/*      */ 
/*      */         
/*  546 */         .undergroundEffectStartDistanceToWS = builder.comment(new String[] { " Distance to the World Surface where underground effect will start to be applied.", " Smaller distance, no underground effect are applied." }).defineInRange("Start Distance To World Surface For Underground Effect", 10, 0, 400);
/*  547 */       this
/*      */ 
/*      */         
/*  550 */         .undergroundEffectEndDistanceToWS = builder.comment(new String[] { " Distance to the World Surface where underground effect will be maximal.", " Bigger distance, the underground effect is maximal. Between the Start and End Distance, the increase of underground effect is linear." }).defineInRange("End Distance To World Surface For Underground Effect", 16, 0, 400);
/*  551 */       builder.pop();
/*      */       
/*  553 */       builder.push("weather");
/*  554 */       this
/*      */ 
/*      */         
/*  557 */         .rainTemperatureModifier = builder.comment(new String[] { " How much of an effect rain has on temperature.", " It means that for a value of -2, the body temperature of the player is reduced by 2." }).defineInRange("Rain Temperature Modifier", -2.0D, -1000.0D, 1000.0D);
/*  558 */       this
/*      */ 
/*      */         
/*  561 */         .snowTemperatureModifier = builder.comment(new String[] { " How much of an effect snow has on temperature.", " It means that for a value of -6, the body temperature of the player is reduced by 6." }).defineInRange("Snow Temperature Modifier", -6.0D, -1000.0D, 1000.0D);
/*  562 */       builder.pop();
/*      */       
/*  564 */       builder.comment(" Freeze effect increases while inside snow powder.").push("freeze");
/*  565 */       this
/*      */         
/*  567 */         .maxFreezeTemperatureModifier = builder.comment(" How much of an effect freeze has on temperature when reaching maximum tick time. Starts at 0 and increases linearly.").defineInRange("Max Freeze Temperature Modifier", -10.0D, -1000.0D, 1000.0D);
/*  568 */       this
/*      */         
/*  570 */         .maxFreezeEffectTick = builder.comment(" How long in tick before freeze modifier reaches its maximum effect.").defineInRange("Max Freeze Effect Tick", 400, 0, 100000);
/*  571 */       builder.pop();
/*      */       
/*  573 */       builder.push("time");
/*  574 */       this
/*      */ 
/*      */         
/*  577 */         .timeModifier = builder.comment(new String[] { " How much Time has effect on Temperature.", " Maximum effect at noon (positive) and midnight (negative), following a sinusoidal" }).defineInRange("Time Based Temperature Modifier", 2.0D, 0.0D, Double.POSITIVE_INFINITY);
/*  578 */       this
/*      */ 
/*      */         
/*  581 */         .biomeTimeMultiplier = builder.comment(new String[] { " How strongly time in extreme temperature biomes affect player's temperature.", " Extreme temperature biomes (like snowy taiga, deserts, ...) will multiply the time based temperature by this value, while temperate biome won't be affected by this value, following a linear." }).defineInRange("Biome Time Multiplier", 1.75D, 1.0D, Double.POSITIVE_INFINITY);
/*  582 */       this
/*      */ 
/*      */ 
/*      */         
/*  586 */         .shadeTimeModifier = builder.comment(new String[] { " Staying in the shade or during cloudy weather will reduce player's temperature by this amount based on time of the day (maximum effect at noon, following sinusoidal).", " It means that for a value of -6, the body temperature of the player is reduced by 6.", " Only effective when reaching the threshold and during day time!" }).defineInRange("Shade Time Modifier", -6.0D, -1000.0D, 1000.0D);
/*  587 */       this
/*      */         
/*  589 */         .shadeTimeModifierThreshold = builder.comment(" Defines when the biome temperature added by the season temperature (if seasons mod loaded) will trigger a shade effect.").defineInRange("Shade Time Modifier Threshold", 9.0D, 0.0D, 10000.0D);
/*  590 */       builder.pop();
/*      */       
/*  592 */       builder.comment(new String[] { " Temperature coat adds temperature effects on armors by using the sewing table.", " Adaptive means the coating will maintain the player's temperature temperate."
/*      */           
/*  594 */           }).push("coat");
/*      */       
/*  596 */       builder.comment(" Add a heating resistance on armors.").push("heating");
/*  597 */       this.heatingCoat1Modifier = builder.defineInRange("Heating Coat I", 2.0D, 0.0D, 1000.0D);
/*  598 */       this.heatingCoat2Modifier = builder.defineInRange("Heating Coat II", 3.0D, 0.0D, 1000.0D);
/*  599 */       this.heatingCoat3Modifier = builder.defineInRange("Heating Coat III", 4.0D, 0.0D, 1000.0D);
/*  600 */       builder.pop();
/*      */       
/*  602 */       builder.comment(" Add a cooling resistance on armors.").push("cooling");
/*  603 */       this.coolingCoat1Modifier = builder.defineInRange("Cooling Coat I", 2.0D, 0.0D, 1000.0D);
/*  604 */       this.coolingCoat2Modifier = builder.defineInRange("Cooling Coat II", 3.0D, 0.0D, 1000.0D);
/*  605 */       this.coolingCoat3Modifier = builder.defineInRange("Cooling Coat III", 4.0D, 0.0D, 1000.0D);
/*  606 */       builder.pop();
/*      */       
/*  608 */       builder.comment(" Add a temperature resistance on armors that can both heat and cool the player.")
/*  609 */         .push("thermal");
/*  610 */       this.thermalCoat1Modifier = builder.defineInRange("Thermal Coat I", 2.0D, 0.0D, 1000.0D);
/*  611 */       this.thermalCoat2Modifier = builder.defineInRange("Thermal Coat II", 3.0D, 0.0D, 1000.0D);
/*  612 */       this.thermalCoat3Modifier = builder.defineInRange("Thermal Coat III", 4.0D, 0.0D, 1000.0D);
/*  613 */       builder.pop();
/*  614 */       builder.pop();
/*      */       
/*  616 */       builder.push("advanced");
/*  617 */       this
/*      */         
/*  619 */         .tempInfluenceMaximumDist = builder.comment(" Maximum influence distance, in blocks, where thermal sources will have an effect on temperature.").defineInRange("Temperature Influence Maximum Distance", 20, 1, 40);
/*  620 */       this
/*      */ 
/*      */ 
/*      */         
/*  624 */         .tempInfluenceUpDistMultiplier = builder.comment(" How strongly influence distance above the player is reduced for thermal sources to have an effect on temperature.").comment(new String[] { " Example max dist is 10, up mult is 0.75 -> max distance is 10 * 0.75 = 7.5 blocks above the player.", " Logic is that heat goes up, the strength of the heat source above the player is decreased faster with distance." }).defineInRange("Temperature Influence Up Distance Multiplier", 0.75D, 0.0D, 1.0D);
/*  625 */       this
/*      */ 
/*      */         
/*  628 */         .tempInfluenceInWaterDistMultiplier = builder.comment(new String[] { " How strongly influence distance in water is reduced for thermal sources to have an effect on temperature.", "The under water maximum distance is defined as the maximum distance * this value" }).defineInRange("Temperature Influence Outside Distance Multiplier", 0.25D, 0.0D, 1.0D);
/*      */       
/*  630 */       this
/*      */ 
/*      */         
/*  633 */         .tempInfluenceOutsideDistMultiplier = builder.comment(new String[] { " How strongly influence distance outside a structure is reduced for thermal sources to have an effect on temperature.", " The outside maximum distance is defined as the maximum distance * this value" }).defineInRange("Temperature Influence Outside Distance Multiplier", 0.5D, 0.0D, 1.0D);
/*  634 */       builder
/*  635 */         .comment(new String[] { " The player's temperature will be adjusted at each temperature tick time,", " by an amount of temperature defined between the minimum and the maximum temperature modification adjusted linearly."
/*      */           
/*  637 */           }).push("temperature-modification");
/*  638 */       this
/*      */         
/*  640 */         .tempTickTime = builder.comment(" Amount of time in ticks between 2 player temperature modification. The bigger is this value, the more time it takes between temperature adjustments.").defineInRange("Temperature Tick Time", 20, 5, 2147483647);
/*  641 */       this
/*      */ 
/*      */         
/*  644 */         .maxTemperatureModification = builder.comment(new String[] { " Maximum amount of temperature the player's temperature can be modified at each temperature tick time.", " Correspond to the amount of temperature given when temperature difference is maximum, meaning 40." }).defineInRange("Maximum Temperature Modification", 1.0D, 0.1D, 2.147483647E9D);
/*  645 */       this
/*      */ 
/*      */         
/*  648 */         .minTemperatureModification = builder.comment(new String[] { " Minimum amount of temperature the player's temperature can be modified at each temperature tick time.", " Correspond to the amount of temperature given when there is no temperature difference" }).defineInRange("Minimum Temperature Modification", 0.2D, 0.1D, 2.147483647E9D);
/*  649 */       builder.pop();
/*  650 */       builder.pop();
/*      */       
/*  652 */       builder.push("integration");
/*      */       
/*  654 */       builder.comment(new String[] { " If TerraFirmaCraft is installed, then biome, time, season (if serene seasons installed) and altitude modifiers will be disabled, and TerraFirmaCraft calculation used instead.", " All other modifiers remain to calculate Player temperature."
/*  655 */           }).push("terrafirmacraft");
/*  656 */       this
/*      */         
/*  658 */         .tfcItemHeatMultiplier = builder.comment(" How much the heat of the item provided by TerraFirmaCraft is multiplied. 0 deactivates the impact on temperature.").defineInRange("TerraFirmaCraft Item Heat Multiplier", 0.01D, 0.0D, 1000.0D);
/*  659 */       this
/*      */         
/*  661 */         .tfcTemperatureMultiplier = builder.comment(" How much the temperature given from TerraFirmaCraft is multiplied. 0 deactivates the impact on temperature.").defineInRange("TerraFirmaCraft Temperature Multiplier", 1.0D, 0.0D, 1000.0D);
/*  662 */       builder.pop();
/*      */       
/*  664 */       builder.push("serene-seasons");
/*  665 */       this
/*      */         
/*  667 */         .sereneSeasonsEnabled = builder.comment(" If Serene Seasons is installed, whether the seasons have an effect on the player's temperature.").define("Serene Seasons Enabled", true);
/*  668 */       this
/*      */ 
/*      */         
/*  671 */         .ssTropicalSeasonsEnabled = builder.comment(new String[] { " If the tropical seasons are disabled, the normal summer-autumn-winter-spring seasons are applied.", " If disabled, dry and wet seasons are applied for hot biomes." }).define("Tropical Seasons Enabled", false);
/*  672 */       this
/*      */         
/*  674 */         .ssSeasonCardsEnabled = builder.comment(" If season cards are enabled, season cards will appear at every season changes.").define("Season Cards Enabled", false);
/*  675 */       this
/*      */ 
/*      */         
/*  678 */         .ssDefaultSeasonEnabled = builder.comment(new String[] { " If default season is enabled, when serene season defines no season effect in a biome, the normal season temperature will be applied.", " If disabled, when serene season defines no season effects, no season temperature will be applied." }).define("Default Season Enabled", true);
/*      */       
/*  680 */       builder.comment(" Temperature modifiers per season in temperate biomes. The value is reached at the middle of the sub season, and smoothly transition from one to another.")
/*      */         
/*  682 */         .push("temperate");
/*  683 */       builder.push("spring");
/*  684 */       this.ssEarlySpringModifier = builder.defineInRange("Early Spring Modifier", -3.0D, -1000.0D, 1000.0D);
/*  685 */       this.ssMidSpringModifier = builder.defineInRange("Mid Spring Modifier", 0.0D, -1000.0D, 1000.0D);
/*  686 */       this.ssLateSpringModifier = builder.defineInRange("Late Spring Modifier", 3.0D, -1000.0D, 1000.0D);
/*  687 */       builder.pop();
/*      */       
/*  689 */       builder.push("summer");
/*  690 */       this.ssEarlySummerModifier = builder.defineInRange("Early Summer Modifier", 6.0D, -1000.0D, 1000.0D);
/*  691 */       this.ssMidSummerModifier = builder.defineInRange("Mid Summer Modifier", 10.0D, -1000.0D, 1000.0D);
/*  692 */       this.ssLateSummerModifier = builder.defineInRange("Late Summer Modifier", 6.0D, -1000.0D, 1000.0D);
/*  693 */       builder.pop();
/*      */       
/*  695 */       builder.push("autumn");
/*  696 */       this.ssEarlyAutumnModifier = builder.defineInRange("Early Autumn Modifier", 3.0D, -1000.0D, 1000.0D);
/*  697 */       this.ssMidAutumnModifier = builder.defineInRange("Mid Autumn Modifier", 0.0D, -1000.0D, 1000.0D);
/*  698 */       this.ssLateAutumnModifier = builder.defineInRange("Late Autumn Modifier", -3.0D, -1000.0D, 1000.0D);
/*  699 */       builder.pop();
/*      */       
/*  701 */       builder.push("winter");
/*  702 */       this.ssEarlyWinterModifier = builder.defineInRange("Early Winter Modifier", -7.0D, -1000.0D, 1000.0D);
/*  703 */       this.ssMidWinterModifier = builder.defineInRange("Mid Winter Modifier", -12.0D, -1000.0D, 1000.0D);
/*  704 */       this.ssLateWinterModifier = builder.defineInRange("Late Winter Modifier", -7.0D, -1000.0D, 1000.0D);
/*  705 */       builder.pop();
/*  706 */       builder.pop();
/*      */       
/*  708 */       builder.comment(" Temperature modifiers per season in tropical biomes.").push("tropical");
/*  709 */       builder.push("wet-season");
/*  710 */       this.ssEarlyWetSeasonModifier = builder.defineInRange("Early Wet Season Modifier", -1.0D, -1000.0D, 1000.0D);
/*  711 */       this.ssMidWetSeasonModifier = builder.defineInRange("Mid Wet Season Modifier", -5.0D, -1000.0D, 1000.0D);
/*  712 */       this.ssLateWetSeasonModifier = builder.defineInRange("Late Wet Season Modifier", -1.0D, -1000.0D, 1000.0D);
/*  713 */       builder.pop();
/*      */       
/*  715 */       builder.push("dry-season");
/*  716 */       this.ssEarlyDrySeasonModifier = builder.defineInRange("Early Dry Season Modifier", 3.0D, -1000.0D, 1000.0D);
/*  717 */       this.ssMidDrySeasonModifier = builder.defineInRange("Mid Dry Season Modifier", 7.0D, -1000.0D, 1000.0D);
/*  718 */       this.ssLateDrySeasonModifier = builder.defineInRange("Late Dry Season Modifier", 3.0D, -1000.0D, 1000.0D);
/*  719 */       builder.pop();
/*      */       
/*  721 */       builder.pop();
/*  722 */       builder.pop();
/*      */       
/*  724 */       builder.push("ecliptic-seasons");
/*  725 */       this
/*      */         
/*  727 */         .eclipticSeasonsEnabled = builder.comment(" If Ecliptic Seasons is installed, whether the seasons have an effect on the player's temperature.").define("Ecliptic Seasons Enabled", true);
/*      */       
/*  729 */       builder.comment(" Temperature modifiers per season. Each season is subdivided in 6 sub seasons. The value is reached at the middle of the sub season, and smoothly transition from one to another.")
/*      */         
/*  731 */         .push("temperature");
/*  732 */       this.esSpringModifier = builder.defineList("Spring Modifier", List.of(Double.valueOf(-10.0D), Double.valueOf(-7.0D), Double.valueOf(-5.0D), Double.valueOf(-3.0D), Double.valueOf(-1.0D), Double.valueOf(0.0D)), Config::validateDouble);
/*  733 */       this.esSummerModifier = builder.defineList("Summer Modifier", List.of(Double.valueOf(1.0D), Double.valueOf(3.0D), Double.valueOf(5.0D), Double.valueOf(7.0D), Double.valueOf(9.0D), Double.valueOf(10.0D)), Config::validateDouble);
/*  734 */       this.esAutumnModifier = builder.defineList("Autumn Modifier", List.of(Double.valueOf(9.0D), Double.valueOf(7.0D), Double.valueOf(5.0D), Double.valueOf(3.0D), Double.valueOf(1.0D), Double.valueOf(0.0D)), Config::validateDouble);
/*  735 */       this.esWinterModifier = builder.defineList("Winter Modifier", List.of(Double.valueOf(-1.0D), Double.valueOf(-3.0D), Double.valueOf(-5.0D), Double.valueOf(-7.0D), Double.valueOf(-10.0D), Double.valueOf(-12.0D)), Config::validateDouble);
/*  736 */       builder.pop();
/*  737 */       builder.pop();
/*      */       
/*  739 */       builder.pop();
/*  740 */       builder.pop();
/*      */       
/*  742 */       builder.comment(" Options related to thirst feature").push("thirst");
/*  743 */       this
/*      */         
/*  745 */         .dangerousDehydration = builder.comment(" If enabled, players will take damage from the complete dehydration.").define("Dangerous Dehydration", true);
/*  746 */       this
/*      */         
/*  748 */         .cumulativeThirstEffectDuration = builder.comment(" If enabled, each time the player receives a thirst effect, its duration will be added to the thirst effect duration if already on the player.").define("Cumulative Thirst Effect Duration", true);
/*  749 */       builder.push("exhaustion");
/*  750 */       this
/*      */         
/*  752 */         .baseHydrationExhaustion = builder.comment(" Hydration exhausted every 10 ticks.").defineInRange("Base Hydration Exhaustion", 0.03D, 0.0D, 1000.0D);
/*  753 */       this
/*      */         
/*  755 */         .sprintingHydrationExhaustion = builder.comment(" Hydration exhausted when sprinting, replacing the base hydration exhausted.").defineInRange("Sprinting Hydration Exhaustion", 0.1D, 0.0D, 1000.0D);
/*  756 */       this
/*      */         
/*  758 */         .onJumpHydrationExhaustion = builder.comment(" Hydration exhausted on every jump.").defineInRange("On Jump Hydration Exhaustion", 0.15D, 0.0D, 1000.0D);
/*  759 */       this
/*      */         
/*  761 */         .onBlockBreakHydrationExhaustion = builder.comment(" Hydration exhausted on every block break.").defineInRange("On Block Break Hydration Exhaustion", 0.07D, 0.0D, 1000.0D);
/*  762 */       this
/*      */         
/*  764 */         .onAttackHydrationExhaustion = builder.comment(" Hydration exhausted on every attack.").defineInRange("On Attack Hydration Exhaustion", 0.3D, 0.0D, 1000.0D);
/*  765 */       builder.pop();
/*  766 */       this
/*      */         
/*  768 */         .dehydrationDamageScaling = builder.comment(" Scaling of the damages dealt when completely dehydrated. Each tick damage will be increased by this value.").defineInRange("Dehydration Damage Scaling", 0.3D, 0.0D, 1000.0D);
/*  769 */       this
/*      */ 
/*      */         
/*  772 */         .thirstEffectModifier = builder.comment(new String[] { " How much thirst exhaustion will be added every 50 ticks when the player suffers from non amplified Thirst Effect.", " The player will suffer Thirst Effect from dirty water for example." }).defineInRange("Thirst Effect Modifier", 0.25D, 0.0D, 1000.0D);
/*  773 */       builder.push("canteen");
/*  774 */       this
/*      */ 
/*      */         
/*  777 */         .selfWateringCanteenEnabled = builder.comment(new String[] { " If enabled, the player can water himself by using the canteen while crouching.", " This will increase the player wetness and remove fire." }).define("Self Watering Canteen Enabled", true);
/*  778 */       this
/*      */ 
/*      */         
/*  781 */         .selfWateringCanteenWetnessIncrease = builder.comment(new String[] { " If Self Watering Canteen and Wetness are enabled, defines how much wetness is added to the player.", " Set this value to 0 to have no wetness added. By default, the maximum wetness is 400." }).defineInRange("Self Watering Canteen Wetness", 400, 0, 10000);
/*  782 */       this
/*      */         
/*  784 */         .canteenCapacity = builder.comment(" Capacity of the canteen used to store water.").defineInRange("Canteen Capacity", 10, 0, 1000);
/*  785 */       this
/*      */         
/*  787 */         .largeCanteenCapacity = builder.comment(" Capacity of the large canteen used to store water.").defineInRange("Large Canteen Capacity", 20, 0, 1000);
/*  788 */       this
/*      */         
/*  790 */         .allowOverridePurifiedWater = builder.comment(" Allow override of purified water stored in canteen with normal water.").define("Allow Override Purified Water", true);
/*  791 */       builder.pop();
/*  792 */       builder.comment(" Allows drinking from lava. Can be used as bauble.").push("nether_chalice");
/*  793 */       this
/*      */         
/*  795 */         .hydrationLava = builder.comment(" Amount of hydration recovered when drinking from lava.").defineInRange("Lava Hydration", 6, 0, 20);
/*  796 */       this
/*      */         
/*  798 */         .saturationLava = builder.comment(" Amount of saturation recovered when drinking from lava.").defineInRange("Lava Saturation", 4.0D, 0.0D, 20.0D);
/*  799 */       builder.pop();
/*  800 */       builder.push("juices");
/*  801 */       this
/*      */         
/*  803 */         .glassBottleLootAfterDrink = builder.comment(" Whether the player retrieves a glass bottle after drinking a juice.").define("Glass Bottle Loot After Drinking A Juice", true);
/*  804 */       builder.pop();
/*      */       
/*  806 */       builder.push("integration");
/*  807 */       builder.push("origins");
/*      */       
/*  809 */       builder.comment(new String[] { " Temperature won't increase while on fire", " Immune to wetness", " Can drink lava"
/*      */ 
/*      */           
/*  812 */           }).push("blazeborn");
/*  813 */       this
/*      */         
/*  815 */         .hydrationLavaBlazeborn = builder.comment(" Amount of hydration recovered when drinking from lava.").defineInRange("Lava Hydration For Blazeborn", 3, 0, 20);
/*  816 */       this
/*      */         
/*  818 */         .saturationLavaBlazeborn = builder.comment(" Amount of saturation recovered when drinking from lava.").defineInRange("Lava Saturation For Blazeborn", 1.0D, 0.0D, 20.0D);
/*  819 */       builder.pop();
/*      */       
/*  821 */       builder.comment(new String[] { " Immune to wetness", "Immune to Thirst Effect"
/*  822 */           }).push("merling");
/*  823 */       builder.pop();
/*      */       
/*  825 */       builder.comment(" Immune to high altitude coldness").push("elytrian");
/*  826 */       builder.pop();
/*      */       
/*  828 */       builder.comment(" Immune to high altitude coldness").push("avian");
/*  829 */       builder.pop();
/*      */       
/*  831 */       builder.comment(" Thirst depletes slightly faster").push("shulk");
/*  832 */       this
/*      */         
/*  834 */         .extraThirstExhaustionShulk = builder.comment(" Amount of thirst exhaustion added every 20 ticks.").defineInRange("Extra Thirst Exhaustion For Shulk", 0.1D, 0.0D, 1000.0D);
/*  835 */       builder.pop();
/*      */       
/*  837 */       builder.comment(" Thirst depletes slightly faster").push("phantom");
/*  838 */       this
/*      */         
/*  840 */         .extraThirstExhaustionPhantom = builder.comment(" Amount of thirst exhaustion added every 20 ticks.").defineInRange("Extra Thirst Exhaustion For Phantom", 0.1D, 0.0D, 1000.0D);
/*  841 */       builder.pop();
/*      */       
/*  843 */       builder.pop();
/*      */       
/*  845 */       builder.push("vampirism");
/*  846 */       this
/*      */ 
/*      */         
/*  849 */         .thirstEnabledIfVampire = builder.comment(new String[] { " If Vampirism is installed and if thirst enabled while being a vampire, keep the thirst system in addition to the vampiric one.", " If disabled, the thirst system will be disabled for vampires." }).define("Thirst Enabled If Vampire", false);
/*  850 */       builder.pop();
/*  851 */       builder.pop();
/*      */       
/*  853 */       builder.pop();
/*      */       
/*  855 */       builder.comment(" Options related to health overhaul").push("health-overhaul");
/*  856 */       this
/*      */         
/*  858 */         .maxAdditionalHealth = builder.comment(" How much of Additional Health a player can accumulate. 2 Heath means a full heart.").defineInRange("Maximum Additional Health", 20.0D, 0.0D, 10000.0D);
/*      */       
/*  860 */       builder.push("shield-health");
/*  861 */       this
/*      */ 
/*      */         
/*  864 */         .maxShieldHealth = builder.comment(new String[] { " How much of Shield Health a player can accumulate. 2 Shield Heath means a full shield.", " Shield Health are lost when the player suffers damages and can't regenerate. Works similarly as the Minecraft Absorption." }).defineInRange("Maximum Shield Health", 20.0D, 1.0D, 10000.0D);
/*  865 */       this
/*      */ 
/*      */         
/*  868 */         .absorptionEffectOverride = builder.comment(new String[] { " Override the absorption effect by a shield health increase of 2.", " The absorption is typically given by the Golden Apple." }).define("Absorption Effect Override", true);
/*  869 */       builder.pop();
/*      */       
/*  871 */       builder.push("heart-loss");
/*  872 */       this
/*      */         
/*  874 */         .heartsLostOnDeath = builder.comment(" The number of Hearts lost on death.").defineInRange("Hearts Lost On Death", 0, 0, 10000);
/*      */       
/*  876 */       this
/*      */ 
/*      */         
/*  879 */         .permanentHearts = builder.comment(new String[] { " The number of Hearts below which player can't lose hearts upon death.", " The hearts below this limit are de facto Permanent Hearts." }).defineInRange("Permanent Hearts", 10, 1, 10000);
/*  880 */       builder.pop();
/*  881 */       builder.push("broken-hearts")
/*  882 */         .comment(new String[] { " Broken Hearts are an interaction with the localized body damage feature. Enables both feature to have it.", " Broken Hearts are lost hearts when a player's limb is severely injured and it can be recovered by healing the injured limb." });
/*      */       
/*  884 */       this
/*      */ 
/*      */         
/*  887 */         .resilientHeartsWithBrokenHearts = builder.comment(new String[] { " The Resilient Hearts is the number of heart below which Broken Hearts can no longer be added.", " By default, the player has 2 resilient heart, meaning no matter the amount of broken hearts, the player won't go below 2 hearts." }).defineInRange("Minimum Amount Of Player's Heart With Broken Hearts (Broken Heart Resilience)", 2, 1, 10000);
/*  888 */       this
/*      */         
/*  890 */         .brokenHeartsPerInjuredLimb = builder.comment(" Amount of Broken Hearts added per limbs fully injured.").defineInRange("Added Broken Hearts Per Injured Limb", 0.1D, 0.0D, 10000.0D);
/*  891 */       this
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  899 */         .brokenHeartsPerInjuredLimbMode = builder.comment(new String[] { " How broken hearts inflicted per injured limbs are calculated. The total amount will be round down to have an integer amount of broken hearts.", " For example, if the amount per injured limb is 0.1 with mode Player Dynamic and the player has 3 limbs injured, the total amount is 3 * (0.1 * 20), 20 being the default player max health, so 6 broken hearts will be inflicted.", " Accepted values are as follows:", "   SIMPLE - The broken heart amount is a fixed value defined in Broken Hearts Per Injured Limb.", "   PLAYER_DYNAMIC - The broken heart amount is a percentage value of the player max health using the percentage value defined in Broken Hearts Per Injured Limb.", "   LIMB_DYNAMIC - The broken heart amount is a percentage value of the injured limb max health using the percentage value defined in Broken Hearts Per Injured Limb.", " Any other value will default to SIMPLE." }).defineEnum("Broken Hearts Per Injured Limb Mode", (Enum)EnumUtil.brokenHeartsPerInjuredLimbMode.PLAYER_DYNAMIC);
/*  900 */       builder.pop();
/*  901 */       builder.pop();
/*      */       
/*  903 */       builder.comment(new String[] { " Options related to localized body damage", " The damageSourceBodyParts.json allows you to define for specific damage source, the damage spread across specified body parts.", " The damage distribution can either be ONE_OF or ALL. ALL means the damage are equally divided across all body parts."
/*      */           
/*  905 */           }).push("body-damage");
/*  906 */       this
/*      */         
/*  908 */         .headCriticalShotMultiplier = builder.comment(" Multiply the damage taken by the player when shot in the head without helmet.").defineInRange("Headshot Multiplier", 2.0D, 1.0D, 1000.0D);
/*  909 */       this
/*      */         
/*  911 */         .bodyDamageMultiplier = builder.comment(" How much of the hurt player's damage is assigned to the body parts.").defineInRange("Body Damage Multiplier", 1.0D, 0.0D, 1000.0D);
/*  912 */       this
/*      */         
/*  914 */         .bodyHealthRatioRecoveredFromSleep = builder.comment(" How much health ratio are recovered in all body parts from bed sleeping.").defineInRange("Body Part Health Ratio Recovered", 1.0D, 0.0D, 1.0D);
/*  915 */       this
/*      */         
/*  917 */         .healthRatioRecoveredFromSleep = builder.comment(" How much health ratio are recovered from bed sleeping.").defineInRange("Health Ratio Recovered", 1.0D, 0.0D, 1.0D);
/*      */       
/*  919 */       this
/*      */ 
/*      */         
/*  922 */         .bodyHealingFoodExhaustion = builder.comment(new String[] { " How much food is exhausted when a limb regenerates based on the amount of health regenerated.", " For each 1 health regenerated, the food is exhausted by this value." }).defineInRange("Body Healing Food Exhaustion", 0.5D, 0.0D, 1000.0D);
/*      */       
/*  924 */       this
/*      */ 
/*      */         
/*  927 */         .minFoodOnBodyHealing = builder.comment(new String[] { " The hunger bar won't drop below this value while body is healing.", " Each hunger icon has a value of 2 in the hunger bar." }).defineInRange("Minimum Food On Body Healing", 0, 0, 1000);
/*      */       
/*  929 */       this
/*      */ 
/*      */         
/*  932 */         .painkillerAddictionDuration = builder.comment(new String[] { " How long in ticks is the Addiction Effect lasting. 0 deactivates the feature.", " The Addiction Effect prevents you from re-using the morphine item." }).defineInRange("Painkiller Addiction Duration", 3600, 0, 100000);
/*      */       
/*  934 */       builder.push("healing-limbs");
/*  935 */       builder.push("passive-regeneration");
/*  936 */       this
/*      */         
/*  938 */         .passiveLimbRegenerationOnFullHealth = builder.comment(" The limbs will be healed when the player is at max health.").define(" Passive Limb Regeneration On Full Health", false);
/*  939 */       this
/*      */         
/*  941 */         .passiveLimbRegenerationEffects = builder.comment(" The limbs will be healed when the player is under one of the mentioned effect, the most damaged limb first.").defineListAllowEmpty("Passive Limb Regeneration On Effects", List.of("minecraft:regeneration"), Config::validateEffectName);
/*  942 */       this
/*      */ 
/*      */ 
/*      */         
/*  946 */         .passiveLimbRegenerationAmplificationEnabled = builder.comment(new String[] { " Whether the amplification of the effect increase the limb regeneration speed.", " The speed increase follows the same logic as the Regeneration Effect Amplification :", "    Amplifier 1 -> tick timer /2, Amplifier 2 -> tick timer /4, ..." }).define("Passive Limb Regeneration Amplification Enabled", true);
/*  947 */       this
/*      */         
/*  949 */         .passiveLimbHealthRegenerated = builder.comment(" Amount of limb health regenerated, the most damaged limb first.").defineInRange("Passive Limb Health Regenerated", 0.01D, 0.0D, 1000.0D);
/*  950 */       this
/*      */         
/*  952 */         .passiveLimbRegenerationTickTimer = builder.comment(" How fast in ticks the limbs regenerate passively. 20 ticks = 1s").defineInRange("Passive Limb Regeneration Tick Timer", 200, 0, 10000);
/*  953 */       builder.pop();
/*  954 */       builder.push("proportional-regeneration");
/*  955 */       this
/*      */         
/*  957 */         .proportionalLimbRegenMinThreshold = builder.comment(" Minimum health threshold (as ratio of max health minus broken hearts) to start regenerating limbs.").defineInRange("Proportional Limb Regen Min Threshold", 0.5D, 0.0D, 1.0D);
/*  958 */       this
/*      */         
/*  960 */         .proportionalLimbRegenMinHealValue = builder.comment(" Minimum limb heal value per tick rate when at min threshold. Spread proportionally across all body parts.").defineInRange("Proportional Limb Regen Min Heal Value", 0.0D, 0.0D, 1000.0D);
/*  961 */       this
/*      */         
/*  963 */         .proportionalLimbRegenMaxHealValue = builder.comment(" Maximum limb heal value per tick rate when at full health. Spread proportionally across all body parts.").defineInRange("Proportional Limb Regen Max Heal Value", 4.0D, 0.0D, 1000.0D);
/*  964 */       this
/*      */         
/*  966 */         .proportionalLimbRegenTickRate = builder.comment(" How often in ticks the proportional regeneration occurs. 20 ticks = 1s").defineInRange("Proportional Limb Regen Tick Rate", 100, 1, 10000);
/*  967 */       this
/*      */         
/*  969 */         .proportionalLimbRegenIncreaseRate = builder.comment(" Rate at which healing increases from min to max. 1.0 = linear, >1 = exponential.").defineInRange("Proportional Limb Regen Increase Rate", 1.0D, 0.1D, 10.0D);
/*  970 */       builder.pop();
/*  971 */       builder.push("custom-health-regen");
/*  972 */       this
/*      */         
/*  974 */         .customHealthRegenEnabled = builder.comment(" Enable custom health regeneration when natural regen is off. Consumes saturation and hunger.").define("Custom Health Regen Enabled", true);
/*  975 */       this
/*      */         
/*  977 */         .customHealthRegenRate = builder.comment(" Amount of health to regenerate per tick rate.").defineInRange("Custom Health Regen Rate", 1.0D, 0.0D, 1000.0D);
/*  978 */       this
/*      */         
/*  980 */         .customHealthRegenTickRate = builder.comment(" How often in ticks health regenerates. 20 ticks = 1s").defineInRange("Custom Health Regen Tick Rate", 200, 1, 10000);
/*  981 */       this
/*      */         
/*  983 */         .customHealthRegenFoodExhaustion = builder.comment(" Food exhaustion per health point regenerated.").defineInRange("Custom Health Regen Food Exhaustion", 6.0D, 0.0D, 100.0D);
/*  984 */       builder.pop();
/*  985 */       builder.comment(" The First Aid Supplies overrides the passive limb regeneration as its effects is meant to be stronger.").push("first-aid-supplies");
/*  986 */       this
/*      */         
/*  988 */         .firstAidSuppliesLimbHealthRegenerated = builder.comment(" The First Aid Supplies regenerate limb health passively, either by holding it or using Curios mod, the most damaged limb first.").defineInRange("First Aid Supplies Limb Health Regenerated", 0.01D, 0.0D, 1000.0D);
/*  989 */       this
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  995 */         .firstAidSuppliesLimbRegenerationMode = builder.comment(new String[] { " How a player's limb health regenerated is defined. Accepted values are as follows:", "   SIMPLE - The limb health regenerated is a fixed value defined in First Aid Supplies Limb Health Regenerated.", "   PLAYER_DYNAMIC - The limb health regenerated is a percentage value of the player max health using the percentage value defined in First Aid Supplies Limb Health Regenerated.", "   LIMB_DYNAMIC - The limb health regenerated is a percentage value of the limb max health using the percentage value defined in First Aid Supplies Limb Health Regenerated.", " Any other value will default to SIMPLE." }).defineEnum("First Aid Supplies Limb Regeneration Mode", (Enum)EnumUtil.limbRegenerationMode.PLAYER_DYNAMIC);
/*  996 */       this
/*      */ 
/*      */         
/*  999 */         .firstAidSuppliesHealingOverflow = builder.comment(new String[] { " Whether the exceeded limb health regenerated will heal the next most damaged limb.", " Only available for Regeneration Mode SIMPLE or PLAYER_DYNAMIC." }).define("First Aid Supplies Healing Overflow", true);
/* 1000 */       this
/*      */         
/* 1002 */         .firstAidSuppliesTickTimer = builder.comment(" How fast in ticks the First Aid Supplies will heal limbs. 20 ticks = 1s").defineInRange("First Aid Supplies Tick Timer", 100, 0, 10000);
/* 1003 */       this
/*      */         
/* 1005 */         .firstAidSuppliesExhaustsFood = builder.comment(" Whether the First Aid Supplies exhaust food when healing limbs, such as the other healing items.").define("First Aid Supplies Exhausts Food", true);
/* 1006 */       this
/*      */         
/* 1008 */         .firstAidSuppliesBoostedOnEffects = builder.comment(" The First Aid Supplies will heal limbs faster when the player is under one of the mentioned effect.").defineListAllowEmpty("First Aid Supplies Boosted On Effects", List.of("minecraft:regeneration", "farmersdelight:comfort"), Config::validateEffectName);
/* 1009 */       this
/*      */ 
/*      */         
/* 1012 */         .firstAidSuppliesBoostedTickTimerMultiplier = builder.comment(new String[] { " How much the First Aid Supplies tick timer is multiplied when boosted. ", " A value of 1 would deactivate the speed boost. 0.5 makes the heal twice faster." }).defineInRange("First Aid Supplies Tick Timer Multiplier", 0.5D, 0.1D, 1.0D);
/* 1013 */       builder.pop();
/* 1014 */       builder.push("healing-items");
/* 1015 */       this
/*      */ 
/*      */         
/* 1018 */         .recoveryEffectHealingValue = builder.comment(new String[] { " Amount of player health regenerated by the Recovery Effect every effect tick.", " For comparison, the Regeneration Effect healing amount is 1." }).defineInRange("Recovery Effect Healing Amount", 0.1D, 0.0D, 1000.0D);
/*      */       
/* 1020 */       this
/*      */         
/* 1022 */         .healingHerbsUseTime = builder.comment(" Item use time in ticks.").defineInRange("Healing Herbs Use Time", 20, 0, 1000);
/*      */       
/* 1024 */       this
/*      */         
/* 1026 */         .plasterUseTime = builder.comment(" Item use time in ticks.").defineInRange("Plaster Use Time", 20, 0, 1000);
/*      */       
/* 1028 */       this
/*      */         
/* 1030 */         .bandageUseTime = builder.comment(" Item use time in ticks.").defineInRange("Bandage Use Time", 30, 0, 1000);
/*      */       
/* 1032 */       this
/*      */         
/* 1034 */         .tonicUseTime = builder.comment(" Item use time in ticks.").defineInRange("Tonic Use Time", 50, 0, 1000);
/*      */       
/* 1036 */       this
/*      */         
/* 1038 */         .medkitUseTime = builder.comment(" Item use time in ticks.").defineInRange("Medkit Use Time", 50, 0, 1000);
/* 1039 */       builder.pop();
/*      */       
/* 1041 */       builder.push("morphine");
/* 1042 */       this
/*      */         
/* 1044 */         .morphineUseTime = builder.comment(" Item use time in ticks.").defineInRange("Morphine Use Time", 30, 0, 1000);
/* 1045 */       this
/*      */         
/* 1047 */         .morphinePainkillerTickDuration = builder.comment(" Painkiller effect duration in ticks. This effect prevents the player to be affected by broken limbs effects.").defineInRange("Morphine Painkiller Duration", 1800, 0, 10000);
/* 1048 */       builder.pop();
/* 1049 */       builder.pop();
/*      */       
/* 1051 */       builder.push("body-parts-health");
/* 1052 */       this
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1059 */         .bodyPartHealthMode = builder.comment(new String[] { " How a player's body part health is determined. Accepted values are as follows:", "   SIMPLE - Body parts will have initial fixed values. The body parts health define the health value.", "       In this case, if the 'headPartHeath = 10', the head will have '10' health.", "   DYNAMIC - Body parts will have dynamic values based on the player's max health. In this case, the body parts health is a multiplier of the player's max health.", "       In this case, if the 'headPartHeath = 0.3', the head will have '0.3' * 'player max health' health.", " Any other value will default to SIMPLE." }).defineEnum("Body Part Health Mode", (Enum)EnumUtil.bodyPartHealthMode.DYNAMIC);
/*      */       
/* 1061 */       this.headPartHealth = builder.defineInRange("Head Part Health", 0.4D, 0.0D, 1000.0D);
/* 1062 */       this
/* 1063 */         .armsPartHealth = builder.comment(" Both arms will have this health.").defineInRange("Arms Part Health", 0.4D, 0.0D, 1000.0D);
/* 1064 */       this.chestPartHealth = builder.defineInRange("Chest Part Health", 0.6D, 0.0D, 1000.0D);
/* 1065 */       this
/* 1066 */         .legsPartHealth = builder.comment(" Both legs will have this health.").defineInRange("Legs Part Health", 0.6D, 0.0D, 1000.0D);
/* 1067 */       this
/* 1068 */         .feetPartHealth = builder.comment(" Both feet will have this health.").defineInRange("Feet Part Health", 0.4D, 0.0D, 1000.0D);
/* 1069 */       builder.pop();
/*      */       
/* 1071 */       builder.push("body-parts-effects");
/* 1072 */       builder.comment(new String[] { " Each effect, threshold and amplifier lists must have the same number of items.", " The first effect will be triggered with the first amplifier value when the first threshold is reach."
/*      */           
/* 1074 */           }).push("head");
/* 1075 */       this
/*      */         
/* 1077 */         .headPartEffects = builder.comment(" The list of effects that will be triggered when the head is damaged by the percentage of remaining head health defined in the thresholds.").defineListAllowEmpty("Head Part Effects", List.of("legendarysurvivaloverhaul:headache"), Config::validateEffectName);
/* 1078 */       this
/*      */ 
/*      */         
/* 1081 */         .headPartEffectAmplifiers = builder.comment(new String[] { " The list of amplifiers the effect will have.", " 0 means the basic effect, 1 means the effect is amplified once." }).defineListAllowEmpty("Head Part Effect Amplifiers", List.of(Integer.valueOf(0)), Config::validatePositiveInt);
/* 1082 */       this
/*      */ 
/*      */         
/* 1085 */         .headPartEffectThresholds = builder.comment(new String[] { " The list of thresholds for which each effect will be triggered. A threshold is a percentage of remaining head health.", " 0 means the head is fully damaged." }).defineListAllowEmpty("Head Part Effect Thresholds", List.of(Double.valueOf(0.2D)), Config::validatePercentDouble);
/* 1086 */       builder.pop();
/* 1087 */       builder.push("arms");
/* 1088 */       this.armsPartEffects = builder.defineListAllowEmpty("Arms Part Effects", List.of("minecraft:mining_fatigue"), Config::validateEffectName);
/* 1089 */       this.armsPartEffectAmplifiers = builder.defineListAllowEmpty("Arms Part Effect Amplifiers", List.of(Integer.valueOf(0)), Config::validatePositiveInt);
/* 1090 */       this.armsPartEffectThresholds = builder.defineListAllowEmpty("Arms Part Effect Thresholds", List.of(Double.valueOf(0.2D)), Config::validatePercentDouble);
/* 1091 */       this
/*      */ 
/*      */         
/* 1094 */         .bothArmsPartEffects = builder.comment(new String[] { " These effects will be triggered when both arms reach the thresholds.", " If a same effect is used with a higher amplifier, the higher prevails (normal Minecraft behaviour)." }).defineListAllowEmpty("Both Arms Part Effects", List.of("minecraft:weakness"), Config::validateEffectName);
/* 1095 */       this.bothArmsPartEffectAmplifiers = builder.defineListAllowEmpty("Both Arms Part Effect Amplifiers", List.of(Integer.valueOf(0)), Config::validatePositiveInt);
/* 1096 */       this.bothArmsPartEffectThresholds = builder.defineListAllowEmpty("Both Arms Part Effect Thresholds", List.of(Double.valueOf(0.2D)), Config::validatePercentDouble);
/* 1097 */       builder.pop();
/* 1098 */       builder.push("chest");
/* 1099 */       this.chestPartEffects = builder.defineListAllowEmpty("Chest Part Effects", List.of("legendarysurvivaloverhaul:vulnerability"), Config::validateEffectName);
/* 1100 */       this.chestPartEffectAmplifiers = builder.defineListAllowEmpty("Chest Part Effect Amplifier", List.of(Integer.valueOf(0)), Config::validatePositiveInt);
/* 1101 */       this.chestPartEffectThresholds = builder.defineListAllowEmpty("Chest Part Effect Thresholds", List.of(Double.valueOf(0.2D)), Config::validatePercentDouble);
/* 1102 */       builder.pop();
/* 1103 */       builder.push("legs");
/* 1104 */       this.legsPartEffects = builder.defineListAllowEmpty("Legs Part Effects", List.of("legendarysurvivaloverhaul:hard_falling"), Config::validateEffectName);
/* 1105 */       this.legsPartEffectAmplifiers = builder.defineListAllowEmpty("Legs Part Effect Amplifiers", List.of(Integer.valueOf(0)), Config::validatePositiveInt);
/* 1106 */       this.legsPartEffectThresholds = builder.defineListAllowEmpty("Legs Part Effect Thresholds", List.of(Double.valueOf(0.2D)), Config::validatePercentDouble);
/* 1107 */       this.bothLegsPartEffects = builder.defineListAllowEmpty("Both Legs Part Effects", List.of("legendarysurvivaloverhaul:hard_falling"), Config::validateEffectName);
/* 1108 */       this.bothLegsPartEffectAmplifiers = builder.defineListAllowEmpty("Both Legs Part Effect Amplifiers", List.of(Integer.valueOf(1)), Config::validatePositiveInt);
/* 1109 */       this.bothLegsPartEffectThresholds = builder.defineListAllowEmpty("Both Legs Part Effect Thresholds", List.of(Double.valueOf(0.2D)), Config::validatePercentDouble);
/* 1110 */       builder.pop();
/* 1111 */       builder.push("feet");
/* 1112 */       this.feetPartEffects = builder.defineListAllowEmpty("Feet Part Effects", Collections.singletonList("minecraft:slowness"), Config::validateEffectName);
/* 1113 */       this.feetPartEffectAmplifiers = builder.defineListAllowEmpty("Feet Part Effect Amplifiers", Collections.singletonList(Integer.valueOf(0)), Config::validatePositiveInt);
/* 1114 */       this.feetPartEffectThresholds = builder.defineListAllowEmpty("Feet Part Effect Thresholds", Collections.singletonList(Double.valueOf(0.2D)), Config::validatePercentDouble);
/* 1115 */       this.bothFeetPartEffects = builder.defineListAllowEmpty("Both Feet Part Effects", Collections.singletonList("minecraft:slowness"), Config::validateEffectName);
/* 1116 */       this.bothFeetPartEffectAmplifiers = builder.defineListAllowEmpty("Both Feet Part Effect Amplifiers", Collections.singletonList(Integer.valueOf(1)), Config::validatePositiveInt);
/* 1117 */       this.bothFeetPartEffectThresholds = builder.defineListAllowEmpty("Both Feet Part Effect Thresholds", Collections.singletonList(Double.valueOf(0.2D)), Config::validatePercentDouble);
/* 1118 */       builder.pop();
/* 1119 */       builder.pop();
/*      */       
/* 1121 */       builder.push("integration");
/* 1122 */       builder.push("meds_and_herbs");
/* 1123 */       this
/*      */ 
/*      */         
/* 1126 */         .morphineSyringeApplyPainkillerAddiction = builder.comment(new String[] { " Painkiller Addiction effect prevents the abusive usage of Painkiller effect that prevents all negative effects from limbs.", " Syringe Morphine share the same configuration as Morphine item" }).define("Syringe Morphine Apply Painkiller Addiction", true);
/* 1127 */       builder.pop();
/*      */       
/* 1129 */       builder.pop();
/* 1130 */       builder.pop();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class Client
/*      */   {
/*      */     public final ModConfigSpec.BooleanValue foodSaturationDisplayed;
/*      */     
/*      */     public final ModConfigSpec.BooleanValue showVanillaBarAnimationOverlay;
/*      */     
/*      */     public final ModConfigSpec.EnumValue<EnumUtil.temperatureDisplayMode> temperatureDisplayMode;
/*      */     
/*      */     public final ModConfigSpec.IntValue temperatureDisplayOffsetX;
/*      */     
/*      */     public final ModConfigSpec.IntValue temperatureDisplayOffsetY;
/*      */     
/*      */     public final ModConfigSpec.IntValue bodyTemperatureDisplayOffsetX;
/*      */     
/*      */     public final ModConfigSpec.IntValue bodyTemperatureDisplayOffsetY;
/*      */     
/*      */     public final ModConfigSpec.BooleanValue heatTemperatureOverlay;
/*      */     public final ModConfigSpec.BooleanValue coldTemperatureOverlay;
/*      */     public final ModConfigSpec.BooleanValue breathingSoundEnabled;
/*      */     public final ModConfigSpec.DoubleValue coldBreathEffectThreshold;
/*      */     public final ModConfigSpec.BooleanValue renderTemperatureInFahrenheit;
/*      */     public final ModConfigSpec.IntValue wetnessIndicatorOffsetX;
/*      */     public final ModConfigSpec.IntValue wetnessIndicatorOffsetY;
/*      */     public final ModConfigSpec.IntValue bodyDamageIndicatorOffsetX;
/*      */     public final ModConfigSpec.IntValue bodyDamageIndicatorOffsetY;
/*      */     public final ModConfigSpec.DoubleValue bodyDamageIndicatorRenderHealthLimit;
/*      */     public final ModConfigSpec.IntValue seasonCardsDisplayOffsetX;
/*      */     public final ModConfigSpec.IntValue seasonCardsDisplayOffsetY;
/*      */     public final ModConfigSpec.IntValue seasonCardsSpawnDimensionDelayInTicks;
/*      */     public final ModConfigSpec.IntValue seasonCardsDisplayTimeInTicks;
/*      */     public final ModConfigSpec.IntValue seasonCardsFadeInInTicks;
/*      */     public final ModConfigSpec.IntValue seasonCardsFadeOutInTicks;
/*      */     public final ModConfigSpec.BooleanValue showHydrationTooltip;
/*      */     public final ModConfigSpec.BooleanValue mergeHydrationAndSaturationTooltip;
/*      */     public final ModConfigSpec.BooleanValue hydrationSaturationDisplayed;
/*      */     public final ModConfigSpec.BooleanValue hydrationExhaustionDisplayed;
/*      */     public final ModConfigSpec.BooleanValue lowHydrationEffect;
/*      */     public final ModConfigSpec.BooleanValue showHydrationBar;
/*      */     public final ModConfigSpec.BooleanValue showDrinkPreview;
/*      */     public final ModConfigSpec.IntValue hydrationBarOffsetX;
/*      */     public final ModConfigSpec.IntValue hydrationBarOffsetY;
/*      */     public final ModConfigSpec.BooleanValue appendBrokenShieldHeartsToHealthBar;
/*      */     
/*      */     Client(ModConfigSpec.Builder builder) {
/* 1179 */       builder.comment(new String[] { " Options related to the heads up display.", " These options will automatically update upon being saved."
/*      */           
/* 1181 */           }).push("hud");
/* 1182 */       builder.push("general");
/*      */       
/* 1184 */       this
/*      */         
/* 1186 */         .foodSaturationDisplayed = builder.comment(" If enabled, the food saturation will be rendered on the Food Bar while the player suffers Cold Hunger Effect (secondary temperature effect).").define("Show Food Saturation Bar", true);
/*      */       
/* 1188 */       this
/*      */ 
/*      */ 
/*      */         
/* 1192 */         .showVanillaBarAnimationOverlay = builder.comment(new String[] { " Whether the vanilla animation of the Food bar and Hydration bar is rendered. The bar shakes more the lower they are.", " This mod render a new food bar as a secondary effect of a cold temperature.", " Disable this animation if the temperature secondary effect is enabled to allow a compatibility with other mods rendering the food bar (for example Appleskin)." }).define("Show Vanilla Bar Animation Overlay", true);
/* 1193 */       builder.pop();
/*      */       
/* 1195 */       builder.push("temperature");
/* 1196 */       this
/*      */ 
/*      */ 
/*      */         
/* 1200 */         .temperatureDisplayMode = builder.comment(new String[] { " How temperature is displayed. Accepted values are as follows:", "    SYMBOL - Display the player's current temperature as a symbol above the hotbar.", "    NONE - Disable the temperature indicator." }).defineEnum("Temperature Display Mode", (Enum)EnumUtil.temperatureDisplayMode.SYMBOL);
/* 1201 */       this
/*      */         
/* 1203 */         .temperatureDisplayOffsetX = builder.comment(" The X and Y offset of the temperature indicator. Set both to 0 for no offset.").defineInRange("Temperature Display X Offset", 0, -10000, 10000);
/* 1204 */       this
/* 1205 */         .temperatureDisplayOffsetY = builder.defineInRange("Temperature Display Y Offset", 0, -10000, 10000);
/* 1206 */       this
/*      */ 
/*      */         
/* 1209 */         .bodyTemperatureDisplayOffsetX = builder.comment(new String[] { " The X and Y offset of the body temperature, shown when thermometer is equipped as a bauble (needs the curios mod).", " Set both to 0 for no offset." }).defineInRange("Body Temperature Display X Offset", 0, -10000, 10000);
/* 1210 */       this
/* 1211 */         .bodyTemperatureDisplayOffsetY = builder.defineInRange("Body Temperature Display Y Offset", 0, -10000, 10000);
/* 1212 */       this
/*      */         
/* 1214 */         .heatTemperatureOverlay = builder.comment(" If enabled, player will see a foggy effect when the heat is high.").define("Heat Temperature Overlay", true);
/* 1215 */       this
/*      */         
/* 1217 */         .coldTemperatureOverlay = builder.comment(" If enabled, player will see a frost effect when the cold is low.").define("Cold Temperature Overlay", true);
/* 1218 */       this
/*      */         
/* 1220 */         .breathingSoundEnabled = builder.comment(" If enabled, breathing sound can be heard while player faces harsh temperatures.").define("Breathing Sound Enabled", true);
/* 1221 */       this
/*      */         
/* 1223 */         .coldBreathEffectThreshold = builder.comment(" Temperature threshold below which a cold breath effect is rendered by the player. -1000 disable the feature.").defineInRange("Cold Breath Temperature Threshold", 10.0D, -1000.0D, 1000.0D);
/* 1224 */       this
/*      */         
/* 1226 */         .renderTemperatureInFahrenheit = builder.comment(" If enabled, render the temperature values in Fahrenheit.").define("Temperature In Fahrenheit", false);
/* 1227 */       builder.push("wetness");
/* 1228 */       this
/*      */         
/* 1230 */         .wetnessIndicatorOffsetX = builder.comment(" The X and Y offset of the wetness indicator. Set both to 0 for no offset.").defineInRange("Wetness Indicator X Offset", 0, -10000, 10000);
/* 1231 */       this
/* 1232 */         .wetnessIndicatorOffsetY = builder.defineInRange("Wetness Indicator Y Offset", 0, -10000, 10000);
/* 1233 */       builder.pop();
/* 1234 */       builder.pop();
/*      */       
/* 1236 */       builder.pop();
/*      */       
/* 1238 */       builder.push("body-damage");
/* 1239 */       this
/*      */         
/* 1241 */         .bodyDamageIndicatorOffsetX = builder.comment(new String[] { " The X and Y offset of the body damage indicator. Set both to 0 for no offset.", " By default, render next to the inventory bar." }).defineInRange("Body Damage Indicator X Offset", 0, -10000, 10000);
/* 1242 */       this.bodyDamageIndicatorOffsetY = builder.defineInRange("Body Damage Indicator Y Offset", 0, -10000, 10000);
/* 1243 */       this
/*      */         
/* 1245 */         .bodyDamageIndicatorRenderHealthLimit = builder.comment(new String[] { " Limb health threshold below which the body damage indicator is rendered.", " If set to 1.1, the body damage indicator is always rendered.", " If set to 1.0, the body damage indicator is rendered as soon as a limb is wounded." }).defineInRange("Body Damage Indicator Limb Health Threshold", 1.0D, 0.0D, 1.1D);
/* 1246 */       builder.pop();
/*      */       
/* 1248 */       builder.push("season-cards");
/* 1249 */       this
/*      */         
/* 1251 */         .seasonCardsDisplayOffsetX = builder.comment(new String[] { " The X and Y offset of the season cards. Set both to 0 for no offset.", " By default, render first top quarter vertically and centered horizontally." }).defineInRange("Season Cards Display X Offset", 0, -10000, 10000);
/* 1252 */       this
/* 1253 */         .seasonCardsDisplayOffsetY = builder.defineInRange("Season Cards Display Y Offset", 0, -10000, 10000);
/* 1254 */       this
/*      */         
/* 1256 */         .seasonCardsSpawnDimensionDelayInTicks = builder.comment(" The delay before rendering the season card at first player spawn or player dimension change.").defineInRange("Season Cards Delay In Ticks", 80, 0, 2147483647);
/* 1257 */       this
/*      */         
/* 1259 */         .seasonCardsDisplayTimeInTicks = builder.comment(" The display time in ticks that the season card will be fully rendered.").defineInRange("Season Cards Display Time In Ticks", 40, 0, 2147483647);
/* 1260 */       this
/*      */         
/* 1262 */         .seasonCardsFadeInInTicks = builder.comment(" The fade in time in ticks that the season card will appear.").defineInRange("Season Cards Fade in In Ticks", 20, 0, 2147483647);
/* 1263 */       this
/*      */         
/* 1265 */         .seasonCardsFadeOutInTicks = builder.comment(" The fade out time in ticks that the season card will disappear.").defineInRange("Season Cards Fade Out In Ticks", 20, 0, 2147483647);
/* 1266 */       builder.pop();
/*      */       
/* 1268 */       builder.push("thirst");
/*      */       
/* 1270 */       builder.push("tooltip");
/* 1271 */       this
/*      */         
/* 1273 */         .showHydrationTooltip = builder.comment(" If enabled, show the hydration values in the item tooltip.").define("Show Hydration Tooltip", true);
/* 1274 */       this
/*      */         
/* 1276 */         .mergeHydrationAndSaturationTooltip = builder.comment(" If enabled, show the hydration and the saturation values on the same line in the tooltip.").define("Merge Hydration And Saturation Tooltip", true);
/* 1277 */       builder.pop();
/*      */       
/* 1279 */       this
/*      */         
/* 1281 */         .hydrationSaturationDisplayed = builder.comment(" Whether the Hydration Saturation is displayed or not.").define("Render the hydration saturation", true);
/* 1282 */       this
/*      */         
/* 1284 */         .hydrationExhaustionDisplayed = builder.comment(" Whether the Hydration Exhaustion is displayed or not (grey bar behind the hydration bar).").define("Render the hydration exhaustion", true);
/* 1285 */       this
/*      */         
/* 1287 */         .lowHydrationEffect = builder.comment(" If enabled, player's vision will become blurry when running low on hydration.").define("Low Hydration Effect", true);
/* 1288 */       builder.push("hydration-bar");
/* 1289 */       this
/*      */         
/* 1291 */         .showHydrationBar = builder.comment(" If enabled, the hydration bar will be displayed.").define("Show Hydration Bar", true);
/* 1292 */       this
/*      */         
/* 1294 */         .showDrinkPreview = builder.comment(" If enabled, a preview on hydration bar will be displayed if player holds a drink item.").define("Show Drink Preview", true);
/* 1295 */       this
/*      */         
/* 1297 */         .hydrationBarOffsetX = builder.comment(" How much the hydration bar is moved to the right.").defineInRange("Hydration Bar Offset X", 0, -10000, 10000);
/* 1298 */       this
/*      */         
/* 1300 */         .hydrationBarOffsetY = builder.comment(" How much the hydration bar is moved to the bottom.").defineInRange("Hydration Bar Offset Y", 0, -10000, 10000);
/* 1301 */       builder.pop();
/* 1302 */       builder.pop();
/*      */       
/* 1304 */       builder.push("health-overhaul");
/* 1305 */       this
/*      */ 
/*      */         
/* 1308 */         .appendBrokenShieldHeartsToHealthBar = builder.comment(new String[] { " If enabled, will try to append the broken and shield hearts at the end of the Health Bar.", " A compat is made with overflowing-bars mod." }).define("Append Broken/Shield Hearts To Health Bar", true);
/* 1309 */       builder.pop();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class Server
/*      */   {
/*      */     Server(ModConfigSpec.Builder builder) {}
/*      */   }
/*      */ 
/*      */   
/*      */   public static class Baked
/*      */   {
/*      */     public static int routinePacketSync;
/*      */     
/*      */     public static boolean hideInfoFromDebug;
/*      */     
/*      */     public static boolean naturalRegenerationEnabled;
/*      */     
/*      */     public static boolean vanillaFreezeEnabled;
/*      */     
/*      */     public static EnumUtil.CompassInfo compassInfoMode;
/*      */     
/*      */     public static boolean showCoordinateOnMap;
/*      */     
/*      */     public static double initialHealth;
/*      */     
/*      */     public static EnumUtil.DifficultyMode difficultyMode;
/*      */     
/*      */     public static double baseFoodExhaustion;
/*      */     
/*      */     public static double sprintingFoodExhaustion;
/*      */     
/*      */     public static double onAttackFoodExhaustion;
/*      */     
/*      */     public static boolean temperatureEnabled;
/*      */     
/*      */     public static int tempTickTime;
/*      */     
/*      */     public static double minTemperatureModification;
/*      */     
/*      */     public static double maxTemperatureModification;
/*      */     
/*      */     public static boolean dangerousHeatTemperature;
/*      */     
/*      */     public static boolean dangerousColdTemperature;
/*      */     
/*      */     public static double goldFernChance;
/*      */     
/*      */     public static boolean temperatureImmunityOnDeathEnabled;
/*      */     
/*      */     public static int temperatureImmunityOnDeathTime;
/*      */     
/*      */     public static boolean temperatureImmunityOnFirstSpawnEnabled;
/*      */     
/*      */     public static int temperatureImmunityOnFirstSpawnTime;
/*      */     
/*      */     public static boolean heatTemperatureSecondaryEffects;
/*      */     
/*      */     public static boolean coldTemperatureSecondaryEffects;
/*      */     
/*      */     public static double heatThirstEffectModifier;
/*      */     
/*      */     public static double coldHungerEffectModifier;
/*      */     
/*      */     public static boolean biomeEffectsEnabled;
/*      */     
/*      */     public static double biomeDrynessMultiplier;
/*      */     
/*      */     public static double biomeTemperatureMultiplier;
/*      */     
/*      */     public static double undergroundBiomeTemperatureMultiplier;
/*      */     
/*      */     public static int undergroundEffectStartDistanceToWS;
/*      */     
/*      */     public static int undergroundEffectEndDistanceToWS;
/*      */     
/*      */     public static double rainTemperatureModifier;
/*      */     
/*      */     public static double snowTemperatureModifier;
/*      */     
/*      */     public static double maxFreezeTemperatureModifier;
/*      */     
/*      */     public static int maxFreezeEffectTick;
/*      */     
/*      */     public static double altitudeModifier;
/*      */     
/*      */     public static double timeModifier;
/*      */     
/*      */     public static double biomeTimeMultiplier;
/*      */     
/*      */     public static double shadeTimeModifier;
/*      */     
/*      */     public static double shadeTimeModifierThreshold;
/*      */     
/*      */     public static int tempInfluenceMaximumDist;
/*      */     
/*      */     public static double tempInfluenceUpDistMultiplier;
/*      */     
/*      */     public static double tempInfluenceOutsideDistMultiplier;
/*      */     
/*      */     public static double tempInfluenceInWaterDistMultiplier;
/*      */     
/*      */     public static double sprintModifier;
/*      */     
/*      */     public static double onFireModifier;
/*      */     
/*      */     public static double playerHuddlingModifier;
/*      */     
/*      */     public static int playerHuddlingRadius;
/*      */     
/*      */     public static boolean wetnessEnabled;
/*      */     
/*      */     public static List<? extends String> wetnessImmunityMounts;
/*      */     
/*      */     public static double wetMultiplier;
/*      */     
/*      */     public static int wetnessTickTimer;
/*      */     
/*      */     public static int wetnessDecrease;
/*      */     
/*      */     public static int wetnessRainIncrease;
/*      */     
/*      */     public static int wetnessFluidIncrease;
/*      */     
/*      */     public static double heatingCoat1Modifier;
/*      */     public static double heatingCoat2Modifier;
/*      */     public static double heatingCoat3Modifier;
/*      */     public static double coolingCoat1Modifier;
/*      */     public static double coolingCoat2Modifier;
/*      */     public static double coolingCoat3Modifier;
/*      */     public static double thermalCoat1Modifier;
/*      */     public static double thermalCoat2Modifier;
/*      */     public static double thermalCoat3Modifier;
/*      */     public static double tfcItemHeatMultiplier;
/*      */     public static double tfcTemperatureMultiplier;
/*      */     public static boolean sereneSeasonsEnabled;
/*      */     public static boolean ssTropicalSeasonsEnabled;
/*      */     public static boolean ssSeasonCardsEnabled;
/*      */     public static boolean ssDefaultSeasonEnabled;
/*      */     public static double ssEarlySpringModifier;
/*      */     public static double ssMidSpringModifier;
/*      */     public static double ssLateSpringModifier;
/*      */     public static double ssEarlySummerModifier;
/*      */     public static double ssMidSummerModifier;
/*      */     public static double ssLateSummerModifier;
/*      */     public static double ssEarlyAutumnModifier;
/*      */     public static double ssMidAutumnModifier;
/*      */     public static double ssLateAutumnModifier;
/*      */     public static double ssEarlyWinterModifier;
/*      */     public static double ssMidWinterModifier;
/*      */     public static double ssLateWinterModifier;
/*      */     public static double ssEarlyWetSeasonModifier;
/*      */     public static double ssMidWetSeasonModifier;
/*      */     public static double ssLateWetSeasonModifier;
/*      */     public static double ssEarlyDrySeasonModifier;
/*      */     public static double ssMidDrySeasonModifier;
/*      */     public static double ssLateDrySeasonModifier;
/*      */     public static boolean eclipticSeasonsEnabled;
/*      */     public static List<? extends Double> esSpringModifier;
/*      */     public static List<? extends Double> esSummerModifier;
/*      */     public static List<? extends Double> esAutumnModifier;
/*      */     public static List<? extends Double> esWinterModifier;
/*      */     public static boolean thirstEnabled;
/*      */     public static boolean dangerousDehydration;
/*      */     public static boolean cumulativeThirstEffectDuration;
/*      */     public static double dehydrationDamageScaling;
/*      */     public static double thirstEffectModifier;
/*      */     public static double baseHydrationExhaustion;
/*      */     public static double sprintingHydrationExhaustion;
/*      */     public static double onJumpHydrationExhaustion;
/*      */     public static double onBlockBreakHydrationExhaustion;
/*      */     public static double onAttackHydrationExhaustion;
/*      */     public static boolean selfWateringCanteenEnabled;
/*      */     public static int selfWateringCanteenWetnessIncrease;
/*      */     public static int canteenCapacity;
/*      */     public static int largeCanteenCapacity;
/*      */     public static boolean allowOverridePurifiedWater;
/*      */     public static int hydrationLava;
/*      */     public static double saturationLava;
/*      */     public static boolean glassBottleLootAfterDrink;
/*      */     public static int hydrationLavaBlazeborn;
/*      */     public static double saturationLavaBlazeborn;
/*      */     public static double extraThirstExhaustionShulk;
/*      */     public static double extraThirstExhaustionPhantom;
/*      */     public static boolean thirstEnabledIfVampire;
/*      */     public static boolean healthOverhaulEnabled;
/*      */     public static double maxAdditionalHealth;
/*      */     public static double maxShieldHealth;
/*      */     public static boolean absorptionEffectOverride;
/*      */     public static int heartsLostOnDeath;
/*      */     public static int permanentHearts;
/*      */     public static int resilientHeartsWithBrokenHearts;
/*      */     public static double brokenHeartsPerInjuredLimb;
/*      */     public static EnumUtil.brokenHeartsPerInjuredLimbMode brokenHeartsPerInjuredLimbMode;
/*      */     public static boolean localizedBodyDamageEnabled;
/*      */     public static double headCriticalShotMultiplier;
/*      */     public static double bodyDamageMultiplier;
/*      */     public static double bodyHealthRatioRecoveredFromSleep;
/*      */     public static double healthRatioRecoveredFromSleep;
/*      */     public static double bodyHealingFoodExhaustion;
/*      */     public static int minFoodOnBodyHealing;
/*      */     public static int painkillerAddictionDuration;
/*      */     public static boolean passiveLimbRegenerationOnFullHealth;
/*      */     public static List<? extends String> passiveLimbRegenerationEffects;
/*      */     public static boolean passiveLimbRegenerationAmplificationEnabled;
/*      */     public static double passiveLimbHealthRegenerated;
/*      */     public static int passiveLimbRegenerationTickTimer;
/*      */     public static double proportionalLimbRegenMinThreshold;
/*      */     public static double proportionalLimbRegenMinHealValue;
/*      */     public static double proportionalLimbRegenMaxHealValue;
/*      */     public static int proportionalLimbRegenTickRate;
/*      */     public static double proportionalLimbRegenIncreaseRate;
/*      */     public static boolean customHealthRegenEnabled;
/*      */     public static double customHealthRegenRate;
/*      */     public static int customHealthRegenTickRate;
/*      */     public static double customHealthRegenFoodExhaustion;
/*      */     public static double firstAidSuppliesLimbHealthRegenerated;
/*      */     public static EnumUtil.limbRegenerationMode limbRegenerationMode;
/*      */     public static boolean firstAidSuppliesHealingOverflow;
/*      */     public static int firstAidSuppliesTickTimer;
/*      */     public static boolean firstAidSuppliesExhaustsFood;
/*      */     public static List<? extends String> firstAidSuppliesBoostedOnEffects;
/*      */     public static double firstAidSuppliesBoostedTickTimerMultiplier;
/*      */     public static EnumUtil.bodyPartHealthMode bodyPartHealthMode;
/*      */     public static double headPartHealth;
/*      */     public static double armsPartHealth;
/*      */     public static double chestPartHealth;
/*      */     public static double legsPartHealth;
/*      */     public static double feetPartHealth;
/*      */     public static double recoveryEffectHealingValue;
/*      */     public static int healingHerbsUseTime;
/*      */     public static int plasterUseTime;
/*      */     public static int bandageUseTime;
/*      */     public static int tonicUseTime;
/*      */     public static int medkitUseTime;
/*      */     public static int morphineUseTime;
/*      */     public static int morphinePainkillerTickDuration;
/*      */     public static List<? extends String> headPartEffects;
/*      */     public static List<? extends Integer> headPartEffectAmplifiers;
/*      */     public static List<? extends Double> headPartEffectThresholds;
/*      */     public static List<? extends String> armsPartEffects;
/*      */     public static List<? extends Integer> armsPartEffectAmplifiers;
/*      */     public static List<? extends Double> armsPartEffectThresholds;
/*      */     public static List<? extends String> bothArmsPartEffects;
/*      */     public static List<? extends Integer> bothArmsPartEffectAmplifiers;
/*      */     public static List<? extends Double> bothArmsPartEffectThresholds;
/*      */     public static List<? extends String> chestPartEffects;
/*      */     public static List<? extends Integer> chestPartEffectAmplifiers;
/*      */     public static List<? extends Double> chestPartEffectThresholds;
/*      */     public static List<? extends String> legsPartEffects;
/*      */     public static List<? extends Integer> legsPartEffectAmplifiers;
/*      */     public static List<? extends Double> legsPartEffectThresholds;
/*      */     public static List<? extends String> bothLegsPartEffects;
/*      */     public static List<? extends Integer> bothLegsPartEffectAmplifiers;
/*      */     public static List<? extends Double> bothLegsPartEffectThresholds;
/*      */     public static List<? extends String> feetPartEffects;
/*      */     public static List<? extends Integer> feetPartEffectAmplifiers;
/*      */     public static List<? extends Double> feetPartEffectThresholds;
/*      */     public static List<? extends String> bothFeetPartEffects;
/*      */     public static List<? extends Integer> bothFeetPartEffectAmplifiers;
/*      */     public static List<? extends Double> bothFeetPartEffectThresholds;
/*      */     public static boolean morphineSyringeApplyPainkillerAddiction;
/*      */     public static EnumUtil.temperatureDisplayMode temperatureDisplayMode;
/*      */     public static int temperatureDisplayOffsetX;
/*      */     public static int temperatureDisplayOffsetY;
/*      */     public static int bodyTemperatureDisplayOffsetX;
/*      */     public static int bodyTemperatureDisplayOffsetY;
/*      */     public static boolean heatTemperatureOverlay;
/*      */     public static boolean coldTemperatureOverlay;
/*      */     public static boolean breathingSoundEnabled;
/*      */     public static double coldBreathEffectThreshold;
/*      */     public static boolean renderTemperatureInFahrenheit;
/*      */     public static boolean foodSaturationDisplayed;
/*      */     public static boolean showVanillaBarAnimationOverlay;
/*      */     public static int seasonCardsDisplayOffsetX;
/*      */     public static int seasonCardsDisplayOffsetY;
/*      */     public static int seasonCardsSpawnDimensionDelayInTicks;
/*      */     public static int seasonCardsDisplayTimeInTicks;
/*      */     public static int seasonCardsFadeInInTicks;
/*      */     public static int seasonCardsFadeOutInTicks;
/*      */     public static int wetnessIndicatorOffsetX;
/*      */     public static int wetnessIndicatorOffsetY;
/*      */     public static int bodyDamageIndicatorOffsetX;
/*      */     public static int bodyDamageIndicatorOffsetY;
/*      */     public static double bodyDamageIndicatorRenderHealthLimit;
/*      */     public static boolean showHydrationTooltip;
/*      */     public static boolean mergeHydrationAndSaturationTooltip;
/*      */     public static boolean hydrationSaturationDisplayed;
/*      */     public static boolean hydrationExhaustionDisplayed;
/*      */     public static boolean lowHydrationEffect;
/*      */     public static boolean showHydrationBar;
/*      */     public static boolean showDrinkPreview;
/*      */     public static int hydrationBarOffsetX;
/*      */     public static int hydrationBarOffsetY;
/*      */     public static boolean appendBrokenShieldHeartsToHealthBar;
/*      */     
/*      */     public static void bakeCommon() {
/* 1607 */       LegendarySurvivalOverhaul.LOGGER.debug("Load Common configuration from file");
/*      */       
/*      */       try {
/* 1610 */         hideInfoFromDebug = ((Boolean)Config.COMMON.hideInfoFromDebug.get()).booleanValue();
/* 1611 */         naturalRegenerationEnabled = ((Boolean)Config.COMMON.naturalRegenerationEnabled.get()).booleanValue();
/* 1612 */         routinePacketSync = ((Integer)Config.COMMON.routinePacketSync.get()).intValue();
/* 1613 */         vanillaFreezeEnabled = ((Boolean)Config.COMMON.vanillaFreezeEnabled.get()).booleanValue();
/* 1614 */         compassInfoMode = (EnumUtil.CompassInfo)Config.COMMON.compassInfoMode.get();
/* 1615 */         showCoordinateOnMap = ((Boolean)Config.COMMON.showCoordinateOnMap.get()).booleanValue();
/* 1616 */         initialHealth = ((Double)Config.COMMON.initialHealth.get()).doubleValue();
/* 1617 */         difficultyMode = (EnumUtil.DifficultyMode)Config.COMMON.difficultyMode.get();
/*      */         
/* 1619 */         baseFoodExhaustion = ((Double)Config.COMMON.baseFoodExhaustion.get()).doubleValue();
/* 1620 */         sprintingFoodExhaustion = ((Double)Config.COMMON.sprintingFoodExhaustion.get()).doubleValue();
/* 1621 */         onAttackFoodExhaustion = ((Double)Config.COMMON.onAttackFoodExhaustion.get()).doubleValue();
/*      */         
/* 1623 */         temperatureEnabled = ((Boolean)Config.COMMON.temperatureEnabled.get()).booleanValue();
/* 1624 */         tempTickTime = ((Integer)Config.COMMON.tempTickTime.get()).intValue();
/* 1625 */         minTemperatureModification = ((Double)Config.COMMON.minTemperatureModification.get()).doubleValue();
/* 1626 */         maxTemperatureModification = ((Double)Config.COMMON.maxTemperatureModification.get()).doubleValue();
/*      */         
/* 1628 */         dangerousHeatTemperature = ((Boolean)Config.COMMON.dangerousHeatTemperature.get()).booleanValue();
/* 1629 */         dangerousColdTemperature = ((Boolean)Config.COMMON.dangerousColdTemperature.get()).booleanValue();
/* 1630 */         goldFernChance = ((Double)Config.COMMON.goldFernChance.get()).doubleValue();
/*      */         
/* 1632 */         temperatureImmunityOnDeathEnabled = ((Boolean)Config.COMMON.temperatureImmunityOnDeathEnabled.get()).booleanValue();
/* 1633 */         temperatureImmunityOnDeathTime = ((Integer)Config.COMMON.temperatureImmunityOnDeathTime.get()).intValue();
/* 1634 */         temperatureImmunityOnFirstSpawnEnabled = ((Boolean)Config.COMMON.temperatureImmunityOnFirstSpawnEnabled.get()).booleanValue();
/* 1635 */         temperatureImmunityOnFirstSpawnTime = ((Integer)Config.COMMON.temperatureImmunityOnFirstSpawnTime.get()).intValue();
/*      */         
/* 1637 */         heatTemperatureSecondaryEffects = ((Boolean)Config.COMMON.heatTemperatureSecondaryEffects.get()).booleanValue();
/* 1638 */         coldTemperatureSecondaryEffects = ((Boolean)Config.COMMON.coldTemperatureSecondaryEffects.get()).booleanValue();
/* 1639 */         heatThirstEffectModifier = ((Double)Config.COMMON.heatThirstEffectModifier.get()).doubleValue();
/* 1640 */         coldHungerEffectModifier = ((Double)Config.COMMON.coldHungerEffectModifier.get()).doubleValue();
/*      */         
/* 1642 */         rainTemperatureModifier = ((Double)Config.COMMON.rainTemperatureModifier.get()).doubleValue();
/* 1643 */         snowTemperatureModifier = ((Double)Config.COMMON.snowTemperatureModifier.get()).doubleValue();
/*      */         
/* 1645 */         maxFreezeTemperatureModifier = ((Double)Config.COMMON.maxFreezeTemperatureModifier.get()).doubleValue();
/* 1646 */         maxFreezeEffectTick = ((Integer)Config.COMMON.maxFreezeEffectTick.get()).intValue();
/*      */         
/* 1648 */         undergroundBiomeTemperatureMultiplier = ((Double)Config.COMMON.undergroundBiomeTemperatureMultiplier.get()).doubleValue();
/* 1649 */         undergroundEffectStartDistanceToWS = ((Integer)Config.COMMON.undergroundEffectStartDistanceToWS.get()).intValue();
/* 1650 */         undergroundEffectEndDistanceToWS = ((Integer)Config.COMMON.undergroundEffectEndDistanceToWS.get()).intValue();
/*      */         
/* 1652 */         altitudeModifier = ((Double)Config.COMMON.altitudeModifier.get()).doubleValue();
/* 1653 */         biomeEffectsEnabled = ((Boolean)Config.COMMON.biomeEffectsEnabled.get()).booleanValue();
/* 1654 */         biomeDrynessMultiplier = ((Double)Config.COMMON.biomeDrynessMultiplier.get()).doubleValue();
/* 1655 */         biomeTemperatureMultiplier = ((Double)Config.COMMON.biomeTemperatureMultiplier.get()).doubleValue();
/* 1656 */         timeModifier = ((Double)Config.COMMON.timeModifier.get()).doubleValue();
/* 1657 */         biomeTimeMultiplier = ((Double)Config.COMMON.biomeTimeMultiplier.get()).doubleValue();
/* 1658 */         shadeTimeModifier = ((Double)Config.COMMON.shadeTimeModifier.get()).doubleValue();
/* 1659 */         shadeTimeModifierThreshold = ((Double)Config.COMMON.shadeTimeModifierThreshold.get()).doubleValue();
/*      */         
/* 1661 */         tempInfluenceMaximumDist = ((Integer)Config.COMMON.tempInfluenceMaximumDist.get()).intValue();
/* 1662 */         tempInfluenceUpDistMultiplier = ((Double)Config.COMMON.tempInfluenceUpDistMultiplier.get()).doubleValue();
/* 1663 */         tempInfluenceInWaterDistMultiplier = ((Double)Config.COMMON.tempInfluenceInWaterDistMultiplier.get()).doubleValue();
/* 1664 */         tempInfluenceOutsideDistMultiplier = ((Double)Config.COMMON.tempInfluenceOutsideDistMultiplier.get()).doubleValue();
/*      */         
/* 1666 */         onFireModifier = ((Double)Config.COMMON.onFireModifier.get()).doubleValue();
/* 1667 */         sprintModifier = ((Double)Config.COMMON.sprintModifier.get()).doubleValue();
/*      */         
/* 1669 */         wetnessEnabled = ((Boolean)Config.COMMON.wetnessEnabled.get()).booleanValue();
/* 1670 */         wetnessImmunityMounts = (List<? extends String>)Config.COMMON.wetnessImmunityMounts.get();
/* 1671 */         wetMultiplier = ((Double)Config.COMMON.wetMultiplier.get()).doubleValue();
/* 1672 */         wetnessTickTimer = ((Integer)Config.COMMON.wetnessTickTimer.get()).intValue();
/* 1673 */         wetnessDecrease = ((Integer)Config.COMMON.wetnessDecrease.get()).intValue();
/* 1674 */         wetnessRainIncrease = ((Integer)Config.COMMON.wetnessRainIncrease.get()).intValue();
/* 1675 */         wetnessFluidIncrease = ((Integer)Config.COMMON.wetnessFluidIncrease.get()).intValue();
/*      */         
/* 1677 */         playerHuddlingModifier = ((Double)Config.COMMON.playerHuddlingModifier.get()).doubleValue();
/* 1678 */         playerHuddlingRadius = ((Integer)Config.COMMON.playerHuddlingRadius.get()).intValue();
/*      */         
/* 1680 */         heatingCoat1Modifier = ((Double)Config.COMMON.heatingCoat1Modifier.get()).doubleValue();
/* 1681 */         heatingCoat2Modifier = ((Double)Config.COMMON.heatingCoat2Modifier.get()).doubleValue();
/* 1682 */         heatingCoat3Modifier = ((Double)Config.COMMON.heatingCoat3Modifier.get()).doubleValue();
/*      */         
/* 1684 */         coolingCoat1Modifier = ((Double)Config.COMMON.coolingCoat1Modifier.get()).doubleValue();
/* 1685 */         coolingCoat2Modifier = ((Double)Config.COMMON.coolingCoat2Modifier.get()).doubleValue();
/* 1686 */         coolingCoat3Modifier = ((Double)Config.COMMON.coolingCoat3Modifier.get()).doubleValue();
/*      */         
/* 1688 */         thermalCoat1Modifier = ((Double)Config.COMMON.thermalCoat1Modifier.get()).doubleValue();
/* 1689 */         thermalCoat2Modifier = ((Double)Config.COMMON.thermalCoat2Modifier.get()).doubleValue();
/* 1690 */         thermalCoat3Modifier = ((Double)Config.COMMON.thermalCoat3Modifier.get()).doubleValue();
/*      */         
/* 1692 */         tfcItemHeatMultiplier = ((Double)Config.COMMON.tfcItemHeatMultiplier.get()).doubleValue();
/* 1693 */         tfcTemperatureMultiplier = ((Double)Config.COMMON.tfcTemperatureMultiplier.get()).doubleValue();
/*      */         
/* 1695 */         sereneSeasonsEnabled = ((Boolean)Config.COMMON.sereneSeasonsEnabled.get()).booleanValue();
/* 1696 */         ssTropicalSeasonsEnabled = ((Boolean)Config.COMMON.ssTropicalSeasonsEnabled.get()).booleanValue();
/* 1697 */         ssSeasonCardsEnabled = ((Boolean)Config.COMMON.ssSeasonCardsEnabled.get()).booleanValue();
/* 1698 */         ssDefaultSeasonEnabled = ((Boolean)Config.COMMON.ssDefaultSeasonEnabled.get()).booleanValue();
/*      */         
/* 1700 */         ssEarlySpringModifier = ((Double)Config.COMMON.ssEarlySpringModifier.get()).doubleValue();
/* 1701 */         ssMidSpringModifier = ((Double)Config.COMMON.ssMidSpringModifier.get()).doubleValue();
/* 1702 */         ssLateSpringModifier = ((Double)Config.COMMON.ssLateSpringModifier.get()).doubleValue();
/*      */         
/* 1704 */         ssEarlySummerModifier = ((Double)Config.COMMON.ssEarlySummerModifier.get()).doubleValue();
/* 1705 */         ssMidSummerModifier = ((Double)Config.COMMON.ssMidSummerModifier.get()).doubleValue();
/* 1706 */         ssLateSummerModifier = ((Double)Config.COMMON.ssLateSummerModifier.get()).doubleValue();
/*      */         
/* 1708 */         ssEarlyAutumnModifier = ((Double)Config.COMMON.ssEarlyAutumnModifier.get()).doubleValue();
/* 1709 */         ssMidAutumnModifier = ((Double)Config.COMMON.ssMidAutumnModifier.get()).doubleValue();
/* 1710 */         ssLateAutumnModifier = ((Double)Config.COMMON.ssLateAutumnModifier.get()).doubleValue();
/*      */         
/* 1712 */         ssEarlyWinterModifier = ((Double)Config.COMMON.ssEarlyWinterModifier.get()).doubleValue();
/* 1713 */         ssMidWinterModifier = ((Double)Config.COMMON.ssMidWinterModifier.get()).doubleValue();
/* 1714 */         ssLateWinterModifier = ((Double)Config.COMMON.ssLateWinterModifier.get()).doubleValue();
/*      */         
/* 1716 */         ssEarlyWetSeasonModifier = ((Double)Config.COMMON.ssEarlyWetSeasonModifier.get()).doubleValue();
/* 1717 */         ssMidWetSeasonModifier = ((Double)Config.COMMON.ssMidWetSeasonModifier.get()).doubleValue();
/* 1718 */         ssLateWetSeasonModifier = ((Double)Config.COMMON.ssLateWetSeasonModifier.get()).doubleValue();
/*      */         
/* 1720 */         ssEarlyDrySeasonModifier = ((Double)Config.COMMON.ssEarlyDrySeasonModifier.get()).doubleValue();
/* 1721 */         ssMidDrySeasonModifier = ((Double)Config.COMMON.ssMidDrySeasonModifier.get()).doubleValue();
/* 1722 */         ssLateDrySeasonModifier = ((Double)Config.COMMON.ssLateDrySeasonModifier.get()).doubleValue();
/*      */         
/* 1724 */         eclipticSeasonsEnabled = ((Boolean)Config.COMMON.eclipticSeasonsEnabled.get()).booleanValue();
/* 1725 */         esSpringModifier = (List<? extends Double>)Config.COMMON.esSpringModifier.get();
/* 1726 */         esSummerModifier = (List<? extends Double>)Config.COMMON.esSummerModifier.get();
/* 1727 */         esAutumnModifier = (List<? extends Double>)Config.COMMON.esAutumnModifier.get();
/* 1728 */         esWinterModifier = (List<? extends Double>)Config.COMMON.esWinterModifier.get();
/*      */         
/* 1730 */         thirstEnabled = ((Boolean)Config.COMMON.thirstEnabled.get()).booleanValue();
/* 1731 */         dangerousDehydration = ((Boolean)Config.COMMON.dangerousDehydration.get()).booleanValue();
/* 1732 */         cumulativeThirstEffectDuration = ((Boolean)Config.COMMON.cumulativeThirstEffectDuration.get()).booleanValue();
/* 1733 */         dehydrationDamageScaling = ((Double)Config.COMMON.dehydrationDamageScaling.get()).doubleValue();
/* 1734 */         thirstEffectModifier = ((Double)Config.COMMON.thirstEffectModifier.get()).doubleValue();
/*      */         
/* 1736 */         baseHydrationExhaustion = ((Double)Config.COMMON.baseHydrationExhaustion.get()).doubleValue();
/* 1737 */         sprintingHydrationExhaustion = ((Double)Config.COMMON.sprintingHydrationExhaustion.get()).doubleValue();
/* 1738 */         onJumpHydrationExhaustion = ((Double)Config.COMMON.onJumpHydrationExhaustion.get()).doubleValue();
/* 1739 */         onBlockBreakHydrationExhaustion = ((Double)Config.COMMON.onBlockBreakHydrationExhaustion.get()).doubleValue();
/* 1740 */         onAttackHydrationExhaustion = ((Double)Config.COMMON.onAttackHydrationExhaustion.get()).doubleValue();
/*      */         
/* 1742 */         selfWateringCanteenEnabled = ((Boolean)Config.COMMON.selfWateringCanteenEnabled.get()).booleanValue();
/* 1743 */         selfWateringCanteenWetnessIncrease = ((Integer)Config.COMMON.selfWateringCanteenWetnessIncrease.get()).intValue();
/* 1744 */         canteenCapacity = ((Integer)Config.COMMON.canteenCapacity.get()).intValue();
/* 1745 */         largeCanteenCapacity = ((Integer)Config.COMMON.largeCanteenCapacity.get()).intValue();
/* 1746 */         allowOverridePurifiedWater = ((Boolean)Config.COMMON.allowOverridePurifiedWater.get()).booleanValue();
/*      */         
/* 1748 */         hydrationLava = ((Integer)Config.COMMON.hydrationLava.get()).intValue();
/* 1749 */         saturationLava = ((Double)Config.COMMON.saturationLava.get()).doubleValue();
/*      */         
/* 1751 */         glassBottleLootAfterDrink = ((Boolean)Config.COMMON.glassBottleLootAfterDrink.get()).booleanValue();
/*      */         
/* 1753 */         hydrationLavaBlazeborn = ((Integer)Config.COMMON.hydrationLavaBlazeborn.get()).intValue();
/* 1754 */         saturationLavaBlazeborn = ((Double)Config.COMMON.saturationLavaBlazeborn.get()).doubleValue();
/* 1755 */         extraThirstExhaustionShulk = ((Double)Config.COMMON.extraThirstExhaustionShulk.get()).doubleValue();
/* 1756 */         extraThirstExhaustionPhantom = ((Double)Config.COMMON.extraThirstExhaustionPhantom.get()).doubleValue();
/* 1757 */         thirstEnabledIfVampire = ((Boolean)Config.COMMON.thirstEnabledIfVampire.get()).booleanValue();
/*      */         
/* 1759 */         healthOverhaulEnabled = ((Boolean)Config.COMMON.healthOverhaulEnabled.get()).booleanValue();
/* 1760 */         maxAdditionalHealth = ((Double)Config.COMMON.maxAdditionalHealth.get()).doubleValue();
/* 1761 */         maxShieldHealth = ((Double)Config.COMMON.maxShieldHealth.get()).doubleValue();
/* 1762 */         absorptionEffectOverride = ((Boolean)Config.COMMON.absorptionEffectOverride.get()).booleanValue();
/* 1763 */         heartsLostOnDeath = ((Integer)Config.COMMON.heartsLostOnDeath.get()).intValue();
/* 1764 */         permanentHearts = ((Integer)Config.COMMON.permanentHearts.get()).intValue();
/* 1765 */         resilientHeartsWithBrokenHearts = ((Integer)Config.COMMON.resilientHeartsWithBrokenHearts.get()).intValue();
/* 1766 */         brokenHeartsPerInjuredLimb = ((Double)Config.COMMON.brokenHeartsPerInjuredLimb.get()).doubleValue();
/* 1767 */         brokenHeartsPerInjuredLimbMode = (EnumUtil.brokenHeartsPerInjuredLimbMode)Config.COMMON.brokenHeartsPerInjuredLimbMode.get();
/*      */         
/* 1769 */         localizedBodyDamageEnabled = ((Boolean)Config.COMMON.localizedBodyDamageEnabled.get()).booleanValue();
/* 1770 */         headCriticalShotMultiplier = ((Double)Config.COMMON.headCriticalShotMultiplier.get()).doubleValue();
/* 1771 */         bodyDamageMultiplier = ((Double)Config.COMMON.bodyDamageMultiplier.get()).doubleValue();
/* 1772 */         bodyHealthRatioRecoveredFromSleep = ((Double)Config.COMMON.bodyHealthRatioRecoveredFromSleep.get()).doubleValue();
/* 1773 */         healthRatioRecoveredFromSleep = ((Double)Config.COMMON.healthRatioRecoveredFromSleep.get()).doubleValue();
/* 1774 */         bodyHealingFoodExhaustion = ((Double)Config.COMMON.bodyHealingFoodExhaustion.get()).doubleValue();
/* 1775 */         minFoodOnBodyHealing = ((Integer)Config.COMMON.minFoodOnBodyHealing.get()).intValue();
/* 1776 */         painkillerAddictionDuration = ((Integer)Config.COMMON.painkillerAddictionDuration.get()).intValue();
/*      */         
/* 1778 */         passiveLimbRegenerationOnFullHealth = ((Boolean)Config.COMMON.passiveLimbRegenerationOnFullHealth.get()).booleanValue();
/* 1779 */         passiveLimbRegenerationEffects = (List<? extends String>)Config.COMMON.passiveLimbRegenerationEffects.get();
/* 1780 */         passiveLimbRegenerationAmplificationEnabled = ((Boolean)Config.COMMON.passiveLimbRegenerationAmplificationEnabled.get()).booleanValue();
/* 1781 */         passiveLimbHealthRegenerated = ((Double)Config.COMMON.passiveLimbHealthRegenerated.get()).doubleValue();
/* 1782 */         passiveLimbRegenerationTickTimer = ((Integer)Config.COMMON.passiveLimbRegenerationTickTimer.get()).intValue();
/*      */         
/* 1784 */         proportionalLimbRegenMinThreshold = ((Double)Config.COMMON.proportionalLimbRegenMinThreshold.get()).doubleValue();
/* 1785 */         proportionalLimbRegenMinHealValue = ((Double)Config.COMMON.proportionalLimbRegenMinHealValue.get()).doubleValue();
/* 1786 */         proportionalLimbRegenMaxHealValue = ((Double)Config.COMMON.proportionalLimbRegenMaxHealValue.get()).doubleValue();
/* 1787 */         proportionalLimbRegenTickRate = ((Integer)Config.COMMON.proportionalLimbRegenTickRate.get()).intValue();
/* 1788 */         proportionalLimbRegenIncreaseRate = ((Double)Config.COMMON.proportionalLimbRegenIncreaseRate.get()).doubleValue();
/*      */         
/* 1790 */         customHealthRegenEnabled = ((Boolean)Config.COMMON.customHealthRegenEnabled.get()).booleanValue();
/* 1791 */         customHealthRegenRate = ((Double)Config.COMMON.customHealthRegenRate.get()).doubleValue();
/* 1792 */         customHealthRegenTickRate = ((Integer)Config.COMMON.customHealthRegenTickRate.get()).intValue();
/* 1793 */         customHealthRegenFoodExhaustion = ((Double)Config.COMMON.customHealthRegenFoodExhaustion.get()).doubleValue();
/*      */         
/* 1795 */         firstAidSuppliesLimbHealthRegenerated = ((Double)Config.COMMON.firstAidSuppliesLimbHealthRegenerated.get()).doubleValue();
/* 1796 */         limbRegenerationMode = (EnumUtil.limbRegenerationMode)Config.COMMON.firstAidSuppliesLimbRegenerationMode.get();
/* 1797 */         firstAidSuppliesHealingOverflow = ((Boolean)Config.COMMON.firstAidSuppliesHealingOverflow.get()).booleanValue();
/* 1798 */         firstAidSuppliesTickTimer = ((Integer)Config.COMMON.firstAidSuppliesTickTimer.get()).intValue();
/* 1799 */         firstAidSuppliesExhaustsFood = ((Boolean)Config.COMMON.firstAidSuppliesExhaustsFood.get()).booleanValue();
/* 1800 */         firstAidSuppliesBoostedOnEffects = (List<? extends String>)Config.COMMON.firstAidSuppliesBoostedOnEffects.get();
/* 1801 */         firstAidSuppliesBoostedTickTimerMultiplier = ((Double)Config.COMMON.firstAidSuppliesBoostedTickTimerMultiplier.get()).doubleValue();
/*      */         
/* 1803 */         recoveryEffectHealingValue = ((Double)Config.COMMON.recoveryEffectHealingValue.get()).doubleValue();
/* 1804 */         healingHerbsUseTime = ((Integer)Config.COMMON.healingHerbsUseTime.get()).intValue();
/* 1805 */         plasterUseTime = ((Integer)Config.COMMON.plasterUseTime.get()).intValue();
/* 1806 */         bandageUseTime = ((Integer)Config.COMMON.bandageUseTime.get()).intValue();
/* 1807 */         tonicUseTime = ((Integer)Config.COMMON.tonicUseTime.get()).intValue();
/* 1808 */         medkitUseTime = ((Integer)Config.COMMON.medkitUseTime.get()).intValue();
/* 1809 */         morphineUseTime = ((Integer)Config.COMMON.morphineUseTime.get()).intValue();
/* 1810 */         morphinePainkillerTickDuration = ((Integer)Config.COMMON.morphinePainkillerTickDuration.get()).intValue();
/*      */         
/* 1812 */         bodyPartHealthMode = (EnumUtil.bodyPartHealthMode)Config.COMMON.bodyPartHealthMode.get();
/* 1813 */         headPartHealth = ((Double)Config.COMMON.headPartHealth.get()).doubleValue();
/* 1814 */         chestPartHealth = ((Double)Config.COMMON.chestPartHealth.get()).doubleValue();
/* 1815 */         armsPartHealth = ((Double)Config.COMMON.armsPartHealth.get()).doubleValue();
/* 1816 */         legsPartHealth = ((Double)Config.COMMON.legsPartHealth.get()).doubleValue();
/* 1817 */         feetPartHealth = ((Double)Config.COMMON.feetPartHealth.get()).doubleValue();
/*      */         
/* 1819 */         headPartEffects = (List<? extends String>)Config.COMMON.headPartEffects.get();
/* 1820 */         headPartEffectAmplifiers = (List<? extends Integer>)Config.COMMON.headPartEffectAmplifiers.get();
/* 1821 */         headPartEffectThresholds = (List<? extends Double>)Config.COMMON.headPartEffectThresholds.get();
/* 1822 */         armsPartEffects = (List<? extends String>)Config.COMMON.armsPartEffects.get();
/* 1823 */         armsPartEffectAmplifiers = (List<? extends Integer>)Config.COMMON.armsPartEffectAmplifiers.get();
/* 1824 */         armsPartEffectThresholds = (List<? extends Double>)Config.COMMON.armsPartEffectThresholds.get();
/* 1825 */         bothArmsPartEffects = (List<? extends String>)Config.COMMON.bothArmsPartEffects.get();
/* 1826 */         bothArmsPartEffectAmplifiers = (List<? extends Integer>)Config.COMMON.bothArmsPartEffectAmplifiers.get();
/* 1827 */         bothArmsPartEffectThresholds = (List<? extends Double>)Config.COMMON.bothArmsPartEffectThresholds.get();
/* 1828 */         chestPartEffects = (List<? extends String>)Config.COMMON.chestPartEffects.get();
/* 1829 */         chestPartEffectAmplifiers = (List<? extends Integer>)Config.COMMON.chestPartEffectAmplifiers.get();
/* 1830 */         chestPartEffectThresholds = (List<? extends Double>)Config.COMMON.chestPartEffectThresholds.get();
/* 1831 */         legsPartEffects = (List<? extends String>)Config.COMMON.legsPartEffects.get();
/* 1832 */         legsPartEffectAmplifiers = (List<? extends Integer>)Config.COMMON.legsPartEffectAmplifiers.get();
/* 1833 */         legsPartEffectThresholds = (List<? extends Double>)Config.COMMON.legsPartEffectThresholds.get();
/* 1834 */         bothLegsPartEffects = (List<? extends String>)Config.COMMON.bothLegsPartEffects.get();
/* 1835 */         bothLegsPartEffectAmplifiers = (List<? extends Integer>)Config.COMMON.bothLegsPartEffectAmplifiers.get();
/* 1836 */         bothLegsPartEffectThresholds = (List<? extends Double>)Config.COMMON.bothLegsPartEffectThresholds.get();
/* 1837 */         feetPartEffects = (List<? extends String>)Config.COMMON.feetPartEffects.get();
/* 1838 */         feetPartEffectAmplifiers = (List<? extends Integer>)Config.COMMON.feetPartEffectAmplifiers.get();
/* 1839 */         feetPartEffectThresholds = (List<? extends Double>)Config.COMMON.feetPartEffectThresholds.get();
/* 1840 */         bothFeetPartEffects = (List<? extends String>)Config.COMMON.bothFeetPartEffects.get();
/* 1841 */         bothFeetPartEffectAmplifiers = (List<? extends Integer>)Config.COMMON.bothFeetPartEffectAmplifiers.get();
/* 1842 */         bothFeetPartEffectThresholds = (List<? extends Double>)Config.COMMON.bothFeetPartEffectThresholds.get();
/*      */         
/* 1844 */         morphineSyringeApplyPainkillerAddiction = ((Boolean)Config.COMMON.morphineSyringeApplyPainkillerAddiction.get()).booleanValue();
/* 1845 */       } catch (Exception e) {
/*      */         
/* 1847 */         LegendarySurvivalOverhaul.LOGGER.warn("An exception was caused trying to load the common config for Legendary Survival Overhaul");
/* 1848 */         LegendarySurvivalOverhaul.LOGGER.warn(e.getStackTrace());
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public static void bakeClient() {
/* 1854 */       LegendarySurvivalOverhaul.LOGGER.debug("Load Client configuration from file");
/*      */       
/*      */       try {
/* 1857 */         temperatureDisplayMode = (EnumUtil.temperatureDisplayMode)Config.CLIENT.temperatureDisplayMode.get();
/* 1858 */         temperatureDisplayOffsetX = ((Integer)Config.CLIENT.temperatureDisplayOffsetX.get()).intValue();
/* 1859 */         temperatureDisplayOffsetY = ((Integer)Config.CLIENT.temperatureDisplayOffsetY.get()).intValue();
/* 1860 */         bodyTemperatureDisplayOffsetX = ((Integer)Config.CLIENT.bodyTemperatureDisplayOffsetX.get()).intValue();
/* 1861 */         bodyTemperatureDisplayOffsetY = ((Integer)Config.CLIENT.bodyTemperatureDisplayOffsetY.get()).intValue();
/* 1862 */         heatTemperatureOverlay = ((Boolean)Config.CLIENT.heatTemperatureOverlay.get()).booleanValue();
/* 1863 */         coldTemperatureOverlay = ((Boolean)Config.CLIENT.coldTemperatureOverlay.get()).booleanValue();
/* 1864 */         breathingSoundEnabled = ((Boolean)Config.CLIENT.breathingSoundEnabled.get()).booleanValue();
/* 1865 */         coldBreathEffectThreshold = ((Double)Config.CLIENT.coldBreathEffectThreshold.get()).doubleValue();
/* 1866 */         renderTemperatureInFahrenheit = ((Boolean)Config.CLIENT.renderTemperatureInFahrenheit.get()).booleanValue();
/*      */         
/* 1868 */         foodSaturationDisplayed = ((Boolean)Config.CLIENT.foodSaturationDisplayed.get()).booleanValue();
/* 1869 */         showVanillaBarAnimationOverlay = ((Boolean)Config.CLIENT.showVanillaBarAnimationOverlay.get()).booleanValue();
/*      */         
/* 1871 */         seasonCardsDisplayOffsetX = ((Integer)Config.CLIENT.seasonCardsDisplayOffsetX.get()).intValue();
/* 1872 */         seasonCardsDisplayOffsetY = ((Integer)Config.CLIENT.seasonCardsDisplayOffsetY.get()).intValue();
/* 1873 */         seasonCardsSpawnDimensionDelayInTicks = ((Integer)Config.CLIENT.seasonCardsSpawnDimensionDelayInTicks.get()).intValue();
/* 1874 */         seasonCardsDisplayTimeInTicks = ((Integer)Config.CLIENT.seasonCardsDisplayTimeInTicks.get()).intValue();
/* 1875 */         seasonCardsFadeInInTicks = ((Integer)Config.CLIENT.seasonCardsFadeInInTicks.get()).intValue();
/* 1876 */         seasonCardsFadeOutInTicks = ((Integer)Config.CLIENT.seasonCardsFadeOutInTicks.get()).intValue();
/*      */         
/* 1878 */         wetnessIndicatorOffsetX = ((Integer)Config.CLIENT.wetnessIndicatorOffsetX.get()).intValue();
/* 1879 */         wetnessIndicatorOffsetY = ((Integer)Config.CLIENT.wetnessIndicatorOffsetY.get()).intValue();
/*      */         
/* 1881 */         bodyDamageIndicatorOffsetX = ((Integer)Config.CLIENT.bodyDamageIndicatorOffsetX.get()).intValue();
/* 1882 */         bodyDamageIndicatorOffsetY = ((Integer)Config.CLIENT.bodyDamageIndicatorOffsetY.get()).intValue();
/* 1883 */         bodyDamageIndicatorRenderHealthLimit = ((Double)Config.CLIENT.bodyDamageIndicatorRenderHealthLimit.get()).doubleValue();
/*      */         
/* 1885 */         hydrationSaturationDisplayed = ((Boolean)Config.CLIENT.hydrationSaturationDisplayed.get()).booleanValue();
/* 1886 */         hydrationExhaustionDisplayed = ((Boolean)Config.CLIENT.hydrationExhaustionDisplayed.get()).booleanValue();
/* 1887 */         showHydrationTooltip = ((Boolean)Config.CLIENT.showHydrationTooltip.get()).booleanValue();
/* 1888 */         mergeHydrationAndSaturationTooltip = ((Boolean)Config.CLIENT.mergeHydrationAndSaturationTooltip.get()).booleanValue();
/* 1889 */         lowHydrationEffect = ((Boolean)Config.CLIENT.lowHydrationEffect.get()).booleanValue();
/* 1890 */         showHydrationBar = ((Boolean)Config.CLIENT.showHydrationBar.get()).booleanValue();
/* 1891 */         showDrinkPreview = ((Boolean)Config.CLIENT.showDrinkPreview.get()).booleanValue();
/* 1892 */         hydrationBarOffsetX = ((Integer)Config.CLIENT.hydrationBarOffsetX.get()).intValue();
/* 1893 */         hydrationBarOffsetY = ((Integer)Config.CLIENT.hydrationBarOffsetY.get()).intValue();
/*      */         
/* 1895 */         appendBrokenShieldHeartsToHealthBar = ((Boolean)Config.CLIENT.appendBrokenShieldHeartsToHealthBar.get()).booleanValue();
/* 1896 */       } catch (Exception e) {
/*      */         
/* 1898 */         LegendarySurvivalOverhaul.LOGGER.warn("An exception was caused trying to load the client config for Legendary Survival Overhaul.");
/* 1899 */         LegendarySurvivalOverhaul.LOGGER.warn(e.getStackTrace());
/*      */       } 
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\config\Config.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */