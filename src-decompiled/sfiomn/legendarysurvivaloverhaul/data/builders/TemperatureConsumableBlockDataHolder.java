/*    */ package sfiomn.legendarysurvivaloverhaul.data.builders;
/*    */ 
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureConsumableBlockData;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureConsumableBlockDataHolder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TemperatureConsumableBlockDataHolder
/*    */   implements ITemperatureConsumableBlockDataHolder
/*    */ {
/* 16 */   private final List<ITemperatureConsumableBlockData> temperatureDataList = new ArrayList<>();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ITemperatureConsumableBlockDataHolder addTemperature(ITemperatureConsumableBlockData temperatureData) {
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


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\builders\TemperatureConsumableBlockDataHolder.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */