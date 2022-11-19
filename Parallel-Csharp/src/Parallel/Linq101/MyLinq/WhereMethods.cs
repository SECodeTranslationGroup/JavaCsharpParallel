using Parallel.Linq101.DataSources;

namespace Parallel.Linq101.MyLinq; 

public class WhereMethods {
    public List<Product> GetProductList() => Products.ProductList;
    public List<Customer> GetCustomerList() => Customers.CustomerList;
    
    //original:5 target:10 just indexed where form Restrictions
    public List<int> IntIndexedWhere() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> q = numbers.Where((n,index)=>n<index).ToList();
        return q;
    }
    
    public List<int> OddIntIndexedWhere() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> q = numbers.Where(i => i % 2 == 1).Where((n,index)=>n<index).ToList();
        return q;
    }
    
    public List<int> OddIntOriginalIndexedWhere() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> q = numbers.Where((n,index)=>n<index&&n % 2 == 1).ToList();
        return q;
    }
    public List<int> IntSquareIndexedWhere() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> q = numbers.Select(i => i * i).Where((n,index)=>n<index).ToList();
        return q;
    }
    
    public List<int> IntWithSquareIndexedWhere() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> q = numbers.Where((n,index)=>n<index*index).ToList();
        return q;
    }

    public List<string> StringIndexedWhere() {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        List<string> q = words.Where((w,index)=>w.Length<index).ToList();
        return q;
    }

    public List<string> LongStringIndexedWhere() {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        List<string> q =words.Where(w=>w.Length>5).Where((w,index)=>w.Length<index*3).ToList();
        return q;
    }

    public List<string> LongStringOrginalIndexedWhere() {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        List<string> q = words.Where((w,index)=>w.Length<index*3&&w.Length>5).ToList();
        return q;
    }
    
    public List<Product> ProductIndexedWhere() {
        List<Product> products = GetProductList();
        List<Product> q = products.Where((w,index)=>w.UnitsInStock>0&&index%2==1).ToList();
        return q;
    }
    
    public List<Product> ExpensiveProductIndexedWhere() {
        List<Product> products = GetProductList();
        List<Product> q = products.Where((w,index)=>w.UnitPrice>100&&index%2==1).ToList();
        return q;
    }
}