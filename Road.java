

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
           stations [start].addPerson(new Person (start, stop));
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


   /**
    * This is the big method that moves all cars, unloads and loads passengers for one unit (of station movement time)
    */


   public void update(){
       //unload all eligible people from cars to stations
       for (Car c : cars){
           //this gives an eligible person to remove or null if nobody is avaiable
           while(true){
           Person p = c.unload();
           if( p != null){
               int location = c.getLocation();
               stations[location].addPerson(p); //stations of location add person p
               //deal when if its just that car it at the end
           } else {
               break;
           }
       }
       }


       for(Station s: stations){
           while(true){
              
           }
       }
       //load all eligible people from stations to cars
       //going to be similar but now looping through stations and putting them in cars




   //move all the cars
       for(Car c : cars){
           c.move();
       }
   }
}
 
