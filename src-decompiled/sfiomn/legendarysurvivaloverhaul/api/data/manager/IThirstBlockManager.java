package sfiomn.legendarysurvivaloverhaul.api.data.manager;

import java.util.List;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonThirstBlock;

public interface IThirstBlockManager {
  List<JsonThirstBlock> get(ResourceLocation paramResourceLocation);
  
  JsonThirstBlock get(BlockState paramBlockState);
  
  JsonThirstBlock get(FluidState paramFluidState);
}


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\manager\IThirstBlockManager.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */