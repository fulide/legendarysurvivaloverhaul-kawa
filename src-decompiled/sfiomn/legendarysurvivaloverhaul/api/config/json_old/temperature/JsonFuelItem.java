/*    */ package sfiomn.legendarysurvivaloverhaul.api.config.json_old.temperature;
/*    */ 
/*    */ import com.google.gson.annotations.SerializedName;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.block.ThermalTypeEnum;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JsonFuelItem
/*    */ {
/*    */   @SerializedName("thermalType")
/*    */   public ThermalTypeEnum thermalType;
/*    */   @SerializedName("fuelValue")
/*    */   public int fuelValue;
/*    */   
/*    */   public JsonFuelItem(ThermalTypeEnum thermalType, int fuelValue) {
/* 16 */     this.thermalType = thermalType;
/* 17 */     this.fuelValue = fuelValue;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\config\json_old\temperature\JsonFuelItem.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */