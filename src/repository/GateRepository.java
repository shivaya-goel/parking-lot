package repository;

import model.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {

    private Map<Long, Gate> gateIdMap;

    public GateRepository() {
        this.gateIdMap = new HashMap<>();
    }

    public Optional<Gate> findById(Long id) {
        if (gateIdMap.containsKey(id)) {
            return Optional.of(gateIdMap.get(id));
        }
        return Optional.empty();
    }

}
