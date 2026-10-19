/*    */ package sfiomn.legendarysurvivaloverhaul.data.builders;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TemperatureData
/*    */   implements ITemperatureData
/*    */ {
/*    */   private float temperature;
/*    */   
/*    */   public ITemperatureData temperature(float temperatureValue) {
/* 17 */     this.temperature = temperatureValue;
/* 18 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public JsonObject build() {
/* 24 */     JsonObject json = new JsonObject();
/* 25 */     json.addProperty("temperature", Float.valueOf(this.temperature));
/* 26 */     return json;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\builders\TemperatureData.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */