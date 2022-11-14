package parallel.linq101;

import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Generators {
    public int rangeOfIntegers() {
        var numbers = IntStream.range(100, 100 + 50).boxed().
                map(n -> Pair.with(n, n % 2 == 1 ? "odd" : "even")).collect(Collectors.toList());
        for (var n : numbers)
            System.out.println("The number " + n.getValue0() + " is " + n.getValue1() + ".");
        return 0;
    }

    public int repeatNumber() {
        var numbers = new ArrayList<>(Collections.nCopies(10, 7));
        for(var n : numbers)
            System.out.println(n);
        return 0;
    }
}
