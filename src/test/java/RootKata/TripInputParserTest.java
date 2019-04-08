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
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class TripInputParserTest {
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
    public void testTripParserReadsDriverRecordAndAddsItToParsedMap() {
        try {
            HashMap<String, List<Trip>> expectedMap = new HashMap<>();
            expectedMap.put("Dan", emptyList());
            assertThat(TripInputParser.parse(createTempFileWith("Driver Dan")), is(expectedMap));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTripParserReadsTripRecordAndAddesToDriver() {
        try {
            HashMap<String, List<Trip>> expectedMap = new HashMap<>();
            HashMap<String, List<Trip>> actualMap = TripInputParser.parse(createTempFileWith("Driver Dan\nTrip Dan 3:30 4:10 15"));
            expectedMap.put("Dan", Arrays.asList(new Trip(LocalTime.of(3, 30), LocalTime.of(4, 10), 15f)));
            assertThat(actualMap.keySet(), is(expectedMap.keySet()));
            assertThat(actualMap.get("Dan").get(0).getStartTime(), is(expectedMap.get("Dan").get(0).getStartTime()));
            assertThat(actualMap.get("Dan").get(0).getEndTime(), is(expectedMap.get("Dan").get(0).getEndTime()));
            assertThat(actualMap.get("Dan").get(0).getMileDriven(), is(expectedMap.get("Dan").get(0).getMileDriven()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTripParserIgnoresInvalidRecordsAndAlertsUser() {
        try {
            HashMap<String, List<Trip>> expectedMap = new HashMap<>();
            expectedMap.put("Dan", emptyList());
            assertThat(TripInputParser.parse(createTempFileWith("Driver Dan\nThis is invalid record")), is(expectedMap));
            assertThat(outContent.toString(), containsString("File has invalid record! Record(s) been discarded"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File createTempFileWith(String line) throws IOException {
        Path path = Files.createTempFile("sample-file", ".txt");
        File file = path.toFile();
        Files.write(path, line.getBytes(StandardCharsets.UTF_8));
        file.deleteOnExit();
        return file;
    }

}