package interfaces;

@FunctionalInterface
public interface Command {

    boolean exec();

    default String getDescription() {
        return "";
    }

}
