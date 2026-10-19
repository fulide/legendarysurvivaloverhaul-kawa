/*    */ package sfiomn.legendarysurvivaloverhaul.api.data.json;public class JsonBodyPartResistance { public static final Codec<JsonBodyPartResistance> CODEC; public float bodyResistance; public float headResistance;
/*    */   public float chestResistance;
/*    */   public float rightArmResistance;
/*    */   public float leftArmResistance;
/*    */   public float legsResistance;
/*    */   public float feetResistance;
/*    */   
/*    */   static {
/*  9 */     CODEC = RecordCodecBuilder.create(inst -> inst.group((App)Codec.FLOAT.optionalFieldOf("body_resistance", Float.valueOf(0.0F)).forGetter(()), (App)Codec.FLOAT.optionalFieldOf("head_resistance", Float.valueOf(0.0F)).forGetter(()), (App)Codec.FLOAT.optionalFieldOf("chest_resistance", Float.valueOf(0.0F)).forGetter(()), (App)Codec.FLOAT.optionalFieldOf("right_arm_resistance", Float.valueOf(0.0F)).forGetter(()), (App)Codec.FLOAT.optionalFieldOf("left_arm_resistance", Float.valueOf(0.0F)).forGetter(()), (App)Codec.FLOAT.optionalFieldOf("legs_resistance", Float.valueOf(0.0F)).forGetter(()), (App)Codec.FLOAT.optionalFieldOf("feet_resistance", Float.valueOf(0.0F)).forGetter(())).apply((Applicative)inst, JsonBodyPartResistance::new));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public JsonBodyPartResistance(float bodyResistance, float headResistance, float chestResistance, float rightArmResistance, float leftArmResistance, float legsResistance, float feetResistance) {
/* 31 */     this.bodyResistance = bodyResistance;
/* 32 */     this.headResistance = headResistance;
/* 33 */     this.chestResistance = chestResistance;
/* 34 */     this.rightArmResistance = rightArmResistance;
/* 35 */     this.leftArmResistance = leftArmResistance;
/* 36 */     this.legsResistance = legsResistance;
/* 37 */     this.feetResistance = feetResistance;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getBodyPartResistance(BodyPartEnum bodyPartEnum) {
/* 42 */     switch (bodyPartEnum) { default: throw new MatchException(null, null);case HEAD: case CHEST: case RIGHT_ARM: case LEFT_ARM: case RIGHT_LEG: case LEFT_LEG: case RIGHT_FOOT: case LEFT_FOOT: break; }  return 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 49 */       this.feetResistance;
/*    */   } }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\json\JsonBodyPartResistance.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */