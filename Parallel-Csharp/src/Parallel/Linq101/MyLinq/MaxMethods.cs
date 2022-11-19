using Parallel.Linq101.DataSources;

namespace Parallel.Linq101.MyLinq;

public class MaxMethod {
    //original:4 target:40
    public List<Product> GetProductList() => Products.ProductList;
    public List<Customer> GetCustomerList() => Customers.CustomerList;

    //max syntax : 5

    public int NumbersMax() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int maxNum = numbers.Max();
        return maxNum;
    }

    public int BigNumbersMax() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int maxNum = numbers.Where(n => n > 5).Max();
        return maxNum;
    }

    public int OddNumbersMax() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int maxNum = numbers.Where(n => n % 2 == 1).Max();
        return maxNum;
    }

    public double DoubleMax() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        double maxNum = numbers.Max();
        return maxNum;
    }

    public double BigDoubleNumbersMax() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        double maxNum = numbers.Where(d => d > 5).Max();
        return maxNum;
    }


    //max projection: 15

    public int NumbersMaxTwice() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int maxNum = numbers.Max(n => n * 2);
        return maxNum;
    }

    public int BigNumbersMaxTwice() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int maxNum = numbers.Where(n => n > 5).Max(n => n * 2);
        return maxNum;
    }

    public int OddNumbersMaxTwice() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int maxNum = numbers.Where(n => n % 2 == 1).Max(n => n * 2);
        return maxNum;
    }

    public int StringMaxLength() {
        string[] words = { "cherry", "apple", "blueberry" };
        int maxLength = words.Max(w => w.Length);
        return maxLength;
    }

    public int ShortStringMaxLength() {
        string[] words = { "cherry", "apple", "blueberry" };
        int maxLength = words.Where(w => w.Length < 7).Max(w => w.Length);
        return maxLength;
    }

    public double ProductUnitPriceMax() {
        List<Product> products = GetProductList();
        double maxUnitPrice = products.Max(p => p.UnitPrice);
        return maxUnitPrice;
    }

    public double ExpensiveProductUnitPriceMax() {
        List<Product> products = GetProductList();
        double maxUnitPrice = products.Where(p => p.UnitPrice > 100).Max(p => p.UnitPrice);
        return maxUnitPrice;
    }

    public int ExpensiveProductStockMax() {
        List<Product> products = GetProductList();
        int maxUnitPrice = products.Where(p => p.UnitPrice > 100).Max(p => p.UnitsInStock);
        return maxUnitPrice;
    }

    public int ProductLongNameLengthMax() {
        List<Product> products = GetProductList();
        int maxUnitPrice = products.Select(p => p.ProductName)
            .Where(name => name.Length > 7).Max(name => name.Length);
        return maxUnitPrice;
    }

    public List<Tuple<string, double>> CustomerOrdersTotalMax() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, double>> ordersTotalMax = customers.Select(c => Tuple.Create(c.CustomerId,
            c.Orders.Max(o => o.Total))).ToList();
        return ordersTotalMax;
    }

    public Dictionary<string, double> CustomerOrdersTotalMaxDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, double> ordersTotalMax = customers.ToDictionary(c => c.CustomerId,
            c => c.Orders.Max(o => o.Total));
        return ordersTotalMax;
    }

    public List<Tuple<string, double>> CustomerInRegionOrdersTotalMax(string region) {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, double>> ordersTotalMax = customers.Where(c => c.Region.Equals(region))
            .Select(c => Tuple.Create(c.CustomerId,
                c.Orders.Max(o => o.Total))).ToList();
        return ordersTotalMax;
    }

    public Dictionary<string, double> CustomerInRegionOrdersTotalMaxDict(string region) {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, double> ordersTotalMax = customers.Where(c => c.Region.Equals(region))
            .ToDictionary(c => c.CustomerId,
                c => c.Orders.Max(o => o.Total));
        return ordersTotalMax;
    }

    public List<Tuple<string, double>> CustomerExpensiveOrdersTotalMax() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, double>> ordersTotalMax = customers.Select(c => Tuple.Create(c.CustomerId,
            c.Orders.Where(o => o.Total > 100).Max(o => o.Total))).ToList();
        return ordersTotalMax;
    }

    public Dictionary<string, double> CustomerExpensiveOrdersTotalMaxDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, double> ordersTotalMax = customers.ToDictionary(c => c.CustomerId,
            c => c.Orders.Where(o => o.Total > 100).Max(o => o.Total));
        return ordersTotalMax;
    }

    //max grouped: 10

    public List<Tuple<string, int>> ProductEachCategoryStock() {
        List<Product> products = GetProductList();
        List<Tuple<string, int>> categories = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key, g.Max(p => p.UnitsInStock))).ToList();
        return categories;
    }

    public Dictionary<string, int> ProductEachCategoryStockDict() {
        List<Product> products = GetProductList();
        Dictionary<string, int> categories = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key, g => g.Max(p => p.UnitsInStock));
        return categories;
    }

    public List<Tuple<string, int>> ExpensiveProductEachCategoryStock() {
        List<Product> products = GetProductList();
        List<Tuple<string, int>> categories = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key, g.Where(p => p.UnitPrice > 100)
                .Max(p => p.UnitsInStock))).ToList();
        return categories;
    }

    public Dictionary<string, int> ExpensiveProductEachCategoryStockDict() {
        List<Product> products = GetProductList();
        Dictionary<string, int> categories = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key, g =>
                g.Where(p => p.UnitPrice > 100).Max(p => p.UnitsInStock));
        return categories;
    }

    public List<Tuple<string, int>> CustomerEachRegionOrdersMax() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, int>> ordersMax = customers.GroupBy(c => c.Region)
            .Select(g => Tuple.Create(g.Key,
                g.Max(c => c.Orders.Length))).ToList();
        return ordersMax;
    }

    public Dictionary<string, int> CustomerEachRegionOrdersMaxDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, int> ordersMax = customers.GroupBy(c => c.Region)
            .ToDictionary(g => g.Key,
                g => g.Max(c => c.Orders.Length));
        return ordersMax;
    }

    public List<Tuple<string, int>> CustomerEachCountryOrdersMax() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, int>> ordersMax = customers.GroupBy(c => c.Country)
            .Select(g => Tuple.Create(g.Key,
                g.Max(c => c.Orders.Length))).ToList();
        return ordersMax;
    }

    public Dictionary<string, int> CustomerEachCountryOrdersMaxDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, int> ordersMax = customers.GroupBy(c => c.Country)
            .ToDictionary(g => g.Key,
                g => g.Max(c => c.Orders.Length));
        return ordersMax;
    }

    public List<Tuple<string, double>> CustomerEachRegionOrdersTotalMax() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, double>> ordersTotalMax = customers.GroupBy(c => c.Region)
            .Select(g => Tuple.Create(g.Key,
                g.SelectMany(c => c.Orders).Max(o => o.Total))).ToList();
        return ordersTotalMax;
    }

    public Dictionary<string, double> CustomerEachRegionOrdersTotalMaxDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, double> ordersTotalMax = customers.GroupBy(c => c.Region)
            .ToDictionary(g => g.Key,
                g => g.SelectMany(c => c.Orders).Max(o => o.Total));
        return ordersTotalMax;
    }
    
    //max each group: 10
    public List<Tuple<string, List<Product>>> ProductEachCategoryMaxUnitPriceProducts() {
        List<Product> products = GetProductList();
        List<Tuple<string, List<Product>>> categories = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key,
                g.Where(p => p.UnitPrice == g.Max(p => p.UnitPrice))
                    .ToList())).ToList();
        return categories;
    }
    
    public Dictionary<string, List<Product>> ProductEachCategoryMaxUnitPriceProductsDict() {
        List<Product> products = GetProductList();
        Dictionary<string, List<Product>> categories = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key,
                g=> g.Where(p => p.UnitPrice == g.Max(p => p.UnitPrice))
                    .ToList());
        return categories;
    }
    
    public List<Tuple<string, List<Product>>> ExpensiveProductEachCategoryMaxUnitPriceProducts() {
        List<Product> products = GetProductList();
        List<Tuple<string, List<Product>>> categories = products.Where(p=>p.UnitPrice>100).GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key,
                g.Where(p => p.UnitPrice == g.Max(p => p.UnitPrice))
                    .ToList())).ToList();
        return categories;
    }
    
    public Dictionary<string, List<Product>> ExpensiveProductEachCategoryMaxUnitPriceProductsDict() {
        List<Product> products = GetProductList();
        Dictionary<string, List<Product>> categories = products.Where(p=>p.UnitPrice>100).GroupBy(p => p.Category)
            .ToDictionary(g => g.Key,
                g=> g.Where(p => p.UnitPrice == g.Max(p => p.UnitPrice))
                    .ToList());
        return categories;
    }
    
    public List<Tuple<string, List<Customer>>> CustomerEachRegionOrdersMaxCustomer() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, List<Customer>>> customerOrdersMax = customers.GroupBy(c => c.Region)
            .Select(g => Tuple.Create(g.Key,
                g.Where(c => c.Orders.Length ==g.Max(c => c.Orders.Length)).ToList())).ToList();
        return customerOrdersMax;
    }

    public Dictionary<string, List<Customer>> CustomerEachRegionOrdersMaxCustomerDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, List<Customer>> customerOrdersMax = customers.GroupBy(c => c.Region)
            .ToDictionary(g => g.Key,
                g => g.Where(c => c.Orders.Length ==g.Max(c => c.Orders.Length)).ToList());
        return customerOrdersMax;
    }

    public List<Tuple<string, List<Customer>>> CustomerEachCountryOrdersMaxCustomer() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, List<Customer>>> customerOrdersMax = customers.GroupBy(c => c.Country)
            .Select(g => Tuple.Create(g.Key,
                g.Where(c => c.Orders.Length ==g.Max(c => c.Orders.Length)).ToList())).ToList();
        return customerOrdersMax;
    }

    public Dictionary<string, List<Customer>> CustomerEachCountryOrdersMaxCustomerDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, List<Customer>> customerOrdersMax = customers.GroupBy(c => c.Country)
            .ToDictionary(g => g.Key,
                g => g.Where(c => c.Orders.Length ==g.Max(c => c.Orders.Length)).ToList());
        return customerOrdersMax;
    }

    public List<Tuple<string, List<Order>>> CustomerEachRegionOrdersTotalMaxCustomer() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, List<Order>>> customerOrdersTotalMax = customers.GroupBy(c => c.Region)
            .Select(g => Tuple.Create(g.Key,
                g.SelectMany(c=>c.Orders).Where(
                    o=>o.Total == g.SelectMany(c=>c.Orders).Max(o => o.Total)).ToList())).ToList();
        return customerOrdersTotalMax;
    }

    public Dictionary<string, List<Order>> CustomerEachRegionOrdersTotalMaxCustomerDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, List<Order>> customerOrdersTotalMax = customers.GroupBy(c => c.Region)
            .ToDictionary(g => g.Key,
                g=>g.SelectMany(c => c.Orders).Where(
                    o => o.Total == g.SelectMany(c => c.Orders).Max(o => o.Total)).ToList());
        return customerOrdersTotalMax;
    }
}