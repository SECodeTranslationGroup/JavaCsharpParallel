package parallel.linq101.mylinq;

import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Order;
import parallel.linq101.datasource.Product;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class GeneratorMethods {
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public List<Integer> rangeOfInts() {
        List<Integer> numbers = IntStream.range(0, 50).boxed().toList();
        return numbers;
    }

    public List<Integer> rangeOfEvenInts() {
        List<Integer> numbers = IntStream.range(0, 50).filter(n->n%2==0).boxed().toList();
        return numbers;
    }

    public List<Integer> rangeOfSquareInts() {
        List<Integer> numbers = IntStream.range(0, 50).map(n->n*n).boxed().toList();
        return numbers;
    }

    public List<Integer> rangeOfIntsStartFrom() {
        List<Integer> numbers = IntStream.range(100, 150).boxed().toList();
        return numbers;
    }

    public List<Integer> rangeOfEvenIntsStartFrom() {
        List<Integer> numbers = IntStream.range(100, 200).filter(n->n%2==0).boxed().toList();
        return numbers;
    }
    public List<Integer> rangeOfSquareIntsStartFrom() {
        List<Integer> numbers = IntStream.range(100, 120).map(n->n*n).boxed().toList();
        return numbers;
    }
    public List<Integer> rangeOfIntsWithStartAndCount(int start,int count) {
        List<Integer> numbers = IntStream.range(start, start+count).boxed().toList();
        return numbers;
    }

    public List<Integer> rangeOfEvenIntsStartFrom(int start,int count) {
        List<Integer> numbers = IntStream.range(start, start+count).filter(n->n%2==0).boxed().toList();
        return numbers;
    }

    public List<Integer> rangeOfSquareIntsStartFrom(int start,int count) {
        List<Integer> numbers = IntStream.range(start, start+count).map(n->n*n).boxed().toList();
        return numbers;
    }

    public Map<Integer,Boolean> rangeOfIntsToDict() {
        Map<Integer,Boolean> numbers =IntStream.range(0, 100).boxed().collect(toMap(n->n,n->n%2==0));
        return numbers;
    }

    public List<Integer> RepeatedInts() {
        List<Integer> numbers = Collections.nCopies(50, 0);
        return numbers;
    }

    public List<Integer> RepeatedIntsWithCount(int count) {
        List<Integer> numbers = Collections.nCopies(count, 0);
        return numbers;
    }

    public List<Integer> RepeatedIntsWithValue(int value) {
        List<Integer> numbers = Collections.nCopies(10, value);
        return numbers;
    }

    public List<Integer> RepeatedIntsWithValueAndCount(int value,int count) {
        List<Integer> numbers = Collections.nCopies(count, value);
        return numbers;
    }

    public List<Product> RepeatedProducts() {
        List<Product> products = Collections.nCopies(30,Product.DEFAULT);
        return products;
    }

    public List<Product> RepeatedProductsWithBase(Product product) {
        List<Product> products = Collections.nCopies(10,product);
        return products;
    }

    public List<Product> RepeatedProductsWithCount(int count) {
        List<Product> products = Collections.nCopies(count,Product.DEFAULT);
        return products;
    }

    public List<Product> RepeatedProductsWithBaseAndCount(Product product,int count) {
        List<Product> products = Collections.nCopies(count, product);
        return products;
    }

    public List<Customer> RepeatedCustomers() {
        List<Customer> customers =  Collections.nCopies(5, Customer.DEFAULT);
        return customers;
    }

    public List<Order> RepeatedOrders() {
        List<Order> orders = Collections.nCopies(10, Order.DEFAULT);
        return orders;
    }
}
