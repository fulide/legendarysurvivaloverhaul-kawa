/*    */ package sfiomn.legendarysurvivaloverhaul.api.data.json;
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.datafixers.kinds.Applicative;
/*    */ import com.mojang.datafixers.util.Function4;
/*    */ import com.mojang.serialization.Codec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ 
/*    */ public class JsonMobEffect {
/*    */   static {
/* 10 */     CODEC = RecordCodecBuilder.create(inst -> inst.group((App)Codec.STRING.fieldOf("effect").forGetter(()), (App)Codec.FLOAT.optionalFieldOf("chance", Float.valueOf(1.0F)).forGetter(()), (App)Codec.INT.fieldOf("duration").forGetter(()), (App)Codec.INT.optionalFieldOf("amplifier", Integer.valueOf(0)).forGetter(())).apply((Applicative)inst, JsonMobEffect::new));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static final Codec<JsonMobEffect> CODEC;
/*    */ 
/*    */   
/* 18 */   public static final Codec<List<JsonMobEffect>> LIST_CODEC = CODEC.listOf();
/*    */   
/*    */   public float chance;
/*    */   
/*    */   public String name;
/*    */   public int duration;
/*    */   public int amplifier;
/*    */   
/*    */   public JsonMobEffect(String name, float chance, int duration, int amplifier) {
/* 27 */     this.name = name;
/* 28 */     this.chance = (chance < 0.0F) ? 0.0F : ((chance > 1.0F) ? 1.0F : chance);
/* 29 */     this.duration = Math.max(duration, 0);
/* 30 */     this.amplifier = Math.max(amplifier, 0);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\json\JsonMobEffect.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */