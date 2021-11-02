package Models;

/**
 * Person Class
 */
public class Person {
    private Long id;
    private String firstName;
    private String lastName;

    /**
     * Constructor of class Person
     *
     * @param id        must be of type Long
     * @param firstName must be of type String
     * @param lastName  must be of type String
     */
    public Person(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters & Setters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getId() {
        return id;
    }
}
