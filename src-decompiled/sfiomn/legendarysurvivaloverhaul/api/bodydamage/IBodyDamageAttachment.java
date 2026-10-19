package sfiomn.legendarysurvivaloverhaul.api.bodydamage;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public interface IBodyDamageAttachment {
  int getExpectedBrokenHearts();
  
  float getBodyPartDamage(BodyPartEnum paramBodyPartEnum);
  
  float getBodyPartHealthRatio(BodyPartEnum paramBodyPartEnum);
  
  float getBodyPartMaxHealth(BodyPartEnum paramBodyPartEnum);
  
  void setBodyPartDamage(BodyPartEnum paramBodyPartEnum, float paramFloat);
  
  void setBodyPartMaxHealth(BodyPartEnum paramBodyPartEnum, float paramFloat);
  
  void healWithFoodExhaustion(Player paramPlayer, BodyPartEnum paramBodyPartEnum, float paramFloat);
  
  void heal(BodyPartEnum paramBodyPartEnum, float paramFloat);
  
  void hurt(BodyPartEnum paramBodyPartEnum, float paramFloat);
  
  void applyHealingTime(BodyPartEnum paramBodyPartEnum, int paramInt, float paramFloat);
  
  int getRemainingHealingTicks(BodyPartEnum paramBodyPartEnum);
  
  float getHealingPerTicks(BodyPartEnum paramBodyPartEnum);
  
  void updateBrokenHearts(Player paramPlayer);
  
  boolean isWoundedBelow(float paramFloat);
  
  float getHealthRatioForMalusBodyPart(MalusBodyPartEnum paramMalusBodyPartEnum);
  
  void setManualDirty();
  
  boolean isDirty();
  
  void setClean();
  
  int getPacketTimer();
  
  int getHealthBlinkTimer();
  
  void tickUpdate(Player paramPlayer, Level paramLevel, boolean paramBoolean);
}


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\bodydamage\IBodyDamageAttachment.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */