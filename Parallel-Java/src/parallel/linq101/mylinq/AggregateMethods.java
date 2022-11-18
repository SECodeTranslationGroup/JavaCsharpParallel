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

    public double NumbersAggregateMultiply() {
        double[] numbers = {1.7, 2.3, 1.9, 4.1, 2.9};
        double product = Arrays.stream(numbers).reduce((a, b) -> a * b).getAsDouble();
        return product;
    }

    public double NumbersAggregateMultiplyWithSeed() {
        double[] numbers = {1.7, 2.3, 1.9, 4.1, 2.9};
        double seed = 1.6;
        double product = Arrays.stream(numbers).reduce(seed, (a, b) -> a * b);
        return product;
    }

    public double NumbersDoubledAggregateMultiply() {
        double[] numbers = {1.7, 2.3, 1.9, 4.1, 2.9};
        double product = Arrays.stream(numbers).map(n -> n * 2).reduce((a, b) -> a * b).getAsDouble();
        return product;
    }

    public double NumbersDoubledAggregateMultiplyWithSeed() {
        double[] numbers = {1.7, 2.3, 1.9, 4.1, 2.9};
        double seed = 1.6;
        double product = product = Arrays.stream(numbers).map(n -> n * 2).reduce(seed, (a, b) -> a * b);
        return product;
    }

    public double BigNumbersAggregateMultiply() {
        double[] numbers = {1.7, 2.3, 1.9, 4.1, 2.9};
        double product = Arrays.stream(numbers).filter(n -> n > 2).reduce((a, b) -> a * b).getAsDouble();
        return product;
    }

    public double BigNumbersAggregateMultiplyWithSeed() {
        double[] numbers = {1.7, 2.3, 1.9, 4.1, 2.9};
        double seed = 1.6;
        double product = Arrays.stream(numbers).filter(n -> n > 2).reduce(seed, (a, b) -> a * b);
        return product;
    }

    public double NumbersAggregateSqrt() {
        double[] numbers = {1.7, 2.3, 1.9, 4.1, 2.9};
        double aggregateSum = Arrays.stream(numbers).filter(n -> n > 2).reduce((a, b) -> Math.sqrt(a * b)).getAsDouble();
        return aggregateSum;
    }

    public double NumbersAggregateSqrtWithSeed() {
        double[] numbers = {1.7, 2.3, 1.9, 4.1, 2.9};
        double seed = 1.6;
        double aggregateSum = Arrays.stream(numbers).filter(n -> n > 2).reduce(seed, (a, b) -> Math.sqrt(a * b));
        return aggregateSum;
    }

    public double NumbersAggregateFindMax() {
        double[] numbers = {1.7, 2.3, 1.9, 4.1, 2.9};
        double aggregateSum = Arrays.stream(numbers).filter(n -> n > 2).reduce((a, b) -> Math.max(a, b)).getAsDouble();
        return aggregateSum;
    }

    public double NumbersAggregateFindMaxWithSeed() {
        double[] numbers = {1.7, 2.3, 1.9, 4.1, 2.9};
        double seed = 5;
        double aggregateSum = Arrays.stream(numbers).filter(n -> n > 2).reduce(seed, (a, b) -> Math.max(a, b));
        return aggregateSum;
    }

    public double NumbersAggregateFindMin() {
        double[] numbers = {1.7, 2.3, 1.9, 4.1, 2.9};
        double aggregateSum = Arrays.stream(numbers).filter(n -> n > 2).reduce((a, b) -> Math.min(a, b)).getAsDouble();
        return aggregateSum;
    }

    public double NumbersAggregateFindMinWithSeed() {
        double[] numbers = {1.7, 2.3, 1.9, 4.1, 2.9};
        double seed = 3;
        double aggregateSum = Arrays.stream(numbers).filter(n -> n > 2).reduce(seed, (a, b) -> Math.min(a, b));
        return aggregateSum;
    }

    public double InputNumbersAggregate(double[] numbers) {
        double product = Arrays.stream(numbers).reduce((a, b) -> a * b).getAsDouble();
        return product;
    }

    public double InputNumbersAggregateWithSeed(double[] numbers, double seed) {
        double product = Arrays.stream(numbers).reduce(seed, (a, b) -> a * b);
        return product;
    }

    public int AggregateWithdrawMoney() {
        int[] attemptedWithdrawals = {100, 20, 10, 40, 50, 10, 70, 30};
        int endBalance = Arrays.stream(attemptedWithdrawals).reduce((balance, nextWithdrawal) ->
        nextWithdrawal <= balance ? balance - nextWithdrawal : balance).getAsInt();
        return 0;
    }

    public int AggregateWithdrawMoneyWithSeed() {
        int startBalance = 100;
        int[] attemptedWithdrawals = {20, 10, 40, 50, 10, 70, 30};
        int endBalance = Arrays.stream(attemptedWithdrawals).reduce(startBalance,(balance, nextWithdrawal) ->
                nextWithdrawal <= balance ? balance - nextWithdrawal : balance);
        return 0;
    }

    public double ProductUnitPriceAggregateAverage() {
        List<Product> products = getProductList();
        double aggregateSum = products.stream().map(p -> p.getUnitPrice()).reduce((a, b) ->(a + b) / 2).get();
        return aggregateSum;
    }

    public double ExpensiveProductUnitPriceAggregateAverage() {
        List<Product> products = getProductList();
        double aggregateSum = products.stream().map(p -> p.getUnitPrice()).filter(d -> d > 100)
                .reduce((a, b) ->(a + b) / 2).get();
        return aggregateSum;
    }

    public double ProductUnitPriceAggregateAverageWithSeed() {
        List<Product> products = getProductList();
        double seed = 15.5;
        double aggregateSum = products.stream().map(p -> p.getUnitPrice()).reduce(seed,(a, b) ->(a + b) / 2);
        return aggregateSum;
    }

    public double ExpensiveProductUnitPriceAggregateAverageWithSeed() {
        List<Product> products = getProductList();
        double seed = 15.5;
        double aggregateSum = products.stream().map(p -> p.getUnitPrice()).filter(d -> d > 100)
                .reduce(seed,(a, b) ->(a + b) / 2);
        return aggregateSum;
    }
}
