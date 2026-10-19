/*    */ package sfiomn.legendarysurvivaloverhaul.client.sounds;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.resources.sounds.SoundInstance;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.core.Position;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import org.apache.commons.lang3.RandomUtils;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemperatureEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.MobEffectRegistry;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.SoundRegistry;
/*    */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*    */ 
/*    */ 
/*    */ public class TemperatureBreathSound
/*    */ {
/* 19 */   private static int delay = 200 + RandomUtils.nextInt(0, 200);
/*    */   
/*    */   private static boolean reset;
/*    */   
/*    */   public static void tickPlay(Player player) {
/* 24 */     if (player == null || !player.isAlive() || player
/* 25 */       .isSpectator() || player.isCreative() || 
/* 26 */       !player.level().getBlockState(BlockPos.containing((Position)player.getEyePosition())).isAir()) {
/*    */       return;
/*    */     }
/*    */ 
/*    */     
/* 31 */     TemperatureEnum temperatureEnum = AttachmentUtil.getTempAttachment(player).getTemperatureEnum();
/*    */     
/* 33 */     boolean isFrostbite = (temperatureEnum == TemperatureEnum.FROSTBITE);
/* 34 */     boolean isHeatStroke = (temperatureEnum == TemperatureEnum.HEAT_STROKE);
/* 35 */     boolean hasColdImmunity = player.hasEffect((Holder)MobEffectRegistry.COLD_IMMUNITY);
/* 36 */     boolean hasHeatImmunity = player.hasEffect((Holder)MobEffectRegistry.HEAT_IMMUNITY);
/*    */     
/* 38 */     if ((isFrostbite && hasColdImmunity) || (isHeatStroke && hasHeatImmunity) || (!isFrostbite && !isHeatStroke)) {
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
/* 49 */       if (isFrostbite) {
/*    */         
/* 51 */         Minecraft.getInstance().getSoundManager().play((SoundInstance)new DynamicPositionSound((SoundEvent)SoundRegistry.SHIVERING.get(), player));
/*    */       } else {
/* 53 */         Minecraft.getInstance().getSoundManager().play((SoundInstance)new DynamicPositionSound((SoundEvent)SoundRegistry.PANTING.get(), player));
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void reset(Player player) {
/* 59 */     if (!reset) {
/*    */       
/* 61 */       delay = 200 + player.getRandom().nextInt(200);
/* 62 */       reset = true;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\client\sounds\TemperatureBreathSound.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */