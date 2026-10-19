/*    */ package sfiomn.legendarysurvivaloverhaul.common.blockentities;
/*    */ 
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.entity.player.Inventory;
/*    */ import net.minecraft.world.inventory.AbstractContainerMenu;
/*    */ import net.minecraft.world.level.block.entity.BlockEntity;
/*    */ import net.minecraft.world.level.block.entity.BlockEntityType;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.block.ThermalTypeEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.containers.CoolerContainer;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.BlockEntityRegistry;
/*    */ 
/*    */ public class CoolerBlockEntity
/*    */   extends AbstractThermalBlockEntity
/*    */ {
/*    */   public CoolerBlockEntity(BlockPos pos, BlockState state) {
/* 19 */     super((BlockEntityType)BlockEntityRegistry.COOLER_BLOCK_ENTITY.get(), ThermalTypeEnum.COOLING, pos, state);
/*    */   }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public Component getDefaultName() {
/* 25 */     return (Component)Component.translatable("container.legendarysurvivaloverhaul.cooler");
/*    */   }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory) {
/* 31 */     return (AbstractContainerMenu)new CoolerContainer(id, inventory, (BlockEntity)this, this.dataAccess);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\blockentities\CoolerBlockEntity.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */