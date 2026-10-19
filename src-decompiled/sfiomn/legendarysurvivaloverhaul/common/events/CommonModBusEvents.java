/*     */ package sfiomn.legendarysurvivaloverhaul.common.events;
/*     */ 
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.neoforged.bus.api.SubscribeEvent;
/*     */ import net.neoforged.fml.common.EventBusSubscriber;
/*     */ import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.AttributeRegistry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @EventBusSubscriber(modid = "legendarysurvivaloverhaul", bus = EventBusSubscriber.Bus.MOD)
/*     */ public class CommonModBusEvents
/*     */ {
/*     */   @SubscribeEvent
/*     */   public static void onEntityAttributesChange(EntityAttributeModificationEvent event) {
/*  18 */     if (!event.has(EntityType.PLAYER, AttributeRegistry.HEATING_TEMPERATURE.getDelegate()))
/*     */     {
/*  20 */       event.add(EntityType.PLAYER, AttributeRegistry.HEATING_TEMPERATURE
/*  21 */           .getDelegate());
/*     */     }
/*     */     
/*  24 */     if (!event.has(EntityType.PLAYER, AttributeRegistry.COOLING_TEMPERATURE.getDelegate()))
/*     */     {
/*  26 */       event.add(EntityType.PLAYER, AttributeRegistry.COOLING_TEMPERATURE
/*  27 */           .getDelegate());
/*     */     }
/*     */     
/*  30 */     if (!event.has(EntityType.PLAYER, AttributeRegistry.HEAT_RESISTANCE.getDelegate()))
/*     */     {
/*  32 */       event.add(EntityType.PLAYER, AttributeRegistry.HEAT_RESISTANCE
/*  33 */           .getDelegate());
/*     */     }
/*     */     
/*  36 */     if (!event.has(EntityType.PLAYER, AttributeRegistry.COLD_RESISTANCE.getDelegate()))
/*     */     {
/*  38 */       event.add(EntityType.PLAYER, AttributeRegistry.COLD_RESISTANCE
/*  39 */           .getDelegate());
/*     */     }
/*     */     
/*  42 */     if (!event.has(EntityType.PLAYER, AttributeRegistry.THERMAL_RESISTANCE.getDelegate()))
/*     */     {
/*  44 */       event.add(EntityType.PLAYER, AttributeRegistry.THERMAL_RESISTANCE
/*  45 */           .getDelegate());
/*     */     }
/*     */ 
/*     */     
/*  49 */     if (!event.has(EntityType.PLAYER, AttributeRegistry.BODY_RESISTANCE.getDelegate()))
/*     */     {
/*  51 */       event.add(EntityType.PLAYER, AttributeRegistry.BODY_RESISTANCE
/*  52 */           .getDelegate());
/*     */     }
/*     */     
/*  55 */     if (!event.has(EntityType.PLAYER, AttributeRegistry.HEAD_RESISTANCE.getDelegate()))
/*     */     {
/*  57 */       event.add(EntityType.PLAYER, AttributeRegistry.HEAD_RESISTANCE
/*  58 */           .getDelegate());
/*     */     }
/*     */     
/*  61 */     if (!event.has(EntityType.PLAYER, AttributeRegistry.CHEST_RESISTANCE.getDelegate()))
/*     */     {
/*  63 */       event.add(EntityType.PLAYER, AttributeRegistry.CHEST_RESISTANCE
/*  64 */           .getDelegate());
/*     */     }
/*     */     
/*  67 */     if (!event.has(EntityType.PLAYER, AttributeRegistry.RIGHT_ARM_RESISTANCE.getDelegate()))
/*     */     {
/*  69 */       event.add(EntityType.PLAYER, AttributeRegistry.RIGHT_ARM_RESISTANCE
/*  70 */           .getDelegate());
/*     */     }
/*     */     
/*  73 */     if (!event.has(EntityType.PLAYER, AttributeRegistry.LEFT_ARM_RESISTANCE.getDelegate()))
/*     */     {
/*  75 */       event.add(EntityType.PLAYER, AttributeRegistry.LEFT_ARM_RESISTANCE
/*  76 */           .getDelegate());
/*     */     }
/*     */     
/*  79 */     if (!event.has(EntityType.PLAYER, AttributeRegistry.LEGS_RESISTANCE.getDelegate()))
/*     */     {
/*  81 */       event.add(EntityType.PLAYER, AttributeRegistry.LEGS_RESISTANCE
/*  82 */           .getDelegate());
/*     */     }
/*     */     
/*  85 */     if (!event.has(EntityType.PLAYER, AttributeRegistry.FEET_RESISTANCE.getDelegate()))
/*     */     {
/*  87 */       event.add(EntityType.PLAYER, AttributeRegistry.FEET_RESISTANCE
/*  88 */           .getDelegate());
/*     */     }
/*     */ 
/*     */     
/*  92 */     if (!event.has(EntityType.PLAYER, AttributeRegistry.BROKEN_HEART.getDelegate()))
/*     */     {
/*  94 */       event.add(EntityType.PLAYER, AttributeRegistry.BROKEN_HEART
/*  95 */           .getDelegate());
/*     */     }
/*     */     
/*  98 */     if (!event.has(EntityType.PLAYER, AttributeRegistry.PERMANENT_HEART.getDelegate()))
/*     */     {
/* 100 */       event.add(EntityType.PLAYER, AttributeRegistry.PERMANENT_HEART
/* 101 */           .getDelegate());
/*     */     }
/*     */     
/* 104 */     if (!event.has(EntityType.PLAYER, AttributeRegistry.BROKEN_HEART_RESILIENCE.getDelegate()))
/*     */     {
/* 106 */       event.add(EntityType.PLAYER, AttributeRegistry.BROKEN_HEART_RESILIENCE
/* 107 */           .getDelegate());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\events\CommonModBusEvents.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */