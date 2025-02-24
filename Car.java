import java.util.*;

public class Car {
    //fields
    private int destination;
    private int currentLocation;
    private boolean direction;
    private ArrayList<Person> passangers;

    public Car(int myDestination, int start){
        destination = myDestination;
        currentLocation = start;
        direction = destination > currentLocation;
        passangers = new ArrayList<Person>();
    }

    public String toString(){
        return super.toString() + "Destination: " + destination + "Current location: " + currentLocation + "Going Right: " + direction + "Passangers: " + passangers;

    }

    public void addPassanger(Person p){
        if(passangers.size() >= 3){
            System.out.println("ERROR: No room!");

        }else{
    
        
        passangers.add(p);

    }
    
}

public boolean hasRoom(){
    return passangers.size() <3 ;
}
}

