
public class Tester {
    public static void main(String[] args){

        Road r = new Road();
        r.addPeople(50);
        r.addCars(20);
        
        System.out.println(r);
        r.update();
        System.out.println("********************************");
        System.out.println(r);
        

    }
 }
 
 
 