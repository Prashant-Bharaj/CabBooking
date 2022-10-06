package repository;

import commands.ICommand;
import model.Driver;
import model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DriverRepository implements IDriverRepository {
    private final Map<String, Driver> driverMap;

    public DriverRepository() {
        driverMap = new HashMap<>();
    }

    public Map<String, Driver> getDriverMap() {
        return driverMap;
    }

    @Override
    public void save(Driver driver) {
        driverMap.put(driver.getName(), driver);
    }

    @Override
    public Optional<Driver> findByName(String name) {
        return Optional.ofNullable(driverMap.get(name));
    }
}
