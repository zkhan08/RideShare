
public class Tester {
    public static void main(String[] args){

        Road r = new Road();
        r.addPeople(50);
        r.addCars(20);
        
        System.out.println(r);
        r.update();
        System.out.println("********************************");
        for(int i = 0; i < 1000; i++){
            r.update();
        }
        System.out.println(r);
        System.out.println(r.completePassangers() + " people made it to their destination.");
        

    }
 }
 
 
 