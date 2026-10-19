/*    */ package sfiomn.legendarysurvivaloverhaul.common.effects;
/*    */ 
/*    */ import net.minecraft.world.effect.MobEffectCategory;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ 
/*    */ 
/*    */ public class ColdHungerEffect
/*    */   extends IncurableMobEffect
/*    */ {
/*    */   public ColdHungerEffect() {
/* 14 */     super(MobEffectCategory.HARMFUL, 10870382);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
/* 21 */     if (entity instanceof Player) {
/*    */ 
/*    */       
/* 24 */       int interval = 50 >> amplifier;
/* 25 */       if (interval > 0 && entity.tickCount % interval != 0) {
/* 26 */         return true;
/*    */       }
/* 28 */       ((Player)entity).causeFoodExhaustion((float)(Config.Baked.coldHungerEffectModifier * (amplifier + 1)));
/*    */     } 
/* 30 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
/* 37 */     if (duration < 0) {
/* 38 */       return true;
/*    */     }
/* 40 */     int time = 50 >> amplifier;
/* 41 */     if (time <= 0) {
/* 42 */       return true;
/*    */     }
/* 44 */     return (duration % time == 0);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\effects\ColdHungerEffect.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */