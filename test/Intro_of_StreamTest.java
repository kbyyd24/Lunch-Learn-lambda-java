import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Intro_of_StreamTest {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

    @Test
    public void should_print_names_first() {
        String output =
                "Bryant\n" +
                "Jordan\n" +
                "James\n" +
                "count\n" +
                "2\n";
        Intro_of_Stream.how_stream_works();
        assertThat(outputStream.toString(), is(output));
    }

}





// lazy evaluation, won't compute value immediately, only compute value when you need it.