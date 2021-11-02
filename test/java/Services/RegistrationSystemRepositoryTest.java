package Services;

import Models.Course;
import Models.Student;
import Models.Teacher;
import Singletons.CourseRepo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationSystemRepositoryTest {

    @Test
    void register() {
        Teacher teacher1 = new Teacher(124L, "Ion", "Ionescu");
        Student student1 = new Student(125L, "Popescu", "Pop");
        Student student2 = new Student(1255L, "Andrei", "Andreescu");
        Course course1 = new Course(123L, "Math", teacher1, 2, 28);
        Course course2 = new Course(1233L, "Chemistry", teacher1, 1, 28);
//        InMemoryCourseRepository course1 = new InMemoryCourseRepository();

        RegistrationSystemRepository registrationSystem = new RegistrationSystemRepository();

        // Successfully adds a student
        assertTrue(registrationSystem.register(course1, student1));
        // Fail - credits > 30
        assertFalse(registrationSystem.register(course2, student1));
        // Fail - There is no free space left
        assertFalse(registrationSystem.register(course2, student2));
    }

    @Test
    void retrieveCoursesWithFreePlaces() {
        RegistrationSystemRepository registrationSystem = new RegistrationSystemRepository();
        Teacher teacher1 = new Teacher(124L, "Ion", "Ionescu");
        Student student1 = new Student(125L, "Popescu", "Pop");
        Student student2 = new Student(1255L, "Andrei", "Andreescu");
        Course course1 = new Course(123L, "Math", teacher1, 2, 28);
        Course course2 = new Course(1233L, "Chemistry", teacher1, 1, 28);

        registrationSystem.register(course1, student1);
        assertEquals(registrationSystem.retrieveCoursesWithFreePlaces().size(), 2);

        registrationSystem.register(course1, student2);
        assertEquals(registrationSystem.retrieveCoursesWithFreePlaces().size(), 0);
    }

    @Test
    void retrieveStudentsEnrolledForACourse() {
        RegistrationSystemRepository registrationSystem = new RegistrationSystemRepository();
        Teacher teacher1 = new Teacher(124L, "Ion", "Ionescu");
        Student student1 = new Student(125L, "Popescu", "Pop");
        Student student2 = new Student(1255L, "Andrei", "Andreescu");
        Course course1 = new Course(123L, "Math", teacher1, 2, 28);
        Course course2 = new Course(1233L, "Chemistry", teacher1, 1, 28);

        registrationSystem.register(course1, student1);
        assertEquals(1, registrationSystem.retrieveStudentsEnrolledForACourse(course1).size());
        registrationSystem.register(course1, student2);
        assertEquals(2, registrationSystem.retrieveStudentsEnrolledForACourse(course1).size());
        assertEquals(0, registrationSystem.retrieveStudentsEnrolledForACourse(course2).size());

    }

    @Test
    void getAllCourses() {
        RegistrationSystemRepository registrationSystem = new RegistrationSystemRepository();
        assertEquals(2, registrationSystem.getAllCourses().size());
    }
}