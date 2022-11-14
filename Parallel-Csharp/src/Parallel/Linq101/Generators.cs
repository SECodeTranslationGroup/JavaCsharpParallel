using System;
using System.Linq;

namespace Parallel.Linq101;
    public class Generators
    {
        public int RangeOfIntegers()
        {
            var numbers = Enumerable.Range(100, 50).Select(n => Tuple.Create(n, n % 2 == 1 ? "odd" : "even")).ToList();


            foreach (var n in numbers)
                Console.WriteLine($"The number {n.Item1} is {n.Item2}.");
            return 0;
        }

        public int RepeatNumber()
        {
            var numbers = Enumerable.Repeat(7, 10).ToList();

            foreach (var n in numbers)
                Console.WriteLine(n);
            
            return 0;
        }
    }

