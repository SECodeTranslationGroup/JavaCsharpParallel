using Parallel.Linq101.DataSources;

namespace Parallel.Linq101.MyLinq;

public class TakeMethods {
    public List<Product> GetProductList() => Products.ProductList;

    public List<Customer> GetCustomerList() => Customers.CustomerList;

    //original:4 target:45 form Partitions
    public List<int> IntTake() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> first3Numbers = numbers.Take(3).ToList();
        return first3Numbers;
    }

    public List<int> OddIntTake() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> first3Numbers = numbers.Where(i => i % 2 == 1).Take(3).ToList();
        return first3Numbers;
    }

    public List<int> IntSquareTake() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> first3Numbers = numbers.Select(i => i * i).Take(3).ToList();
        return first3Numbers;
    }

    public List<int> IntTakeCount(int n) {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> first3Numbers = numbers.Take(n).ToList();
        return first3Numbers;
    }

    public List<int> IntTakeCount(int[] numbers, int n) {
        List<int> firstNNumbers = numbers.Take(n).ToList();
        return firstNNumbers;
    }

    public List<string> StringTake() {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        List<string> firstNNumbers = words.Take(3).ToList();
        return firstNNumbers;
    }

    public List<string> LongStringTake() {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        List<string> first3Words = words.Where(w => w.Length > 5).Take(3).ToList();
        return first3Words;
    }

    public List<int> StringLengthTake() {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        List<int> first3Words = words.Select(w => w.Length).Take(3).ToList();
        return first3Words;
    }

    public List<string> StringTakeCount(int n) {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        List<string> firstNWords = words.Take(n).ToList();
        return firstNWords;
    }

    public List<string> StringTakeCount(string[] strings, int n) {
        List<string> firstNWords = strings.Take(n).ToList();
        return firstNWords;
    }

    public List<Product> ProductTake() {
        List<Product> products = GetProductList();
        List<Product> first3Products = products.Take(3).ToList();
        return first3Products;
    }

    public List<Product> ExpensiveProductTake() {
        List<Product> products = GetProductList();
        List<Product> first3Products = products.Where(p => p.UnitPrice > 100).Take(3).ToList();
        return first3Products;
    }

    public List<Product> InStockProductTake() {
        List<Product> products = GetProductList();
        List<Product> first3Products = products.Where(p => p.UnitsInStock > 0).Take(3).ToList();
        return first3Products;
    }

    public Dictionary<string, List<Product>> ProductGroupTake() {
        List<Product> products = GetProductList();
        Dictionary<string, List<Product>> first3Groups = products.GroupBy(p => p.Category)
            .Take(3).ToDictionary(g => g.Key, g => g.ToList());
        return first3Groups;
    }

    public Dictionary<string, List<Product>> ProductEachGroupTake() {
        List<Product> products = GetProductList();
        Dictionary<string, List<Product>> first3EachGroups = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key, g => g.Take(3).ToList());
        return first3EachGroups;
    }

    public List<Order> CustomerOrdersTake() {
        List<Customer> customers = GetCustomerList();
        List<Order> first3Orders = customers.SelectMany(c => c.Orders)
            .Take(3).ToList();
        return first3Orders;
    }

    public List<Tuple<string, DateTime>> CustomerOrdersNestedTake() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, DateTime>> first3Orders = customers.SelectMany(c => c.Orders, (c, o) => Tuple.Create(
            c.CustomerId, o.OrderDate)).Take(3).ToList();
        return first3Orders;
    }

    public List<Tuple<string, DateTime>> CustomerOrdersEachNestedTake() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, DateTime>> first3EachOrders = customers
            .SelectMany(c => c.Orders.Take(3), (c, o) => Tuple.Create(
                c.CustomerId, o.OrderDate)).ToList();
        return first3EachOrders;
    }

    public List<Tuple<string, DateTime>> WaCustomerOrdersNestedTake() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, DateTime>> first3WAOrders = customers.Where(c => c.Region == "WA")
            .SelectMany(c => c.Orders, (c, o) => Tuple.Create(
                c.CustomerId, o.OrderDate)).Take(3).ToList();
        return first3WAOrders;
    }

    public List<Tuple<string, DateTime>> WaCustomerOrdersEachNestedTake() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, DateTime>> first3EachWAOrders = customers.Where(c => c.Region == "WA")
            .SelectMany(c => c.Orders.Take(3), (c, o) => Tuple.Create(
                c.CustomerId, o.OrderDate)).ToList();
        return first3EachWAOrders;
    }

    public List<int> IntTakeWhile() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> firstNumbersWhile = numbers.TakeWhile(i => i > 3).ToList();
        return firstNumbersWhile;
    }

    public List<int> OddIntTakeWhile() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> firstNumbersWhile = numbers.Where(i => i % 2 == 1).TakeWhile(i => i > 3).ToList();
        return firstNumbersWhile;
    }

    public List<int> IntSquareTakeWhile() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> firstNumbersWhile = numbers.Select(i => i * i).TakeWhile(i => i > 3).ToList();
        return firstNumbersWhile;
    }

    public List<int> IntTakeWhileCount(int n) {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> firstNumbersWhile = numbers.TakeWhile(i => i > n).ToList();
        return firstNumbersWhile;
    }

    public List<int> IntTakeWhileCount(int[] numbers, int n) {
        List<int> firstNumbersWhile = numbers.TakeWhile(i => i > n).ToList();
        return firstNumbersWhile;
    }

    public List<string> StringTakeWhile() {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        List<string> firstWordsWhile = words.TakeWhile(w => w[0] > 'b').ToList();
        return firstWordsWhile;
    }

    public List<string> LongStringTakeWhile() {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        List<string> firstWordsWhile = words.Where(w => w.Length > 5).TakeWhile(w => w[0] > 'b').ToList();
        return firstWordsWhile;
    }

    public List<int> StringLengthTakeWhile() {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        List<int> firstWordsWhile = words.Select(w => w.Length).TakeWhile(n => n > 5).ToList();
        return firstWordsWhile;
    }

    public List<string> StringTakeWhileCount(char c) {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        List<string> firstWordsWhile = words.TakeWhile(w => w[0] > c).ToList();
        return firstWordsWhile;
    }

    public List<string> StringTakeWhileCount(string[] strings, char c) {
        List<string> firstWordsWhile = strings.TakeWhile(w => w[0] > c).ToList();
        return firstWordsWhile;
    }

    public List<Product> ProductTakeWhile() {
        List<Product> products = GetProductList();
        List<Product> firstProductsWhile = products.TakeWhile(p => p.ProductId > 100).ToList();
        return firstProductsWhile;
    }

    public List<Product> ExpensiveProductTakeWhile() {
        List<Product> products = GetProductList();
        List<Product> firstProductsWhile =
            products.Where(p => p.UnitPrice > 100).TakeWhile(p => p.ProductId > 100).ToList();
        return firstProductsWhile;
    }

    public List<Product> InStockProductTakeWhile() {
        List<Product> products = GetProductList();
        List<Product> firstProductsWhile =
            products.Where(p => p.UnitsInStock > 0).TakeWhile(p => p.ProductId > 100).ToList();
        return firstProductsWhile;
    }

    public Dictionary<string, List<Product>> ProductGroupTakeWhile() {
        List<Product> products = GetProductList();
        Dictionary<string, List<Product>> firstGroupsWhile = products.GroupBy(p => p.Category)
            .TakeWhile(g => g.Key.Length > 6).ToDictionary(g => g.Key, g => g.ToList());
        return firstGroupsWhile;
    }

    public Dictionary<string, List<Product>> ProductEachGroupTakeWhile() {
        List<Product> products = GetProductList();
        Dictionary<string, List<Product>> firstEachGroupsWhile = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key, g => g.TakeWhile(p => p.ProductId > 100).ToList());
        return firstEachGroupsWhile;
    }

    public List<Order> CustomerOrdersTakeWhile() {
        List<Customer> customers = GetCustomerList();
        List<Order> firstOrdersWhile = customers.SelectMany(c => c.Orders)
            .TakeWhile(o => o.OrderDate > new DateTime(2000, 1, 1)).ToList();
        return firstOrdersWhile;
    }

    public List<Tuple<string, DateTime>> CustomerOrdersNestedTakeWhile() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, DateTime>> firstOrdersWhile = customers.SelectMany(c => c.Orders, (c, o) => Tuple.Create(
            c.CustomerId, o.OrderDate)).TakeWhile(t => t.Item2 > new DateTime(
            2000, 1, 1)).ToList();
        return firstOrdersWhile;
    }

    public List<Tuple<string, DateTime>> CustomerOrdersEachNestedTakeWhile() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, DateTime>> firstOrdersEachWhile = customers
            .SelectMany(c => c.Orders.TakeWhile(o => o.OrderDate > new DateTime(
                2000, 1, 1)), (c, o) => Tuple.Create(
                c.CustomerId, o.OrderDate)).ToList();
        return firstOrdersEachWhile;
    }

    public List<Tuple<string, DateTime>> WaCustomerOrdersNestedTakeWhile() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, DateTime>> firstOrdersWhile = customers.Where(c => c.Region == "WA")
            .SelectMany(c => c.Orders, (c, o) => Tuple.Create(
                c.CustomerId, o.OrderDate)).TakeWhile(t => t.Item2 > new DateTime(
                2000, 1, 1)).ToList();
        return firstOrdersWhile;
    }

    public List<Tuple<string, DateTime>> WaCustomerOrdersEachNestedTakeWhile() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, DateTime>> firstOrdersEachWhile = customers.Where(c => c.Region == "WA")
            .SelectMany(c => c.Orders.TakeWhile(o => o.OrderDate > new DateTime(
                2000, 1, 1)), (c, o) => Tuple.Create(
                c.CustomerId, o.OrderDate)).ToList();
        return firstOrdersEachWhile;
    }

    public List<int> IntTakeWhileIndexed() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> firstNumbers = numbers.TakeWhile((n, index) => n > index).ToList();
        return firstNumbers;
    }
    public List<int> IntSquareTakeWhileIndexed() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> firstNumbers = numbers.Select(i => i * i).TakeWhile((n, index) => n > index).ToList();
        return firstNumbers;
    }
    
    public List<double> IntSqrtSkipWhileIndexed() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<double> afterNumbers = numbers.Select(i => Math.Sqrt(i)).TakeWhile((n, index) => n > index).ToList();
        return afterNumbers;
    }

    public List<int> IntTakeWhileIndexedCount(int n) {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> firstNumbers = numbers.TakeWhile((n, index) => n > index).ToList();
        return firstNumbers;
    }

    public List<int> IntTakeWhileIndexedCount(int[] numbers, int n) {
        List<int> firstNumbers = numbers.TakeWhile((n, index) => n > index).ToList();
        return firstNumbers;
    }
}