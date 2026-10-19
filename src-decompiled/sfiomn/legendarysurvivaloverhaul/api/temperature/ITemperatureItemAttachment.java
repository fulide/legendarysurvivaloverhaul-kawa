package sfiomn.legendarysurvivaloverhaul.api.temperature;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

public interface ITemperatureItemAttachment {
  float getWorldTemperatureLevel();
  
  void setWorldTemperatureLevel(float paramFloat);
  
  boolean shouldUpdate(long paramLong);
  
  void updateWorldTemperature(Level paramLevel, Entity paramEntity, long paramLong);
}


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\temperature\ITemperatureItemAttachment.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */