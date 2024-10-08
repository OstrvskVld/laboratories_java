import java.util.*;

public class Main {

    //4 task
    public static class Find {
        public <T extends Comparable<T>> T findMax(T num1, T num2) {
            if (num1.compareTo(num2) > 0) {
                return num1;
            } else {
                return num2;
            }
        }
    }


    //6 task
//    public static double getArea(List<? extends Shape> shapes){
//        double area = 0;
//        for (Shape shape : shapes){
//            area += shape.getArea();
//        }
//        return area;
//    }


//7 task
//    public static void  addToList (List<? super Integer> list){
//        for (Object o : list){
//            System.out.println(o);
//        }
//    }


    public static void main(String[] args) {
//1 task
//        Students students = new Students();
//        students.addStudent(new Student(1,"John","123456789"));
//        students.addStudent(new Student(2,"David","987654321"));
//        students.printAllStudents();
//        Student foundstudent = students.findStudent(3);
//        if(foundstudent != null){
//            System.out.println("Student found: " + foundstudent);
//        }
//        students.removeStudent(1);
//        students.printAllStudents();


//2 task
//        List<String> words = Arrays.asList("apple", "banana", "orange", "apple", "banana");
//        Set<String> uniqueWords = Uniqueobj.findUnique(words);
//        System.out.println("Unique words: " + uniqueWords);
//
//        Map<String, Integer> wordCounts = Uniqueobj.countUnique(words);
//        System.out.println("Number of times each word appears: " + wordCounts);


        //3 task
//        List<Integer> integerList = new ArrayList<>();
//        integerList.add(1);
//        integerList.add(2);
//        integerList.add(3);
//        integerList.add(4);
//        integerList.add(5);
//        Box.deletelist(integerList,3);
//        System.out.println(integerList);
//        List<String> stringList = new ArrayList<>();
//        stringList.add("Hello");
//        stringList.add("I`m");
//        stringList.add("from");
//        stringList.add("Russia");
//        stringList.add("Ukraine");
//        Box.deletelist(stringList,"Russia");
//        System.out.println(stringList);
//        List<Character> characterList = new ArrayList<>();
//        characterList.add('a');
//        characterList.add('b');
//        characterList.add('c');
//        Box.deletelist(characterList,'b');
//        System.out.println(characterList);


        //4 task
//        Find find = new Find();
//        System.out.println(find.findMax(5, 10));
//        System.out.println(find.findMax("apple", "banana"));
//        System.out.println(find.findMax(3.14, 2.71));
//        System.out.println(find.findMax('A', 'Z'));


        //5 task
//        Pair<Integer,String> pair1 = new Pair<>(10,"Ten");
//        System.out.println("Pair1: " +pair1);
//        Pair<String, List<Integer>> pair2 = new Pair<>("Hello", Arrays.asList(1,2,3));
//        System.out.println("Pair2: " +pair2);
//        System.out.println("Pair1 equals Pair2: " +pair1.equals(pair2));


//6 task
//        List<Shape> shapes = new ArrayList<>();
//        shapes.add(new Circle(5));
//        shapes.add(new Rectangle(4, 6));
//        shapes.add(new Circle(2));
//        double area = getArea(shapes);
//        System.out.println("Total area: " + area);


        //7 task
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
//        addToList(integers);
//        List<? super Number> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        addToList(numbers);


//8 task
        Dog dog = new Dog();
        Cat cat = new Cat();
        Labrador labrador = new Labrador();
        AnimalShelter animalShelter = new AnimalShelter();
        animalShelter.addAnimals(dog);
        animalShelter.addAnimals(cat);
        animalShelter.addAnimals(labrador);
        animalShelter.printAnimalSound();
    }
}

