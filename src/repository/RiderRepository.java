package repository;

import model.Rider;
import model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RiderRepository implements IRiderRepository {
    private final Map<String, Rider> riderMap;

    public RiderRepository() {
        riderMap = new HashMap<>();
    }

    @Override
    public void save(Rider rider) {
        riderMap.put(rider.getName(), rider);
    }

    @Override
    public Optional<Rider> findByName(String name) {
        return Optional.ofNullable(riderMap.get(name));
    }

    @Override
    public boolean riderExists(String name) {
        return riderMap.containsKey(name);
    }
}
