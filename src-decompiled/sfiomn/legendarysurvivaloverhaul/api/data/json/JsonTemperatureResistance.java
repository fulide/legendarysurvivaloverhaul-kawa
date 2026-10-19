/*    */ package sfiomn.legendarysurvivaloverhaul.api.data.json;
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.datafixers.util.Function4;
/*    */ import com.mojang.serialization.Codec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ 
/*    */ public class JsonTemperatureResistance {
/*    */   static {
/*  9 */     CODEC = RecordCodecBuilder.create(inst -> inst.group((App)Codec.FLOAT.optionalFieldOf("temperature", Float.valueOf(0.0F)).forGetter(()), (App)Codec.FLOAT.optionalFieldOf("heat_resistance", Float.valueOf(0.0F)).forGetter(()), (App)Codec.FLOAT.optionalFieldOf("cold_resistance", Float.valueOf(0.0F)).forGetter(()), (App)Codec.FLOAT.optionalFieldOf("thermal_resistance", Float.valueOf(0.0F)).forGetter(())).apply((Applicative)inst, JsonTemperatureResistance::new));
/*    */   }
/*    */ 
/*    */   
/*    */   public static final Codec<JsonTemperatureResistance> CODEC;
/*    */   
/*    */   public float temperature;
/*    */   
/*    */   public float heatResistance;
/*    */   
/*    */   public float coldResistance;
/*    */   public float thermalResistance;
/*    */   
/*    */   public JsonTemperatureResistance() {
/* 23 */     this(0.0F, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public JsonTemperatureResistance(float temperature) {
/* 28 */     this(temperature, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public JsonTemperatureResistance(float temperature, float heatResistance, float coldResistance, float thermalResistance) {
/* 33 */     this.temperature = temperature;
/* 34 */     this.heatResistance = heatResistance;
/* 35 */     this.coldResistance = coldResistance;
/* 36 */     this.thermalResistance = thermalResistance;
/*    */   }
/*    */ 
/*    */   
/*    */   public void add(JsonTemperatureResistance config) {
/* 41 */     this.temperature += config.temperature;
/* 42 */     this.heatResistance += config.heatResistance;
/* 43 */     this.coldResistance += config.coldResistance;
/* 44 */     this.thermalResistance += config.thermalResistance;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\json\JsonTemperatureResistance.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */