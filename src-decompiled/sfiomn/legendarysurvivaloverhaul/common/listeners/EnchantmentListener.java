/*     */ package sfiomn.legendarysurvivaloverhaul.common.listeners;
/*     */ 
/*     */ import net.minecraft.core.Holder;
/*     */ import net.minecraft.core.component.DataComponents;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.item.enchantment.Enchantment;
/*     */ import net.minecraft.world.item.enchantment.ItemEnchantments;
/*     */ import net.neoforged.bus.api.EventPriority;
/*     */ import net.neoforged.bus.api.SubscribeEvent;
/*     */ import net.neoforged.fml.common.EventBusSubscriber;
/*     */ import net.neoforged.neoforge.event.AnvilUpdateEvent;
/*     */ import net.neoforged.neoforge.event.GrindstoneEvent;
/*     */ import net.neoforged.neoforge.event.entity.player.PlayerEvent;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.enchantments.ModEnchantments;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.items.drink.CanteenItem;
/*     */ 
/*     */ 
/*     */ 
/*     */ @EventBusSubscriber(modid = "legendarysurvivaloverhaul", bus = EventBusSubscriber.Bus.GAME)
/*     */ public class EnchantmentListener
/*     */ {
/*     */   @SubscribeEvent(priority = EventPriority.LOWEST)
/*     */   public static void onAnvilUpdate(AnvilUpdateEvent event) {
/*  26 */     ItemStack left = event.getLeft();
/*  27 */     ItemStack right = event.getRight();
/*     */     
/*  29 */     if (left.isEmpty() || right.isEmpty())
/*  30 */       return;  if (!(left.getItem() instanceof CanteenItem))
/*     */       return; 
/*  32 */     boolean shouldPurify = false;
/*     */ 
/*     */     
/*  35 */     if (right.getItem() == Items.ENCHANTED_BOOK) {
/*  36 */       ItemEnchantments bookEnchantments = (ItemEnchantments)right.getOrDefault(DataComponents.STORED_ENCHANTMENTS, ItemEnchantments.EMPTY);
/*     */       
/*  38 */       for (Holder<Enchantment> enchHolder : (Iterable<Holder<Enchantment>>)bookEnchantments.keySet()) {
/*  39 */         if (enchHolder.is(ModEnchantments.PURITY)) {
/*  40 */           shouldPurify = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  47 */     if (right.getItem() instanceof CanteenItem) {
/*  48 */       ItemEnchantments rightEnchantments = (ItemEnchantments)right.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
/*     */       
/*  50 */       for (Holder<Enchantment> enchHolder : (Iterable<Holder<Enchantment>>)rightEnchantments.keySet()) {
/*  51 */         if (enchHolder.is(ModEnchantments.PURITY)) {
/*  52 */           shouldPurify = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  59 */     if (shouldPurify) {
/*  60 */       ItemStack output = event.getOutput();
/*  61 */       if (!output.isEmpty() && output.getItem() instanceof CanteenItem) {
/*     */         
/*  63 */         ItemEnchantments outputEnchantments = (ItemEnchantments)output.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
/*  64 */         boolean hasPurity = false;
/*     */         
/*  66 */         for (Holder<Enchantment> enchHolder : (Iterable<Holder<Enchantment>>)outputEnchantments.keySet()) {
/*  67 */           if (enchHolder.is(ModEnchantments.PURITY)) {
/*  68 */             hasPurity = true;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */         
/*  74 */         if (hasPurity) {
/*     */           
/*  76 */           ItemStack newOutput = output.copy();
/*  77 */           CanteenItem.onPurityApplied(newOutput);
/*  78 */           event.setOutput(newOutput);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
/*  89 */     ItemStack result = event.getCrafting();
/*  90 */     Player player = event.getEntity();
/*     */ 
/*     */     
/*  93 */     if (!result.isEmpty() && result.getItem() instanceof CanteenItem) {
/*  94 */       if ((player.level()).isClientSide) {
/*     */         return;
/*     */       }
/*  97 */       ItemEnchantments enchantments = (ItemEnchantments)result.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
/*     */       
/*  99 */       for (Holder<Enchantment> enchHolder : (Iterable<Holder<Enchantment>>)enchantments.keySet()) {
/* 100 */         if (enchHolder.is(ModEnchantments.PURITY)) {
/* 101 */           CanteenItem.onPurityApplied(result);
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onGrindstone(GrindstoneEvent.OnPlaceItem event) {
/* 110 */     ItemStack topItem = event.getTopItem();
/* 111 */     ItemStack bottomItem = event.getBottomItem();
/*     */ 
/*     */     
/* 114 */     if (topItem.getItem() instanceof CanteenItem);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 119 */     if (bottomItem.getItem() instanceof CanteenItem);
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\listeners\EnchantmentListener.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */