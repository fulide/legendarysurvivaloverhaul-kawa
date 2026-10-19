/*    */ package sfiomn.legendarysurvivaloverhaul.api.temperature;
/*    */ 
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureResistance;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AttributeModifierBase
/*    */ {
/*    */   public JsonTemperatureResistance getItemAttributes(ItemStack stack) {
/* 17 */     return new JsonTemperatureResistance();
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\temperature\AttributeModifierBase.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */