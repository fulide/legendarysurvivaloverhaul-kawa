/*    */ package sfiomn.legendarysurvivaloverhaul.api.data.json;
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.datafixers.kinds.Applicative;
/*    */ import com.mojang.datafixers.util.Function3;
/*    */ import com.mojang.serialization.Codec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ import java.util.List;
/*    */ import net.minecraft.world.effect.MobEffect;
/*    */ import net.neoforged.neoforge.registries.DeferredHolder;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemporaryModifierGroupEnum;
/*    */ 
/*    */ public class JsonTemperatureConsumable {
/*    */   static {
/* 14 */     CODEC = RecordCodecBuilder.create(inst -> inst.group((App)Codec.STRING.fieldOf("group").forGetter(()), (App)Codec.INT.fieldOf("temperature_level").forGetter(()), (App)Codec.INT.fieldOf("duration").forGetter(())).apply((Applicative)inst, JsonTemperatureConsumable::new));
/*    */   }
/*    */ 
/*    */   
/*    */   public static final Codec<JsonTemperatureConsumable> CODEC;
/*    */   
/* 20 */   public static final Codec<List<JsonTemperatureConsumable>> LIST_CODEC = CODEC.listOf();
/*    */   
/*    */   public TemporaryModifierGroupEnum group;
/*    */   
/*    */   public int temperatureLevel;
/*    */   public int duration;
/*    */   private DeferredHolder<MobEffect, MobEffect> effect;
/*    */   private DeferredHolder<MobEffect, MobEffect> oppositeEffect;
/*    */   
/*    */   public JsonTemperatureConsumable(String group, int temperatureLevel, int duration) {
/* 30 */     this.temperatureLevel = temperatureLevel;
/* 31 */     this.duration = duration;
/* 32 */     this.group = TemporaryModifierGroupEnum.get(group);
/* 33 */     this.effect = null;
/* 34 */     this.oppositeEffect = null;
/* 35 */     if (temperatureLevel > 0) {
/*    */       
/* 37 */       this.effect = this.group.hotEffect;
/* 38 */       this.oppositeEffect = this.group.coldEffect;
/* 39 */     } else if (temperatureLevel < 0) {
/*    */       
/* 41 */       this.effect = this.group.coldEffect;
/* 42 */       this.oppositeEffect = this.group.hotEffect;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public MobEffect getEffect() {
/* 48 */     return (MobEffect)this.effect.get();
/*    */   }
/*    */ 
/*    */   
/*    */   public MobEffect getOppositeEffect() {
/* 53 */     return (MobEffect)this.oppositeEffect.get();
/*    */   }
/*    */ 
/*    */   
/*    */   public DeferredHolder<MobEffect, MobEffect> getEffectHolder() {
/* 58 */     return this.effect;
/*    */   }
/*    */ 
/*    */   
/*    */   public DeferredHolder<MobEffect, MobEffect> getOppositeEffectHolder() {
/* 63 */     return this.oppositeEffect;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\json\JsonTemperatureConsumable.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */