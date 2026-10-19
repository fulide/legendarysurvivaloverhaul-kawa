package sfiomn.legendarysurvivaloverhaul.api.bodydamage;

import java.util.List;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.lang3.tuple.Pair;

public interface IBodyDamageUtil {
  void applyConsumableHealing(Player paramPlayer, ItemStack paramItemStack, boolean paramBoolean);
  
  List<Pair<MobEffect, Integer>> getEffects(MalusBodyPartEnum paramMalusBodyPartEnum, float paramFloat);
  
  MobEffectInstance getPlayerPassiveLimbRegenerationEffect(Player paramPlayer);
  
  boolean hasPlayerFirstAidSuppliesBoostingEffect(Player paramPlayer);
  
  void applyHealingTimeBodyPart(Player paramPlayer, BodyPartEnum paramBodyPartEnum, float paramFloat, int paramInt);
  
  void healBodyPart(Player paramPlayer, BodyPartEnum paramBodyPartEnum, float paramFloat);
  
  void hurtBodyPart(Player paramPlayer, BodyPartEnum paramBodyPartEnum, float paramFloat);
  
  void balancedHurtBodyParts(Player paramPlayer, List<BodyPartEnum> paramList, float paramFloat);
  
  void randomHurtBodyParts(Player paramPlayer, List<BodyPartEnum> paramList, float paramFloat);
  
  float getHealthRatio(Player paramPlayer, BodyPartEnum paramBodyPartEnum);
  
  float getTotalRemainingHealing(Player paramPlayer, BodyPartEnum paramBodyPartEnum);
  
  float getMaxHealth(Player paramPlayer, BodyPartEnum paramBodyPartEnum);
  
  void updatePlayerBrokenHeartAttribute(Player paramPlayer);
}


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\bodydamage\IBodyDamageUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */