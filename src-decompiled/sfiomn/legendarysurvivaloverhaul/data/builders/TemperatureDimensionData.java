/*    */ package sfiomn.legendarysurvivaloverhaul.data.builders;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureDimensionData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TemperatureDimensionData
/*    */   implements ITemperatureDimensionData
/*    */ {
/*    */   private float temperature;
/*    */   private int seaLevelHeight;
/*    */   private boolean hasAltitude;
/*    */   
/*    */   public ITemperatureDimensionData temperature(float temperatureValue) {
/* 19 */     this.temperature = temperatureValue;
/* 20 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ITemperatureDimensionData seaLevelHeight(int seaLevelHeightValue) {
/* 26 */     this.seaLevelHeight = seaLevelHeightValue;
/* 27 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ITemperatureDimensionData hasAltitude() {
/* 33 */     this.hasAltitude = true;
/* 34 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public JsonObject build() {
/* 40 */     JsonObject json = new JsonObject();
/* 41 */     json.addProperty("temperature", Float.valueOf(this.temperature));
/* 42 */     json.addProperty("sea_level_height", Integer.valueOf(this.seaLevelHeight));
/* 43 */     json.addProperty("has_altitude", Boolean.valueOf(this.hasAltitude));
/* 44 */     return json;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\builders\TemperatureDimensionData.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */