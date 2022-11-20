package parallel.linq101.mylinq;

import org.javatuples.Pair;
import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Product;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class ConvertMethods {
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public int[] intsConvertToArray() {
        int[] ints = {2, 3, 1, 5, 4};
        int[] intsArray = Arrays.stream(ints).sorted().toArray();
        return intsArray;
    }

    public int[] intsConvertToDescendingArrayAndPrint() {
        int[] ints = {2, 3, 1, 5, 4};
        int[] intsArray = Arrays.stream(ints).boxed().sorted(Comparator.reverseOrder()).mapToInt(d -> d).toArray();
        for (int i = 0; i < intsArray.length; i++)
            System.out.println(intsArray[i]);
        return intsArray;
    }

    public int[] intsConvertToArrayAndPrintForeach() {
        int[] ints = {2, 3, 1, 5, 4};
        int[] intsArray = Arrays.stream(ints).sorted().toArray();
        for (int i : intsArray)
            System.out.println(i);
        return intsArray;
    }

    public double[] doublesConvertToDescendingArray() {
        double[] doubles = {1.7, 2.3, 1.9, 4.1, 2.9};
        double[] doublesArray = Arrays.stream(doubles).boxed().sorted(Comparator.reverseOrder()).mapToDouble(d -> d).toArray();
        return doublesArray;
    }

    public double[] doublesConvertToArrayAndPrint() {
        double[] doubles = {1.7, 2.3, 1.9, 4.1, 2.9};
        double[] doublesArray = Arrays.stream(doubles).sorted().toArray();
        for (int i = 0; i < doublesArray.length; i++)
            System.out.println(doublesArray[i]);
        return doublesArray;
    }

    public double[] doublesConvertToDescendingArrayAndPrintForeach() {
        double[] doubles = {1.7, 2.3, 1.9, 4.1, 2.9};
        double[] doublesArray = Arrays.stream(doubles).boxed().sorted(Comparator.reverseOrder()).mapToDouble(d -> d).toArray();
        for (double d : doublesArray)
            System.out.println(d);
        return doublesArray;
    }

    public Product[] productsConvertToArray() {
        List<Product> products = getProductList();
        Product[] productsArray = (Product[]) products.stream().sorted(Comparator.comparing(
                p -> p.getUnitPrice())).toArray();
        return productsArray;
    }

    public Product[] productsConvertToDescendingArrayAndPrint() {
        List<Product> products = getProductList();
        Product[] productsArray = (Product[]) products.stream().sorted(Comparator.comparing(
                p -> p.getUnitPrice(), Comparator.reverseOrder())).toArray();
        for (int i = 0; i < productsArray.length; i++)
            System.out.println(productsArray[i]);
        return productsArray;
    }

    public Product[] productsConvertToDescendingArrayAndPrintForeach() {
        List<Product> products = getProductList();
        Product[] productsArray = (Product[]) products.stream().sorted(Comparator.comparing(
                p -> p.getUnitPrice(), Comparator.reverseOrder())).toArray();
        for (Product p : productsArray)
            System.out.println(p);
        return productsArray;
    }

    public double[] productsConvertToUnitPriceArray() {
        List<Product> products = getProductList();
        double[] pricesArray = products.stream().mapToDouble(p -> p.getUnitPrice()).sorted().toArray();
        return pricesArray;
    }

    public List<Integer> intsConvertToList() {
        int[] ints = {2, 3, 1, 5, 4};
        List<Integer> intsList = Arrays.stream(ints).boxed().sorted().toList();
        return intsList;
    }

    public List<Integer> intsConvertToDescendingListAndPrint() {
        int[] ints = {2, 3, 1, 5, 4};
        List<Integer> intsList = Arrays.stream(ints).boxed().sorted(Comparator.reverseOrder()).toList();
        for (int i = 0; i < intsList.size(); i++)
            System.out.println(intsList.get(i));
        return intsList;
    }

    public List<Integer> intsConvertToListAndPrintForeach() {
        int[] ints = {2, 3, 1, 5, 4};
        List<Integer> intsList = Arrays.stream(ints).boxed().sorted().toList();
        for (int i : intsList)
            System.out.println(i);
        return intsList;
    }

    public List<Double> doublesConvertToDescendingList() {
        double[] doubles = {1.7, 2.3, 1.9, 4.1, 2.9};
        List<Double> doublesList = Arrays.stream(doubles).boxed().
                sorted(Comparator.reverseOrder()).toList();
        return doublesList;
    }

    public List<Double> doublesConvertToListAndPrint() {
        double[] doubles = {1.7, 2.3, 1.9, 4.1, 2.9};
        List<Double> doublesList = Arrays.stream(doubles).boxed().
                sorted().toList();
        for (int i = 0; i < doublesList.size(); i++)
            System.out.println(doublesList.get(i));
        return doublesList;
    }

    public List<Double> doublesConvertToDescendingListAndPrintForeach() {
        double[] doubles = {1.7, 2.3, 1.9, 4.1, 2.9};
        List<Double> doublesList = Arrays.stream(doubles).boxed().
                sorted(Comparator.reverseOrder()).toList();
        for (double d : doublesList)
            System.out.println(d);
        return doublesList;
    }

    public List<Product> productsConvertToList() {
        List<Product> products = getProductList();
        List<Product> productsList = products.stream().sorted(Comparator.comparing(p -> p.getUnitPrice())).toList();
        return productsList;
    }

    public List<Product> productsConvertToDescendingListAndPrint() {
        List<Product> products = getProductList();
        List<Product> productsList = products.stream().sorted(Comparator.comparing(
                p -> p.getUnitPrice(), Comparator.reverseOrder())).toList();
        for (int i = 0; i < productsList.size(); i++)
            System.out.println(productsList.get(i));
        return productsList;
    }

    public List<Product> productsConvertToDescendingListAndPrintForeach() {
        List<Product> products = getProductList();
        List<Product> productsList = products.stream().sorted(Comparator.comparing(
                p -> p.getUnitPrice(), Comparator.reverseOrder())).toList();
        for (Product p : productsList)
            System.out.println(p);
        return productsList;
    }

    public List<Double> productsConvertToUnitPriceList() {
        List<Product> products = getProductList();
        List<Double> pricesList = products.stream().map(p -> p.getUnitPrice()).sorted().toList();
        return pricesList;
    }

    public Map<String, Integer> convertTuplesToDictionary() {
        List<Pair<String,Integer>> scoreRecords = Arrays.asList(
                Pair.with("Alice", 50), Pair.with("Bob", 40), Pair.with("Cathy", 45));
        Map<String, Integer> scoreRecordsDict = scoreRecords.stream().collect(toMap(
                sr -> sr.getValue0(), sr -> sr.getValue1()));
        return scoreRecordsDict;
    }

    public Map<String, Integer> convertTuplesToDictionaryAndPrint() {
        List<Pair<String,Integer>> scoreRecords = Arrays.asList(
                Pair.with("Alice", 50), Pair.with("Bob", 40), Pair.with("Cathy", 45));
        Map<String, Integer> scoreRecordsDict = scoreRecords.stream().collect(toMap(
                sr -> sr.getValue0(), sr -> sr.getValue1()));
        for(var pair : scoreRecordsDict.entrySet())
            System.out.println(pair.getKey() + " " + pair.getValue());
        return scoreRecordsDict;
    }

    public Map<Double, Double> convertArrayToDictionary() {
        double[] doubles = {1.7, 2.3, 1.9, 4.1, 2.9};
        Map<Double, Double> doublesDict = Arrays.stream(doubles).boxed().collect(toMap(
                sr -> sr, sr -> sr*2));
        return doublesDict;
    }

    public Map<Double, Double> convertArrayToDictionaryAndPrint() {
        double[] doubles = {1.7, 2.3, 1.9, 4.1, 2.9};
        Map<Double, Double> doublesDict = Arrays.stream(doubles).boxed().collect(toMap(
                sr -> sr, sr -> sr*2));
        for(var pair : doublesDict.entrySet())
            System.out.println(pair.getKey() + " " + pair.getValue());
        return doublesDict;
    }

    public Map<Double, Double> convertArrayToDictionaryWithDistinct() {
        double[] doubles = {1.7, 2.3, 1.9, 4.1, 1.7, 2.9};
        Map<Double, Double> doublesDict = Arrays.stream(doubles).distinct().boxed().collect(toMap(
                sr -> sr, sr -> sr*2));
        return doublesDict;
    }

    public Map<Double, Double> convertArrayToDictionaryWithDistinctAndPrint() {
        double[] doubles = {1.7, 2.3, 1.9, 4.1, 1.7, 2.9};
        Map<Double, Double> doublesDict = Arrays.stream(doubles).distinct().boxed().collect(toMap(
                sr -> sr, sr -> sr*2));
        for(var pair : doublesDict.entrySet())
            System.out.println(pair.getKey() + " " + pair.getValue());
        return doublesDict;
    }

    public Map<String, Double> productsConvertFieldsToDictionary() {
        List<Product> products = getProductList();
        Map<String, Double> productsUnitPrice = products.stream().collect(toMap(
                p ->p.getProductName(), p ->p.getUnitPrice()));
        return productsUnitPrice;
    }

    public Map<String, Double> productsConvertFieldsToDictionaryAndPrint() {
        List<Product> products = getProductList();
        Map<String, Double> productsUnitPrice = products.stream().collect(toMap(
                p ->p.getProductName(), p ->p.getUnitPrice()));
        for(var pair : productsUnitPrice.entrySet())
            System.out.println(pair.getKey() + " " + pair.getValue());
        return productsUnitPrice;
    }

    public Map<String, List<Product>> productsConvertGroupingToDictionary() {
        List<Product> products = getProductList();
        Map<String, List<Product>> catagory = products.stream().collect(groupingBy(
                p ->p.getCategory()));
        return catagory;
    }

    public Map<String, List<Product>> productsConvertGroupingToDictionaryAndPrint() {
        List<Product> products = getProductList();
        Map<String, List<Product>> catagory = products.stream().collect(groupingBy(
                p ->p.getCategory()));
        for(var pair : catagory.entrySet()) {
            System.out.println(pair.getKey() + ":");
            for(var product : pair.getValue())
                System.out.println("\t" + product);
        }
        return catagory;
    }

    public double[] convertSelectedDoubleItemToArray() {
        Object[] numbers = { null, 1.0, "two", 3, "four", 5, "six", 7.0 };
        double[] doubles = Arrays.stream(numbers).filter(o->o instanceof Double).mapToDouble(d-> (double) d).toArray();
        return doubles;
    }

    public double[] ConvertSelectedDoubleItemToArrayAndPrint() {
        Object[] numbers = { null, 1.0, "two", 3, "four", 5, "six", 7.0 };
        double[] doubles = Arrays.stream(numbers).filter(o->o instanceof Double).mapToDouble(d-> (double) d).toArray();
        for (int i = 0; i < doubles.length; i++)
            System.out.println(doubles[i]);
        return doubles;
    }

    public double[] ConvertSelectedDoubleItemToArrayAndPrintForeach() {
        Object[] numbers = { null, 1.0, "two", 3, "four", 5, "six", 7.0 };
        double[] doubles = Arrays.stream(numbers).filter(o->o instanceof Double).mapToDouble(d-> (double) d).toArray();
        for (double d : doubles)
            System.out.println(d);
        return doubles;
    }

    public List<String> ConvertSelectedStringItemToList() {
        Object[] numbers = { null, 1.0, "two", 3, "four", 5, "six", 7.0 };
        List<String> strings =  Arrays.stream(numbers).filter(o->o instanceof String).map(s->(String)s).toList();
        return strings;
    }

    public List<String> ConvertSelectedStringItemToListAndPrint() {
        Object[] numbers = { null, 1.0, "two", 3, "four", 5, "six", 7.0 };
        List<String> strings =  Arrays.stream(numbers).filter(o->o instanceof String).map(s->(String)s).toList();
        for (int i = 0; i < strings.size(); i++)
            System.out.println(strings.get(i));
        return strings;
    }

    public List<String> ConvertSelectedStringItemToListAndPrintForeach() {
        Object[] numbers = { null, 1.0, "two", 3, "four", 5, "six", 7.0 };
        List<String> strings = Arrays.stream(numbers).filter(o->o instanceof String).map(s->(String)s).toList();
        for (String s : strings)
            System.out.println(s);
        return strings;
    }

    public List<Pair<String,Integer>> ConvertSelectedTupleToList() {
        Object[] numbers = { Pair.with("Alice", "50"), Pair.with("Bob", 40), Pair.with("Cathy", 45) };
        List<Pair<String,Integer>> strings = Arrays.stream(numbers).filter(o->o instanceof Pair &&
                ((Pair)o).getValue0() instanceof String &&((Pair)o).getValue1() instanceof Integer)
                .map(o->(Pair<String,Integer>)o).toList();
        return strings;
    }

    public List<Pair<String,Integer>> ConvertSelectedTupleToListAndPrint() {
        Object[] numbers = { Pair.with("Alice", "50"), Pair.with("Bob", 40), Pair.with("Cathy", 45) };
        List<Pair<String,Integer>> strings = Arrays.stream(numbers).filter(o->o instanceof Pair &&
                        ((Pair)o).getValue0() instanceof String &&((Pair)o).getValue1() instanceof Integer)
                .map(o->(Pair<String,Integer>)o).toList();
        for (var i = 0; i < strings.size(); i++)
            System.out.println(strings.get(i).getValue0()+":"+ strings.get(i).getValue1());
        return strings;
    }

    public Map<String,Integer> ConvertSelectedTupleToDictionary() {
        Object[] numbers = { Pair.with("Alice", "50"), Pair.with("Bob", 40), Pair.with("Cathy", 45) };
        Map<String,Integer> strings = Arrays.stream(numbers).filter(o->o instanceof Pair &&
                        ((Pair)o).getValue0() instanceof String &&((Pair)o).getValue1() instanceof Integer)
                .map(o->(Pair<String,Integer>)o).collect(toMap(p->p.getValue0(),p->p.getValue1()));
        return strings;
    }

    public Map<String,Integer> ConvertSelectedTupleToDictionaryAndPrint() {
        Object[] numbers = { Pair.with("Alice", "50"), Pair.with("Bob", 40), Pair.with("Cathy", 45) };
        Map<String,Integer> strings = Arrays.stream(numbers).filter(o->o instanceof Pair &&
                        ((Pair)o).getValue0() instanceof String &&((Pair)o).getValue1() instanceof Integer)
                .map(o->(Pair<String,Integer>)o).collect(toMap(p->p.getValue0(),p->p.getValue1()));
        for (var pair : strings.entrySet())
            System.out.println(pair.getKey()+":"+pair.getValue());
        return strings;
    }
}
