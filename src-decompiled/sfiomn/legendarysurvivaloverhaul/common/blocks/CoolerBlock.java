/*    */ package sfiomn.legendarysurvivaloverhaul.common.blocks;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.core.particles.ParticleOptions;
/*    */ import net.minecraft.core.particles.ParticleTypes;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.sounds.SoundSource;
/*    */ import net.minecraft.util.RandomSource;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.block.SoundType;
/*    */ import net.minecraft.world.level.block.entity.BlockEntityTicker;
/*    */ import net.minecraft.world.level.block.entity.BlockEntityType;
/*    */ import net.minecraft.world.level.block.state.BlockBehaviour;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraft.world.level.block.state.properties.Property;
/*    */ import net.minecraft.world.level.material.MapColor;
/*    */ import net.neoforged.api.distmarker.Dist;
/*    */ import net.neoforged.api.distmarker.OnlyIn;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.block.ThermalTypeEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.blockentities.AbstractThermalBlockEntity;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.BlockEntityRegistry;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.SoundRegistry;
/*    */ 
/*    */ public class CoolerBlock extends ThermalBlock {
/* 25 */   public static final BlockBehaviour.Properties properties = getProperties();
/*    */ 
/*    */   
/*    */   public CoolerBlock(ThermalTypeEnum thermalType) {
/* 29 */     super(thermalType, properties);
/*    */   }
/*    */ 
/*    */   
/*    */   public static BlockBehaviour.Properties getProperties() {
/* 34 */     return 
/* 35 */       BlockBehaviour.Properties.of()
/* 36 */       .mapColor(MapColor.WOOD)
/* 37 */       .sound(SoundType.WOOD)
/* 38 */       .strength(2.0F, 10.0F)
/* 39 */       .noOcclusion();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   public <T extends net.minecraft.world.level.block.entity.BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState p_153213_, BlockEntityType<T> entityType) {
/* 46 */     return level.isClientSide ? null : createTickerHelper(entityType, (BlockEntityType)BlockEntityRegistry.COOLER_BLOCK_ENTITY.get(), AbstractThermalBlockEntity::serverTick);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @OnlyIn(Dist.CLIENT)
/*    */   public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
/* 53 */     if (((Boolean)state.getValue((Property)LIT)).booleanValue()) {
/*    */       
/* 55 */       float chanceSound = 0.1F;
/* 56 */       float chanceParticle = 0.25F;
/* 57 */       double posX = pos.getX();
/* 58 */       double posY = pos.getY();
/* 59 */       double posZ = pos.getZ();
/* 60 */       if (rand.nextFloat() < chanceSound)
/*    */       {
/* 62 */         level.playLocalSound(posX + 0.5D, posY + 0.5D, posZ + 0.5D, (SoundEvent)SoundRegistry.COOLER_BLOCK.get(), SoundSource.BLOCKS, 1.0F, 1.0F, false);
/*    */       }
/*    */       
/* 65 */       if (rand.nextFloat() < chanceParticle) {
/*    */ 
/*    */ 
/*    */         
/* 69 */         float xr = rand.nextFloat();
/* 70 */         float zr = rand.nextFloat();
/*    */         
/* 72 */         level.addParticle((ParticleOptions)ParticleTypes.ITEM_SNOWBALL, false, posX + xr, posY + 1.0D, posZ + zr, 0.0D, 0.0D, 0.0D);
/*    */       } 
/*    */     } 
/* 75 */     super.animateTick(state, level, pos, rand);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\blocks\CoolerBlock.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */