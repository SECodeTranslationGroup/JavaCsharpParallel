package parallel.linq101.mylinq;

import org.javatuples.Pair;
import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Order;
import parallel.linq101.datasource.Product;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class MaxMethods {
    //original:4 target:40
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }
    //max syntax : 5

    public int numbersMax() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int maxNum = Arrays.stream(numbers).max().getAsInt();
        return maxNum;
    }

    public int bigNumbersMax() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int maxNum = Arrays.stream(numbers).filter(n -> n >= 5).max().getAsInt();
        return maxNum;
    }

    public int oddNumbersMax() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int maxNum = Arrays.stream(numbers).filter(n -> n % 2 == 0).max().getAsInt();
        return maxNum;
    }

    public double doubleMax() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        double maxNum = Arrays.stream(numbers).max().getAsDouble();
        return maxNum;
    }

    public double bigDoubleNumbersMax() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        double maxNum = Arrays.stream(numbers).filter(n -> n >= 5).max().getAsDouble();
        return maxNum;
    }


    //max projection: 15

    public int numbersMaxTwice() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int maxNum = Arrays.stream(numbers).map(n -> n * 2).max().getAsInt();
        return maxNum;
    }

    public int bigNumbersMaxTwice() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int maxNum = Arrays.stream(numbers).filter(n -> n >= 5).map(n -> n * 2).max().getAsInt();
        return maxNum;
    }

    public int oddNumbersMaxTwice() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int maxNum = Arrays.stream(numbers).filter(n -> n % 2 == 0).map(n -> n * 2).max().getAsInt();
        return maxNum;
    }

    public int stringMaxLength() {
        String[] words = {"cherry", "apple", "blueberry"};
        int maxLength = Arrays.stream(words).mapToInt(w -> w.length()).max().getAsInt();
        return maxLength;
    }

    public int shortStringMaxLength() {
        String[] words = {"cherry", "apple", "blueberry"};
        int maxLength = Arrays.stream(words).filter(w -> w.length() < 7).mapToInt(w -> w.length()).max().getAsInt();
        return maxLength;
    }

    public double productUnitPriceMax() {
        List<Product> products = getProductList();
        double maxUnitPrice = products.stream().mapToDouble(p -> p.getUnitPrice()).max().getAsDouble();
        return maxUnitPrice;
    }

    public double expensiveProductUnitPriceMax() {
        List<Product> products = getProductList();
        double maxUnitPrice = products.stream().filter(p -> p.getUnitPrice() > 100)
                .mapToDouble(p -> p.getUnitPrice()).max().getAsDouble();
        return maxUnitPrice;
    }

    public int expensiveProductStockMax() {
        List<Product> products = getProductList();
        int maxUnitPrice = products.stream().filter(p -> p.getUnitPrice() > 100)
                .mapToInt(p -> p.getUnitsInStock()).max().getAsInt();
        return maxUnitPrice;
    }

    public int productLongNameLengthMax() {
        List<Product> products = getProductList();
        int maxUnitPrice = products.stream().map(p -> p.getProductName())
                .filter(name -> name.length() > 7).mapToInt(name -> name.length()).max().getAsInt();
        return maxUnitPrice;
    }

    public List<Pair<String, Double>> customerOrdersTotalMax() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersTotalMax = customers.stream().map(c -> Pair.with(c.getCustomerId(),
                c.getOrders().stream().mapToDouble(o -> o.getTotal()).max().getAsDouble())).toList();
        return ordersTotalMax;
    }

    public Map<String, Double> customerOrdersTotalMaxDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersTotalMax = customers.stream().collect(toMap(c -> c.getCustomerId(),
                c -> c.getOrders().stream().mapToDouble(o -> o.getTotal()).max().getAsDouble()));
        return ordersTotalMax;
    }

    public List<Pair<String, Double>> customerInRegionOrdersTotalMax(String region) {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersTotalMax = customers.stream().filter(c -> c.getRegion().equals(region))
                .map(c -> Pair.with(c.getCustomerId(),
                        c.getOrders().stream().mapToDouble(o -> o.getTotal()).max().getAsDouble())).toList();
        return ordersTotalMax;
    }

    public Map<String, Double> customerInRegionOrdersTotalMaxDict(String region) {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersTotalMax = customers.stream().filter(c -> c.getRegion().equals(region))
                .collect(toMap(c -> c.getCustomerId(),
                        c -> c.getOrders().stream().mapToDouble(o -> o.getTotal()).max().getAsDouble()));
        return ordersTotalMax;
    }

    public List<Pair<String, Double>> customerExpensiveOrdersTotalMax() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersTotalMax = customers.stream().map(c -> Pair.with(c.getCustomerId(),
                c.getOrders().stream().filter(o -> o.getTotal() > 100)
                        .mapToDouble(o -> o.getTotal()).max().getAsDouble())).toList();
        return ordersTotalMax;
    }

    public Map<String, Double> customerExpensiveOrdersTotalMaxDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersTotalMax = customers.stream().collect(toMap(c -> c.getCustomerId(),
                c -> c.getOrders().stream().filter(o -> o.getTotal() > 100)
                        .mapToDouble(o -> o.getTotal()).max().getAsDouble()));
        return ordersTotalMax;
    }

    //max grouped: 10

    public List<Pair<String, Integer>> productEachCategoryStock() {
        List<Product> products = getProductList();
        List<Pair<String, Integer>> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().mapToInt(p -> p.getUnitsInStock()).max().getAsInt())).toList();
        return categories;
    }

    public Map<String, Integer> productEachCategoryStockDict() {
        List<Product> products = getProductList();
        Map<String, Integer> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().mapToInt(p -> p.getUnitsInStock()).max().getAsInt()));
        return categories;
    }

    public List<Pair<String, Integer>> expensiveProductEachCategoryStock() {
        List<Product> products = getProductList();
        List<Pair<String, Integer>> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().filter(
                        p -> p.getUnitPrice() > 100).mapToInt(p -> p.getUnitsInStock()).max().getAsInt())).toList();
        return categories;
    }

    public Map<String, Integer> expensiveProductEachCategoryStockDict() {
        List<Product> products = getProductList();
        Map<String, Integer> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().filter(
                        p -> p.getUnitPrice() > 100).mapToInt(p -> p.getUnitsInStock()).max().getAsInt()));
        return categories;
    }

    public List<Pair<String, Integer>> customerEachRegionOrdersMax() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Integer>> ordersMax = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().mapToInt(c -> c.getOrders().size()).max().getAsInt())).toList();
        return ordersMax;
    }

    public Map<String, Integer> customerEachRegionOrdersMaxDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Integer> ordersMax = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().mapToInt(c -> c.getOrders().size()).max().getAsInt()));
        return ordersMax;
    }

    public List<Pair<String, Integer>> customerEachCountryOrdersMax() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Integer>> ordersMax = customers.stream().collect(groupingBy(c -> c.getCountry()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().mapToInt(c -> c.getOrders().size()).max().getAsInt())).toList();
        return ordersMax;
    }

    public Map<String, Integer> customerEachCountryOrdersMaxDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Integer> ordersMax = customers.stream().collect(groupingBy(c -> c.getCountry()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().mapToInt(c -> c.getOrders().size()).max().getAsInt()));
        return ordersMax;
    }

    public List<Pair<String, Double>> customerEachRegionOrdersTotalMax() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersTotalMax = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().flatMap(c ->
                        c.getOrders().stream()).mapToDouble(o -> o.getTotal()).max().getAsDouble())).toList();
        return ordersTotalMax;
    }

    public Map<String, Double> customerEachRegionOrdersTotalMaxDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersTotalMax = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().flatMap(c ->
                        c.getOrders().stream()).mapToDouble(o -> o.getTotal()).max().getAsDouble()));
        return ordersTotalMax;
    }

    //max each group: 10
    public List<Pair<String, List<Product>>> productEachCategoryMaxUnitPriceProducts() {
        List<Product> products = getProductList();
        List<Pair<String, List<Product>>> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().collect(groupingBy(p -> p.getUnitPrice()))
                        .entrySet().stream().max(Map.Entry.comparingByKey()).get().getValue())).toList();
        return categories;
    }

    public Map<String, List<Product>> productEachCategoryMaxUnitPriceProductsDict() {
        List<Product> products = getProductList();
        Map<String, List<Product>> categories = products.stream().collect(groupingBy(p -> p.getCategory())).entrySet()
                .stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().collect(groupingBy(
                        p -> p.getUnitPrice())).entrySet().stream().max(Map.Entry.comparingByKey()).get().getValue()));
        return categories;
    }

    public List<Pair<String, List<Product>>> expensiveProductEachCategoryMaxUnitPriceProducts() {
        List<Product> products = getProductList();
        List<Pair<String, List<Product>>> categories = products.stream().filter(p -> p.getUnitPrice() > 100).
                collect(groupingBy(p -> p.getCategory())).entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().collect(groupingBy(p -> p.getUnitPrice()))
                                .entrySet().stream().max(Map.Entry.comparingByKey()).get().getValue())).toList();
        return categories;
    }

    public Map<String, List<Product>> expensiveProductEachCategoryMaxUnitPriceProductsDict() {
        List<Product> products = getProductList();
        Map<String, List<Product>> categories = products.stream().filter(p -> p.getUnitPrice() > 100).collect(
                groupingBy(p -> p.getCategory())).entrySet().stream().collect(toMap(g -> g.getKey(),
                g -> g.getValue().stream().collect(groupingBy(p -> p.getUnitPrice()))
                        .entrySet().stream().max(Map.Entry.comparingByKey()).get().getValue()));
        return categories;
    }

    public List<Pair<String, List<Customer>>> customerEachRegionOrdersMaxCustomer() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, List<Customer>>> customerOrdersMax = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().
                        collect(groupingBy(c -> c.getOrders().size())).entrySet()
                        .stream().max(Map.Entry.comparingByKey()).get().getValue())).toList();
        return customerOrdersMax;
    }

    public Map<String, List<Customer>> customerEachRegionOrdersMaxCustomerDict() {
        List<Customer> customers = getCustomerList();
        Map<String, List<Customer>> customerOrdersMax = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().
                        collect(groupingBy(c -> c.getOrders().size())).entrySet()
                        .stream().max(Map.Entry.comparingByKey()).get().getValue()));
        return customerOrdersMax;
    }

    public List<Pair<String, List<Customer>>> customerEachCountryOrdersMaxCustomer() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, List<Customer>>> customerOrdersMax = customers.stream().collect(groupingBy(c -> c.getCountry()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().
                        collect(groupingBy(c -> c.getOrders().size())).entrySet()
                        .stream().max(Map.Entry.comparingByKey()).get().getValue())).toList();
        return customerOrdersMax;
    }

    public Map<String, List<Customer>> customerEachCountryOrdersMaxCustomerDict() {
        List<Customer> customers = getCustomerList();
        Map<String, List<Customer>> customerOrdersMax = customers.stream().collect(groupingBy(c -> c.getCountry()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().
                        collect(groupingBy(c -> c.getOrders().size())).entrySet()
                        .stream().max(Map.Entry.comparingByKey()).get().getValue()));
        return customerOrdersMax;
    }

    public List<Pair<String, List<Order>>> customerEachRegionOrdersTotalMaxCustomer() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, List<Order>>> customerOrdersTotalMax = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream()
                        .flatMap(c -> c.getOrders().stream()).collect(groupingBy(o -> o.getTotal()))
                        .entrySet().stream().max(Map.Entry.comparingByKey()).get().getValue())).toList();
        return customerOrdersTotalMax;
    }

    public Map<String, List<Order>> customerEachRegionOrdersTotalMaxCustomerDict() {
        List<Customer> customers = getCustomerList();
        Map<String, List<Order>> customerOrdersTotalMax = customers.stream().collect(groupingBy(c -> c.getCountry()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream()
                        .flatMap(c -> c.getOrders().stream()).collect(groupingBy(o -> o.getTotal()))
                        .entrySet().stream().max(Map.Entry.comparingByKey()).get().getValue()));
        return customerOrdersTotalMax;
    }
}
