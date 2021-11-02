package Models;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private int totalCredits;
    private List<Course> enrolledCourses = new ArrayList<>();

    // Constructor
    public Student(Long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    // Getters & Setters
    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName();
    }

    //    Methode for enrolling Student
    public boolean enrollInCourse(Course course) {
        // Checks if course still has place
        if (!course.addEnrolledStudent(this)) {
            return false;
        }
        // Checks if student has enough credits and enroll him
        if (totalCredits + course.getCredit() < 30) {
            totalCredits += course.getCredit();
            enrolledCourses.add(course);
            return true;
        }
        return false;
    }
}
