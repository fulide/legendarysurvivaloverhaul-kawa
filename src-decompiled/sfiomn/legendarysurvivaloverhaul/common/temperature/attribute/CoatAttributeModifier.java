/*    */ package sfiomn.legendarysurvivaloverhaul.common.temperature.attribute;
/*    */ 
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureResistance;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.item.CoatEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.AttributeModifierBase;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemperatureUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CoatAttributeModifier
/*    */   extends AttributeModifierBase
/*    */ {
/*    */   public JsonTemperatureResistance getItemAttributes(ItemStack stack) {
/* 18 */     JsonTemperatureResistance config = new JsonTemperatureResistance();
/* 19 */     if (!TemperatureUtil.getArmorCoatTag(stack).isEmpty()) {
/*    */       
/* 21 */       CoatEnum coat = CoatEnum.getFromId(TemperatureUtil.getArmorCoatTag(stack));
/* 22 */       if (coat != null) {
/*    */         
/* 24 */         if (coat.type().equals("cooling"))
/* 25 */           config.heatResistance += (float)coat.modifier(); 
/* 26 */         if (coat.type().equals("heating"))
/* 27 */           config.coldResistance += (float)coat.modifier(); 
/* 28 */         if (coat.type().equals("thermal"))
/* 29 */           config.thermalResistance += (float)coat.modifier(); 
/*    */       } 
/*    */     } 
/* 32 */     return config;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\temperature\attribute\CoatAttributeModifier.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */