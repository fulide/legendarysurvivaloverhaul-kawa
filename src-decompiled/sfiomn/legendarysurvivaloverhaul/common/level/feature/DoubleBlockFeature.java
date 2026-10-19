/*    */ package sfiomn.legendarysurvivaloverhaul.common.level.feature;
/*    */ 
/*    */ import com.mojang.serialization.Codec;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ import net.minecraft.world.level.LevelReader;
/*    */ import net.minecraft.world.level.WorldGenLevel;
/*    */ import net.minecraft.world.level.block.DoublePlantBlock;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraft.world.level.levelgen.feature.Feature;
/*    */ import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
/*    */ import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
/*    */ 
/*    */ public class DoubleBlockFeature extends Feature<SimpleBlockConfiguration> {
/*    */   public DoubleBlockFeature(Codec<SimpleBlockConfiguration> codec) {
/* 16 */     super(codec);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> context) {
/* 21 */     SimpleBlockConfiguration config = (SimpleBlockConfiguration)context.config();
/* 22 */     WorldGenLevel level = context.level();
/* 23 */     BlockPos pos = context.origin();
/* 24 */     BlockState state = config.toPlace().getState(context.random(), pos);
/* 25 */     if (state.canSurvive((LevelReader)level, pos)) {
/*    */       
/* 27 */       if (!level.isEmptyBlock(pos.above()))
/*    */       {
/* 29 */         return false;
/*    */       }
/*    */       
/* 32 */       DoublePlantBlock.placeAt((LevelAccessor)level, state, pos, 2);
/*    */       
/* 34 */       return true;
/*    */     } 
/*    */     
/* 37 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\level\feature\DoubleBlockFeature.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */