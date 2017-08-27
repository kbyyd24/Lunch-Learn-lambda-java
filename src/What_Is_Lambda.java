public class What_Is_Lambda {

    public static void intro() {

        what_is_lambda();

        why_need_lambda();

        what_lambda_look_like();

        some_important_interface();

    }

    public static void what_is_lambda() {

        String define = "Lambda is an anonymous function";

        String explain = "It's hard to set name for every function, " +
                "so you don't need to set any name for a lambda function";

    }

    public static void why_need_lambda() {

        String think_about = "How do we use anonymous class";

        before_Java_8();

        after_Java_8();

    }

    private static void before_Java_8() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("other thread");
            }
        };

    }

    private static void after_Java_8() {

        Runnable runnable = () -> System.out.println("other thread");

    }

    public static void what_lambda_look_like() {

    }

    public static void some_important_interface() {

    }

}
