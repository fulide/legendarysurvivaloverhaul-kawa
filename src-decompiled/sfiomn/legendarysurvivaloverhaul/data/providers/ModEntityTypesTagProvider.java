/*    */ package sfiomn.legendarysurvivaloverhaul.data.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.minecraft.data.tags.EntityTypeTagsProvider;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModEntityTypesTagProvider
/*    */   extends EntityTypeTagsProvider
/*    */ {
/*    */   public ModEntityTypesTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
/* 17 */     super(output, lookupProvider, "legendarysurvivaloverhaul", existingFileHelper);
/*    */   }
/*    */   
/*    */   protected void addTags(HolderLookup.Provider provider) {}
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\providers\ModEntityTypesTagProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */