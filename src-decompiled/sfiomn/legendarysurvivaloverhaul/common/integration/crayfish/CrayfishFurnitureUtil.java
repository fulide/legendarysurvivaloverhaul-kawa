/*     */ package sfiomn.legendarysurvivaloverhaul.common.integration.crayfish;
/*     */ 
/*     */ import com.mrcrayfish.furniture.refurbished.blockentity.fluid.FluidContainer;
/*     */ import com.mrcrayfish.furniture.refurbished.blockentity.fluid.IFluidContainerBlock;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.sounds.SoundEvents;
/*     */ import net.minecraft.world.InteractionResult;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.block.entity.BlockEntity;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.material.Fluid;
/*     */ import net.minecraft.world.level.material.Fluids;
/*     */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.items.drink.CanteenItem;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CrayfishFurnitureUtil
/*     */ {
/*     */   public static InteractionResult tryFillCanteenFromSinkOrBasin(Level level, BlockPos pos, Player player, ItemStack canteen) {
/*  26 */     if (!LegendarySurvivalOverhaul.crayfishFurnitureLoaded)
/*  27 */       return InteractionResult.PASS; 
/*     */     try {
/*     */       IFluidContainerBlock fluidContainerBlock;
/*     */       CanteenItem canteenItem;
/*  31 */       BlockEntity blockEntity = level.getBlockEntity(pos);
/*  32 */       if (blockEntity == null) {
/*  33 */         return InteractionResult.PASS;
/*     */       }
/*     */ 
/*     */       
/*  37 */       boolean isKitchenSink = blockEntity instanceof com.mrcrayfish.furniture.refurbished.blockentity.KitchenSinkBlockEntity;
/*  38 */       boolean isBasin = blockEntity instanceof com.mrcrayfish.furniture.refurbished.blockentity.BasinBlockEntity;
/*     */       
/*  40 */       if (!isKitchenSink && !isBasin) {
/*  41 */         return InteractionResult.PASS;
/*     */       }
/*     */       
/*  44 */       if (blockEntity instanceof IFluidContainerBlock) { fluidContainerBlock = (IFluidContainerBlock)blockEntity; }
/*  45 */       else { return InteractionResult.PASS; }
/*     */ 
/*     */       
/*  48 */       FluidContainer container = fluidContainerBlock.getFluidContainer();
/*  49 */       if (container == null) {
/*  50 */         return InteractionResult.PASS;
/*     */       }
/*     */       
/*  53 */       long storedAmount = container.getStoredAmount();
/*     */ 
/*     */       
/*  56 */       if (container.isEmpty()) {
/*  57 */         return InteractionResult.PASS;
/*     */       }
/*     */       
/*  60 */       if (!container.getStoredFluid().isSame((Fluid)Fluids.WATER)) {
/*  61 */         return InteractionResult.PASS;
/*     */       }
/*     */       
/*  64 */       if (storedAmount <= 0L) {
/*  65 */         return InteractionResult.PASS;
/*     */       }
/*     */       
/*  68 */       Item item = canteen.getItem(); if (item instanceof CanteenItem) { canteenItem = (CanteenItem)item; }
/*  69 */       else { return InteractionResult.PASS; }
/*     */ 
/*     */       
/*  72 */       if (!canteenItem.canFill(canteen, level)) {
/*  73 */         return InteractionResult.PASS;
/*     */       }
/*     */       
/*  76 */       long bottleCapacity = FluidContainer.BOTTLE_CAPACITY;
/*     */       
/*  78 */       if (storedAmount >= bottleCapacity) {
/*  79 */         if (!level.isClientSide) {
/*  80 */           container.pull(bottleCapacity, false);
/*  81 */           canteenItem.fill(canteen, level);
/*     */         } 
/*     */         
/*  84 */         if (player instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)player;
/*  85 */           serverPlayer.playSound(SoundEvents.BOTTLE_FILL, 1.0F, 1.0F); }
/*     */ 
/*     */         
/*  88 */         return InteractionResult.sidedSuccess(level.isClientSide);
/*     */       } 
/*  90 */       LegendarySurvivalOverhaul.LOGGER.debug("Not enough fluid in container: {} < {}", Long.valueOf(storedAmount), Long.valueOf(bottleCapacity));
/*     */ 
/*     */       
/*  93 */       return InteractionResult.PASS;
/*  94 */     } catch (NoClassDefFoundError e) {
/*  95 */       LegendarySurvivalOverhaul.LOGGER.error("Crayfish Furniture classes not found - mod may not be installed", e);
/*  96 */       LegendarySurvivalOverhaul.crayfishFurnitureLoaded = false;
/*  97 */       return InteractionResult.PASS;
/*  98 */     } catch (Exception e) {
/*  99 */       LegendarySurvivalOverhaul.LOGGER.error("Error occurred while trying to fill canteen from Crayfish furniture", e);
/* 100 */       return InteractionResult.PASS;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static InteractionResult tryEmptyCanteenIntoSinkOrBasin(Level level, BlockPos pos, Player player, ItemStack canteen) {
/* 105 */     if (!LegendarySurvivalOverhaul.crayfishFurnitureLoaded) {
/* 106 */       return InteractionResult.PASS;
/*     */     }
/*     */     try {
/*     */       IFluidContainerBlock fluidContainerBlock;
/* 110 */       BlockEntity blockEntity = level.getBlockEntity(pos);
/* 111 */       if (blockEntity == null) {
/* 112 */         return InteractionResult.PASS;
/*     */       }
/*     */ 
/*     */       
/* 116 */       boolean isKitchenSink = blockEntity instanceof com.mrcrayfish.furniture.refurbished.blockentity.KitchenSinkBlockEntity;
/* 117 */       boolean isBasin = blockEntity instanceof com.mrcrayfish.furniture.refurbished.blockentity.BasinBlockEntity;
/*     */       
/* 119 */       if (!isKitchenSink && !isBasin) {
/* 120 */         return InteractionResult.PASS;
/*     */       }
/*     */       
/* 123 */       if (blockEntity instanceof IFluidContainerBlock) { fluidContainerBlock = (IFluidContainerBlock)blockEntity; }
/* 124 */       else { return InteractionResult.PASS; }
/*     */ 
/*     */       
/* 127 */       FluidContainer container = fluidContainerBlock.getFluidContainer();
/* 128 */       if (container == null) {
/* 129 */         return InteractionResult.PASS;
/*     */       }
/*     */       
/* 132 */       Item item = canteen.getItem(); if (item instanceof CanteenItem) { CanteenItem canteenItem = (CanteenItem)item; }
/* 133 */       else { return InteractionResult.PASS; }
/*     */ 
/*     */ 
/*     */       
/* 137 */       if (!CanteenItem.canDrink(canteen)) {
/* 138 */         return InteractionResult.PASS;
/*     */       }
/*     */ 
/*     */       
/* 142 */       long currentAmount = container.getStoredAmount();
/* 143 */       long maxCapacity = container.getCapacity();
/* 144 */       long bottleCapacity = FluidContainer.BOTTLE_CAPACITY;
/*     */       
/* 146 */       if (currentAmount + bottleCapacity > maxCapacity) {
/* 147 */         return InteractionResult.PASS;
/*     */       }
/*     */ 
/*     */       
/* 151 */       if (!level.isClientSide) {
/* 152 */         container.push((Fluid)Fluids.WATER, bottleCapacity, false);
/* 153 */         CanteenItem.shrinkCapacity(canteen);
/*     */       } 
/*     */       
/* 156 */       if (player instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)player;
/* 157 */         serverPlayer.playSound(SoundEvents.BOTTLE_EMPTY, 1.0F, 1.0F); }
/*     */ 
/*     */       
/* 160 */       return InteractionResult.sidedSuccess(level.isClientSide);
/*     */     }
/* 162 */     catch (NoClassDefFoundError e) {
/* 163 */       LegendarySurvivalOverhaul.LOGGER.error("Crayfish Furniture classes not found - mod may not be installed", e);
/* 164 */       LegendarySurvivalOverhaul.crayfishFurnitureLoaded = false;
/* 165 */       return InteractionResult.PASS;
/* 166 */     } catch (Exception e) {
/* 167 */       LegendarySurvivalOverhaul.LOGGER.error("Error occurred while trying to empty canteen into Crayfish furniture", e);
/* 168 */       return InteractionResult.PASS;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isSinkOrBasin(BlockState blockState) {
/* 177 */     if (!LegendarySurvivalOverhaul.crayfishFurnitureLoaded) {
/* 178 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 183 */       String blockClassName = blockState.getBlock().getClass().getName();
/* 184 */       return (blockClassName.contains("KitchenSinkBlock") || blockClassName.contains("BasinBlock"));
/* 185 */     } catch (Exception e) {
/* 186 */       return false;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\crayfish\CrayfishFurnitureUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */