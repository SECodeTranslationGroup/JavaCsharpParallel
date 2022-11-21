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

public class AverageMethods {
    //original:4 target:40
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }
    //average syntax : 5

    public double numbersAverage() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        double averageNum = Arrays.stream(numbers).average().getAsDouble();
        return averageNum;
    }

    public double bigNumbersAverage() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        double averageNum = Arrays.stream(numbers).filter(n -> n >= 5).average().getAsDouble();
        return averageNum;
    }

    public double oddNumbersAverage() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        double averageNum = Arrays.stream(numbers).filter(n -> n % 2 == 0).average().getAsDouble();
        return averageNum;
    }

    public double doubleAverage() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        double averageNum = Arrays.stream(numbers).average().getAsDouble();
        return averageNum;
    }

    public double bigDoubleNumbersAverage() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        double averageNum = Arrays.stream(numbers).filter(n -> n >= 5).average().getAsDouble();
        return averageNum;
    }


    //average projection: 15

    public double numbersAverageTwice() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        double averageNum = Arrays.stream(numbers).map(n -> n * 2).average().getAsDouble();
        return averageNum;
    }

    public double bigNumbersAverageTwice() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        double averageNum = Arrays.stream(numbers).filter(n -> n >= 5).map(n -> n * 2).average().getAsDouble();
        return averageNum;
    }

    public double oddNumbersAverageTwice() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        double averageNum = Arrays.stream(numbers).filter(n -> n % 2 == 0).map(n -> n * 2).average().getAsDouble();
        return averageNum;
    }

    public double stringAverageLength() {
        String[] words = {"cherry", "apple", "blueberry"};
        double averageLength = Arrays.stream(words).mapToInt(w -> w.length()).average().getAsDouble();
        return averageLength;
    }

    public double shortStringAverageLength() {
        String[] words = {"cherry", "apple", "blueberry"};
        double averageLength = Arrays.stream(words).filter(w -> w.length() < 7).mapToInt(w -> w.length()).average().getAsDouble();
        return averageLength;
    }

    public double productUnitPriceAverage() {
        List<Product> products = getProductList();
        double averageUnitPrice = products.stream().mapToDouble(p -> p.getUnitPrice()).average().getAsDouble();
        return averageUnitPrice;
    }

    public double expensiveProductUnitPriceAverage() {
        List<Product> products = getProductList();
        double averageUnitPrice = products.stream().filter(p -> p.getUnitPrice() > 100)
                .mapToDouble(p -> p.getUnitPrice()).average().getAsDouble();
        return averageUnitPrice;
    }

    public double expensiveProductStockAverage() {
        List<Product> products = getProductList();
        double averageUnitPrice = products.stream().filter(p -> p.getUnitPrice() > 100)
                .mapToInt(p -> p.getUnitsInStock()).average().getAsDouble();
        return averageUnitPrice;
    }

    public double productLongNameLengthAverage() {
        List<Product> products = getProductList();
        double averageUnitPrice = products.stream().map(p -> p.getProductName())
                .filter(name -> name.length() > 7).mapToInt(name -> name.length()).average().getAsDouble();
        return averageUnitPrice;
    }

    public List<Pair<String, Double>> customerOrdersTotalAverage() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersTotalAverage = customers.stream().map(c -> Pair.with(c.getCustomerId(),
                c.getOrders().stream().mapToDouble(o -> o.getTotal()).average().getAsDouble())).toList();
        return ordersTotalAverage;
    }

    public Map<String, Double> customerOrdersTotalAverageDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersTotalAverage = customers.stream().collect(toMap(c -> c.getCustomerId(),
                c -> c.getOrders().stream().mapToDouble(o -> o.getTotal()).average().getAsDouble()));
        return ordersTotalAverage;
    }

    public List<Pair<String, Double>> customerInRegionOrdersTotalAverage(String region) {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersTotalAverage = customers.stream().filter(c -> c.getRegion().equals(region))
                .map(c -> Pair.with(c.getCustomerId(),
                        c.getOrders().stream().mapToDouble(o -> o.getTotal()).average().getAsDouble())).toList();
        return ordersTotalAverage;
    }

    public Map<String, Double> customerInRegionOrdersTotalAverageDict(String region) {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersTotalAverage = customers.stream().filter(c -> c.getRegion().equals(region))
                .collect(toMap(c -> c.getCustomerId(),
                        c -> c.getOrders().stream().mapToDouble(o -> o.getTotal()).average().getAsDouble()));
        return ordersTotalAverage;
    }

    public List<Pair<String, Double>> customerExpensiveOrdersTotalAverage() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersTotalAverage = customers.stream().map(c -> Pair.with(c.getCustomerId(),
                c.getOrders().stream().filter(o -> o.getTotal() > 100)
                        .mapToDouble(o -> o.getTotal()).average().getAsDouble())).toList();
        return ordersTotalAverage;
    }

    public Map<String, Double> customerExpensiveOrdersTotalAverageDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersTotalAverage = customers.stream().collect(toMap(c -> c.getCustomerId(),
                c -> c.getOrders().stream().filter(o -> o.getTotal() > 100)
                        .mapToDouble(o -> o.getTotal()).average().getAsDouble()));
        return ordersTotalAverage;
    }

    //average grouped: 10

    public List<Pair<String, Double>> productEachCategoryStock() {
        List<Product> products = getProductList();
        List<Pair<String, Double>> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().mapToInt(p -> p.getUnitsInStock()).average().getAsDouble())).toList();
        return categories;
    }

    public Map<String, Double> productEachCategoryStockDict() {
        List<Product> products = getProductList();
        Map<String, Double> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().mapToInt(p -> p.getUnitsInStock()).average().getAsDouble()));
        return categories;
    }

    public List<Pair<String, Double>> expensiveProductEachCategoryStock() {
        List<Product> products = getProductList();
        List<Pair<String, Double>> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().filter(
                        p -> p.getUnitPrice() > 100).mapToInt(p -> p.getUnitsInStock()).average().getAsDouble())).toList();
        return categories;
    }

    public Map<String, Double> expensiveProductEachCategoryStockDict() {
        List<Product> products = getProductList();
        Map<String, Double> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().filter(
                        p -> p.getUnitPrice() > 100).mapToInt(p -> p.getUnitsInStock()).average().getAsDouble()));
        return categories;
    }

    public List<Pair<String, Double>> customerEachRegionOrdersAverage() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersAverage = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().mapToInt(c -> c.getOrders().size()).average().getAsDouble())).toList();
        return ordersAverage;
    }

    public Map<String, Double> customerEachRegionOrdersAverageDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersAverage = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().mapToInt(c -> c.getOrders().size()).average().getAsDouble()));
        return ordersAverage;
    }

    public List<Pair<String, Double>> customerEachCountryOrdersAverage() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersAverage = customers.stream().collect(groupingBy(c -> c.getCountry()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().mapToInt(c -> c.getOrders().size()).average().getAsDouble())).toList();
        return ordersAverage;
    }

    public Map<String, Double> customerEachCountryOrdersAverageDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersAverage = customers.stream().collect(groupingBy(c -> c.getCountry()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().mapToInt(c -> c.getOrders().size()).average().getAsDouble()));
        return ordersAverage;
    }

    public List<Pair<String, Double>> customerEachRegionOrdersTotalAverage() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersTotalAverage = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().flatMap(c ->
                        c.getOrders().stream()).mapToDouble(o -> o.getTotal()).average().getAsDouble())).toList();
        return ordersTotalAverage;
    }

    public Map<String, Double> customerEachRegionOrdersTotalAverageDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersTotalAverage = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().flatMap(c ->
                        c.getOrders().stream()).mapToDouble(o -> o.getTotal()).average().getAsDouble()));
        return ordersTotalAverage;
    }
}
