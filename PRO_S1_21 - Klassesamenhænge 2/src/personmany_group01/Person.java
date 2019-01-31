package personmany_group01;

public class Person {
    private String name;
    // association: --> 0..1 Group
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

    public void setGroup(Group group) {
        if (group != null) {
            group.addPerson(this);
        } else {
            this.group.removePerson(this);
        }
        this.group = group;
    }

//    // Alternative code for setGroup():
//    public void setGroup(Group group) {
//        if (group != null) {
//            group.addPerson(this);
//            this.group = group;
//        } else {
//            this.group.removePerson(this);
//            this.group = null;
//        }
//    }
}
