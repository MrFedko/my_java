package familyTree;

public class Research1 {

    static void Research(People foo, String bar) {
        if (foo != null) {
            System.out.println(bar + foo.name);
            for (People item : foo.GetRelative()) {
                if (item != null) {
                    Research(item, bar + "--");
                }
            }
        }
    }
}
