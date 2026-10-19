/*     */ package sfiomn.legendarysurvivaloverhaul.common.integration;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import net.neoforged.fml.ModList;
/*     */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.block.ThermalTypeEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.BodyPartEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.DamageDistributionEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.JsonPropertyValue;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemporaryModifierGroupEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.json_old.JsonConfig;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class IntegrationController
/*     */ {
/*     */   public static void initIntegration() {
/*  25 */     ModList mods = ModList.get();
/*     */     
/*  27 */     if (mods.isLoaded("create"))
/*  28 */       initCreate(); 
/*  29 */     if (mods.isLoaded("farmersdelight"))
/*  30 */       initFarmersDelight(); 
/*  31 */     if (mods.isLoaded("realistictorches"))
/*  32 */       initRealisticTorches(); 
/*  33 */     if (mods.isLoaded("byg"))
/*  34 */       initBYG(); 
/*  35 */     if (mods.isLoaded("artifacts"))
/*  36 */       initArtifacts(); 
/*  37 */     if (mods.isLoaded("endergetic"))
/*  38 */       initEndergeticExpansion(); 
/*  39 */     if (mods.isLoaded("infernalexp"))
/*  40 */       initInfernalExpansion(); 
/*  41 */     if (mods.isLoaded("biomesoplenty"))
/*  42 */       initBiomesOPlenty(); 
/*  43 */     if (mods.isLoaded("betterendforge"))
/*  44 */       initBetterEndForge(); 
/*  45 */     if (mods.isLoaded("betterend"))
/*  46 */       initBetterEnd(); 
/*  47 */     if (mods.isLoaded("atmospheric"))
/*  48 */       initAtmospheric(); 
/*  49 */     if (mods.isLoaded("legendarycreatures")) {
/*  50 */       initLegendaryCreatures();
/*     */     }
/*  52 */     if (mods.isLoaded("neapolitan")) {
/*     */       
/*  54 */       initNeapolitan();
/*     */ 
/*     */ 
/*     */       
/*  58 */       if (mods.isLoaded("seasonals"))
/*  59 */         initSeasonals(); 
/*  60 */       if (mods.isLoaded("peculiars")) {
/*  61 */         initPeculiars();
/*     */       }
/*     */     } 
/*  64 */     if (mods.isLoaded("supplementaries"))
/*  65 */       initSupplementaries(); 
/*  66 */     if (mods.isLoaded("crockpot"))
/*  67 */       initCrockpot(); 
/*  68 */     if (mods.isLoaded("quark"))
/*  69 */       initQuark(); 
/*  70 */     if (mods.isLoaded("beachparty"))
/*  71 */       initBeachParty(); 
/*  72 */     if (mods.isLoaded("create_confectionery"))
/*  73 */       initCreateConfectionery(); 
/*  74 */     if (mods.isLoaded("wardrobe"))
/*  75 */       initWardrobe(); 
/*  76 */     if (mods.isLoaded("iceandfire"))
/*  77 */       initIceAndFire(); 
/*  78 */     if (mods.isLoaded("alexsmobs"))
/*  79 */       initAlexsMobs(); 
/*  80 */     if (mods.isLoaded("aquamirae"))
/*  81 */       initAquamirae(); 
/*  82 */     if (mods.isLoaded("call_of_yucutan"))
/*  83 */       initCallOfYucutan(); 
/*  84 */     if (mods.isLoaded("cataclysm"))
/*  85 */       initCataclysm(); 
/*  86 */     if (mods.isLoaded("endermanoverhaul"))
/*  87 */       initEndermanOverhaul(); 
/*  88 */     if (mods.isLoaded("irons_spellbooks"))
/*  89 */       initIronsSpellbooks(); 
/*  90 */     if (mods.isLoaded("born_in_chaos_v1"))
/*  91 */       initBornInChaos(); 
/*  92 */     if (mods.isLoaded("upgrade_aquatic"))
/*  93 */       initUpgradeAquatic(); 
/*  94 */     if (LegendarySurvivalOverhaul.terraFirmaCraftLoaded)
/*  95 */       initTerraFirmaCraft(); 
/*  96 */     if (mods.isLoaded("legendary_additions"))
/*  97 */       initLegendaryAdditions(); 
/*  98 */     if (mods.isLoaded("hardcore_torches")) {
/*  99 */       initHardcoreTorches();
/*     */     }
/*     */   }
/*     */   
/*     */   private static void initCreate() {
/* 104 */     JsonConfig.registerDefaultBlockFluidTemperature("create:blaze_burner", 2.5F, new JsonPropertyValue[] { new JsonPropertyValue("blaze", "smouldering") });
/* 105 */     JsonConfig.registerDefaultBlockFluidTemperature("create:blaze_burner", 5.0F, new JsonPropertyValue[] { new JsonPropertyValue("blaze", "kindled") });
/* 106 */     JsonConfig.registerDefaultBlockFluidTemperature("create:blaze_burner", 7.5F, new JsonPropertyValue[] { new JsonPropertyValue("blaze", "seething") });
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initFarmersDelight() {
/* 111 */     JsonConfig.registerDefaultBlockFluidTemperature("farmersdelight:stove", 7.5F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "true") });
/* 112 */     JsonConfig.registerDefaultBlockFluidTemperature("farmersdelight:stove", 0.0F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "false") });
/*     */     
/* 114 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "farmersdelight:beef_stew", 2, 2400);
/* 115 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "farmersdelight:chicken_soup", 2, 2400);
/* 116 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "farmersdelight:vegetable_soup", 2, 2400);
/* 117 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "farmersdelight:fish_stew", 2, 2400);
/* 118 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "farmersdelight:pumpkin_soup", 2, 2400);
/* 119 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "farmersdelight:baked_cod_stew", 2, 2400);
/* 120 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "farmersdelight:hot_cocoa", 3, 3600);
/* 121 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "farmersdelight:melon_juice", -1, 1200);
/*     */     
/* 123 */     JsonConfig.registerDefaultConsumableThirst("farmersdelight:chicken_soup", 4, 2.0F);
/* 124 */     JsonConfig.registerDefaultConsumableThirst("farmersdelight:vegetable_soup", 4, 2.0F);
/* 125 */     JsonConfig.registerDefaultConsumableThirst("farmersdelight:pumpkin_soup", 4, 2.0F);
/* 126 */     JsonConfig.registerDefaultConsumableThirst("farmersdelight:hot_cocoa", 4, 1.0F);
/* 127 */     JsonConfig.registerDefaultConsumableThirst("farmersdelight:melon_juice", 8, 4.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initRealisticTorches() {
/* 132 */     JsonConfig.registerDefaultBlockFluidTemperature("realistictorches:torch", 1.5F, new JsonPropertyValue[] { new JsonPropertyValue("litstate", "2") });
/* 133 */     JsonConfig.registerDefaultBlockFluidTemperature("realistictorches:torch", 0.75F, new JsonPropertyValue[] { new JsonPropertyValue("litstate", "1") });
/* 134 */     JsonConfig.registerDefaultBlockFluidTemperature("realistictorches:torch", 0.0F, new JsonPropertyValue[] { new JsonPropertyValue("litstate", "0") });
/*     */     
/* 136 */     JsonConfig.registerDefaultBlockFluidTemperature("realistictorches:torch_wall", 1.5F, new JsonPropertyValue[] { new JsonPropertyValue("litstate", "2") });
/* 137 */     JsonConfig.registerDefaultBlockFluidTemperature("realistictorches:torch_wall", 0.75F, new JsonPropertyValue[] { new JsonPropertyValue("litstate", "1") });
/* 138 */     JsonConfig.registerDefaultBlockFluidTemperature("realistictorches:torch_wall", 0.0F, new JsonPropertyValue[] { new JsonPropertyValue("litstate", "0") });
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initBYG() {
/* 143 */     JsonConfig.registerDefaultBlockFluidTemperature("byg:boric_fire", 5.0F, new JsonPropertyValue[0]);
/* 144 */     JsonConfig.registerDefaultBlockFluidTemperature("byg:boric_campfire", 10.0F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "true") });
/* 145 */     JsonConfig.registerDefaultBlockFluidTemperature("byg:boric_campfire", 0.0F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "false") });
/*     */     
/* 147 */     JsonConfig.registerDefaultBlockFluidTemperature("byg:cryptic_fire", 5.0F, new JsonPropertyValue[0]);
/* 148 */     JsonConfig.registerDefaultBlockFluidTemperature("byg:cryptic_campfire", 7.5F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "true") });
/* 149 */     JsonConfig.registerDefaultBlockFluidTemperature("byg:cryptic_campfire", 0.0F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "false") });
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initArtifacts() {
/* 154 */     JsonConfig.registerDefaultItemTemperature("artifacts:villager_hat", 0.0F, 2.5F, 0.0F, 0.0F);
/* 155 */     JsonConfig.registerDefaultItemTemperature("artifacts:lucky_scarf", 0.0F, 0.0F, 2.5F, 0.0F);
/* 156 */     JsonConfig.registerDefaultItemTemperature("artifacts:scarf_of_invisibility", 0.0F, 0.0F, 2.5F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initEndergeticExpansion() {
/* 161 */     JsonConfig.registerDefaultBlockFluidTemperature("endergetic:ender_fire", -7.0F, new JsonPropertyValue[0]);
/* 162 */     JsonConfig.registerDefaultBlockFluidTemperature("endergetic:ender_campfire", -10.0F, new JsonPropertyValue[0]);
/* 163 */     JsonConfig.registerDefaultBlockFluidTemperature("endergetic:ender_torch", -1.5F, new JsonPropertyValue[0]);
/* 164 */     JsonConfig.registerDefaultBlockFluidTemperature("endergetic:ender_wall_torch", -1.5F, new JsonPropertyValue[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initInfernalExpansion() {
/* 169 */     JsonConfig.registerDefaultBlockFluidTemperature("infernalexp:fire_glow", 7.0F, new JsonPropertyValue[0]);
/* 170 */     JsonConfig.registerDefaultBlockFluidTemperature("infernalexp:campfire_glow", 10.0F, new JsonPropertyValue[0]);
/* 171 */     JsonConfig.registerDefaultBlockFluidTemperature("infernalexp:torch_glow", 1.5F, new JsonPropertyValue[0]);
/* 172 */     JsonConfig.registerDefaultBlockFluidTemperature("infernalexp:torch_glow_wall", 1.5F, new JsonPropertyValue[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initBiomesOPlenty() {
/* 177 */     JsonConfig.registerDefaultBiomeOverride("biomesoplenty:crystalline_chasm", 0.8F, false);
/* 178 */     JsonConfig.registerDefaultBiomeOverride("biomesoplenty:undergrowth", 0.75F, false);
/* 179 */     JsonConfig.registerDefaultBiomeOverride("biomesoplenty:visceral_heap", 0.9F, false);
/* 180 */     JsonConfig.registerDefaultBiomeOverride("biomesoplenty:withered_abyss", 1.5F, false);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initNeapolitan() {
/* 185 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "neapolitan:ice_cubes", -1, 3600);
/*     */     
/* 187 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "neapolitan:chocolate_ice_cream", -3, 3600);
/* 188 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "neapolitan:vanilla_ice_cream", -3, 3600);
/* 189 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "neapolitan:strawberry_ice_cream", -3, 3600);
/* 190 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "neapolitan:banana_ice_cream", -3, 3600);
/*     */     
/* 192 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "neapolitan:neapolitan_ice_cream", -3, 3600);
/*     */     
/* 194 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "neapolitan:chocolate_milkshake", -3, 3600);
/* 195 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "neapolitan:vanilla_milkshake", -3, 3600);
/* 196 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "neapolitan:strawberry_milkshake", -3, 3600);
/* 197 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "neapolitan:banana_milkshake", -3, 3600);
/*     */     
/* 199 */     JsonConfig.registerDefaultConsumableThirst("neapolitan:chocolate_milkshake", 4, 1.0F);
/* 200 */     JsonConfig.registerDefaultConsumableThirst("neapolitan:vanilla_milkshake", 4, 1.0F);
/* 201 */     JsonConfig.registerDefaultConsumableThirst("neapolitan:strawberry_milkshake", 4, 1.0F);
/* 202 */     JsonConfig.registerDefaultConsumableThirst("neapolitan:banana_milkshake", 4, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initSeasonals() {
/* 207 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "seasonals:pumpkin_ice_cream", -3, 3600);
/* 208 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "seasonals:sweet_berry_ice_cream", -3, 3600);
/*     */     
/* 210 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "seasonals:pumpkin_milkshake", -3, 3600);
/* 211 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "seasonals:sweet_berry_milkshake", -3, 3600);
/* 212 */     JsonConfig.registerDefaultConsumableThirst("seasonals:pumpkin_milkshake", 4, 1.0F);
/* 213 */     JsonConfig.registerDefaultConsumableThirst("seasonals:sweet_berry_milkshake", 4, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initPeculiars() {
/* 218 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "peculiars:yucca_ice_cream", -3, 3600);
/* 219 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "peculiars:aloe_ice_cream", -3, 3600);
/* 220 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "peculiars:passionfruit_ice_cream", -3, 3600);
/*     */     
/* 222 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "peculiars:yucca_milkshake", -3, 3600);
/* 223 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "peculiars:aloe_milkshake", -3, 3600);
/* 224 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "peculiars:passionfruit_milkshake", -3, 3600);
/* 225 */     JsonConfig.registerDefaultConsumableThirst("peculiars:yucca_milkshake", 6, 2.0F);
/* 226 */     JsonConfig.registerDefaultConsumableThirst("peculiars:aloe_milkshake", 6, 2.0F);
/* 227 */     JsonConfig.registerDefaultConsumableThirst("peculiars:passionfruit_milkshake", 6, 2.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initBetterEnd() {
/* 232 */     JsonConfig.registerDefaultFuelItems("betterend:charcoal_block", ThermalTypeEnum.HEATING, 270);
/*     */     
/* 234 */     JsonConfig.registerDefaultItemTemperature("betterend:aeternium_helmet", 0.0F, 2.0F, 0.0F, 0.0F);
/* 235 */     JsonConfig.registerDefaultItemTemperature("betterend:aeternium_chestplate", 0.0F, 3.0F, 0.0F, 0.0F);
/* 236 */     JsonConfig.registerDefaultItemTemperature("betterend:aeternium_leggings", 0.0F, 2.5F, 0.0F, 0.0F);
/* 237 */     JsonConfig.registerDefaultItemTemperature("betterend:aeternium_boots", 0.0F, 2.0F, 0.0F, 0.0F);
/* 238 */     JsonConfig.registerDefaultItemTemperature("betterend:crystalite_helmet", 0.0F, 1.5F, 0.0F, 0.0F);
/* 239 */     JsonConfig.registerDefaultItemTemperature("betterend:crystalite_chestplate", 0.0F, 2.0F, 0.0F, 0.0F);
/* 240 */     JsonConfig.registerDefaultItemTemperature("betterend:crystalite_leggings", 0.0F, 2.0F, 0.0F, 0.0F);
/* 241 */     JsonConfig.registerDefaultItemTemperature("betterend:crystalite_boots", 0.0F, 1.0F, 0.0F, 0.0F);
/* 242 */     JsonConfig.registerDefaultItemTemperature("betterend:terminite_helmet", 0.0F, 1.0F, 0.0F, 0.0F);
/* 243 */     JsonConfig.registerDefaultItemTemperature("betterend:terminite_chestplate", 0.0F, 1.5F, 0.0F, 0.0F);
/* 244 */     JsonConfig.registerDefaultItemTemperature("betterend:terminite_leggings", 0.0F, 1.0F, 0.0F, 0.0F);
/* 245 */     JsonConfig.registerDefaultItemTemperature("betterend:terminite_boots", 0.0F, 1.0F, 0.0F, 0.0F);
/* 246 */     JsonConfig.registerDefaultItemTemperature("betterend:thallasium_helmet", 0.0F, 0.5F, 0.0F, 0.0F);
/* 247 */     JsonConfig.registerDefaultItemTemperature("betterend:thallasium_chestplate", 0.0F, 1.0F, 0.0F, 0.0F);
/* 248 */     JsonConfig.registerDefaultItemTemperature("betterend:thallasium_leggings", 0.0F, 0.5F, 0.0F, 0.0F);
/* 249 */     JsonConfig.registerDefaultItemTemperature("betterend:thallasium_boots", 0.0F, 0.5F, 0.0F, 0.0F);
/* 250 */     JsonConfig.registerDefaultItemTemperature("betternether:cincinnasite_helmet", 0.0F, 1.0F, 0.0F, 0.0F);
/* 251 */     JsonConfig.registerDefaultItemTemperature("betternether:cincinnasite_chestplate", 0.0F, 2.0F, 0.0F, 0.0F);
/* 252 */     JsonConfig.registerDefaultItemTemperature("betternether:cincinnasite_leggings", 0.0F, 2.0F, 0.0F, 0.0F);
/* 253 */     JsonConfig.registerDefaultItemTemperature("betternether:cincinnasite_boots", 0.0F, 1.0F, 0.0F, 0.0F);
/* 254 */     JsonConfig.registerDefaultItemTemperature("betternether:nether_ruby_helmet", 0.0F, 0.0F, 1.0F, 0.0F);
/* 255 */     JsonConfig.registerDefaultItemTemperature("betternether:nether_ruby_chestplate", 0.0F, 0.0F, 2.0F, 0.0F);
/* 256 */     JsonConfig.registerDefaultItemTemperature("betternether:nether_ruby_leggings", 0.0F, 0.0F, 2.0F, 0.0F);
/* 257 */     JsonConfig.registerDefaultItemTemperature("betternether:nether_ruby_boots", 0.0F, 0.0F, 1.0F, 0.0F);
/* 258 */     JsonConfig.registerDefaultItemTemperature("betternether:flaming_ruby_helmet", 0.0F, 0.0F, 1.5F, 0.0F);
/* 259 */     JsonConfig.registerDefaultItemTemperature("betternether:flaming_ruby_chestplate", 0.0F, 0.0F, 2.5F, 0.0F);
/* 260 */     JsonConfig.registerDefaultItemTemperature("betternether:flaming_ruby_leggings", 0.0F, 0.0F, 2.5F, 0.0F);
/* 261 */     JsonConfig.registerDefaultItemTemperature("betternether:flaming_ruby_boots", 0.0F, 0.0F, 1.5F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initBetterEndForge() {
/* 266 */     JsonConfig.registerDefaultBiomeOverride("betterendforge:sulphur_springs", 1.1F);
/* 267 */     JsonConfig.registerDefaultBiomeOverride("betterendforge:ice_starfield", 0.1F);
/*     */     
/* 269 */     JsonConfig.registerDefaultFuelItems("betterendforge:coal_block", ThermalTypeEnum.HEATING, 270);
/* 270 */     JsonConfig.registerDefaultFuelItems("betterendforge:charcoal_block", ThermalTypeEnum.HEATING, 270);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initAtmospheric() {
/* 275 */     JsonConfig.registerDefaultDamageSourceBodyParts("atmospheric.yuccaSapling", DamageDistributionEnum.ONE_OF, Arrays.asList(new BodyPartEnum[] { BodyPartEnum.LEFT_FOOT, BodyPartEnum.RIGHT_FOOT, BodyPartEnum.LEFT_LEG, BodyPartEnum.RIGHT_LEG }));
/* 276 */     JsonConfig.registerDefaultDamageSourceBodyParts("atmospheric.yuccaFlower", DamageDistributionEnum.ONE_OF, Arrays.asList(new BodyPartEnum[] { BodyPartEnum.LEFT_FOOT, BodyPartEnum.RIGHT_FOOT, BodyPartEnum.LEFT_LEG, BodyPartEnum.RIGHT_LEG }));
/* 277 */     JsonConfig.registerDefaultDamageSourceBodyParts("atmospheric.yuccaBranch", DamageDistributionEnum.ONE_OF, Arrays.asList(new BodyPartEnum[] { BodyPartEnum.LEFT_FOOT, BodyPartEnum.RIGHT_FOOT, BodyPartEnum.LEFT_LEG, BodyPartEnum.RIGHT_LEG }));
/* 278 */     JsonConfig.registerDefaultDamageSourceBodyParts("atmospheric.yuccaLeaves", DamageDistributionEnum.ONE_OF, Arrays.asList(new BodyPartEnum[] { BodyPartEnum.LEFT_FOOT, BodyPartEnum.RIGHT_FOOT, BodyPartEnum.LEFT_LEG, BodyPartEnum.RIGHT_LEG }));
/* 279 */     JsonConfig.registerDefaultDamageSourceBodyParts("atmospheric.barrelCactus", DamageDistributionEnum.ONE_OF, Arrays.asList(new BodyPartEnum[] { BodyPartEnum.LEFT_FOOT, BodyPartEnum.RIGHT_FOOT, BodyPartEnum.LEFT_LEG, BodyPartEnum.RIGHT_LEG }));
/* 280 */     JsonConfig.registerDefaultDamageSourceBodyParts("atmospheric.aloeLeaves", DamageDistributionEnum.ONE_OF, Arrays.asList(new BodyPartEnum[] { BodyPartEnum.LEFT_FOOT, BodyPartEnum.RIGHT_FOOT, BodyPartEnum.LEFT_LEG, BodyPartEnum.RIGHT_LEG }));
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initLegendaryCreatures() {
/* 285 */     JsonConfig.registerDefaultDamageSourceBodyParts("legendarycreatures.root_attack", DamageDistributionEnum.ONE_OF, Arrays.asList(new BodyPartEnum[] { BodyPartEnum.LEFT_FOOT, BodyPartEnum.RIGHT_FOOT, BodyPartEnum.LEFT_LEG, BodyPartEnum.RIGHT_LEG }));
/*     */     
/* 287 */     JsonConfig.registerDefaultItemTemperature("legendarycreatures:straw_hat", 0.0F, 3.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initSupplementaries() {
/* 292 */     JsonConfig.registerDefaultDamageSourceBodyParts("supplementaries.bamboo_spikes", DamageDistributionEnum.ALL, Arrays.asList(new BodyPartEnum[] { BodyPartEnum.LEFT_FOOT, BodyPartEnum.RIGHT_FOOT }));
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initCrockpot() {
/* 297 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "crockpot:asparagus_soup", 2, 1200);
/* 298 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "crockpot:iced_tea", -2, 4800);
/* 299 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "crockpot:ice_cream", -3, 1200);
/* 300 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "crockpot:tea", 3, 4800);
/* 301 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "crockpot:bacon_eggs", 1, 1200);
/* 302 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "crockpot:bone_stew", 3, 2400);
/* 303 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "crockpot:bunny_stew", 1, 1200);
/* 304 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "crockpot:bone_soup", 2, 1800);
/* 305 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "crockpot:california_roll", -1, 1200);
/* 306 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "crockpot:flower_salad", -3, 6000);
/* 307 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "crockpot:fruit_medley", -1, 1200);
/* 308 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "crockpot:gazpacho", -2, 2400);
/* 309 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "crockpot:hot_chili", 2, 2400);
/* 310 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "crockpot:hot_cocoa", 3, 2400);
/* 311 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "crockpot:kabobs", 1, 2400);
/* 312 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "crockpot:meat_balls", 1, 1200);
/* 313 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "crockpot:moqueca", 1, 1800);
/* 314 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "crockpot:plain_omelette", 1, 1200);
/* 315 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "crockpot:pepper_popper", 3, 6000);
/* 316 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "crockpot:pierogi", 2, 1200);
/* 317 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "crockpot:ratatouille", 3, 6000);
/* 318 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "crockpot:salmon_sushi", -1, 1800);
/* 319 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "crockpot:salsa", -2, 2400);
/* 320 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "crockpot:turkey_dinner", 2, 2400);
/* 321 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "crockpot:veg_stinger", -1, 1200);
/* 322 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "crockpot:watermelon_icle", -4, 1800);
/*     */     
/* 324 */     JsonConfig.registerDefaultConsumableThirst("crockpot:asparagus_soup", 4, 2.0F);
/* 325 */     JsonConfig.registerDefaultConsumableThirst("crockpot:bone_soup", 4, 2.0F);
/* 326 */     JsonConfig.registerDefaultConsumableThirst("crockpot:iced_tea", 8, 5.0F);
/* 327 */     JsonConfig.registerDefaultConsumableThirst("crockpot:tea", 5, 2.0F);
/* 328 */     JsonConfig.registerDefaultConsumableThirst("crockpot:gazpacho", 4, 2.0F);
/* 329 */     JsonConfig.registerDefaultConsumableThirst("crockpot:hot_cocoa", 2, 1.0F);
/* 330 */     JsonConfig.registerDefaultConsumableThirst("crockpot:fruit_medley", 3, 1.0F);
/* 331 */     JsonConfig.registerDefaultConsumableThirst("crockpot:veg_stinger", 5, 2.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initQuark() {
/* 336 */     JsonConfig.registerDefaultFuelItems("quark:coal_block", ThermalTypeEnum.HEATING, 270);
/* 337 */     JsonConfig.registerDefaultFuelItems("quark:charcoal_block", ThermalTypeEnum.HEATING, 270);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initBeachParty() {
/* 342 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "beachparty:sweetberry_icecream", -2, 3600);
/* 343 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "beachparty:coconut_icecream", -2, 3600);
/* 344 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "beachparty:chocolate_icecream", -3, 3600);
/* 345 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "beachparty:icecream_coconut", -2, 3600);
/* 346 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "beachparty:icecream_cactus", -2, 3600);
/* 347 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "beachparty:icecream_chocolate", -2, 3600);
/* 348 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "beachparty:icecream_sweetberries", -2, 3600);
/* 349 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.FOOD, "beachparty:icecream_melon", -2, 3600);
/*     */     
/* 351 */     JsonConfig.registerDefaultConsumableThirst("beachparty:coconut_open", 3, 0.0F);
/*     */     
/* 353 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "beachparty:coconut_cocktail", -1, 2400);
/* 354 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "beachparty:sweetberries_cocktail", -1, 2400);
/* 355 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "beachparty:cocoa_cocktail", -2, 2400);
/* 356 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "beachparty:pumpkin_cocktail", -1, 2400);
/* 357 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "beachparty:melon_cocktail", -1, 2400);
/* 358 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "beachparty:honey_cocktail", -1, 2400);
/* 359 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "beachparty:refreshing_drink", -1, 2400);
/* 360 */     JsonConfig.registerDefaultConsumableThirst("beachparty:coconut_cocktail", 4, 2.0F);
/* 361 */     JsonConfig.registerDefaultConsumableThirst("beachparty:sweetberries_cocktail", 4, 2.0F);
/* 362 */     JsonConfig.registerDefaultConsumableThirst("beachparty:cocoa_cocktail", 5, 2.0F);
/* 363 */     JsonConfig.registerDefaultConsumableThirst("beachparty:pumpkin_cocktail", 5, 2.0F);
/* 364 */     JsonConfig.registerDefaultConsumableThirst("beachparty:melon_cocktail", 5, 2.0F);
/* 365 */     JsonConfig.registerDefaultConsumableThirst("beachparty:honey_cocktail", 7, 3.0F);
/* 366 */     JsonConfig.registerDefaultConsumableThirst("beachparty:refreshing_drink", 10, 5.0F);
/*     */     
/* 368 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "beachparty:sweetberry_milkshake", -3, 4800);
/* 369 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "beachparty:coconut_milkshake", -3, 4800);
/* 370 */     JsonConfig.registerDefaultConsumableTemperature(TemporaryModifierGroupEnum.DRINK, "beachparty:chocolate_milkshake", -3, 4800);
/* 371 */     JsonConfig.registerDefaultConsumableThirst("beachparty:sweetberry_milkshake", 4, 2.0F);
/* 372 */     JsonConfig.registerDefaultConsumableThirst("beachparty:coconut_milkshake", 5, 3.0F);
/* 373 */     JsonConfig.registerDefaultConsumableThirst("beachparty:chocolate_milkshake", 7, 4.0F);
/*     */     
/* 375 */     JsonConfig.registerDefaultItemTemperature("beachparty:beach_hat", 0.0F, 2.5F, 0.0F, 0.0F);
/* 376 */     JsonConfig.registerDefaultItemTemperature("beachparty:trunks", 0.0F, 3.0F, 0.0F, 0.0F);
/* 377 */     JsonConfig.registerDefaultItemTemperature("beachparty:bikine", 0.0F, 3.0F, 0.0F, 0.0F);
/* 378 */     JsonConfig.registerDefaultItemTemperature("beachparty:crocs", 0.0F, 0.5F, 0.0F, 0.0F);
/* 379 */     JsonConfig.registerDefaultItemTemperature("beachparty:palm_torch_item", 1.0F, 0.0F, 0.0F, 0.0F);
/* 380 */     JsonConfig.registerDefaultItemTemperature("beachparty:palm_tall_torch", 1.0F, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initCreateConfectionery() {
/* 385 */     JsonConfig.registerDefaultConsumableThirst("create_confectionery:hot_chocolate_bottle", 3, 2.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initWardrobe() {
/* 390 */     JsonConfig.registerDefaultItemTemperature("wardrobe:taiga_helmet", 0.0F, 0.0F, 2.0F, 0.0F);
/* 391 */     JsonConfig.registerDefaultItemTemperature("wardrobe:taiga_chestplate", 0.0F, 0.0F, 3.5F, 0.0F);
/* 392 */     JsonConfig.registerDefaultItemTemperature("wardrobe:taiga_leggings", 0.0F, 0.0F, 3.0F, 0.0F);
/* 393 */     JsonConfig.registerDefaultItemTemperature("wardrobe:taiga_boots", 0.0F, 0.0F, 1.0F, 0.0F);
/* 394 */     JsonConfig.registerDefaultItemTemperature("wardrobe:snowy_helmet", 0.0F, 0.0F, 2.0F, 0.0F);
/* 395 */     JsonConfig.registerDefaultItemTemperature("wardrobe:snowy_chestplate", 0.0F, 0.0F, 3.5F, 0.0F);
/* 396 */     JsonConfig.registerDefaultItemTemperature("wardrobe:snowy_leggings", 0.0F, 0.0F, 3.0F, 0.0F);
/* 397 */     JsonConfig.registerDefaultItemTemperature("wardrobe:snowy_boots", 0.0F, 0.0F, 1.0F, 0.0F);
/* 398 */     JsonConfig.registerDefaultItemTemperature("wardrobe:desert_helmet", 0.0F, 2.0F, 0.0F, 0.0F);
/* 399 */     JsonConfig.registerDefaultItemTemperature("wardrobe:desert_chestplate", 0.0F, 3.0F, 0.0F, 0.0F);
/* 400 */     JsonConfig.registerDefaultItemTemperature("wardrobe:desert_leggings", 0.0F, 2.0F, 0.0F, 0.0F);
/* 401 */     JsonConfig.registerDefaultItemTemperature("wardrobe:desert_boots", 0.0F, 1.0F, 0.0F, 0.0F);
/* 402 */     JsonConfig.registerDefaultItemTemperature("wardrobe:jungle_chestplate", 0.0F, 5.0F, 0.0F, 0.0F);
/* 403 */     JsonConfig.registerDefaultItemTemperature("wardrobe:jungle_leggings", 0.0F, 3.0F, 0.0F, 0.0F);
/* 404 */     JsonConfig.registerDefaultItemTemperature("wardrobe:jungle_boots", 0.0F, 2.0F, 0.0F, 0.0F);
/* 405 */     JsonConfig.registerDefaultItemTemperature("wardrobe:savanna_chestplate", 0.0F, 4.0F, 0.0F, 0.0F);
/* 406 */     JsonConfig.registerDefaultItemTemperature("wardrobe:savanna_leggings", 0.0F, 2.5F, 0.0F, 0.0F);
/* 407 */     JsonConfig.registerDefaultItemTemperature("wardrobe:savanna_boots", 0.0F, 1.5F, 0.0F, 0.0F);
/* 408 */     JsonConfig.registerDefaultItemTemperature("wardrobe:wool_vest_chestplate", 0.0F, 0.0F, 2.0F, 0.0F);
/* 409 */     JsonConfig.registerDefaultItemTemperature("wardrobe:chiton", 0.0F, 2.0F, 0.0F, 0.0F);
/* 410 */     JsonConfig.registerDefaultItemTemperature("wardrobe:farmers_hat_helmet", 0.0F, 3.5F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initIceAndFire() {
/* 415 */     JsonConfig.registerDefaultEntityTemperature("iceandfire:hippocampus", 3.0F);
/*     */     
/* 417 */     JsonConfig.registerDefaultItemTemperature("iceandfire:dread_torch", -1.0F, 0.0F, 0.0F, 0.0F);
/*     */     
/* 419 */     JsonConfig.registerDefaultFuelItems("iceandfire:dragon_ice", ThermalTypeEnum.COOLING, 20);
/* 420 */     JsonConfig.registerDefaultFuelItems("iceandfire:dread_shard", ThermalTypeEnum.COOLING, 180);
/*     */     
/* 422 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_silver_metal_helmet", 0.0F, 0.5F, 0.0F, 0.0F);
/* 423 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_silver_metal_chestplate", 0.0F, 1.5F, 0.0F, 0.0F);
/* 424 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_silver_metal_leggings", 0.0F, 1.0F, 0.0F, 0.0F);
/* 425 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_silver_metal_boots", 0.0F, 1.0F, 0.0F, 0.0F);
/* 426 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_copper_metal_helmet", 0.0F, 0.5F, 0.0F, 0.0F);
/* 427 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_copper_metal_chestplate", 0.0F, 0.5F, 0.0F, 0.0F);
/* 428 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_copper_metal_leggings", 0.0F, 0.5F, 0.0F, 0.0F);
/* 429 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_copper_metal_boots", 0.0F, 0.5F, 0.0F, 0.0F);
/* 430 */     JsonConfig.registerDefaultItemTemperature("iceandfire:sheep_helmet", 0.0F, 0.0F, 2.0F, 0.0F);
/* 431 */     JsonConfig.registerDefaultItemTemperature("iceandfire:sheep_chestplate", 0.0F, 0.0F, 3.5F, 0.0F);
/* 432 */     JsonConfig.registerDefaultItemTemperature("iceandfire:sheep_leggings", 0.0F, 0.0F, 3.0F, 0.0F);
/* 433 */     JsonConfig.registerDefaultItemTemperature("iceandfire:sheep_boots", 0.0F, 0.0F, 1.0F, 0.0F);
/* 434 */     JsonConfig.registerDefaultItemTemperature("iceandfire:deathworm_yellow_helmet", 0.0F, 0.5F, 0.0F, 0.0F);
/* 435 */     JsonConfig.registerDefaultItemTemperature("iceandfire:deathworm_yellow_chestplate", 0.0F, 1.5F, 0.0F, 0.0F);
/* 436 */     JsonConfig.registerDefaultItemTemperature("iceandfire:deathworm_yellow_leggings", 0.0F, 1.0F, 0.0F, 0.0F);
/* 437 */     JsonConfig.registerDefaultItemTemperature("iceandfire:deathworm_yellow_boots", 0.0F, 1.0F, 0.0F, 0.0F);
/* 438 */     JsonConfig.registerDefaultItemTemperature("iceandfire:deathworm_white_helmet", 0.0F, 0.5F, 0.0F, 0.0F);
/* 439 */     JsonConfig.registerDefaultItemTemperature("iceandfire:deathworm_white_chestplate", 0.0F, 1.5F, 0.0F, 0.0F);
/* 440 */     JsonConfig.registerDefaultItemTemperature("iceandfire:deathworm_white_leggings", 0.0F, 1.0F, 0.0F, 0.0F);
/* 441 */     JsonConfig.registerDefaultItemTemperature("iceandfire:deathworm_white_boots", 0.0F, 1.0F, 0.0F, 0.0F);
/* 442 */     JsonConfig.registerDefaultItemTemperature("iceandfire:deathworm_red_helmet", 0.0F, 0.5F, 0.0F, 0.0F);
/* 443 */     JsonConfig.registerDefaultItemTemperature("iceandfire:deathworm_red_chestplate", 0.0F, 1.5F, 0.0F, 0.0F);
/* 444 */     JsonConfig.registerDefaultItemTemperature("iceandfire:deathworm_red_leggings", 0.0F, 1.0F, 0.0F, 0.0F);
/* 445 */     JsonConfig.registerDefaultItemTemperature("iceandfire:deathworm_red_boots", 0.0F, 1.0F, 0.0F, 0.0F);
/* 446 */     JsonConfig.registerDefaultItemTemperature("iceandfire:dragonsteel_ice_helmet", 0.0F, 3.0F, 0.0F, 0.0F);
/* 447 */     JsonConfig.registerDefaultItemTemperature("iceandfire:dragonsteel_ice_chestplate", 0.0F, 5.0F, 0.0F, 0.0F);
/* 448 */     JsonConfig.registerDefaultItemTemperature("iceandfire:dragonsteel_ice_leggings", 0.0F, 4.5F, 0.0F, 0.0F);
/* 449 */     JsonConfig.registerDefaultItemTemperature("iceandfire:dragonsteel_ice_boots", 0.0F, 2.5F, 0.0F, 0.0F);
/* 450 */     JsonConfig.registerDefaultItemTemperature("iceandfire:dragonsteel_fire_helmet", 0.0F, 0.0F, 3.0F, 0.0F);
/* 451 */     JsonConfig.registerDefaultItemTemperature("iceandfire:dragonsteel_fire_chestplate", 0.0F, 0.0F, 5.0F, 0.0F);
/* 452 */     JsonConfig.registerDefaultItemTemperature("iceandfire:dragonsteel_fire_leggings", 0.0F, 0.0F, 4.5F, 0.0F);
/* 453 */     JsonConfig.registerDefaultItemTemperature("iceandfire:dragonsteel_fire_boots", 0.0F, 0.0F, 2.5F, 0.0F);
/* 454 */     JsonConfig.registerDefaultItemTemperature("iceandfire:dragonsteel_lightning_helmet", 0.0F, 0.0F, 0.0F, 1.5F);
/* 455 */     JsonConfig.registerDefaultItemTemperature("iceandfire:dragonsteel_lightning_chestplate", 0.0F, 0.0F, 0.0F, 2.5F);
/* 456 */     JsonConfig.registerDefaultItemTemperature("iceandfire:dragonsteel_lightning_leggings", 0.0F, 0.0F, 0.0F, 2.0F);
/* 457 */     JsonConfig.registerDefaultItemTemperature("iceandfire:dragonsteel_lightning_boots", 0.0F, 0.0F, 0.0F, 1.5F);
/* 458 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_red_helmet", 0.0F, 0.0F, 1.0F, 0.0F);
/* 459 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_red_chestplate", 0.0F, 0.0F, 2.0F, 0.0F);
/* 460 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_red_leggings", 0.0F, 0.0F, 1.5F, 0.0F);
/* 461 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_red_boots", 0.0F, 0.0F, 1.5F, 0.0F);
/* 462 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_bronze_helmet", 0.0F, 0.0F, 1.0F, 0.0F);
/* 463 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_bronze_chestplate", 0.0F, 0.0F, 2.0F, 0.0F);
/* 464 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_bronze_leggings", 0.0F, 0.0F, 1.5F, 0.0F);
/* 465 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_bronze_boots", 0.0F, 0.0F, 1.5F, 0.0F);
/* 466 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_green_helmet", 0.0F, 0.0F, 1.0F, 0.0F);
/* 467 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_green_chestplate", 0.0F, 0.0F, 2.0F, 0.0F);
/* 468 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_green_leggings", 0.0F, 0.0F, 1.5F, 0.0F);
/* 469 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_green_boots", 0.0F, 0.0F, 1.5F, 0.0F);
/* 470 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_gray_helmet", 0.0F, 0.0F, 1.0F, 0.0F);
/* 471 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_gray_chestplate", 0.0F, 0.0F, 2.0F, 0.0F);
/* 472 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_gray_leggings", 0.0F, 0.0F, 1.5F, 0.0F);
/* 473 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_gray_boots", 0.0F, 0.0F, 1.5F, 0.0F);
/* 474 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_blue_helmet", 0.0F, 1.0F, 0.0F, 0.0F);
/* 475 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_blue_chestplate", 0.0F, 2.0F, 0.0F, 0.0F);
/* 476 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_blue_leggings", 0.0F, 1.5F, 0.0F, 0.0F);
/* 477 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_blue_boots", 0.0F, 1.5F, 0.0F, 0.0F);
/* 478 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_silver_helmet", 0.0F, 1.0F, 0.0F, 0.0F);
/* 479 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_silver_chestplate", 0.0F, 2.0F, 0.0F, 0.0F);
/* 480 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_silver_leggings", 0.0F, 1.5F, 0.0F, 0.0F);
/* 481 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_silver_boots", 0.0F, 1.5F, 0.0F, 0.0F);
/* 482 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_white_helmet", 0.0F, 1.0F, 0.0F, 0.0F);
/* 483 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_white_chestplate", 0.0F, 2.0F, 0.0F, 0.0F);
/* 484 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_white_leggings", 0.0F, 1.5F, 0.0F, 0.0F);
/* 485 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_white_boots", 0.0F, 1.5F, 0.0F, 0.0F);
/* 486 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_sapphire_helmet", 0.0F, 1.0F, 0.0F, 0.0F);
/* 487 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_sapphire_chestplate", 0.0F, 2.0F, 0.0F, 0.0F);
/* 488 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_sapphire_leggings", 0.0F, 1.5F, 0.0F, 0.0F);
/* 489 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_sapphire_boots", 0.0F, 1.5F, 0.0F, 0.0F);
/* 490 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_amythest_helmet", 0.0F, 0.0F, 0.0F, 0.5F);
/* 491 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_amythest_chestplate", 0.0F, 0.0F, 0.0F, 1.0F);
/* 492 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_amythest_leggings", 0.0F, 0.0F, 0.0F, 1.0F);
/* 493 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_amythest_boots", 0.0F, 0.0F, 0.0F, 0.5F);
/* 494 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_copper_helmet", 0.0F, 0.0F, 0.0F, 0.5F);
/* 495 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_copper_chestplate", 0.0F, 0.0F, 0.0F, 1.0F);
/* 496 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_copper_leggings", 0.0F, 0.0F, 0.0F, 1.0F);
/* 497 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_copper_boots", 0.0F, 0.0F, 0.0F, 0.5F);
/* 498 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_black_helmet", 0.0F, 0.0F, 0.0F, 0.5F);
/* 499 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_black_chestplate", 0.0F, 0.0F, 0.0F, 1.0F);
/* 500 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_black_leggings", 0.0F, 0.0F, 0.0F, 1.0F);
/* 501 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_black_boots", 0.0F, 0.0F, 0.0F, 0.5F);
/* 502 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_electric_helmet", 0.0F, 0.0F, 0.0F, 0.5F);
/* 503 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_electric_chestplate", 0.0F, 0.0F, 0.0F, 1.0F);
/* 504 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_electric_leggings", 0.0F, 0.0F, 0.0F, 1.0F);
/* 505 */     JsonConfig.registerDefaultItemTemperature("iceandfire:armor_electric_boots", 0.0F, 0.0F, 0.0F, 0.5F);
/* 506 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_red_helmet", 0.0F, 0.0F, 1.0F, 0.0F);
/* 507 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_red_chestplate", 0.0F, 0.0F, 2.0F, 0.0F);
/* 508 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_red_leggings", 0.0F, 0.0F, 1.5F, 0.0F);
/* 509 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_red_boots", 0.0F, 0.0F, 1.5F, 0.0F);
/* 510 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_blue_helmet", 0.0F, 0.0F, 1.0F, 0.0F);
/* 511 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_blue_chestplate", 0.0F, 0.0F, 2.0F, 0.0F);
/* 512 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_blue_leggings", 0.0F, 0.0F, 1.5F, 0.0F);
/* 513 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_blue_boots", 0.0F, 0.0F, 1.5F, 0.0F);
/* 514 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_bronze_helmet", 0.0F, 0.0F, 1.0F, 0.0F);
/* 515 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_bronze_chestplate", 0.0F, 0.0F, 2.0F, 0.0F);
/* 516 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_bronze_leggings", 0.0F, 0.0F, 1.5F, 0.0F);
/* 517 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_bronze_boots", 0.0F, 0.0F, 1.5F, 0.0F);
/* 518 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_green_helmet", 0.0F, 0.0F, 1.0F, 0.0F);
/* 519 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_green_chestplate", 0.0F, 0.0F, 2.0F, 0.0F);
/* 520 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_green_leggings", 0.0F, 0.0F, 1.5F, 0.0F);
/* 521 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_green_boots", 0.0F, 0.0F, 1.5F, 0.0F);
/* 522 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_deepblue_helmet", 0.0F, 0.0F, 1.0F, 0.0F);
/* 523 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_deepblue_chestplate", 0.0F, 0.0F, 2.0F, 0.0F);
/* 524 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_deepblue_leggings", 0.0F, 0.0F, 1.5F, 0.0F);
/* 525 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_deepblue_boots", 0.0F, 0.0F, 1.5F, 0.0F);
/* 526 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_purple_helmet", 0.0F, 0.0F, 1.0F, 0.0F);
/* 527 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_purple_chestplate", 0.0F, 0.0F, 2.0F, 0.0F);
/* 528 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_purple_leggings", 0.0F, 0.0F, 1.5F, 0.0F);
/* 529 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_purple_boots", 0.0F, 0.0F, 1.5F, 0.0F);
/* 530 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_teal_helmet", 0.0F, 0.0F, 1.0F, 0.0F);
/* 531 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_teal_chestplate", 0.0F, 0.0F, 2.0F, 0.0F);
/* 532 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_teal_leggings", 0.0F, 0.0F, 1.5F, 0.0F);
/* 533 */     JsonConfig.registerDefaultItemTemperature("iceandfire:tide_teal_boots", 0.0F, 0.0F, 1.5F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initAlexsMobs() {
/* 538 */     JsonConfig.registerDefaultItemTemperature("alexsmobs:roadrunner_boots", 0.0F, 1.0F, 0.0F, 0.0F);
/* 539 */     JsonConfig.registerDefaultItemTemperature("alexsmobs:crocodile_chestplate", 0.0F, 0.0F, 1.0F, 0.0F);
/* 540 */     JsonConfig.registerDefaultItemTemperature("alexsmobs:centipede_leggings", 0.0F, 1.0F, 0.0F, 0.0F);
/* 541 */     JsonConfig.registerDefaultItemTemperature("alexsmobs:frontier_cap", 0.0F, 0.0F, 4.0F, 0.0F);
/* 542 */     JsonConfig.registerDefaultItemTemperature("alexsmobs:sombrero", 0.0F, 4.0F, 0.0F, 0.0F);
/* 543 */     JsonConfig.registerDefaultItemTemperature("alexsmobs:emu_leggings", 0.0F, 1.5F, 0.0F, 0.0F);
/* 544 */     JsonConfig.registerDefaultItemTemperature("alexsmobs:froststalker_helmet", 0.0F, 3.0F, 0.0F, 0.0F);
/* 545 */     JsonConfig.registerDefaultItemTemperature("alexsmobs:unsettling_kimono", 0.0F, 2.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initAquamirae() {
/* 550 */     JsonConfig.registerDefaultItemTemperature("aquamirae:terrible_helmet", 0.0F, 1.0F, 0.0F, 0.0F);
/* 551 */     JsonConfig.registerDefaultItemTemperature("aquamirae:terrible_chestplate", 0.0F, 1.5F, 0.0F, 0.0F);
/* 552 */     JsonConfig.registerDefaultItemTemperature("aquamirae:terrible_leggings", 0.0F, 1.5F, 0.0F, 0.0F);
/* 553 */     JsonConfig.registerDefaultItemTemperature("aquamirae:terrible_boots", 0.0F, 1.0F, 0.0F, 0.0F);
/* 554 */     JsonConfig.registerDefaultItemTemperature("aquamirae:abyssal_heaume", 0.0F, 0.0F, 1.0F, 0.0F);
/* 555 */     JsonConfig.registerDefaultItemTemperature("aquamirae:abyssal_brigantine", 0.0F, 0.0F, 2.0F, 0.0F);
/* 556 */     JsonConfig.registerDefaultItemTemperature("aquamirae:abyssal_leggings", 0.0F, 0.0F, 1.0F, 0.0F);
/* 557 */     JsonConfig.registerDefaultItemTemperature("aquamirae:abyssal_boots", 0.0F, 0.0F, 1.0F, 0.0F);
/* 558 */     JsonConfig.registerDefaultItemTemperature("aquamirae:three_bolt_helmet", 0.0F, 0.0F, 1.0F, 0.0F);
/* 559 */     JsonConfig.registerDefaultItemTemperature("aquamirae:three_bolt_suit", 0.0F, 0.0F, 1.0F, 0.0F);
/* 560 */     JsonConfig.registerDefaultItemTemperature("aquamirae:three_bolt_leggings", 0.0F, 0.0F, 1.0F, 0.0F);
/* 561 */     JsonConfig.registerDefaultItemTemperature("aquamirae:three_bolt_boots", 0.0F, 0.0F, 1.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initCallOfYucutan() {
/* 566 */     JsonConfig.registerDefaultItemTemperature("call_of_yucutan:jades_helmet", 0.0F, 0.5F, 0.0F, 0.0F);
/* 567 */     JsonConfig.registerDefaultItemTemperature("call_of_yucutan:jades_chestplate", 0.0F, 1.5F, 0.0F, 0.0F);
/* 568 */     JsonConfig.registerDefaultItemTemperature("call_of_yucutan:jades_leggings", 0.0F, 1.5F, 0.0F, 0.0F);
/* 569 */     JsonConfig.registerDefaultItemTemperature("call_of_yucutan:jades_boots", 0.0F, 0.5F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initCataclysm() {
/* 574 */     JsonConfig.registerDefaultItemTemperature("cataclysm:bone_reptile_helmet", 0.0F, 0.0F, 1.5F, 0.0F);
/* 575 */     JsonConfig.registerDefaultItemTemperature("cataclysm:bone_reptile_chestplate", 0.0F, 0.0F, 2.0F, 0.0F);
/* 576 */     JsonConfig.registerDefaultItemTemperature("cataclysm:ignitium_helmet", 0.0F, 0.0F, 1.5F, 0.0F);
/* 577 */     JsonConfig.registerDefaultItemTemperature("cataclysm:ignitium_chestplate", 0.0F, 0.0F, 3.0F, 0.0F);
/* 578 */     JsonConfig.registerDefaultItemTemperature("cataclysm:ignitium_elytra_chestplate", 0.0F, 0.0F, 3.0F, 0.0F);
/* 579 */     JsonConfig.registerDefaultItemTemperature("cataclysm:ignitium_leggings", 0.0F, 0.0F, 2.0F, 0.0F);
/* 580 */     JsonConfig.registerDefaultItemTemperature("cataclysm:ignitium_boots", 0.0F, 0.0F, 1.5F, 0.0F);
/* 581 */     JsonConfig.registerDefaultItemTemperature("cataclysm:monstrous_helm", 0.0F, 0.0F, 1.0F, 0.0F);
/* 582 */     JsonConfig.registerDefaultItemTemperature("cataclysm:bloom_stone_pauldrons", 0.0F, 1.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initEndermanOverhaul() {
/* 587 */     JsonConfig.registerDefaultItemTemperature("endermanoverhaul:badlands_hood", 0.0F, 0.0F, 2.5F, 0.0F);
/* 588 */     JsonConfig.registerDefaultItemTemperature("endermanoverhaul:savanna_hood", 0.0F, 0.0F, 2.5F, 0.0F);
/* 589 */     JsonConfig.registerDefaultItemTemperature("endermanoverhaul:snowy_hood", 0.0F, 0.0F, 2.5F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initIronsSpellbooks() {
/* 594 */     JsonConfig.registerDefaultItemTemperature("irons_spellbooks:pyromancer_helmet", 0.0F, 0.0F, 1.5F, 0.0F);
/* 595 */     JsonConfig.registerDefaultItemTemperature("irons_spellbooks:pyromancer_chestplate", 0.0F, 0.0F, 2.5F, 0.0F);
/* 596 */     JsonConfig.registerDefaultItemTemperature("irons_spellbooks:pyromancer_leggings", 0.0F, 0.0F, 2.0F, 0.0F);
/* 597 */     JsonConfig.registerDefaultItemTemperature("irons_spellbooks:pyromancer_boots", 0.0F, 0.0F, 1.5F, 0.0F);
/* 598 */     JsonConfig.registerDefaultItemTemperature("irons_spellbooks:cryomancer_helmet", 0.0F, 1.5F, 0.0F, 0.0F);
/* 599 */     JsonConfig.registerDefaultItemTemperature("irons_spellbooks:cryomancer_chestplate", 0.0F, 2.5F, 0.0F, 0.0F);
/* 600 */     JsonConfig.registerDefaultItemTemperature("irons_spellbooks:cryomancer_leggings", 0.0F, 2.0F, 0.0F, 0.0F);
/* 601 */     JsonConfig.registerDefaultItemTemperature("irons_spellbooks:cryomancer_boots", 0.0F, 1.5F, 0.0F, 0.0F);
/* 602 */     JsonConfig.registerDefaultItemTemperature("irons_spellbooks:netherite_mage_helmet", 0.0F, 0.0F, 2.0F, 0.0F);
/* 603 */     JsonConfig.registerDefaultItemTemperature("irons_spellbooks:netherite_mage_chestplate", 0.0F, 0.0F, 3.5F, 0.0F);
/* 604 */     JsonConfig.registerDefaultItemTemperature("irons_spellbooks:netherite_mage_leggings", 0.0F, 0.0F, 2.5F, 0.0F);
/* 605 */     JsonConfig.registerDefaultItemTemperature("irons_spellbooks:netherite_mage_boots", 0.0F, 0.0F, 2.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initBornInChaos() {
/* 610 */     JsonConfig.registerDefaultItemTemperature("born_in_chaos_v1:dark_metal_armor_helmet", 0.0F, 1.0F, 0.0F, 0.0F);
/* 611 */     JsonConfig.registerDefaultItemTemperature("born_in_chaos_v1:dark_metal_armor_chestplate", 0.0F, 2.0F, 0.0F, 0.0F);
/* 612 */     JsonConfig.registerDefaultItemTemperature("born_in_chaos_v1:dark_metal_armor_leggings", 0.0F, 1.0F, 0.0F, 0.0F);
/* 613 */     JsonConfig.registerDefaultItemTemperature("born_in_chaos_v1:dark_metal_armor_boots", 0.0F, 0.5F, 0.0F, 0.0F);
/* 614 */     JsonConfig.registerDefaultItemTemperature("born_in_chaos_v1:spiritual_guide_sombrero_helmet", 0.0F, 3.5F, 0.0F, 0.0F);
/* 615 */     JsonConfig.registerDefaultItemTemperature("born_in_chaos_v1:nightmare_mantleofthe_night_helmet", 0.0F, 0.0F, 1.0F, 0.0F);
/* 616 */     JsonConfig.registerDefaultItemTemperature("born_in_chaos_v1:nightmare_mantleofthe_night_chestplate", 0.0F, 0.0F, 2.0F, 0.0F);
/* 617 */     JsonConfig.registerDefaultItemTemperature("born_in_chaos_v1:nightmare_mantleofthe_night_leggings", 0.0F, 0.0F, 1.0F, 0.0F);
/* 618 */     JsonConfig.registerDefaultItemTemperature("born_in_chaos_v1:nightmare_mantleofthe_night_boots", 0.0F, 0.0F, 0.5F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initUpgradeAquatic() {
/* 623 */     JsonConfig.registerDefaultConsumableThirst("upgrade_aquatic:mulberry", 4, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initTerraFirmaCraft() {
/* 628 */     JsonConfig.registerDefaultBlockFluidTemperature("tfc:firepit", 8.0F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "true") });
/* 629 */     JsonConfig.registerDefaultBlockFluidTemperature("tfc:firepit", 0.0F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "false") });
/* 630 */     JsonConfig.registerDefaultBlockFluidTemperature("tfc:pot", 8.0F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "true") });
/* 631 */     JsonConfig.registerDefaultBlockFluidTemperature("tfc:pot", 0.0F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "false") });
/* 632 */     JsonConfig.registerDefaultBlockFluidTemperature("tfc:charcoal_forge", 15.0F, new JsonPropertyValue[] { new JsonPropertyValue("heat_level", "6") });
/* 633 */     JsonConfig.registerDefaultBlockFluidTemperature("tfc:charcoal_forge", 13.0F, new JsonPropertyValue[] { new JsonPropertyValue("heat_level", "5") });
/* 634 */     JsonConfig.registerDefaultBlockFluidTemperature("tfc:charcoal_forge", 11.0F, new JsonPropertyValue[] { new JsonPropertyValue("heat_level", "4") });
/* 635 */     JsonConfig.registerDefaultBlockFluidTemperature("tfc:charcoal_forge", 9.0F, new JsonPropertyValue[] { new JsonPropertyValue("heat_level", "3") });
/* 636 */     JsonConfig.registerDefaultBlockFluidTemperature("tfc:charcoal_forge", 6.0F, new JsonPropertyValue[] { new JsonPropertyValue("heat_level", "2") });
/* 637 */     JsonConfig.registerDefaultBlockFluidTemperature("tfc:charcoal_forge", 3.0F, new JsonPropertyValue[] { new JsonPropertyValue("heat_level", "1") });
/* 638 */     JsonConfig.registerDefaultBlockFluidTemperature("tfc:charcoal_forge", 0.0F, new JsonPropertyValue[] { new JsonPropertyValue("heat_level", "0") });
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initLegendaryAdditions() {
/* 643 */     JsonConfig.registerDefaultItemTemperature("legendaryadditions:tribal_torch", 1.0F, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initHardcoreTorches() {
/* 648 */     JsonConfig.registerDefaultBlockFluidTemperature("hardcore_torches:hardcore_campfire", 10.0F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "true") });
/* 649 */     JsonConfig.registerDefaultBlockFluidTemperature("hardcore_torches:hardcore_campfire", 0.0F, new JsonPropertyValue[] { new JsonPropertyValue("lit", "false") });
/*     */     
/* 651 */     JsonConfig.registerDefaultBlockFluidTemperature("hardcore_torches:lit_wall_torch", 1.5F, new JsonPropertyValue[0]);
/* 652 */     JsonConfig.registerDefaultBlockFluidTemperature("hardcore_torches:lit_torch", 1.5F, new JsonPropertyValue[0]);
/*     */     
/* 654 */     JsonConfig.registerDefaultBlockFluidTemperature("hardcore_torches:smoldering_wall_torch", 0.75F, new JsonPropertyValue[0]);
/* 655 */     JsonConfig.registerDefaultBlockFluidTemperature("hardcore_torches:smoldering_torch", 0.75F, new JsonPropertyValue[0]);
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\IntegrationController.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */