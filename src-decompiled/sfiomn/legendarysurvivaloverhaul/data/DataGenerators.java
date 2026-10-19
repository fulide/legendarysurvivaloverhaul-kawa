/*    */ package sfiomn.legendarysurvivaloverhaul.data;
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.DataGenerator;
/*    */ import net.minecraft.data.DataProvider;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.neoforged.bus.api.SubscribeEvent;
/*    */ import net.neoforged.fml.common.EventBusSubscriber;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import net.neoforged.neoforge.data.event.GatherDataEvent;
/*    */ import sfiomn.legendarysurvivaloverhaul.data.providers.MinecraftThirstProvider;
/*    */ import sfiomn.legendarysurvivaloverhaul.data.providers.ModBlockTagProvider;
/*    */ import sfiomn.legendarysurvivaloverhaul.data.providers.ModDamageTypeTagsProvider;
/*    */ import sfiomn.legendarysurvivaloverhaul.data.providers.ModDatapackBuiltinEntriesProvider;
/*    */ import sfiomn.legendarysurvivaloverhaul.data.providers.ModEnchantmentTagProvider;
/*    */ import sfiomn.legendarysurvivaloverhaul.data.providers.ModEntityTypesTagProvider;
/*    */ import sfiomn.legendarysurvivaloverhaul.data.providers.ModThirstProvider;
/*    */ 
/*    */ @EventBusSubscriber(modid = "legendarysurvivaloverhaul", bus = EventBusSubscriber.Bus.MOD)
/*    */ public final class DataGenerators {
/*    */   @SubscribeEvent(priority = EventPriority.LOWEST)
/*    */   public static void gatherData(GatherDataEvent event) {
/* 23 */     DataGenerator gen = event.getGenerator();
/* 24 */     PackOutput packOutput = gen.getPackOutput();
/* 25 */     ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
/* 26 */     CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
/*    */     
/* 28 */     gen.addProvider(event.includeClient(), (DataProvider)new ModBlockStateProvider(packOutput, existingFileHelper));
/* 29 */     gen.addProvider(event.includeClient(), (DataProvider)new ModItemModelProvider(packOutput, existingFileHelper));
/*    */ 
/*    */     
/* 32 */     ModDatapackBuiltinEntriesProvider datapackProvider = (ModDatapackBuiltinEntriesProvider)gen.addProvider(event.includeServer(), (DataProvider)new ModDatapackBuiltinEntriesProvider(packOutput, lookupProvider));
/* 33 */     CompletableFuture<HolderLookup.Provider> lookupWithCustom = datapackProvider.getRegistryProvider();
/*    */     
/* 35 */     gen.addProvider(event.includeServer(), (DataProvider)new ModEntityTypesTagProvider(packOutput, lookupWithCustom, existingFileHelper));
/* 36 */     gen.addProvider(event.includeServer(), (DataProvider)new ModDamageTypeTagsProvider(packOutput, lookupWithCustom, existingFileHelper));
/* 37 */     gen.addProvider(event.includeServer(), (DataProvider)new ModEnchantmentTagProvider(packOutput, lookupWithCustom, existingFileHelper));
/* 38 */     gen.addProvider(event.includeServer(), (DataProvider)new ModRecipeProvider(packOutput, lookupWithCustom));
/* 39 */     gen.addProvider(event.includeServer(), (DataProvider)ModLootTableProvider.createLootTables(packOutput, lookupWithCustom));
/* 40 */     gen.addProvider(event.includeServer(), (DataProvider)new ModAdvancementProvider(packOutput, lookupWithCustom, existingFileHelper));
/*    */     
/* 42 */     ModBlockTagProvider blockTagProvider = (ModBlockTagProvider)gen.addProvider(event.includeServer(), (DataProvider)new ModBlockTagProvider(packOutput, lookupWithCustom, existingFileHelper));
/*    */     
/* 44 */     gen.addProvider(event.includeServer(), (DataProvider)new ModItemTagProvider(packOutput, lookupWithCustom, blockTagProvider.contentsGetter(), existingFileHelper));
/*    */     
/* 46 */     gen.addProvider(event.includeServer(), (DataProvider)new ModGlobalLootModifierProvider(packOutput, lookupWithCustom));
/* 47 */     gen.addProvider(event.includeServer(), (DataProvider)new ModTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/* 48 */     gen.addProvider(event.includeServer(), (DataProvider)new ModThirstProvider(packOutput, lookupProvider, existingFileHelper));
/* 49 */     gen.addProvider(event.includeServer(), (DataProvider)new ModBodyDamageProvider(packOutput, lookupProvider, existingFileHelper));
/* 50 */     gen.addProvider(event.includeServer(), (DataProvider)new MinecraftBodyDamageProvider(packOutput, lookupProvider, existingFileHelper));
/* 51 */     gen.addProvider(event.includeServer(), (DataProvider)new MinecraftThirstProvider(packOutput, lookupProvider, existingFileHelper));
/* 52 */     gen.addProvider(event.includeServer(), (DataProvider)new MinecraftTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*    */     
/* 54 */     IntegrationDataGenerators.addIntegrationProviders(event, gen, packOutput, lookupProvider, existingFileHelper);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\DataGenerators.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */