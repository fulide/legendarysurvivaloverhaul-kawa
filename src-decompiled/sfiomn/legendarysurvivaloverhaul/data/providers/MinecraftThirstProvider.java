/*    */ package sfiomn.legendarysurvivaloverhaul.data.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.minecraft.world.effect.MobEffect;
/*    */ import net.minecraft.world.item.Items;
/*    */ import net.minecraft.world.level.block.Blocks;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.IThirstData;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.providers.ThirstDataProvider;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.MobEffectRegistry;
/*    */ 
/*    */ 
/*    */ public class MinecraftThirstProvider
/*    */   extends ThirstDataProvider
/*    */ {
/*    */   public MinecraftThirstProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 19 */     super("minecraft", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 25 */     block("rain").addThirst(thirstData(1, 0.0F));
/*    */ 
/*    */     
/* 28 */     IThirstData dirtyWater = thirstData(3, 0.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 300, 0.75F);
/* 29 */     block("flowing_water").addThirst(dirtyWater);
/* 30 */     block(Blocks.WATER).addThirst(dirtyWater);
/* 31 */     block(Blocks.WATER_CAULDRON).addThirst(dirtyWater);
/*    */     
/* 33 */     consumable(Items.POTION)
/* 34 */       .addThirst(dirtyWater.addProperty("Potion", "minecraft:water"))
/* 35 */       .addThirst(dirtyWater.addProperty("Potion", "minecraft:mundane"))
/* 36 */       .addThirst(dirtyWater.addProperty("Potion", "minecraft:thick"))
/* 37 */       .addThirst(dirtyWater.addProperty("Potion", "minecraft:awkward"))
/* 38 */       .addThirst(thirstData(0, 0.0F).addProperty("Potion", "minecraft:empty"))
/* 39 */       .addThirst(thirstData(6, 1.5F));
/*    */     
/* 41 */     consumable(Items.MELON_SLICE).addThirst(thirstData(2, 1.0F));
/* 42 */     consumable(Items.APPLE).addThirst(thirstData(2, 0.5F));
/* 43 */     consumable(Items.GLOW_BERRIES).addThirst(thirstData(2, 0.5F));
/* 44 */     consumable(Items.SWEET_BERRIES).addThirst(thirstData(2, 0.5F));
/* 45 */     consumable(Items.ROTTEN_FLESH).addThirst(thirstData(-4, 0.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600));
/* 46 */     consumable(Items.SPIDER_EYE).addThirst(thirstData(-4, 0.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600));
/* 47 */     consumable(Items.MILK_BUCKET).addThirst(thirstData(5, 1.0F));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\providers\MinecraftThirstProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */