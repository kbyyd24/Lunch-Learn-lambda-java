import model.TWer;

import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class What_Is_Lambda {

    public static void intro() {

        what_is_lambda();

        why_need_lambda();

        what_lambda_look_like();

        some_important_interface(emptyList());

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

        three_parts();

        shape_of_arguments();

        shape_of_expression();

    }

    private static void three_parts() {

        String structure = "(a, b) -> {...}";

        String arguments = " (a, b) ";

        String connect_symbol = " -> ";

        String expression = " {...} ";

    }

    private static void shape_of_arguments() {

        Runnable no_argument = () -> {
        };

        Predicate<TWer> one_argument_shape_one = twer -> true;

        Predicate<TWer> one_argument_shape_two = (twer) -> true;

        Predicate<TWer> one_argument_shape_three = (TWer twer) -> true;

        BinaryOperator<TWer> multiple_arguments_shape_one = (twer1, twer2) -> twer1;

        BinaryOperator<TWer> multiple_arguments_shape_two = (twer1, twer2) -> twer1;

    }

    private static void shape_of_expression() {

        Runnable one_line_without_return = () -> System.out.println("only one line");

        Runnable multiple_lines_without_return = () -> {
            System.out.println("line one");
            System.out.println("line two");
        };

        Predicate<TWer> one_line_with_return = twer -> true;

        Predicate<TWer> multiple_lines_with_return = twer -> {
            if (twer.region.equals("China")) {
                return true;
            } else if (twer.office.equals("LA")) {
                return true;
            }
            return false;
        };

    }

    public static void some_important_interface(List<TWer> twers) {

        intro_Predicate(twers);

        intro_Consumer(twers);

        intro_Function(twers);

        intro_BinaryOperator(twers);

    }

    private static void intro_Predicate(List<TWer> twers) {

        Predicate<TWer> is_from_china = twer -> twer.region.equals("China");

        // example
        long number_of_twer_from_china = twers.stream()
                .filter(is_from_china)
                .count();

    }

    private static void intro_Consumer(List<TWer> twers) {

        Consumer<TWer> print_every_name = twer -> System.out.println(twer.name);

        Consumer<TWer> print_every_name_and_region =
                print_every_name.andThen(twer -> System.out.println(twer.region));

        twers.forEach(print_every_name_and_region);

    }

    private static void intro_Function(List<TWer> twers) {

        Function<TWer, String> get_all_regions = twer -> twer.region;

        List<String> regions = twers.stream()
                .map(get_all_regions)
                .collect(Collectors.toList());

    }


    private static void intro_BinaryOperator(List<TWer> twers) {

        BinaryOperator<Integer> add_all_ages = (age1, age2) -> age1 + age2;

        int sumAge = twers.stream()
                .map(twer -> twer.age)
                .reduce(0, add_all_ages);


        BinaryOperator<TWer> select_youngest_person =
                (twer1, twer2) ->
                        twer1.age > twer2.age ? twer2 : twer1;

        TWer youngest_twer = twers.stream()
                .reduce(new TWer(), select_youngest_person);

    }
}
