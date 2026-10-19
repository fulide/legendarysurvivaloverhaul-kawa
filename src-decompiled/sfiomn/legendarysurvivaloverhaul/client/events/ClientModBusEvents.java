/*     */ package sfiomn.legendarysurvivaloverhaul.client.events;
/*     */ import net.minecraft.client.DeltaTracker;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiGraphics;
/*     */ import net.minecraft.client.gui.LayeredDraw;
/*     */ import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
/*     */ import net.minecraft.client.particle.ParticleEngine;
/*     */ import net.minecraft.core.particles.ParticleType;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.neoforged.bus.api.SubscribeEvent;
/*     */ import net.neoforged.fml.common.EventBusSubscriber;
/*     */ import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
/*     */ import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
/*     */ import net.neoforged.neoforge.client.gui.VanillaGuiLayers;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.integration.sereneseasons.RenderSeasonCards;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.render.RenderBodyDamageGui;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.render.RenderHealthGui;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.render.RenderTemperatureGui;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.render.RenderTemperatureOverlay;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.render.RenderThirstGui;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.render.RenderTooltipFrame;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.tooltips.HydrationClientTooltipComponent;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.tooltips.HydrationTooltipComponent;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.ParticleTypeRegistry;
/*     */ 
/*     */ @EventBusSubscriber(modid = "legendarysurvivaloverhaul", bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
/*     */ public class ClientModBusEvents {
/*     */   @SubscribeEvent
/*     */   public static void registerGuiOverlays(RegisterGuiLayersEvent event) {
/*  31 */     LayeredDraw.Layer healthLayer = (guiGraphics, delta) -> {
/*     */         Gui gui = (Minecraft.getInstance()).gui;
/*     */         
/*     */         int w = Minecraft.getInstance().getWindow().getGuiScaledWidth();
/*     */         int h = Minecraft.getInstance().getWindow().getGuiScaledHeight();
/*     */         RenderHealthGui.render(gui, guiGraphics, delta.getGameTimeDeltaPartialTick(false), w, h);
/*     */       };
/*  38 */     LayeredDraw.Layer coldHungerLayer = (guiGraphics, delta) -> {
/*     */         Gui gui = (Minecraft.getInstance()).gui;
/*     */         
/*     */         int w = Minecraft.getInstance().getWindow().getGuiScaledWidth();
/*     */         int h = Minecraft.getInstance().getWindow().getGuiScaledHeight();
/*     */         RenderTemperatureGui.renderColdHunger(gui, guiGraphics, delta.getGameTimeDeltaPartialTick(false), w, h);
/*     */       };
/*  45 */     LayeredDraw.Layer thirstLayer = (guiGraphics, delta) -> {
/*     */         Gui gui = (Minecraft.getInstance()).gui;
/*     */         
/*     */         int w = Minecraft.getInstance().getWindow().getGuiScaledWidth();
/*     */         int h = Minecraft.getInstance().getWindow().getGuiScaledHeight();
/*     */         RenderThirstGui.render(gui, guiGraphics, delta.getGameTimeDeltaPartialTick(false), w, h);
/*     */       };
/*  52 */     LayeredDraw.Layer temperatureLayer = (guiGraphics, delta) -> {
/*     */         Gui gui = (Minecraft.getInstance()).gui;
/*     */         
/*     */         int w = Minecraft.getInstance().getWindow().getGuiScaledWidth();
/*     */         int h = Minecraft.getInstance().getWindow().getGuiScaledHeight();
/*     */         RenderTemperatureGui.renderTemperature(gui, guiGraphics, delta.getGameTimeDeltaPartialTick(false), w, h);
/*     */       };
/*  59 */     LayeredDraw.Layer wetnessLayer = (guiGraphics, delta) -> {
/*     */         Gui gui = (Minecraft.getInstance()).gui;
/*     */         
/*     */         int w = Minecraft.getInstance().getWindow().getGuiScaledWidth();
/*     */         int h = Minecraft.getInstance().getWindow().getGuiScaledHeight();
/*     */         RenderWetnessGui.render(gui, guiGraphics, delta.getGameTimeDeltaPartialTick(false), w, h);
/*     */       };
/*  66 */     LayeredDraw.Layer bodyDamageLayer = (guiGraphics, delta) -> {
/*     */         Gui gui = (Minecraft.getInstance()).gui;
/*     */         
/*     */         int w = Minecraft.getInstance().getWindow().getGuiScaledWidth();
/*     */         int h = Minecraft.getInstance().getWindow().getGuiScaledHeight();
/*     */         RenderBodyDamageGui.render(gui, guiGraphics, delta.getGameTimeDeltaPartialTick(false), w, h);
/*     */       };
/*  73 */     LayeredDraw.Layer temperatureOverlayLayer = (guiGraphics, delta) -> {
/*     */         Gui gui = (Minecraft.getInstance()).gui;
/*     */         
/*     */         int w = Minecraft.getInstance().getWindow().getGuiScaledWidth();
/*     */         int h = Minecraft.getInstance().getWindow().getGuiScaledHeight();
/*     */         RenderTemperatureOverlay.render(gui, guiGraphics, delta.getGameTimeDeltaPartialTick(false), w, h);
/*     */       };
/*  80 */     LayeredDraw.Layer itemFrameTooltipLayer = (guiGraphics, delta) -> {
/*     */         Gui gui = (Minecraft.getInstance()).gui;
/*     */         
/*     */         int w = Minecraft.getInstance().getWindow().getGuiScaledWidth();
/*     */         int h = Minecraft.getInstance().getWindow().getGuiScaledHeight();
/*     */         RenderTooltipFrame.render(gui, guiGraphics, delta.getGameTimeDeltaPartialTick(false), w, h);
/*     */       };
/*  87 */     LayeredDraw.Layer seasonCardLayer = (guiGraphics, delta) -> {
/*     */         Gui gui = (Minecraft.getInstance()).gui;
/*     */         
/*     */         int w = Minecraft.getInstance().getWindow().getGuiScaledWidth();
/*     */         int h = Minecraft.getInstance().getWindow().getGuiScaledHeight();
/*     */         RenderSeasonCards.render(gui, guiGraphics, delta.getGameTimeDeltaPartialTick(false), w, h);
/*     */       };
/*  94 */     event.registerAbove(VanillaGuiLayers.PLAYER_HEALTH, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "health_overhaul"), healthLayer);
/*  95 */     event.registerBelow(VanillaGuiLayers.FOOD_LEVEL, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "cold_hunger"), coldHungerLayer);
/*  96 */     event.registerAbove(VanillaGuiLayers.FOOD_LEVEL, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "thirst"), thirstLayer);
/*  97 */     event.registerAbove(VanillaGuiLayers.FOOD_LEVEL, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "temperature"), temperatureLayer);
/*  98 */     event.registerAbove(VanillaGuiLayers.FOOD_LEVEL, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "wetness"), wetnessLayer);
/*  99 */     event.registerAbove(VanillaGuiLayers.FOOD_LEVEL, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "body_damage"), bodyDamageLayer);
/*     */     
/* 101 */     event.registerAbove(VanillaGuiLayers.PLAYER_HEALTH, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "temperature_overlay"), temperatureOverlayLayer);
/* 102 */     event.registerAbove(VanillaGuiLayers.FOOD_LEVEL, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "item_frame_tooltip"), itemFrameTooltipLayer);
/* 103 */     event.registerAbove(VanillaGuiLayers.FOOD_LEVEL, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "season_card"), seasonCardLayer);
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onTooltipRegistration(RegisterClientTooltipComponentFactoriesEvent event) {
/* 109 */     event.register(HydrationTooltipComponent.class, component -> new HydrationClientTooltipComponent(component.hydration(), component.saturation()));
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
/* 115 */     event.registerSpriteSet((ParticleType)ParticleTypeRegistry.SUN_FERN_BLOSSOM.get(), sfiomn.legendarysurvivaloverhaul.client.particles.FernBlossomParticle.Factory::new);
/* 116 */     event.registerSpriteSet((ParticleType)ParticleTypeRegistry.ICE_FERN_BLOSSOM.get(), sfiomn.legendarysurvivaloverhaul.client.particles.FernBlossomParticle.Factory::new);
/* 117 */     event.registerSpriteSet((ParticleType)ParticleTypeRegistry.COLD_BREATH.get(), sfiomn.legendarysurvivaloverhaul.client.particles.BreathParticle.Factory::new);
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\client\events\ClientModBusEvents.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */