/*    */ package sfiomn.legendarysurvivaloverhaul.api.data.json;
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.serialization.Codec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ 
/*    */ public class JsonTemperatureBiomeOverride {
/*    */   static {
/*  8 */     CODEC = RecordCodecBuilder.create(inst -> inst.group((App)Codec.FLOAT.fieldOf("temperature").forGetter(()), (App)Codec.BOOL.fieldOf("is_dry").forGetter(())).apply((Applicative)inst, JsonTemperatureBiomeOverride::new));
/*    */   }
/*    */ 
/*    */   
/*    */   public static final Codec<JsonTemperatureBiomeOverride> CODEC;
/*    */   
/*    */   public float temperature;
/*    */   public boolean isDry;
/*    */   
/*    */   public JsonTemperatureBiomeOverride(float temperature, boolean isDry) {
/* 18 */     this.temperature = temperature;
/* 19 */     this.isDry = isDry;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\json\JsonTemperatureBiomeOverride.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */