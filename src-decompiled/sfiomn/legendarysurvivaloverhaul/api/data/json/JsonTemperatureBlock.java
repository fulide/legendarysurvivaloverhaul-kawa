/*     */ package sfiomn.legendarysurvivaloverhaul.api.data.json;
/*     */ import com.mojang.datafixers.kinds.App;
/*     */ import com.mojang.datafixers.kinds.Applicative;
/*     */ import com.mojang.serialization.Codec;
/*     */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.function.BiFunction;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.world.level.block.entity.BlockEntity;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.block.state.properties.Property;
/*     */ import net.minecraft.world.level.material.FluidState;
/*     */ 
/*     */ public class JsonTemperatureBlock {
/*     */   static {
/*  17 */     CODEC = RecordCodecBuilder.create(inst -> inst.group((App)Codec.FLOAT.fieldOf("temperature").forGetter(()), (App)Codec.unboundedMap((Codec)Codec.STRING, (Codec)Codec.STRING).optionalFieldOf("properties", new HashMap<>()).forGetter(())).apply((Applicative)inst, JsonTemperatureBlock::new));
/*     */   }
/*     */ 
/*     */   
/*     */   public static final Codec<JsonTemperatureBlock> CODEC;
/*  22 */   public static final Codec<List<JsonTemperatureBlock>> LIST_CODEC = CODEC.listOf();
/*     */   
/*     */   public float temperature;
/*     */   
/*     */   public Map<String, String> properties;
/*     */ 
/*     */   
/*     */   public JsonTemperatureBlock(float temperature, Map<String, String> properties) {
/*  30 */     this.temperature = temperature;
/*     */     
/*  32 */     this.properties = new HashMap<>();
/*  33 */     this.properties.putAll(properties);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDefault() {
/*  38 */     return this.properties.isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean matchesBlockEntity(BlockEntity blockEntity) {
/*  43 */     CompoundTag blockEntityTag = blockEntity.saveWithFullMetadata((HolderLookup.Provider)blockEntity.getLevel().registryAccess());
/*  44 */     for (Map.Entry<String, String> property : this.properties.entrySet()) {
/*     */       
/*  46 */       String name = property.getKey();
/*     */       
/*  48 */       if (blockEntityTag.contains(name)) {
/*     */         
/*  50 */         String stateValue = String.valueOf(blockEntityTag.get(name));
/*     */         
/*  52 */         if (!((String)property.getValue()).equalsIgnoreCase(stateValue))
/*     */         {
/*  54 */           return false;
/*     */         }
/*     */         continue;
/*     */       } 
/*  58 */       return false;
/*     */     } 
/*     */ 
/*     */     
/*  62 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean matchesState(BlockState blockState) {
/*  67 */     for (Property<?> property : (Iterable<Property<?>>)blockState.getProperties()) {
/*     */       
/*  69 */       String name = property.getName();
/*     */       
/*  71 */       if (this.properties.containsKey(name)) {
/*     */         
/*  73 */         String stateValue = blockState.getValue(property).toString();
/*     */         
/*  75 */         if (!((String)this.properties.get(name)).equalsIgnoreCase(stateValue))
/*     */         {
/*  77 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  82 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean matchesState(FluidState fluidState) {
/*  87 */     for (Property<?> property : (Iterable<Property<?>>)fluidState.getProperties()) {
/*     */       
/*  89 */       String name = property.getName();
/*     */       
/*  91 */       if (this.properties.containsKey(name)) {
/*     */         
/*  93 */         String stateValue = fluidState.getValue(property).toString();
/*     */         
/*  95 */         if (!((String)this.properties.get(name)).equalsIgnoreCase(stateValue))
/*     */         {
/*  97 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 102 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\json\JsonTemperatureBlock.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */