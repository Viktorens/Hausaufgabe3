package Services;

import Models.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InMemoryTeacherRepository implements CrudRepository<Teacher> {
    private List<Teacher> teachers = new ArrayList<>();

    //     Constructor
    public InMemoryTeacherRepository() {
        teachers.add(new Teacher(0L, "", ""));
        teachers.add(new Teacher(0L, "", ""));
    }

    // Implementation of the CRUD
    @Override
    public Teacher findOne(Long id) {
        for (Teacher teacher : teachers) {
            if (Objects.equals(teacher.getId(), id)) {
                return teacher;
            }
        }
        return null;
    }

    @Override
    public Iterable<Teacher> findAll() {
        return teachers;
    }

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
