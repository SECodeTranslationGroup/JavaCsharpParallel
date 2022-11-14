package parallel.linq101;

import org.javatuples.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Conversions {

    public int convertToArray() {
        double[] doubles = {1.7, 2.3, 1.9, 4.1, 2.9};
        var doublesArray = Arrays.stream(doubles).boxed().
                sorted(Comparator.comparing(d -> d)).toArray();
        System.out.println("Every other double from highest to lowest:");
        for (int d = 0; d < doublesArray.length; d += 2)
            System.out.println(doublesArray[d]);
        return 0;
    }

    public int convertToList() {
        String[] words = {"cherry", "apple", "blueberry"};
        var sortedWords = Arrays.stream(words).sorted().collect(Collectors.toList());
        System.out.println("The sorted word list:");
        for (var w : sortedWords)
            System.out.println(w);
        return 0;
    }

    public int convertToDictionary() {
        var scoreRecords = new Pair[]{Pair.with("Alice", 50), Pair.with("Bob", 40), Pair.with("Cathy", 45)};
        var scoreRecordsDict = Arrays.stream(scoreRecords).collect(
                Collectors.toMap(sr -> sr.getValue0(), sr -> sr.getValue1()));
        System.out.println("Bob's score: " + scoreRecordsDict.get("Bob"));
        return 0;
    }

    public int convertSelectedItems() {
        Object[] numbers = { null, 1.0, "two", 3, "four", 5, "six", 7.0 };

        var doubles = Arrays.stream(numbers).filter(o->o instanceof Double).toArray();

        System.out.println("Numbers stored as doubles:");
        for (var d : doubles)
            System.out.println(d);
        return 0;
    }
}
