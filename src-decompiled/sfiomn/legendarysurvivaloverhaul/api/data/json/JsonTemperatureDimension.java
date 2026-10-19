/*    */ package sfiomn.legendarysurvivaloverhaul.api.data.json;
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.serialization.Codec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ 
/*    */ public class JsonTemperatureDimension {
/*    */   static {
/*  8 */     CODEC = RecordCodecBuilder.create(inst -> inst.group((App)Codec.FLOAT.fieldOf("temperature").forGetter(()), (App)Codec.INT.optionalFieldOf("sea_level_height", Integer.valueOf(64)).forGetter(()), (App)Codec.BOOL.optionalFieldOf("has_altitude", Boolean.valueOf(true)).forGetter(())).apply((Applicative)inst, JsonTemperatureDimension::new));
/*    */   }
/*    */ 
/*    */   
/*    */   public static final Codec<JsonTemperatureDimension> CODEC;
/*    */   
/*    */   public float temperature;
/*    */   
/*    */   public int seaLevelHeight;
/*    */   public boolean hasAltitude;
/*    */   
/*    */   public JsonTemperatureDimension(float temperature, int seaLevelHeight, boolean hasAltitude) {
/* 20 */     this.temperature = temperature;
/* 21 */     this.seaLevelHeight = seaLevelHeight;
/* 22 */     this.hasAltitude = hasAltitude;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\json\JsonTemperatureDimension.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */