/*     */ package sfiomn.legendarysurvivaloverhaul.data.integration;
/*     */ import java.util.concurrent.CompletableFuture;
/*     */ import net.minecraft.core.HolderLookup;
/*     */ import net.minecraft.data.DataGenerator;
/*     */ import net.minecraft.data.DataProvider;
/*     */ import net.minecraft.data.PackOutput;
/*     */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*     */ import net.neoforged.neoforge.data.event.GatherDataEvent;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.integration.providers.AtmosphericBodyDamageProvider;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.integration.providers.BeachPartyTemperatureProvider;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.integration.providers.CuriosBlockTagProvider;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.integration.providers.FarmersDelightTemperatureProvider;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.integration.providers.MeadowTemperatureProvider;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.integration.providers.PeculiarsThirstProvider;
/*     */ 
/*     */ public final class IntegrationDataGenerators {
/*     */   public static void addIntegrationProviders(GatherDataEvent event, DataGenerator gen, PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
/*  18 */     gen.addProvider(event.includeServer(), (DataProvider)new AlexsMobsTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  19 */     gen.addProvider(event.includeServer(), (DataProvider)new AquamiraeTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  20 */     gen.addProvider(event.includeServer(), (DataProvider)new ArtifactsTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  21 */     gen.addProvider(event.includeServer(), (DataProvider)new AtmosphericBodyDamageProvider(packOutput, lookupProvider, existingFileHelper));
/*  22 */     gen.addProvider(event.includeServer(), (DataProvider)new BeachPartyTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  23 */     gen.addProvider(event.includeServer(), (DataProvider)new BeachPartyThirstProvider(packOutput, lookupProvider, existingFileHelper));
/*  24 */     gen.addProvider(event.includeServer(), (DataProvider)new BetterEndForgeTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  25 */     gen.addProvider(event.includeServer(), (DataProvider)new BetterEndTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  26 */     gen.addProvider(event.includeServer(), (DataProvider)new BopTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  27 */     gen.addProvider(event.includeServer(), (DataProvider)new BornInChaosTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  28 */     gen.addProvider(event.includeServer(), (DataProvider)new BreweryTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  29 */     gen.addProvider(event.includeServer(), (DataProvider)new BreweryThirstProvider(packOutput, lookupProvider, existingFileHelper));
/*  30 */     gen.addProvider(event.includeServer(), (DataProvider)new BrewinAndChewinTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  31 */     gen.addProvider(event.includeServer(), (DataProvider)new BrewinAndChewinThirstProvider(packOutput, lookupProvider, existingFileHelper));
/*  32 */     gen.addProvider(event.includeServer(), (DataProvider)new BrewinCompatDelightTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  33 */     gen.addProvider(event.includeServer(), (DataProvider)new BrewinCompatDelightThirstProvider(packOutput, lookupProvider, existingFileHelper));
/*  34 */     gen.addProvider(event.includeServer(), (DataProvider)new BygTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  35 */     gen.addProvider(event.includeServer(), (DataProvider)new CallOfYucatanTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  36 */     gen.addProvider(event.includeServer(), (DataProvider)new CampingTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  37 */     gen.addProvider(event.includeServer(), (DataProvider)new CandlelightTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  38 */     gen.addProvider(event.includeServer(), (DataProvider)new CandlelightThirstProvider(packOutput, lookupProvider, existingFileHelper));
/*  39 */     gen.addProvider(event.includeServer(), (DataProvider)new CataclysmTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  40 */     gen.addProvider(event.includeServer(), (DataProvider)new ConfectioneryThirstProvider(packOutput, lookupProvider, existingFileHelper));
/*  41 */     gen.addProvider(event.includeServer(), (DataProvider)new CornExpansionThirstProvider(packOutput, lookupProvider, existingFileHelper));
/*  42 */     gen.addProvider(event.includeServer(), (DataProvider)new CrabbersDelightTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  43 */     gen.addProvider(event.includeServer(), (DataProvider)new CrabbersDelightThirstProvider(packOutput, lookupProvider, existingFileHelper));
/*  44 */     gen.addProvider(event.includeServer(), (DataProvider)new CreateTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  45 */     gen.addProvider(event.includeServer(), (DataProvider)new CreateThirstProvider(packOutput, lookupProvider, existingFileHelper));
/*  46 */     gen.addProvider(event.includeServer(), (DataProvider)new CrockpotTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  47 */     gen.addProvider(event.includeServer(), (DataProvider)new CrockpotThirstProvider(packOutput, lookupProvider, existingFileHelper));
/*     */     
/*  49 */     if (ModList.get().isLoaded("curios")) {
/*     */       
/*  51 */       gen.addProvider(event.includeServer(), (DataProvider)new CuriosProvider(packOutput, existingFileHelper, lookupProvider));
/*  52 */       CuriosBlockTagProvider blockTagProvider = (CuriosBlockTagProvider)gen.addProvider(event.includeServer(), (DataProvider)new CuriosBlockTagProvider(packOutput, lookupProvider, existingFileHelper));
/*  53 */       gen.addProvider(event.includeServer(), (DataProvider)new CuriosItemTagProvider(packOutput, lookupProvider, blockTagProvider.contentsGetter(), existingFileHelper));
/*     */     } 
/*     */     
/*  56 */     gen.addProvider(event.includeServer(), (DataProvider)new DecorativeBlocksTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  57 */     gen.addProvider(event.includeServer(), (DataProvider)new EcologicsThirstProvider(packOutput, lookupProvider, existingFileHelper));
/*  58 */     gen.addProvider(event.includeServer(), (DataProvider)new EndergeticTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  59 */     gen.addProvider(event.includeServer(), (DataProvider)new EndermanOverhaulTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  60 */     gen.addProvider(event.includeServer(), (DataProvider)new FarmAndCharmTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  61 */     gen.addProvider(event.includeServer(), (DataProvider)new FarmAndCharmThirstProvider(packOutput, lookupProvider, existingFileHelper));
/*  62 */     gen.addProvider(event.includeServer(), (DataProvider)new FarmersDelightTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  63 */     gen.addProvider(event.includeServer(), (DataProvider)new FarmersDelightThirstProvider(packOutput, lookupProvider, existingFileHelper));
/*  64 */     gen.addProvider(event.includeServer(), (DataProvider)new FarmersRespiteTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  65 */     gen.addProvider(event.includeServer(), (DataProvider)new FarmersRespiteThirstProvider(packOutput, lookupProvider, existingFileHelper));
/*  66 */     gen.addProvider(event.includeServer(), (DataProvider)new GraveyardTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  67 */     gen.addProvider(event.includeServer(), (DataProvider)new HardcoreTorchesTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  68 */     gen.addProvider(event.includeServer(), (DataProvider)new HearthAndHarvestTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  69 */     gen.addProvider(event.includeServer(), (DataProvider)new HearthAndHarvestThirstProvider(packOutput, lookupProvider, existingFileHelper));
/*  70 */     gen.addProvider(event.includeServer(), (DataProvider)new HerbalBrewsTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  71 */     gen.addProvider(event.includeServer(), (DataProvider)new HerbalBrewsThirstProvider(packOutput, lookupProvider, existingFileHelper));
/*  72 */     gen.addProvider(event.includeServer(), (DataProvider)new IceAndFireBodyDamageProvider(packOutput, lookupProvider, existingFileHelper));
/*  73 */     gen.addProvider(event.includeServer(), (DataProvider)new IceAndFireTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  74 */     gen.addProvider(event.includeServer(), (DataProvider)new InfernalExpansionTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  75 */     gen.addProvider(event.includeServer(), (DataProvider)new IronsSpellbooksTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  76 */     gen.addProvider(event.includeServer(), (DataProvider)new LegendaryAdditionsTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  77 */     gen.addProvider(event.includeServer(), (DataProvider)new LegendaryCreaturesBodyDamageProvider(packOutput, lookupProvider, existingFileHelper));
/*  78 */     gen.addProvider(event.includeServer(), (DataProvider)new LegendaryCreaturesTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  79 */     gen.addProvider(event.includeServer(), (DataProvider)new MeadowTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  80 */     gen.addProvider(event.includeServer(), (DataProvider)new MeadowThirstProvider(packOutput, lookupProvider, existingFileHelper));
/*  81 */     gen.addProvider(event.includeServer(), (DataProvider)new MedsAndHerbsBodyDamageProvider(packOutput, lookupProvider, existingFileHelper));
/*  82 */     gen.addProvider(event.includeServer(), (DataProvider)new NeapolitanTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  83 */     gen.addProvider(event.includeServer(), (DataProvider)new NeapolitanThirstProvider(packOutput, lookupProvider, existingFileHelper));
/*  84 */     gen.addProvider(event.includeServer(), (DataProvider)new NetherVineryTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  85 */     gen.addProvider(event.includeServer(), (DataProvider)new NetherVineryThirstProvider(packOutput, lookupProvider, existingFileHelper));
/*  86 */     gen.addProvider(event.includeServer(), (DataProvider)new OriginsTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  87 */     gen.addProvider(event.includeServer(), (DataProvider)new PeculiarsTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  88 */     gen.addProvider(event.includeServer(), (DataProvider)new PeculiarsThirstProvider(packOutput, lookupProvider, existingFileHelper));
/*  89 */     gen.addProvider(event.includeServer(), (DataProvider)new QuarkTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  90 */     gen.addProvider(event.includeServer(), (DataProvider)new RealisticTorchesTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  91 */     gen.addProvider(event.includeServer(), (DataProvider)new RusticDelightTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  92 */     gen.addProvider(event.includeServer(), (DataProvider)new RusticDelightThirstProvider(packOutput, lookupProvider, existingFileHelper));
/*  93 */     gen.addProvider(event.includeServer(), (DataProvider)new SeasonalsTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  94 */     gen.addProvider(event.includeServer(), (DataProvider)new SeasonalsThirstProvider(packOutput, lookupProvider, existingFileHelper));
/*  95 */     gen.addProvider(event.includeServer(), (DataProvider)new SupplementariesBodyDamageProvider(packOutput, lookupProvider, existingFileHelper));
/*  96 */     gen.addProvider(event.includeServer(), (DataProvider)new SupplementariesTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*  97 */     gen.addProvider(event.includeServer(), (DataProvider)new SupplementariesThirstProvider(packOutput, lookupProvider, existingFileHelper));
/*  98 */     gen.addProvider(event.includeServer(), (DataProvider)new SurvivalInstinctBodyDamageProvider(packOutput, lookupProvider, existingFileHelper));
/*  99 */     gen.addProvider(event.includeServer(), (DataProvider)new SurvivalInstinctThirstProvider(packOutput, lookupProvider, existingFileHelper));
/* 100 */     gen.addProvider(event.includeServer(), (DataProvider)new TerraFirmaCraftTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/* 101 */     gen.addProvider(event.includeServer(), (DataProvider)new UpgradeAquaticThirstProvider(packOutput, lookupProvider, existingFileHelper));
/* 102 */     gen.addProvider(event.includeServer(), (DataProvider)new ValhelsiaStructuresTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/* 103 */     gen.addProvider(event.includeServer(), (DataProvider)new VineryTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/* 104 */     gen.addProvider(event.includeServer(), (DataProvider)new VineryThirstProvider(packOutput, lookupProvider, existingFileHelper));
/* 105 */     gen.addProvider(event.includeServer(), (DataProvider)new WardrobeTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/* 106 */     gen.addProvider(event.includeServer(), (DataProvider)new WilderNatureTemperatureProvider(packOutput, lookupProvider, existingFileHelper));
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\IntegrationDataGenerators.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */