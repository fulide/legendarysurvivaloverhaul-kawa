/*     */ package sfiomn.legendarysurvivaloverhaul.common.attachments.bodydamage;
/*     */ 
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.util.Mth;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.BodyPartEnum;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BodyPart
/*     */ {
/*     */   private final float healthMultiplier;
/*     */   private final BodyPartEnum bodyPartEnum;
/*     */   private float oldMaxHealth;
/*     */   private float oldDamage;
/*     */   private float damage;
/*     */   private float maxHealth;
/*     */   private int remainingHealingTicks;
/*     */   private float healingPerTicks;
/*     */   
/*     */   public BodyPart(BodyPartEnum bodyPart, float healthMultiplier) {
/*  22 */     this.bodyPartEnum = bodyPart;
/*  23 */     this.healthMultiplier = healthMultiplier;
/*     */     
/*  25 */     this.maxHealth = 0.0F;
/*  26 */     this.damage = 0.0F;
/*  27 */     this.remainingHealingTicks = 0;
/*  28 */     this.healingPerTicks = 0.0F;
/*     */     
/*  30 */     this.oldMaxHealth = 0.0F;
/*  31 */     this.oldDamage = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDirty() {
/*  36 */     return (this.oldDamage != this.damage || this.oldMaxHealth != this.maxHealth);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setClean() {
/*  41 */     this.oldDamage = this.damage;
/*  42 */     this.oldMaxHealth = this.maxHealth;
/*     */   }
/*     */ 
/*     */   
/*     */   public void heal(float value) {
/*  47 */     setDamage(this.damage - value);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hurt(float value) {
/*  52 */     setDamage(this.damage + value);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isMaxHealth() {
/*  57 */     return (this.damage == 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getHealthMultiplier() {
/*  62 */     return this.healthMultiplier;
/*     */   }
/*     */ 
/*     */   
/*     */   public BodyPartEnum getBodyPartEnum() {
/*  67 */     return this.bodyPartEnum;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getDamage() {
/*  72 */     return this.damage;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDamage(float value) {
/*  77 */     this.damage = Mth.clamp(value, 0.0F, this.maxHealth);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getMaxHealth() {
/*  82 */     return this.maxHealth;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaxHealth(float value) {
/*  87 */     this.maxHealth = value;
/*  88 */     this.damage = Math.min(this.maxHealth, this.damage);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRemainingHealingTicks() {
/*  93 */     return this.remainingHealingTicks;
/*     */   }
/*     */ 
/*     */   
/*     */   public void reduceRemainingHealingTicks(int healingTick) {
/*  98 */     this.remainingHealingTicks -= Math.min(healingTick, this.remainingHealingTicks);
/*  99 */     if (this.remainingHealingTicks == 0)
/*     */     {
/* 101 */       this.healingPerTicks = 0.0F;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public float getHealingPerTicks() {
/* 107 */     return this.healingPerTicks;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHealing(int healingTick, float healingValuePerTick) {
/* 112 */     this.remainingHealingTicks = healingTick;
/* 113 */     this.healingPerTicks = healingValuePerTick;
/*     */   }
/*     */ 
/*     */   
/*     */   public CompoundTag writeNbt(CompoundTag nbt) {
/* 118 */     nbt.putFloat(this.bodyPartEnum.name() + "_damage", this.damage);
/* 119 */     nbt.putFloat(this.bodyPartEnum.name() + "_maxHealth", this.maxHealth);
/* 120 */     nbt.putFloat(this.bodyPartEnum.name() + "_healingPerTicks", this.healingPerTicks);
/* 121 */     nbt.putInt(this.bodyPartEnum.name() + "_remainingHealingTicks", this.remainingHealingTicks);
/*     */ 
/*     */     
/* 124 */     return nbt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void readNBT(CompoundTag compound) {
/* 129 */     float oldMaxHealth = this.maxHealth;
/* 130 */     float oldDamage = this.damage;
/*     */ 
/*     */     
/* 133 */     if (compound.contains(this.bodyPartEnum.name() + "_maxHealth")) {
/*     */       
/* 135 */       float savedMaxHealth = compound.getFloat(this.bodyPartEnum.name() + "_maxHealth");
/*     */ 
/*     */       
/* 138 */       if (savedMaxHealth > 0.0F)
/*     */       {
/* 140 */         setMaxHealth(savedMaxHealth);
/*     */       }
/*     */     } 
/* 143 */     if (compound.contains(this.bodyPartEnum.name() + "_damage"))
/*     */     {
/* 145 */       setDamage(compound.getFloat(this.bodyPartEnum.name() + "_damage"));
/*     */     }
/* 147 */     if (compound.contains(this.bodyPartEnum.name() + "_remainingHealingTicks"))
/*     */     {
/* 149 */       this.remainingHealingTicks = compound.getInt(this.bodyPartEnum.name() + "_remainingHealingTicks");
/*     */     }
/* 151 */     if (compound.contains(this.bodyPartEnum.name() + "_healingPerTicks"))
/*     */     {
/* 153 */       this.healingPerTicks = compound.getFloat(this.bodyPartEnum.name() + "_healingPerTicks");
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\attachments\bodydamage\BodyPart.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */