/*    */ package sfiomn.legendarysurvivaloverhaul.common.temperature.attribute;
/*    */ 
/*    */ import net.minecraft.core.registries.BuiltInRegistries;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureResistance;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.TemperatureDataManager;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.AttributeModifierBase;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemAttributeModifier
/*    */   extends AttributeModifierBase
/*    */ {
/*    */   public JsonTemperatureResistance getItemAttributes(ItemStack stack) {
/* 19 */     ResourceLocation itemRegistryName = BuiltInRegistries.ITEM.getKey(stack.getItem());
/* 20 */     JsonTemperatureResistance config = TemperatureDataManager.getItem(itemRegistryName);
/* 21 */     return (config == null) ? new JsonTemperatureResistance() : config;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\temperature\attribute\ItemAttributeModifier.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */