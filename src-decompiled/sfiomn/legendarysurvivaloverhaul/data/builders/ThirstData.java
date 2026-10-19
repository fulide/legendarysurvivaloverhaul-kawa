/*     */ package sfiomn.legendarysurvivaloverhaul.data.builders;
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.effect.MobEffect;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.IThirstData;
/*     */ 
/*     */ public class ThirstData implements IThirstData {
/*     */   private final List<EffectData> effects;
/*     */   private final Map<String, String> properties;
/*     */   private int hydration;
/*     */   private float saturation;
/*     */   
/*     */   public ThirstData() {
/*  22 */     this.effects = new ArrayList<>();
/*  23 */     this.properties = new HashMap<>();
/*     */   }
/*     */ 
/*     */   
/*     */   public ThirstData(ThirstData copy) {
/*  28 */     this.hydration = copy.hydration;
/*  29 */     this.saturation = copy.saturation;
/*  30 */     this.effects = new ArrayList<>(copy.effects);
/*  31 */     this.properties = new HashMap<>(copy.properties);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IThirstData hydration(int hydrationValue) {
/*  37 */     this.hydration = hydrationValue;
/*  38 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IThirstData saturation(float saturationValue) {
/*  44 */     this.saturation = saturationValue;
/*  45 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IThirstData addEffect(MobEffect effect, int durationInTick, float chance, int amplifier) {
/*  51 */     ResourceLocation effectName = Objects.<ResourceLocation>requireNonNull(BuiltInRegistries.MOB_EFFECT.getKey(effect));
/*  52 */     this.effects.add(new EffectData(effectName, Math.max(durationInTick, 0), Math.max(amplifier, 0), Mth.clamp(chance, 0.0F, 1.0F)));
/*  53 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IThirstData addEffect(MobEffect effect, int durationInTick, float chance) {
/*  59 */     return addEffect(effect, durationInTick, chance, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IThirstData addEffect(MobEffect effect, int durationInTick, int amplifier) {
/*  65 */     return addEffect(effect, durationInTick, 0.0F, amplifier);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IThirstData addEffect(MobEffect effect, int durationInTick) {
/*  71 */     return addEffect(effect, durationInTick, 1.0F, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IThirstData addProperty(String propertyName, String propertyValue) {
/*  77 */     this.properties.put(propertyName, propertyValue);
/*  78 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IThirstData copy() {
/*  84 */     return new ThirstData(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonObject build() {
/*  90 */     JsonObject json = new JsonObject();
/*  91 */     json.addProperty("hydration", Integer.valueOf(this.hydration));
/*  92 */     json.addProperty("saturation", Float.valueOf(this.saturation));
/*     */     
/*  94 */     JsonArray jsonEffects = new JsonArray();
/*  95 */     this.effects.forEach(e -> {
/*     */           JsonObject jsonEffect = new JsonObject();
/*     */           jsonEffect.addProperty("effect", e.effect.toString());
/*     */           jsonEffect.addProperty("duration", Integer.valueOf(e.duration));
/*     */           jsonEffect.addProperty("amplifier", Integer.valueOf(e.amplifier));
/*     */           jsonEffect.addProperty("chance", Float.valueOf(e.chance));
/*     */           jsonEffects.add((JsonElement)jsonEffect);
/*     */         });
/* 103 */     json.add("effects", (JsonElement)jsonEffects);
/*     */     
/* 105 */     JsonObject jsonProperties = new JsonObject();
/* 106 */     Objects.requireNonNull(jsonProperties); this.properties.forEach(jsonProperties::addProperty);
/* 107 */     json.add("properties", (JsonElement)jsonProperties);
/* 108 */     return json;
/*     */   }
/*     */   public static final class EffectData extends Record { private final ResourceLocation effect; private final int duration; private final int amplifier; private final float chance;
/* 111 */     public EffectData(ResourceLocation effect, int duration, int amplifier, float chance) { this.effect = effect; this.duration = duration; this.amplifier = amplifier; this.chance = chance; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lsfiomn/legendarysurvivaloverhaul/data/builders/ThirstData$EffectData;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #111	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/* 111 */       //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/data/builders/ThirstData$EffectData; } public ResourceLocation effect() { return this.effect; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lsfiomn/legendarysurvivaloverhaul/data/builders/ThirstData$EffectData;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #111	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/data/builders/ThirstData$EffectData; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lsfiomn/legendarysurvivaloverhaul/data/builders/ThirstData$EffectData;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #111	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lsfiomn/legendarysurvivaloverhaul/data/builders/ThirstData$EffectData;
/* 111 */       //   0	8	1	o	Ljava/lang/Object; } public int duration() { return this.duration; } public int amplifier() { return this.amplifier; } public float chance() { return this.chance; }
/*     */      }
/*     */ 
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\builders\ThirstData.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */