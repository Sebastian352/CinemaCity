import java.util.ArrayList;

public class Person {
    ArrayList<Person> personList = new ArrayList<>();

    String role;
    int money;

    public Person(String role, int money){
        this.role = role;
        this.money = money;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
