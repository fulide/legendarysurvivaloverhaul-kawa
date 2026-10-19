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
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureBlock;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.listeners.TemperatureBlockListener;
/*    */ 
/*    */ public final class SyncTemperatureBlocksPayload extends Record implements CustomPacketPayload {
/*    */   private final Map<ResourceLocation, List<JsonTemperatureBlock>> temperatureBlocks;
/*    */   
/* 18 */   public SyncTemperatureBlocksPayload(Map<ResourceLocation, List<JsonTemperatureBlock>> temperatureBlocks) { this.temperatureBlocks = temperatureBlocks; } public Map<ResourceLocation, List<JsonTemperatureBlock>> temperatureBlocks() { return this.temperatureBlocks; } public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureBlocksPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #18	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureBlocksPayload;
/*    */   } public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureBlocksPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #18	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureBlocksPayload;
/*    */   } public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureBlocksPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #18	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureBlocksPayload;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/* 24 */   } public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "sync_temperature_blocks");
/* 25 */   public static final CustomPacketPayload.Type<SyncTemperatureBlocksPayload> TYPE = new CustomPacketPayload.Type(ID);
/*    */ 
/*    */   
/* 28 */   public static final StreamCodec<RegistryFriendlyByteBuf, SyncTemperatureBlocksPayload> STREAM_CODEC = StreamCodec.composite(
/* 29 */       ByteBufCodecs.map(java.util.HashMap::new, ResourceLocation.STREAM_CODEC, 
/*    */ 
/*    */         
/* 32 */         ByteBufCodecs.fromCodecTrusted(JsonTemperatureBlock.LIST_CODEC)), SyncTemperatureBlocksPayload::temperatureBlocks, SyncTemperatureBlocksPayload::new);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void handle(SyncTemperatureBlocksPayload pkt, IPayloadContext ctx) {
/* 40 */     if (ctx.flow() != PacketFlow.CLIENTBOUND)
/* 41 */       return;  ctx.enqueueWork(() -> TemperatureBlockListener.acceptServerTemperatureBlocks(pkt.temperatureBlocks()));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void sendToServer(Map<ResourceLocation, List<JsonTemperatureBlock>> data) {
/* 46 */     PacketDistributor.sendToServer(new SyncTemperatureBlocksPayload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void sendToPlayer(ServerPlayer player, Map<ResourceLocation, List<JsonTemperatureBlock>> data) {
/* 51 */     PacketDistributor.sendToPlayer(player, new SyncTemperatureBlocksPayload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void sendToAll(Map<ResourceLocation, List<JsonTemperatureBlock>> data) {
/* 56 */     PacketDistributor.sendToAllPlayers(new SyncTemperatureBlocksPayload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
/* 62 */     return (CustomPacketPayload.Type)TYPE;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\network\payloads\SyncTemperatureBlocksPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */