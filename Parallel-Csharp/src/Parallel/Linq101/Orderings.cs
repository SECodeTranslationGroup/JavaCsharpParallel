using System;
using System.Linq;
using System.Collections.Generic;
using Parallel.Linq101.DataSources;

namespace Parallel.Linq101;

public class Orderings
{
    public List<Product> GetProductList() => Products.ProductList;

    public List<Customer> GetCustomerList() => Customers.CustomerList;

    public int OrderbySyntax()
    {
        string[] words = { "cherry", "apple", "blueberry" };

        var sortedWords = words.OrderBy(w => w).ToArray();

        Console.WriteLine("The sorted list of words:");
        foreach (var w in sortedWords)

            Console.WriteLine(w);
        return 0;
    }

    public int OrderbyProperty()
    {
        string[] words = { "cherry", "apple", "blueberry" };

        var sortedWords = words.OrderBy(w => w.Length).ToArray();

        Console.WriteLine("The sorted list of words (by length):");
        foreach (var w in sortedWords)
            Console.WriteLine(w);

        return 0;
    }

    public int OrderByProducts()
    {
        List<Product> products = GetProductList();
        var sortedProducts = products.OrderBy(p => p.ProductName).ToList();
        foreach (var product in sortedProducts)
            Console.WriteLine(product);
        return 0;
    }

    public class CaseInsensitiveComparer : IComparer<string>
    {
        public int Compare(string x, string y) =>
            string.Compare(x, y, StringComparison.OrdinalIgnoreCase);
    }

    public int OrderByWithCustomComparer()
    {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };

        var sortedWords = words.OrderBy(a => a, new CaseInsensitiveComparer()).ToArray();

        foreach (var word in sortedWords)
            Console.WriteLine(word);

        return 0;
    }

    public int OrderByDescendingSyntax()
    {
        double[] doubles = { 1.7, 2.3, 1.9, 4.1, 2.9 };

        var sortedDoubles = doubles.OrderByDescending(d => d).ToArray();

        Console.WriteLine("The doubles from highest to lowest:");

        foreach (var d in sortedDoubles)
            Console.WriteLine(d);

        return 0;
    }

    public int OrderProductsDescending()
    {
        List<Product> products = GetProductList();

        var sortedProducts = products.OrderByDescending(p => p.UnitsInStock).ToArray();

        foreach (var product in sortedProducts)
            Console.WriteLine(product);

        return 0;
    }

    public int DescendingCustomComparer()
    {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };

        var sortedWords = words.OrderByDescending(a => a, new CaseInsensitiveComparer()).ToArray();

        foreach (var word in sortedWords)
            Console.WriteLine(word);

        return 0;
    }

    public int ThenBySyntax()
    {
        string[] digits = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        var sortedDigits = digits.OrderBy(d => d.Length).ThenBy(d => d).ToArray();

        Console.WriteLine("Sorted digits:");
        foreach (var d in sortedDigits)
            Console.WriteLine(d);

        return 0;
    }

    public int ThenByCustom()
    {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };

        var sortedWords = words
            .OrderBy(a => a.Length).ThenBy(a => a, new CaseInsensitiveComparer()).ToArray();

        foreach (var word in sortedWords)
            Console.WriteLine(word);

        return 0;
    }

    public int ThenByDifferentOrdering()
    {
        List<Product> products = GetProductList();

        var sortedProducts = products.OrderBy(p => p.Category).ThenByDescending(p => p.UnitPrice).ToList();

        foreach (var product in sortedProducts)
            Console.WriteLine(product);

        return 0;
    }

    public int CustomThenByDescending()
    {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };

        var sortedWords = words.OrderBy(a => a.Length)
            .ThenByDescending(a => a, new CaseInsensitiveComparer()).ToArray();

        foreach (var word in sortedWords)
            Console.WriteLine(word);

        return 0;
    }

    public int OrderingReversal()
    {
        string[] digits = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        var reversedIDigits = digits.Where(d => d[1] == 'i').Reverse().ToArray();

        Console.WriteLine("A backwards list of the digits with a second character of 'i':");
        foreach (var d in reversedIDigits)
            Console.WriteLine(d);

        return 0;
    }
}