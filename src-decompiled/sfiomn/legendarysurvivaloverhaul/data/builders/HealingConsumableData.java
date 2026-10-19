/*    */ package sfiomn.legendarysurvivaloverhaul.data.builders;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.IHealingConsumableData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HealingConsumableData
/*    */   implements IHealingConsumableData
/*    */ {
/*    */   private int healingCharges;
/*    */   private float healingValue;
/*    */   private int healingTime;
/*    */   private int recoveryDuration;
/*    */   private int recoveryAmplifier;
/*    */   
/*    */   public IHealingConsumableData healingCharges(int healingCharges) {
/* 21 */     this.healingCharges = healingCharges;
/* 22 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IHealingConsumableData healingValue(float healingValue) {
/* 28 */     this.healingValue = healingValue;
/* 29 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IHealingConsumableData duration(int durationInTick) {
/* 35 */     this.healingTime = durationInTick;
/* 36 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IHealingConsumableData recoveryEffectDuration(int durationInTick) {
/* 42 */     this.recoveryDuration = durationInTick;
/* 43 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IHealingConsumableData recoveryEffectAmplifier(int amplifier) {
/* 49 */     this.recoveryAmplifier = amplifier;
/* 50 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public JsonObject build() {
/* 56 */     JsonObject json = new JsonObject();
/* 57 */     json.addProperty("healing_charges", Integer.valueOf(this.healingCharges));
/* 58 */     json.addProperty("healing_value", Float.valueOf(this.healingValue));
/* 59 */     json.addProperty("healing_time", Integer.valueOf(this.healingTime));
/* 60 */     json.addProperty("recovery_effect_duration", Integer.valueOf(this.recoveryDuration));
/* 61 */     json.addProperty("recovery_effect_amplifier", Integer.valueOf(this.recoveryAmplifier));
/* 62 */     return json;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\builders\HealingConsumableData.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */