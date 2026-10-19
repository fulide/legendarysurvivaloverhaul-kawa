/*    */ package sfiomn.legendarysurvivaloverhaul.util;
/*    */ 
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.EquipmentSlot;
/*    */ import net.minecraft.world.item.ArmorItem;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.integration.curios.CuriosUtil;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemUtil
/*    */ {
/*    */   public static boolean canBeEquippedInSlot(ItemStack stack, EquipmentSlot slot) {
/* 20 */     Item item = stack.getItem(); if (item instanceof ArmorItem) { ArmorItem armorItem = (ArmorItem)item;
/*    */       
/* 22 */       return (armorItem.getEquipmentSlot() == slot); }
/*    */ 
/*    */     
/* 25 */     if (stack.getItem() instanceof net.minecraft.world.item.ShieldItem)
/*    */     {
/* 27 */       return (slot == EquipmentSlot.OFFHAND);
/*    */     }
/*    */     
/* 30 */     if (CuriosUtil.isCuriosItem(stack)) {
/* 31 */       return false;
/*    */     }
/* 33 */     return (slot == EquipmentSlot.MAINHAND);
/*    */   }
/*    */ 
/*    */   
/*    */   public static EquipmentSlot getEquippableSlot(ItemStack stack) {
/* 38 */     Item item = stack.getItem(); if (item instanceof ArmorItem) { ArmorItem armorItem = (ArmorItem)item;
/*    */       
/* 40 */       return armorItem.getEquipmentSlot(); }
/*    */ 
/*    */     
/* 43 */     if (stack.getItem() instanceof net.minecraft.world.item.ShieldItem)
/*    */     {
/* 45 */       return EquipmentSlot.OFFHAND;
/*    */     }
/*    */     
/* 48 */     return EquipmentSlot.MAINHAND;
/*    */   }
/*    */ 
/*    */   
/*    */   public static String compassLocation(Entity entity) {
/* 53 */     switch (Config.Baked.compassInfoMode) { default: throw new MatchException(null, null);case FULL: case HORIZONTAL: case NONE: break; }  return 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 58 */       "";
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhau\\util\ItemUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */