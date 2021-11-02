package Services;

import Models.*;

import java.util.List;

/**
 * IRegistrationSystem interface
 */
public interface IRegistrationSystem {
    /**
     * Enrolls a student to a course
     * @param course must be not null
     * @param student must be not null
     * @return true if the registration was successful, else false
     */
    boolean register(Course course, Student student);

    /**
     * Shows all courses with free places
     * @return list of courses
     */
    List<Course> retrieveCoursesWithFreePlaces();

    /**
     * Shows students that are enrolled to a specific course
     * @param course must be not null
     * @return list of students
     */
    List<Student> retrieveStudentsEnrolledForACourse(Course course);

    /**
     * Shows all courses
     * @return list of courses
     */
    List<Course> getAllCourses();
}
