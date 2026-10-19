/*    */ package sfiomn.legendarysurvivaloverhaul.common.effects;
/*    */ 
/*    */ import net.minecraft.world.effect.MobEffect;
/*    */ import net.minecraft.world.effect.MobEffectCategory;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ 
/*    */ public class RecoveryEffect
/*    */   extends MobEffect
/*    */ {
/*    */   public RecoveryEffect() {
/* 13 */     super(MobEffectCategory.BENEFICIAL, 1166574);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
/* 19 */     entity.heal((float)Config.Baked.recoveryEffectHealingValue);
/* 20 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
/* 27 */     int i = 50 >> amplifier;
/* 28 */     if (i > 0)
/*    */     {
/* 30 */       return (duration % i == 0);
/*    */     }
/*    */     
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\effects\RecoveryEffect.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */