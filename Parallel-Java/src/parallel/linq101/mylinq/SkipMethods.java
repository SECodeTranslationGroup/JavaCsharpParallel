package parallel.linq101.mylinq;

import org.javatuples.Pair;
import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Order;
import parallel.linq101.datasource.Product;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class SkipMethods {
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public List<Integer> intSkip() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> after3Numbers = Arrays.stream(numbers).skip(3).boxed().toList();
        return after3Numbers;
    }

    public List<Integer> oddIntSkip() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> after3Numbers = Arrays.stream(numbers).filter(i -> i % 2 == 1).skip(3).boxed().toList();
        return after3Numbers;
    }

    public List<Integer> intSquareSkip() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> after3Numbers = Arrays.stream(numbers).map(i -> i * i).skip(3).boxed().toList();
        return after3Numbers;
    }

    public List<Integer> intSkipCount(int n) {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> after3Numbers = Arrays.stream(numbers).skip(n).boxed().toList();
        return after3Numbers;
    }

    public List<Integer> intSkipCount(int[] numbers, int n) {
        List<Integer> afterNNumbers = Arrays.stream(numbers).skip(n).boxed().toList();
        return afterNNumbers;
    }

    public List<String> stringSkip() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        List<String> afterNNumbers = Arrays.stream(words).skip(3).toList();
        return afterNNumbers;
    }

    public List<String> longStringSkip() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        List<String> after3Words = Arrays.stream(words).filter(w -> w.length() > 5).skip(3).toList();
        return after3Words;
    }

    public List<Integer> stringLengthSkip() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        List<Integer> after3Words = Arrays.stream(words).map(w -> w.length()).skip(3).toList();
        return after3Words;
    }

    public List<String> stringSkipCount(int n) {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        List<String> afterNWords = Arrays.stream(words).skip(3).toList();
        return afterNWords;
    }

    public List<String> stringSkipCount(String[] strings, int n) {
        List<String> afterNWords = Arrays.stream(strings).skip(3).toList();
        return afterNWords;
    }

    public List<Product> productSkip() {
        List<Product> products = getProductList();
        List<Product> after3Products = products.stream().skip(3).toList();
        return after3Products;
    }

    public List<Product> expensiveProductSkip() {
        List<Product> products = getProductList();
        List<Product> after3Products = products.stream().filter(p -> p.getUnitPrice() > 100).skip(3).toList();
        return after3Products;
    }

    public List<Product> inStockProductSkip() {
        List<Product> products = getProductList();
        List<Product> after3Products = products.stream().filter(p -> p.getUnitsInStock() > 100).skip(3).toList();
        return after3Products;
    }

    public Map<String, List<Product>> productGroupSkip() {
        List<Product> products = getProductList();
        Map<String, List<Product>> after3Groups = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().skip(3).collect(toMap(g -> g.getKey(), g -> g.getValue()));
        return after3Groups;
    }

    public Map<String, List<Product>> productEachGroupSkip() {
        List<Product> products = getProductList();
        Map<String, List<Product>> after3EachGroups = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().skip(3).toList()));
        return after3EachGroups;
    }

    public List<Order> customerOrdersSkip() {
        List<Customer> customers = getCustomerList();
        List<Order> after3Orders = customers.stream().flatMap(c -> c.getOrders().stream()).skip(3).toList();
        return after3Orders;
    }

    public List<Pair<String, LocalDate>> customerOrdersNestedSkip() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, LocalDate>> after3Orders = customers.stream().flatMap(c -> c.getOrders().stream()
                .map(o -> Pair.with(c.getCustomerId(), o.getOrderDate()))).skip(3).toList();
        return after3Orders;
    }

    public List<Pair<String, LocalDate>> customerOrdersEachNestedSkip() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, LocalDate>> after3EachOrders = customers.stream().flatMap(c -> c.getOrders().stream().skip(3)
                .map(o -> Pair.with(c.getCustomerId(), o.getOrderDate()))).toList();
        return after3EachOrders;
    }

    public List<Pair<String, LocalDate>> waCustomerOrdersNestedSkip() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, LocalDate>> after3WAOrders = customers.stream().filter(c -> c.getRegion().equals("WA"))
                .flatMap(c -> c.getOrders().stream().map(o ->
                        Pair.with(c.getCustomerId(), o.getOrderDate()))).skip(3).toList();
        return after3WAOrders;
    }

    public List<Pair<String, LocalDate>> waCustomerOrdersEachNestedSkip() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, LocalDate>> after3EachWAOrders = customers.stream().filter(c -> c.getRegion().equals("WA"))
                .flatMap(c -> c.getOrders().stream().skip(3).map(o ->
                        Pair.with(c.getCustomerId(), o.getOrderDate()))).toList();
        return after3EachWAOrders;
    }

    public List<Integer> intSkipWhile() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> after3Numbers = Arrays.stream(numbers).dropWhile(i -> i > 3).boxed().toList();
        return after3Numbers;
    }

    public List<Integer> oddIntSkipWhile() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> after3Numbers = Arrays.stream(numbers).filter(i -> i % 2 == 1).dropWhile(i -> i > 3).boxed().toList();
        return after3Numbers;
    }

    public List<Integer> intSquareSkipWhile() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> after3Numbers = Arrays.stream(numbers).map(i -> i * i).dropWhile(i -> i > 3).boxed().toList();
        return after3Numbers;
    }

    public List<Integer> intSkipWhileCount(int n) {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> after3Numbers = Arrays.stream(numbers).dropWhile(i -> i > n).boxed().toList();
        return after3Numbers;
    }

    public List<Integer> intSkipWhileCount(int[] numbers, int n) {
        List<Integer> afterNNumbers = Arrays.stream(numbers).dropWhile(i -> i > n).boxed().toList();
        return afterNNumbers;
    }

    public List<String> stringSkipWhile() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        List<String> afterNNumbers = Arrays.stream(words).dropWhile(w -> w.charAt(0) > 'b').toList();
        return afterNNumbers;
    }

    public List<String> longStringSkipWhile() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        List<String> after3Words = Arrays.stream(words).filter(w -> w.length() > 5).dropWhile(w -> w.charAt(0) > 'b').toList();
        return after3Words;
    }

    public List<Integer> stringLengthSkipWhile() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        List<Integer> after3Words = Arrays.stream(words).map(w -> w.length()).dropWhile(n -> n > 5).toList();
        return after3Words;
    }

    public List<String> stringSkipWhileCount(char c) {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        List<String> afterNWords = Arrays.stream(words).dropWhile(w -> w.charAt(0) > c).toList();
        return afterNWords;
    }

    public List<String> stringSkipWhileCount(String[] strings, char c) {
        List<String> afterNWords = Arrays.stream(strings).dropWhile(w -> w.charAt(0) > c).toList();
        return afterNWords;
    }

    public List<Product> productSkipWhile() {
        List<Product> products = getProductList();
        List<Product> after3Products = products.stream().dropWhile(p -> p.getProductId() > 100).toList();
        return after3Products;
    }

    public List<Product> expensiveProductSkipWhile() {
        List<Product> products = getProductList();
        List<Product> after3Products = products.stream().filter(p -> p.getUnitPrice() > 100).dropWhile(p -> p.getProductId() > 100).toList();
        return after3Products;
    }

    public List<Product> inStockProductSkipWhile() {
        List<Product> products = getProductList();
        List<Product> after3Products = products.stream().filter(p -> p.getUnitsInStock() > 100).dropWhile(p -> p.getProductId() > 100).toList();
        return after3Products;
    }

    public Map<String, List<Product>> productGroupSkipWhile() {
        List<Product> products = getProductList();
        Map<String, List<Product>> after3Groups = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().dropWhile(g -> g.getKey().length() > 6).collect(toMap(g -> g.getKey(), g -> g.getValue()));
        return after3Groups;
    }

    public Map<String, List<Product>> productEachGroupSkipWhile() {
        List<Product> products = getProductList();
        Map<String, List<Product>> after3EachGroups = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().dropWhile(p -> p.getProductId() > 100).toList()));
        return after3EachGroups;
    }

    public List<Order> customerOrdersSkipWhile() {
        List<Customer> customers = getCustomerList();
        List<Order> after3Orders = customers.stream().flatMap(c -> c.getOrders().stream())
                .dropWhile(o -> o.getOrderDate().isAfter(LocalDate.of(2000, 1, 1))).toList();
        return after3Orders;
    }

    public List<Pair<String, LocalDate>> customerOrdersNestedSkipWhile() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, LocalDate>> after3Orders = customers.stream().flatMap(c -> c.getOrders().stream()
                        .map(o -> Pair.with(c.getCustomerId(), o.getOrderDate())))
                .dropWhile(t -> t.getValue1().isAfter(LocalDate.of(2000, 1, 1))).toList();
        return after3Orders;
    }

    public List<Pair<String, LocalDate>> customerOrdersEachNestedSkipWhile() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, LocalDate>> after3EachOrders = customers.stream().flatMap(c -> c.getOrders().stream()
                .dropWhile(o -> o.getOrderDate().isAfter(LocalDate.of(2000, 1, 1)))
                .map(o -> Pair.with(c.getCustomerId(), o.getOrderDate()))).toList();
        return after3EachOrders;
    }

    public List<Pair<String, LocalDate>> waCustomerOrdersNestedSkipWhile() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, LocalDate>> after3WAOrders = customers.stream().filter(c -> c.getRegion().equals("WA"))
                .flatMap(c -> c.getOrders().stream().map(o -> Pair.with(c.getCustomerId(), o.getOrderDate())))
                .dropWhile(t -> t.getValue1().isAfter(LocalDate.of(2000, 1, 1))).toList();
        return after3WAOrders;
    }

    public List<Pair<String, LocalDate>> waCustomerOrdersEachNestedSkipWhile() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, LocalDate>> after3EachWAOrders = customers.stream().filter(c -> c.getRegion().equals("WA"))
                .flatMap(c -> c.getOrders().stream().dropWhile(o -> o.getOrderDate()
                                .isAfter(LocalDate.of(2000, 1, 1)))
                        .map(o -> Pair.with(c.getCustomerId(), o.getOrderDate()))).toList();
        return after3EachWAOrders;
    }

    public List<Integer> intSkipWhileIndexed() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> afterNumbers = IntStream.range(0, numbers.length)
                .dropWhile(i -> numbers[i] > i).map(i -> numbers[i]).boxed().toList();
        return afterNumbers;
    }

    public List<Integer> intSquareSkipWhileIndexed() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> afterNumbers =  IntStream.range(0, numbers.length)
                .dropWhile(i -> numbers[i]*numbers[i] > i).map(i -> numbers[i]*numbers[i]).boxed().toList();
        return afterNumbers;
    }

    public List<Double> intSqrtSkipWhileIndexed() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Double> afterNumbers =  IntStream.range(0, numbers.length)
                .dropWhile(i -> Math.sqrt(numbers[i]) > i).mapToDouble(i -> Math.sqrt(numbers[i]) ).boxed().toList();
        return afterNumbers;
    }

    public List<Integer> intSkipWhileIndexedCount(int n) {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> afterNumbers = IntStream.range(0, numbers.length)
                .dropWhile(i -> n > i).map(i -> numbers[i]).boxed().toList();
        return afterNumbers;
    }

    public List<Integer> intSkipWhileIndexedCount(int[] numbers, int n) {
        List<Integer> afterNumbers = IntStream.range(0, numbers.length)
                .dropWhile(i -> n > i).map(i -> numbers[i]).boxed().toList();
        return afterNumbers;
    }
}
