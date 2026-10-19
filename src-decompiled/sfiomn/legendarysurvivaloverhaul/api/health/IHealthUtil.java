package sfiomn.legendarysurvivaloverhaul.api.health;

import java.util.UUID;
import net.minecraft.world.entity.player.Player;

public interface IHealthUtil {
  void updatePlayerMaxHealthAttribute(Player paramPlayer);
  
  double getPlayerMaxHealth(Player paramPlayer);
  
  double getPlayerStableMaxHealth(Player paramPlayer);
  
  int getEffectiveBrokenHearts(Player paramPlayer);
  
  void initializeHealthAttributes(Player paramPlayer);
  
  float hurtPlayer(Player paramPlayer, float paramFloat);
  
  void loseHearth(Player paramPlayer, int paramInt);
  
  void updateBrokenHearts(Player paramPlayer, UUID paramUUID, int paramInt);
}


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\health\IHealthUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */