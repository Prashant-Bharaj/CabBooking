package driver;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Integration Testing")
class MainTest {
    private final PrintStream standardOut = System.out;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Invalid fileName")
    void invalidFileName() {
        //Arrange
        Main.main(new String[]{"xyz"});
        //expected
        Assertions.assertEquals("", outputStreamCaptor.toString().trim());
    }
    @Test
    @DisplayName("Integration Test #1")
    void runTest1(){
        //Arrange
        List<String> arguments = new ArrayList<>(List.of("sample_input/input1.txt"));

        String expectedOutput = "Successful";

        //Act
        Main.run(arguments);
        //Assert
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Integration Test #2")
    void runTest2(){
        //Arrange
        List<String> arguments = new ArrayList<>(List.of("sample_input/input1.txt"));

        String expectedOutput = "Successful";

        //Act
        Main.run(arguments);
        //Assert
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Integration Test #3")
    void runTest3(){
        //Arrange
        List<String> arguments = new ArrayList<>(List.of("sample_input/input1.txt"));

        String expectedOutput = "Successful";

        //Act
        Main.run(arguments);
        //Assert
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public  void tearDown() {
        System.setOut(standardOut);
    }

}