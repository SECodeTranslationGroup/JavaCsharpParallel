using Parallel.Linq101.DataSources;

namespace Parallel.Linq101.MyLinq;

public class SumMethod {
    //original:3 target:30
    public List<Product> GetProductList() => Products.ProductList;
    public List<Customer> GetCustomerList() => Customers.CustomerList;

    //sum syntax : 5

    public int NumbersSum() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int numbersSum = numbers.Sum();
        return numbersSum;
    }

    public int BigNumbersSum() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int numbersSum = numbers.Where(n => n > 5).Sum();
        return numbersSum;
    }

    public int OddNumbersSum() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int numbersSum = numbers.Where(n => n % 2 == 1).Sum();
        return numbersSum;
    }

    public double DoubleSum() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        double numbersSum = numbers.Sum();
        return numbersSum;
    }

    public double BigDoubleNumbersSum() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        double numbersSum = numbers.Where(d => d > 5).Sum();
        return numbersSum;
    }


    //sum projection: 15

    public int NumbersSumTwice() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int numbersSum = numbers.Sum(n => n * 2);
        return numbersSum;
    }

    public int BigNumbersSumTwice() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int numbersSum = numbers.Where(n => n > 5).Sum(n => n * 2);
        return numbersSum;
    }

    public int OddNumbersSumTwice() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int numbersSum = numbers.Where(n => n % 2 == 1).Sum(n => n * 2);
        return numbersSum;
    }

    public int StringSumLength() {
        string[] words = { "cherry", "apple", "blueberry" };
        int totalChars = words.Sum(w => w.Length);
        return totalChars;
    }

    public int ShortStringSumLength() {
        string[] words = { "cherry", "apple", "blueberry" };
        int totalChars = words.Where(w => w.Length < 7).Sum(w => w.Length);
        return totalChars;
    }

    public double ProductUnitPriceTotalSum() {
        List<Product> products = GetProductList();
        double totalSum = products.Sum(p => p.UnitPrice);
        return totalSum;
    }

    public double ExpensiveProductUnitPriceTotalSum() {
        List<Product> products = GetProductList();
        double totalSum = products.Where(p => p.UnitPrice > 100).Sum(p => p.UnitPrice);
        return totalSum;
    }

    public int ExpensiveProductStockTotalSum() {
        List<Product> products = GetProductList();
        int totalSum = products.Where(p => p.UnitPrice > 100).Sum(p => p.UnitsInStock);
        return totalSum;
    }

    public int ProductLongNameLengthSum() {
        List<Product> products = GetProductList();
        int totalSum = products.Select(p => p.ProductName)
            .Where(name => name.Length > 7).Sum(name => name.Length);
        return totalSum;
    }

    public List<Tuple<string, double>> CustomerOrdersTotalSum() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, double>> ordersTotalSum = customers.Select(c => Tuple.Create(c.CustomerId,
            c.Orders.Sum(o => o.Total))).ToList();
        return ordersTotalSum;
    }

    public Dictionary<string, double> CustomerOrdersTotalSumDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, double> ordersTotalSum = customers.ToDictionary(c => c.CustomerId,
            c => c.Orders.Sum(o => o.Total));
        return ordersTotalSum;
    }

    public List<Tuple<string, double>> CustomerInRegionOrdersTotalSum(string region) {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, double>> ordersTotalSum = customers.Where(c => c.Region.Equals(region))
            .Select(c => Tuple.Create(c.CustomerId,
                c.Orders.Sum(o => o.Total))).ToList();
        return ordersTotalSum;
    }

    public Dictionary<string, double> CustomerInRegionOrdersTotalSumDict(string region) {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, double> ordersTotalSum = customers.Where(c => c.Region.Equals(region))
            .ToDictionary(c => c.CustomerId,
                c => c.Orders.Sum(o => o.Total));
        return ordersTotalSum;
    }

    public List<Tuple<string, double>> CustomerExpensiveOrdersTotalSum() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, double>> ordersTotalSum = customers.Select(c => Tuple.Create(c.CustomerId,
            c.Orders.Where(o => o.Total > 100).Sum(o => o.Total))).ToList();
        return ordersTotalSum;
    }

    public Dictionary<string, double> CustomerExpensiveOrdersTotalSumDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, double> ordersTotalSum = customers.ToDictionary(c => c.CustomerId,
            c => c.Orders.Where(o => o.Total > 100).Sum(o => o.Total));
        return ordersTotalSum;
    }

    //sum grouped: 10

    public List<Tuple<string, int>> ProductEachCategoryStock() {
        List<Product> products = GetProductList();
        List<Tuple<string, int>> categories = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key, g.Sum(p => p.UnitsInStock))).ToList();
        return categories;
    }

    public Dictionary<string, int> ProductEachCategoryStockDict() {
        List<Product> products = GetProductList();
        Dictionary<string, int> categories = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key, g => g.Sum(p => p.UnitsInStock));
        return categories;
    }
    
    public List<Tuple<string, int>> ExpensiveProductEachCategoryStock() {
        List<Product> products = GetProductList();
        List<Tuple<string, int>> categories = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key, g.Where(p=>p.UnitPrice>100)
                .Sum(p => p.UnitsInStock))).ToList();
        return categories;
    }

    public Dictionary<string, int> ExpensiveProductEachCategoryStockDict() {
        List<Product> products = GetProductList();
        Dictionary<string, int> categories = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key, g => 
                g.Where(p=>p.UnitPrice>100).Sum(p => p.UnitsInStock));
        return categories;
    }
    
    public List<Tuple<string, int>> CustomerEachRegionOrdersSum() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, int>> ordersTotalSum = customers.GroupBy(c => c.Region)
            .Select(g=>Tuple.Create(g.Key,
                g.Sum(c=>c.Orders.Length))).ToList();
        return ordersTotalSum;
    }
    
    public Dictionary<string, int> CustomerEachRegionOrdersSumDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, int> ordersTotalSum = customers.GroupBy(c => c.Region)
            .ToDictionary(g=>g.Key,
                g=>g.Sum(c=>c.Orders.Length));
        return ordersTotalSum;
    }
    
    public List<Tuple<string, int>> CustomerEachCountryOrdersSum() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, int>> ordersTotalSum = customers.GroupBy(c => c.Country)
            .Select(g=>Tuple.Create(g.Key,
                g.Sum(c=>c.Orders.Length))).ToList();
        return ordersTotalSum;
    }
    
    public Dictionary<string, int> CustomerEachCountryOrdersSumDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, int> ordersTotalSum = customers.GroupBy(c => c.Country)
            .ToDictionary(g=>g.Key,
                g=>g.Sum(c=>c.Orders.Length));
        return ordersTotalSum;
    }
    
    public List<Tuple<string, double>> CustomerEachRegionOrdersTotalSum() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, double>> ordersTotalSum = customers.GroupBy(c => c.Region)
            .Select(g=>Tuple.Create(g.Key,
            g.SelectMany(c=>c.Orders).Sum(o => o.Total))).ToList();
        return ordersTotalSum;
    }
    
    public Dictionary<string, double> CustomerEachRegionOrdersTotalSumDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, double> ordersTotalSum = customers.GroupBy(c => c.Region)
            .ToDictionary(g=>g.Key,
                g=>g.SelectMany(c=>c.Orders).Sum(o => o.Total));
        return ordersTotalSum;
    }
}