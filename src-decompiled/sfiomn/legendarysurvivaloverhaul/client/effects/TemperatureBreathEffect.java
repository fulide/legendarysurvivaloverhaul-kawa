/*    */ package sfiomn.legendarysurvivaloverhaul.client.effects;
/*    */ 
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.core.Position;
/*    */ import net.minecraft.core.particles.ParticleOptions;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ import org.apache.commons.lang3.RandomUtils;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemperatureUtil;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.ParticleTypeRegistry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TemperatureBreathEffect
/*    */ {
/* 21 */   private static int delay = 200 + RandomUtils.nextInt(0, 200);
/*    */   private static int particleTicks;
/*    */   private static boolean reset;
/*    */   
/*    */   public static void tickPlay(Player player) {
/* 26 */     if (player == null || !player.isAlive() || player.isSpectator() || player.isCreative() || 
/* 27 */       !player.level().getBlockState(BlockPos.containing((Position)player.getEyePosition())).isAir()) {
/*    */       return;
/*    */     }
/*    */ 
/*    */     
/* 32 */     if (updateTempTicks-- < 0) {
/*    */       
/* 34 */       updateTempTicks = 20;
/* 35 */       temperature = TemperatureUtil.getWorldTemperature(player.level(), player.blockPosition());
/*    */     } 
/*    */     
/* 38 */     if (temperature >= Config.Baked.coldBreathEffectThreshold) {
/*    */       
/* 40 */       reset(player);
/*    */       
/*    */       return;
/*    */     } 
/* 44 */     reset = false;
/*    */     
/* 46 */     if (delay-- <= 0) {
/*    */       
/* 48 */       delay = 200 + player.getRandom().nextInt(200);
/* 49 */       particleTicks = 17;
/*    */     } 
/*    */     
/* 52 */     if (particleTicks > 0) {
/*    */       
/* 54 */       particleTicks--;
/* 55 */       Vec3 eyePosition = player.getEyePosition().subtract(0.0D, 0.2D, 0.0D);
/* 56 */       if (player.isCrouching())
/* 57 */         eyePosition = eyePosition.subtract(0.0D, 0.25D, 0.0D); 
/* 58 */       for (int i = 0; i < 3; i++) {
/*    */         
/* 60 */         Vec3 trajectory = player.getLookAngle().yRot(((player.level()).random.nextFloat() - 0.5F) * 0.1F).normalize();
/* 61 */         Vec3 origin = eyePosition.add(trajectory.scale(0.5D));
/* 62 */         player.level().addParticle((ParticleOptions)ParticleTypeRegistry.COLD_BREATH.get(), origin.x, origin.y, origin.z, trajectory.x, trajectory.y, trajectory.z);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private static int updateTempTicks;
/*    */   
/*    */   public static void reset(Player player) {
/* 70 */     if (!reset) {
/*    */       
/* 72 */       delay = 200 + player.getRandom().nextInt(200);
/* 73 */       reset = true;
/*    */     } 
/*    */   }
/*    */   
/*    */   private static float temperature;
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\client\effects\TemperatureBreathEffect.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */