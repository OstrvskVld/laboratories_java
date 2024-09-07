import java.util.LinkedHashMap;
import java.util.Map;

public class Student {
    private int studentId;
    private String name;
    private String number;

    public Student(int studentId, String name, String number) {
        this.studentId = studentId;
        this.name = name;
        this.number = number;
    }

    public int getStudentId(){
        return studentId;
    }

    public String getName(){
        return name;
    }

    public String getNumber(){
        return number;
    }

    public String toString(){
        return "Student{" + "studentId=" + studentId + ", name=" + name + ", number=" + number + '}';
    }
}

class Students{
    private Map<Integer, Student> studentMap;

    public Students(){
        this.studentMap = new LinkedHashMap<>();
    }

    public void addStudent(Student student) {
        studentMap.put(student.getStudentId(), student);
        System.out.println("Student " + student.getName() + " added to the list.");
    }

    public void removeStudent(int studentId) {
        if (studentMap.containsKey(studentId)) {
            Student removedStudent = studentMap.remove(studentId);
            System.out.println("Student with ID " + studentId + " and name " + removedStudent.getName() + " deleted from the list.");
        } else {
            System.out.println("Student with ID " + studentId + " not found in the list.");
        }
    }

    public Student findStudent(int studentId) {
        if (studentMap.containsKey(studentId)) {
            return studentMap.get(studentId);
        } else {
            System.out.println("Student with ID " + studentId + " not found in the list.");
            return null;
        }
    }

    public void printAllStudents() {
        System.out.println("List of students:");
        for (Student student : studentMap.values()) {
            System.out.println(student);
        }
    }

}
