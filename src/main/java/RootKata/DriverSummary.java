package RootKata;

import java.util.UUID;

public class DriverSummary {
    String driverName;
    int totalMilesDriven;
    int totalAvgSpeed;

    public DriverSummary(String driverName, int totalMilesDriven, int totalAvgSpeed) {
        this.driverName = driverName;
        this.totalMilesDriven = totalMilesDriven;
        this.totalAvgSpeed = totalAvgSpeed;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getTotalMilesDriven() {
        return totalMilesDriven;
    }

    public void setTotalMilesDriven(int totalMilesDriven) {
        this.totalMilesDriven = totalMilesDriven;
    }

    public int getTotalAvgSpeed() {
        return totalAvgSpeed;
    }

    public void setTotalAvgSpeed(int totalAvgSpeed) {
        this.totalAvgSpeed = totalAvgSpeed;
    }

    public String toString() {
        if (totalMilesDriven == 0) {
            return this.driverName + ": " + this.totalMilesDriven + " miles";
        } else {
            return this.driverName + ": " + this.totalMilesDriven + " miles @ " + this.totalAvgSpeed + " mph";
        }
    }

    public boolean equals(Object o) {
        DriverSummary driverSummary = (DriverSummary)o;
        return driverSummary.getDriverName().equals(this.driverName)
                && driverSummary.getTotalMilesDriven() == this.totalMilesDriven
                && driverSummary.getTotalAvgSpeed() == this.getTotalAvgSpeed();
    }
}
