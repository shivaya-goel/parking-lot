package service;

import model.ParkingFloor;
import model.ParkingSpot;
import model.Vehicle;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class NearestSpotAssignmentStrategy implements SpotAssignmentStrategy {

    @Override
    public Optional<ParkingSpot> issueSpot(ParkingFloor parkingFloor, Vehicle vehicle) {
        List<ParkingSpot> parkingSpots = parkingFloor.getSpots();
        return parkingSpots.stream()
                .filter(spot -> vehicle.getVehicleType().equals(spot.getSpotType()))
                .filter(spot -> !Objects.isNull(spot.getVehicle()))
                .findFirst();
    }

}
