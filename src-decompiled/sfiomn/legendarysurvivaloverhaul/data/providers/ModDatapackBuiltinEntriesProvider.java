/*    */ package sfiomn.legendarysurvivaloverhaul.data.providers;
/*    */ 
/*    */ import java.util.Set;
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.core.RegistrySetBuilder;
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
/*    */ import net.neoforged.neoforge.registries.NeoForgeRegistries;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.ModDamageTypes;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.enchantments.ModEnchantments;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.level.gen.ModBiomeModifiers;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.level.gen.ModConfiguredFeatures;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.level.gen.ModPlacedFeatures;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModDatapackBuiltinEntriesProvider
/*    */   extends DatapackBuiltinEntriesProvider
/*    */ {
/* 22 */   public static final RegistrySetBuilder BUILDER = (new RegistrySetBuilder())
/* 23 */     .add(Registries.DAMAGE_TYPE, ModDamageTypes::bootstrap)
/* 24 */     .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
/* 25 */     .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
/* 26 */     .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)
/* 27 */     .add(Registries.ENCHANTMENT, ModEnchantments::bootstrap);
/*    */ 
/*    */   
/*    */   public ModDatapackBuiltinEntriesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
/* 31 */     super(output, registries, BUILDER, Set.of("legendarysurvivaloverhaul"));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\providers\ModDatapackBuiltinEntriesProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */