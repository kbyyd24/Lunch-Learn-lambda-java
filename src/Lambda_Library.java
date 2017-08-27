import model.TWer;

import java.util.List;

import static java.util.Collections.emptyList;

public class Lambda_Library {

    public static void intro() {

        map_to_basic_type();

        summaryStatistics_method(emptyList());

        functionalInterface_annotation();

        default_method();

        static_method_in_interface();

        optional_type();

    }

    public static void map_to_basic_type() {}

    public static void summaryStatistics_method(List<TWer> twers) {}

    // interfaces.Command for example
    public static void functionalInterface_annotation() {}

    public static void default_method() {}

    public static void static_method_in_interface() {}

    public static void optional_type() {}

}
