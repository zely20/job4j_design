import org.junit.Test;
import ru.job4j.lsp.parking.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParkingTest {

    @Test
    public void addTrackAndCar(){
        Parking parking = new ParkingImpl();
        Vehicle car = new Car();
        Vehicle track = new Track();
        parking.addVehicle(car);
        parking.addVehicle(track);
        assertThat(parking.getVehicles().size(), is(2));
    }
}
