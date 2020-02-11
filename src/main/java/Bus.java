import java.util.ArrayList;

public class Bus {
    private String destination;
    private Integer capacity;
    private ArrayList<Person> passengers;

    public Bus(String destination, Integer capacity) {
        this.destination = destination;
        this.capacity = capacity;
        this.passengers = new ArrayList<Person>();
    }


    public int getPassengerCount() {
        return this.passengers.size();
    }

    public void addPassenger(Person person) {
        if (this.getPassengerCount() < this.capacity) {
            this.passengers.add(person);
        }
    }

    public Person removePassenger(Person person) {
        int index = this.passengers.indexOf(person);
        return this.passengers.remove(index);
    }
}
