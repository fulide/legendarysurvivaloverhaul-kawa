package sfiomn.legendarysurvivaloverhaul.api.thirst;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public interface IThirstAttachment {
  float getThirstExhaustion();
  
  void setExhaustion(float paramFloat);
  
  int getHydrationLevel();
  
  void setHydrationLevel(int paramInt);
  
  float getSaturationLevel();
  
  int getTickTimer();
  
  void setTickTimer(int paramInt);
  
  int getThirstDamageTickTimer();
  
  void setThirstDamageTickTimer(int paramInt);
  
  int getThirstDamageCounter();
  
  void setThirstDamageCounter(int paramInt);
  
  void setSaturation(float paramFloat);
  
  void addThirstExhaustion(float paramFloat);
  
  void addHydrationLevel(int paramInt);
  
  void addSaturationLevel(float paramFloat);
  
  void addTickTimer(int paramInt);
  
  void addThirstDamageTickTimer(int paramInt);
  
  void addThirstDamageCounter(int paramInt);
  
  boolean isHydrationLevelAtMax();
  
  boolean hasShownBlurWarning();
  
  void setShownBlurWarning(boolean paramBoolean);
  
  boolean isDirty();
  
  void setClean();
  
  void setDirty();
  
  void tickUpdate(Player paramPlayer, Level paramLevel, boolean paramBoolean);
  
  int getPacketTimer();
}


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\thirst\IThirstAttachment.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */