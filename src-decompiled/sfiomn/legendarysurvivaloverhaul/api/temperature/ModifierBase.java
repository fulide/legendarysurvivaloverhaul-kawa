/*     */ package sfiomn.legendarysurvivaloverhaul.api.temperature;
/*     */ 
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.registries.Registries;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.biome.Biome;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureBiomeOverride;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.TemperatureDataManager;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.WorldUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ModifierBase
/*     */ {
/*     */   private static final float COLDEST_BIOME_TEMP = -0.5F;
/*     */   private static final float HOTTEST_BIOME_TEMP = 2.0F;
/*     */   
/*     */   public float getPlayerInfluence(Player player) {
/*  66 */     return 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getWorldInfluence(@Nullable Player player, Level world, BlockPos pos) {
/*  77 */     return 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getNormalizedTempForBiome(Level level, Biome biome) {
/*  88 */     ResourceLocation name = level.registryAccess().registryOrThrow(Registries.BIOME).getKey(biome);
/*  89 */     JsonTemperatureBiomeOverride biomeInfo = TemperatureDataManager.getBiome(name);
/*  90 */     if (name != null && biomeInfo != null)
/*     */     {
/*  92 */       return clampNormalizeTemperature(biomeInfo.temperature);
/*     */     }
/*     */     
/*  95 */     return clampNormalizeTemperature(biome.getBaseTemperature());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float applyUndergroundEffect(float temperature, Level level, BlockPos pos, float undergroundTemperature) {
/* 102 */     if (level.dimensionType().hasCeiling())
/*     */     {
/* 104 */       return temperature;
/*     */     }
/*     */     
/* 107 */     return Mth.lerp(WorldUtil.getUndergroundEffectAtPos(level, pos), temperature, undergroundTemperature);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getHumidityForBiome(Level level, Biome biome) {
/* 117 */     ResourceLocation name = level.registryAccess().registryOrThrow(Registries.BIOME).getKey(biome);
/*     */     
/* 119 */     JsonTemperatureBiomeOverride biomeInfo = TemperatureDataManager.getBiome(name);
/* 120 */     if (name != null && biomeInfo != null)
/*     */     {
/* 122 */       return biomeInfo.isDry ? 0.1F : 0.5F;
/*     */     }
/*     */     
/* 125 */     return biome.getModifiedClimateSettings().downfall();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected float clampNormalizeTemperature(float temp) {
/* 131 */     return (Mth.clamp(temp, -0.5F, 2.0F) - -0.5F) / 2.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float normalizeToPositiveNegative(float value) {
/* 138 */     return value * 2.0F - 1.0F;
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\temperature\ModifierBase.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */