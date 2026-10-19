/*    */ package sfiomn.legendarysurvivaloverhaul.common.integration.supplementaries;
/*    */ 
/*    */ import net.mehvahdjukaar.supplementaries.common.items.LunchBoxItem;
/*    */ import net.mehvahdjukaar.supplementaries.common.items.components.LunchBaskedContent;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*    */ 
/*    */ public class SupplementariesUtil
/*    */ {
/*    */   public static ItemStack getSelectedItemInLunchBasket(ItemStack stack) {
/*    */     LunchBoxItem lb;
/* 13 */     if (!LegendarySurvivalOverhaul.supplementariesLoaded) return ItemStack.EMPTY; 
/* 14 */     Item item = stack.getItem(); if (item instanceof LunchBoxItem) { lb = (LunchBoxItem)item; } else { return ItemStack.EMPTY; }
/*    */ 
/*    */     
/* 17 */     LunchBaskedContent data = (LunchBaskedContent)stack.get(lb.getComponentType());
/* 18 */     if (data == null || !data.canEatFrom()) return ItemStack.EMPTY;
/*    */     
/* 20 */     return data.getSelected();
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\supplementaries\SupplementariesUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */