using Parallel.Linq101.DataSources;

namespace Parallel.Linq101.MyLinq; 

public class OrderbyDescendingMethods {
    //descending
    //original:4 target:40 form Orderings
    //reverse
    //original:1 target:10 form Orderings
    public List<Product> GetProductList() => Products.ProductList;
    public List<Customer> GetCustomerList() => Customers.CustomerList;
    public class CaseInsensitiveComparer: IComparer<string> {
        public int Compare(string x, string y) =>
            string.Compare(x, y, StringComparison.OrdinalIgnoreCase);
    }
    
    public class CustomNumberComparer : IComparer<int> {
        public int Compare(int x, int y) =>
            Math.Abs(x - 5) - Math.Abs(y - 5);
    }
    
    public List<double> DoubleOrderbyDescending() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.OrderByDescending(n => n).ToList();
        return sortedNumbers;
    }

    public List<double> DoubleOrderbyDescendingFraction() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.OrderByDescending(n => n-(int)n).ToList();
        return sortedNumbers;
    }
    
    public List<double> DoubleFractionOrderbyDescending() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.Select(n => n-(int)n).OrderByDescending(n=>n).ToList();
        return sortedNumbers;
    }
    
    public List<double> BigDoubleOrderbyDescending() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.Where(n => n > 5).OrderByDescending(n => n).ToList();
        return sortedNumbers;
    }

    public List<double> BigDoubleOrderbyDescendingFraction() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.Where(n => n > 5).OrderByDescending(n => n-(int)n).ToList();
        return sortedNumbers;
    }
    
    public List<double> BigDoubleFractionOrderbyDescending() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.Where(n => n > 5).Select(n => n-(int)n).OrderByDescending(n=>n).ToList();
        return sortedNumbers;
    }
    
    public List<Tuple<bool, List<double>>> DoubleGroupByBoolOrderbyDescending() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<Tuple<bool, List<double>>> numbersGroups = numbers.GroupBy(n => n>5)
            .Select(g => Tuple.Create(g.Key, g.OrderByDescending(w=>w).ToList())).ToList();
        return numbersGroups;
    }

    public Dictionary<bool, List<double>> DoubleGroupByBoolDictOrderbyDescending() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        Dictionary<bool, List<double>>  numbersGroups = numbers.GroupBy(n => n>5)
            .ToDictionary(g => g.Key, g => g.OrderByDescending(w=>w).ToList());
        return numbersGroups;
    }
    
    public List<Tuple<bool, List<double>>> DoubleGroupByBoolOrderbyDescendingFraction() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<Tuple<bool, List<double>>> numbersGroups = numbers.GroupBy(n => n>5)
            .Select(g => Tuple.Create(g.Key, g.OrderByDescending(n=>n-(int)n).ToList())).ToList();
        return numbersGroups;
    }

    public Dictionary<bool, List<double>> DoubleGroupByBoolDictOrderbyDescendingFraction() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        Dictionary<bool, List<double>>  numbersGroups = numbers.GroupBy(n => n>5)
            .ToDictionary(g => g.Key, g => g.OrderByDescending(n=>n-(int)n).ToList());
        return numbersGroups;
    }

    public List<string> StringOrderbyDescending() {
        string[] words = { "cherry", "apple", "blueberry" };
        List<string> sortedWords = words.OrderByDescending(w => w).ToList();
        return sortedWords;
    }

    public List<string> StringOrderbyDescendingLength() {
        string[] words = { "cherry", "apple", "blueberry" };
        List<string> sortedWords = words.OrderByDescending(w => w.Length).ToList();
        return sortedWords;
    }

    public List<int> StringLengthOrderbyDescending() {
        string[] words = { "cherry", "apple", "blueberry" };
        List<int> sortedWords = words.Select(w => w.Length).OrderByDescending(w => w).ToList();
        return sortedWords;
    }

    public List<string> ShortStringOrderbyDescending() {
        string[] words = { "cherry", "apple", "blueberry", "pear", "peach", "melon" };
        List<string> sortedWords = words.Where(w => w.Length < 6).OrderByDescending(w => w).ToList();
        return sortedWords;
    }

    public List<string> ShortStringOrderbyDescendingLength() {
        string[] words = { "cherry", "apple", "blueberry", "pear", "peach", "melon" };
        List<string> sortedWords = words.Where(w => w.Length < 6).OrderByDescending(w => w.Length).ToList();
        return sortedWords;
    }

    public List<int> ShortStringLengthOrderbyDescending() {
        string[] words = { "cherry", "apple", "blueberry", "pear", "peach", "melon" };
        List<int> sortedWords = words.Where(w => w.Length < 6).Select(w => w.Length).OrderByDescending(w => w).ToList();
        return sortedWords;
    }
    
    public List<Tuple<char, List<string>>> StringGroupByFirstCharOrderbyDescending() {
        string[] words = { "blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese" };
        List<Tuple<char, List<string>>> wordsGroups = words.GroupBy(w => w[0])
            .Select(g => Tuple.Create(g.Key, g.OrderByDescending(w=>w).ToList())).ToList();
        return wordsGroups;
    }

    public Dictionary<char, List<string>> StringGroupByFirstCharDictOrderbyDescending() {
        string[] words = { "blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese" };
        Dictionary<char, List<string>> wordsGroups = words.GroupBy(w => w[0])
            .ToDictionary(g => g.Key, g => g.OrderByDescending(w=>w).ToList());
        return wordsGroups;
    }

    public List<Tuple<bool, List<string>>> StringGroupByLengthOrderbyDescendingLength() {
        string[] words = { "blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese" };
        List<Tuple<bool, List<string>>> wordsGroups = words.GroupBy(w => w.Length > 8)
            .Select(g => Tuple.Create(g.Key, g.OrderByDescending(w=>w.Length).ToList())).ToList();
        return wordsGroups;
    }

    public Dictionary<bool, List<string>> StringGroupByLengthDictOrderbyDescendingLength() {
        string[] words = { "blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese" };
        Dictionary<bool, List<string>> wordsGroups = words.GroupBy(w => w.Length > 8)
            .ToDictionary(g => g.Key, g => g.OrderByDescending(w=>w.Length).ToList());
        return wordsGroups;
    }

    public List<Product> ProductOrderbyDescendingId() {
        List<Product> products = GetProductList();
        List<Product> sortedProducts = products.OrderByDescending(p => p.ProductId).ToList();
        return sortedProducts;
    }
    
    public List<Product> ProductOrderbyDescendingName() {
        List<Product> products = GetProductList();
        List<Product> sortedProducts = products.OrderByDescending(p => p.ProductName).ToList();
        return sortedProducts;
    }
    
    public List<string> ProductNameOrderbyDescending() {
        List<Product> products = GetProductList();
        List<string> sortedProducts = products.Select(p => p.ProductName).OrderByDescending(n=>n).ToList();
        return sortedProducts;
    }
    
    public List<Product> ExpensiveProductOrderbyDescendingId() {
        List<Product> products = GetProductList();
        List<Product> sortedProducts = products.Where(p=>p.UnitPrice>100).OrderByDescending(p => p.ProductId).ToList();
        return sortedProducts;
    }
    
    public List<Product> ExpensiveProductOrderbyDescendingName() {
        List<Product> products = GetProductList();
        List<Product> sortedProducts = products.Where(p=>p.UnitPrice>100).OrderByDescending(p => p.ProductName).ToList();
        return sortedProducts;
    }
    
    public List<string> ExpensiveProductNameOrderbyDescending() {
        List<Product> products = GetProductList();
        List<string> sortedProducts = products.Where(p=>p.UnitPrice>100).Select(p => p.ProductName).OrderByDescending(n=>n).ToList();
        return sortedProducts;
    }
    
    public List<Tuple<string,List<Product>>> ProductGroupByCategoryOrderbyDescendingId() {
        List<Product> products = GetProductList();
        List<Tuple<string,List<Product>>> productsGroups = products.GroupBy(p=>p.Category)
            .Select(g => Tuple.Create(g.Key,g.OrderByDescending(p=>p).ToList())).ToList();
        return productsGroups;
    }
    
    public Dictionary<string,List<Product>> ProductGroupByCategoryDictOrderbyDescendingId() {
        List<Product> products = GetProductList();
        Dictionary<string,List<Product>>  productsGroups = products.GroupBy(p=>p.Category)
            .ToDictionary(g => g.Key,g=>g.OrderByDescending(p=>p).ToList());
        return productsGroups;
    }
    public List<Tuple<string,List<Product>>> ProductGroupByCategoryOrderbyDescendingName() {
        List<Product> products = GetProductList();
        List<Tuple<string,List<Product>>> productsGroups = products.GroupBy(p=>p.Category)
            .Select(g => Tuple.Create(g.Key,g.OrderByDescending(p=>p.ProductName).ToList())).ToList();
        return productsGroups;
    }
    
    public Dictionary<string,List<Product>> ProductGroupByCategoryDictOrderbyDescendingName() {
        List<Product> products = GetProductList();
        Dictionary<string,List<Product>>  productsGroups = products.GroupBy(p=>p.Category)
            .ToDictionary(g => g.Key,g=>g.OrderByDescending(p=>p.ProductName).ToList());
        return productsGroups;
    }

     public List<string> StringOrderbyDescendingCustom() {
         string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        List<string> sortedWords = words.OrderByDescending(w => w, new CaseInsensitiveComparer()).ToList();
        return sortedWords;
    }

    public List<string> StringOrderbyDescendingLengthCustom() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        List<string> sortedWords = words.OrderByDescending(w => w.Length, new CustomNumberComparer()).ToList();
        return sortedWords;
    }

    public List<int> StringLengthOrderbyDescendingCustom() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        List<int> sortedWords = words.Select(w => w.Length).OrderByDescending(w => w, new CustomNumberComparer()).ToList();
        return sortedWords;
    }
    
    public List<string> ShortStringOrderbyDescendingCustom() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        List<string> sortedWords = words.Where(w => w.Length < 6).OrderByDescending(w => w, new CaseInsensitiveComparer()).ToList();
        return sortedWords;
    }

    public List<string> ShortStringOrderbyDescendingLengthCustom() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        List<string> sortedWords = words.Where(w => w.Length < 6).OrderByDescending(w => w.Length, new CustomNumberComparer()).ToList();
        return sortedWords;
    }

    public List<int> ShortStringLengthOrderbyDescendingCustom() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        List<int> sortedWords = words.Where(w => w.Length < 6).Select(w => w.Length).OrderByDescending(w => w, new CustomNumberComparer()).ToList();
        return sortedWords;
    }
    
    public List<Tuple<char, List<string>>> StringGroupByFirstCharOrderbyDescendingCustom() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        List<Tuple<char, List<string>>> wordsGroups = words.GroupBy(w => char.ToLower(w[0]))
            .Select(g => Tuple.Create(g.Key, g.OrderByDescending(w=>w,new CaseInsensitiveComparer()).ToList())).ToList();
        return wordsGroups;
    }

    public Dictionary<char, List<string>> StringGroupByFirstCharDictOrderbyDescendingCustom() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        Dictionary<char, List<string>> wordsGroups = words.GroupBy(w => char.ToLower(w[0]))
            .ToDictionary(g => g.Key, g => g.OrderByDescending(w=>w,new CaseInsensitiveComparer()).ToList());
        return wordsGroups;
    }

    public List<Tuple<bool, List<string>>> StringGroupByLengthOrderbyDescendingLengthCustom() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        List<Tuple<bool, List<string>>> wordsGroups = words.GroupBy(w => w.Length > 8)
            .Select(g => Tuple.Create(g.Key, g.OrderByDescending(w=>w.Length,new CustomNumberComparer()).ToList())).ToList();
        return wordsGroups;
    }

    public Dictionary<bool, List<string>> StringGroupByLengthDictOrderbyDescendingLengthCustom() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        Dictionary<bool, List<string>> wordsGroups = words.GroupBy(w => w.Length > 8)
            .ToDictionary(g => g.Key, g => g.OrderByDescending(w=>w.Length,new CustomNumberComparer()).ToList());
        return wordsGroups;
    }
    //Reverse
    public List<double> DoubleReverse() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.Reverse().ToList();
        return sortedNumbers;
    }
    
    public List<double> DoubleOrderbyReverse() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.OrderBy(n=>n).Reverse().ToList();
        return sortedNumbers;
    }

    public List<double> DoubleOrderbyFractionReverse() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.OrderBy(n => n-(int)n).Reverse().ToList();
        return sortedNumbers;
    }
    
    public List<double> DoubleFractionReverse() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.Select(n => n-(int)n).Reverse().ToList();
        return sortedNumbers;
    }
    
    public List<double> DoubleFractionOrderbyReverse() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.Select(n => n-(int)n).OrderBy(n=>n).Reverse().ToList();
        return sortedNumbers;
    }
    
    public List<string> StringReverse() {
        string[] words = { "cherry", "apple", "blueberry" };
        List<string> sortedWords = words.Reverse().ToList();
        return sortedWords;
    }

    public List<string> StringOrderbyReverse() {
        string[] words = { "cherry", "apple", "blueberry" };
        List<string> sortedWords = words.OrderBy(w => w).Reverse().ToList();
        return sortedWords;
    }

    public List<string> StringOrderbyLengthReverse() {
        string[] words = { "cherry", "apple", "blueberry" };
        List<string> sortedWords = words.OrderBy(w => w.Length).Reverse().ToList();
        return sortedWords;
    }

    public List<string> ShortStringReverse() {
        string[] words = { "cherry", "apple", "blueberry", "pear", "peach", "melon" };
        List<string> sortedWords = words.Where(w => w.Length < 6).Reverse().ToList();
        return sortedWords;
    }

    public List<string> ShortStringOrderbyReverse() {
        string[] words = { "cherry", "apple", "blueberry", "pear", "peach", "melon" };
        List<string> sortedWords = words.Where(w => w.Length < 6).OrderBy(w => w).Reverse().ToList();
        return sortedWords;
    }

    public List<string> ShortStringOrderbyLengthReverse() {
        string[] words = { "cherry", "apple", "blueberry", "pear", "peach", "melon" };
        List<string> sortedWords = words.Where(w => w.Length < 6).OrderBy(w => w.Length).Reverse().ToList();
        return sortedWords;
    }
    
}