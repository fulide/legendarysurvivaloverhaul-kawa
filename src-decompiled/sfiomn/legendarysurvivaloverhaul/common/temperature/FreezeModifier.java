/*    */ package sfiomn.legendarysurvivaloverhaul.common.temperature;
/*    */ 
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.ModifierBase;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FreezeModifier
/*    */   extends ModifierBase
/*    */ {
/*    */   public float getPlayerInfluence(Player player) {
/* 19 */     if (Config.Baked.maxFreezeTemperatureModifier == 0.0D) {
/* 20 */       return 0.0F;
/*    */     }
/* 22 */     int freezeTickTimer = AttachmentUtil.getTempAttachment(player).getFreezeTickTimer();
/*    */     
/* 24 */     if (freezeTickTimer > 0)
/*    */     {
/* 26 */       return (float)Mth.lerp(Math.min(freezeTickTimer / Config.Baked.maxFreezeEffectTick, 1.0D), 0.0D, Config.Baked.maxFreezeTemperatureModifier);
/*    */     }
/*    */     
/* 29 */     return 0.0F;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\temperature\FreezeModifier.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */