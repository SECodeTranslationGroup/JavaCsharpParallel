package parallel.linq101.mylinq;

import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Product;

import java.util.Arrays;
import java.util.List;

public class AggregateMethods {
    //original:2 target:20
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public double numbersAggregateMultiply() {
        double[] numbers = {1.7, 2.3, 1.9, 4.1, 2.9};
        double product = Arrays.stream(numbers).reduce((a, b) -> a * b).getAsDouble();
        return product;
    }

    public double numbersAggregateMultiplyWithSeed() {
        double[] numbers = {1.7, 2.3, 1.9, 4.1, 2.9};
        double seed = 1.6;
        double product = Arrays.stream(numbers).reduce(seed, (a, b) -> a * b);
        return product;
    }

    public double numbersDoubledAggregateMultiply() {
        double[] numbers = {1.7, 2.3, 1.9, 4.1, 2.9};
        double product = Arrays.stream(numbers).map(n -> n * 2).reduce((a, b) -> a * b).getAsDouble();
        return product;
    }

    public double numbersDoubledAggregateMultiplyWithSeed() {
        double[] numbers = {1.7, 2.3, 1.9, 4.1, 2.9};
        double seed = 1.6;
        double product = product = Arrays.stream(numbers).map(n -> n * 2).reduce(seed, (a, b) -> a * b);
        return product;
    }

    public double bigNumbersAggregateMultiply() {
        double[] numbers = {1.7, 2.3, 1.9, 4.1, 2.9};
        double product = Arrays.stream(numbers).filter(n -> n > 2).reduce((a, b) -> a * b).getAsDouble();
        return product;
    }

    public double bigNumbersAggregateMultiplyWithSeed() {
        double[] numbers = {1.7, 2.3, 1.9, 4.1, 2.9};
        double seed = 1.6;
        double product = Arrays.stream(numbers).filter(n -> n > 2).reduce(seed, (a, b) -> a * b);
        return product;
    }

    public double numbersAggregateSqrt() {
        double[] numbers = {1.7, 2.3, 1.9, 4.1, 2.9};
        double aggregateSum = Arrays.stream(numbers).filter(n -> n > 2).reduce((a, b) -> Math.sqrt(a * b)).getAsDouble();
        return aggregateSum;
    }

    public double numbersAggregateSqrtWithSeed() {
        double[] numbers = {1.7, 2.3, 1.9, 4.1, 2.9};
        double seed = 1.6;
        double aggregateSum = Arrays.stream(numbers).filter(n -> n > 2).reduce(seed, (a, b) -> Math.sqrt(a * b));
        return aggregateSum;
    }

    public double numbersAggregateFindMax() {
        double[] numbers = {1.7, 2.3, 1.9, 4.1, 2.9};
        double aggregateSum = Arrays.stream(numbers).filter(n -> n > 2).reduce((a, b) -> Math.max(a, b)).getAsDouble();
        return aggregateSum;
    }

    public double numbersAggregateFindMaxWithSeed() {
        double[] numbers = {1.7, 2.3, 1.9, 4.1, 2.9};
        double seed = 5;
        double aggregateSum = Arrays.stream(numbers).filter(n -> n > 2).reduce(seed, (a, b) -> Math.max(a, b));
        return aggregateSum;
    }

    public double numbersAggregateFindMin() {
        double[] numbers = {1.7, 2.3, 1.9, 4.1, 2.9};
        double aggregateSum = Arrays.stream(numbers).filter(n -> n > 2).reduce((a, b) -> Math.min(a, b)).getAsDouble();
        return aggregateSum;
    }

    public double numbersAggregateFindMinWithSeed() {
        double[] numbers = {1.7, 2.3, 1.9, 4.1, 2.9};
        double seed = 3;
        double aggregateSum = Arrays.stream(numbers).filter(n -> n > 2).reduce(seed, (a, b) -> Math.min(a, b));
        return aggregateSum;
    }

    public double inputNumbersAggregate(double[] numbers) {
        double product = Arrays.stream(numbers).reduce((a, b) -> a * b).getAsDouble();
        return product;
    }

    public double inputNumbersAggregateWithSeed(double[] numbers, double seed) {
        double product = Arrays.stream(numbers).reduce(seed, (a, b) -> a * b);
        return product;
    }

    public int aggregateWithdrawMoney() {
        int[] attemptedWithdrawals = {100, 20, 10, 40, 50, 10, 70, 30};
        int endBalance = Arrays.stream(attemptedWithdrawals).reduce((balance, nextWithdrawal) ->
        nextWithdrawal <= balance ? balance - nextWithdrawal : balance).getAsInt();
        return 0;
    }

    public int aggregateWithdrawMoneyWithSeed() {
        int startBalance = 100;
        int[] attemptedWithdrawals = {20, 10, 40, 50, 10, 70, 30};
        int endBalance = Arrays.stream(attemptedWithdrawals).reduce(startBalance,(balance, nextWithdrawal) ->
                nextWithdrawal <= balance ? balance - nextWithdrawal : balance);
        return 0;
    }

    public double productUnitPriceAggregateAverage() {
        List<Product> products = getProductList();
        double aggregateSum = products.stream().map(p -> p.getUnitPrice()).reduce((a, b) ->(a + b) / 2).get();
        return aggregateSum;
    }

    public double expensiveProductUnitPriceAggregateAverage() {
        List<Product> products = getProductList();
        double aggregateSum = products.stream().map(p -> p.getUnitPrice()).filter(d -> d > 100)
                .reduce((a, b) ->(a + b) / 2).get();
        return aggregateSum;
    }

    public double productUnitPriceAggregateAverageWithSeed() {
        List<Product> products = getProductList();
        double seed = 15.5;
        double aggregateSum = products.stream().map(p -> p.getUnitPrice()).reduce(seed,(a, b) ->(a + b) / 2);
        return aggregateSum;
    }

    public double expensiveProductUnitPriceAggregateAverageWithSeed() {
        List<Product> products = getProductList();
        double seed = 15.5;
        double aggregateSum = products.stream().map(p -> p.getUnitPrice()).filter(d -> d > 100)
                .reduce(seed,(a, b) ->(a + b) / 2);
        return aggregateSum;
    }
}
