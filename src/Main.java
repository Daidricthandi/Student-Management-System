import com.library.management.Library;
import com.library.management.Student;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    boolean running = true;

    while(running) {
        printMenu();
        int choice = getChoice();

        switch (choice) {
            case 1 -> addStudents();
            case 2 -> viewAllStudents();
            case 3 -> searchStudent();
            case 4 -> deleteStudent();
            case 5 -> {
                System.out.println("Exiting program. Goodbye!");
                running = false;
            }
            case 6 -> addGradeToStudent();
            case 7 -> viewStudentGrades();

            default -> System.out.println("Invalid choice. Please select 1-5.");

        }
    }
    }
    private static void printMenu() {
        System.out.println("\n**** Student Management System ****");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by Name or ID");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
        System.out.println("6. Add Grade to Student");
        System.out.println("7. View Student Grades");
        System.out.print("Enter your choice: ");
    }

    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // invalid input
        }
    }

    private static void addStudents() {
        System.out.print("Enter Student ID (number): ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Email: ");
        String email = scanner.nextLine();

        Student newStudent = new Student(id, name, email);
        students.add(newStudent);

        System.out.println(name + " has been added to the system.");
    }

    private static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\nList of Students:");
            for (Student s : students) {
                System.out.println(s);  // This calls Student.toString()
            }
        }
    }

    private static void searchStudent() {
        System.out.print("Enter Student ID or Name to search: ");
        String input = scanner.nextLine().trim();

        boolean found = false;

        for (Student s : students) {
            // Check if input matches student ID or name (case-insensitive for name)
            if (String.valueOf(s.getStudentID()).equals(input) || s.getName().equalsIgnoreCase(input)) {
                System.out.println("Student found: " + s);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No student found with ID or name: " + input);
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String input = scanner.nextLine().trim();

        boolean removed = false;

        // Use iterator to avoid ConcurrentModificationException when removing
        for (int i = 0; i < students.size(); i++) {
            if (String.valueOf(students.get(i).getStudentID()).equals(input)) {
                Student removedStudent = students.remove(i);
                System.out.println(removedStudent.getName() + " has been deleted from the system.");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("No student found with ID: " + input);
        }
    }

    private static void addGradeToStudent() {
        System.out.print("Enter Student ID to add grade: ");
        String input = scanner.nextLine().trim();

        Student student = null;
        for (Student s : students) {
            if (String.valueOf(s.getStudentID()).equals(input)) {
                student = s;
                break;
            }
        }

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter subject name: ");
        String subject = scanner.nextLine();

        System.out.print("Enter grade (0 - 100): ");
        double grade;
        try {
            grade = Double.parseDouble(scanner.nextLine());
            if (grade < 0 || grade > 100) {
                System.out.println("Grade must be between 0 and 100.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid grade format.");
            return;
        }

        student.addGrade(subject, grade);
        System.out.println("Grade added.");
    }

    private static void viewStudentGrades() {
        System.out.print("Enter Student ID to view grades: ");
        String input = scanner.nextLine().trim();

        Student student = null;
        for (Student s : students) {
            if (String.valueOf(s.getStudentID()).equals(input)) {
                student = s;
                break;
            }
        }

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        student.displayGrades();
    }

}