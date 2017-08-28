import model.TWer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_API_Examples {

    public static List<TWer> filter_example(Stream<TWer> twers) {
        return twers
                .filter(twer -> twer.name.contains("2"))
                .collect(Collectors.toList());
    }

    public static Set<String> map_example(Stream<TWer> twers) {
        return twers
                .map(twer -> twer.name)
                .collect(Collectors.toSet());
    }

    public static List<TWer> sort_example(Stream<TWer> unorderedTwers) {
        return unorderedTwers
//                .sorted(Comparator.comparing(twer -> twer.name))
                .sorted((twer1, twer2) -> twer1.name.compareTo(twer2.name))
//                Comparable interface
                .collect(Collectors.toList());
    }

    public static int reduce_example(Stream<TWer> twerStream) {
        return twerStream
                .map(twer -> twer.age)
                .reduce(0, (age1, age2) -> age1 + age2);
    }

    public static int sum_example(Stream<TWer> tWerStream) {
        return tWerStream
                .mapToInt(twer -> twer.age)
//                .mapToDouble()
//                .mapToLong()
                .sum();
    }

    public static TWer max_example(Stream<TWer> tWerStream) {
        Optional<TWer> maxTWer = tWerStream
//                .min(Collections.reverseOrder(Comparator.comparing(twer -> twer.name)));
//                .min(Comparator.<TWer, String>comparing(twer -> twer.name).reversed());
                .max(Comparator.comparing(twer -> twer.name));

        return maxTWer.orElse(new TWer());
    }

}
