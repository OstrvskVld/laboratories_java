import java.util.*;

public class Main {
    public static void main(String[] args) {
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


//        List<String> words = Arrays.asList("apple", "banana", "orange", "apple", "banana");
//        Set<String> uniqueWords = Uniqueobj.findUnique(words);
//        System.out.println("Unique words: " + uniqueWords);
//
//        Map<String, Integer> wordCounts = Uniqueobj.countUnique(words);
//        System.out.println("Number of times each word appears: " + wordCounts);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        Box.deletelist(integerList,3);
        System.out.println(integerList);
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("I`m");
        stringList.add("from");
        stringList.add("Russia");
        stringList.add("Ukraine");
        Box.deletelist(stringList,"Russia");
        System.out.println(stringList);
        List<Character> characterList = new ArrayList<>();
        characterList.add('a');
        characterList.add('b');
        characterList.add('c');
        Box.deletelist(characterList,'b');
        System.out.println(characterList);
    }

}