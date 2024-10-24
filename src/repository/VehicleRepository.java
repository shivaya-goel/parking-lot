package repository;

import model.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {

    private final Map<String, Vehicle> vehcleLicenceMap;

    public VehicleRepository() {
        this.vehcleLicenceMap = new HashMap<>();
    }

    public Optional<Vehicle> findByLicencePlate(String licencePlate) {
        if (vehcleLicenceMap.containsKey(licencePlate)) {
            return Optional.of(vehcleLicenceMap.get(licencePlate));
        }
        return Optional.empty();
    }

    public Vehicle save(Vehicle vehicle) {
        vehcleLicenceMap.put(vehicle.getLicencePlate(), vehicle);
        return vehicle;
    }

}
