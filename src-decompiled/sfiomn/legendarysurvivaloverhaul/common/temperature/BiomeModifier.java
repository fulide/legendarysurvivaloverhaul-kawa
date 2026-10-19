/*    */ package sfiomn.legendarysurvivaloverhaul.common.temperature;
/*    */ 
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.core.Vec3i;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.biome.Biome;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.ModifierBase;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.integration.terrafirmacraft.TerraFirmaCraftUtil;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BiomeModifier
/*    */   extends ModifierBase
/*    */ {
/*    */   public float getWorldInfluence(@Nullable Player player, Level level, BlockPos pos) {
/* 23 */     if (TerraFirmaCraftUtil.shouldUseTerraFirmaCraftTemp()) {
/* 24 */       return 0.0F;
/*    */     }
/* 26 */     Vec3i[] posOffsets = { new Vec3i(0, 0, 0), new Vec3i(10, 0, 0), new Vec3i(-10, 0, 0), new Vec3i(0, 0, 10), new Vec3i(0, 0, -10), new Vec3i(7, 0, 7), new Vec3i(7, 0, -7), new Vec3i(-7, 0, 7), new Vec3i(-7, 0, -7) };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 39 */     float biomeAverage = 0.0F;
/* 40 */     float undergroundAverage = 0.0F;
/*    */     
/* 42 */     long worldTime = level.getLevelData().getDayTime() % 24000L;
/* 43 */     double drynessTimeMultiplier = 1.0D;
/* 44 */     double drynessAverageMultiplier = 1.0D;
/* 45 */     if (worldTime > 12000L && !level.dimensionType().hasCeiling() && Config.Baked.biomeDrynessMultiplier < 1.0D) {
/*    */ 
/*    */       
/* 48 */       drynessTimeMultiplier = 1.0D + Math.sin(worldTime * 2.6179938E-4D) * (1.0D - Config.Baked.biomeDrynessMultiplier);
/* 49 */       drynessAverageMultiplier = (1.0D + Config.Baked.biomeDrynessMultiplier) / 2.0D;
/*    */     } 
/*    */     
/* 52 */     for (Vec3i offset : posOffsets) {
/*    */       
/* 54 */       Biome biome = (Biome)level.getBiome(pos.offset(offset)).value();
/* 55 */       float humidity = getHumidityForBiome(level, biome);
/* 56 */       float biomeTemperature = getNormalizedTempForBiome(level, biome);
/*    */ 
/*    */       
/* 59 */       if (drynessTimeMultiplier < 1.0D && humidity < 0.2F && biomeTemperature > 0.8F) {
/*    */ 
/*    */         
/* 62 */         undergroundAverage += (float)(drynessAverageMultiplier * biomeTemperature);
/* 63 */         biomeAverage += (float)(drynessTimeMultiplier * biomeTemperature);
/*    */       } else {
/*    */         
/* 66 */         undergroundAverage += biomeTemperature;
/* 67 */         biomeAverage += biomeTemperature;
/*    */       } 
/*    */     } 
/*    */     
/* 71 */     biomeAverage /= posOffsets.length;
/* 72 */     undergroundAverage /= posOffsets.length;
/*    */     
/* 74 */     return applyUndergroundEffect(
/* 75 */         (float)(normalizeToPositiveNegative(biomeAverage) * Config.Baked.biomeTemperatureMultiplier), level, pos, 
/*    */ 
/*    */         
/* 78 */         (float)(normalizeToPositiveNegative(undergroundAverage) * Config.Baked.biomeTemperatureMultiplier * Config.Baked.undergroundBiomeTemperatureMultiplier));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\temperature\BiomeModifier.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */