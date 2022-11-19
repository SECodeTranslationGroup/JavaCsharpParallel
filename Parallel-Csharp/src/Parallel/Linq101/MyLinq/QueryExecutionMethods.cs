namespace Parallel.Linq101.MyLinq; 

public class QueryExecutionMethods {
    //original:3 target:20 form QueryExecution
    //reuse query not included
    
    public void NumbersDeferred() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int i = 0;
        var q = numbers.Select(n => i+=n);
        foreach (var v in q)
            Console.WriteLine($"v = {v}, i = {i}");
    }
    
    public void BigNumbersDeferred() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int i = 0;
        var q = numbers.Where(n => n > 5).Select(n => i+=n);
        foreach (var v in q)
            Console.WriteLine($"v = {v}, i = {i}");
    }
    
    public void OddNumbersDeferred() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int i = 0;
        var q = numbers.Where(n => n % 2 == 1).Select(n => i+=n);
        foreach (var v in q)
            Console.WriteLine($"v = {v}, i = {i}");
    }

    public void DoubleDeferred() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        double d = 0;
        var q = numbers.Select(n => d+=n);
        foreach (var v in q)
            Console.WriteLine($"v = {v}, d = {d}");
    }

    public void BigDoubleNumbersDeferred() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        double d = 0;
        var q = numbers.Where(d=>d>5).Select(n => d+=n);
        foreach (var v in q)
            Console.WriteLine($"v = {v}, d = {d}");
    }

    public void NumbersTwiceDeferred() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int i = 0;
        var q = numbers.Select(n=>n*2).Select(n => i+=n);
        foreach (var v in q)
            Console.WriteLine($"v = {v}, i = {i}");
    }

    public void BigNumbersTwiceDeferred() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int i = 0;
        var q = numbers.Where(n => n > 5).Select(n=>n*2).Select(n => i+=n);
        foreach (var v in q)
            Console.WriteLine($"v = {v}, i = {i}");
    }

    public void OddNumbersTwiceDeferred() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int i = 0;
        var q = numbers.Where(n => n % 2==1).Select(n=>n*2).Select(n => i+=n);
        foreach (var v in q)
            Console.WriteLine($"v = {v}, i = {i}");
    }

    public void StringLengthDeferred() {
        string[] words = { "cherry", "apple", "blueberry" };
        int i = 0;
        var q = words.Select(w=>w.Length).Select(n => i+=n);
        foreach (var v in q)
            Console.WriteLine($"v = {v}, i = {i}");
    }

    public void ShortStringLengthDeferred() {
        string[] words = { "cherry", "apple", "blueberry" };
        int i = 0;
        var q = words.Where(w => w.Length < 7).Select(w=>w.Length).Select(n => i+=n);
        foreach (var v in q)
            Console.WriteLine($"v = {v}, i = {i}");
    }
    
    public void NumbersEager() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int i = 0;
        var q = numbers.Select(n => i+=n).ToList();
        foreach (var v in q)
            Console.WriteLine($"v = {v}, i = {i}");
    }
    
    public void BigNumbersEager() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int i = 0;
        var q = numbers.Where(n => n > 5).Select(n => i+=n).ToList();
        foreach (var v in q)
            Console.WriteLine($"v = {v}, i = {i}");
    }
    
    public void OddNumbersEager() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int i = 0;
        var q = numbers.Where(n => n % 2 == 1).Select(n => i+=n).ToList();
        foreach (var v in q)
            Console.WriteLine($"v = {v}, i = {i}");
    }

    public void DoubleEager() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        double d = 0;
        var q = numbers.Select(n => d+=n).ToList();
        foreach (var v in q)
            Console.WriteLine($"v = {v}, d = {d}");
    }

    public void BigDoubleNumbersEager() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        double d = 0;
        var q = numbers.Where(d=>d>5).Select(n => d+=n).ToList();
        foreach (var v in q)
            Console.WriteLine($"v = {v}, d = {d}");
    }

    public void NumbersTwiceEager() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int i = 0;
        var q = numbers.Select(n=>n*2).Select(n => i+=n).ToList();
        foreach (var v in q)
            Console.WriteLine($"v = {v}, i = {i}");
    }

    public void BigNumbersTwiceEager() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int i = 0;
        var q = numbers.Where(n => n > 5).Select(n=>n*2).Select(n => i+=n).ToList();
        foreach (var v in q)
            Console.WriteLine($"v = {v}, i = {i}");
    }

    public void OddNumbersTwiceEager() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int i = 0;
        var q = numbers.Where(n => n % 2==1).Select(n=>n*2).Select(n => i+=n).ToList();
        foreach (var v in q)
            Console.WriteLine($"v = {v}, i = {i}");
    }

    public void StringLengthEager() {
        string[] words = { "cherry", "apple", "blueberry" };
        int i = 0;
        var q = words.Select(w=>w.Length).Select(n => i+=n).ToList();
        foreach (var v in q)
            Console.WriteLine($"v = {v}, i = {i}");
    }

    public void ShortStringLengthEager() {
        string[] words = { "cherry", "apple", "blueberry" };
        int i = 0;
        var q = words.Where(w => w.Length < 7).Select(w=>w.Length).Select(n => i+=n).ToList();
        foreach (var v in q)
            Console.WriteLine($"v = {v}, i = {i}");
    }
}