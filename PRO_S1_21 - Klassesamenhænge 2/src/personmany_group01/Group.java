package personmany_group01;

import java.util.ArrayList;

public class Group {
    private String name;
    // association: --> 0..* Person
    private ArrayList<Person> persons = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    // -------------------------------------------------------------------------

    public ArrayList<Person> getPersons() {
        return new ArrayList<>(persons);
    }

    void addPerson(Person person) { // package visibility
        persons.add(person);
    }

    void removePerson(Person person) { // package visibility
        persons.remove(person);
    }
}
