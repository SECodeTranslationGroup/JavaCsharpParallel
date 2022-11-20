package parallel.linq101.mylinq;

import org.javatuples.Pair;
import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Order;
import parallel.linq101.datasource.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class FirstMethods {
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public int numbersFirst() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int firstNum = Arrays.stream(numbers).findFirst().getAsInt();
        return firstNum;
    }

    public int bigNumbersFirst() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int firstNum = Arrays.stream(numbers).filter(n -> n > 5).findFirst().getAsInt();
        return firstNum;
    }

    public int oddNumbersFirst() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int firstNum = Arrays.stream(numbers).filter(n -> n % 2 == 1).findFirst().getAsInt();
        return firstNum;
    }

    public double doubleFirst() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        double firstNum = Arrays.stream(numbers).findFirst().getAsDouble();
        return firstNum;
    }

    public double bigDoubleNumbersFirst() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        double firstNum = Arrays.stream(numbers).filter(d -> d > 5).findFirst().getAsDouble();
        return firstNum;
    }

    public String stringFirstStartWithO() {
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String startWithO = Arrays.stream(strings).filter(s -> s.charAt(0) == 'o').findFirst().get();
        return startWithO;
    }

    public String stringFirstStartWith(char c) {
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String startWithChar = Arrays.stream(strings).filter(s -> s.charAt(0) == c).findFirst().get();
        return startWithChar;
    }

    public String stringFirstLong() {
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String startsWithO = Arrays.stream(strings).filter(s -> s.length() > 4).findFirst().get();
        return startsWithO;
    }

    public int projectedBigNumbersFirst() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int firstNum = Arrays.stream(numbers).map(i -> (int) Math.pow(2, i)).filter(n -> n > 100).findFirst().getAsInt();
        return firstNum;
    }

    public double projectedDoubleFirst() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        double firstNum = Arrays.stream(numbers).map(i -> Math.log(i)).filter(n -> n > 3).findFirst().getAsDouble();
        return firstNum;
    }

    public int projectedStringFirst() {
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int firstStringLength = Arrays.stream(strings).mapToInt(s -> s.length()).filter(i -> i % 2 == 0).findFirst().getAsInt();
        return firstStringLength;
    }

    public Product productFirst() {
        List<Product> products = getProductList();
        Product product12 = products.stream().filter(p -> p.getProductId() == 12).findFirst().get();
        return product12;
    }

    public List<Pair<String, Product>> productEachCategoryFirst() {
        List<Product> products = getProductList();
        List<Pair<String, Product>> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().findFirst().get())).toList();
        return categories;
    }

    public Map<String, Product> productEachCategoryFirstDict() {
        List<Product> products = getProductList();
        Map<String, Product> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().findFirst().get()));
        return categories;
    }

    public List<Pair<String, Order>> customerEachRegionFirstOrder() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Order>> ordersFirst = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().flatMap(c -> c.getOrders().stream()).findFirst().get())).toList();
        return ordersFirst;
    }

    public Map<String, Order> customerEachRegionFirstOrderDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Order> ordersFirst = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().flatMap(c -> c.getOrders().stream()).findFirst().get()));
        return ordersFirst;
    }

    public List<Pair<String, List<Product>>> productEachCategoryFirstUnitPriceProducts() {
        List<Product> products = getProductList();
        List<Pair<String, List<Product>>> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().filter(p ->
                        p.getUnitPrice() == g.getValue().stream().findFirst().get().getUnitPrice()).toList())).toList();
        return categories;
    }

    public Map<String, List<Product>> productEachCategoryFirstUnitPriceProductsDict() {
        List<Product> products = getProductList();
        Map<String, List<Product>> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().filter(p ->
                                p.getUnitPrice() == g.getValue().stream().findFirst().get().getUnitPrice()).toList()));
        return categories;
    }

    public List<Pair<String, List<Customer>>> customerEachCountryOrdersFirstCustomer() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, List<Customer>>> customerOrdersFirst = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().filter(
                        c -> c.getOrders().size() == g.getValue().stream().findFirst().get().getOrders().size()).toList())).toList();
        return customerOrdersFirst;
    }

    public Map<String, List<Customer>> customerEachCountryOrdersFirstCustomerDict() {
        List<Customer> customers = getCustomerList();
        Map<String, List<Customer>> customerOrdersFirst = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g->g.getValue().stream().filter(
                        c -> c.getOrders().size() == g.getValue().stream().findFirst().get().getOrders().size()).toList()));
        return customerOrdersFirst;
    }

    public int numbersFirstOrDefaultOrDefault() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int firstNum = Arrays.stream(numbers).findFirst().orElse(-1);
        return firstNum;
    }

    public int bigNumbersFirstOrDefault() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int firstNum = Arrays.stream(numbers).filter(n -> n > 5).findFirst().orElse(0);
        return firstNum;
    }

    public int oddNumbersFirstOrDefault() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int firstNum = Arrays.stream(numbers).filter(n -> n % 2 == 1).findFirst().orElse(-2);
        return firstNum;
    }

    public double doubleFirstOrDefault() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        double firstNum = Arrays.stream(numbers).findFirst().orElse(3.14);
        return firstNum;
    }

    public double bigDoubleNumbersFirstOrDefault() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        double firstNum = Arrays.stream(numbers).filter(d -> d > 5).findFirst().orElse(-2.3);
        return firstNum;
    }

    public String stringFirstOrDefaultStartWithO() {
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String startWithO = Arrays.stream(strings).filter(s -> s.charAt(0) == 'o').findFirst().orElse("none");
        return startWithO;
    }

    public String stringFirstOrDefaultStartWith(char c) {
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String startWithChar = Arrays.stream(strings).filter(s -> s.charAt(0) == c).findFirst().orElse("none");
        return startWithChar;
    }

    public String stringFirstOrDefaultLong() {
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String startsWithO = Arrays.stream(strings).filter(s -> s.length() > 4).findFirst().orElse("empty");
        return startsWithO;
    }

    public int projectedBigNumbersFirstOrDefault() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int firstNum = Arrays.stream(numbers).map(i -> (int) Math.pow(2, i)).filter(n -> n > 100).findFirst().orElse(100);
        return firstNum;
    }

    public double projectedDoubleFirstOrDefault() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        double firstNum = Arrays.stream(numbers).map(i -> Math.log(i)).filter(n -> n > 3).findFirst().orElse(3.01);
        return firstNum;
    }

    public int projectedStringFirstOrDefault() {
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int firstStringLength = Arrays.stream(strings).mapToInt(s -> s.length()).filter(i -> i % 2 == 0).findFirst().orElse(-1);
        return firstStringLength;
    }

    public Product productFirstOrDefault() {
        List<Product> products = getProductList();
        Product product12 = products.stream().filter(p -> p.getProductId() == 12).findFirst().orElse(Product.DEFAULT);
        return product12;
    }

    public List<Pair<String, Product>> productEachCategoryFirstOrDefault() {
        List<Product> products = getProductList();
        List<Pair<String, Product>> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().findFirst().orElse(Product.DEFAULT))).toList();
        return categories;
    }

    public Map<String, Product> productEachCategoryFirstOrDefaultDict() {
        List<Product> products = getProductList();
        Map<String, Product> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().findFirst().orElse(Product.DEFAULT)));
        return categories;
    }

    public List<Pair<String, Order>> customerEachRegionFirstOrDefaultOrder() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Order>> ordersFirstOrDefault = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().flatMap(c -> c.getOrders().stream()).findFirst().orElse(Order.DEFAULT))).toList();
        return ordersFirstOrDefault;
    }

    public Map<String, Order> customerEachRegionFirstOrDefaultOrderDict() {
        List<Customer> customers = getCustomerList();
        Map<String, Order> ordersFirstOrDefault = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().flatMap(c -> c.getOrders().stream()).findFirst().orElse(Order.DEFAULT)));
        return ordersFirstOrDefault;
    }

    public List<Pair<String, List<Product>>> productEachCategoryFirstOrDefaultUnitPriceProducts() {
        List<Product> products = getProductList();
        List<Pair<String, List<Product>>> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().filter(p ->
                        p.getUnitPrice() == g.getValue().stream().findFirst().orElse(Product.DEFAULT).getUnitPrice()).toList())).toList();
        return categories;
    }

    public Map<String, List<Product>> productEachCategoryFirstOrDefaultUnitPriceProductsDict() {
        List<Product> products = getProductList();
        Map<String, List<Product>> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().filter(p ->
                                p.getUnitPrice() == g.getValue().stream().findFirst().orElse(Product.DEFAULT).getUnitPrice()).toList()));
        return categories;
    }

    public List<Pair<String, List<Customer>>> customerEachCountryOrdersFirstOrDefaultCustomer() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, List<Customer>>> customerOrdersFirstOrDefault = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().filter(
                        c -> c.getOrders().size() == g.getValue().stream().findFirst().orElse(Customer.DEFAULT).getOrders().size()).toList())).toList();
        return customerOrdersFirstOrDefault;
    }

    public Map<String, List<Customer>> customerEachCountryOrdersFirstOrDefaultCustomerDict() {
        List<Customer> customers = getCustomerList();
        Map<String, List<Customer>> customerOrdersFirstOrDefault = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g->g.getValue().stream().filter(
                        c -> c.getOrders().size() == g.getValue().stream().findFirst().orElse(Customer.DEFAULT).getOrders().size()).toList()));
        return customerOrdersFirstOrDefault;
    }

    public int NumbersElementAt() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int numAt = Arrays.stream(numbers).skip(1).findFirst().getAsInt();
        return numAt;
    }

    public int OddNumbersElementAt() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int numAt = Arrays.stream(numbers).filter(n -> n % 2 == 1).skip(3).findFirst().getAsInt();
        return numAt;
    }

    public double BigDoubleNumbersElementAt() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        double numAt = Arrays.stream(numbers).filter(d -> d>5).skip(1).findFirst().getAsDouble();
        return numAt;
    }

    public String StringElementAtStartWithO() {
        String[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        String startWithO = Arrays.stream(strings).filter(s ->s.charAt(0)=='o').skip(0).findFirst().get();
        return startWithO;
    }

    public String StringElementAtStartWith(char c) {
        String[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        String startWithO = Arrays.stream(strings).filter(s ->s.charAt(0)==c).skip(2).findFirst().get();
        return startWithO;
    }

    public double ProjectedDoubleElementAt() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        double numAt = Arrays.stream(numbers).map(i -> Math.log(i)).filter(n -> n > 3).skip(2).findFirst().getAsDouble();
        return numAt;
    }

    public int ProjectedStringElementAt() {
        String[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        int firstStringLength = Arrays.stream(strings).mapToInt(s -> s.length())
            .filter(i -> i % 2 == 0).skip(2).findFirst().getAsInt();
        return firstStringLength;
    }

    public Product ExpensiveProductElementAt() {
        List<Product> products = getProductList();
        Product expensiveProduct = products.stream().filter(p->p.getUnitPrice()>100)
                .skip(2).findFirst().get();
        return expensiveProduct;
    }

    public List<Pair<String, Product>> ProductEachCategoryElementAt() {
        List<Product> products = getProductList();
        List<Pair<String, Product>> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
            .entrySet().stream().map(g -> Pair.with(g.getKey(),
                g.getValue().stream().skip(1).findFirst().get())).toList();
        return categories;
    }

    public Map<String, Product> ProductEachCategoryElementAtDict() {
        List<Product> products = getProductList();
        Map<String, Product> categories = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g->g.getValue().stream().skip(1).findFirst().get()));
        return categories;
    }
}
