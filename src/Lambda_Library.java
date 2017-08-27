import interfaces.Command;
import model.TWer;

import java.util.Collection;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import static java.util.Collections.emptyList;

public class Lambda_Library {

    public static void intro() {

        map_to_basic_type(emptyList());

        summaryStatistics_method(emptyList());

        functionalInterface_annotation();

        default_method();

        static_method_in_interface();

        optional_type();

    }

    public static void map_to_basic_type(List<TWer> tWers) {
        // Just for performance
        long count = tWers.stream()
                .mapToInt(twer -> twer.age)
                .mapToLong(age -> age)
                .mapToDouble(age -> age)
                .count();
    }

    public static void summaryStatistics_method(List<TWer> twers) {
        // useful to statistic numbers
        DoubleSummaryStatistics summaryStatistics = twers.stream()
                .mapToDouble(twer -> twer.time_in_ThoughtWorks)
                .summaryStatistics();

        System.out.printf("max: %f, min: %f, ave: %f, sum: %f, count: %d",
                summaryStatistics.getMax(),
                summaryStatistics.getMin(),
                summaryStatistics.getAverage(),
                summaryStatistics.getSum(),
                summaryStatistics.getCount());
    }

    // interfaces.Command for example
    public static void functionalInterface_annotation() {
        Command showMe = () -> true;
    }

    public static void default_method() {

        String reason = "In order to compatible other libraries";
        String detail = "Other libraries extend Collection library, " +
                "without default method in Collection interface, " +
                "these libraries can't work in Java8";

        Collection<TWer> showMe = emptyList();

        String tips = "default methods ain't non-overriding method";

        Command showMeAgain = () -> true;

    }

    public static void static_method_in_interface() {}

    public static void optional_type() {}

}
