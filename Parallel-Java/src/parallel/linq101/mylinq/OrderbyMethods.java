package parallel.linq101.mylinq;

import org.javatuples.Pair;
import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Product;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class OrderbyMethods {
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public class CaseInsensitiveComparer implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.toLowerCase().compareTo(o2.toLowerCase());
        }
    }

    public class CustomNumberComparer implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Math.abs(o1 - 5) - Math.abs(o2 - 5);
        }
    }


    public List<Double> doubleOrderby() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).boxed().sorted().toList();
        return sortedNumbers;
    }

    public List<Double> doubleOrderbyFraction() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).boxed().sorted(Comparator.comparing(n -> n - (int) n.doubleValue())).toList();
        return sortedNumbers;
    }

    public List<Double> doubleFractionOrderby() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).map(n -> n - (int) n).boxed().sorted().toList();
        return sortedNumbers;
    }

    public List<Double> bigDoubleOrderby() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).filter(n -> n > 5).boxed().sorted().toList();
        return sortedNumbers;
    }

    public List<Double> bigDoubleOrderbyFraction() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).filter(n -> n > 5).boxed().sorted(Comparator.comparing(n -> n - (int) n.doubleValue())).toList();
        return sortedNumbers;
    }

    public List<Double> bigDoubleFractionOrderby() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).filter(n -> n > 5).map(n -> n - (int) n).boxed().sorted().toList();
        return sortedNumbers;
    }

    public List<Pair<Boolean, List<Double>>> doubleGroupByBoolOrderby() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Pair<Boolean, List<Double>>> numbersGroups = Arrays.stream(numbers).boxed().collect(groupingBy(n -> n > 5))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().sorted().toList())).toList();
        return numbersGroups;
    }

    public Map<Boolean, List<Double>> doubleGroupByBoolDictOrderby() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        Map<Boolean, List<Double>> numbersGroups = Arrays.stream(numbers).boxed().collect(groupingBy(n -> n > 5))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().sorted().toList()));
        return numbersGroups;
    }

    public List<Pair<Boolean, List<Double>>> doubleGroupByBoolOrderbyFraction() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Pair<Boolean, List<Double>>> numbersGroups = Arrays.stream(numbers).boxed().collect(groupingBy(n -> n > 5))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().sorted(Comparator.comparing(
                        n -> n - (int) n.doubleValue())).toList())).toList();
        return numbersGroups;
    }

    public Map<Boolean, List<Double>> doubleGroupByBoolDictOrderbyFraction() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        Map<Boolean, List<Double>> numbersGroups = Arrays.stream(numbers).boxed().collect(groupingBy(n -> n > 5))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().sorted(Comparator.comparing(
                        n -> n - (int) n.doubleValue())).toList()));
        return numbersGroups;
    }

    public List<String> stringOrderby() {
        String[] words = {"cherry", "apple", "blueberry"};
        List<String> sortedWords = Arrays.stream(words).sorted().toList();
        return sortedWords;
    }

    public List<String> stringOrderbyLength() {
        String[] words = {"cherry", "apple", "blueberry"};
        List<String> sortedWords = Arrays.stream(words).sorted(Comparator.comparing(w -> w.length())).toList();
        return sortedWords;
    }

    public List<Integer> stringLengthOrderby() {
        String[] words = {"cherry", "apple", "blueberry"};
        List<Integer> sortedWords = Arrays.stream(words).map(w -> w.length()).sorted().toList();
        return sortedWords;
    }

    public List<String> shortStringOrderby() {
        String[] words = {"cherry", "apple", "blueberry", "pear", "peach", "melon"};
        List<String> sortedWords = Arrays.stream(words).filter(w -> w.length() < 6).sorted().toList();
        return sortedWords;
    }

    public List<String> shortStringOrderbyLength() {
        String[] words = {"cherry", "apple", "blueberry", "pear", "peach", "melon"};
        List<String> sortedWords = Arrays.stream(words).filter(w -> w.length() < 6).sorted(Comparator.comparing(w -> w.length())).toList();
        return sortedWords;
    }

    public List<Integer> shortStringLengthOrderby() {
        String[] words = {"cherry", "apple", "blueberry", "pear", "peach", "melon"};
        List<Integer> sortedWords = Arrays.stream(words).filter(w -> w.length() < 6).map(w -> w.length()).sorted().toList();
        return sortedWords;
    }

    public List<Pair<Character, List<String>>> stringGroupByFirstCharOrderby() {
        String[] words = {"blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese"};
        List<Pair<Character, List<String>>> wordsGroups = Arrays.stream(words).collect(groupingBy(w -> w.charAt(0)))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().sorted().toList())).toList();
        return wordsGroups;
    }

    public Map<Character, List<String>> stringGroupByFirstCharDictOrderby() {
        String[] words = {"blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese"};
        Map<Character, List<String>> wordsGroups = Arrays.stream(words).collect(groupingBy(w -> w.charAt(0)))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().sorted().toList()));
        return wordsGroups;
    }

    public List<Pair<Boolean, List<String>>> stringGroupByLengthOrderbyLength() {
        String[] words = {"blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese"};
        List<Pair<Boolean, List<String>>> wordsGroups = Arrays.stream(words).collect(groupingBy(w -> w.length() > 8))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().sorted(Comparator.comparing(w -> w.length())).toList())).toList();
        return wordsGroups;
    }

    public Map<Boolean, List<String>> stringGroupByLengthDictOrderbyLength() {
        String[] words = {"blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese"};
        Map<Boolean, List<String>> wordsGroups = Arrays.stream(words).collect(groupingBy(w -> w.length() > 8))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().sorted(Comparator.comparing(w -> w.length())).toList()));
        return wordsGroups;
    }

    public List<Product> productOrderbyId() {
        List<Product> products = getProductList();
        List<Product> sortedProducts = products.stream().sorted(Comparator.comparing(p -> p.getProductId())).toList();
        return sortedProducts;
    }

    public List<Product> productOrderbyName() {
        List<Product> products = getProductList();
        List<Product> sortedProducts = products.stream().sorted(Comparator.comparing(p -> p.getProductName())).toList();
        return sortedProducts;
    }

    public List<String> productNameOrderby() {
        List<Product> products = getProductList();
        List<String> sortedProducts = products.stream().map(p -> p.getProductName()).sorted().toList();
        return sortedProducts;
    }

    public List<Product> expensiveProductOrderbyId() {
        List<Product> products = getProductList();
        List<Product> sortedProducts = products.stream().filter(p -> p.getUnitPrice() > 100).sorted(Comparator.comparing(p -> p.getProductId())).toList();
        return sortedProducts;
    }

    public List<Product> expensiveProductOrderbyName() {
        List<Product> products = getProductList();
        List<Product> sortedProducts = products.stream().filter(p -> p.getUnitPrice() > 100).sorted(Comparator.comparing(p -> p.getProductName())).toList();
        return sortedProducts;
    }

    public List<String> expensiveProductNameOrderby() {
        List<Product> products = getProductList();
        List<String> sortedProducts = products.stream().filter(p -> p.getUnitPrice() > 100).map(p -> p.getProductName()).sorted().toList();
        return sortedProducts;
    }

    public List<Pair<String, List<Product>>> productGroupByCategoryOrderbyId() {
        List<Product> products = getProductList();
        List<Pair<String, List<Product>>> productsGroups = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream()
                        .sorted(Comparator.comparing(p -> p.getProductId())).toList())).toList();
        return productsGroups;
    }

    public Map<String, List<Product>> productGroupByCategoryDictOrderbyId() {
        List<Product> products = getProductList();
        Map<String, List<Product>> productsGroups = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream()
                        .sorted(Comparator.comparing(p -> p.getProductId())).toList()));
        return productsGroups;
    }

    public List<Pair<String, List<Product>>> productGroupByCategoryOrderbyName() {
        List<Product> products = getProductList();
        List<Pair<String, List<Product>>> productsGroups = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream()
                        .sorted(Comparator.comparing(p -> p.getProductName())).toList())).toList();
        return productsGroups;
    }

    public Map<String, List<Product>> productGroupByCategoryDictOrderbyName() {
        List<Product> products = getProductList();
        Map<String, List<Product>> productsGroups = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().
                        sorted(Comparator.comparing(p -> p.getProductName())).toList()));
        return productsGroups;
    }

    public List<String> stringOrderbyCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<String> sortedWords = Arrays.stream(words).sorted(new CaseInsensitiveComparer()).toList();
        return sortedWords;
    }

    public List<String> stringOrderbyLengthCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<String> sortedWords = Arrays.stream(words).sorted(Comparator.comparing(w -> w.length(),
                new CustomNumberComparer())).toList();
        return sortedWords;
    }

    public List<Integer> stringLengthOrderbyCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<Integer> sortedWords = Arrays.stream(words).map(w -> w.length()).sorted(new CustomNumberComparer()).toList();
        return sortedWords;
    }

    public List<String> shortStringOrderbyCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<String> sortedWords = Arrays.stream(words).filter(w -> w.length() < 6).sorted(new CaseInsensitiveComparer()).
                toList();
        return sortedWords;
    }

    public List<String> shortStringOrderbyLengthCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<String> sortedWords = Arrays.stream(words).filter(w -> w.length() < 6).sorted(Comparator.comparing(w -> w.length(),
                new CustomNumberComparer())).toList();
        return sortedWords;
    }

    public List<Integer> shortStringLengthOrderbyCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<Integer> sortedWords = Arrays.stream(words).filter(w -> w.length() < 6).map(w -> w.length()).
                sorted(new CustomNumberComparer()).toList();
        return sortedWords;
    }

    public List<Pair<Character, List<String>>> stringGroupByFirstCharOrderbyCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<Pair<Character, List<String>>> wordsGroups = Arrays.stream(words).collect(groupingBy(w -> Character.toLowerCase(w.charAt(0))))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().sorted(new CaseInsensitiveComparer()).toList())).toList();
        return wordsGroups;
    }

    public Map<Character, List<String>> stringGroupByFirstCharDictOrderbyCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        Map<Character, List<String>> wordsGroups = Arrays.stream(words).collect(groupingBy(w -> Character.toLowerCase(w.charAt(0))))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().sorted(new CaseInsensitiveComparer()).toList()));
        return wordsGroups;
    }

    public List<Pair<Boolean, List<String>>> stringGroupByLengthOrderbyLengthCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<Pair<Boolean, List<String>>> wordsGroups = Arrays.stream(words).collect(groupingBy(w -> w.length() > 8))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().sorted(
                        Comparator.comparing(w -> w.length(), new CustomNumberComparer())).toList())).toList();
        return wordsGroups;
    }

    public Map<Boolean, List<String>> stringGroupByLengthDictOrderbyLengthCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        Map<Boolean, List<String>> wordsGroups = Arrays.stream(words).collect(groupingBy(w -> w.length() > 8))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().sorted(
                        Comparator.comparing(w -> w.length(), new CustomNumberComparer())).toList()));
        return wordsGroups;
    }
}
