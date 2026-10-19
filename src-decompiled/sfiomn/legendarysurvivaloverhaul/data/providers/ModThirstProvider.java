/*    */ package sfiomn.legendarysurvivaloverhaul.data.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.minecraft.world.effect.MobEffect;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.IThirstData;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.providers.ThirstDataProvider;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.thirst.HydrationEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.ItemRegistry;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.MobEffectRegistry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModThirstProvider
/*    */   extends ThirstDataProvider
/*    */ {
/*    */   public ModThirstProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 22 */     super("legendarysurvivaloverhaul", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 28 */     consumable((Item)ItemRegistry.APPLE_JUICE.get()).addThirst(thirstData(6, 3.0F));
/* 29 */     consumable((Item)ItemRegistry.BEETROOT_JUICE.get()).addThirst(thirstData(8, 4.0F));
/* 30 */     consumable((Item)ItemRegistry.CACTUS_JUICE.get()).addThirst(thirstData(9, 3.0F));
/* 31 */     consumable((Item)ItemRegistry.CARROT_JUICE.get()).addThirst(thirstData(4, 2.0F));
/* 32 */     consumable((Item)ItemRegistry.CHORUS_FRUIT_JUICE.get()).addThirst(thirstData(12, 14.0F));
/* 33 */     consumable((Item)ItemRegistry.GOLDEN_APPLE_JUICE.get()).addThirst(thirstData(10, 12.0F));
/* 34 */     consumable((Item)ItemRegistry.GOLDEN_CARROT_JUICE.get()).addThirst(thirstData(8, 6.0F));
/* 35 */     consumable((Item)ItemRegistry.GLISTERING_MELON_JUICE.get()).addThirst(thirstData(6, 6.0F));
/* 36 */     consumable((Item)ItemRegistry.MELON_JUICE.get()).addThirst(thirstData(7, 4.0F));
/* 37 */     consumable((Item)ItemRegistry.PUMPKIN_JUICE.get()).addThirst(thirstData(6, 3.5F));
/* 38 */     consumable((Item)ItemRegistry.GLOW_BERRIES_JUICE.get()).addThirst(thirstData(4, 6.0F));
/* 39 */     consumable((Item)ItemRegistry.SWEET_BERRIES_JUICE.get()).addThirst(thirstData(9, 5.0F));
/* 40 */     consumable((Item)ItemRegistry.PURIFIED_WATER_BOTTLE.get()).addThirst(thirstData(6, 1.5F));
/* 41 */     consumable((Item)ItemRegistry.WATER_PLANT_BAG.get()).addThirst(thirstData(3, 0.0F));
/*    */ 
/*    */ 
/*    */     
/* 45 */     IThirstData dirtyWaterCanteen = thirstData(3, 0.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 300, 0.75F).addProperty("legendarysurvivaloverhaul:HydrationPurity", HydrationEnum.NORMAL.getName());
/*    */     
/* 47 */     IThirstData purifiedWaterCanteen = thirstData(6, 1.5F).addProperty("legendarysurvivaloverhaul:HydrationPurity", HydrationEnum.PURIFIED.getName());
/* 48 */     consumable((Item)ItemRegistry.CANTEEN.get()).addThirst(dirtyWaterCanteen).addThirst(purifiedWaterCanteen);
/* 49 */     consumable((Item)ItemRegistry.LARGE_CANTEEN.get()).addThirst(dirtyWaterCanteen).addThirst(purifiedWaterCanteen);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\providers\ModThirstProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */