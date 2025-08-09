package com.library.management;

import java.util.ArrayList;

public class Library {
    private ArrayList<Student> students; //declares a field named students

    public Library() {
        students = new ArrayList<>(); //This creates an empty ArrayList and assigns it to the students field. Now students is ready to hold Student objects.
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println(student.getName() + " has been added to the library system.");
    }

    public void listStudents() {
        if(students.isEmpty()) {
            System.out.println("No students found");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }
}
