/*     */ package sfiomn.legendarysurvivaloverhaul.common.blocks;
/*     */ import com.mojang.serialization.MapCodec;
/*     */ import java.util.function.Function;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Direction;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.InteractionResult;
/*     */ import net.minecraft.world.ItemInteractionResult;
/*     */ import net.minecraft.world.MenuProvider;
/*     */ import net.minecraft.world.SimpleMenuProvider;
/*     */ import net.minecraft.world.entity.player.Inventory;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.inventory.AbstractContainerMenu;
/*     */ import net.minecraft.world.inventory.ContainerLevelAccess;
/*     */ import net.minecraft.world.item.context.BlockPlaceContext;
/*     */ import net.minecraft.world.level.BlockGetter;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.block.Block;
/*     */ import net.minecraft.world.level.block.HorizontalDirectionalBlock;
/*     */ import net.minecraft.world.level.block.state.BlockBehaviour;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.block.state.StateDefinition;
/*     */ import net.minecraft.world.level.block.state.properties.Property;
/*     */ import net.minecraft.world.phys.BlockHitResult;
/*     */ import net.minecraft.world.phys.shapes.CollisionContext;
/*     */ import net.minecraft.world.phys.shapes.Shapes;
/*     */ import net.minecraft.world.phys.shapes.VoxelShape;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.containers.SewingTableContainer;
/*     */ 
/*     */ public class SewingTableBlock extends HorizontalDirectionalBlock implements MenuProvider {
/*  34 */   public static final MapCodec<SewingTableBlock> CODEC = simpleCodec(SewingTableBlock::new);
/*     */   
/*  36 */   private static final Component CONTAINER_TITLE = (Component)Component.translatable("container.legendarysurvivaloverhaul.sewing_table").withStyle(new net.minecraft.ChatFormatting[0]);
/*  37 */   private static final VoxelShape BASE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
/*  38 */   private static final VoxelShape X_TOP = Block.box(6.0D, 1.0D, 2.0D, 10.0D, 10.0D, 14.0D);
/*  39 */   private static final VoxelShape Z_TOP = Block.box(2.0D, 1.0D, 6.0D, 14.0D, 10.0D, 10.0D);
/*  40 */   private static final VoxelShape X_AABB = Shapes.or(BASE, X_TOP);
/*  41 */   private static final VoxelShape Z_AABB = Shapes.or(BASE, Z_TOP);
/*     */   
/*     */   public SewingTableBlock(BlockBehaviour.Properties properties) {
/*  44 */     super(properties);
/*  45 */     registerDefaultState((BlockState)((BlockState)getStateDefinition().any()).setValue((Property)FACING, (Comparable)Direction.NORTH));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static BlockBehaviour.Properties getProperties() {
/*  51 */     return BlockBehaviour.Properties.of()
/*  52 */       .mapColor(MapColor.WOOD)
/*  53 */       .strength(4.0F, 10.0F)
/*  54 */       .noOcclusion();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MapCodec<SewingTableBlock> codec() {
/*  60 */     return CODEC;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockState getStateForPlacement(BlockPlaceContext context) {
/*  66 */     return (BlockState)defaultBlockState().setValue((Property)FACING, (Comparable)context.getHorizontalDirection());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
/*  72 */     builder.add(new Property[] { (Property)FACING });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
/*  78 */     return (((Direction)state.getValue((Property)FACING)).getAxis() == Direction.Axis.X) ? X_AABB : Z_AABB;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
/*  88 */     if (level.isClientSide)
/*     */     {
/*  90 */       return InteractionResult.SUCCESS;
/*     */     }
/*  92 */     player.openMenu(state.getMenuProvider(level, pos));
/*  93 */     return InteractionResult.CONSUME;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
/* 106 */     return (useWithoutItem(state, level, pos, player, hit) == InteractionResult.CONSUME) ? 
/* 107 */       ItemInteractionResult.SUCCESS : 
/* 108 */       ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
/* 115 */     return (MenuProvider)new SimpleMenuProvider((windowId, inv, player) -> new SewingTableContainer(windowId, inv, ContainerLevelAccess.create(level, pos)), CONTAINER_TITLE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public Component getDisplayName() {
/* 124 */     return CONTAINER_TITLE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public AbstractContainerMenu createMenu(int windowId, Inventory playerInventory, Player player) {
/* 131 */     return (AbstractContainerMenu)new SewingTableContainer(windowId, playerInventory, 
/* 132 */         ContainerLevelAccess.create(player.level(), player.blockPosition()));
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\blocks\SewingTableBlock.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */