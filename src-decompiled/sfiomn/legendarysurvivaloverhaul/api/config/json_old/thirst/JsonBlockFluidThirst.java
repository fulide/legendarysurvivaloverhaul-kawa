/*     */ package sfiomn.legendarysurvivaloverhaul.api.config.json_old.thirst;
/*     */ 
/*     */ import com.google.gson.annotations.SerializedName;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.block.state.properties.Property;
/*     */ import net.minecraft.world.level.material.FluidState;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.JsonPropertyValue;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JsonBlockFluidThirst
/*     */ {
/*     */   @SerializedName("hydration")
/*     */   public int hydration;
/*     */   @SerializedName("saturation")
/*     */   public float saturation;
/*     */   
/*     */   public JsonBlockFluidThirst(int hydration, float saturation, JsonEffectParameter[] effects, JsonPropertyValue... properties) {
/*  24 */     this.hydration = hydration;
/*  25 */     this.saturation = saturation;
/*     */     
/*  27 */     this.effects = new ArrayList<>();
/*  28 */     this.effects.addAll(Arrays.asList(effects));
/*     */     
/*  30 */     this.properties = new HashMap<>();
/*  31 */     for (JsonPropertyValue prop : properties)
/*     */     {
/*  33 */       this.properties.put(prop.name, prop.value); } 
/*     */   }
/*     */   @SerializedName("effects")
/*     */   public List<JsonEffectParameter> effects; @SerializedName("properties")
/*     */   public Map<String, String> properties;
/*     */   public JsonPropertyValue[] getPropertyArray() {
/*  39 */     List<JsonPropertyValue> jpvList = new ArrayList<>();
/*  40 */     for (Map.Entry<String, String> entry : this.properties.entrySet())
/*     */     {
/*  42 */       jpvList.add(new JsonPropertyValue(entry.getKey(), entry.getValue()));
/*     */     }
/*     */     
/*  45 */     return jpvList.<JsonPropertyValue>toArray(new JsonPropertyValue[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDefault() {
/*  50 */     return this.properties.isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean matchesState(BlockState blockState) {
/*  55 */     for (Property<?> property : (Iterable<Property<?>>)blockState.getProperties()) {
/*     */       
/*  57 */       String name = property.getName();
/*     */       
/*  59 */       if (this.properties.containsKey(name)) {
/*     */         
/*  61 */         String stateValue = blockState.getValue(property).toString();
/*     */         
/*  63 */         if (!((String)this.properties.get(name)).equalsIgnoreCase(stateValue))
/*     */         {
/*  65 */           return false;
/*     */         }
/*     */         continue;
/*     */       } 
/*  69 */       return false;
/*     */     } 
/*     */ 
/*     */     
/*  73 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean matchesState(FluidState fluidState) {
/*  78 */     for (Property<?> property : (Iterable<Property<?>>)fluidState.getProperties()) {
/*     */       
/*  80 */       String name = property.getName();
/*     */       
/*  82 */       if (this.properties.containsKey(name)) {
/*     */         
/*  84 */         String stateValue = fluidState.getValue(property).toString();
/*     */         
/*  86 */         if (!((String)this.properties.get(name)).equalsIgnoreCase(stateValue))
/*     */         {
/*  88 */           return false;
/*     */         }
/*     */         continue;
/*     */       } 
/*  92 */       return false;
/*     */     } 
/*     */ 
/*     */     
/*  96 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean matchesProperties(JsonPropertyValue... props) {
/* 101 */     if (props.length != this.properties.size())
/*     */     {
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     for (JsonPropertyValue prop : props) {
/*     */       
/* 108 */       if (!this.properties.containsKey(prop.name))
/*     */       {
/* 110 */         return false;
/*     */       }
/* 112 */       if (!prop.value.equals(this.properties.get(prop.name)))
/*     */       {
/* 114 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 118 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\config\json_old\thirst\JsonBlockFluidThirst.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */