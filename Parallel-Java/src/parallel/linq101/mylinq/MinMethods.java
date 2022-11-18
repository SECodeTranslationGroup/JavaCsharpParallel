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

public class MinMethods {
    //original:4 target:40
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }
    //min syntax : 5

    public int NumbersMin() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int minNum = Arrays.stream(numbers).min().getAsInt();
        return minNum;
    }

    public int BigNumbersMin() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int minNum = Arrays.stream(numbers).filter(n -> n >= 5).min().getAsInt();
        return minNum;
    }

    public int OddNumbersMin() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int minNum = Arrays.stream(numbers).filter(n -> n % 2 == 0).min().getAsInt();
        return minNum;
    }

    public double DoubleMin() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        double minNum = Arrays.stream(numbers).min().getAsDouble();
        return minNum;
    }

    public double BigDoubleNumbersMin() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        double minNum = Arrays.stream(numbers).filter(n -> n >= 5).min().getAsDouble();
        return minNum;
    }


    //min projection: 15

    public int NumbersMinTwice() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int minNum = Arrays.stream(numbers).map(n -> n * 2).min().getAsInt();
        return minNum;
    }

    public int BigNumbersMinTwice() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int minNum = Arrays.stream(numbers).filter(n -> n >= 5).map(n -> n * 2).min().getAsInt();
        return minNum;
    }

    public int OddNumbersMinTwice() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int minNum = Arrays.stream(numbers).filter(n -> n % 2 == 0).map(n -> n * 2).min().getAsInt();
        return minNum;
    }

    public int StringMinLength() {
        String[] words = {"cherry", "apple", "blueberry"};
        int minLength = Arrays.stream(words).mapToInt(w -> w.length()).min().getAsInt();
        return minLength;
    }

    public int ShortStringMinLength() {
        String[] words = {"cherry", "apple", "blueberry"};
        int minLength = Arrays.stream(words).filter(w -> w.length() < 7).mapToInt(w -> w.length()).min().getAsInt();
        return minLength;
    }

    public double ProductUnitPriceMin() {
        List<Product> products = getProductList();
        double minUnitPrice = products.stream().mapToDouble(p -> p.getUnitPrice()).min().getAsDouble();
        return minUnitPrice;
    }

    public double ExpensiveProductUnitPriceMin() {
        List<Product> products = getProductList();
        double minUnitPrice = products.stream().filter(p -> p.getUnitPrice() > 100)
                .mapToDouble(p -> p.getUnitPrice()).min().getAsDouble();
        return minUnitPrice;
    }

    public int ExpensiveProductStockMin() {
        List<Product> products = getProductList();
        int minUnitPrice = products.stream().filter(p -> p.getUnitPrice() > 100)
                .mapToInt(p -> p.getUnitsInStock()).min().getAsInt();
        return minUnitPrice;
    }

    public int ProductLongNameLengthMin() {
        List<Product> products = getProductList();
        int minUnitPrice = products.stream().map(p -> p.getProductName())
                .filter(name -> name.length() > 7).mapToInt(name -> name.length()).min().getAsInt();
        return minUnitPrice;
    }

    public List<Pair<String, Double>> CustomerOrdersTotalMin() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersTotalMin = customers.stream().map(c -> Pair.with(c.getCustomerId(),
                c.getOrders().stream().mapToDouble(o -> o.getTotal()).min().getAsDouble())).toList();
        return ordersTotalMin;
    }

    public Map<String, Double> CustomerOrdersTotalMinDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersTotalMin = customers.stream().collect(toMap(c -> c.getCustomerId(),
                c -> c.getOrders().stream().mapToDouble(o -> o.getTotal()).min().getAsDouble()));
        return ordersTotalMin;
    }

    public List<Pair<String, Double>> CustomerInRegionOrdersTotalMin(String region) {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersTotalMin = customers.stream().filter(c -> c.getRegion().equals(region))
                .map(c -> Pair.with(c.getCustomerId(),
                        c.getOrders().stream().mapToDouble(o -> o.getTotal()).min().getAsDouble())).toList();
        return ordersTotalMin;
    }

    public Map<String, Double> CustomerInRegionOrdersTotalMinDict(String region) {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersTotalMin = customers.stream().filter(c -> c.getRegion().equals(region))
                .collect(toMap(c -> c.getCustomerId(),
                        c -> c.getOrders().stream().mapToDouble(o -> o.getTotal()).min().getAsDouble()));
        return ordersTotalMin;
    }

    public List<Pair<String, Double>> CustomerExpensiveOrdersTotalMin() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersTotalMin = customers.stream().map(c -> Pair.with(c.getCustomerId(),
                c.getOrders().stream().filter(o -> o.getTotal() > 100)
                        .mapToDouble(o -> o.getTotal()).min().getAsDouble())).toList();
        return ordersTotalMin;
    }

    public Map<String, Double> CustomerExpensiveOrdersTotalMinDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersTotalMin = customers.stream().collect(toMap(c -> c.getCustomerId(),
                c -> c.getOrders().stream().filter(o -> o.getTotal() > 100)
                        .mapToDouble(o -> o.getTotal()).min().getAsDouble()));
        return ordersTotalMin;
    }

    //min grouped: 10

    public List<Pair<String, Integer>> ProductEachCategoryStock() {
        List<Product> products = getProductList();
        List<Pair<String, Integer>> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().mapToInt(p -> p.getUnitsInStock()).min().getAsInt())).toList();
        return categories;
    }

    public Map<String, Integer> ProductEachCategoryStockDict() {
        List<Product> products = getProductList();
        Map<String, Integer> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().mapToInt(p -> p.getUnitsInStock()).min().getAsInt()));
        return categories;
    }

    public List<Pair<String, Integer>> ExpensiveProductEachCategoryStock() {
        List<Product> products = getProductList();
        List<Pair<String, Integer>> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().filter(
                        p -> p.getUnitPrice() > 100).mapToInt(p -> p.getUnitsInStock()).min().getAsInt())).toList();
        return categories;
    }

    public Map<String, Integer> ExpensiveProductEachCategoryStockDict() {
        List<Product> products = getProductList();
        Map<String, Integer> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().filter(
                        p -> p.getUnitPrice() > 100).mapToInt(p -> p.getUnitsInStock()).min().getAsInt()));
        return categories;
    }

    public List<Pair<String, Integer>> CustomerEachRegionOrdersMin() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Integer>> ordersMin = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().mapToInt(c -> c.getOrders().size()).min().getAsInt())).toList();
        return ordersMin;
    }

    public Map<String, Integer> CustomerEachRegionOrdersMinDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Integer> ordersMin = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().mapToInt(c -> c.getOrders().size()).min().getAsInt()));
        return ordersMin;
    }

    public List<Pair<String, Integer>> CustomerEachCountryOrdersMin() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Integer>> ordersMin = customers.stream().collect(groupingBy(c -> c.getCountry()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().mapToInt(c -> c.getOrders().size()).min().getAsInt())).toList();
        return ordersMin;
    }

    public Map<String, Integer> CustomerEachCountryOrdersMinDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Integer> ordersMin = customers.stream().collect(groupingBy(c -> c.getCountry()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().mapToInt(c -> c.getOrders().size()).min().getAsInt()));
        return ordersMin;
    }

    public List<Pair<String, Double>> CustomerEachRegionOrdersTotalMin() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersTotalMin = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().flatMap(c ->
                        c.getOrders().stream()).mapToDouble(o -> o.getTotal()).min().getAsDouble())).toList();
        return ordersTotalMin;
    }

    public Map<String, Double> CustomerEachRegionOrdersTotalMinDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersTotalMin = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().flatMap(c ->
                        c.getOrders().stream()).mapToDouble(o -> o.getTotal()).min().getAsDouble()));
        return ordersTotalMin;
    }

    //min each group: 10
    public List<Pair<String, List<Product>>> ProductEachCategoryMinUnitPriceProducts() {
        List<Product> products = getProductList();
        List<Pair<String, List<Product>>> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().collect(groupingBy(p -> p.getUnitPrice()))
                        .entrySet().stream().min(Map.Entry.comparingByKey()).get().getValue())).toList();
        return categories;
    }

    public Map<String, List<Product>> ProductEachCategoryMinUnitPriceProductsDict() {
        List<Product> products = getProductList();
        Map<String, List<Product>> categories = products.stream().collect(groupingBy(p -> p.getCategory())).entrySet()
                .stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().collect(groupingBy(
                        p -> p.getUnitPrice())).entrySet().stream().min(Map.Entry.comparingByKey()).get().getValue()));
        return categories;
    }

    public List<Pair<String, List<Product>>> ExpensiveProductEachCategoryMinUnitPriceProducts() {
        List<Product> products = getProductList();
        List<Pair<String, List<Product>>> categories = products.stream().filter(p -> p.getUnitPrice() > 100).
                collect(groupingBy(p -> p.getCategory())).entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().collect(groupingBy(p -> p.getUnitPrice()))
                                .entrySet().stream().min(Map.Entry.comparingByKey()).get().getValue())).toList();
        return categories;
    }

    public Map<String, List<Product>> ExpensiveProductEachCategoryMinUnitPriceProductsDict() {
        List<Product> products = getProductList();
        Map<String, List<Product>> categories = products.stream().filter(p -> p.getUnitPrice() > 100).collect(
                groupingBy(p -> p.getCategory())).entrySet().stream().collect(toMap(g -> g.getKey(),
                g -> g.getValue().stream().collect(groupingBy(p -> p.getUnitPrice()))
                        .entrySet().stream().min(Map.Entry.comparingByKey()).get().getValue()));
        return categories;
    }

    public List<Pair<String, List<Customer>>> CustomerEachRegionOrdersMinCustomer() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, List<Customer>>> customerOrdersMin = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().
                        collect(groupingBy(c -> c.getOrders().size())).entrySet()
                        .stream().min(Map.Entry.comparingByKey()).get().getValue())).toList();
        return customerOrdersMin;
    }

    public Map<String, List<Customer>> CustomerEachRegionOrdersMinCustomerDict() {
        List<Customer> customers = getCustomerList();
        Map<String, List<Customer>> customerOrdersMin = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().
                        collect(groupingBy(c -> c.getOrders().size())).entrySet()
                        .stream().min(Map.Entry.comparingByKey()).get().getValue()));
        return customerOrdersMin;
    }

    public List<Pair<String, List<Customer>>> CustomerEachCountryOrdersMinCustomer() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, List<Customer>>> customerOrdersMin = customers.stream().collect(groupingBy(c -> c.getCountry()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().
                        collect(groupingBy(c -> c.getOrders().size())).entrySet()
                        .stream().min(Map.Entry.comparingByKey()).get().getValue())).toList();
        return customerOrdersMin;
    }

    public Map<String, List<Customer>> CustomerEachCountryOrdersMinCustomerDict() {
        List<Customer> customers = getCustomerList();
        Map<String, List<Customer>> customerOrdersMin = customers.stream().collect(groupingBy(c -> c.getCountry()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().
                        collect(groupingBy(c -> c.getOrders().size())).entrySet()
                        .stream().min(Map.Entry.comparingByKey()).get().getValue()));
        return customerOrdersMin;
    }

    public List<Pair<String, List<Order>>> CustomerEachRegionOrdersTotalMinCustomer() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, List<Order>>> customerOrdersTotalMin = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream()
                        .flatMap(c -> c.getOrders().stream()).collect(groupingBy(o -> o.getTotal()))
                        .entrySet().stream().min(Map.Entry.comparingByKey()).get().getValue())).toList();
        return customerOrdersTotalMin;
    }

    public Map<String, List<Order>> CustomerEachRegionOrdersTotalMinCustomerDict() {
        List<Customer> customers = getCustomerList();
        Map<String, List<Order>> customerOrdersTotalMin = customers.stream().collect(groupingBy(c -> c.getCountry()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream()
                        .flatMap(c -> c.getOrders().stream()).collect(groupingBy(o -> o.getTotal()))
                        .entrySet().stream().min(Map.Entry.comparingByKey()).get().getValue()));
        return customerOrdersTotalMin;
    }
}
