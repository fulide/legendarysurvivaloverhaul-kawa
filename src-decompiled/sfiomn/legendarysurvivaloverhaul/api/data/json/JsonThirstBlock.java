/*    */ package sfiomn.legendarysurvivaloverhaul.api.data.json;
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.datafixers.util.Function4;
/*    */ import com.mojang.serialization.Codec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraft.world.level.block.state.properties.Property;
/*    */ import net.minecraft.world.level.material.FluidState;
/*    */ 
/*    */ public class JsonThirstBlock {
/*    */   static {
/* 16 */     CODEC = RecordCodecBuilder.create(inst -> inst.group((App)Codec.INT.fieldOf("hydration").forGetter(()), (App)Codec.FLOAT.fieldOf("saturation").forGetter(()), (App)JsonMobEffect.LIST_CODEC.optionalFieldOf("effects", new ArrayList()).forGetter(()), (App)Codec.unboundedMap((Codec)Codec.STRING, (Codec)Codec.STRING).optionalFieldOf("properties", new HashMap<>()).forGetter(())).apply((Applicative)inst, JsonThirstBlock::new));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static final Codec<JsonThirstBlock> CODEC;
/*    */   
/* 23 */   public static final Codec<List<JsonThirstBlock>> LIST_CODEC = CODEC.listOf();
/*    */   
/*    */   public int hydration;
/*    */   
/*    */   public float saturation;
/*    */   
/*    */   public List<JsonMobEffect> effects;
/*    */   public Map<String, String> properties;
/*    */   
/*    */   public JsonThirstBlock(int hydration, float saturation, List<JsonMobEffect> effects, Map<String, String> properties) {
/* 33 */     this.hydration = hydration;
/* 34 */     this.saturation = saturation;
/*    */     
/* 36 */     this.effects = new ArrayList<>();
/* 37 */     this.effects.addAll(effects);
/*    */     
/* 39 */     this.properties = new HashMap<>();
/* 40 */     this.properties.putAll(properties);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isDefault() {
/* 45 */     return this.properties.isEmpty();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean matchesState(BlockState blockState) {
/* 51 */     for (Property<?> property : (Iterable<Property<?>>)blockState.getProperties()) {
/*    */       
/* 53 */       String name = property.getName();
/*    */       
/* 55 */       if (this.properties.containsKey(name)) {
/*    */         
/* 57 */         String stateValue = blockState.getValue(property).toString();
/*    */         
/* 59 */         if (!((String)this.properties.get(name)).equalsIgnoreCase(stateValue))
/*    */         {
/* 61 */           return false;
/*    */         }
/*    */       } 
/*    */     } 
/*    */     
/* 66 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean matchesState(FluidState fluidState) {
/* 71 */     for (Property<?> property : (Iterable<Property<?>>)fluidState.getProperties()) {
/*    */       
/* 73 */       String name = property.getName();
/*    */       
/* 75 */       if (this.properties.containsKey(name)) {
/*    */         
/* 77 */         String stateValue = fluidState.getValue(property).toString();
/*    */         
/* 79 */         if (!((String)this.properties.get(name)).equalsIgnoreCase(stateValue))
/*    */         {
/* 81 */           return false;
/*    */         }
/*    */       } 
/*    */     } 
/*    */     
/* 86 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\json\JsonThirstBlock.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */