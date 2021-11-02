package Services;

import Models.Course;
import Models.Student;
import Models.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InMemoryCourseRepository implements CrudRepository<Course> {
    private List<Course> courses = new ArrayList<>();

    //    Constructor
    public InMemoryCourseRepository() {
        courses.add(new Course(0L, "", null, 0, 0));
        courses.add(new Course(0L, "", null, 0, 0));
    }

    public List<Course> getCourses() {
        return courses;
    }

    //   Finds all courses that still have free places
    public List<Course> getFreeCourses() {
        List<Course> freeCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.getEnrolledStudents().size() < course.getMaxEnrollment()) {
                freeCourses.add(course);
            }
        }
        return freeCourses;
    }

    // Implementation of the CRUD
    @Override
    public Course findOne(Long id) {
        for (Course course : courses) {
            if (Objects.equals(course.getId(), id)) {
                return course;
            }
        }
        return null;
    }

    @Override
    public Iterable<Course> findAll() {
        return courses;
    }

    @Override
    public Course save(Course entity) {
        if (entity == null) {
            return null;
        }
        for (Course course : courses) {
            if (Objects.equals(course.getId(), entity.getId())) {
                return null;
            }
        }
        courses.add(entity);
        return entity;
    }

    @Override
    public Course delete(Long id) {
        if (id == null) {
            return null;
        }
        for (Course course : courses) {
            if (Objects.equals(course.getId(), id)) {
                courses.remove(course);
                return course;
            }
        }
        return null;
    }

    @Override
    public Course update(Course entity) {
        if (entity == null) {
            return null;
        }
        for (Course course : courses) {
            if (Objects.equals(course.getId(), entity.getId())) {
                courses.remove(course);
                courses.add(entity);
                return null;
            }
        }
        return entity;
    }


}
