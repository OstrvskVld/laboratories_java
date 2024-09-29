import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {

//    public static void  addToList (List<? super Integer> list){
//        for (Object o : list){
//            System.out.println(o);
//        }
//    }
//    public static double getArea(List<? extends Shape> shapes){
//        double area = 0;
//        for (Shape shape : shapes){
//            area += shape.getArea();
//        }
//        return area;
//    }

//    public static void add(int a, int b){
//        int result = a + b;
//        System.out.println(result);
//    }
//    public static void add(double a, double b){
//        double result = a + b;
//        System.out.println(result);
//    }
    public static void main(String[] args) {
       Dog dog = new Dog();
       Cat cat = new Cat();
       Labrador labrador = new Labrador();
       AnimalShelter shelter = new AnimalShelter();
       shelter.addAnimals(dog);
       shelter.addAnimals(cat);
       shelter.addAnimals(cat);
       shelter.addAnimals(dog);
       shelter.addAnimals(labrador);
       shelter.AnimalSound();



//        List<? super Integer> integers = new ArrayList<>();
//        integers.add(1);
//        integers.add(2);
//        integers.add(3);
//        integers.add(4);
//        integers.add(5);
//        integers.add(6);
//        integers.add(7);
//        integers.add(8);
//        integers.add(9);
//        integers.add(10);
//        System.out.println(integers);
//        List<? super Number> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        System.out.println(numbers);
//        List<Shape> shapes = new ArrayList<>();
//        shapes.add(new Circle(5));
//        shapes.add(new Rectangle(4, 6));
//        shapes.add(new Circle(2));
//        double area = getArea(shapes);
//        System.out.println("Total area: " + area);


//        List<Animal> animals = new ArrayList<>();
//        animals.add(new Animal(1));
//        animals.add(new Animal(2));
//        test(animals);
//
//        List<Dog> dogs = new ArrayList<>();
//        dogs.add(new Dog());
//        dogs.add(new Dog());
//        test(dogs);


//        Students students = new Students();
//        students.addStudent(new Student(1,"John","123456789"));
//        students.addStudent(new Student(2,"David","987654321"));
//        students.printAllStudents();
//        Student foundstudent = students.findStudent(1);
//        if(foundstudent != null){
//            System.out.println("Student found: " + foundstudent);
//        }
//        students.removeStudent(1);
//        students.printAllStudents();


//        add(1, 2);
//        add(10.5, 20.2);


//        Hashtable<String, Integer> hashtable = new Hashtable<>("Hello", 54);
//        System.out.println(hashtable);


//        GenericMethod genericMethod = new GenericMethod();
//        genericMethod.showitem("Hello");
//        genericMethod.showitem(54);
//        genericMethod.showitem(12.5);
//        genericMethod.showitem('a');

//        Example<Car,String> example = new Example<>();
//        String string = "Hello";
//        Car car = new Car("Toyota", 2022);
//        Car car2 = new Car("Honda", 2021);
//        example.addToString(car, string);
//        example.addToString(car2, string);
//        System.out.println(example.getString());


    }

//    private static void test(List<? extends Animal> list){
//        for (Animal animal : list){
//            System.out.println(animal);
//            animal.eat();
//        }
//
//    }

}