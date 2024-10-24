package service;

import model.ParkingFloor;
import model.ParkingSpot;
import model.Vehicle;

import java.util.Optional;

public interface SpotAssignmentStrategy {

    public Optional<ParkingSpot> issueSpot(ParkingFloor parkingFloor, Vehicle vehicle);

}
