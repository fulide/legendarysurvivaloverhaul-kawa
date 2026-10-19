package sfiomn.legendarysurvivaloverhaul.api.data.builder;

import com.google.gson.JsonObject;

public interface IBodyPartResistanceData {
  IBodyPartResistanceData bodyResistance(float paramFloat);
  
  IBodyPartResistanceData headResistance(float paramFloat);
  
  IBodyPartResistanceData chestResistance(float paramFloat);
  
  IBodyPartResistanceData rightArmResistance(float paramFloat);
  
  IBodyPartResistanceData leftArmResistance(float paramFloat);
  
  IBodyPartResistanceData legsResistance(float paramFloat);
  
  IBodyPartResistanceData feetResistance(float paramFloat);
  
  JsonObject build();
}


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\builder\IBodyPartResistanceData.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */