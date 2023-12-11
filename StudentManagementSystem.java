import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String studentID;
    private String name;
    private int age;
    private List<String> courses;

    public Student(String studentID, String name, int age) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.courses = new ArrayList<>();
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    public void displayDetails() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Courses: " + courses);
        System.out.println();
    }

    public void updateAge(int newAge) {
        this.age = newAge;
    }

    public List<String> getCourses() {
        return courses;
    }

    public int getAge() {
        return age;
    }

    public String getStudentID() {
        return studentID;
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Add existing sample students
        Student student1 = new Student("S001", "John Doe", 20);
        student1.addCourse("Math");
        student1.addCourse("Physics");

        Student student2 = new Student("S002", "Jane Smith", 22);
        student2.addCourse("Computer Science");
        student2.addCourse("Art");

        Student student3 = new Student("S003", "Bob Johnson", 21);
        student3.addCourse("Computer Science");
        student3.addCourse("History");

        students.add(student1);
        students.add(student2);
        students.add(student3);

        // Add a new student with your provided information
        Student newStudent = new Student("200546540", "Navpreet Kaur", 19);
        newStudent.addCourse("Computer Programming");

        students.add(newStudent);

        // Display details of all students using Java streams
        System.out.println("Details of all students:");
        students.forEach(Student::displayDetails);

        // Find and display students enrolled in a specific course using Java streams
        String targetCourse = "Computer Science";
        List<Student> computerScienceStudents = students.stream()
                .filter(student -> student.getCourses().contains(targetCourse))
                .collect(Collectors.toList());

        System.out.println("Students enrolled in " + targetCourse + ":");
        computerScienceStudents.forEach(Student::displayDetails);

        // Update the age of a specific student using Java streams
        String studentIDToUpdate = "S002";
        int newAge = 23;
        students.stream()
                .filter(student -> student.getStudentID().equals(studentIDToUpdate))
                .findFirst()
                .ifPresent(student -> student.updateAge(newAge));

        // Display details of all students after updating age using Java streams
        System.out.println("Details of all students after updating age:");
        students.forEach(Student::displayDetails);

        // Calculate and display the average age of all students using Java streams
        double averageAge = students.stream()
                .mapToDouble(Student::getAge)
                .average()
                .orElse(0.0);

        System.out.println("Average age of all students: " + averageAge);
    }
}
