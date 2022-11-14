package parallel.linq101;

import org.javatuples.Pair;
import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Product;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.List;
import java.util.stream.Collectors;

public class AggregateOperators {
    public List<Product> getProductList() {
        return Data.getProductList();
    }
    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public int countSyntax()
    {
        int[] factorsOf300 = { 2, 2, 3, 5, 5 };

        int uniqueFactors = (int) Arrays.stream(factorsOf300).distinct().count();

        System.out.println("There are "+uniqueFactors+" unique factors of 300.");

        return 0;
    }

    public int countConditional()
    {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

        int oddNumbers = (int) Arrays.stream(numbers).filter(n -> n % 2 == 1).count();

        System.out.println("There are "+oddNumbers+" odd numbers in the list.");

        return 0;
    }

    public int nestedCount()
    {
        List<Customer> customers = getCustomerList();

        var orderCounts = customers.stream().map(c ->
                Pair.with(c.getCustomerId(), c.getOrders().size())).collect(Collectors.toList());

        for (var customer : orderCounts)
            System.out.println("ID: "+customer.getValue0()+", count: "+customer.getValue1());

        return 0;
    }
}
