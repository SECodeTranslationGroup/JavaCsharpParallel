using Parallel.Linq101.DataSources;

namespace Parallel.Linq101.MyLinq;

public class SelectMethods {
    //original:10 target:50 form Projections
    public List<Product> GetProductList() => Products.ProductList;
    public List<Customer> GetCustomerList() => Customers.CustomerList;

    public int[] IntPlusOne() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int[] numSelected = numbers.Select(n => n + 1).ToArray();
        return numSelected;
    }

    public int[] OddIntPlusOne() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int[] numSelected = numbers.Where(n => n % 2 == 1).Select(n => n + 1).ToArray();
        return numSelected;
    }

    public int[] BigIntPlusOne() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int[] numSelected = numbers.Where(n => n > 5).Select(n => n + 1).ToArray();
        return numSelected;
    }

    public int[] IntTwice() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int[] numSelected = numbers.Select(n => n * 2).ToArray();
        return numSelected;
    }

    public int[] OddIntTwice() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int[] numSelected = numbers.Where(n => n % 2 == 1).Select(n => n * 2).ToArray();
        return numSelected;
    }

    public int[] BigIntTwice() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int[] numSelected = numbers.Where(n => n > 5).Select(n => n * 2).ToArray();
        return numSelected;
    }


    public char[] StringFirstChar() {
        string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        char[] selected = strings.Select(w => w[0]).ToArray();
        return selected;
    }

    public char[] ShortStringFirstChar() {
        string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        char[] selected = strings.Where(w => w.Length < 4).Select(w => w[0]).ToArray();
        return selected;
    }

    public int[] StringLength() {
        string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        int[] selected = strings.Select(w => w.Length).ToArray();
        return selected;
    }

    public int[] ShortStringLength() {
        string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        int[] selected = strings.Where(w => w.Length < 4).Select(w => w.Length).ToArray();
        return selected;
    }

    public List<string> ProductName() {
        List<Product> products = GetProductList();
        List<string> productNames = products.Select(p => p.ProductName).ToList();
        return productNames;
    }

    public List<double> ProductUnitPrice() {
        List<Product> products = GetProductList();
        List<double> productNames = products.Select(p => p.UnitPrice).ToList();
        return productNames;
    }

    public List<string> ExpensiveProductName() {
        List<Product> products = GetProductList();
        List<string> productNames = products.Where(p => p.UnitPrice > 100).Select(p => p.ProductName).ToList();
        return productNames;
    }

    public List<double> ExpensiveProductUnitPrice() {
        List<Product> products = GetProductList();
        List<double> productNames = products.Where(p => p.UnitPrice > 100).Select(p => p.UnitPrice).ToList();
        return productNames;
    }

    public List<string> OutOfStockProductName() {
        List<Product> products = GetProductList();
        List<string> productNames = products.Where(p => p.UnitsInStock == 0).Select(p => p.ProductName).ToList();
        return productNames;
    }

    public List<double> OutOfStockProductUnitPrice() {
        List<Product> products = GetProductList();
        List<double> productNames = products.Where(p => p.UnitsInStock == 0).Select(p => p.UnitPrice).ToList();
        return productNames;
    }


    public List<Tuple<string, List<string>>> ProductGroupName() {
        List<Product> products = GetProductList();
        List<Tuple<string, List<string>>> productNames = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key, g.Select(p => p.ProductName).ToList()))
            .ToList();
        return productNames;
    }

    public Dictionary<string, List<string>> ProductGroupNameDict() {
        List<Product> products = GetProductList();
        Dictionary<string, List<string>> productNames = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key, g => g.Select(p => p.ProductName).ToList());
        return productNames;
    }

    public List<Tuple<string, List<double>>> ProductGroupUnitPrice() {
        List<Product> products = GetProductList();
        List<Tuple<string, List<double>>> productNames = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key, g.Select(p => p.UnitPrice).ToList()))
            .ToList();
        return productNames;
    }

    public Dictionary<string, List<double>> ProductGroupUnitPriceDict() {
        List<Product> products = GetProductList();
        Dictionary<string, List<double>> productNames = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key, g => g.Select(p => p.UnitPrice).ToList());
        return productNames;
    }

    public int[] TransformIndexToInt() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int[] textNums = numbers.Select(n => numbers[n]).ToArray();
        return textNums;
    }

    public string[] TransformIndexToString() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        string[] textNums = numbers.Select(n => strings[n]).ToArray();
        return textNums;
    }

    public int[] TransformIndexHashToInt() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int[] textNums = numbers.Select(n => numbers[n * 97 % 10]).ToArray();
        return textNums;
    }

    public string[] TransformIndexHashToString() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        string[] textNums = numbers.Select(n => strings[n * 97 % 10]).ToArray();
        return textNums;
    }

    public Tuple<string, string>[] SelectByCase() {
        string[] words = { "aPPLE", "BlUeBeRrY", "cHeRry" };
        Tuple<string, string>[] upperLowerWords = words.Select(w =>
            Tuple.Create(w.ToUpper(), w.ToLower())).ToArray();
        return upperLowerWords;
    }

    public string[] SelectByCaseConcat() {
        string[] words = { "aPPLE", "BlUeBeRrY", "cHeRry" };
        string[] upperLowerWords = words.Select(w =>
            w.ToUpper() + w.ToLower()).ToArray();
        return upperLowerWords;
    }

    public Tuple<string, int>[] SelectByStringAndLength() {
        string[] words = { "aPPLE", "BlUeBeRrY", "cHeRry" };
        Tuple<string, int>[] upperLowerWords = words.Select(w =>
            Tuple.Create(w, w.Length)).ToArray();
        return upperLowerWords;
    }

    public string[] SelectByStringAndLengthConcat() {
        string[] words = { "aPPLE", "BlUeBeRrY", "cHeRry" };
        string[] upperLowerWords = words.Select(w =>
            w + w.Length).ToArray();
        return upperLowerWords;
    }

    public Tuple<string, bool>[] SelectByEvenOdd() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        Tuple<string, bool>[] evenOddWords = numbers.Select(n =>
            Tuple.Create(strings[n], n % 2 == 0)).ToArray();
        return evenOddWords;
    }

    public string[] SelectByEvenOddConcat() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        string[] evenOddWords = numbers.Select(n =>
            strings[n] + (n % 2 == 0 ? " even" : " odd")).ToArray();
        return evenOddWords;
    }
    
    public List<Tuple<string,string>> CustomerIdAndName() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,string>> customerProperties = customers.Select(c=>
            Tuple.Create(c.CustomerId,c.CompanyName)).ToList();
        return customerProperties;
    }
    
    public List<Tuple<string,string>> CustomerRegionAndCountry() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,string>> customerProperties = customers.Select(c=>
            Tuple.Create(c.Region,c.Country)).ToList();
        return customerProperties;
    }
    
    public List<Tuple<string,string>> CustomerCityAndAddress() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,string>> customerProperties = customers.Select(c=>
            Tuple.Create(c.City,c.Address)).ToList();
        return customerProperties;
    }
    
    public List<Tuple<string,string,string>> CustomerRegionAndCountryAndCity() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,string,string>> customerProperties = customers.Select(c=>
            Tuple.Create(c.Region,c.Country,c.City)).ToList();
        return customerProperties;
    }
    
    public List<Tuple<string,string,string>> CustomerCityAndAddressAndPostal() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,string,string>> customerProperties = customers.Select(c=>
            Tuple.Create(c.City,c.Address,c.PostalCode)).ToList();
        return customerProperties;
    }
    
    public List<Tuple<string,Order[]>> CustomerIdAndOrders() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,Order[]>> customerProperties = customers.Select(c=>
            Tuple.Create(c.CustomerId, c.Orders)).ToList();
        return customerProperties;
    }
    
    public List<Tuple<string,int>> CustomerIdAndOrdersCount() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,int>> customerProperties = customers.Select(c=>
            Tuple.Create(c.CustomerId, c.Orders.Length)).ToList();
        return customerProperties;
    }
    
    public List<Tuple<string,Order>> CustomerIdAndFirstOrder() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,Order>> customerProperties = customers.Select(c=>
            Tuple.Create(c.CustomerId, c.Orders.First())).ToList();
        return customerProperties;
    }
    
    public List<Tuple<string,Order>> CustomerIdAndFirstOrDefaultOrder() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,Order>> customerProperties = customers.Select(c=>
            Tuple.Create(c.CustomerId, c.Orders.FirstOrDefault(Order.Default))).ToList();
        return customerProperties;
    }
    
    public List<Tuple<string,double>> CustomerIdAndBiggestTotal() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,double>> customerProperties = customers.Select(c=>
            Tuple.Create(c.CustomerId, c.Orders.Select(o=>o.Total).Max())).ToList();
        return customerProperties;
    }

    public bool[] IntWithIndex() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        bool[] numSelected = numbers.Select((n, index) => n == index).ToArray();
        return numSelected;
    }
    
    public int[] IntAddIndex() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int[] numSelected = numbers.Select((n, index) => n + index).ToArray();
        return numSelected;
    }
    
    public bool[] OddIntWithIndex() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        bool[] numSelected = numbers.Where(n => n % 2 == 1).Select((n, index) => n == index).ToArray();
        return numSelected;
    }
    
    public int[] OddIntAddIndex() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int[] numSelected = numbers.Where(n => n % 2 == 1).Select((n, index) => n + index).ToArray();
        return numSelected;
    }

    public bool[] OddIntWithOriginalIndex() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        bool[] numSelected = numbers.Select((n, index) => Tuple.Create(n % 2 == 1,n == index))
            .Where(t=>t.Item1).Select(t=>t.Item2).ToArray();
        return numSelected;
    }
    
    public int[] OddIntAddOriginalIndex() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int[] numSelected = numbers.Select((n, index) => n % 2 == 1 ? n + index : -1)
            .Where(n=>n!=-1).ToArray();
        return numSelected;
    }

    public bool[] BigIntWithIndex() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        bool[] numSelected = numbers.Where(n => n > 5).Select((n, index) => n == index).ToArray();
        return numSelected;
    }
    
    public int[] BigIntAddIndex() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int[] numSelected = numbers.Where(n => n > 5).Select((n, index) => n + index).ToArray();
        return numSelected;
    }
    
    public bool[] BigIntWithOriginalIndex() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        bool[] numSelected = numbers.Select((n, index) => Tuple.Create(n > 5,n == index))
            .Where(t=>t.Item1).Select(t=>t.Item2).ToArray();
        return numSelected;
    }
    
    public int[] BigIntAddOriginalIndex() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        int[] numSelected = numbers.Select((n, index) => n > 5 ? n + index : -1)
            .Where(n=>n!=-1).ToArray();
        return numSelected;
    }
}