package service;

import model.SpotAssignmentStrategyType;

public class SpotAssignmentStrategyFactory {

    public SpotAssignmentStrategy getStrategyService(SpotAssignmentStrategyType spotAssignmentStrategyType) {
        switch (spotAssignmentStrategyType) {
            case NEAREST:
                return new NearestSpotAssignmentStrategy();

            case RANDOM:
            default:
                return new RandomSpotAssignmentService();
        }
    }

}
