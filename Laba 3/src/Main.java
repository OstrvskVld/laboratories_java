import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

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


        List<String> words = Arrays.asList("apple", "banana", "orange", "apple", "banana");
        Set<String> uniqueWords = Uniqueobj.findUnique(words);
        System.out.println("Унікальні слова: " + uniqueWords);

        Map<String, Integer> wordCounts = Uniqueobj.countUnique(words);
        System.out.println("Кількість входжень кожного слова: " + wordCounts);
    }

}