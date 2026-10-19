package sfiomn.legendarysurvivaloverhaul.api.wetness;

import net.minecraft.world.entity.player.Player;

public interface IWetnessUtil {
  void addWetness(Player paramPlayer, int paramInt);
  
  void deactivateWetness(Player paramPlayer);
  
  void activateWetness(Player paramPlayer);
  
  boolean isWetnessActive(Player paramPlayer);
}


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\wetness\IWetnessUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */