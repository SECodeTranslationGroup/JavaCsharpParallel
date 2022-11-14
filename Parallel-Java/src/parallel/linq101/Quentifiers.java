package parallel.linq101;

import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Quentifiers {
    public List<Product> getProductList() {
        return Data.getProductList();
    }
    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }
    public int anyMatchingElements() {
        String[] words = {"believe", "relief", "receipt", "field"};
        boolean iAfterE = Arrays.stream(words).anyMatch(w -> w.contains("ei"));
        System.out.println("There is a word that contains in the list that contains 'ei': " + iAfterE);
        return 0;
    }

    public int groupedAnyMatchedElements() {
        List<Product> products = getProductList();
        var productGroups = products.stream().collect(Collectors.groupingBy(
                p -> p.getCategory())).entrySet().stream().filter(e -> e.getValue().stream()
                .anyMatch(p -> p.getUnitsInStock() == 0)).collect(Collectors.toMap(e->e.getKey(),e->e.getValue()));
        for (var group : productGroups.entrySet()) {
            System.out.println(group.getKey());
            for (var product : group.getValue())
                System.out.println("\t" + product);
        }
        return 0;
    }

    public int allMatchedElements() {
        int[] numbers = {1, 11, 3, 19, 41, 65, 19};
        boolean onlyOdd = Arrays.stream(numbers).allMatch(n -> n % 2 == 1);
        System.out.println("The list contains only odd numbers: " + onlyOdd);
        return 0;
    }

    public int groupedAllMatchedElements() {
        List<Product> products = getProductList();
        var productGroups = products.stream().collect(Collectors.groupingBy(
                p -> p.getCategory())).entrySet().stream().filter(e -> e.getValue().stream()
                .allMatch(p -> p.getUnitsInStock() > 0)).collect(Collectors.toMap(e->e.getKey(),e->e.getValue()));
        for (var group : productGroups.entrySet()) {
            System.out.println(group.getKey());
            for (var product : group.getValue())
                System.out.println("\t" + product);
        }
        return 0;
    }

}
