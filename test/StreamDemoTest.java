import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StreamDemoTest {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

    @SuppressWarnings("Convert2MethodRef")
    @Test
    public void should_print_names_first() {

        Stream<String> nameStream = Stream.of("Bryant", "Jordan", "James")
                .peek(name -> System.out.println(name))
                .filter(name -> name.length() == 6);

        System.out.println("count");
        System.out.println(nameStream.count());


        String output =
                "Bryant\n" +
                "Jordan\n" +
                "James\n" +
                "count\n" +
                "2\n";
        assertThat(outputStream.toString(), is(output));
    }

}