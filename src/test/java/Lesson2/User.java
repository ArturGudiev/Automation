package Lesson2;

/**
 * Created by Artur on 07.05.2017.
 */
public class User {
    private String firstName;
    private String lastName;

    public User() {
        firstName = "John";
        lastName = "Smith";
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
