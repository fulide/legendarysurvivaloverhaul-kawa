/*    */ package sfiomn.legendarysurvivaloverhaul.util;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.EquipmentSlot;
/*    */ import net.minecraft.world.entity.EquipmentSlotGroup;
/*    */ import net.minecraft.world.entity.ai.attributes.Attribute;
/*    */ import net.minecraft.world.entity.ai.attributes.AttributeInstance;
/*    */ import net.minecraft.world.entity.ai.attributes.AttributeModifier;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.neoforged.neoforge.event.ItemAttributeModifierEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AttributeBuilder
/*    */ {
/*    */   protected final Holder<Attribute> attribute;
/*    */   protected final ResourceLocation descriptionId;
/*    */   
/*    */   public AttributeBuilder(Holder<Attribute> attribute, ResourceLocation descriptionId) {
/* 23 */     this.attribute = attribute;
/* 24 */     this.descriptionId = descriptionId;
/*    */   }
/*    */ 
/*    */   
/*    */   public void addModifier(ItemAttributeModifierEvent event, UUID uuid, double value) {
/* 29 */     if (uuid == null || this.attribute == null || this.descriptionId == null) {
/*    */       return;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 36 */       EquipmentSlot slot = ItemUtil.getEquippableSlot(event.getItemStack());
/* 37 */       if (slot == null) {
/*    */         return;
/*    */       }
/*    */ 
/*    */       
/* 42 */       ResourceLocation modifierId = ResourceLocation.fromNamespaceAndPath(this.descriptionId
/* 43 */           .getNamespace(), this.descriptionId
/* 44 */           .getPath() + "_" + this.descriptionId.getPath());
/*    */       
/* 46 */       event.addModifier(this.attribute, new AttributeModifier(modifierId, value, AttributeModifier.Operation.ADD_VALUE), 
/*    */ 
/*    */           
/* 49 */           EquipmentSlotGroup.bySlot(slot));
/*    */     }
/* 51 */     catch (Exception e) {
/*    */ 
/*    */       
/* 54 */       System.err.println("Error adding attribute modifier: " + e.getMessage());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void addModifier(Player player, UUID uuid, double value) {
/* 60 */     AttributeInstance instance = player.getAttribute(this.attribute);
/* 61 */     if (instance != null) {
/*    */ 
/*    */       
/* 64 */       ResourceLocation modifierId = ResourceLocation.fromNamespaceAndPath(this.descriptionId
/* 65 */           .getNamespace(), this.descriptionId
/* 66 */           .getPath() + "_" + this.descriptionId.getPath());
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       try {
/* 72 */         AttributeModifier existingModifier = instance.getModifier(modifierId);
/* 73 */         if (existingModifier != null)
/*    */         {
/* 75 */           instance.removeModifier(modifierId);
/*    */         }
/* 77 */       } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/*    */ 
/*    */       
/* 80 */       } catch (Exception e) {
/*    */         
/* 82 */         System.err.println("Error checking for existing attribute modifier: " + e.getMessage());
/*    */       } 
/*    */       
/* 85 */       instance.addPermanentModifier(new AttributeModifier(modifierId, value, AttributeModifier.Operation.ADD_VALUE));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public AttributeInstance getAttribute(Player player) {
/* 91 */     return player.getAttribute(this.attribute);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhau\\util\AttributeBuilder.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */