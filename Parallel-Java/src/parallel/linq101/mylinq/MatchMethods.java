package parallel.linq101.mylinq;

import org.javatuples.Pair;
import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Product;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class MatchMethods {
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public boolean intAllMatch() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        boolean allMatch = Arrays.stream(numbers).allMatch(n -> n > 3);
        return allMatch;
    }

    public boolean oddIntAllMatch() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        boolean allMatch = Arrays.stream(numbers).filter(i -> i % 2 == 1).allMatch(n -> n > 3);
        return allMatch;
    }

    public boolean intSquareAllMatch() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        boolean allMatch = Arrays.stream(numbers).map(i -> i * i).allMatch(n -> n > 3);
        return allMatch;
    }

    public boolean intAllMatchInput(int i) {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        boolean allMatch = Arrays.stream(numbers).allMatch(n -> n > i);
        return allMatch;
    }

    public boolean intAllMatchInput(int[] numbers, int i) {
        boolean allMatch = Arrays.stream(numbers).allMatch(n -> n > i);
        return allMatch;
    }

    public boolean stringAllMatch() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        boolean allMatch = Arrays.stream(words).allMatch(n -> n.compareTo("b") > 0);
        return allMatch;
    }

    public boolean longStringAllMatch() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        boolean allMatch = Arrays.stream(words).filter(w -> w.length() > 5).allMatch(n -> n.compareTo("b") > 0);
        return allMatch;
    }

    public boolean stringLengthAllMatch() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        boolean allMatch = Arrays.stream(words).map(w -> w.length()).allMatch(n -> n > 5);
        return allMatch;
    }

    public boolean stringAllMatch(char c) {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        boolean allMatch = Arrays.stream(words).allMatch(w -> w.charAt(0) > c);
        return allMatch;
    }

    public boolean stringAllMatchCount(String[] strings, char c) {
        boolean allMatch = Arrays.stream(strings).allMatch(w -> w.charAt(0) > c);
        return allMatch;
    }

    public boolean productAllMatch() {
        List<Product> products = getProductList();
        boolean allMatch = products.stream().allMatch(p -> p.getUnitsInStock() > 0);
        return allMatch;
    }

    public boolean expensiveProductAllMatch() {
        List<Product> products = getProductList();
        boolean allMatch = products.stream().filter(p -> p.getUnitPrice() > 100).allMatch(p -> p.getUnitsInStock() > 0);
        return allMatch;
    }

    public boolean categoryProductAllMatch() {
        List<Product> products = getProductList();
        boolean allMatch = products.stream().filter(p -> p.getCategory() == "Beverages").allMatch(p -> p.getUnitsInStock() > 0);
        return allMatch;
    }

    public Map<String, Boolean> productEachGroupAllMatch() {
        List<Product> products = getProductList();
        Map<String, Boolean> allMatch = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().allMatch(p -> p.getUnitsInStock() > 0)));
        return allMatch;
    }

    public Map<String, Boolean> expensiveProductEachGroupAllMatch() {
        List<Product> products = getProductList();
        Map<String, Boolean> allMatch = products.stream().filter(p -> p.getUnitPrice() > 100).collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().allMatch(p -> p.getUnitsInStock() > 0)));
        return allMatch;
    }

    public boolean customerOrdersAllMatch() {
        List<Customer> customers = getCustomerList();
        boolean allMatch = customers.stream().flatMap(c -> c.getOrders().stream())
                .allMatch(o -> o.getOrderDate().isAfter(LocalDate.of(2000, 1, 1)));
        return allMatch;
    }

    public boolean customerOrdersNestedAllMatch() {
        List<Customer> customers = getCustomerList();
        boolean allMatch = customers.stream().flatMap(c -> c.getOrders().stream()
                        .map(o -> Pair.with(c.getCustomerId(), o.getOrderDate())))
                .allMatch(t -> t.getValue1().isAfter(LocalDate.of(2000, 1, 1)));
        return allMatch;
    }

    public List<Boolean> customerOrdersEachNestedAllMatch() {
        List<Customer> customers = getCustomerList();
        List<Boolean> allMatch = customers.stream().map(c -> c.getOrders().stream().allMatch(o ->
                o.getOrderDate().isAfter(LocalDate.of(2000, 1, 1)))).toList();
        return allMatch;
    }

    public boolean waCustomerOrdersNestedAllMatch() {
        List<Customer> customers = getCustomerList();
        boolean allMatch = customers.stream().filter(c -> c.getRegion() == "WA").flatMap(c -> c.getOrders().stream()
                        .map(o -> Pair.with(c.getCustomerId(), o.getOrderDate())))
                .allMatch(t -> t.getValue1().isAfter(LocalDate.of(2000, 1, 1)));
        return allMatch;
    }

    public List<Boolean> waCustomerOrdersEachNestedAllMatch() {
        List<Customer> customers = getCustomerList();
        List<Boolean> allMatch = customers.stream().filter(c -> c.getRegion() == "WA").map(c -> c.getOrders().stream().allMatch(o ->
                o.getOrderDate().isAfter(LocalDate.of(2000, 1, 1)))).toList();
        return allMatch;
    }

    public boolean intAnyMatch() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        boolean anyMatch = Arrays.stream(numbers).anyMatch(n -> n > 3);
        return anyMatch;
    }

    public boolean oddIntAnyMatch() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        boolean anyMatch = Arrays.stream(numbers).filter(i -> i % 2 == 1).anyMatch(n -> n > 3);
        return anyMatch;
    }

    public boolean intSquareAnyMatch() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        boolean anyMatch = Arrays.stream(numbers).map(i -> i * i).anyMatch(n -> n > 3);
        return anyMatch;
    }

    public boolean intAnyMatchInput(int i) {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        boolean anyMatch = Arrays.stream(numbers).anyMatch(n -> n > i);
        return anyMatch;
    }

    public boolean intAnyMatchInput(int[] numbers, int i) {
        boolean anyMatch = Arrays.stream(numbers).anyMatch(n -> n > i);
        return anyMatch;
    }

    public boolean stringAnyMatch() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        boolean anyMatch = Arrays.stream(words).anyMatch(n -> n.compareTo("b") > 0);
        return anyMatch;
    }

    public boolean longStringAnyMatch() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        boolean anyMatch = Arrays.stream(words).filter(w -> w.length() > 5).anyMatch(n -> n.compareTo("b") > 0);
        return anyMatch;
    }

    public boolean stringLengthAnyMatch() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        boolean anyMatch = Arrays.stream(words).map(w -> w.length()).anyMatch(n -> n > 5);
        return anyMatch;
    }

    public boolean stringAnyMatch(char c) {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        boolean anyMatch = Arrays.stream(words).anyMatch(w -> w.charAt(0) > c);
        return anyMatch;
    }

    public boolean stringAnyMatchCount(String[] strings, char c) {
        boolean anyMatch = Arrays.stream(strings).anyMatch(w -> w.charAt(0) > c);
        return anyMatch;
    }

    public boolean productAnyMatch() {
        List<Product> products = getProductList();
        boolean anyMatch = products.stream().anyMatch(p -> p.getUnitsInStock() > 0);
        return anyMatch;
    }

    public boolean expensiveProductAnyMatch() {
        List<Product> products = getProductList();
        boolean anyMatch = products.stream().filter(p -> p.getUnitPrice() > 100).anyMatch(p -> p.getUnitsInStock() > 0);
        return anyMatch;
    }

    public boolean categoryProductAnyMatch() {
        List<Product> products = getProductList();
        boolean anyMatch = products.stream().filter(p -> p.getCategory() == "Beverages").anyMatch(p -> p.getUnitsInStock() > 0);
        return anyMatch;
    }

    public Map<String, Boolean> productEachGroupAnyMatch() {
        List<Product> products = getProductList();
        Map<String, Boolean> anyMatch = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().anyMatch(p -> p.getUnitsInStock() > 0)));
        return anyMatch;
    }

    public Map<String, Boolean> expensiveProductEachGroupAnyMatch() {
        List<Product> products = getProductList();
        Map<String, Boolean> anyMatch = products.stream().filter(p -> p.getUnitPrice() > 100).collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().anyMatch(p -> p.getUnitsInStock() > 0)));
        return anyMatch;
    }

    public boolean customerOrdersAnyMatch() {
        List<Customer> customers = getCustomerList();
        boolean anyMatch = customers.stream().flatMap(c -> c.getOrders().stream())
                .anyMatch(o -> o.getOrderDate().isAfter(LocalDate.of(2000, 1, 1)));
        return anyMatch;
    }

    public boolean customerOrdersNestedAnyMatch() {
        List<Customer> customers = getCustomerList();
        boolean anyMatch = customers.stream().flatMap(c -> c.getOrders().stream()
                        .map(o -> Pair.with(c.getCustomerId(), o.getOrderDate())))
                .anyMatch(t -> t.getValue1().isAfter(LocalDate.of(2000, 1, 1)));
        return anyMatch;
    }

    public List<Boolean> customerOrdersEachNestedAnyMatch() {
        List<Customer> customers = getCustomerList();
        List<Boolean> anyMatch = customers.stream().map(c -> c.getOrders().stream().anyMatch(o ->
                o.getOrderDate().isAfter(LocalDate.of(2000, 1, 1)))).toList();
        return anyMatch;
    }

    public boolean waCustomerOrdersNestedAnyMatch() {
        List<Customer> customers = getCustomerList();
        boolean anyMatch = customers.stream().filter(c -> c.getRegion() == "WA").flatMap(c -> c.getOrders().stream()
                        .map(o -> Pair.with(c.getCustomerId(), o.getOrderDate())))
                .anyMatch(t -> t.getValue1().isAfter(LocalDate.of(2000, 1, 1)));
        return anyMatch;
    }

    public List<Boolean> waCustomerOrdersEachNestedAnyMatch() {
        List<Customer> customers = getCustomerList();
        List<Boolean> anyMatch = customers.stream().filter(c -> c.getRegion() == "WA").map(c -> c.getOrders().stream().anyMatch(o ->
                o.getOrderDate().isAfter(LocalDate.of(2000, 1, 1)))).toList();
        return anyMatch;
    }

}
