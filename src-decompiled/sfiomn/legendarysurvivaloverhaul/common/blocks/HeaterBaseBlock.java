/*     */ package sfiomn.legendarysurvivaloverhaul.common.blocks;
/*     */ 
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.core.particles.ParticleTypes;
/*     */ import net.minecraft.sounds.SoundEvents;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.ItemInteractionResult;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.context.BlockPlaceContext;
/*     */ import net.minecraft.world.level.BlockGetter;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.block.Block;
/*     */ import net.minecraft.world.level.block.SoundType;
/*     */ import net.minecraft.world.level.block.entity.BlockEntityTicker;
/*     */ import net.minecraft.world.level.block.entity.BlockEntityType;
/*     */ import net.minecraft.world.level.block.state.BlockBehaviour;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.block.state.properties.BlockStateProperties;
/*     */ import net.minecraft.world.level.block.state.properties.Property;
/*     */ import net.minecraft.world.level.material.MapColor;
/*     */ import net.minecraft.world.phys.BlockHitResult;
/*     */ import net.minecraft.world.phys.shapes.CollisionContext;
/*     */ import net.minecraft.world.phys.shapes.Shapes;
/*     */ import net.minecraft.world.phys.shapes.VoxelShape;
/*     */ import net.neoforged.api.distmarker.Dist;
/*     */ import net.neoforged.api.distmarker.OnlyIn;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.block.ThermalTypeEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.blockentities.AbstractThermalBlockEntity;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.BlockEntityRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.BlockRegistry;
/*     */ 
/*     */ public class HeaterBaseBlock
/*     */   extends ThermalBlock {
/*  39 */   public static final BlockBehaviour.Properties properties = getProperties();
/*     */   
/*  41 */   private static final VoxelShape FEET = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D);
/*  42 */   private static final VoxelShape BASE = Block.box(1.0D, 6.0D, 1.0D, 15.0D, 16.0D, 15.0D);
/*     */   
/*  44 */   private static final VoxelShape XZ_AXIS_AABB = Shapes.or(FEET, BASE);
/*     */ 
/*     */   
/*     */   public HeaterBaseBlock(ThermalTypeEnum thermalType) {
/*  48 */     super(thermalType, properties);
/*     */   }
/*     */ 
/*     */   
/*     */   public static BlockBehaviour.Properties getProperties() {
/*  53 */     return 
/*  54 */       BlockBehaviour.Properties.of()
/*  55 */       .mapColor(MapColor.METAL)
/*  56 */       .sound(SoundType.METAL)
/*  57 */       .strength(3.0F, 10.0F)
/*  58 */       .noOcclusion()
/*  59 */       .lightLevel(lightLevel -> ((Boolean)lightLevel.getValue((Property)BlockStateProperties.LIT)).booleanValue() ? 13 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
/*  65 */     return XZ_AXIS_AABB;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public <T extends net.minecraft.world.level.block.entity.BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState p_153213_, BlockEntityType<T> entityType) {
/*  72 */     return level.isClientSide ? null : createTickerHelper(entityType, (BlockEntityType)BlockEntityRegistry.HEATER_BLOCK_ENTITY.get(), AbstractThermalBlockEntity::serverTick);
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
/*     */   
/*     */   public ItemInteractionResult onTopUseItem(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
/*  85 */     return useItemOn(stack, state, level, pos, player, hand, hit);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockState getStateForPlacement(BlockPlaceContext context) {
/*  93 */     Level level = context.getLevel();
/*  94 */     BlockPos topPos = context.getClickedPos().above();
/*  95 */     return (level.getBlockState(topPos).canBeReplaced(context) && level.getWorldBorder().isWithinBounds(topPos)) ? 
/*  96 */       (BlockState)defaultBlockState().setValue((Property)FACING, (Comparable)context.getHorizontalDirection()) : 
/*  97 */       null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
/* 103 */     super.onRemove(state, level, pos, newState, isMoving);
/* 104 */     if (!state.is(newState.getBlock()) && level.getBlockState(pos.above()).getBlock() instanceof HeaterTopBlock)
/*     */     {
/* 106 */       level.removeBlock(pos.above(), false);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
/* 115 */     if (level.isEmptyBlock(pos.above()))
/*     */     {
/* 117 */       level.setBlock(pos.above(), (BlockState)((HeaterTopBlock)BlockRegistry.HEATER_TOP.get()).defaultBlockState().setValue((Property)HeaterTopBlock.FACING, state.getValue((Property)FACING)), 2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @OnlyIn(Dist.CLIENT)
/*     */   public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
/* 125 */     if (((Boolean)state.getValue((Property)LIT)).booleanValue()) {
/*     */       
/* 127 */       float chance = 0.5F;
/* 128 */       float chance_flame = 0.4F;
/*     */ 
/*     */       
/* 131 */       double posX = pos.getX();
/* 132 */       double posY = pos.getY();
/* 133 */       double posZ = pos.getZ();
/*     */       
/* 135 */       if (rand.nextFloat() < chance)
/*     */       {
/* 137 */         level.playLocalSound(posX + 0.5D, posY + 0.5D, posZ + 0.5D, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
/*     */       }
/*     */       
/* 140 */       if (rand.nextFloat() < chance) {
/*     */ 
/*     */         
/* 143 */         float xr = rand.nextFloat() / 2.0F + 0.25F;
/* 144 */         float zr = rand.nextFloat() / 2.0F + 0.25F;
/*     */ 
/*     */         
/* 147 */         float xm = rand.nextFloat() / 20.0F - 0.025F;
/* 148 */         float zm = rand.nextFloat() / 20.0F - 0.025F;
/*     */ 
/*     */         
/* 151 */         float ym = rand.nextFloat() / 10.0F + 0.02F;
/*     */         
/* 153 */         level.addParticle((ParticleOptions)ParticleTypes.CAMPFIRE_COSY_SMOKE, false, posX + xr, pos.above().getY() + 0.8D, posZ + zr, xm, ym, zm);
/*     */       } 
/*     */       
/* 156 */       if (rand.nextFloat() < chance_flame) {
/*     */ 
/*     */         
/* 159 */         float zr = rand.nextFloat() / 3.0F + 0.33F;
/* 160 */         float yr = rand.nextFloat() / 6.0F + 0.5F;
/* 161 */         level.addParticle((ParticleOptions)ParticleTypes.SMOKE, false, posX + 0.05D, posY + yr, posZ + zr, 0.0D, 0.0D, 0.0D);
/* 162 */         level.addParticle((ParticleOptions)ParticleTypes.FLAME, false, posX + 0.05D, posY + yr, posZ + zr, 0.0D, 0.0D, 0.0D);
/*     */       } 
/* 164 */       if (rand.nextFloat() < chance_flame) {
/*     */ 
/*     */         
/* 167 */         float zr = rand.nextFloat() / 3.0F + 0.33F;
/* 168 */         float yr = rand.nextFloat() / 6.0F + 0.5F;
/* 169 */         level.addParticle((ParticleOptions)ParticleTypes.SMOKE, false, posX + 0.95D, posY + yr, posZ + zr, 0.0D, 0.0D, 0.0D);
/* 170 */         level.addParticle((ParticleOptions)ParticleTypes.FLAME, false, posX + 0.95D, posY + yr, posZ + zr, 0.0D, 0.0D, 0.0D);
/*     */       } 
/* 172 */       if (rand.nextFloat() < chance_flame) {
/*     */ 
/*     */         
/* 175 */         float xr = rand.nextFloat() / 3.0F + 0.33F;
/* 176 */         float yr = rand.nextFloat() / 6.0F + 0.5F;
/* 177 */         level.addParticle((ParticleOptions)ParticleTypes.SMOKE, false, posX + xr, posY + yr, posZ + 0.05D, 0.0D, 0.0D, 0.0D);
/* 178 */         level.addParticle((ParticleOptions)ParticleTypes.FLAME, false, posX + xr, posY + yr, posZ + 0.05D, 0.0D, 0.0D, 0.0D);
/*     */       } 
/* 180 */       if (rand.nextFloat() < chance_flame) {
/*     */ 
/*     */         
/* 183 */         float xr = rand.nextFloat() / 3.0F + 0.33F;
/* 184 */         float yr = rand.nextFloat() / 6.0F + 0.5F;
/* 185 */         level.addParticle((ParticleOptions)ParticleTypes.SMOKE, false, posX + xr, posY + yr, posZ + 0.95D, 0.0D, 0.0D, 0.0D);
/* 186 */         level.addParticle((ParticleOptions)ParticleTypes.FLAME, false, posX + xr, posY + yr, posZ + 0.95D, 0.0D, 0.0D, 0.0D);
/*     */       } 
/*     */     } 
/* 189 */     super.animateTick(state, level, pos, rand);
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\blocks\HeaterBaseBlock.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */