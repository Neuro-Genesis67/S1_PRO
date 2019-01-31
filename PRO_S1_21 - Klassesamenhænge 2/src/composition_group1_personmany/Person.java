package composition_group1_personmany;

public class Person {
    private String name;
    // composition: --> 1 Group
    private Group group;

    Person(String name) { // package visibility
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    // -------------------------------------------------------------------------

    public Group getGroup() {
        return group;
    }

    void setGroup(Group group) { // package visibility
        this.group = group;
    }
}
