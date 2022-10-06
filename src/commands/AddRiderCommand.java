package commands;

import model.Gender;
import model.Rider;
import repository.IRiderRepository;

import java.util.List;

public class AddRiderCommand implements ICommand{

    IRiderRepository riderRepository;

    public AddRiderCommand(IRiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    @Override
    public void execute(List<String> tokens) {
        Character gender = tokens.get(2).charAt(0);
        riderRepository.save(new Rider(tokens.get(1), gender =='F'? Gender.FEMALE : gender == 'M' ? Gender.MALE : Gender.NonBinary, Integer.parseInt(tokens.get(3))));
    }
}
