using System;
using System.Linq;

namespace Parallel.Linq101;

public class Conversions {
    public int ConvertToArray() {
        double[] doubles = { 1.7, 2.3, 1.9, 4.1, 2.9 };
        var doublesArray = doubles.OrderByDescending(d => d).ToArray();
        Console.WriteLine("Every other double from highest to lowest:");
        for (int d = 0; d < doublesArray.Length; d += 2)
            Console.WriteLine(doublesArray[d]);
        return 0;
    }

    public int ConvertToList() {
        string[] words = { "cherry", "apple", "blueberry" };
        var sortedWords = words.OrderBy(w => w).ToList();
        Console.WriteLine("The sorted word list:");
        foreach (var w in sortedWords)
            Console.WriteLine(w);
        return 0;
    }

    public int ConvertToDictionary() {
        Tuple<string,int>[] scoreRecords = { Tuple.Create("Alice", 50), Tuple.Create("Bob", 40), Tuple.Create("Cathy", 45) };
        var scoreRecordsDict = scoreRecords.ToDictionary(sr => sr.Item1,
            sr => sr.Item2);
        Console.WriteLine("Bob's score: {0}", scoreRecordsDict["Bob"]);
        return 0;
    }

    public int ConvertSelectedItems() {
        object[] numbers = { null, 1.0, "two", 3, "four", 5, "six", 7.0 };
        var doubles = numbers.OfType<double>();
        Console.WriteLine("Numbers stored as doubles:");
        foreach (var d in doubles)
            Console.WriteLine(d);
        return 0;
    }
}