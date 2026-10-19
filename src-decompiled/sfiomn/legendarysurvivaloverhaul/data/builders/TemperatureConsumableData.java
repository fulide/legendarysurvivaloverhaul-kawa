/*    */ package sfiomn.legendarysurvivaloverhaul.data.builders;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureConsumableBlockData;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureConsumableData;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemporaryModifierGroupEnum;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TemperatureConsumableData
/*    */   implements ITemperatureConsumableData
/*    */ {
/*    */   private TemporaryModifierGroupEnum group;
/*    */   private int temperatureLevel;
/*    */   private int durationInTick;
/*    */   
/*    */   public TemperatureConsumableData() {}
/*    */   
/*    */   public TemperatureConsumableData(TemperatureConsumableData copy) {
/* 20 */     this.group = copy.group;
/* 21 */     this.temperatureLevel = copy.temperatureLevel;
/* 22 */     this.durationInTick = copy.durationInTick;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ITemperatureConsumableData group(TemporaryModifierGroupEnum group) {
/* 28 */     this.group = group;
/* 29 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ITemperatureConsumableData temperatureLevel(int temperatureLevel) {
/* 35 */     this.temperatureLevel = temperatureLevel;
/* 36 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ITemperatureConsumableData duration(int durationInTick) {
/* 42 */     this.durationInTick = durationInTick;
/* 43 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ITemperatureConsumableBlockData asBlock() {
/* 49 */     return (new TemperatureConsumableBlockData()).duration(this.durationInTick).temperatureLevel(this.temperatureLevel).group(this.group);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ITemperatureConsumableData copy() {
/* 55 */     return new TemperatureConsumableData(this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public JsonObject build() {
/* 61 */     JsonObject json = new JsonObject();
/* 62 */     json.addProperty("group", this.group.name());
/* 63 */     json.addProperty("temperature_level", Integer.valueOf(this.temperatureLevel));
/* 64 */     json.addProperty("duration", Integer.valueOf(this.durationInTick));
/*    */     
/* 66 */     return json;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\builders\TemperatureConsumableData.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */