package parallel.linq101.mylinq;

import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Product;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ThenbyMethods {
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

    public List<Double> doubleOrderbyFractionThenby() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).boxed().sorted(
                Comparator.comparing((Double n) -> n - (int) n.doubleValue())
                        .thenComparing(Comparator.naturalOrder())).toList();
        return sortedNumbers;
    }

    public List<Double> doubleOrderbyModThenby() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).boxed().sorted(
                Comparator.comparing((Double n) -> n % 1.5)
                        .thenComparing(Comparator.naturalOrder())).toList();
        return sortedNumbers;
    }

    public List<Double> doubleOrderbyFractionDescendingThenby() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).boxed().sorted(
                Comparator.comparing((Double n) -> n - (int) n.doubleValue(),Comparator.reverseOrder())
                        .thenComparing(Comparator.naturalOrder())).toList();
        return sortedNumbers;
    }

    public List<Double> doubleOrderbyModDescendingThenby() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).boxed().sorted(
                Comparator.comparing((Double n) -> n % 1.5,Comparator.reverseOrder())
                        .thenComparing(Comparator.naturalOrder())).toList();
        return sortedNumbers;
    }

    public List<Double> doubleOrderbyFractionThenbyDescending() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).boxed().sorted(
                Comparator.comparing((Double n) -> n - (int) n.doubleValue())
                        .thenComparing(Comparator.reverseOrder())).toList();
        return sortedNumbers;
    }

    public List<Double> doubleOrderbyModThenbyDescending() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).boxed().sorted(
                Comparator.comparing((Double n) -> n % 1.5)
                        .thenComparing(Comparator.reverseOrder())).toList();
        return sortedNumbers;
    }

    public List<Double> doubleOrderbyFractionDescendingThenbyDescending() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).boxed().sorted(
                Comparator.comparing((Double n) -> n - (int) n.doubleValue(),Comparator.reverseOrder())
                        .thenComparing(Comparator.reverseOrder())).toList();
        return sortedNumbers;
    }

    public List<Double> doubleOrderbyModDescendingThenbyDescending() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).boxed().sorted(
                Comparator.comparing((Double n) -> n % 1.5,Comparator.reverseOrder())
                        .thenComparing(Comparator.reverseOrder())).toList();
        return sortedNumbers;
    }

    public List<Double> bigDoubleOrderbyFractionThenby() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).boxed().sorted(
                Comparator.comparing((Double n) -> n - (int) n.doubleValue())
                        .thenComparing(Comparator.naturalOrder())).toList();
        return sortedNumbers;
    }

    public List<Double> bigDoubleOrderbyModThenby() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).filter(n->n>3).boxed().sorted(
                Comparator.comparing((Double n) -> n % 1.5)
                        .thenComparing(Comparator.naturalOrder())).toList();
        return sortedNumbers;
    }

    public List<Double> bigDoubleOrderbyFractionDescendingThenby() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).filter(n->n>3).boxed().sorted(
                Comparator.comparing((Double n) -> n - (int) n.doubleValue(),Comparator.reverseOrder())
                        .thenComparing(Comparator.naturalOrder())).toList();
        return sortedNumbers;
    }

    public List<Double> bigDoubleOrderbyModDescendingThenby() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).filter(n->n>3).boxed().sorted(
                Comparator.comparing((Double n) -> n % 1.5,Comparator.reverseOrder())
                        .thenComparing(Comparator.naturalOrder())).toList();
        return sortedNumbers;
    }

    public List<Double> bigDoubleOrderbyFractionThenbyDescending() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).filter(n->n>3).boxed().sorted(
                Comparator.comparing((Double n) -> n - (int) n.doubleValue())
                        .thenComparing(Comparator.reverseOrder())).toList();
        return sortedNumbers;
    }

    public List<Double> bigDoubleOrderbyModThenbyDescending() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).filter(n->n>3).boxed().sorted(
                Comparator.comparing((Double n) -> n % 1.5)
                        .thenComparing(Comparator.reverseOrder())).toList();
        return sortedNumbers;
    }

    public List<Double> bigDoubleOrderbyFractionDescendingThenbyDescending() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).filter(n->n>3).boxed().sorted(
                Comparator.comparing((Double n) -> n - (int) n.doubleValue(),Comparator.reverseOrder())
                        .thenComparing(Comparator.reverseOrder())).toList();
        return sortedNumbers;
    }

    public List<Double> bigDoubleOrderbyModDescendingThenbyDescending() {
        double[] numbers = {3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0};
        List<Double> sortedNumbers = Arrays.stream(numbers).filter(n->n>3).boxed().sorted(
                Comparator.comparing((Double n) -> n % 1.5,Comparator.reverseOrder())
                        .thenComparing(Comparator.reverseOrder())).toList();
        return sortedNumbers;
    }

    public List<String> stringOrderbyLengthThenby() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        List<String> sortedWords = Arrays.stream(words).sorted(Comparator.comparing((String w) -> w.length())
                .thenComparing(Comparator.naturalOrder())).toList();
        return sortedWords;
    }

    public List<String> stringOrderbyThenbyLength() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        List<String> sortedWords = Arrays.stream(words).sorted(Comparator.comparing((String w) -> w)
                .thenComparing(w -> w.length())).toList();
        return sortedWords;
    }

    public List<String> stringOrderbyLengthCustomThenby() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        List<String> sortedWords =  Arrays.stream(words).sorted(Comparator.comparing((String w) -> w.length(),
                new CustomNumberComparer()).thenComparing(Comparator.naturalOrder())).toList();
        return sortedWords;
    }

    public List<String> stringOrderbyThenbyLengthCustom() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        List<String> sortedWords = Arrays.stream(words).sorted(Comparator.comparing((String w) -> w)
                .thenComparing(w -> w.length(),new CustomNumberComparer())).toList();
        return sortedWords;
    }

    public List<String> stringOrderbyLengthThenbyCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<String> sortedWords = Arrays.stream(words).sorted(Comparator.comparing((String w) -> w.length())
                .thenComparing(new CaseInsensitiveComparer())).toList();
        return sortedWords;
    }

    public List<String> stringOrderbyCustomThenbyLength() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<String> sortedWords =Arrays.stream(words)
                .sorted(Comparator.comparing((String w) -> w,new CaseInsensitiveComparer())
                .thenComparing(w -> w.length())).toList();
        return sortedWords;
    }

    public List<String> stringOrderbyLengthCustomThenbyCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<String> sortedWords = Arrays.stream(words).sorted(Comparator
                .comparing((String w) -> w.length(),new CustomNumberComparer())
                .thenComparing(new CaseInsensitiveComparer())).toList();
        return sortedWords;
    }

    public List<String> stringOrderbyCustomThenbyLengthCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<String> sortedWords = Arrays.stream(words)
                .sorted(Comparator.comparing((String w) -> w,new CaseInsensitiveComparer())
                        .thenComparing(w -> w.length(),new CustomNumberComparer())).toList();
        return sortedWords;
    }

    public List<String> stringOrderbyThenbyLengthDescendingCustom() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        List<String> sortedWords =Arrays.stream(words).sorted(Comparator.comparing((String w) -> w)
                .thenComparing(w -> w.length(),new CustomNumberComparer().reversed())).toList();
        return sortedWords;
    }

    public List<String> stringOrderbyLengthThenbyDescendingCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<String> sortedWords =Arrays.stream(words).sorted(Comparator.comparing((String w) -> w.length())
                .thenComparing(new CaseInsensitiveComparer().reversed())).toList();
        return sortedWords;
    }

    public List<String> stringOrderbyLengthCustomThenbyDescendingCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<String> sortedWords = Arrays.stream(words)
                .sorted(Comparator.comparing((String w) -> w.length(),new CustomNumberComparer())
                .thenComparing(new CaseInsensitiveComparer().reversed())).toList();
        return sortedWords;
    }

    public List<String> stringOrderbyCustomThenbyLengthDescendingCustom() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<String> sortedWords = Arrays.stream(words).sorted(Comparator.comparing((String w) -> w,new CaseInsensitiveComparer())
                .thenComparing(w -> w.length(),new CustomNumberComparer().reversed())).toList();
        return sortedWords;
    }

    public List<Product> productOrderbyCategoryThenbyId() {
        List<Product> products = getProductList();
        List<Product> sortedProducts = products.stream().sorted(Comparator.comparing((Product p) -> p.getCategory())
                .thenComparing(p -> p.getProductId())).toList();
        return sortedProducts;
    }

    public List<Product> productOrderbyCategoryThenbyName() {
        List<Product> products = getProductList();
        List<Product> sortedProducts = products.stream().sorted(Comparator.comparing((Product p) -> p.getCategory())
                .thenComparing(p -> p.getProductName())).toList();
        return sortedProducts;
    }

    public List<Product> productOrderbyCategoryThenbyDescendingId() {
        List<Product> products = getProductList();
        List<Product> sortedProducts = products.stream().sorted(Comparator.comparing((Product p) -> p.getCategory())
                .thenComparing(p -> p.getProductId(),Comparator.reverseOrder())).toList();
        return sortedProducts;
    }

    public List<Product> productOrderbyCategoryThenbyDescendingName() {
        List<Product> products = getProductList();
        List<Product> sortedProducts =products.stream().sorted(Comparator.comparing((Product p) -> p.getCategory())
                .thenComparing(p -> p.getProductName(),Comparator.reverseOrder())).toList();
        return sortedProducts;
    }

    public List<Product> expensiveProductOrderbyCategoryThenbyId() {
        List<Product> products = getProductList();
        List<Product> sortedProducts = products.stream().filter(p->p.getUnitPrice()>100)
                .sorted(Comparator.comparing((Product p) -> p.getCategory())
                .thenComparing(p -> p.getProductName())).toList();
        return sortedProducts;
    }

    public List<Product> expensiveProductOrderbyCategoryThenbyName() {
        List<Product> products = getProductList();
        List<Product> sortedProducts = products.stream().filter(p->p.getUnitPrice()>100)
                .sorted(Comparator.comparing((Product p) -> p.getCategory())
                        .thenComparing(p -> p.getProductName())).toList();
        return sortedProducts;
    }

    public List<Product> productOrderbyCategoryThenbyIdCustom() {
        List<Product> products = getProductList();
        List<Product> sortedProducts = products.stream().sorted(Comparator.comparing((Product p) -> p.getCategory())
                .thenComparing(p -> p.getProductId(),new CustomNumberComparer())).toList();
        return sortedProducts;
    }

    public List<Product> productOrderbyCategoryThenbyNameCustom() {
        List<Product> products = getProductList();
        List<Product> sortedProducts = products.stream().sorted(Comparator.comparing((Product p) -> p.getCategory())
                .thenComparing(p -> p.getProductName(),new CaseInsensitiveComparer())).toList();
        return sortedProducts;
    }

    public List<Product> productOrderbyCategoryThenbyDescendingIdCustom() {
        List<Product> products = getProductList();
        List<Product> sortedProducts = products.stream().sorted(Comparator.comparing((Product p) -> p.getCategory())
                .thenComparing(p -> p.getProductId(),new CustomNumberComparer().reversed())).toList();
        return sortedProducts;
    }

    public List<Product> productOrderbyCategoryThenbyDescendingNameCustom() {
        List<Product> products = getProductList();
        List<Product> sortedProducts = products.stream().sorted(Comparator.comparing((Product p) -> p.getCategory())
                .thenComparing(p -> p.getProductName(),new CaseInsensitiveComparer().reversed())).toList();
        return sortedProducts;
    }

    public List<Product> expensiveProductOrderbyCategoryThenbyIdCustom() {
        List<Product> products = getProductList();
        List<Product> sortedProducts = products.stream().filter(p->p.getUnitPrice()>100)
                .sorted(Comparator.comparing((Product p) -> p.getCategory())
                .thenComparing(p -> p.getProductId(),new CustomNumberComparer().reversed())).toList();
        return sortedProducts;
    }

    public List<Product> expensiveProductOrderbyCategoryThenbyNameCustom() {
        List<Product> products = getProductList();
        List<Product> sortedProducts = products.stream().filter(p->p.getUnitPrice()>100)
                .sorted(Comparator.comparing((Product p) -> p.getCategory())
                .thenComparing(p -> p.getProductName(),new CaseInsensitiveComparer().reversed())).toList();
        return sortedProducts;
    }
}
