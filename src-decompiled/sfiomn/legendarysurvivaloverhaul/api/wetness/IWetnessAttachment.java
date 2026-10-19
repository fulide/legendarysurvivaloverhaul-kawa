package sfiomn.legendarysurvivaloverhaul.api.wetness;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public interface IWetnessAttachment {
  int getWetness();
  
  void setWetness(int paramInt);
  
  int getWetnessTickTimer();
  
  void setWetnessTickTimer(int paramInt);
  
  void addWetness(int paramInt);
  
  void addWetnessTickTimer(int paramInt);
  
  boolean isDirty();
  
  void setClean();
  
  void setDirty();
  
  void tickUpdate(Player paramPlayer, Level paramLevel, boolean paramBoolean);
  
  int getPacketTimer();
}


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\wetness\IWetnessAttachment.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */