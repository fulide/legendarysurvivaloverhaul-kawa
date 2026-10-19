/*    */ package sfiomn.legendarysurvivaloverhaul.data.builders;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureResistanceData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TemperatureResistanceData
/*    */   implements ITemperatureResistanceData
/*    */ {
/*    */   private float temperature;
/*    */   private float heatResistance;
/*    */   private float coldResistance;
/*    */   private float thermalResistance;
/*    */   
/*    */   public ITemperatureResistanceData temperature(float temperatureValue) {
/* 20 */     this.temperature = temperatureValue;
/* 21 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ITemperatureResistanceData heatResistance(float heatResistanceValue) {
/* 27 */     this.heatResistance = heatResistanceValue;
/* 28 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ITemperatureResistanceData coldResistance(float coldResistanceValue) {
/* 34 */     this.coldResistance = coldResistanceValue;
/* 35 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ITemperatureResistanceData thermalResistance(float thermalResistanceValue) {
/* 41 */     this.thermalResistance = thermalResistanceValue;
/* 42 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public JsonObject build() {
/* 48 */     JsonObject json = new JsonObject();
/* 49 */     json.addProperty("temperature", Float.valueOf(this.temperature));
/* 50 */     json.addProperty("heat_resistance", Float.valueOf(this.heatResistance));
/* 51 */     json.addProperty("cold_resistance", Float.valueOf(this.coldResistance));
/* 52 */     json.addProperty("thermal_resistance", Float.valueOf(this.thermalResistance));
/* 53 */     return json;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\builders\TemperatureResistanceData.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */