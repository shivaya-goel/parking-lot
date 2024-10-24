package model;

import java.util.List;

public class ParkingFloor extends BaseModel {

    private int floorLevel;
    private List<ParkingSpot> spots;
    private ParkingFloorStatus parkingFloorStatus;
    private SpotAssignmentStrategyType spotAssignmentStrategyType;

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public void setSpots(List<ParkingSpot> spots) {
        this.spots = spots;
    }

    public int getFloorLevel() {
        return floorLevel;
    }

    public void setFloorLevel(int floorLevel) {
        this.floorLevel = floorLevel;
    }

    public SpotAssignmentStrategyType getSpotAssignmentStrategy() {
        return spotAssignmentStrategyType;
    }

    public void setSpotAssignmentStrategy(SpotAssignmentStrategyType spotAssignmentStrategyType) {
        this.spotAssignmentStrategyType = spotAssignmentStrategyType;
    }

    public ParkingFloorStatus getParkingFloorStatus() {
        return parkingFloorStatus;
    }

    public void setParkingFloorStatus(ParkingFloorStatus parkingFloorStatus) {
        this.parkingFloorStatus = parkingFloorStatus;
    }
}
