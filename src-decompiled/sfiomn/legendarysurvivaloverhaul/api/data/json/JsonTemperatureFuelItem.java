/*    */ package sfiomn.legendarysurvivaloverhaul.api.data.json;
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.serialization.Codec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.block.ThermalTypeEnum;
/*    */ 
/*    */ public class JsonTemperatureFuelItem {
/*    */   static {
/*  9 */     CODEC = RecordCodecBuilder.create(inst -> inst.group((App)Codec.STRING.fieldOf("thermal_type").forGetter(()), (App)Codec.INT.fieldOf("duration").forGetter(())).apply((Applicative)inst, JsonTemperatureFuelItem::new));
/*    */   }
/*    */ 
/*    */   
/*    */   public static final Codec<JsonTemperatureFuelItem> CODEC;
/*    */   
/*    */   public ThermalTypeEnum thermalType;
/*    */   public int duration;
/*    */   
/*    */   public JsonTemperatureFuelItem(String thermalType, int duration) {
/* 19 */     this.thermalType = ThermalTypeEnum.get(thermalType);
/* 20 */     this.duration = duration;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\json\JsonTemperatureFuelItem.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */