package aggregation_group01_personmany;

public class Person {
    private String name;
    // aggregation: --> 0..1 Group
    private Group group;

    public Person(String name) {
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
