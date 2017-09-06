import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPITest {

    private Collection<ThoughtWorker> twers;

    @Before
    public void setUp() throws Exception {
        twers = new ArrayList<>();
        twers.add(new ThoughtWorker("Kobe", "US", "LA", 29, 4.3));
        twers.add(new ThoughtWorker("Jordan", "US", "Chicago", 32, 7));
        twers.add(new ThoughtWorker("Yuexiang", "China", "Chengdu", 18, 0.1));
        twers.add(new ThoughtWorker("Yingjian", "China", "Xian", 20, 0.3));
        twers.add(new ThoughtWorker("Yu", "China", "Xian", 25, 3.3));
    }

    @Test
    public void buildStreamDemo() throws Exception {
        Stream<String> shootingGuardStream = Stream.of("Jordan", "Kobe");

        Stream<ThoughtWorker> twerStream = Stream.<ThoughtWorker>builder()
                .add(new ThoughtWorker())
                .add(new ThoughtWorker())
                .build();

        twerStream = twers.stream();
    }

    @Test
    public void filterDemo() throws Exception {

        Predicate<ThoughtWorker> canGetAwardFromApax = twer -> twer.yearsInTW > 4;

        Optional<ThoughtWorker> optionalTwer = twers.stream()
                .filter(canGetAwardFromApax)
                .findAny();

        boolean isPresent = optionalTwer.isPresent();
        ThoughtWorker twer = optionalTwer.orElse(new ThoughtWorker());
//        ThoughtWorker twer = optionalTwer.get();
//        ThoughtWorker twer = optionalTwer.orElseThrow(RuntimeException::new);
//        ThoughtWorker twer = optionalTwer.orElseGet(() -> new ThoughtWorker());
        optionalTwer.ifPresent(System.out::println);

    }

    @Test
    public void mapDemo() throws Exception {

        Function<ThoughtWorker, String> getRegion = thoughtWorker -> thoughtWorker.region;

        List<String> regions = twers.stream()
                .map(getRegion)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(regions);

    }

    @Test
    public void reduceDemo() throws Exception {

        Integer sumAge = twers.stream()
                .map(twer -> twer.age)
                .reduce((age1, age2) -> age1 + age2)
                .orElse(0);

        System.out.println(sumAge);

    }

    @Test
    public void sortDemo() throws Exception {

        twers.stream()
                .sorted()
//                .sorted(Comparator.comparing(ThoughtWorker::getAge).reversed())
//                .sorted(ThoughtWorker::compareTo)
                .map(twer -> twer.name)
                .forEach(System.out::println);

    }
}
