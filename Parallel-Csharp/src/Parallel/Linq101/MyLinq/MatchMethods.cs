using Parallel.Linq101.DataSources;

namespace Parallel.Linq101.MyLinq;

public class MatchMethods {
    public List<Product> GetProductList() => Products.ProductList;

    public List<Customer> GetCustomerList() => Customers.CustomerList;

    //original:4 target:40 form Quantifiers
    public bool IntAllMatch() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        bool allMatch = numbers.All(n => n > 3);
        return allMatch;
    }

    public bool OddIntAllMatch() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        bool allMatch = numbers.Where(i => i % 2 == 1).All(n => n > 3);
        return allMatch;
    }

    public bool IntSquareAllMatch() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        bool allMatch = numbers.Select(i => i * i).All(n => n > 3);
        return allMatch;
    }

    public bool IntAllMatchInput(int i) {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        bool allMatch = numbers.All(n => n > i);
        return allMatch;
    }

    public bool IntAllMatchInput(int[] numbers, int i) {
        bool allMatch = numbers.All(n => n > i);
        return allMatch;
    }

    public bool StringAllMatch() {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        bool allMatch = words.All(n => string.CompareOrdinal(n, "b") > 0);
        return allMatch;
    }

    public bool LongStringAllMatch() {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        bool allMatch = words.Where(w => w.Length > 5).All(n => string.CompareOrdinal(n, "b") > 0);
        return allMatch;
    }

    public bool StringLengthAllMatch() {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        bool allMatch = words.Select(w => w.Length).All(n => n > 5);
        return allMatch;
    }

    public bool StringAllMatch(char c) {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        bool allMatch = words.All(w => w[0] > c);
        return allMatch;
    }

    public bool StringAllMatchCount(string[] strings, char c) {
        bool allMatch = strings.All(w => w[0] > c);
        return allMatch;
    }

    public bool ProductAllMatch() {
        List<Product> products = GetProductList();
        bool allMatch = products.All(p => p.UnitsInStock > 0);
        return allMatch;
    }

    public bool ExpensiveProductAllMatch() {
        List<Product> products = GetProductList();
        bool allMatch = products.Where(p => p.UnitPrice > 100).All(p => p.UnitsInStock > 0);
        return allMatch;
    }

    public bool CategoryProductAllMatch() {
        List<Product> products = GetProductList();
        bool allMatch = products.Where(p => p.Category == "Beverages").All(p => p.UnitsInStock > 0);
        return allMatch;
    }

    public Dictionary<string, bool> ProductEachGroupAllMatch() {
        List<Product> products = GetProductList();
        Dictionary<string, bool> allMatch = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key, g => g.All(p => p.UnitsInStock > 0));
        return allMatch;
    }

    public Dictionary<string, bool> ExpensiveProductEachGroupAllMatch() {
        List<Product> products = GetProductList();
        Dictionary<string, bool> allMatch = products.Where(p => p.UnitPrice > 100).GroupBy(p => p.Category)
            .ToDictionary(g => g.Key, g => g.All(p => p.UnitsInStock > 0));
        return allMatch;
    }

    public bool CustomerOrdersAllMatch() {
        List<Customer> customers = GetCustomerList();
        bool allMatch = customers.SelectMany(c => c.Orders)
            .All(o => o.OrderDate > new DateTime(2000, 1, 1));
        return allMatch;
    }

    public bool CustomerOrdersNestedAllMatch() {
        List<Customer> customers = GetCustomerList();
        bool allMatch = customers.SelectMany(c => c.Orders, (c, o) => Tuple.Create(
            c.CustomerId, o.OrderDate)).All(t => t.Item2 > new DateTime(2000, 1, 1));
        return allMatch;
    }

    public List<bool> CustomerOrdersEachNestedAllMatch() {
        List<Customer> customers = GetCustomerList();
        List<bool> allMatch = customers.Select(c => c.Orders.All(o =>
            o.OrderDate > new DateTime(2000, 1, 1))).ToList();
        return allMatch;
    }

    public bool WaCustomerOrdersNestedAllMatch() {
        List<Customer> customers = GetCustomerList();
        bool allMatch = customers.Where(c=>c.Region=="WA").SelectMany(c => c.Orders, (c, o) => Tuple.Create(
            c.CustomerId, o.OrderDate)).All(t => t.Item2 > new DateTime(2000, 1, 1));
        return allMatch;
    }

    public List<bool> WaCustomerOrdersEachNestedAllMatch() {
        List<Customer> customers = GetCustomerList();
        List<bool> allMatch = customers.Where(c=>c.Region=="WA").Select(c => c.Orders.All(o =>
            o.OrderDate > new DateTime(2000, 1, 1))).ToList();
        return allMatch;
    }
    
     public bool IntAnyMatch() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        bool anyMatch = numbers.Any(n => n > 3);
        return anyMatch;
    }

    public bool OddIntAnyMatch() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        bool anyMatch = numbers.Where(i => i % 2 == 1).Any(n => n > 3);
        return anyMatch;
    }

    public bool IntSquareAnyMatch() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        bool anyMatch = numbers.Select(i => i * i).Any(n => n > 3);
        return anyMatch;
    }

    public bool IntAnyMatchInput(int i) {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        bool anyMatch = numbers.Any(n => n > i);
        return anyMatch;
    }

    public bool IntAnyMatchInput(int[] numbers, int i) {
        bool anyMatch = numbers.Any(n => n > i);
        return anyMatch;
    }

    public bool StringAnyMatch() {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        bool anyMatch = words.Any(n => string.CompareOrdinal(n, "b") > 0);
        return anyMatch;
    }

    public bool LongStringAnyMatch() {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        bool anyMatch = words.Where(w => w.Length > 5).Any(n => string.CompareOrdinal(n, "b") > 0);
        return anyMatch;
    }

    public bool StringLengthAnyMatch() {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        bool anyMatch = words.Select(w => w.Length).Any(n => n > 5);
        return anyMatch;
    }

    public bool StringAnyMatch(char c) {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        bool anyMatch = words.Any(w => w[0] > c);
        return anyMatch;
    }

    public bool StringAnyMatchCount(string[] strings, char c) {
        bool anyMatch = strings.Any(w => w[0] > c);
        return anyMatch;
    }

    public bool ProductAnyMatch() {
        List<Product> products = GetProductList();
        bool anyMatch = products.Any(p => p.UnitsInStock > 0);
        return anyMatch;
    }

    public bool ExpensiveProductAnyMatch() {
        List<Product> products = GetProductList();
        bool anyMatch = products.Where(p => p.UnitPrice > 100).Any(p => p.UnitsInStock > 0);
        return anyMatch;
    }

    public bool CategoryProductAnyMatch() {
        List<Product> products = GetProductList();
        bool anyMatch = products.Where(p => p.Category == "Beverages").Any(p => p.UnitsInStock > 0);
        return anyMatch;
    }

    public Dictionary<string, bool> ProductEachGroupAnyMatch() {
        List<Product> products = GetProductList();
        Dictionary<string, bool> anyMatch = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key, g => g.Any(p => p.UnitsInStock > 0));
        return anyMatch;
    }

    public Dictionary<string, bool> ExpensiveProductEachGroupAnyMatch() {
        List<Product> products = GetProductList();
        Dictionary<string, bool> anyMatch = products.Where(p => p.UnitPrice > 100).GroupBy(p => p.Category)
            .ToDictionary(g => g.Key, g => g.Any(p => p.UnitsInStock > 0));
        return anyMatch;
    }

    public bool CustomerOrdersAnyMatch() {
        List<Customer> customers = GetCustomerList();
        bool anyMatch = customers.SelectMany(c => c.Orders)
            .Any(o => o.OrderDate > new DateTime(2000, 1, 1));
        return anyMatch;
    }

    public bool CustomerOrdersNestedAnyMatch() {
        List<Customer> customers = GetCustomerList();
        bool anyMatch = customers.SelectMany(c => c.Orders, (c, o) => Tuple.Create(
            c.CustomerId, o.OrderDate)).Any(t => t.Item2 > new DateTime(2000, 1, 1));
        return anyMatch;
    }

    public List<bool> CustomerOrdersEachNestedAnyMatch() {
        List<Customer> customers = GetCustomerList();
        List<bool> anyMatch = customers.Select(c => c.Orders.Any(o =>
            o.OrderDate > new DateTime(2000, 1, 1))).ToList();
        return anyMatch;
    }

    public bool WaCustomerOrdersNestedAnyMatch() {
        List<Customer> customers = GetCustomerList();
        bool anyMatch = customers.Where(c=>c.Region=="WA").SelectMany(c => c.Orders, (c, o) => Tuple.Create(
            c.CustomerId, o.OrderDate)).Any(t => t.Item2 > new DateTime(2000, 1, 1));
        return anyMatch;
    }

    public List<bool> WaCustomerOrdersEachNestedAnyMatch() {
        List<Customer> customers = GetCustomerList();
        List<bool> anyMatch = customers.Where(c=>c.Region=="WA").Select(c => c.Orders.Any(o =>
            o.OrderDate > new DateTime(2000, 1, 1))).ToList();
        return anyMatch;
    }
}