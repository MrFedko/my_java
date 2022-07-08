package familyTree;

import java.util.ArrayList;

public class People {
    public String name;
    public People parent;
    private ArrayList<People> family = new ArrayList<>();

    public People(String name) {
        this.name = name;
    }

    public void SetRelative(People people) {
        family.add(people);
        people.parent = this;
    }

    public ArrayList<People> GetRelative() {
        return family;
    }
}
