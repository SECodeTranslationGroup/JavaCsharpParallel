package parallel.linq101.mylinq;

import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SetMethods {
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public int[] intUnion() {
        int[] numbersA = {0, 2, 4, 5, 9};
        int[] numbersB = {0, 2, 4, 5, 9};
        int[] uniqueNumbers = IntStream.concat(Arrays.stream(numbersA), Arrays.stream(numbersB)).distinct().toArray();
        return uniqueNumbers;
    }

    public double[] doubleUnion() {
        double[] numbersA = {0.1, 2.2, 4.3, 5.4, 6.5, 8.6, 9.7};
        double[] numbersB = {0.1, 3.3, 5.4, 7.7, 8.6};
        double[] uniqueNumbers = DoubleStream.concat(Arrays.stream(numbersA), Arrays.stream(numbersB)).distinct().toArray();
        return uniqueNumbers;
    }

    public String[] stringUnion() {
        String[] wordsA = {"Alice", "Bob", "Foo", "Bar"};
        String[] wordsB = {"Cafe", "Bar", "Restaurant"};
        String[] uniqueWords = (String[]) Stream.concat(Arrays.stream(wordsA), Arrays.stream(wordsB)).distinct().toArray();
        return uniqueWords;
    }

    public int[] projectionIntUnion() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8};
        var first = Arrays.stream(numbersA).map(n -> n + 1);
        var second = Arrays.stream(numbersB).map(n -> n - 1);
        int[] uniqueNumbers = IntStream.concat(first, second).distinct().toArray();
        return uniqueNumbers;
    }

    public double[] projectionDoubleUnion() {
        double[] numbersA = {0.1, 2.2, 4.3, 5.4, 6.5, 8.6, 9.7};
        double[] numbersB = {0.1, 3.3, 5.4, 7.7, 8.6};
        var first = Arrays.stream(numbersA).map(n -> n - (int) n);
        var second = Arrays.stream(numbersB).map(n -> n - (int) n);
        double[] uniqueNumbers = DoubleStream.concat(first, second).distinct().toArray();
        return uniqueNumbers;
    }

    public Character[] projectionStringUnion() {
        String[] wordsA = {"Alice", "Bob", "Foo", "Bar"};
        String[] wordsB = {"Cafe", "Bar", "Restaurant"};
        var first = Arrays.stream(wordsA).map(n -> n.charAt(0));
        var second = Arrays.stream(wordsB).map(n -> n.charAt(0));
        Character[] uniqueWords = (Character[]) Stream.concat(first, second).distinct().toArray();
        return uniqueWords;
    }

    public List<String> unionOfCategory() {
        String[] categories = {"Furnitures", "Seagoods"};
        List<Product> products = getProductList();
        var productCategories = products.stream().map(p -> p.getCategory());
        List<String> uniqueCategories = Stream.concat(productCategories, Arrays.stream(categories)).distinct().toList();
        return uniqueCategories;
    }

    public List<String> unionOfRegion() {
        String[] regions = {"WA", "AF", "RO"};
        List<Customer> customers = getCustomerList();
        var customerRegions = customers.stream().map(c -> c.getRegion());
        List<String> uniqueRegions = Stream.concat(customerRegions, Arrays.stream(regions)).distinct().toList();
        return uniqueRegions;
    }

    public List<String> unionOfName() {
        List<Product> products = getProductList();
        List<Customer> customers = getCustomerList();
        var productNames = products.stream().map(p -> p.getProductName());
        var customerNames = customers.stream().map(c -> c.getCompanyName());
        List<String> uniqueNames = Stream.concat(productNames, customerNames).distinct().toList();
        return uniqueNames;
    }

    public List<Character> unionOfNameFirstChar() {
        List<Product> products = getProductList();
        List<Customer> customers = getCustomerList();
        var productFirstChars = products.stream().map(p -> p.getProductName().charAt(0));
        var customerFirstChars = customers.stream().map(c -> c.getCompanyName().charAt(0));
        List<Character> uniqueFirstChars = Stream.concat(productFirstChars, customerFirstChars).distinct().toList();
        return uniqueFirstChars;
    }

    public int[] intIntersect() {
        int[] numbersA = {0, 2, 4, 5, 9};
        int[] numbersB = {0, 2, 4, 5, 9};
        int[] sharedNumbers = Arrays.stream(numbersA).distinct().filter(a ->
                Arrays.stream(numbersB).anyMatch(b -> b == a)).toArray();
        return sharedNumbers;
    }

    public double[] doubleIntersect() {
        double[] numbersA = {0.1, 2.2, 4.3, 5.4, 6.5, 8.6, 9.7};
        double[] numbersB = {0.1, 3.3, 5.4, 7.7, 8.6};
        double[] sharedNumbers = Arrays.stream(numbersA).distinct().filter(a ->
                Arrays.stream(numbersB).anyMatch(b -> b == a)).toArray();
        return sharedNumbers;
    }

    public String[] stringIntersect() {
        String[] wordsA = {"Alice", "Bob", "Foo", "Bar"};
        String[] wordsB = {"Cafe", "Bar", "Restaurant"};
        String[] sharedWords = (String[]) Arrays.stream(wordsA).distinct().filter(a ->
                Arrays.stream(wordsB).anyMatch(b -> b.equals(a))).toArray();
        return sharedWords;
    }

    public int[] projectionIntIntersect() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8};
        var first = Arrays.stream(numbersA).map(n -> n + 1);
        var second = Arrays.stream(numbersB).map(n -> n - 1);
        int[] sharedNumbers = first.distinct().filter(a -> second.anyMatch(b -> b == a)).toArray();
        return sharedNumbers;
    }

    public double[] projectionDoubleIntersect() {
        double[] numbersA = {0.1, 2.2, 4.3, 5.4, 6.5, 8.6, 9.7};
        double[] numbersB = {0.1, 3.3, 5.4, 7.7, 8.6};
        var first = Arrays.stream(numbersA).map(n -> n - (int) n);
        var second = Arrays.stream(numbersB).map(n -> n - (int) n);
        double[] sharedNumbers = first.distinct().filter(a -> second.anyMatch(b -> b == a)).toArray();
        return sharedNumbers;
    }

    public Character[] projectionStringIntersect() {
        String[] wordsA = {"Alice", "Bob", "Foo", "Bar"};
        String[] wordsB = {"Cafe", "Bar", "Restaurant"};
        var first = Arrays.stream(wordsA).map(n -> n.charAt(0));
        var second = Arrays.stream(wordsB).map(n -> n.charAt(0));
        Character[] sharedWords = (Character[]) first.distinct().filter(a -> second.anyMatch(b -> b == a)).toArray();
        return sharedWords;
    }

    public List<String> intersectOfCategory() {
        String[] categories = {"Furnitures", "Seagoods"};
        List<Product> products = getProductList();
        var productCategories = products.stream().map(p -> p.getCategory());
        List<String> sharedCategories = productCategories.distinct().filter(a -> Arrays.stream(categories).anyMatch(b -> b.equals(a))).toList();
        return sharedCategories;
    }

    public List<String> intersectOfRegion() {
        String[] regions = {"WA", "AF", "RO"};
        List<Customer> customers = getCustomerList();
        var customerRegions = customers.stream().map(c -> c.getRegion());
        List<String> sharedRegions = customerRegions.distinct().filter(a -> Arrays.stream(regions).anyMatch(b -> b.equals(a))).toList();
        return sharedRegions;
    }

    public List<String> intersectOfName() {
        List<Product> products = getProductList();
        List<Customer> customers = getCustomerList();
        var productNames = products.stream().map(p -> p.getProductName());
        var customerNames = customers.stream().map(c -> c.getCompanyName());
        List<String> sharedNames = productNames.distinct().filter(a -> customerNames.anyMatch(b -> b.equals(a))).toList();
        return sharedNames;
    }

    public List<Character> intersectOfNameFirstChar() {
        List<Product> products = getProductList();
        List<Customer> customers = getCustomerList();
        var productFirstChars = products.stream().map(p -> p.getProductName().charAt(0));
        var customerFirstChars = customers.stream().map(c -> c.getCompanyName().charAt(0));
        List<Character> sharedFirstChars = productFirstChars.distinct().filter(a -> customerFirstChars.anyMatch(b -> b == a)).toList();
        return sharedFirstChars;
    }

    public int[] intExcept() {
        int[] numbersA = {0, 2, 4, 5, 9};
        int[] numbersB = {0, 2, 4, 5, 9};
        int[] differemtNumbers = Arrays.stream(numbersA).distinct().filter(a ->
                Arrays.stream(numbersB).allMatch(b -> b != a)).toArray();
        return differemtNumbers;
    }

    public double[] doubleExcept() {
        double[] numbersA = {0.1, 2.2, 4.3, 5.4, 6.5, 8.6, 9.7};
        double[] numbersB = {0.1, 3.3, 5.4, 7.7, 8.6};
        double[] differemtNumbers = Arrays.stream(numbersA).distinct().filter(a ->
                Arrays.stream(numbersB).allMatch(b -> b != a)).toArray();
        return differemtNumbers;
    }

    public String[] stringExcept() {
        String[] wordsA = {"Alice", "Bob", "Foo", "Bar"};
        String[] wordsB = {"Cafe", "Bar", "Restaurant"};
        String[] differemtWords = (String[]) Arrays.stream(wordsA).distinct().filter(a ->
                Arrays.stream(wordsB).allMatch(b -> !b.equals(a))).toArray();
        return differemtWords;
    }

    public int[] projectionIntExcept() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8};
        var first = Arrays.stream(numbersA).map(n -> n + 1);
        var second = Arrays.stream(numbersB).map(n -> n - 1);
        int[] differemtNumbers = first.distinct().filter(a -> second.allMatch(b -> b != a)).toArray();
        return differemtNumbers;
    }

    public double[] projectionDoubleExcept() {
        double[] numbersA = {0.1, 2.2, 4.3, 5.4, 6.5, 8.6, 9.7};
        double[] numbersB = {0.1, 3.3, 5.4, 7.7, 8.6};
        var first = Arrays.stream(numbersA).map(n -> n - (int) n);
        var second = Arrays.stream(numbersB).map(n -> n - (int) n);
        double[] differemtNumbers = first.distinct().filter(a -> second.allMatch(b -> b != a)).toArray();
        return differemtNumbers;
    }

    public Character[] projectionStringExcept() {
        String[] wordsA = {"Alice", "Bob", "Foo", "Bar"};
        String[] wordsB = {"Cafe", "Bar", "Restaurant"};
        var first = Arrays.stream(wordsA).map(n -> n.charAt(0));
        var second = Arrays.stream(wordsB).map(n -> n.charAt(0));
        Character[] differemtWords = (Character[]) first.distinct().filter(a -> second.allMatch(b -> b != a)).toArray();
        return differemtWords;
    }

    public List<String> exceptOfCategory() {
        String[] categories = {"Furnitures", "Seagoods"};
        List<Product> products = getProductList();
        var productCategories = products.stream().map(p -> p.getCategory());
        List<String> differemtCategories = productCategories.distinct().filter(a -> Arrays.stream(categories).allMatch(b -> !b.equals(a))).toList();
        return differemtCategories;
    }

    public List<String> exceptOfRegion() {
        String[] regions = {"WA", "AF", "RO"};
        List<Customer> customers = getCustomerList();
        var customerRegions = customers.stream().map(c -> c.getRegion());
        List<String> differemtRegions = customerRegions.distinct().filter(a -> Arrays.stream(regions).allMatch(b -> !b.equals(a))).toList();
        return differemtRegions;
    }

    public List<String> exceptOfName() {
        List<Product> products = getProductList();
        List<Customer> customers = getCustomerList();
        var productNames = products.stream().map(p -> p.getProductName());
        var customerNames = customers.stream().map(c -> c.getCompanyName());
        List<String> differemtNames = productNames.distinct().filter(a -> customerNames.allMatch(b -> !b.equals(a))).toList();
        return differemtNames;
    }

    public List<Character> exceptOfNameFirstChar() {
        List<Product> products = getProductList();
        List<Customer> customers = getCustomerList();
        var productFirstChars = products.stream().map(p -> p.getProductName().charAt(0));
        var customerFirstChars = customers.stream().map(c -> c.getCompanyName().charAt(0));
        List<Character> differemtFirstChars = productFirstChars.distinct().filter(a -> customerFirstChars.allMatch(b -> b != a)).toList();
        return differemtFirstChars;
    }

}
