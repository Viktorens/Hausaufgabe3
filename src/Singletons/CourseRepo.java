package Singletons;

import Services.InMemoryCourseRepository;

/**
 * CourseRepo Class
 */
public class CourseRepo {
    private static InMemoryCourseRepository instance;

    private CourseRepo() {
    }

    /**
     * Singleton Instance for InMemoryCourseRepository class
     *
     * @return instance of InMemoryCourseRepository
     */
    public static InMemoryCourseRepository getInstance() {
        if (instance == null) {
            instance = new InMemoryCourseRepository();
        }
        return instance;
    }
}
