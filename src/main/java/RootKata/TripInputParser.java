package RootKata;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class TripInputParser {
    public static HashMap<String, List<Trip>> parse(File inputFile) {
        HashMap<String, List<Trip>> parsedTripRecords = new HashMap<>();
        Stream<String> inputFileStream;
        try {
            inputFileStream = Files.lines(Paths.get(inputFile.getPath()));
            inputFileStream.map(line -> line.split(" ")).forEach(tokens -> {
                if (tokens[0].equals("Driver")) {
                    parsedTripRecords.put(tokens[1], new ArrayList<>());
                } else if (tokens[0].equals("Trip")) {
                    addTripToDriver(parsedTripRecords, tokens);
                } else {
                    System.out.println("File has invalid record! Record(s) been discarded");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  parsedTripRecords;
    }

    private static void addTripToDriver(HashMap<String, List<Trip>> parsedTripRecords, String[] tokens) {
        String startTime = tokens[2];
        int startHour = Integer.parseInt(startTime.split(":")[0]);
        int startMinutes = Integer.parseInt(startTime.split(":")[1]);

        String endTime = tokens[3];
        int endHour = Integer.parseInt(endTime.split(":")[0]);
        int endMinutes = Integer.parseInt(endTime.split(":")[1]);

        float milesDriven = Float.valueOf(tokens[4]);

        parsedTripRecords.get(tokens[1])
                .add(new Trip(LocalTime.of(startHour, startMinutes), LocalTime.of(endHour, endMinutes), milesDriven));
    }
}
