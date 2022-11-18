using Parallel.Linq101.DataSources;

namespace Parallel.Linq101.MyLinq;

public class AggregateMethod {
    //original:2 target:20
    public List<Product> GetProductList() => Products.ProductList;
    public List<Customer> GetCustomerList() => Customers.CustomerList;

    public double NumbersAggregateMultiply() {
        double[] numbers = { 1.7, 2.3, 1.9, 4.1, 2.9 };
        double product = numbers.Aggregate((a, b) => a * b);
        return product;
    }

    public double NumbersAggregateMultiplyWithSeed() {
        double[] numbers = { 1.7, 2.3, 1.9, 4.1, 2.9 };
        double seed = 1.6;
        double product = numbers.Aggregate(seed, (a, b) => a * b);
        return product;
    }

    public double NumbersDoubledAggregateMultiply() {
        double[] numbers = { 1.7, 2.3, 1.9, 4.1, 2.9 };
        double product = numbers.Select(n => n * 2).Aggregate((a, b) => a * b);
        return product;
    }

    public double NumbersDoubledAggregateMultiplyWithSeed() {
        double[] numbers = { 1.7, 2.3, 1.9, 4.1, 2.9 };
        double seed = 1.6;
        double product = numbers.Select(n => n * 2).Aggregate(seed, (a, b) => a * b);
        return product;
    }

    public double BigNumbersAggregateMultiply() {
        double[] numbers = { 1.7, 2.3, 1.9, 4.1, 2.9 };
        double product = numbers.Where(n => n > 2).Aggregate((a, b) => a * b);
        return product;
    }

    public double BigNumbersAggregateMultiplyWithSeed() {
        double[] numbers = { 1.7, 2.3, 1.9, 4.1, 2.9 };
        double seed = 1.6;
        double product = numbers.Where(n => n > 2).Aggregate(seed, (a, b) => a * b);
        return product;
    }

    public double NumbersAggregateSqrt() {
        double[] numbers = { 1.7, 2.3, 1.9, 4.1, 2.9 };
        double aggregateSum = numbers.Aggregate((a, b) => Math.Sqrt(a * b));
        return aggregateSum;
    }

    public double NumbersAggregateSqrtWithSeed() {
        double[] numbers = { 1.7, 2.3, 1.9, 4.1, 2.9 };
        double seed = 1.6;
        double aggregateSum = numbers.Aggregate(seed, (a, b) => Math.Sqrt(a * b));
        return aggregateSum;
    }

    public double NumbersAggregateFindMax() {
        double[] numbers = { 1.7, 2.3, 1.9, 4.1, 2.9 };
        double aggregateSum = numbers.Aggregate((a, b) => Math.Max(a,b));
        return aggregateSum;
    }

    public double NumbersAggregateFindMaxWithSeed() {
        double[] numbers = { 1.7, 2.3, 1.9, 4.1, 2.9 };
        double seed = 5;
        double aggregateSum = numbers.Aggregate(seed, (a, b) => Math.Max(a,b));
        return aggregateSum;
    }
    
    public double NumbersAggregateFindMin() {
        double[] numbers = { 1.7, 2.3, 1.9, 4.1, 2.9 };
        double aggregateSum = numbers.Aggregate((a, b) => Math.Min(a,b));
        return aggregateSum;
    }

    public double NumbersAggregateFindMinWithSeed() {
        double[] numbers = { 1.7, 2.3, 1.9, 4.1, 2.9 };
        double seed = 3;
        double aggregateSum = numbers.Aggregate(seed, (a, b) => Math.Min(a,b));
        return aggregateSum;
    }
    
    public double InputNumbersAggregate(double[] numbers) {
        double product = numbers.Aggregate((runningProduct, nextFactor)
            => runningProduct * nextFactor);
        return product;
    }

    public double InputNumbersAggregateWithSeed(double[] numbers, double seed) {
        double product = numbers.Aggregate(seed, (runningProduct, nextFactor)
            => runningProduct * nextFactor);
        return product;
    }

    public int AggregateWithdrawMoney() {
        int[] attemptedWithdrawals = { 100, 20, 10, 40, 50, 10, 70, 30 };
        int endBalance = attemptedWithdrawals.Aggregate((balance, nextWithdrawal) =>
            nextWithdrawal <= balance ? balance - nextWithdrawal : balance);
        return 0;
    }

    public int AggregateWithdrawMoneyWithSeed() {
        int startBalance = 100;
        int[] attemptedWithdrawals = { 20, 10, 40, 50, 10, 70, 30 };
        int endBalance = attemptedWithdrawals.Aggregate(startBalance, (balance, nextWithdrawal) =>
            nextWithdrawal <= balance ? balance - nextWithdrawal : balance);
        return 0;
    }

    public double ProductUnitPriceAggregateAverage() {
        List<Product> products = GetProductList();
        double aggregateSum = products.Select(p => p.UnitPrice).Aggregate((a, b) => (a + b) / 2);
        return aggregateSum;
    }

    public double ExpensiveProductUnitPriceAggregateAverage() {
        List<Product> products = GetProductList();
        double aggregateSum = products.Select(p => p.UnitPrice).Where(d => d > 100)
            .Aggregate((a, b) => (a + b) / 2);
        return aggregateSum;
    }

    public double ProductUnitPriceAggregateAverageWithSeed() {
        List<Product> products = GetProductList();
        double seed = 15.5;
        double aggregateSum = products.Select(p => p.UnitPrice).Aggregate(seed, (a, b) => (a + b) / 2);
        return aggregateSum;
    }

    public double ExpensiveProductUnitPriceAggregateAverageWithSeed() {
        List<Product> products = GetProductList();
        double seed = 15.5;
        double aggregateSum = products.Select(p => p.UnitPrice).Where(d => d > 100)
            .Aggregate(seed, (a, b) => (a + b) / 2);
        return aggregateSum;
    }
}