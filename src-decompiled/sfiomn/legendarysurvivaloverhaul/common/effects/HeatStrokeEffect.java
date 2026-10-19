/*    */ package sfiomn.legendarysurvivaloverhaul.common.effects;
/*    */ 
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.world.effect.MobEffectCategory;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.ModDamageTypes;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.MobEffectRegistry;
/*    */ import sfiomn.legendarysurvivaloverhaul.util.DifficultyUtil;
/*    */ 
/*    */ public class HeatStrokeEffect extends IncurableMobEffect {
/*    */   public HeatStrokeEffect() {
/* 15 */     super(MobEffectCategory.HARMFUL, 16756041);
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean playerIsImmuneToHeat(Player player) {
/* 20 */     return (player.hasEffect((Holder)MobEffectRegistry.HEAT_IMMUNITY) || player.hasEffect((Holder)MobEffectRegistry.TEMPERATURE_IMMUNITY));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
/* 26 */     if (entity instanceof Player) { Player player = (Player)entity; if (!entity.hasEffect((Holder)MobEffectRegistry.HEAT_IMMUNITY)) {
/*    */ 
/*    */         
/* 29 */         int interval = 50 >> amplifier;
/* 30 */         if (interval > 0 && entity.tickCount % interval != 0) {
/* 31 */           return true;
/*    */         }
/* 33 */         if (DifficultyUtil.isModDangerous() && DifficultyUtil.healthAboveDifficulty(player) && !player.isSleeping())
/*    */         {
/* 35 */           ModDamageTypes.hyperthermia((Entity)player, 1.0F); } 
/*    */       }  }
/*    */     
/* 38 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
/* 45 */     if (duration < 0) {
/* 46 */       return true;
/*    */     }
/* 48 */     int time = 50 >> amplifier;
/* 49 */     if (time <= 0) {
/* 50 */       return true;
/*    */     }
/* 52 */     return (duration % time == 0);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\effects\HeatStrokeEffect.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */