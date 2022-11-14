package parallel.linq101;

import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SequenceOperations {
    public List<Product> getProductList() {
        return Data.getProductList();
    }
    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }
    public int equalSequence() {
        var wordsA = new String[]{"cherry", "apple", "blueberry"};
        var wordsB = new String[]{"cherry", "apple", "blueberry"};
        boolean match = Arrays.equals(wordsA, wordsB);
        System.out.println("The sequences match: "+match);
        return 0;
    }

    public int unequalSequence() {
        var wordsA = new String[]{"cherry", "apple", "blueberry"};
        var wordsB = new String[]{"apple", "blueberry", "cherry"};
        boolean match = Arrays.equals(wordsA,wordsB);
        System.out.println("The sequences match: "+match);
        return 0;
    }

    public int concatSeries() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8};
        var allNumbers = Stream.concat(Arrays.stream(numbersA).boxed(),
                Arrays.stream(numbersB).boxed()).toArray();
        System.out.println("All numbers from both arrays:");
        for(var n : allNumbers)
            System.out.println(n);
        return 0;
    }

    public int concatProjection() {
        List<Customer> customers = getCustomerList();
        List<Product> products = getProductList();
        var allNames = Stream.concat(customers.stream().map(c->c.getCompanyName()),
                products.stream().map(p->p.getProductName())).collect(Collectors.toList());
        System.out.println("Customer and product names:");
        for(var n : allNames)
            System.out.println(n);
        return 0;
    }

    public int dotProduct() {
        int[] vectorA = {0, 2, 4, 5, 6};
        int[] vectorB = {1, 3, 5, 7, 8};
        int dotProduct = IntStream.range(0,vectorA.length).map(index->
                vectorA[index]*vectorB[index]).sum();
        System.out.println("Dot product: "+dotProduct);
        return 0;
    }
}
