package interfaces;

@FunctionalInterface
public interface Command {

    boolean exec();

//    Multiple non-overriding abstract methods found in interface
//    String getName();

    default String getDescription() {
        return "";
    }

}
