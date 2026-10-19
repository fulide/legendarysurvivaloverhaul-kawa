/*    */ package sfiomn.legendarysurvivaloverhaul.network.payloads;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import net.minecraft.network.codec.ByteBufCodecs;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.neoforged.neoforge.network.PacketDistributor;
/*    */ import net.neoforged.neoforge.network.handling.IPayloadContext;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureConsumableBlock;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.listeners.TemperatureConsumableBlockListener;
/*    */ 
/*    */ public final class SyncTemperatureConsumableBlocksPayload extends Record implements CustomPacketPayload {
/*    */   private final Map<ResourceLocation, List<JsonTemperatureConsumableBlock>> temperatureConsumableBlocks;
/*    */   
/* 18 */   public SyncTemperatureConsumableBlocksPayload(Map<ResourceLocation, List<JsonTemperatureConsumableBlock>> temperatureConsumableBlocks) { this.temperatureConsumableBlocks = temperatureConsumableBlocks; } public Map<ResourceLocation, List<JsonTemperatureConsumableBlock>> temperatureConsumableBlocks() { return this.temperatureConsumableBlocks; } public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureConsumableBlocksPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #18	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureConsumableBlocksPayload;
/*    */   } public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureConsumableBlocksPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #18	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureConsumableBlocksPayload;
/*    */   } public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureConsumableBlocksPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #18	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureConsumableBlocksPayload;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/* 24 */   } public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "sync_temperature_consumable_blocks");
/* 25 */   public static final CustomPacketPayload.Type<SyncTemperatureConsumableBlocksPayload> TYPE = new CustomPacketPayload.Type(ID);
/*    */ 
/*    */   
/* 28 */   public static final StreamCodec<RegistryFriendlyByteBuf, SyncTemperatureConsumableBlocksPayload> STREAM_CODEC = StreamCodec.composite(
/* 29 */       ByteBufCodecs.map(java.util.HashMap::new, ResourceLocation.STREAM_CODEC, 
/*    */ 
/*    */         
/* 32 */         ByteBufCodecs.fromCodecTrusted(JsonTemperatureConsumableBlock.LIST_CODEC)), SyncTemperatureConsumableBlocksPayload::temperatureConsumableBlocks, SyncTemperatureConsumableBlocksPayload::new);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void handle(SyncTemperatureConsumableBlocksPayload pkt, IPayloadContext ctx) {
/* 40 */     if (ctx.flow() != PacketFlow.CLIENTBOUND)
/* 41 */       return;  ctx.enqueueWork(() -> TemperatureConsumableBlockListener.acceptServerTemperatureConsumableBlocks(pkt.temperatureConsumableBlocks()));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void sendToServer(Map<ResourceLocation, List<JsonTemperatureConsumableBlock>> data) {
/* 46 */     PacketDistributor.sendToServer(new SyncTemperatureConsumableBlocksPayload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void sendToPlayer(ServerPlayer player, Map<ResourceLocation, List<JsonTemperatureConsumableBlock>> data) {
/* 51 */     PacketDistributor.sendToPlayer(player, new SyncTemperatureConsumableBlocksPayload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void sendToAll(Map<ResourceLocation, List<JsonTemperatureConsumableBlock>> data) {
/* 56 */     PacketDistributor.sendToAllPlayers(new SyncTemperatureConsumableBlocksPayload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
/* 62 */     return (CustomPacketPayload.Type)TYPE;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\network\payloads\SyncTemperatureConsumableBlocksPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */