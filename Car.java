import java.util.*;


public class Car {
   //fields
   private int destination;
   private int currentLocation;
   private boolean direction;
   private ArrayList<Person> passengers;


   //constructors
   public Car(int myDestination, int myCurrentLocation){
       destination = myDestination;
       currentLocation = myCurrentLocation;
       direction = destination > currentLocation;
       passengers = new ArrayList<Person>();
   }
  
   //methods
   public String toString(){
       return super.toString() + " Destination: " + destination + " Current location: " +
       currentLocation + " Going right? " + direction + " Passengers: " + passengers;
   }


   public void addPassenger(Person p){
       if(passengers.size() >= 3){
           System.out.println("ERROR: No room!"); //get rid of later
       }else if(p.getDirection() != direction){
           System.out.println("ERROR: Trying to add person in wrong direction!"); //get rid of later
       }else{
           passengers.add(p);
       }
   }


   public void move(){
       if(currentLocation == destination){
           return; //kick out early before trying to move
       }


       if(direction == true){ //could also just use if(direction){}
           currentLocation++;
       }else{
           currentLocation--;
       }
   }


   /**
    * Method foor handing back a personn that is eligible to be dropped off
    * This removes the person from the car as well
    * There may be multiple people eligible for dropoff but this only returns one
    * @return one Person eligible to be dropped off, null if nobody is available
    */
  
   public Person unload(){
       for(int i = 0; i < passengers.size(); i++){
           Person a = passengers.get(i);
           if(a.getDestination() == currentLocation || destination == currentLocation){
               passengers.remove(i);
               return a;
           }
       }
       return null;
   }


   public boolean hasRoom(){
       return passengers.size() < 3;
   }


   public int getLocation(){
       return currentLocation;
   }
}


