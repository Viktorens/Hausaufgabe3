package Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Course class
 */
public class Course {
    private Long id;
    private String name;
    private Teacher teacher;
    private int maxEnrollment;
    private int credit;
    private List<Student> enrolledStudents = new ArrayList<>();

    /**
     * Constructor of class Course
     *
     * @param id            must be of type Long
     * @param name          must be of type String
     * @param teacher       must be of type Teacher and not null
     * @param maxEnrollment must be of type int
     * @param credit        must be of type int
     */
    public Course(Long id, String name, Teacher teacher, int maxEnrollment, int credit) {
        this.name = name;
        this.teacher = teacher;
        this.teacher.addCourse(this);
        this.maxEnrollment = maxEnrollment;
        this.credit = credit;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Person getTeacher() {
        return teacher;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public int getCredit() {
        return credit;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    /**
     * Enroll Student in Course List
     *
     * @param student must be of type Student
     * @return true if the enrollment was successful - otherwise false
     */
    public boolean addEnrolledStudent(Student student) {
        if (this.isCourseFull()) {
            return false;
        }
        enrolledStudents.add(student);
        return true;
    }

    /**
     * Checks if course still has places
     *
     * @return true if the list of courses has the maximum number of enrollments
     */
    public boolean isCourseFull() {
        return enrolledStudents.size() == maxEnrollment;
    }

}
