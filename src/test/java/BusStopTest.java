import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusStopTest {

    private BusStop busStop;
    private Bus bus;
    private Person person1;
    private Person person2;

    @Before
    public void before(){
        busStop = new BusStop("Balerno");
        bus = new Bus("Balerno", 3);
        person1 = new Person();
        person2 = new Person();
    }

    @Test
    public void bus_stop_queue_starts_empty(){
        assertEquals(0, busStop.getQueueLength());
    }

    @Test
    public void can_add_person_to_bus_stop_queue(){
        busStop.addPersonToQueue(person1);
        assertEquals(1, busStop.getQueueLength());
    }

    @Test
    public void can_remove_person_from_queue(){
        busStop.addPersonToQueue(person1);
        busStop.addPersonToQueue(person2);
        assertEquals(person2, busStop.removePerson(person2));
    }
}
