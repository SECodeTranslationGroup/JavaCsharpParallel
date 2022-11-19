using Parallel.Linq101.DataSources;

namespace Parallel.Linq101.MyLinq;

public class OrderbyMethods {
    //original:4 target:40 form Orderings
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
    
    public List<double> DoubleOrderby() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.OrderBy(n => n).ToList();
        return sortedNumbers;
    }

    public List<double> DoubleOrderbyFraction() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.OrderBy(n => n-(int)n).ToList();
        return sortedNumbers;
    }
    
    public List<double> DoubleFractionOrderby() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.Select(n => n-(int)n).OrderBy(n=>n).ToList();
        return sortedNumbers;
    }
    
    public List<double> BigDoubleOrderby() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.Where(n => n > 5).OrderBy(n => n).ToList();
        return sortedNumbers;
    }

    public List<double> BigDoubleOrderbyFraction() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.Where(n => n > 5).OrderBy(n => n-(int)n).ToList();
        return sortedNumbers;
    }
    
    public List<double> BigDoubleFractionOrderby() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.Where(n => n > 5).Select(n => n-(int)n).OrderBy(n=>n).ToList();
        return sortedNumbers;
    }
    
    public List<Tuple<bool, List<double>>> DoubleGroupByBoolOrderby() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<Tuple<bool, List<double>>> numbersGroups = numbers.GroupBy(n => n>5)
            .Select(g => Tuple.Create(g.Key, g.OrderBy(w=>w).ToList())).ToList();
        return numbersGroups;
    }

    public Dictionary<bool, List<double>> DoubleGroupByBoolDictOrderby() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        Dictionary<bool, List<double>>  numbersGroups = numbers.GroupBy(n => n>5)
            .ToDictionary(g => g.Key, g => g.OrderBy(w=>w).ToList());
        return numbersGroups;
    }
    
    public List<Tuple<bool, List<double>>> DoubleGroupByBoolOrderbyFraction() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<Tuple<bool, List<double>>> numbersGroups = numbers.GroupBy(n => n>5)
            .Select(g => Tuple.Create(g.Key, g.OrderBy(n=>n-(int)n).ToList())).ToList();
        return numbersGroups;
    }

    public Dictionary<bool, List<double>> DoubleGroupByBoolDictOrderbyFraction() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        Dictionary<bool, List<double>>  numbersGroups = numbers.GroupBy(n => n>5)
            .ToDictionary(g => g.Key, g => g.OrderBy(n=>n-(int)n).ToList());
        return numbersGroups;
    }

    public List<string> StringOrderby() {
        string[] words = { "cherry", "apple", "blueberry" };
        List<string> sortedWords = words.OrderBy(w => w).ToList();
        return sortedWords;
    }

    public List<string> StringOrderbyLength() {
        string[] words = { "cherry", "apple", "blueberry" };
        List<string> sortedWords = words.OrderBy(w => w.Length).ToList();
        return sortedWords;
    }

    public List<int> StringLengthOrderby() {
        string[] words = { "cherry", "apple", "blueberry" };
        List<int> sortedWords = words.Select(w => w.Length).OrderBy(w => w).ToList();
        return sortedWords;
    }

    public List<string> ShortStringOrderby() {
        string[] words = { "cherry", "apple", "blueberry", "pear", "peach", "melon" };
        List<string> sortedWords = words.Where(w => w.Length < 6).OrderBy(w => w).ToList();
        return sortedWords;
    }

    public List<string> ShortStringOrderbyLength() {
        string[] words = { "cherry", "apple", "blueberry", "pear", "peach", "melon" };
        List<string> sortedWords = words.Where(w => w.Length < 6).OrderBy(w => w.Length).ToList();
        return sortedWords;
    }

    public List<int> ShortStringLengthOrderby() {
        string[] words = { "cherry", "apple", "blueberry", "pear", "peach", "melon" };
        List<int> sortedWords = words.Where(w => w.Length < 6).Select(w => w.Length).OrderBy(w => w).ToList();
        return sortedWords;
    }
    
    public List<Tuple<char, List<string>>> StringGroupByFirstCharOrderby() {
        string[] words = { "blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese" };
        List<Tuple<char, List<string>>> wordsGroups = words.GroupBy(w => w[0])
            .Select(g => Tuple.Create(g.Key, g.OrderBy(w=>w).ToList())).ToList();
        return wordsGroups;
    }

    public Dictionary<char, List<string>> StringGroupByFirstCharDictOrderby() {
        string[] words = { "blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese" };
        Dictionary<char, List<string>> wordsGroups = words.GroupBy(w => w[0])
            .ToDictionary(g => g.Key, g => g.OrderBy(w=>w).ToList());
        return wordsGroups;
    }

    public List<Tuple<bool, List<string>>> StringGroupByLengthOrderbyLength() {
        string[] words = { "blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese" };
        List<Tuple<bool, List<string>>> wordsGroups = words.GroupBy(w => w.Length > 8)
            .Select(g => Tuple.Create(g.Key, g.OrderBy(w=>w.Length).ToList())).ToList();
        return wordsGroups;
    }

    public Dictionary<bool, List<string>> StringGroupByLengthDictOrderbyLength() {
        string[] words = { "blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese" };
        Dictionary<bool, List<string>> wordsGroups = words.GroupBy(w => w.Length > 8)
            .ToDictionary(g => g.Key, g => g.OrderBy(w=>w.Length).ToList());
        return wordsGroups;
    }

    public List<Product> ProductOrderbyId() {
        List<Product> products = GetProductList();
        List<Product> sortedProducts = products.OrderBy(p => p.ProductId).ToList();
        return sortedProducts;
    }
    
    public List<Product> ProductOrderbyName() {
        List<Product> products = GetProductList();
        List<Product> sortedProducts = products.OrderBy(p => p.ProductName).ToList();
        return sortedProducts;
    }
    
    public List<string> ProductNameOrderby() {
        List<Product> products = GetProductList();
        List<string> sortedProducts = products.Select(p => p.ProductName).OrderBy(n=>n).ToList();
        return sortedProducts;
    }
    
    public List<Product> ExpensiveProductOrderbyId() {
        List<Product> products = GetProductList();
        List<Product> sortedProducts = products.Where(p=>p.UnitPrice>100).OrderBy(p => p.ProductId).ToList();
        return sortedProducts;
    }
    
    public List<Product> ExpensiveProductOrderbyName() {
        List<Product> products = GetProductList();
        List<Product> sortedProducts = products.Where(p=>p.UnitPrice>100).OrderBy(p => p.ProductName).ToList();
        return sortedProducts;
    }
    
    public List<string> ExpensiveProductNameOrderby() {
        List<Product> products = GetProductList();
        List<string> sortedProducts = products.Where(p=>p.UnitPrice>100).Select(p => p.ProductName).OrderBy(n=>n).ToList();
        return sortedProducts;
    }
    
    public List<Tuple<string,List<Product>>> ProductGroupByCategoryOrderbyId() {
        List<Product> products = GetProductList();
        List<Tuple<string,List<Product>>> productsGroups = products.GroupBy(p=>p.Category)
            .Select(g => Tuple.Create(g.Key,g.OrderBy(p=>p).ToList())).ToList();
        return productsGroups;
    }
    
    public Dictionary<string,List<Product>> ProductGroupByCategoryDictOrderbyId() {
        List<Product> products = GetProductList();
        Dictionary<string,List<Product>>  productsGroups = products.GroupBy(p=>p.Category)
            .ToDictionary(g => g.Key,g=>g.OrderBy(p=>p).ToList());
        return productsGroups;
    }
    public List<Tuple<string,List<Product>>> ProductGroupByCategoryOrderbyName() {
        List<Product> products = GetProductList();
        List<Tuple<string,List<Product>>> productsGroups = products.GroupBy(p=>p.Category)
            .Select(g => Tuple.Create(g.Key,g.OrderBy(p=>p.ProductName).ToList())).ToList();
        return productsGroups;
    }
    
    public Dictionary<string,List<Product>> ProductGroupByCategoryDictOrderbyName() {
        List<Product> products = GetProductList();
        Dictionary<string,List<Product>>  productsGroups = products.GroupBy(p=>p.Category)
            .ToDictionary(g => g.Key,g=>g.OrderBy(p=>p.ProductName).ToList());
        return productsGroups;
    }

     public List<string> StringOrderbyCustom() {
         string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        List<string> sortedWords = words.OrderBy(w => w, new CaseInsensitiveComparer()).ToList();
        return sortedWords;
    }

    public List<string> StringOrderbyLengthCustom() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        List<string> sortedWords = words.OrderBy(w => w.Length, new CustomNumberComparer()).ToList();
        return sortedWords;
    }

    public List<int> StringLengthOrderbyCustom() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        List<int> sortedWords = words.Select(w => w.Length).OrderBy(w => w, new CustomNumberComparer()).ToList();
        return sortedWords;
    }
    
    public List<string> ShortStringOrderbyCustom() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        List<string> sortedWords = words.Where(w => w.Length < 6).OrderBy(w => w, new CaseInsensitiveComparer()).ToList();
        return sortedWords;
    }

    public List<string> ShortStringOrderbyLengthCustom() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        List<string> sortedWords = words.Where(w => w.Length < 6).OrderBy(w => w.Length, new CustomNumberComparer()).ToList();
        return sortedWords;
    }

    public List<int> ShortStringLengthOrderbyCustom() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        List<int> sortedWords = words.Where(w => w.Length < 6).Select(w => w.Length).OrderBy(w => w, new CustomNumberComparer()).ToList();
        return sortedWords;
    }
    
    public List<Tuple<char, List<string>>> StringGroupByFirstCharOrderbyCustom() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        List<Tuple<char, List<string>>> wordsGroups = words.GroupBy(w => char.ToLower(w[0]))
            .Select(g => Tuple.Create(g.Key, g.OrderBy(w=>w,new CaseInsensitiveComparer()).ToList())).ToList();
        return wordsGroups;
    }

    public Dictionary<char, List<string>> StringGroupByFirstCharDictOrderbyCustom() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        Dictionary<char, List<string>> wordsGroups = words.GroupBy(w => char.ToLower(w[0]))
            .ToDictionary(g => g.Key, g => g.OrderBy(w=>w,new CaseInsensitiveComparer()).ToList());
        return wordsGroups;
    }

    public List<Tuple<bool, List<string>>> StringGroupByLengthOrderbyLengthCustom() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        List<Tuple<bool, List<string>>> wordsGroups = words.GroupBy(w => w.Length > 8)
            .Select(g => Tuple.Create(g.Key, g.OrderBy(w=>w.Length,new CustomNumberComparer()).ToList())).ToList();
        return wordsGroups;
    }

    public Dictionary<bool, List<string>> StringGroupByLengthDictOrderbyLengthCustom() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        Dictionary<bool, List<string>> wordsGroups = words.GroupBy(w => w.Length > 8)
            .ToDictionary(g => g.Key, g => g.OrderBy(w=>w.Length,new CustomNumberComparer()).ToList());
        return wordsGroups;
    }
}