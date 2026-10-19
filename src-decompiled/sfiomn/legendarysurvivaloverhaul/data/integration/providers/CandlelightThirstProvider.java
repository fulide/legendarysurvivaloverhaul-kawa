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
/*    */ public class CandlelightThirstProvider
/*    */   extends ThirstDataProvider
/*    */ {
/*    */   public CandlelightThirstProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 17 */     super("candlelight", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 24 */     consumable("mozzarella").addThirst(thirstData(2, 0.0F));
/*    */     
/* 26 */     IThirstData soupThirstData = thirstData(4, 2.0F);
/* 27 */     consumable("tomato_soup").addThirst(soupThirstData);
/* 28 */     consumable("mushroom_soup").addThirst(soupThirstData);
/*    */ 
/*    */ 
/*    */     
/* 32 */     IThirstData sinkThirst = thirstData(3, 0.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 300, 0.75F).addProperty("filled", "true");
/* 33 */     block("cobblestone_kitchen_sink").addThirst(sinkThirst);
/* 34 */     block("sandstone_kitchen_sink").addThirst(sinkThirst);
/* 35 */     block("stone_bricks_kitchen_sink").addThirst(sinkThirst);
/* 36 */     block("deepslate_kitchen_sink").addThirst(sinkThirst);
/* 37 */     block("granite_kitchen_sink").addThirst(sinkThirst);
/* 38 */     block("end_kitchen_sink").addThirst(sinkThirst);
/* 39 */     block("mud_kitchen_sink").addThirst(sinkThirst);
/* 40 */     block("quartz_kitchen_sink").addThirst(sinkThirst);
/* 41 */     block("mud_kitchen_sink").addThirst(sinkThirst);
/* 42 */     block("mud_kitchen_sink").addThirst(sinkThirst);
/* 43 */     block("quartz_kitchen_sink").addThirst(sinkThirst);
/* 44 */     block("red_nether_bricks_kitchen_sink").addThirst(sinkThirst);
/* 45 */     block("basalt_kitchen_sink").addThirst(sinkThirst);
/* 46 */     block("bamboo_kitchen_sink").addThirst(sinkThirst);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\CandlelightThirstProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */