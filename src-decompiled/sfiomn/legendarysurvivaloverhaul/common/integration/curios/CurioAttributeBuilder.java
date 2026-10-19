/*    */ package sfiomn.legendarysurvivaloverhaul.common.integration.curios;
/*    */ 
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.ai.attributes.Attribute;
/*    */ import net.minecraft.world.entity.ai.attributes.AttributeModifier;
/*    */ import sfiomn.legendarysurvivaloverhaul.util.AttributeBuilder;
/*    */ import top.theillusivec4.curios.api.event.CurioAttributeModifierEvent;
/*    */ 
/*    */ 
/*    */ public class CurioAttributeBuilder
/*    */   extends AttributeBuilder
/*    */ {
/*    */   public CurioAttributeBuilder(Holder<Attribute> attribute, ResourceLocation descriptionId) {
/* 15 */     super(attribute, descriptionId);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void addModifier(CurioAttributeModifierEvent event, ResourceLocation id, double value) {
/* 21 */     event.addModifier(this.attribute, new AttributeModifier(id, value, AttributeModifier.Operation.ADD_VALUE));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\curios\CurioAttributeBuilder.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */