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
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class TakeMethods {
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public List<Integer> intTake() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> after3Numbers = Arrays.stream(numbers).limit(3).boxed().toList();
        return after3Numbers;
    }

    public List<Integer> oddIntTake() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> after3Numbers = Arrays.stream(numbers).filter(i -> i % 2 == 1).limit(3).boxed().toList();
        return after3Numbers;
    }

    public List<Integer> intSquareTake() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> after3Numbers = Arrays.stream(numbers).map(i -> i * i).limit(3).boxed().toList();
        return after3Numbers;
    }

    public List<Integer> intTakeCount(int n) {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> after3Numbers = Arrays.stream(numbers).limit(n).boxed().toList();
        return after3Numbers;
    }

    public List<Integer> intTakeCount(int[] numbers, int n) {
        List<Integer> afterNNumbers = Arrays.stream(numbers).limit(n).boxed().toList();
        return afterNNumbers;
    }

    public List<String> stringTake() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        List<String> afterNNumbers = Arrays.stream(words).limit(3).toList();
        return afterNNumbers;
    }

    public List<String> longStringTake() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        List<String> after3Words = Arrays.stream(words).filter(w -> w.length() > 5).limit(3).toList();
        return after3Words;
    }

    public List<Integer> stringLengthTake() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        List<Integer> after3Words = Arrays.stream(words).map(w -> w.length()).limit(3).toList();
        return after3Words;
    }

    public List<String> stringTakeCount(int n) {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        List<String> afterNWords = Arrays.stream(words).limit(3).toList();
        return afterNWords;
    }

    public List<String> stringTakeCount(String[] strings, int n) {
        List<String> afterNWords = Arrays.stream(strings).limit(3).toList();
        return afterNWords;
    }

    public List<Product> productTake() {
        List<Product> products = getProductList();
        List<Product> after3Products = products.stream().limit(3).toList();
        return after3Products;
    }

    public List<Product> expensiveProductTake() {
        List<Product> products = getProductList();
        List<Product> after3Products = products.stream().filter(p -> p.getUnitPrice() > 100).limit(3).toList();
        return after3Products;
    }

    public List<Product> inStockProductTake() {
        List<Product> products = getProductList();
        List<Product> after3Products = products.stream().filter(p -> p.getUnitsInStock() > 100).limit(3).toList();
        return after3Products;
    }

    public Map<String, List<Product>> productGroupTake() {
        List<Product> products = getProductList();
        Map<String, List<Product>> after3Groups = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().limit(3).collect(toMap(g -> g.getKey(), g -> g.getValue()));
        return after3Groups;
    }

    public Map<String, List<Product>> productEachGroupTake() {
        List<Product> products = getProductList();
        Map<String, List<Product>> after3EachGroups = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().limit(3).toList()));
        return after3EachGroups;
    }

    public List<Order> customerOrdersTake() {
        List<Customer> customers = getCustomerList();
        List<Order> after3Orders = customers.stream().flatMap(c -> c.getOrders().stream()).limit(3).toList();
        return after3Orders;
    }

    public List<Pair<String, LocalDate>> customerOrdersNestedTake() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, LocalDate>> after3Orders = customers.stream().flatMap(c -> c.getOrders().stream()
                .map(o -> Pair.with(c.getCustomerId(), o.getOrderDate()))).limit(3).toList();
        return after3Orders;
    }

    public List<Pair<String, LocalDate>> customerOrdersEachNestedTake() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, LocalDate>> after3EachOrders = customers.stream().flatMap(c -> c.getOrders().stream().limit(3)
                .map(o -> Pair.with(c.getCustomerId(), o.getOrderDate()))).toList();
        return after3EachOrders;
    }

    public List<Pair<String, LocalDate>> waCustomerOrdersNestedTake() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, LocalDate>> after3WAOrders = customers.stream().filter(c -> c.getRegion().equals("WA"))
                .flatMap(c -> c.getOrders().stream().map(o ->
                        Pair.with(c.getCustomerId(), o.getOrderDate()))).limit(3).toList();
        return after3WAOrders;
    }

    public List<Pair<String, LocalDate>> waCustomerOrdersEachNestedTake() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, LocalDate>> after3EachWAOrders = customers.stream().filter(c -> c.getRegion().equals("WA"))
                .flatMap(c -> c.getOrders().stream().limit(3).map(o ->
                        Pair.with(c.getCustomerId(), o.getOrderDate()))).toList();
        return after3EachWAOrders;
    }

    public List<Integer> intTakeWhile() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> after3Numbers = Arrays.stream(numbers).takeWhile(i -> i > 3).boxed().toList();
        return after3Numbers;
    }

    public List<Integer> oddIntTakeWhile() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> after3Numbers = Arrays.stream(numbers).filter(i -> i % 2 == 1).takeWhile(i -> i > 3).boxed().toList();
        return after3Numbers;
    }

    public List<Integer> intSquareTakeWhile() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> after3Numbers = Arrays.stream(numbers).map(i -> i * i).takeWhile(i -> i > 3).boxed().toList();
        return after3Numbers;
    }

    public List<Integer> intTakeWhileCount(int n) {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> after3Numbers = Arrays.stream(numbers).takeWhile(i -> i > n).boxed().toList();
        return after3Numbers;
    }

    public List<Integer> intTakeWhileCount(int[] numbers, int n) {
        List<Integer> afterNNumbers = Arrays.stream(numbers).takeWhile(i -> i > n).boxed().toList();
        return afterNNumbers;
    }

    public List<String> stringTakeWhile() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        List<String> afterNNumbers = Arrays.stream(words).takeWhile(w -> w.charAt(0) > 'b').toList();
        return afterNNumbers;
    }

    public List<String> longStringTakeWhile() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        List<String> after3Words = Arrays.stream(words).filter(w -> w.length() > 5).takeWhile(w -> w.charAt(0) > 'b').toList();
        return after3Words;
    }

    public List<Integer> stringLengthTakeWhile() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        List<Integer> after3Words = Arrays.stream(words).map(w -> w.length()).takeWhile(n -> n > 5).toList();
        return after3Words;
    }

    public List<String> stringTakeWhileCount(char c) {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        List<String> afterNWords = Arrays.stream(words).takeWhile(w -> w.charAt(0) > c).toList();
        return afterNWords;
    }

    public List<String> stringTakeWhileCount(String[] strings, char c) {
        List<String> afterNWords = Arrays.stream(strings).takeWhile(w -> w.charAt(0) > c).toList();
        return afterNWords;
    }

    public List<Product> productTakeWhile() {
        List<Product> products = getProductList();
        List<Product> after3Products = products.stream().takeWhile(p -> p.getProductId() > 100).toList();
        return after3Products;
    }

    public List<Product> expensiveProductTakeWhile() {
        List<Product> products = getProductList();
        List<Product> after3Products = products.stream().filter(p -> p.getUnitPrice() > 100).takeWhile(p -> p.getProductId() > 100).toList();
        return after3Products;
    }

    public List<Product> inStockProductTakeWhile() {
        List<Product> products = getProductList();
        List<Product> after3Products = products.stream().filter(p -> p.getUnitsInStock() > 100).takeWhile(p -> p.getProductId() > 100).toList();
        return after3Products;
    }

    public Map<String, List<Product>> productGroupTakeWhile() {
        List<Product> products = getProductList();
        Map<String, List<Product>> after3Groups = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().takeWhile(g -> g.getKey().length() > 6).collect(toMap(g -> g.getKey(), g -> g.getValue()));
        return after3Groups;
    }

    public Map<String, List<Product>> productEachGroupTakeWhile() {
        List<Product> products = getProductList();
        Map<String, List<Product>> after3EachGroups = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().takeWhile(p -> p.getProductId() > 100).toList()));
        return after3EachGroups;
    }

    public List<Order> customerOrdersTakeWhile() {
        List<Customer> customers = getCustomerList();
        List<Order> after3Orders = customers.stream().flatMap(c -> c.getOrders().stream())
                .takeWhile(o -> o.getOrderDate().isAfter(LocalDate.of(2000, 1, 1))).toList();
        return after3Orders;
    }

    public List<Pair<String, LocalDate>> customerOrdersNestedTakeWhile() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, LocalDate>> after3Orders = customers.stream().flatMap(c -> c.getOrders().stream()
                        .map(o -> Pair.with(c.getCustomerId(), o.getOrderDate())))
                .takeWhile(t -> t.getValue1().isAfter(LocalDate.of(2000, 1, 1))).toList();
        return after3Orders;
    }

    public List<Pair<String, LocalDate>> customerOrdersEachNestedTakeWhile() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, LocalDate>> after3EachOrders = customers.stream().flatMap(c -> c.getOrders().stream()
                .takeWhile(o -> o.getOrderDate().isAfter(LocalDate.of(2000, 1, 1)))
                .map(o -> Pair.with(c.getCustomerId(), o.getOrderDate()))).toList();
        return after3EachOrders;
    }

    public List<Pair<String, LocalDate>> waCustomerOrdersNestedTakeWhile() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, LocalDate>> after3WAOrders = customers.stream().filter(c -> c.getRegion().equals("WA"))
                .flatMap(c -> c.getOrders().stream().map(o -> Pair.with(c.getCustomerId(), o.getOrderDate())))
                .takeWhile(t -> t.getValue1().isAfter(LocalDate.of(2000, 1, 1))).toList();
        return after3WAOrders;
    }

    public List<Pair<String, LocalDate>> waCustomerOrdersEachNestedTakeWhile() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, LocalDate>> after3EachWAOrders = customers.stream().filter(c -> c.getRegion().equals("WA"))
                .flatMap(c -> c.getOrders().stream().takeWhile(o -> o.getOrderDate()
                                .isAfter(LocalDate.of(2000, 1, 1)))
                        .map(o -> Pair.with(c.getCustomerId(), o.getOrderDate()))).toList();
        return after3EachWAOrders;
    }

    public List<Integer> intTakeWhileIndexed() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> afterNumbers = IntStream.range(0, numbers.length)
                .takeWhile(i -> numbers[i] > i).map(i -> numbers[i]).boxed().toList();
        return afterNumbers;
    }

    public List<Integer> intSquareTakeWhileIndexed() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> afterNumbers =  IntStream.range(0, numbers.length)
                .takeWhile(i -> numbers[i]*numbers[i] > i).map(i -> numbers[i]*numbers[i]).boxed().toList();
        return afterNumbers;
    }

    public List<Double> intSqrtTakeWhileIndexed() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Double> afterNumbers =  IntStream.range(0, numbers.length)
                .takeWhile(i -> Math.sqrt(numbers[i]) > i).mapToDouble(i -> Math.sqrt(numbers[i]) ).boxed().toList();
        return afterNumbers;
    }

    public List<Integer> intTakeWhileIndexedCount(int n) {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> afterNumbers = IntStream.range(0, numbers.length)
                .takeWhile(i -> n > i).map(i -> numbers[i]).boxed().toList();
        return afterNumbers;
    }

    public List<Integer> intTakeWhileIndexedCount(int[] numbers, int n) {
        List<Integer> afterNumbers = IntStream.range(0, numbers.length)
                .takeWhile(i -> n > i).map(i -> numbers[i]).boxed().toList();
        return afterNumbers;
    }

}
