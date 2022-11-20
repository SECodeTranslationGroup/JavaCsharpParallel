using Parallel.Linq101.DataSources;

namespace Parallel.Linq101.MyLinq;

public class SkipMethods {
    public List<Product> GetProductList() => Products.ProductList;

    public List<Customer> GetCustomerList() => Customers.CustomerList;

    //original:4 target:45 form Partitions
    public List<int> IntSkip() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> after3Numbers = numbers.Skip(3).ToList();
        return after3Numbers;
    }

    public List<int> OddIntSkip() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> after3Numbers = numbers.Where(i => i % 2 == 1).Skip(3).ToList();
        return after3Numbers;
    }

    public List<int> IntSquareSkip() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> after3Numbers = numbers.Select(i => i * i).Skip(3).ToList();
        return after3Numbers;
    }

    public List<int> IntSkipCount(int n) {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> after3Numbers = numbers.Skip(n).ToList();
        return after3Numbers;
    }

    public List<int> IntSkipCount(int[] numbers, int n) {
        List<int> afterNNumbers = numbers.Skip(n).ToList();
        return afterNNumbers;
    }

    public List<string> StringSkip() {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        List<string> afterNNumbers = words.Skip(3).ToList();
        return afterNNumbers;
    }

    public List<string> LongStringSkip() {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        List<string> after3Words = words.Where(w => w.Length > 5).Skip(3).ToList();
        return after3Words;
    }

    public List<int> StringLengthSkip() {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        List<int> after3Words = words.Select(w => w.Length).Skip(3).ToList();
        return after3Words;
    }

    public List<string> StringSkipCount(int n) {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        List<string> afterNWords = words.Skip(n).ToList();
        return afterNWords;
    }

    public List<string> StringSkipCount(string[] strings, int n) {
        List<string> afterNWords = strings.Skip(n).ToList();
        return afterNWords;
    }

    public List<Product> ProductSkip() {
        List<Product> products = GetProductList();
        List<Product> after3Products = products.Skip(3).ToList();
        return after3Products;
    }

    public List<Product> ExpensiveProductSkip() {
        List<Product> products = GetProductList();
        List<Product> after3Products = products.Where(p => p.UnitPrice > 100).Skip(3).ToList();
        return after3Products;
    }

    public List<Product> InStockProductSkip() {
        List<Product> products = GetProductList();
        List<Product> after3Products = products.Where(p => p.UnitsInStock > 0).Skip(3).ToList();
        return after3Products;
    }

    public Dictionary<string, List<Product>> ProductGroupSkip() {
        List<Product> products = GetProductList();
        Dictionary<string, List<Product>> after3Groups = products.GroupBy(p => p.Category)
            .Skip(3).ToDictionary(g => g.Key, g => g.ToList());
        return after3Groups;
    }

    public Dictionary<string, List<Product>> ProductEachGroupSkip() {
        List<Product> products = GetProductList();
        Dictionary<string, List<Product>> after3EachGroups = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key, g => g.Skip(3).ToList());
        return after3EachGroups;
    }

    public List<Order> CustomerOrdersSkip() {
        List<Customer> customers = GetCustomerList();
        List<Order> after3Orders = customers.SelectMany(c => c.Orders)
            .Skip(3).ToList();
        return after3Orders;
    }

    public List<Tuple<string, DateTime>> CustomerOrdersNestedSkip() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, DateTime>> after3Orders = customers.SelectMany(c => c.Orders, (c, o) => Tuple.Create(
            c.CustomerId, o.OrderDate)).Skip(3).ToList();
        return after3Orders;
    }

    public List<Tuple<string, DateTime>> CustomerOrdersEachNestedSkip() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, DateTime>> after3EachOrders = customers
            .SelectMany(c => c.Orders.Skip(3), (c, o) => Tuple.Create(
                c.CustomerId, o.OrderDate)).ToList();
        return after3EachOrders;
    }

    public List<Tuple<string, DateTime>> WaCustomerOrdersNestedSkip() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, DateTime>> after3WAOrders = customers.Where(c => c.Region == "WA")
            .SelectMany(c => c.Orders, (c, o) => Tuple.Create(
                c.CustomerId, o.OrderDate)).Skip(3).ToList();
        return after3WAOrders;
    }

    public List<Tuple<string, DateTime>> WaCustomerOrdersEachNestedSkip() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, DateTime>> after3EachWAOrders = customers.Where(c => c.Region == "WA")
            .SelectMany(c => c.Orders.Skip(3), (c, o) => Tuple.Create(
                c.CustomerId, o.OrderDate)).ToList();
        return after3EachWAOrders;
    }

    public List<int> IntSkipWhile() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> afterNumbersWhile = numbers.SkipWhile(i => i > 3).ToList();
        return afterNumbersWhile;
    }

    public List<int> OddIntSkipWhile() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> afterNumbersWhile = numbers.Where(i => i % 2 == 1).SkipWhile(i => i > 3).ToList();
        return afterNumbersWhile;
    }

    public List<int> IntSquareSkipWhile() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> afterNumbersWhile = numbers.Select(i => i * i).SkipWhile(i => i > 3).ToList();
        return afterNumbersWhile;
    }

    public List<int> IntSkipWhileCount(int n) {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> afterNumbersWhile = numbers.SkipWhile(i => i > n).ToList();
        return afterNumbersWhile;
    }

    public List<int> IntSkipWhileCount(int[] numbers, int n) {
        List<int> afterNumbersWhile = numbers.SkipWhile(i => i > n).ToList();
        return afterNumbersWhile;
    }

    public List<string> StringSkipWhile() {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        List<string> afterWordsWhile = words.SkipWhile(w => w[0] > 'b').ToList();
        return afterWordsWhile;
    }

    public List<string> LongStringSkipWhile() {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        List<string> afterWordsWhile = words.Where(w => w.Length > 5).SkipWhile(w => w[0] > 'b').ToList();
        return afterWordsWhile;
    }

    public List<int> StringLengthSkipWhile() {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        List<int> afterWordsWhile = words.Select(w => w.Length).SkipWhile(n => n > 5).ToList();
        return afterWordsWhile;
    }

    public List<string> StringSkipWhileCount(char c) {
        string[] words = { "cherry", "apple", "blueberry", "banana", "abacus" };
        List<string> afterWordsWhile = words.SkipWhile(w => w[0] > c).ToList();
        return afterWordsWhile;
    }

    public List<string> StringSkipWhileCount(string[] strings, char c) {
        List<string> afterWordsWhile = strings.SkipWhile(w => w[0] > c).ToList();
        return afterWordsWhile;
    }

    public List<Product> ProductSkipWhile() {
        List<Product> products = GetProductList();
        List<Product> afterProductsWhile = products.SkipWhile(p => p.ProductId > 100).ToList();
        return afterProductsWhile;
    }

    public List<Product> ExpensiveProductSkipWhile() {
        List<Product> products = GetProductList();
        List<Product> afterProductsWhile =
            products.Where(p => p.UnitPrice > 100).SkipWhile(p => p.ProductId > 100).ToList();
        return afterProductsWhile;
    }

    public List<Product> InStockProductSkipWhile() {
        List<Product> products = GetProductList();
        List<Product> afterProductsWhile =
            products.Where(p => p.UnitsInStock > 0).SkipWhile(p => p.ProductId > 100).ToList();
        return afterProductsWhile;
    }

    public Dictionary<string, List<Product>> ProductGroupSkipWhile() {
        List<Product> products = GetProductList();
        Dictionary<string, List<Product>> afterGroupsWhile = products.GroupBy(p => p.Category)
            .SkipWhile(g => g.Key.Length > 6).ToDictionary(g => g.Key, g => g.ToList());
        return afterGroupsWhile;
    }

    public Dictionary<string, List<Product>> ProductEachGroupSkipWhile() {
        List<Product> products = GetProductList();
        Dictionary<string, List<Product>> afterEachGroupsWhile = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key, g => g.SkipWhile(p => p.ProductId > 100).ToList());
        return afterEachGroupsWhile;
    }

    public List<Order> CustomerOrdersSkipWhile() {
        List<Customer> customers = GetCustomerList();
        List<Order> afterOrdersWhile = customers.SelectMany(c => c.Orders)
            .SkipWhile(o => o.OrderDate > new DateTime(2000, 1, 1)).ToList();
        return afterOrdersWhile;
    }

    public List<Tuple<string, DateTime>> CustomerOrdersNestedSkipWhile() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, DateTime>> afterOrdersWhile = customers.SelectMany(c => c.Orders, (c, o) => Tuple.Create(
            c.CustomerId, o.OrderDate)).SkipWhile(t => t.Item2 > new DateTime(
            2000, 1, 1)).ToList();
        return afterOrdersWhile;
    }

    public List<Tuple<string, DateTime>> CustomerOrdersEachNestedSkipWhile() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, DateTime>> afterOrdersEachWhile = customers
            .SelectMany(c => c.Orders.SkipWhile(o => o.OrderDate > new DateTime(
                2000, 1, 1)), (c, o) => Tuple.Create(
                c.CustomerId, o.OrderDate)).ToList();
        return afterOrdersEachWhile;
    }

    public List<Tuple<string, DateTime>> WaCustomerOrdersNestedSkipWhile() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, DateTime>> afterOrdersWhile = customers.Where(c => c.Region == "WA")
            .SelectMany(c => c.Orders, (c, o) => Tuple.Create(
                c.CustomerId, o.OrderDate)).SkipWhile(t => t.Item2 > new DateTime(
                2000, 1, 1)).ToList();
        return afterOrdersWhile;
    }

    public List<Tuple<string, DateTime>> WaCustomerOrdersEachNestedSkipWhile() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, DateTime>> afterOrdersEachWhile = customers.Where(c => c.Region == "WA")
            .SelectMany(c => c.Orders.SkipWhile(o => o.OrderDate > new DateTime(
                2000, 1, 1)), (c, o) => Tuple.Create(
                c.CustomerId, o.OrderDate)).ToList();
        return afterOrdersEachWhile;
    }

    public List<int> IntSkipWhileIndexed() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> afterNumbers = numbers.SkipWhile((n, index) => n > index).ToList();
        return afterNumbers;
    }
    public List<int> IntSquareSkipWhileIndexed() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> afterNumbers = numbers.Select(i => i * i).SkipWhile((n, index) => n > index).ToList();
        return afterNumbers;
    }
    
    public List<double> IntSqrtSkipWhileIndexed() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<double> afterNumbers = numbers.Select(i => Math.Sqrt(i)).SkipWhile((n, index) => n > index).ToList();
        return afterNumbers;
    }


    public List<int> IntSkipWhileIndexedCount(int n) {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<int> afterNumbers = numbers.SkipWhile((n, index) => n > index).ToList();
        return afterNumbers;
    }

    public List<int> IntSkipWhileIndexedCount(int[] numbers, int n) {
        List<int> afterNumbers = numbers.SkipWhile((n, index) => n > index).ToList();
        return afterNumbers;
    }
}