using System;
using System.Collections.Generic;
using System.Linq;
using Parallel.Linq101.DataSources;

namespace Parallel.Linq101;

public class Restrictions
{
    public List<Product> GetProductList() => Products.ProductList;

    public List<Customer> GetCustomerList() => Customers.CustomerList;

    public int LowNumbers()
    {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

        var lowNums = numbers.Where(n => n < 5).ToArray();
        Console.WriteLine("Numbers < 5:");
        foreach (var x in lowNums)
            Console.WriteLine(x);
        return 0;
    }

    public int ProductsOutOfStock()
    {
        List<Product> products = GetProductList();

        var soldOutProducts = products.Where(p => p.UnitsInStock == 0).ToList();

        Console.WriteLine("Sold out products:");
        foreach (var product in soldOutProducts)
            Console.WriteLine($"{product.ProductName} is sold out!");

        return 0;
    }

    public int ExpensiveProductsInStock()
    {
        List<Product> products = GetProductList();

        var expensiveInStockProducts = products.Where(p => p.UnitsInStock > 0
                                                           && p.UnitPrice > 3.00).ToList();

        Console.WriteLine("In-stock products that cost more than 3.00:");
        foreach (var product in expensiveInStockProducts)
            Console.WriteLine($"{product.ProductName} is in stock and costs more than 3.00.");
        return 0;
    }

    public int DisplayCustomerOrders()
    {
        List<Customer> customers = GetCustomerList();

        var waCustomers = customers.Where(c => c.Region == "WA").ToList();

        Console.WriteLine("Customers from Washington and their orders:");
        foreach (var customer in waCustomers)
        {
            Console.WriteLine($"Customer {customer.CustomerId}: {customer.CompanyName}");
            foreach (var order in customer.Orders)
                Console.WriteLine($"  Order {order.OrderId}: {order.OrderDate}");
        }

        return 0;
    }

    public int IndexedWhere()
    {
        string[] digits = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        var shortDigits = digits.Where((digit, index) => digit.Length < index);

        Console.WriteLine("Short digits:");
        foreach (var d in shortDigits)
            Console.WriteLine($"The word {d} is shorter than its value.");

        return 0;
    }
}