/*    */ package sfiomn.legendarysurvivaloverhaul.common.items.drink;
/*    */ 
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.thirst.HydrationEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.thirst.ThirstUtil;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.enchantments.ModEnchantments;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ 
/*    */ public class LargeCanteenItem
/*    */   extends CanteenItem {
/*    */   public LargeCanteenItem(Item.Properties properties) {
/* 17 */     super(properties);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getMaxCapacity() {
/* 23 */     return Config.Baked.largeCanteenCapacity;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getMaxCapacity(ItemStack stack, Level level) {
/* 29 */     int baseCapacity = getMaxCapacity();
/* 30 */     if (level == null) return baseCapacity; 
/* 31 */     int reservoirLevel = stack.getEnchantmentLevel((Holder)level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ModEnchantments.RESERVOIR));
/* 32 */     return baseCapacity + reservoirLevel;
/*    */   }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public String getDescriptionId(ItemStack stack) {
/* 38 */     if (ThirstUtil.getCapacityTag(stack) == 0) {
/* 39 */       return "item.legendarysurvivaloverhaul.large_canteen_empty";
/*    */     }
/* 41 */     if (ThirstUtil.getHydrationEnumTag(stack) == HydrationEnum.PURIFIED) {
/* 42 */       return "item.legendarysurvivaloverhaul.large_canteen_purified";
/*    */     }
/* 44 */     return "item.legendarysurvivaloverhaul.large_canteen";
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\items\drink\LargeCanteenItem.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */