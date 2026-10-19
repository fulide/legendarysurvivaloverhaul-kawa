/*     */ package sfiomn.legendarysurvivaloverhaul.common.temperature;
/*     */ import com.mojang.datafixers.util.Pair;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Direction;
/*     */ import net.minecraft.core.Vec3i;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureBlock;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.TemperatureDataManager;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.temperature.ModifierBase;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.MathUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.SpreadPoint;
/*     */ 
/*     */ public class BlockModifier extends ModifierBase {
/*  24 */   private float coldestValue = 0.0F;
/*  25 */   private float hottestValue = 0.0F;
/*  26 */   private float hotTotal = 0.0F;
/*  27 */   private float coldTotal = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int tempInfluenceMaximumDist() {
/*  36 */     return Config.Baked.tempInfluenceMaximumDist - 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getWorldInfluence(@Nullable Player player, Level level, BlockPos pos) {
/*  42 */     this.coldestValue = 0.0F;
/*  43 */     this.hottestValue = 0.0F;
/*     */     
/*  45 */     this.hotTotal = 0.0F;
/*  46 */     this.coldTotal = 0.0F;
/*     */     
/*  48 */     doBlocksAndFluidsRoutine(level, pos);
/*     */     
/*  50 */     this.hotTotal -= this.hottestValue;
/*  51 */     this.coldTotal -= this.coldestValue;
/*     */     
/*  53 */     float hotLogValue = this.hottestValue * (float)Math.sqrt(easyLog(this.hotTotal));
/*  54 */     float coldLogValue = this.coldestValue * (float)Math.sqrt(easyLog(this.coldTotal));
/*     */     
/*  56 */     float result = hotLogValue + coldLogValue;
/*     */     
/*  58 */     if (result > this.hottestValue)
/*     */     {
/*     */ 
/*     */       
/*  62 */       return Math.min(this.hottestValue + 2.5F, result); } 
/*  63 */     if (result < this.coldestValue)
/*     */     {
/*     */ 
/*     */       
/*  67 */       return Math.max(this.coldestValue - 2.5F, result);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  72 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void doBlocksAndFluidsRoutine(Level level, BlockPos pos) {
/*  78 */     HashSet<BlockPos> visitedBlockPos = new HashSet<>();
/*  79 */     ArrayList<SpreadPoint> visitedSpreadPoints = new ArrayList<>();
/*  80 */     ArrayList<SpreadPoint> spreadPointsToProcess = new ArrayList<>();
/*  81 */     Map<Pair<Integer, Integer>, Map<Boolean, Integer>> cachedCanSeeSky = new HashMap<>();
/*     */     
/*  83 */     SpreadPoint spreadPointFeetPlayer = new SpreadPoint(pos, Direction.DOWN, tempInfluenceMaximumDist(), 0.0D, level);
/*  84 */     SpreadPoint spreadPointHeadPlayer = new SpreadPoint(pos.above(), Direction.UP, tempInfluenceMaximumDist(), 0.0D, level);
/*  85 */     spreadPointsToProcess.add(spreadPointFeetPlayer);
/*  86 */     spreadPointsToProcess.add(spreadPointHeadPlayer);
/*     */     
/*  88 */     visitedBlockPos.add(spreadPointFeetPlayer.position());
/*  89 */     visitedBlockPos.add(spreadPointHeadPlayer.position());
/*  90 */     visitedSpreadPoints.add(spreadPointFeetPlayer);
/*  91 */     visitedSpreadPoints.add(spreadPointHeadPlayer);
/*     */     
/*  93 */     boolean hasCeiling = level.dimensionType().hasCeiling();
/*     */     
/*  95 */     while (!spreadPointsToProcess.isEmpty()) {
/*     */       
/*  97 */       SpreadPoint spreadPoint = spreadPointsToProcess.remove(0);
/*  98 */       spreadPoint.setCanSeeSky((!hasCeiling || level.canSeeSky(pos)));
/*  99 */       Direction oppositeDirection = spreadPoint.originalDirection().getOpposite();
/*     */       
/* 101 */       for (Direction direction : Direction.values()) {
/*     */ 
/*     */         
/* 104 */         if (direction != oppositeDirection)
/*     */         {
/* 106 */           if (spreadPoint.isValidSpreadDirection(direction)) {
/*     */             
/* 108 */             Vec3i newPosVector = direction.getNormal();
/* 109 */             SpreadPoint spreadPoint1 = processDirectionTo(spreadPointsToProcess, visitedBlockPos, visitedSpreadPoints, spreadPoint, spreadPoint.position().offset(newPosVector), direction, 1.0F);
/*     */             
/* 111 */             if (spreadPoint1 != null)
/*     */             {
/* 113 */               for (Direction direction1 : Direction.values()) {
/*     */ 
/*     */                 
/* 116 */                 if (direction1.getAxis() != direction.getAxis() && direction1 != oppositeDirection)
/*     */                 {
/* 118 */                   if (spreadPoint1.isValidSpreadDirection(direction)) {
/*     */                     
/* 120 */                     newPosVector = newPosVector.relative(direction1, 1);
/* 121 */                     SpreadPoint spreadPoint2 = processDirectionTo(spreadPointsToProcess, visitedBlockPos, visitedSpreadPoints, spreadPoint, spreadPoint.position().offset(newPosVector), direction1, 1.414F);
/*     */                     
/* 123 */                     if (spreadPoint2 != null)
/*     */                     {
/* 125 */                       for (Direction direction2 : Direction.values()) {
/*     */ 
/*     */                         
/* 128 */                         if (direction2.getAxis() != direction1.getAxis() && direction2.getAxis() != direction.getAxis() && direction2 != oppositeDirection)
/*     */                         {
/* 130 */                           if (spreadPoint2.isValidSpreadDirection(direction)) {
/*     */                             
/* 132 */                             newPosVector = newPosVector.relative(direction2, 1);
/* 133 */                             processDirectionTo(spreadPointsToProcess, visitedBlockPos, visitedSpreadPoints, spreadPoint, spreadPoint.position().offset(newPosVector), direction2, 1.732F);
/*     */                           }  } 
/*     */                       }  } 
/*     */                   } 
/*     */                 }
/*     */               } 
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/* 144 */     Map<ResourceLocation, List<JsonTemperatureBlock>> cachedTemperatureBlocks = new HashMap<>();
/*     */     
/* 146 */     for (SpreadPoint spreadPoint : visitedSpreadPoints)
/*     */     {
/* 148 */       processTemp(getTemperatureFromSpreadPoint(level, spreadPoint, cachedTemperatureBlocks));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private SpreadPoint processDirectionTo(ArrayList<SpreadPoint> spreadPointsToProcess, HashSet<BlockPos> visitedBlockPos, ArrayList<SpreadPoint> visitedSpreadPoints, SpreadPoint parentSpreadPoint, BlockPos newBlockPos, Direction originDirection, float distance) {
/* 155 */     if (!visitedBlockPos.contains(newBlockPos)) {
/*     */ 
/*     */       
/* 158 */       SpreadPoint newSpreadPoint = parentSpreadPoint.spreadTo(newBlockPos, originDirection, distance);
/* 159 */       visitedBlockPos.add(newSpreadPoint.position());
/* 160 */       visitedSpreadPoints.add(newSpreadPoint);
/*     */ 
/*     */       
/* 163 */       if (newSpreadPoint.isValidSpreadPoint(originDirection)) {
/*     */         
/* 165 */         spreadPointsToProcess.add(newSpreadPoint);
/* 166 */         return newSpreadPoint;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 182 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private void processTemp(float temp) {
/* 187 */     if (temp == 0.0F) {
/*     */       return;
/*     */     }
/* 190 */     if (temp >= 0.0F) {
/*     */       
/* 192 */       this.hotTotal += temp;
/* 193 */       if (temp > this.hottestValue)
/*     */       {
/* 195 */         this.hottestValue = temp;
/*     */       }
/*     */     } else {
/*     */       
/* 199 */       this.coldTotal += temp;
/* 200 */       if (temp < this.coldestValue)
/*     */       {
/* 202 */         this.coldestValue = temp;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private float easyLog(float f) {
/* 209 */     if (f >= 0.0F)
/*     */     {
/* 211 */       return (float)Math.log10((f + 10.0F));
/*     */     }
/*     */     
/* 214 */     return (float)Math.log10((-1.0F * f + 10.0F));
/*     */   }
/*     */ 
/*     */   
/*     */   private float getTemperatureFromSpreadPoint(Level level, SpreadPoint spreadPoint, Map<ResourceLocation, List<JsonTemperatureBlock>> cachedTemperatureBlocks) {
/*     */     List<JsonTemperatureBlock> tempPropertyList;
/* 220 */     BlockState blockState = level.getBlockState(spreadPoint.position());
/* 221 */     float temperature = 0.0F;
/* 222 */     ResourceLocation registryName = BuiltInRegistries.BLOCK.getKey(blockState.getBlock());
/*     */     
/* 224 */     if (registryName == null || blockState.isAir())
/*     */     {
/* 226 */       return 0.0F;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 232 */     if (cachedTemperatureBlocks.containsKey(registryName)) {
/*     */       
/* 234 */       tempPropertyList = cachedTemperatureBlocks.get(registryName);
/*     */     } else {
/*     */       
/* 237 */       tempPropertyList = TemperatureDataManager.getBlock(registryName);
/* 238 */       cachedTemperatureBlocks.put(registryName, tempPropertyList);
/*     */     } 
/*     */     
/* 241 */     if (tempPropertyList == null)
/*     */     {
/* 243 */       return 0.0F;
/*     */     }
/*     */     
/* 246 */     for (JsonTemperatureBlock tempInfo : tempPropertyList) {
/*     */       
/* 248 */       if (tempInfo == null) {
/*     */         continue;
/*     */       }
/* 251 */       if (tempInfo.matchesState(blockState)) {
/*     */         
/* 253 */         temperature = tempInfo.temperature;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 258 */     return (temperature == 0.0F) ? temperature : temperatureAfterDistanceInfluence(temperature, spreadPoint);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private float temperatureAfterDistanceInfluence(float tempIn, SpreadPoint spreadPoint) {
/* 287 */     float capacityConsumed = MathUtil.round((float)Math.max(tempInfluenceMaximumDist() - spreadPoint.spreadCapacity() - 1.0D, 0.0D) / tempInfluenceMaximumDist(), 2);
/*     */ 
/*     */ 
/*     */     
/* 291 */     return MathUtil.round((float)Math.sqrt((1.0F - capacityConsumed)) * tempIn, 2);
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\temperature\BlockModifier.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */