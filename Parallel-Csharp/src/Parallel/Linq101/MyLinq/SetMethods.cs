using Parallel.Linq101.DataSources;

namespace Parallel.Linq101.MyLinq; 

public class SetMethods {
    //original:8 target:30 form SetOperations
    public List<Product> GetProductList() => Products.ProductList;
    public List<Customer> GetCustomerList() => Customers.CustomerList;
    public int[] IntUnion() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8 };
        int[] uniqueNumbers = numbersA.Union(numbersB).ToArray();
        return uniqueNumbers;
    }
    
    public double[] DoubleUnion() {
        double[] numbersA = { 0.1, 2.2, 4.3, 5.4, 6.5, 8.6, 9.7 };
        double[] numbersB = { 0.1, 3.3, 5.4, 7.7, 8.6 };
        double[] uniqueNumbers = numbersA.Union(numbersB).ToArray();
        return uniqueNumbers;
    }
    
    public string[] StringUnion() {
        string[] wordsA = {"Alice", "Bob", "Foo", "Bar"};
        string[] wordsB = {"Cafe", "Bar","Restaurant" };
        string[] uniqueWords = wordsA.Union(wordsB).ToArray();
        return uniqueWords;
    }
    
    public int[] ProjectionIntUnion() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8 };
        var first = numbersA.Select(n => n+1);
        var second = numbersB.Select(n => n-1);
        int[] numbers = first.Union(second).ToArray();
        return numbers;
    }
    
    public double[] ProjectionDoubleUnion() {
        double[] numbersA = { 0.1, 2.2, 4.3, 5.4, 6.5, 8.6, 9.7 };
        double[] numbersB = { 0.1, 3.3, 5.4, 7.7, 8.6 };
        var first = numbersA.Select(n => n-(int)n);
        var second = numbersB.Select(n => n-(int)n);
        double[] numbers = first.Union(second).ToArray();
        return numbers;
    }
    
    public char[] ProjectionStringUnion() {
        string[] wordsA = {"Alice", "Bob", "Foo", "Bar"};
        string[] wordsB = {"Cafe", "Bar","Restaurant" };
        var first = wordsA.Select(n => n[0]);
        var second = wordsB.Select(n => n[0]);
        char[] words = first.Union(second).ToArray();
        return words;
    }
    
    public List<string> UnionOfCategory() {
        string[] categories = {"Furnitures", "Seagoods"};
        List<Product> products = GetProductList();
        var productCategories = products.Select(p => p.Category);
        List<string> uniqueCategories = productCategories.Union(categories).ToList();
        return uniqueCategories;
    }
    
    public List<string> UnionOfRegion() {
        string[] regions = {"WA", "AF","RO"};
        List<Customer> customers = GetCustomerList();
        var customerRegions = customers.Select(c => c.Region);
        List<string> uniqueRegions = customerRegions.Union(regions).ToList();
        return uniqueRegions;
    }
    
    public List<string> UnionOfName() {
        List<Product> products = GetProductList();
        List<Customer> customers = GetCustomerList();
        var productNames = products.Select(p => p.ProductName);
        var customerNames = customers.Select(c => c.CompanyName);
        List<string> uniqueNames = productNames.Union(customerNames).ToList();
        return uniqueNames;
    }
    
    public List<char> UnionOfNameFirstChar() {
        List<Product> products = GetProductList();
        List<Customer> customers = GetCustomerList();
        var productFirstChars = products.Select(p => p.ProductName[0]);
        var customerFirstChars = customers.Select(c => c.CompanyName[0]);
        List<char> uniqueFirstChars = productFirstChars.Union(customerFirstChars).ToList();
        return uniqueFirstChars;
    }
    
    public int[] IntIntersect() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8 };
        int[] sharedNumbers = numbersA.Intersect(numbersB).ToArray();
        return sharedNumbers;
    }
    
    public double[] DoubleIntersect() {
        double[] numbersA = { 0.1, 2.2, 4.3, 5.4, 6.5, 8.6, 9.7 };
        double[] numbersB = { 0.1, 3.3, 5.4, 7.7, 8.6 };
        double[] sharedNumbers = numbersA.Intersect(numbersB).ToArray();
        return sharedNumbers;
    }
    
    public string[] StringIntersect() {
        string[] wordsA = {"Alice", "Bob", "Foo", "Bar"};
        string[] wordsB = {"Cafe", "Bar","Restaurant" };
        string[] sharedWords = wordsA.Intersect(wordsB).ToArray();
        return sharedWords;
    }
    
    public int[] ProjectionIntIntersect() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8 };
        var first = numbersA.Select(n => n+1);
        var second = numbersB.Select(n => n-1);
        int[] numbers = first.Intersect(second).ToArray();
        return numbers;
    }
    
    public double[] ProjectionDoubleIntersect() {
        double[] numbersA = { 0.1, 2.2, 4.3, 5.4, 6.5, 8.6, 9.7 };
        double[] numbersB = { 0.1, 3.3, 5.4, 7.7, 8.6 };
        var first = numbersA.Select(n => n-(int)n);
        var second = numbersB.Select(n => n-(int)n);
        double[] numbers = first.Intersect(second).ToArray();
        return numbers;
    }
    
    public char[] ProjectionStringIntersect() {
        string[] wordsA = {"Alice", "Bob", "Foo", "Bar"};
        string[] wordsB = {"Cafe", "Bar","Restaurant" };
        var first = wordsA.Select(n => n[0]);
        var second = wordsB.Select(n => n[0]);
        char[] words = first.Intersect(second).ToArray();
        return words;
    }
    
    public List<string> IntersectOfCategory() {
        string[] categories = {"Furnitures", "Seagoods"};
        List<Product> products = GetProductList();
        var productCategories = products.Select(p => p.Category);
        List<string> sharedCategories = productCategories.Intersect(categories).ToList();
        return sharedCategories;
    }
    
    public List<string> IntersectOfRegion() {
        string[] regions = {"WA", "AF","RO"};
        List<Customer> customers = GetCustomerList();
        var customerRegions = customers.Select(c => c.Region);
        List<string> sharedRegions = customerRegions.Intersect(regions).ToList();
        return sharedRegions;
    }
    
    public List<string> IntersectOfName() {
        List<Product> products = GetProductList();
        List<Customer> customers = GetCustomerList();
        var productNames = products.Select(p => p.ProductName);
        var customerNames = customers.Select(c => c.CompanyName);
        List<string> sharedNames = productNames.Intersect(customerNames).ToList();
        return sharedNames;
    }

    public List<char> IntersectOfNameFirstChar() {
        List<Product> products = GetProductList();
        List<Customer> customers = GetCustomerList();
        var productFirstChars = products.Select(p => p.ProductName[0]);
        var customerFirstChars = customers.Select(c => c.CompanyName[0]);
        List<char> sharedFirstChars = productFirstChars.Intersect(customerFirstChars).ToList();
        return sharedFirstChars;
    }
    
    public int[] IntExcept() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8 };
        int[] differentNumbers = numbersA.Except(numbersB).ToArray();
        return differentNumbers;
    }
    
    public double[] DoubleExcept() {
        double[] numbersA = { 0.1, 2.2, 4.3, 5.4, 6.5, 8.6, 9.7 };
        double[] numbersB = { 0.1, 3.3, 5.4, 7.7, 8.6 };
        double[] differentNumbers = numbersA.Except(numbersB).ToArray();
        return differentNumbers;
    }
    
    public string[] StringExcept() {
        string[] wordsA = {"Alice", "Bob", "Foo", "Bar"};
        string[] wordsB = {"Cafe", "Bar","Restaurant" };
        string[] differentWords = wordsA.Except(wordsB).ToArray();
        return differentWords;
    }
    
    public int[] ProjectionIntExcept() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8 };
        var first = numbersA.Select(n => n+1);
        var second = numbersB.Select(n => n-1);
        int[] numbers = first.Except(second).ToArray();
        return numbers;
    }
    
    public double[] ProjectionDoubleExcept() {
        double[] numbersA = { 0.1, 2.2, 4.3, 5.4, 6.5, 8.6, 9.7 };
        double[] numbersB = { 0.1, 3.3, 5.4, 7.7, 8.6 };
        var first = numbersA.Select(n => n-(int)n);
        var second = numbersB.Select(n => n-(int)n);
        double[] numbers = first.Except(second).ToArray();
        return numbers;
    }
    
    public char[] ProjectionStringExcept() {
        string[] wordsA = {"Alice", "Bob", "Foo", "Bar"};
        string[] wordsB = {"Cafe", "Bar","Restaurant" };
        var first = wordsA.Select(n => n[0]);
        var second = wordsB.Select(n => n[0]);
        char[] words = first.Except(second).ToArray();
        return words;
    }
    
    public List<string> ExceptOfCategory() {
        string[] categories = {"Furnitures", "Seagoods"};
        List<Product> products = GetProductList();
        var productCategories = products.Select(p => p.Category);
        List<string> differentCategories = productCategories.Except(categories).ToList();
        return differentCategories;
    }
    
    public List<string> ExceptOfRegion() {
        string[] regions = {"WA", "AF","RO"};
        List<Customer> customers = GetCustomerList();
        var customerRegions = customers.Select(c => c.Region);
        List<string> differentRegions = customerRegions.Except(regions).ToList();
        return differentRegions;
    }
    
    public List<string> ExceptOfName() {
        List<Product> products = GetProductList();
        List<Customer> customers = GetCustomerList();
        var productNames = products.Select(p => p.ProductName);
        var customerNames = customers.Select(c => c.CompanyName);
        List<string> differentNames = productNames.Except(customerNames).ToList();
        return differentNames;
    }
    
    public List<char> ExceptOfNameFirstChar() {
        List<Product> products = GetProductList();
        List<Customer> customers = GetCustomerList();
        var productFirstChars = products.Select(p => p.ProductName[0]);
        var customerFirstChars = customers.Select(c => c.CompanyName[0]);
        List<char> differentFirstChars = productFirstChars.Except(customerFirstChars).ToList();
        return differentFirstChars;
    }
}