using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Parallel.Linq101.DataSources;

namespace Parallel.Linq101;

    public class Quantifiers
    {
        public List<Product> GetProductList() => Products.ProductList;
        public List<Customer> GetCustomerList() => Customers.CustomerList;

        public int AnyMatchingElements()
        {
            string[] words = { "believe", "relief", "receipt", "field" };

            bool iAfterE = words.Any(w => w.Contains("ei"));

            Console.WriteLine($"There is a word that contains in the list that contains 'ei': {iAfterE}");
            return 0;
        }

        public int GroupedAnyMatchedElements()
        {
            List<Product> products = GetProductList();
            var productGroups = products.GroupBy(p => p.Category).
                Where(g => g.Any(p => p.UnitsInStock == 0))
                .ToDictionary(g => g.Key, g => g.AsEnumerable().ToList());

            foreach(var group in productGroups)
            {
                Console.WriteLine(group.Key);
                foreach(var product in group.Value)
                    Console.WriteLine($"\t{product}");
            }
            return 0;
        }

        public int AllMatchedElements()
        {
            int[] numbers = { 1, 11, 3, 19, 41, 65, 19 };

            bool onlyOdd = numbers.All(n => n % 2 == 1);

            Console.WriteLine($"The list contains only odd numbers: {onlyOdd}");
            return 0;
        }

        public int GroupedAllMatchedElements()
        {
            List<Product> products = GetProductList();
          
            var productGroups = products.GroupBy(p => p.Category).
                Where(g => g.All(p => p.UnitsInStock > 0))
                .ToDictionary(g => g.Key, g => g.AsEnumerable().ToList());
            
            foreach (var group in productGroups)
            {
                Console.WriteLine(group.Key);
                foreach (var product in group.Value)
                    Console.WriteLine($"\t{product}");
            }
            return 0;
        }
    }
