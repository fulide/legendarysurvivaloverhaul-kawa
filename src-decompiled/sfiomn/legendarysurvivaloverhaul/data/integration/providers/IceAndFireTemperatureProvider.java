/*     */ package sfiomn.legendarysurvivaloverhaul.data.integration.providers;
/*     */ 
/*     */ import java.util.concurrent.CompletableFuture;
/*     */ import net.minecraft.core.HolderLookup;
/*     */ import net.minecraft.data.PackOutput;
/*     */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.block.ThermalTypeEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.providers.TemperatureDataProvider;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IceAndFireTemperatureProvider
/*     */   extends TemperatureDataProvider
/*     */ {
/*     */   public IceAndFireTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/*  17 */     super("iceandfire", output, lookupProvider, fileHelper);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/*  24 */     mount("hippocampus").coldResistance(4.0F);
/*  25 */     mount("ice_dragon").temperature(-7.0F);
/*  26 */     mount("fire_dragon").temperature(10.0F);
/*  27 */     mount("lightning_dragon").temperature(10.0F);
/*     */     
/*  29 */     block("chared_cobblestone").addTemperature(temperatureBlock(6.0F));
/*  30 */     block("chared_dirt").addTemperature(temperatureBlock(6.0F));
/*  31 */     block("chared_dirt_path").addTemperature(temperatureBlock(6.0F));
/*  32 */     block("chared_grass").addTemperature(temperatureBlock(6.0F));
/*  33 */     block("chared_gravel").addTemperature(temperatureBlock(6.0F));
/*  34 */     block("chared_stone").addTemperature(temperatureBlock(6.0F));
/*     */     
/*  36 */     block("dragonforge_fire_brick").addTemperature(temperatureBlock(12.0F));
/*  37 */     block("dragonforge_fire_core").addTemperature(temperatureBlock(16.0F));
/*  38 */     block("dragonforge_fire_core_disabled").addTemperature(temperatureBlock(12.0F));
/*  39 */     block("dragonforge_fire_input").addTemperature(temperatureBlock(12.0F));
/*     */     
/*  41 */     block("dragonforge_ice_brick").addTemperature(temperatureBlock(-12.0F));
/*  42 */     block("dragonforge_ice_core").addTemperature(temperatureBlock(-16.0F));
/*  43 */     block("dragonforge_ice_core_disabled").addTemperature(temperatureBlock(-12.0F));
/*  44 */     block("dragonforge_ice_input").addTemperature(temperatureBlock(-12.0F));
/*     */     
/*  46 */     block("dragonscale_blue").addTemperature(temperatureBlock(-8.0F));
/*  47 */     block("dragonscale_bronze").addTemperature(temperatureBlock(8.0F));
/*  48 */     block("dragonscale_gray").addTemperature(temperatureBlock(8.0F));
/*  49 */     block("dragonscale_green").addTemperature(temperatureBlock(8.0F));
/*  50 */     block("dragonscale_red").addTemperature(temperatureBlock(8.0F));
/*  51 */     block("dragonscale_sapphire").addTemperature(temperatureBlock(-8.0F));
/*  52 */     block("dragonscale_silver").addTemperature(temperatureBlock(-8.0F));
/*  53 */     block("dragonscale_white").addTemperature(temperatureBlock(-8.0F));
/*     */     
/*  55 */     block("frozen_cobblestone").addTemperature(temperatureBlock(-6.0F));
/*  56 */     block("frozen_dirt").addTemperature(temperatureBlock(-6.0F));
/*  57 */     block("frozen_dirt_path").addTemperature(temperatureBlock(-6.0F));
/*  58 */     block("frozen_grass").addTemperature(temperatureBlock(-6.0F));
/*  59 */     block("frozen_gravel").addTemperature(temperatureBlock(-6.0F));
/*  60 */     block("frozen_splinters").addTemperature(temperatureBlock(-6.0F));
/*  61 */     block("frozen_stone").addTemperature(temperatureBlock(-6.0F));
/*     */     
/*  63 */     block("dragon_ice").addTemperature(temperatureBlock(-6.0F));
/*  64 */     item("dragon_ice").temperature(-4.0F);
/*     */     
/*  66 */     block("dread_torch").addTemperature(temperatureBlock(-1.0F));
/*  67 */     item("dread_torch").temperature(-1.0F);
/*     */     
/*  69 */     fuelItem("dragon_ice").thermalType(ThermalTypeEnum.COOLING).duration(400);
/*  70 */     fuelItem("dread_shard").thermalType(ThermalTypeEnum.COOLING).duration(3600);
/*     */     
/*  72 */     item("armor_silver_metal_helmet").heatResistance(0.5F);
/*  73 */     item("armor_silver_metal_chestplate").heatResistance(1.5F);
/*  74 */     item("armor_silver_metal_leggings").heatResistance(1.0F);
/*  75 */     item("armor_silver_metal_boots").heatResistance(1.0F);
/*  76 */     item("armor_copper_metal_helmet").heatResistance(0.5F);
/*  77 */     item("armor_copper_metal_chestplate").heatResistance(0.5F);
/*  78 */     item("armor_copper_metal_leggings").heatResistance(0.5F);
/*  79 */     item("armor_copper_metal_boots").heatResistance(0.5F);
/*  80 */     item("sheep_helmet").coldResistance(2.0F);
/*  81 */     item("sheep_chestplate").coldResistance(3.5F);
/*  82 */     item("sheep_leggings").coldResistance(3.0F);
/*  83 */     item("sheep_boots").coldResistance(1.0F);
/*  84 */     item("deathworm_yellow_helmet").heatResistance(0.5F);
/*  85 */     item("deathworm_yellow_chestplate").heatResistance(1.5F);
/*  86 */     item("deathworm_yellow_leggings").heatResistance(1.0F);
/*  87 */     item("deathworm_yellow_boots").heatResistance(1.0F);
/*  88 */     item("deathworm_white_helmet").heatResistance(0.5F);
/*  89 */     item("deathworm_white_chestplate").heatResistance(1.5F);
/*  90 */     item("deathworm_white_leggings").heatResistance(1.0F);
/*  91 */     item("deathworm_white_boots").heatResistance(1.0F);
/*  92 */     item("deathworm_red_helmet").heatResistance(0.5F);
/*  93 */     item("deathworm_red_chestplate").heatResistance(1.5F);
/*  94 */     item("deathworm_red_leggings").heatResistance(1.0F);
/*  95 */     item("deathworm_red_boots").heatResistance(1.0F);
/*  96 */     item("dragonsteel_ice_helmet").heatResistance(3.0F);
/*  97 */     item("dragonsteel_ice_chestplate").heatResistance(5.0F);
/*  98 */     item("dragonsteel_ice_leggings").heatResistance(4.5F);
/*  99 */     item("dragonsteel_ice_boots").heatResistance(2.5F);
/* 100 */     item("dragonsteel_fire_helmet").coldResistance(3.0F);
/* 101 */     item("dragonsteel_fire_chestplate").coldResistance(5.0F);
/* 102 */     item("dragonsteel_fire_leggings").coldResistance(4.5F);
/* 103 */     item("dragonsteel_fire_boots").coldResistance(2.5F);
/* 104 */     item("dragonsteel_lightning_helmet").thermalResistance(1.5F);
/* 105 */     item("dragonsteel_lightning_chestplate").thermalResistance(2.5F);
/* 106 */     item("dragonsteel_lightning_leggings").thermalResistance(2.0F);
/* 107 */     item("dragonsteel_lightning_boots").thermalResistance(1.5F);
/* 108 */     item("armor_red_helmet").coldResistance(1.0F);
/* 109 */     item("armor_red_chestplate").coldResistance(2.0F);
/* 110 */     item("armor_red_leggings").coldResistance(1.5F);
/* 111 */     item("armor_red_boots").coldResistance(1.5F);
/* 112 */     item("armor_bronze_helmet").coldResistance(1.0F);
/* 113 */     item("armor_bronze_chestplate").coldResistance(2.0F);
/* 114 */     item("armor_bronze_leggings").coldResistance(1.5F);
/* 115 */     item("armor_bronze_boots").coldResistance(1.5F);
/* 116 */     item("armor_green_helmet").coldResistance(1.0F);
/* 117 */     item("armor_green_chestplate").coldResistance(2.0F);
/* 118 */     item("armor_green_leggings").coldResistance(1.5F);
/* 119 */     item("armor_green_boots").coldResistance(1.5F);
/* 120 */     item("armor_gray_helmet").coldResistance(1.0F);
/* 121 */     item("armor_gray_chestplate").coldResistance(2.0F);
/* 122 */     item("armor_gray_leggings").coldResistance(1.5F);
/* 123 */     item("armor_gray_boots").coldResistance(1.5F);
/* 124 */     item("armor_blue_helmet").heatResistance(1.0F);
/* 125 */     item("armor_blue_chestplate").heatResistance(2.0F);
/* 126 */     item("armor_blue_leggings").heatResistance(1.5F);
/* 127 */     item("armor_blue_boots").heatResistance(1.5F);
/* 128 */     item("armor_silver_helmet").heatResistance(1.0F);
/* 129 */     item("armor_silver_chestplate").heatResistance(2.0F);
/* 130 */     item("armor_silver_leggings").heatResistance(1.5F);
/* 131 */     item("armor_silver_boots").heatResistance(1.5F);
/* 132 */     item("armor_white_helmet").heatResistance(1.0F);
/* 133 */     item("armor_white_chestplate").heatResistance(2.0F);
/* 134 */     item("armor_white_leggings").heatResistance(1.5F);
/* 135 */     item("armor_white_boots").heatResistance(1.5F);
/* 136 */     item("armor_sapphire_helmet").heatResistance(1.0F);
/* 137 */     item("armor_sapphire_chestplate").heatResistance(2.0F);
/* 138 */     item("armor_sapphire_leggings").heatResistance(1.5F);
/* 139 */     item("armor_sapphire_boots").heatResistance(1.5F);
/* 140 */     item("armor_amythest_helmet").thermalResistance(0.5F);
/* 141 */     item("armor_amythest_chestplate").thermalResistance(1.0F);
/* 142 */     item("armor_amythest_leggings").thermalResistance(1.0F);
/* 143 */     item("armor_amythest_boots").thermalResistance(0.5F);
/* 144 */     item("armor_copper_helmet").thermalResistance(0.5F);
/* 145 */     item("armor_copper_chestplate").thermalResistance(1.0F);
/* 146 */     item("armor_copper_leggings").thermalResistance(1.0F);
/* 147 */     item("armor_copper_boots").thermalResistance(0.5F);
/* 148 */     item("armor_black_helmet").thermalResistance(0.5F);
/* 149 */     item("armor_black_chestplate").thermalResistance(1.0F);
/* 150 */     item("armor_black_leggings").thermalResistance(1.0F);
/* 151 */     item("armor_black_boots").thermalResistance(0.5F);
/* 152 */     item("armor_electric_helmet").thermalResistance(0.5F);
/* 153 */     item("armor_electric_chestplate").thermalResistance(1.0F);
/* 154 */     item("armor_electric_leggings").thermalResistance(1.0F);
/* 155 */     item("armor_electric_boots").thermalResistance(0.5F);
/* 156 */     item("tide_red_helmet").coldResistance(1.0F);
/* 157 */     item("tide_red_chestplate").coldResistance(2.0F);
/* 158 */     item("tide_red_leggings").coldResistance(1.5F);
/* 159 */     item("tide_red_boots").coldResistance(1.5F);
/* 160 */     item("tide_blue_helmet").coldResistance(1.0F);
/* 161 */     item("tide_blue_chestplate").coldResistance(2.0F);
/* 162 */     item("tide_blue_leggings").coldResistance(1.5F);
/* 163 */     item("tide_blue_boots").coldResistance(1.5F);
/* 164 */     item("tide_bronze_helmet").coldResistance(1.0F);
/* 165 */     item("tide_bronze_chestplate").coldResistance(2.0F);
/* 166 */     item("tide_bronze_leggings").coldResistance(1.5F);
/* 167 */     item("tide_bronze_boots").coldResistance(1.5F);
/* 168 */     item("tide_green_helmet").coldResistance(1.0F);
/* 169 */     item("tide_green_chestplate").coldResistance(2.0F);
/* 170 */     item("tide_green_leggings").coldResistance(1.5F);
/* 171 */     item("tide_green_boots").coldResistance(1.5F);
/* 172 */     item("tide_deepblue_helmet").coldResistance(1.0F);
/* 173 */     item("tide_deepblue_chestplate").coldResistance(2.0F);
/* 174 */     item("tide_deepblue_leggings").coldResistance(1.5F);
/* 175 */     item("tide_deepblue_boots").coldResistance(1.5F);
/* 176 */     item("tide_purple_helmet").coldResistance(1.0F);
/* 177 */     item("tide_purple_chestplate").coldResistance(2.0F);
/* 178 */     item("tide_purple_leggings").coldResistance(1.5F);
/* 179 */     item("tide_purple_boots").coldResistance(1.5F);
/* 180 */     item("tide_teal_helmet").coldResistance(1.0F);
/* 181 */     item("tide_teal_chestplate").coldResistance(2.0F);
/* 182 */     item("tide_teal_leggings").coldResistance(1.5F);
/* 183 */     item("tide_teal_boots").coldResistance(1.5F);
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\IceAndFireTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */