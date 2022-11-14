using System;
using System.Collections.Generic;
using System.Linq;
using Parallel.Linq101.DataSources;

namespace Parallel.Linq101;

public class ElementOperations {
    public List<Product> GetProductList() => Products.ProductList;
    public List<Customer> GetCustomerList() => Customers.CustomerList;

    public int FirstElement() {
        List<Product> products = GetProductList();
        Product product12 = products.First(p => p.ProductId == 12);
        Console.WriteLine(product12);
        return 0;
    }

    public int FirstMatchingElement() {
        string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        string startsWithO = strings.First(s => s[0] == 'o');
        Console.WriteLine($"A string starting with 'o': {startsWithO}");
        return 0;
    }

    public int MaybeFirstElement() {
        int[] numbers = { };
        int firstNumOrDefault = numbers.FirstOrDefault(0);
        Console.WriteLine(firstNumOrDefault);
        return 0;
    }

    public int MaybeFirstMatchingElement() {
        List<Product> products = GetProductList();
        Product product789 = products.FirstOrDefault(p => p.ProductId == 789, null);
        Console.WriteLine($"Product 789 exists: {product789 != null}");
        return 0;
    }

    public int ElementAtPosition() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int fourthLowNum = numbers.Where(n => n > 5)
            .ElementAt(1); // second number is index 1 because sequences use 0-based indexing
        Console.WriteLine($"Second number > 5: {fourthLowNum}");
        return 0;
    }
}