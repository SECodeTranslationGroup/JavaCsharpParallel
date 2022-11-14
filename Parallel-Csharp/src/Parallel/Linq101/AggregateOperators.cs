using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using Parallel.Linq101.DataSources;

namespace Parallel.Linq101;

public class AggregateOperators {
    public List<Product> GetProductList() => Products.ProductList;
    public List<Customer> GetCustomerList() => Customers.CustomerList;

    public int CountSyntax() {
        int[] factorsOf300 = { 2, 2, 3, 5, 5 };
        int uniqueFactors = factorsOf300.Distinct().Count();
        Console.WriteLine($"There are {uniqueFactors} unique factors of 300.");
        return 0;
    }

    public int CountConditional() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int oddNumbers = numbers.Count(n => n % 2 == 1);
        Console.WriteLine($"There are {oddNumbers} odd numbers in the list.");
        return 0;
    }

    public int NestedCount() {
        List<Customer> customers = GetCustomerList();
        var orderCounts = customers
            .Select(c => Tuple.Create(c.CustomerId, c.Orders.Length)).ToList();
        foreach (var customer in orderCounts)
            Console.WriteLine($"ID: {customer.Item1}, count: {customer.Item2}");
        return 0;
    }

    public int GroupedCount() {
        List<Product> products = GetProductList();
        var categoryCounts = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key, g.Count())).ToList();
        foreach (var c in categoryCounts)
            Console.WriteLine($"Category: {c.Item1}: Product count: {c.Item2}");
        return 0;
    }

    public int SumSyntax() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int numSum = numbers.Sum();
        Console.WriteLine($"The sum of the numbers is {numSum}");
        return 0;
    }

    public int SumProjection() {
        string[] words = { "cherry", "apple", "blueberry" };
        int totalChars = words.Sum(w => w.Length);
        Console.WriteLine($"There are a total of {totalChars} characters in these words.");
        return 0;
    }

    public int SumGrouped() {
        List<Product> products = GetProductList();
        var categories = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key, g.Sum(p => p.UnitsInStock)))
            .ToList();
        foreach (var pair in categories)
            Console.WriteLine($"Category: {pair.Item1}, Units in stock: {pair.Item2}");
        return 0;
    }

    public int MinSyntax() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int minNum = numbers.Min();
        Console.WriteLine($"The minimum number is {minNum}");
        return 0;
    }

    public int MinProjection() {
        string[] words = { "cherry", "apple", "blueberry" };
        int shortestWord = words.Min(w => w.Length);
        Console.WriteLine($"The shortest word is {shortestWord} characters long.");
        return 0;
    }

    public int MinGrouped() {
        List<Product> products = GetProductList();
        var categories = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key, g.Min(p => p.UnitPrice)))
            .ToList();
        foreach (var c in categories)
            Console.WriteLine($"Category: {c.Item1}, Lowest price: {c.Item2}");
        return 0;
    }

    public int MinEachGroup() {
        List<Product> products = GetProductList();
        var categories = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key,
                g.Where(p => p.UnitPrice == g.Min(p => p.UnitPrice))
                    .ToList())).ToList();
        foreach (var c in categories) {
            Console.WriteLine($"Category: {c.Item1}");
            foreach (var p in c.Item2)
                Console.WriteLine($"\tProduct: {p}");
        }

        return 0;
    }

    public int MaxSyntax() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int maxNum = numbers.Max();
        Console.WriteLine($"The maximum number is {maxNum}");
        return 0;
    }

    public int MaxProjection() {
        string[] words = { "cherry", "apple", "blueberry" };
        int longestLength = words.Max(w => w.Length);
        Console.WriteLine($"The longest word is {longestLength} characters long.");
        return 0;
    }

    public int MaxGrouped() {
        List<Product> products = GetProductList();
        var categories = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key,
                g.Max(p => p.UnitPrice))).ToList();
        foreach (var c in categories)
            Console.WriteLine($"Category: {c.Item1} Most expensive product: {c.Item2}");
        return 0;
    }

    public int MaxEachGroup() {
        List<Product> products = GetProductList();
        var categories = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key,
                g.Where(p => p.UnitPrice == g.Max(p => p.UnitPrice))
                    .ToList())).ToList();
        foreach (var c in categories) {
            Console.WriteLine($"Category: {c.Item1}");
            foreach (var p in c.Item2)
                Console.WriteLine($"\t{p}");
        }

        return 0;
    }

    public int AverageSyntax() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        double averageNum = numbers.Average();
        Console.WriteLine($"The average number is {averageNum}.");
        return 0;
    }

    public int AverageProjection() {
        string[] words = { "cherry", "apple", "blueberry" };
        double averageLength = words.Average(w => w.Length);
        Console.WriteLine($"The average word length is {averageLength} characters.");
        return 0;
    }

    public int AverageGrouped() {
        List<Product> products = GetProductList();
        var categories = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key,
                g.Average(p => p.UnitPrice))).ToList();
        foreach (var c in categories)
            Console.WriteLine($"Category: {c.Item1}, Average price: {c.Item2}");
        return 0;
    }

    public int AggregateSyntax() {
        double[] doubles = { 1.7, 2.3, 1.9, 4.1, 2.9 };
        double product = doubles.Aggregate((runningProduct, nextFactor)
            => runningProduct * nextFactor);
        Console.WriteLine($"Total product of all numbers: {product}");
        return 0;
    }

    public int SeededAggregate() {
        int startBalance = 100;
        int[] attemptedWithdrawals = { 20, 10, 40, 50, 10, 70, 30 };
        int endBalance = attemptedWithdrawals.Aggregate(startBalance, (balance, nextWithdrawal) =>
            ((nextWithdrawal <= balance) ? (balance - nextWithdrawal) : balance));
        Console.WriteLine($"Ending balance: {endBalance}");
        return 0;
    }
}