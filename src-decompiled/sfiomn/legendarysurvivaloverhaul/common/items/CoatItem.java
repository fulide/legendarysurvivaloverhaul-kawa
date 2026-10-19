/*    */ package sfiomn.legendarysurvivaloverhaul.common.items;
/*    */ 
/*    */ import com.mojang.blaze3d.platform.InputConstants;
/*    */ import com.mojang.blaze3d.systems.RenderSystem;
/*    */ import java.util.List;
/*    */ import java.util.Objects;
/*    */ import net.minecraft.ChatFormatting;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.network.chat.MutableComponent;
/*    */ import net.minecraft.network.chat.Style;
/*    */ import net.minecraft.network.chat.TextColor;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.TooltipFlag;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.item.CoatEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.KeyMappingRegistry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CoatItem
/*    */   extends Item
/*    */ {
/*    */   public CoatEnum coat;
/*    */   
/*    */   public CoatItem(CoatEnum coat, Item.Properties properties) {
/* 29 */     super(properties);
/* 30 */     this.coat = coat;
/*    */   }
/*    */ 
/*    */   
/*    */   public void appendHoverText(ItemStack stack, @Nullable Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
/*    */     MutableComponent text;
/* 36 */     super.appendHoverText(stack, context, tooltipComponents, isAdvanced);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 41 */     boolean showDetails = false;
/* 42 */     if (RenderSystem.isOnRenderThread()) {
/*    */       
/* 44 */       long windowHandle = Minecraft.getInstance().getWindow().getWindow();
/* 45 */       int key = KeyMappingRegistry.showAddedDesc.getKey().getValue();
/* 46 */       if (windowHandle != 0L && key != -1)
/*    */       {
/* 48 */         showDetails = InputConstants.isKeyDown(windowHandle, key);
/*    */       }
/*    */     } 
/*    */     
/* 52 */     if (showDetails) {
/*    */       
/* 54 */       if (this.coat != null) {
/*    */         
/* 56 */         MutableComponent effectComponent = Component.translatable("tooltip.legendarysurvivaloverhaul.coat_item." + this.coat.type() + ".effect").withStyle(Style.EMPTY.withColor(TextColor.fromRgb(6466303)));
/* 57 */         MutableComponent temperatureComponent = Component.literal(" " + this.coat.modifier());
/*    */         
/* 59 */         if (Objects.equals(this.coat.type(), "heating")) {
/*    */           
/* 61 */           effectComponent = effectComponent.withStyle(Style.EMPTY.withColor(TextColor.fromRgb(6466303)));
/* 62 */           temperatureComponent = temperatureComponent.withStyle(Style.EMPTY.withColor(TextColor.fromRgb(6466303)));
/* 63 */         } else if (Objects.equals(this.coat.type(), "cooling")) {
/*    */           
/* 65 */           effectComponent = effectComponent.withStyle(Style.EMPTY.withColor(TextColor.fromRgb(16420407)));
/* 66 */           temperatureComponent = temperatureComponent.withStyle(Style.EMPTY.withColor(TextColor.fromRgb(16420407)));
/*    */         } else {
/*    */           
/* 69 */           effectComponent = effectComponent.withStyle(Style.EMPTY.withColor(TextColor.fromRgb(10040319)));
/* 70 */           temperatureComponent = temperatureComponent.withStyle(Style.EMPTY.withColor(TextColor.fromRgb(10040319)));
/*    */         } 
/*    */         
/* 73 */         text = Component.translatable("tooltip.legendarysurvivaloverhaul.coat_item.desc", new Object[] { effectComponent }).append((Component)temperatureComponent);
/*    */       }
/*    */       else {
/*    */         
/*    */         return;
/*    */       } 
/*    */     } else {
/*    */       
/* 81 */       text = Component.literal(String.valueOf(ChatFormatting.GRAY) + String.valueOf(ChatFormatting.GRAY));
/*    */     } 
/*    */     
/* 84 */     tooltipComponents.add(text);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\items\CoatItem.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */