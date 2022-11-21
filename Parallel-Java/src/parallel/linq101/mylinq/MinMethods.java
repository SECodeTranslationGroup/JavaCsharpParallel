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

    public int numbersMin() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int minNum = Arrays.stream(numbers).min().getAsInt();
        return minNum;
    }

    public int bigNumbersMin() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int minNum = Arrays.stream(numbers).filter(n -> n >= 5).min().getAsInt();
        return minNum;
    }

    public int oddNumbersMin() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int minNum = Arrays.stream(numbers).filter(n -> n % 2 == 0).min().getAsInt();
        return minNum;
    }

    public double doubleMin() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        double minNum = Arrays.stream(numbers).min().getAsDouble();
        return minNum;
    }

    public double bigDoubleNumbersMin() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        double minNum = Arrays.stream(numbers).filter(n -> n >= 5).min().getAsDouble();
        return minNum;
    }


    //min projection: 15

    public int numbersMinTwice() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int minNum = Arrays.stream(numbers).map(n -> n * 2).min().getAsInt();
        return minNum;
    }

    public int bigNumbersMinTwice() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int minNum = Arrays.stream(numbers).filter(n -> n >= 5).map(n -> n * 2).min().getAsInt();
        return minNum;
    }

    public int oddNumbersMinTwice() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int minNum = Arrays.stream(numbers).filter(n -> n % 2 == 0).map(n -> n * 2).min().getAsInt();
        return minNum;
    }

    public int stringMinLength() {
        String[] words = {"cherry", "apple", "blueberry"};
        int minLength = Arrays.stream(words).mapToInt(w -> w.length()).min().getAsInt();
        return minLength;
    }

    public int shortStringMinLength() {
        String[] words = {"cherry", "apple", "blueberry"};
        int minLength = Arrays.stream(words).filter(w -> w.length() < 7).mapToInt(w -> w.length()).min().getAsInt();
        return minLength;
    }

    public double productUnitPriceMin() {
        List<Product> products = getProductList();
        double minUnitPrice = products.stream().mapToDouble(p -> p.getUnitPrice()).min().getAsDouble();
        return minUnitPrice;
    }

    public double expensiveProductUnitPriceMin() {
        List<Product> products = getProductList();
        double minUnitPrice = products.stream().filter(p -> p.getUnitPrice() > 100)
                .mapToDouble(p -> p.getUnitPrice()).min().getAsDouble();
        return minUnitPrice;
    }

    public int expensiveProductStockMin() {
        List<Product> products = getProductList();
        int minUnitPrice = products.stream().filter(p -> p.getUnitPrice() > 100)
                .mapToInt(p -> p.getUnitsInStock()).min().getAsInt();
        return minUnitPrice;
    }

    public int productLongNameLengthMin() {
        List<Product> products = getProductList();
        int minUnitPrice = products.stream().map(p -> p.getProductName())
                .filter(name -> name.length() > 7).mapToInt(name -> name.length()).min().getAsInt();
        return minUnitPrice;
    }

    public List<Pair<String, Double>> customerOrdersTotalMin() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersTotalMin = customers.stream().map(c -> Pair.with(c.getCustomerId(),
                c.getOrders().stream().mapToDouble(o -> o.getTotal()).min().getAsDouble())).toList();
        return ordersTotalMin;
    }

    public Map<String, Double> customerOrdersTotalMinDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersTotalMin = customers.stream().collect(toMap(c -> c.getCustomerId(),
                c -> c.getOrders().stream().mapToDouble(o -> o.getTotal()).min().getAsDouble()));
        return ordersTotalMin;
    }

    public List<Pair<String, Double>> customerInRegionOrdersTotalMin(String region) {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersTotalMin = customers.stream().filter(c -> c.getRegion().equals(region))
                .map(c -> Pair.with(c.getCustomerId(),
                        c.getOrders().stream().mapToDouble(o -> o.getTotal()).min().getAsDouble())).toList();
        return ordersTotalMin;
    }

    public Map<String, Double> customerInRegionOrdersTotalMinDict(String region) {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersTotalMin = customers.stream().filter(c -> c.getRegion().equals(region))
                .collect(toMap(c -> c.getCustomerId(),
                        c -> c.getOrders().stream().mapToDouble(o -> o.getTotal()).min().getAsDouble()));
        return ordersTotalMin;
    }

    public List<Pair<String, Double>> customerExpensiveOrdersTotalMin() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersTotalMin = customers.stream().map(c -> Pair.with(c.getCustomerId(),
                c.getOrders().stream().filter(o -> o.getTotal() > 100)
                        .mapToDouble(o -> o.getTotal()).min().getAsDouble())).toList();
        return ordersTotalMin;
    }

    public Map<String, Double> customerExpensiveOrdersTotalMinDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersTotalMin = customers.stream().collect(toMap(c -> c.getCustomerId(),
                c -> c.getOrders().stream().filter(o -> o.getTotal() > 100)
                        .mapToDouble(o -> o.getTotal()).min().getAsDouble()));
        return ordersTotalMin;
    }

    //min grouped: 10

    public List<Pair<String, Integer>> productEachCategoryStock() {
        List<Product> products = getProductList();
        List<Pair<String, Integer>> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().mapToInt(p -> p.getUnitsInStock()).min().getAsInt())).toList();
        return categories;
    }

    public Map<String, Integer> productEachCategoryStockDict() {
        List<Product> products = getProductList();
        Map<String, Integer> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().mapToInt(p -> p.getUnitsInStock()).min().getAsInt()));
        return categories;
    }

    public List<Pair<String, Integer>> expensiveProductEachCategoryStock() {
        List<Product> products = getProductList();
        List<Pair<String, Integer>> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().filter(
                        p -> p.getUnitPrice() > 100).mapToInt(p -> p.getUnitsInStock()).min().getAsInt())).toList();
        return categories;
    }

    public Map<String, Integer> expensiveProductEachCategoryStockDict() {
        List<Product> products = getProductList();
        Map<String, Integer> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().filter(
                        p -> p.getUnitPrice() > 100).mapToInt(p -> p.getUnitsInStock()).min().getAsInt()));
        return categories;
    }

    public List<Pair<String, Integer>> customerEachRegionOrdersMin() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Integer>> ordersMin = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().mapToInt(c -> c.getOrders().size()).min().getAsInt())).toList();
        return ordersMin;
    }

    public Map<String, Integer> customerEachRegionOrdersMinDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Integer> ordersMin = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().mapToInt(c -> c.getOrders().size()).min().getAsInt()));
        return ordersMin;
    }

    public List<Pair<String, Integer>> customerEachCountryOrdersMin() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Integer>> ordersMin = customers.stream().collect(groupingBy(c -> c.getCountry()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().mapToInt(c -> c.getOrders().size()).min().getAsInt())).toList();
        return ordersMin;
    }

    public Map<String, Integer> customerEachCountryOrdersMinDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Integer> ordersMin = customers.stream().collect(groupingBy(c -> c.getCountry()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().mapToInt(c -> c.getOrders().size()).min().getAsInt()));
        return ordersMin;
    }

    public List<Pair<String, Double>> customerEachRegionOrdersTotalMin() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> ordersTotalMin = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().flatMap(c ->
                        c.getOrders().stream()).mapToDouble(o -> o.getTotal()).min().getAsDouble())).toList();
        return ordersTotalMin;
    }

    public Map<String, Double> customerEachRegionOrdersTotalMinDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Double> ordersTotalMin = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().flatMap(c ->
                        c.getOrders().stream()).mapToDouble(o -> o.getTotal()).min().getAsDouble()));
        return ordersTotalMin;
    }

    //min each group: 10
    public List<Pair<String, List<Product>>> productEachCategoryMinUnitPriceProducts() {
        List<Product> products = getProductList();
        List<Pair<String, List<Product>>> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().collect(groupingBy(p -> p.getUnitPrice()))
                        .entrySet().stream().min(Map.Entry.comparingByKey()).get().getValue())).toList();
        return categories;
    }

    public Map<String, List<Product>> productEachCategoryMinUnitPriceProductsDict() {
        List<Product> products = getProductList();
        Map<String, List<Product>> categories = products.stream().collect(groupingBy(p -> p.getCategory())).entrySet()
                .stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().collect(groupingBy(
                        p -> p.getUnitPrice())).entrySet().stream().min(Map.Entry.comparingByKey()).get().getValue()));
        return categories;
    }

    public List<Pair<String, List<Product>>> expensiveProductEachCategoryMinUnitPriceProducts() {
        List<Product> products = getProductList();
        List<Pair<String, List<Product>>> categories = products.stream().filter(p -> p.getUnitPrice() > 100).
                collect(groupingBy(p -> p.getCategory())).entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().collect(groupingBy(p -> p.getUnitPrice()))
                                .entrySet().stream().min(Map.Entry.comparingByKey()).get().getValue())).toList();
        return categories;
    }

    public Map<String, List<Product>> expensiveProductEachCategoryMinUnitPriceProductsDict() {
        List<Product> products = getProductList();
        Map<String, List<Product>> categories = products.stream().filter(p -> p.getUnitPrice() > 100).collect(
                groupingBy(p -> p.getCategory())).entrySet().stream().collect(toMap(g -> g.getKey(),
                g -> g.getValue().stream().collect(groupingBy(p -> p.getUnitPrice()))
                        .entrySet().stream().min(Map.Entry.comparingByKey()).get().getValue()));
        return categories;
    }

    public List<Pair<String, List<Customer>>> customerEachRegionOrdersMinCustomer() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, List<Customer>>> customerOrdersMin = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().
                        collect(groupingBy(c -> c.getOrders().size())).entrySet()
                        .stream().min(Map.Entry.comparingByKey()).get().getValue())).toList();
        return customerOrdersMin;
    }

    public Map<String, List<Customer>> customerEachRegionOrdersMinCustomerDict() {
        List<Customer> customers = getCustomerList();
        Map<String, List<Customer>> customerOrdersMin = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().
                        collect(groupingBy(c -> c.getOrders().size())).entrySet()
                        .stream().min(Map.Entry.comparingByKey()).get().getValue()));
        return customerOrdersMin;
    }

    public List<Pair<String, List<Customer>>> customerEachCountryOrdersMinCustomer() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, List<Customer>>> customerOrdersMin = customers.stream().collect(groupingBy(c -> c.getCountry()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().
                        collect(groupingBy(c -> c.getOrders().size())).entrySet()
                        .stream().min(Map.Entry.comparingByKey()).get().getValue())).toList();
        return customerOrdersMin;
    }

    public Map<String, List<Customer>> customerEachCountryOrdersMinCustomerDict() {
        List<Customer> customers = getCustomerList();
        Map<String, List<Customer>> customerOrdersMin = customers.stream().collect(groupingBy(c -> c.getCountry()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().
                        collect(groupingBy(c -> c.getOrders().size())).entrySet()
                        .stream().min(Map.Entry.comparingByKey()).get().getValue()));
        return customerOrdersMin;
    }

    public List<Pair<String, List<Order>>> customerEachRegionOrdersTotalMinCustomer() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, List<Order>>> customerOrdersTotalMin = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream()
                        .flatMap(c -> c.getOrders().stream()).collect(groupingBy(o -> o.getTotal()))
                        .entrySet().stream().min(Map.Entry.comparingByKey()).get().getValue())).toList();
        return customerOrdersTotalMin;
    }

    public Map<String, List<Order>> customerEachRegionOrdersTotalMinCustomerDict() {
        List<Customer> customers = getCustomerList();
        Map<String, List<Order>> customerOrdersTotalMin = customers.stream().collect(groupingBy(c -> c.getCountry()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream()
                        .flatMap(c -> c.getOrders().stream()).collect(groupingBy(o -> o.getTotal()))
                        .entrySet().stream().min(Map.Entry.comparingByKey()).get().getValue()));
        return customerOrdersTotalMin;
    }
}
