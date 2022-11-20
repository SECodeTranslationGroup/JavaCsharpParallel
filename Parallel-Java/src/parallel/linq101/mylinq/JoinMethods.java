package parallel.linq101.mylinq;

import org.javatuples.Pair;
import org.javatuples.Triplet;
import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class JoinMethods {
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public List<Pair<String, Product>> productCrossJoinCategories() {
        String[] categories = {"Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"};
        List<Product> products = getProductList();
        List<Pair<String, Product>> q = Arrays.stream(categories).flatMap(
                c -> products.stream().filter(p -> p.getCategory().equals(c)).map(
                        p -> Pair.with(c, p))).toList();
        return q;
    }

    public List<Pair<String, String>> productCrossJoinCategoriesName() {
        String[] categories = {"Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"};
        List<Product> products = getProductList();
        List<Pair<String, String>> q = Arrays.stream(categories).flatMap(
                c -> products.stream().filter(p -> p.getCategory().equals(c)).map(
                        p -> Pair.with(c, p.getProductName()))).toList();
        return q;
    }

    public List<Pair<String, Double>> productCrossJoinCategoriesUnitPrice() {
        String[] categories = {"Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"};
        List<Product> products = getProductList();
        List<Pair<String, Double>> q = Arrays.stream(categories).flatMap(
                c -> products.stream().filter(p -> p.getCategory().equals(c)).map(
                        p -> Pair.with(c, p.getUnitPrice()))).toList();
        return q;
    }

    public List<Pair<String, Customer>> customerCrossJoinRegions() {
        String[] regions = {"BC", "SP", "OR", "LA"};
        List<Customer> customers = getCustomerList();
        List<Pair<String, Customer>> q = Arrays.stream(regions).flatMap(
                r -> customers.stream().filter(c -> c.getRegion().equals(r)).map(
                        c -> Pair.with(r, c))).toList();
        return q;
    }

    public List<Pair<String, String>> customerCrossJoinRegionsName() {
        String[] regions = {"BC", "SP", "OR", "LA"};
        List<Customer> customers = getCustomerList();
        List<Pair<String, String>> q = Arrays.stream(regions).flatMap(
                r -> customers.stream().filter(c -> c.getRegion().equals(r)).map(
                        c -> Pair.with(r, c.getCompanyName()))).toList();
        return q;
    }

    public List<Pair<String, String>> customerCrossJoinRegionsPhone() {
        String[] regions = {"BC", "SP", "OR", "LA"};
        List<Customer> customers = getCustomerList();
        List<Pair<String, String>> q = Arrays.stream(regions).flatMap(
                r -> customers.stream().filter(c -> c.getRegion().equals(r)).map(
                        c -> Pair.with(r, c.getPhone()))).toList();
        return q;
    }

    public List<Pair<Integer, Customer>> customerCrossJoinRegionsWithCode() {
        List<Pair<String, Integer>> regions = Arrays.asList(
                Pair.with("BC", 101), Pair.with("BC", 105),
                Pair.with("OR", 121), Pair.with("LA", 143)
        );
        List<Customer> customers = getCustomerList();
        List<Pair<Integer, Customer>> q = regions.stream().flatMap(
                r -> customers.stream().filter(c -> c.getRegion().equals(r.getValue0())).map(
                        c -> Pair.with(r.getValue1(), c))).toList();
        return q;
    }

    public List<Pair<Integer, String>> customerCrossJoinRegionsWithCodeName() {
        List<Pair<String, Integer>> regions = Arrays.asList(
                Pair.with("BC", 101), Pair.with("BC", 105),
                Pair.with("OR", 121), Pair.with("LA", 143)
        );
        List<Customer> customers = getCustomerList();
        List<Pair<Integer, String>> q = regions.stream().flatMap(
                r -> customers.stream().filter(c -> c.getRegion().equals(r.getValue0())).map(
                        c -> Pair.with(r.getValue1(), c.getCompanyName()))).toList();
        return q;
    }

    public List<Triplet<String, Integer, Customer>> customerCrossJoinRegionsWithCodeRegion() {
        List<Pair<String, Integer>> regions = Arrays.asList(
                Pair.with("BC", 101), Pair.with("BC", 105),
                Pair.with("OR", 121), Pair.with("LA", 143)
        );
        List<Customer> customers = getCustomerList();
        List<Triplet<String, Integer, Customer>> q = regions.stream().flatMap(
                r -> customers.stream().filter(c -> c.getRegion().equals(r.getValue0())).map(
                        c -> Triplet.with(r.getValue0(), r.getValue1(), c))).toList();
        return q;
    }

    public List<Triplet<String, Integer, String>> customerCrossJoinRegionsWithCodeNameRegion() {
        List<Pair<String, Integer>> regions = Arrays.asList(
                Pair.with("BC", 101), Pair.with("BC", 105),
                Pair.with("OR", 121), Pair.with("LA", 143)
        );
        List<Customer> customers = getCustomerList();
        List<Triplet<String, Integer, String>> q = regions.stream().flatMap(
                r -> customers.stream().filter(c -> c.getRegion().equals(r.getValue0())).map(
                        c -> Triplet.with(r.getValue0(), r.getValue1(), c.getCompanyName()))).toList();
        return q;
    }

    //group join
    public Map<String, List<Product>> productGroupJoinCategories() {
        String[] categories = {"Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"};
        List<Product> products = getProductList();
        Map<String, List<Product>> q = Arrays.stream(categories).map(c -> Pair.with(c, products.stream()
                        .filter(p -> p.getCategory().equals(c)).toList()))
                .collect(toMap(t -> t.getValue0(), t -> t.getValue1()));
        return q;
    }

    public Map<String, List<String>> productGroupJoinCategoriesName() {
        String[] categories = {"Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"};
        List<Product> products = getProductList();
        Map<String, List<String>> q = Arrays.stream(categories).map(c -> Pair.with(c, products.stream()
                        .filter(p -> p.getCategory().equals(c)).map(p1 -> p1.getProductName()).toList()))
                .collect(toMap(t -> t.getValue0(), t -> t.getValue1()));
        return q;
    }

    public Map<String, List<Double>> productGroupJoinCategoriesUnitPrice() {
        String[] categories = {"Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"};
        List<Product> products = getProductList();
        Map<String, List<Double>> q = Arrays.stream(categories).map(c -> Pair.with(c, products.stream()
                        .filter(p -> p.getCategory().equals(c)).map(p1 -> p1.getUnitPrice()).toList()))
                .collect(toMap(t -> t.getValue0(), t -> t.getValue1()));
        return q;
    }

    public Map<String, List<Customer>> customerGroupJoinRegions() {
        String[] regions = {"BC", "SP", "OR", "LA"};
        List<Customer> customers = getCustomerList();
        Map<String, List<Customer>> q = Arrays.stream(regions).map(r -> Pair.with(r, customers.stream()
                .filter(c -> c.getRegion().equals(r)).toList())).collect(toMap(t->t.getValue0(),t->t.getValue1()));
        return q;
    }

    public Map<String, List<String>> customerGroupJoinRegionsName() {
        String[] regions = {"BC", "SP", "OR", "LA"};
        List<Customer> customers = getCustomerList();
        Map<String, List<String>> q = Arrays.stream(regions).map(r -> Pair.with(r, customers.stream()
                .filter(c -> c.getRegion().equals(r)).map(c->c.getCompanyName()).toList()))
                .collect(toMap(t->t.getValue0(),t->t.getValue1()));
        return q;
    }

    public Map<String, List<String>> customerGroupJoinRegionsPhone() {
        String[] regions = {"BC", "SP", "OR", "LA"};
        List<Customer> customers = getCustomerList();
        Map<String, List<String>> q = Arrays.stream(regions).map(r -> Pair.with(r, customers.stream()
                        .filter(c -> c.getRegion().equals(r)).map(c->c.getPhone()).toList()))
                .collect(toMap(t->t.getValue0(),t->t.getValue1()));
        return q;
    }

    public Map<Integer, List<Customer>> customerGroupJoinRegionsWithCode() {
        List<Pair<String, Integer>> regions = Arrays.asList(
                Pair.with("BC", 101), Pair.with("BC", 105),
                Pair.with("OR", 121), Pair.with("LA", 143)
        );
        List<Customer> customers = getCustomerList();
        Map<Integer, List<Customer>> q = regions.stream().map(r -> Pair.with(r.getValue1(), customers.stream()
                .filter(c -> c.getRegion().equals(r.getValue0())).toList())).collect(toMap(t->t.getValue0(),t->t.getValue1()));
        return q;
    }

    public Map<Integer, List<String>> customerGroupJoinRegionsWithCodeName() {
        List<Pair<String, Integer>> regions = Arrays.asList(
                Pair.with("BC", 101), Pair.with("BC", 105),
                Pair.with("OR", 121), Pair.with("LA", 143)
        );
        List<Customer> customers = getCustomerList();
        Map<Integer, List<String>> q = regions.stream().map(r -> Pair.with(r.getValue1(), customers.stream()
                .filter(c -> c.getRegion().equals(r.getValue0())).map(c->c.getCompanyName()).toList()))
                .collect(toMap(t->t.getValue0(),t->t.getValue1()));
        return q;
    }

    public Map<Pair<String, Integer>, List<Customer>> customerGroupJoinRegionsWithCodeRegion() {
        List<Pair<String, Integer>> regions = Arrays.asList(
                Pair.with("BC", 101), Pair.with("BC", 105),
                Pair.with("OR", 121), Pair.with("LA", 143)
        );
        List<Customer> customers = getCustomerList();
        Map<Pair<String, Integer>, List<Customer>> q = regions.stream().map(r -> Pair.with(r, customers.stream()
                        .filter(c -> c.getRegion().equals(r.getValue0())).toList()))
                .collect(toMap(t->t.getValue0(),t->t.getValue1()));
        return q;
    }

    public Map<Pair<String, Integer>, List<String>> customerGroupJoinRegionsWithCodeNameRegion() {
        List<Pair<String, Integer>> regions = Arrays.asList(
                Pair.with("BC", 101), Pair.with("BC", 105),
                Pair.with("OR", 121), Pair.with("LA", 143)
        );
        List<Customer> customers = getCustomerList();
        Map<Pair<String, Integer>, List<String>> q = regions.stream().map(r -> Pair.with(r, customers.stream()
                        .filter(c -> c.getRegion().equals(r.getValue0())).map(c->c.getCompanyName()).toList()))
                .collect(toMap(t->t.getValue0(),t->t.getValue1()));
        return q;
    }

    //cross group join
    public List<Pair<String, Product>> productCrossGroupJoinCategories() {
        String[] categories = {"Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"};
        List<Product> products = getProductList();
        List<Pair<String, Product>> q = Arrays.stream(categories).map(
                c -> Pair.with(c, products.stream().filter(p -> p.getCategory().equals(c))
                        .collect(Collectors.toList()))).flatMap(t -> t.getValue1().stream()
                .map(p1 -> Pair.with(t.getValue0(), p1))).toList();
        return q;
    }

    public List<Pair<String, String>> productCrossGroupJoinCategoriesName() {
        String[] categories = {"Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"};
        List<Product> products = getProductList();
        List<Pair<String, String>> q = Arrays.stream(categories).map(
                c -> Pair.with(c, products.stream().filter(p -> p.getCategory().equals(c))
                        .collect(Collectors.toList()))).flatMap(t -> t.getValue1().stream()
                .map(p1 -> Pair.with(t.getValue0(), p1.getProductName()))).toList();
        return q;
    }

    public List<Pair<String, Double>> productCrossGroupJoinCategoriesUnitPrice() {
        String[] categories = {"Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"};
        List<Product> products = getProductList();
        List<Pair<String, Double>> q = Arrays.stream(categories).map(
                c -> Pair.with(c, products.stream().filter(p -> p.getCategory().equals(c))
                        .collect(Collectors.toList()))).flatMap(t -> t.getValue1().stream()
                .map(p1 -> Pair.with(t.getValue0(), p1.getUnitPrice()))).toList();
        return q;
    }

    public List<Pair<String, Customer>> customerCrossGroupJoinRegions() {
        String[] regions = {"BC", "SP", "OR", "LA"};
        List<Customer> customers = getCustomerList();
        List<Pair<String, Customer>> q = Arrays.stream(regions).map(
                r -> Pair.with(r, customers.stream().filter(c -> c.getRegion().equals(r))
                        .collect(Collectors.toList()))).flatMap(t -> t.getValue1().stream()
                .map(c1 -> Pair.with(t.getValue0(), c1))).toList();
        return q;
    }

    public List<Pair<String, String>> customerCrossGroupJoinRegionsName() {
        String[] regions = {"BC", "SP", "OR", "LA"};
        List<Customer> customers = getCustomerList();
        List<Pair<String, String>> q = Arrays.stream(regions).map(
                r -> Pair.with(r, customers.stream().filter(c -> c.getRegion().equals(r))
                        .collect(Collectors.toList()))).flatMap(t -> t.getValue1().stream()
                .map(c1 -> Pair.with(t.getValue0(), c1.getCompanyName()))).toList();
        return q;
    }

    public List<Pair<String, String>> customerCrossGroupJoinRegionsPhone() {
        String[] regions = {"BC", "SP", "OR", "LA"};
        List<Customer> customers = getCustomerList();
        List<Pair<String, String>> q = Arrays.stream(regions).map(
                r -> Pair.with(r, customers.stream().filter(c -> c.getRegion().equals(r))
                        .collect(Collectors.toList()))).flatMap(t -> t.getValue1().stream()
                .map(c1 -> Pair.with(t.getValue0(), c1.getPhone()))).toList();
        return q;
    }

    public List<Pair<Integer, Customer>> customerCrossGroupJoinRegionsWithCode() {
        List<Pair<String, Integer>> regions = Arrays.asList(
                Pair.with("BC", 101), Pair.with("BC", 105),
                Pair.with("OR", 121), Pair.with("LA", 143)
        );
        List<Customer> customers = getCustomerList();
        List<Pair<Integer, Customer>> q = regions.stream().map(
                r -> Pair.with(r.getValue1(), customers.stream().filter(c -> c.getRegion().equals(r))
                        .collect(Collectors.toList()))).flatMap(t -> t.getValue1().stream()
                .map(c1 -> Pair.with(t.getValue0(), c1))).toList();
        return q;
    }

    public List<Pair<Integer, String>> customerCrossGroupJoinRegionsWithCodeName() {
        List<Pair<String, Integer>> regions = Arrays.asList(
                Pair.with("BC", 101), Pair.with("BC", 105),
                Pair.with("OR", 121), Pair.with("LA", 143)
        );
        List<Customer> customers = getCustomerList();
        List<Pair<Integer, String>> q = regions.stream().map(
                r -> Pair.with(r.getValue1(), customers.stream().filter(c -> c.getRegion().equals(r))
                        .collect(Collectors.toList()))).flatMap(t -> t.getValue1().stream()
                .map(c1 -> Pair.with(t.getValue0(), c1.getCompanyName()))).toList();
        return q;
    }

    public List<Pair<Pair<String, Integer>, Customer>> customerCrossGroupJoinRegionsWithCodeRegion() {
        List<Pair<String, Integer>> regions = Arrays.asList(
                Pair.with("BC", 101), Pair.with("BC", 105),
                Pair.with("OR", 121), Pair.with("LA", 143)
        );
        List<Customer> customers = getCustomerList();
        List<Pair<Pair<String, Integer>, Customer>> q = regions.stream().map(
                r -> Pair.with(r, customers.stream().filter(c -> c.getRegion().equals(r))
                        .collect(Collectors.toList()))).flatMap(t -> t.getValue1().stream()
                .map(c1 -> Pair.with(t.getValue0(), c1))).toList();
        return q;
    }

    public List<Pair<Pair<String, Integer>, String>> customerCrossGroupJoinRegionsWithCodeNameRegion() {
        List<Pair<String, Integer>> regions = Arrays.asList(
                Pair.with("BC", 101), Pair.with("BC", 105),
                Pair.with("OR", 121), Pair.with("LA", 143)
        );
        List<Customer> customers = getCustomerList();
        List<Pair<Pair<String, Integer>, String>> q = regions.stream().map(
                r -> Pair.with(r, customers.stream().filter(c -> c.getRegion().equals(r))
                        .collect(Collectors.toList()))).flatMap(t -> t.getValue1().stream()
                .map(c1 -> Pair.with(t.getValue0(), c1.getCompanyName()))).toList();
        return q;
    }

    //left outer join
    public List<Pair<String, Product>> productLeftOuterJoinCategories() {
        String[] categories = {"Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"};
        List<Product> products = getProductList();
        List<Pair<String, Product>> q = Arrays.stream(categories).map(
                c -> Pair.with(c, products.stream().filter(p -> p.getCategory().equals(c))
                        .collect(Collectors.toList()))).flatMap(t -> defaultIfEmpty(t.getValue1(), null).stream()
                .map(p1 -> Pair.with(t.getValue0(), p1))).toList();
        return q;
    }

    public List<Pair<String, String>> productLeftOuterJoinCategoriesName() {
        String[] categories = {"Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"};
        List<Product> products = getProductList();
        List<Pair<String, String>> q = Arrays.stream(categories).map(
                c -> Pair.with(c, products.stream().filter(p -> p.getCategory().equals(c))
                        .collect(Collectors.toList()))).flatMap(t -> defaultIfEmpty(t.getValue1(), null).stream()
                .map(p1 -> Pair.with(t.getValue0(), p1!=null?p1.getProductName():"No Product"))).toList();
        return q;
    }

    public List<Pair<String, Double>> productLeftOuterJoinCategoriesUnitPrice() {
        String[] categories = {"Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"};
        List<Product> products = getProductList();
        List<Pair<String, Double>> q = Arrays.stream(categories).map(
                c -> Pair.with(c, products.stream().filter(p -> p.getCategory().equals(c))
                        .collect(Collectors.toList()))).flatMap(t -> defaultIfEmpty(t.getValue1(), null).stream()
                .map(p1 -> Pair.with(t.getValue0(), p1!=null?p1.getUnitPrice():0))).toList();
        return q;
    }

    public List<Pair<String, Customer>> customerLeftOuterJoinRegions() {
        String[] regions = {"BC", "SP", "OR", "LA"};
        List<Customer> customers = getCustomerList();
        List<Pair<String, Customer>> q = Arrays.stream(regions).map(
                r -> Pair.with(r, customers.stream().filter(c -> c.getRegion().equals(r))
                        .collect(Collectors.toList()))).flatMap(t -> defaultIfEmpty(t.getValue1(), null).stream()
                .map(p1 -> Pair.with(t.getValue0(), p1))).toList();
        return q;
    }

    public List<Pair<String, String>> customerLeftOuterJoinRegionsName() {
        String[] regions = {"BC", "SP", "OR", "LA"};
        List<Customer> customers = getCustomerList();
        List<Pair<String, String>> q = Arrays.stream(regions).map(
                r -> Pair.with(r, customers.stream().filter(c -> c.getRegion().equals(r))
                        .collect(Collectors.toList()))).flatMap(t -> defaultIfEmpty(t.getValue1(), null).stream()
                .map(p1 -> Pair.with(t.getValue0(), p1!=null?p1.getCompanyName():"No Customer"))).toList();
        return q;
    }

    public List<Pair<String, String>> customerLeftOuterJoinRegionsPhone() {
        String[] regions = {"BC", "SP", "OR", "LA"};
        List<Customer> customers = getCustomerList();
        List<Pair<String, String>> q = Arrays.stream(regions).map(
                r -> Pair.with(r, customers.stream().filter(c -> c.getRegion().equals(r))
                        .collect(Collectors.toList()))).flatMap(t -> defaultIfEmpty(t.getValue1(), null).stream()
                .map(p1 -> Pair.with(t.getValue0(), p1!=null?p1.getPhone():"No phone"))).toList();
        return q;
    }

    public List<Pair<Integer, Customer>> customerLeftOuterJoinRegionsWithCode() {
        List<Pair<String, Integer>> regions = Arrays.asList(
                Pair.with("BC", 101), Pair.with("BC", 105),
                Pair.with("OR", 121), Pair.with("LA", 143)
        );
        List<Customer> customers = getCustomerList();
        List<Pair<Integer, Customer>> q = regions.stream().map(
                r -> Pair.with(r.getValue1(), customers.stream().filter(c -> c.getRegion().equals(r))
                        .collect(Collectors.toList()))).flatMap(t -> defaultIfEmpty(t.getValue1(), null).stream()
                .map(p1 -> Pair.with(t.getValue0(), p1))).toList();
        return q;
    }

    public List<Pair<Integer, String>> customerLeftOuterJoinRegionsWithCodeName() {
        List<Pair<String, Integer>> regions = Arrays.asList(
                Pair.with("BC", 101), Pair.with("BC", 105),
                Pair.with("OR", 121), Pair.with("LA", 143)
        );
        List<Customer> customers = getCustomerList();
        List<Pair<Integer, String>> q = regions.stream().map(
                r -> Pair.with(r.getValue1(), customers.stream().filter(c -> c.getRegion().equals(r))
                        .collect(Collectors.toList()))).flatMap(t -> defaultIfEmpty(t.getValue1(), null).stream()
                .map(p1 -> Pair.with(t.getValue0(), p1!=null?p1.getCompanyName():"No Customer"))).toList();
        return q;
    }

    public List<Pair<Pair<String, Integer>, Customer>> customerLeftOuterJoinRegionsWithCodeRegion() {
        List<Pair<String, Integer>> regions = Arrays.asList(
                Pair.with("BC", 101), Pair.with("BC", 105),
                Pair.with("OR", 121), Pair.with("LA", 143)
        );
        List<Customer> customers = getCustomerList();
        List<Pair<Pair<String, Integer>, Customer>> q = regions.stream().map(
                r -> Pair.with(r, customers.stream().filter(c -> c.getRegion().equals(r))
                        .collect(Collectors.toList()))).flatMap(t -> defaultIfEmpty(t.getValue1(), null).stream()
                .map(p1 -> Pair.with(t.getValue0(), p1))).toList();
        return q;
    }

    public List<Pair<Pair<String, Integer>, String>> customerLeftOuterJoinRegionsWithCodeNameRegion() {
        List<Pair<String, Integer>> regions = Arrays.asList(
                Pair.with("BC", 101), Pair.with("BC", 105),
                Pair.with("OR", 121), Pair.with("LA", 143)
        );
        List<Customer> customers = getCustomerList();
        List<Pair<Pair<String, Integer>, String>> q = regions.stream().map(
                r -> Pair.with(r, customers.stream().filter(c -> c.getRegion().equals(r))
                        .collect(Collectors.toList()))).flatMap(t -> defaultIfEmpty(t.getValue1(), null).stream()
                .map(p1 -> Pair.with(t.getValue0(), p1!=null?p1.getCompanyName():"No Customer"))).toList();
        return q;
    }
    public static <T> List<T> defaultIfEmpty(List<T> list, T def) {
        if (list.isEmpty()) {
            List<T> ll = new ArrayList<T>();
            ll.add(def);
            return ll;
        } else return list;
    }
}
