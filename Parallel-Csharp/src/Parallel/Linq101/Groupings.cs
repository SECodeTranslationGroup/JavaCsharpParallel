using System;
using System.Collections.Generic;
using System.Linq;
using Parallel.Linq101.DataSources;

namespace Parallel.Linq101;

public class Groupings
{
    public List<Product> GetProductList() => Products.ProductList;
    public List<Customer> GetCustomerList() => Customers.CustomerList;


    public int GroupingSyntax()
    {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

        var numberGroups = numbers.GroupBy(n => n % 5)
            .ToDictionary(g=>g.Key,g=>g.AsEnumerable().ToList());

        foreach (var g in numberGroups)
        {
            Console.WriteLine($"Numbers with a remainder of {g.Key} when divided by 5:");
            foreach (var n in g.Value)
                Console.WriteLine(n);
        }
        return 0;
    }

    public int GroupByProperty()
    {

        string[] words = { "blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese" };

        var wordGroups = words.GroupBy(w => w[0])
            .ToDictionary(g=>g.Key,g=>g.AsEnumerable().ToList());

        foreach (var g in wordGroups)
        {
            Console.WriteLine($"Words that start with the letter {g.Key}:");
            foreach (var w in g.Value)
                Console.WriteLine(w);
        }

        return 0;
    }

    public int GroupByCategory()
    {

        List<Product> products = GetProductList();

        var orderGroups = products.GroupBy(p => p.Category)
            .ToDictionary(g=>g.Key,g=>g.AsEnumerable().ToList());
            
        foreach (var orderGroup in orderGroups)
        {
            Console.WriteLine($"Products in {orderGroup.Key} category:");
            foreach (var product in orderGroup.Value)
                Console.WriteLine($"\t{product}");
        }
        return 0;
    }

    public int NestedGroupBy()
    {

        List<Customer> customers = GetCustomerList();

        var customerOrderGroups = customers.Select(
            c => Tuple.Create(c.CompanyName, 
                c.Orders.GroupBy(o => o.OrderDate.Year).ToDictionary(
                    yg=>yg.Key,
                    yg=>yg.GroupBy(o => o.OrderDate.Month).ToDictionary(
                        mg=>mg.Key,
                        mg=>mg.AsEnumerable().ToList()
                        )
                    )
                )
        ).ToList();

        foreach (var ordersByCustomer in customerOrderGroups)
        {
            Console.WriteLine($"Customer Name: {ordersByCustomer.Item1}");
            foreach (var ordersByYear in ordersByCustomer.Item2)
            {
                Console.WriteLine($"\tYear: {ordersByYear.Key}");
                foreach (var ordersByMonth in ordersByYear.Value)
                {
                    Console.WriteLine($"\t\tMonth: {ordersByMonth.Key}");
                    foreach (var order in ordersByMonth.Value)
                        Console.WriteLine($"\t\t\tOrder: {order}");
                }
            }
        }


        return 0;
    }

    public int GroupByCustomComparer()
    {

        string[] anagrams = { "from   ", " salt", " earn ", "  last   ", " near ", " form  " };

        var orderGroups = anagrams.GroupBy(w => new AnagramEqualityComparer().getCanonicalString(w.Trim()))
           .ToDictionary(g=>g.Key,g=>g.AsEnumerable().ToList());

        foreach (var set in orderGroups)
        {
            // The key would be the first item in the set
            foreach (var word in set.Value)
                Console.WriteLine(word);

            Console.WriteLine("...");
        }

        return 0;
    }

    public int NestedGroupByCustom()
    {

        string[] anagrams = { "from   ", " salt", " earn ", "  last   ", " near ", " form  " };

        var orderGroups = anagrams.GroupBy(
            w => new AnagramEqualityComparer().getCanonicalString(w.Trim()),
            w => w.ToUpper()
        ).ToDictionary(g=>g.Key,g=>g.AsEnumerable().ToList());
        foreach (var set in orderGroups)
        {
            Console.WriteLine(set.Key);
            foreach (var word in set.Value)
                Console.WriteLine($"\t{word}");
        }

        return 0;
    }
}

public class AnagramEqualityComparer : IEqualityComparer<string>
{
    public bool Equals(string x, string y) => getCanonicalString(x) == getCanonicalString(y);

    public int GetHashCode(string obj) => getCanonicalString(obj).GetHashCode();

    public string getCanonicalString(string word)
    {
        char[] wordChars = word.ToCharArray();
        Array.Sort<char>(wordChars);
        return new string(wordChars);
    }
}