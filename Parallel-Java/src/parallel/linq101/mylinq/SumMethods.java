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

    public int numbersSum() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int numbersSum = Arrays.stream(numbers).sum();
        return numbersSum;
    }

    public int bigNumbersSum() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int numbersSum = Arrays.stream(numbers).filter(n -> n >= 5).sum();
        return numbersSum;
    }

    public int oddNumbersSum() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int numbersSum = Arrays.stream(numbers).filter(n -> n % 2 == 0).sum();
        return numbersSum;
    }

    public double doubleSum() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        double numbersSum = Arrays.stream(numbers).sum();
        return numbersSum;
    }

    public double bigDoubleNumbersSum() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        double numbersSum = Arrays.stream(numbers).filter(n -> n >= 5).sum();
        return numbersSum;
    }


    //sum projection: 15

    public int numbersSumTwice() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int numbersSum = Arrays.stream(numbers).map(n -> n * 2).sum();
        return numbersSum;
    }

    public int bigNumbersSumTwice() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int numbersSum = Arrays.stream(numbers).filter(n -> n >= 5).map(n -> n * 2).sum();
        return numbersSum;
    }

    public int oddNumbersSumTwice() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int numbersSum = Arrays.stream(numbers).filter(n -> n % 2 == 0).map(n -> n * 2).sum();
        return numbersSum;
    }

    public int stringSumLength() {
        String[] words = {"cherry", "apple", "blueberry"};
        int totalChars = Arrays.stream(words).mapToInt(w -> w.length()).sum();
        return totalChars;
    }

    public int shortStringSumLength() {
        String[] words = {"cherry", "apple", "blueberry"};
        int totalChars = Arrays.stream(words).filter(w -> w.length() < 7).mapToInt(w -> w.length()).sum();
        return totalChars;
    }

    public double productUnitPriceSum() {
        List<Product> products = getProductList();
        double totalSum = products.stream().mapToDouble(p -> p.getUnitPrice()).sum();
        return totalSum;
    }

    public double expensiveProductUnitPriceSum() {
        List<Product> products = getProductList();
        double totalSum = products.stream().filter(p -> p.getUnitPrice() > 100)
                .mapToDouble(p -> p.getUnitPrice()).sum();
        return totalSum;
    }

    public int expensiveProductStockSum() {
        List<Product> products = getProductList();
        int totalSum = products.stream().filter(p -> p.getUnitPrice() > 100)
                .mapToInt(p -> p.getUnitsInStock()).sum();
        return totalSum;
    }

    public int productLongNameLengthSum() {
        List<Product> products = getProductList();
        int totalSum = products.stream().map(p -> p.getProductName())
                .filter(name -> name.length() > 7).mapToInt(name -> name.length()).sum();
        return totalSum;
    }

    public List<Pair<String, Double>> customerOrdersTotalSum() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersTotalSum = customers.stream().map(c -> Pair.with(c.getCustomerId(),
                c.getOrders().stream().mapToDouble(o -> o.getTotal()).sum())).toList();
        return ordersTotalSum;
    }

    public Map<String, Double> customerOrdersTotalSumDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersTotalSum = customers.stream().collect(toMap(c -> c.getCustomerId(),
                c -> c.getOrders().stream().mapToDouble(o -> o.getTotal()).sum()));
        return ordersTotalSum;
    }

    public List<Pair<String, Double>> customerInRegionOrdersTotalSum(String region) {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersTotalSum = customers.stream().filter(c -> c.getRegion().equals(region))
                .map(c -> Pair.with(c.getCustomerId(),
                        c.getOrders().stream().mapToDouble(o -> o.getTotal()).sum())).toList();
        return ordersTotalSum;
    }

    public Map<String, Double> customerInRegionOrdersTotalSumDict(String region) {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersTotalSum = customers.stream().filter(c -> c.getRegion().equals(region))
                .collect(toMap(c -> c.getCustomerId(),
                        c -> c.getOrders().stream().mapToDouble(o -> o.getTotal()).sum()));
        return ordersTotalSum;
    }

    public List<Pair<String, Double>> customerExpensiveOrdersTotalSum() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersTotalSum = customers.stream().map(c -> Pair.with(c.getCustomerId(),
                c.getOrders().stream().filter(o -> o.getTotal() > 100)
                        .mapToDouble(o -> o.getTotal()).sum())).toList();
        return ordersTotalSum;
    }

    public Map<String, Double> customerExpensiveOrdersTotalSumDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersTotalSum = customers.stream().collect(toMap(c -> c.getCustomerId(),
                c -> c.getOrders().stream().filter(o -> o.getTotal() > 100)
                        .mapToDouble(o -> o.getTotal()).sum()));
        return ordersTotalSum;
    }

    //sum grouped: 10

    public List<Pair<String, Integer>> productEachCategoryStock() {
        List<Product> products = getProductList();
        List<Pair<String, Integer>> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().mapToInt(p -> p.getUnitsInStock()).sum())).toList();
        return categories;
    }

    public Map<String, Integer> productEachCategoryStockDict() {
        List<Product> products = getProductList();
        Map<String, Integer> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().mapToInt(p -> p.getUnitsInStock()).sum()));
        return categories;
    }

    public List<Pair<String, Integer>> expensiveProductEachCategoryStock() {
        List<Product> products = getProductList();
        List<Pair<String, Integer>> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().filter(
                        p -> p.getUnitPrice() > 100).mapToInt(p -> p.getUnitsInStock()).sum())).toList();
        return categories;
    }

    public Map<String, Integer> expensiveProductEachCategoryStockDict() {
        List<Product> products = getProductList();
        Map<String, Integer> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().filter(
                        p -> p.getUnitPrice() > 100).mapToInt(p -> p.getUnitsInStock()).sum()));
        return categories;
    }

    public List<Pair<String, Integer>> customerEachRegionOrdersSum() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Integer>> ordersSum = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().mapToInt(c -> c.getOrders().size()).sum())).toList();
        return ordersSum;
    }

    public Map<String, Integer> customerEachRegionOrdersSumDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Integer> ordersSum = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().mapToInt(c -> c.getOrders().size()).sum()));
        return ordersSum;
    }

    public List<Pair<String, Integer>> customerEachCountryOrdersSum() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Integer>> ordersSum = customers.stream().collect(groupingBy(c -> c.getCountry()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().mapToInt(c -> c.getOrders().size()).sum())).toList();
        return ordersSum;
    }

    public Map<String, Integer> customerEachCountryOrdersSumDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Integer> ordersSum = customers.stream().collect(groupingBy(c -> c.getCountry()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().mapToInt(c -> c.getOrders().size()).sum()));
        return ordersSum;
    }

    public List<Pair<String, Double>> customerEachRegionOrdersTotalSum() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersTotalSum = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().flatMap(c ->
                        c.getOrders().stream()).mapToDouble(o -> o.getTotal()).sum())).toList();
        return ordersTotalSum;
    }

    public Map<String, Double> customerEachRegionOrdersTotalSumDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersTotalSum = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().flatMap(c ->
                        c.getOrders().stream()).mapToDouble(o -> o.getTotal()).sum()));
        return ordersTotalSum;
    }
}
