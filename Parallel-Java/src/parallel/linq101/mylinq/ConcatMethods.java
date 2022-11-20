package parallel.linq101.mylinq;

import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConcatMethods {
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public boolean equalInts() {
        int[] numbersA = {0, 2, 4, 5, 9};
        int[] numbersB = {0, 2, 4, 5, 9};
        boolean equal = Arrays.equals(numbersA, numbersB);
        return equal;
    }

    public boolean unequalInts() {
        int[] numbersA = {0, 2, 4, 5, 9};
        int[] numbersB = {1, 3, 5, 6, 10};
        boolean equal = Arrays.equals(numbersA, numbersB);
        return equal;
    }

    public boolean projectionEqualInts() {
        int[] numbersA = {0, 2, 4, 5, 9};
        int[] numbersB = {1, 3, 5, 6, 10};
        boolean equal = Arrays.equals(Arrays.stream(numbersA).map(n -> n + 1).
                toArray(), numbersB);
        return equal;
    }

    public boolean equalDoubles() {
        double[] numbersA = {0.5, 2.3, 4.7, 5.4, 9.8};
        double[] numbersB = {0.5, 2.3, 4.7, 5.4, 9.8};
        boolean equal = Arrays.equals(numbersA, numbersB);
        return equal;
    }

    public boolean unequalDoubles() {
        double[] numbersA = {0.5, 2.3, 4.7, 5.4, 9.8};
        double[] numbersB = {6.5, 1.3, 8.7, 2.4, 4.8};
        boolean equal = Arrays.equals(numbersA, numbersB);
        return equal;
    }

    public boolean projectionEqualDoubles() {
        double[] numbersA = {0.5, 2.3, 4.7, 5.4, 9.8};
        double[] numbersB = {6.5, 1.3, 8.7, 2.4, 4.8};
        boolean equal = Arrays.equals(Arrays.stream(numbersA).map(n -> n - (int) n).
                toArray(), numbersB);
        return equal;
    }

    public boolean equalStrings() {
        List<String> wordsA = Arrays.asList("Alpha", "Beta", "Gamma");
        List<String> wordsB = Arrays.asList("Alpha", "Beta", "Gamma");
        boolean equal = wordsA.equals(wordsB);
        return equal;
    }

    public boolean equalStringsLengths() {
        List<String> wordsA = Arrays.asList("Alpha", "Beta", "Gamma");
        List<String> wordsB = Arrays.asList("Gamma", "Beta", "Alpha");
        boolean equal = wordsA.stream().map(w -> w.length()).toList().equals(wordsB);
        return equal;
    }

    public boolean unequalStrings() {
        List<String> wordsA = Arrays.asList("Alpha", "Beta", "Gamma");
        List<String> wordsB = Arrays.asList("aLPhA", "bETa", "gAaMa");
        boolean equal = wordsA.equals(wordsB);
        return equal;
    }

    public boolean projectionEqualStrings() {
        List<String> wordsA = Arrays.asList("Alpha", "Beta", "Gamma");
        List<String> wordsB = Arrays.asList("aLPhA", "bETa", "gAaMa");
        boolean equal = wordsA.stream().map(w -> w.toLowerCase()).toList().equals(wordsB);
        return equal;
    }

    public int[] intConcat() {
        int[] numbersA = {0, 2, 4, 5, 9};
        int[] numbersB = {0, 2, 4, 5, 9};
        int[] allNumbers = IntStream.concat(Arrays.stream(numbersA), Arrays.stream(numbersB)).toArray();
        return allNumbers;
    }

    public double[] doubleConcat() {
        double[] numbersA = {0.1, 2.2, 4.3, 5.4, 6.5, 8.6, 9.7};
        double[] numbersB = {0.1, 3.3, 5.4, 7.7, 8.6};
        double[] allNumbers = DoubleStream.concat(Arrays.stream(numbersA), Arrays.stream(numbersB)).toArray();
        return allNumbers;
    }

    public String[] stringConcat() {
        String[] wordsA = {"Alice", "Bob", "Foo", "Bar"};
        String[] wordsB = {"Cafe", "Bar", "Restaurant"};
        String[] allWords = (String[]) Stream.concat(Arrays.stream(wordsA), Arrays.stream(wordsB)).toArray();
        return allWords;
    }

    public int[] projectionIntConcat() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8};
        var first = Arrays.stream(numbersA).map(n -> n + 1);
        var second = Arrays.stream(numbersB).map(n -> n - 1);
        int[] allNumbers = IntStream.concat(first, second).toArray();
        return allNumbers;
    }

    public double[] projectionDoubleConcat() {
        double[] numbersA = {0.1, 2.2, 4.3, 5.4, 6.5, 8.6, 9.7};
        double[] numbersB = {0.1, 3.3, 5.4, 7.7, 8.6};
        var first = Arrays.stream(numbersA).map(n -> n - (int) n);
        var second = Arrays.stream(numbersB).map(n -> n - (int) n);
        double[] allNumbers = DoubleStream.concat(first, second).toArray();
        return allNumbers;
    }

    public Character[] projectionStringConcat() {
        String[] wordsA = {"Alice", "Bob", "Foo", "Bar"};
        String[] wordsB = {"Cafe", "Bar", "Restaurant"};
        var first = Arrays.stream(wordsA).map(n -> n.charAt(0));
        var second = Arrays.stream(wordsB).map(n -> n.charAt(0));
        Character[] allWords = (Character[]) Stream.concat(first, second).toArray();
        return allWords;
    }

    public List<String> concatOfCategory() {
        String[] categories = {"Furnitures", "Seagoods"};
        List<Product> products = getProductList();
        var productCategories = products.stream().map(p -> p.getCategory());
        List<String> allCategories = Stream.concat(productCategories, Arrays.stream(categories)).toList();
        return allCategories;
    }

    public List<String> concatOfRegion() {
        String[] regions = {"WA", "AF", "RO"};
        List<Customer> customers = getCustomerList();
        var customerRegions = customers.stream().map(c -> c.getRegion());
        List<String> allRegions = Stream.concat(customerRegions, Arrays.stream(regions)).toList();
        return allRegions;
    }

    public List<String> concatOfName() {
        List<Product> products = getProductList();
        List<Customer> customers = getCustomerList();
        var productNames = products.stream().map(p -> p.getProductName());
        var customerNames = customers.stream().map(c -> c.getCompanyName());
        List<String> allNames = Stream.concat(productNames, customerNames).toList();
        return allNames;
    }

    public List<Character> concatOfNameFirstChar() {
        List<Product> products = getProductList();
        List<Customer> customers = getCustomerList();
        var productFirstChars = products.stream().map(p -> p.getProductName().charAt(0));
        var customerFirstChars = customers.stream().map(c -> c.getCompanyName().charAt(0));
        List<Character> allFirstChars = Stream.concat(productFirstChars, customerFirstChars).toList();
        return allFirstChars;
    }

    public int[] intZipAdd() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8, 10, 11};
        int length = numbersA.length;
        int[] addNumbers = IntStream.range(0, length).map(i -> numbersA[i] + numbersB[i]).toArray();
        return addNumbers;
    }

    public int[] intZipAddReverse() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8, 10, 11};
        int length = numbersA.length;
        int[] addNumbers = IntStream.range(0, length).map(i -> numbersA[i] + numbersB[length - 1 - i]).toArray();
        return addNumbers;
    }

    public int[] intZipSub() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8, 10, 11};
        int length = numbersA.length;
        int[] subNumbers = IntStream.range(0, length).map(i -> numbersA[i] - numbersB[i]).toArray();
        return subNumbers;
    }

    public int[] intZipMultiply() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8, 10, 11};
        int length = numbersA.length;
        int[] multiplyNumbers = IntStream.range(0, length).map(i -> numbersA[i] * numbersB[i]).toArray();
        return multiplyNumbers;
    }

    public int intDotProduct() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8, 10, 11};
        int length = numbersA.length;
        int dotProduct = IntStream.range(0, length).map(i -> numbersA[i] * numbersB[i]).sum();
        return dotProduct;
    }

    public int intAddMultiply() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8, 10, 11};
        int length = numbersA.length;
        int product = IntStream.range(0, length).map(i -> numbersA[i] + numbersB[i])
                .reduce((a, b) -> a * b).getAsInt();
        return product;
    }

    public String[] stringZipAdd() {
        String[] wordsA = {"Alpha", "Beta", "Gamma"};
        String[] wordsB = {"red", "green", "blue"};
        int length = wordsA.length;
        String[] results = (String[]) IntStream.range(0, length).mapToObj(i -> wordsA[i] + wordsB[i]).toArray();
        return results;
    }

    public String[] stringZipAddInt() {
        String[] words = {"Alpha", "Beta", "Gamma"};
        int[] numbers = {1, 2, 3};
        int length = words.length;
        String[] results = (String[]) IntStream.range(0, length).mapToObj(i -> words[i] + numbers[i]).toArray();
        return results;
    }

    public String[] stringProjectionZipAdd() {
        String[] wordsA = {"Alpha", "Beta", "Gamma"};
        String[] wordsB = {"red", "green", "blue"};
        int length = wordsA.length;
        String[] results = (String[]) IntStream.range(0, length)
                .mapToObj(i -> String.valueOf(wordsA[i].charAt(0)) + wordsB[i].charAt(0)).toArray();
        return results;
    }

    public int[] stringProjectionZipAddInt() {
        String[] wordsA = {"Alpha", "Beta", "Gamma"};
        String[] wordsB = {"red", "green", "blue"};
        int length = wordsA.length;
        int[] results = IntStream.range(0, length).map(i -> wordsA[i].length() + wordsB[i].length()).toArray();
        return results;
    }
}
