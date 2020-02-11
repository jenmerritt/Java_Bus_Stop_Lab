import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusTest {

    private Bus bus;
    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    private BusStop busStop;

    @Before
    public void before(){
        bus = new Bus("Balerno", 3);
        person1 = new Person();
        person2 = new Person();
        person3 = new Person();
        person4 = new Person();
        busStop = new BusStop("Balerno");
        busStop.addPersonToQueue(person1);
        busStop.addPersonToQueue(person2);
        busStop.addPersonToQueue(person3);
        busStop.addPersonToQueue(person4);
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

    @Test
    public void can_pickup_person_from_bus_stop(){
        bus.pickUpPassenger(busStop, person1);
        assertEquals(1, bus.getPassengerCount());
        assertEquals(3, busStop.getQueueLength());
    }

    @Test
    public void cannot_pickup_person_if_over_capacity(){
        bus.pickUpPassenger(busStop, person1);
        bus.pickUpPassenger(busStop, person2);
        bus.pickUpPassenger(busStop, person3);
        bus.pickUpPassenger(busStop, person4);
        assertEquals(3, bus.getPassengerCount());
        assertEquals(1, busStop.getQueueLength());
    }

}