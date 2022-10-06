package commands;

import service.RideService;

import java.util.List;

public class ChooseRideCommand implements ICommand{
    RideService rideService;

    public ChooseRideCommand(RideService rideService) {
        this.rideService = rideService;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            rideService.chooseRide(tokens.get(1), tokens.get(2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
