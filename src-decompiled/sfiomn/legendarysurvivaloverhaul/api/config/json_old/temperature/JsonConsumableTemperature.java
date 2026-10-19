/*    */ package sfiomn.legendarysurvivaloverhaul.api.config.json_old.temperature;
/*    */ 
/*    */ import net.minecraft.world.effect.MobEffect;
/*    */ import net.neoforged.neoforge.registries.DeferredHolder;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemporaryModifierGroupEnum;
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
/*    */ public class JsonConsumableTemperature
/*    */ {
/*    */   public TemporaryModifierGroupEnum group;
/*    */   public int temperatureLevel;
/*    */   public int duration;
/*    */   private DeferredHolder<MobEffect, MobEffect> effect;
/*    */   private DeferredHolder<MobEffect, MobEffect> oppositeEffect;
/*    */   
/*    */   public JsonConsumableTemperature(TemporaryModifierGroupEnum group, int temperatureLevel, int duration) {
/* 25 */     this.temperatureLevel = temperatureLevel;
/* 26 */     this.duration = duration;
/* 27 */     this.group = group;
/* 28 */     this.effect = null;
/* 29 */     this.oppositeEffect = null;
/* 30 */     if (temperatureLevel > 0) {
/*    */       
/* 32 */       this.effect = group.hotEffect;
/* 33 */       this.oppositeEffect = group.coldEffect;
/* 34 */     } else if (temperatureLevel < 0) {
/*    */       
/* 36 */       this.effect = group.coldEffect;
/* 37 */       this.oppositeEffect = group.hotEffect;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public MobEffect getEffect() {
/* 43 */     return (MobEffect)this.effect.get();
/*    */   }
/*    */ 
/*    */   
/*    */   public MobEffect getOppositeEffect() {
/* 48 */     return (MobEffect)this.oppositeEffect.get();
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\config\json_old\temperature\JsonConsumableTemperature.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */