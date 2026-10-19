/*    */ package sfiomn.legendarysurvivaloverhaul.common.temperature;
/*    */ 
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.ModifierBase;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.attachments.wetness.WetnessAttachment;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*    */ import sfiomn.legendarysurvivaloverhaul.util.MathUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WetModifier
/*    */   extends ModifierBase
/*    */ {
/*    */   public float getPlayerInfluence(Player player) {
/* 21 */     if (Config.Baked.wetnessEnabled) {
/*    */       
/* 23 */       WetnessAttachment wetCap = AttachmentUtil.getWetnessAttachment(player);
/* 24 */       if (wetCap.getWetness() == 0)
/*    */       {
/*    */         
/* 27 */         return 0.0F;
/*    */       }
/*    */ 
/*    */       
/* 31 */       return (float)(Config.Baked.wetMultiplier * MathUtil.invLerp(0.0F, 400.0F, wetCap.getWetness()));
/*    */     } 
/*    */     
/* 34 */     return 0.0F;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\temperature\WetModifier.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */