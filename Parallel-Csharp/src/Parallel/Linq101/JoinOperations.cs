using System;
using System.Collections.Generic;
using System.Linq;
using Parallel.Linq101.DataSources;

namespace Parallel.Linq101;

public class JoinOperations
{
    public List<Product> GetProductList() => Products.ProductList;
    public List<Customer> GetCustomerList() => Customers.CustomerList;

    public int CrossJoinQuery()
    {
        string[] categories =
        {
            "Beverages",
            "Condiments",
            "Vegetables",
            "Dairy Products",
            "Seafood"
        };

        List<Product> products = GetProductList();

        var q = categories.Join(products, c => c, p => p.Category,
            (c, p) => Tuple.Create(c, p.ProductName)).ToList();

        foreach (var v in q)
            Console.WriteLine(v.Item1 + ": " + v.Item2);
        return 0;
    }

    public int GroupJoinQuery()
    {
        string[] categories =
        {
            "Beverages",
            "Condiments",
            "Vegetables",
            "Dairy Products",
            "Seafood"
        };

        List<Product> products = GetProductList();
        
        var q = categories.GroupJoin(products, c => c, p => p.Category,
            (c, p) => Tuple.Create(c, p.ToList()))
            .ToDictionary(t=>t.Item1,t=>t.Item2);

        foreach (var v in q)
        {
            Console.WriteLine(v.Key + ":");
            foreach (var p in v.Value)
                Console.WriteLine("   " + p.ProductName);
        }
        return 0;
    }

    public int CrossGroupJoin()
    {

        string[] categories =
        {
            "Beverages",
            "Condiments",
            "Vegetables",
            "Dairy Products",
            "Seafood"
        };

        List<Product> products = GetProductList();
        
        var q = categories.GroupJoin(products, c => c, p => p.Category,
            (c, p) => Tuple.Create(c, p)).SelectMany(t=>t.Item2,
            (t,p)=>Tuple.Create(t.Item1,p.ProductName)).ToList();
        
        foreach (var v in q)
            Console.WriteLine(v.Item2 + ": " + v.Item1);

        return 0;
    }

    public int LeftOuterJoin()
    {
        string[] categories =
        {
            "Beverages",
            "Condiments",
            "Vegetables",
            "Dairy Products",
            "Seafood"
        };

        List<Product> products = GetProductList();
        
        var q = categories.GroupJoin(products, c => c, p => p.Category,
            (c, p) => Tuple.Create(c, p)).SelectMany(t=>t.Item2.DefaultIfEmpty(null),
            (t,p)=>Tuple.Create(t.Item1,p == null ? "(No products)" : p.ProductName)).ToList();

        foreach (var v in q)
            Console.WriteLine($"{v.Item2}: {v.Item1}");

        return 0;
    }
}