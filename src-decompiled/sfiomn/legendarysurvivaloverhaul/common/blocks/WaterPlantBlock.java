/*     */ package sfiomn.legendarysurvivaloverhaul.common.blocks;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.tags.BlockTags;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.level.BlockGetter;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.LevelReader;
/*     */ import net.minecraft.world.level.block.Block;
/*     */ import net.minecraft.world.level.block.CropBlock;
/*     */ import net.minecraft.world.level.block.SoundType;
/*     */ import net.minecraft.world.level.block.state.BlockBehaviour;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.block.state.StateDefinition;
/*     */ import net.minecraft.world.level.block.state.properties.BlockStateProperties;
/*     */ import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
/*     */ import net.minecraft.world.level.block.state.properties.EnumProperty;
/*     */ import net.minecraft.world.level.block.state.properties.IntegerProperty;
/*     */ import net.minecraft.world.level.block.state.properties.Property;
/*     */ import net.minecraft.world.level.material.MapColor;
/*     */ import net.minecraft.world.level.material.PushReaction;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraft.world.phys.shapes.CollisionContext;
/*     */ import net.minecraft.world.phys.shapes.VoxelShape;
/*     */ import net.neoforged.neoforge.common.CommonHooks;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.ItemRegistry;
/*     */ 
/*     */ public class WaterPlantBlock extends CropBlock {
/*  33 */   public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
/*     */   
/*     */   public static final int MAX_AGE = 7;
/*  36 */   public static final IntegerProperty AGE = BlockStateProperties.AGE_7;
/*  37 */   public static final BlockBehaviour.Properties properties = getProperties();
/*  38 */   private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] {
/*  39 */       Block.box(4.0D, 0.0D, 4.0D, 12.0D, 6.0D, 12.0D), 
/*  40 */       Block.box(2.0D, 0.0D, 2.0D, 14.0D, 9.0D, 14.0D), 
/*  41 */       Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D), 
/*  42 */       Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), 
/*  43 */       Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), 
/*  44 */       Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D), 
/*  45 */       Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D), 
/*  46 */       Block.box(0.0D, 0.0D, 0.0D, 16.0D, 11.0D, 16.0D)
/*     */     };
/*     */   
/*     */   public WaterPlantBlock() {
/*  50 */     super(properties);
/*  51 */     registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue((Property)HALF, (Comparable)DoubleBlockHalf.LOWER));
/*     */   }
/*     */ 
/*     */   
/*     */   public static BlockBehaviour.Properties getProperties() {
/*  56 */     return 
/*  57 */       BlockBehaviour.Properties.of()
/*  58 */       .mapColor(MapColor.PLANT)
/*  59 */       .randomTicks()
/*  60 */       .noOcclusion()
/*  61 */       .noCollission()
/*  62 */       .instabreak()
/*  63 */       .sound(SoundType.CROP)
/*  64 */       .pushReaction(PushReaction.DESTROY);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void randomTick(@NotNull BlockState state, ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
/*  70 */     if (!level.isAreaLoaded(pos, 1))
/*     */       return; 
/*  72 */     if (level.getRawBrightness(pos, 0) >= 9 && !isUpperBlock(state)) {
/*     */       
/*  74 */       int age = getAge(state);
/*  75 */       if (canGrow((Level)level, state, pos)) {
/*     */         
/*  77 */         float f = getGrowthSpeed(state, (BlockGetter)level, pos);
/*  78 */         if (CommonHooks.canCropGrow((Level)level, pos, state, (random.nextInt((int)(25.0F / f) + 1) == 0))) {
/*     */           
/*  80 */           level.setBlock(pos, getStateForAge(age + 1), 2);
/*  81 */           if (getAge(state) > getMaxAge() / 2)
/*     */           {
/*  83 */             level.setBlock(pos.above(), (BlockState)getStateForAge(age + 1).setValue((Property)HALF, (Comparable)DoubleBlockHalf.UPPER), 2);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void growCrops(Level level, BlockPos pos, BlockState state) {
/*  93 */     int age = getAge(state);
/*  94 */     if (canGrow(level, state, pos)) {
/*     */       
/*  96 */       BlockPos basePos = pos;
/*  97 */       if (isUpperBlock(state))
/*     */       {
/*  99 */         basePos = pos.below();
/*     */       }
/* 101 */       age = Math.min(age + getBonemealAgeIncrease(level), getMaxAge());
/* 102 */       level.setBlock(basePos, getStateForAge(age), 2);
/* 103 */       if (age > getMaxAge() / 2)
/*     */       {
/* 105 */         level.setBlock(basePos.above(), (BlockState)getStateForAge(age).setValue((Property)HALF, (Comparable)DoubleBlockHalf.UPPER), 2);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isUpperBlock(BlockState state) {
/* 112 */     return (state.getValue((Property)HALF) == DoubleBlockHalf.UPPER);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGrow(Level level, BlockState state, BlockPos pos) {
/* 117 */     if (isUpperBlock(state) || level.isEmptyBlock(pos.above()) || level.getBlockState(pos.above()).is((Block)this))
/*     */     {
/* 119 */       return (getAge(state) < getMaxAge());
/*     */     }
/*     */     
/* 122 */     return (getAge(state) < getMaxAge() / 2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   protected ItemLike getBaseSeedId() {
/* 129 */     return (ItemLike)ItemRegistry.WATER_PLANT_SEEDS.get();
/*     */   }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public IntegerProperty getAgeProperty() {
/* 135 */     return AGE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxAge() {
/* 141 */     return 7;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
/* 147 */     builder.add(new Property[] { (Property)AGE }).add(new Property[] { (Property)HALF });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader level, @NotNull BlockPos pos) {
/* 153 */     if (state.getBlock() == this && isUpperBlock(state)) {
/*     */       
/* 155 */       BlockState stateBelow = level.getBlockState(pos.below());
/* 156 */       return ((level.getRawBrightness(pos, 0) >= 8 || level.canSeeSky(pos)) && stateBelow.getBlock() == this && getAge(stateBelow) > getMaxAge() / 2);
/*     */     } 
/* 158 */     return super.canSurvive(state, level, pos);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockReader, BlockPos blockPos) {
/* 164 */     return blockState.is(BlockTags.SAND);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
/* 170 */     Vec3 vector3d = state.getOffset(reader, pos);
/* 171 */     if (state.getValue((Property)HALF) == DoubleBlockHalf.LOWER) {
/* 172 */       return SHAPE_BY_AGE[Math.min(getAge(state), 3)].move(vector3d.x, vector3d.y, vector3d.z);
/*     */     }
/* 174 */     return SHAPE_BY_AGE[getAge(state)].move(vector3d.x, vector3d.y, vector3d.z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
/* 181 */     if (!level.isClientSide) {
/*     */       
/* 183 */       if (isUpperBlock(state))
/*     */       
/* 185 */       { if (level.getBlockState(pos.below()).is((Block)this)) level.removeBlock(pos.below(), false);  }
/* 186 */       else if (level.getBlockState(pos.above()).is((Block)this)) { level.removeBlock(pos.above(), false); }
/* 187 */        if (player.isCreative())
/*     */       {
/* 189 */         level.removeBlock(pos, false);
/*     */       }
/*     */     } 
/* 192 */     return super.playerWillDestroy(level, pos, state, player);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getBonemealAgeIncrease(Level pLevel) {
/* 198 */     return Mth.nextInt(pLevel.random, 1, 2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isValidBonemealTarget(@NotNull LevelReader level, @NotNull BlockPos pos, @NotNull BlockState state) {
/* 204 */     if (canGrow((Level)level, state, pos))
/*     */     {
/* 206 */       return (state.getBlock() == this);
/*     */     }
/* 208 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\blocks\WaterPlantBlock.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */