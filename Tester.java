
public class Tester {
    public static void main(String[] args){
        Person a = new Person(5, 7);
        Person b = new Person(2, 0);
        Person c = new Person(10, 24);
 
 
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
       
        Car d = new Car(5, 9);
        System.out.println(d);
        d.addPassenger(a);
        System.out.println(d);
 
 
        System.out.println(d.unload());
 
 
        Road r = new Road();
        System.out.println(r.toString());
    }
 }
 
 
 