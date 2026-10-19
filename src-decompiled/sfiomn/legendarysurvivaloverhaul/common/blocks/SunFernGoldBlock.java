/*    */ package sfiomn.legendarysurvivaloverhaul.common.blocks;
/*    */ 
/*    */ import com.mojang.serialization.MapCodec;
/*    */ import java.util.function.Function;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.core.particles.ParticleOptions;
/*    */ import net.minecraft.tags.BlockTags;
/*    */ import net.minecraft.util.RandomSource;
/*    */ import net.minecraft.world.level.BlockGetter;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.block.Blocks;
/*    */ import net.minecraft.world.level.block.BushBlock;
/*    */ import net.minecraft.world.level.block.SoundType;
/*    */ import net.minecraft.world.level.block.state.BlockBehaviour;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraft.world.level.material.MapColor;
/*    */ import net.minecraft.world.level.material.PushReaction;
/*    */ import net.neoforged.api.distmarker.Dist;
/*    */ import net.neoforged.api.distmarker.OnlyIn;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.ParticleTypeRegistry;
/*    */ 
/*    */ public class SunFernGoldBlock extends BushBlock {
/* 23 */   public static final MapCodec<SunFernGoldBlock> CODEC = simpleCodec(SunFernGoldBlock::new);
/*    */ 
/*    */ 
/*    */   
/*    */   public SunFernGoldBlock(BlockBehaviour.Properties properties) {
/* 28 */     super(properties);
/*    */   }
/*    */ 
/*    */   
/*    */   public static BlockBehaviour.Properties getProperties() {
/* 33 */     return 
/* 34 */       BlockBehaviour.Properties.of()
/* 35 */       .mapColor(MapColor.PLANT)
/* 36 */       .randomTicks()
/* 37 */       .noOcclusion()
/* 38 */       .noCollission()
/* 39 */       .instabreak()
/* 40 */       .sound(SoundType.CROP)
/* 41 */       .pushReaction(PushReaction.DESTROY);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MapCodec<SunFernGoldBlock> codec() {
/* 47 */     return CODEC;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean mayPlaceOn(BlockState blockState, BlockGetter level, BlockPos pos) {
/* 53 */     return (blockState.is(Blocks.GRASS_BLOCK) || blockState.is(Blocks.DIRT) || blockState
/* 54 */       .is(Blocks.COARSE_DIRT) || blockState.is(Blocks.PODZOL) || blockState
/* 55 */       .is(Blocks.FARMLAND) || blockState.is(BlockTags.SAND));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @OnlyIn(Dist.CLIENT)
/*    */   public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
/* 62 */     double offsetX = ((2.0F * rand.nextFloat() - 1.0F) * 0.3F);
/* 63 */     double offsetZ = ((2.0F * rand.nextFloat() - 1.0F) * 0.3F);
/*    */     
/* 65 */     double x = pos.getX() + 0.5D + offsetX;
/* 66 */     double y = pos.getY() + 0.5D + (rand.nextFloat() * 0.05F);
/* 67 */     double z = pos.getZ() + 0.5D + offsetZ;
/*    */     
/* 69 */     if (level.getGameTime() % 3L == 0L)
/* 70 */       level.addParticle((ParticleOptions)ParticleTypeRegistry.SUN_FERN_BLOSSOM.get(), x, y, z, 0.04D, 0.01D, 0.04D); 
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\blocks\SunFernGoldBlock.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */