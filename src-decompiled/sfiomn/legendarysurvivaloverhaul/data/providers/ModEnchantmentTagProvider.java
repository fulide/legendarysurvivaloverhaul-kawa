/*    */ package sfiomn.legendarysurvivaloverhaul.data.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.minecraft.data.tags.EnchantmentTagsProvider;
/*    */ import net.minecraft.tags.EnchantmentTags;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.enchantments.ModEnchantments;
/*    */ 
/*    */ 
/*    */ public class ModEnchantmentTagProvider
/*    */   extends EnchantmentTagsProvider
/*    */ {
/*    */   public ModEnchantmentTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
/* 17 */     super(output, lookupProvider, "legendarysurvivaloverhaul", existingFileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void addTags(HolderLookup.Provider provider) {
/* 23 */     tag(EnchantmentTags.IN_ENCHANTING_TABLE)
/* 24 */       .addOptional(ModEnchantments.REFRESHING.location())
/* 25 */       .addOptional(ModEnchantments.PURITY.location())
/* 26 */       .addOptional(ModEnchantments.RESERVOIR.location());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 34 */     tag(EnchantmentTags.NON_TREASURE)
/* 35 */       .addOptional(ModEnchantments.REFRESHING.location())
/* 36 */       .addOptional(ModEnchantments.PURITY.location())
/* 37 */       .addOptional(ModEnchantments.RESERVOIR.location());
/*    */ 
/*    */     
/* 40 */     tag(EnchantmentTags.TRADEABLE)
/* 41 */       .addOptional(ModEnchantments.REFRESHING.location())
/* 42 */       .addOptional(ModEnchantments.PURITY.location())
/* 43 */       .addOptional(ModEnchantments.RESERVOIR.location());
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\providers\ModEnchantmentTagProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */