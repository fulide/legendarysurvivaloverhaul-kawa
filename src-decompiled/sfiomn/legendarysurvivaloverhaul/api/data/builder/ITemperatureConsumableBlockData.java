package sfiomn.legendarysurvivaloverhaul.api.data.builder;

import com.google.gson.JsonObject;
import sfiomn.legendarysurvivaloverhaul.api.temperature.TemporaryModifierGroupEnum;

public interface ITemperatureConsumableBlockData {
  ITemperatureConsumableBlockData group(TemporaryModifierGroupEnum paramTemporaryModifierGroupEnum);
  
  ITemperatureConsumableBlockData temperatureLevel(int paramInt);
  
  ITemperatureConsumableBlockData duration(int paramInt);
  
  ITemperatureConsumableBlockData addProperty(String paramString1, String paramString2);
  
  ITemperatureConsumableBlockData copy();
  
  JsonObject build();
}


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\builder\ITemperatureConsumableBlockData.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */