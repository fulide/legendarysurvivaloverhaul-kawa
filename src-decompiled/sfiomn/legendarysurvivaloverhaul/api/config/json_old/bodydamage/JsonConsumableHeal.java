/*    */ package sfiomn.legendarysurvivaloverhaul.api.config.json_old.bodydamage;
/*    */ 
/*    */ import com.google.gson.annotations.SerializedName;
/*    */ 
/*    */ 
/*    */ public class JsonConsumableHeal
/*    */ {
/*    */   @SerializedName("healingCharges")
/*    */   public int healingCharges;
/*    */   @SerializedName("healingValue")
/*    */   public float healingValue;
/*    */   @SerializedName("healingTime")
/*    */   public int healingTime;
/*    */   
/*    */   public JsonConsumableHeal(int healingCharges, float healingValue, int healingTime) {
/* 16 */     this.healingCharges = healingCharges;
/* 17 */     this.healingValue = healingValue;
/* 18 */     this.healingTime = healingTime;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\config\json_old\bodydamage\JsonConsumableHeal.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */