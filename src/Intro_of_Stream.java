import model.TWer;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;

public class Intro_of_Stream {

    public static void intro() {

        internal_iteration(emptyList());

        external_iteration(emptyList());

        how_stream_works();

        more_options_about_stream(emptyList());

    }

    public static void internal_iteration(List<TWer> twers) {
        //three examples
        //for i iteration

        List<TWer> twersFromChina = emptyList();
        for (int i = 0; i < twers.size(); i++) {
            TWer twer = twers.get(i);
            if (twer.region.equals("China")) {
                twersFromChina.add(twer);
            }
        }


        //use iterator

        twersFromChina = emptyList();
        Iterator<TWer> iterator = twers.iterator();
        while (iterator.hasNext()) {
            TWer twer = iterator.next();
            if (twer.region.equals("China")) {
                twersFromChina.add(twer);
            }
        }

        //for iteration

        twersFromChina = emptyList();
        for (TWer twer : twers) {
            if (twer.region.equals("China")) {
                twersFromChina.add(twer);
            }
        }


        System.out.println("Need us to control the iteration");
    }

    public static void external_iteration(List<TWer> twers) {

        List<TWer> twersFromChina = emptyList();
        twers.forEach(twer -> {
            if (twer.region.equals("China")) {
                twersFromChina.add(twer);
            }
        });

        System.out.println("We don't need to control iteration when we use external iteration");

    }

    public static void how_stream_works() {

        Stream<String> nameStream = Stream.of("Bryant", "Jordan", "James")
                .peek(name -> System.out.println(name))
                .filter(name -> name.length() == 6);

        System.out.println("count");
        System.out.println(nameStream.count());

    }

    public static void more_options_about_stream(List<TWer> twers) {

        Consumer<TWer> print_every_one = tWer -> System.out.println(true);

        twers.stream()
                .peek(print_every_one)
                .close();
        twers.forEach(print_every_one);


        Function<TWer, Integer> getAge = tWer -> tWer.age;

        Optional<Integer> maxAge = twers.stream()
                .map(getAge)
                .max((x, y) -> Integer.compare(x, y));
//              .min((x, y) -> Integer.compare(x, y));

    }

}
