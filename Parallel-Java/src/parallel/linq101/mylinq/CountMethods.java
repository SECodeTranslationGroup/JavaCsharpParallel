package parallel.linq101.mylinq;

import org.javatuples.Pair;
import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Product;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class CountMethods {
    //original:4 target:40
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    //distinct count and conditional count : 20

    public int uniqueFactorOf300Count() {
        int[] factorsOf300 = {2, 2, 3, 5, 5};
        int uniqueFactorsCount = (int) Arrays.stream(factorsOf300).distinct().count();
        return uniqueFactorsCount;
    }

    public int uniqueFactorsCount(int[] factors) {
        int factorsCount = (int) Arrays.stream(factors).distinct().count();
        return factorsCount;
    }

    public int oddFactorOf300Count() {
        int[] factorsOf300 = {2, 2, 3, 5, 5};
        int factorsCount = (int) Arrays.stream(factorsOf300).filter(n -> (n % 2 == 1)).count();
        return factorsCount;
    }

    public int uniqueOddFactorOf300Count() {
        int[] factorsOf300 = {2, 2, 3, 5, 5};
        int uniqueFactorsCount = (int) Arrays.stream(factorsOf300).distinct().filter(n -> (n % 2 == 1)).count();
        return uniqueFactorsCount;
    }

    public int oddNumbersCount(int[] numbers) {
        int oddNumbersCount = (int) Arrays.stream(numbers).filter(n -> (n % 2 == 1)).count();
        return oddNumbersCount;
    }

    public int distinctOddNumbersCount(int[] numbers) {
        int oddNumbersCount = (int) Arrays.stream(numbers).distinct().filter(n -> (n % 2 == 1)).count();
        return oddNumbersCount;
    }

    public int expensiveProductCount() {
        List<Product> products = getProductList();
        int count = (int) products.stream().filter(p -> p.getUnitPrice() > 100).count();
        return count;
    }

    public int cheapProductCount() {
        List<Product> products = getProductList();
        int count = (int) products.stream().filter(p -> p.getUnitPrice() < 100).count();
        return count;
    }

    public int distinctProductCategoryCount() {
        List<Product> products = getProductList();
        int count = (int) products.stream().map(p -> p.getCategory()).distinct().count();
        return count;
    }

    public int productLongCategoryCount() {
        List<Product> products = getProductList();
        int count = (int) products.stream().map(p -> p.getCategory()).filter(c -> c.length() > 8).count();
        return count;
    }

    public int productNameWithFirstLetterCount() {
        List<Product> products = getProductList();
        int count = (int) products.stream().map(p -> p.getProductName()).filter(c -> c.startsWith("c")).count();
        return count;
    }

    public int productOutOfStock() {
        List<Product> products = getProductList();
        int count = (int) products.stream().filter(c -> c.getUnitsInStock() == 0).count();
        return count;
    }

    public int distinctProductLongCategoryCount() {
        List<Product> products = getProductList();
        int count = (int) products.stream().map(p -> p.getCategory()).distinct().filter(c -> c.length() > 8).count();
        return count;
    }

    public int customerDistinctRegionsCount() {
        List<Customer> customers = getCustomerList();
        int count = (int) customers.stream().map(c -> c.getRegion()).distinct().count();
        return count;
    }

    public int customerInRegionCount(String region) {
        List<Customer> customers = getCustomerList();
        int count = (int) customers.stream().filter(c -> c.getRegion().equals(region)).count();
        return count;
    }

    public int customerWithManyOrdersCount() {
        List<Customer> customers = getCustomerList();
        int count = (int) customers.stream().filter(c -> c.getOrders().size() > 5).count();
        return count;
    }

    public int totalOrdersCount(String region) {
        List<Customer> customers = getCustomerList();
        int count = (int) customers.stream().flatMap(c -> c.getOrders().stream()).count();
        return count;
    }

    public int distinctOrdersCount(String region) {
        List<Customer> customers = getCustomerList();
        int count = (int) customers.stream().flatMap(c -> c.getOrders().stream()).distinct().count();
        return count;
    }

    public int expensiveOrdersCount(String region) {
        List<Customer> customers = getCustomerList();
        int count = (int) customers.stream().flatMap(c -> c.getOrders().stream())
                .filter(o -> o.getTotal() > 100).count();
        return count;
    }

    public int newOrdersCount(String region) {
        List<Customer> customers = getCustomerList();
        int count = (int) customers.stream().flatMap(c -> c.getOrders().stream())
                .filter(o -> o.getOrderDate().isAfter(LocalDate.of(2000, 1, 1))).count();
        return count;
    }

    //nested count : 10

    public int[] uniqueFactorOf300And900Count() {
        int[][] factorsOf300And900 = {
                {2, 2, 3, 5, 5},
                {2, 2, 3, 3, 5, 5}
        };
        int[] uniqueFactorsCount = Arrays.stream(factorsOf300And900)
                .mapToInt(a -> (int) Arrays.stream(a).distinct().count()).toArray();
        return uniqueFactorsCount;
    }

    public int[] oddFactorOf300And900Count() {
        int[][] factorsOf300And900 = {
                {2, 2, 3, 5, 5},
                {2, 2, 3, 3, 5, 5}
        };
        int[] factorsCount = Arrays.stream(factorsOf300And900)
                .mapToInt(a -> (int) Arrays.stream(a).filter(n -> n % 2 == 1).count()).toArray();
        return factorsCount;
    }

    public int[] uniqueFactorsCount(int[][] factors) {
        int[] factorsCount = Arrays.stream(factors)
                .mapToInt(a -> (int) Arrays.stream(a).distinct().count()).toArray();
        return factorsCount;
    }

    public int[] oddNumbersCount(int[][] numbers) {
        int[] oddNumbersCount = Arrays.stream(numbers)
                .mapToInt(a -> (int) Arrays.stream(a).filter(n -> n % 2 == 1).count()).toArray();
        return oddNumbersCount;
    }

    public List<Pair<String, Integer>> customerDistinctOrdersCount() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Integer>> orderCounts = customers.stream().map(c ->
                Pair.with(c.getCustomerId(), (int) c.getOrders().stream().distinct().count())).toList();
        return orderCounts;
    }

    public Map<String, Integer> customerDistinctOrdersCountDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Integer> orderCounts = customers.stream().collect(toMap(
                c -> c.getCustomerId(), c -> (int) c.getOrders().stream().distinct().count()));
        return orderCounts;
    }

    public List<Pair<String, Integer>> customerExpensiveOrdersCount() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Integer>> orderCounts = customers.stream().map(c ->
                Pair.with(c.getCustomerId(), (int) c.getOrders().stream().filter(o -> o.getTotal() > 100).count())).toList();
        return orderCounts;
    }

    public Map<String, Integer> customerExpensiveOrdersCountDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Integer> orderCounts = customers.stream().collect(toMap(
                c -> c.getCustomerId(), c -> (int) c.getOrders().stream().filter(o -> o.getTotal() > 100).count()));
        return orderCounts;
    }

    public List<Pair<String, Integer>> customerNewOrdersCount() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Integer>> orderCounts = customers.stream().map(c ->
                Pair.with(c.getCustomerId(), (int) c.getOrders().stream()
                        .filter(o -> o.getOrderDate().isAfter(LocalDate.of(2000, 1, 1))).count())).toList();
        return orderCounts;
    }

    public Map<String, Integer> customerNewOrdersCountDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Integer> orderCounts = customers.stream().collect(toMap(
                c -> c.getCustomerId(), c -> (int) c.getOrders().stream()
                        .filter(o -> o.getOrderDate().isAfter(LocalDate.of(2000, 1, 1))).count()));
        return orderCounts;
    }

    //grouped count : 10

    public List<Pair<Integer, Integer>> uniqueFactorOf300CountByOddEven() {
        int[] factorsOf300 = {2, 2, 3, 5, 5};
        List<Pair<Integer, Integer>> uniqueFactorsCount = Arrays.stream(factorsOf300).boxed().collect(
                groupingBy(n -> n % 2)).entrySet().stream().map(g -> Pair.with(g.getKey(), (int) g.getValue()
                .stream().distinct().count())).toList();
        return uniqueFactorsCount;
    }

    public Map<Integer, Integer> uniqueFactorOf300CountByOddEvenDict() {
        int[] factorsOf300 = {2, 2, 3, 5, 5};
        Map<Integer, Integer> uniqueFactorsCount = Arrays.stream(factorsOf300).boxed().collect(
                groupingBy(n -> n % 2)).entrySet().stream().collect(toMap(g -> g.getKey(),
                g -> (int) g.getValue().stream().distinct().count()));
        return uniqueFactorsCount;
    }

    public List<Pair<String, Integer>> countDistinctProductByCategory() {
        List<Product> products = getProductList();
        List<Pair<String, Integer>> categoryCounts = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        (int) g.getValue().stream().distinct().count())).toList();
        return categoryCounts;
    }

    public Map<String, Integer> countDistinctProductByCategoryDict() {
        List<Product> products = getProductList();
        Map<String, Integer> categoryCounts = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> (int) g.getValue().stream().distinct().count()));
        return categoryCounts;
    }

    public List<Pair<Boolean, Integer>> countExpensiveProductByInStock() {
        List<Product> products = getProductList();
        List<Pair<Boolean, Integer>> inStockCounts = products.stream().collect(groupingBy(p -> p.getUnitsInStock() == 0))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        (int) g.getValue().stream().filter(p -> p.getUnitPrice() > 100).count())).toList();
        return inStockCounts;
    }

    public Map<Boolean, Integer> countExpensiveProductByInStockDict() {
        List<Product> products = getProductList();
        Map<Boolean, Integer> inStockCounts = products.stream().collect(groupingBy(p -> p.getUnitsInStock() == 0))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> (int) g.getValue().stream().filter(p -> p.getUnitPrice() > 100).count()));
        return inStockCounts;
    }

    public List<Pair<String, Integer>> countRegionDistinctCustomer() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Integer>> regionCounts = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        (int) g.getValue().stream().distinct().count())).toList();
        return regionCounts;
    }

    public Map<String, Integer> countRegionDistinctCustomerDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Integer> regionCounts = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> (int) g.getValue().stream().distinct().count()));
        return regionCounts;
    }

    public List<Pair<String, Integer>> countRegionExpensiveOrders() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Integer>> regionCounts = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), (int) g.getValue().
                        stream().flatMap(c -> c.getOrders().stream()).filter(o -> o.getTotal() > 100).count())).toList();
        return regionCounts;
    }

    public Map<String, Integer> countRegionExpensiveOrdersDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Integer> regionCounts = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> (int) g.getValue().stream().
                        flatMap(c -> c.getOrders().stream()).filter(o -> o.getTotal() > 100).count()));
        return regionCounts;
    }
}
