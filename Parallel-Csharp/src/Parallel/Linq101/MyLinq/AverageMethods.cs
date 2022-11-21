using Parallel.Linq101.DataSources;

namespace Parallel.Linq101.MyLinq;

public class AverageMethod {
    //original:3 target:30
    public List<Product> GetProductList() => Products.ProductList;
    public List<Customer> GetCustomerList() => Customers.CustomerList;

    //average syntax : 5

    public double NumbersAverage() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        double averageNum = numbers.Average();
        return averageNum;
    }

    public double BigNumbersAverage() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        double averageNum = numbers.Where(n => n > 5).Average();
        return averageNum;
    }

    public double OddNumbersAverage() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        double averageNum = numbers.Where(n => n % 2 == 1).Average();
        return averageNum;
    }

    public double DoubleAverage() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        double averageNum = numbers.Average();
        return averageNum;
    }

    public double BigDoubleNumbersAverage() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        double averageNum = numbers.Where(d => d > 5).Average();
        return averageNum;
    }


    //average projection: 15

    public double NumbersAverageTwice() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        double averageNum = numbers.Average(n => n * 2);
        return averageNum;
    }

    public double BigNumbersAverageTwice() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        double averageNum = numbers.Where(n => n > 5).Average(n => n * 2);
        return averageNum;
    }

    public double OddNumbersAverageTwice() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        double averageNum = numbers.Where(n => n % 2 == 1).Average(n => n * 2);
        return averageNum;
    }

    public double StringAverageLength() {
        string[] words = { "cherry", "apple", "blueberry" };
        double averageLength = words.Average(w => w.Length);
        return averageLength;
    }

    public double ShortStringAverageLength() {
        string[] words = { "cherry", "apple", "blueberry" };
        double averageLength = words.Where(w => w.Length < 7).Average(w => w.Length);
        return averageLength;
    }

    public double ProductUnitPriceAverage() {
        List<Product> products = GetProductList();
        double averageUnitPrice = products.Average(p => p.UnitPrice);
        return averageUnitPrice;
    }

    public double ExpensiveProductUnitPriceAverage() {
        List<Product> products = GetProductList();
        double averageUnitPrice = products.Where(p => p.UnitPrice > 100).Average(p => p.UnitPrice);
        return averageUnitPrice;
    }

    public double ExpensiveProductStockAverage() {
        List<Product> products = GetProductList();
        double averageUnitPrice = products.Where(p => p.UnitPrice > 100).Average(p => p.UnitsInStock);
        return averageUnitPrice;
    }

    public double ProductLongNameLengthAverage() {
        List<Product> products = GetProductList();
        double averageUnitPrice = products.Select(p => p.ProductName)
            .Where(name => name.Length > 7).Average(name => name.Length);
        return averageUnitPrice;
    }

    public List<Tuple<string, double>> CustomerOrdersTotalAverage() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, double>> ordersTotalAverage = customers.Select(c => Tuple.Create(c.CustomerId,
            c.Orders.Average(o => o.Total))).ToList();
        return ordersTotalAverage;
    }

    public Dictionary<string, double> CustomerOrdersTotalAverageDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, double> ordersTotalAverage = customers.ToDictionary(c => c.CustomerId,
            c => c.Orders.Average(o => o.Total));
        return ordersTotalAverage;
    }

    public List<Tuple<string, double>> CustomerInRegionOrdersTotalAverage(string region) {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, double>> ordersTotalAverage = customers.Where(c => c.Region.Equals(region))
            .Select(c => Tuple.Create(c.CustomerId,
                c.Orders.Average(o => o.Total))).ToList();
        return ordersTotalAverage;
    }

    public Dictionary<string, double> CustomerInRegionOrdersTotalAverageDict(string region) {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, double> ordersTotalAverage = customers.Where(c => c.Region.Equals(region))
            .ToDictionary(c => c.CustomerId,
                c => c.Orders.Average(o => o.Total));
        return ordersTotalAverage;
    }

    public List<Tuple<string, double>> CustomerExpensiveOrdersTotalAverage() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, double>> ordersTotalAverage = customers.Select(c => Tuple.Create(c.CustomerId,
            c.Orders.Where(o => o.Total > 100).Average(o => o.Total))).ToList();
        return ordersTotalAverage;
    }

    public Dictionary<string, double> CustomerExpensiveOrdersTotalAverageDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, double> ordersTotalAverage = customers.ToDictionary(c => c.CustomerId,
            c => c.Orders.Where(o => o.Total > 100).Average(o => o.Total));
        return ordersTotalAverage;
    }

    //average grouped: 10

    public List<Tuple<string, double>> ProductEachCategoryStock() {
        List<Product> products = GetProductList();
        List<Tuple<string, double>> categories = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key, g.Average(p => p.UnitsInStock))).ToList();
        return categories;
    }

    public Dictionary<string, double> ProductEachCategoryStockDict() {
        List<Product> products = GetProductList();
        Dictionary<string, double> categories = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key, g => g.Average(p => p.UnitsInStock));
        return categories;
    }

    public List<Tuple<string, double>> ExpensiveProductEachCategoryStock() {
        List<Product> products = GetProductList();
        List<Tuple<string, double>> categories = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key, g.Where(p => p.UnitPrice > 100)
                .Average(p => p.UnitsInStock))).ToList();
        return categories;
    }

    public Dictionary<string, double> ExpensiveProductEachCategoryStockDict() {
        List<Product> products = GetProductList();
        Dictionary<string, double> categories = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key, g =>
                g.Where(p => p.UnitPrice > 100).Average(p => p.UnitsInStock));
        return categories;
    }

    public List<Tuple<string, double>> CustomerEachRegionOrdersAverage() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, double>> ordersAverage = customers.GroupBy(c => c.Region)
            .Select(g => Tuple.Create(g.Key,
                g.Average(c => c.Orders.Count))).ToList();
        return ordersAverage;
    }

    public Dictionary<string, double> CustomerEachRegionOrdersAverageDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, double> ordersAverage = customers.GroupBy(c => c.Region)
            .ToDictionary(g => g.Key,
                g => g.Average(c => c.Orders.Count));
        return ordersAverage;
    }

    public List<Tuple<string, double>> CustomerEachCountryOrdersAverage() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, double>> ordersAverage = customers.GroupBy(c => c.Country)
            .Select(g => Tuple.Create(g.Key,
                g.Average(c => c.Orders.Count))).ToList();
        return ordersAverage;
    }

    public Dictionary<string, double> CustomerEachCountryOrdersAverageDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, double> ordersAverage = customers.GroupBy(c => c.Country)
            .ToDictionary(g => g.Key,
                g => g.Average(c => c.Orders.Count));
        return ordersAverage;
    }

    public List<Tuple<string, double>> CustomerEachRegionOrdersTotalAverage() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, double>> ordersTotalAverage = customers.GroupBy(c => c.Region)
            .Select(g => Tuple.Create(g.Key,
                g.SelectMany(c => c.Orders).Average(o => o.Total))).ToList();
        return ordersTotalAverage;
    }

    public Dictionary<string, double> CustomerEachRegionOrdersTotalAverageDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, double> ordersTotalAverage = customers.GroupBy(c => c.Region)
            .ToDictionary(g => g.Key,
                g => g.SelectMany(c => c.Orders).Average(o => o.Total));
        return ordersTotalAverage;
    }
}