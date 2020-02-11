import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusTest {

    private Bus bus;
    private Person person1;
    private Person person2;

    @Before
    public void before(){
        bus = new Bus("Balerno", 3);
        person1 = new Person();
        person2 = new Person();
    }

    @Test
    public void number_of_passengers_starts_at_zero(){
        assertEquals(0, bus.getPassengerCount());
    }

    @Test
    public void can_add_passenger_to_bus(){
        bus.addPassenger(person1);
        assertEquals(1, bus.getPassengerCount());
    }

    @Test
    public void cannot_add_passenger_to_bus_if_at_capacity(){
        bus.addPassenger(person1);
        bus.addPassenger(person2);
        bus.addPassenger(person1);
        bus.addPassenger(person2);
        assertEquals(3, bus.getPassengerCount());
    }

    @Test
    public void can_remove_passenger(){
        bus.addPassenger(person1);
        bus.addPassenger(person2);
        assertEquals(person1, bus.removePassenger(person1));
    }
}
