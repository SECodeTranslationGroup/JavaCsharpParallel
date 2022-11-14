package parallel.linq101;

import org.javatuples.Pair;
import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class JoinOperations {
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public int crossJoinQuery() {
        String[] categories = {"Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"};
        List<Product> products = getProductList();
        var q = Arrays.stream(categories).flatMap(
                c -> products.stream().filter(p -> p.getCategory().equals(c)).map(
                        p -> Pair.with(c, p.productName)
                )).collect(Collectors.toList());
        for (var v : q)
            System.out.println(v.getValue0() + ": " + v.getValue1());
        return 0;
    }

    public int groupJoinQuery() {
        String[] categories = {"Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"};
        List<Product> products = getProductList();
        var q = Arrays.stream(categories).map(
                c -> Pair.with(c, products.stream().filter(p -> p.getCategory().equals(c))
                        .collect(Collectors.toList()))
        ).collect(Collectors.toMap(t -> t.getValue0(), t -> t.getValue1()));
        for (var v : q.entrySet()) {
            System.out.println(v.getKey() + ":");
            for (var p : v.getValue())
                System.out.println("   " + p.getProductName());
        }
        return 0;
    }

    public int crossGroupJoin() {
        String[] categories = {"Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"};
        List<Product> products = getProductList();
        var q = Arrays.stream(categories).map(
                c -> Pair.with(c, products.stream().filter(p -> p.getCategory().equals(c))
                        .collect(Collectors.toList()))).flatMap(t -> t.getValue1().stream()
                .map(p -> Pair.with(t.getValue0(), p.getProductName()))).collect(Collectors.toList());
        for (var v : q)
            System.out.println(v.getValue1() + ": " + v.getValue0());
        return 0;
    }

    public int leftOuterJoin() {
        String[] categories = {"Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"};
        List<Product> products = getProductList();
        var q = Arrays.stream(categories).map(
                c -> Pair.with(c, products.stream().filter(p -> p.getCategory().equals(c))
                        .collect(Collectors.toList()))).flatMap(t -> defaultIfEmpty(t.getValue1(), null)
                .stream().map(p -> Pair.with(t.getValue0(),
                        p == null ? "(No products)" : p.getProductName()))).collect(Collectors.toList());
        for (var v : q)
            System.out.println(v.getValue1() + ": " + v.getValue0());
        return 0;
    }

    public static <T> List<T> defaultIfEmpty(List<T> list, T def) {
        if (list.isEmpty()) {
            List<T> ll = new ArrayList<T>();
            ll.add(def);
            return ll;
        } else return list;
    }

}
