package animalPet;

abstract class Animal {
    Integer health;
    Integer satiety;
    animalType type;

    public Animal(){
        health = 100;
        satiety = 100;
    }

    public void voice (){};
    public void GetFood(String food){
        satiety = ((satiety + food.length()) < 100) ? satiety + food.length() : 100;
    }


}

