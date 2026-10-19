/*    */ package sfiomn.legendarysurvivaloverhaul.data.builders;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureBiomeOverrideData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TemperatureBiomeOverrideData
/*    */   implements ITemperatureBiomeOverrideData
/*    */ {
/*    */   private float temperature;
/*    */   private boolean isDry;
/*    */   
/*    */   public ITemperatureBiomeOverrideData temperature(float temperatureValue) {
/* 18 */     this.temperature = temperatureValue;
/* 19 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ITemperatureBiomeOverrideData isDry(boolean isDry) {
/* 25 */     this.isDry = isDry;
/* 26 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public JsonObject build() {
/* 32 */     JsonObject json = new JsonObject();
/* 33 */     json.addProperty("temperature", Float.valueOf(this.temperature));
/* 34 */     json.addProperty("is_dry", Boolean.valueOf(this.isDry));
/* 35 */     return json;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\builders\TemperatureBiomeOverrideData.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */