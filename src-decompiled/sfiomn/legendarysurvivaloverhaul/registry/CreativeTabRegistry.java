/*     */ package sfiomn.legendarysurvivaloverhaul.registry;
/*     */ import java.util.List;
/*     */ import net.minecraft.core.registries.Registries;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.world.item.CreativeModeTab;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.neoforged.bus.api.IEventBus;
/*     */ import net.neoforged.neoforge.registries.DeferredHolder;
/*     */ import net.neoforged.neoforge.registries.DeferredRegister;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.thirst.HydrationEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.thirst.ThirstUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.blocks.HeaterBaseBlock;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.blocks.IceFernGoldBlock;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.blocks.SewingTableBlock;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.blocks.SunFernGoldBlock;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*     */ 
/*     */ public class CreativeTabRegistry {
/*  20 */   public static final DeferredRegister<CreativeModeTab> ITEM_GROUPS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "legendarysurvivaloverhaul");
/*     */   
/*  22 */   public static final DeferredHolder<CreativeModeTab, ? extends CreativeModeTab> LEGENDARY_CREATURES_TAB = ITEM_GROUPS.register("legendary_creatures", () -> CreativeModeTab.builder().icon(()).displayItems(()).title((Component)Component.translatable("itemGroup.legendarysurvivaloverhaul")).build());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void register(IEventBus eventBus) {
/* 116 */     ITEM_GROUPS.register(eventBus);
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\registry\CreativeTabRegistry.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */