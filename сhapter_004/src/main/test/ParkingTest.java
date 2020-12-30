import org.junit.Test;
import ru.job4j.lsp.parking.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParkingTest {

    @Test
    public void addTrackAndCar() {
        Parking parking = new ParkingImpl(1,1);
        Vehicle car = new Car(1);
        Vehicle track = new Track(1);
        parking.addVehicle(car);
        parking.addVehicle(track);
        assertThat(parking.getVehicles().size(), is(2));
    }

    @Test
    public void addTrackToCarPlace() {
        Parking parking = new ParkingImpl(0,3);
        Vehicle track = new Track(2);
        parking.addVehicle(track);
        assertThat(parking.getVehicles().size(), is(1));
    }
}
