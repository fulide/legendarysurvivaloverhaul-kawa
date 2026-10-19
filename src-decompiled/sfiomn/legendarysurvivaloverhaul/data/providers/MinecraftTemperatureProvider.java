/*     */ package sfiomn.legendarysurvivaloverhaul.data.providers;
/*     */ 
/*     */ import java.util.concurrent.CompletableFuture;
/*     */ import net.minecraft.core.HolderLookup;
/*     */ import net.minecraft.data.PackOutput;
/*     */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.block.ThermalTypeEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.providers.TemperatureDataProvider;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemporaryModifierGroupEnum;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MinecraftTemperatureProvider
/*     */   extends TemperatureDataProvider
/*     */ {
/*     */   public MinecraftTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/*  17 */     super("minecraft", output, lookupProvider, fileHelper);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/*  23 */     dimension("overworld").temperature(20.0F).hasAltitude().seaLevelHeight(64);
/*  24 */     dimension("the_end").temperature(-13.0F);
/*  25 */     dimension("the_nether").temperature(27.0F);
/*     */     
/*  27 */     block("campfire")
/*  28 */       .addTemperature(temperatureBlock(10.0F).addProperty("lit", "true"))
/*  29 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/*  30 */     block("soul_campfire")
/*  31 */       .addTemperature(temperatureBlock(-10.0F).addProperty("lit", "true"))
/*  32 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/*  33 */     block("furnace")
/*  34 */       .addTemperature(temperatureBlock(6.0F).addProperty("lit", "true"))
/*  35 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/*  36 */     block("blast_furnace")
/*  37 */       .addTemperature(temperatureBlock(6.0F).addProperty("lit", "true"))
/*  38 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/*  39 */     block("smoker")
/*  40 */       .addTemperature(temperatureBlock(6.0F).addProperty("lit", "true"))
/*  41 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/*     */     
/*  43 */     block("torch").addTemperature(temperatureBlock(1.5F));
/*  44 */     block("wall_torch").addTemperature(temperatureBlock(1.5F));
/*  45 */     block("soul_torch").addTemperature(temperatureBlock(-1.5F));
/*  46 */     block("soul_wall_torch").addTemperature(temperatureBlock(-1.5F));
/*  47 */     block("fire").addTemperature(temperatureBlock(7.0F));
/*  48 */     block("soul_fire").addTemperature(temperatureBlock(-7.0F));
/*     */     
/*  50 */     block("magma_block").addTemperature(temperatureBlock(12.0F));
/*  51 */     block("jack_o_lantern").addTemperature(temperatureBlock(3.0F));
/*  52 */     block("lava").addTemperature(temperatureBlock(12.5F));
/*  53 */     block("flowing_lava").addTemperature(temperatureBlock(12.5F));
/*     */     
/*  55 */     item("lava_bucket").temperature(6.0F);
/*  56 */     item("magma_block").temperature(6.0F);
/*  57 */     item("torch").temperature(1.0F);
/*  58 */     item("soul_torch").temperature(-1.0F);
/*  59 */     item("ice").temperature(-1.0F);
/*  60 */     item("packed_ice").temperature(-2.0F);
/*  61 */     item("blue_ice").temperature(-3.0F);
/*     */     
/*  63 */     item("leather_boots").coldResistance(0.5F);
/*  64 */     item("leather_leggings").coldResistance(1.0F);
/*  65 */     item("leather_chestplate").coldResistance(1.5F);
/*  66 */     item("leather_helmet").coldResistance(1.0F);
/*     */     
/*  68 */     item("golden_boots").coldResistance(0.5F);
/*  69 */     item("golden_leggings").coldResistance(1.0F);
/*  70 */     item("golden_chestplate").coldResistance(1.0F);
/*  71 */     item("golden_helmet").coldResistance(0.5F);
/*     */     
/*  73 */     item("iron_boots").heatResistance(0.5F);
/*  74 */     item("iron_leggings").heatResistance(1.0F);
/*  75 */     item("iron_chestplate").heatResistance(1.0F);
/*  76 */     item("iron_helmet").heatResistance(0.5F);
/*     */     
/*  78 */     item("diamond_boots").heatResistance(1.0F);
/*  79 */     item("diamond_leggings").heatResistance(1.0F);
/*  80 */     item("diamond_chestplate").heatResistance(1.5F);
/*  81 */     item("diamond_helmet").heatResistance(0.5F);
/*     */     
/*  83 */     item("netherite_boots").coldResistance(1.5F);
/*  84 */     item("netherite_leggings").coldResistance(1.5F);
/*  85 */     item("netherite_chestplate").coldResistance(2.0F);
/*  86 */     item("netherite_helmet").coldResistance(1.0F);
/*     */     
/*  88 */     mount("strider").heatResistance(7.0F);
/*     */     
/*  90 */     consumable("mushroom_stew")
/*  91 */       .addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(1).duration(1200));
/*  92 */     consumable("mushroom_stew")
/*  93 */       .addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(1).duration(1200));
/*  94 */     consumable("rabbit_stew")
/*  95 */       .addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(2).duration(1200));
/*  96 */     consumable("suspicious_stew")
/*  97 */       .addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(1).duration(1200));
/*  98 */     consumable("melon_slice")
/*  99 */       .addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-1).duration(1200));
/*     */     
/* 101 */     biome("crimson_forest").temperature(0.75F).isDry(false);
/* 102 */     biome("warped_forest").temperature(0.75F).isDry(false);
/* 103 */     biome("nether_wastes").temperature(1.0F).isDry(false);
/* 104 */     biome("soul_sand_valley").temperature(1.0F).isDry(false);
/* 105 */     biome("basalt_deltas").temperature(1.45F).isDry(false);
/* 106 */     biome("frozen_ocean").temperature(-0.5F).isDry(false);
/* 107 */     biome("deep_frozen_ocean").temperature(-0.5F).isDry(false);
/*     */     
/* 109 */     fuelItem("coal").thermalType(ThermalTypeEnum.HEATING).duration(600);
/* 110 */     fuelItem("charcoal").thermalType(ThermalTypeEnum.HEATING).duration(600);
/* 111 */     fuelItem("coal_block").thermalType(ThermalTypeEnum.HEATING).duration(2700);
/* 112 */     fuelItem("ice").thermalType(ThermalTypeEnum.COOLING).duration(400);
/* 113 */     fuelItem("snowball").thermalType(ThermalTypeEnum.COOLING).duration(400);
/* 114 */     fuelItem("snow_block").thermalType(ThermalTypeEnum.COOLING).duration(600);
/* 115 */     fuelItem("blue_ice").thermalType(ThermalTypeEnum.COOLING).duration(16200);
/* 116 */     fuelItem("packed_ice").thermalType(ThermalTypeEnum.COOLING).duration(1800);
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\providers\MinecraftTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */