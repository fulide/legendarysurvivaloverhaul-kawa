/*    */ package sfiomn.legendarysurvivaloverhaul.data.builders;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.block.ThermalTypeEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureFuelItemData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TemperatureFuelItemData
/*    */   implements ITemperatureFuelItemData
/*    */ {
/*    */   private ThermalTypeEnum thermalType;
/*    */   private int duration;
/*    */   
/*    */   public ITemperatureFuelItemData thermalType(ThermalTypeEnum thermalType) {
/* 19 */     this.thermalType = thermalType;
/* 20 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ITemperatureFuelItemData duration(int durationInTicks) {
/* 26 */     this.duration = durationInTicks;
/* 27 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public JsonObject build() {
/* 33 */     JsonObject json = new JsonObject();
/* 34 */     json.addProperty("thermal_type", this.thermalType.name());
/* 35 */     json.addProperty("duration", Integer.valueOf(this.duration));
/* 36 */     return json;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\builders\TemperatureFuelItemData.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */