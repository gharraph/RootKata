package RootKata;

import org.junit.Test;

import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class TripTest {

    @Test
    public void testTripReturnsSpeed() {
        Trip trip1 = new Trip(LocalTime.of(10,5), LocalTime.of(10,35), 17.3f);
        Trip trip2 = new Trip(LocalTime.of(10,5), LocalTime.of(10,25), 21.8f);
        assertThat(trip1.getTripSpeed(), equalTo(35));
        assertThat(trip2.getTripSpeed(), equalTo(65));
    }

}