/*    */ package sfiomn.legendarysurvivaloverhaul.api.config.json_old.thirst;
/*    */ 
/*    */ import com.google.gson.annotations.SerializedName;
/*    */ 
/*    */ 
/*    */ public class JsonEffectParameter
/*    */ {
/*    */   @SerializedName("chance")
/*    */   public float chance;
/*    */   @SerializedName("effect")
/*    */   public String name;
/*    */   @SerializedName("duration")
/*    */   public int duration;
/*    */   @SerializedName("amplifier")
/*    */   public int amplifier;
/*    */   
/*    */   public JsonEffectParameter(String name, float chance, int duration, int amplifier) {
/* 18 */     this.name = name;
/* 19 */     this.chance = (chance < 0.0F) ? 0.0F : ((chance > 1.0F) ? 1.0F : chance);
/* 20 */     this.duration = Math.max(duration, 0);
/* 21 */     this.amplifier = Math.max(amplifier, 0);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\config\json_old\thirst\JsonEffectParameter.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */