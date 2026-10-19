/*     */ package sfiomn.legendarysurvivaloverhaul.common.blocks;
/*     */ 
/*     */ import com.mojang.serialization.MapCodec;
/*     */ import java.util.function.Function;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Direction;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.InteractionResult;
/*     */ import net.minecraft.world.ItemInteractionResult;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.context.BlockPlaceContext;
/*     */ import net.minecraft.world.level.BlockGetter;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.block.Block;
/*     */ import net.minecraft.world.level.block.HorizontalDirectionalBlock;
/*     */ import net.minecraft.world.level.block.SoundType;
/*     */ import net.minecraft.world.level.block.state.BlockBehaviour;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.block.state.StateDefinition;
/*     */ import net.minecraft.world.level.block.state.properties.Property;
/*     */ import net.minecraft.world.level.material.MapColor;
/*     */ import net.minecraft.world.phys.BlockHitResult;
/*     */ import net.minecraft.world.phys.shapes.CollisionContext;
/*     */ import net.minecraft.world.phys.shapes.Shapes;
/*     */ import net.minecraft.world.phys.shapes.VoxelShape;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.BlockRegistry;
/*     */ 
/*     */ public class HeaterTopBlock extends HorizontalDirectionalBlock {
/*  31 */   public static final MapCodec<HeaterTopBlock> CODEC = simpleCodec(HeaterTopBlock::new);
/*  32 */   private static final VoxelShape BASE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);
/*  33 */   private static final VoxelShape TUBE = Block.box(4.0D, 2.0D, 4.0D, 12.0D, 14.0D, 12.0D);
/*  34 */   private static final VoxelShape TOP = Block.box(3.0D, 14.0D, 3.0D, 13.0D, 16.0D, 13.0D);
/*  35 */   private static final VoxelShape XZ_AXIS_AABB = Shapes.or(BASE, new VoxelShape[] { TUBE, TOP });
/*     */ 
/*     */   
/*     */   public HeaterTopBlock(BlockBehaviour.Properties properties) {
/*  39 */     super(properties);
/*  40 */     registerDefaultState((BlockState)((BlockState)getStateDefinition().any()).setValue((Property)FACING, (Comparable)Direction.NORTH));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static BlockBehaviour.Properties getProperties() {
/*  46 */     return 
/*  47 */       BlockBehaviour.Properties.of()
/*  48 */       .mapColor(MapColor.METAL)
/*  49 */       .sound(SoundType.METAL)
/*  50 */       .strength(3.0F, 10.0F)
/*  51 */       .noOcclusion();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MapCodec<HeaterTopBlock> codec() {
/*  57 */     return CODEC;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
/*  63 */     builder.add(new Property[] { (Property)FACING });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
/*  69 */     return XZ_AXIS_AABB;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
/*  79 */     BlockState bottomState = level.getBlockState(pos.below());
/*  80 */     if (bottomState.is((Block)BlockRegistry.HEATER.get())) { Block block = bottomState.getBlock(); if (block instanceof HeaterBaseBlock) { HeaterBaseBlock heater = (HeaterBaseBlock)block;
/*     */ 
/*     */         
/*  83 */         return heater.useWithoutItem(bottomState, level, pos.below(), player, hit); }
/*     */        }
/*     */     
/*  86 */     return InteractionResult.PASS;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
/*  97 */     BlockState bottomState = level.getBlockState(pos.below());
/*  98 */     if (bottomState.is((Block)BlockRegistry.HEATER.get())) { Block block = bottomState.getBlock(); if (block instanceof HeaterBaseBlock) { HeaterBaseBlock heater = (HeaterBaseBlock)block;
/*     */ 
/*     */         
/* 101 */         return heater.onTopUseItem(stack, bottomState, level, pos.below(), player, hand, hit); }
/*     */        }
/*     */     
/* 104 */     return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
/* 110 */     super.onRemove(state, level, pos, newState, isMoving);
/* 111 */     if (!state.is(newState.getBlock()) && level.getBlockState(pos.below()).getBlock() instanceof HeaterBaseBlock)
/*     */     {
/* 113 */       level.removeBlock(pos.below(), false);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockState getStateForPlacement(BlockPlaceContext context) {
/* 121 */     return (BlockState)defaultBlockState().setValue((Property)FACING, (Comparable)context.getHorizontalDirection());
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\blocks\HeaterTopBlock.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */