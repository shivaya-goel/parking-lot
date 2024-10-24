package controller;

import dto.IssueSpotDto;
import dto.IssueSpotResponseDto;
import model.ParkingFloor;
import model.ParkingSpot;
import service.ParkingSpotService;

public class ParkingController {

    private ParkingSpotService parkingSpotService;

    public ParkingController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    public void issueSpot(IssueSpotDto issueSpotDto) {
        IssueSpotResponseDto issueSpotResponseDto = parkingSpotService.issueSpot(issueSpotDto);
        ParkingSpot parkingSpot = issueSpotResponseDto.getParkingSpot();
        ParkingFloor parkingFloor = issueSpotResponseDto.getParkingFloor();
        System.out.println("Assigned spot is " + parkingSpot.getId() + " on floor " + parkingFloor.getFloorLevel());
    }

}
