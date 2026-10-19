/*    */ package sfiomn.legendarysurvivaloverhaul.common.items;
/*    */ 
/*    */ import com.mojang.blaze3d.platform.InputConstants;
/*    */ import com.mojang.blaze3d.systems.RenderSystem;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.ChatFormatting;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.network.chat.MutableComponent;
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.InteractionResultHolder;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.TooltipFlag;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.attachments.temperature.TemperatureItemAttachment;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.KeyMappingRegistry;
/*    */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*    */ import sfiomn.legendarysurvivaloverhaul.util.WorldUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ThermometerItem
/*    */   extends Item
/*    */ {
/*    */   public ThermometerItem(Item.Properties properties) {
/* 33 */     super(properties);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
/* 39 */     if (level.isClientSide()) {
/*    */       MutableComponent mutableComponent;
/* 41 */       TemperatureItemAttachment tempCap = AttachmentUtil.getTempItemAttachment(player.getMainHandItem());
/*    */       
/* 43 */       float temperature = tempCap.getWorldTemperatureLevel();
/*    */       
/* 45 */       if (Config.Baked.renderTemperatureInFahrenheit) {
/*    */         
/* 47 */         mutableComponent = Component.literal("" + WorldUtil.toFahrenheit(temperature) + "°F");
/*    */       } else {
/*    */         
/* 50 */         mutableComponent = Component.literal("" + temperature + "°C");
/*    */       } 
/* 52 */       player.displayClientMessage((Component)mutableComponent, true);
/*    */     } 
/* 54 */     return super.use(level, player, hand);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void appendHoverText(ItemStack stack, @Nullable Item.TooltipContext level, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag isAdvanced) {
/* 60 */     super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
/* 61 */     List<MutableComponent> text = new ArrayList<>();
/*    */ 
/*    */     
/* 64 */     boolean showDetails = false;
/* 65 */     if (RenderSystem.isOnRenderThread()) {
/*    */       
/* 67 */       long windowHandle = Minecraft.getInstance().getWindow().getWindow();
/* 68 */       int key = KeyMappingRegistry.showAddedDesc.getKey().getValue();
/* 69 */       if (windowHandle != 0L && key != -1)
/*    */       {
/* 71 */         showDetails = InputConstants.isKeyDown(windowHandle, key);
/*    */       }
/*    */     } 
/*    */     
/* 75 */     if (showDetails) {
/*    */       
/* 77 */       text.add(Component.translatable("tooltip.legendarysurvivaloverhaul.thermometer.description"));
/* 78 */       if (LegendarySurvivalOverhaul.curiosLoaded) {
/* 79 */         text.add(Component.translatable("tooltip.legendarysurvivaloverhaul.thermometer.bauble_description"));
/*    */       }
/*    */     } else {
/*    */       
/* 83 */       text.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + String.valueOf(ChatFormatting.GRAY)));
/*    */     } 
/*    */     
/* 86 */     tooltipComponents.addAll(text);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\items\ThermometerItem.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */