import model.TWer;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Stream_API_ExamplesTest {

    private Stream<TWer> tWerStream;

    @Before
    public void setUp() throws Exception {
        tWerStream = Stream.<TWer>builder()
                .add(new TWer("name03", "China", "Chengdu", 0.1, 25))
                .add(new TWer("name20", "UK", "London", 3, 23))
                .add(new TWer("name14", "USA", "LA", 2, 32))
                .add(new TWer("name30", "India", "Pune", 12, 50))
                .add(new TWer("name23", "Australia", "Sydney", 7, 43))
                .add(new TWer("name05", "Singapore", "Singapore", 12.3, 33))
                .build();
    }

    @Test
    public void test_filter_example() throws Exception {
        System.out.println();
        System.out.println("Stream_API_ExamplesTest.test_filter_example");

        List<TWer> tWers = Stream_API_Examples.filter_example(tWerStream);
        tWers.forEach(System.out::println);
//        tWers.forEach(twer -> System.out.println(twer));
    }

    @Test
    public void test_map_example() throws Exception {
        System.out.println();
        System.out.println("Stream_API_ExamplesTest.test_map_example");

        Set<String> names = Stream_API_Examples.map_example(tWerStream);
        names.forEach(System.out::println);
    }

    @Test
    public void test_sort_example() throws Exception {
        System.out.println();
        System.out.println("Stream_API_ExamplesTest.test_sort_example");

        List<TWer> tWers = Stream_API_Examples.sort_example(tWerStream);
        tWers.forEach(System.out::println);
    }

    @Test
    public void test_reduce_example() throws Exception {
        System.out.println();
        System.out.println("Stream_API_ExamplesTest.test_reduce_example");

        int sumAge = Stream_API_Examples.reduce_example(tWerStream);
        System.out.println(sumAge);
    }

    @Test
    public void test_sum_example() throws Exception {
        System.out.println();
        System.out.println("Stream_API_ExamplesTest.test_sum_example");

        List<TWer> tWers = tWerStream.collect(Collectors.toList());
        int sumAge = Stream_API_Examples.sum_example(tWers.stream());
        System.out.println(sumAge);

        int reduce_sum_age = Stream_API_Examples.reduce_example(tWers.stream());

        assertThat(reduce_sum_age, is(sumAge));
    }

    @Test
    public void test_max_example() throws Exception {
        System.out.println();
        System.out.println("Stream_API_ExamplesTest.test_max_example");

        TWer max_name_person = Stream_API_Examples.max_example(tWerStream);
        System.out.println(max_name_person);
    }

}