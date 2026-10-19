/*    */ package sfiomn.legendarysurvivaloverhaul.api.config.json_old.bodydamage;
/*    */ 
/*    */ import com.google.gson.annotations.SerializedName;
/*    */ import java.util.List;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.BodyPartEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.DamageDistributionEnum;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JsonBodyPartsDamageSource
/*    */ {
/*    */   @SerializedName("bodyParts")
/*    */   public List<BodyPartEnum> bodyParts;
/*    */   @SerializedName("damageDistribution")
/*    */   public DamageDistributionEnum damageDistribution;
/*    */   
/*    */   public JsonBodyPartsDamageSource(DamageDistributionEnum damageDistribution, List<BodyPartEnum> bodyParts) {
/* 21 */     this.damageDistribution = damageDistribution;
/* 22 */     this.bodyParts = bodyParts;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<BodyPartEnum> getBodyParts(Player player) {
/* 27 */     return this.damageDistribution.getBodyParts(player, this.bodyParts);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\config\json_old\bodydamage\JsonBodyPartsDamageSource.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */