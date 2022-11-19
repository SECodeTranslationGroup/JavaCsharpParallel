using Parallel.Linq101.DataSources;

namespace Parallel.Linq101.MyLinq;

public class ConcatMethods {
    //original:5 target:30 form SequenceOperations
    public List<Product> GetProductList() => Products.ProductList;
    public List<Customer> GetCustomerList() => Customers.CustomerList;

    public bool EqualInts() {
        int[] numbersA = { 0, 2, 4, 5, 9 };
        int[] numbersB = { 0, 2, 4, 5, 9 };
        bool equal = numbersA.SequenceEqual(numbersB);
        return equal;
    }

    public bool UnequalInts() {
        int[] numbersA = { 0, 2, 4, 5, 9 };
        int[] numbersB = { 1, 3, 5, 6, 10 };
        bool equal = numbersA.SequenceEqual(numbersB);
        return equal;
    }

    public bool ProjectedEqualInts() {
        int[] numbersA = { 0, 2, 4, 5, 9 };
        int[] numbersB = { 1, 3, 5, 6, 10 };
        bool equal = numbersA.Select(n => n + 1).SequenceEqual(numbersB);
        return equal;
    }

    public bool EqualDoubles() {
        double[] numbersA = { 0.5, 2.3, 4.7, 5.4, 9.8 };
        double[] numbersB = { 0.5, 2.3, 4.7, 5.4, 9.8 };
        bool equal = numbersA.SequenceEqual(numbersB);
        return equal;
    }

    public bool UnequalDoubles() {
        double[] numbersA = { 0.5, 2.3, 4.7, 5.4, 9.8 };
        double[] numbersB = { 6.5, 1.3, 8.7, 2.4, 4.8 };
        bool equal = numbersA.SequenceEqual(numbersB);
        return equal;
    }

    public bool ProjectedEqualDoubles() {
        double[] numbersA = { 0.5, 2.3, 4.7, 5.4, 9.8 };
        double[] numbersB = { 6.5, 1.3, 8.7, 2.4, 4.8 };
        bool equal = numbersA.Select(n => n - (int)n).SequenceEqual(numbersB.Select(n => n - (int)n));
        return equal;
    }

    public bool EqualStrings() {
        string[] wordsA = { "Alpha", "Beta", "Gamma" };
        string[] wordsB = { "Alpha", "Beta", "Gamma" };
        bool equal = wordsA.SequenceEqual(wordsB);
        return equal;
    }

    public bool EqualStringLengths() {
        string[] wordsA = { "Alpha", "Beta", "Gamma" };
        string[] wordsB = { "Gamma", "Beta", "Alpha" };
        bool equal = wordsA.Select(w => w.Length).SequenceEqual(wordsB.Select(w => w.Length));
        return equal;
    }

    public bool UnequalStrings() {
        string[] wordsA = { "Alpha", "Beta", "Gamma" };
        string[] wordsB = { "aLPhA", "bETa", "gAaMa" };
        bool equal = wordsA.SequenceEqual(wordsB);
        return equal;
    }

    public bool ProjectedEqualStrings() {
        string[] wordsA = { "Alpha", "Beta", "Gamma" };
        string[] wordsB = { "aLPhA", "bETa", "gAaMa" };
        bool equal = wordsA.Select(w => w.ToLower()).SequenceEqual(wordsB.Select(w => w.ToLower()));
        return equal;
    }

    public int[] IntConcat() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8 };
        int[] allNumbers = numbersA.Concat(numbersB).ToArray();
        return allNumbers;
    }

    public double[] DoubleConcat() {
        double[] numbersA = { 0.1, 2.2, 4.3, 5.4, 6.5, 8.6, 9.7 };
        double[] numbersB = { 0.1, 3.3, 5.4, 7.7, 8.6 };
        double[] allNumbers = numbersA.Concat(numbersB).ToArray();
        return allNumbers;
    }

    public string[] StringConcat() {
        string[] wordsA = { "Alice", "Bob", "Foo", "Bar" };
        string[] wordsB = { "Cafe", "Bar", "Restaurant" };
        string[] allWords = wordsA.Concat(wordsB).ToArray();
        return allWords;
    }

    public int[] ProjectionIntConcat() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8 };
        var first = numbersA.Select(n => n + 1);
        var second = numbersB.Select(n => n - 1);
        int[] numbers = first.Concat(second).ToArray();
        return numbers;
    }

    public double[] ProjectionDoubleConcat() {
        double[] numbersA = { 0.1, 2.2, 4.3, 5.4, 6.5, 8.6, 9.7 };
        double[] numbersB = { 0.1, 3.3, 5.4, 7.7, 8.6 };
        var first = numbersA.Select(n => n - (int)n);
        var second = numbersB.Select(n => n - (int)n);
        double[] numbers = first.Concat(second).ToArray();
        return numbers;
    }

    public char[] ProjectionStringConcat() {
        string[] wordsA = { "Alice", "Bob", "Foo", "Bar" };
        string[] wordsB = { "Cafe", "Bar", "Restaurant" };
        var first = wordsA.Select(n => n[0]);
        var second = wordsB.Select(n => n[0]);
        char[] words = first.Concat(second).ToArray();
        return words;
    }

    public List<string> ConcatOfCategory() {
        string[] categories = { "Furnitures", "Seagoods" };
        List<Product> products = GetProductList();
        var productCategories = products.Select(p => p.Category);
        List<string> allCategories = productCategories.Concat(categories).ToList();
        return allCategories;
    }

    public List<string> ConcatOfRegion() {
        string[] regions = { "WA", "AF", "RO" };
        List<Customer> customers = GetCustomerList();
        var customerRegions = customers.Select(c => c.Region);
        List<string> allCategories = customerRegions.Concat(regions).ToList();
        return allCategories;
    }

    public List<string> ConcatOfName() {
        List<Product> products = GetProductList();
        List<Customer> customers = GetCustomerList();
        var productFirstChars = products.Select(p => p.ProductName);
        var customerFirstChars = customers.Select(c => c.CompanyName);
        List<string> allFirstChars = productFirstChars.Concat(customerFirstChars).ToList();
        return allFirstChars;
    }

    public List<char> ConcatOfNameFirstChar() {
        List<Product> products = GetProductList();
        List<Customer> customers = GetCustomerList();
        var productFirstChars = products.Select(p => p.ProductName[0]);
        var customerFirstChars = customers.Select(c => c.CompanyName[0]);
        List<char> allFirstChars = productFirstChars.Concat(customerFirstChars).ToList();
        return allFirstChars;
    }
    public int[] IntZipAdd() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8, 10, 11 };
        int[] addNumbers = numbersA.Zip(numbersB,(a,b)=>a+b).ToArray();
        return addNumbers;
    }
    public int[] IntZipAddReverse() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8, 10, 11 };
        int[] addNumbers = numbersA.Zip(numbersB.Reverse(),(a,b)=>a+b).ToArray();
        return addNumbers;
    }
    public int[] IntZipSub() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8, 10, 11 };
        int[] subNumbers = numbersA.Zip(numbersB,(a,b)=>a-b).ToArray();
        return subNumbers;
    }
    public int[] IntZipMultiply() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8, 10, 11 };
        int[] multiplyNumbers = numbersA.Zip(numbersB,(a,b)=>a*b).ToArray();
        return multiplyNumbers;
    }
    public int IntDotProduct() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8, 10, 11 };
        int dotProduct = numbersA.Zip(numbersB,(a,b)=>a*b).Sum();
        return dotProduct;
    }
    public int IntAddMultiply() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8, 10, 11 };
        int product = numbersA.Zip(numbersB,(a,b)=>a+b).Aggregate((a,b)=>a*b);
        return product;
    }
    
    public string[] StringZipAdd() {
        string[] wordsA = { "Alpha", "Beta", "Gamma" };
        string[] wordsB = { "red", "green", "blue" };
        string[] addNumbers = wordsA.Zip(wordsB,(a,b)=>a+b).ToArray();
        return addNumbers;
    }
    
    public string[] StringZipAddInt() {
        string[] words = { "Alpha", "Beta", "Gamma" };
        int[] numbers = { 1,2,3 };
        string[] addNumbers = words.Zip(numbers,(a,b)=>a+b).ToArray();
        return addNumbers;
    }
    
    public string[] StringProjectionZipAdd() {
        string[] wordsA = { "Alpha", "Beta", "Gamma" };
        string[] wordsB = { "red", "green", "blue" };
        string[] addNumbers = wordsA.Select(w=>w[0].ToString())
            .Zip(wordsB.Select(w=>w[0]),(a,b)=>a+b).ToArray();
        return addNumbers;
    }
    public int[] StringProjectionZipAddInt() {
        string[] wordsA = { "Alpha", "Beta", "Gamma" };
        string[] wordsB = { "red", "green", "blue" };
        int[] addNumbers = wordsA.Select(w=>w.Length)
            .Zip(wordsB.Select(w=>w.Length),(a,b)=>a+b).ToArray();
        return addNumbers;
    }
}