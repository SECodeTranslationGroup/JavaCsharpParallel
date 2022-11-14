using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Parallel.Linq101.DataSources;

namespace Parallel.Linq101;

public class Projections
{
    public List<Product> GetProductList() => Products.ProductList;
    public List<Customer> GetCustomerList() => Customers.CustomerList;

    public int SelectSyntax()
    {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

        var numsPlusOne = numbers.Select(n => n + 1).ToArray();

        Console.WriteLine("Numbers + 1:");
        foreach (var i in numsPlusOne)
            Console.WriteLine(i);
        return 0;
    }

    public int SelectProperty()
    {
        List<Product> products = GetProductList();

        var productNames = products.Select(p => p.ProductName).ToList();

        Console.WriteLine("Product Names:");
        foreach (var productName in productNames)
            Console.WriteLine(productName);
        return 0;
    }

    public int TransformWithSelect()
    {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        var textNums = numbers.Select(n => strings[n]).ToArray();

        Console.WriteLine("Number strings:");
        foreach (var s in textNums)
            Console.WriteLine(s);
        return 0;
    }

    public int SelectByCaseAnonymous()
    {
        string[] words = { "aPPLE", "BlUeBeRrY", "cHeRry" };

        var upperLowerWords = words.Select(w =>
            new { Upper = w.ToUpper(), Lower = w.ToLower() }).ToArray();

        foreach (var ul in upperLowerWords)
            Console.WriteLine($"Uppercase: {ul.Upper}, Lowercase: {ul.Lower}");
        return 0;
    }

    public int SelectByCaseTuple()
    {
        string[] words = { "aPPLE", "BlUeBeRrY", "cHeRry" };

        var upperLowerWords = words.Select(w =>
            Tuple.Create(w.ToUpper(), w.ToLower())).ToArray();

        foreach (var ul in upperLowerWords)
            Console.WriteLine($"Uppercase: {ul.Item1}, Lowercase: {ul.Item2}");

        return 0;
    }

    public int SelectAnonymousConstructions()
    {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        var digitOddEvens = numbers.Select(n =>
            new { Digit = strings[n], Even = (n % 2 == 0) }).ToArray();

        foreach (var d in digitOddEvens)
            Console.WriteLine($"The digit {d.Digit} is {(d.Even ? "even" : "odd")}.");

        return 0;
    }

    public int SelectTupleConstructions()
    {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        var digitOddEvens = numbers.Select(n =>
            Tuple.Create(strings[n], n % 2 == 0)).ToArray();

        foreach (var d in digitOddEvens)
            Console.WriteLine($"The digit {d.Item1} is {(d.Item2 ? "even" : "odd")}.");

        return 0;
    }

    public int SelectPropertySubset()
    {
        List<Product> products = GetProductList();

        var productInfos = products.Select(p =>
            Tuple.Create(p.ProductName, p.Category, p.UnitPrice)).ToList();

        Console.WriteLine("Product Info:");
        foreach (var productInfo in productInfos)
            Console.WriteLine(
                $"{productInfo.Item1} is in the category {productInfo.Item2} and costs {productInfo.Item3} per unit.");

        return 0;
    }

    public int SelectWithIndex()
    {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

        var numsInPlace = numbers.Select((num, index) =>
            Tuple.Create(num, num == index)).ToArray();

        Console.WriteLine("Number: In-place?");
        foreach (var n in numsInPlace)
            Console.WriteLine($"{n.Item1}: {n.Item2}");
        return 0;
    }

    public int SelectWithWhere()
    {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        string[] digits = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        var lowNums = numbers.Where(n => n < 5).Select(n => digits[n]).ToArray();

        Console.WriteLine("Numbers < 5:");
        foreach (var num in lowNums)
            Console.WriteLine(num);
        return 0;
    }

    public int SelectFromMultipleSequences()
    {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8 };

        var pairs = numbersA.SelectMany(a => numbersB.Where(b => a < b),
                (a, b) => Tuple.Create(a, b))
            .ToArray();

        Console.WriteLine("Pairs where a < b:");
        foreach (var pair in pairs)
            Console.WriteLine($"{pair.Item1} is less than {pair.Item2}");
        return 0;
    }

    public int SelectFromChildSequence()
    {
        List<Customer> customers = GetCustomerList();

        var orders = customers.SelectMany(c => c.Orders.Where(o => o.Total < 500.00),
            (c, o) => Tuple.Create(c.CustomerId, o.OrderId, o.Total)).ToList();

        foreach (var order in orders)
            Console.WriteLine($"Customer: {order.Item1}, Order: {order.Item2}, Total value: {order.Item3}");
        return 0;
    }

    public int SelectManyWithWhere()
    {
        List<Customer> customers = GetCustomerList();

        var orders = customers.SelectMany(c => c.Orders.Where(o => o.OrderDate > new DateTime(1998, 1, 1)),
            (c, o) => Tuple.Create(c.CustomerId, o.OrderDate, o.OrderDate)).ToList();

        foreach (var order in orders)
            Console.WriteLine(
                $"Customer: {order.Item1}, Order: {order.Item2}, Total date: {order.Item3.ToShortDateString()}");

        return 0;
    }

    public int SelectManyWhereAssignment()
    {
        List<Customer> customers = GetCustomerList();

        var orders = customers.SelectMany(c => c.Orders.Where(o => o.Total >= 2000.0),
            (c, o) => Tuple.Create(c.CustomerId, o.OrderDate, o.Total)).ToList();

        foreach (var order in orders)
            Console.WriteLine($"Customer: {order.Item1}, Order: {order.Item2}, Total value: {order.Item3}");
        return 0;
    }

    public int SelectMultipleWhereClauses()
    {
        List<Customer> customers = GetCustomerList();

        DateTime cutoffDate = new DateTime(1997, 1, 1);

        var orders = customers.Where(c => c.Region == "WA").SelectMany(
            c => c.Orders.Where(o => o.OrderDate > cutoffDate),
            (c, o) => Tuple.Create(c.CustomerId, o.OrderId)).ToList();

        foreach (var order in orders)
            Console.WriteLine($"Customer: {order.Item1}, Order: {order.Item2}");

        return 0;
    }

    public int IndexedSelectMany()
    {
        List<Customer> customers = GetCustomerList();

        var customerOrders =
            customers.SelectMany(
                (c, index) =>
                    c.Orders.Select(o => "Customer #" + (index + 1) +
                                            " has an order with OrderID " + o.OrderId)).ToList();

        foreach (var order in customerOrders)
            Console.WriteLine(order);

        return 0;
    }
}