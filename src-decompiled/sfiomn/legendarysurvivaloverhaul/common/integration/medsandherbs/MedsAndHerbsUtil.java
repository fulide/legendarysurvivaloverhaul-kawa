/*    */ package sfiomn.legendarysurvivaloverhaul.common.integration.medsandherbs;
/*    */ 
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.effect.MobEffectInstance;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.MobEffectRegistry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MedsAndHerbsUtil
/*    */ {
/*    */   public static boolean triggerMorphineBehavior(Player player) {
/* 16 */     if (player.hasEffect((Holder)MobEffectRegistry.PAINKILLER_ADDICTION)) {
/*    */       
/* 18 */       player.displayClientMessage((Component)Component.translatable("message.legendarysurvivaloverhaul.morphine_use_under_painkiller_addiction"), true);
/*    */       
/* 20 */       return false;
/*    */     } 
/*    */     
/* 23 */     player.addEffect(new MobEffectInstance((Holder)MobEffectRegistry.PAINKILLER, Config.Baked.morphinePainkillerTickDuration, 0, false, false, true));
/* 24 */     if (Config.Baked.morphineSyringeApplyPainkillerAddiction)
/* 25 */       player.addEffect(new MobEffectInstance((Holder)MobEffectRegistry.PAINKILLER_ADDICTION, Config.Baked.painkillerAddictionDuration, 0, false, false, true)); 
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\medsandherbs\MedsAndHerbsUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */