/*    */ package sfiomn.legendarysurvivaloverhaul.data.builders;
/*    */ 
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureConsumableData;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureConsumableDataHolder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TemperatureConsumableDataHolder
/*    */   implements ITemperatureConsumableDataHolder
/*    */ {
/* 16 */   private final List<ITemperatureConsumableData> temperatureDataList = new ArrayList<>();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ITemperatureConsumableDataHolder addTemperature(ITemperatureConsumableData temperatureData) {
/* 22 */     this.temperatureDataList.add(temperatureData.copy());
/* 23 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public JsonArray build() {
/* 29 */     JsonArray json = new JsonArray();
/* 30 */     this.temperatureDataList.forEach(t -> json.add((JsonElement)t.build()));
/* 31 */     return json;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\builders\TemperatureConsumableDataHolder.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */