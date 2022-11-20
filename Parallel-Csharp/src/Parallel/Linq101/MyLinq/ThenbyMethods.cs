using Parallel.Linq101.DataSources;

namespace Parallel.Linq101.MyLinq; 

public class ThenbyMethods {
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
    
    public List<double> DoubleOrderbyFractionThenby() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.OrderBy(n => n-(int)n).ThenBy(n => n).ToList();
        return sortedNumbers;
    }

    public List<double> DoubleOrderbyModThenby() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.OrderBy(n => n % 1.5).ThenBy(n => n).ToList();
        return sortedNumbers;
    }
    
    public List<double> DoubleOrderbyFractionDescendingThenby() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.OrderByDescending(n => n-(int)n).ThenBy(n => n).ToList();
        return sortedNumbers;
    }

    public List<double> DoubleOrderbyModDescendingThenby() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.OrderByDescending(n => n % 1.5).ThenBy(n => n).ToList();
        return sortedNumbers;
    }
    
    public List<double> DoubleOrderbyFractionThenbyDescending() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.OrderBy(n => n-(int)n).ThenByDescending(n => n).ToList();
        return sortedNumbers;
    }

    public List<double> DoubleOrderbyModThenbyDescending() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.OrderBy(n => n % 1.5).ThenByDescending(n => n).ToList();
        return sortedNumbers;
    }
    
    public List<double> DoubleOrderbyFractionDescendingThenbyDescending() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.OrderByDescending(n => n-(int)n).ThenByDescending(n => n).ToList();
        return sortedNumbers;
    }

    public List<double> DoubleOrderbyModDescendingThenbyDescending() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.OrderByDescending(n => n % 1.5).ThenByDescending(n => n).ToList();
        return sortedNumbers;
    }
    
    public List<double> BigDoubleOrderbyFractionThenby() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.Where(n=>n>3).OrderBy(n => n-(int)n).ThenBy(n => n).ToList();
        return sortedNumbers;
    }

    public List<double> BigDoubleOrderbyModThenby() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.Where(n=>n>3).OrderBy(n => n % 1.5).ThenBy(n => n).ToList();
        return sortedNumbers;
    }
    
    public List<double> BigDoubleOrderbyFractionDescendingThenby() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.Where(n=>n>3).OrderByDescending(n => n-(int)n).ThenBy(n => n).ToList();
        return sortedNumbers;
    }

    public List<double> BigDoubleOrderbyModDescendingThenby() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.Where(n=>n>3).OrderByDescending(n => n % 1.5).ThenBy(n => n).ToList();
        return sortedNumbers;
    }
    
    public List<double> BigDoubleOrderbyFractionThenbyDescending() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.Where(n=>n>3).OrderBy(n => n-(int)n).ThenByDescending(n => n).ToList();
        return sortedNumbers;
    }

    public List<double> BigDoubleOrderbyModThenbyDescending() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.Where(n=>n>3).OrderBy(n => n % 1.5).ThenByDescending(n => n).ToList();
        return sortedNumbers;
    }
    
    public List<double> BigDoubleOrderbyFractionDescendingThenbyDescending() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.Where(n=>n>3).OrderByDescending(n => n-(int)n).ThenByDescending(n => n).ToList();
        return sortedNumbers;
    }

    public List<double> BigDoubleOrderbyModDescendingThenbyDescending() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        List<double> sortedNumbers = numbers.Where(n=>n>3).OrderByDescending(n => n % 1.5).ThenByDescending(n => n).ToList();
        return sortedNumbers;
    }
    
    public List<string> StringOrderbyLengthThenby() {
        string[] words = { "cherry", "apple", "blueberry","banana","abacus" };
        List<string> sortedWords = words.OrderBy(w => w.Length).ThenBy(w=>w).ToList();
        return sortedWords;
    }
    
    public List<string> StringOrderbyThenbyLength() {
        string[] words = { "cherry", "apple", "blueberry","banana","abacus" };
        List<string> sortedWords = words.OrderBy(w => w).ThenBy(w=>w.Length).ToList();
        return sortedWords;
    }
    
    public List<string> StringOrderbyLengthCustomThenby() {
        string[] words = { "cherry", "apple", "blueberry","banana","abacus" };
        List<string> sortedWords = words.OrderBy(w => w.Length,
            new CustomNumberComparer()).ThenBy(w=>w).ToList();
        return sortedWords;
    }
    
    public List<string> StringOrderbyThenbyLengthCustom() {
        string[] words = { "cherry", "apple", "blueberry","banana","abacus" };
        List<string> sortedWords = words.OrderBy(w => w)
            .ThenBy(w=>w.Length,new CustomNumberComparer()).ToList();
        return sortedWords;
    }
    
    public List<string> StringOrderbyLengthThenbyCustom() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        List<string> sortedWords = words.OrderBy(w => w.Length).ThenBy(w=>w,new CaseInsensitiveComparer()).ToList();
        return sortedWords;
    }
    
    public List<string> StringOrderbyCustomThenbyLength() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        List<string> sortedWords = words.OrderBy(w => w,new CaseInsensitiveComparer())
            .ThenBy(w=>w.Length).ToList();
        return sortedWords;
    }
    
    public List<string> StringOrderbyLengthCustomThenbyCustom() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        List<string> sortedWords = words.OrderBy(w => w.Length,
            new CustomNumberComparer()).ThenBy(w=>w,new CaseInsensitiveComparer()).ToList();
        return sortedWords;
    }
    
    public List<string> StringOrderbyCustomThenbyLengthCustom() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        List<string> sortedWords = words.OrderBy(w => w,new CaseInsensitiveComparer())
            .ThenBy(w=>w.Length,new CustomNumberComparer()).ToList();
        return sortedWords;
    }
    
    public List<string> StringOrderbyThenbyLengthDescendingCustom() {
        string[] words = { "cherry", "apple", "blueberry","banana","abacus" };
        List<string> sortedWords = words.OrderBy(w => w)
            .ThenByDescending(w=>w.Length,new CustomNumberComparer()).ToList();
        return sortedWords;
    }
    
    public List<string> StringOrderbyLengthThenbyDescendingCustom() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        List<string> sortedWords = words.OrderBy(w => w.Length)
            .ThenByDescending(w=>w,new CaseInsensitiveComparer()).ToList();
        return sortedWords;
    }
    
    public List<string> StringOrderbyLengthCustomThenbyDescendingCustom() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        List<string> sortedWords = words.OrderBy(w => w.Length, new CustomNumberComparer()).
            ThenByDescending(w=>w,new CaseInsensitiveComparer()).ToList();
        return sortedWords;
    }
    
    public List<string> StringOrderbyCustomThenbyLengthDescendingCustom() {
        string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        List<string> sortedWords = words.OrderBy(w => w,new CaseInsensitiveComparer())
            .ThenByDescending(w=>w.Length,new CustomNumberComparer()).ToList();
        return sortedWords;
    }
    
    public List<Product> ProductOrderbyCategoryThenbyId() {
        List<Product> products = GetProductList();
        List<Product> sortedProducts = products.OrderBy(p => p.Category).ThenBy(p=>p.ProductId).ToList();
        return sortedProducts;
    }
    
    public List<Product> ProductOrderbyCategoryThenbyName() {
        List<Product> products = GetProductList();
        List<Product> sortedProducts = products.OrderBy(p => p.Category).ThenBy(p=>p.ProductName).ToList();
        return sortedProducts;
    }
    
    public List<Product> ProductOrderbyCategoryThenbyDescendingId() {
        List<Product> products = GetProductList();
        List<Product> sortedProducts = products.OrderBy(p => p.Category).ThenByDescending(p=>p.ProductId).ToList();
        return sortedProducts;
    }
    
    public List<Product> ProductOrderbyCategoryThenbyDescendingName() {
        List<Product> products = GetProductList();
        List<Product> sortedProducts = products.OrderBy(p => p.Category).ThenByDescending(p=>p.ProductName).ToList();
        return sortedProducts;
    }
    
    public List<Product> ExpensiveProductOrderbyCategoryThenbyId() {
        List<Product> products = GetProductList();
        List<Product> sortedProducts = products.Where(p=>p.UnitPrice>100).OrderBy(p => p.Category).ThenBy(p=>p.ProductId).ToList();
        return sortedProducts;
    }
    
    public List<Product> ExpensiveProductOrderbyCategoryThenbyName() {
        List<Product> products = GetProductList();
        List<Product> sortedProducts = products.Where(p=>p.UnitPrice>100).OrderBy(p => p.Category).ThenBy(p=>p.ProductName).ToList();
        return sortedProducts;
    }
    
    public List<Product> ProductOrderbyCategoryThenbyIdCustom() {
        List<Product> products = GetProductList();
        List<Product> sortedProducts = products.OrderBy(p => p.Category)
            .ThenBy(p=>p.ProductId,new CustomNumberComparer()).ToList();
        return sortedProducts;
    }
    
    public List<Product> ProductOrderbyCategoryThenbyNameCustom() {
        List<Product> products = GetProductList();
        List<Product> sortedProducts = products.OrderBy(p => p.Category)
            .ThenBy(p=>p.ProductName,new CaseInsensitiveComparer()).ToList();
        return sortedProducts;
    }
    
    public List<Product> ProductOrderbyCategoryThenbyDescendingIdCustom() {
        List<Product> products = GetProductList();
        List<Product> sortedProducts = products.OrderBy(p => p.Category)
            .ThenByDescending(p=>p.ProductId,new CustomNumberComparer()).ToList();
        return sortedProducts;
    }
    
    public List<Product> ProductOrderbyCategoryThenbyDescendingNameCustom() {
        List<Product> products = GetProductList();
        List<Product> sortedProducts = products.OrderBy(p => p.Category)
            .ThenByDescending(p=>p.ProductName,new CaseInsensitiveComparer()).ToList();
        return sortedProducts;
    }
    
    public List<Product> ExpensiveProductOrderbyCategoryThenbyIdCustom() {
        List<Product> products = GetProductList();
        List<Product> sortedProducts = products.Where(p=>p.UnitPrice>100).OrderBy(p => p.Category)
            .ThenBy(p=>p.ProductId,new CustomNumberComparer()).ToList();
        return sortedProducts;
    }
    
    public List<Product> ExpensiveProductOrderbyCategoryThenbyNameCustom() {
        List<Product> products = GetProductList();
        List<Product> sortedProducts = products.Where(p=>p.UnitPrice>100).OrderBy(p => p.Category)
            .ThenBy(p=>p.ProductName,new CaseInsensitiveComparer()).ToList();
        return sortedProducts;
    }
}