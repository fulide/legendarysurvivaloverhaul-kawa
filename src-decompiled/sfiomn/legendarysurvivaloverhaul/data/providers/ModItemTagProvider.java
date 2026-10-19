/*    */ package sfiomn.legendarysurvivaloverhaul.data.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.minecraft.data.tags.ItemTagsProvider;
/*    */ import net.minecraft.data.tags.TagsProvider;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.tags.ModItemTags;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.ItemRegistry;
/*    */ 
/*    */ public class ModItemTagProvider
/*    */   extends ItemTagsProvider
/*    */ {
/*    */   public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
/* 18 */     super(output, lookupProvider, p_275322_, "legendarysurvivaloverhaul", existingFileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void addTags(HolderLookup.Provider provider) {
/* 24 */     tag(ModItemTags.CANTEEN_ENCHANTABLE)
/* 25 */       .add(ItemRegistry.CANTEEN.get())
/* 26 */       .add(ItemRegistry.LARGE_CANTEEN.get());
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\providers\ModItemTagProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */