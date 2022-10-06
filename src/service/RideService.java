package service;

import model.Driver;
import model.Location;
import model.Rider;
import repository.IDriverRepository;
import repository.IRiderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RideService {
    IDriverRepository driverRepository;
    IRiderRepository riderRepository;

    List<Driver> driverList;

    public RideService(IDriverRepository driverRepository, IRiderRepository riderRepository) {
        this.driverRepository = driverRepository;
        this.riderRepository = riderRepository;
    }

    public List<Driver> findAvailableDrivers(String name, Location source, Location destination) throws Exception {
        Optional<Rider> rider = riderRepository.findByName(name);
        if(rider.isEmpty()) throw new Exception("rider not exists in database");
        riderRepository.save(new Rider(rider.get(), source, destination));
        driverList = new ArrayList<>();
        for(Driver driver : driverRepository.getDriverMap().values()){
            if(driver.getAvailability() && distance(source, destination) <= 5){
                driverList.add(driver);
            }
        }
        return driverList;
    }

    //TODO: cache the search results
    public String chooseRide(String riderName, String driverName) throws Exception {
        Optional<Rider> rider = riderRepository.findByName(riderName);
        if(rider.isEmpty()) throw new Exception("rider not exists in database");
        Location source = rider.get().getSource();
        Location destination = rider.get().getDestination();
        if(source==null || destination == null) throw new Exception("Please find available drivers first");

        driverList = new ArrayList<>();
        for(Driver driver : driverRepository.getDriverMap().values()){
            if(driver.getAvailability() && distance(rider.get().getSource(), rider.get().getDestination()) <= 5){
                driverList.add(driver);
            }
        }
        // it is essential before choosingRide, rider search for available rides
        if(driverList.isEmpty()) throw new Exception("Not any driver available");

        for(Driver driver : driverList){
            if(driver.getName().equals(driverName)){
                if(!driver.getAvailability()){
                    throw new Exception("Someone else booked the driver");
                } else {
                    driverRepository.save(new Driver(driver, false));
                    return "Successful";
                }
            }
        }
        return "Failed";
    }

    public double distance(Location source, Location destination){
        // to calculate distance [[https://www.movable-type.co.uk/scripts/latlong.html]]
        // Assumption surface is xy-plane
        return Math.sqrt(Math.pow(source.getLatitude() - destination.getLatitude(), 2) + Math.pow(source.getLongitude() - destination.getLongitude(), 2));
    }
}
