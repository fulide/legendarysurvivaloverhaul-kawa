/*    */ package sfiomn.legendarysurvivaloverhaul.common.attachments.food;
/*    */ 
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.food.IFoodAttachment;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ 
/*    */ 
/*    */ public class FoodAttachment
/*    */   implements IFoodAttachment
/*    */ {
/*    */   private Vec3 oldPos;
/*    */   private boolean wasSprinting;
/*    */   private int updateTickTimer;
/*    */   
/*    */   public FoodAttachment() {
/* 18 */     init();
/*    */   }
/*    */ 
/*    */   
/*    */   public void init() {
/* 23 */     this.oldPos = null;
/* 24 */     this.updateTickTimer = 0;
/* 25 */     this.wasSprinting = false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void tickUpdate(Player player, Level world, boolean isStart) {
/* 30 */     if (isStart)
/*    */       return; 
/* 32 */     if (this.oldPos == null) {
/* 33 */       this.oldPos = player.position();
/*    */     }
/* 35 */     this.updateTickTimer++;
/* 36 */     if (this.updateTickTimer >= 10) {
/*    */       
/* 38 */       this.updateTickTimer = 0;
/*    */ 
/*    */       
/* 41 */       if (this.oldPos.distanceTo(player.position()) > 1.0D) {
/*    */         float foodExhausted;
/*    */         
/* 44 */         if (player.isSprinting() && this.wasSprinting) {
/* 45 */           foodExhausted = (float)Config.Baked.sprintingFoodExhaustion;
/* 46 */         } else if (player.isSprinting() || this.wasSprinting) {
/* 47 */           foodExhausted = (float)((Config.Baked.sprintingFoodExhaustion + Config.Baked.baseFoodExhaustion) / 2.0D);
/*    */         } else {
/* 49 */           foodExhausted = (float)Config.Baked.baseFoodExhaustion;
/*    */         } 
/* 51 */         player.getFoodData().addExhaustion(foodExhausted);
/* 52 */         this.oldPos = player.position();
/* 53 */         this.wasSprinting = player.isSprinting();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\attachments\food\FoodAttachment.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */