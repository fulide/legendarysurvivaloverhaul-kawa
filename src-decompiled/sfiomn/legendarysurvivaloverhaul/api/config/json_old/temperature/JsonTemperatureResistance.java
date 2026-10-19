/*    */ package sfiomn.legendarysurvivaloverhaul.api.config.json_old.temperature;
/*    */ 
/*    */ import com.google.gson.annotations.SerializedName;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JsonTemperatureResistance
/*    */ {
/*    */   @SerializedName("temperature")
/*    */   public float temperature;
/*    */   @SerializedName("heat_resistance")
/*    */   public float heatResistance;
/*    */   @SerializedName("cold_resistance")
/*    */   public float coldResistance;
/*    */   @SerializedName("thermal_resistance")
/*    */   public float thermalResistance;
/*    */   
/*    */   public JsonTemperatureResistance() {
/* 21 */     this(0.0F, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public JsonTemperatureResistance(float temperature) {
/* 26 */     this(temperature, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public JsonTemperatureResistance(float temperature, float heatResistance, float coldResistance, float thermalResistance) {
/* 31 */     this.temperature = temperature;
/* 32 */     this.heatResistance = heatResistance;
/* 33 */     this.coldResistance = coldResistance;
/* 34 */     this.thermalResistance = thermalResistance;
/*    */   }
/*    */ 
/*    */   
/*    */   public void add(JsonTemperatureResistance config) {
/* 39 */     this.temperature += config.temperature;
/* 40 */     this.heatResistance += config.heatResistance;
/* 41 */     this.coldResistance += config.coldResistance;
/* 42 */     this.thermalResistance += config.thermalResistance;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\config\json_old\temperature\JsonTemperatureResistance.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */