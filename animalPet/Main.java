package animalPet;

public class Main {
    public static void main (String[] args){
        People Mikhail = new People("Михаил", 33);

        Cat Barsik = new Cat();
        Dog Wolf = new Dog();
        Fish Dory = new Fish();

        Mikhail.setPet(Barsik);
        Mikhail.setPet(Wolf);
        Mikhail.setPet(Dory);

        Mikhail.callPet();
    }
    
}
