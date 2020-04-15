package asmt01;

/**
 * SFSU CSC220 Data Structures
 *
 * @author Duc Ta PLUS
 */
public class Person implements Greeting {

    private String firstName;
    private String lastName;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
    
    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name + "!");
    }
}
