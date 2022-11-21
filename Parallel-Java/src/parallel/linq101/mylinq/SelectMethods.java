package parallel.linq101.mylinq;

import org.javatuples.Pair;
import org.javatuples.Triplet;
import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Order;
import parallel.linq101.datasource.Product;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class SelectMethods {
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public int[] intPlusOne() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int[] numSelected = Arrays.stream(numbers).map(n -> n + 1).toArray();
        return numSelected;
    }

    public int[] oddIntPlusOne() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int[] numSelected = Arrays.stream(numbers).filter(n -> n % 2 == 1).map(n -> n + 1).toArray();
        return numSelected;
    }

    public int[] bigIntPlusOne() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int[] numSelected = Arrays.stream(numbers).filter(n -> n > 5).map(n -> n + 1).toArray();
        return numSelected;
    }

    public int[] intTwice() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int[] numSelected = Arrays.stream(numbers).map(n -> n * 2).toArray();
        return numSelected;
    }

    public int[] oddIntTwice() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int[] numSelected = Arrays.stream(numbers).filter(n -> n % 2 == 1).map(n -> n * 2).toArray();
        return numSelected;
    }

    public int[] bigIntTwice() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int[] numSelected = Arrays.stream(numbers).filter(n -> n > 5).map(n -> n * 2).toArray();
        return numSelected;
    }


    public Character[] stringFirstChar() {
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Character[] selected = (Character[]) Arrays.stream(strings).map(w -> w.charAt(0)).toArray();
        return selected;
    }

    public Character[] shortStringFirstChar() {
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Character[] selected = (Character[]) Arrays.stream(strings).filter(w -> w.length() < 4)
                .map(w -> w.charAt(0)).toArray();
        return selected;
    }

    public int[] stringLength() {
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int[] selected = Arrays.stream(strings).mapToInt(w -> w.length()).toArray();
        return selected;
    }

    public int[] shortStringLength() {
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int[] selected = Arrays.stream(strings).filter(w -> w.length() < 4).mapToInt(w -> w.length()).toArray();
        return selected;
    }

    public List<String> productName() {
        List<Product> products = getProductList();
        List<String> productNames = products.stream().map(p -> p.getProductName()).toList();
        return productNames;
    }

    public List<Double> productUnitPrice() {
        List<Product> products = getProductList();
        List<Double> productNames = products.stream().map(p -> p.getUnitPrice()).toList();
        return productNames;
    }

    public List<String> expensiveProductName() {
        List<Product> products = getProductList();
        List<String> productNames = products.stream().filter(p -> p.getUnitPrice() > 100).map(p -> p.getProductName()).toList();
        return productNames;
    }

    public List<Double> expensiveProductUnitPrice() {
        List<Product> products = getProductList();
        List<Double> productNames = products.stream().filter(p -> p.getUnitPrice() > 100).map(p -> p.getUnitPrice()).toList();
        return productNames;
    }

    public List<String> outOfStockProductName() {
        List<Product> products = getProductList();
        List<String> productNames = products.stream().filter(p -> p.getUnitsInStock() == 0).map(p -> p.getProductName()).toList();
        return productNames;
    }

    public List<Double> outOfStockProductUnitPrice() {
        List<Product> products = getProductList();
        List<Double> productNames = products.stream().filter(p -> p.getUnitsInStock() == 0).map(p -> p.getUnitPrice()).toList();
        return productNames;
    }


    public List<Pair<String, List<String>>> productGroupName() {
        List<Product> products = getProductList();
        List<Pair<String, List<String>>> productNames = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().map(p -> p.getProductName()).toList())).toList();
        return productNames;
    }

    public Map<String, List<String>> productGroupNameDict() {
        List<Product> products = getProductList();
        Map<String, List<String>> productNames = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().map(p -> p.getProductName()).toList()));
        return productNames;
    }

    public List<Pair<String, List<Double>>> productGroupUnitPrice() {
        List<Product> products = getProductList();
        List<Pair<String, List<Double>>> productNames = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().map(g -> Pair.with(g.getKey(),
                        g.getValue().stream().map(p -> p.getUnitPrice()).toList())).toList();
        return productNames;
    }

    public Map<String, List<Double>> productGroupUnitPriceDict() {
        List<Product> products = getProductList();
        Map<String, List<Double>> productNames = products.stream().collect(groupingBy(p -> p.getCategory()))
                .entrySet().stream().collect(toMap(g -> g.getKey(),
                        g -> g.getValue().stream().map(p -> p.getUnitPrice()).toList()));
        return productNames;
    }

    public int[] transformIndexToInt() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int[] textNums = Arrays.stream(numbers).map(n -> numbers[n]).toArray();
        return textNums;
    }

    public String[] transformIndexToString() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] textNums = (String[]) Arrays.stream(numbers).mapToObj(n -> strings[n]).toArray();
        return textNums;
    }

    public int[] transformIndexHashToInt() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int[] textNums = Arrays.stream(numbers).map(n -> numbers[n * 97 % 10]).toArray();
        return textNums;
    }

    public String[] transformIndexHashToString() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] textNums = (String[]) Arrays.stream(numbers).mapToObj(n -> numbers[n * 97 % 10]).toArray();
        return textNums;
    }

    public Pair<String, String>[] selectByCase() {
        String[] words = {"aPPLE", "BlUeBeRrY", "cHeRry"};
        Pair<String, String>[] upperLowerWords = (Pair<String, String>[]) Arrays.stream(words).map(w ->
                Pair.with(w.toUpperCase(), w.toLowerCase())).toArray();
        return upperLowerWords;
    }

    public String[] selectByCaseConcat() {
        String[] words = {"aPPLE", "BlUeBeRrY", "cHeRry"};
        String[] upperLowerWords = (String[]) Arrays.stream(words).map(w ->
                w.toUpperCase() + w.toLowerCase()).toArray();
        return upperLowerWords;
    }

    public Pair<String, Integer>[] selectByStringAndLength() {
        String[] words = {"aPPLE", "BlUeBeRrY", "cHeRry"};
        Pair<String, Integer>[] upperLowerWords = (Pair<String, Integer>[]) Arrays.stream(words).map(w ->
                Pair.with(w, w.length())).toArray();
        return upperLowerWords;
    }

    public String[] selectByStringAndLengthConcat() {
        String[] words = {"aPPLE", "BlUeBeRrY", "cHeRry"};
        String[] upperLowerWords = (String[]) Arrays.stream(words).map(w ->
                w + w.length()).toArray();
        return upperLowerWords;
    }

    public Pair<String, Boolean>[] selectByEvenOdd() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Pair<String, Boolean>[] evenOddWords = (Pair<String, Boolean>[]) Arrays.stream(numbers).mapToObj(n ->
                Pair.with(strings[n], n % 2 == 0)).toArray();
        return evenOddWords;
    }

    public String[] selectByEvenOddConcat() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] evenOddWords = (String[]) Arrays.stream(numbers).mapToObj(n ->
                strings[n] + (n % 2 == 0 ? " even" : " odd")).toArray();
        return evenOddWords;
    }

    public List<Pair<String, String>> customerIdAndName() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, String>> customerProperties = customers.stream().map(c ->
                Pair.with(c.getCustomerId(), c.getCompanyName())).toList();
        return customerProperties;
    }

    public List<Pair<String, String>> customerRegionAndCountry() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, String>> customerProperties = customers.stream().map(c ->
                Pair.with(c.getRegion(), c.getCountry())).toList();
        return customerProperties;
    }

    public List<Pair<String, String>> customerCityAndAddress() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, String>> customerProperties = customers.stream().map(c ->
                Pair.with(c.getCity(), c.getAddress())).toList();
        return customerProperties;
    }

    public List<Triplet<String, String, String>> customerRegionAndCountryAndCity() {
        List<Customer> customers = getCustomerList();
        List<Triplet<String, String, String>> customerProperties = customers.stream().map(c ->
                Triplet.with(c.getRegion(), c.getCountry(), c.getCity())).toList();
        return customerProperties;
    }

    public List<Triplet<String, String, String>> customerCityAndAddressAndPostal() {
        List<Customer> customers = getCustomerList();
        List<Triplet<String, String, String>> customerProperties = customers.stream().map(c ->
                Triplet.with(c.getCity(), c.getAddress(), c.getPostalCode())).toList();
        return customerProperties;
    }

    public List<Pair<String, List<Order>>> customerIdAndOrders() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, List<Order>>> customerProperties = customers.stream().map(c ->
                Pair.with(c.getCustomerId(), c.getOrders())).toList();
        return customerProperties;
    }

    public List<Pair<String, Integer>> customerIdAndOrdersCount() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Integer>> customerProperties = customers.stream().map(c ->
                Pair.with(c.getCustomerId(), c.getOrders().size())).toList();
        return customerProperties;
    }

    public List<Pair<String, Order>> customerIdAndFirstOrder() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Order>> customerProperties = customers.stream().map(c ->
                Pair.with(c.getCustomerId(), c.getOrders().stream().findFirst().get())).toList();
        return customerProperties;
    }

    public List<Pair<String, Order>> customerIdAndFirstOrDefaultOrder() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Order>> customerProperties = customers.stream().map(c ->
                Pair.with(c.getCustomerId(), c.getOrders().stream().findFirst().orElse(Order.DEFAULT))).toList();
        return customerProperties;
    }

    public List<Pair<String, Double>> customerIdAndBiggestTotal() {
        List<Customer> customers = getCustomerList();
        List<Pair<String, Double>> customerProperties = customers.stream().map(c ->
                Pair.with(c.getCustomerId(),c.getOrders().stream()
                        .mapToDouble(o -> o.getTotal()).max().getAsDouble())).toList();
        return customerProperties;
    }

    public Boolean[] intWithIndex() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        Boolean[] numSelected = (Boolean[]) IntStream.range(0, numbers.length).mapToObj(i -> numbers[i] == i).toArray();
        return numSelected;
    }

    public int[] intAddIndex() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int[] numSelected = IntStream.range(0, numbers.length).map(i -> numbers[i] + i).toArray();
        return numSelected;
    }

    public Boolean[] oddIntWithIndex() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int[] oddNumbers = Arrays.stream(numbers).filter(n -> n % 2 == 1).toArray();
        Boolean[] numSelected = (Boolean[]) IntStream.range(0, oddNumbers.length).mapToObj(i -> oddNumbers[i] == i).toArray();
        return numSelected;
    }

    public int[] oddIntAddIndex() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int[] oddNumbers = Arrays.stream(numbers).filter(n -> n % 2 == 1).toArray();
        int[] numSelected = IntStream.range(0, oddNumbers.length).map(i -> oddNumbers[i] + i).toArray();
        return numSelected;
    }

    public Boolean[] oddIntWithOriginalIndex() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        Boolean[] numSelected = (Boolean[]) IntStream.range(0, numbers.length).filter(i -> numbers[i] % 2 == 1).mapToObj(i ->
                numbers[i] == i).toArray();
        return numSelected;
    }

    public int[] oddIntAddOriginalIndex() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int[] numSelected = IntStream.range(0, numbers.length).filter(i -> numbers[i] % 2 == 1).map(i ->
                numbers[i] + i).toArray();
        return numSelected;
    }

    public Boolean[] bigIntWithIndex() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int[] bigNumbers = Arrays.stream(numbers).filter(n -> n > 5).toArray();
        Boolean[] numSelected = (Boolean[]) IntStream.range(0, bigNumbers.length).mapToObj(i -> bigNumbers[i] == i).toArray();
        return numSelected;
    }

    public int[] bigIntAddIndex() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int[] bigNumbers = Arrays.stream(numbers).filter(n -> n > 5).toArray();
        int[] numSelected = IntStream.range(0, bigNumbers.length).map(i -> bigNumbers[i] + i).toArray();
        return numSelected;
    }

    public Boolean[] bigIntWithOriginalIndex() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        Boolean[] numSelected = (Boolean[]) IntStream.range(0, numbers.length).filter(i -> numbers[i] > 5).filter(i -> numbers[i] % 2 == 1)
                .mapToObj(i -> numbers[i] == i).toArray();
        return numSelected;
    }

    public int[] bigIntAddOriginalIndex() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int[] numSelected = IntStream.range(0, numbers.length).filter(i -> numbers[i] > 5).filter(i -> numbers[i] % 2 == 1).map(i ->
                numbers[i] + i).toArray();
        return numSelected;
    }
}
