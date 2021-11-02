package Singletons;

import Services.InMemoryCourseRepository;

public class CourseRepo {
    private static InMemoryCourseRepository instance;

    private CourseRepo() {
    }

    // Singleton Instance for InMemoryRepository class
    public static InMemoryCourseRepository getInstance() {
        if (instance == null) {
            instance = new InMemoryCourseRepository();
        }
        return instance;
    }
}
