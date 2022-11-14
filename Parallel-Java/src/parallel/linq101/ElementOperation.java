package parallel.linq101;

import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Product;

import java.util.Arrays;
import java.util.List;

public class ElementOperation {
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public int firstElement() {
        List<Product> products = getProductList();
        Product product12 = products.stream().filter(p -> p.getProductId() == 12).findFirst().get();
        System.out.println(product12);
        return 0;
    }

    public int firstMatchingElement() {
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String startsWithO = Arrays.stream(strings).filter(s -> s.charAt(0) == 'o').findFirst().get();
        System.out.println("A string starting with 'o': " + startsWithO);
        return 0;
    }

    public int maybeFirstElement() {
        int[] numbers = {};
        int firstNumOrDefault = Arrays.stream(numbers).findFirst().orElse(0);
        System.out.println(firstNumOrDefault);
        return 0;
    }

    public int maybeFirstMatchingElement() {
        List<Product> products = getProductList();
        Product product789 = products.stream().filter(p -> p.getProductId() == 789).findFirst().orElse(null);
        System.out.println("Product 789 exists: " + (product789 != null));
        return 0;
    }

    public int elementAtPosition() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int fourthLowNum = Arrays.stream(numbers).boxed().filter(n -> n > 5).skip(1).findFirst().get();
        System.out.println("Second number > 5: " + fourthLowNum);
        return 0;
    }
}
