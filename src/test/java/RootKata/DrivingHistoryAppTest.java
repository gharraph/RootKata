/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package RootKata;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class DrivingHistoryAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testDrivingHistoryAppRequiresNonEmptyArgList() {
        DrivingHistoryApp.main(new String[0]);
        assertThat(outContent.toString(), containsString("Please pass <input file path> as an argument .."));
    }

    @Test
    public void testDrivingHistoryAppRequiresValidFilePath() {
        try {
            DrivingHistoryApp.parseFile(createTempFileWith("any text"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(outContent.toString(), containsString("Driving History for input drivers:"));
    }

    @Test
    public void testDrivingHistoryAppAsksForValidPathWhenFilePathIsNotValid() {
        String[] filePath = {"~/pathToFileNonValidPath"};
        DrivingHistoryApp.main(filePath);
        assertThat(outContent.toString(), containsString("The file path you entered is not valid, please enter valid path!"));
    }

    private static File createTempFileWith(String line) throws IOException {
        Path path = Files.createTempFile("sample-file", ".txt");
        File file = path.toFile();
        Files.write(path, line.getBytes(StandardCharsets.UTF_8));
        file.deleteOnExit();
        return file;
    }
}
