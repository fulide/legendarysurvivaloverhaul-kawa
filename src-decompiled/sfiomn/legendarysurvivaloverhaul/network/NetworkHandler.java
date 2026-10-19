/*    */ package sfiomn.legendarysurvivaloverhaul.network;
/*    */ import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
/*    */ import net.neoforged.neoforge.network.handling.IPayloadHandler;
/*    */ import net.neoforged.neoforge.network.registration.PayloadRegistrar;
/*    */ import sfiomn.legendarysurvivaloverhaul.network.payloads.BodyPartHealingTimeMessage;
/*    */ import sfiomn.legendarysurvivaloverhaul.network.payloads.DrinkBlockFluidMessage;
/*    */ import sfiomn.legendarysurvivaloverhaul.network.payloads.SyncBodyDamageHealingConsumablesPayload;
/*    */ import sfiomn.legendarysurvivaloverhaul.network.payloads.SyncBodyPartsDamageSourcesPayload;
/*    */ import sfiomn.legendarysurvivaloverhaul.network.payloads.SyncTemperatureDimensionsPayload;
/*    */ import sfiomn.legendarysurvivaloverhaul.network.payloads.SyncTemperatureFuelItemsPayload;
/*    */ import sfiomn.legendarysurvivaloverhaul.network.payloads.SyncTemperatureItemsPayload;
/*    */ import sfiomn.legendarysurvivaloverhaul.network.payloads.SyncTemperatureMountsPayload;
/*    */ import sfiomn.legendarysurvivaloverhaul.network.payloads.SyncTemperatureOriginsPayload;
/*    */ import sfiomn.legendarysurvivaloverhaul.network.payloads.SyncThirstBlocksPayload;
/*    */ import sfiomn.legendarysurvivaloverhaul.network.payloads.UpdateBodyDamagePayload;
/*    */ import sfiomn.legendarysurvivaloverhaul.network.payloads.UpdateHeartsPayload;
/*    */ 
/*    */ @EventBusSubscriber(modid = "legendarysurvivaloverhaul", bus = EventBusSubscriber.Bus.MOD)
/*    */ public class NetworkHandler {
/*    */   @SubscribeEvent
/*    */   public static void register(RegisterPayloadHandlersEvent event) {
/* 22 */     PayloadRegistrar reg = event.registrar("legendarysurvivaloverhaul").versioned("1");
/*    */     
/* 24 */     reg.playBidirectional(UpdateTemperaturesPayload.TYPE, UpdateTemperaturesPayload.STREAM_CODEC, (IPayloadHandler)new DirectionalPayloadHandler(UpdateTemperaturesPayload::handle, UpdateTemperaturesPayload::handle));
/*    */ 
/*    */     
/* 27 */     reg.playBidirectional(UpdateWetnessPayload.TYPE, UpdateWetnessPayload.STREAM_CODEC, (IPayloadHandler)new DirectionalPayloadHandler(UpdateWetnessPayload::handle, UpdateWetnessPayload::handle));
/*    */ 
/*    */     
/* 30 */     reg.playBidirectional(UpdateThirstPayload.TYPE, UpdateThirstPayload.STREAM_CODEC, (IPayloadHandler)new DirectionalPayloadHandler(UpdateThirstPayload::handle, UpdateThirstPayload::handle));
/*    */ 
/*    */     
/* 33 */     reg.playBidirectional(UpdateHeartsPayload.TYPE, UpdateHeartsPayload.STREAM_CODEC, (IPayloadHandler)new DirectionalPayloadHandler(UpdateHeartsPayload::handle, UpdateHeartsPayload::handle));
/*    */ 
/*    */     
/* 36 */     reg.playBidirectional(UpdateBodyDamagePayload.TYPE, UpdateBodyDamagePayload.STREAM_CODEC, (IPayloadHandler)new DirectionalPayloadHandler(UpdateBodyDamagePayload::handle, UpdateBodyDamagePayload::handle));
/*    */ 
/*    */     
/* 39 */     reg.playBidirectional(DrinkBlockFluidMessage.TYPE, DrinkBlockFluidMessage.STREAM_CODEC, (IPayloadHandler)new DirectionalPayloadHandler(DrinkBlockFluidMessage::handle, DrinkBlockFluidMessage::handle));
/*    */ 
/*    */     
/* 42 */     reg.playBidirectional(BodyPartHealingTimeMessage.TYPE, BodyPartHealingTimeMessage.STREAM_CODEC, (IPayloadHandler)new DirectionalPayloadHandler(BodyPartHealingTimeMessage::handle, BodyPartHealingTimeMessage::handle));
/*    */ 
/*    */     
/* 45 */     reg.playBidirectional(SyncTemperatureConsumablesPayload.TYPE, SyncTemperatureConsumablesPayload.STREAM_CODEC, (IPayloadHandler)new DirectionalPayloadHandler(SyncTemperatureConsumablesPayload::handle, SyncTemperatureConsumablesPayload::handle));
/*    */     
/* 47 */     reg.playBidirectional(SyncTemperatureConsumableBlocksPayload.TYPE, SyncTemperatureConsumableBlocksPayload.STREAM_CODEC, (IPayloadHandler)new DirectionalPayloadHandler(SyncTemperatureConsumableBlocksPayload::handle, SyncTemperatureConsumableBlocksPayload::handle));
/*    */     
/* 49 */     reg.playBidirectional(SyncTemperatureBlocksPayload.TYPE, SyncTemperatureBlocksPayload.STREAM_CODEC, (IPayloadHandler)new DirectionalPayloadHandler(SyncTemperatureBlocksPayload::handle, SyncTemperatureBlocksPayload::handle));
/*    */     
/* 51 */     reg.playBidirectional(SyncTemperatureItemsPayload.TYPE, SyncTemperatureItemsPayload.STREAM_CODEC, (IPayloadHandler)new DirectionalPayloadHandler(SyncTemperatureItemsPayload::handle, SyncTemperatureItemsPayload::handle));
/*    */     
/* 53 */     reg.playBidirectional(SyncTemperatureBiomesPayload.TYPE, SyncTemperatureBiomesPayload.STREAM_CODEC, (IPayloadHandler)new DirectionalPayloadHandler(SyncTemperatureBiomesPayload::handle, SyncTemperatureBiomesPayload::handle));
/*    */     
/* 55 */     reg.playBidirectional(SyncTemperatureFuelItemsPayload.TYPE, SyncTemperatureFuelItemsPayload.STREAM_CODEC, (IPayloadHandler)new DirectionalPayloadHandler(SyncTemperatureFuelItemsPayload::handle, SyncTemperatureFuelItemsPayload::handle));
/*    */     
/* 57 */     reg.playBidirectional(SyncTemperatureMountsPayload.TYPE, SyncTemperatureMountsPayload.STREAM_CODEC, (IPayloadHandler)new DirectionalPayloadHandler(SyncTemperatureMountsPayload::handle, SyncTemperatureMountsPayload::handle));
/*    */     
/* 59 */     reg.playBidirectional(SyncTemperatureDimensionsPayload.TYPE, SyncTemperatureDimensionsPayload.STREAM_CODEC, (IPayloadHandler)new DirectionalPayloadHandler(SyncTemperatureDimensionsPayload::handle, SyncTemperatureDimensionsPayload::handle));
/*    */     
/* 61 */     reg.playBidirectional(SyncTemperatureOriginsPayload.TYPE, SyncTemperatureOriginsPayload.STREAM_CODEC, (IPayloadHandler)new DirectionalPayloadHandler(SyncTemperatureOriginsPayload::handle, SyncTemperatureOriginsPayload::handle));
/*    */ 
/*    */     
/* 64 */     reg.playBidirectional(SyncThirstBlocksPayload.TYPE, SyncThirstBlocksPayload.STREAM_CODEC, (IPayloadHandler)new DirectionalPayloadHandler(SyncThirstBlocksPayload::handle, SyncThirstBlocksPayload::handle));
/*    */     
/* 66 */     reg.playBidirectional(SyncThirstConsumablesPaload.TYPE, SyncThirstConsumablesPaload.STREAM_CODEC, (IPayloadHandler)new DirectionalPayloadHandler(SyncThirstConsumablesPaload::handle, SyncThirstConsumablesPaload::handle));
/*    */ 
/*    */     
/* 69 */     reg.playBidirectional(SyncBodyDamageHealingConsumablesPayload.TYPE, SyncBodyDamageHealingConsumablesPayload.STREAM_CODEC, (IPayloadHandler)new DirectionalPayloadHandler(SyncBodyDamageHealingConsumablesPayload::handle, SyncBodyDamageHealingConsumablesPayload::handle));
/*    */     
/* 71 */     reg.playBidirectional(SyncBodyPartsDamageSourcesPayload.TYPE, SyncBodyPartsDamageSourcesPayload.STREAM_CODEC, (IPayloadHandler)new DirectionalPayloadHandler(SyncBodyPartsDamageSourcesPayload::handle, SyncBodyPartsDamageSourcesPayload::handle));
/*    */     
/* 73 */     reg.playBidirectional(SyncBodyPartResistanceItemsPayload.TYPE, SyncBodyPartResistanceItemsPayload.STREAM_CODEC, (IPayloadHandler)new DirectionalPayloadHandler(SyncBodyPartResistanceItemsPayload::handle, SyncBodyPartResistanceItemsPayload::handle));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\network\NetworkHandler.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */