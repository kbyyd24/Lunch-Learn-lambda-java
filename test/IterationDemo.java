import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IterationDemo {

    private List<Character> characters;

    @Before
    public void setUp() throws Exception {
        characters = Arrays.asList('a', 'a', 'a', 'b', 'b', 'c', 'c', 'd', 'a', 'a', 'a');
    }

    @Test
    public void externalIteration() throws Exception {
        int count = 0;

        for (int i = 0; i < characters.size(); i++) {
            Character character = characters.get(i);
            if (character == 'a') {
                count ++;
            }
        }


        count = 0;

        Iterator<Character> iterator = characters.iterator();
        while (iterator.hasNext()) {
            Character next = iterator.next();
            if (next == 'a') {
                count ++;
            }
        }

    }

    @Test
    public void internalIteration() throws Exception {
        long count = characters.stream()
                .filter(character -> character == 'a')
                .count();
    }
}
