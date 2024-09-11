import java.util.ArrayList;
import java.util.List;

public class AnimalShelter {
    private List<Dog> dogs = new ArrayList<>();
    private List<Animal> otherAnimals = new ArrayList<>();

    public void addAnimals(Animal animal){
        if(animal instanceof Dog){
            dogs.add((Dog) animal);
        } else {
            otherAnimals.add(animal);
        }
    }
    public void printAnimalSound(){
        System.out.println("Dogs:");
        for (Dog dog : dogs){
            dog.makeSound();
        }

        System.out.println("Other Animals:");
        for (Animal animal : otherAnimals){
            animal.makeSound();
        }
    }
}
