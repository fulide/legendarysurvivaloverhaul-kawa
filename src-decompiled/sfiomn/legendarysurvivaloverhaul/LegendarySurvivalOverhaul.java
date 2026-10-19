/*     */ package sfiomn.legendarysurvivaloverhaul;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import net.minecraft.client.gui.screens.MenuScreens;
/*     */ import net.minecraft.client.renderer.item.ItemProperties;
/*     */ import net.minecraft.client.renderer.item.ItemPropertyFunction;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.server.packs.resources.PreparableReloadListener;
/*     */ import net.minecraft.world.inventory.MenuType;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.neoforged.bus.api.IEventBus;
/*     */ import net.neoforged.fml.ModList;
/*     */ import net.neoforged.fml.common.EventBusSubscriber;
/*     */ import net.neoforged.fml.event.config.ModConfigEvent;
/*     */ import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
/*     */ import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
/*     */ import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
/*     */ import net.neoforged.neoforge.event.AddReloadListenerEvent;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.IBodyDamageUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.BodyDamageDataManager;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.IBodyPartsDamageSourceManager;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.IBodyResistanceItemManager;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.IHealingConsumableManager;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.ITemperatureBiomeManager;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.ITemperatureConsumableBlockManager;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.ITemperatureFuelItemManager;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.ITemperatureOriginManager;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.IThirstConsumableManager;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.TemperatureDataManager;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.ThirstDataManager;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.temperature.ITemperatureUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.thirst.ThirstUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.wetness.WetnessUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.itemproperties.CanteenProperty;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.integration.sereneseasons.SereneSeasonsUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.listeners.BodyDamageHealingConsumableListener;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.listeners.BodyPartResistanceItemListener;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.listeners.TemperatureBiomeListener;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.listeners.TemperatureConsumableBlockListener;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.listeners.TemperatureConsumableListener;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.listeners.TemperatureDimensionListener;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.listeners.TemperatureFuelItemListener;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.listeners.TemperatureItemListener;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.listeners.TemperatureMountListener;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.listeners.ThirstBlockListener;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.listeners.ThirstConsumableListener;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.ContainerRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.ItemRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.internal.BodyDamageUtilInternal;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.internal.HealthUtilInternal;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.internal.TemperatureUtilInternal;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.internal.ThirstUtilInternal;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.internal.WetnessUtilInternal;
/*     */ 
/*     */ @Mod("legendarysurvivaloverhaul")
/*     */ public class LegendarySurvivalOverhaul {
/*  58 */   public static final Logger LOGGER = LogManager.getLogger();
/*     */ 
/*     */   
/*     */   public static final String MOD_ID = "legendarysurvivaloverhaul";
/*     */ 
/*     */   
/*     */   public static boolean betterWeatherLoaded = false;
/*     */ 
/*     */   
/*     */   public static boolean sereneSeasonsLoaded = false;
/*     */   
/*     */   public static boolean eclipticSeasonsLoaded = false;
/*     */   
/*     */   public static boolean terraFirmaCraftLoaded = false;
/*     */   
/*     */   public static boolean surviveLoaded = false;
/*     */   
/*     */   public static boolean curiosLoaded = false;
/*     */   
/*     */   public static boolean vampirismLoaded = false;
/*     */   
/*     */   public static boolean originsLoaded = false;
/*     */   
/*     */   public static boolean mutantMonstersLoaded = false;
/*     */   
/*     */   public static boolean supplementariesLoaded = false;
/*     */   
/*     */   public static boolean artifactsLoaded = false;
/*     */   
/*     */   public static boolean beachpartyLoaded = false;
/*     */   
/*     */   public static boolean meadowLoaded = false;
/*     */   
/*     */   public static boolean overflowingbarsLoaded = false;
/*     */   
/*     */   public static boolean weather2Loaded = false;
/*     */   
/*     */   public static boolean medsandherbsLoaded = false;
/*     */   
/*     */   public static boolean crayfishFurnitureLoaded = false;
/*     */   
/*  99 */   public static Path configPath = FMLPaths.CONFIGDIR.get();
/* 100 */   public static Path modConfigPath = Paths.get(configPath.toAbsolutePath().toString(), new String[] { "legendarysurvivaloverhaul" });
/* 101 */   public static Path modConfigJsons = Paths.get(modConfigPath.toString(), new String[] { "json" });
/* 102 */   public static Path modIntegrationConfigJsons = Paths.get(modConfigJsons.toString(), new String[] { "integration" });
/*     */ 
/*     */ 
/*     */   
/*     */   public LegendarySurvivalOverhaul(IEventBus modBus, ModContainer modContainer) {
/* 107 */     modBus.addListener(this::commonSetup);
/* 108 */     modBus.addListener(this::onModConfigLoadEvent);
/* 109 */     modBus.addListener(this::onModConfigReloadEvent);
/* 110 */     modBus.addListener(this::onLoadComplete);
/*     */ 
/*     */     
/* 113 */     ModAttachments.init(modBus);
/*     */ 
/*     */     
/* 116 */     DataComponentRegistry.init(modBus);
/*     */     
/* 118 */     IEventBus forgeBus = NeoForge.EVENT_BUS;
/*     */     
/* 120 */     forgeBus.addListener(this::addReloadListenerEvent);
/*     */     
/* 122 */     Config.register();
/*     */     
/* 124 */     AttributeRegistry.register(modBus);
/* 125 */     ArmorMaterialBase.register(modBus);
/* 126 */     ItemRegistry.register(modBus);
/* 127 */     MobEffectRegistry.register(modBus);
/* 128 */     LootModifierRegistry.register(modBus);
/* 129 */     BlockRegistry.register(modBus);
/* 130 */     ContainerRegistry.register(modBus);
/* 131 */     ParticleTypeRegistry.register(modBus);
/* 132 */     RecipeRegistry.register(modBus);
/* 133 */     SoundRegistry.register(modBus);
/* 134 */     TemperatureModifierRegistry.register(modBus);
/* 135 */     BlockEntityRegistry.register(modBus);
/* 136 */     FeatureRegistry.register(modBus);
/* 137 */     CreativeTabRegistry.register(modBus);
/*     */     
/* 139 */     forgeBus.addListener(CommandRegistry::registerCommandsEvent);
/*     */     
/* 141 */     modIntegration(forgeBus);
/*     */   }
/*     */ 
/*     */   
/*     */   private void modIntegration(IEventBus forgeBus) {
/* 146 */     sereneSeasonsLoaded = ModList.get().isLoaded("sereneseasons");
/* 147 */     eclipticSeasonsLoaded = ModList.get().isLoaded("eclipticseasons");
/* 148 */     curiosLoaded = ModList.get().isLoaded("curios");
/* 149 */     terraFirmaCraftLoaded = ModList.get().isLoaded("tfc");
/* 150 */     vampirismLoaded = ModList.get().isLoaded("vampirism");
/* 151 */     originsLoaded = ModList.get().isLoaded("origins");
/* 152 */     mutantMonstersLoaded = ModList.get().isLoaded("mutantmonsters");
/* 153 */     supplementariesLoaded = ModList.get().isLoaded("supplementaries");
/* 154 */     artifactsLoaded = ModList.get().isLoaded("artifacts");
/* 155 */     beachpartyLoaded = ModList.get().isLoaded("beachparty");
/* 156 */     meadowLoaded = ModList.get().isLoaded("meadow");
/* 157 */     overflowingbarsLoaded = ModList.get().isLoaded("overflowingbars");
/* 158 */     medsandherbsLoaded = ModList.get().isLoaded("meds_and_herbs");
/* 159 */     crayfishFurnitureLoaded = ModList.get().isLoaded("refurbished_furniture");
/*     */     
/* 161 */     weather2Loaded = ModList.get().isLoaded("weather2");
/* 162 */     surviveLoaded = ModList.get().isLoaded("survive");
/*     */     
/* 164 */     if (sereneSeasonsLoaded) {
/* 165 */       LOGGER.debug("Serene Seasons is loaded, enabling compatibility");
/*     */     }
/* 167 */     if (eclipticSeasonsLoaded)
/*     */     {
/* 169 */       if (sereneSeasonsLoaded) {
/* 170 */         LOGGER.debug("Ecliptic Seasons and Serene Seasons are loaded, please choose one over the other");
/*     */       } else {
/* 172 */         LOGGER.debug("Ecliptic Seasons is loaded, enabling compatibility");
/*     */       } 
/*     */     }
/* 175 */     if (terraFirmaCraftLoaded) {
/* 176 */       LOGGER.debug("TerraFirmaCraft is loaded, enabling compatibility");
/*     */     }
/* 178 */     if (mutantMonstersLoaded) {
/* 179 */       LOGGER.debug("Mutant Monsters is loaded, enabling compatibility");
/*     */     }
/* 181 */     if (curiosLoaded) {
/*     */       
/* 183 */       LOGGER.debug("Curios is loaded, enabling compatibility");
/* 184 */       forgeBus.register(CuriosEvents.class);
/*     */     } 
/*     */     
/* 187 */     if (vampirismLoaded) {
/*     */       
/* 189 */       LOGGER.debug("Vampirism is loaded, enabling compatibility");
/* 190 */       forgeBus.register(VampirismEvents.class);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 198 */     if (supplementariesLoaded) {
/* 199 */       LOGGER.debug("Supplementarie is loaded, enabling compatibility");
/*     */     }
/* 201 */     if (artifactsLoaded) {
/* 202 */       LOGGER.debug("Artifacts is loaded, enabling compatibility");
/*     */     }
/* 204 */     if (beachpartyLoaded) {
/* 205 */       LOGGER.debug("Let's do Beachparty is loaded, enabling compatibility");
/*     */     }
/* 207 */     if (meadowLoaded) {
/* 208 */       LOGGER.debug("Let's do Meadow is loaded, enabling compatibility");
/*     */     }
/* 210 */     if (overflowingbarsLoaded) {
/* 211 */       LOGGER.debug("Overflowing Bars is loaded, enabling compatibility");
/*     */     }
/* 213 */     if (medsandherbsLoaded) {
/* 214 */       LOGGER.debug("Meds And Herbs is loaded, enabling compatibility");
/*     */     }
/* 216 */     if (crayfishFurnitureLoaded) {
/* 217 */       LOGGER.debug("MrCrayfish's Furniture Mod: Refurbished is loaded, enabling compatibility");
/*     */     }
/* 219 */     if (weather2Loaded) {
/* 220 */       LOGGER.debug("Weather2 is loaded, no compatibility for now");
/*     */     }
/* 222 */     if (surviveLoaded) {
/* 223 */       LOGGER.debug("Survive is loaded, I hope you know what you're doing");
/*     */     }
/* 225 */     JsonIntegrationConfigRegistration.init(modIntegrationConfigJsons.toFile());
/*     */   }
/*     */ 
/*     */   
/*     */   private void commonSetup(FMLCommonSetupEvent event) {
/* 230 */     event.enqueueWork(() -> {
/*     */           TemperatureUtil.internal = (ITemperatureUtil)new TemperatureUtilInternal();
/*     */           ThirstUtil.internal = (IThirstUtil)new ThirstUtilInternal();
/*     */           BodyDamageUtil.internal = (IBodyDamageUtil)new BodyDamageUtilInternal();
/*     */           WetnessUtil.internal = (IWetnessUtil)new WetnessUtilInternal();
/*     */           HealthUtil.internal = (IHealthUtil)new HealthUtilInternal();
/*     */           TemperatureDataManager.internalConsumable = (ITemperatureConsumableManager)new TemperatureConsumableListener();
/*     */           TemperatureDataManager.internalConsumableBlock = (ITemperatureConsumableBlockManager)new TemperatureConsumableBlockListener();
/*     */           TemperatureDataManager.internalBlock = (ITemperatureBlockManager)new TemperatureBlockListener();
/*     */           TemperatureDataManager.internalItem = (ITemperatureItemManager)new TemperatureItemListener();
/*     */           TemperatureDataManager.internalBiome = (ITemperatureBiomeManager)new TemperatureBiomeListener();
/*     */           TemperatureDataManager.internalFuelItem = (ITemperatureFuelItemManager)new TemperatureFuelItemListener();
/*     */           TemperatureDataManager.internalDimension = (ITemperatureDimensionManager)new TemperatureDimensionListener();
/*     */           TemperatureDataManager.internalMount = (ITemperatureMountManager)new TemperatureMountListener();
/*     */           TemperatureDataManager.internalOrigin = (ITemperatureOriginManager)new TemperatureOriginListener();
/*     */           ThirstDataManager.internalConsumable = (IThirstConsumableManager)new ThirstConsumableListener();
/*     */           ThirstDataManager.internalBlock = (IThirstBlockManager)new ThirstBlockListener();
/*     */           BodyDamageDataManager.internalBodyPartsDamageSource = (IBodyPartsDamageSourceManager)new BodyPartsDamageSourceListener();
/*     */           BodyDamageDataManager.internalHealingConsumable = (IHealingConsumableManager)new BodyDamageHealingConsumableListener();
/*     */           BodyDamageDataManager.internalBodyResistanceItem = (IBodyResistanceItemManager)new BodyPartResistanceItemListener();
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void onLoadComplete(FMLLoadCompleteEvent event) {
/* 259 */     event.enqueueWork(() -> {
/*     */           BodyDamageUtilInternal.initMalusConfig();
/*     */           BodyDamageUtilInternal.initLimbEffects();
/*     */           if (sereneSeasonsLoaded) {
/*     */             SereneSeasonsUtil.initAverageTemperatures();
/*     */           }
/*     */           if (eclipticSeasonsLoaded) {
/*     */             EclipticSeasonsUtil.initAverageTemperatures();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void onModConfigLoadEvent(ModConfigEvent.Loading event) {
/* 275 */     if (event.getConfig().getSpec() == Config.CLIENT_SPEC) {
/* 276 */       Config.Baked.bakeClient();
/*     */     }
/* 278 */     if (event.getConfig().getSpec() == Config.COMMON_SPEC) {
/* 279 */       Config.Baked.bakeCommon();
/*     */     }
/*     */   }
/*     */   
/*     */   private void onModConfigReloadEvent(ModConfigEvent.Reloading event) {
/* 284 */     ModConfig config = event.getConfig();
/*     */ 
/*     */     
/* 287 */     if (config.getSpec() == Config.CLIENT_SPEC) {
/* 288 */       Config.Baked.bakeClient();
/*     */     }
/*     */   }
/*     */   
/*     */   private void addReloadListenerEvent(AddReloadListenerEvent event) {
/* 293 */     event.addListener((PreparableReloadListener)TemperatureDataManager.internalConsumable);
/* 294 */     event.addListener((PreparableReloadListener)TemperatureDataManager.internalConsumableBlock);
/* 295 */     event.addListener((PreparableReloadListener)TemperatureDataManager.internalBlock);
/* 296 */     event.addListener((PreparableReloadListener)TemperatureDataManager.internalItem);
/* 297 */     event.addListener((PreparableReloadListener)TemperatureDataManager.internalBiome);
/* 298 */     event.addListener((PreparableReloadListener)TemperatureDataManager.internalFuelItem);
/* 299 */     event.addListener((PreparableReloadListener)TemperatureDataManager.internalDimension);
/* 300 */     event.addListener((PreparableReloadListener)TemperatureDataManager.internalMount);
/* 301 */     event.addListener((PreparableReloadListener)TemperatureDataManager.internalOrigin);
/* 302 */     event.addListener((PreparableReloadListener)ThirstDataManager.internalConsumable);
/* 303 */     event.addListener((PreparableReloadListener)ThirstDataManager.internalBlock);
/* 304 */     event.addListener((PreparableReloadListener)BodyDamageDataManager.internalBodyPartsDamageSource);
/* 305 */     event.addListener((PreparableReloadListener)BodyDamageDataManager.internalHealingConsumable);
/* 306 */     event.addListener((PreparableReloadListener)BodyDamageDataManager.internalBodyResistanceItem);
/*     */   }
/*     */ 
/*     */   
/*     */   @EventBusSubscriber(modid = "legendarysurvivaloverhaul", bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
/*     */   public static class ClientModEvents
/*     */   {
/*     */     @SubscribeEvent
/*     */     public static void onClientSetup(FMLClientSetupEvent event) {
/* 315 */       Config.Baked.bakeClient();
/*     */       
/* 317 */       ItemProperties.register((Item)ItemRegistry.THERMOMETER.get(), ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "temperature"), (ItemPropertyFunction)new ThermometerProperty());
/* 318 */       ItemProperties.register((Item)ItemRegistry.CANTEEN.get(), ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "thirstenum"), (ItemPropertyFunction)new CanteenProperty());
/* 319 */       ItemProperties.register((Item)ItemRegistry.LARGE_CANTEEN.get(), ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "thirstenum"), (ItemPropertyFunction)new CanteenProperty());
/* 320 */       if (LegendarySurvivalOverhaul.sereneSeasonsLoaded || LegendarySurvivalOverhaul.eclipticSeasonsLoaded) {
/*     */         
/* 322 */         ItemProperties.register((Item)ItemRegistry.SEASONAL_CALENDAR.get(), ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "time"), (ItemPropertyFunction)new SeasonalCalendarTimeProperty());
/* 323 */         ItemProperties.register((Item)ItemRegistry.SEASONAL_CALENDAR.get(), ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "seasontype"), (ItemPropertyFunction)new SeasonalCalendarSeasonTypeProperty());
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     @SubscribeEvent
/*     */     public static void onRegisterMenuScreens(RegisterMenuScreensEvent event) {
/* 330 */       event.register((MenuType)ContainerRegistry.COOLER_CONTAINER.get(), sfiomn.legendarysurvivaloverhaul.client.screens.ThermalScreen::new);
/* 331 */       event.register((MenuType)ContainerRegistry.HEATER_CONTAINER.get(), sfiomn.legendarysurvivaloverhaul.client.screens.ThermalScreen::new);
/* 332 */       event.register((MenuType)ContainerRegistry.SEWING_TABLE_CONTAINER.get(), sfiomn.legendarysurvivaloverhaul.client.screens.SewingTableScreen::new);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\LegendarySurvivalOverhaul.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */