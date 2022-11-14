package parallel.linq101;

import org.javatuples.Pair;
import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Product;

import java.util.*;
import java.util.stream.Collectors;

public class AggregateOperators {
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public int countSyntax() {
        int[] factorsOf300 = {2, 2, 3, 5, 5};
        int uniqueFactors = (int) Arrays.stream(factorsOf300).distinct().count();
        System.out.println("There are " + uniqueFactors + " unique factors of 300.");
        return 0;
    }

    public int countConditional() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int oddNumbers = (int) Arrays.stream(numbers).filter(n -> n % 2 == 1).count();
        System.out.println("There are " + oddNumbers + " odd numbers in the list.");
        return 0;
    }

    public int nestedCount() {
        List<Customer> customers = getCustomerList();
        var orderCounts = customers.stream().map(c ->
                Pair.with(c.getCustomerId(), c.getOrders().size())).collect(Collectors.toList());
        for (var customer : orderCounts)
            System.out.println("ID: " + customer.getValue0() + ", count: " + customer.getValue1());
        return 0;
    }

    public int groupedCount() {
        List<Product> products = getProductList();
        var categoryCounts = products.stream().collect(Collectors.groupingBy(
                        p -> p.getCategory())).entrySet().stream().map(e -> Pair.with(e.getKey(), e.getValue().size()))
                .collect(Collectors.toList());
        for (var c : categoryCounts)
            System.out.println("Category: " + c.getValue0() + ": Product count: " + c.getValue1());
        return 0;
    }

    public int sumSyntax() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int numSum = Arrays.stream(numbers).sum();
        System.out.println("The sum of the numbers is " + numSum);
        return 0;
    }

    public int sumProjection() {
        String[] words = {"cherry", "apple", "blueberry"};
        int totalChars = Arrays.stream(words).mapToInt(w -> w.length()).sum();
        System.out.println("There are a total of " + totalChars + " characters in these words.");
        return 0;
    }

    public int sumGrouped() {
        List<Product> products = getProductList();
        var categories = products.stream().collect(Collectors.groupingBy(
                        p -> p.getCategory())).entrySet().stream().map(e -> Pair.with(e.getKey(),
                        e.getValue().stream().mapToInt(p -> p.getUnitsInStock()).sum()))
                .collect(Collectors.toList());
        for (var pair : categories)
            System.out.println("Category: " + pair.getValue0() + ", Units in stock: " + pair.getValue1());
        return 0;
    }

    public int minSyntax() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int minNum = Arrays.stream(numbers).min().getAsInt();
        System.out.println("The minimum number is " + minNum);
        return 0;
    }

    public int minProjection() {
        String[] words = {"cherry", "apple", "blueberry"};
        int shortestWord = Arrays.stream(words).mapToInt(w -> w.length()).min().getAsInt();
        System.out.println("The shortest word is " + shortestWord + " characters long.");
        return 0;
    }

    public int minGrouped() {
        List<Product> products = getProductList();
        var categories = products.stream().collect(Collectors.groupingBy(
                        p -> p.getCategory())).entrySet().stream().map(e -> Pair.with(e.getKey(),
                        e.getValue().stream().mapToDouble(p -> p.getUnitPrice()).min().getAsDouble()))
                .collect(Collectors.toList());
        for (var c : categories)
            System.out.println("Category: " + c.getValue0() + ", Lowest price: " + c.getValue1());
        return 0;
    }

    public int minEachGroup() {
        List<Product> products = getProductList();
        var categories = products.stream().collect(Collectors.groupingBy(
                p -> p.getCategory())).entrySet().stream().map(e -> Pair.with(e.getKey(),
                e.getValue().stream().filter(p -> p.getUnitPrice() == e.getValue()
                                .stream().mapToDouble(p1 -> p1.getUnitPrice()).min().getAsDouble())
                        .toList())).collect(Collectors.toList());
        for (var c : categories) {
            System.out.println("Category: " + c.getValue0());
            for (var p : c.getValue1())
                System.out.println("\tProduct: " + p);
        }
        return 0;
    }

    public int MaxSyntax() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int maxNum = Arrays.stream(numbers).max().getAsInt();
        System.out.println("The maximum number is "+maxNum);
        return 0;
    }

    public int maxProjection() {
        String[] words = {"cherry", "apple", "blueberry"};
        int longestLength = Arrays.stream(words).mapToInt(w->w.length()).max().getAsInt();
        System.out.println("The longest word is "+longestLength+" characters long.");
        return 0;
    }

    public int maxGrouped() {
        List<Product> products = getProductList();
        var categories = products.stream().collect(Collectors.groupingBy(
                        p -> p.getCategory())).entrySet().stream().map(e -> Pair.with(e.getKey(),
                        e.getValue().stream().mapToDouble(p -> p.getUnitPrice()).max().getAsDouble()))
                .collect(Collectors.toList());
        for (var c : categories)
        System.out.println("Category: "+c.getValue0()+" Most expensive product: "+c.getValue1());
        return 0;
    }

    public int maxEachGroup() {
        List<Product> products = getProductList();
        var categories = products.stream().collect(Collectors.groupingBy(
                p -> p.getCategory())).entrySet().stream().map(e -> Pair.with(e.getKey(),
                e.getValue().stream().filter(p -> p.getUnitPrice() == e.getValue()
                                .stream().mapToDouble(p1 -> p1.getUnitPrice()).max().getAsDouble())
                        .toList())).collect(Collectors.toList());
        for(var c : categories) {
            System.out.println("Category: "+c.getValue0());
            for(var p : c.getValue1())
                System.out.println("\t"+p);
        }
        return 0;
    }

    public int averageSyntax() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        double averageNum = Arrays.stream(numbers).average().getAsDouble();
        System.out.println("The average number is "+averageNum+".");
        return 0;
    }

    public int averageProjection() {
        String[] words = {"cherry", "apple", "blueberry"};
        double averageLength = Arrays.stream(words).mapToInt(w -> w.length()).average().getAsDouble();
        System.out.println("The average word length is "+averageLength+" characters.");
        return 0;
    }

    public int averageGrouped() {
        List<Product> products = getProductList();
        var categories = products.stream().collect(Collectors.groupingBy(
                        p -> p.getCategory())).entrySet().stream().map(e -> Pair.with(e.getKey(),
                        e.getValue().stream().mapToDouble(p -> p.getUnitPrice()).average().getAsDouble()))
                .collect(Collectors.toList());
        for(var c : categories)
            System.out.println("Category: "+c.getValue0()+" Average price: "+c.getValue1());
        return 0;
    }

    public int aggregateSyntax() {
        double[] doubles = {1.7, 2.3, 1.9, 4.1, 2.9};
        double product = Arrays.stream(doubles).reduce((runningProduct, nextFactor)
                ->runningProduct * nextFactor).getAsDouble();
        System.out.println("Total product of all numbers: "+product);
        return 0;
    }

    public int seededAggregate() {
        int startBalance = 100;
        int[] attemptedWithdrawals = {20, 10, 40, 50, 10, 70, 30};
        int endBalance = Arrays.stream(attemptedWithdrawals).reduce(startBalance,(balance, nextWithdrawal) ->
        ((nextWithdrawal <= balance) ? (balance - nextWithdrawal) : balance));
        System.out.println("Ending balance: "+endBalance);
        return 0;
    }
}
