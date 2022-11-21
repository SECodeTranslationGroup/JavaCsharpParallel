using Parallel.Linq101.DataSources;

namespace Parallel.Linq101.MyLinq;

public class FirstMethods {
    //original:5 target:50 form ElementOperators
    public List<Product> GetProductList() => Products.ProductList;
    public List<Customer> GetCustomerList() => Customers.CustomerList;

    public int NumbersFirst() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int firstNum = numbers.First();
        return firstNum;
    }

    public int BigNumbersFirst() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int firstNum = numbers.First(n => n > 5);
        return firstNum;
    }

    public int OddNumbersFirst() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int firstNum = numbers.First(n => n % 2 == 1);
        return firstNum;
    }

    public double DoubleFirst() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        double firstNum = numbers.First();
        return firstNum;
    }

    public double BigDoubleNumbersFirst() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        double firstNum = numbers.First(d => d > 5);
        return firstNum;
    }

    public string StringFirstStartWithO() {
        string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        string startWithO = strings.First(s => s[0] == 'o');
        return startWithO;
    }

    public string StringFirstStartWith(char c) {
        string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        string startWithChar = strings.First(s => s[0] == c);
        return startWithChar;
    }

    public string StringFirstLong() {
        string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        string startsWithO = strings.First(s => s.Length > 4);
        return startsWithO;
    }

    public int ProjectedBigNumbersFirst() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int firstNum = numbers.Select(i => (int)Math.Pow(2, i)).First(n => n > 100);
        return firstNum;
    }

    public double ProjectedDoubleFirst() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        double firstNum = numbers.Select(i => Math.Log(i)).First(n => n > 3);
        return firstNum;
    }

    public int ProjectedStringFirst() {
        string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        int firstStringLength = strings.Select(s => s.Length).First(i => i % 2 == 0);
        return firstStringLength;
    }

    public Product ProductFirst() {
        List<Product> products = GetProductList();
        Product product12 = products.First(p => p.ProductId == 12);
        return product12;
    }

    public List<Tuple<string, Product>> ProductEachCategoryFirst() {
        List<Product> products = GetProductList();
        List<Tuple<string, Product>> categories = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key, g.First())).ToList();
        return categories;
    }

    public Dictionary<string, Product> ProductEachCategoryFirstDict() {
        List<Product> products = GetProductList();
        Dictionary<string, Product> categories = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key, g => g.First());
        return categories;
    }

    public List<Tuple<string, Order>> CustomerEachRegionFirstOrder() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, Order>> ordersMax = customers.GroupBy(c => c.Region)
            .Select(g => Tuple.Create(g.Key,
                g.SelectMany(c => c.Orders).First())).ToList();
        return ordersMax;
    }

    public Dictionary<string, Order> CustomerEachRegionFirstOrderDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, Order> ordersMax = customers.GroupBy(c => c.Region)
            .ToDictionary(g => g.Key,
                g => g.SelectMany(c => c.Orders).First());
        return ordersMax;
    }
    
    public List<Tuple<string, List<Product>>> ProductEachCategoryFirstUnitPriceProducts() {
        List<Product> products = GetProductList();
        List<Tuple<string, List<Product>>> categories = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key,
                g.Where(p => p.UnitPrice == g.First().UnitPrice)
                    .ToList())).ToList();
        return categories;
    }
    
    public Dictionary<string, List<Product>> ProductEachCategoryFirstUnitPriceProductsDict() {
        List<Product> products = GetProductList();
        Dictionary<string, List<Product>> categories = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key,
                g=> g.Where(p => p.UnitPrice == g.First().UnitPrice)
                    .ToList());
        return categories;
    }
    
    public List<Tuple<string, List<Customer>>> CustomerEachCountryOrdersFirstCustomer() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, List<Customer>>> customerOrdersFirst = customers.GroupBy(c => c.Country)
            .Select(g => Tuple.Create(g.Key,
                g.Where(c => c.Orders.Count ==g.First().Orders.Count).ToList())).ToList();
        return customerOrdersFirst;
    }

    public Dictionary<string, List<Customer>> CustomerEachCountryOrdersFirstCustomerDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, List<Customer>> customerOrdersFirst = customers.GroupBy(c => c.Country)
            .ToDictionary(g => g.Key,
                g => g.Where(c => c.Orders.Count ==g.First().Orders.Count).ToList());
        return customerOrdersFirst;
    }
    
    public int NumbersFirstOrDefault() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int firstNum = numbers.FirstOrDefault(-1);
        return firstNum;
    }

    public int BigNumbersFirstOrDefault() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int firstNum = numbers.FirstOrDefault(n => n > 5,0);
        return firstNum;
    }

    public int OddNumbersFirstOrDefault() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int firstNum = numbers.FirstOrDefault(n => n % 2 == 1,-2);
        return firstNum;
    }

    public double DoubleFirstOrDefault() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        double firstNum = numbers.FirstOrDefault(3.14);
        return firstNum;
    }

    public double BigDoubleNumbersFirstOrDefault() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        double firstNum = numbers.FirstOrDefault(d => d > 5,-2.3);
        return firstNum;
    }

    public string StringFirstOrDefaultStartWithO() {
        string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        string startWithO = strings.FirstOrDefault(s => s[0] == 'o',"none");
        return startWithO;
    }

    public string StringFirstOrDefaultStartWith(char c) {
        string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        string startWithChar = strings.FirstOrDefault(s => s[0] == c,"none");
        return startWithChar;
    }

    public string StringFirstOrDefaultLong() {
        string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        string startsWithO = strings.FirstOrDefault(s => s.Length > 4,"empty");
        return startsWithO;
    }

    public int ProjectedBigNumbersFirstOrDefault() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int firstNum = numbers.Select(i => (int)Math.Pow(2, i))
            .FirstOrDefault(n => n > 100,100);
        return firstNum;
    }

    public double ProjectedDoubleFirstOrDefault() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        double firstNum = numbers.Select(i => Math.Log2(i))
            .FirstOrDefault(n => n > 3,3.01);
        return firstNum;
    }

    public int ProjectedStringFirstOrDefault() {
        string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        int firstStringLength = strings.Select(s => s.Length)
            .FirstOrDefault(i => i % 2 == 0,-1);
        return firstStringLength;
    }

    public Product ProductFirstOrDefault() {
        List<Product> products = GetProductList();
        Product product12 = products.FirstOrDefault(p => p.ProductId == 12,Product.Default);
        return product12;
    }

    public List<Tuple<string, Product>> ProductEachCategoryFirstOrDefault() {
        List<Product> products = GetProductList();
        List<Tuple<string, Product>> categories = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key, 
                g.FirstOrDefault(Product.Default))).ToList();
        return categories;
    }

    public Dictionary<string, Product> ProductEachCategoryFirstOrDefaultDict() {
        List<Product> products = GetProductList();
        Dictionary<string, Product> categories = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key, g =>
                g.FirstOrDefault(Product.Default));
        return categories;
    }

    public List<Tuple<string, Order>> CustomerEachRegionFirstOrDefaultOrder() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, Order>> ordersMax = customers.GroupBy(c => c.Region)
            .Select(g => Tuple.Create(g.Key,
                g.SelectMany(p => p.Orders).FirstOrDefault(Order.Default))).ToList();
        return ordersMax;
    }

    public Dictionary<string, Order> CustomerEachRegionFirstOrDefaultOrderDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, Order> ordersMax = customers.GroupBy(c => c.Region)
            .ToDictionary(g => g.Key,
                g => g.SelectMany(p => p.Orders).FirstOrDefault(Order.Default));
        return ordersMax;
    }
    
    public List<Tuple<string, List<Product>>> ProductEachCategoryFirstOrDefaultUnitPriceProducts() {
        List<Product> products = GetProductList();
        List<Tuple<string, List<Product>>> categories = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key,
                g.Where(p => p.UnitPrice == g.FirstOrDefault(Product.Default).UnitPrice)
                    .ToList())).ToList();
        return categories;
    }
    
    public Dictionary<string, List<Product>> ProductEachCategoryFirstOrDefaultUnitPriceProductsDict() {
        List<Product> products = GetProductList();
        Dictionary<string, List<Product>> categories = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key,
                g=> g.Where(p => p.UnitPrice == g.FirstOrDefault(Product.Default).UnitPrice)
                    .ToList());
        return categories;
    }
    
    public List<Tuple<string, List<Customer>>> CustomerEachCountryOrdersFirstOrDefaultCustomer() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, List<Customer>>> customerOrdersFirst = customers.GroupBy(c => c.Country)
            .Select(g => Tuple.Create(g.Key,
                g.Where(c => c.Orders.Count ==g.FirstOrDefault(Customer.Default).Orders.Count).ToList())).ToList();
        return customerOrdersFirst;
    }

    public Dictionary<string, List<Customer>> CustomerEachCountryOrdersFirstOrDefaultCustomerDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, List<Customer>> customerOrdersFirst = customers.GroupBy(c => c.Country)
            .ToDictionary(g => g.Key,
                g => g.Where(c => c.Orders.Count ==g.FirstOrDefault(Customer.Default).Orders.Count).ToList());
        return customerOrdersFirst;
    }
    
    public int NumbersElementAt() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int numAt = numbers.ElementAt(1);
        return numAt;
    }

    public int OddNumbersElementAt() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int numAt = numbers.Where(n => n % 2 == 1).ElementAt(3);
        return numAt;
    }

    public double BigDoubleNumbersElementAt() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        double numAt = numbers.Where(d => d > 5).ElementAt(1);
        return numAt;
    }

    public string StringElementAtStartWithO() {
        string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        string startWithO = strings.Where(s => s[0] == 'o').ElementAt(0);
        return startWithO;
    }

    public string StringElementAtStartWith(char c) {
        string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        string startWithChar = strings.Where(s => s[0] == c).ElementAt(2);
        return startWithChar;
    }

    public double ProjectedDoubleElementAt() {
        double[] numbers = { 3.1, 4.2, 1.6, 0.7, 8.7, 6.9, 7.4, 2.5, 5.7, 0 };
        double numAt = numbers.Select(i => Math.Log(i)).Where(n => n > 3).ElementAt(2);
        return numAt;
    }
    
    public int ProjectedStringElementAt() {
        string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        int firstStringLength = strings.Select(s => s.Length)
            .Where(i => i % 2 == 0).ElementAt(2);
        return firstStringLength;
    }
    
    public Product ExpensiveProductElementAt() {
        List<Product> products = GetProductList();
        Product expensiveProduct = products.Where(p=>p.UnitPrice>100).ElementAt(2);
        return expensiveProduct;
    }
    
    public List<Tuple<string, Product>> ProductEachCategoryElementAt() {
        List<Product> products = GetProductList();
        List<Tuple<string, Product>> categories = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key, 
                g.ElementAt(1))).ToList();
        return categories;
    }

    public Dictionary<string, Product> ProductEachCategoryElementAtDict() {
        List<Product> products = GetProductList();
        Dictionary<string, Product> categories = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key, g =>
                g.ElementAt(1));
        return categories;
    }
}