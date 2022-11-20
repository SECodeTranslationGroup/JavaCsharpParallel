package parallel.linq101.mylinq;

import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Product;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class QueryExecutionMethods {
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public void numbersDeferred() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        AtomicInteger i = new AtomicInteger(0);
        var q = Arrays.stream(numbers).map(n -> i.addAndGet(n));
        q.forEach(v -> System.out.println(v + " " + i));
    }

    public void bigNumbersDeferred() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        AtomicInteger i = new AtomicInteger(0);
        var q = Arrays.stream(numbers).filter(n->n>5).map(n -> i.addAndGet(n));
        q.forEach(v -> System.out.println(v + " " + i));
    }

    public void oddNumbersDeferred() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        AtomicInteger i = new AtomicInteger(0);
        var q = Arrays.stream(numbers).filter(n->n%2==1).map(n -> i.addAndGet(n));
        q.forEach(v -> System.out.println(v + " " + i));
    }

    public void doubleDeferred() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        AtomicReference<Double> d = new AtomicReference<>(0.0);
        var q = Arrays.stream(numbers).map(n -> d.accumulateAndGet(n, Double::sum));
        q.forEach(v -> System.out.println(v + " " + d));
    }

    public void bigDoubleNumbersDeferred() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        AtomicReference<Double> d = new AtomicReference<>(0.0);
        var q = Arrays.stream(numbers).filter(n->n>5).map(n -> d.accumulateAndGet(n, Double::sum));
        q.forEach(v -> System.out.println(v + " " + d));
    }

    public void numbersTwiceDeferred() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        AtomicInteger i = new AtomicInteger(0);
        var q = Arrays.stream(numbers).map(n->n*2).map(n -> i.addAndGet(n));
        q.forEach(v -> System.out.println(v + " " + i));
    }

    public void bigNumbersTwiceDeferred() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        AtomicInteger i = new AtomicInteger(0);
        var q = Arrays.stream(numbers).filter(n->n>5).map(n->n*2).map(n -> i.addAndGet(n));
        q.forEach(v -> System.out.println(v + " " + i));
    }

    public void oddNumbersTwiceDeferred() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        AtomicInteger i = new AtomicInteger(0);
        var q = Arrays.stream(numbers).filter(n->n%2==1).map(n->n*2).map(n -> i.addAndGet(n));
        q.forEach(v -> System.out.println(v + " " + i));
    }

    public void stringLengthDeferred() {
        String[] words = {"cherry", "apple", "blueberry"};
        AtomicInteger i = new AtomicInteger(0);
        var q = Arrays.stream(words).map(w -> w.length()).map(n -> i.addAndGet(n));
        q.forEach(v -> System.out.println(v + " " + i));
    }

    public void shortStringLengthDeferred() {
        String[] words = {"cherry", "apple", "blueberry"};
        AtomicInteger i = new AtomicInteger(0);
        var q = Arrays.stream(words).filter(w->w.length()<7).map(w -> w.length()).map(n -> i.addAndGet(n));
        q.forEach(v -> System.out.println(v + " " + i));
    }

    public void numbersEager() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        AtomicInteger i = new AtomicInteger(0);
        var q = Arrays.stream(numbers).map(n -> i.addAndGet(n)).boxed().toList();
        for (var v : q)
           System.out.println(v + " " + i);
    }

    public void bigNumbersEager() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        AtomicInteger i = new AtomicInteger(0);
        var q = Arrays.stream(numbers).filter(n->n>5).map(n -> i.addAndGet(n)).boxed().toList();
        for (var v : q)
           System.out.println(v + " " + i);
    }

    public void oddNumbersEager() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        AtomicInteger i = new AtomicInteger(0);
        var q = Arrays.stream(numbers).filter(n->n%2==1).map(n -> i.addAndGet(n)).boxed().toList();
        for (var v : q)
           System.out.println(v + " " + i);
    }

    public void doubleEager() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        AtomicReference<Double> d = new AtomicReference<>(0.0);
        var q = Arrays.stream(numbers).map(n -> d.accumulateAndGet(n, Double::sum)).boxed().toList();
        for (var v : q)
            System.out.println(v + " " + d);
    }

    public void bigDoubleNumbersEager() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        AtomicReference<Double> d = new AtomicReference<>(0.0);
        var q = Arrays.stream(numbers).filter(n->n>5).map(n -> d.accumulateAndGet(n, Double::sum)).boxed().toList();
        for (var v : q)
            System.out.println(v + " " + d);
    }

    public void numbersTwiceEager() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        AtomicInteger i = new AtomicInteger(0);
        var q = Arrays.stream(numbers).map(n->n*2).map(n -> i.addAndGet(n)).boxed().toList();
        for (var v : q)
           System.out.println(v + " " + i);
    }

    public void bigNumbersTwiceEager() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        AtomicInteger i = new AtomicInteger(0);
        var q = Arrays.stream(numbers).filter(n->n>5).map(n->n*2).map(n -> i.addAndGet(n)).boxed().toList();
        for (var v : q)
           System.out.println(v + " " + i);
    }

    public void oddNumbersTwiceEager() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        AtomicInteger i = new AtomicInteger(0);
        var q = Arrays.stream(numbers).filter(n->n%2==1).map(n->n*2).map(n -> i.addAndGet(n)).boxed().toList();
        for (var v : q)
           System.out.println(v + " " + i);
    }

    public void stringLengthEager() {
        String[] words = {"cherry", "apple", "blueberry"};
        AtomicInteger i = new AtomicInteger(0);
        var q = Arrays.stream(words).map(w -> w.length()).map(n -> i.addAndGet(n)).toList();
        for (var v : q)
           System.out.println(v + " " + i);
    }

    public void shortStringLengthEager() {
        String[] words = {"cherry", "apple", "blueberry"};
        AtomicInteger i = new AtomicInteger(0);
        var q = Arrays.stream(words).filter(w->w.length()<7).map(w -> w.length()).map(n -> i.addAndGet(n)).toList();
        for (var v : q)
           System.out.println(v + " " + i);
    }
}
