/*    */ package sfiomn.legendarysurvivaloverhaul.data.builders;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.IBodyPartResistanceData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BodyPartResistanceData
/*    */   implements IBodyPartResistanceData
/*    */ {
/*    */   private float bodyResistance;
/*    */   private float headResistance;
/*    */   private float chestResistance;
/*    */   private float rightArmResistance;
/*    */   private float leftArmResistance;
/*    */   private float legsResistance;
/*    */   private float feetResistance;
/*    */   
/*    */   public IBodyPartResistanceData bodyResistance(float resistanceValue) {
/* 23 */     this.bodyResistance = resistanceValue;
/* 24 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IBodyPartResistanceData headResistance(float resistanceValue) {
/* 30 */     this.headResistance = resistanceValue;
/* 31 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IBodyPartResistanceData chestResistance(float resistanceValue) {
/* 37 */     this.chestResistance = resistanceValue;
/* 38 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IBodyPartResistanceData rightArmResistance(float resistanceValue) {
/* 44 */     this.rightArmResistance = resistanceValue;
/* 45 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IBodyPartResistanceData leftArmResistance(float resistanceValue) {
/* 51 */     this.leftArmResistance = resistanceValue;
/* 52 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IBodyPartResistanceData legsResistance(float resistanceValue) {
/* 58 */     this.legsResistance = resistanceValue;
/* 59 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IBodyPartResistanceData feetResistance(float resistanceValue) {
/* 65 */     this.feetResistance = resistanceValue;
/* 66 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public JsonObject build() {
/* 72 */     JsonObject json = new JsonObject();
/* 73 */     json.addProperty("body_resistance", Float.valueOf(this.bodyResistance));
/* 74 */     json.addProperty("head_resistance", Float.valueOf(this.headResistance));
/* 75 */     json.addProperty("chest_resistance", Float.valueOf(this.chestResistance));
/* 76 */     json.addProperty("right_arm_resistance", Float.valueOf(this.rightArmResistance));
/* 77 */     json.addProperty("left_arm_resistance", Float.valueOf(this.leftArmResistance));
/* 78 */     json.addProperty("legs_resistance", Float.valueOf(this.legsResistance));
/* 79 */     json.addProperty("feet_resistance", Float.valueOf(this.feetResistance));
/* 80 */     return json;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\builders\BodyPartResistanceData.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */