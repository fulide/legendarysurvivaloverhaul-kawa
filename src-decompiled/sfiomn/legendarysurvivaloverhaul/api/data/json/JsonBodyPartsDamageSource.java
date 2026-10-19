/*    */ package sfiomn.legendarysurvivaloverhaul.api.data.json;
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.datafixers.kinds.Applicative;
/*    */ import com.mojang.serialization.Codec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ import java.util.List;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.BodyPartEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.DamageDistributionEnum;
/*    */ 
/*    */ public class JsonBodyPartsDamageSource {
/*    */   static {
/* 13 */     CODEC = RecordCodecBuilder.create(inst -> inst.group((App)Codec.STRING.fieldOf("damage_distribution").forGetter(()), (App)Codec.STRING.listOf().fieldOf("body_parts").forGetter(())).apply((Applicative)inst, JsonBodyPartsDamageSource::new));
/*    */   }
/*    */ 
/*    */   
/*    */   public static final Codec<JsonBodyPartsDamageSource> CODEC;
/*    */   
/*    */   public List<BodyPartEnum> bodyParts;
/*    */   public DamageDistributionEnum damageDistribution;
/*    */   
/*    */   public JsonBodyPartsDamageSource(String damageDistribution, List<String> bodyParts) {
/* 23 */     this.damageDistribution = DamageDistributionEnum.get(damageDistribution);
/* 24 */     this.bodyParts = bodyParts.stream().map(BodyPartEnum::get).toList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<BodyPartEnum> getBodyParts(Player player) {
/* 29 */     return this.damageDistribution.getBodyParts(player, this.bodyParts);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\json\JsonBodyPartsDamageSource.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */