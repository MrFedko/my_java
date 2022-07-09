package animalPet;

import java.util.ArrayList;

public class People {
    private ArrayList <Animal> pets = new ArrayList<>();
    private int age;
    private String name;

    public People (String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Name - %s, age - %d", name, age);
    }

    public void setPet(Animal any){
        pets.add(any);
    }

    public void callPet(){
        for (Animal i : pets) i.voice();
    }
}
