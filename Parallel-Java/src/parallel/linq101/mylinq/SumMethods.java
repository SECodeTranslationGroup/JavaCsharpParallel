package parallel.linq101.mylinq;

import org.javatuples.Pair;
import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Order;
import parallel.linq101.datasource.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class SumMethods {
    //original:4 target:40
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }
    //sum syntax : 5

    public int NumbersSum() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int numbersSum = Arrays.stream(numbers).sum();
        return numbersSum;
    }

    public int BigNumbersSum() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int numbersSum = Arrays.stream(numbers).filter(n -> n >= 5).sum();
        return numbersSum;
    }

    public int OddNumbersSum() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int numbersSum = Arrays.stream(numbers).filter(n -> n % 2 == 0).sum();
        return numbersSum;
    }

    public double DoubleSum() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        double numbersSum = Arrays.stream(numbers).sum();
        return numbersSum;
    }

    public double BigDoubleNumbersSum() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        double numbersSum = Arrays.stream(numbers).filter(n -> n >= 5).sum();
        return numbersSum;
    }


    //sum projection: 15

    public int NumbersSumTwice() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int numbersSum = Arrays.stream(numbers).map(n -> n * 2).sum();
        return numbersSum;
    }

    public int BigNumbersSumTwice() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int numbersSum = Arrays.stream(numbers).filter(n -> n >= 5).map(n -> n * 2).sum();
        return numbersSum;
    }

    public int OddNumbersSumTwice() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int numbersSum = Arrays.stream(numbers).filter(n -> n % 2 == 0).map(n -> n * 2).sum();
        return numbersSum;
    }

    public int StringSumLength() {
        String[] words = {"cherry", "apple", "blueberry"};
        int totalChars = Arrays.stream(words).mapToInt(w -> w.length()).sum();
        return totalChars;
    }

    public int ShortStringSumLength() {
        String[] words = {"cherry", "apple", "blueberry"};
        int totalChars = Arrays.stream(words).filter(w -> w.length() < 7).mapToInt(w -> w.length()).sum();
        return totalChars;
    }

    public double ProductUnitPriceSum() {
        List<Product> products = getProductList();
        double totalSum = products.stream().mapToDouble(p -> p.getUnitPrice()).sum();
        return totalSum;
    }

    public double ExpensiveProductUnitPriceSum() {
        List<Product> products = getProductList();
        double totalSum = products.stream().filter(p -> p.getUnitPrice() > 100)
                .mapToDouble(p -> p.getUnitPrice()).sum();
        return totalSum;
    }

    public int ExpensiveProductStockSum() {
        List<Product> products = getProductList();
        int totalSum = products.stream().filter(p -> p.getUnitPrice() > 100)
                .mapToInt(p -> p.getUnitsInStock()).sum();
        return totalSum;
    }

    public int ProductLongNameLengthSum() {
        List<Product> products = getProductList();
        int totalSum = products.stream().map(p -> p.getProductName())
                .filter(name -> name.length() > 7).mapToInt(name -> name.length()).sum();
        return totalSum;
    }

    public List<Pair<String, Double>> CustomerOrdersTotalSum() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersTotalSum = customers.stream().map(c -> Pair.with(c.getCustomerId(),
                c.getOrders().stream().mapToDouble(o -> o.getTotal()).sum())).toList();
        return ordersTotalSum;
    }

    public Map<String, Double> CustomerOrdersTotalSumDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersTotalSum = customers.stream().collect(toMap(c -> c.getCustomerId(),
                c -> c.getOrders().stream().mapToDouble(o -> o.getTotal()).sum()));
        return ordersTotalSum;
    }

    public List<Pair<String, Double>> CustomerInRegionOrdersTotalSum(String region) {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersTotalSum = customers.stream().filter(c -> c.getRegion().equals(region))
                .map(c -> Pair.with(c.getCustomerId(),
                        c.getOrders().stream().mapToDouble(o -> o.getTotal()).sum())).toList();
        return ordersTotalSum;
    }

    public Map<String, Double> CustomerInRegionOrdersTotalSumDict(String region) {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersTotalSum = customers.stream().filter(c -> c.getRegion().equals(region))
                .collect(toMap(c -> c.getCustomerId(),
                        c -> c.getOrders().stream().mapToDouble(o -> o.getTotal()).sum()));
        return ordersTotalSum;
    }

    public List<Pair<String, Double>> CustomerExpensiveOrdersTotalSum() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersTotalSum = customers.stream().map(c -> Pair.with(c.getCustomerId(),
                c.getOrders().stream().filter(o -> o.getTotal() > 100)
                        .mapToDouble(o -> o.getTotal()).sum())).toList();
        return ordersTotalSum;
    }

    public Map<String, Double> CustomerExpensiveOrdersTotalSumDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersTotalSum = customers.stream().collect(toMap(c -> c.getCustomerId(),
                c -> c.getOrders().stream().filter(o -> o.getTotal() > 100)
                        .mapToDouble(o -> o.getTotal()).sum()));
        return ordersTotalSum;
    }

    //sum grouped: 10

    public List<Pair<String, Integer>> ProductEachCategoryStock() {
        List<Product> products = getProductList();
        List<Pair<String, Integer>> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().mapToInt(p -> p.getUnitsInStock()).sum())).toList();
        return categories;
    }

    public Map<String, Integer> ProductEachCategoryStockDict() {
        List<Product> products = getProductList();
        Map<String, Integer> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().mapToInt(p -> p.getUnitsInStock()).sum()));
        return categories;
    }

    public List<Pair<String, Integer>> ExpensiveProductEachCategoryStock() {
        List<Product> products = getProductList();
        List<Pair<String, Integer>> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().filter(
                        p -> p.getUnitPrice() > 100).mapToInt(p -> p.getUnitsInStock()).sum())).toList();
        return categories;
    }

    public Map<String, Integer> ExpensiveProductEachCategoryStockDict() {
        List<Product> products = getProductList();
        Map<String, Integer> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().filter(
                        p -> p.getUnitPrice() > 100).mapToInt(p -> p.getUnitsInStock()).sum()));
        return categories;
    }

    public List<Pair<String, Integer>> CustomerEachRegionOrdersSum() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Integer>> ordersSum = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().mapToInt(c -> c.getOrders().size()).sum())).toList();
        return ordersSum;
    }

    public Map<String, Integer> CustomerEachRegionOrdersSumDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Integer> ordersSum = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().mapToInt(c -> c.getOrders().size()).sum()));
        return ordersSum;
    }

    public List<Pair<String, Integer>> CustomerEachCountryOrdersSum() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Integer>> ordersSum = customers.stream().collect(groupingBy(c -> c.getCountry()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().mapToInt(c -> c.getOrders().size()).sum())).toList();
        return ordersSum;
    }

    public Map<String, Integer> CustomerEachCountryOrdersSumDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Integer> ordersSum = customers.stream().collect(groupingBy(c -> c.getCountry()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().mapToInt(c -> c.getOrders().size()).sum()));
        return ordersSum;
    }

    public List<Pair<String, Double>> CustomerEachRegionOrdersTotalSum() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersTotalSum = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().flatMap(c ->
                        c.getOrders().stream()).mapToDouble(o -> o.getTotal()).sum())).toList();
        return ordersTotalSum;
    }

    public Map<String, Double> CustomerEachRegionOrdersTotalSumDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersTotalSum = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().flatMap(c ->
                        c.getOrders().stream()).mapToDouble(o -> o.getTotal()).sum()));
        return ordersTotalSum;
    }
}
