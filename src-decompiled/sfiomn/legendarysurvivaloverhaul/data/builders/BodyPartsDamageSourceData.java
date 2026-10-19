/*    */ package sfiomn.legendarysurvivaloverhaul.data.builders;
/*    */ 
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.BodyPartEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.DamageDistributionEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.IBodyPartsDamageSourceData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BodyPartsDamageSourceData
/*    */   implements IBodyPartsDamageSourceData
/*    */ {
/* 19 */   private final List<BodyPartEnum> bodyParts = new ArrayList<>();
/*    */   
/*    */   private DamageDistributionEnum damageDistribution;
/*    */ 
/*    */   
/*    */   public IBodyPartsDamageSourceData damageDistribution(DamageDistributionEnum damageDistribution) {
/* 25 */     this.damageDistribution = damageDistribution;
/* 26 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IBodyPartsDamageSourceData addBodyPart(BodyPartEnum bodyPart) {
/* 32 */     this.bodyParts.add(bodyPart);
/* 33 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IBodyPartsDamageSourceData addBodyParts(List<BodyPartEnum> bodyParts) {
/* 39 */     this.bodyParts.addAll(bodyParts);
/* 40 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public JsonObject build() {
/* 46 */     JsonObject json = new JsonObject();
/* 47 */     json.addProperty("damage_distribution", this.damageDistribution.name());
/*    */     
/* 49 */     JsonArray jsonBodyParts = new JsonArray();
/* 50 */     this.bodyParts.forEach(b -> jsonBodyParts.add(b.name()));
/* 51 */     json.add("body_parts", (JsonElement)jsonBodyParts);
/* 52 */     return json;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\builders\BodyPartsDamageSourceData.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */