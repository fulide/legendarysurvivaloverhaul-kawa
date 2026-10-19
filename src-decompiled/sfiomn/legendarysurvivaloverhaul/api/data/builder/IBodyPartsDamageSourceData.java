package sfiomn.legendarysurvivaloverhaul.api.data.builder;

import com.google.gson.JsonObject;
import java.util.List;
import sfiomn.legendarysurvivaloverhaul.api.bodydamage.BodyPartEnum;
import sfiomn.legendarysurvivaloverhaul.api.bodydamage.DamageDistributionEnum;

public interface IBodyPartsDamageSourceData {
  IBodyPartsDamageSourceData damageDistribution(DamageDistributionEnum paramDamageDistributionEnum);
  
  IBodyPartsDamageSourceData addBodyPart(BodyPartEnum paramBodyPartEnum);
  
  IBodyPartsDamageSourceData addBodyParts(List<BodyPartEnum> paramList);
  
  JsonObject build();
}


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\builder\IBodyPartsDamageSourceData.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */