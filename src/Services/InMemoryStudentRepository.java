package Services;

import Models.Student;
import Models.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * InMemoryStudentRepository class
 */
public class InMemoryStudentRepository implements CrudRepository<Student> {
    private List<Student> students = new ArrayList<>();

    /**
     * Constructor of the class
     */
    public InMemoryStudentRepository() {
        students.add(new Student(0L, "", ""));
        students.add(new Student(0L, "", ""));
    }

    // Implementation of the CRUD

    /**
     * @param id -the id of the entity to be returned id must not be null
     * @return entity with the specified id or null - if there is no entity with the given id
     */
    @Override
    public Student findOne(Long id) {
        for (Student student : students) {
            if (Objects.equals(student.getId(), id)) {
                return student;
            }
        }
        return null;
    }

    /**
     * @return all entities
     */
    @Override
    public Iterable<Student> findAll() {
        return students;
    }

    /**
     * @param entity entity must be not null
     * @return null- if the given entity is saved otherwise returns the entity (id already exists)
     */
    @Override
    public Student save(Student entity) {
        if (entity == null) {
            return null;
        }
        for (Student student : students) {
            if (Objects.equals(student.getId(), entity.getId())) {
                return null;
            }
        }
        students.add(entity);
        return entity;
    }

    /**
     * removes the entity with the specified id
     *
     * @param id id must be not null
     * @return the removed entity or null if there is no entity with the given id
     */
    @Override
    public Student delete(Long id) {
        if (id == null) {
            return null;
        }
        for (Student student : students) {
            if (Objects.equals(student.getId(), id)) {
                students.remove(student);
                return student;
            }
        }
        return null;
    }

    /**
     * @param entity entity must not be null
     * @return null - if the entity is updated, otherwise returns the entity - (e.g id does not exist).
     */
    @Override
    public Student update(Student entity) {
        if (entity == null) {
            return null;
        }
        for (Student student : students) {
            if (Objects.equals(student.getId(), entity.getId())) {
                students.remove(student);
                students.add(entity);
                return null;
            }
        }
        return entity;
    }
}
