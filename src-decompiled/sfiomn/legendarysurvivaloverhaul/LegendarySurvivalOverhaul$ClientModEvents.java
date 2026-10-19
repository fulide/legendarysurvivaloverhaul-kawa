/*     */ package sfiomn.legendarysurvivaloverhaul;
/*     */ 
/*     */ import net.minecraft.client.gui.screens.MenuScreens;
/*     */ import net.minecraft.client.renderer.item.ItemProperties;
/*     */ import net.minecraft.client.renderer.item.ItemPropertyFunction;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.world.inventory.MenuType;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.neoforged.api.distmarker.Dist;
/*     */ import net.neoforged.bus.api.SubscribeEvent;
/*     */ import net.neoforged.fml.common.EventBusSubscriber;
/*     */ import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
/*     */ import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.itemproperties.CanteenProperty;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.itemproperties.SeasonalCalendarSeasonTypeProperty;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.itemproperties.SeasonalCalendarTimeProperty;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.itemproperties.ThermometerProperty;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.ContainerRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.ItemRegistry;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @EventBusSubscriber(modid = "legendarysurvivaloverhaul", bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
/*     */ public class ClientModEvents
/*     */ {
/*     */   @SubscribeEvent
/*     */   public static void onClientSetup(FMLClientSetupEvent event) {
/* 315 */     Config.Baked.bakeClient();
/*     */     
/* 317 */     ItemProperties.register((Item)ItemRegistry.THERMOMETER.get(), ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "temperature"), (ItemPropertyFunction)new ThermometerProperty());
/* 318 */     ItemProperties.register((Item)ItemRegistry.CANTEEN.get(), ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "thirstenum"), (ItemPropertyFunction)new CanteenProperty());
/* 319 */     ItemProperties.register((Item)ItemRegistry.LARGE_CANTEEN.get(), ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "thirstenum"), (ItemPropertyFunction)new CanteenProperty());
/* 320 */     if (LegendarySurvivalOverhaul.sereneSeasonsLoaded || LegendarySurvivalOverhaul.eclipticSeasonsLoaded) {
/*     */       
/* 322 */       ItemProperties.register((Item)ItemRegistry.SEASONAL_CALENDAR.get(), ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "time"), (ItemPropertyFunction)new SeasonalCalendarTimeProperty());
/* 323 */       ItemProperties.register((Item)ItemRegistry.SEASONAL_CALENDAR.get(), ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "seasontype"), (ItemPropertyFunction)new SeasonalCalendarSeasonTypeProperty());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onRegisterMenuScreens(RegisterMenuScreensEvent event) {
/* 330 */     event.register((MenuType)ContainerRegistry.COOLER_CONTAINER.get(), sfiomn.legendarysurvivaloverhaul.client.screens.ThermalScreen::new);
/* 331 */     event.register((MenuType)ContainerRegistry.HEATER_CONTAINER.get(), sfiomn.legendarysurvivaloverhaul.client.screens.ThermalScreen::new);
/* 332 */     event.register((MenuType)ContainerRegistry.SEWING_TABLE_CONTAINER.get(), sfiomn.legendarysurvivaloverhaul.client.screens.SewingTableScreen::new);
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\LegendarySurvivalOverhaul$ClientModEvents.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */