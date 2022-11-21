package parallel.linq101.mylinq;

import org.javatuples.Pair;
import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Order;
import parallel.linq101.datasource.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class GroupMethods {
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public List<Pair<Integer, List<Integer>>> intGroupByMod() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Pair<Integer, List<Integer>>> numberGroups = Arrays.stream(numbers).boxed().collect(groupingBy(n -> n % 5))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue())).toList();
        return numberGroups;
    }

    public Map<Integer, List<Integer>> intGroupByModDict() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        Map<Integer, List<Integer>> numberGroups = Arrays.stream(numbers).boxed().collect(groupingBy(n -> n % 5));
        return numberGroups;
    }

    public List<Pair<Boolean, List<Integer>>> intGroupByBool() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Pair<Boolean, List<Integer>>> numberGroups = Arrays.stream(numbers).boxed().collect(groupingBy(n -> n > 4))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue())).toList();
        return numberGroups;
    }

    public Map<Boolean, List<Integer>> intGroupByBoolDict() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        Map<Boolean, List<Integer>> numberGroups = Arrays.stream(numbers).boxed().collect(groupingBy(n -> n > 4));
        return numberGroups;
    }

    public Map<Boolean, List<Integer>> intGroupByBoolDictPrint() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        Map<Boolean, List<Integer>> numberGroups = numberGroups = Arrays.stream(numbers).boxed().collect(groupingBy(n -> n > 4))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue()));
        numberGroups.get(true).stream().forEach(n -> System.out.print(n));
        System.out.println();
        numberGroups.get(false).stream().forEach(n -> System.out.print(n));
        return numberGroups;
    }

    public List<Pair<Double, List<Double>>> doubleGroupByMod() {
        double[] numbers = {5.8, 4.3, 1.5, 3.7, 9.3};
        List<Pair<Double, List<Double>>> numberGroups = Arrays.stream(numbers).boxed().collect(groupingBy(n -> n % 1.5))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue())).toList();
        return numberGroups;
    }

    public Map<Double, List<Double>> doubleGroupByModDict() {
        double[] numbers = {5.8, 4.3, 1.5, 3.7, 9.3};
        Map<Double, List<Double>> numberGroups = Arrays.stream(numbers).boxed().collect(groupingBy(n -> n % 1.5));
        return numberGroups;
    }

    public List<Pair<Boolean, List<Double>>> doubleGroupByBool() {
        double[] numbers = {5.8, 4.3, 1.5, 3.7, 9.3};
        List<Pair<Boolean, List<Double>>> numberGroups = numberGroups = Arrays.stream(numbers).boxed().collect(groupingBy(n -> n > 3))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue())).toList();
        return numberGroups;
    }

    public Map<Boolean, List<Double>> doubleGroupByBoolDict() {
        double[] numbers = {5.8, 4.3, 1.5, 3.7, 9.3};
        Map<Boolean, List<Double>> numberGroups = Arrays.stream(numbers).boxed().collect(groupingBy(n -> n > 3));
        return numberGroups;
    }

    public List<Pair<Character, List<String>>> stringGroupByFirstChar() {
        String[] words = {"blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese"};
        List<Pair<Character, List<String>>> wordsGroups = Arrays.stream(words).collect(groupingBy(w -> w.charAt(0)))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue())).toList();
        return wordsGroups;
    }

    public Map<Character, List<String>> stringGroupByFirstCharDict() {
        String[] words = {"blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese"};
        Map<Character, List<String>> wordsGroups = Arrays.stream(words).collect(groupingBy(w -> w.charAt(0)));
        return wordsGroups;
    }

    public List<Pair<Boolean, List<String>>> stringGroupByLength() {
        String[] words = {"blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese"};
        List<Pair<Boolean, List<String>>> wordsGroups = Arrays.stream(words).collect(groupingBy(w -> w.length() > 8))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue())).toList();
        return wordsGroups;
    }

    public Map<Boolean, List<String>> stringGroupByLengthDict() {
        String[] words = {"blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese"};
        Map<Boolean, List<String>> wordsGroups = Arrays.stream(words).collect(groupingBy(w -> w.length() > 8));
        return wordsGroups;
    }

    public List<Pair<String, List<Product>>> productGroupByCategory() {
        List<Product> products = getProductList();
        List<Pair<String, List<Product>>> category = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue())).toList();
        return category;
    }

    public Map<String, List<Product>> productGroupByCategoryDict() {
        List<Product> products = getProductList();
        Map<String, List<Product>> category = products.stream().collect(groupingBy(p -> p.getCategory()));
        return category;
    }

    public List<Pair<String, List<Integer>>> productGroupByCategoryWithId() {
        List<Product> products = getProductList();
        List<Pair<String, List<Integer>>> category = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().map(p -> p.getProductId()).toList())).toList();
        return category;
    }

    public Map<String, List<Integer>> productGroupByCategoryWithIdDict() {
        List<Product> products = getProductList();
        Map<String, List<Integer>> category = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().map(p -> p.getProductId()).toList()));
        return category;
    }

    public List<Pair<Boolean, List<Product>>> productGroupByPrice() {
        List<Product> products = getProductList();
        List<Pair<Boolean, List<Product>>> productGroup = products.stream().collect(groupingBy(p -> p.getUnitPrice() > 100))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue())).toList();
        return productGroup;
    }

    public Map<Boolean, List<Product>> productGroupByPriceDict() {
        List<Product> products = getProductList();
        Map<Boolean, List<Product>> productGroup = products.stream().collect(groupingBy(p -> p.getUnitPrice() > 100));
        return productGroup;
    }

    public Map<Boolean, List<Product>> productGroupByPriceDictPrint() {
        List<Product> products = getProductList();
        Map<Boolean, List<Product>> productGroup = products.stream().collect(groupingBy(p -> p.getUnitPrice() > 100));
        productGroup.get(true).stream().forEach(n -> System.out.print(n));
        System.out.println();
        productGroup.get(false).stream().forEach(n -> System.out.print(n));
        return productGroup;
    }

    public List<Pair<Boolean, List<Integer>>> productGroupByPriceWithId() {
        List<Product> products = getProductList();
        List<Pair<Boolean, List<Integer>>> productGroup = products.stream().collect(groupingBy(p -> p.getUnitPrice() > 100))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().map(p -> p.getProductId()).toList())).toList();
        return productGroup;
    }

    public Map<Boolean, List<Integer>> productGroupByPriceWithIdDict() {
        List<Product> products = getProductList();
        Map<Boolean, List<Integer>> productGroup = products.stream().collect(groupingBy(p -> p.getUnitPrice() > 100))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().map(p -> p.getProductId()).toList()));
        return productGroup;
    }

    public Map<Boolean, List<Integer>> productGroupByPriceWithIdDictPrint() {
        List<Product> products = getProductList();
        Map<Boolean, List<Integer>> productGroup = products.stream().collect(groupingBy(p -> p.getUnitPrice() > 100))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().map(p -> p.getProductId()).toList()));
        productGroup.get(true).stream().forEach(n -> System.out.print(n));
        System.out.println();
        productGroup.get(false).stream().forEach(n -> System.out.print(n));
        return productGroup;
    }

    public List<Pair<Boolean, List<Product>>> productGroupByInStock() {
        List<Product> products = getProductList();
        List<Pair<Boolean, List<Product>>> productGroup = products.stream().collect(groupingBy(p -> p.getUnitsInStock() > 0))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue())).toList();
        return productGroup;
    }

    public Map<Boolean, List<Product>> productGroupByInStockDict() {
        List<Product> products = getProductList();
        Map<Boolean, List<Product>> productGroup = products.stream().collect(groupingBy(p -> p.getUnitsInStock() > 0));
        return productGroup;
    }

    public Map<Boolean, List<Product>> productGroupByInStockDictPrint() {
        List<Product> products = getProductList();
        Map<Boolean, List<Product>> productGroup = products.stream().collect(groupingBy(p -> p.getUnitsInStock() > 0));
        productGroup.get(true).stream().forEach(n -> System.out.print(n));
        System.out.println();
        productGroup.get(false).stream().forEach(n -> System.out.print(n));
        return productGroup;
    }

    public List<Pair<Boolean, List<Integer>>> productGroupByInStockWithId() {
        List<Product> products = getProductList();
        List<Pair<Boolean, List<Integer>>> productGroup = products.stream().collect(groupingBy(p -> p.getUnitsInStock() > 0))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().map(p -> p.getProductId()).toList())).toList();
        return productGroup;
    }

    public Map<Boolean, List<Integer>> productGroupByInStockWithIdDict() {
        List<Product> products = getProductList();
        Map<Boolean, List<Integer>> productGroup = products.stream().collect(groupingBy(p -> p.getUnitsInStock() > 0))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().map(p -> p.getProductId()).toList()));
        return productGroup;
    }

    public Map<Boolean, List<Integer>> productGroupByInStockWithIdDictPrint() {
        List<Product> products = getProductList();
        Map<Boolean, List<Integer>> productGroup = products.stream().collect(groupingBy(p -> p.getUnitsInStock() > 0))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().map(p -> p.getProductId()).toList()));
        productGroup.get(true).stream().forEach(n -> System.out.print(n));
        System.out.println();
        productGroup.get(false).stream().forEach(n -> System.out.print(n));
        return productGroup;
    }

    public List<Pair<String, List<Customer>>> customerGroupByRegion() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, List<Customer>>> catagory = customers.stream().collect(groupingBy(c -> c.getRegion()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue())).toList();
        return catagory;
    }

    public Map<String, List<Customer>> customerGroupByRegionDict() {
        List<Customer> customers = getCustomerList();
        Map<String, List<Customer>> catagory = customers.stream().collect(groupingBy(c -> c.getRegion()));
        return catagory;
    }

    public Map<String, Map<String, Customer>> customerNestedGroupByRegionAndName() {
        List<Customer> customers = getCustomerList();
        Map<String, Map<String, Customer>> customerGroups = customers.stream().collect(groupingBy(p -> p.getRegion()))
                .entrySet().stream().collect(toMap(
                        g -> g.getKey(),
                        g -> g.getValue().stream().collect(toMap(
                                c -> c.getCompanyName(),
                                c -> c))));
        return customerGroups;
    }

    public Map<String, Map<String, List<Customer>>> customerNestedGroupByRegionAndCountry() {
        List<Customer> customers = getCustomerList();
        Map<String, Map<String, List<Customer>>> customerGroups = customers.stream().collect(groupingBy(p -> p.getRegion()))
                .entrySet().stream().collect(toMap(
                        g -> g.getKey(),
                        g -> g.getValue().stream().collect(groupingBy(
                                c -> c.getCountry()))));
        return customerGroups;
    }


    public Map<String, Map<String, Map<String, Customer>>> customerNestedGroupByRegionAndCountryAndName() {
        List<Customer> customers = getCustomerList();
        Map<String, Map<String, Map<String, Customer>>> customerGroups = customers.stream().collect(groupingBy(p -> p.getRegion()))
                .entrySet().stream().collect(toMap(
                        g -> g.getKey(),
                        g -> g.getValue().stream().collect(groupingBy(c -> c.getCountry()))
                                .entrySet().stream().collect(toMap(
                                        g1 -> g1.getKey(),
                                        g1 -> g1.getValue().stream().collect(toMap(
                                                c -> c.getCompanyName(),
                                                c -> c))))));
        return customerGroups;
    }

    public Map<String, Map<String, Map<String, Customer>>> customerNestedGroupByRegionAndCountryAndNamePrint() {
        List<Customer> customers = getCustomerList();
        Map<String, Map<String, Map<String, Customer>>> customerGroups = customers.stream().collect(groupingBy(p -> p.getRegion()))
                .entrySet().stream().collect(toMap(
                        g -> g.getKey(),
                        g -> g.getValue().stream().collect(groupingBy(c -> c.getCountry()))
                                .entrySet().stream().collect(toMap(
                                        g1 -> g1.getKey(),
                                        g1 -> g1.getValue().stream().collect(toMap(
                                                c -> c.getCompanyName(),
                                                c -> c))))));
        for (var e1 : customerGroups.entrySet()) {
            System.out.println(e1.getKey() + ":");
            for (var e2 : e1.getValue().entrySet()) {
                System.out.println("\t" + e2.getKey() + ":");
                for (var e3 : e2.getValue().entrySet())
                    System.out.println("\t\t" + e3.getKey() + ":" + e3.getValue());
            }
        }
        return customerGroups;
    }

    public Map<String, Map<Integer, List<Order>>> customerNestedGroupByNameAndOrderYear() {
        List<Customer> customers = getCustomerList();
        Map<String, Map<Integer, List<Order>>> customerOrderGroups = customers.stream().collect(toMap(
                c -> c.getCompanyName(),
                c -> c.getOrders().stream().collect(
                        groupingBy(o -> o.getOrderDate().getYear()))
        ));
        return customerOrderGroups;
    }

    public Map<Integer, Map<Integer, List<Order>>> customerNestedGroupByOrderYearAndMonth() {
        List<Customer> customers = getCustomerList();
        Map<Integer, Map<Integer, List<Order>>> customerOrderGroups = customers.stream().flatMap(c -> c.getOrders().stream())
                .collect(groupingBy(o -> o.getOrderDate().getYear())).entrySet().stream().collect(toMap(
                        g -> g.getKey(),
                        g -> g.getValue().stream().collect(groupingBy(
                                o -> o.getOrderDate().getMonthValue()
                        ))));
        return customerOrderGroups;
    }

    public Map<Integer, Map<Integer, List<Order>>> customerNestedGroupByOrderYearAndMonthPrint() {
        List<Customer> customers = getCustomerList();
        Map<Integer, Map<Integer, List<Order>>> customerOrderGroups = customers.stream().flatMap(c -> c.getOrders().stream())
                .collect(groupingBy(o -> o.getOrderDate().getYear())).entrySet().stream().collect(toMap(
                        g -> g.getKey(),
                        g -> g.getValue().stream().collect(groupingBy(
                                o -> o.getOrderDate().getMonthValue()
                        ))));
        for (var e1 : customerOrderGroups.entrySet()) {
            System.out.println(e1.getKey() + ":");
            for (var e2 : e1.getValue().entrySet()) {
                System.out.println("\t" + e2.getKey() + ":");
                e2.getValue().stream().forEach(o -> System.out.println("\t\t" + o));
            }
        }
        return customerOrderGroups;
    }

    public Map<String, Map<Integer, Map<Integer, List<Order>>>> customerNestedGroupByNameAndOrderYearAndMonth() {
        List<Customer> customers = getCustomerList();
        Map<String, Map<Integer, Map<Integer, List<Order>>>> customerOrderGroups = customers.stream().collect(toMap(
                c -> c.getCompanyName(),
                c -> c.getOrders().stream().collect(groupingBy(o -> o.getOrderDate().getYear())).entrySet().stream().collect(toMap(
                        g -> g.getKey(),
                        g -> g.getValue().stream().collect(groupingBy(
                                o -> o.getOrderDate().getMonthValue()
                        ))))));
        return customerOrderGroups;
    }

    public Map<String, Map<Integer, Map<Integer, List<Order>>>>
    customerNestedGroupByNameAndOrderYearAndMonthPrint() {
        List<Customer> customers = getCustomerList();
        Map<String, Map<Integer, Map<Integer, List<Order>>>> customerOrderGroups = customers.stream().collect(toMap(
                c -> c.getCompanyName(),
                c -> c.getOrders().stream().collect(groupingBy(o -> o.getOrderDate().getYear())).entrySet().stream().collect(toMap(
                        g -> g.getKey(),
                        g -> g.getValue().stream().collect(groupingBy(
                                o -> o.getOrderDate().getMonthValue()
                        ))))));
        for (var e1 : customerOrderGroups.entrySet()) {
            System.out.println(e1.getKey() + ":");
            for (var e2 : e1.getValue().entrySet()) {
                System.out.println("\t" + e2.getKey() + ":");
                for (var e3 : e2.getValue().entrySet()) {
                    System.out.println("\t\t" + e3.getKey() + ":");
                    e3.getValue().forEach(o -> System.out.println("\t\t\t" + o));
                }
            }
        }
        return customerOrderGroups;
    }

}
