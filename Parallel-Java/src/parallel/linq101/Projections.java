package parallel.linq101;

import org.javatuples.Pair;
import org.javatuples.Triplet;
import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Product;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Projections {
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    interface UpperLower {
        String getLower();

        String getUpper();
    }

    interface DigitEven {
        String getDigit();

        boolean isEven();
    }

    public int selectSyntax() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        var numsPlusOne = Arrays.stream(numbers).map(n -> n + 1).toArray();
        System.out.println("Numbers + 1:");
        for (var i : numsPlusOne)
            System.out.println(i);
        return 0;
    }

    public int selectProperty() {
        List<Product> products = getProductList();
        var productNames = products.stream().map(p -> p.getProductName()).toList();
        System.out.println("Product Names:");
        for (var productName : productNames)
            System.out.println(productName);
        return 0;
    }

    public int transformWithSelect() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        var textNums = Arrays.stream(numbers).mapToObj(n -> strings[n]).toArray();
        System.out.println("Number strings:");
        for (var s : textNums)
            System.out.println(s);
        return 0;
    }

    public int selectByCaseAnonymous() {
        String[] words = {"aPPLE", "BlUeBeRrY", "cHeRry"};
        var upperLowerWords = Arrays.stream(words).map(w ->
                new UpperLower() {
                    @Override
                    public String getLower() {
                        return w.toLowerCase();
                    }

                    @Override
                    public String getUpper() {
                        return w.toUpperCase();
                    }
                }).toArray();
        for (Object ul : upperLowerWords)
            System.out.println("Uppercase: " + ((UpperLower) ul).getUpper() + ", Lowercase: " + ((UpperLower) ul).getLower());
        return 0;
    }

    public int selectByCaseTuple() {
        String[] words = {"aPPLE", "BlUeBeRrY", "cHeRry"};
        var upperLowerWords = Arrays.stream(words).map(w ->
                Pair.with(w.toUpperCase(), w.toLowerCase())).toArray();
        for (var ul : upperLowerWords)
            System.out.println("Uppercase: " + ((Pair) ul).getValue0() + ", Lowercase: " + ((Pair) ul).getValue1());
        return 0;
    }

    public int selectAnonymousConstructions() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        var digitOddEvens = Arrays.stream(numbers).mapToObj(n ->
                new DigitEven() {
                    @Override
                    public String getDigit() {
                        return strings[n];
                    }

                    @Override
                    public boolean isEven() {
                        return n % 2 == 0;
                    }
                }).toArray();
        for (var d : digitOddEvens)
            System.out.println("The digit " + ((DigitEven) d).getDigit() + " is " + (((DigitEven) d).isEven() ? "even" : "odd"));
        return 0;
    }

    public int selectTupleConstructions() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        var digitOddEvens = Arrays.stream(numbers).mapToObj(n ->
                Pair.with(strings[n], n % 2 == 0)).toArray();
        for (var d : digitOddEvens)
            System.out.println("The digit " + ((Pair) d).getValue0() + " is " + ((boolean) ((Pair) d).getValue1() ? "even" : "odd"));
        return 0;
    }

    public int selectPropertySubset() {
        List<Product> products = getProductList();
        var productInfos = products.stream().map(p ->
                        Triplet.with(p.getProductName(), p.getCategory(), p.getUnitPrice()))
                .collect(Collectors.toList());
        System.out.println("Product Info:");
        for (var productInfo : productInfos)
            System.out.println(
                    productInfo.getValue0() + " is in the category " + productInfo.getValue1() + " and costs " + productInfo.getValue2() + " per unit.");
        return 0;
    }

    public int selectWithIndex() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        var numsInPlace = IntStream.range(0, numbers.length).mapToObj(index ->
                Pair.with(numbers[index], index)).toArray();
        System.out.println("Number: In-place?");
        for (var n : numsInPlace)
            System.out.println(((Pair) n).getValue0() + ": " + ((Pair) n).getValue1());
        return 0;
    }

    public int selectWithWhere() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        var lowNums = Arrays.stream(numbers).filter(n -> n < 5).mapToObj(n -> digits[n]).toArray();
        System.out.println("Numbers < 5:");
        for (var num : lowNums)
            System.out.println(num);
        return 0;
    }

    public int selectFromMultipleSequences() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8};
        var pairs = Arrays.stream(numbersA).boxed().flatMap(a -> Arrays.stream(numbersB).filter(b -> a < b)
                .mapToObj(b -> Pair.with(a, b))).toArray();
        System.out.println("Pairs where a < b:");
        for (var pair : pairs)
            System.out.println(((Pair) pair).getValue0() + " is less than " + ((Pair) pair).getValue1());
        return 0;
    }

    public int selectFromChildSequence() {
        List<Customer> customers = getCustomerList();
        var orders = customers.stream().flatMap(c -> c.getOrders().stream().filter(o -> o.getTotal() < 500.00).
                map(o -> Triplet.with(c.getCustomerId(), o.getOrderId(), o.getTotal()))).collect(Collectors.toList());
        for (var order : orders)
            System.out.println("Customer: " + order.getValue0() + ", Order: " + order.getValue1() + ", Total value: " + order.getValue2());
        return 0;
    }

    public int selectManyWithWhere() {
        List<Customer> customers = getCustomerList();
        var orders = customers.stream().flatMap(c -> c.getOrders().stream().filter(o -> o.getOrderDate().isAfter(
                        LocalDate.of(1998, 1, 1))).
                map(o -> Triplet.with(c.getCustomerId(), o.getOrderId(), o.getTotal()))).collect(Collectors.toList());
        for (var order : orders)
            System.out.println("Customer: " + order.getValue0() + ", Order: " + order.getValue1() + ", Total value: " + order.getValue2());
        return 0;
    }

    public int selectManyWhereAssignment() {
        List<Customer> customers = getCustomerList();
        var orders = customers.stream().flatMap(c -> c.getOrders().stream().filter(o -> o.getTotal() > 2000.00).
                map(o -> Triplet.with(c.getCustomerId(), o.getOrderId(), o.getTotal()))).collect(Collectors.toList());
        for (var order : orders)
            System.out.println("Customer: " + order.getValue0() + ", Order: " + order.getValue1() + ", Total value: " + order.getValue2());
        return 0;
    }

    public int selectMultipleWhereClauses() {
        List<Customer> customers = getCustomerList();
        LocalDate cutoffDate = LocalDate.of(1997, 1, 1);
        var orders = customers.stream().filter(c -> c.getRegion() == "WA").
                flatMap(c -> c.getOrders().stream().filter(o -> o.getOrderDate().isAfter(cutoffDate)).
                        map(o -> Pair.with(c.getCustomerId(), o.getOrderId()))).collect(Collectors.toList());
        for (var order : orders)
            System.out.println("Customer: " + order.getValue0() + ", Order: " + order.getValue1());
        return 0;
    }

    public int indexedSelectMany() {
        List<Customer> customers = getCustomerList();
        var customerOrders = IntStream.range(0, customers.size()).boxed().flatMap(
                        index -> customers.get(index).getOrders().stream().map(
                                o -> "Customer #" + (index + 1) + " has an order with OrderID " + o.getOrderId()))
                .collect(Collectors.toList());
        for (var order : customerOrders)
            System.out.println(order);
        return 0;
    }
}
