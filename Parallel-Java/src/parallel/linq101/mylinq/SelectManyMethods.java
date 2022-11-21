package parallel.linq101.mylinq;

import org.javatuples.Pair;
import org.javatuples.Triplet;
import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Order;
import parallel.linq101.datasource.Product;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SelectManyMethods {
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public Pair<Integer, Integer>[] selectManyJoin() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8};
        Pair<Integer, Integer>[] pairs = (Pair<Integer, Integer>[]) Arrays.stream(numbersA).boxed().flatMap(
                a -> Arrays.stream(numbersB).mapToObj(b -> Pair.with(a, b))).toArray();
        return pairs;
    }

    public Pair<Integer, Integer>[] selectManyJoinOdd() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8};
        Pair<Integer, Integer>[] pairs = (Pair<Integer, Integer>[]) Arrays.stream(numbersA).boxed().flatMap(a -> Arrays.stream(numbersB)
                .filter(b -> b % 2 == 1).mapToObj(b -> Pair.with(a, b))).toArray();
        return pairs;
    }

    public Pair<Integer, Integer>[] selectManyJoinBig() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8};
        Pair<Integer, Integer>[] pairs = (Pair<Integer, Integer>[]) Arrays.stream(numbersA).boxed().flatMap(a -> Arrays.stream(numbersB)
                .filter(b -> b > 5).mapToObj(b -> Pair.with(a, b))).toArray();
        return pairs;
    }

    public Pair<Integer, Integer>[] selectManyJoinSmaller() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8};
        Pair<Integer, Integer>[] pairs = (Pair<Integer, Integer>[]) Arrays.stream(numbersA).boxed().flatMap(a -> Arrays.stream(numbersB)
                .filter(b -> a < b).mapToObj(b -> Pair.with(a, b))).toArray();
        return pairs;
    }

    public Pair<Integer, Integer>[] selectManyJoinSumEven() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8};
        Pair<Integer, Integer>[] pairs = (Pair<Integer, Integer>[]) Arrays.stream(numbersA).boxed().flatMap(a -> Arrays.stream(numbersB)
                .filter(b -> (a + b) % 2 == 0).mapToObj(b -> Pair.with(a, b))).toArray();
        return pairs;
    }

    public List<Order> customerSelectManyOrders() {
        List<Customer> customers = getCustomerList();
        List<Order> customerProperties = customers.stream().flatMap(c -> c.getOrders().stream()).toList();
        return customerProperties;
    }

    public List<Pair<String, Order>> customerSelectManyCustomerOrders() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Order>> customerProperties = customers.stream().flatMap(c -> c.getOrders()
                .stream().map(o -> Pair.with(c.getCustomerId(), o))).toList();
        return customerProperties;
    }

    public List<Pair<String, LocalDate>> customerSelectManyCustomerOrderDates() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, LocalDate>> customerProperties = customers.stream().flatMap(c -> c.getOrders()
                .stream().map(o -> Pair.with(c.getCustomerId(), o.getOrderDate()))).toList();
        return customerProperties;
    }

    public List<Triplet<String, Integer, Double>> customerSelectManyCustomerOrderIdAndTotals() {
        List<Customer> customers = getCustomerList();
        List<Triplet<String, Integer, Double>> customerProperties = customers.stream().flatMap(c -> c.getOrders()
                .stream().map(o -> Triplet.with(c.getCustomerId(), o.getOrderId(), o.getTotal()))).toList();
        return customerProperties;
    }

    public List<Triplet<String, Integer, Integer>> customerSelectManyCustomerOrderDateYearAndMonth() {
        List<Customer> customers = getCustomerList();
        List<Triplet<String, Integer, Integer>> customerProperties = customers.stream().flatMap(c -> c.getOrders()
                .stream().map(o -> Triplet.with(c.getCustomerId(), o.getOrderDate().getYear(), o.getOrderDate().getMonthValue()))).toList();
        return customerProperties;
    }

    public List<Order> customerSelectManyBigOrders() {
        List<Customer> customers = getCustomerList();
        List<Order> customerProperties = customers.stream().flatMap(c -> c.getOrders()
                .stream().filter(o -> o.getTotal() > 100)).toList();
        return customerProperties;
    }

    public List<Pair<String, Order>> customerSelectManyCustomerBigOrders() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Order>> customerProperties = customers.stream().flatMap(c -> c.getOrders()
                .stream().filter(o -> o.getTotal() > 100).map(o -> Pair.with(c.getCustomerId(), o))).toList();
        return customerProperties;
    }

    public List<Pair<String, LocalDate>> customerSelectManyCustomerBigOrderDates() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, LocalDate>> customerProperties = customers.stream().flatMap(c -> c.getOrders()
                .stream().filter(o -> o.getTotal() > 100).map(o -> Pair.with(c.getCustomerId(), o.getOrderDate()))).toList();
        return customerProperties;
    }

    public List<Triplet<String, Integer, Double>> customerSelectManyCustomerBigOrderIdAndTotals() {
        List<Customer> customers = getCustomerList();
        List<Triplet<String, Integer, Double>> customerProperties = customers.stream().flatMap(c -> c.getOrders()
                .stream().filter(o -> o.getTotal() > 100).map(o -> Triplet.with(c.getCustomerId(), o.getOrderId(), o.getTotal()))).toList();
        return customerProperties;
    }

    public List<Triplet<String, Integer, Integer>> customerSelectManyCustomerBigOrderDateYearAndMonth() {
        List<Customer> customers = getCustomerList();
        List<Triplet<String, Integer, Integer>> customerProperties = customers.stream().flatMap(c -> c.getOrders()
                .stream().filter(o -> o.getTotal() > 100).map(o ->
                        Triplet.with(c.getCustomerId(), o.getOrderDate().getYear(), o.getOrderDate().getMonthValue()))).toList();
        return customerProperties;
    }

    public List<Order> customerSelectManyNewOrders() {
        List<Customer> customers = getCustomerList();
        List<Order> customerProperties = customers.stream().flatMap(c -> c.getOrders()
                .stream().filter(o -> o.getOrderDate().isAfter(LocalDate.of(1998, 1, 1)))).toList();
        return customerProperties;
    }

    public List<Pair<String, Order>> customerSelectManyCustomerNewOrders() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Order>> customerProperties = customers.stream().flatMap(c -> c.getOrders()
                .stream().filter(o -> o.getOrderDate().isAfter(LocalDate.of(1998, 1, 1)))
                .map(o -> Pair.with(c.getCustomerId(), o))).toList();
        return customerProperties;
    }

    public List<Pair<String, LocalDate>> customerSelectManyCustomerNewOrderDates() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, LocalDate>> customerProperties = customers.stream().flatMap(c -> c.getOrders()
                .stream().filter(o -> o.getOrderDate().isAfter(LocalDate.of(1998, 1, 1)))
                .map(o -> Pair.with(c.getCustomerId(), o.getOrderDate()))).toList();
        return customerProperties;
    }

    public List<Triplet<String, Integer, Double>> customerSelectManyCustomerNewOrderIdAndTotals() {
        List<Customer> customers = getCustomerList();
        List<Triplet<String, Integer, Double>> customerProperties = customers.stream().flatMap(c -> c.getOrders()
                .stream().filter(o -> o.getOrderDate().isAfter(LocalDate.of(1998, 1, 1)))
                .map(o -> Triplet.with(c.getCustomerId(), o.getOrderId(), o.getTotal()))).toList();
        return customerProperties;
    }

    public List<Triplet<String, Integer, Integer>> customerSelectManyCustomerNewOrderDateYearAndMonth() {
        List<Customer> customers = getCustomerList();
        List<Triplet<String, Integer, Integer>> customerProperties = customers.stream().flatMap(c -> c.getOrders()
                .stream().filter(o -> o.getOrderDate().isAfter(LocalDate.of(1998, 1, 1)))
                .map(o -> Triplet.with(c.getCustomerId(), o.getOrderDate().getYear(), o.getOrderDate().getMonthValue()))).toList();
        return customerProperties;
    }

    public List<Order> waCustomerSelectManyNewOrders() {
        List<Customer> customers = getCustomerList();
        List<parallel.linq101.datasource.Order> customerProperties = customers.stream().filter(c -> c.getRegion().equals("WA")).flatMap(c -> c.getOrders()
                .stream().filter(o -> o.getOrderDate().isAfter(LocalDate.of(1998, 1, 1)))).toList();
        return customerProperties;
    }

    public List<Pair<String, Order>> waCustomerSelectManyCustomerNewOrders() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Order>> customerProperties = customers.stream().filter(c -> c.getRegion().equals("WA")).flatMap(c -> c.getOrders()
                .stream().filter(o -> o.getOrderDate().isAfter(LocalDate.of(1998, 1, 1)))
                .map(o -> Pair.with(c.getCustomerId(), o))).toList();
        return customerProperties;
    }

    public List<Pair<String, LocalDate>> waCustomerSelectManyCustomerNewOrderDates() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, LocalDate>> customerProperties = customers.stream().filter(c -> c.getRegion().equals("WA")).flatMap(c -> c.getOrders()
                .stream().filter(o -> o.getOrderDate().isAfter(LocalDate.of(1998, 1, 1)))
                .map(o -> Pair.with(c.getCustomerId(), o.getOrderDate()))).toList();
        return customerProperties;
    }

    public List<Triplet<String, Integer, Double>> waCustomerSelectManyCustomerNewOrderIdAndTotals() {
        List<Customer> customers = getCustomerList();
        List<Triplet<String, Integer, Double>> customerProperties = customers.stream().filter(c -> c.getRegion().equals("WA")).flatMap(c -> c.getOrders()
                .stream().filter(o -> o.getOrderDate().isAfter(LocalDate.of(1998, 1, 1)))
                .map(o -> Triplet.with(c.getCustomerId(), o.getOrderId(), o.getTotal()))).toList();
        return customerProperties;
    }

    public List<Triplet<String, Integer, Integer>> waCustomerSelectManyCustomerNewOrderDateYearAndMonth() {
        List<Customer> customers = getCustomerList();
        List<Triplet<String, Integer, Integer>> customerProperties = customers.stream().filter(c -> c.getRegion().equals("WA")).flatMap(c -> c.getOrders()
                .stream().filter(o -> o.getOrderDate().isAfter(LocalDate.of(1998, 1, 1)))
                .map(o -> Triplet.with(c.getCustomerId(), o.getOrderDate().getYear(), o.getOrderDate().getMonthValue()))).toList();
        return customerProperties;
    }

    public int[] indexedSelectMany() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8};
        int[] pairs = IntStream.range(0, numbersA.length).flatMap(i -> Arrays.stream(numbersB).map(
                b -> i % 2 == 0 ? numbersA[i] : b)).toArray();
        return pairs;
    }

    public int[] indexedSelectManyBig() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8};
        int[] pairs = IntStream.range(0, numbersA.length).flatMap(i -> Arrays.stream(numbersB).filter(
                b ->b<numbersA[i]+i)).toArray();
        return pairs;
    }

    public List<Order> customerIndexedSelectManyOrdersTake() {
        List<Customer> customers = getCustomerList();
        List<Order> customerProperties = IntStream.range(0, customers.size()).boxed().
                flatMap(i -> customers.get(i).getOrders().stream().limit(i<10?5:1)).toList();
        return customerProperties;
    }

    public List<Order> waCustomerIndexedSelectManyOrdersTake() {
        List<Customer> customers = getCustomerList();
        List<Order> customerProperties = IntStream.range(0, customers.size()).boxed().filter(i->customers.get(i).getRegion().equals("WA"))
                .flatMap(i -> customers.get(i).getOrders().stream().limit(i<10?5:1)).toList();
        return customerProperties;
    }

    public List<String> indexedSelectManyString() { 
        List<Customer> customers = getCustomerList();
        List<String> customerOrders = IntStream.range(0, customers.size()).boxed().flatMap(
                        i -> customers.get(i).getOrders().stream().map(
                                o -> "Customer #" + (i + 1) + " has an order with OrderID " + o.getOrderId()))
                .collect(Collectors.toList());
        return customerOrders;
    }
}
