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

    public int UniqueFactorOf300Count() {
        int[] factorsOf300 = {2, 2, 3, 5, 5};
        int uniqueFactorsCount = (int) Arrays.stream(factorsOf300).distinct().count();
        return uniqueFactorsCount;
    }

    public int UniqueFactorsCount(int[] factors) {
        int factorsCount = (int) Arrays.stream(factors).distinct().count();
        return factorsCount;
    }

    public int OddFactorOf300Count() {
        int[] factorsOf300 = {2, 2, 3, 5, 5};
        int factorsCount = (int) Arrays.stream(factorsOf300).filter(n -> (n % 2 == 1)).count();
        return factorsCount;
    }

    public int UniqueOddFactorOf300Count() {
        int[] factorsOf300 = {2, 2, 3, 5, 5};
        int uniqueFactorsCount = (int) Arrays.stream(factorsOf300).distinct().filter(n -> (n % 2 == 1)).count();
        return uniqueFactorsCount;
    }

    public int OddNumbersCount(int[] numbers) {
        int oddNumbersCount = (int) Arrays.stream(numbers).filter(n -> (n % 2 == 1)).count();
        return oddNumbersCount;
    }

    public int DistinctOddNumbersCount(int[] numbers) {
        int oddNumbersCount = (int) Arrays.stream(numbers).distinct().filter(n -> (n % 2 == 1)).count();
        return oddNumbersCount;
    }

    public int ExpensiveProductCount() {
        List<Product> products = getProductList();
        int count = (int) products.stream().filter(p -> p.getUnitPrice() > 100).count();
        return count;
    }

    public int CheapProductCount() {
        List<Product> products = getProductList();
        int count = (int) products.stream().filter(p -> p.getUnitPrice() < 100).count();
        return count;
    }

    public int DistinctProductCategoryCount() {
        List<Product> products = getProductList();
        int count = (int) products.stream().map(p -> p.getCategory()).distinct().count();
        return count;
    }

    public int ProductLongCategoryCount() {
        List<Product> products = getProductList();
        int count = (int) products.stream().map(p -> p.getCategory()).filter(c -> c.length() > 8).count();
        return count;
    }

    public int ProductNameWithFirstLetterCount() {
        List<Product> products = getProductList();
        int count = (int) products.stream().map(p -> p.getProductName()).filter(c -> c.startsWith("c")).count();
        return count;
    }

    public int ProductOutOfStock() {
        List<Product> products = getProductList();
        int count = (int) products.stream().filter(c -> c.getUnitsInStock() == 0).count();
        return count;
    }

    public int DistinctProductLongCategoryCount() {
        List<Product> products = getProductList();
        int count = (int) products.stream().map(p -> p.getCategory()).distinct().filter(c -> c.length() > 8).count();
        return count;
    }

    public int CustomerDistinctRegionsCount() {
        List<Customer> customers = getCustomerList();
        int count = (int) customers.stream().map(c -> c.getRegion()).distinct().count();
        return count;
    }

    public int CustomerInRegionCount(String region) {
        List<Customer> customers = getCustomerList();
        int count = (int) customers.stream().filter(c -> c.getRegion().equals(region)).count();
        return count;
    }

    public int CustomerWithManyOrdersCount() {
        List<Customer> customers = getCustomerList();
        int count = (int) customers.stream().filter(c -> c.getOrders().size() > 5).count();
        return count;
    }

    public int TotalOrdersCount(String region) {
        List<Customer> customers = getCustomerList();
        int count = (int) customers.stream().flatMap(c -> c.getOrders().stream()).count();
        return count;
    }

    public int DistinctOrdersCount(String region) {
        List<Customer> customers = getCustomerList();
        int count = (int) customers.stream().flatMap(c -> c.getOrders().stream()).distinct().count();
        return count;
    }

    public int ExpensiveOrdersCount(String region) {
        List<Customer> customers = getCustomerList();
        int count = (int) customers.stream().flatMap(c -> c.getOrders().stream())
                .filter(o -> o.getTotal() > 100).count();
        return count;
    }

    public int NewOrdersCount(String region) {
        List<Customer> customers = getCustomerList();
        int count = (int) customers.stream().flatMap(c -> c.getOrders().stream())
                .filter(o -> o.getOrderDate().isAfter(LocalDate.of(2000, 1, 1))).count();
        return count;
    }

    //nested count : 10

    public int[] UniqueFactorOf300And900Count() {
        int[][] factorsOf300And900 = {
                {2, 2, 3, 5, 5},
                {2, 2, 3, 3, 5, 5}
        };
        int[] uniqueFactorsCount = Arrays.stream(factorsOf300And900)
                .mapToInt(a -> (int) Arrays.stream(a).distinct().count()).toArray();
        return uniqueFactorsCount;
    }

    public int[] OddFactorOf300And900Count() {
        int[][] factorsOf300And900 = {
                {2, 2, 3, 5, 5},
                {2, 2, 3, 3, 5, 5}
        };
        int[] factorsCount = Arrays.stream(factorsOf300And900)
                .mapToInt(a -> (int) Arrays.stream(a).filter(n -> n % 2 == 1).count()).toArray();
        return factorsCount;
    }

    public int[] UniqueFactorsCount(int[][] factors) {
        int[] factorsCount = Arrays.stream(factors)
                .mapToInt(a -> (int) Arrays.stream(a).distinct().count()).toArray();
        return factorsCount;
    }

    public int[] OddNumbersCount(int[][] numbers) {
        int[] oddNumbersCount = Arrays.stream(numbers)
                .mapToInt(a -> (int) Arrays.stream(a).filter(n -> n % 2 == 1).count()).toArray();
        return oddNumbersCount;
    }

    public List<Pair<String, Integer>> CustomerDistinctOrdersCount() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Integer>> orderCounts = customers.stream().map(c ->
                Pair.with(c.getCustomerId(), (int) c.getOrders().stream().distinct().count())).toList();
        return orderCounts;
    }

    public Map<String, Integer> CustomerDistinctOrdersCountDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Integer> orderCounts = customers.stream().collect(toMap(
                c -> c.getCustomerId(), c -> (int) c.getOrders().stream().distinct().count()));
        return orderCounts;
    }

    public List<Pair<String, Integer>> CustomerExpensiveOrdersCount() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Integer>> orderCounts = customers.stream().map(c ->
                Pair.with(c.getCustomerId(), (int) c.getOrders().stream().filter(o -> o.getTotal() > 100).count())).toList();
        return orderCounts;
    }

    public Map<String, Integer> CustomerExpensiveOrdersCountDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Integer> orderCounts = customers.stream().collect(toMap(
                c -> c.getCustomerId(), c -> (int) c.getOrders().stream().filter(o -> o.getTotal() > 100).count()));
        return orderCounts;
    }

    public List<Pair<String, Integer>> CustomerNewOrdersCount() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Integer>> orderCounts = customers.stream().map(c ->
                Pair.with(c.getCustomerId(), (int) c.getOrders().stream()
                        .filter(o -> o.getOrderDate().isAfter(LocalDate.of(2000, 1, 1))).count())).toList();
        return orderCounts;
    }

    public Map<String, Integer> CustomerNewOrdersCountDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Integer> orderCounts = customers.stream().collect(toMap(
                c -> c.getCustomerId(), c -> (int) c.getOrders().stream()
                        .filter(o -> o.getOrderDate().isAfter(LocalDate.of(2000, 1, 1))).count()));
        return orderCounts;
    }

    //grouped count : 10

    public List<Pair<Integer, Integer>> UniqueFactorOf300CountByOddEven() {
        int[] factorsOf300 = {2, 2, 3, 5, 5};
        List<Pair<Integer, Integer>> uniqueFactorsCount = Arrays.stream(factorsOf300).boxed().collect(
                groupingBy(n -> n % 2)).entrySet().stream().map(g -> Pair.with(g.getKey(), (int) g.getValue()
                .stream().distinct().count())).toList();
        return uniqueFactorsCount;
    }

    public Map<Integer, Integer> UniqueFactorOf300CountByOddEvenDict() {
        int[] factorsOf300 = {2, 2, 3, 5, 5};
        Map<Integer, Integer> uniqueFactorsCount = Arrays.stream(factorsOf300).boxed().collect(
                groupingBy(n -> n % 2)).entrySet().stream().collect(toMap(g -> g.getKey(),
                g -> (int) g.getValue().stream().distinct().count()));
        return uniqueFactorsCount;
    }

    public List<Pair<String, Integer>> CountDistinctProductByCategory() {
        List<Product> products = getProductList();
        List<Pair<String, Integer>> categoryCounts = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        (int) g.getValue().stream().distinct().count())).toList();
        return categoryCounts;
    }

    public Map<String, Integer> CountDistinctProductByCategoryDict() {
        List<Product> products = getProductList();
        Map<String, Integer> categoryCounts = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> (int) g.getValue().stream().distinct().count()));
        return categoryCounts;
    }

    public List<Pair<Boolean, Integer>> CountExpensiveProductByInStock() {
        List<Product> products = getProductList();
        List<Pair<Boolean, Integer>> inStockCounts = products.stream().collect(groupingBy(p -> p.getUnitsInStock() == 0))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        (int) g.getValue().stream().filter(p -> p.getUnitPrice() > 100).count())).toList();
        return inStockCounts;
    }

    public Map<Boolean, Integer> CountExpensiveProductByInStockDict() {
        List<Product> products = getProductList();
        Map<Boolean, Integer> inStockCounts = products.stream().collect(groupingBy(p -> p.getUnitsInStock() == 0))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> (int) g.getValue().stream().filter(p -> p.getUnitPrice() > 100).count()));
        return inStockCounts;
    }

    public List<Pair<String, Integer>> CountRegionDistinctCustomer() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Integer>> regionCounts = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        (int) g.getValue().stream().distinct().count())).toList();
        return regionCounts;
    }

    public Map<String, Integer> CountRegionDistinctCustomerDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Integer> regionCounts = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> (int) g.getValue().stream().distinct().count()));
        return regionCounts;
    }

    public List<Pair<String, Integer>> CountRegionExpensiveOrders() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Integer>> regionCounts = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), (int) g.getValue().
                        stream().flatMap(c -> c.getOrders().stream()).filter(o -> o.getTotal() > 100).count())).toList();
        return regionCounts;
    }

    public Map<String, Integer> CountRegionExpensiveOrdersDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Integer> regionCounts = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> (int) g.getValue().stream().
                        flatMap(c -> c.getOrders().stream()).filter(o -> o.getTotal() > 100).count()));
        return regionCounts;
    }
}
