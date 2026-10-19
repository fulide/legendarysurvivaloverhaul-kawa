/*    */ package sfiomn.legendarysurvivaloverhaul.common.blocks;
/*    */ 
/*    */ import com.mojang.serialization.MapCodec;
/*    */ import java.util.function.Function;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.core.particles.ParticleOptions;
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
/*    */ public class IceFernGoldBlock extends BushBlock {
/* 22 */   public static final MapCodec<IceFernGoldBlock> CODEC = simpleCodec(IceFernGoldBlock::new);
/*    */ 
/*    */   
/*    */   public IceFernGoldBlock(BlockBehaviour.Properties properties) {
/* 26 */     super(properties);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static BlockBehaviour.Properties getProperties() {
/* 32 */     return 
/* 33 */       BlockBehaviour.Properties.of()
/* 34 */       .mapColor(MapColor.PLANT)
/* 35 */       .randomTicks()
/* 36 */       .noOcclusion()
/* 37 */       .noCollission()
/* 38 */       .instabreak()
/* 39 */       .sound(SoundType.CROP)
/* 40 */       .pushReaction(PushReaction.DESTROY);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MapCodec<IceFernGoldBlock> codec() {
/* 46 */     return CODEC;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean mayPlaceOn(BlockState blockState, BlockGetter level, BlockPos pos) {
/* 52 */     return (blockState.is(Blocks.GRASS_BLOCK) || blockState.is(Blocks.DIRT) || blockState
/* 53 */       .is(Blocks.COARSE_DIRT) || blockState.is(Blocks.PODZOL) || blockState
/* 54 */       .is(Blocks.FARMLAND) || blockState.is(Blocks.SNOW_BLOCK));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @OnlyIn(Dist.CLIENT)
/*    */   public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
/* 61 */     double offsetX = ((2.0F * rand.nextFloat() - 1.0F) * 0.3F);
/* 62 */     double offsetZ = ((2.0F * rand.nextFloat() - 1.0F) * 0.3F);
/*    */     
/* 64 */     double x = pos.getX() + 0.5D + offsetX;
/* 65 */     double y = pos.getY() + 0.5D + (rand.nextFloat() * 0.05F);
/* 66 */     double z = pos.getZ() + 0.5D + offsetZ;
/*    */     
/* 68 */     if (level.getGameTime() % 3L == 0L)
/*    */     {
/* 70 */       level.addParticle((ParticleOptions)ParticleTypeRegistry.ICE_FERN_BLOSSOM.get(), x, y, z, 0.04D, 0.01D, 0.04D);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\blocks\IceFernGoldBlock.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */