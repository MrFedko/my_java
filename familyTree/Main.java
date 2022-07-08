package familyTree;


public class Main {
    
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

        LucasGray.SetRelative(MaryGray);
        LucasGray.SetRelative(JasonGray);
        LucasGray.SetRelative(PeterGray);
        MaryGray.SetRelative(FredSmith);
        MaryGray.SetRelative(JaneSmith);
        JasonGray.SetRelative(SeanGray);
        JasonGray.SetRelative(JessicaGray);
        JasonGray.SetRelative(HannahGray);
        JessicaGray.SetRelative(JosephWetter);
        JessicaGray.SetRelative(JohnWetter);
        JessicaGray.SetRelative(LauraWetter);

        Research1.Research(LucasGray, "|");

    }
}
