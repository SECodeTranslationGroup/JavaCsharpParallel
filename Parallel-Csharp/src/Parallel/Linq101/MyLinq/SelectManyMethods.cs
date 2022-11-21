using Parallel.Linq101.DataSources;

namespace Parallel.Linq101.MyLinq;

public class SelectManyMethods {
    //original:6 target:30 form Projections
    public List<Product> GetProductList() => Products.ProductList;
    public List<Customer> GetCustomerList() => Customers.CustomerList;
    public Tuple<int, int>[] SelectManyJoin() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8 };
        Tuple<int, int>[] pairs = numbersA.SelectMany(a => numbersB,
            (a, b) => Tuple.Create(a, b)).ToArray();
        return pairs;
    }

    public Tuple<int, int>[] SelectManyJoinOdd() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8 };
        Tuple<int, int>[] pairs = numbersA.SelectMany(a => numbersB.Where(b => b % 2 == 1),
            (a, b) => Tuple.Create(a, b)).ToArray();
        return pairs;
    }

    public Tuple<int, int>[] SelectManyJoinBig() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8 };
        Tuple<int, int>[] pairs = numbersA.SelectMany(a => numbersB.Where(b => b > 5),
            (a, b) => Tuple.Create(a, b)).ToArray();
        return pairs;
    }

    public Tuple<int, int>[] SelectManyJoinSmaller() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8 };
        Tuple<int, int>[] pairs = numbersA.SelectMany(a => numbersB.Where(b => a < b),
            (a, b) => Tuple.Create(a, b)).ToArray();
        return pairs;
    }

    public Tuple<int, int>[] SelectManyJoinSumEven() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8 };
        Tuple<int, int>[] pairs = numbersA.SelectMany(a => numbersB.Where(b => (a + b) % 2 == 0),
            (a, b) => Tuple.Create(a, b)).ToArray();
        return pairs;
    }
    
    public List<Order> CustomerSelectManyOrders() {
        List<Customer> customers = GetCustomerList();
        List<Order> customerProperties = customers.SelectMany(c=>
            c.Orders).ToList();
        return customerProperties;
    }
    
    public List<Tuple<string,Order>> CustomerSelectManyCustomerOrders() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,Order>> customerProperties = customers.SelectMany(c=>c.Orders,
            (c,o)=>Tuple.Create(c.CustomerId, o)).ToList();
        return customerProperties;
    }
    
    public List<Tuple<string,DateTime>> CustomerSelectManyCustomerOrderDates() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,DateTime>> customerProperties = customers.SelectMany(c=>c.Orders,
            (c,o)=>Tuple.Create(c.CustomerId, o.OrderDate)).ToList();
        return customerProperties;
    }
    
    public List<Tuple<string,int,double>> CustomerSelectManyCustomerOrderIdAndTotals() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,int,double>> customerProperties = customers.SelectMany(c=>c.Orders,
            (c,o)=>Tuple.Create(c.CustomerId, o.OrderId, o.Total)).ToList();
        return customerProperties;
    }
    public List<Tuple<string,int,int>> CustomerSelectManyCustomerOrderDateYearAndMonth() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,int,int>> customerProperties = customers.SelectMany(c=>c.Orders,
            (c,o)=>Tuple.Create(c.CustomerId, o.OrderDate.Year,o.OrderDate.Month)).ToList();
        return customerProperties;
    }
    
    public List<Order> CustomerSelectManyBigOrders() {
        List<Customer> customers = GetCustomerList();
        List<Order> customerProperties = customers.SelectMany(c=>
            c.Orders.Where(o=>o.Total>100)).ToList();
        return customerProperties;
    }
    
    public List<Tuple<string,Order>> CustomerSelectManyCustomerBigOrders() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,Order>> customerProperties = customers.SelectMany(c=>c.Orders.Where(o=>o.Total>100),
            (c,o)=>Tuple.Create(c.CustomerId, o)).ToList();
        return customerProperties;
    }
    
    public List<Tuple<string,DateTime>> CustomerSelectManyCustomerBigOrderDates() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,DateTime>> customerProperties = customers.SelectMany(c=>c.Orders.Where(o=>o.Total>100),
            (c,o)=>Tuple.Create(c.CustomerId, o.OrderDate)).ToList();
        return customerProperties;
    }
    
    public List<Tuple<string,int,double>> CustomerSelectManyCustomerBigOrderIdAndTotals() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,int,double>> customerProperties = customers.SelectMany(c=>c.Orders.Where(o=>o.Total>100),
            (c,o)=>Tuple.Create(c.CustomerId, o.OrderId, o.Total)).ToList();
        return customerProperties;
    }
    public List<Tuple<string,int,int>> CustomerSelectManyCustomerBigOrderDateYearAndMonth() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,int,int>> customerProperties = customers.SelectMany(c=>c.Orders.Where(o=>o.Total>100),
            (c,o)=>Tuple.Create(c.CustomerId, o.OrderDate.Year,o.OrderDate.Month)).ToList();
        return customerProperties;
    }
    
    public List<Order> CustomerSelectManyNewOrders() {
        List<Customer> customers = GetCustomerList();
        List<Order> customerProperties = customers.SelectMany(c=>
            c.Orders.Where(o=>o.OrderDate>new DateTime(1998, 1, 1))).ToList();
        return customerProperties;
    }
    
    public List<Tuple<string,Order>> CustomerSelectManyCustomerNewOrders() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,Order>> customerProperties = customers.SelectMany(
            c=>c.Orders.Where(o=>o.OrderDate>new DateTime(1998, 1, 1)),
            (c,o)=>Tuple.Create(c.CustomerId, o)).ToList();
        return customerProperties;
    }
    
    public List<Tuple<string,DateTime>> CustomerSelectManyCustomerNewOrderDates() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,DateTime>> customerProperties = customers.SelectMany(
            c=>c.Orders.Where(o=>o.OrderDate>new DateTime(1998, 1, 1)),
            (c,o)=>Tuple.Create(c.CustomerId, o.OrderDate)).ToList();
        return customerProperties;
    }
    
    public List<Tuple<string,int,double>> CustomerSelectManyCustomerNewOrderIdAndTotals() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,int,double>> customerProperties = customers.SelectMany(
            c=>c.Orders.Where(o=>o.OrderDate>new DateTime(1998, 1, 1)),
            (c,o)=>Tuple.Create(c.CustomerId, o.OrderId, o.Total)).ToList();
        return customerProperties;
    }
    public List<Tuple<string,int,int>> CustomerSelectManyCustomerNewOrderDateYearAndMonth() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,int,int>> customerProperties = customers.SelectMany(
            c=>c.Orders.Where(o=>o.OrderDate>new DateTime(1998, 1, 1)),
            (c,o)=>Tuple.Create(c.CustomerId, o.OrderDate.Year,o.OrderDate.Month)).ToList();
        return customerProperties;
    }
    
    public List<Order> WaCustomerSelectManyNewOrders() {
        List<Customer> customers = GetCustomerList();
        List<Order> customerProperties = customers.Where(c => c.Region == "WA").SelectMany(c=>
            c.Orders.Where(o=>o.OrderDate>new DateTime(1998, 1, 1))).ToList();
        return customerProperties;
    }
    
    public List<Tuple<string,Order>> WaCustomerSelectManyCustomerNewOrders() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,Order>> customerProperties = customers.Where(c => c.Region == "WA").SelectMany(
            c=>c.Orders.Where(o=>o.OrderDate>new DateTime(1998, 1, 1)),
            (c,o)=>Tuple.Create(c.CustomerId, o)).ToList();
        return customerProperties;
    }
    
    public List<Tuple<string,DateTime>> WaCustomerSelectManyCustomerNewOrderDates() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,DateTime>> customerProperties = customers.Where(c => c.Region == "WA").SelectMany(
            c=>c.Orders.Where(o=>o.OrderDate>new DateTime(1998, 1, 1)),
            (c,o)=>Tuple.Create(c.CustomerId, o.OrderDate)).ToList();
        return customerProperties;
    }
    
    public List<Tuple<string,int,double>> WaCustomerSelectManyCustomerNewOrderIdAndDates() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,int,double>> customerProperties = customers.Where(c => c.Region == "WA").SelectMany(
            c=>c.Orders.Where(o=>o.OrderDate>new DateTime(1998, 1, 1)),
            (c,o)=>Tuple.Create(c.CustomerId, o.OrderId, o.Total)).ToList();
        return customerProperties;
    }
    public List<Tuple<string,int,int>> WaCustomerSelectManyCustomerNewOrderDateYearAndMonth() {
        List<Customer> customers = GetCustomerList();
        List<Tuple<string,int,int>> customerProperties = customers.Where(c => c.Region == "WA").SelectMany(
            c=>c.Orders.Where(o=>o.OrderDate>new DateTime(1998, 1, 1)),
            (c,o)=>Tuple.Create(c.CustomerId, o.OrderDate.Year,o.OrderDate.Month)).ToList();
        return customerProperties;
    }
    
    public int[] IndexedSelectMany() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8 };
        int[] pairs = numbersA.SelectMany((a,i) => numbersB.Select(
                b=>i%2==0?a:b)).ToArray();
        return pairs;
    }
    
    public int[] IndexedSelectManyBig() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8 };
        int[] pairs = numbersA.SelectMany((a,i) => numbersB.Where(b=>b<a+i)).ToArray();
        return pairs;
    }
    public List<Order> CustomerIndexedSelectManyOrdersTake() {
        List<Customer> customers = GetCustomerList();
        List<Order> customerProperties = customers.SelectMany((c,i)=>
            c.Orders.Take(i<10?5:1).ToList()).ToList();
        return customerProperties;
    }
    
    public List<Order> WaCustomerIndexedSelectManyOrdersTake() {
        List<Customer> customers = GetCustomerList();
        List<Order> customerProperties = customers.Where(c=>c.Region=="WA").SelectMany((c,i)=>
            c.Orders.Take(i<10?5:1).ToList()).ToList();
        return customerProperties;
    }
    
    public List<string> IndexedSelectManyString() {
        List<Customer> customers = GetCustomerList();
        List<string> customerOrders = customers.SelectMany((c, i) => c.Orders.Select(o => 
            "Customer #" + (i + 1) + " has an order with OrderID " + o.OrderId)).ToList();
        return customerOrders;
    }
}