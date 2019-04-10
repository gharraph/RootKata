package RootKata;

import java.time.Duration;
import java.time.LocalTime;

public class Trip {
    private LocalTime startTime;
    private LocalTime endTime;
    private float milesDriven;

    public Trip(LocalTime startTime, LocalTime endTime, float milesDriven) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.milesDriven = milesDriven;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public float getMilesDriven() {
        return milesDriven;
    }

    public int getTripSpeed () {
        float tripDuration = (float)Duration.between(startTime, endTime).toMinutes()/60f;
        return Math.round(milesDriven/tripDuration);
    }
}
