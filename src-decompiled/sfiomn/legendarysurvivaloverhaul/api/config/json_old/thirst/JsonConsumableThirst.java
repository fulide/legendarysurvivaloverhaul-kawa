/*     */ package sfiomn.legendarysurvivaloverhaul.api.config.json_old.thirst;
/*     */ import com.google.gson.annotations.SerializedName;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.core.component.DataComponents;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.component.CustomData;
/*     */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.config.json_old.JsonPropertyValue;
/*     */ 
/*     */ public class JsonConsumableThirst {
/*     */   @SerializedName("hydration")
/*     */   public int hydration;
/*     */   @SerializedName("saturation")
/*     */   public float saturation;
/*     */   @SerializedName("effects")
/*     */   public List<JsonEffectParameter> effects;
/*     */   @SerializedName("nbt")
/*     */   public Map<String, String> nbt;
/*     */   
/*     */   public JsonConsumableThirst(int hydration, float saturation, JsonEffectParameter[] effects, JsonPropertyValue... nbt) {
/*  26 */     this.hydration = hydration;
/*  27 */     this.saturation = saturation;
/*     */     
/*  29 */     this.effects = new ArrayList<>();
/*  30 */     this.effects.addAll(Arrays.asList(effects));
/*     */     
/*  32 */     this.nbt = new HashMap<>();
/*  33 */     for (JsonPropertyValue prop : nbt)
/*     */     {
/*  35 */       this.nbt.put(prop.name, prop.value);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public JsonPropertyValue[] getNbtArray() {
/*  41 */     List<JsonPropertyValue> jpvList = new ArrayList<>();
/*  42 */     for (Map.Entry<String, String> entry : this.nbt.entrySet())
/*     */     {
/*  44 */       jpvList.add(new JsonPropertyValue(entry.getKey(), entry.getValue()));
/*     */     }
/*  46 */     return jpvList.<JsonPropertyValue>toArray(new JsonPropertyValue[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean matchesNbt(ItemStack itemStack) {
/*  51 */     boolean hasCustom = itemStack.has(DataComponents.CUSTOM_DATA);
/*  52 */     if (hasCustom == this.nbt.isEmpty())
/*  53 */       return false; 
/*  54 */     CustomData custom = (CustomData)itemStack.get(DataComponents.CUSTOM_DATA);
/*  55 */     CompoundTag itemStackTag = (custom != null) ? custom.copyTag() : null;
/*     */     
/*  57 */     if (itemStackTag == null && this.nbt.isEmpty()) {
/*  58 */       return true;
/*     */     }
/*  60 */     assert itemStackTag != null;
/*     */     
/*  62 */     for (Map.Entry<String, String> nbtEntry : this.nbt.entrySet()) {
/*     */       
/*  64 */       String key = nbtEntry.getKey();
/*  65 */       String expected = nbtEntry.getValue();
/*  66 */       if (!itemStackTag.contains(key)) {
/*  67 */         return false;
/*     */       }
/*  69 */       byte tagType = itemStackTag.getTagType(key);
/*  70 */       if (tagType == 8) {
/*     */         
/*  72 */         if (!itemStackTag.getString(key).equals(expected))
/*  73 */           return false;  continue;
/*  74 */       }  if (tagType == 1 || tagType == 2 || tagType == 3 || tagType == 4 || tagType == 5 || tagType == 6) {
/*     */         
/*  76 */         if (Double.compare(itemStackTag.getDouble(key), Double.parseDouble(expected)) != 0)
/*  77 */           return false; 
/*     */         continue;
/*     */       } 
/*  80 */       LegendarySurvivalOverhaul.LOGGER.error("Error while matching nbt for {} : Tag type {} not taken into account.\nIt can either be a String (tag type 8) or a numeric (tag type in [1-6])", itemStack.getDescriptionId(), Byte.valueOf(tagType));
/*  81 */       return false;
/*     */     } 
/*     */ 
/*     */     
/*  85 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDefault() {
/*  90 */     return this.nbt.isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean matchesNbt(JsonPropertyValue... nbt) {
/*  95 */     if (nbt.length != this.nbt.size())
/*     */     {
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     for (JsonPropertyValue prop : nbt) {
/*     */       
/* 102 */       if (!this.nbt.containsKey(prop.name))
/*     */       {
/* 104 */         return false; } 
/* 105 */       if (!prop.value.equals(this.nbt.get(prop.name)))
/*     */       {
/* 107 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 111 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\config\json_old\thirst\JsonConsumableThirst.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */