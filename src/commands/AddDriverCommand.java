package commands;

import model.Driver;
import model.Gender;
import model.Location;
import model.Vehicle;
import repository.IDriverRepository;

import java.util.List;

public class AddDriverCommand implements ICommand{
    IDriverRepository driverRepository;

    public AddDriverCommand(IDriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public void execute(List<String> tokens) {
        Character gender = tokens.get(2).charAt(0);
        driverRepository.save(new Driver(tokens.get(1), gender =='F'? Gender.FEMALE : gender == 'M' ? Gender.MALE : Gender.NonBinary, Integer.parseInt(tokens.get(3)),  new Vehicle(tokens.get(4), tokens.get(5)), new Location(Double.parseDouble(tokens.get(6)), Double.parseDouble(tokens.get(7)))));
    }
}
