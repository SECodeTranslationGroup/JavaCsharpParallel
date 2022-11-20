package parallel.linq101.mylinq;

import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class WhereMethods {
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public List<Integer> intIndexedWhere() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> q = IntStream.range(0, numbers.length).filter(i -> numbers[i] < i).map(i -> numbers[i]).boxed().toList();
        return q;
    }

    public List<Integer> oddIntIndexedWhere() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int[] oddNumbers = Arrays.stream(numbers).filter(i -> i % 2 == 1).toArray();
        List<Integer> q = IntStream.range(0, oddNumbers.length).filter(i -> oddNumbers[i] < i)
                .map(i -> oddNumbers[i]).boxed().toList();
        return q;
    }

    public List<Integer> oddIntOriginalIndexedWhere() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> q = IntStream.range(0, numbers.length).filter(i -> numbers[i] < i && numbers[i] % 2 == 1)
                .map(i -> numbers[i]).boxed().toList();
        return q;
    }

    public List<Integer> intSquareIndexedWhere() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> q = IntStream.range(0, numbers.length).filter(i -> numbers[i] * numbers[i] < i)
                .map(i -> numbers[i] * numbers[i]).boxed().toList();
        return q;
    }

    public List<Integer> intWithSquareIndexedWhere() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> q = IntStream.range(0, numbers.length).filter(i -> numbers[i] < i * i)
                .map(i -> numbers[i]).boxed().toList();
        return q;
    }

    public List<String> stringIndexedWhere() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        IntStream.range(0, words.length).filter(i -> words[i].length() < i).mapToObj(i -> words[i]).toList();
        List<String> q = IntStream.range(0, words.length).filter(i -> words[i].length() < i).mapToObj(i -> words[i]).toList();
        return q;
    }

    public List<String> longStringIndexedWhere() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        String[] longWords = (String[]) Arrays.stream(words).filter(w -> w.length() > 5).toArray();
        List<String> q = IntStream.range(0, longWords.length).filter(i -> longWords[i].length() < i * 3)
                .mapToObj(i -> longWords[i]).toList();
        return q;
    }

    public List<String> longStringOrginalIndexedWhere() {
        String[] words = {"cherry", "apple", "blueberry", "banana", "abacus"};
        List<String> q = IntStream.range(0, words.length).filter(i -> words[i].length() < i * 3 &&
                words[i].length() > 5).mapToObj(i -> words[i]).toList();
        return q;
    }

    public List<Product> productIndexedWhere() {
        List<Product> products = getProductList();
        List<Product> q = IntStream.range(0, products.size()).filter(i -> products.get(i).getUnitsInStock() > 0 &&
                i % 2 == 1).mapToObj(i -> products.get(i)).toList();
        return q;
    }

    public List<Product> expensiveProductIndexedWhere() {
        List<Product> products = getProductList();
        List<Product> q = IntStream.range(0, products.size()).filter(i -> products.get(i).getUnitPrice() > 100 &&
                i % 2 == 1).mapToObj(i -> products.get(i)).toList();
        return q;
    }
}
