public class Main {
    public static void main(String[] args) {
        Students students = new Students();
        students.addStudent(new Student(1,"John","123456789"));
        students.addStudent(new Student(2,"David","987654321"));
        students.printAllStudents();
        Student foundstudent = students.findStudent(1);
        if(foundstudent != null){
            System.out.println("Student found: " + foundstudent);
        }
        students.removeStudent(1);
        students.printAllStudents();
    }

}