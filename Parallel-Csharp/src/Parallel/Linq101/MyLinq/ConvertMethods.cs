using Parallel.Linq101.DataSources;

namespace Parallel.Linq101.MyLinq;

public class ConvertMethods {
    //original:4 target:40
    public List<Product> GetProductList() => Products.ProductList;
    public List<Customer> GetCustomerList() => Customers.CustomerList;

    public int[] IntsConvertToArray() {
        int[] ints = { 2, 3, 1, 5, 4 };
        int[] intsArray = ints.OrderBy(d => d).ToArray();
        return intsArray;
    }

    public int[] IntsConvertToDescendingArrayAndPrint() {
        int[] ints = { 2, 3, 1, 5, 4 };
        int[] intsArray = ints.OrderByDescending(d => d).ToArray();
        for (int i = 0; i < intsArray.Length; i++)
            Console.WriteLine(intsArray[i]);
        return intsArray;
    }

    public int[] IntsConvertToArrayAndPrintForeach() {
        int[] ints = { 2, 3, 1, 5, 4 };
        int[] intsArray = ints.OrderBy(d => d).ToArray();
        foreach (int i in intsArray)
            Console.WriteLine(i);
        return intsArray;
    }

    public double[] DoublesConvertToDescendingArray() {
        double[] doubles = { 1.7, 2.3, 1.9, 4.1, 2.9 };
        double[] doublesArray = doubles.OrderByDescending(d => d).ToArray();
        return doublesArray;
    }

    public double[] DoublesConvertToArrayAndPrint() {
        double[] doubles = { 1.7, 2.3, 1.9, 4.1, 2.9 };
        double[] doublesArray = doubles.OrderBy(d => d).ToArray();
        for (int i = 0; i < doublesArray.Length; i++)
            Console.WriteLine(doublesArray[i]);
        return doublesArray;
    }

    public double[] DoublesConvertToDescendingArrayAndPrintForeach() {
        double[] doubles = { 1.7, 2.3, 1.9, 4.1, 2.9 };
        double[] doublesArray = doubles.OrderByDescending(d => d).ToArray();
        foreach (double d in doublesArray)
            Console.WriteLine(d);
        return doublesArray;
    }

    public Product[] ProductsConvertToArray() {
        List<Product> products = GetProductList();
        Product[] productsArray = products.OrderBy(p => p.UnitPrice).ToArray();
        return productsArray;
    }

    public Product[] ProductsConvertToDescendingArrayAndPrint() {
        List<Product> products = GetProductList();
        Product[] productsArray = products.OrderByDescending(p => p.UnitPrice).ToArray();
        for (int i = 0; i < productsArray.Length; i++)
            Console.WriteLine(productsArray[i]);
        return productsArray;
    }

    public Product[] ProductsConvertToDescendingArrayAndPrintForeach() {
        List<Product> products = GetProductList();
        Product[] productsArray = products.OrderByDescending(p => p.UnitPrice).ToArray();
        foreach (Product p in productsArray)
            Console.WriteLine(p);
        return productsArray;
    }

    public double[] ProductsConvertToUnitPriceArray() {
        List<Product> products = GetProductList();
        double[] pricesArray = products.Select(p => p.UnitPrice).OrderBy(d => d).ToArray();
        return pricesArray;
    }

    public List<int> IntsConvertToList() {
        int[] ints = { 2, 3, 1, 5, 4 };
        List<int> intsList = ints.OrderBy(d => d).ToList();
        return intsList;
    }

    public List<int> IntsConvertToDescendingListAndPrint() {
        int[] ints = { 2, 3, 1, 5, 4 };
        List<int> intsList = ints.OrderByDescending(d => d).ToList();
        for (int i = 0; i < intsList.Count; i++)
            Console.WriteLine(intsList[i]);
        return intsList;
    }

    public List<int> IntsConvertToListAndPrintForeach() {
        int[] ints = { 2, 3, 1, 5, 4 };
        List<int> intsList = ints.OrderBy(d => d).ToList();
        foreach (int i in intsList)
            Console.WriteLine(i);
        return intsList;
    }

    public List<double> DoublesConvertToDescendingList() {
        double[] doubles = { 1.7, 2.3, 1.9, 4.1, 2.9 };
        List<double> doublesList = doubles.OrderByDescending(d => d).ToList();
        return doublesList;
    }

    public List<double> DoublesConvertToListAndPrint() {
        double[] doubles = { 1.7, 2.3, 1.9, 4.1, 2.9 };
        List<double> doublesList = doubles.OrderBy(d => d).ToList();
        for (int i = 0; i < doublesList.Count; i++)
            Console.WriteLine(doublesList[i]);
        return doublesList;
    }

    public List<double> DoublesConvertToDescendingListAndPrintForeach() {
        double[] doubles = { 1.7, 2.3, 1.9, 4.1, 2.9 };
        List<double> doublesList = doubles.OrderByDescending(d => d).ToList();
        foreach (double d in doublesList)
            Console.WriteLine(d);
        return doublesList;
    }

    public List<Product> ProductsConvertToList() {
        List<Product> products = GetProductList();
        List<Product> productsList = products.OrderBy(p => p.UnitPrice).ToList();
        return productsList;
    }

    public List<Product> ProductsConvertToDescendingListAndPrint() {
        List<Product> products = GetProductList();
        List<Product> productsList = products.OrderByDescending(p => p.UnitPrice).ToList();
        for (int i = 0; i < productsList.Count; i++)
            Console.WriteLine(productsList[i]);
        return productsList;
    }

    public List<Product> ProductsConvertToDescendingListAndPrintForeach() {
        List<Product> products = GetProductList();
        List<Product> productsList = products.OrderByDescending(p => p.UnitPrice).ToList();
        foreach (Product p in productsList)
            Console.WriteLine(p);
        return productsList;
    }

    public List<double> ProductsConvertToDescendingUnitPriceList() {
        List<Product> products = GetProductList();
        List<double> pricesList = products.Select(p => p.UnitPrice).OrderBy(d => d).ToList();
        return pricesList;
    }

    public Dictionary<string, int> ConvertTuplesToDictionary() {
        List<Tuple<string, int>> scoreRecords =new List<Tuple<string, int>>
            { Tuple.Create("Alice", 50), Tuple.Create("Bob", 40), Tuple.Create("Cathy", 45) };
        Dictionary<string, int> scoreRecordsDict = scoreRecords.ToDictionary(sr => sr.Item1,
            sr => sr.Item2);
        return scoreRecordsDict;
    }

    public Dictionary<string, int> ConvertTuplesToDictionaryAndPrint() {
        List<Tuple<string, int>> scoreRecords =new List<Tuple<string, int>>
            { Tuple.Create("Alice", 50), Tuple.Create("Bob", 40), Tuple.Create("Cathy", 45) };
        Dictionary<string, int> scoreRecordsDict = scoreRecords.ToDictionary(sr => sr.Item1,
            sr => sr.Item2);
        foreach (var pair in scoreRecordsDict)
            Console.WriteLine(pair.Key + " " + pair.Value);
        return scoreRecordsDict;
    }

    public Dictionary<double, double> ConvertArrayToDictionary() {
        double[] doubles = { 1.7, 2.3, 1.9, 4.1, 2.9 };
        Dictionary<double, double> doublesDict = doubles.ToDictionary(sr => sr,
            sr => sr * 2);
        return doublesDict;
    }

    public Dictionary<double, double> ConvertArrayToDictionaryAndPrint() {
        double[] doubles = { 1.7, 2.3, 1.9, 4.1, 2.9 };
        Dictionary<double, double> doublesDict = doubles.ToDictionary(sr => sr,
            sr => sr * 2);
        foreach (var pair in doublesDict)
            Console.WriteLine(pair.Key + " " + pair.Value);
        return doublesDict;
    }

    public Dictionary<double, double> ConvertArrayToDictionaryWithDistinct() {
        double[] doubles = { 1.7, 2.3, 1.9, 4.1, 1.7, 2.9 };
        Dictionary<double, double> doublesDict = doubles.Distinct().ToDictionary(sr => sr,
            sr => sr * 2);
        return doublesDict;
    }

    public Dictionary<double, double> ConvertArrayToDictionaryWithDistinctAndPrint() {
        double[] doubles = { 1.7, 2.3, 1.9, 4.1, 1.7, 2.9 };
        Dictionary<double, double> doublesDict = doubles.Distinct().ToDictionary(sr => sr,
            sr => sr * 2);
        foreach (var pair in doublesDict)
            Console.WriteLine(pair.Key + " " + pair.Value);
        return doublesDict;
    }

    public Dictionary<string, double> ProductsConvertFieldsToDictionary() {
        List<Product> products = GetProductList();
        Dictionary<string, double> productsUnitPrice = products.ToDictionary(
            p => p.ProductName, p => p.UnitPrice);
        return productsUnitPrice;
    }

    public Dictionary<string, double> ProductsConvertFieldsToDictionaryAndPrint() {
        List<Product> products = GetProductList();
        Dictionary<string, double> productsUnitPrice = products.ToDictionary(
            p => p.ProductName, p => p.UnitPrice);
        foreach (var pair in productsUnitPrice)
            Console.WriteLine(pair.Key + ":" + pair.Value);
        return productsUnitPrice;
    }

    public Dictionary<string, List<Product>> ProductsConvertGroupingToDictionary() {
        List<Product> products = GetProductList();
        Dictionary<string, List<Product>> catagory = products.GroupBy(p => p.Category).ToDictionary(
            g => g.Key, g => g.ToList());
        return catagory;
    }

    public Dictionary<string, List<Product>> ProductsConvertGroupingToDictionaryAndPrint() {
        List<Product> products = GetProductList();
        Dictionary<string, List<Product>> catagory = products.GroupBy(p => p.Category).ToDictionary(
            g => g.Key, g => g.ToList());
        foreach (var pair in catagory) {
            Console.WriteLine(pair.Key + ":");
            foreach (var product in pair.Value)
                Console.WriteLine("\t" + product);
        }
        return catagory;
    }
    
    public double[] ConvertSelectedDoubleItemToArray() {
        object[] numbers = { null, 1.0, "two", 3, "four", 5, "six", 7.0 };
        double[] doubles = numbers.OfType<double>().ToArray();
        return doubles;
    }
    
    public double[] ConvertSelectedDoubleItemToArrayAndPrint() {
        object[] numbers = { null, 1.0, "two", 3, "four", 5, "six", 7.0 };
        double[] doubles = numbers.OfType<double>().ToArray();
        for (int i = 0; i < doubles.Length; i++)
            Console.WriteLine(doubles[i]);
        return doubles;
    }

    public double[] ConvertSelectedDoubleItemToArrayAndPrintForeach() {
        object[] numbers = { null, 1.0, "two", 3, "four", 5, "six", 7.0 };
        double[] doubles = numbers.OfType<double>().ToArray();
        foreach (double d in doubles)
            Console.WriteLine(d);
        return doubles;
    }

    public List<string> ConvertSelectedStringItemToList() {
        object[] numbers = { null, 1.0, "two", 3, "four", 5, "six", 7.0 };
        List<string> strings = numbers.OfType<string>().ToList();
        return strings;
    }

    public List<string> ConvertSelectedStringItemToListAndPrint() {
        object[] numbers = { null, 1.0, "two", 3, "four", 5, "six", 7.0 };
        List<string> strings = numbers.OfType<string>().ToList();
        for (int i = 0; i < strings.Count; i++)
            Console.WriteLine(strings[i]);
        return strings;
    }
    
    public List<string> ConvertSelectedStringItemToListAndPrintForeach() {
        object[] numbers = { null, 1.0, "two", 3, "four", 5, "six", 7.0 };
        List<string> strings = numbers.OfType<string>().ToList();
        foreach (string s in strings)
            Console.WriteLine(s);
        return strings;
    }
    
    public List<Tuple<string,int>> ConvertSelectedTupleToList() {
        object[] numbers = { Tuple.Create("Alice", "50"), Tuple.Create("Bob", 40), Tuple.Create("Cathy", 45) };
        List<Tuple<string,int>> strings = numbers.OfType<Tuple<string,int>>().ToList();
        return strings;
    }
    
    public List<Tuple<string,int>> ConvertSelectedTupleToListAndPrint() {
        object[] numbers = { Tuple.Create("Alice", "50"), Tuple.Create("Bob", 40), Tuple.Create("Cathy", 45) };
        List<Tuple<string,int>> strings = numbers.OfType<Tuple<string,int>>().ToList();
        for (var i = 0; i < strings.Count; i++)
            Console.WriteLine(strings[i].Item1+":"+strings[i].Item2);
        return strings;
    }
    
    public Dictionary<string,int> ConvertSelectedTupleToDictionary() {
        object[] numbers = { Tuple.Create("Alice", "50"), Tuple.Create("Bob", 40), Tuple.Create("Cathy", 45) };
        Dictionary<string,int> strings = numbers.OfType<Tuple<string,int>>().ToDictionary(
            t=>t.Item1,t=>t.Item2);
        return strings;
    }
    
    public Dictionary<string,int> ConvertSelectedTupleToDictionaryAndPrint() {
        object[] numbers = { Tuple.Create("Alice", "50"), Tuple.Create("Bob", 40), Tuple.Create("Cathy", 45) };
        Dictionary<string,int> strings = numbers.OfType<Tuple<string,int>>().ToDictionary(
            t=>t.Item1,t=>t.Item2);
        foreach (var pair in strings) 
            Console.WriteLine(pair.Key+":"+pair.Value);
        return strings;
    }
}