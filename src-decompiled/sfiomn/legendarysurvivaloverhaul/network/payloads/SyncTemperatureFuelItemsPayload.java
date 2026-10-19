/*    */ package sfiomn.legendarysurvivaloverhaul.network.payloads;
/*    */ 
/*    */ import java.util.Map;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.neoforged.neoforge.network.PacketDistributor;
/*    */ import net.neoforged.neoforge.network.handling.IPayloadContext;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureFuelItem;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.listeners.TemperatureFuelItemListener;
/*    */ 
/*    */ public final class SyncTemperatureFuelItemsPayload extends Record implements CustomPacketPayload {
/*    */   private final Map<ResourceLocation, JsonTemperatureFuelItem> temperatureFuelItems;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureFuelItemsPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #18	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureFuelItemsPayload;
/*    */   }
/*    */   
/* 18 */   public SyncTemperatureFuelItemsPayload(Map<ResourceLocation, JsonTemperatureFuelItem> temperatureFuelItems) { this.temperatureFuelItems = temperatureFuelItems; } public Map<ResourceLocation, JsonTemperatureFuelItem> temperatureFuelItems() { return this.temperatureFuelItems; }
/*    */    public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureFuelItemsPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #18	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureFuelItemsPayload;
/*    */   } public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureFuelItemsPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #18	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureFuelItemsPayload;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */   }
/* 24 */   public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "sync_temperature_fuel_items");
/*    */   
/* 26 */   public static final CustomPacketPayload.Type<SyncTemperatureFuelItemsPayload> TYPE = new CustomPacketPayload.Type(ID);
/*    */ 
/*    */   
/* 29 */   public static final StreamCodec<RegistryFriendlyByteBuf, SyncTemperatureFuelItemsPayload> STREAM_CODEC = StreamCodec.composite(
/* 30 */       ByteBufCodecs.map(java.util.HashMap::new, ResourceLocation.STREAM_CODEC, 
/*    */ 
/*    */         
/* 33 */         ByteBufCodecs.fromCodecTrusted(JsonTemperatureFuelItem.CODEC)), SyncTemperatureFuelItemsPayload::temperatureFuelItems, SyncTemperatureFuelItemsPayload::new);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void handle(SyncTemperatureFuelItemsPayload pkt, IPayloadContext ctx) {
/* 41 */     if (ctx.flow() != PacketFlow.CLIENTBOUND)
/* 42 */       return;  ctx.enqueueWork(() -> TemperatureFuelItemListener.acceptServerTemperatureFuelItems(pkt.temperatureFuelItems()));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void sendToServer(Map<ResourceLocation, JsonTemperatureFuelItem> data) {
/* 47 */     PacketDistributor.sendToServer(new SyncTemperatureFuelItemsPayload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void sendToPlayer(ServerPlayer player, Map<ResourceLocation, JsonTemperatureFuelItem> data) {
/* 52 */     PacketDistributor.sendToPlayer(player, new SyncTemperatureFuelItemsPayload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void sendToAll(Map<ResourceLocation, JsonTemperatureFuelItem> data) {
/* 57 */     PacketDistributor.sendToAllPlayers(new SyncTemperatureFuelItemsPayload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
/* 63 */     return (CustomPacketPayload.Type)TYPE;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\network\payloads\SyncTemperatureFuelItemsPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */