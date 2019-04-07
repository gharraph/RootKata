package RootKata;

import java.time.LocalTime;

public class Trip {
    private LocalTime startTime;
    private LocalTime endTime;
    private float mileDriven;

    public Trip(LocalTime startTime, LocalTime endTime, float mileDriven) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.mileDriven = mileDriven;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public float getMileDriven() {
        return mileDriven;
    }

    public void setMileDriven(float mileDriven) {
        this.mileDriven = mileDriven;
    }
}
