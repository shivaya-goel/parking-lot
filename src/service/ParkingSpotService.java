package service;

import dto.IssueSpotDto;
import dto.IssueSpotResponseDto;
import exceptions.CustomException;
import model.ParkingFloor;
import model.ParkingLot;
import model.ParkingSpot;
import model.Vehicle;
import repository.ParkingFloorRepository;
import repository.VehicleRepository;

import java.util.Optional;

public class ParkingSpotService {
    private final ParkingFloorRepository parkingFloorRepository;
    private final VehicleRepository vehicleRepository;
    private final SpotAssignmentStrategyFactory spotAssignmentStrategyFactory;
    private final ParkingLot parkingLot;


    public ParkingSpotService(ParkingFloorRepository parkingFloorRepository, VehicleRepository vehicleRepository, SpotAssignmentStrategyFactory spotAssignmentStrategyFactory, ParkingLot parkingLot) {
        this.parkingFloorRepository = parkingFloorRepository;
        this.vehicleRepository = vehicleRepository;
        this.spotAssignmentStrategyFactory = spotAssignmentStrategyFactory;
        this.parkingLot = parkingLot;
    }

    public IssueSpotResponseDto issueSpot(IssueSpotDto issueSpotDto) {

        ParkingFloor parkingFloor = getParkingFloor(issueSpotDto);
        Vehicle vehicle = getVehicle(issueSpotDto);

        SpotAssignmentStrategy spotAssignmentStrategy =
                spotAssignmentStrategyFactory.getStrategyService(parkingFloor.getSpotAssignmentStrategy());
        Optional<ParkingSpot> parkingSpot = spotAssignmentStrategy.issueSpot(parkingFloor, vehicle);
        if (parkingSpot.isEmpty()) {
            throw new CustomException("Parking is full");
        }

        vehicle.setParkingSpot(parkingSpot.get());
        vehicleRepository.save(vehicle);

        IssueSpotResponseDto issueSpotResponseDto = new IssueSpotResponseDto();
        issueSpotResponseDto.setParkingSpot(parkingSpot.get());
        issueSpotResponseDto.setParkingFloor(parkingFloor);
        return issueSpotResponseDto;

    }

    private ParkingFloor getParkingFloor(IssueSpotDto issueSpotDto) {
        // Fetches the floor by the gate from which vehicle has entered
        Long floorId = parkingLot.getGateFloorMap().get(issueSpotDto.getGateId());

        Optional<ParkingFloor> parkingFloor = parkingFloorRepository.findById(floorId);
        if (parkingFloor.isEmpty()) {
            throw new CustomException("Parking floor not found");
        }

        return parkingFloor.get();
    }

    private Vehicle getVehicle(IssueSpotDto issueSpotDto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(issueSpotDto.getVehicleType());
        vehicle.setLicencePlate(issueSpotDto.getLicencePlate());
        vehicle.setOwnerName(issueSpotDto.getOwnerName());
        return vehicle;
    }
}
