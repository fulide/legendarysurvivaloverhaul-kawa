/*     */ package sfiomn.legendarysurvivaloverhaul.api.config.json_old.temperature;
/*     */ 
/*     */ import com.google.gson.annotations.SerializedName;
/*     */ import java.util.ArrayList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JsonBlockFluidTemperature
/*     */ {
/*     */   @SerializedName("properties")
/*     */   public Map<String, String> properties;
/*     */   @SerializedName("temperature")
/*     */   public float temperature;
/*     */   
/*     */   public JsonBlockFluidTemperature(float temperature, JsonPropertyValue... props) {
/*  32 */     this.temperature = temperature;
/*  33 */     this.properties = new HashMap<>();
/*     */     
/*  35 */     for (JsonPropertyValue prop : props)
/*     */     {
/*  37 */       this.properties.put(prop.name, prop.value);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public JsonPropertyValue[] getPropertyArray() {
/*  43 */     List<JsonPropertyValue> jpvList = new ArrayList<>();
/*  44 */     for (Map.Entry<String, String> entry : this.properties.entrySet())
/*     */     {
/*  46 */       jpvList.add(new JsonPropertyValue(entry.getKey(), entry.getValue()));
/*     */     }
/*     */     
/*  49 */     return jpvList.<JsonPropertyValue>toArray(new JsonPropertyValue[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean matchesState(BlockState blockState) {
/*  54 */     for (Property<?> property : (Iterable<Property<?>>)blockState.getProperties()) {
/*     */       
/*  56 */       String name = property.getName();
/*     */       
/*  58 */       if (this.properties.containsKey(name)) {
/*     */         
/*  60 */         String stateValue = blockState.getValue(property).toString();
/*     */         
/*  62 */         if (!((String)this.properties.get(name)).equalsIgnoreCase(stateValue))
/*     */         {
/*  64 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  69 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean matchesState(FluidState fluidState) {
/*  74 */     for (Property<?> property : (Iterable<Property<?>>)fluidState.getProperties()) {
/*     */       
/*  76 */       String name = property.getName();
/*     */       
/*  78 */       if (this.properties.containsKey(name)) {
/*     */         
/*  80 */         String stateValue = fluidState.getValue(property).toString();
/*     */         
/*  82 */         if (!((String)this.properties.get(name)).equalsIgnoreCase(stateValue))
/*     */         {
/*  84 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  89 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean matchesProperties(JsonPropertyValue... props) {
/*  94 */     if (props.length != this.properties.size())
/*     */     {
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     for (JsonPropertyValue prop : props) {
/*     */       
/* 101 */       if (!this.properties.containsKey(prop.name))
/*     */       {
/* 103 */         return false;
/*     */       }
/*     */       
/* 106 */       if (!prop.value.equalsIgnoreCase(this.properties.get(prop.name)))
/*     */       {
/* 108 */         return false;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 113 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\config\json_old\temperature\JsonBlockFluidTemperature.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */