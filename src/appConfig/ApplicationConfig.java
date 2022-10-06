package appConfig;

import commands.*;
import repository.DriverRepository;
import repository.IDriverRepository;
import repository.IRiderRepository;
import repository.RiderRepository;
import service.RideService;

public class ApplicationConfig {
    private final IRiderRepository userRepository= new RiderRepository();
    private final IDriverRepository driverRepository = new DriverRepository();
    private final RideService rideService = new RideService(driverRepository, userRepository);
    private final AddRiderCommand addRiderCommand = new AddRiderCommand(userRepository);
    private final AddDriverCommand addDriverCommand = new AddDriverCommand(driverRepository);
    private final FindRideCommand findRideCommand = new FindRideCommand(rideService);
    private final ChooseRideCommand chooseRideCommand = new ChooseRideCommand(rideService);
    private final CommandInvoker commandInvoker = new CommandInvoker();
    public CommandInvoker getCommandInvoker() {
        commandInvoker.register(Commands.AddRider.name(), addRiderCommand);
        commandInvoker.register(Commands.AddDriver.name(), addDriverCommand);
        commandInvoker.register(Commands.FindRide.name(), findRideCommand);
        commandInvoker.register(Commands.ChooseRide.name(), chooseRideCommand);
        return commandInvoker;
    }
}
