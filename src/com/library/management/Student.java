package com.library.management;
import java.util.HashMap;
import java.util.Map;

public class Student {
    //declaring mt fields/attributes
    private int studentID;
    private String name;
    private String email;

    // new field for subjects and grades
    private Map<String, Double> grades;


    //Constuctor
    public Student(int studentID, String name, String email) {
        this.studentID = studentID;
        this.name = name;
        this.email= email;
        this.grades = new HashMap<>();
    }

    //Getters
    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // method to add or update a grade
    public void addGrade(String subject, double grade) {
        grades.put(subject, grade);
    }

    // method to calculate average grade
    public double getAverageGrade() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0;
        for (double grade : grades.values()) {
            sum += grade;
        }
        return sum / grades.size();
    }

    @Override
    public String toString() {
        return "\nStudent ID: " + studentID +
                "\nName: " + name +
                "\nEmail: " + email +
                "\nAverage Grade: " +
                String.format("%.2f", getAverageGrade());
    }

    // Optional: method to display all subjects and grades
    public void displayGrades() {
        if (grades.isEmpty()) {
            System.out.println("No grades recorded.");
        } else {
            System.out.println("Grades:");
            for (Map.Entry<String, Double> entry : grades.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
