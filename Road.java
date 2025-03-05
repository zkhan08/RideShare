import java.util.*;

public class Road {
    private ArrayList<Station> stations;
    private ArrayList<Car> cars;
    private ArrayList<Person> people;
    
    public Road(int numStations, int numCars, int numPeople) {
        stations = new ArrayList<>();
        cars = new ArrayList<>();
        people = new ArrayList<>();
        
        for (int i = 0; i < numStations; i++) {
            stations.add(new Station(i));
        }
        
        Random rand = new Random();
        
        for (int i = 0; i < numPeople; i++) {
            int start = rand.nextInt(numStations);
            int destination;
            do {
                destination = rand.nextInt(numStations);
            } while (destination == start);
            
            Person p = new Person(destination, start);
            people.add(p);
            stations.get(start).addPerson(p);
        }
        
        for (int i = 0; i < numCars; i++) {
            int start = rand.nextInt(numStations);
            int destination;
            do {
                destination = rand.nextInt(numStations);
            } while (destination == start);
            
            Car c = new Car(destination, start);
            cars.add(c);
        }
    }
    
    public void simulate(int steps) {
        for (int i = 0; i < steps; i++) {
            for (Car c : cars) {
                Station currentStation = stations.get(c.currentLocation);
                
                while (c.hasRoom() && currentStation.hasPeopleGoingInDirection(c.direction)) {
                    Person p = currentStation.getPersonGoingInDirection(c.direction);
                    c.addPassanger(p);
                }
                
                c.move();
                
                Person droppedOff;
                while ((droppedOff = c.unload()) != null) {
                    System.out.println("Dropped off " + droppedOff);
                }
            }
        }
    }
}
