package RootKata;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class DriverSummaryTest {

    @Test
    public void testDriverSummaryToStringReturnsDriverNameAndMilesDrivenOnlyWhenMilesDrivenIsZero() {
        List<DriverSummary> subject =Arrays.asList(new DriverSummary("Sherief", 0, 0));
        assertThat(subject.toString(), equalTo("[Sherief: 0 miles]"));
    }

    @Test
    public void testDriverSummaryToStringReturnsDriverAllSummaryInfoWhenMilesDrivenIsNOTZero() {
        List<DriverSummary> subject =Arrays.asList(new DriverSummary("Sherief", 20, 30));
        assertThat(subject.toString(), equalTo("[Sherief: 20 miles @ 30 mph]"));
    }

}