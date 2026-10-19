/*     */ package sfiomn.legendarysurvivaloverhaul.util.internal;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import net.minecraft.core.Holder;
/*     */ import net.minecraft.core.component.DataComponents;
/*     */ import net.minecraft.core.registries.BuiltInRegistries;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.world.effect.MobEffect;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.component.CustomData;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.material.Fluid;
/*     */ import net.minecraft.world.level.material.FluidState;
/*     */ import net.minecraft.world.level.material.Fluids;
/*     */ import net.minecraft.world.phys.BlockHitResult;
/*     */ import net.minecraft.world.phys.HitResult;
/*     */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonMobEffect;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonThirstBlock;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonThirstConsumable;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.ThirstDataManager;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.thirst.HydrationEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.thirst.IThirstUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.thirst.ThirstUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.attachments.thirst.ThirstAttachment;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.integration.curios.CuriosUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.ItemRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.MobEffectRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*     */ 
/*     */ public class ThirstUtilInternal implements IThirstUtil {
/*     */   public void setHydrationEnumTag(ItemStack stack, HydrationEnum hydrationEnum) {
/*  43 */     CustomData custom = (CustomData)stack.get(DataComponents.CUSTOM_DATA);
/*  44 */     CompoundTag compound = (custom != null) ? custom.copyTag() : new CompoundTag();
/*  45 */     compound.putString("legendarysurvivaloverhaul:HydrationPurity", hydrationEnum.getName());
/*  46 */     stack.set(DataComponents.CUSTOM_DATA, CustomData.of(compound));
/*     */   }
/*     */   
/*     */   public static final String HYDRATION_ENUM_TAG = "legendarysurvivaloverhaul:HydrationPurity";
/*     */   
/*     */   public HydrationEnum getHydrationEnumTag(ItemStack stack) {
/*  52 */     CustomData custom = (CustomData)stack.get(DataComponents.CUSTOM_DATA);
/*  53 */     if (custom != null) {
/*     */       
/*  55 */       CompoundTag compound = custom.copyTag();
/*  56 */       if (compound.contains("legendarysurvivaloverhaul:HydrationPurity")) {
/*     */         
/*  58 */         String hydrationEnumName = compound.getString("legendarysurvivaloverhaul:HydrationPurity");
/*  59 */         return HydrationEnum.getByName(hydrationEnumName);
/*     */       } 
/*     */     } 
/*  62 */     return null;
/*     */   }
/*     */   
/*     */   public static final String CAPACITY_TAG = "legendarysurvivaloverhaul:HydrationCapacity";
/*     */   
/*     */   public void removeHydrationEnumTag(ItemStack stack) {
/*  68 */     CustomData custom = (CustomData)stack.get(DataComponents.CUSTOM_DATA);
/*  69 */     if (custom != null) {
/*     */       
/*  71 */       CompoundTag compound = custom.copyTag();
/*  72 */       if (compound.contains("legendarysurvivaloverhaul:HydrationPurity")) {
/*     */         
/*  74 */         compound.remove("legendarysurvivaloverhaul:HydrationPurity");
/*  75 */         stack.set(DataComponents.CUSTOM_DATA, CustomData.of(compound));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCapacityTag(ItemStack stack, int capacity) {
/*  83 */     CustomData custom = (CustomData)stack.get(DataComponents.CUSTOM_DATA);
/*  84 */     CompoundTag compound = (custom != null) ? custom.copyTag() : new CompoundTag();
/*  85 */     compound.putInt("legendarysurvivaloverhaul:HydrationCapacity", capacity);
/*  86 */     stack.set(DataComponents.CUSTOM_DATA, CustomData.of(compound));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCapacityTag(ItemStack stack) {
/*  92 */     CustomData custom = (CustomData)stack.get(DataComponents.CUSTOM_DATA);
/*  93 */     if (custom != null) {
/*     */       
/*  95 */       CompoundTag compound = custom.copyTag();
/*  96 */       if (compound.contains("legendarysurvivaloverhaul:HydrationCapacity"))
/*     */       {
/*  98 */         return compound.getInt("legendarysurvivaloverhaul:HydrationCapacity");
/*     */       }
/*     */     } 
/* 101 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeCapacityTag(ItemStack stack) {
/* 107 */     CustomData custom = (CustomData)stack.get(DataComponents.CUSTOM_DATA);
/* 108 */     if (custom != null) {
/*     */       
/* 110 */       CompoundTag compound = custom.copyTag();
/* 111 */       if (compound.contains("legendarysurvivaloverhaul:HydrationCapacity")) {
/*     */         
/* 113 */         compound.remove("legendarysurvivaloverhaul:HydrationCapacity");
/* 114 */         stack.set(DataComponents.CUSTOM_DATA, CustomData.of(compound));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void takeDrink(Player player, ItemStack itemStack) {
/* 122 */     if (!Config.Baked.thirstEnabled || !ThirstUtil.isThirstActive(player)) {
/*     */       return;
/*     */     }
/* 125 */     JsonThirstConsumable jsonThirstConsumable = ThirstDataManager.getConsumable(itemStack);
/*     */     
/* 127 */     if (jsonThirstConsumable != null)
/*     */     {
/* 129 */       ThirstUtil.takeDrink(player, jsonThirstConsumable.hydration, jsonThirstConsumable.saturation, jsonThirstConsumable.effects);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void takeDrink(Player player, int hydration, float saturation, List<JsonMobEffect> effects) {
/* 136 */     if (!Config.Baked.thirstEnabled || !ThirstUtil.isThirstActive(player)) {
/*     */       return;
/*     */     }
/* 139 */     ThirstAttachment thirstAttachment = AttachmentUtil.getThirstAttachment(player);
/*     */     
/* 141 */     if (!thirstAttachment.isHydrationLevelAtMax()) {
/*     */       
/* 143 */       thirstAttachment.addHydrationLevel(hydration);
/*     */       
/* 145 */       thirstAttachment.addSaturationLevel(saturation);
/*     */     } 
/*     */ 
/*     */     
/* 149 */     for (JsonMobEffect effect : effects) {
/*     */       
/* 151 */       if (effect.chance >= 0.0F && effect.duration > 0 && !effect.name.isEmpty() && (player.level()).random.nextFloat() < effect.chance) {
/*     */         
/* 153 */         ResourceLocation effectId = ResourceLocation.parse(effect.name);
/* 154 */         Optional<Holder.Reference<MobEffect>> effectHolder = BuiltInRegistries.MOB_EFFECT.getHolder(effectId);
/* 155 */         if (effectHolder.isPresent()) {
/*     */           
/* 157 */           int effectDuration = effect.duration;
/* 158 */           if (Config.Baked.cumulativeThirstEffectDuration && ((Holder.Reference)effectHolder
/* 159 */             .get()).value() == MobEffectRegistry.THIRST.get() && player
/* 160 */             .getEffect((Holder)MobEffectRegistry.THIRST) != null)
/*     */           {
/* 162 */             effectDuration += ((MobEffectInstance)Objects.<MobEffectInstance>requireNonNull(player.getEffect((Holder)MobEffectRegistry.THIRST))).getDuration();
/*     */           }
/* 164 */           player.addEffect(new MobEffectInstance((Holder)effectHolder.get(), effectDuration, effect.amplifier, false, true, true));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void takeDrink(Player player, int hydration, float saturation) {
/* 174 */     takeDrink(player, hydration, saturation, Collections.emptyList());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addExhaustion(Player player, float exhaustion) {
/* 180 */     ThirstAttachment thirstCap = AttachmentUtil.getThirstAttachment(player);
/* 181 */     thirstCap.addThirstExhaustion(exhaustion);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonThirstBlock getFluidThirstLookedAt(Player player, double finalDistance) {
/* 187 */     ResourceLocation rain = ResourceLocation.parse("rain");
/*     */ 
/*     */     
/* 190 */     if (player.getViewXRot(1.0F) < -60.0F && player.level().isRainingAt(player.blockPosition().above()) && 
/* 191 */       ThirstDataManager.getBlock(rain) != null) {
/*     */ 
/*     */       
/* 194 */       List<JsonThirstBlock> thirstPropertyList = ThirstDataManager.getBlock(rain);
/*     */       
/* 196 */       if (thirstPropertyList == null || thirstPropertyList.isEmpty())
/*     */       {
/* 198 */         return null;
/*     */       }
/*     */       
/* 201 */       return thirstPropertyList.get(0);
/*     */     } 
/*     */     
/* 204 */     HitResult positionLookedAt = player.pick(finalDistance, 0.0F, true);
/*     */     
/* 206 */     if (positionLookedAt.getType() == HitResult.Type.BLOCK) {
/*     */ 
/*     */       
/* 209 */       FluidState fluidState = player.level().getFluidState(((BlockHitResult)positionLookedAt).getBlockPos());
/* 210 */       ResourceLocation fluidRegistryName = BuiltInRegistries.FLUID.getKey(fluidState.getType());
/* 211 */       JsonThirstBlock defaultThirst = null;
/*     */       
/* 213 */       if (fluidRegistryName != null && !fluidState.isEmpty()) {
/*     */ 
/*     */         
/* 216 */         if (LegendarySurvivalOverhaul.curiosLoaded)
/*     */         {
/* 218 */           if (CuriosUtil.isCurioItemEquipped(player, (Item)ItemRegistry.NETHER_CHALICE.get()) && (fluidState
/* 219 */             .is((Fluid)Fluids.FLOWING_LAVA) || fluidState.is((Fluid)Fluids.LAVA))) {
/* 220 */             return new JsonThirstBlock(Config.Baked.hydrationLava, (float)Config.Baked.saturationLava, new ArrayList(), new HashMap<>());
/*     */           }
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 229 */         List<JsonThirstBlock> jsonBlockFluidThirsts = ThirstDataManager.getBlock(fluidRegistryName);
/*     */         
/* 231 */         if (jsonBlockFluidThirsts == null) {
/* 232 */           return null;
/*     */         }
/* 234 */         for (JsonThirstBlock thirstInfo : jsonBlockFluidThirsts) {
/*     */           
/* 236 */           if (thirstInfo == null) {
/*     */             continue;
/*     */           }
/* 239 */           if (thirstInfo.isDefault()) {
/* 240 */             defaultThirst = thirstInfo;
/*     */           }
/* 242 */           if (thirstInfo.matchesState(fluidState))
/*     */           {
/* 244 */             return thirstInfo;
/*     */           }
/*     */         } 
/* 247 */         return defaultThirst;
/*     */       } 
/*     */     } 
/*     */     
/* 251 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonThirstBlock getBlockThirstLookedAt(Player player, double finalDistance) {
/* 258 */     HitResult positionLookedAt = player.pick(finalDistance, 0.0F, true);
/*     */     
/* 260 */     if (positionLookedAt.getType() == HitResult.Type.BLOCK) {
/*     */ 
/*     */       
/* 263 */       JsonThirstBlock defaultThirst = null;
/*     */       
/* 265 */       BlockState blockState = player.level().getBlockState(((BlockHitResult)positionLookedAt).getBlockPos());
/* 266 */       ResourceLocation blockRegistryName = BuiltInRegistries.BLOCK.getKey(blockState.getBlock());
/*     */       
/* 268 */       if (blockRegistryName != null) {
/*     */         
/* 270 */         List<JsonThirstBlock> jsonBlockFluidThirsts = ThirstDataManager.getBlock(blockRegistryName);
/*     */         
/* 272 */         if (jsonBlockFluidThirsts == null) {
/* 273 */           return null;
/*     */         }
/* 275 */         for (JsonThirstBlock thirstInfo : jsonBlockFluidThirsts) {
/*     */           
/* 277 */           if (thirstInfo == null) {
/*     */             continue;
/*     */           }
/* 280 */           if (thirstInfo.isDefault()) {
/* 281 */             defaultThirst = thirstInfo;
/*     */           }
/* 283 */           if (thirstInfo.matchesState(blockState))
/*     */           {
/* 285 */             return thirstInfo;
/*     */           }
/*     */         } 
/*     */         
/* 289 */         return defaultThirst;
/*     */       } 
/*     */     } 
/* 292 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void deactivateThirst(Player player) {
/* 298 */     ThirstAttachment cap = AttachmentUtil.getThirstAttachment(player);
/* 299 */     cap.setTickTimer(-1);
/* 300 */     cap.setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void activateThirst(Player player) {
/* 306 */     ThirstAttachment cap = AttachmentUtil.getThirstAttachment(player);
/* 307 */     if (cap.getTickTimer() == -1) {
/*     */       
/* 309 */       cap.setTickTimer(0);
/* 310 */       cap.setDirty();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isThirstActive(Player player) {
/* 317 */     return (AttachmentUtil.getThirstAttachment(player).getTickTimer() != -1);
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhau\\util\internal\ThirstUtilInternal.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */