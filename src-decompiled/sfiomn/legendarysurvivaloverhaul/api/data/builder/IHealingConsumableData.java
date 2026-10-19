package sfiomn.legendarysurvivaloverhaul.api.data.builder;

import com.google.gson.JsonObject;

public interface IHealingConsumableData {
  IHealingConsumableData healingCharges(int paramInt);
  
  IHealingConsumableData healingValue(float paramFloat);
  
  IHealingConsumableData duration(int paramInt);
  
  IHealingConsumableData recoveryEffectDuration(int paramInt);
  
  IHealingConsumableData recoveryEffectAmplifier(int paramInt);
  
  JsonObject build();
}


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\builder\IHealingConsumableData.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */