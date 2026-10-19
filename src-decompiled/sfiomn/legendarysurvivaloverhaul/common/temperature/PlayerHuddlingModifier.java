/*    */ package sfiomn.legendarysurvivaloverhaul.common.temperature;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.core.Vec3i;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.ai.targeting.TargetingConditions;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.phys.AABB;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.ModifierBase;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlayerHuddlingModifier
/*    */   extends ModifierBase
/*    */ {
/*    */   public float getPlayerInfluence(Player player) {
/* 25 */     if (Config.Baked.playerHuddlingRadius == 0 || Config.Baked.playerHuddlingModifier == 0.0D) {
/* 26 */       return 0.0F;
/*    */     }
/* 28 */     Level world = player.getCommandSenderWorld();
/* 29 */     BlockPos pos = player.blockPosition();
/*    */     
/* 31 */     int huddleRadius = Config.Baked.playerHuddlingRadius;
/*    */ 
/*    */     
/* 34 */     BlockPos minPos = pos.offset(-huddleRadius, -huddleRadius, -huddleRadius);
/* 35 */     BlockPos maxPos = pos.offset(huddleRadius, huddleRadius, huddleRadius);
/*    */     
/* 37 */     AABB bounds = new AABB(Vec3.atLowerCornerOf((Vec3i)minPos), Vec3.atLowerCornerOf((Vec3i)maxPos));
/*    */ 
/*    */     
/* 40 */     List<? extends Player> players = world.getNearbyPlayers(TargetingConditions.DEFAULT, (LivingEntity)player, bounds);
/*    */     
/* 42 */     int playerCount = 0;
/*    */     
/* 44 */     for (Player p : players) {
/*    */       
/* 46 */       if (!p.isCreative() && !p.isSpectator())
/*    */       {
/* 48 */         playerCount++;
/*    */       }
/*    */     } 
/*    */     
/* 52 */     return (float)(playerCount * Config.Baked.playerHuddlingModifier);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\temperature\PlayerHuddlingModifier.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */