/*    */ package sfiomn.legendarysurvivaloverhaul.common.temperature.dynamic;
/*    */ 
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureResistance;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.DynamicModifierBase;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.AttributeRegistry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TemperatureResistanceModifier
/*    */   extends DynamicModifierBase
/*    */ {
/*    */   public float applyDynamicPlayerInfluence(Player player, float currentTemperature, float currentResistance) {
/* 19 */     JsonTemperatureResistance jsonTemperatureResistance = new JsonTemperatureResistance();
/*    */     
/* 21 */     if (player.getAttributes().hasAttribute((Holder)AttributeRegistry.THERMAL_RESISTANCE)) {
/* 22 */       jsonTemperatureResistance.thermalResistance = (float)player.getAttributeValue((Holder)AttributeRegistry.THERMAL_RESISTANCE);
/*    */     }
/* 24 */     if (player.getAttributes().hasAttribute((Holder)AttributeRegistry.HEAT_RESISTANCE)) {
/* 25 */       jsonTemperatureResistance.heatResistance = (float)player.getAttributeValue((Holder)AttributeRegistry.HEAT_RESISTANCE);
/*    */     }
/* 27 */     if (player.getAttributes().hasAttribute((Holder)AttributeRegistry.COLD_RESISTANCE)) {
/* 28 */       jsonTemperatureResistance.coldResistance = (float)player.getAttributeValue((Holder)AttributeRegistry.COLD_RESISTANCE);
/*    */     }
/* 30 */     return getEffectiveResistance(currentTemperature, currentResistance, jsonTemperatureResistance);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\temperature\dynamic\TemperatureResistanceModifier.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */