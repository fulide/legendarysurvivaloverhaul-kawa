/*    */ package sfiomn.legendarysurvivaloverhaul.api.data.json;
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.datafixers.kinds.Applicative;
/*    */ import com.mojang.datafixers.util.Function4;
/*    */ import com.mojang.serialization.Codec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import net.minecraft.core.component.DataComponents;
/*    */ import net.minecraft.nbt.CompoundTag;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.component.CustomData;
/*    */ 
/*    */ public class JsonThirstConsumable {
/*    */   static {
/* 18 */     CODEC = RecordCodecBuilder.create(inst -> inst.group((App)Codec.INT.fieldOf("hydration").forGetter(()), (App)Codec.FLOAT.fieldOf("saturation").forGetter(()), (App)JsonMobEffect.LIST_CODEC.optionalFieldOf("effects", new ArrayList()).forGetter(()), (App)Codec.unboundedMap((Codec)Codec.STRING, (Codec)Codec.STRING).optionalFieldOf("properties", new HashMap<>()).forGetter(())).apply((Applicative)inst, JsonThirstConsumable::new));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static final Codec<JsonThirstConsumable> CODEC;
/*    */   
/* 25 */   public static final Codec<List<JsonThirstConsumable>> LIST_CODEC = CODEC.listOf();
/*    */   
/*    */   public int hydration;
/*    */   
/*    */   public float saturation;
/*    */   
/*    */   public List<JsonMobEffect> effects;
/*    */   public Map<String, String> properties;
/*    */   
/*    */   public JsonThirstConsumable(int hydration, float saturation, List<JsonMobEffect> effects, Map<String, String> properties) {
/* 35 */     this.hydration = hydration;
/* 36 */     this.saturation = saturation;
/*    */     
/* 38 */     this.effects = new ArrayList<>();
/* 39 */     this.effects.addAll(effects);
/*    */     
/* 41 */     this.properties = new HashMap<>();
/* 42 */     this.properties.putAll(properties);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isDefault() {
/* 47 */     return this.properties.isEmpty();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean matchesNbt(ItemStack itemStack) {
/* 52 */     boolean hasCustom = itemStack.has(DataComponents.CUSTOM_DATA);
/* 53 */     if (hasCustom == this.properties.isEmpty()) {
/* 54 */       return false;
/*    */     }
/* 56 */     CustomData custom = (CustomData)itemStack.get(DataComponents.CUSTOM_DATA);
/* 57 */     CompoundTag itemStackTag = (custom != null) ? custom.copyTag() : null;
/*    */     
/* 59 */     if (itemStackTag == null && this.properties.isEmpty()) {
/* 60 */       return true;
/*    */     }
/* 62 */     assert itemStackTag != null;
/*    */     
/* 64 */     for (Map.Entry<String, String> nbtEntry : this.properties.entrySet()) {
/*    */       
/* 66 */       if (!itemStackTag.contains(nbtEntry.getKey())) {
/* 67 */         return false;
/*    */       }
/* 69 */       byte tagType = itemStackTag.getTagType(nbtEntry.getKey());
/*    */       
/* 71 */       if (tagType == 8) {
/*    */         
/* 73 */         if (!itemStackTag.getString(nbtEntry.getKey()).equals(nbtEntry.getValue()))
/* 74 */           return false; 
/*    */         continue;
/*    */       } 
/* 77 */       if (tagType == 1 || tagType == 2 || tagType == 3 || tagType == 4 || tagType == 5 || tagType == 6) {
/*    */         
/* 79 */         if (itemStackTag.getDouble(nbtEntry.getKey()) != Double.parseDouble(nbtEntry.getValue()))
/* 80 */           return false;  continue;
/*    */       } 
/* 82 */       LegendarySurvivalOverhaul.LOGGER.error("Error while matching nbt for {} : Tag type {} not taken into account.\nIt can either be a String (tag type 8) or a numeric (tag type in [1-6])", itemStack
/* 83 */           .getDescriptionId(), Byte.valueOf(tagType));
/*    */     } 
/*    */ 
/*    */     
/* 87 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\json\JsonThirstConsumable.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */