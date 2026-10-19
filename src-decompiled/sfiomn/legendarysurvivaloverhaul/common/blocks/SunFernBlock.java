/*     */ package sfiomn.legendarysurvivaloverhaul.common.blocks;
/*     */ 
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.tags.BlockTags;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.level.BlockGetter;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.block.Block;
/*     */ import net.minecraft.world.level.block.Blocks;
/*     */ import net.minecraft.world.level.block.CropBlock;
/*     */ import net.minecraft.world.level.block.SoundType;
/*     */ import net.minecraft.world.level.block.state.BlockBehaviour;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.block.state.StateDefinition;
/*     */ import net.minecraft.world.level.block.state.properties.BlockStateProperties;
/*     */ import net.minecraft.world.level.block.state.properties.IntegerProperty;
/*     */ import net.minecraft.world.level.block.state.properties.Property;
/*     */ import net.minecraft.world.level.material.MapColor;
/*     */ import net.minecraft.world.level.material.PushReaction;
/*     */ import net.minecraft.world.phys.shapes.CollisionContext;
/*     */ import net.minecraft.world.phys.shapes.VoxelShape;
/*     */ import net.neoforged.api.distmarker.Dist;
/*     */ import net.neoforged.api.distmarker.OnlyIn;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.BlockRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.ItemRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.ParticleTypeRegistry;
/*     */ 
/*     */ public class SunFernBlock extends CropBlock {
/*  34 */   public static final IntegerProperty AGE = BlockStateProperties.AGE_3; public static final int MAX_AGE = 3;
/*  35 */   public static final BlockBehaviour.Properties properties = getProperties();
/*  36 */   private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] {
/*  37 */       Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D), 
/*  38 */       Block.box(1.0D, 0.0D, 1.0D, 15.0D, 10.0D, 15.0D), 
/*  39 */       Block.box(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D), 
/*  40 */       Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)
/*     */     };
/*     */   
/*     */   public SunFernBlock() {
/*  44 */     super(properties);
/*     */   }
/*     */ 
/*     */   
/*     */   public static BlockBehaviour.Properties getProperties() {
/*  49 */     return 
/*  50 */       BlockBehaviour.Properties.of()
/*  51 */       .mapColor(MapColor.PLANT)
/*  52 */       .randomTicks()
/*  53 */       .noOcclusion()
/*  54 */       .noCollission()
/*  55 */       .instabreak()
/*  56 */       .sound(SoundType.CROP)
/*  57 */       .pushReaction(PushReaction.DESTROY);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void growCrops(Level level, BlockPos pos, BlockState blockState) {
/*  63 */     int previousAge = getAge(blockState);
/*  64 */     int i = getAge(blockState) + getBonemealAgeIncrease(level);
/*  65 */     int j = getMaxAge();
/*  66 */     if (i > j)
/*     */     {
/*  68 */       i = j;
/*     */     }
/*     */     
/*  71 */     if (previousAge < 3 && i == 3)
/*     */     {
/*  73 */       if (level.getRandom().nextFloat() < Config.Baked.goldFernChance) {
/*     */         
/*  75 */         level.setBlock(pos, ((SunFernGoldBlock)BlockRegistry.SUN_FERN_GOLD.get()).defaultBlockState(), 2);
/*     */         
/*     */         return;
/*     */       } 
/*     */     }
/*  80 */     level.setBlock(pos, getStateForAge(i), 2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
/*  86 */     int previousAge = getAge(state);
/*  87 */     super.randomTick(state, level, pos, random);
/*     */     
/*  89 */     if (previousAge >= 3) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  94 */     BlockState newState = level.getBlockState(pos);
/*  95 */     if (getAge(newState) == 3)
/*     */     {
/*  97 */       if (random.nextFloat() < Config.Baked.goldFernChance)
/*     */       {
/*  99 */         level.setBlock(pos, ((SunFernGoldBlock)BlockRegistry.SUN_FERN_GOLD.get()).defaultBlockState(), 2);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockReader, BlockPos blockPos) {
/* 107 */     return (blockState.is(Blocks.GRASS_BLOCK) || blockState.is(Blocks.DIRT) || blockState.is(Blocks.COARSE_DIRT) || blockState.is(Blocks.PODZOL) || blockState.is(Blocks.FARMLAND) || blockState.is(BlockTags.SAND));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getBonemealAgeIncrease(Level pLevel) {
/* 113 */     return Mth.nextInt(pLevel.random, 0, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected ItemLike getBaseSeedId() {
/* 119 */     return (ItemLike)ItemRegistry.SUN_FERN_SEEDS.get();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IntegerProperty getAgeProperty() {
/* 125 */     return AGE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxAge() {
/* 131 */     return 3;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
/* 137 */     builder.add(new Property[] { (Property)AGE });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
/* 143 */     return SHAPE_BY_AGE[getAge(state)];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @OnlyIn(Dist.CLIENT)
/*     */   public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
/* 150 */     if (getAge(state) < getMaxAge())
/*     */       return; 
/* 152 */     double offsetX = ((2.0F * rand.nextFloat() - 1.0F) * 0.3F);
/* 153 */     double offsetZ = ((2.0F * rand.nextFloat() - 1.0F) * 0.3F);
/*     */     
/* 155 */     double x = pos.getX() + 0.5D + offsetX;
/* 156 */     double y = pos.getY() + 0.5D + (rand.nextFloat() * 0.05F);
/* 157 */     double z = pos.getZ() + 0.5D + offsetZ;
/*     */     
/* 159 */     if (level.getGameTime() % 3L == 0L)
/* 160 */       level.addParticle((ParticleOptions)ParticleTypeRegistry.SUN_FERN_BLOSSOM.get(), x, y, z, 0.04D, 0.01D, 0.04D); 
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\blocks\SunFernBlock.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */