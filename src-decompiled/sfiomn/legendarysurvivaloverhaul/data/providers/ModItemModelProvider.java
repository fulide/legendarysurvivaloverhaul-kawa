/*     */ package sfiomn.legendarysurvivaloverhaul.data.providers;
/*     */ 
/*     */ import net.minecraft.data.PackOutput;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
/*     */ import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
/*     */ import net.neoforged.neoforge.client.model.generators.ModelFile;
/*     */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*     */ import net.neoforged.neoforge.registries.DeferredHolder;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.ItemRegistry;
/*     */ 
/*     */ public class ModItemModelProvider
/*     */   extends ItemModelProvider
/*     */ {
/*     */   public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
/*  17 */     super(output, "legendarysurvivaloverhaul", existingFileHelper);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void registerModels() {
/*  23 */     simpleJuiceItem(ItemRegistry.APPLE_JUICE);
/*  24 */     simpleJuiceItem(ItemRegistry.BEETROOT_JUICE);
/*  25 */     simpleJuiceItem(ItemRegistry.CACTUS_JUICE);
/*  26 */     simpleJuiceItem(ItemRegistry.CARROT_JUICE);
/*  27 */     simpleJuiceItem(ItemRegistry.CHORUS_FRUIT_JUICE);
/*  28 */     simpleJuiceItem(ItemRegistry.GLISTERING_MELON_JUICE);
/*  29 */     simpleJuiceItem(ItemRegistry.GOLDEN_APPLE_JUICE);
/*  30 */     simpleJuiceItem(ItemRegistry.GOLDEN_CARROT_JUICE);
/*  31 */     simpleJuiceItem(ItemRegistry.MELON_JUICE);
/*  32 */     simpleJuiceItem(ItemRegistry.PUMPKIN_JUICE);
/*  33 */     simpleJuiceItem(ItemRegistry.SWEET_BERRIES_JUICE);
/*  34 */     simpleJuiceItem(ItemRegistry.GLOW_BERRIES_JUICE);
/*  35 */     simpleJuiceItem(ItemRegistry.GOLDEN_APPLE_JUICE);
/*     */     
/*  37 */     simpleHealingItem(ItemRegistry.BANDAGE);
/*  38 */     simpleHealingItem(ItemRegistry.HEALING_HERBS);
/*  39 */     simpleHealingItem(ItemRegistry.MEDKIT);
/*  40 */     simpleHealingItem(ItemRegistry.MORPHINE);
/*  41 */     simpleHealingItem(ItemRegistry.PLASTER);
/*  42 */     simpleHealingItem(ItemRegistry.TONIC);
/*     */     
/*  44 */     canteenItem(ItemRegistry.CANTEEN);
/*  45 */     canteenItem(ItemRegistry.LARGE_CANTEEN);
/*     */     
/*  47 */     simpleItem(ItemRegistry.PURIFIED_WATER_BOTTLE);
/*  48 */     simpleItem(ItemRegistry.ICE_FERN);
/*  49 */     simpleItem(ItemRegistry.ICE_FERN_SEEDS);
/*  50 */     simpleItem(ItemRegistry.ICE_FERN_GOLD);
/*  51 */     simpleItem(ItemRegistry.SUN_FERN);
/*  52 */     simpleItem(ItemRegistry.SUN_FERN_SEEDS);
/*  53 */     simpleItem(ItemRegistry.SUN_FERN_GOLD);
/*  54 */     simpleItem(ItemRegistry.WATER_PLANT_BAG);
/*  55 */     simpleItem(ItemRegistry.WATER_PLANT_SEEDS);
/*  56 */     simpleItem(ItemRegistry.COLD_STRING);
/*  57 */     simpleItem(ItemRegistry.WARM_STRING);
/*  58 */     simpleItem(ItemRegistry.NETHER_CHALICE);
/*  59 */     simpleItem(ItemRegistry.SPONGE);
/*  60 */     simpleItem(ItemRegistry.WATER_PURIFIER);
/*  61 */     simpleItem(ItemRegistry.HEAT_RESISTANCE_RING);
/*  62 */     simpleItem(ItemRegistry.COLD_RESISTANCE_RING);
/*  63 */     simpleItem(ItemRegistry.THERMAL_RESISTANCE_RING);
/*  64 */     simpleItem(ItemRegistry.FIRST_AID_SUPPLIES);
/*  65 */     simpleItem(ItemRegistry.HEART_CONTAINER);
/*  66 */     simpleItem(ItemRegistry.HEART_FRAGMENT);
/*  67 */     simpleItem(ItemRegistry.SHIELD_CONTAINER);
/*     */     
/*  69 */     simpleCoatItem(ItemRegistry.COOLING_COAT_1);
/*  70 */     simpleCoatItem(ItemRegistry.COOLING_COAT_2);
/*  71 */     simpleCoatItem(ItemRegistry.COOLING_COAT_3);
/*  72 */     simpleCoatItem(ItemRegistry.HEATING_COAT_1);
/*  73 */     simpleCoatItem(ItemRegistry.HEATING_COAT_2);
/*  74 */     simpleCoatItem(ItemRegistry.HEATING_COAT_3);
/*  75 */     simpleCoatItem(ItemRegistry.THERMAL_COAT_1);
/*  76 */     simpleCoatItem(ItemRegistry.THERMAL_COAT_2);
/*  77 */     simpleCoatItem(ItemRegistry.THERMAL_COAT_3);
/*     */     
/*  79 */     simpleArmorItem(ItemRegistry.DESERT_BOOTS);
/*  80 */     simpleArmorItem(ItemRegistry.DESERT_CHEST);
/*  81 */     simpleArmorItem(ItemRegistry.DESERT_HELMET);
/*  82 */     simpleArmorItem(ItemRegistry.DESERT_LEGGINGS);
/*  83 */     simpleArmorItem(ItemRegistry.SNOW_BOOTS);
/*  84 */     simpleArmorItem(ItemRegistry.SNOW_CHEST);
/*  85 */     simpleArmorItem(ItemRegistry.SNOW_HELMET);
/*  86 */     simpleArmorItem(ItemRegistry.SNOW_LEGGINGS);
/*     */     
/*  88 */     for (int i = 0; i < 30; i++) {
/*     */       
/*  90 */       String jsonName = String.format("%02d", new Object[] { Integer.valueOf(i) });
/*  91 */       singleTexture("item/thermometer/thermometer_" + jsonName, ResourceLocation.parse("item/generated"), "layer0", 
/*  92 */           ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "item/thermometer/thermometer_" + jsonName));
/*     */     } 
/*     */     
/*  95 */     String[] serene_seasons = { "autumn", "dry", "spring", "summer", "wet", "winter" };
/*  96 */     for (int j = 1; j < 4; j++) {
/*     */       
/*  98 */       for (String season : serene_seasons) {
/*     */         
/* 100 */         String jsonName = season + season;
/* 101 */         singleTexture("item/seasonal_calendar/serene_seasons/seasonal_calendar_" + jsonName, ResourceLocation.parse("item/generated"), "layer0", 
/* 102 */             ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "item/seasonal_calendar/serene_seasons/" + jsonName));
/*     */       } 
/*     */     } 
/*     */     
/* 106 */     String[] ecliptic_seasons = { "autumn", "spring", "summer", "winter" };
/* 107 */     for (int k = 1; k < 7; k++) {
/*     */       
/* 109 */       for (String season : ecliptic_seasons) {
/*     */         
/* 111 */         String jsonName = season + season;
/* 112 */         singleTexture("item/seasonal_calendar/ecliptic_seasons/seasonal_calendar_" + jsonName, ResourceLocation.parse("item/generated"), "layer0", 
/* 113 */             ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "item/seasonal_calendar/ecliptic_seasons/" + jsonName));
/*     */       } 
/*     */     } 
/*     */     
/* 117 */     singleTexture("item/seasonal_calendar/seasonal_calendar_null", ResourceLocation.parse("item/generated"), "layer0", 
/* 118 */         ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "item/seasonal_calendar/calendar_null"));
/*     */   }
/*     */ 
/*     */   
/*     */   private void simpleItem(DeferredHolder<Item, ? extends Item> item) {
/* 123 */     singleTexture(item.getId().getPath(), ResourceLocation.parse("item/generated"), "layer0", 
/* 124 */         ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "item/" + item.getId().getPath()));
/*     */   }
/*     */ 
/*     */   
/*     */   private void simpleItem(String jsonName) {
/* 129 */     singleTexture(jsonName, ResourceLocation.parse("item/generated"), "layer0", 
/* 130 */         ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "item/" + jsonName));
/*     */   }
/*     */ 
/*     */   
/*     */   private void simpleArmorItem(DeferredHolder<Item, ? extends Item> item) {
/* 135 */     singleTexture(item.getId().getPath(), ResourceLocation.parse("item/generated"), "layer0", 
/* 136 */         ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "item/armor/" + item.getId().getPath()));
/*     */   }
/*     */ 
/*     */   
/*     */   private void simpleCoatItem(DeferredHolder<Item, ? extends Item> item) {
/* 141 */     singleTexture(item.getId().getPath(), ResourceLocation.parse("item/generated"), "layer0", 
/* 142 */         ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "item/coat/" + item.getId().getPath()));
/*     */   }
/*     */ 
/*     */   
/*     */   private void simpleHealingItem(DeferredHolder<Item, ? extends Item> item) {
/* 147 */     singleTexture(item.getId().getPath(), ResourceLocation.parse("item/generated"), "layer0", 
/* 148 */         ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "item/healing/" + item.getId().getPath()));
/*     */   }
/*     */ 
/*     */   
/*     */   private void simpleJuiceItem(DeferredHolder<Item, ? extends Item> item) {
/* 153 */     singleTexture(item.getId().getPath(), ResourceLocation.parse("item/generated"), "layer0", 
/* 154 */         ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "item/juice/" + item.getId().getPath()));
/*     */   }
/*     */ 
/*     */   
/*     */   private void simplePaddingItem(DeferredHolder<Item, ? extends Item> item) {
/* 159 */     singleTexture(item.getId().getPath(), ResourceLocation.parse("item/generated"), "layer0", 
/* 160 */         ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "item/padding/" + item.getId().getPath()));
/*     */   }
/*     */ 
/*     */   
/*     */   private void canteenItem(DeferredHolder<Item, ? extends Item> canteenItem) {
/* 165 */     ((ItemModelBuilder)((ItemModelBuilder)withExistingParent(canteenItem.getId().getPath(), ResourceLocation.parse("item/generated")))
/* 166 */       .texture("layer0", ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "item/" + canteenItem.getId().getPath())))
/* 167 */       .override()
/* 168 */       .predicate(ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "thirstenum"), 0.3F)
/* 169 */       .model((ModelFile)new ModelFile.UncheckedModelFile(ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "item/" + canteenItem.getId().getPath() + "_purified")))
/* 170 */       .end();
/*     */     
/* 172 */     simpleItem(canteenItem.getId().getPath() + "_purified");
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\providers\ModItemModelProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */