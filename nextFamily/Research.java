package nextFamily;

import java.util.ArrayList;

public class Research {

    ArrayList<Node> tree;

    public Research(Tree geoTree) {
        tree = geoTree.getTree();
    }

    public ArrayList<People> spend(People p, Relationship re) {
        var result = new ArrayList<People>();

        for (Node t : tree) {
            if (t.parent.GetFullName() == p.GetFullName() && t.rel == re) {
                result.add(t.child);
            }
        }
        return result;
    }

    public void fullTree (People p, String foo) {
        ArrayList<People> children = new ArrayList<People>();
        children = spend(p, Relationship.parent);
        if (children != null) {
            for (People child : children){
                System.out.println(foo + "--" + child.GetFullName());
                fullTree(child, foo + "--");
            }
        }
    }
}
