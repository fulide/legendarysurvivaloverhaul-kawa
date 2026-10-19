package sfiomn.legendarysurvivaloverhaul.api.data.builder;

import com.google.gson.JsonObject;
import net.minecraft.world.effect.MobEffect;

public interface IThirstData {
  IThirstData hydration(int paramInt);
  
  IThirstData saturation(float paramFloat);
  
  IThirstData addEffect(MobEffect paramMobEffect, int paramInt1, float paramFloat, int paramInt2);
  
  IThirstData addEffect(MobEffect paramMobEffect, int paramInt1, int paramInt2);
  
  IThirstData addEffect(MobEffect paramMobEffect, int paramInt, float paramFloat);
  
  IThirstData addEffect(MobEffect paramMobEffect, int paramInt);
  
  IThirstData addProperty(String paramString1, String paramString2);
  
  IThirstData copy();
  
  JsonObject build();
}


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\builder\IThirstData.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */