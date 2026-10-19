package sfiomn.legendarysurvivaloverhaul.api.data.builder;

import com.google.gson.JsonObject;

public interface ITemperatureResistanceData {
  ITemperatureResistanceData temperature(float paramFloat);
  
  ITemperatureResistanceData heatResistance(float paramFloat);
  
  ITemperatureResistanceData coldResistance(float paramFloat);
  
  ITemperatureResistanceData thermalResistance(float paramFloat);
  
  JsonObject build();
}


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\builder\ITemperatureResistanceData.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */