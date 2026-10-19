/*    */ package sfiomn.legendarysurvivaloverhaul.data.builders;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Objects;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureConsumableBlockData;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemporaryModifierGroupEnum;
/*    */ 
/*    */ public class TemperatureConsumableBlockData
/*    */   implements ITemperatureConsumableBlockData {
/*    */   private final Map<String, String> properties;
/*    */   private TemporaryModifierGroupEnum group;
/*    */   private int temperatureLevel;
/*    */   private int durationInTick;
/*    */   
/*    */   public TemperatureConsumableBlockData() {
/* 19 */     this.properties = new HashMap<>();
/*    */   }
/*    */ 
/*    */   
/*    */   public TemperatureConsumableBlockData(TemperatureConsumableBlockData copy) {
/* 24 */     this.group = copy.group;
/* 25 */     this.temperatureLevel = copy.temperatureLevel;
/* 26 */     this.durationInTick = copy.durationInTick;
/* 27 */     this.properties = Map.copyOf(copy.properties);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ITemperatureConsumableBlockData group(TemporaryModifierGroupEnum group) {
/* 33 */     this.group = group;
/* 34 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ITemperatureConsumableBlockData temperatureLevel(int temperatureLevel) {
/* 40 */     this.temperatureLevel = temperatureLevel;
/* 41 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ITemperatureConsumableBlockData duration(int durationInTick) {
/* 47 */     this.durationInTick = durationInTick;
/* 48 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ITemperatureConsumableBlockData addProperty(String propertyName, String propertyValue) {
/* 54 */     this.properties.put(propertyName, propertyValue);
/* 55 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ITemperatureConsumableBlockData copy() {
/* 61 */     return new TemperatureConsumableBlockData(this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public JsonObject build() {
/* 67 */     JsonObject json = new JsonObject();
/* 68 */     json.addProperty("group", this.group.name());
/* 69 */     json.addProperty("temperature_level", Integer.valueOf(this.temperatureLevel));
/* 70 */     json.addProperty("duration", Integer.valueOf(this.durationInTick));
/*    */     
/* 72 */     JsonObject jsonProperties = new JsonObject();
/* 73 */     Objects.requireNonNull(jsonProperties); this.properties.forEach(jsonProperties::addProperty);
/* 74 */     json.add("properties", (JsonElement)jsonProperties);
/*    */     
/* 76 */     return json;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\builders\TemperatureConsumableBlockData.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */