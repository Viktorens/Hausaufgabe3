package Models;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private List<Course> courses = new ArrayList<>();

    // Constructor
    public Teacher(Long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    // Add courses to own list
    public void addCourse(Course course) {
        courses.add(course);
    }
}
