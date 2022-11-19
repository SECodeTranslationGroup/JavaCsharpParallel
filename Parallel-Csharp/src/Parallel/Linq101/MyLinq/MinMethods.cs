using Parallel.Linq101.DataSources;

namespace Parallel.Linq101.MyLinq;

public class MinMethod {
    //original:4 target:40
    public List<Product> GetProductList() => Products.ProductList;
    public List<Customer> GetCustomerList() => Customers.CustomerList;

    //min syntax : 5

    public int NumbersMin() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int minNum = numbers.Min();
        return minNum;
    }

    public int BigNumbersMin() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int minNum = numbers.Where(n => n > 5).Min();
        return minNum;
    }

    public int OddNumbersMin() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int minNum = numbers.Where(n => n % 2 == 1).Min();
        return minNum;
    }

    public double DoubleMin() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        double minNum = numbers.Min();
        return minNum;
    }

    public double BigDoubleNumbersMin() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        double minNum = numbers.Where(d => d > 5).Min();
        return minNum;
    }


    //min projection: 15

    public int NumbersMinTwice() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int minNum = numbers.Min(n => n * 2);
        return minNum;
    }

    public int BigNumbersMinTwice() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int minNum = numbers.Where(n => n > 5).Min(n => n * 2);
        return minNum;
    }

    public int OddNumbersMinTwice() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int minNum = numbers.Where(n => n % 2 == 1).Min(n => n * 2);
        return minNum;
    }

    public int StringMinLength() {
        string[] words = { "cherry", "apple", "blueberry" };
        int minLength = words.Min(w => w.Length);
        return minLength;
    }

    public int ShortStringMinLength() {
        string[] words = { "cherry", "apple", "blueberry" };
        int minLength = words.Where(w => w.Length < 7).Min(w => w.Length);
        return minLength;
    }

    public double ProductUnitPriceMin() {
        List<Product> products = GetProductList();
        double minUnitPrice = products.Min(p => p.UnitPrice);
        return minUnitPrice;
    }

    public double ExpensiveProductUnitPriceMin() {
        List<Product> products = GetProductList();
        double minUnitPrice = products.Where(p => p.UnitPrice > 100).Min(p => p.UnitPrice);
        return minUnitPrice;
    }

    public int ExpensiveProductStockMin() {
        List<Product> products = GetProductList();
        int minUnitPrice = products.Where(p => p.UnitPrice > 100).Min(p => p.UnitsInStock);
        return minUnitPrice;
    }

    public int ProductLongNameLengthMin() {
        List<Product> products = GetProductList();
        int minUnitPrice = products.Select(p => p.ProductName)
            .Where(name => name.Length > 7).Min(name => name.Length);
        return minUnitPrice;
    }

    public List<Tuple<string, double>> CustomerOrdersTotalMin() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, double>> ordersTotalMin = customers.Select(c => Tuple.Create(c.CustomerId,
            c.Orders.Min(o => o.Total))).ToList();
        return ordersTotalMin;
    }

    public Dictionary<string, double> CustomerOrdersTotalMinDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, double> ordersTotalMin = customers.ToDictionary(c => c.CustomerId,
            c => c.Orders.Min(o => o.Total));
        return ordersTotalMin;
    }

    public List<Tuple<string, double>> CustomerInRegionOrdersTotalMin(string region) {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, double>> ordersTotalMin = customers.Where(c => c.Region.Equals(region))
            .Select(c => Tuple.Create(c.CustomerId,
                c.Orders.Min(o => o.Total))).ToList();
        return ordersTotalMin;
    }

    public Dictionary<string, double> CustomerInRegionOrdersTotalMinDict(string region) {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, double> ordersTotalMin = customers.Where(c => c.Region.Equals(region))
            .ToDictionary(c => c.CustomerId,
                c => c.Orders.Min(o => o.Total));
        return ordersTotalMin;
    }

    public List<Tuple<string, double>> CustomerExpensiveOrdersTotalMin() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, double>> ordersTotalMin = customers.Select(c => Tuple.Create(c.CustomerId,
            c.Orders.Where(o => o.Total > 100).Min(o => o.Total))).ToList();
        return ordersTotalMin;
    }

    public Dictionary<string, double> CustomerExpensiveOrdersTotalMinDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, double> ordersTotalMin = customers.ToDictionary(c => c.CustomerId,
            c => c.Orders.Where(o => o.Total > 100).Min(o => o.Total));
        return ordersTotalMin;
    }

    //min grouped: 10

    public List<Tuple<string, int>> ProductEachCategoryStock() {
        List<Product> products = GetProductList();
        List<Tuple<string, int>> categories = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key, g.Min(p => p.UnitsInStock))).ToList();
        return categories;
    }

    public Dictionary<string, int> ProductEachCategoryStockDict() {
        List<Product> products = GetProductList();
        Dictionary<string, int> categories = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key, g => g.Min(p => p.UnitsInStock));
        return categories;
    }

    public List<Tuple<string, int>> ExpensiveProductEachCategoryStock() {
        List<Product> products = GetProductList();
        List<Tuple<string, int>> categories = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key, g.Where(p => p.UnitPrice > 100)
                .Min(p => p.UnitsInStock))).ToList();
        return categories;
    }

    public Dictionary<string, int> ExpensiveProductEachCategoryStockDict() {
        List<Product> products = GetProductList();
        Dictionary<string, int> categories = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key, g =>
                g.Where(p => p.UnitPrice > 100).Min(p => p.UnitsInStock));
        return categories;
    }

    public List<Tuple<string, int>> CustomerEachRegionOrdersMin() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, int>> ordersMin = customers.GroupBy(c => c.Region)
            .Select(g => Tuple.Create(g.Key,
                g.Min(c => c.Orders.Length))).ToList();
        return ordersMin;
    }

    public Dictionary<string, int> CustomerEachRegionOrdersMinDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, int> ordersMin = customers.GroupBy(c => c.Region)
            .ToDictionary(g => g.Key,
                g => g.Min(c => c.Orders.Length));
        return ordersMin;
    }

    public List<Tuple<string, int>> CustomerEachCountryOrdersMin() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, int>> ordersMin = customers.GroupBy(c => c.Country)
            .Select(g => Tuple.Create(g.Key,
                g.Min(c => c.Orders.Length))).ToList();
        return ordersMin;
    }

    public Dictionary<string, int> CustomerEachCountryOrdersMinDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, int> ordersMin = customers.GroupBy(c => c.Country)
            .ToDictionary(g => g.Key,
                g => g.Min(c => c.Orders.Length));
        return ordersMin;
    }

    public List<Tuple<string, double>> CustomerEachRegionOrdersTotalMin() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, double>> ordersTotalMin = customers.GroupBy(c => c.Region)
            .Select(g => Tuple.Create(g.Key,
                g.SelectMany(c => c.Orders).Min(o => o.Total))).ToList();
        return ordersTotalMin;
    }

    public Dictionary<string, double> CustomerEachRegionOrdersTotalMinDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, double> ordersTotalMin = customers.GroupBy(c => c.Region)
            .ToDictionary(g => g.Key,
                g => g.SelectMany(c => c.Orders).Min(o => o.Total));
        return ordersTotalMin;
    }

    //min each group: 10
    public List<Tuple<string, List<Product>>> ProductEachCategoryMinUnitPriceProducts() {
        List<Product> products = GetProductList();
        List<Tuple<string, List<Product>>> categories = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key,
                g.Where(p => p.UnitPrice == g.Min(p => p.UnitPrice))
                    .ToList())).ToList();
        return categories;
    }
    
    public Dictionary<string, List<Product>> ProductEachCategoryMinUnitPriceProductsDict() {
        List<Product> products = GetProductList();
        Dictionary<string, List<Product>> categories = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key,
                g=> g.Where(p => p.UnitPrice == g.Min(p => p.UnitPrice))
                    .ToList());
        return categories;
    }
    
    public List<Tuple<string, List<Product>>> ExpensiveProductEachCategoryMinUnitPriceProducts() {
        List<Product> products = GetProductList();
        List<Tuple<string, List<Product>>> categories = products.Where(p=>p.UnitPrice>100).GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key,
                g.Where(p => p.UnitPrice == g.Min(p => p.UnitPrice))
                    .ToList())).ToList();
        return categories;
    }
    
    public Dictionary<string, List<Product>> ExpensiveProductEachCategoryMinUnitPriceProductsDict() {
        List<Product> products = GetProductList();
        Dictionary<string, List<Product>> categories = products.Where(p=>p.UnitPrice>100).GroupBy(p => p.Category)
            .ToDictionary(g => g.Key,
                g=> g.Where(p => p.UnitPrice == g.Min(p => p.UnitPrice))
                    .ToList());
        return categories;
    }
    
    public List<Tuple<string, List<Customer>>> CustomerEachRegionOrdersMinCustomer() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, List<Customer>>> customerOrdersMin = customers.GroupBy(c => c.Region)
            .Select(g => Tuple.Create(g.Key,
                g.Where(c => c.Orders.Length ==g.Min(c => c.Orders.Length)).ToList())).ToList();
        return customerOrdersMin;
    }

    public Dictionary<string, List<Customer>> CustomerEachRegionOrdersMinCustomerDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, List<Customer>> customerOrdersMin = customers.GroupBy(c => c.Region)
            .ToDictionary(g => g.Key,
                g => g.Where(c => c.Orders.Length ==g.Min(c => c.Orders.Length)).ToList());
        return customerOrdersMin;
    }

    public List<Tuple<string, List<Customer>>> CustomerEachCountryOrdersMinCustomer() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, List<Customer>>> customerOrdersMin = customers.GroupBy(c => c.Country)
            .Select(g => Tuple.Create(g.Key,
                g.Where(c => c.Orders.Length ==g.Min(c => c.Orders.Length)).ToList())).ToList();
        return customerOrdersMin;
    }

    public Dictionary<string, List<Customer>> CustomerEachCountryOrdersMinCustomerDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, List<Customer>> customerOrdersMin = customers.GroupBy(c => c.Country)
            .ToDictionary(g => g.Key,
                g => g.Where(c => c.Orders.Length ==g.Min(c => c.Orders.Length)).ToList());
        return customerOrdersMin;
    }

    public List<Tuple<string, List<Order>>> CustomerEachRegionOrdersTotalMinCustomer() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, List<Order>>> customerOrdersTotalMin = customers.GroupBy(c => c.Region)
            .Select(g => Tuple.Create(g.Key,
                g.SelectMany(c=>c.Orders).Where(
                    o=>o.Total == g.SelectMany(c=>c.Orders).Min(o => o.Total)).ToList())).ToList();
        return customerOrdersTotalMin;
    }

    public Dictionary<string, List<Order>> CustomerEachRegionOrdersTotalMinCustomerDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, List<Order>> customerOrdersTotalMin = customers.GroupBy(c => c.Region)
            .ToDictionary(g => g.Key,
                g=>g.SelectMany(c => c.Orders).Where(
                    o => o.Total == g.SelectMany(c => c.Orders).Min(o => o.Total)).ToList());
        return customerOrdersTotalMin;
    }
}