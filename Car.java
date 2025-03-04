import java.util.*;

public class Car {
    //fields
    private int destination;
    private int currentLocation;
    private boolean direction; //true for right, false for left
    private ArrayList<Person> passangers;

    public Car(int myDestination, int start){
        destination = myDestination;
        currentLocation = start;
        direction = destination > currentLocation;
        passangers = new ArrayList<Person>();
    }

    public String toString(){
        return super.toString() + "Destination: " + destination + " Current location: " + currentLocation + " Going Right: " + direction + " Passangers: " + passangers;

    }

    public void addPassanger(Person p){
        if(passangers.size() >= 3){
            System.out.println("ERROR: No room!");

        }else if(p.getDirection() != direction){
            System.out.println("ERROR: Trying to add person in wrong direction!");

        }else{
    
        
        passangers.add(p);

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
    for(int i = 0; i < passangers.size(); i++){
        Person a = passangers.get(i);
        if(a.getDestination() == currentLocation){
            return passangers.remove(i);
            
        }
    }
    return null;
}

public boolean hasRoom(){
    return passangers.size() <3 ;
}
}

