package parallel.linq101.mylinq;

import org.javatuples.Pair;
import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Product;

import java.util.*;

import static java.util.stream.Collectors.*;

public class OrderbyDescendingMethods {
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


    public List<Double> doubleOrderbyDescending() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).toList();
        return sortedNumbers;
    }

    public List<Double> doubleOrderbyDescendingFraction() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).boxed().sorted(
                Comparator.comparing(n -> n - (int) n.doubleValue(), Comparator.reverseOrder())).toList();
        return sortedNumbers;
    }

    public List<Double> doubleFractionOrderbyDescending() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).map(n -> n - (int) n).boxed().sorted(Comparator.reverseOrder()).toList();
        return sortedNumbers;
    }

    public List<Double> bigDoubleOrderbyDescending() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).filter(n -> n > 5).boxed().sorted(Comparator.reverseOrder()).toList();
        return sortedNumbers;
    }

    public List<Double> bigDoubleOrderbyDescendingFraction() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).filter(n -> n > 5).boxed().sorted(
                Comparator.comparing(n -> n - (int) n.doubleValue(), Comparator.reverseOrder())).toList();
        return sortedNumbers;
    }

    public List<Double> bigDoubleFractionOrderbyDescending() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).filter(n -> n > 5).map(n -> n - (int) n).boxed()
                .sorted(Comparator.reverseOrder()).toList();
        return sortedNumbers;
    }

    public List<Pair<Boolean, List<Double>>> doubleGroupByBoolOrderbyDescending() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Pair<Boolean, List<Double>>> numbersGroups = Arrays.stream(numbers).boxed().collect(groupingBy(n -> n > 5))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().sorted(Comparator.reverseOrder()).toList())).toList();
        return numbersGroups;
    }

    public Map<Boolean, List<Double>> doubleGroupByBoolDictOrderbyDescending() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        Map<Boolean, List<Double>> numbersGroups = Arrays.stream(numbers).boxed().collect(groupingBy(n -> n > 5))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().sorted(Comparator.reverseOrder()).toList()));
        return numbersGroups;
    }

    public List<Pair<Boolean, List<Double>>> doubleGroupByBoolOrderbyDescendingFraction() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Pair<Boolean, List<Double>>> numbersGroups = Arrays.stream(numbers).boxed().collect(groupingBy(n -> n > 5))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().sorted(Comparator.comparing(
                        n -> n - (int) n.doubleValue(), Comparator.reverseOrder())).toList())).toList();
        return numbersGroups;
    }

    public Map<Boolean, List<Double>> doubleGroupByBoolDictOrderbyDescendingFraction() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        Map<Boolean, List<Double>> numbersGroups = Arrays.stream(numbers).boxed().collect(groupingBy(n -> n > 5))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().sorted(Comparator.comparing(
                        n -> n - (int) n.doubleValue(), Comparator.reverseOrder())).toList()));
        return numbersGroups;
    }

    public List<String> stringOrderbyDescending() {
        String[] words = {"cherry", "apple", "blueberry"};
        List<String> sortedWords = Arrays.stream(words).sorted(Comparator.reverseOrder()).toList();
        return sortedWords;
    }

    public List<String> stringOrderbyDescendingLength() {
        String[] words = {"cherry", "apple", "blueberry"};
        List<String> sortedWords = Arrays.stream(words).sorted(Comparator.comparing(w -> w.length(), Comparator.reverseOrder())).toList();
        return sortedWords;
    }

    public List<Integer> stringLengthOrderbyDescending() {
        String[] words = {"cherry", "apple", "blueberry"};
        List<Integer> sortedWords = Arrays.stream(words).map(w -> w.length()).sorted(Comparator.reverseOrder()).toList();
        return sortedWords;
    }

    public List<String> shortStringOrderbyDescending() {
        String[] words = {"cherry", "apple", "blueberry", "pear", "peach", "melon"};
        List<String> sortedWords = Arrays.stream(words).filter(w -> w.length() < 6).sorted(Comparator.reverseOrder()).toList();
        return sortedWords;
    }

    public List<String> shortStringOrderbyDescendingLength() {
        String[] words = {"cherry", "apple", "blueberry", "pear", "peach", "melon"};
        List<String> sortedWords = Arrays.stream(words).filter(w -> w.length() < 6)
                .sorted(Comparator.comparing(w -> w.length(), Comparator.reverseOrder())).toList();
        return sortedWords;
    }

    public List<Integer> shortStringLengthOrderbyDescending() {
        String[] words = {"cherry", "apple", "blueberry", "pear", "peach", "melon"};
        List<Integer> sortedWords = Arrays.stream(words).filter(w -> w.length() < 6).map(w -> w.length())
                .sorted(Comparator.reverseOrder()).toList();
        return sortedWords;
    }

    public List<Pair<Character, List<String>>> stringGroupByFirstCharOrderbyDescending() {
        String[] words = {"blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese"};
        List<Pair<Character, List<String>>> wordsGroups = Arrays.stream(words).collect(groupingBy(w -> w.charAt(0)))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().sorted(Comparator.reverseOrder()).toList())).toList();
        return wordsGroups;
    }

    public Map<Character, List<String>> stringGroupByFirstCharDictOrderbyDescending() {
        String[] words = {"blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese"};
        Map<Character, List<String>> wordsGroups = Arrays.stream(words).collect(groupingBy(w -> w.charAt(0)))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().sorted(Comparator.reverseOrder()).toList()));
        return wordsGroups;
    }

    public List<Pair<Boolean, List<String>>> stringGroupByLengthOrderbyDescendingLength() {
        String[] words = {"blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese"};
        List<Pair<Boolean, List<String>>> wordsGroups = Arrays.stream(words).collect(groupingBy(w -> w.length() > 8))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream()
                        .sorted(Comparator.comparing(w -> w.length(), Comparator.reverseOrder())).toList())).toList();
        return wordsGroups;
    }

    public Map<Boolean, List<String>> stringGroupByLengthDictOrderbyDescendingLength() {
        String[] words = {"blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese"};
        Map<Boolean, List<String>> wordsGroups = Arrays.stream(words).collect(groupingBy(w -> w.length() > 8))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream()
                        .sorted(Comparator.comparing(w -> w.length(), Comparator.reverseOrder())).toList()));
        return wordsGroups;
    }

    public List<Product> productOrderbyDescendingId() {
        List<Product> products = getProductList();
        List<Product> sortedProducts = products.stream().sorted(
                Comparator.comparing(p -> p.getProductId(), Comparator.reverseOrder())).toList();
        return sortedProducts;
    }

    public List<Product> productOrderbyDescendingName() {
        List<Product> products = getProductList();
        List<Product> sortedProducts = products.stream().sorted(
                Comparator.comparing(p -> p.getProductName(), Comparator.reverseOrder())).toList();
        return sortedProducts;
    }

    public List<String> productNameOrderbyDescending() {
        List<Product> products = getProductList();
        List<String> sortedProducts = products.stream().map(p -> p.getProductName())
                .sorted(Comparator.reverseOrder()).toList();
        return sortedProducts;
    }

    public List<Product> expensiveProductOrderbyDescendingId() {
        List<Product> products = getProductList();
        List<Product> sortedProducts = products.stream().filter(p -> p.getUnitPrice() > 100)
                .sorted(Comparator.comparing(p -> p.getProductId(), Comparator.reverseOrder())).toList();
        return sortedProducts;
    }

    public List<Product> expensiveProductOrderbyDescendingName() {
        List<Product> products = getProductList();
        List<Product> sortedProducts = products.stream().filter(p -> p.getUnitPrice() > 100)
                .sorted(Comparator.comparing(p -> p.getProductName(), Comparator.reverseOrder())).toList();
        return sortedProducts;
    }

    public List<String> expensiveProductNameOrderbyDescending() {
        List<Product> products = getProductList();
        List<String> sortedProducts = products.stream().filter(p -> p.getUnitPrice() > 100)
                .map(p -> p.getProductName()).sorted(Comparator.reverseOrder()).toList();
        return sortedProducts;
    }

    public List<Pair<String, List<Product>>> productGroupByCategoryOrderbyDescendingId() {
        List<Product> products = getProductList();
        List<Pair<String, List<Product>>> productsGroups = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream()
                        .sorted(Comparator.comparing(p -> p.getProductId(),Comparator.reverseOrder())).toList())).toList();
        return productsGroups;
    }

    public Map<String, List<Product>> productGroupByCategoryDictOrderbyDescendingId() {
        List<Product> products = getProductList();
        Map<String, List<Product>> productsGroups = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream()
                        .sorted(Comparator.comparing(p -> p.getProductName(),Comparator.reverseOrder())).toList()));
        return productsGroups;
    }

    public List<Pair<String, List<Product>>> productGroupByCategoryOrderbyDescendingName() {
        List<Product> products = getProductList();
        List<Pair<String, List<Product>>> productsGroups = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream()
                        .sorted(Comparator.comparing(p -> p.getProductName(),Comparator.reverseOrder())).toList())).toList();
        return productsGroups;
    }

    public Map<String, List<Product>> productGroupByCategoryDictOrderbyDescendingName() {
        List<Product> products = getProductList();
        Map<String, List<Product>> productsGroups = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().
                        sorted(Comparator.comparing(p -> p.getProductName(),Comparator.reverseOrder())).toList()));
        return productsGroups;
    }

    public List<String> stringOrderbyDescendingCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<String> sortedWords = Arrays.stream(words).sorted(new CaseInsensitiveComparer().reversed()).toList();
        return sortedWords;
    }

    public List<String> stringOrderbyDescendingLengthCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<String> sortedWords = Arrays.stream(words).sorted(Comparator.comparing(w -> w.length(),
                new CustomNumberComparer().reversed())).toList();
        return sortedWords;
    }

    public List<Integer> stringLengthOrderbyDescendingCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<Integer> sortedWords = Arrays.stream(words).map(w -> w.length()).sorted(new CustomNumberComparer().reversed()).toList();
        return sortedWords;
    }

    public List<String> shortStringOrderbyDescendingCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<String> sortedWords = Arrays.stream(words).filter(w -> w.length() < 6).sorted(new CaseInsensitiveComparer().reversed()).
                toList();
        return sortedWords;
    }

    public List<String> shortStringOrderbyDescendingLengthCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<String> sortedWords = Arrays.stream(words).filter(w -> w.length() < 6).sorted(Comparator.comparing(w -> w.length(),
                new CustomNumberComparer().reversed())).toList();
        return sortedWords;
    }

    public List<Integer> shortStringLengthOrderbyDescendingCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<Integer> sortedWords = Arrays.stream(words).filter(w -> w.length() < 6).map(w -> w.length()).
                sorted(new CustomNumberComparer().reversed()).toList();
        return sortedWords;
    }

    public List<Pair<Character, List<String>>> stringGroupByFirstCharOrderbyDescendingCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<Pair<Character, List<String>>> wordsGroups = Arrays.stream(words).collect(groupingBy(w -> Character.toLowerCase(w.charAt(0))))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().sorted(new CaseInsensitiveComparer().reversed()).toList())).toList();
        return wordsGroups;
    }

    public Map<Character, List<String>> stringGroupByFirstCharDictOrderbyDescendingCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        Map<Character, List<String>> wordsGroups = Arrays.stream(words).collect(groupingBy(w -> Character.toLowerCase(w.charAt(0))))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().sorted(new CaseInsensitiveComparer().reversed()).toList()));
        return wordsGroups;
    }

    public List<Pair<Boolean, List<String>>> stringGroupByLengthOrderbyDescendingLengthCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<Pair<Boolean, List<String>>> wordsGroups = Arrays.stream(words).collect(groupingBy(w -> w.length() > 8))
                .entrySet().stream().map(g -> Pair.with(g.getKey(), g.getValue().stream().sorted(
                        Comparator.comparing(w -> w.length(), new CustomNumberComparer().reversed())).toList())).toList();
        return wordsGroups;
    }

    public Map<Boolean, List<String>> stringGroupByLengthDictOrderbyDescendingLengthCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        Map<Boolean, List<String>> wordsGroups = Arrays.stream(words).collect(groupingBy(w -> w.length() > 8))
                .entrySet().stream().collect(toMap(g -> g.getKey(), g -> g.getValue().stream().sorted(
                        Comparator.comparing(w -> w.length(), new CustomNumberComparer().reversed())).toList()));
        return wordsGroups;
    }

    //Reverse
    public List<Double> doubleReverse() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<Double> sortedNumbers = Arrays.stream(numbers).boxed().collect(
                collectingAndThen(toList(),l->{Collections.reverse(l);return l;}));
        return sortedNumbers;
    }

    public List<Double> doubleOrderbyReverse() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<Double> sortedNumbers = Arrays.stream(numbers).sorted().boxed().collect(
                collectingAndThen(toList(),l->{Collections.reverse(l);return l;}));
        return sortedNumbers;
    }

    public List<Double> doubleOrderbyFractionReverse() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<Double> sortedNumbers = Arrays.stream(numbers).boxed().sorted(Comparator.comparing(n -> n-(int)n.doubleValue()))
                .collect(collectingAndThen(toList(),l->{Collections.reverse(l);return l;}));
        return sortedNumbers;
    }

    public List<Double> doubleFractionReverse() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<Double> sortedNumbers = Arrays.stream(numbers).map(n -> n-(int)n).boxed()
                .collect(collectingAndThen(toList(),l->{Collections.reverse(l);return l;}));
        return sortedNumbers;
    }

    public List<Double> doubleFractionOrderbyReverse() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<Double> sortedNumbers = Arrays.stream(numbers).map(n -> n-(int)n).boxed().sorted()
                .collect(collectingAndThen(toList(),l->{Collections.reverse(l);return l;}));
        return sortedNumbers;
    }

    public List<String> stringReverse() {
        String[] words = { "cherry", "apple", "blueberry" };
        List<String> sortedWords = Arrays.stream(words).collect(
                collectingAndThen(toList(),l->{Collections.reverse(l);return l;}));
        return sortedWords;
    }

    public List<String> stringOrderbyReverse() {
        String[] words = { "cherry", "apple", "blueberry" };
        List<String> sortedWords = Arrays.stream(words).sorted().collect(
                collectingAndThen(toList(),l->{Collections.reverse(l);return l;}));
        return sortedWords;
    }

    public List<String> stringOrderbyLengthReverse() {
        String[] words = { "cherry", "apple", "blueberry" };
        List<String> sortedWords = Arrays.stream(words).sorted(Comparator.comparing(w->w.length())).collect(
                collectingAndThen(toList(),l->{Collections.reverse(l);return l;}));
        return sortedWords;
    }

    public List<String> shortStringReverse() {
        String[] words = { "cherry", "apple", "blueberry", "pear", "peach", "melon" };
        List<String> sortedWords = Arrays.stream(words).filter(w -> w.length() < 6).collect(
                collectingAndThen(toList(),l->{Collections.reverse(l);return l;}));
        return sortedWords;
    }

    public List<String> shortStringOrderbyLengthReverse() {
        String[] words = { "cherry", "apple", "blueberry", "pear", "peach", "melon" };
        List<String> sortedWords = Arrays.stream(words).filter(w -> w.length() < 6)
                .sorted(Comparator.comparing(w->w.length())).collect(
                collectingAndThen(toList(),l->{Collections.reverse(l);return l;}));
        return sortedWords;
    }

}
