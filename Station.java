import java.util.ArrayList;

class Station {
    private ArrayList<Person> waitingPeople;

    public Station(int loc) {
        waitingPeople = new ArrayList<>();
    }
    
    public void addPerson(Person p) {
        waitingPeople.add(p);
    }
    
    public boolean hasPeopleGoingInDirection(boolean direction) {
        for (Person p : waitingPeople) {
            if (p.getDirection() == direction) {
                return true;
            }
        }
        return false;
    }
    
    public Person getPersonGoingInDirection(boolean direction) {
        for (int i = 0; i < waitingPeople.size(); i++) {
            if (waitingPeople.get(i).getDirection() == direction) {
                return waitingPeople.remove(i);
            }
        }
        return null;
    }
}
