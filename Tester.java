
public class Tester {
    public static void main(String[] args){

        Road r = new Road();
        int people = 50;
        int cars = 20;
        r.addPeople(people);
        r.addCars(cars);
        
        System.out.println(r);
        while(r.carsLeft()==true){
            r.update();
        }
        System.out.println(r);
        System.out.println(r.completePassangers() + " people made it to their destination.");
        System.out.println((double) r.completePassangers()/people*100 + "% people made it to their destination.");
        

    }
 }
 
 
 