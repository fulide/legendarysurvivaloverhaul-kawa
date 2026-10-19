/*    */ package sfiomn.legendarysurvivaloverhaul.common.level.feature;
/*    */ import com.mojang.serialization.Codec;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.world.level.LevelReader;
/*    */ import net.minecraft.world.level.WorldGenLevel;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraft.world.level.levelgen.feature.Feature;
/*    */ import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
/*    */ import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.blocks.SunFernGoldBlock;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.BlockRegistry;
/*    */ 
/*    */ public class GoldFernFeature extends Feature<SimpleBlockConfiguration> {
/*    */   public GoldFernFeature(Codec<SimpleBlockConfiguration> codec) {
/* 17 */     super(codec);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> context) {
/* 23 */     SimpleBlockConfiguration config = (SimpleBlockConfiguration)context.config();
/* 24 */     WorldGenLevel level = context.level();
/* 25 */     BlockPos pos = context.origin();
/*    */     
/* 27 */     BlockState state = config.toPlace().getState(context.random(), pos);
/*    */     
/* 29 */     if (context.random().nextFloat() < Config.Baked.goldFernChance)
/*    */     {
/* 31 */       if (state.is((Block)BlockRegistry.ICE_FERN_CROP.get())) {
/*    */         
/* 33 */         state = ((IceFernGoldBlock)BlockRegistry.ICE_FERN_GOLD.get()).defaultBlockState();
/* 34 */       } else if (state.is((Block)BlockRegistry.SUN_FERN_CROP.get())) {
/*    */         
/* 36 */         state = ((SunFernGoldBlock)BlockRegistry.SUN_FERN_GOLD.get()).defaultBlockState();
/*    */       } 
/*    */     }
/*    */     
/* 40 */     if (!state.canSurvive((LevelReader)level, pos))
/*    */     {
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     level.setBlock(pos, state, 2);
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\level\feature\GoldFernFeature.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */