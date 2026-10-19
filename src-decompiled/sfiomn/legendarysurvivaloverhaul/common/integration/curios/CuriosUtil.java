/*     */ package sfiomn.legendarysurvivaloverhaul.common.integration.curios;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import net.minecraft.core.NonNullList;
/*     */ import net.minecraft.util.Tuple;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.neoforged.api.distmarker.Dist;
/*     */ import net.neoforged.bus.api.Event;
/*     */ import net.neoforged.bus.api.ICancellableEvent;
/*     */ import net.neoforged.fml.loading.FMLEnvironment;
/*     */ import net.neoforged.neoforge.common.NeoForge;
/*     */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*     */ import top.theillusivec4.curios.api.CuriosApi;
/*     */ import top.theillusivec4.curios.api.SlotContext;
/*     */ import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;
/*     */ import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;
/*     */ import top.theillusivec4.curios.api.type.inventory.IDynamicStackHandler;
/*     */ 
/*     */ public class CuriosUtil {
/*     */   public static boolean isCurioItemEquipped(Player player, Item item) {
/*  27 */     if (LegendarySurvivalOverhaul.curiosLoaded) {
/*     */       
/*  29 */       Optional<ICuriosItemHandler> curiosInventory = CuriosApi.getCuriosInventory((LivingEntity)player);
/*  30 */       return ((Boolean)curiosInventory.<Boolean>map(handler -> Boolean.valueOf(handler.isEquipped(item))).orElse(Boolean.valueOf(false))).booleanValue();
/*     */     } 
/*     */     
/*  33 */     return (player.getItemInHand(InteractionHand.MAIN_HAND).is(item) || player
/*  34 */       .getItemInHand(InteractionHand.OFF_HAND).is(item));
/*     */   }
/*     */   
/*     */   public static boolean isThermometerEquipped = false;
/*     */   
/*     */   public static boolean isCuriosItem(ItemStack stack) {
/*  40 */     if (!LegendarySurvivalOverhaul.curiosLoaded) return false;
/*     */     
/*  42 */     boolean isClient = (FMLEnvironment.dist == Dist.CLIENT);
/*  43 */     return !CuriosApi.getItemStackSlots(stack, isClient).isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean equipCurio(Player player, ItemStack stack, InteractionHand hand) {
/*  49 */     if (!LegendarySurvivalOverhaul.curiosLoaded || stack.isEmpty()) return false;
/*     */     
/*  51 */     Optional<ICuriosItemHandler> curiosInventoryOpt = CuriosApi.getCuriosInventory((LivingEntity)player);
/*  52 */     if (curiosInventoryOpt.isEmpty()) return false;
/*     */     
/*  54 */     ICuriosItemHandler curiosInventory = curiosInventoryOpt.get();
/*  55 */     Map<String, ICurioStacksHandler> curios = curiosInventory.getCurios();
/*     */     
/*  57 */     Tuple<IDynamicStackHandler, SlotContext> firstSlot = null;
/*     */ 
/*     */     
/*  60 */     for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
/*     */       
/*  62 */       String id = entry.getKey();
/*  63 */       ICurioStacksHandler handler = entry.getValue();
/*  64 */       IDynamicStackHandler slots = handler.getStacks();
/*  65 */       NonNullList<Boolean> renderStates = handler.getRenders();
/*     */       
/*  67 */       for (int ix = 0; ix < slots.getSlots(); ix++) {
/*     */ 
/*     */ 
/*     */         
/*  71 */         SlotContext slotContext = new SlotContext(id, (LivingEntity)player, ix, false, (renderStates.size() > ix && ((Boolean)renderStates.get(ix)).booleanValue()));
/*     */ 
/*     */         
/*  74 */         if (slots.isItemValid(ix, stack)) {
/*     */           
/*  76 */           ItemStack present = slots.getStackInSlot(ix);
/*     */ 
/*     */           
/*  79 */           if (present.isEmpty()) {
/*     */             
/*  81 */             slots.setStackInSlot(ix, stack.copy());
/*  82 */             if (!player.isCreative())
/*     */             {
/*  84 */               stack.shrink(stack.getCount());
/*     */             }
/*  86 */             return true;
/*     */           } 
/*     */ 
/*     */           
/*  90 */           if (firstSlot == null && canUnequipViaCuriosEvent(present, slotContext))
/*     */           {
/*     */             
/*  93 */             if (slots.extractItem(ix, stack.getMaxStackSize(), true).getCount() == stack.getCount())
/*     */             {
/*  95 */               firstSlot = new Tuple(slots, slotContext);
/*     */             }
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 102 */     if (firstSlot != null) {
/*     */       
/* 104 */       IDynamicStackHandler targetStacks = (IDynamicStackHandler)firstSlot.getA();
/* 105 */       SlotContext slotContext = (SlotContext)firstSlot.getB();
/* 106 */       int i = slotContext.index();
/* 107 */       ItemStack present = targetStacks.getStackInSlot(i);
/*     */       
/* 109 */       targetStacks.setStackInSlot(i, stack.copy());
/* 110 */       if (!player.isCreative())
/*     */       {
/*     */         
/* 113 */         player.setItemInHand(hand, present.copy());
/*     */       }
/*     */       
/* 116 */       return true;
/*     */     } 
/*     */     
/* 119 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean canUnequipViaCuriosEvent(ItemStack present, SlotContext slotContext) {
/*     */     try {
/* 130 */       Class<?> evtClass = Class.forName("top.theillusivec4.curios.api.event.CurioUnequipEvent");
/* 131 */       Constructor<?> ctor = evtClass.getConstructor(new Class[] { ItemStack.class, SlotContext.class });
/* 132 */       Object evt = ctor.newInstance(new Object[] { present, slotContext });
/*     */ 
/*     */       
/* 135 */       Object posted = NeoForge.EVENT_BUS.post((Event)evt);
/*     */ 
/*     */       
/* 138 */       if (posted instanceof ICancellableEvent) { ICancellableEvent c = (ICancellableEvent)posted;
/*     */         
/* 140 */         return !c.isCanceled(); }
/*     */       
/* 142 */       return true;
/* 143 */     } catch (Throwable ignored) {
/*     */ 
/*     */       
/* 146 */       return true;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\curios\CuriosUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */