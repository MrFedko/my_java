package nextFamily;

public class People {
    private String fullName;

    public People(String name) {
        this.fullName = name;
    }

    public String GetFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return this.fullName;
    }

}
