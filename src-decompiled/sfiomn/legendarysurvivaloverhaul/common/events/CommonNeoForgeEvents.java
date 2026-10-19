/*     */ package sfiomn.legendarysurvivaloverhaul.common.events;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.UUID;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.core.Holder;
/*     */ import net.minecraft.core.registries.BuiltInRegistries;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.tags.DamageTypeTags;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.InteractionResult;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.damagesource.DamageTypes;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.GameRules;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.storage.LevelData;
/*     */ import net.minecraft.world.level.storage.PrimaryLevelData;
/*     */ import net.neoforged.bus.api.EventPriority;
/*     */ import net.neoforged.bus.api.SubscribeEvent;
/*     */ import net.neoforged.fml.common.EventBusSubscriber;
/*     */ import net.neoforged.fml.loading.FMLEnvironment;
/*     */ import net.neoforged.neoforge.event.ItemAttributeModifierEvent;
/*     */ import net.neoforged.neoforge.event.OnDatapackSyncEvent;
/*     */ import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
/*     */ import net.neoforged.neoforge.event.entity.living.LivingEvent;
/*     */ import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
/*     */ import net.neoforged.neoforge.event.entity.living.LivingShieldBlockEvent;
/*     */ import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
/*     */ import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
/*     */ import net.neoforged.neoforge.event.entity.player.PlayerEvent;
/*     */ import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
/*     */ import net.neoforged.neoforge.event.level.BlockEvent;
/*     */ import net.neoforged.neoforge.event.level.LevelEvent;
/*     */ import net.neoforged.neoforge.event.level.SleepFinishedTimeEvent;
/*     */ import net.neoforged.neoforge.event.tick.PlayerTickEvent;
/*     */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.ModDamageTypes;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.BodyDamageUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.BodyPartEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.DamageDistributionEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonBodyPartResistance;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonBodyPartsDamageSource;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureResistance;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonThirstBlock;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.BodyDamageDataManager;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.health.HealthUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.temperature.AttributeModifierBase;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemperatureEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemperatureUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.thirst.ThirstUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.attachments.bodydamage.BodyDamageAttachment;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.attachments.health.HealthAttachment;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.attachments.temperature.TemperatureAttachment;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.attachments.thirst.ThirstAttachment;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.attachments.wetness.WetnessAttachment;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.integration.supplementaries.SupplementariesUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.listeners.BodyDamageHealingConsumableListener;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.listeners.BodyPartResistanceItemListener;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.listeners.TemperatureDimensionListener;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.listeners.TemperatureFuelItemListener;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.listeners.ThirstBlockListener;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*     */ import sfiomn.legendarysurvivaloverhaul.network.payloads.UpdateBodyDamagePayload;
/*     */ import sfiomn.legendarysurvivaloverhaul.network.payloads.UpdateHeartsPayload;
/*     */ import sfiomn.legendarysurvivaloverhaul.network.payloads.UpdateTemperaturesPayload;
/*     */ import sfiomn.legendarysurvivaloverhaul.network.payloads.UpdateThirstPayload;
/*     */ import sfiomn.legendarysurvivaloverhaul.network.payloads.UpdateWetnessPayload;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.MobEffectRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.SoundRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.TemperatureModifierRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.ItemUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.PlayerModelUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.internal.BodyDamageUtilInternal;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.internal.TemperatureUtilInternal;
/*     */ 
/*     */ @EventBusSubscriber(modid = "legendarysurvivaloverhaul", bus = EventBusSubscriber.Bus.GAME)
/*     */ public class CommonNeoForgeEvents {
/*  91 */   private static final Set<Player> recentlyBlockedPlayers = ConcurrentHashMap.newKeySet();
/*     */   
/*     */   @SubscribeEvent(priority = EventPriority.LOWEST)
/*     */   public static void onItemUse(PlayerInteractEvent.RightClickItem event) {
/*  95 */     Player player = event.getEntity();
/*     */     
/*  97 */     if (event.getHand() != event.getEntity().getUsedItemHand()) {
/*     */       return;
/*     */     }
/* 100 */     ItemStack usedItemStack = event.getItemStack();
/* 101 */     if (LegendarySurvivalOverhaul.supplementariesLoaded) {
/* 102 */       ItemStack itemStackInBasket = SupplementariesUtil.getSelectedItemInLunchBasket(event.getItemStack());
/* 103 */       if (itemStackInBasket != ItemStack.EMPTY)
/* 104 */         usedItemStack = itemStackInBasket; 
/*     */     } 
/* 106 */     ResourceLocation itemRegistryName = BuiltInRegistries.ITEM.getKey(usedItemStack.getItem());
/*     */     
/* 108 */     if (LegendarySurvivalOverhaul.medsandherbsLoaded && itemRegistryName != null && itemRegistryName
/* 109 */       .getNamespace().equals("meds_and_herbs")) {
/* 110 */       if (itemRegistryName.equals(ResourceLocation.fromNamespaceAndPath("meds_and_herbs", "syringe_morphine")) && 
/* 111 */         !MedsAndHerbsUtil.triggerMorphineBehavior(player)) {
/* 112 */         event.setCanceled(true);
/* 113 */         event.setCancellationResult(InteractionResult.CONSUME);
/*     */       } 
/*     */       
/* 116 */       BodyDamageUtil.applyConsumableHealing(player, usedItemStack, true);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onUseItem(LivingEntityUseItemEvent.Start event) {}
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onFinishUseItem(LivingEntityUseItemEvent.Finish event) {
/*     */     Player player;
/* 126 */     LivingEntity entity = event.getEntity();
/* 127 */     if (entity instanceof Player) { player = (Player)entity; }
/*     */     else
/*     */     { return; }
/* 130 */      ItemStack usedItemStack = event.getItem();
/* 131 */     if (LegendarySurvivalOverhaul.supplementariesLoaded) {
/* 132 */       ItemStack itemStackInBasket = SupplementariesUtil.getSelectedItemInLunchBasket(event.getItem());
/* 133 */       if (itemStackInBasket != ItemStack.EMPTY) {
/* 134 */         usedItemStack = itemStackInBasket;
/*     */       }
/*     */     } 
/* 137 */     if (!(entity.level()).isClientSide) {
/* 138 */       ResourceLocation itemRegistryName = BuiltInRegistries.ITEM.getKey(usedItemStack.getItem());
/* 139 */       TemperatureUtil.applyConsumableTemperature(player, itemRegistryName);
/*     */     } 
/*     */     
/* 142 */     if (!(entity.level()).isClientSide) {
/* 143 */       ThirstUtil.takeDrink(player, usedItemStack);
/*     */     }
/*     */     
/* 146 */     if (!(usedItemStack.getItem() instanceof sfiomn.legendarysurvivaloverhaul.common.items.heal.BodyHealingItem)) {
/* 147 */       BodyDamageUtil.applyConsumableHealing(player, usedItemStack, true);
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
/* 153 */     if (shouldApplyThirst(event.getEntity()))
/*     */     {
/* 155 */       if (event.getHand() == InteractionHand.MAIN_HAND && event.getEntity().getMainHandItem().isEmpty()) {
/*     */         
/* 157 */         Player player = event.getEntity();
/*     */         
/* 159 */         ThirstAttachment thirstAttachment = AttachmentUtil.getThirstAttachment(player);
/* 160 */         if (!thirstAttachment.isHydrationLevelAtMax()) {
/*     */           
/* 162 */           boolean hasMenu = event.getLevel().getBlockEntity(event.getHitVec().getBlockPos()) instanceof net.minecraft.world.MenuProvider;
/* 163 */           if (hasMenu) {
/*     */             return;
/*     */           }
/* 166 */           JsonThirstBlock jsonBlockThirst = ThirstUtil.getBlockThirstLookedAt(player, (float)(player.getAttributeValue(Attributes.BLOCK_INTERACTION_RANGE) / 2.0D));
/* 167 */           JsonThirstBlock jsonFluidThirst = ThirstUtil.getFluidThirstLookedAt(player, (float)(player.getAttributeValue(Attributes.BLOCK_INTERACTION_RANGE) / 2.0D));
/*     */ 
/*     */           
/* 170 */           if (jsonBlockThirst != null && (jsonBlockThirst.hydration != 0 || jsonBlockThirst.saturation != 0.0F) && !event.getEntity().isCrouching()) {
/* 171 */             if ((event.getLevel()).isClientSide) {
/* 172 */               playerDrinkEffect(event.getEntity());
/*     */             } else {
/* 174 */               ThirstUtil.takeDrink(event.getEntity(), jsonBlockThirst.hydration, jsonBlockThirst.saturation, jsonBlockThirst.effects);
/*     */             } 
/* 176 */             event.setCanceled(true);
/* 177 */             event.setCancellationResult(InteractionResult.CONSUME); return;
/*     */           } 
/* 179 */           if (jsonFluidThirst != null && (jsonFluidThirst.hydration != 0 || jsonFluidThirst.saturation != 0.0F)) {
/* 180 */             if ((event.getLevel()).isClientSide) {
/* 181 */               playerDrinkEffect(event.getEntity());
/*     */             } else {
/* 183 */               ThirstUtil.takeDrink(event.getEntity(), jsonFluidThirst.hydration, jsonFluidThirst.saturation, jsonFluidThirst.effects);
/*     */             } 
/*     */             
/*     */             return;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/* 191 */     if (Config.Baked.temperatureEnabled)
/*     */     {
/*     */       
/* 194 */       if (event.getHand() == InteractionHand.MAIN_HAND && !event.getLevel().isClientSide()) {
/*     */         
/* 196 */         Player player = event.getEntity();
/* 197 */         BlockState usedBlock = event.getLevel().getBlockState(event.getHitVec().getBlockPos());
/* 198 */         if (player != null) {
/* 199 */           TemperatureUtil.applyConsumableBlockTemperature(player, usedBlock);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onAttributeModifier(ItemAttributeModifierEvent event) {
/* 207 */     if (!Config.Baked.temperatureEnabled && !Config.Baked.localizedBodyDamageEnabled) {
/*     */       return;
/*     */     }
/* 210 */     if (FMLEnvironment.dist == Dist.CLIENT && 
/* 211 */       (Minecraft.getInstance()).level == null)
/*     */       return; 
/* 213 */     if (ItemUtil.canBeEquippedInSlot(event.getItemStack(), ItemUtil.getEquippableSlot(event.getItemStack()))) {
/*     */       
/* 215 */       if (Config.Baked.temperatureEnabled) {
/* 216 */         JsonTemperatureResistance config = new JsonTemperatureResistance();
/* 217 */         for (AttributeModifierBase attributeModifier : new AttributeModifierBase[] { (AttributeModifierBase)TemperatureModifierRegistry.ITEM_ATTRIBUTE
/* 218 */             .get(), (AttributeModifierBase)TemperatureModifierRegistry.COAT_ATTRIBUTE
/* 219 */             .get() })
/*     */         {
/* 221 */           config.add(attributeModifier.getItemAttributes(event.getItemStack()));
/*     */         }
/*     */         
/* 224 */         UUID modifierUuid = (UUID)TemperatureUtilInternal.equipmentSlotTemperatureUuid.get(ItemUtil.getEquippableSlot(event.getItemStack()));
/*     */         
/* 226 */         if (config.temperature != 0.0F) {
/* 227 */           TemperatureUtilInternal.HEATING_TEMPERATURE.addModifier(event, modifierUuid, Math.max(config.temperature, 0.0F));
/* 228 */           TemperatureUtilInternal.COOLING_TEMPERATURE.addModifier(event, modifierUuid, Math.min(config.temperature, 0.0F));
/*     */         } 
/*     */         
/* 231 */         if (config.heatResistance != 0.0F) {
/* 232 */           TemperatureUtilInternal.HEAT_RESISTANCE.addModifier(event, modifierUuid, config.heatResistance);
/*     */         }
/* 234 */         if (config.coldResistance != 0.0F) {
/* 235 */           TemperatureUtilInternal.COLD_RESISTANCE.addModifier(event, modifierUuid, config.coldResistance);
/*     */         }
/* 237 */         if (config.thermalResistance != 0.0F) {
/* 238 */           TemperatureUtilInternal.THERMAL_RESISTANCE.addModifier(event, modifierUuid, config.thermalResistance);
/*     */         }
/*     */       } 
/* 241 */       if (Config.Baked.localizedBodyDamageEnabled) {
/* 242 */         ResourceLocation itemRegistryName = BuiltInRegistries.ITEM.getKey(event.getItemStack().getItem());
/* 243 */         JsonBodyPartResistance config = BodyDamageDataManager.getBodyResistanceItem(itemRegistryName);
/*     */         
/* 245 */         if (itemRegistryName == null || config == null) {
/*     */           return;
/*     */         }
/* 248 */         UUID modifierUuid = (UUID)BodyDamageUtilInternal.equipmentSlotBodyResistanceUuid.get(ItemUtil.getEquippableSlot(event.getItemStack()));
/*     */         
/* 250 */         if (config.bodyResistance != 0.0F) {
/* 251 */           BodyDamageUtilInternal.BODY_RESISTANCE.addModifier(event, modifierUuid, config.bodyResistance);
/*     */         }
/* 253 */         if (config.headResistance != 0.0F) {
/* 254 */           BodyDamageUtilInternal.HEAD_RESISTANCE.addModifier(event, modifierUuid, config.headResistance);
/*     */         }
/* 256 */         if (config.chestResistance != 0.0F) {
/* 257 */           BodyDamageUtilInternal.CHEST_RESISTANCE.addModifier(event, modifierUuid, config.chestResistance);
/*     */         }
/* 259 */         if (config.rightArmResistance != 0.0F) {
/* 260 */           BodyDamageUtilInternal.RIGHT_ARM_RESISTANCE.addModifier(event, modifierUuid, config.rightArmResistance);
/*     */         }
/* 262 */         if (config.leftArmResistance != 0.0F) {
/* 263 */           BodyDamageUtilInternal.LEFT_ARM_RESISTANCE.addModifier(event, modifierUuid, config.leftArmResistance);
/*     */         }
/* 265 */         if (config.legsResistance != 0.0F) {
/* 266 */           BodyDamageUtilInternal.LEGS_RESISTANCE.addModifier(event, modifierUuid, config.legsResistance);
/*     */         }
/* 268 */         if (config.feetResistance != 0.0F)
/* 269 */           BodyDamageUtilInternal.FEET_RESISTANCE.addModifier(event, modifierUuid, config.feetResistance); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onJump(LivingEvent.LivingJumpEvent event) {
/* 276 */     LivingEntity entity = event.getEntity();
/* 277 */     if (entity instanceof Player && shouldApplyThirst((Player)entity) && !(entity.level()).isClientSide) {
/* 278 */       ThirstUtil.addExhaustion((Player)entity, (float)Config.Baked.onJumpHydrationExhaustion);
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onBlockBreak(BlockEvent.BreakEvent event) {
/* 284 */     Player player = event.getPlayer();
/* 285 */     if (shouldApplyThirst(player) && !(player.level()).isClientSide && event.getState().getDestroySpeed((BlockGetter)event.getLevel(), event.getPos()) > 0.0F) {
/* 286 */       ThirstUtil.addExhaustion(player, (float)Config.Baked.onBlockBreakHydrationExhaustion);
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onAttackEntity(AttackEntityEvent event) {
/* 292 */     Player player = event.getEntity();
/* 293 */     if (shouldApplyThirst(player) && !(player.level()).isClientSide) {
/* 294 */       Entity monster = event.getTarget();
/* 295 */       if (monster.isAttackable()) {
/* 296 */         ThirstUtil.addExhaustion(player, (float)Config.Baked.onAttackHydrationExhaustion);
/* 297 */         player.causeFoodExhaustion((float)Config.Baked.onAttackFoodExhaustion);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent(priority = EventPriority.LOWEST)
/*     */   public static void onEntityHurt(LivingIncomingDamageEvent event) {
/* 304 */     if (!event.getSource().is(DamageTypes.FALL) && 
/* 305 */       !event.getSource().is(DamageTypes.STARVE) && 
/* 306 */       !event.getSource().is(DamageTypes.FREEZE) && 
/* 307 */       !event.getSource().is(DamageTypes.DROWN) && 
/* 308 */       !event.getSource().is(ModDamageTypes.DEHYDRATION) && 
/* 309 */       !event.getSource().is(ModDamageTypes.HYPOTHERMIA) && 
/* 310 */       !event.getSource().is(ModDamageTypes.HYPERTHERMIA) && event.getEntity().hasEffect((Holder)MobEffectRegistry.VULNERABILITY)) {
/*     */       
/* 312 */       event.setAmount(event.getAmount() * (1.0F + 0.2F * ((MobEffectInstance)Objects.<MobEffectInstance>requireNonNull(event.getEntity().getEffect((Holder)MobEffectRegistry.VULNERABILITY))).getAmplifier() + 1.0F));
/*     */     }
/* 314 */     else if (event.getSource().is(DamageTypes.FALL) && event.getEntity().hasEffect((Holder)MobEffectRegistry.HARD_FALLING)) {
/*     */       
/* 316 */       event.setAmount(event.getAmount() * (1.0F + 0.2F * ((MobEffectInstance)Objects.<MobEffectInstance>requireNonNull(event.getEntity().getEffect((Holder)MobEffectRegistry.HARD_FALLING))).getAmplifier() + 1.0F));
/* 317 */       event.getEntity().level().playSound(null, (Entity)event.getEntity(), (SoundEvent)SoundRegistry.HARD_FALLING_HURT.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onShieldBlock(LivingShieldBlockEvent event) {
/* 323 */     if (event.getBlocked()) { LivingEntity livingEntity = event.getEntity(); if (livingEntity instanceof Player) { Player player = (Player)livingEntity;
/* 324 */         recentlyBlockedPlayers.add(player); }
/*     */        }
/*     */   
/*     */   }
/*     */   @SubscribeEvent(priority = EventPriority.LOWEST)
/*     */   public static void onEntityHurtDamage(LivingIncomingDamageEvent event) {
/*     */     Player player;
/* 331 */     if (event.getEntity() instanceof Player) {
/* 332 */       player = (Player)event.getEntity();
/*     */     } else {
/*     */       return;
/* 335 */     }  if ((player.level()).isClientSide) {
/*     */       return;
/*     */     }
/*     */     
/* 339 */     if (recentlyBlockedPlayers.remove(player)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 344 */     if (event.getAmount() <= 0.0F) {
/*     */       return;
/*     */     }
/* 347 */     if (shouldApplyHealthOverhaul(player)) {
/* 348 */       event.setAmount(HealthUtil.hurtPlayer(player, event.getAmount()));
/*     */     }
/* 350 */     if (shouldApplyLocalizedBodyDamage(player)) {
/* 351 */       float bodyPartDamageValue = event.getAmount() * (float)Config.Baked.bodyDamageMultiplier;
/* 352 */       DamageSource source = event.getSource();
/*     */       
/* 354 */       JsonBodyPartsDamageSource damageSourceBodyParts = BodyDamageDataManager.getBodyParts(source.getMsgId());
/* 355 */       List<BodyPartEnum> hitBodyParts = new ArrayList<>();
/* 356 */       if (damageSourceBodyParts != null) {
/*     */ 
/*     */         
/* 359 */         if (damageSourceBodyParts.damageDistribution != DamageDistributionEnum.NONE) {
/* 360 */           hitBodyParts.addAll(damageSourceBodyParts.getBodyParts(player));
/*     */         }
/*     */       } else {
/* 363 */         if (source.is(DamageTypeTags.IS_PROJECTILE) && source.getDirectEntity() != null) {
/* 364 */           hitBodyParts.addAll(PlayerModelUtil.getPreciseEntityImpact(source.getDirectEntity(), player));
/*     */         }
/* 366 */         else if (source.getDirectEntity() != null) {
/* 367 */           List<BodyPartEnum> possibleHitParts = PlayerModelUtil.getEntityImpact(source.getDirectEntity(), player);
/* 368 */           if (!possibleHitParts.isEmpty()) {
/* 369 */             hitBodyParts.addAll(DamageDistributionEnum.ONE_OF.getBodyParts(player, possibleHitParts));
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 374 */         if (hitBodyParts.isEmpty()) {
/* 375 */           hitBodyParts.addAll(DamageDistributionEnum.ONE_OF.getBodyParts(player, Arrays.asList(BodyPartEnum.values())));
/*     */         }
/*     */       } 
/*     */       
/* 379 */       if (!hitBodyParts.isEmpty()) {
/* 380 */         BodyDamageUtil.balancedHurtBodyParts(player, hitBodyParts, bodyPartDamageValue);
/*     */         
/* 382 */         AttachmentUtil.getBodyDamageAttachment(player).updateBrokenHearts(player);
/*     */       } 
/*     */       
/* 385 */       if (source.is(DamageTypeTags.IS_PROJECTILE) && hitBodyParts
/* 386 */         .contains(BodyPartEnum.HEAD) && Config.Baked.headCriticalShotMultiplier > 1.0D && player
/*     */         
/* 388 */         .getItemBySlot(EquipmentSlot.HEAD).isEmpty()) {
/* 389 */         event.setAmount(event.getAmount() * (float)Config.Baked.headCriticalShotMultiplier);
/* 390 */         player.level().playLocalSound(player.blockPosition(), (SoundEvent)SoundRegistry.HEADSHOT.get(), SoundSource.HOSTILE, 1.0F, 1.0F, false);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onSleepFinished(SleepFinishedTimeEvent event) {
/* 397 */     for (Player player : event.getLevel().players()) {
/* 398 */       if (player.isSleepingLongEnough()) {
/* 399 */         if (Config.Baked.localizedBodyDamageEnabled && Config.Baked.bodyHealthRatioRecoveredFromSleep > 0.0D) {
/* 400 */           for (BodyPartEnum bodyPart : BodyPartEnum.values()) {
/* 401 */             double healthRecovered = BodyDamageUtil.getMaxHealth(player, bodyPart) * Config.Baked.bodyHealthRatioRecoveredFromSleep;
/* 402 */             BodyDamageUtil.healBodyPart(player, bodyPart, (float)healthRecovered);
/*     */           } 
/*     */           
/* 405 */           AttachmentUtil.getBodyDamageAttachment(player).updateBrokenHearts(player);
/*     */         } 
/*     */         
/* 408 */         if (Config.Baked.healthRatioRecoveredFromSleep > 0.0D) {
/* 409 */           HealthUtil.updatePlayerMaxHealthAttribute(player);
/* 410 */           double healthRecovered = player.getMaxHealth() * Config.Baked.healthRatioRecoveredFromSleep;
/* 411 */           player.heal((float)healthRecovered);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onPlayerEffect(MobEffectEvent.Applicable event) {
/* 419 */     LivingEntity livingEntity = event.getEntity(); if (livingEntity instanceof Player) { Player player = (Player)livingEntity; if (!(event.getEntity().level()).isClientSide) {
/* 420 */         if (Config.Baked.healthOverhaulEnabled && event
/* 421 */           .getEffectInstance().getEffect() == MobEffects.ABSORPTION && Config.Baked.absorptionEffectOverride) {
/*     */ 
/*     */           
/* 424 */           HealthAttachment healthAttachment = AttachmentUtil.getHealthAttachment(player);
/* 425 */           healthAttachment.addShieldHealth(2.0F);
/* 426 */           event.setResult(MobEffectEvent.Applicable.Result.DO_NOT_APPLY);
/*     */         } 
/* 428 */         if (event.getEffectInstance().getEffect() == MobEffectRegistry.THIRST.get() && 
/* 429 */           CuriosUtil.isCurioItemEquipped(player, (Item)ItemRegistry.WATER_PURIFIER.get()))
/* 430 */           event.setResult(MobEffectEvent.Applicable.Result.DO_NOT_APPLY); 
/*     */       }  }
/*     */   
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
/* 437 */     if (event.isEndConquered()) {
/*     */       return;
/*     */     }
/* 440 */     Player player = event.getEntity();
/*     */     
/* 442 */     if (Config.Baked.temperatureImmunityOnDeathEnabled && Config.Baked.temperatureEnabled) {
/* 443 */       player.addEffect(new MobEffectInstance((Holder)MobEffectRegistry.TEMPERATURE_IMMUNITY, Config.Baked.temperatureImmunityOnDeathTime, 0, false, false, true));
/*     */     }
/*     */ 
/*     */     
/* 447 */     if (Config.Baked.temperatureEnabled) {
/* 448 */       TemperatureAttachment tempCap = AttachmentUtil.getTempAttachment(player);
/* 449 */       tempCap.setTemperatureLevel(TemperatureEnum.NORMAL.getValue());
/* 450 */       tempCap.setTargetTemperatureLevel(TemperatureEnum.NORMAL.getValue());
/*     */       
/* 452 */       if (player instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)player;
/* 453 */         UpdateTemperaturesPayload.sendToPlayer(serverPlayer, tempCap
/* 454 */             .writeNBT()); }
/*     */     
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 460 */     if (Config.Baked.localizedBodyDamageEnabled) {
/* 461 */       BodyDamageAttachment bodyCap = AttachmentUtil.getBodyDamageAttachment(player);
/* 462 */       for (BodyPartEnum part : BodyPartEnum.values()) {
/* 463 */         bodyCap.setBodyPartDamage(part, 0.0F);
/*     */       }
/* 465 */       bodyCap.updateBrokenHearts(player);
/* 466 */       bodyCap.setManualDirty();
/*     */       
/* 468 */       if (player instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)player;
/* 469 */         UpdateBodyDamagePayload.sendToPlayer(serverPlayer, bodyCap
/* 470 */             .writeNBT()); }
/*     */     
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 476 */     if (Config.Baked.thirstEnabled && shouldApplyThirst(player)) {
/* 477 */       ThirstAttachment thirstCap = AttachmentUtil.getThirstAttachment(player);
/* 478 */       thirstCap.init();
/* 479 */       thirstCap.setDirty();
/*     */       
/* 481 */       if (player instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)player;
/* 482 */         UpdateThirstPayload.sendToPlayer(serverPlayer, thirstCap
/* 483 */             .writeNBT()); }
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
/* 491 */     Player player = event.getEntity(); if (player instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)player;
/*     */ 
/*     */       
/* 494 */       if (Config.Baked.healthOverhaulEnabled) {
/* 495 */         HealthUtil.initializeHealthAttributes((Player)serverPlayer);
/*     */       }
/* 497 */       HealthUtil.updatePlayerMaxHealthAttribute((Player)serverPlayer);
/* 498 */       BodyDamageUtil.updatePlayerBrokenHeartAttribute((Player)serverPlayer);
/*     */ 
/*     */       
/* 501 */       if (Config.Baked.temperatureEnabled) {
/* 502 */         TemperatureAttachment tempCap = AttachmentUtil.getTempAttachment((Player)serverPlayer);
/* 503 */         UpdateTemperaturesPayload.sendToPlayer(serverPlayer, tempCap
/* 504 */             .writeNBT());
/*     */       } 
/*     */       
/* 507 */       if (Config.Baked.thirstEnabled) {
/* 508 */         ThirstAttachment thirstCap = AttachmentUtil.getThirstAttachment((Player)serverPlayer);
/* 509 */         UpdateThirstPayload.sendToPlayer(serverPlayer, thirstCap
/* 510 */             .writeNBT());
/*     */       } 
/*     */       
/* 513 */       if (Config.Baked.wetnessEnabled) {
/* 514 */         WetnessAttachment wetnessCap = AttachmentUtil.getWetnessAttachment((Player)serverPlayer);
/* 515 */         UpdateWetnessPayload.sendToPlayer(serverPlayer, wetnessCap
/* 516 */             .writeNBT());
/*     */       } 
/*     */       
/* 519 */       if (Config.Baked.localizedBodyDamageEnabled) {
/* 520 */         BodyDamageAttachment bodyCap = AttachmentUtil.getBodyDamageAttachment((Player)serverPlayer);
/* 521 */         UpdateBodyDamagePayload.sendToPlayer(serverPlayer, bodyCap
/* 522 */             .writeNBT());
/*     */       }  }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
/* 530 */     if (Config.Baked.temperatureImmunityOnFirstSpawnEnabled && Config.Baked.temperatureEnabled && !event.getEntity().getPersistentData().getBoolean("tempImmuneOnSpawn")) {
/* 531 */       event.getEntity().getPersistentData().putBoolean("tempImmuneOnSpawn", true);
/* 532 */       event.getEntity().addEffect(new MobEffectInstance((Holder)MobEffectRegistry.TEMPERATURE_IMMUNITY, Config.Baked.temperatureImmunityOnFirstSpawnTime, 0, false, false, true));
/*     */     } 
/*     */     
/* 535 */     if (Config.Baked.healthOverhaulEnabled) {
/* 536 */       HealthUtil.initializeHealthAttributes(event.getEntity());
/*     */     }
/*     */     
/* 539 */     HealthUtil.updatePlayerMaxHealthAttribute(event.getEntity());
/* 540 */     BodyDamageUtil.updatePlayerBrokenHeartAttribute(event.getEntity());
/*     */ 
/*     */     
/* 543 */     Player player = event.getEntity(); if (player instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)player;
/* 544 */       if (Config.Baked.temperatureEnabled) {
/* 545 */         TemperatureAttachment tempCap = AttachmentUtil.getTempAttachment((Player)serverPlayer);
/* 546 */         UpdateTemperaturesPayload.sendToPlayer(serverPlayer, tempCap
/* 547 */             .writeNBT());
/*     */       } 
/*     */       
/* 550 */       if (Config.Baked.thirstEnabled) {
/* 551 */         ThirstAttachment thirstCap = AttachmentUtil.getThirstAttachment((Player)serverPlayer);
/* 552 */         UpdateThirstPayload.sendToPlayer(serverPlayer, thirstCap
/* 553 */             .writeNBT());
/*     */       } 
/*     */       
/* 556 */       if (Config.Baked.wetnessEnabled) {
/* 557 */         WetnessAttachment wetnessCap = AttachmentUtil.getWetnessAttachment((Player)serverPlayer);
/* 558 */         UpdateWetnessPayload.sendToPlayer(serverPlayer, wetnessCap
/* 559 */             .writeNBT());
/*     */       } 
/*     */       
/* 562 */       if (Config.Baked.localizedBodyDamageEnabled) {
/* 563 */         BodyDamageAttachment bodyCap = AttachmentUtil.getBodyDamageAttachment((Player)serverPlayer);
/* 564 */         UpdateBodyDamagePayload.sendToPlayer(serverPlayer, bodyCap
/* 565 */             .writeNBT());
/*     */       } 
/*     */       
/* 568 */       if (Config.Baked.healthOverhaulEnabled) {
/* 569 */         HealthAttachment healthCap = AttachmentUtil.getHealthAttachment((Player)serverPlayer);
/* 570 */         UpdateHeartsPayload.sendToPlayer(serverPlayer, healthCap
/* 571 */             .writeNBT());
/*     */       }  }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onLevelLoad(LevelEvent.Load event) {
/* 579 */     if (!event.getLevel().isClientSide()) {
/* 580 */       LevelData levelData = event.getLevel().getLevelData();
/* 581 */       if (levelData instanceof PrimaryLevelData) { PrimaryLevelData primaryLevelData = (PrimaryLevelData)levelData;
/* 582 */         ((GameRules.BooleanValue)primaryLevelData.getGameRules().getRule(GameRules.RULE_NATURAL_REGENERATION)).set(Config.Baked.naturalRegenerationEnabled, event.getLevel().getServer()); }
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onDataPackSyncEvent(OnDatapackSyncEvent event) {
/* 589 */     ServerPlayer player = event.getPlayer();
/*     */     
/* 591 */     ThirstBlockListener.sendDataToClient(player);
/* 592 */     ThirstConsumableListener.sendDataToClient(player);
/*     */     
/* 594 */     TemperatureBiomeListener.sendDataToClient(player);
/* 595 */     TemperatureBlockListener.sendDataToClient(player);
/* 596 */     TemperatureConsumableListener.sendDataToClient(player);
/* 597 */     TemperatureDimensionListener.sendDataToClient(player);
/* 598 */     TemperatureFuelItemListener.sendDataToClient(player);
/* 599 */     TemperatureItemListener.sendDataToClient(player);
/* 600 */     TemperatureMountListener.sendDataToClient(player);
/* 601 */     TemperatureOriginListener.sendDataToClient(player);
/*     */     
/* 603 */     BodyDamageHealingConsumableListener.sendDataToClient(player);
/* 604 */     BodyPartsDamageSourceListener.sendDataToClient(player);
/* 605 */     BodyPartResistanceItemListener.sendDataToClient(player);
/*     */   }
/*     */   @SubscribeEvent
/*     */   public static void onPlayerTick(PlayerTickEvent.Post event) {
/*     */     ServerPlayer serverPlayer;
/* 610 */     Player player = event.getEntity();
/* 611 */     if (!(player.level()).isClientSide && player instanceof ServerPlayer) { serverPlayer = (ServerPlayer)player; }
/*     */     else
/*     */     { return; }
/*     */     
/* 615 */     if (player.isDeadOrDying()) {
/*     */       return;
/*     */     }
/* 618 */     Level level = player.level();
/* 619 */     boolean isStart = (player.tickCount < 20);
/*     */ 
/*     */     
/* 622 */     if (Config.Baked.temperatureEnabled && !player.isCreative() && !player.isSpectator()) {
/* 623 */       TemperatureAttachment tempCap = AttachmentUtil.getTempAttachment(player);
/* 624 */       tempCap.tickUpdate(player, level, isStart);
/* 625 */       if (tempCap.isDirty()) {
/* 626 */         UpdateTemperaturesPayload.sendToPlayer(serverPlayer, tempCap
/* 627 */             .writeNBT());
/*     */         
/* 629 */         tempCap.setClean();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 634 */     if (Config.Baked.thirstEnabled && shouldApplyThirst(player)) {
/* 635 */       ThirstAttachment thirstCap = AttachmentUtil.getThirstAttachment(player);
/* 636 */       thirstCap.tickUpdate(player, level, isStart);
/* 637 */       if (thirstCap.isDirty()) {
/* 638 */         UpdateThirstPayload.sendToPlayer(serverPlayer, thirstCap
/* 639 */             .writeNBT());
/*     */         
/* 641 */         thirstCap.setClean();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 646 */     if (Config.Baked.wetnessEnabled) {
/* 647 */       WetnessAttachment wetnessCap = AttachmentUtil.getWetnessAttachment(player);
/* 648 */       wetnessCap.tickUpdate(player, level, isStart);
/* 649 */       if (wetnessCap.isDirty()) {
/* 650 */         UpdateWetnessPayload.sendToPlayer(serverPlayer, wetnessCap
/* 651 */             .writeNBT());
/*     */         
/* 653 */         wetnessCap.setClean();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 658 */     if (Config.Baked.temperatureEnabled) {
/* 659 */       AttachmentUtil.getFoodAttachment(player).tickUpdate(player, level, isStart);
/*     */     }
/*     */ 
/*     */     
/* 663 */     if (Config.Baked.localizedBodyDamageEnabled) {
/* 664 */       BodyDamageAttachment bodyCap = AttachmentUtil.getBodyDamageAttachment(player);
/* 665 */       bodyCap.tickUpdate(player, level, isStart);
/* 666 */       if (bodyCap.isDirty()) {
/* 667 */         UpdateBodyDamagePayload.sendToPlayer(serverPlayer, bodyCap
/* 668 */             .writeNBT());
/*     */         
/* 670 */         bodyCap.setClean();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 675 */     if (Config.Baked.healthOverhaulEnabled) {
/* 676 */       HealthAttachment healthCap = AttachmentUtil.getHealthAttachment(player);
/* 677 */       if (healthCap.isDirty()) {
/* 678 */         UpdateHeartsPayload.sendToPlayer(serverPlayer, healthCap
/* 679 */             .writeNBT());
/*     */         
/* 681 */         healthCap.setClean();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean shouldApplyThirst(Player player) {
/* 688 */     return (!player.isCreative() && !player.isSpectator() && Config.Baked.thirstEnabled && ThirstUtil.isThirstActive(player));
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean shouldApplyLocalizedBodyDamage(Player player) {
/* 693 */     return (!player.isCreative() && !player.isSpectator() && Config.Baked.localizedBodyDamageEnabled);
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean shouldApplyHealthOverhaul(Player player) {
/* 698 */     return (!player.isCreative() && !player.isSpectator() && Config.Baked.healthOverhaulEnabled);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void playerDrinkEffect(Player player) {
/* 704 */     player.swing(InteractionHand.MAIN_HAND);
/* 705 */     player.playSound(SoundEvents.GENERIC_DRINK, 1.0F, 1.0F);
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\events\CommonNeoForgeEvents.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */