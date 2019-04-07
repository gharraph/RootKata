package RootKata;

import java.io.File;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TripInputParser {
    public static HashMap<String, List<Trip>> parse(File inputFile) {
        HashMap<String, List<Trip>> parsedTripRecoreds = new HashMap<>();
        parsedTripRecoreds.put("dan", Arrays.asList(new Trip(LocalTime.now(), LocalTime.of(5, 30), 14.5f)));
        return  parsedTripRecoreds;
    }
}
