import org.junit.Test;

public class LambdaIntroTest {

    @Test
    public void anonymousClass() throws Exception {
        System.out.println();
        System.out.println("LambdaIntroTest.anonymousClass");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("anonymous class");
            }
        };

        new Thread(runnable).run();

    }

    @Test
    public void lambdaRunnable() throws Exception {
        System.out.println();
        System.out.println("LambdaIntroTest.lambdaRunnable");

        Runnable runnable = () -> System.out.println("lambda runnable");

        new Thread(runnable).run();

    }
}
