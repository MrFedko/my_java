package nextFamily;

import java.util.ArrayList;

public class MainPoint {
    
    public static void main(String[] args) {
        People LucasGray = new People("Lucas Gray");
        People MaryGray = new People("Mary Gray");
        People JasonGray = new People("Jason Gray");
        People PeterGray = new People("Peter Gray");
        People FredSmith = new People("Fred Smith");
        People JaneSmith = new People("Jane Smith");
        People SeanGray = new People("Sean Gray");
        People JessicaGray = new People("Jessica Gray");
        People HannahGray = new People("Hannah Gray");
        People JosephWetter = new People("Joseph Wetter");
        People JohnWetter = new People("John Wetter");
        People LauraWetter = new People("Laura Wetter");

        Tree newTree = new Tree();
        newTree.append(LucasGray, MaryGray);
        newTree.append(LucasGray, JasonGray);
        newTree.append(LucasGray, PeterGray);
        newTree.append(MaryGray, FredSmith);
        newTree.append(MaryGray, JaneSmith);
        newTree.append(JasonGray, SeanGray);
        newTree.append(JasonGray, JessicaGray);
        newTree.append(JasonGray, HannahGray);
        newTree.append(JessicaGray, JosephWetter);
        newTree.append(JessicaGray, JohnWetter);
        newTree.append(JessicaGray, LauraWetter);


        System.out.println(new Research(newTree).spend(LucasGray, Relationship.parent).toString());
        new Research(newTree).fullTree(LucasGray, "|");
    }

}
