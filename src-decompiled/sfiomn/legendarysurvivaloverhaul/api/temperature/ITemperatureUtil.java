package sfiomn.legendarysurvivaloverhaul.api.temperature;

import java.util.UUID;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public interface ITemperatureUtil {
  float getPlayerTargetTemperature(Player paramPlayer);
  
  float getWorldTemperature(Level paramLevel, BlockPos paramBlockPos);
  
  float clampTemperature(float paramFloat);
  
  void applyConsumableTemperature(Player paramPlayer, ResourceLocation paramResourceLocation);
  
  void applyConsumableBlockTemperature(Player paramPlayer, BlockState paramBlockState);
  
  TemperatureEnum getTemperatureEnum(float paramFloat);
  
  boolean hasImmunity(Player paramPlayer, TemperatureImmunityEnum paramTemperatureImmunityEnum);
  
  void addImmunity(Player paramPlayer, TemperatureImmunityEnum paramTemperatureImmunityEnum);
  
  void removeImmunity(Player paramPlayer, TemperatureImmunityEnum paramTemperatureImmunityEnum);
  
  void addTemperatureModifier(Player paramPlayer, double paramDouble, UUID paramUUID);
  
  void addHeatResistanceModifier(Player paramPlayer, double paramDouble, UUID paramUUID);
  
  void addColdResistanceModifier(Player paramPlayer, double paramDouble, UUID paramUUID);
  
  void addThermalResistanceModifier(Player paramPlayer, double paramDouble, UUID paramUUID);
  
  void setArmorCoatTag(ItemStack paramItemStack, String paramString);
  
  String getArmorCoatTag(ItemStack paramItemStack);
  
  void removeArmorCoatTag(ItemStack paramItemStack);
}


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\temperature\ITemperatureUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */