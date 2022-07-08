package nextFamily;

public class Node {
    People parent;
    Relationship rel;
    People child;

    public Node(People first, Relationship rel, People second) {
        this.parent = first;
        this.rel = rel;
        this.child = second;
    }

    @Override
    public String toString() {
        return String.format("<%s %s %s>", parent, rel, child);
    }

}
