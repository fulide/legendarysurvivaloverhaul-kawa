package sfiomn.legendarysurvivaloverhaul.api.data.manager;

import java.util.List;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonThirstConsumable;

public interface IThirstConsumableManager {
  List<JsonThirstConsumable> get(ResourceLocation paramResourceLocation);
  
  JsonThirstConsumable get(ItemStack paramItemStack);
}


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\manager\IThirstConsumableManager.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */