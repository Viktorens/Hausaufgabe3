package Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Teacher class
 */
public class Teacher extends Person {
    private List<Course> courses = new ArrayList<>();

    /**
     * Constructor of class Teacher
     *
     * @param id        must be of type Long
     * @param firstName must be of type String
     * @param lastName  must be of type String
     */
    public Teacher(Long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    /**
     * Add courses to own list
     *
     * @param course must be of type Course
     */
    public void addCourse(Course course) {
        courses.add(course);
    }
}
