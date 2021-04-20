package main.java8.functionalInterface;

@FunctionalInterface
public interface RunSomething {

    void doIt();

    static void printName() {
        System.out.println("I'm EHOTO!!!");
    }

    default void printAge() {
        System.out.println("I'm 29");
    }

}
