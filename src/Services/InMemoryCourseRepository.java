package Services;

import Models.Course;
import Models.Student;
import Models.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * InMemoryCourseRepository class
 */
public class InMemoryCourseRepository implements CrudRepository<Course> {
    private List<Course> courses = new ArrayList<>();

    /**
     * Constructor of the class
     */
    public InMemoryCourseRepository() {
        Teacher teacher1 = new Teacher(124L, "Ion", "Ionescu");
        Teacher teacher2 = new Teacher(1244L, "Vlad", "Vladimirescu");
        courses.add(new Course(123L, "Math", teacher1, 2, 28));
        courses.add(new Course(1233L, "Chemistry", teacher2, 1, 28));
    }

    public List<Course> getCourses() {
        return courses;
    }

    /**
     * Finds all courses that still have free places
     *
     * @return list with all free courses
     */
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

    /**
     * @param id -the id of the entity to be returned id must not be null
     * @return entity with the specified id or null - if there is no entity with the given id
     */
    @Override
    public Course findOne(Long id) {
        for (Course course : courses) {
            if (Objects.equals(course.getId(), id)) {
                return course;
            }
        }
        return null;
    }

    /**
     * @return all entities
     */
    @Override
    public Iterable<Course> findAll() {
        return courses;
    }

    /**
     * @param entity entity must be not null
     * @return null- if the given entity is saved otherwise returns the entity (id already exists)
     */
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

    /**
     * removes the entity with the specified id
     *
     * @param id id must be not null
     * @return the removed entity or null if there is no entity with the given id
     */
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

    /**
     * @param entity entity must not be null
     * @return null - if the entity is updated, otherwise returns the entity - (e.g id does not exist).
     */
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
