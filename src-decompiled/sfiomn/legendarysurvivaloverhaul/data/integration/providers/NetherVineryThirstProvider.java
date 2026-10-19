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
/*    */ public class NetherVineryThirstProvider
/*    */   extends ThirstDataProvider
/*    */ {
/*    */   public NetherVineryThirstProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 17 */     super("nethervinery", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 24 */     consumable("crimson_grape").addThirst(thirstData(2, 0.0F));
/* 25 */     consumable("warped_grape").addThirst(thirstData(2, 0.0F));
/*    */     
/* 27 */     IThirstData vinery_hydration = thirstData(5, 4.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.2F);
/* 28 */     IThirstData vinery2_hydration = thirstData(7, 5.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.2F);
/* 29 */     consumable("blazewine_pinot").addThirst(vinery_hydration);
/* 30 */     consumable("ghastly_grenache").addThirst(vinery_hydration);
/* 31 */     consumable("netherite_nectar").addThirst(vinery2_hydration);
/* 32 */     consumable("lava_fizz").addThirst(vinery_hydration);
/* 33 */     consumable("nether_fizz").addThirst(vinery_hydration);
/* 34 */     consumable("improved_lava_fizz").addThirst(vinery2_hydration);
/* 35 */     consumable("improved_nether_fizz").addThirst(vinery2_hydration);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\NetherVineryThirstProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */