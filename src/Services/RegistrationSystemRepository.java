package Services;

import Models.Course;
import Models.Student;
import Singletons.CourseRepo;

import java.util.List;

// Instancing the class
public class RegistrationSystemRepository implements IRegistrationSystem {
    private InMemoryCourseRepository courseRepository = CourseRepo.getInstance();

    //    Registers a student to a specific course
    @Override
    public boolean register(Course course, Student student) {
        course.addEnrolledStudent(student);
        student.enrollInCourse(course);
        return true;
    }

    // Retrieves the free courses
    @Override
    public List<Course> retrieveCoursesWithFreePlaces() {
        return courseRepository.getFreeCourses();
    }

    // Retrieves the enrolled students from a specific course
    @Override
    public List<Student> retrieveStudentsEnrolledForACourse(Course course) {
        return course.getEnrolledStudents();
    }

    // Get all courses
    @Override
    public List<Course> getAllCourses() {
        return courseRepository.getCourses();
    }
}
