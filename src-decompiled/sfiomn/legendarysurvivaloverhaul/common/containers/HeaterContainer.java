/*    */ package sfiomn.legendarysurvivaloverhaul.common.containers;
/*    */ 
/*    */ import net.minecraft.network.FriendlyByteBuf;
/*    */ import net.minecraft.world.entity.player.Inventory;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.inventory.ContainerData;
/*    */ import net.minecraft.world.inventory.ContainerLevelAccess;
/*    */ import net.minecraft.world.inventory.SimpleContainerData;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.minecraft.world.level.block.entity.BlockEntity;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.block.ThermalTypeEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.blockentities.AbstractThermalBlockEntity;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.BlockRegistry;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.ContainerRegistry;
/*    */ 
/*    */ public class HeaterContainer
/*    */   extends AbstractThermalContainer
/*    */ {
/*    */   public HeaterContainer(int windowId, Inventory playerInventory, BlockEntity be, ContainerData dataAccess) {
/* 20 */     super(windowId, playerInventory, (AbstractThermalBlockEntity)be, dataAccess, ContainerRegistry.HEATER_CONTAINER, ThermalTypeEnum.HEATING);
/*    */   }
/*    */ 
/*    */   
/*    */   public HeaterContainer(int windowId, Inventory playerInv, FriendlyByteBuf data) {
/* 25 */     this(windowId, playerInv, playerInv.player.level().getBlockEntity(data.readBlockPos()), (ContainerData)new SimpleContainerData(2));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean stillValid(Player player) {
/* 31 */     return stillValid(ContainerLevelAccess.create(this.level, this.blockEntity.getBlockPos()), player, (Block)BlockRegistry.HEATER.get());
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\containers\HeaterContainer.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */