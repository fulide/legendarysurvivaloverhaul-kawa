/*    */ package sfiomn.legendarysurvivaloverhaul.registry;
/*    */ 
/*    */ import com.mojang.blaze3d.platform.InputConstants;
/*    */ import net.minecraft.client.KeyMapping;
/*    */ import net.neoforged.api.distmarker.Dist;
/*    */ import net.neoforged.bus.api.SubscribeEvent;
/*    */ import net.neoforged.fml.common.EventBusSubscriber;
/*    */ import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
/*    */ import net.neoforged.neoforge.client.settings.IKeyConflictContext;
/*    */ import net.neoforged.neoforge.client.settings.KeyConflictContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(modid = "legendarysurvivaloverhaul", bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
/*    */ public class KeyMappingRegistry
/*    */ {
/*    */   public static KeyMapping showAddedDesc;
/*    */   public static KeyMapping showBodyHealth;
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void registerKeyMappingsEvent(RegisterKeyMappingsEvent event) {
/* 23 */     showAddedDesc = create("added_desc", 340, KeyConflictContext.GUI);
/* 24 */     event.register(showAddedDesc);
/* 25 */     showBodyHealth = create("body_health", 72, KeyConflictContext.UNIVERSAL);
/* 26 */     event.register(showBodyHealth);
/*    */   }
/*    */ 
/*    */   
/*    */   private static KeyMapping create(String name, int key, KeyConflictContext context) {
/* 31 */     return new KeyMapping("key.legendarysurvivaloverhaul." + name, (IKeyConflictContext)context, InputConstants.Type.KEYSYM, key, "key.legendarysurvivaloverhaul.title");
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\registry\KeyMappingRegistry.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */