/*     */ package sfiomn.legendarysurvivaloverhaul.client.render;
/*     */ import com.mojang.blaze3d.systems.RenderSystem;
/*     */ import java.util.Objects;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiGraphics;
/*     */ import net.minecraft.client.player.LocalPlayer;
/*     */ import net.minecraft.core.registries.BuiltInRegistries;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.network.chat.FormattedText;
/*     */ import net.minecraft.network.chat.MutableComponent;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.entity.decoration.ItemFrame;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.Items;
/*     */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.attachments.temperature.TemperatureItemAttachment;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.integration.eclipticseasons.EclipticSeasonsUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.integration.sereneseasons.SereneSeasonsUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.ItemRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.ItemUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.WorldUtil;
/*     */ 
/*     */ public class RenderTooltipFrame {
/*  30 */   public static final ResourceLocation ICONS = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "textures/gui/overlay.png");
/*     */   
/*     */   private static final int FRAME_HEIGHT = 20;
/*     */   
/*     */   private static final int FRAME_WIDTH = 122;
/*     */   private static final int LEFT_SIDE_FRAME_X_OFFSET = 0;
/*     */   private static final int LEFT_SIDE_FRAME_WIDTH = 6;
/*     */   private static final int MIDDLE_SIDE_FRAME_X_OFFSET = 4;
/*     */   private static final int RIGHT_SIDE_FRAME_WIDTH = 6;
/*     */   private static final int RIGHT_SIDE_FRAME_X_OFFSET = 116;
/*     */   private static final int MIDDLE_SIDE_FRAME_MAX_WIDTH = 114;
/*  41 */   private static Entity ENTITY_LOOKED_AT = null;
/*     */ 
/*     */   
/*     */   public static void render(Gui gui, GuiGraphics guiGraphics, float partialTicks, int width, int height) {
/*  45 */     LocalPlayer localPlayer = (Minecraft.getInstance()).player;
/*  46 */     if (localPlayer != null)
/*     */     {
/*  48 */       if (ENTITY_LOOKED_AT == null || ((Player)localPlayer).tickCount % 4 == 0)
/*     */       {
/*  50 */         ENTITY_LOOKED_AT = WorldUtil.getEntityLookedAt((Player)localPlayer, localPlayer
/*     */             
/*  52 */             .getAttributeValue(Attributes.ENTITY_INTERACTION_RANGE));
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*  57 */     if (ENTITY_LOOKED_AT instanceof ItemFrame && !((ItemFrame)ENTITY_LOOKED_AT).getItem().isEmpty()) {
/*     */       MutableComponent mutableComponent;
/*  59 */       Item itemInFrame = ((ItemFrame)ENTITY_LOOKED_AT).getItem().getItem();
/*     */       
/*  61 */       Component text = null;
/*  62 */       if (LegendarySurvivalOverhaul.sereneSeasonsLoaded && (
/*  63 */         Objects.equals(BuiltInRegistries.ITEM.getKey(itemInFrame), ResourceLocation.fromNamespaceAndPath("sereneseasons", "calendar")) || itemInFrame == ItemRegistry.SEASONAL_CALENDAR
/*  64 */         .get())) {
/*     */         
/*  66 */         text = SereneSeasonsUtil.seasonTooltip(ENTITY_LOOKED_AT.blockPosition(), ENTITY_LOOKED_AT.level());
/*  67 */       } else if (LegendarySurvivalOverhaul.eclipticSeasonsLoaded && itemInFrame == ItemRegistry.SEASONAL_CALENDAR.get()) {
/*     */         
/*  69 */         text = EclipticSeasonsUtil.seasonTooltip(ENTITY_LOOKED_AT.level());
/*  70 */       } else if (itemInFrame == ItemRegistry.THERMOMETER.get()) {
/*     */         
/*  72 */         TemperatureItemAttachment tempItemCap = AttachmentUtil.getTempItemAttachment(((ItemFrame)ENTITY_LOOKED_AT).getItem());
/*  73 */         float temperature = tempItemCap.getWorldTemperatureLevel();
/*  74 */         if (Config.Baked.renderTemperatureInFahrenheit) {
/*     */           
/*  76 */           mutableComponent = Component.literal("" + WorldUtil.toFahrenheit(temperature) + "°F");
/*     */         } else {
/*     */           
/*  79 */           mutableComponent = Component.literal("" + temperature + "°C");
/*     */         } 
/*  81 */       } else if (itemInFrame == Items.COMPASS) {
/*     */         
/*  83 */         String loc = ItemUtil.compassLocation(ENTITY_LOOKED_AT);
/*  84 */         if (!loc.isEmpty()) mutableComponent = Component.literal(loc); 
/*  85 */       } else if (itemInFrame == Items.CLOCK) {
/*     */         
/*  87 */         mutableComponent = Component.literal(WorldUtil.timeInGame(Minecraft.getInstance()));
/*     */       } 
/*     */       
/*  90 */       if (mutableComponent != null) {
/*     */         
/*  92 */         RenderSystem.enableBlend();
/*  93 */         RenderSystem.defaultBlendFunc();
/*  94 */         Minecraft.getInstance().getProfiler().push("tooltip_frame");
/*  95 */         drawTooltipInFrame(guiGraphics, width, height, (Component)mutableComponent);
/*  96 */         Minecraft.getInstance().getProfiler().pop();
/*  97 */         RenderSystem.disableBlend();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawTooltipInFrame(GuiGraphics gui, int width, int height, Component text) {
/* 104 */     int textWidth = (Minecraft.getInstance()).font.width((FormattedText)text);
/* 105 */     int white = 16777215;
/* 106 */     int left = width / 2 - textWidth / 2 - 6;
/* 107 */     int top = height / 2 + 10;
/*     */     
/* 109 */     int x = left;
/*     */ 
/*     */     
/* 112 */     gui.blit(ICONS, x, top, 0, 18, 6, 20);
/*     */ 
/*     */     
/* 115 */     int remainingTextWidth = textWidth;
/* 116 */     x = left + 6;
/* 117 */     while (remainingTextWidth > 0) {
/*     */       
/* 119 */       int renderedWidth = Math.min(remainingTextWidth, 114);
/* 120 */       gui.blit(ICONS, x, top, 4, 18, renderedWidth, 20);
/*     */       
/* 122 */       remainingTextWidth -= renderedWidth;
/* 123 */       x += renderedWidth;
/*     */     } 
/*     */     
/* 126 */     x = left + 6 + textWidth;
/*     */     
/* 128 */     gui.blit(ICONS, x, top, 116, 18, 6, 20);
/*     */     
/* 130 */     gui.drawCenteredString((Minecraft.getInstance()).font, text, width / 2, top + 10 - 4, white);
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\client\render\RenderTooltipFrame.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */