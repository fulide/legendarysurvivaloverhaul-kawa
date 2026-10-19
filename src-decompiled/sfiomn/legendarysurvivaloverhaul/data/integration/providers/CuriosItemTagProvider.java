/*    */ package sfiomn.legendarysurvivaloverhaul.data.integration.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.minecraft.data.tags.ItemTagsProvider;
/*    */ import net.minecraft.data.tags.TagsProvider;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.tags.TagKey;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.ItemRegistry;
/*    */ 
/*    */ public class CuriosItemTagProvider
/*    */   extends ItemTagsProvider {
/* 19 */   public static final TagKey<Item> BELT_TAG = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("curios", "belt"));
/* 20 */   public static final TagKey<Item> NECKLACE_TAG = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("curios", "necklace"));
/* 21 */   public static final TagKey<Item> HEAD_TAG = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("curios", "head"));
/* 22 */   public static final TagKey<Item> BODY_TAG = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("curios", "body"));
/* 23 */   public static final TagKey<Item> CHARM_TAG = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("curios", "charm"));
/* 24 */   public static final TagKey<Item> RING_TAG = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("curios", "ring"));
/*    */ 
/*    */   
/*    */   public CuriosItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
/* 28 */     super(output, lookupProvider, p_275322_, "curios", existingFileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void addTags(HolderLookup.Provider provider) {
/* 34 */     tag(BELT_TAG)
/* 35 */       .add(ItemRegistry.THERMOMETER.get());
/* 36 */     tag(NECKLACE_TAG)
/* 37 */       .add(ItemRegistry.NETHER_CHALICE.get());
/* 38 */     tag(HEAD_TAG)
/* 39 */       .add(ItemRegistry.WATER_PURIFIER.get());
/* 40 */     tag(BODY_TAG)
/* 41 */       .add(ItemRegistry.SPONGE.get());
/* 42 */     tag(CHARM_TAG)
/* 43 */       .add(ItemRegistry.FIRST_AID_SUPPLIES.get());
/* 44 */     tag(RING_TAG)
/* 45 */       .add(ItemRegistry.HEAT_RESISTANCE_RING.get())
/* 46 */       .add(ItemRegistry.COLD_RESISTANCE_RING.get())
/* 47 */       .add(ItemRegistry.THERMAL_RESISTANCE_RING.get());
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\CuriosItemTagProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */