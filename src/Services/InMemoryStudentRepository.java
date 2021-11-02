package Services;

import Models.Student;
import Models.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InMemoryStudentRepository implements CrudRepository<Student> {
    private List<Student> students = new ArrayList<>();

    // Constructor
    public InMemoryStudentRepository() {
        students.add(new Student(0L, "", ""));
        students.add(new Student(0L, "", ""));
    }

    // Implementation of the CRUD
    @Override
    public Student findOne(Long id) {
        for (Student student : students) {
            if (Objects.equals(student.getId(), id)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public Iterable<Student> findAll() {
        return students;
    }

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
