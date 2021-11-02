package Services;

import Models.Course;
import Models.Student;
import Singletons.CourseRepo;

import java.util.List;

/**
 * Instancing the class
 */
public class RegistrationSystemRepository implements IRegistrationSystem {
    private InMemoryCourseRepository courseRepository = CourseRepo.getInstance();

    /**
     * Resisters a student to a specific course
     *
     * @param course  must be not null
     * @param student must be not null
     * @return true if student was successfully added
     */
    @Override
    public boolean register(Course course, Student student) {
        return student.enrollInCourse(course);
    }

    /**
     * Retrieves the free courses
     *
     * @return list with the free courses
     */
    @Override
    public List<Course> retrieveCoursesWithFreePlaces() {
        return courseRepository.getFreeCourses();
    }

    /**
     * Retrieves the enrolled students from a specific course
     *
     * @param course must be not null
     * @return list with the all students from a course
     */
    @Override
    public List<Student> retrieveStudentsEnrolledForACourse(Course course) {
        return course.getEnrolledStudents();
    }

    /**
     * Get all courses
     *
     * @return list with the all courses
     */
    @Override
    public List<Course> getAllCourses() {
        return courseRepository.getCourses();
    }
}
