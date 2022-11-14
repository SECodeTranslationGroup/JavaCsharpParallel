package parallel.linq101;

import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Restrictions {
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public int lowNumbers() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        var lowNums = Arrays.stream(numbers).filter(n -> n < 5).toArray();
        System.out.println("Numbers < 5:");
        for (var x : lowNums)
            System.out.println(x);
        return 0;
    }

    public int productsOutOfStock() {
        List<Product> products = getProductList();
        var soldOutProducts = products.stream().filter(p -> p.getUnitsInStock() == 0)
                .collect(Collectors.toList());
        System.out.println("Sold out products:");
        for (var product : soldOutProducts)
            System.out.println(product.getProductName() + " is sold out!");
        return 0;
    }

    public int expensiveProductsInStock() {
        List<Product> products = getProductList();
        var expensiveInStockProducts = products.stream().filter(
                p -> p.getUnitsInStock() > 0 && p.getUnitPrice() > 3.00).collect(Collectors.toList());
        System.out.println("In-stock products that cost more than 3.00:");
        for (var product : expensiveInStockProducts)
            System.out.println(product.getProductName() + " is in stock and costs more than 3.00.");
        return 0;
    }

    public int displayCustomerOrders() {
        List<Customer> customers = getCustomerList();
        var waCustomers = customers.stream().filter(c -> c.getRegion() == "WA").collect(Collectors.toList());
        System.out.println("Customers from Washington and their orders:");
        for (var customer : waCustomers) {
            System.out.println("Customer " + customer.getCustomerId() + ": " + customer.getCompanyName());
            for (var order : customer.getOrders())
                System.out.println("  Order " + order.getOrderId() + ": " + order.getOrderDate());
        }
        return 0;
    }

    public int indexedWhere() {
        String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        var shortDigits = IntStream.range(0, digits.length).filter(
                index -> digits[index].length() < index).mapToObj(index -> digits[index]).toArray();
        System.out.println("Short digits:");
        for (var d : shortDigits)
            System.out.println("The word " + d + " is shorter than its value.");
        return 0;
    }
}
