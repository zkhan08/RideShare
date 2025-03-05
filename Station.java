
import java.util.*;
public class Station {
   //fields
   private int stationNumber;
   private ArrayList<Person> waitingLeft;
   private ArrayList<Person> waitingRight;
   private ArrayList<Person> done;


   //constructors
   public Station(int myStationNumber){
       stationNumber = myStationNumber;
       waitingLeft = new ArrayList<Person>();
       waitingRight = new ArrayList<Person>();
       done = new ArrayList<Person>();
   }


   //methods
   public void addPerson(Person p){
       if(p.getDestination() == stationNumber){
           done.add(p);
       } else if (p.getDirection()){
           waitingRight.add(p);
       } else {
           waitingLeft.add(p);
       }
   }


   /**
    * Method for giving back an individual that is going leftboud.
    * @return A single person traveleing to the left-- returns null if nobody is available
    */
   public Person nextLeft(){
       if(waitingLeft.size() > 0){
           return waitingLeft.remove(0);
       } else {
           return null;
       }
   }
  
   /**
    * Method for giving back an individual that is going rightboud.
    * @return A single person traveleing to the right-- returns null if nobody is available
    */
   public Person nextRight(){
       if(waitingRight.size() > 0){
           return waitingRight.remove(0);
       } else {
           return null;
       }
   }


   public int doneCount(){
       return done.size();
   }
  
   public String toString(){
       String s = "Station: " + stationNumber + "\n";
       s+= "Leftbound: " + waitingLeft.toString() + "\n";
       s+= "Rightbound: " + waitingRight.toString() + "\n";
       s+= "Done: " + done.toString() + "\n";
       return s;
   }
}
