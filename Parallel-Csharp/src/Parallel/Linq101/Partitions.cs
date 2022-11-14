using System;
using System.Collections.Generic;
using System.Linq;
using Parallel.Linq101.DataSources;

namespace Parallel.Linq101;

    public class Partitions
    {
        public List<Product> GetProductList() => Products.ProductList;

        public List<Customer> GetCustomerList() => Customers.CustomerList;

        public int TakeSyntax()
        {
            int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

            var first3Numbers = numbers.Take(3).ToArray();

            Console.WriteLine("First 3 numbers:");
            foreach (var n in first3Numbers)
                Console.WriteLine(n);
            return 0;
        }

        public int NestedTake()
        {
            List<Customer> customers = GetCustomerList();
            
            var first3WAOrders = customers.Where(c=>c.Region=="WA").
                SelectMany(c => c.Orders,
                    (c, o) => Tuple.Create(c.CustomerId,o.OrderId,o.OrderDate))
                .Take(3).ToList();

            Console.WriteLine("First 3 orders in WA:");
            foreach (var order in first3WAOrders)
                Console.WriteLine(order);
            return 0;
        }

        public int SkipSyntax()
        {
            int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

            var allButFirst4Numbers = numbers.Skip(4).ToArray();

            Console.WriteLine("All but first 4 numbers:");
            foreach (var n in allButFirst4Numbers)
                Console.WriteLine(n);
  
            return 0;
        }

        public int NestedSkip()
        {
            List<Customer> customers = GetCustomerList();

            var allButFirst2Orders = customers.Where(c=>c.Region=="WA").
                SelectMany(c => c.Orders,
                    (c, o) => Tuple.Create(c.CustomerId,o.OrderId,o.OrderDate))
                .Skip(2).ToList();

            Console.WriteLine("All but first 2 orders in WA:");
            foreach (var order in allButFirst2Orders)
                Console.WriteLine(order);
            return 1;
        }

        public int TakeWhileSyntax()
        {
            int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

            var firstNumbersLessThan6 = numbers.TakeWhile(n => n < 6).ToArray();

            Console.WriteLine("First numbers less than 6:");
            foreach (var num in firstNumbersLessThan6)
                Console.WriteLine(num);
            
            return 0;
        }

        public int IndexedTakeWhile()
        {
            int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

            var firstSmallNumbers = numbers.TakeWhile((n, index) => n >= index).ToArray();

            Console.WriteLine("First numbers not less than their position:");
            foreach (var n in firstSmallNumbers)
                Console.WriteLine(n);
         
            return 0;
        }

        public int SkipWhileSyntax()
        {
            int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

            var allButFirst3Numbers = numbers.SkipWhile(n => n % 3 != 0).ToArray();

            Console.WriteLine("All elements starting from first element divisible by 3:");
            foreach (var n in allButFirst3Numbers)
                Console.WriteLine(n);
            return 0;
        }

        public int IndexedSkipWhile()
        {
            int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

            var laterNumbers = numbers.SkipWhile((n, index) => n >= index).ToArray();

            Console.WriteLine("All elements starting from first element less than its position:");
            foreach (var n in laterNumbers)
                Console.WriteLine(n);
            return 0;
        }

    }
