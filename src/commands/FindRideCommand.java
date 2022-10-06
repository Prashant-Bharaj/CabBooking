package commands;

import model.Location;
import service.RideService;

import java.util.List;

public class FindRideCommand implements ICommand{
    RideService rideService;

    public FindRideCommand(RideService rideService) {
        this.rideService = rideService;
    }

    @Override
    public void execute(List<String> tokens) {
        Location source = new Location(Double.parseDouble(tokens.get(2)), Double.parseDouble(tokens.get(3)));
        Location destination = new Location(Double.parseDouble(tokens.get(4)), Double.parseDouble(tokens.get(5)));
        try{
            rideService.findAvailableDrivers(tokens.get(1), source, destination);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
