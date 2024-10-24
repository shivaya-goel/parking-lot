package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot extends BaseModel {

    private static ParkingLot instance;

    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private Map<Long, Long> gateFloorMap;

    public ParkingLot() {
        parkingFloors = new ArrayList<>();
        gateFloorMap = new HashMap<>();
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public Map<Long, Long> getGateFloorMap() {
        return gateFloorMap;
    }

    public void setGateFloorMap(Map<Long, Long> gateFloorMap) {
        this.gateFloorMap = gateFloorMap;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }
}
