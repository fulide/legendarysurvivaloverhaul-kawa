/*    */ package sfiomn.legendarysurvivaloverhaul.data.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.providers.TemperatureDataProvider;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemporaryModifierGroupEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.blocks.IceFernBlock;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.blocks.SunFernBlock;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.BlockRegistry;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.ItemRegistry;
/*    */ 
/*    */ 
/*    */ public class ModTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public ModTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 21 */     super("legendarysurvivaloverhaul", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 27 */     block((Block)BlockRegistry.COOLER.get())
/* 28 */       .addTemperature(temperatureBlock(-15.0F).addProperty("lit", "true"))
/* 29 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/* 30 */     block((Block)BlockRegistry.HEATER.get())
/* 31 */       .addTemperature(temperatureBlock(15.0F).addProperty("lit", "true"))
/* 32 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/*    */     
/* 34 */     block((Block)BlockRegistry.ICE_FERN_CROP.get()).addTemperature(temperatureBlock(-1.5F).addProperty(IceFernBlock.AGE.getName(), String.valueOf(3)));
/* 35 */     block((Block)BlockRegistry.SUN_FERN_CROP.get()).addTemperature(temperatureBlock(1.5F).addProperty(SunFernBlock.AGE.getName(), String.valueOf(3)));
/*    */     
/* 37 */     block((Block)BlockRegistry.ICE_FERN_GOLD.get()).addTemperature(temperatureBlock(-1.5F).addProperty(IceFernBlock.AGE.getName(), String.valueOf(3)));
/* 38 */     block((Block)BlockRegistry.SUN_FERN_GOLD.get()).addTemperature(temperatureBlock(1.5F).addProperty(SunFernBlock.AGE.getName(), String.valueOf(3)));
/*    */     
/* 40 */     item((Item)ItemRegistry.SNOW_BOOTS.get()).coldResistance(0.5F);
/* 41 */     item((Item)ItemRegistry.SNOW_LEGGINGS.get()).coldResistance(2.5F);
/* 42 */     item((Item)ItemRegistry.SNOW_CHEST.get()).coldResistance(3.0F);
/* 43 */     item((Item)ItemRegistry.SNOW_HELMET.get()).coldResistance(1.5F);
/*    */     
/* 45 */     item((Item)ItemRegistry.DESERT_BOOTS.get()).heatResistance(0.5F);
/* 46 */     item((Item)ItemRegistry.DESERT_LEGGINGS.get()).heatResistance(2.5F);
/* 47 */     item((Item)ItemRegistry.DESERT_CHEST.get()).heatResistance(3.0F);
/* 48 */     item((Item)ItemRegistry.DESERT_HELMET.get()).heatResistance(1.5F);
/*    */     
/* 50 */     item((Item)ItemRegistry.NETHER_CHALICE.get()).temperature(2.0F);
/* 51 */     item((Item)ItemRegistry.HEAT_RESISTANCE_RING.get()).heatResistance(3.0F);
/* 52 */     item((Item)ItemRegistry.COLD_RESISTANCE_RING.get()).coldResistance(3.0F);
/* 53 */     item((Item)ItemRegistry.THERMAL_RESISTANCE_RING.get()).thermalResistance(3.0F);
/*    */     
/* 55 */     consumable((Item)ItemRegistry.MELON_JUICE.get()).addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-1).duration(1200));
/* 56 */     consumable((Item)ItemRegistry.GLISTERING_MELON_JUICE.get()).addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-2).duration(3600));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\providers\ModTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */