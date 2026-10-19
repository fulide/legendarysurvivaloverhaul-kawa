/*    */ package sfiomn.legendarysurvivaloverhaul.common.integration.meadow;
/*    */ 
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.satisfy.meadow.core.registry.ObjectRegistry;
/*    */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MeadowUtil
/*    */ {
/*    */   public static boolean isInWoodenWaterCauldron(BlockState blockState) {
/* 13 */     return (LegendarySurvivalOverhaul.meadowLoaded && blockState.is((Block)ObjectRegistry.WOODEN_WATER_CAULDRON.get()));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\meadow\MeadowUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */