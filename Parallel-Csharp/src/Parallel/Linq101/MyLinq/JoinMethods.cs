using System.Collections;
using Parallel.Linq101.DataSources;

namespace Parallel.Linq101.MyLinq;

public class JoinMethods {
    public List<Product> GetProductList() => Products.ProductList;

    public List<Customer> GetCustomerList() => Customers.CustomerList;

    //original:4 target:40 form JoinOperators 
    public List<Tuple<string, Product>> ProductCrossJoinCategories() {
        string[] categories = { "Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood" };
        List<Product> products = GetProductList();
        List<Tuple<string, Product>> q = categories.Join(products, c => c, p => p.Category,
            (c, p) => Tuple.Create(c, p)).ToList();
        return q;
    }

    public List<Tuple<string, string>> ProductCrossJoinCategoriesName() {
        string[] categories = { "Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood" };
        List<Product> products = GetProductList();
        List<Tuple<string, string>> q = categories.Join(products, c => c, p => p.Category,
            (c, p) => Tuple.Create(c, p.ProductName)).ToList();
        return q;
    }

    public List<Tuple<string, double>> ProductCrossJoinCategoriesUnitPrice() {
        string[] categories = { "Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood" };
        List<Product> products = GetProductList();
        List<Tuple<string, double>> q = categories.Join(products, c => c, p => p.Category,
            (c, p) => Tuple.Create(c, p.UnitPrice)).ToList();
        return q;
    }

    public List<Tuple<string, Customer>> CustomerCrossJoinRegions() {
        string[] regions = { "BC", "SP", "OR", "LA" };
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, Customer>> q = regions.Join(customers, r => r, c => c.Region,
            (r, c) => Tuple.Create(r, c)).ToList();
        return q;
    }

    public List<Tuple<string, string>> CustomerCrossJoinRegionsName() {
        string[] regions = { "BC", "SP", "OR", "LA" };
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, string>> q = regions.Join(customers, r => r, c => c.Region,
            (r, c) => Tuple.Create(r, c.CompanyName)).ToList();
        return q;
    }

    public List<Tuple<string, string>> CustomerCrossJoinRegionsPhone() {
        string[] regions = { "BC", "SP", "OR", "LA" };
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, string>> q = regions.Join(customers, r => r, c => c.Region,
            (r, c) => Tuple.Create(r, c.Phone)).ToList();
        return q;
    }

    public List<Tuple<int, Customer>> CustomerCrossJoinRegionsWithCode() {
        List<Tuple<string, int>> regions = new List<Tuple<string, int>>{
            Tuple.Create("BC", 101), Tuple.Create("BC", 105),
            Tuple.Create("OR", 121), Tuple.Create("LA", 143)
        };
        List<Customer> customers = GetCustomerList();
        List<Tuple<int, Customer>> q = regions.Join(customers, r => r.Item1, c => c.Region,
            (r, c) => Tuple.Create(r.Item2, c)).ToList();
        return q;
    }

    public List<Tuple<int, string>> CustomerCrossJoinRegionsWithCodeName() {
        List<Tuple<string, int>> regions = new List<Tuple<string, int>>{
            Tuple.Create("BC", 101), Tuple.Create("BC", 105),
            Tuple.Create("OR", 121), Tuple.Create("LA", 143)
        };
        List<Customer> customers = GetCustomerList();
        List<Tuple<int, string>> q = regions.Join(customers, r => r.Item1, c => c.Region,
            (r, c) => Tuple.Create(r.Item2, c.CompanyName)).ToList();
        return q;
    }

    public List<Tuple<string, int, Customer>> CustomerCrossJoinRegionsWithCodeRegion() {
        List<Tuple<string, int>> regions = new List<Tuple<string, int>>{
            Tuple.Create("BC", 101), Tuple.Create("BC", 105),
            Tuple.Create("OR", 121), Tuple.Create("LA", 143)
        };
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, int, Customer>> q = regions.Join(customers, r => r.Item1, c => c.Region,
            (r, c) => Tuple.Create(r.Item1, r.Item2, c)).ToList();
        return q;
    }

    public List<Tuple<string, int, string>> CustomerCrossJoinRegionsWithCodeNameRegion() {
        List<Tuple<string, int>> regions = new List<Tuple<string, int>>{
            Tuple.Create("BC", 101), Tuple.Create("BC", 105),
            Tuple.Create("OR", 121), Tuple.Create("LA", 143)
        };
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, int, string>> q = regions.Join(customers, r => r.Item1, c => c.Region,
            (r, c) => Tuple.Create(r.Item1, r.Item2, c.CompanyName)).ToList();
        return q;
    }

    //group join
    public Dictionary<string, List<Product>> ProductGroupJoinCategories() {
        string[] categories = { "Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood" };
        List<Product> products = GetProductList();
        Dictionary<string, List<Product>> q = categories.GroupJoin(products, c => c, p => p.Category,
                (c, p) => Tuple.Create(c, p.ToList()))
            .ToDictionary(t => t.Item1, t => t.Item2);
        return q;
    }
    
    public Dictionary<string, List<string>> ProductGroupJoinCategoriesName() {
        string[] categories = { "Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood" };
        List<Product> products = GetProductList();
        Dictionary<string, List<string>> q = categories.GroupJoin(products, c => c, p => p.Category,
                (c, p) => Tuple.Create(c, p.Select(p1=>p1.ProductName).ToList()))
            .ToDictionary(t => t.Item1, t => t.Item2);
        return q;
    }

    public Dictionary<string, List<double>>  ProductGroupJoinCategoriesUnitPrice() {
        string[] categories = { "Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood" };
        List<Product> products = GetProductList();
        Dictionary<string, List<double>> q = categories.GroupJoin(products, c => c, p => p.Category,
                (c, p) => Tuple.Create(c, p.Select(p1=>p1.UnitPrice).ToList()))
            .ToDictionary(t => t.Item1, t => t.Item2);
        return q;
    }

    public Dictionary<string, List<Customer>>  CustomerGroupJoinRegions() {
        string[] regions = { "BC", "SP", "OR", "LA" };
        List<Customer> customers = GetCustomerList();
        Dictionary<string, List<Customer>> q = regions.GroupJoin(customers, r => r, c => c.Region,
                (r, c) => Tuple.Create(r, c.ToList()))
            .ToDictionary(t => t.Item1, t => t.Item2);
        return q;
    }
    
    public Dictionary<string, List<string>>  CustomerGroupJoinRegionsName() {
        string[] regions = { "BC", "SP", "OR", "LA" };
        List<Customer> customers = GetCustomerList();
        Dictionary<string, List<string>> q = regions.GroupJoin(customers, r => r, c => c.Region,
                (r, c) => Tuple.Create(r, c.Select(c1=>c1.CompanyName).ToList()))
            .ToDictionary(t => t.Item1, t => t.Item2);
        return q;
    }
    
    public Dictionary<string, List<string>>  CustomerGroupJoinRegionsPhone() {
        string[] regions = { "BC", "SP", "OR", "LA" };
        List<Customer> customers = GetCustomerList();
        Dictionary<string, List<string>> q = regions.GroupJoin(customers, r => r, c => c.Region,
                (r, c) => Tuple.Create(r, c.Select(c1=>c1.Phone).ToList()))
            .ToDictionary(t => t.Item1, t => t.Item2);
        return q;
    }
    
    public Dictionary<int, List<Customer>>  CustomerGroupJoinRegionsWithCode() {
        List<Tuple<string, int>> regions = new List<Tuple<string, int>>{
            Tuple.Create("BC", 101), Tuple.Create("BC", 105),
            Tuple.Create("OR", 121), Tuple.Create("LA", 143)
        };
        List<Customer> customers = GetCustomerList();
        Dictionary<int, List<Customer>> q = regions.GroupJoin(customers, r => r.Item1, c => c.Region,
                (r, c) => Tuple.Create(r.Item2, c.ToList()))
            .ToDictionary(t => t.Item1, t => t.Item2);
        return q;
    }

    public  Dictionary<int, List<string>> CustomerGroupJoinRegionsWithCodeName() {
        List<Tuple<string, int>> regions = new List<Tuple<string, int>>{
            Tuple.Create("BC", 101), Tuple.Create("BC", 105),
            Tuple.Create("OR", 121), Tuple.Create("LA", 143)
        };
        List<Customer> customers = GetCustomerList();
        Dictionary<int, List<string>> q = regions.GroupJoin(customers, r => r.Item1, c => c.Region,
                (r, c) => Tuple.Create(r.Item2, c.Select(c=>c.CompanyName).ToList()))
            .ToDictionary(t => t.Item1, t => t.Item2);
        return q;
    }
    
    public Dictionary<Tuple<string,int>, List<Customer>> CustomerGroupJoinRegionsWithCodeRegion() {
        List<Tuple<string, int>> regions = new List<Tuple<string, int>>{
            Tuple.Create("BC", 101), Tuple.Create("BC", 105),
            Tuple.Create("OR", 121), Tuple.Create("LA", 143)
        };
        List<Customer> customers = GetCustomerList();
        Dictionary<Tuple<string,int>, List<Customer>> q = regions.GroupJoin(customers, r => r.Item1, c => c.Region,
                (r, c) => Tuple.Create(r, c.ToList()))
            .ToDictionary(t => t.Item1, t => t.Item2);
        return q;
    }
    
    public Dictionary<Tuple<string,int>, List<string>> CustomerGroupJoinRegionsWithCodeNameRegion() {
        List<Tuple<string, int>> regions = new List<Tuple<string, int>>{
            Tuple.Create("BC", 101), Tuple.Create("BC", 105),
            Tuple.Create("OR", 121), Tuple.Create("LA", 143)
        };
        List<Customer> customers = GetCustomerList();
        Dictionary<Tuple<string,int>, List<string>> q = regions.GroupJoin(customers, r => r.Item1, c => c.Region,
                (r, c) => Tuple.Create(r, c.Select(c=>c.CompanyName).ToList()))
            .ToDictionary(t => t.Item1, t => t.Item2);
        return q;
    }
    //cross group join
    public List<Tuple<string, Product>> ProductCrossGroupJoinCategories() {
        string[] categories = { "Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood" };
        List<Product> products = GetProductList();
        List<Tuple<string, Product>> q = categories.GroupJoin(products, c => c, p => p.Category,
                (c, p) => Tuple.Create(c, p))
            .SelectMany(t => t.Item2,
                (t, p) => Tuple.Create(t.Item1, p)).ToList();
        return q;
    }
    
    public List<Tuple<string, string>> ProductCrossGroupJoinCategoriesName() {
        string[] categories = { "Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood" };
        List<Product> products = GetProductList();
        List<Tuple<string, string>> q = categories.GroupJoin(products, c => c, p => p.Category,
                (c, p) => Tuple.Create(c, p))
            .SelectMany(t => t.Item2.Select(p=>p.ProductName),
                (t, n) => Tuple.Create(t.Item1, n)).ToList();
        return q;
    }

    public List<Tuple<string, double>>  ProductCrossGroupJoinCategoriesUnitPrice() {
        string[] categories = { "Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood" };
        List<Product> products = GetProductList();
        List<Tuple<string, double>> q = categories.GroupJoin(products, c => c, p => p.Category,
                (c, p) => Tuple.Create(c, p))
            .SelectMany(t => t.Item2.Select(p=>p.UnitPrice),
                (t, n) => Tuple.Create(t.Item1, n)).ToList();
        return q;
    }

    public List<Tuple<string, Customer>> CustomerCrossGroupJoinRegions() {
        string[] regions = { "BC", "SP", "OR", "LA" };
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, Customer>> q = regions.GroupJoin(customers, r => r, c => c.Region,
                (r, c) => Tuple.Create(r, c)).SelectMany(t=>t.Item2
            ,(t, c) => Tuple.Create(t.Item1, c)).ToList();
        return q;
    }
    
    public List<Tuple<string, string>> CustomerCrossGroupJoinRegionsName() {
        string[] regions = { "BC", "SP", "OR", "LA" };
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, string>> q = regions.GroupJoin(customers, r => r, c => c.Region,
            (r, c) => Tuple.Create(r, c)).SelectMany(t=>
                t.Item2.Select(c=>c.CompanyName)
            ,(t, c) => Tuple.Create(t.Item1, c)).ToList();
        return q;
    }
    
    public List<Tuple<string, string>> CustomerCrossGroupJoinRegionsPhone() {
        string[] regions = { "BC", "SP", "OR", "LA" };
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, string>> q = regions.GroupJoin(customers, r => r, c => c.Region,
            (r, c) => Tuple.Create(r, c)).SelectMany(t=>
                t.Item2.Select(c=>c.Phone)
            ,(t, c) => Tuple.Create(t.Item1, c)).ToList();
        return q;
    }
    
    public List<Tuple<int, Customer>> CustomerCrossGroupJoinRegionsWithCode() {
        List<Tuple<string, int>> regions = new List<Tuple<string, int>>{
            Tuple.Create("BC", 101), Tuple.Create("BC", 105),
            Tuple.Create("OR", 121), Tuple.Create("LA", 143)
        };
        List<Customer> customers = GetCustomerList();
        List<Tuple<int, Customer>> q = regions.GroupJoin(customers, r => r.Item1, c => c.Region,
            (r, c) => Tuple.Create(r.Item2, c)).SelectMany(t=>
                t.Item2,(t, c) => Tuple.Create(t.Item1, c)).ToList();
        return q;
    }

    public List<Tuple<int, string>> CustomerCrossGroupJoinRegionsWithCodeName() {
        List<Tuple<string, int>> regions = new List<Tuple<string, int>>{
            Tuple.Create("BC", 101), Tuple.Create("BC", 105),
            Tuple.Create("OR", 121), Tuple.Create("LA", 143)
        };
        List<Customer> customers = GetCustomerList();
        List<Tuple<int, string>> q = regions.GroupJoin(customers, r => r.Item1, c => c.Region,
            (r, c) => Tuple.Create(r.Item2, c)).SelectMany(t=>
            t.Item2.Select(c=>c.CompanyName),(t, c) => Tuple.Create(t.Item1, c)).ToList();
        return q;
    }
    
    public List<Tuple<Tuple<string, int>, Customer>>  CustomerCrossGroupJoinRegionsWithCodeRegion() {
        List<Tuple<string, int>> regions = new List<Tuple<string, int>>{
            Tuple.Create("BC", 101), Tuple.Create("BC", 105),
            Tuple.Create("OR", 121), Tuple.Create("LA", 143)
        };
        List<Customer> customers = GetCustomerList();
        List<Tuple<Tuple<string, int>, Customer>> q = regions.GroupJoin(customers, r => r.Item1, c => c.Region,
            (r, c) => Tuple.Create(r, c)).SelectMany(t=>
            t.Item2,(t, c) => Tuple.Create(t.Item1, c)).ToList();
        return q;
    }
    
    public List<Tuple<Tuple<string, int>, string>> CustomerCrossGroupJoinRegionsWithCodeNameRegion() {
        List<Tuple<string, int>> regions = new List<Tuple<string, int>>{
            Tuple.Create("BC", 101), Tuple.Create("BC", 105),
            Tuple.Create("OR", 121), Tuple.Create("LA", 143)
        };
        List<Customer> customers = GetCustomerList();
        List<Tuple<Tuple<string, int>, string>> q = regions.GroupJoin(customers, r => r.Item1, c => c.Region,
            (r, c) => Tuple.Create(r, c)).SelectMany(t=>
            t.Item2.Select(c=>c.CompanyName),(t, c) => Tuple.Create(t.Item1, c)).ToList();
        return q;
    }
    //left outer join
    public List<Tuple<string, Product>> ProductLeftOuterJoinCategories() {
        string[] categories = { "Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood" };
        List<Product> products = GetProductList();
        List<Tuple<string, Product>> q = categories.GroupJoin(products, c => c, p => p.Category,
                (c, p) => Tuple.Create(c, p))
            .SelectMany(t => t.Item2.DefaultIfEmpty(null),
                (t, p) => Tuple.Create(t.Item1, p)).ToList();
        return q;
    }
    
    public List<Tuple<string, string>> ProductLeftOuterJoinCategoriesName() {
        string[] categories = { "Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood" };
        List<Product> products = GetProductList();
        List<Tuple<string, string>> q = categories.GroupJoin(products, c => c, p => p.Category,
                (c, p) => Tuple.Create(c, p))
            .SelectMany(t => t.Item2.Select(p=>p.ProductName).DefaultIfEmpty("No Product"),
                (t, n) => Tuple.Create(t.Item1, n)).ToList();
        return q;
    }

    public List<Tuple<string, double>>  ProductLeftOuterJoinCategoriesUnitPrice() {
        string[] categories = { "Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood" };
        List<Product> products = GetProductList();
        List<Tuple<string, double>> q = categories.GroupJoin(products, c => c, p => p.Category,
                (c, p) => Tuple.Create(c, p))
            .SelectMany(t => t.Item2.Select(p=>p.UnitPrice).DefaultIfEmpty(0),
                (t, n) => Tuple.Create(t.Item1, n)).ToList();
        return q;
    }

    public List<Tuple<string, Customer>> CustomerLeftOuterJoinRegions() {
        string[] regions = { "BC", "SP", "OR", "LA" };
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, Customer>> q = regions.GroupJoin(customers, r => r, c => c.Region,
                (r, c) => Tuple.Create(r, c)).SelectMany(t=>t.Item2.DefaultIfEmpty(null)
            ,(t, c) => Tuple.Create(t.Item1, c)).ToList();
        return q;
    }
    
    public List<Tuple<string, string>> CustomerLeftOuterJoinRegionsName() {
        string[] regions = { "BC", "SP", "OR", "LA" };
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, string>> q = regions.GroupJoin(customers, r => r, c => c.Region,
            (r, c) => Tuple.Create(r, c)).SelectMany(t=>
                t.Item2.Select(c=>c.CompanyName).DefaultIfEmpty("No Customer")
            ,(t, c) => Tuple.Create(t.Item1, c)).ToList();
        return q;
    }
    
    public List<Tuple<string, string>> CustomerLeftOuterJoinRegionsPhone() {
        string[] regions = { "BC", "SP", "OR", "LA" };
        List<Customer> customers = GetCustomerList();
        List<Tuple<string, string>> q = regions.GroupJoin(customers, r => r, c => c.Region,
            (r, c) => Tuple.Create(r, c)).SelectMany(t=>
                t.Item2.Select(c=>c.Phone).DefaultIfEmpty("No phone")
            ,(t, c) => Tuple.Create(t.Item1, c)).ToList();
        return q;
    }
    
    public List<Tuple<int, Customer>> CustomerLeftOuterJoinRegionsWithCode() {
        List<Tuple<string, int>> regions = new List<Tuple<string, int>>{
            Tuple.Create("BC", 101), Tuple.Create("BC", 105),
            Tuple.Create("OR", 121), Tuple.Create("LA", 143)
        };
        List<Customer> customers = GetCustomerList();
        List<Tuple<int, Customer>> q = regions.GroupJoin(customers, r => r.Item1, c => c.Region,
            (r, c) => Tuple.Create(r.Item2, c)).SelectMany(t=>
                t.Item2.DefaultIfEmpty(null),(t, c) => Tuple.Create(t.Item1, c)).ToList();
        return q;
    }

    public List<Tuple<int, string>> CustomerLeftOuterJoinRegionsWithCodeName() {
        List<Tuple<string, int>> regions = new List<Tuple<string, int>>{
            Tuple.Create("BC", 101), Tuple.Create("BC", 105),
            Tuple.Create("OR", 121), Tuple.Create("LA", 143)
        };
        List<Customer> customers = GetCustomerList();
        List<Tuple<int, string>> q = regions.GroupJoin(customers, r => r.Item1, c => c.Region,
            (r, c) => Tuple.Create(r.Item2, c)).SelectMany(t=>
            t.Item2.Select(c=>c.CompanyName).DefaultIfEmpty("No Customer"),(t, c) => Tuple.Create(t.Item1, c)).ToList();
        return q;
    }
    
    public List<Tuple<Tuple<string, int>, Customer>>  CustomerLeftOuterJoinRegionsWithCodeRegion() {
        List<Tuple<string, int>> regions = new List<Tuple<string, int>>{
            Tuple.Create("BC", 101), Tuple.Create("BC", 105),
            Tuple.Create("OR", 121), Tuple.Create("LA", 143)
        };
        List<Customer> customers = GetCustomerList();
        List<Tuple<Tuple<string, int>, Customer>> q = regions.GroupJoin(customers, r => r.Item1, c => c.Region,
            (r, c) => Tuple.Create(r, c)).SelectMany(t=>
            t.Item2.DefaultIfEmpty(null),(t, c) => Tuple.Create(t.Item1, c)).ToList();
        return q;
    }
    
    public List<Tuple<Tuple<string, int>, string>> CustomerLeftOuterJoinRegionsWithCodeNameRegion() {
        List<Tuple<string, int>> regions = new List<Tuple<string, int>>{
            Tuple.Create("BC", 101), Tuple.Create("BC", 105),
            Tuple.Create("OR", 121), Tuple.Create("LA", 143)
        };
        List<Customer> customers = GetCustomerList();
        List<Tuple<Tuple<string, int>, string>> q = regions.GroupJoin(customers, r => r.Item1, c => c.Region,
            (r, c) => Tuple.Create(r, c)).SelectMany(t=>
            t.Item2.Select(c=>c.CompanyName).DefaultIfEmpty("No Customer"),(t, c) => Tuple.Create(t.Item1, c)).ToList();
        return q;
    }
}