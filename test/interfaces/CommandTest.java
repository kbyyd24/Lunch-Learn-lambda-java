package interfaces;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CommandTest {

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
    public void test_for_command() throws Exception {
        String msg = "list all files in this folder";
        Command ls = () -> {
            System.out.println(msg);
            return true;
        };

        HashMap<String, Command> commands = new HashMap<>();
        commands.put("ls", ls);

        commands.get("ls").exec();

        boolean result = ls.exec();

        assertTrue(result);
        assertThat(outputStream.toString(), is(msg));
    }
}