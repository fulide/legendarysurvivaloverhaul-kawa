/*     */ package sfiomn.legendarysurvivaloverhaul.api.thirst;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonMobEffect;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonThirstBlock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ThirstUtil
/*     */ {
/*     */   public static IThirstUtil internal;
/*     */   
/*     */   public static void takeDrink(Player player, ItemStack itemStack) {
/*  23 */     internal.takeDrink(player, itemStack);
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
/*     */   public static void takeDrink(Player player, int hydration, float saturation, List<JsonMobEffect> effects) {
/*  36 */     internal.takeDrink(player, hydration, saturation, effects);
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
/*     */   public static void takeDrink(Player player, int hydration, float saturation) {
/*  48 */     internal.takeDrink(player, hydration, saturation);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addExhaustion(Player player, float exhaustion) {
/*  59 */     internal.addExhaustion(player, exhaustion);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JsonThirstBlock getFluidThirstLookedAt(Player player, double finalDistance) {
/*  70 */     return internal.getFluidThirstLookedAt(player, finalDistance);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JsonThirstBlock getBlockThirstLookedAt(Player player, double finalDistance) {
/*  81 */     return internal.getBlockThirstLookedAt(player, finalDistance);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setHydrationEnumTag(ItemStack stack, HydrationEnum hydrationEnum) {
/*  92 */     internal.setHydrationEnumTag(stack, hydrationEnum);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public static HydrationEnum getHydrationEnumTag(ItemStack stack) {
/* 104 */     return internal.getHydrationEnumTag(stack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void removeHydrationEnumTag(ItemStack stack) {
/* 114 */     internal.removeHydrationEnumTag(stack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setCapacityTag(ItemStack stack, int capacity) {
/* 125 */     internal.setCapacityTag(stack, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getCapacityTag(ItemStack stack) {
/* 136 */     return internal.getCapacityTag(stack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void removeCapacityTag(ItemStack stack) {
/* 146 */     internal.removeCapacityTag(stack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void deactivateThirst(Player player) {
/* 156 */     internal.deactivateThirst(player);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void activateThirst(Player player) {
/* 166 */     internal.activateThirst(player);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isThirstActive(Player player) {
/* 176 */     return internal.isThirstActive(player);
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\thirst\ThirstUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */