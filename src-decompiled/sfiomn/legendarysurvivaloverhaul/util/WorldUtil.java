/*     */ package sfiomn.legendarysurvivaloverhaul.util;
/*     */ 
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Position;
/*     */ import net.minecraft.core.Vec3i;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.entity.projectile.ProjectileUtil;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.biome.Biome;
/*     */ import net.minecraft.world.level.levelgen.Heightmap;
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import net.minecraft.world.phys.EntityHitResult;
/*     */ import net.minecraft.world.phys.HitResult;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import org.apache.commons.lang3.tuple.ImmutablePair;
/*     */ import org.apache.commons.lang3.tuple.Pair;
/*     */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemperatureUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.integration.artifacts.ArtifactsUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.integration.beachparty.BeachpartyUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.integration.eclipticseasons.EclipticSeasonsUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*     */ 
/*     */ public final class WorldUtil
/*     */ {
/*  28 */   private static Pair<BlockPos, Float> undergroundEffect = (Pair<BlockPos, Float>)new ImmutablePair(new BlockPos(0, 0, 0), Float.valueOf(0.0F));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BlockPos getSidedBlockPos(Level world, Entity entity) {
/*  36 */     if (!world.isClientSide)
/*     */     {
/*  38 */       return entity.blockPosition();
/*     */     }
/*     */     
/*  41 */     if (entity instanceof Player)
/*     */     {
/*  43 */       return BlockPos.containing((Position)entity.position().add(0.0D, 0.5D, 0.0D)); } 
/*  44 */     if (entity instanceof net.minecraft.world.entity.decoration.ItemFrame)
/*     */     {
/*  46 */       return BlockPos.containing((Position)entity.position().add(0.0D, -0.45D, 0.0D));
/*     */     }
/*     */     
/*  49 */     return entity.blockPosition();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isChunkLoaded(Level world, BlockPos pos) {
/*  55 */     if (world.isClientSide)
/*     */     {
/*  57 */       return true;
/*     */     }
/*     */     
/*  60 */     return world.getChunkSource().hasChunk(pos.getX() >> 4, pos.getZ() >> 4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isPlayerOrPosUndercover(Level level, Player player, BlockPos pos) {
/*  66 */     if (LegendarySurvivalOverhaul.beachpartyLoaded && 
/*  67 */       BeachpartyUtil.isUnderParasol(level, player, pos)) {
/*  68 */       return true;
/*     */     }
/*  70 */     if (LegendarySurvivalOverhaul.artifactsLoaded && 
/*  71 */       ArtifactsUtil.isHoldingUmbrella(player)) {
/*  72 */       return true;
/*     */     }
/*  74 */     return (!level.canSeeSky(pos) || level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, pos).getY() > pos.getY());
/*     */   }
/*     */ 
/*     */   
/*     */   public static Biome.Precipitation getPrecipitationAt(Level level, Player player, BlockPos pos) {
/*  79 */     if (isPlayerOrPosUndercover(level, player, pos)) {
/*  80 */       return Biome.Precipitation.NONE;
/*     */     }
/*  82 */     if (LegendarySurvivalOverhaul.eclipticSeasonsLoaded) {
/*  83 */       return EclipticSeasonsUtil.getPrecipitation(level, pos);
/*     */     }
/*  85 */     if (!level.isRaining()) {
/*  86 */       return Biome.Precipitation.NONE;
/*     */     }
/*  88 */     return ((Biome)level.getBiome(pos).value()).getPrecipitationAt(pos);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isRainingOrSnowingAt(Level level, BlockPos pos) {
/*  93 */     if (LegendarySurvivalOverhaul.eclipticSeasonsLoaded) {
/*  94 */       return (EclipticSeasonsUtil.getPrecipitation(level, pos) != Biome.Precipitation.NONE);
/*     */     }
/*  96 */     if (!level.isRaining())
/*     */     {
/*  98 */       return false; } 
/*  99 */     if (!level.canSeeSky(pos))
/*     */     {
/* 101 */       return false; } 
/* 102 */     return (level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, pos).getY() <= pos.getY());
/*     */   }
/*     */ 
/*     */   
/*     */   public static float calculateClientWorldEntityTemperature(Level world, Entity entity) {
/* 107 */     return TemperatureUtil.getWorldTemperature(world, getSidedBlockPos(world, entity));
/*     */   }
/*     */ 
/*     */   
/*     */   public static float toFahrenheit(float temperature) {
/* 112 */     return 32.0F + temperature * 1.8F;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getUndergroundEffectAtPos(Level level, BlockPos pos) {
/* 117 */     if (!((BlockPos)undergroundEffect.getKey()).toShortString().equals(pos.toShortString())) {
/*     */       
/* 119 */       float averageDepthUnderground = 0.0F;
/* 120 */       Vec3i[] posOffsets = { new Vec3i(0, 0, 0), new Vec3i(10, 0, 0), new Vec3i(-10, 0, 0), new Vec3i(0, 0, 10), new Vec3i(0, 0, -10), new Vec3i(7, 0, 7), new Vec3i(7, 0, -7), new Vec3i(-7, 0, 7), new Vec3i(-7, 0, -7) };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 133 */       for (Vec3i offset : posOffsets) {
/*     */         
/* 135 */         BlockPos posOffset = pos.offset(offset);
/* 136 */         int surfaceDistance = level.getHeightmapPos(Heightmap.Types.WORLD_SURFACE_WG, posOffset).getY() - posOffset.getY();
/*     */         
/* 138 */         if (surfaceDistance >= Config.Baked.undergroundEffectStartDistanceToWS)
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 143 */           if (surfaceDistance >= Config.Baked.undergroundEffectEndDistanceToWS) {
/*     */             
/* 145 */             averageDepthUnderground++;
/*     */           } else {
/*     */             
/* 148 */             averageDepthUnderground += (surfaceDistance - Config.Baked.undergroundEffectStartDistanceToWS) / (Config.Baked.undergroundEffectEndDistanceToWS - Config.Baked.undergroundEffectStartDistanceToWS);
/*     */           }  } 
/*     */       } 
/* 151 */       undergroundEffect = (Pair<BlockPos, Float>)new ImmutablePair(pos, Float.valueOf(averageDepthUnderground / posOffsets.length));
/*     */     } 
/* 153 */     return ((Float)undergroundEffect.getValue()).floatValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public static Entity getEntityLookedAt(Player player, double finalDistance) {
/* 158 */     Entity foundEntity = null;
/*     */     
/* 160 */     HitResult positionLookedAt = player.pick(finalDistance, 0.0F, false);
/* 161 */     Vec3 eyePosition = player.getEyePosition(0.0F);
/*     */     
/* 163 */     double distanceFromEye = positionLookedAt.getLocation().distanceTo(eyePosition);
/*     */     
/* 165 */     Vec3 lookVector = player.getLookAngle();
/* 166 */     Vec3 reachVector = eyePosition.add(lookVector.x * distanceFromEye, lookVector.y * distanceFromEye, lookVector.z * distanceFromEye);
/*     */     
/* 168 */     AABB expandedPlayerBound = player.getBoundingBox().expandTowards(lookVector.x * distanceFromEye, lookVector.y * distanceFromEye, lookVector.z * distanceFromEye);
/*     */     
/* 170 */     EntityHitResult entityRayTraceResult = ProjectileUtil.getEntityHitResult((Entity)player, eyePosition, reachVector, expandedPlayerBound, entity -> (!entity.isSpectator() && entity.isPickable()), distanceFromEye * distanceFromEye);
/* 171 */     if (entityRayTraceResult != null)
/*     */     {
/* 173 */       foundEntity = entityRayTraceResult.getEntity();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 208 */     return foundEntity;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String timeInGame(Minecraft mc) {
/* 213 */     int dayCount = 0;
/* 214 */     int dayTime = (mc.level != null) ? (int)mc.level.dayTime() : 0;
/* 215 */     while (dayTime > 24000) {
/*     */       
/* 217 */       dayTime -= 24000;
/* 218 */       dayCount++;
/*     */     } 
/*     */     
/* 221 */     dayTime = (dayTime + 6000) % 24000;
/*     */     
/* 223 */     String hourOfTheDay = String.format("%2s", new Object[] { Integer.valueOf(dayTime / 1000) }).replace(' ', '0');
/* 224 */     String minuteOfTheDay = String.format("%2s", new Object[] { Integer.valueOf(dayTime % 1000 * 6 / 100) }).replace(' ', '0');
/*     */     
/* 226 */     return "Day " + dayCount + ", " + hourOfTheDay + ":" + minuteOfTheDay;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Vec3i getOppositeVector(Vec3i originalVector) {
/* 231 */     return new Vec3i(-originalVector.getX(), -originalVector.getY(), -originalVector.getZ());
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhau\\util\WorldUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */