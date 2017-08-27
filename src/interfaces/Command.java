package interfaces;

@FunctionalInterface
// A interface which has only one non-overriding abstract method.
// Won't work when application is running,
// only use to check if the interface has only one non-overriding abstract method.
public interface Command {

    boolean exec();

//    Multiple non-overriding abstract methods found in interface
//    String getName();

    default String getDescription() {
        return "";
    }

}
