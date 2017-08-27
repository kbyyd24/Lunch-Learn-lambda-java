import model.TWer;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;

public class Intro_of_Stream {

    public static void intro() {

        internal_iteration(emptyList());

        external_iteration(emptyList());

        how_stream_works();

        some_options_about_stream();

    }

    public static void internal_iteration(List<TWer> twers) {
        //three examples
        //for i iteration
        int count = 0;
        for (int i = 0; i < twers.size(); i++) {
            if (twers.get(i).region.equals("China")) {
                count ++;
            }
        }
        System.out.println("Count by for i iteration: " + count);

        //use iterator
        count = 0;
        Iterator<TWer> iterator = twers.iterator();
        while (iterator.hasNext()) {
            TWer twer = iterator.next();
            if (twer.region.equals("China")) {
                count ++;
            }
        }
        System.out.println("Count by iterator: " + count);

        //for iteration
        count = 0;
        for (TWer twer : twers) {
            if (twer.region.equals("China")) {
                count ++;
            }
        }
        System.out.println("Count by for iteration: " + count);

        System.out.println("Need us to control the iteration");
    }

    public static void external_iteration(List<TWer> twers) {

        long count = twers.stream()
                .filter(twer -> twer.region.equals("China"))
                .count();
        System.out.println("Count by stream: " + count);

        System.out.println("We don't need to control iteration when we use external iteration");

    }

    public static void how_stream_works() {

        Stream<String> nameStream = Stream.of("Bryant", "Jordan", "James")
                .peek(name -> System.out.println(name))
                .filter(name -> name.length() == 6);

        System.out.println("counting");
        System.out.println(nameStream.count());

    }

    public static void some_options_about_stream() {}

}
