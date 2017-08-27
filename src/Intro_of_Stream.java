import model.TWer;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static java.util.Collections.emptyList;

public class Intro_of_Stream {

    public static void intro() {

        internal_iteration(emptyList());

        external_iteration();

        get_stream_from_collection();

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

    public static void external_iteration() {}

    public static void get_stream_from_collection() {}

    public static void how_stream_works() {}

    public static void some_options_about_stream() {}

}
