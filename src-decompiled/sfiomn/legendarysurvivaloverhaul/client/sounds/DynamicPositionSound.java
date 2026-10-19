/*    */ package sfiomn.legendarysurvivaloverhaul.client.sounds;
/*    */ 
/*    */ import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
/*    */ import net.minecraft.client.resources.sounds.SoundInstance;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.sounds.SoundSource;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ 
/*    */ public class DynamicPositionSound
/*    */   extends AbstractTickableSoundInstance
/*    */ {
/*    */   private final Player player;
/*    */   private int time;
/*    */   
/*    */   public DynamicPositionSound(SoundEvent soundEvent, Player player) {
/* 16 */     super(soundEvent, SoundSource.PLAYERS, SoundInstance.createUnseededRandom());
/* 17 */     this.player = player;
/* 18 */     this.looping = false;
/* 19 */     this.volume = 1.0F;
/* 20 */     this.time = 60;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void tick() {
/* 26 */     if (this.player.isAlive() && this.time-- >= 0) {
/*    */       
/* 28 */       this.x = this.player.getX();
/* 29 */       this.y = this.player.getY();
/* 30 */       this.z = this.player.getZ();
/*    */     }
/*    */     else {
/*    */       
/* 34 */       stop();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\client\sounds\DynamicPositionSound.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */