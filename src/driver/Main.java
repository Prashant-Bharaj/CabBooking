package driver;

import appConfig.ApplicationConfig;
import commands.CommandInvoker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// latitude , longitude
public class Main {
    public static void main(String[] args) {
        List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
        run(commandLineArgs);
    }

    public static void run(List<String> commandLineArgs) {
        // logic to run the complete program.
        try {
            ApplicationConfig applicationConfig = new ApplicationConfig();
            CommandInvoker commandInvoker = applicationConfig.getCommandInvoker();
            if(commandLineArgs.size() == 0) throw new RuntimeException("FILE_NAME_NOT_PROVIDED");
            String inputFile = commandLineArgs.get(0);

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();
            while (line != null) {
                List<String> tokens = Arrays.asList(line.split(" "));
                commandInvoker.executeCommand(tokens.get(0),tokens);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (RuntimeException | IOException e) {
            e.getMessage();
        }
    }
}