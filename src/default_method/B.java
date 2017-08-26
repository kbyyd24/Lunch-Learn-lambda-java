package default_method;

public interface B extends A {
    @Override
    default void a() {
        System.out.println("b");
    }
}
