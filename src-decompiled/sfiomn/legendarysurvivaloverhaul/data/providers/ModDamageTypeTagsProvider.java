/*    */ package sfiomn.legendarysurvivaloverhaul.data.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.minecraft.data.tags.DamageTypeTagsProvider;
/*    */ import net.minecraft.tags.DamageTypeTags;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.ModDamageTypes;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModDamageTypeTagsProvider
/*    */   extends DamageTypeTagsProvider
/*    */ {
/*    */   public ModDamageTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
/* 19 */     super(output, lookupProvider, "legendarysurvivaloverhaul", existingFileHelper);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void addTags(HolderLookup.Provider lookupProvider) {
/* 24 */     tag(DamageTypeTags.BYPASSES_ARMOR).addOptional(ModDamageTypes.HYPOTHERMIA.location()).addOptional(ModDamageTypes.HYPERTHERMIA.location()).addOptional(ModDamageTypes.DEHYDRATION.location());
/* 25 */     tag(DamageTypeTags.BYPASSES_ENCHANTMENTS).addOptional(ModDamageTypes.HYPOTHERMIA.location()).addOptional(ModDamageTypes.HYPERTHERMIA.location()).addOptional(ModDamageTypes.DEHYDRATION.location());
/* 26 */     tag(DamageTypeTags.BYPASSES_RESISTANCE).addOptional(ModDamageTypes.HYPOTHERMIA.location()).addOptional(ModDamageTypes.HYPERTHERMIA.location()).addOptional(ModDamageTypes.DEHYDRATION.location());
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\providers\ModDamageTypeTagsProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */