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
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonThirstBlock;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.listeners.ThirstBlockListener;
/*    */ 
/*    */ public final class SyncThirstBlocksPayload extends Record implements CustomPacketPayload {
/*    */   private final Map<ResourceLocation, List<JsonThirstBlock>> thirstBlocks;
/*    */   
/* 18 */   public SyncThirstBlocksPayload(Map<ResourceLocation, List<JsonThirstBlock>> thirstBlocks) { this.thirstBlocks = thirstBlocks; } public Map<ResourceLocation, List<JsonThirstBlock>> thirstBlocks() { return this.thirstBlocks; } public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncThirstBlocksPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #18	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncThirstBlocksPayload;
/*    */   } public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncThirstBlocksPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #18	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncThirstBlocksPayload;
/*    */   } public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncThirstBlocksPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #18	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncThirstBlocksPayload;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/* 24 */   } public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "sync_thirst_blocks");
/*    */   
/* 26 */   public static final CustomPacketPayload.Type<SyncThirstBlocksPayload> TYPE = new CustomPacketPayload.Type(ID);
/*    */ 
/*    */   
/* 29 */   public static final StreamCodec<RegistryFriendlyByteBuf, SyncThirstBlocksPayload> STREAM_CODEC = StreamCodec.composite(
/* 30 */       ByteBufCodecs.map(java.util.HashMap::new, ResourceLocation.STREAM_CODEC, 
/*    */ 
/*    */         
/* 33 */         ByteBufCodecs.fromCodecTrusted(JsonThirstBlock.LIST_CODEC)), SyncThirstBlocksPayload::thirstBlocks, SyncThirstBlocksPayload::new);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void handle(SyncThirstBlocksPayload pkt, IPayloadContext ctx) {
/* 42 */     if (ctx.flow() != PacketFlow.CLIENTBOUND)
/* 43 */       return;  ctx.enqueueWork(() -> ThirstBlockListener.acceptServerThirstBlocks(pkt.thirstBlocks()));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void sendToServer(Map<ResourceLocation, List<JsonThirstBlock>> data) {
/* 49 */     PacketDistributor.sendToServer(new SyncThirstBlocksPayload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void sendToPlayer(ServerPlayer player, Map<ResourceLocation, List<JsonThirstBlock>> data) {
/* 58 */     PacketDistributor.sendToPlayer(player, new SyncThirstBlocksPayload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void sendToAll(Map<ResourceLocation, List<JsonThirstBlock>> data) {
/* 64 */     PacketDistributor.sendToAllPlayers(new SyncThirstBlocksPayload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
/* 70 */     return (CustomPacketPayload.Type)TYPE;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\network\payloads\SyncThirstBlocksPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */