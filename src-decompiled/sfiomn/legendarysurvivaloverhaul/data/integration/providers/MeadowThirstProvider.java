/*    */ package sfiomn.legendarysurvivaloverhaul.data.integration.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.minecraft.world.effect.MobEffect;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.IThirstData;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.providers.ThirstDataProvider;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.MobEffectRegistry;
/*    */ 
/*    */ 
/*    */ public class MeadowThirstProvider
/*    */   extends ThirstDataProvider
/*    */ {
/*    */   public MeadowThirstProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 17 */     super("meadow", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 25 */     IThirstData dirtyWater = thirstData(3, 0.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 300, 0.75F);
/* 26 */     block("wooden_water_cauldron").addThirst(dirtyWater);
/*    */     
/* 28 */     IThirstData milkThirstData = thirstData(5, 2.0F);
/* 29 */     consumable("wooden_milk_bucket").addThirst(milkThirstData);
/* 30 */     consumable("wooden_sheep_milk_bucket").addThirst(milkThirstData);
/* 31 */     consumable("wooden_buffalo_milk_bucket").addThirst(milkThirstData);
/* 32 */     consumable("wooden_goat_milk_bucket").addThirst(milkThirstData);
/* 33 */     consumable("wooden_warped_milk_bucket").addThirst(milkThirstData);
/* 34 */     consumable("wooden_grain_milk_bucket").addThirst(milkThirstData);
/* 35 */     consumable("wooden_amethyst_milk_bucket").addThirst(milkThirstData);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\MeadowThirstProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */