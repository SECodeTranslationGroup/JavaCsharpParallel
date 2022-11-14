package parallel.linq101;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class QueryExecution {
    public int deferredExecution() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        AtomicInteger i = new AtomicInteger();
        var q = Arrays.stream(numbers).map(n -> i.incrementAndGet());
        q.forEach(v -> System.out.println("v = " + v + ", i = " + i));
        return 0;
    }

    public int eagerExecution() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        AtomicInteger i = new AtomicInteger();
        var q = Arrays.stream(numbers).map(n -> i.incrementAndGet()).toArray();
        for (var v : q)
            System.out.println("v = " + v + ", i = " + i);
        return 0;
    }

    public int reuseQueryDefinition() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        var lowNumbers = Arrays.stream(numbers).filter(n -> n <= 3);
        var lowNumbers2 = Arrays.stream(numbers).filter(n -> n <= 3);
        System.out.println("First run numbers <= 3:");
        lowNumbers.forEach(n -> System.out.println(n));
        for (int i = 0; i < 10; i++)
            numbers[i] = -numbers[i];
        System.out.println("Second run numbers <= 3:");
        lowNumbers2.forEach(n -> System.out.println(n));
        return 0;
    }
}
