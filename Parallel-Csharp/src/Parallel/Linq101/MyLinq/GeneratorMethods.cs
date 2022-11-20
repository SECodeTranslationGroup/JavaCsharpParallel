using Parallel.Linq101.DataSources;

namespace Parallel.Linq101.MyLinq; 

public class GeneratorMethods {
    //original:2 target:20 form Generators
    public List<int> RangeOfInts() {
        List<int> numbers = Enumerable.Range(0, 50).ToList();
        return numbers;
    }
    
    public List<int> RangeOfEvenInts() {
        List<int> numbers = Enumerable.Range(0, 100).Where(n=>n%2==0).ToList();
        return numbers;
    }
    
    public List<int> RangeOfSquareInts() {
        List<int> numbers = Enumerable.Range(0, 20).Select(n=>n*n).ToList();
        return numbers;
    }
    
    public List<int> RangeOfIntsStartFrom() {
        List<int> numbers = Enumerable.Range(100, 50).ToList();
        return numbers;
    }
    
    public List<int> RangeOfEvenIntsStartFrom() {
        List<int> numbers = Enumerable.Range(100, 100).Where(n=>n%2==0).ToList();
        return numbers;
    }
    public List<int> RangeOfSquareIntsStartFrom() {
        List<int> numbers = Enumerable.Range(100, 20).Select(n=>n*n).ToList();
        return numbers;
    }
    public List<int> RangeOfIntsWithStartAndCount(int start,int count) {
        List<int> numbers = Enumerable.Range(start, count).ToList();
        return numbers;
    }
    
    public List<int> RangeOfEvenIntsStartFrom(int start,int count) {
        List<int> numbers = Enumerable.Range(start, count).Where(n=>n%2==0).ToList();
        return numbers;
    }
    
    public List<int> RangeOfSquareIntsStartFrom(int start,int count) {
        List<int> numbers = Enumerable.Range(start, count).Select(n=>n*n).ToList();
        return numbers;
    }
    
    public Dictionary<int,bool> RangeOfIntsToDict() {
        Dictionary<int, bool> numbers = Enumerable.Range(0, 100).ToDictionary(n => n,
            n => n % 2 == 0);
        return numbers;
    }
    
    public List<int> RepeatedInts() {
        List<int> numbers = Enumerable.Repeat(0, 50).ToList();
        return numbers;
    }
    
    public List<int> RepeatedIntsWithCount(int count) {
        List<int> numbers = Enumerable.Repeat(0, count).ToList();
        return numbers;
    }
    
    public List<int> RepeatedIntsWithValue(int value) {
        List<int> numbers = Enumerable.Range(value, 10).ToList();
        return numbers;
    }
    
    public List<int> RepeatedIntsWithValueAndCount(int value,int count) {
        List<int> numbers = Enumerable.Range(value, count).ToList();
        return numbers;
    }

    public List<Product> RepeatedProducts() {
        List<Product> products = Enumerable.Repeat(Product.Default, 30).ToList();
        return products;
    }
    
    public List<Product> RepeatedProductsWithBase(Product product) {
        List<Product> products = Enumerable.Repeat(product, 10).ToList();
        return products;
    }
    
    public List<Product> RepeatedProductsWithCount(int count) {
        List<Product> products = Enumerable.Repeat(Product.Default, count).ToList();
        return products;
    }
    
    public List<Product> RepeatedProductsWithBaseAndCount(Product product,int count) {
        List<Product> products = Enumerable.Repeat(product, count).ToList();
        return products;
    }
    
    public List<Customer> RepeatedCustomers() {
        List<Customer> customers = Enumerable.Repeat(Customer.Default, 5).ToList();
        return customers;
    }
    
    public List<Order> RepeatedOrders() {
        List<Order> orders = Enumerable.Repeat(Order.Default, 10).ToList();
        return orders;
    }
    
}