/*    */ package sfiomn.legendarysurvivaloverhaul.data.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.minecraft.tags.BlockTags;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.neoforged.neoforge.common.data.BlockTagsProvider;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.BlockRegistry;
/*    */ 
/*    */ 
/*    */ public class ModBlockTagProvider
/*    */   extends BlockTagsProvider
/*    */ {
/*    */   public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
/* 18 */     super(output, lookupProvider, "legendarysurvivaloverhaul", existingFileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void addTags(HolderLookup.Provider provider) {
/* 24 */     tag(BlockTags.MINEABLE_WITH_AXE)
/* 25 */       .add(BlockRegistry.COOLER.get());
/*    */     
/* 27 */     tag(BlockTags.MINEABLE_WITH_PICKAXE)
/* 28 */       .add((Object[])new Block[] { (Block)BlockRegistry.HEATER.get(), (Block)BlockRegistry.HEATER_TOP
/* 29 */           .get() });
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\providers\ModBlockTagProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */