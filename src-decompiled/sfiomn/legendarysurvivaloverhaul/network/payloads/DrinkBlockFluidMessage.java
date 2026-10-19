/*    */ package sfiomn.legendarysurvivaloverhaul.network.payloads;
/*    */ 
/*    */ import net.minecraft.network.RegistryFriendlyByteBuf;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.neoforged.neoforge.network.PacketDistributor;
/*    */ import net.neoforged.neoforge.network.handling.IPayloadContext;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonThirstBlock;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.thirst.ThirstUtil;
/*    */ 
/*    */ public final class DrinkBlockFluidMessage extends Record implements CustomPacketPayload {
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/DrinkBlockFluidMessage;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/DrinkBlockFluidMessage;
/*    */   }
/*    */   
/* 18 */   public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "drink_block_fluid");
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/DrinkBlockFluidMessage;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/DrinkBlockFluidMessage; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/DrinkBlockFluidMessage;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/DrinkBlockFluidMessage;
/* 19 */     //   0	8	1	o	Ljava/lang/Object; } public static final CustomPacketPayload.Type<DrinkBlockFluidMessage> TYPE = new CustomPacketPayload.Type(ID);
/*    */ 
/*    */   
/* 22 */   public static final StreamCodec<RegistryFriendlyByteBuf, DrinkBlockFluidMessage> STREAM_CODEC = StreamCodec.unit(new DrinkBlockFluidMessage());
/*    */ 
/*    */   
/*    */   public static void handle(DrinkBlockFluidMessage pkt, IPayloadContext ctx) {
/* 26 */     ctx.enqueueWork(() -> {
/*    */           if (ctx.player() != null) {
/*    */             DrinkWaterOnServer(ctx.player());
/*    */           }
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void DrinkWaterOnServer(Player player) {
/* 36 */     JsonThirstBlock jsonFluidThirst = ThirstUtil.getFluidThirstLookedAt(player, (float)Math.max(3.0D, player.blockInteractionRange() / 2.0D));
/*    */     
/* 38 */     if (jsonFluidThirst == null) {
/*    */       return;
/*    */     }
/* 41 */     ThirstUtil.takeDrink(player, jsonFluidThirst.hydration, jsonFluidThirst.saturation, jsonFluidThirst.effects);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void sendToServer() {
/* 46 */     PacketDistributor.sendToServer(new DrinkBlockFluidMessage(), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
/* 52 */     return (CustomPacketPayload.Type)TYPE;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\network\payloads\DrinkBlockFluidMessage.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */