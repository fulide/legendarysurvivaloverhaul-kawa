/*    */ package sfiomn.legendarysurvivaloverhaul.api.data.json;
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.serialization.Codec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ 
/*    */ public class JsonTemperature {
/*    */   static {
/*  8 */     CODEC = RecordCodecBuilder.create(inst -> inst.group((App)Codec.FLOAT.fieldOf("temperature").forGetter(())).apply((Applicative)inst, JsonTemperature::new));
/*    */   }
/*    */ 
/*    */   
/*    */   public static final Codec<JsonTemperature> CODEC;
/*    */   public float temperature;
/*    */   
/*    */   public JsonTemperature(float temperature) {
/* 16 */     this.temperature = temperature;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\json\JsonTemperature.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */