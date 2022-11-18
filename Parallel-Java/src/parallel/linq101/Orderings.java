package parallel.linq101;

import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Product;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Orderings {
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public int orderbySyntax() {
        String[] words = {"cherry", "apple", "blueberry"};
        var sortedWords = Arrays.stream(words).sorted().toArray();
        System.out.println("The sorted list of words:");
        for (var w : sortedWords)
            System.out.println(w);
        return 0;
    }

    public int orderbyProperty() {
        String[] words = {"cherry", "apple", "blueberry"};
        var sortedWords = Arrays.stream(words).sorted(Comparator.comparing(w -> w.length())).toArray();
        System.out.println("The sorted list of words (by length):");
        for (var w : sortedWords)
            System.out.println(w);
        return 0;
    }

    public int orderByProducts() {
        List<Product> products = getProductList();
        var sortedProducts = products.stream().sorted(Comparator.comparing(p -> p.getProductName()))
                .collect(Collectors.toList());
        for (var product : sortedProducts)
            System.out.println(product);
        return 0;
    }

    public static class CaseInsensitiveComparer implements Comparator<String> {
        @Override
        public int compare(String x, String y) {
            return x.toUpperCase().compareTo(y.toUpperCase());
        }
    }

    public int orderByWithCustomComparer() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        var sortedWords = Arrays.stream(words).sorted(new CaseInsensitiveComparer()).toArray();
        for (var word : sortedWords)
            System.out.println(word);
        return 0;
    }

    public int orderByDescendingSyntax() {
        double[] doubles = {1.7, 2.3, 1.9, 4.1, 2.9};
        var sortedDoubles = Arrays.stream(doubles).boxed().sorted(Comparator.reverseOrder()).toArray();
        System.out.println("The doubles from highest to lowest:");
        for (var d : sortedDoubles)
            System.out.println(d);
        return 0;
    }

    public int orderProductsDescending() {
        List<Product> products = getProductList();
        var sortedProducts = products.stream().sorted(
                Comparator.comparing((Product p) -> p.getUnitsInStock(), Comparator.reverseOrder())).toList();
        for (var product : sortedProducts)
            System.out.println(product);
        return 0;
    }

    public int descendingCustomComparer() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        var sortedWords = Arrays.stream(words).sorted(new CaseInsensitiveComparer().reversed()).toArray();
        for (var word : sortedWords)
            System.out.println(word);
        return 0;
    }

    public int thenBySyntax() {
        String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        var sortedDigits = Arrays.stream(digits).sorted(Comparator.comparing((String w) -> w.length())
                .thenComparing(d -> d)).toArray();
        System.out.println("Sorted digits:");
        for (var d : sortedDigits)
            System.out.println(d);
        return 0;
    }

    public int thenByCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        var sortedWords = Arrays.stream(words).sorted(Comparator.comparing((String w) -> w.length())
                .thenComparing(new CaseInsensitiveComparer())).toArray();
        for (var word : sortedWords)
            System.out.println(word);
        return 0;
    }

    public int thenByDifferentOrdering() {
        List<Product> products = getProductList();
        var sortedProducts = products.stream().sorted(Comparator.comparing((Product p) -> p.getCategory())
                .thenComparing(p -> p.getUnitPrice(), Comparator.reverseOrder())).collect(Collectors.toList());
        for (var product : sortedProducts)
            System.out.println(product);
        return 0;
    }

    public int customThenByDescending() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        var sortedWords = Arrays.stream(words).sorted(Comparator.comparing((String w) -> w.length()).
                thenComparing(new CaseInsensitiveComparer().reversed())).toArray();
        for (var word : sortedWords)
            System.out.println(word);
        return 0;
    }

    public int orderingReversal() {
        String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        var reversedIDigits = Arrays.stream(digits).filter(d -> d.charAt(1) == 'i').
                collect(Collectors.collectingAndThen(Collectors.toList(),
                        list->{Collections.reverse(list);return list.stream();})).toArray();
        System.out.println("A backwards list of the digits with a second character of 'i':");
        for (var d : reversedIDigits)
            System.out.println(d);
        return 0;
    }
}
