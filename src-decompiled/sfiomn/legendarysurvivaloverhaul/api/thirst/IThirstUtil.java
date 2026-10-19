package sfiomn.legendarysurvivaloverhaul.api.thirst;

import java.util.List;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonMobEffect;
import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonThirstBlock;

public interface IThirstUtil {
  void takeDrink(Player paramPlayer, ItemStack paramItemStack);
  
  void takeDrink(Player paramPlayer, int paramInt, float paramFloat, List<JsonMobEffect> paramList);
  
  void takeDrink(Player paramPlayer, int paramInt, float paramFloat);
  
  void addExhaustion(Player paramPlayer, float paramFloat);
  
  JsonThirstBlock getFluidThirstLookedAt(Player paramPlayer, double paramDouble);
  
  JsonThirstBlock getBlockThirstLookedAt(Player paramPlayer, double paramDouble);
  
  void setHydrationEnumTag(ItemStack paramItemStack, HydrationEnum paramHydrationEnum);
  
  HydrationEnum getHydrationEnumTag(ItemStack paramItemStack);
  
  void removeHydrationEnumTag(ItemStack paramItemStack);
  
  void setCapacityTag(ItemStack paramItemStack, int paramInt);
  
  int getCapacityTag(ItemStack paramItemStack);
  
  void removeCapacityTag(ItemStack paramItemStack);
  
  void deactivateThirst(Player paramPlayer);
  
  void activateThirst(Player paramPlayer);
  
  boolean isThirstActive(Player paramPlayer);
}


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\thirst\IThirstUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */