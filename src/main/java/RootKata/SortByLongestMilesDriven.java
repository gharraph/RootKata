package RootKata;

import java.util.Comparator;

public class SortByLongestMilesDriven implements Comparator<DriverSummary> {
    @Override
    public int compare(DriverSummary a, DriverSummary b) {
        return b.totalMilesDriven - a.totalMilesDriven;
    }
}
