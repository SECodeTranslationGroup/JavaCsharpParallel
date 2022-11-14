package parallel.linq101;

import org.javatuples.Pair;
import parallel.linq101.datasource.Customer;
import parallel.linq101.datasource.Data;
import parallel.linq101.datasource.Product;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Groupings {
    public List<Product> getProductList() {
        return Data.getProductList();
    }

    public List<Customer> getCustomerList() {
        return Data.getCustomerList();
    }

    public int groupingSyntax() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};

        var numberGroups = Arrays.stream(numbers).boxed().collect(
                Collectors.groupingBy(n -> n % 5));

        for (var g : numberGroups.entrySet()) {
            System.out.println("Numbers with a remainder of " + g.getKey() + " when divided by 5:");
            for (var n : g.getValue())
                System.out.println(n);
        }
        return 0;
    }

    public int groupByProperty() {

        String[] words = {"blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese"};

        var wordGroups = Arrays.stream(words).collect(
                Collectors.groupingBy(n -> n.charAt(0)));

        for (var g : wordGroups.entrySet()) {
            System.out.println("Words that start with the letter '" + g.getKey() + "':");
            for (var w : g.getValue())
                System.out.println(w);
        }

        return 0;
    }

    public int groupByCategory() {

        List<Product> products = getProductList();

        var orderGroups = products.stream().collect(
                Collectors.groupingBy(p -> p.getCategory()));

        for (var orderGroup : orderGroups.entrySet()) {
            System.out.println("Products in " + orderGroup.getKey() + " category:");
            for (var product : orderGroup.getValue())
                System.out.println("\t" + product + "}");
        }
        return 0;
    }

    public int nestedGroupBy() {

        List<Customer> customers = getCustomerList();
        var customerOrderGroups = customers.stream().map(
                c -> Pair.with(c.getCompanyName(),
                        c.getOrders().stream().collect(Collectors.groupingBy(
                                o -> o.getOrderDate().getYear(),
                                Collectors.groupingBy(
                                        o -> o.getOrderDate().getMonth().getValue()
                                )
                        ))
                )
        ).collect(Collectors.toList());

        for (var ordersByCustomer : customerOrderGroups) {
            System.out.println("Customer Name: " + ordersByCustomer.getValue0());
            for (var ordersByYear : ordersByCustomer.getValue1().entrySet()) {
                System.out.println("\tYear: " + ordersByYear.getKey());
                for (var ordersByMonth : ordersByYear.getValue().entrySet()) {
                    System.out.println("\t\tMonth: " + ordersByMonth.getKey());
                    for (var order : ordersByMonth.getValue())
                        System.out.println("\t\t\tOrder: " + order);
                }
            }
        }


        return 0;
    }

    public int groupByCustomComparer() {

        String[] anagrams = {"from   ", " salt", " earn ", "  last   ", " near ", " form  "};

        var orderGroups = Arrays.stream(anagrams).collect(
                Collectors.groupingBy(p -> new AnagramEqualityComparer().getCanonicalString(p.trim())));

        for(var set : orderGroups.entrySet())
        {
            // The key would be the first item in the set
            for(var word : set.getValue())
                System.out.println(word);
            System.out.println("...");
        }

        return 0;
    }

    public int nestedGroupByCustom() {

        String[] anagrams = {"from   ", " salt", " earn ", "  last   ", " near ", " form  "};


        var orderGroups = Arrays.stream(anagrams).collect(Collectors.groupingBy(
                w->new AnagramEqualityComparer().getCanonicalString(w.trim()),
                Collectors.mapping(w->w.toUpperCase(),Collectors.toList())));

        for(var set : orderGroups.entrySet())
        {
            System.out.println(set.getKey());
            for(var word : set.getValue())
                System.out.println("\t"+word);
        }

        return 0;
    }

    public class AnagramEqualityComparer implements Comparator<String> {
        private String getCanonicalString(String word) {
            Character[] wordChars = word.chars().sorted().mapToObj(i -> (char) i).toArray(Character[]::new);
            return String.valueOf(wordChars);
        }

        @Override
        public int compare(String x, String y) {
            return getCanonicalString(x).compareTo(getCanonicalString(y));
        }
    }
}

