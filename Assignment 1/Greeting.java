package asmt01ec;

/**
 * SFSU CSC220 Data Structures
 * **************************** PLEASE DO NOT CHANGE THIS FILE ***********
 * @author Duc Ta PLUS
 */
public interface Greeting {

    public static final String HELLO = "Hello there!";
    public static final String SFSU_ENGLISH_HELLO = "Hello Gators!";
    public static final String SFSU_SPANISH_HELLO = "Hola Caimanes!";
    public static final String SFGIANTS_ENGLISH_HELLO = "Hello Giants!";
    public static final String SFGIANTS_SPANISH_HELLO = "Hello Gigantes!";

    public default void sayHello() {
        System.out.println(Greeting.HELLO);
    }

    public abstract void sayHello(String name);
}
