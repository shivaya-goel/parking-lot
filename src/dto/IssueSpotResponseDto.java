package dto;

import model.ParkingFloor;
import model.ParkingSpot;

public class IssueSpotResponseDto {

    private ParkingSpot parkingSpot;
    private ParkingFloor parkingFloor;

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

}
