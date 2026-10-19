/*    */ package sfiomn.legendarysurvivaloverhaul.api.data.json;
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.serialization.Codec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ 
/*    */ public class JsonHealingConsumable {
/*    */   static {
/*  8 */     CODEC = RecordCodecBuilder.create(inst -> inst.group((App)Codec.INT.fieldOf("healing_charges").forGetter(()), (App)Codec.FLOAT.fieldOf("healing_value").forGetter(()), (App)Codec.INT.fieldOf("healing_time").forGetter(()), (App)Codec.INT.optionalFieldOf("recovery_effect_duration", Integer.valueOf(0)).forGetter(()), (App)Codec.INT.optionalFieldOf("recovery_effect_amplifier", Integer.valueOf(0)).forGetter(())).apply((Applicative)inst, JsonHealingConsumable::new));
/*    */   }
/*    */ 
/*    */   
/*    */   public static final Codec<JsonHealingConsumable> CODEC;
/*    */   
/*    */   public int healingCharges;
/*    */   
/*    */   public float healingValue;
/*    */   
/*    */   public int healingTime;
/*    */   
/*    */   public int recoveryEffectDuration;
/*    */   public int recoveryEffectAmplifier;
/*    */   
/*    */   public JsonHealingConsumable(int healingCharges, float healingValue, int healingTime, int recoveryEffectDuration, int recoveryEffectAmplifier) {
/* 24 */     this.healingCharges = healingCharges;
/* 25 */     this.healingValue = healingValue;
/* 26 */     this.healingTime = healingTime;
/* 27 */     this.recoveryEffectDuration = recoveryEffectDuration;
/* 28 */     this.recoveryEffectAmplifier = recoveryEffectAmplifier;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\json\JsonHealingConsumable.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */