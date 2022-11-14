using System;
using System.Collections.Generic;
using System.Linq;
using Parallel.Linq101.DataSources;

namespace Parallel.Linq101;

public class SetOperations
{
    public List<Product> GetProductList() => Products.ProductList;
    public List<Customer> GetCustomerList() => Customers.CustomerList;

    public int DistinctSyntax()
    {
        int[] factorsOf300 = { 2, 2, 3, 5, 5 };

        var uniqueFactors = factorsOf300.Distinct().ToArray();

        Console.WriteLine("Prime factors of 300:");
        foreach (var f in uniqueFactors)
            Console.WriteLine(f);

        return 0;
    }

    public int DistinctPropertyValues()
    {
        List<Product> products = GetProductList();

        var categoryNames = products.Select(p => p.Category)
            .Distinct().ToList();

        Console.WriteLine("Category names:");
        foreach (var n in categoryNames)
            Console.WriteLine(n);
        return 0;
    }

    public int UnionSyntax()
    {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8 };

        var uniqueNumbers = numbersA.Union(numbersB).ToArray();

        Console.WriteLine("Unique numbers from both arrays:");
        foreach (var n in uniqueNumbers)
            Console.WriteLine(n);

        return 0;
    }

    public int UnionOfQueryResults()
    {
        List<Product> products = GetProductList();
        List<Customer> customers = GetCustomerList();

        var productFirstChars = products.Select(p => p.ProductName[0]);
        var customerFirstChars = customers.Select(c => c.CompanyName[0]);
        var uniqueFirstChars = productFirstChars.Union(customerFirstChars).ToList();

        Console.WriteLine("Unique first letters from Product names and Customer names:");
        foreach (var ch in uniqueFirstChars)
            Console.WriteLine(ch);

        return 0;
    }

    public int IntersectSynxtax()
    {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8 };

        var commonNumbers = numbersA.Intersect(numbersB).ToArray();

        Console.WriteLine("Common numbers shared by both arrays:");
        foreach (var n in commonNumbers)
            Console.WriteLine(n);
        return 0;
    }

    public int IntersectQueryResults()
    {
        List<Product> products = GetProductList();
        List<Customer> customers = GetCustomerList();

        var productFirstChars = products.Select(p => p.ProductName[0]);
        var customerFirstChars = customers.Select(c => c.CompanyName[0]);
        var commonFirstChars = productFirstChars.Intersect(customerFirstChars).ToList();

        Console.WriteLine("Common first letters from Product names and Customer names:");
        foreach (var ch in commonFirstChars)
            Console.WriteLine(ch);
        return 0;
    }

    public int DifferenceOfSets()
    {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8 };

        var aOnlyNumbers = numbersA.Except(numbersB).ToArray();

        Console.WriteLine("Numbers in first array but not second array:");
        foreach (var n in aOnlyNumbers)
            Console.WriteLine(n);

        return 0;
    }

    public int DifferenceOfQueries()
    {

        List<Product> products = GetProductList();
        List<Customer> customers = GetCustomerList();
        
        var productFirstChars = products.Select(p => p.ProductName[0]);
        var customerFirstChars = customers.Select(c => c.CompanyName[0]);
        var productOnlyFirstChars = productFirstChars.Except(customerFirstChars).ToList();

        Console.WriteLine("First letters from Product names, but not from Customer names:");
        foreach (var ch in productOnlyFirstChars)
            Console.WriteLine(ch);

        return 0;
    }
}