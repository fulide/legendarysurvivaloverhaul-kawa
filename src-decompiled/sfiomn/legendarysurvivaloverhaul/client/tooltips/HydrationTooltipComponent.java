/*   */ package sfiomn.legendarysurvivaloverhaul.client.tooltips;
/*   */ public final class HydrationTooltipComponent extends Record implements TooltipComponent { private final int hydration;
/*   */   private final float saturation;
/*   */   
/* 5 */   public HydrationTooltipComponent(int hydration, float saturation) { this.hydration = hydration; this.saturation = saturation; } public final String toString() { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: <illegal opcode> toString : (Lsfiomn/legendarysurvivaloverhaul/client/tooltips/HydrationTooltipComponent;)Ljava/lang/String;
/*   */     //   6: areturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #5	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/* 5 */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/client/tooltips/HydrationTooltipComponent; } public int hydration() { return this.hydration; } public final int hashCode() { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: <illegal opcode> hashCode : (Lsfiomn/legendarysurvivaloverhaul/client/tooltips/HydrationTooltipComponent;)I
/*   */     //   6: ireturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #5	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/*   */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/client/tooltips/HydrationTooltipComponent; } public final boolean equals(Object o) { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: aload_1
/*   */     //   2: <illegal opcode> equals : (Lsfiomn/legendarysurvivaloverhaul/client/tooltips/HydrationTooltipComponent;Ljava/lang/Object;)Z
/*   */     //   7: ireturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #5	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/*   */     //   0	8	0	this	Lsfiomn/legendarysurvivaloverhaul/client/tooltips/HydrationTooltipComponent;
/* 5 */     //   0	8	1	o	Ljava/lang/Object; } public float saturation() { return this.saturation; }
/*   */    }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\client\tooltips\HydrationTooltipComponent.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */