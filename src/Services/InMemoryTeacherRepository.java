package Services;

import Models.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * InMemoryTeacherRepository class
 */
public class InMemoryTeacherRepository implements CrudRepository<Teacher> {
    private List<Teacher> teachers = new ArrayList<>();

    /**
     * Constructor of the class
     */
    public InMemoryTeacherRepository() {
        teachers.add(new Teacher(0L, "", ""));
        teachers.add(new Teacher(0L, "", ""));
    }

    // Implementation of the CRUD

    /**
     * @param id -the id of the entity to be returned id must not be null
     * @return entity with the specified id or null - if there is no entity with the given id
     */
    @Override
    public Teacher findOne(Long id) {
        for (Teacher teacher : teachers) {
            if (Objects.equals(teacher.getId(), id)) {
                return teacher;
            }
        }
        return null;
    }

    /**
     * @return all entities
     */
    @Override
    public Iterable<Teacher> findAll() {
        return teachers;
    }

    /**
     * @param entity entity must be not null
     * @return null- if the given entity is saved otherwise returns the entity (id already exists)
     */
    @Override
    public Teacher save(Teacher entity) {
        if (entity == null) {
            return null;
        }
        for (Teacher teacher : teachers) {
            if (Objects.equals(teacher.getId(), entity.getId())) {
                return null;
            }
        }
        teachers.add(entity);
        return entity;
    }

    /**
     * removes the entity with the specified id
     *
     * @param id id must be not null
     * @return the removed entity or null if there is no entity with the given id
     */
    @Override
    public Teacher delete(Long id) {
        if (id == null) {
            return null;
        }
        for (Teacher teacher : teachers) {
            if (Objects.equals(teacher.getId(), id)) {
                teachers.remove(teacher);
                return teacher;
            }
        }
        return null;

    }

    /**
     * @param entity entity must not be null
     * @return null - if the entity is updated, otherwise returns the entity - (e.g id does not exist).
     */
    @Override
    public Teacher update(Teacher entity) {
        if (entity == null) {
            return null;
        }
        for (Teacher teacher : teachers) {
            if (Objects.equals(teacher.getId(), entity.getId())) {
                teachers.remove(teacher);
                teachers.add(entity);
                return null;
            }
        }
        return entity;
    }

}
