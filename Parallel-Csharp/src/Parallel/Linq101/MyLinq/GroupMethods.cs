using Parallel.Linq101.DataSources;

namespace Parallel.Linq101.MyLinq;

public class GroupMethods {
    public List<Product> GetProductList() => Products.ProductList;

    public List<Customer> GetCustomerList() => Customers.CustomerList;

    //original:6 target:40 form Groupings(remove custom comparator)
    public List<Tuple<int, List<int>>> IntGroupByMod() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<Tuple<int, List<int>>> numberGroups = numbers.GroupBy(n => n % 5)
            .Select(g => Tuple.Create(g.Key, g.ToList())).ToList();
        return numberGroups;
    }

    public Dictionary<int, List<int>> IntGroupByModDict() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        Dictionary<int, List<int>> numberGroups = numbers.GroupBy(n => n % 5)
            .ToDictionary(g => g.Key, g => g.ToList());
        return numberGroups;
    }

    public List<Tuple<bool, List<int>>> IntGroupByBool() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        List<Tuple<bool, List<int>>> numberGroups = numbers.GroupBy(n => n > 4)
            .Select(g => Tuple.Create(g.Key, g.ToList())).ToList();
        return numberGroups;
    }

    public Dictionary<bool, List<int>> IntGroupByBoolDict() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        Dictionary<bool, List<int>> numberGroups = numbers.GroupBy(n => n > 4)
            .ToDictionary(g => g.Key, g => g.ToList());
        return numberGroups;
    }

    public Dictionary<bool, List<int>> IntGroupByBoolDictPrint() {
        int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        Dictionary<bool, List<int>> numberGroups = numbers.GroupBy(n => n > 4)
            .ToDictionary(g => g.Key, g => g.ToList());
        numberGroups[true].ForEach(n => Console.Write(n));
        Console.WriteLine();
        numberGroups[false].ForEach(n => Console.Write(n));
        return numberGroups;
    }

    public List<Tuple<double, List<double>>> DoubleGroupByMod() {
        double[] numbers = { 5.8, 4.3, 1.5, 3.7, 9.3 };
        List<Tuple<double, List<double>>> numberGroups = numbers.GroupBy(n => n % 1.5)
            .Select(g => Tuple.Create(g.Key, g.ToList())).ToList();
        return numberGroups;
    }

    public Dictionary<double, List<double>> DoubleGroupByModDict() {
        double[] numbers = { 5.8, 4.3, 1.5, 3.7, 9.3 };
        Dictionary<double, List<double>> numberGroups = numbers.GroupBy(n => n % 1.5)
            .ToDictionary(g => g.Key, g => g.ToList());
        return numberGroups;
    }

    public List<Tuple<bool, List<double>>> DoubleGroupByBool() {
        double[] numbers = { 5.8, 4.3, 1.5, 3.7, 9.3 };
        List<Tuple<bool, List<double>>> numberGroups = numbers.GroupBy(n => n > 3)
            .Select(g => Tuple.Create(g.Key, g.ToList())).ToList();
        return numberGroups;
    }

    public Dictionary<bool, List<double>> DoubleGroupByBoolDict() {
        double[] numbers = { 5.8, 4.3, 1.5, 3.7, 9.3 };
        Dictionary<bool, List<double>> numberGroups = numbers.GroupBy(n => n > 3)
            .ToDictionary(g => g.Key, g => g.ToList());
        return numberGroups;
    }

    public List<Tuple<char, List<string>>> StringGroupByFirstChar() {
        string[] words = { "blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese" };
        List<Tuple<char, List<string>>> wordsGroups = words.GroupBy(w => w[0])
            .Select(g => Tuple.Create(g.Key, g.ToList())).ToList();
        return wordsGroups;
    }

    public Dictionary<char, List<string>> StringGroupByFirstCharDict() {
        string[] words = { "blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese" };
        Dictionary<char, List<string>> wordsGroups = words.GroupBy(w => w[0])
            .ToDictionary(g => g.Key, g => g.ToList());
        return wordsGroups;
    }

    public List<Tuple<bool, List<string>>> StringGroupByLength() {
        string[] words = { "blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese" };
        List<Tuple<bool, List<string>>> wordsGroups = words.GroupBy(w => w.Length > 8)
            .Select(g => Tuple.Create(g.Key, g.ToList())).ToList();
        return wordsGroups;
    }

    public Dictionary<bool, List<string>> StringGroupByLengthDict() {
        string[] words = { "blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese" };
        Dictionary<bool, List<string>> wordsGroups = words.GroupBy(w => w.Length > 8)
            .ToDictionary(g => g.Key, g => g.ToList());
        return wordsGroups;
    }

    public List<Tuple<string, List<Product>>> ProductGroupByCategory() {
        List<Product> products = GetProductList();
        List<Tuple<string, List<Product>>> category = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key, g.ToList())).ToList();
        return category;
    }

    public Dictionary<string, List<Product>> ProductGroupByCategoryDict() {
        List<Product> products = GetProductList();
        Dictionary<string, List<Product>> category = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key, g => g.ToList());
        return category;
    }

    public List<Tuple<string, List<int>>> ProductGroupByCategoryWithId() {
        List<Product> products = GetProductList();
        List<Tuple<string, List<int>>> category = products.GroupBy(p => p.Category)
            .Select(g => Tuple.Create(g.Key, g.Select(p => p.ProductId).ToList())).ToList();
        return category;
    }

    public Dictionary<string, List<int>> ProductGroupByCategoryWithIdDict() {
        List<Product> products = GetProductList();
        Dictionary<string, List<int>> category = products.GroupBy(p => p.Category)
            .ToDictionary(g => g.Key, g => g.Select(p => p.ProductId).ToList());
        return category;
    }

    public List<Tuple<bool, List<Product>>> ProductGroupByPrice() {
        List<Product> products = GetProductList();
        List<Tuple<bool, List<Product>>> productGroup = products.GroupBy(p => p.UnitPrice > 100)
            .Select(g => Tuple.Create(g.Key, g.ToList())).ToList();
        return productGroup;
    }

    public Dictionary<bool, List<Product>> ProductGroupByPriceDict() {
        List<Product> products = GetProductList();
        Dictionary<bool, List<Product>> productGroup = products.GroupBy(p => p.UnitPrice > 100)
            .ToDictionary(g => g.Key, g => g.ToList());
        return productGroup;
    }

    public Dictionary<bool, List<Product>> ProductGroupByPriceDictPrint() {
        List<Product> products = GetProductList();
        Dictionary<bool, List<Product>> productGroup = products.GroupBy(p => p.UnitPrice > 100)
            .ToDictionary(g => g.Key, g => g.ToList());
        productGroup[true].ForEach(p => Console.Write(p));
        Console.WriteLine();
        productGroup[false].ForEach(p => Console.Write(p));
        return productGroup;
    }

    public List<Tuple<bool, List<int>>> ProductGroupByPriceWithId() {
        List<Product> products = GetProductList();
        List<Tuple<bool, List<int>>> productGroup = products.GroupBy(p => p.UnitPrice > 100)
            .Select(g => Tuple.Create(g.Key, g.Select(p => p.ProductId).ToList())).ToList();
        return productGroup;
    }

    public Dictionary<bool, List<int>> ProductGroupByPriceWithIdDict() {
        List<Product> products = GetProductList();
        Dictionary<bool, List<int>> productGroup = products.GroupBy(p => p.UnitPrice > 100)
            .ToDictionary(g => g.Key, g => g.Select(p => p.ProductId).ToList());
        return productGroup;
    }

    public Dictionary<bool, List<int>> ProductGroupByPriceWithIdDictPrint() {
        List<Product> products = GetProductList();
        Dictionary<bool, List<int>> productGroup = products.GroupBy(p => p.UnitPrice > 100)
            .ToDictionary(g => g.Key, g => g.Select(p => p.ProductId).ToList());
        productGroup[true].ForEach(p => Console.Write(p));
        Console.WriteLine();
        productGroup[false].ForEach(p => Console.Write(p));
        return productGroup;
    }

    public List<Tuple<bool, List<Product>>> ProductGroupByInStock() {
        List<Product> products = GetProductList();
        List<Tuple<bool, List<Product>>> productGroup = products.GroupBy(p => p.UnitsInStock == 0)
            .Select(g => Tuple.Create(g.Key, g.ToList())).ToList();
        return productGroup;
    }

    public Dictionary<bool, List<Product>> ProductGroupByInStockDict() {
        List<Product> products = GetProductList();
        Dictionary<bool, List<Product>> productGroup = products.GroupBy(p => p.UnitsInStock == 0)
            .ToDictionary(g => g.Key, g => g.ToList());
        return productGroup;
    }

    public Dictionary<bool, List<Product>> ProductGroupByInStockDictPrint() {
        List<Product> products = GetProductList();
        Dictionary<bool, List<Product>> productGroup = products.GroupBy(p => p.UnitsInStock == 0)
            .ToDictionary(g => g.Key, g => g.ToList());
        productGroup[true].ForEach(p => Console.Write(p));
        Console.WriteLine();
        productGroup[false].ForEach(p => Console.Write(p));
        return productGroup;
    }

    public List<Tuple<bool, List<int>>> ProductGroupByInStockWithId() {
        List<Product> products = GetProductList();
        List<Tuple<bool, List<int>>> productGroup = products.GroupBy(p => p.UnitsInStock == 0)
            .Select(g => Tuple.Create(g.Key, g.Select(p => p.ProductId).ToList())).ToList();
        return productGroup;
    }

    public Dictionary<bool, List<int>> ProductGroupByInStockWithIdDict() {
        List<Product> products = GetProductList();
        Dictionary<bool, List<int>> productGroup = products.GroupBy(p => p.UnitsInStock == 0)
            .ToDictionary(g => g.Key, g => g.Select(p => p.ProductId).ToList());
        return productGroup;
    }

    public Dictionary<bool, List<int>> ProductGroupByInStockWithIdDictPrint() {
        List<Product> products = GetProductList();
        Dictionary<bool, List<int>> productGroup = products.GroupBy(p => p.UnitsInStock == 0)
            .ToDictionary(g => g.Key, g => g.Select(p => p.ProductId).ToList());
        productGroup[true].ForEach(p => Console.Write(p));
        Console.WriteLine();
        productGroup[false].ForEach(p => Console.Write(p));
        return productGroup;
    }

    public List<Tuple<string, List<Customer>>> CustomerGroupByRegion() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, List<Customer>>> catagory = customers.GroupBy(c => c.Region)
            .Select(g => Tuple.Create(g.Key, g.ToList())).ToList();
        return catagory;
    }

    public Dictionary<string, List<Customer>> CustomerGroupByRegionDict() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, List<Customer>> catagory = customers.GroupBy(c => c.Region)
            .ToDictionary(g => g.Key, g => g.ToList());
        return catagory;
    }

    public Dictionary<string, Dictionary<string, Customer>> CustomerNestedGroupByRegionAndName() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, Dictionary<string, Customer>> customerGroups = customers.GroupBy(
            c => c.Region).ToDictionary(g => g.Key,
            g => g.ToDictionary(
                c => c.CompanyName,
                c => c));
        return customerGroups;
    }

    public Dictionary<string, Dictionary<string, List<Customer>>> CustomerNestedGroupByRegionAndCountry() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, Dictionary<string, List<Customer>>> customerGroups = customers.GroupBy(
            c => c.Region).ToDictionary(g => g.Key,
            g => g.GroupBy(c => c.Country).ToDictionary(
                g => g.Key,
                g => g.ToList()));
        return customerGroups;
    }

    public Dictionary<string, Dictionary<string, Dictionary<string, Customer>>>
        CustomerNestedGroupByRegionAndCountryAndName() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, Dictionary<string, Dictionary<string, Customer>>> customerGroups = customers.GroupBy(
            c => c.Region).ToDictionary(g => g.Key,
            g => g.GroupBy(c => c.Country).ToDictionary(
                g => g.Key,
                g => g.ToDictionary(
                    c => c.CompanyName,
                    c => c)));
        return customerGroups;
    }

    public Dictionary<string, Dictionary<string, Dictionary<string, Customer>>>
        CustomerNestedGroupByRegionAndCountryAndNamePrint() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, Dictionary<string, Dictionary<string, Customer>>> customerGroups = customers.GroupBy(
            c => c.Region).ToDictionary(g => g.Key,
            g => g.GroupBy(c => c.Country).ToDictionary(
                g => g.Key,
                g => g.ToDictionary(
                    c => c.CompanyName,
                    c => c)));
        foreach (var e1 in customerGroups) {
            Console.WriteLine(e1.Key + ":");
            foreach (var e2 in e1.Value) {
                Console.WriteLine("\t" + e2.Key + ":");
                foreach (var e3 in e2.Value)
                    Console.WriteLine("\t\t" + e3.Key + ":" + e3.Value);
            }
        }
        return customerGroups;
    }

    public Dictionary<string, Dictionary<int, List<Order>>> CustomerNestedGroupByNameAndOrderYear() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, Dictionary<int, List<Order>>> customerOrderGroups = customers.ToDictionary(
            c => c.CompanyName,
            c => c.Orders.GroupBy(o => o.OrderDate.Year).ToDictionary(
                yg => yg.Key,
                yg => yg.ToList()
            )
        );
        return customerOrderGroups;
    }

    public Dictionary<int, Dictionary<int, List<Order>>> CustomerNestedGroupByOrderYearAndMonth() {
        List<Customer> customers = GetCustomerList();
        Dictionary<int, Dictionary<int, List<Order>>> customerOrderGroups = customers.SelectMany(c => c.Orders)
            .GroupBy(o => o.OrderDate.Year).ToDictionary(
                yg => yg.Key,
                yg => yg.GroupBy(o => o.OrderDate.Month).ToDictionary(
                    mg => mg.Key,
                    mg => mg.ToList())
            );
        return customerOrderGroups;
    }

    public Dictionary<int, Dictionary<int, List<Order>>> CustomerNestedGroupByOrderYearAndMonthPrint() {
        List<Customer> customers = GetCustomerList();
        Dictionary<int, Dictionary<int, List<Order>>> customerOrderGroups = customers.SelectMany(c => c.Orders)
            .GroupBy(o => o.OrderDate.Year).ToDictionary(
                yg => yg.Key,
                yg => yg.GroupBy(o => o.OrderDate.Month).ToDictionary(
                    mg => mg.Key,
                    mg => mg.ToList())
            );
        foreach (var e1 in customerOrderGroups) {
            Console.WriteLine(e1.Key + ":");
            foreach (var e2 in e1.Value) {
                Console.WriteLine("\t" + e2.Key + ":");
                e2.Value.ForEach(o => Console.WriteLine("\t\t" + o));
            }
        }
        return customerOrderGroups;
    }

    public Dictionary<string, Dictionary<int, Dictionary<int, List<Order>>>>
        CustomerNestedGroupByNameAndOrderYearAndMonth() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, Dictionary<int, Dictionary<int, List<Order>>>> customerOrderGroups = customers.ToDictionary(
            c => c.CompanyName,
            c => c.Orders.GroupBy(o => o.OrderDate.Year).ToDictionary(
                yg => yg.Key,
                yg => yg.GroupBy(o => o.OrderDate.Month).ToDictionary(
                    mg => mg.Key,
                    mg => mg.ToList()
                )
            ));
        return customerOrderGroups;
    }

    public Dictionary<string, Dictionary<int, Dictionary<int, List<Order>>>>
        CustomerNestedGroupByNameAndOrderYearAndMonthPrint() {
        List<Customer> customers = GetCustomerList();
        Dictionary<string, Dictionary<int, Dictionary<int, List<Order>>>> customerOrderGroups = customers.ToDictionary(
            c => c.CompanyName,
            c => c.Orders.GroupBy(o => o.OrderDate.Year).ToDictionary(
                yg => yg.Key,
                yg => yg.GroupBy(o => o.OrderDate.Month).ToDictionary(
                    mg => mg.Key,
                    mg => mg.ToList()
                )
            ));
        foreach (var e1 in customerOrderGroups) {
            Console.WriteLine(e1.Key + ":");
            foreach (var e2 in e1.Value) {
                Console.WriteLine("\t" + e2.Key + ":");
                foreach (var e3 in e2.Value) {
                    Console.WriteLine("\t\t" + e3.Key + ":");
                    e3.Value.ForEach(o => Console.WriteLine("\t\t\t" + o));
                }
            }
        }
        return customerOrderGroups;
    }
}