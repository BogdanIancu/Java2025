package ro.ase.acs.interfaces;

@FunctionalInterface
public interface Displayable {
    void display();

    default void displayHelloWorld() {
        System.out.println("Hello World");
    }
}

