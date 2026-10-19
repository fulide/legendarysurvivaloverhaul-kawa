/*     */ package sfiomn.legendarysurvivaloverhaul.util.internal;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Holder;
/*     */ import net.minecraft.core.component.DataComponents;
/*     */ import net.minecraft.core.registries.BuiltInRegistries;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.item.component.CustomData;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.neoforged.neoforge.registries.DeferredHolder;
/*     */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureConsumable;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureConsumableBlock;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.TemperatureDataManager;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.temperature.DynamicModifierBase;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.temperature.ITemperatureUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.temperature.ModifierBase;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemperatureEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemperatureImmunityEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.attachments.temperature.TemperatureAttachment;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.AttributeRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.TemperatureModifierRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.AttributeBuilder;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.MathUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.WorldUtil;
/*     */ 
/*     */ public class TemperatureUtilInternal
/*     */   implements ITemperatureUtil {
/*     */   public static final String COAT_TAG = "Coat";
/*  45 */   public static final AttributeBuilder HEATING_TEMPERATURE = new AttributeBuilder((Holder)AttributeRegistry.HEATING_TEMPERATURE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "heating_temperature"));
/*  46 */   public static final AttributeBuilder COOLING_TEMPERATURE = new AttributeBuilder((Holder)AttributeRegistry.COOLING_TEMPERATURE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "cooling_temperature"));
/*  47 */   public static final AttributeBuilder HEAT_RESISTANCE = new AttributeBuilder((Holder)AttributeRegistry.HEAT_RESISTANCE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "heat_resistance"));
/*  48 */   public static final AttributeBuilder COLD_RESISTANCE = new AttributeBuilder((Holder)AttributeRegistry.COLD_RESISTANCE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "cold_resistance"));
/*  49 */   public static final AttributeBuilder THERMAL_RESISTANCE = new AttributeBuilder((Holder)AttributeRegistry.THERMAL_RESISTANCE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "thermal_resistance"));
/*     */   
/*  51 */   public static final Map<EquipmentSlot, UUID> equipmentSlotTemperatureUuid = new HashMap<>();
/*     */ 
/*     */   
/*     */   static {
/*  55 */     equipmentSlotTemperatureUuid.put(EquipmentSlot.HEAD, UUID.fromString("06e30f27-2340-4bdb-9a91-a657f1e2880f"));
/*  56 */     equipmentSlotTemperatureUuid.put(EquipmentSlot.CHEST, UUID.fromString("1e7ef99e-2fe7-4edc-95b1-27fa056eae6d"));
/*  57 */     equipmentSlotTemperatureUuid.put(EquipmentSlot.LEGS, UUID.fromString("f46c0aff-7381-4f99-890e-75eb3781af21"));
/*  58 */     equipmentSlotTemperatureUuid.put(EquipmentSlot.FEET, UUID.fromString("34f98220-a7d9-4cc1-8930-b3dc4115ad07"));
/*  59 */     equipmentSlotTemperatureUuid.put(EquipmentSlot.MAINHAND, UUID.fromString("7b1e1c2c-746c-4631-8037-f76c82529909"));
/*  60 */     equipmentSlotTemperatureUuid.put(EquipmentSlot.OFFHAND, UUID.fromString("389caa2f-2c18-49da-b521-b53cc5713e14"));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getPlayerTargetTemperature(Player player) {
/*  66 */     float sum = 0.0F;
/*  67 */     Level world = player.getCommandSenderWorld();
/*  68 */     BlockPos pos = WorldUtil.getSidedBlockPos(world, (Entity)player);
/*     */     
/*  70 */     for (DeferredHolder<ModifierBase, ? extends ModifierBase> holder : (Iterable<DeferredHolder<ModifierBase, ? extends ModifierBase>>)TemperatureModifierRegistry.MODIFIERS.getEntries()) {
/*     */       
/*  72 */       ModifierBase modifier = (ModifierBase)holder.get();
/*  73 */       float worldInfluence = modifier.getWorldInfluence(player, world, pos);
/*  74 */       float playerInfluence = modifier.getPlayerInfluence(player);
/*  75 */       if (player.getMainHandItem().is(Items.DEBUG_STICK))
/*     */       {
/*  77 */         LegendarySurvivalOverhaul.LOGGER.info("{} : world influence={}, player influence={}", holder.getId(), Float.valueOf(worldInfluence), Float.valueOf(playerInfluence));
/*     */       }
/*     */       
/*  80 */       sum += worldInfluence + playerInfluence;
/*     */     } 
/*     */     
/*  83 */     float dynamicModification = 0.0F;
/*  84 */     for (DeferredHolder<DynamicModifierBase, ? extends DynamicModifierBase> holder : (Iterable<DeferredHolder<DynamicModifierBase, ? extends DynamicModifierBase>>)TemperatureModifierRegistry.DYNAMIC_MODIFIERS.getEntries()) {
/*     */       
/*  86 */       DynamicModifierBase dynamicModifier = (DynamicModifierBase)holder.get();
/*  87 */       float worldInfluence = dynamicModifier.applyDynamicWorldInfluence(player, world, pos, sum, dynamicModification);
/*  88 */       float playerInfluence = dynamicModifier.applyDynamicPlayerInfluence(player, sum, dynamicModification);
/*  89 */       if (player.getMainHandItem().is(Items.DEBUG_STICK))
/*     */       {
/*  91 */         LegendarySurvivalOverhaul.LOGGER.info("{} : dynamic world influence={}, dynamic player influence={}", holder.getId(), Float.valueOf(worldInfluence), Float.valueOf(playerInfluence));
/*     */       }
/*     */       
/*  94 */       dynamicModification += worldInfluence + playerInfluence;
/*     */     } 
/*  96 */     sum += dynamicModification;
/*  97 */     return MathUtil.round(sum, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getWorldTemperature(Level world, BlockPos pos) {
/* 103 */     float sum = 0.0F;
/*     */     
/* 105 */     for (DeferredHolder<ModifierBase, ? extends ModifierBase> holder : (Iterable<DeferredHolder<ModifierBase, ? extends ModifierBase>>)TemperatureModifierRegistry.MODIFIERS.getEntries()) {
/*     */       
/* 107 */       ModifierBase modifier = (ModifierBase)holder.get();
/*     */       
/* 109 */       sum += modifier.getWorldInfluence(null, world, pos);
/*     */     } 
/*     */     
/* 112 */     float dynamicModification = 0.0F;
/* 113 */     for (DeferredHolder<DynamicModifierBase, ? extends DynamicModifierBase> holder : (Iterable<DeferredHolder<DynamicModifierBase, ? extends DynamicModifierBase>>)TemperatureModifierRegistry.DYNAMIC_MODIFIERS.getEntries()) {
/*     */       
/* 115 */       DynamicModifierBase dynamicModifier = (DynamicModifierBase)holder.get();
/*     */       
/* 117 */       dynamicModification += dynamicModifier.applyDynamicWorldInfluence(null, world, pos, sum, dynamicModification);
/*     */     } 
/* 119 */     sum += dynamicModification;
/*     */     
/* 121 */     return MathUtil.round(sum, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TemperatureEnum getTemperatureEnum(float temperature) {
/* 127 */     return TemperatureEnum.get(temperature);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasImmunity(Player player, TemperatureImmunityEnum immunity) {
/* 133 */     if (!Config.Baked.temperatureEnabled) {
/* 134 */       return false;
/*     */     }
/* 136 */     TemperatureAttachment cap = AttachmentUtil.getTempAttachment(player);
/* 137 */     return cap.getTemperatureImmunities().contains(Integer.valueOf(immunity.id));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addImmunity(Player player, TemperatureImmunityEnum immunity) {
/* 143 */     if (!Config.Baked.temperatureEnabled) {
/*     */       return;
/*     */     }
/* 146 */     TemperatureAttachment cap = AttachmentUtil.getTempAttachment(player);
/* 147 */     cap.addTemperatureImmunityId(immunity.id);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeImmunity(Player player, TemperatureImmunityEnum immunity) {
/* 153 */     if (!Config.Baked.temperatureEnabled) {
/*     */       return;
/*     */     }
/* 156 */     TemperatureAttachment cap = AttachmentUtil.getTempAttachment(player);
/* 157 */     cap.removeTemperatureImmunityId(immunity.id);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void applyConsumableTemperature(Player player, ResourceLocation itemRegistryName) {
/* 163 */     if (Config.Baked.temperatureEnabled) {
/*     */       
/* 165 */       List<JsonTemperatureConsumable> jsonConsumableTemperatures = TemperatureDataManager.getConsumable(itemRegistryName);
/*     */       
/* 167 */       if (jsonConsumableTemperatures != null)
/*     */       {
/* 169 */         for (JsonTemperatureConsumable jtc : jsonConsumableTemperatures) {
/*     */           
/* 171 */           if (jtc.getEffect() != null) {
/*     */             
/* 173 */             player.addEffect(new MobEffectInstance((Holder)jtc.getEffectHolder(), jtc.duration, Math.abs(jtc.temperatureLevel) - 1, false, false, true));
/* 174 */             if (jtc.getOppositeEffectHolder() != null) {
/* 175 */               player.removeEffect((Holder)jtc.getOppositeEffectHolder());
/*     */             }
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void applyConsumableBlockTemperature(Player player, BlockState blockState) {
/* 185 */     if (Config.Baked.temperatureEnabled) {
/*     */       
/* 187 */       ResourceLocation blockRegistryName = BuiltInRegistries.BLOCK.getKey(blockState.getBlock());
/* 188 */       List<JsonTemperatureConsumableBlock> jsonConsumableBlockTemperatures = TemperatureDataManager.getConsumableBlock(blockRegistryName);
/*     */       
/* 190 */       if (jsonConsumableBlockTemperatures != null)
/*     */       {
/* 192 */         for (JsonTemperatureConsumableBlock jtcb : jsonConsumableBlockTemperatures) {
/*     */           
/* 194 */           if (jtcb.getEffect() != null && jtcb.matchesState(blockState)) {
/*     */             
/* 196 */             player.addEffect(new MobEffectInstance((Holder)jtcb.getEffectHolder(), jtcb.duration, Math.abs(jtcb.temperatureLevel) - 1, false, false, true));
/* 197 */             if (jtcb.getOppositeEffectHolder() != null) {
/* 198 */               player.removeEffect((Holder)jtcb.getOppositeEffectHolder());
/*     */             }
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addTemperatureModifier(Player player, double temperature, UUID uuid) {
/* 208 */     HEATING_TEMPERATURE.addModifier(player, uuid, Math.max(temperature, 0.0D));
/* 209 */     COOLING_TEMPERATURE.addModifier(player, uuid, Math.min(temperature, 0.0D));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addHeatResistanceModifier(Player player, double resistance, UUID uuid) {
/* 215 */     HEAT_RESISTANCE.addModifier(player, uuid, resistance);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addColdResistanceModifier(Player player, double resistance, UUID uuid) {
/* 221 */     COLD_RESISTANCE.addModifier(player, uuid, resistance);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addThermalResistanceModifier(Player player, double resistance, UUID uuid) {
/* 226 */     THERMAL_RESISTANCE.addModifier(player, uuid, resistance);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setArmorCoatTag(ItemStack stack, String coatId) {
/* 232 */     CustomData custom = (CustomData)stack.get(DataComponents.CUSTOM_DATA);
/* 233 */     CompoundTag compound = (custom != null) ? custom.copyTag() : new CompoundTag();
/* 234 */     compound.putString("Coat", coatId);
/* 235 */     stack.set(DataComponents.CUSTOM_DATA, CustomData.of(compound));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float clampTemperature(float temperature) {
/* 242 */     return Mth.clamp(temperature, TemperatureEnum.getMin(), TemperatureEnum.getMax());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getArmorCoatTag(ItemStack stack) {
/* 248 */     CustomData custom = (CustomData)stack.get(DataComponents.CUSTOM_DATA);
/* 249 */     if (custom != null) {
/*     */       
/* 251 */       CompoundTag compound = custom.copyTag();
/*     */       
/* 253 */       if (compound.contains("ArmorPadding")) {
/*     */         
/* 255 */         compound.putString("Coat", compound.getString("ArmorPadding"));
/* 256 */         compound.remove("ArmorPadding");
/* 257 */         stack.set(DataComponents.CUSTOM_DATA, CustomData.of(compound));
/*     */       } 
/* 259 */       if (compound.contains("Coat"))
/*     */       {
/* 261 */         return compound.getString("Coat");
/*     */       }
/*     */     } 
/* 264 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeArmorCoatTag(ItemStack stack) {
/* 270 */     CustomData custom = (CustomData)stack.get(DataComponents.CUSTOM_DATA);
/* 271 */     if (custom != null) {
/*     */       
/* 273 */       CompoundTag compound = custom.copyTag();
/* 274 */       if (compound.contains("Coat")) {
/*     */         
/* 276 */         compound.remove("Coat");
/* 277 */         stack.set(DataComponents.CUSTOM_DATA, CustomData.of(compound));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhau\\util\internal\TemperatureUtilInternal.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */