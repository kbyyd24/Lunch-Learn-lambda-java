import org.junit.Test;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class LambdaIntroTest {

    @Test
    public void anonymousClass() throws Exception {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(this.getClass());
            }
        };

        new Thread(runnable).run();

    }

    @Test
    public void lambdaRunnable() throws Exception {

        Runnable runnable = () -> System.out.println("lambda runnable");

        new Thread(runnable).run();

    }

    @Test
    public void noArgumentMethod() throws Exception {

        Runnable runnable = () -> {
            System.out.println("LambdaIntroTest.noArgumentMethod");
            System.out.println(this.getClass());
        };

        new Thread(runnable).run();

        runnable = () -> System.out.println("lambda runnable");

        new Thread(runnable).run();

    }

    @Test
    public void oneArgumentMethod() throws Exception {

        ThoughtWorker twer = new ThoughtWorker();
        twer.title = "Senior Consultant";
        twer.yearsInTW = 3;

        Predicate<ThoughtWorker> isSenior = thoughtWorker -> thoughtWorker.title.contains("Senior");

        System.out.println("is senior: " + isSenior.test(twer));


        isSenior = (thoughtWorker) -> thoughtWorker.title.contains("Senior");

        System.out.println("is senior: " + isSenior.test(twer));


        isSenior = (ThoughtWorker thoughtworker) -> thoughtworker.title.contains("Senior");

        System.out.println("is senior: " + isSenior.test(twer));


        Predicate<ThoughtWorker> isSeniorAndServedMoreThan4Years = thoughtWorker -> {
            if (!thoughtWorker.title.contains("Senior")) {
                return false;
            }
            return thoughtWorker.yearsInTW > 4;
        };

        System.out.println("is senior and served more than 4 years: " +
                isSeniorAndServedMoreThan4Years.test(twer));
    }

    @Test
    public void multipleArgumentsMethod() throws Exception {

        BinaryOperator<Integer> add = (a, b) -> a + b;

        System.out.println("1 + 2 = " + add.apply(1, 2));


        add = (Integer a, Integer b) -> a + b;

        System.out.println("1 + 2 = " + add.apply(1, 2));

    }
}
