package repository;

import model.Driver;
import model.User;

import java.util.Map;
import java.util.Optional;

public interface IDriverRepository {
    public Map<String, Driver> getDriverMap();
    public void save(Driver driver);
    public Optional<Driver> findByName(String name);
}
