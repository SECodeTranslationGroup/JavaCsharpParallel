using Parallel.Linq101.DataSources;

namespace Parallel.Linq101.MyLinq;

public class CountMethod {
    //original:4 target:40
    public List<Product> GetProductList() => Products.ProductList;
    public List<Customer> GetCustomerList() => Customers.CustomerList;

    //distinct count and conditional count : 20

    public int UniqueFactorOf300Count() {
        int[] factorsOf300 = { 2, 2, 3, 5, 5 };
        int uniqueFactorsCount = factorsOf300.Distinct().Count();
        return uniqueFactorsCount;
    }

    public int UniqueFactorsCount(int[] factors) {
        int factorsCount = factors.Distinct().Count();
        return factorsCount;
    }

    public int OddFactorOf300Count() {
        int[] factorsOf300 = { 2, 2, 3, 5, 5 };
        int factorsCount = factorsOf300.Count(n => n % 2 == 1);
        return factorsCount;
    }

    public int UniqueOddFactorOf300Count() {
        int[] factorsOf300 = { 2, 2, 3, 5, 5 };
        int uniqueFactorsCount = factorsOf300.Distinct().Count(n => n % 2 == 1);
        return uniqueFactorsCount;
    }

    public int OddNumbersCount(int[] numbers) {
        int oddNumbersCount = numbers.Count(n => n % 2 == 1);
        return oddNumbersCount;
    }

    public int DistinctOddNumbersCount(int[] numbers) {
        int oddNumbersCount = numbers.Distinct().Count(n => n % 2 == 1);
        return oddNumbersCount;
    }

    public int ExpensiveProductCount() {
        List<Product> products = GetProductList();
        int count = products.Count(p => p.UnitPrice > 100);
        return count;
    }

    public int CheapProductCount() {
        List<Product> products = GetProductList();
        int count = products.Count(p => p.UnitPrice < 100);
        return count;
    }

    public int DistinctProductCategoryCount() {
        List<Product> products = GetProductList();
        int count = products.Select(p => p.Category).Distinct().Count();
        return count;
    }

    public int ProductLongCategoryCount() {
        List<Product> products = GetProductList();
        int count = products.Select(p => p.Category).Count(c => c.Length > 8);
        return count;
    }

    public int ProductNameWithFirstLetterCount() {
        List<Product> products = GetProductList();
        int count = products.Select(p => p.ProductName).Count(c => c.StartsWith('c'));
        return count;
    }

    public int ProductOutOfStock() {
        List<Product> products = GetProductList();
        int count = products.Count(c => c.UnitsInStock == 0);
        return count;
    }

    public int DistinctProductLongCategoryCount() {
        List<Product> products = GetProductList();
        int count = products.Select(p => p.Category).Distinct().Count(c => c.Length > 8);
        return count;
    }

    public int CustomerDistinctRegionsCount() {
        List<Customer> customers = GetCustomerList();
        int count = customers.Select(c => c.Region).Distinct().Count();
        return count;
    }

    public int CustomerInRegionCount(string region) {
        List<Customer> customers = GetCustomerList();
        int count = customers.Count(c => c.Region.Equals(region));
        return count;
    }

    public int CustomerWithManyOrdersCount() {
        List<Customer> customers = GetCustomerList();
        int count = customers.Count(c => c.Orders.Count > 5);
        return count;
    }

    public int TotalOrdersCount(string region) {
        List<Customer> customers = GetCustomerList();
        int count = customers.SelectMany(c => c.Orders).Count();
        return count;
    }

    public int DistinctOrdersCount(string region) {
        List<Customer> customers = GetCustomerList();
        int count = customers.SelectMany(c => c.Orders).Distinct().Count();
        return count;
    }

    public int ExpensiveOrdersCount(string region) {
        List<Customer> customers = GetCustomerList();
        int count = customers.SelectMany(c => c.Orders).Count(o => o.Total > 100);
        return count;
    }

    public int NewOrdersCount(string region) {
        List<Customer> customers = GetCustomerList();
        int count = customers.SelectMany(c => c.Orders).Count(o => o.OrderDate
                                                                   > new DateTime(2000, 1, 1));
        return count;
    }

    //nested count : 10

    public int[] UniqueFactorOf300And900Count() {
        int[][] factorsOf300And900 = {
            new[] { 2, 2, 3, 5, 5 },
            new[] { 2, 2, 3, 3, 5, 5 }
        };
        int[] uniqueFactorsCount = factorsOf300And900.Select(
            a => a.Distinct().Count()).ToArray();
        return uniqueFactorsCount;
    }

    public int[] OddFactorOf300And900Count() {
        int[][] factorsOf300And900 = {
            new[] { 2, 2, 3, 5, 5 },
            new[] { 2, 2, 3, 3, 5, 5 }
        };
        int[] factorsCount = factorsOf300And900.Select(
            a => a.Count(n => n % 2 == 1)).ToArray();
        return factorsCount;
    }

    public int[] UniqueFactorsCount(int[][] factors) {
        int[] factorsCount = factors.Select(
            a => a.Distinct().Count()).ToArray();
        return factorsCount;
    }

    public int[] OddNumbersCount(int[][] numbers) {
        int[] oddNumbersCount = numbers.Select(
            a => a.Count(n => n % 2 == 1)).ToArray();
        return oddNumbersCount;
    }

    public List<Tuple<string, int>> CustomerDistinctOrdersCount() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, int>> orderCounts = customers.Select(c =>
            Tuple.Create(c.CustomerId, c.Orders.Distinct().Count())).ToList();
        return orderCounts;
    }

    public Dictionary<string, int> CustomerDistinctOrdersCountDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, int> orderCounts = customers.ToDictionary(
            c => c.CustomerId, c => c.Orders.Distinct().Count());
        return orderCounts;
    }

    public List<Tuple<string, int>> CustomerExpensiveOrdersCount() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, int>> orderCounts = customers.Select(c =>
            Tuple.Create(c.CustomerId, c.Orders.Count(o => o.Total > 100))).ToList();
        return orderCounts;
    }

    public Dictionary<string, int> CustomerExpensiveOrdersCountDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, int> orderCounts = customers.ToDictionary(
            c => c.CustomerId, c => c.Orders.Count(o => o.Total > 100));
        return orderCounts;
    }

    public List<Tuple<string, int>> CustomerNewOrdersCount() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, int>> orderCounts = customers.Select(c =>
            Tuple.Create(c.CustomerId, c.Orders.Count(
                o => o.OrderDate > new DateTime(2000, 1, 1)))).ToList();
        return orderCounts;
    }

    public Dictionary<string, int> CustomerNewOrdersCountDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, int> orderCounts = customers.ToDictionary(
            c => c.CustomerId, c => c.Orders.Count(
                o => o.OrderDate > new DateTime(2000, 1, 1)));
        return orderCounts;
    }
    
    //grouped count : 10
    
    public List<Tuple<int,int>> UniqueFactorOf300CountByOddEven() {
        int[] factorsOf300= {2, 2, 3, 5, 5 };
        List<Tuple<int,int>>  uniqueFactorsCount = factorsOf300.GroupBy(n=>n%2).Select(
            g=>Tuple.Create(g.Key,g.Distinct().Count())).ToList();
        return uniqueFactorsCount;
    }
    
    public Dictionary<int,int> UniqueFactorOf300CountByOddEvenDict() {
        int[] factorsOf300= {2, 2, 3, 5, 5 };
        Dictionary<int,int> uniqueFactorsCount = factorsOf300.GroupBy(n => n % 2).ToDictionary(
            g => g.Key, g => g.Distinct().Count());
        return uniqueFactorsCount;
    }

    public List<Tuple<String,int>> CountDistinctProductByCategory() {
        List<Product> products = GetProductList();
        List<Tuple<String,int>> categoryCounts = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key, g.Distinct().Count())).ToList();
        return categoryCounts;
    }
    
    public Dictionary<String,int> CountDistinctProductByCategoryDict() {
        List<Product> products = GetProductList();
        Dictionary<String,int> categoryCounts = products.GroupBy(p => p.Category)
            .ToDictionary(g=>g.Key,g => g.Distinct().Count());
        return categoryCounts;
    }
    
    public List<Tuple<bool,int>> CountExpensiveProductByInStock() {
        List<Product> products = GetProductList();
        List<Tuple<bool,int>> inStockCounts = products.GroupBy(p => p.UnitsInStock==0)
            .Select(g => Tuple.Create(g.Key, g.Count(p=>p.UnitPrice>100))).ToList();
        return inStockCounts;
    }
    
    public Dictionary<bool,int> CountExpensiveProductByInStockDict() {
        List<Product> products = GetProductList();
        Dictionary<bool,int> inStockCounts = products.GroupBy(p => p.UnitsInStock==0)
            .ToDictionary(g=>g.Key,g => g.Count(p=>p.UnitPrice>100));
        return inStockCounts;
    }
    
    public List<Tuple<String,int>> CountRegionDistinctCustomer() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<String,int>> regionCounts = customers.GroupBy(c=>c.Region)
            .Select(g=>Tuple.Create(g.Key,
                g.Distinct().Count())).ToList();
        return regionCounts;
    }
    
    public Dictionary<String,int> CountRegionDistinctCustomerDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<String,int> regionCounts = customers.GroupBy(c=>c.Region)
            .ToDictionary(g=>g.Key,
                g=>g.Distinct().Count());
        return regionCounts;
    }
    
    public List<Tuple<string,int>> CountRegionExpensiveOrders() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,int>> regionCounts = customers.GroupBy(c=>c.Region)
            .Select(g => Tuple.Create(g.Key, 
                g.SelectMany(c=>c.Orders).Count(o=>o.Total>100))).ToList();
        return regionCounts;
    }
    
    public Dictionary<string,int> CountRegionExpensiveOrdersDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string,int> regionCounts = customers.GroupBy(c=>c.Region)
            .ToDictionary(g => g.Key, 
                g=> g.SelectMany(c=>c.Orders).Count(o=>o.Total>100));
        return regionCounts;
    }
}