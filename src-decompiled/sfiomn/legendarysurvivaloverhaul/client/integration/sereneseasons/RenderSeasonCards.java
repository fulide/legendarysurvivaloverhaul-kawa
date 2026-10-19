/*     */ package sfiomn.legendarysurvivaloverhaul.client.integration.sereneseasons;
/*     */ 
/*     */ import com.mojang.blaze3d.systems.RenderSystem;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiGraphics;
/*     */ import net.minecraft.resources.ResourceKey;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.neoforged.api.distmarker.Dist;
/*     */ import net.neoforged.api.distmarker.OnlyIn;
/*     */ import sereneseasons.api.season.Season;
/*     */ import sereneseasons.api.season.SeasonHelper;
/*     */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.integration.sereneseasons.SereneSeasonsUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.RenderUtil;
/*     */ 
/*     */ @OnlyIn(Dist.CLIENT)
/*     */ public class RenderSeasonCards
/*     */ {
/*  24 */   private static final ResourceLocation SPRING_CARD = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "textures/cards/spring.png");
/*  25 */   private static final ResourceLocation AUTUMN_CARD = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "textures/cards/autumn.png");
/*  26 */   private static final ResourceLocation SUMMER_CARD = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "textures/cards/summer.png");
/*  27 */   private static final ResourceLocation WINTER_CARD = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "textures/cards/winter.png");
/*  28 */   private static final ResourceLocation DRY_CARD = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "textures/cards/dry.png");
/*  29 */   private static final ResourceLocation WET_CARD = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "textures/cards/wet.png");
/*     */   private static final int CARD_WIDTH = 128;
/*     */   private static final int CARD_HEIGHT = 128;
/*  32 */   private static ResourceLocation seasonCard = null;
/*  33 */   private static Season lastSeason = null;
/*  34 */   private static SereneSeasonsUtil.TropicalSeason lastTropicalSeason = null;
/*  35 */   private static ResourceKey<Level> lastDimension = null;
/*     */   private static boolean isDimensionSeasonal;
/*  37 */   private static float fadeLevel = 0.0F;
/*     */   private static boolean fadeIn;
/*  39 */   private static int delayTimer = 0;
/*  40 */   private static int cardTimer = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public static void render(Gui gui, GuiGraphics guiGraphics, float partialTicks, int width, int height) {
/*  45 */     if (LegendarySurvivalOverhaul.sereneSeasonsLoaded && Config.Baked.ssSeasonCardsEnabled && seasonCard != null) {
/*     */ 
/*     */       
/*  48 */       int x = Mth.floor(width / 2.0F - 64.0F);
/*  49 */       int y = Mth.floor(height / 4.0F - 64.0F);
/*     */ 
/*     */       
/*  52 */       RenderSystem.enableBlend();
/*  53 */       RenderSystem.defaultBlendFunc();
/*     */       
/*  55 */       Minecraft.getInstance().getProfiler().push("season_card");
/*  56 */       RenderSystem.setShaderTexture(0, seasonCard);
/*  57 */       RenderUtil.drawTexturedModelRectWithAlpha(guiGraphics
/*  58 */           .pose().last().pose(), (x + Config.Baked.seasonCardsDisplayOffsetX), (y + Config.Baked.seasonCardsDisplayOffsetY), 128, 128, 0, 0, 256, 256, fadeLevel);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  63 */       Minecraft.getInstance().getProfiler().pop();
/*     */       
/*  65 */       RenderSystem.disableBlend();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void updateSeasonCardFading(Player player) {
/*  71 */     if (player == null || !player.isAlive()) {
/*     */       return;
/*     */     }
/*  74 */     Level level = player.level();
/*  75 */     if (lastDimension == null || lastDimension != level.dimension()) {
/*     */       
/*  77 */       delayTimer = Config.Baked.seasonCardsSpawnDimensionDelayInTicks;
/*  78 */       lastDimension = level.dimension();
/*  79 */       isDimensionSeasonal = SereneSeasonsUtil.hasSeasons(level);
/*     */     } 
/*     */     
/*  82 */     if (!isDimensionSeasonal) {
/*     */       
/*  84 */       if (lastSeason != null || lastTropicalSeason != null) {
/*  85 */         reset();
/*     */       }
/*     */       return;
/*     */     } 
/*  89 */     if (delayTimer > 0) {
/*     */       
/*  91 */       delayTimer--;
/*     */       
/*     */       return;
/*     */     } 
/*  95 */     if (seasonCard == null) {
/*     */ 
/*     */ 
/*     */       
/*  99 */       SereneSeasonsUtil.SeasonType seasonType = SereneSeasonsUtil.getSeasonType(level.getBiome(player.blockPosition()));
/*     */       
/* 101 */       if (seasonType == SereneSeasonsUtil.SeasonType.NORMAL_SEASON) {
/*     */         
/* 103 */         Season currentSeason = SeasonHelper.getSeasonState(level).getSeason();
/* 104 */         if (currentSeason != lastSeason) {
/*     */           
/* 106 */           lastSeason = currentSeason;
/* 107 */           fadeIn = true;
/* 108 */           cardTimer = 0;
/* 109 */           if (currentSeason == Season.AUTUMN)
/* 110 */           { seasonCard = AUTUMN_CARD; }
/* 111 */           else if (currentSeason == Season.SPRING)
/* 112 */           { seasonCard = SPRING_CARD; }
/* 113 */           else if (currentSeason == Season.SUMMER)
/* 114 */           { seasonCard = SUMMER_CARD; }
/* 115 */           else if (currentSeason == Season.WINTER)
/* 116 */           { seasonCard = WINTER_CARD; } 
/*     */         } 
/* 118 */       } else if (seasonType == SereneSeasonsUtil.SeasonType.TROPICAL_SEASON) {
/*     */         
/* 120 */         SereneSeasonsUtil.TropicalSeason currentTropicalSeason = SereneSeasonsUtil.TropicalSeason.getTropicalSeason(SeasonHelper.getSeasonState(level).getTropicalSeason());
/* 121 */         if (currentTropicalSeason != lastTropicalSeason) {
/*     */           
/* 123 */           lastTropicalSeason = currentTropicalSeason;
/* 124 */           fadeIn = true;
/* 125 */           cardTimer = 0;
/* 126 */           if (currentTropicalSeason == SereneSeasonsUtil.TropicalSeason.DRY) {
/* 127 */             seasonCard = DRY_CARD;
/* 128 */           } else if (currentTropicalSeason == SereneSeasonsUtil.TropicalSeason.WET) {
/* 129 */             seasonCard = WET_CARD;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 134 */     if (seasonCard != null) {
/*     */       
/* 136 */       float targetFadeLevel = 0.0F;
/* 137 */       if (fadeIn) {
/* 138 */         targetFadeLevel = 1.0F;
/*     */       }
/* 140 */       if (targetFadeLevel > fadeLevel)
/*     */       {
/* 142 */         fadeLevel = Math.min(targetFadeLevel, fadeLevel + Math.round(1.0F / Config.Baked.seasonCardsFadeInInTicks * 100.0F) / 100.0F);
/*     */       }
/* 144 */       if (targetFadeLevel < fadeLevel)
/*     */       {
/* 146 */         fadeLevel = Math.max(targetFadeLevel, fadeLevel - Math.round(1.0F / Config.Baked.seasonCardsFadeOutInTicks * 100.0F) / 100.0F);
/*     */       }
/*     */       
/* 149 */       if (fadeLevel == 1.0F) {
/*     */         
/* 151 */         if (cardTimer++ >= Config.Baked.seasonCardsDisplayTimeInTicks)
/* 152 */           fadeIn = false; 
/* 153 */       } else if (fadeLevel == 0.0F) {
/*     */         
/* 155 */         seasonCard = null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void reset() {
/* 162 */     lastSeason = null;
/* 163 */     lastTropicalSeason = null;
/* 164 */     seasonCard = null;
/* 165 */     fadeLevel = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void init() {
/* 170 */     seasonCard = null;
/* 171 */     lastSeason = null;
/* 172 */     lastTropicalSeason = null;
/* 173 */     lastDimension = null;
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\client\integration\sereneseasons\RenderSeasonCards.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */