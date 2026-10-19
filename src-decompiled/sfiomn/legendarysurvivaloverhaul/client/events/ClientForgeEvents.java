/*     */ package sfiomn.legendarysurvivaloverhaul.client.events;
/*     */ 
/*     */ import java.util.ListIterator;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.player.LocalPlayer;
/*     */ import net.minecraft.core.Holder;
/*     */ import net.minecraft.core.registries.BuiltInRegistries;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.item.MapItem;
/*     */ import net.minecraft.world.level.block.Block;
/*     */ import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
/*     */ import net.neoforged.api.distmarker.Dist;
/*     */ import net.neoforged.bus.api.EventPriority;
/*     */ import net.neoforged.bus.api.SubscribeEvent;
/*     */ import net.neoforged.fml.common.EventBusSubscriber;
/*     */ import net.neoforged.neoforge.client.event.ClientTickEvent;
/*     */ import net.neoforged.neoforge.client.event.CustomizeGuiOverlayEvent;
/*     */ import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;
/*     */ import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
/*     */ import net.neoforged.neoforge.client.gui.VanillaGuiLayers;
/*     */ import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
/*     */ import net.neoforged.neoforge.event.entity.player.BonemealEvent;
/*     */ import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
/*     */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonThirstBlock;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.thirst.ThirstUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.ClientHooks;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.effects.TemperatureBreathEffect;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.integration.sereneseasons.RenderSeasonCards;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.render.RenderBlurOverlay;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.render.RenderBodyDamageGui;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.render.RenderTemperatureGui;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.render.RenderTemperatureOverlay;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.render.RenderThirstGui;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.render.RenderWetnessGui;
/*     */ import sfiomn.legendarysurvivaloverhaul.client.sounds.TemperatureBreathSound;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.attachments.thirst.ThirstAttachment;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.events.CommonNeoForgeEvents;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.integration.curios.CuriosUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.integration.sereneseasons.SereneSeasonsUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*     */ import sfiomn.legendarysurvivaloverhaul.network.payloads.DrinkBlockFluidMessage;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.ItemRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.KeyMappingRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.MobEffectRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.ItemUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.WorldUtil;
/*     */ 
/*     */ @EventBusSubscriber(modid = "legendarysurvivaloverhaul", bus = EventBusSubscriber.Bus.GAME, value = {Dist.CLIENT})
/*     */ public class ClientForgeEvents {
/*     */   public static boolean hasOpened = false;
/*  60 */   public static int warningPageDelay = 40;
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onItemRightClick(PlayerInteractEvent.RightClickItem event) {
/*  65 */     LocalPlayer localPlayer = (Minecraft.getInstance()).player;
/*  66 */     if (localPlayer == null) {
/*     */       return;
/*     */     }
/*     */     
/*  70 */     if (LegendarySurvivalOverhaul.sereneSeasonsLoaded && BuiltInRegistries.ITEM
/*  71 */       .getKey(event.getItemStack().getItem())
/*  72 */       .equals(ResourceLocation.fromNamespaceAndPath("sereneseasons", "calendar"))) {
/*     */       
/*  74 */       localPlayer.displayClientMessage(SereneSeasonsUtil.seasonTooltip(localPlayer.blockPosition(), localPlayer.level()), true);
/*  75 */     } else if (event.getItemStack().getItem() == Items.CLOCK) {
/*     */       
/*  77 */       localPlayer.displayClientMessage((Component)Component.literal(WorldUtil.timeInGame(Minecraft.getInstance())), true);
/*  78 */     } else if (event.getItemStack().getItem() == Items.COMPASS) {
/*     */       
/*  80 */       String compassLocation = ItemUtil.compassLocation((Entity)localPlayer);
/*  81 */       if (!compassLocation.isEmpty())
/*  82 */         localPlayer.displayClientMessage((Component)Component.literal(compassLocation), true); 
/*  83 */     } else if (Config.Baked.showCoordinateOnMap && event.getItemStack().getItem() == Items.FILLED_MAP) {
/*     */       
/*  85 */       MapItemSavedData mapData = MapItem.getSavedData(event.getItemStack(), event.getLevel());
/*  86 */       if (mapData != null)
/*  87 */         localPlayer.displayClientMessage(
/*  88 */             (Component)Component.translatable("message.legendarysurvivaloverhaul.filled_map.destination", new Object[] {
/*  89 */                 Integer.valueOf(mapData.centerX), Integer.valueOf(mapData.centerZ)
/*     */               }), true); 
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent(priority = EventPriority.HIGH)
/*     */   public static void onApplyBonemeal(BonemealEvent event) {
/*  96 */     Block plant = event.getLevel().getBlockState(event.getPos()).getBlock();
/*  97 */     LocalPlayer localPlayer = (Minecraft.getInstance()).player;
/*  98 */     if (localPlayer == null || BuiltInRegistries.BLOCK.getKey(plant) == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 103 */     if (LegendarySurvivalOverhaul.sereneSeasonsLoaded && !SereneSeasonsUtil.plantCanGrow(event.getLevel(), event.getPos(), event.getLevel().getBlockState(event.getPos())))
/*     */     {
/* 105 */       localPlayer.displayClientMessage((Component)Component.translatable("message.legendarysurvivaloverhaul.bonemeal.not_correct_season"), true);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onRightClickEmpty(PlayerInteractEvent.RightClickEmpty event) {
/* 112 */     if (shouldApplyThirst(event.getEntity()))
/*     */     {
/*     */       
/* 115 */       if (event.getHand() == InteractionHand.MAIN_HAND && event.getEntity().getMainHandItem().isEmpty()) {
/*     */         
/* 117 */         Player player = event.getEntity();
/*     */         
/* 119 */         ThirstAttachment thirstAttachment = AttachmentUtil.getThirstAttachment(player);
/* 120 */         if (!thirstAttachment.isHydrationLevelAtMax()) {
/*     */           
/* 122 */           JsonThirstBlock jsonFluidThirst = ThirstUtil.getFluidThirstLookedAt(player, (float)Math.max(3.0D, player.getAttributeValue(Attributes.BLOCK_INTERACTION_RANGE) / 2.0D));
/*     */           
/* 124 */           if (jsonFluidThirst != null && (jsonFluidThirst.hydration != 0 || jsonFluidThirst.saturation != 0.0F)) {
/*     */             
/* 126 */             CommonNeoForgeEvents.playerDrinkEffect(event.getEntity());
/* 127 */             DrinkBlockFluidMessage.sendToServer();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void preRenderGameOverlay(RenderGuiLayerEvent.Pre event) {
/* 137 */     if (event.getName().equals(VanillaGuiLayers.FOOD_LEVEL))
/*     */     {
/*     */ 
/*     */       
/* 141 */       if ((Minecraft.getInstance()).player != null && (Minecraft.getInstance()).player.hasEffect((Holder)MobEffectRegistry.COLD_HUNGER)) {
/* 142 */         event.setCanceled(true);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onRenderOverlayEventHideDebugInfo(CustomizeGuiOverlayEvent.DebugText event) {
/* 149 */     LocalPlayer localPlayer = (Minecraft.getInstance()).player;
/* 150 */     if (localPlayer == null || localPlayer.isCreative() || localPlayer.isSpectator() || !Config.Baked.hideInfoFromDebug)
/*     */       return; 
/*     */     ListIterator<String> it;
/* 153 */     for (it = event.getRight().listIterator(); it.hasNext(); ) {
/*     */       
/* 155 */       String line = it.next();
/* 156 */       if (line.contains("Targeted")) {
/*     */         
/* 158 */         line = line.split(":")[0] + ":";
/* 159 */         it.remove();
/* 160 */         it.add(line);
/*     */       } 
/*     */     } 
/*     */     
/* 164 */     for (it = event.getLeft().listIterator(); it.hasNext(); ) {
/*     */       
/* 166 */       String line = it.next();
/* 167 */       if (line.contains("XYZ:")) {
/*     */         
/* 169 */         line = Component.translatable("message.legendarysurvivaloverhaul.warning_use_compass").getString();
/* 170 */         it.remove();
/* 171 */         it.add(line);
/*     */       } 
/* 173 */       if (line.startsWith("Chunk:") || line.startsWith("Block:") || line.startsWith("Facing:")) {
/* 174 */         it.remove();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onClientTick(ClientTickEvent.Post event) {
/* 181 */     LocalPlayer localPlayer = (Minecraft.getInstance()).player;
/* 182 */     if (!Minecraft.getInstance().isPaused() && localPlayer != null) {
/*     */       
/* 184 */       if (Config.Baked.temperatureEnabled) {
/*     */         
/* 186 */         RenderTemperatureGui.updateTimer();
/* 187 */         RenderTemperatureOverlay.updateTemperatureEffect((Player)localPlayer);
/* 188 */         if (Config.Baked.coldBreathEffectThreshold != -1000.0D)
/* 189 */           TemperatureBreathEffect.tickPlay((Player)localPlayer); 
/* 190 */         if (Config.Baked.breathingSoundEnabled) {
/* 191 */           TemperatureBreathSound.tickPlay((Player)localPlayer);
/*     */         }
/*     */       } 
/* 194 */       if (Config.Baked.wetnessEnabled) {
/* 195 */         RenderWetnessGui.updateTimer();
/*     */       }
/* 197 */       if (shouldApplyThirst((Player)localPlayer) && Config.Baked.lowHydrationEffect) {
/* 198 */         RenderBlurOverlay.updateBlurIntensity((Player)localPlayer);
/*     */       }
/* 200 */       if (LegendarySurvivalOverhaul.sereneSeasonsLoaded && Config.Baked.ssSeasonCardsEnabled) {
/* 201 */         RenderSeasonCards.updateSeasonCardFading((Player)localPlayer);
/*     */       }
/* 203 */       if (Config.Baked.localizedBodyDamageEnabled) {
/*     */         
/* 205 */         RenderBodyDamageGui.updateFlashingTimer();
/*     */         
/* 207 */         if (KeyMappingRegistry.showBodyHealth.consumeClick()) {
/* 208 */           ClientHooks.openBodyHealthScreen((Player)localPlayer);
/*     */         }
/*     */       } 
/* 211 */       if (Config.Baked.thirstEnabled && Config.Baked.showDrinkPreview) {
/* 212 */         RenderThirstGui.updateTimer();
/*     */       }
/* 214 */       if (LegendarySurvivalOverhaul.curiosLoaded && ((Player)localPlayer).tickCount % 10 == 0) {
/* 215 */         CuriosUtil.isThermometerEquipped = CuriosUtil.isCurioItemEquipped((Player)localPlayer, (Item)ItemRegistry.THERMOMETER.get());
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onRenderLevelStage(RenderLevelStageEvent event) {
/* 222 */     LocalPlayer localPlayer = (Minecraft.getInstance()).player;
/* 223 */     if (localPlayer != null && event.getStage() == RenderLevelStageEvent.Stage.AFTER_WEATHER && Config.Baked.lowHydrationEffect && 
/* 224 */       shouldApplyThirst((Player)localPlayer))
/*     */     {
/* 226 */       RenderBlurOverlay.render((Player)localPlayer);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
/* 233 */     if ((event.getLevel()).isClientSide && event.getEntity() instanceof Player)
/*     */     {
/* 235 */       if (LegendarySurvivalOverhaul.sereneSeasonsLoaded) {
/* 236 */         RenderSeasonCards.init();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static boolean shouldApplyThirst(Player player) {
/* 242 */     return (Config.Baked.thirstEnabled && ThirstUtil.isThirstActive(player));
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\client\events\ClientForgeEvents.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */