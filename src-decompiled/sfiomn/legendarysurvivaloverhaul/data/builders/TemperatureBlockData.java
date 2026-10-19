/*    */ package sfiomn.legendarysurvivaloverhaul.data.builders;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Objects;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureBlockData;
/*    */ 
/*    */ public class TemperatureBlockData
/*    */   implements ITemperatureBlockData {
/*    */   private final Map<String, String> properties;
/*    */   private float temperature;
/*    */   
/*    */   public TemperatureBlockData() {
/* 16 */     this.properties = new HashMap<>();
/*    */   }
/*    */ 
/*    */   
/*    */   public TemperatureBlockData(TemperatureBlockData copy) {
/* 21 */     this.temperature = copy.temperature;
/* 22 */     this.properties = Map.copyOf(copy.properties);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ITemperatureBlockData temperature(float temperatureValue) {
/* 28 */     this.temperature = temperatureValue;
/* 29 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ITemperatureBlockData addProperty(String propertyName, String propertyValue) {
/* 35 */     this.properties.put(propertyName, propertyValue);
/* 36 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ITemperatureBlockData copy() {
/* 42 */     return new TemperatureBlockData(this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public JsonObject build() {
/* 48 */     JsonObject json = new JsonObject();
/* 49 */     json.addProperty("temperature", Float.valueOf(this.temperature));
/*    */     
/* 51 */     JsonObject jsonProperties = new JsonObject();
/* 52 */     Objects.requireNonNull(jsonProperties); this.properties.forEach(jsonProperties::addProperty);
/* 53 */     json.add("properties", (JsonElement)jsonProperties);
/* 54 */     return json;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\builders\TemperatureBlockData.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */