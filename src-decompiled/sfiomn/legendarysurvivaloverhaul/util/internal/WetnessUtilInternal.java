/*    */ package sfiomn.legendarysurvivaloverhaul.util.internal;
/*    */ 
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.wetness.IWetnessUtil;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.attachments.wetness.WetnessAttachment;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*    */ 
/*    */ 
/*    */ public class WetnessUtilInternal
/*    */   implements IWetnessUtil
/*    */ {
/*    */   public void addWetness(Player player, int wetness) {
/* 14 */     if (!isWetnessActive(player)) {
/*    */       return;
/*    */     }
/* 17 */     WetnessAttachment cap = AttachmentUtil.getWetnessAttachment(player);
/* 18 */     cap.addWetness(wetness);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void deactivateWetness(Player player) {
/* 24 */     if (!Config.Baked.wetnessEnabled) {
/*    */       return;
/*    */     }
/* 27 */     WetnessAttachment cap = AttachmentUtil.getWetnessAttachment(player);
/* 28 */     cap.setWetnessTickTimer(-1);
/* 29 */     cap.setDirty();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void activateWetness(Player player) {
/* 35 */     if (!Config.Baked.wetnessEnabled) {
/*    */       return;
/*    */     }
/* 38 */     WetnessAttachment cap = AttachmentUtil.getWetnessAttachment(player);
/* 39 */     if (cap.getWetnessTickTimer() == -1) {
/*    */       
/* 41 */       cap.setWetnessTickTimer(0);
/* 42 */       cap.setDirty();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isWetnessActive(Player player) {
/* 49 */     if (!Config.Baked.wetnessEnabled) {
/* 50 */       return false;
/*    */     }
/* 52 */     return (AttachmentUtil.getWetnessAttachment(player).getWetnessTickTimer() != -1);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhau\\util\internal\WetnessUtilInternal.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */