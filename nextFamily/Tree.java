package nextFamily;

import java.util.ArrayList;

public class Tree {

    private ArrayList<Node> tree = new ArrayList<>();

    public ArrayList<Node> getTree() {
        return tree;
    }

    public void append(People parent, People child) {
        tree.add(new Node(parent, Relationship.parent, child));
        tree.add(new Node(child, Relationship.child, parent));
    }

}
