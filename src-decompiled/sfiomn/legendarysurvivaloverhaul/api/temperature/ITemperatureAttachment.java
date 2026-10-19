package sfiomn.legendarysurvivaloverhaul.api.temperature;

import java.util.List;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public interface ITemperatureAttachment {
  float getTemperatureLevel();
  
  void setTemperatureLevel(float paramFloat);
  
  float getTargetTemperatureLevel();
  
  void setTargetTemperatureLevel(float paramFloat);
  
  int getTemperatureTickTimer();
  
  void setTemperatureTickTimer(int paramInt);
  
  int getFreezeTickTimer();
  
  void setFreezeTickTimer(int paramInt);
  
  TemperatureEnum getTemperatureEnum();
  
  List<Integer> getTemperatureImmunities();
  
  void addTemperatureLevel(float paramFloat);
  
  void addTemperatureTickTimer(int paramInt);
  
  void addFreezeTickTimer(int paramInt);
  
  void addTemperatureImmunityId(int paramInt);
  
  void removeTemperatureImmunityId(int paramInt);
  
  void tickUpdate(Player paramPlayer, Level paramLevel, boolean paramBoolean);
  
  void tickClient(Player paramPlayer, boolean paramBoolean);
  
  boolean isDirty();
  
  void setClean();
  
  int getPacketTimer();
}


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\temperature\ITemperatureAttachment.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */