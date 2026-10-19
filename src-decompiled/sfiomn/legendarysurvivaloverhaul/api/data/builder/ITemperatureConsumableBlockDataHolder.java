package sfiomn.legendarysurvivaloverhaul.api.data.builder;

import com.google.gson.JsonArray;

public interface ITemperatureConsumableBlockDataHolder {
  ITemperatureConsumableBlockDataHolder addTemperature(ITemperatureConsumableBlockData paramITemperatureConsumableBlockData);
  
  JsonArray build();
}


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\builder\ITemperatureConsumableBlockDataHolder.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */