/*    */ package sfiomn.legendarysurvivaloverhaul.common.effects;
/*    */ 
/*    */ import net.minecraft.world.effect.MobEffect;
/*    */ import net.minecraft.world.effect.MobEffectCategory;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.attachments.thirst.ThirstAttachment;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*    */ 
/*    */ public class ThirstEffect
/*    */   extends MobEffect
/*    */ {
/*    */   public ThirstEffect() {
/* 16 */     super(MobEffectCategory.HARMFUL, 10870382);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
/* 22 */     if (entity instanceof Player) {
/*    */       
/* 24 */       ThirstAttachment thirstAttachment = AttachmentUtil.getThirstAttachment((Player)entity);
/*    */ 
/*    */       
/* 27 */       thirstAttachment.addThirstExhaustion((float)(Config.Baked.thirstEffectModifier * amplifier + 1.0D));
/*    */     } 
/* 29 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
/* 35 */     int time = 50 >> amplifier;
/* 36 */     return (time == 0 || duration % time == 0);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\effects\ThirstEffect.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */