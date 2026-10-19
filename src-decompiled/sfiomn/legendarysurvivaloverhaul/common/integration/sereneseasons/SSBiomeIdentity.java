/*    */ package sfiomn.legendarysurvivaloverhaul.common.integration.sereneseasons;
/*    */ 
/*    */ import com.google.gson.annotations.SerializedName;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSBiomeIdentity
/*    */ {
/*    */   @SerializedName("enable_seasonal_effects")
/*    */   public boolean seasonEffects;
/*    */   @SerializedName("use_tropical_seasons")
/*    */   public boolean isTropical;
/*    */   
/*    */   public SSBiomeIdentity(boolean isTropical) {
/* 20 */     this(true, isTropical);
/*    */   }
/*    */ 
/*    */   
/*    */   public SSBiomeIdentity(boolean seasonEffects, boolean isTropical) {
/* 25 */     this.seasonEffects = seasonEffects;
/* 26 */     this.isTropical = isTropical;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\sereneseasons\SSBiomeIdentity.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */