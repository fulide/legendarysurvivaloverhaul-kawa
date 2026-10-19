/*    */ package sfiomn.legendarysurvivaloverhaul.api.data.json;
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.datafixers.kinds.Applicative;
/*    */ import com.mojang.datafixers.util.Function4;
/*    */ import com.mojang.serialization.Codec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import net.minecraft.world.effect.MobEffect;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraft.world.level.block.state.properties.Property;
/*    */ import net.neoforged.neoforge.registries.DeferredHolder;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemporaryModifierGroupEnum;
/*    */ 
/*    */ public class JsonTemperatureConsumableBlock {
/*    */   static {
/* 18 */     CODEC = RecordCodecBuilder.create(inst -> inst.group((App)Codec.STRING.fieldOf("group").forGetter(()), (App)Codec.INT.fieldOf("temperature_level").forGetter(()), (App)Codec.INT.fieldOf("duration").forGetter(()), (App)Codec.unboundedMap((Codec)Codec.STRING, (Codec)Codec.STRING).optionalFieldOf("properties", new HashMap<>()).forGetter(())).apply((Applicative)inst, JsonTemperatureConsumableBlock::new));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static final Codec<JsonTemperatureConsumableBlock> CODEC;
/*    */   
/* 25 */   public static final Codec<List<JsonTemperatureConsumableBlock>> LIST_CODEC = CODEC.listOf();
/*    */   
/*    */   public TemporaryModifierGroupEnum group;
/*    */   
/*    */   public int temperatureLevel;
/*    */   
/*    */   public int duration;
/*    */   public Map<String, String> properties;
/*    */   private DeferredHolder<MobEffect, ? extends MobEffect> effect;
/*    */   private DeferredHolder<MobEffect, ? extends MobEffect> oppositeEffect;
/*    */   
/*    */   public JsonTemperatureConsumableBlock(String group, int temperatureLevel, int duration, Map<String, String> properties) {
/* 37 */     this.temperatureLevel = temperatureLevel;
/* 38 */     this.duration = duration;
/* 39 */     this.group = TemporaryModifierGroupEnum.get(group);
/*    */     
/* 41 */     this.properties = new HashMap<>();
/* 42 */     this.properties.putAll(properties);
/*    */     
/* 44 */     this.effect = null;
/* 45 */     this.oppositeEffect = null;
/* 46 */     if (temperatureLevel > 0) {
/*    */       
/* 48 */       this.effect = this.group.hotEffect;
/* 49 */       this.oppositeEffect = this.group.coldEffect;
/* 50 */     } else if (temperatureLevel < 0) {
/*    */       
/* 52 */       this.effect = this.group.coldEffect;
/* 53 */       this.oppositeEffect = this.group.hotEffect;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public MobEffect getEffect() {
/* 59 */     return (MobEffect)this.effect.get();
/*    */   }
/*    */ 
/*    */   
/*    */   public MobEffect getOppositeEffect() {
/* 64 */     return (MobEffect)this.oppositeEffect.get();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isDefault() {
/* 69 */     return this.properties.isEmpty();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean matchesState(BlockState blockState) {
/* 74 */     for (Property<?> property : (Iterable<Property<?>>)blockState.getProperties()) {
/*    */       
/* 76 */       String name = property.getName();
/*    */       
/* 78 */       if (this.properties.containsKey(name)) {
/*    */         
/* 80 */         String stateValue = blockState.getValue(property).toString();
/*    */         
/* 82 */         if (!((String)this.properties.get(name)).equalsIgnoreCase(stateValue))
/*    */         {
/* 84 */           return false;
/*    */         }
/*    */       } 
/*    */     } 
/*    */     
/* 89 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public DeferredHolder<MobEffect, ? extends MobEffect> getEffectHolder() {
/* 94 */     return this.effect;
/*    */   }
/*    */ 
/*    */   
/*    */   public DeferredHolder<MobEffect, ? extends MobEffect> getOppositeEffectHolder() {
/* 99 */     return this.oppositeEffect;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\json\JsonTemperatureConsumableBlock.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */