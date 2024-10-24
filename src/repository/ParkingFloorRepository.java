package repository;

import model.ParkingFloor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ParkingFloorRepository {

    private Map<Long, ParkingFloor> parkingFloorMap;

    public ParkingFloorRepository() {
        this.parkingFloorMap = new HashMap<>();
    }

    public Optional<ParkingFloor> findById(Long id) {
        if (parkingFloorMap.containsKey(id)) {
            return Optional.of(parkingFloorMap.get(id));
        }
        return Optional.empty();
    }

}
