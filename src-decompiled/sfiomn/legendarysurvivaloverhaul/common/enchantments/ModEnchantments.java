/*    */ package sfiomn.legendarysurvivaloverhaul.common.enchantments;
/*    */ 
/*    */ import net.minecraft.core.HolderGetter;
/*    */ import net.minecraft.core.HolderSet;
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.data.worldgen.BootstrapContext;
/*    */ import net.minecraft.resources.ResourceKey;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.EquipmentSlotGroup;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.enchantment.Enchantment;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.tags.ModItemTags;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModEnchantments
/*    */ {
/* 18 */   public static final ResourceKey<Enchantment> REFRESHING = key("refreshing");
/* 19 */   public static final ResourceKey<Enchantment> PURITY = key("purity");
/* 20 */   public static final ResourceKey<Enchantment> RESERVOIR = key("reservoir");
/*    */   
/*    */   private static ResourceKey<Enchantment> key(String name) {
/* 23 */     return ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", name));
/*    */   }
/*    */   
/*    */   public static void bootstrap(BootstrapContext<Enchantment> context) {
/* 27 */     HolderGetter<Item> items = context.lookup(Registries.ITEM);
/*    */ 
/*    */     
/* 30 */     register(context, REFRESHING, Enchantment.enchantment(
/* 31 */           Enchantment.definition((HolderSet)items
/* 32 */             .getOrThrow(ModItemTags.CANTEEN_ENCHANTABLE), (HolderSet)items
/* 33 */             .getOrThrow(ModItemTags.CANTEEN_ENCHANTABLE), 10, 3, 
/*    */ 
/*    */             
/* 36 */             Enchantment.dynamicCost(1, 10), 
/* 37 */             Enchantment.dynamicCost(51, 10), 2, new EquipmentSlotGroup[] { EquipmentSlotGroup.ANY })));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 44 */     register(context, PURITY, Enchantment.enchantment(
/* 45 */           Enchantment.definition((HolderSet)items
/* 46 */             .getOrThrow(ModItemTags.CANTEEN_ENCHANTABLE), (HolderSet)items
/* 47 */             .getOrThrow(ModItemTags.CANTEEN_ENCHANTABLE), 2, 1, 
/*    */ 
/*    */             
/* 50 */             Enchantment.constantCost(15), 
/* 51 */             Enchantment.constantCost(65), 4, new EquipmentSlotGroup[] { EquipmentSlotGroup.ANY })));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 58 */     register(context, RESERVOIR, Enchantment.enchantment(
/* 59 */           Enchantment.definition((HolderSet)items
/* 60 */             .getOrThrow(ModItemTags.CANTEEN_ENCHANTABLE), (HolderSet)items
/* 61 */             .getOrThrow(ModItemTags.CANTEEN_ENCHANTABLE), 10, 5, 
/*    */ 
/*    */             
/* 64 */             Enchantment.dynamicCost(1, 8), 
/* 65 */             Enchantment.dynamicCost(16, 8), 1, new EquipmentSlotGroup[] { EquipmentSlotGroup.ANY })));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static void register(BootstrapContext<Enchantment> context, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
/* 73 */     context.register(key, builder.build(key.location()));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\enchantments\ModEnchantments.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */