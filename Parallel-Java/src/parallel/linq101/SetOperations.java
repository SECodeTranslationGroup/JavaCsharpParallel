package parallel.linq101;

import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SetOperations {
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public int distinctSyntax() {
        int[] factorsOf300 = {2, 2, 3, 5, 5};

        var uniqueFactors = Arrays.stream(factorsOf300).distinct().toArray();

        System.out.println("Prime factors of 300:");
        for (var f : uniqueFactors)
            System.out.println(f);

        return 0;
    }

    public int distinctPropertyValues() {
        List<Product> products = getProductList();

        var categoryNames = products.stream().map(p -> p.getCategory())
                .distinct().collect(Collectors.toList());

        System.out.println("Category names:");
        for (var n : categoryNames)
            System.out.println(n);
        return 0;
    }

    public int unionSyntax() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8};

        var uniqueNumbers = IntStream.concat(Arrays.stream(numbersA),
                Arrays.stream(numbersB)).distinct().toArray();

        System.out.println("Unique numbers from both arrays:");
        for (var n : uniqueNumbers)
            System.out.println(n);

        return 0;
    }

    public int unionOfQueryResults() {
        List<Product> products = getProductList();
        List<Customer> customers = getCustomerList();

        var productFirstChars = products.stream().map(p -> p.getProductName().charAt(0));
        var customerFirstChars = customers.stream().map(c -> c.getCompanyName().charAt(0));
        var uniqueFirstChars = Stream.concat(productFirstChars, customerFirstChars)
                .distinct().collect(Collectors.toList());

        System.out.println("Unique first letters from Product names and Customer names:");
        for (var ch : uniqueFirstChars)
            System.out.println(ch);

        return 0;
    }

    public int intersectSynxtax() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8};

        var commonNumbers = Arrays.stream(numbersA).filter(a ->
                Arrays.stream(numbersB).anyMatch(b->b==a)).toArray();

        System.out.println("Common numbers shared by both arrays:");
        for (var n : commonNumbers)
            System.out.println(n);
        return 0;
    }

    public int intersectQueryResults() {
        List<Product> products = getProductList();
        List<Customer> customers = getCustomerList();

        var productFirstChars = products.stream().map(p -> p.getProductName().charAt(0));
        var customerFirstChars = customers.stream().map(c -> c.getCompanyName().charAt(0));
        var commonFirstChars = productFirstChars.filter(p -> customerFirstChars.anyMatch(c -> c == p))
                .collect(Collectors.toList());

        System.out.println("Common first letters from Product names and Customer names:");
        for (var ch : commonFirstChars)
            System.out.println(ch);
        return 0;
    }

    public int differenceOfSets() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8};

        var aOnlyNumbers = Arrays.stream(numbersA).filter(a ->
                Arrays.stream(numbersB).allMatch(b->b!=a)).toArray();

        System.out.println("Numbers in first array but not second array:");
        for(var n : aOnlyNumbers)
            System.out.println(n);

        return 0;
    }

    public int DifferenceOfQueries() {

        List<Product> products = getProductList();
        List<Customer> customers = getCustomerList();

        var productFirstChars = products.stream().map(p -> p.getProductName().charAt(0));
        var customerFirstChars = customers.stream().map(c -> c.getCompanyName().charAt(0));
        var productOnlyFirstChars = productFirstChars.filter(p -> customerFirstChars.allMatch(c -> c != p))
                .collect(Collectors.toList());

        System.out.println("First letters from Product names, but not from Customer names:");
        for(var n : productOnlyFirstChars)
            System.out.println(n);

        return 0;
    }
}
