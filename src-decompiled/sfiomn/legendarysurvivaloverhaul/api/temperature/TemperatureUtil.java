/*     */ package sfiomn.legendarysurvivaloverhaul.api.temperature;
/*     */ 
/*     */ import java.util.UUID;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.block.state.BlockState;
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
/*     */ 
/*     */ public class TemperatureUtil
/*     */ {
/*     */   public static ITemperatureUtil internal;
/*     */   
/*     */   public static float getPlayerTargetTemperature(Player player) {
/*  26 */     return internal.getPlayerTargetTemperature(player);
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
/*     */   public static float getWorldTemperature(Level world, BlockPos pos) {
/*  39 */     return internal.getWorldTemperature(world, pos);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float clampTemperature(float temperature) {
/*  50 */     return internal.clampTemperature(temperature);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TemperatureEnum getTemperatureEnum(float temperature) {
/*  61 */     return internal.getTemperatureEnum(temperature);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean hasImmunity(Player player, TemperatureImmunityEnum immunity) {
/*  72 */     return internal.hasImmunity(player, immunity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addImmunity(Player player, TemperatureImmunityEnum immunity) {
/*  83 */     internal.addImmunity(player, immunity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void removeImmunity(Player player, TemperatureImmunityEnum immunity) {
/*  94 */     internal.removeImmunity(player, immunity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void applyConsumableTemperature(Player player, ResourceLocation itemRegistryName) {
/* 105 */     internal.applyConsumableTemperature(player, itemRegistryName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void applyConsumableBlockTemperature(Player player, BlockState blockState) {
/* 116 */     internal.applyConsumableBlockTemperature(player, blockState);
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
/*     */   public static void addTemperatureModifier(Player player, double temperature, UUID uuid) {
/* 128 */     internal.addTemperatureModifier(player, temperature, uuid);
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
/*     */   public static void addHeatResistanceModifier(Player player, double resistance, UUID uuid) {
/* 140 */     internal.addHeatResistanceModifier(player, resistance, uuid);
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
/*     */   public static void addColdResistanceModifier(Player player, double resistance, UUID uuid) {
/* 152 */     internal.addColdResistanceModifier(player, resistance, uuid);
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
/*     */   public static void addThermalResistanceModifier(Player player, double resistance, UUID uuid) {
/* 164 */     internal.addThermalResistanceModifier(player, resistance, uuid);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setArmorCoatTag(ItemStack stack, String coatId) {
/* 175 */     internal.setArmorCoatTag(stack, coatId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getArmorCoatTag(ItemStack stack) {
/* 186 */     return internal.getArmorCoatTag(stack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void removeArmorCoatTag(ItemStack stack) {
/* 196 */     internal.removeArmorCoatTag(stack);
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\temperature\TemperatureUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */