/*     */ package sfiomn.legendarysurvivaloverhaul.common.items.drink;
/*     */ 
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Holder;
/*     */ import net.minecraft.core.registries.Registries;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundEvents;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.InteractionResult;
/*     */ import net.minecraft.world.InteractionResultHolder;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.context.UseOnContext;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.block.Blocks;
/*     */ import net.minecraft.world.level.block.LayeredCauldronBlock;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.block.state.properties.Property;
/*     */ import net.minecraft.world.level.gameevent.GameEvent;
/*     */ import net.minecraft.world.level.material.FluidState;
/*     */ import net.minecraft.world.phys.BlockHitResult;
/*     */ import net.minecraft.world.phys.HitResult;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonMobEffect;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonThirstBlock;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.ThirstDataManager;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.thirst.HydrationEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.thirst.ThirstUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.wetness.WetnessUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.enchantments.ModEnchantments;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.integration.crayfish.CrayfishFurnitureUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.MobEffectRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.SoundRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*     */ 
/*     */ public class CanteenItem extends DrinkItem {
/*     */   public CanteenItem(Item.Properties properties) {
/*  45 */     super(properties.stacksTo(1));
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean canDrink(ItemStack stack) {
/*  50 */     return (ThirstUtil.getCapacityTag(stack) > 0 && ThirstUtil.getHydrationEnumTag(stack) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void shrinkCapacity(ItemStack stack) {
/*  55 */     int newCapacity = ThirstUtil.getCapacityTag(stack) - 1;
/*  56 */     ThirstUtil.setCapacityTag(stack, newCapacity);
/*  57 */     if (newCapacity == 0) {
/*  58 */       ThirstUtil.removeHydrationEnumTag(stack);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxCapacity() {
/*  64 */     return Config.Baked.canteenCapacity;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxCapacity(ItemStack stack) {
/*  69 */     return getMaxCapacity();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxCapacity(ItemStack stack, Level level) {
/*  74 */     int baseCapacity = getMaxCapacity();
/*  75 */     if (level == null) return baseCapacity; 
/*  76 */     int reservoirLevel = stack.getEnchantmentLevel((Holder)level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ModEnchantments.RESERVOIR));
/*  77 */     return baseCapacity + reservoirLevel;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getUseDuration(@NotNull ItemStack stack, LivingEntity entity) {
/*  83 */     return canDrink(stack) ? 40 : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canFill(ItemStack stack, Level level) {
/*  89 */     return Config.Baked.allowOverridePurifiedWater ? (
/*  90 */       (ThirstUtil.getCapacityTag(stack) < getMaxCapacity(stack, level))) : (
/*  91 */       (ThirstUtil.getCapacityTag(stack) < getMaxCapacity(stack, level) && ThirstUtil.getHydrationEnumTag(stack) != HydrationEnum.PURIFIED));
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(ItemStack stack, Level level) {
/*  96 */     ThirstUtil.setCapacityTag(stack, Math.min(getMaxCapacity(stack, level), ThirstUtil.getCapacityTag(stack) + 1));
/*     */     
/*  98 */     boolean hasPurity = (level != null && stack.getEnchantmentLevel((Holder)level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ModEnchantments.PURITY)) > 0);
/*  99 */     ThirstUtil.setHydrationEnumTag(stack, hasPurity ? HydrationEnum.PURIFIED : HydrationEnum.NORMAL);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWater(Level level, BlockPos blockPos) {
/* 105 */     FluidState fluidState = level.getFluidState(blockPos);
/* 106 */     JsonThirstBlock thirstInfo = ThirstDataManager.getBlock(fluidState);
/* 107 */     if (thirstInfo == null) {
/* 108 */       thirstInfo = ThirstDataManager.getBlock(level.getBlockState(blockPos));
/*     */     }
/* 110 */     if (thirstInfo != null && thirstInfo.hydration == 3 && thirstInfo.saturation == 0.0F && !thirstInfo.effects.isEmpty())
/*     */     {
/* 112 */       for (JsonMobEffect jsonMobEffect : thirstInfo.effects) {
/*     */         
/* 114 */         if (jsonMobEffect.name.equalsIgnoreCase(MobEffectRegistry.THIRST.getId().toString()))
/* 115 */           return true; 
/*     */       } 
/*     */     }
/* 118 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public InteractionResult useOn(UseOnContext useOnContext) {
/* 124 */     ItemStack canteen = useOnContext.getItemInHand();
/* 125 */     Player player = useOnContext.getPlayer();
/* 126 */     Level level = useOnContext.getLevel();
/* 127 */     BlockPos clickedPos = useOnContext.getClickedPos();
/* 128 */     BlockState blockState = level.getBlockState(clickedPos);
/*     */     
/* 130 */     if (player == null) {
/* 131 */       return InteractionResult.PASS;
/*     */     }
/*     */     
/* 134 */     int currentCapacity = ThirstUtil.getCapacityTag(canteen);
/* 135 */     int maxCapacity = getMaxCapacity(canteen);
/* 136 */     boolean isFullCanteen = (currentCapacity >= maxCapacity);
/*     */ 
/*     */     
/* 139 */     if (isFullCanteen && canDrink(canteen)) {
/*     */       
/* 141 */       if (blockState.is(Blocks.CAULDRON)) {
/* 142 */         if (!level.isClientSide) {
/* 143 */           shrinkCapacity(canteen);
/* 144 */           level.setBlockAndUpdate(clickedPos, (BlockState)Blocks.WATER_CAULDRON.defaultBlockState().setValue((Property)LayeredCauldronBlock.LEVEL, Integer.valueOf(1)));
/* 145 */           level.playSound(null, clickedPos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
/* 146 */           level.gameEvent(null, (Holder)GameEvent.FLUID_PLACE, clickedPos);
/*     */         } 
/* 148 */         player.swing(InteractionHand.MAIN_HAND, true);
/* 149 */         return InteractionResult.sidedSuccess(level.isClientSide);
/*     */       } 
/*     */ 
/*     */       
/* 153 */       if (blockState.is(Blocks.WATER_CAULDRON)) {
/* 154 */         int currentLevel = ((Integer)blockState.getValue((Property)LayeredCauldronBlock.LEVEL)).intValue();
/* 155 */         if (currentLevel < 3) {
/* 156 */           if (!level.isClientSide) {
/* 157 */             shrinkCapacity(canteen);
/* 158 */             level.setBlockAndUpdate(clickedPos, (BlockState)blockState.setValue((Property)LayeredCauldronBlock.LEVEL, Integer.valueOf(currentLevel + 1)));
/* 159 */             level.playSound(null, clickedPos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
/* 160 */             level.gameEvent(null, (Holder)GameEvent.FLUID_PLACE, clickedPos);
/*     */           } 
/* 162 */           player.swing(InteractionHand.MAIN_HAND, true);
/* 163 */           return InteractionResult.sidedSuccess(level.isClientSide);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 169 */     if (LegendarySurvivalOverhaul.crayfishFurnitureLoaded) {
/* 170 */       InteractionResult result = CrayfishFurnitureUtil.tryFillCanteenFromSinkOrBasin(level, clickedPos, player, canteen);
/* 171 */       if (result.consumesAction()) {
/* 172 */         player.swing(InteractionHand.MAIN_HAND, true);
/* 173 */         return result;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 178 */     if (blockState.is(Blocks.WATER_CAULDRON) && canFill(canteen, level)) {
/* 179 */       if (!level.isClientSide) {
/* 180 */         fill(canteen, level);
/* 181 */         LayeredCauldronBlock.lowerFillLevel(blockState, level, clickedPos);
/* 182 */         level.playSound(null, clickedPos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
/* 183 */         level.gameEvent(null, (Holder)GameEvent.FLUID_PICKUP, clickedPos);
/*     */       } 
/* 185 */       player.swing(InteractionHand.MAIN_HAND, true);
/* 186 */       return InteractionResult.sidedSuccess(level.isClientSide);
/*     */     } 
/*     */ 
/*     */     
/* 190 */     if (blockState.is(Blocks.CAULDRON) && canDrink(canteen)) {
/* 191 */       if (!level.isClientSide) {
/* 192 */         shrinkCapacity(canteen);
/* 193 */         level.setBlockAndUpdate(clickedPos, (BlockState)Blocks.WATER_CAULDRON.defaultBlockState().setValue((Property)LayeredCauldronBlock.LEVEL, Integer.valueOf(1)));
/* 194 */         level.playSound(null, clickedPos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
/* 195 */         level.gameEvent(null, (Holder)GameEvent.FLUID_PLACE, clickedPos);
/*     */       } 
/* 197 */       player.swing(InteractionHand.MAIN_HAND, true);
/* 198 */       return InteractionResult.sidedSuccess(level.isClientSide);
/*     */     } 
/*     */ 
/*     */     
/* 202 */     if (blockState.is(Blocks.WATER_CAULDRON) && canDrink(canteen)) {
/* 203 */       int currentLevel = ((Integer)blockState.getValue((Property)LayeredCauldronBlock.LEVEL)).intValue();
/* 204 */       if (currentLevel < 3) {
/* 205 */         if (!level.isClientSide) {
/* 206 */           shrinkCapacity(canteen);
/* 207 */           level.setBlockAndUpdate(clickedPos, (BlockState)blockState.setValue((Property)LayeredCauldronBlock.LEVEL, Integer.valueOf(currentLevel + 1)));
/* 208 */           level.playSound(null, clickedPos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
/* 209 */           level.gameEvent(null, (Holder)GameEvent.FLUID_PLACE, clickedPos);
/*     */         } 
/* 211 */         player.swing(InteractionHand.MAIN_HAND, true);
/* 212 */         return InteractionResult.sidedSuccess(level.isClientSide);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 217 */     boolean isWater = isWater(level, clickedPos);
/* 218 */     if (canFill(canteen, level) && isWater) {
/* 219 */       player.swing(InteractionHand.MAIN_HAND, true);
/*     */ 
/*     */       
/* 222 */       level.playSound(player, player.blockPosition(), SoundEvents.BOTTLE_FILL, SoundSource.PLAYERS, 1.0F, 1.0F);
/* 223 */       fill(canteen, level);
/* 224 */       return InteractionResult.CONSUME;
/*     */     } 
/*     */     
/* 227 */     return InteractionResult.PASS;
/*     */   }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
/* 233 */     HitResult positionLookedAt = player.pick(Math.max(3.0D, player.getAttributeValue(Attributes.BLOCK_INTERACTION_RANGE) / 2.0D), 0.0F, true);
/*     */     
/* 235 */     ItemStack canteen = player.getItemInHand(hand);
/*     */ 
/*     */     
/* 238 */     boolean isWater = false;
/* 239 */     BlockPos blockPos = null;
/* 240 */     if (positionLookedAt.getType() == HitResult.Type.BLOCK) {
/* 241 */       blockPos = ((BlockHitResult)positionLookedAt).getBlockPos();
/* 242 */       isWater = isWater(level, blockPos);
/*     */     } 
/*     */ 
/*     */     
/* 246 */     if (canFill(canteen, level) && isWater) {
/* 247 */       player.swing(InteractionHand.MAIN_HAND);
/* 248 */       player.playSound(SoundEvents.BOTTLE_FILL, 1.0F, 1.0F);
/* 249 */       fill(canteen, level);
/* 250 */       return InteractionResultHolder.consume(canteen);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 257 */     if (positionLookedAt.getType() == HitResult.Type.BLOCK && blockPos != null) {
/* 258 */       BlockState blockState = level.getBlockState(blockPos);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 263 */       boolean isHandledByUseOn = (blockState.is(Blocks.CAULDRON) || blockState.is(Blocks.WATER_CAULDRON) || (LegendarySurvivalOverhaul.crayfishFurnitureLoaded && CrayfishFurnitureUtil.isSinkOrBasin(blockState)));
/*     */       
/* 265 */       if (isHandledByUseOn) {
/* 266 */         return InteractionResultHolder.pass(canteen);
/*     */       }
/*     */     } 
/*     */     
/* 270 */     if (player.isCrouching() && player.getViewXRot(1.0F) < -60.0F && canDrink(canteen) && Config.Baked.selfWateringCanteenEnabled) {
/*     */       
/* 272 */       player.playSound((SoundEvent)SoundRegistry.SELF_WATERING.get(), 1.0F, 1.0F);
/* 273 */       if (player.isOnFire())
/* 274 */         player.clearFire(); 
/* 275 */       if (Config.Baked.selfWateringCanteenWetnessIncrease > 0)
/* 276 */         WetnessUtil.addWetness(player, Config.Baked.selfWateringCanteenWetnessIncrease); 
/* 277 */       player.swing(InteractionHand.MAIN_HAND);
/* 278 */       shrinkCapacity(canteen);
/* 279 */       return InteractionResultHolder.consume(canteen);
/*     */     } 
/*     */     
/* 282 */     if (canDrink(canteen) && !AttachmentUtil.getThirstAttachment(player).isHydrationLevelAtMax()) {
/*     */       
/* 284 */       player.startUsingItem(hand);
/* 285 */       return InteractionResultHolder.consume(canteen);
/*     */     } 
/* 287 */     return InteractionResultHolder.fail(canteen);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public ItemStack finishUsingItem(@NotNull ItemStack stack, Level level, @NotNull LivingEntity entity) {
/*     */     Player player;
/* 293 */     if (!level.isClientSide && entity instanceof Player) { player = (Player)entity; }
/* 294 */     else { return stack; }
/*     */     
/* 296 */     runSecondaryEffect(player, stack);
/*     */ 
/*     */     
/* 299 */     int refreshingLevel = stack.getEnchantmentLevel((Holder)level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ModEnchantments.REFRESHING));
/* 300 */     if (refreshingLevel > 0) {
/*     */ 
/*     */       
/* 303 */       int bonusHydration = refreshingLevel;
/* 304 */       float bonusSaturation = Math.max(0, refreshingLevel - 1);
/* 305 */       ThirstUtil.takeDrink(player, bonusHydration, bonusSaturation);
/*     */     } 
/*     */     
/* 308 */     shrinkCapacity(stack);
/*     */     
/* 310 */     return stack;
/*     */   }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public String getDescriptionId(ItemStack stack) {
/* 316 */     if (ThirstUtil.getCapacityTag(stack) == 0) {
/* 317 */       return "item.legendarysurvivaloverhaul.canteen_empty";
/*     */     }
/* 319 */     if (ThirstUtil.getHydrationEnumTag(stack) == HydrationEnum.PURIFIED) {
/* 320 */       return "item.legendarysurvivaloverhaul.canteen_purified";
/*     */     }
/* 322 */     return "item.legendarysurvivaloverhaul.canteen";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBarVisible(@NotNull ItemStack stack) {
/* 328 */     return (ThirstUtil.getCapacityTag(stack) > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBarWidth(@NotNull ItemStack stack) {
/* 335 */     float max = getMaxCapacity();
/* 336 */     if (max == 0.0F) {
/* 337 */       return 0;
/*     */     }
/*     */     
/* 340 */     return Math.min(13, Math.round(ThirstUtil.getCapacityTag(stack) / max * 13.0F));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBarColor(@NotNull ItemStack stack) {
/* 347 */     float f = Math.max(0.0F, ThirstUtil.getCapacityTag(stack) / getMaxCapacity());
/* 348 */     return Mth.hsvToRgb(f / 3.0F, 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnchantable(@NotNull ItemStack stack) {
/* 354 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getEnchantmentValue() {
/* 360 */     return 10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void onPurityApplied(ItemStack stack) {
/* 368 */     if (ThirstUtil.getCapacityTag(stack) > 0 && ThirstUtil.getHydrationEnumTag(stack) == HydrationEnum.NORMAL)
/* 369 */       ThirstUtil.setHydrationEnumTag(stack, HydrationEnum.PURIFIED); 
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\items\drink\CanteenItem.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */