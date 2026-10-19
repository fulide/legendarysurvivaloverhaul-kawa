/*     */ package sfiomn.legendarysurvivaloverhaul.network.payloads;
/*     */ 
/*     */ import java.util.function.Function;
/*     */ import net.minecraft.core.Holder;
/*     */ import net.minecraft.core.registries.BuiltInRegistries;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.codec.StreamCodec;
/*     */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.neoforged.neoforge.network.handling.IPayloadContext;
/*     */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.BodyPartEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonHealingConsumable;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.BodyDamageDataManager;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.MobEffectRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.SoundRegistry;
/*     */ 
/*     */ public final class BodyPartHealingTimeMessage extends Record implements CustomPacketPayload {
/*  26 */   public BodyPartHealingTimeMessage(CompoundTag compound) { this.compound = compound; } private final CompoundTag compound; public final String toString() { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: <illegal opcode> toString : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/BodyPartHealingTimeMessage;)Ljava/lang/String;
/*     */     //   6: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #26	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*  26 */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/BodyPartHealingTimeMessage; } public CompoundTag compound() { return this.compound; }
/*     */    public final int hashCode() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: <illegal opcode> hashCode : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/BodyPartHealingTimeMessage;)I
/*     */     //   6: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #26	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/BodyPartHealingTimeMessage;
/*     */   } public final boolean equals(Object o) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: aload_1
/*     */     //   2: <illegal opcode> equals : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/BodyPartHealingTimeMessage;Ljava/lang/Object;)Z
/*     */     //   7: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #26	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	8	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/BodyPartHealingTimeMessage;
/*     */     //   0	8	1	o	Ljava/lang/Object;
/*     */   }
/*  32 */   public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "body_part_healing_time");
/*  33 */   public static final CustomPacketPayload.Type<BodyPartHealingTimeMessage> TYPE = new CustomPacketPayload.Type(ID);
/*     */ 
/*     */   
/*  36 */   public static final StreamCodec<RegistryFriendlyByteBuf, BodyPartHealingTimeMessage> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.COMPOUND_TAG, BodyPartHealingTimeMessage::compound, BodyPartHealingTimeMessage::new);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BodyPartHealingTimeMessage(BodyPartEnum bodyPart, InteractionHand hand, boolean consumeItem, boolean applyEffect) {
/*  44 */     this(createPayload(bodyPart, hand, consumeItem, applyEffect));
/*     */   }
/*     */ 
/*     */   
/*     */   private static CompoundTag createPayload(BodyPartEnum bodyPart, InteractionHand hand, boolean consumeItem, boolean applyEffect) {
/*  49 */     CompoundTag bodyPartHealNbt = new CompoundTag();
/*  50 */     bodyPartHealNbt.putString("bodyPartEnum", bodyPart.name());
/*  51 */     bodyPartHealNbt.putBoolean("mainHand", (hand == InteractionHand.MAIN_HAND));
/*  52 */     bodyPartHealNbt.putBoolean("consumeItem", consumeItem);
/*  53 */     bodyPartHealNbt.putBoolean("applyEffect", applyEffect);
/*  54 */     return bodyPartHealNbt;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void handle(BodyPartHealingTimeMessage pkt, IPayloadContext ctx) {
/*  59 */     ctx.enqueueWork(() -> {
/*     */           Player patt0$temp = ctx.player();
/*     */           if (patt0$temp instanceof ServerPlayer) {
/*     */             ServerPlayer serverPlayer = (ServerPlayer)patt0$temp;
/*     */             applyHealingItemOnServer(serverPlayer, pkt.compound());
/*     */           } 
/*     */         });
/*     */   }
/*     */   
/*     */   public static void applyHealingItemOnServer(ServerPlayer player, CompoundTag nbt) {
/*  69 */     BodyPartEnum bodyPartEnum = BodyPartEnum.valueOf(nbt.getString("bodyPartEnum"));
/*  70 */     InteractionHand hand = nbt.getBoolean("mainHand") ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;
/*  71 */     boolean shouldConsume = nbt.getBoolean("consumeItem");
/*  72 */     boolean shouldApplyEffect = nbt.getBoolean("applyEffect");
/*     */     
/*  74 */     ItemStack usedItemStack = player.getItemInHand(hand);
/*  75 */     if (LegendarySurvivalOverhaul.supplementariesLoaded) {
/*     */       
/*  77 */       ItemStack itemStackInBasket = SupplementariesUtil.getSelectedItemInLunchBasket(player.getItemInHand(hand));
/*  78 */       if (itemStackInBasket != ItemStack.EMPTY) {
/*  79 */         usedItemStack = itemStackInBasket;
/*     */       }
/*     */     } 
/*  82 */     ResourceLocation itemStackRegistryName = BuiltInRegistries.ITEM.getKey(usedItemStack.getItem());
/*  83 */     JsonHealingConsumable jhc = BodyDamageDataManager.getHealingItem(itemStackRegistryName);
/*     */     
/*  85 */     player.serverLevel().playSound(null, (Entity)player, (SoundEvent)SoundRegistry.HEAL_BODY_PART.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
/*     */     
/*  87 */     if (shouldConsume && !player.isCreative()) {
/*  88 */       usedItemStack.shrink(1);
/*     */     }
/*  90 */     if (jhc != null) {
/*     */       
/*  92 */       if (shouldApplyEffect)
/*  93 */         player.addEffect(new MobEffectInstance((Holder)MobEffectRegistry.RECOVERY, jhc.recoveryEffectDuration, jhc.recoveryEffectAmplifier, false, false, true)); 
/*  94 */       BodyDamageUtil.applyHealingTimeBodyPart((Player)player, bodyPartEnum, jhc.healingValue, jhc.healingTime);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void sendToServer(BodyPartEnum bodyPart, InteractionHand hand, boolean consumeItem, boolean applyEffect) {
/* 100 */     PacketDistributor.sendToServer(new BodyPartHealingTimeMessage(bodyPart, hand, consumeItem, applyEffect), new CustomPacketPayload[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
/* 106 */     return (CustomPacketPayload.Type)TYPE;
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\network\payloads\BodyPartHealingTimeMessage.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */