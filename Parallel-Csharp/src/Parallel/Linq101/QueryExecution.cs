using System;
using System.Linq;

namespace Parallel.Linq101;

public class QueryExecution {
    public int DeferredExecution() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int i = 0;
        var q = numbers.Select(n => ++i);
        foreach (var v in q)
            Console.WriteLine($"v = {v}, i = {i}");
        return 0;
    }

    public int EagerExecution() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int i = 0;
        var q = numbers.Select(n => ++i).ToArray();
        foreach (var v in q)
            Console.WriteLine($"v = {v}, i = {i}");
        return 0;
    }

    public int ReuseQueryDefinition() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        var lowNumbers = numbers.Where(n => n <= 3);
        var lowNumbers2 = numbers.Where(n => n <= 3);
        Console.WriteLine("First run numbers <= 3:");
        foreach (int n in lowNumbers)
            Console.WriteLine(n);
        for (int i = 0; i < 10; i++)
            numbers[i] = -numbers[i];
        Console.WriteLine("Second run numbers <= 3:");
        foreach (int n in lowNumbers2)
            Console.WriteLine(n);
        return 0;
    }
}