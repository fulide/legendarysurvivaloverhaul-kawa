package sfiomn.legendarysurvivaloverhaul.api.health;

public interface IHealthAttachment {
  void addAdditionalHealth(float paramFloat);
  
  void addShieldHealth(float paramFloat);
  
  float getAdditionalHealth();
  
  void setAdditionalHealth(float paramFloat);
  
  float getShieldHealth();
  
  void setShieldHealth(float paramFloat);
  
  boolean isDirty();
  
  void setClean();
  
  int getPacketTimer();
}


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\health\IHealthAttachment.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */