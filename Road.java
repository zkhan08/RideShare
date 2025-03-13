import java.util.*;


public class Road {
   private Station[] stations;
   private ArrayList<Car> cars;


   private static final int NUMOFST = 10;


   public Road(){
       stations = new Station[NUMOFST];
       for (int i = 0; i < stations.length; i++){
           stations[i] = new Station(i);
       }
       cars = new ArrayList<Car>();
   }


   public void addPeople(int numPass){
       for(int i = 0; i < numPass; i++){
           int start = (int)(Math.random() * NUMOFST);
           int stop = (int)(Math.random() * NUMOFST);
           stations [start].addPerson(new Person (stop, start));
       }
   }


   public void addCars(int numCars){
       for(int i = 0; i < numCars; i++){
           int start = (int)(Math.random() * NUMOFST);
           int stop = (int)(Math.random() * NUMOFST);
           cars.add(new Car(start, stop));
       }
   }


   public String toString(){
       String s = "Stations: \n";
       for(Station st : stations){
           s += st.toString();
           s +="\n\n";
       }
       s += "Cars: \n";
       for(Car c : cars){
           s += c.toString();
           s+= "\n";
       }
       return s;
   }

   public int completePassangers(){
    int count = 0;
    for (Station s : stations){
        count += s.doneCount();
    }
    return count;
   }

   /**
    * This is the big method that moves all cars, unloads and loads passengers for one unit (of station movement time)
    */
   public void update(){
       // Unload all eligible people from cars to stations
       for (Car c : cars) {
           Person p = c.unload();
           while (p != null) { // Unload until there are no more passengers
               int location = c.getLocation(); // Using existing method to get current location
               stations[location].addPerson(p); // Stations of location add person p
               p = c.unload(); // Try to unload the next person
           }
       }


       // Load all eligible people from stations to cars
       for (Station s : stations) {
           // Load leftbound people
           Person leftPerson = s.nextLeft();
           if (leftPerson != null) {
               int location = s.getStationNumber();
               if (location < cars.size()) {
                   Car car = cars.get(location);
                   if (!car.getDirection() && car.hasRoom()) { // Check direction and room
                       car.addPassenger(leftPerson); // Add passenger if direction matches and there's room
                   }
               }
           }


           // Load rightbound people
           Person rightPerson = s.nextRight();
           if (rightPerson != null) {
               int location = s.getStationNumber();
               if (location < cars.size()) {
                   Car car = cars.get(location);
                   if (car.getDirection() && car.hasRoom()) { // Check direction and room
                       car.addPassenger(rightPerson); // Add passenger if direction matches and there's room
                   }
               }
           }
       }


       // Move all the cars
       for (Car c : cars) {
           c.move();
       }
   }
}
