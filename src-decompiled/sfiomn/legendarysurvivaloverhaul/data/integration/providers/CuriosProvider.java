/*    */ package sfiomn.legendarysurvivaloverhaul.data.integration.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import top.theillusivec4.curios.api.CuriosDataProvider;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CuriosProvider
/*    */   extends CuriosDataProvider
/*    */ {
/*    */   public CuriosProvider(PackOutput output, ExistingFileHelper fileHelper, CompletableFuture<HolderLookup.Provider> registries) {
/* 16 */     super("legendarysurvivaloverhaul", output, fileHelper, registries);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 22 */     String beltSlotId = "belt";
/* 23 */     String necklaceSlotId = "necklace";
/* 24 */     String headSlotId = "head";
/* 25 */     String bodySlotId = "body";
/* 26 */     String charmSlotId = "charm";
/* 27 */     String ringSlotId = "ring";
/* 28 */     createSlot(beltSlotId).icon(ResourceLocation.parse("curios:slot/empty_belt_slot"));
/* 29 */     createSlot(necklaceSlotId).icon(ResourceLocation.parse("curios:slot/empty_necklace_slot"));
/* 30 */     createSlot(headSlotId).icon(ResourceLocation.parse("curios:slot/empty_head_slot"));
/* 31 */     createSlot(bodySlotId).icon(ResourceLocation.parse("curios:slot/empty_body_slot"));
/* 32 */     createSlot(charmSlotId).icon(ResourceLocation.parse("curios:slot/empty_charm_slot"));
/* 33 */     createSlot(ringSlotId).icon(ResourceLocation.parse("curios:slot/empty_ring_slot"));
/* 34 */     createEntities("player").addPlayer().addSlots(new String[] { beltSlotId, necklaceSlotId, headSlotId, bodySlotId, charmSlotId, ringSlotId });
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\CuriosProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */