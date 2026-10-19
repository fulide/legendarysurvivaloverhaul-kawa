/*    */ package sfiomn.legendarysurvivaloverhaul.common.integration.curios;
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.core.registries.BuiltInRegistries;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.ai.attributes.Attribute;
/*    */ import net.neoforged.api.distmarker.Dist;
/*    */ import net.neoforged.fml.loading.FMLEnvironment;
/*    */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureResistance;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.TemperatureDataManager;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.AttributeRegistry;
/*    */ import top.theillusivec4.curios.api.CuriosApi;
/*    */ import top.theillusivec4.curios.api.event.CurioAttributeModifierEvent;
/*    */ import top.theillusivec4.curios.api.type.ISlotType;
/*    */ 
/*    */ public class CuriosModifier {
/* 17 */   public static final CurioAttributeBuilder HEATING_TEMPERATURE = new CurioAttributeBuilder((Holder<Attribute>)AttributeRegistry.HEATING_TEMPERATURE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "heating_temperature"));
/* 18 */   public static final CurioAttributeBuilder COOLING_TEMPERATURE = new CurioAttributeBuilder((Holder<Attribute>)AttributeRegistry.COOLING_TEMPERATURE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "cooling_temperature"));
/* 19 */   public static final CurioAttributeBuilder HEAT_RESISTANCE = new CurioAttributeBuilder((Holder<Attribute>)AttributeRegistry.HEAT_RESISTANCE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "heat_resistance"));
/* 20 */   public static final CurioAttributeBuilder COLD_RESISTANCE = new CurioAttributeBuilder((Holder<Attribute>)AttributeRegistry.COLD_RESISTANCE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "cold_resistance"));
/* 21 */   public static final CurioAttributeBuilder THERMAL_RESISTANCE = new CurioAttributeBuilder((Holder<Attribute>)AttributeRegistry.THERMAL_RESISTANCE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "thermal_resistance"));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void addAttribute(CurioAttributeModifierEvent event) {
/* 29 */     if (!LegendarySurvivalOverhaul.curiosLoaded)
/*    */       return; 
/* 31 */     ResourceLocation itemRegistryName = BuiltInRegistries.ITEM.getKey(event.getItemStack().getItem());
/* 32 */     JsonTemperatureResistance tempConfig = TemperatureDataManager.getItem(itemRegistryName);
/*    */     
/* 34 */     if (itemRegistryName != null && tempConfig != null)
/*    */     {
/* 36 */       for (ISlotType slot : CuriosApi.getItemStackSlots(event.getItemStack(), (FMLEnvironment.dist == Dist.CLIENT)).values()) {
/*    */         
/* 38 */         if (slot.getIdentifier().equals(event.getSlotContext().identifier())) {
/*    */           
/* 40 */           ResourceLocation base = itemRegistryName;
/* 41 */           HEATING_TEMPERATURE.addModifier(event, ResourceLocation.fromNamespaceAndPath(base.getNamespace(), base.getPath() + "_heating_temperature"), Math.max(tempConfig.temperature, 0.0F));
/* 42 */           COOLING_TEMPERATURE.addModifier(event, ResourceLocation.fromNamespaceAndPath(base.getNamespace(), base.getPath() + "_cooling_temperature"), Math.min(tempConfig.temperature, 0.0F));
/* 43 */           HEAT_RESISTANCE.addModifier(event, ResourceLocation.fromNamespaceAndPath(base.getNamespace(), base.getPath() + "_heat_resistance"), tempConfig.heatResistance);
/* 44 */           COLD_RESISTANCE.addModifier(event, ResourceLocation.fromNamespaceAndPath(base.getNamespace(), base.getPath() + "_cold_resistance"), tempConfig.coldResistance);
/* 45 */           THERMAL_RESISTANCE.addModifier(event, ResourceLocation.fromNamespaceAndPath(base.getNamespace(), base.getPath() + "_thermal_resistance"), tempConfig.thermalResistance);
/*    */         } 
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\curios\CuriosModifier.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */