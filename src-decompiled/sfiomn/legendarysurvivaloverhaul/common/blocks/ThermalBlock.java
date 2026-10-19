/*     */ package sfiomn.legendarysurvivaloverhaul.common.blocks;
/*     */ 
/*     */ import com.mojang.serialization.MapCodec;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Direction;
/*     */ import net.minecraft.world.Container;
/*     */ import net.minecraft.world.Containers;
/*     */ import net.minecraft.world.InteractionResult;
/*     */ import net.minecraft.world.MenuProvider;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.context.BlockPlaceContext;
/*     */ import net.minecraft.world.level.BlockGetter;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.block.BaseEntityBlock;
/*     */ import net.minecraft.world.level.block.Block;
/*     */ import net.minecraft.world.level.block.EntityBlock;
/*     */ import net.minecraft.world.level.block.RenderShape;
/*     */ import net.minecraft.world.level.block.entity.BlockEntity;
/*     */ import net.minecraft.world.level.block.state.BlockBehaviour;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.block.state.StateDefinition;
/*     */ import net.minecraft.world.level.block.state.properties.BlockStateProperties;
/*     */ import net.minecraft.world.level.block.state.properties.BooleanProperty;
/*     */ import net.minecraft.world.level.block.state.properties.DirectionProperty;
/*     */ import net.minecraft.world.level.block.state.properties.Property;
/*     */ import net.minecraft.world.phys.BlockHitResult;
/*     */ import net.minecraft.world.phys.shapes.CollisionContext;
/*     */ import net.minecraft.world.phys.shapes.VoxelShape;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.block.ThermalTypeEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.blockentities.CoolerBlockEntity;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.blockentities.HeaterBlockEntity;
/*     */ 
/*     */ public class ThermalBlock extends BaseEntityBlock implements EntityBlock {
/*  35 */   public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
/*  36 */   public static final BooleanProperty LIT = BlockStateProperties.LIT;
/*  37 */   private static final VoxelShape[] SHAPES = new VoxelShape[] {
/*     */       
/*  39 */       Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), 
/*  40 */       Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), 
/*  41 */       Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), 
/*  42 */       Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), 
/*  43 */       Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), 
/*  44 */       Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)
/*     */     };
/*     */   
/*     */   public final ThermalTypeEnum thermalType;
/*     */ 
/*     */   
/*     */   public ThermalBlock(ThermalTypeEnum thermalType, BlockBehaviour.Properties properties) {
/*  51 */     super(properties);
/*  52 */     this.thermalType = thermalType;
/*     */     
/*  54 */     registerDefaultState((BlockState)((BlockState)((BlockState)getStateDefinition().any())
/*  55 */         .setValue((Property)FACING, (Comparable)Direction.NORTH))
/*  56 */         .setValue((Property)LIT, Boolean.FALSE));
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockState getStateForPlacement(BlockPlaceContext context) {
/*  61 */     return (BlockState)defaultBlockState().setValue((Property)FACING, (Comparable)context.getHorizontalDirection());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RenderShape getRenderShape(BlockState p_49232_) {
/*  67 */     return RenderShape.MODEL;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
/*  72 */     builder.add(new Property[] { (Property)FACING, (Property)LIT });
/*     */   }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
/*  78 */     return SHAPES[((Direction)state.getValue((Property)FACING)).get3DDataValue()];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public InteractionResult useWithoutItem(@NotNull BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
/*  88 */     if (level.isClientSide)
/*     */     {
/*     */       
/*  91 */       return InteractionResult.SUCCESS;
/*     */     }
/*  93 */     interactWith(level, pos, player);
/*  94 */     return InteractionResult.CONSUME;
/*     */   }
/*     */ 
/*     */   
/*     */   private void interactWith(Level level, BlockPos pos, Player player) {
/*  99 */     BlockEntity blockEntity = level.getBlockEntity(pos);
/*     */     
/* 101 */     if (blockEntity instanceof HeaterBlockEntity) { HeaterBlockEntity be = (HeaterBlockEntity)blockEntity; if (player instanceof net.minecraft.server.level.ServerPlayer)
/*     */       
/* 103 */       { player.openMenu((MenuProvider)be, pos); return; }  }
/* 104 */      if (blockEntity instanceof CoolerBlockEntity) { CoolerBlockEntity be = (CoolerBlockEntity)blockEntity; if (player instanceof net.minecraft.server.level.ServerPlayer)
/*     */       
/* 106 */       { player.openMenu((MenuProvider)be, pos); }
/*     */       else
/*     */       
/* 109 */       { throw new IllegalStateException("Tile entity container is missing!"); }  } else { throw new IllegalStateException("Tile entity container is missing!"); }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
/* 116 */     if (!state.is(newState.getBlock())) {
/*     */       
/* 118 */       BlockEntity blockEntity = level.getBlockEntity(pos);
/* 119 */       if (blockEntity instanceof sfiomn.legendarysurvivaloverhaul.common.blockentities.AbstractThermalBlockEntity) {
/*     */         
/* 121 */         if (level instanceof net.minecraft.server.level.ServerLevel) {
/* 122 */           Containers.dropContents(level, pos, (Container)blockEntity);
/*     */         }
/* 124 */         level.updateNeighbourForOutputSignal(pos, (Block)this);
/*     */       } 
/*     */       
/* 127 */       super.onRemove(state, level, pos, newState, isMoving);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
/* 134 */     if (this.thermalType == ThermalTypeEnum.COOLING)
/*     */     {
/* 136 */       return (BlockEntity)new CoolerBlockEntity(blockPos, blockState);
/*     */     }
/*     */     
/* 139 */     return (BlockEntity)new HeaterBlockEntity(blockPos, blockState);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected MapCodec<? extends BaseEntityBlock> codec() {
/* 146 */     throw new UnsupportedOperationException("ThermalBlock does not support codec serialization");
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\blocks\ThermalBlock.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */