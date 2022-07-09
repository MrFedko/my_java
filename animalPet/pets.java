package animalPet;

public class pets {

}

class Cat extends Animal {

    public Cat() {
        this.type = animalType.cat;
    }

    @Override
    public void voice() {
        System.out.println("meow meow");
    }
}

class Dog extends Animal {

    public Dog() {
        this.type = animalType.dog;
    }

    @Override
    public void voice() {
        System.out.println("gav gav");
    }

}

class Fish extends Animal {
    public Fish() {
        this.type = animalType.fish;
    }

    @Override
    public void voice() {
        System.out.println("oooooo");
    }
}
