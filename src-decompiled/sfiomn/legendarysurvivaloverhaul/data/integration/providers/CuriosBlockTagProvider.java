/*    */ package sfiomn.legendarysurvivaloverhaul.data.integration.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.neoforged.neoforge.common.data.BlockTagsProvider;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ 
/*    */ public class CuriosBlockTagProvider
/*    */   extends BlockTagsProvider
/*    */ {
/*    */   public CuriosBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
/* 15 */     super(output, lookupProvider, "curios", existingFileHelper);
/*    */   }
/*    */   
/*    */   protected void addTags(HolderLookup.Provider provider) {}
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\CuriosBlockTagProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */