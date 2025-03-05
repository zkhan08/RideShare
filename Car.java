import java.util.*;

public class Car {
    //fields
    private int destination;
    int currentLocation;
    boolean direction; //true for right, false for left
    private ArrayList<Person> passengers;

    public Car(int myDestination, int start){
        destination = myDestination;
        currentLocation = start;
        direction = destination > currentLocation;
        passengers = new ArrayList<Person>();
    }

    public String toString(){
        return super.toString() + "Destination: " + destination + " Current location: " + currentLocation + " Going Right: " + direction + " Passangers: " + passengers;

    }

    public void addPassanger(Person p){
        if(passengers.size() >= 3){
            System.out.println("ERROR: No room!");

        }else if(p.getDirection() != direction){
            System.out.println("ERROR: Trying to add person in wrong direction!");

        }else{
    
        
        passengers.add(p);

    }
    
}

public void move(){
    if(currentLocation == destination){
        return; //kick out early before trying to move
    }
    if(direction == true){
        currentLocation++;
    }else{
        currentLocation--;
    }
}


/**
 * Method for handing back a person that is eligible to be dropped off
 * This removed the person from the car as well
 * There may be multiple people eligible for dropoff but only returns one 
 * @return one Person eligible to be dropped off, null if nobody is availible
 */
public Person unload(){
    for(int i = 0; i < passengers.size(); i++){
        Person a = passengers.get(i);
        if(a.getDestination() == currentLocation){
            return passengers.remove(i);
            
        }
    }
    return null;
}

public boolean hasRoom(){
    return passengers.size() <3 ;
}

public void dropOffPassengers() {
   
    throw new UnsupportedOperationException("Unimplemented method 'dropOffPassengers'");
}

public void pickUpPassenger(Person p) {
   
    throw new UnsupportedOperationException("Unimplemented method 'pickUpPassenger'");
}
}

