package parallel.linq101;

import org.javatuples.Pair;
import org.javatuples.Triplet;
import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Partitions {
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public int takeSyntax() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};

        var first3Numbers = Arrays.stream(numbers).limit(3).toArray();

        System.out.println("First 3 numbers:");
        for (var n : first3Numbers)
            System.out.println(n);
        return 0;
    }

    public int nestedTake() {
        List<Customer> customers = getCustomerList();

        var first3WAOrders = customers.stream().filter(c -> c.getRegion() == "WA").flatMap(
                        c -> c.getOrders().stream().map(o -> Triplet.with(c.getCustomerId(), o.getOrderId(), o.getOrderDate()))).
                limit(3).collect(Collectors.toList());

        System.out.println("First 3 orders in WA:");
        for (var order : first3WAOrders)
            System.out.println(order);
        return 0;
    }

    public int skipSyntax() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};

        var allButFirst4Numbers = Arrays.stream(numbers).skip(4).toArray();

        System.out.println("All but first 4 numbers:");
        for (var n : allButFirst4Numbers)
            System.out.println(n);

        return 0;
    }

    public int nestedSkip() {
        List<Customer> customers = getCustomerList();

        var allButFirst2Orders = customers.stream().filter(c -> c.getRegion() == "WA").flatMap(
                        c -> c.getOrders().stream().map(o -> Triplet.with(c.getCustomerId(), o.getOrderId(), o.getOrderDate()))).
                skip(2).collect(Collectors.toList());

        System.out.println("All but first 2 orders in WA:");
        for (var order : allButFirst2Orders)
            System.out.println(order);
        return 1;
    }

    public int takeWhileSyntax() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};

        var firstNumbersLessThan6 = Arrays.stream(numbers).takeWhile(n -> n < 6).toArray();

        System.out.println("First numbers less than 6:");
        for (var num : firstNumbersLessThan6)
            System.out.println(num);

        return 0;
    }

    public int indexedTakeWhile() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};

        var firstSmallNumbers = IntStream.range(0, numbers.length).takeWhile(index -> numbers[index] > index)
                .map(i -> numbers[i]).toArray();

        System.out.println("First numbers not less than their position:");
        for (var n : firstSmallNumbers)
            System.out.println(n);

        return 0;
    }

    public int skipWhileSyntax() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};

        var allButFirst3Numbers = Arrays.stream(numbers).dropWhile(n -> n % 3 != 0).toArray();

        System.out.println("All elements starting from first element divisible by 3:");
        for (var n : allButFirst3Numbers)
            System.out.println(n);
        return 0;
    }

    public int IndexedSkipWhile() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};

        var laterNumbers = IntStream.range(0, numbers.length).dropWhile(index -> numbers[index] >= index)
                .map(i -> numbers[i]).toArray();

        System.out.println("All elements starting from first element less than its position:");
        for (var n : laterNumbers)
            System.out.println(n);
        return 0;
    }
}
