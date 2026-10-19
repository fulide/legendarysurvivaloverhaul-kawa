/*    */ package sfiomn.legendarysurvivaloverhaul.api.config.json_old.temperature;
/*    */ 
/*    */ import com.google.gson.annotations.SerializedName;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JsonBiomeIdentity
/*    */ {
/*    */   @SerializedName("temperature")
/*    */   public float temperature;
/*    */   @SerializedName("isDry")
/*    */   public boolean isDry;
/*    */   
/*    */   public JsonBiomeIdentity(float temperature) {
/* 15 */     this(temperature, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public JsonBiomeIdentity(float temperature, boolean isDry) {
/* 20 */     this.temperature = temperature;
/* 21 */     this.isDry = isDry;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\config\json_old\temperature\JsonBiomeIdentity.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */