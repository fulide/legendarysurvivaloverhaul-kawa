/*    */ package sfiomn.legendarysurvivaloverhaul.common.items.armor;
/*    */ 
/*    */ import java.util.EnumMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import net.minecraft.Util;
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.sounds.SoundEvents;
/*    */ import net.minecraft.tags.ItemTags;
/*    */ import net.minecraft.world.item.ArmorItem;
/*    */ import net.minecraft.world.item.ArmorMaterial;
/*    */ import net.minecraft.world.item.Items;
/*    */ import net.minecraft.world.item.crafting.Ingredient;
/*    */ import net.minecraft.world.level.ItemLike;
/*    */ import net.neoforged.bus.api.IEventBus;
/*    */ import net.neoforged.neoforge.registries.DeferredRegister;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ArmorMaterialBase
/*    */ {
/* 24 */   public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, "legendarysurvivaloverhaul");
/*    */ 
/*    */   
/* 27 */   public static final Holder<ArmorMaterial> SNOW = (Holder<ArmorMaterial>)ARMOR_MATERIALS.register("snow", () -> new ArmorMaterial((Map)Util.make(new EnumMap<>(ArmorItem.Type.class), ()), 17, SoundEvents.ARMOR_EQUIP_LEATHER, (), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "snow"))), 0.0F, 0.0F));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 46 */   public static final Holder<ArmorMaterial> DESERT = (Holder<ArmorMaterial>)ARMOR_MATERIALS.register("desert", () -> new ArmorMaterial((Map)Util.make(new EnumMap<>(ArmorItem.Type.class), ()), 19, SoundEvents.ARMOR_EQUIP_LEATHER, (), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "desert"))), 0.0F, 0.0F));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void register(IEventBus eventBus) {
/* 66 */     ARMOR_MATERIALS.register(eventBus);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\items\armor\ArmorMaterialBase.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */