/*    */ package sfiomn.legendarysurvivaloverhaul.common.integration.beachparty;
/*    */ 
/*    */ import javax.annotation.Nonnull;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraft.world.level.block.state.properties.Property;
/*    */ import net.satisfy.beachparty.core.block.BeachParasolBlock;
/*    */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BeachpartyUtil
/*    */ {
/*    */   public static boolean isUnderParasol(Level level, Player player, BlockPos pos) {
/* 20 */     if (LegendarySurvivalOverhaul.beachpartyLoaded) {
/*    */ 
/*    */       
/* 23 */       if (player != null && player.getVehicle() != null && player.getVehicle() instanceof net.satisfy.beachparty.core.entity.ChairEntity) {
/*    */         
/* 25 */         BlockPos blockPos = player.blockPosition().offset(0, 1, 0);
/* 26 */         BlockState blockState1 = level.getBlockState(blockPos);
/* 27 */         return blockState1.getBlock() instanceof net.satisfy.beachparty.core.block.HoodedBeachChair;
/*    */       } 
/*    */       
/* 30 */       BlockPos checkPos = pos.offset(0, 1, 0);
/* 31 */       BlockState blockState = level.getBlockState(checkPos);
/* 32 */       if (blockState.getBlock() instanceof BeachParasolBlock)
/*    */       {
/* 34 */         return blockState.hasProperty((Property)BeachParasolBlock.OPEN) ? ((Boolean)blockState.getValue((Property)BeachParasolBlock.OPEN)).booleanValue() : false;
/*    */       }
/*    */     } 
/*    */     
/* 38 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean canProvideShade(@Nonnull ResourceLocation itemRegistryName) {
/* 43 */     return (LegendarySurvivalOverhaul.beachpartyLoaded && (itemRegistryName.toString().equals("beachparty:hooded_beach_chair") || itemRegistryName.toString().equals("beachparty:beach_parasol")));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\beachparty\BeachpartyUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */