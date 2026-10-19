/*     */ package sfiomn.legendarysurvivaloverhaul.util;
/*     */ 
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Direction;
/*     */ import net.minecraft.world.level.BlockGetter;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.block.Blocks;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*     */ 
/*     */ public class SpreadPoint
/*     */ {
/*     */   private final BlockPos pos;
/*     */   private final Direction originDirection;
/*     */   private final double spreadCapacity;
/*     */   private final double influenceDistance;
/*     */   private final Level level;
/*     */   private final BlockState blockState;
/*     */   private boolean canSeeSky;
/*     */   private boolean isWater;
/*     */   
/*     */   public SpreadPoint(BlockPos pos, Direction originDirection, double spreadCapacity, double influenceDistance, Level level) {
/*  23 */     this.pos = pos;
/*  24 */     this.originDirection = originDirection;
/*  25 */     this.spreadCapacity = spreadCapacity;
/*  26 */     this.influenceDistance = influenceDistance;
/*  27 */     this.level = level;
/*  28 */     this.blockState = level.getBlockState(pos);
/*  29 */     this.canSeeSky = false;
/*  30 */     this.isWater = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public double influenceDistance() {
/*  35 */     return this.influenceDistance;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockPos position() {
/*  40 */     return this.pos;
/*     */   }
/*     */ 
/*     */   
/*     */   public Direction originalDirection() {
/*  45 */     return this.originDirection;
/*     */   }
/*     */ 
/*     */   
/*     */   public double spreadCapacity() {
/*  50 */     return this.spreadCapacity;
/*     */   }
/*     */ 
/*     */   
/*     */   public SpreadPoint spreadTo(BlockPos newBlockPos, Direction originDirection, float distance) {
/*  55 */     return new SpreadPoint(newBlockPos, originDirection, this.spreadCapacity - distance * consumptionMultiplier(originDirection), this.influenceDistance + distance, this.level);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isValidSpreadPoint(Direction originDirection) {
/*  61 */     if (this.spreadCapacity <= 0.0D)
/*     */     {
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     if (this.blockState.isAir())
/*  67 */       return true; 
/*  68 */     if (this.blockState.is(Blocks.WATER)) {
/*     */       
/*  70 */       this.isWater = true;
/*  71 */       return true;
/*     */     } 
/*     */     
/*  74 */     return !this.blockState.isFaceSturdy((BlockGetter)this.level, this.pos, originDirection.getOpposite());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isValidSpreadDirection(Direction direction) {
/*  80 */     return !this.blockState.isFaceSturdy((BlockGetter)this.level, this.pos, direction);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCanSeeSky(boolean canSeeSky) {
/*  85 */     this.canSeeSky = canSeeSky;
/*     */   }
/*     */ 
/*     */   
/*     */   private double consumptionMultiplier(Direction originDirection) {
/*  90 */     boolean upDirection = (originDirection.getNormal().getY() > 0);
/*  91 */     double consumptionMultiplier = 1.0D;
/*  92 */     if (this.isWater) {
/*     */       
/*  94 */       consumptionMultiplier *= Config.Baked.tempInfluenceInWaterDistMultiplier;
/*  95 */     } else if (this.canSeeSky) {
/*     */       
/*  97 */       consumptionMultiplier *= Config.Baked.tempInfluenceOutsideDistMultiplier;
/*     */     } 
/*  99 */     if (upDirection)
/*     */     {
/* 101 */       consumptionMultiplier *= Config.Baked.tempInfluenceUpDistMultiplier;
/*     */     }
/* 103 */     return 1.0D / consumptionMultiplier;
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhau\\util\SpreadPoint.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */