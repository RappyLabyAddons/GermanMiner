package de.germanminer.addon.v1_21_3;

import de.germanminer.addon.api.vehicle.Vehicle;
import de.germanminer.addon.controller.VehicleController;
import java.util.List;
import javax.inject.Singleton;
import net.labymod.api.models.Implements;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.Entity;

@Singleton
@Implements(VehicleController.class)
public class VersionedVehicleController extends VehicleController {

  @Override
  public void fixVehicles(final List<Vehicle> vehicles) {
    vehicles.forEach(vehicle -> {
      final ClientLevel level = Minecraft.getInstance().level;
      if(level == null) return;
      final Entity entity = level.getEntity(vehicle.getEntityId());

      if (entity == null) return;
      entity.moveTo(
          vehicle.getX(),
          vehicle.getY(),
          vehicle.getZ(),
          vehicle.getYaw(),
          vehicle.getPitch()
      );
    });
  }

}
