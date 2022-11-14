using System;
using System.Collections.Generic;
using System.Linq;
using Parallel.Linq101.DataSources;

namespace Parallel.Linq101;

public class SequenceOperations
{
    public List<Product> GetProductList() => Products.ProductList;
    public List<Customer> GetCustomerList() => Customers.CustomerList;

    public int EqualSequence()
    {
        var wordsA = new string[] { "cherry", "apple", "blueberry" };
        var wordsB = new string[] { "cherry", "apple", "blueberry" };

        bool match = wordsA.SequenceEqual(wordsB);

        Console.WriteLine($"The sequences match: {match}");
        return 0;
    }

    public int UnequalSequence()
    {
        var wordsA = new string[] { "cherry", "apple", "blueberry" };
        var wordsB = new string[] { "apple", "blueberry", "cherry" };

        bool match = wordsA.SequenceEqual(wordsB);

        Console.WriteLine($"The sequences match: {match}");
        return 0;
    }

    public int ConcatSeries()
    {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8 };

        var allNumbers = numbersA.Concat(numbersB).ToArray();

        Console.WriteLine("All numbers from both arrays:");
        foreach (var n in allNumbers)
            Console.WriteLine(n);

        return 0;
    }

    public int ConcatProjection()
    {
        List<Customer> customers = GetCustomerList();
        List<Product> products = GetProductList();
        
        var allNames = customers.Select(c => c.CompanyName).
            Concat(products.Select(p => p.ProductName)).ToList();

        Console.WriteLine("Customer and product names:");
        foreach (var n in allNames)
            Console.WriteLine(n);

        return 0;
    }

    public int DotProduct()
    {
        int[] vectorA = { 0, 2, 4, 5, 6 };
        int[] vectorB = { 1, 3, 5, 7, 8 };

        int dotProduct = vectorA.Zip(vectorB, (a, b) => a * b).Sum();

        Console.WriteLine($"Dot product: {dotProduct}");
        return 0;
    }
}