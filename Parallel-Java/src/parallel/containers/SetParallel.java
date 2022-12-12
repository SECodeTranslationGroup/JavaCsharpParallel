package parallel.containers;

import java.util.List;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetParallel {
    // Template 1, totally 7 functions
    public TreeSet<Character> unionGetterWithChar(TreeSet<Character> set1, TreeSet<Character> set2) {
        TreeSet<Character> set = new TreeSet<>();
        set.addAll(set1);
        set.addAll(set2);
        return set;
    }

    public TreeSet<Character> unionGetterWithCharV2(TreeSet<Character> set1, TreeSet<Character> set2) {
        TreeSet<Character> set = new TreeSet<>(set1);
        set.addAll(set2);
        return set;
    }

    public TreeSet<Character> differenceGetterWithChar(TreeSet<Character> set1, TreeSet<Character> set2) {
        TreeSet<Character> set = new TreeSet<>();
        set.addAll(set1);
        set.removeAll(set2);
        return set;
    }

    public TreeSet<Character> differenceGetterWithCharV2(TreeSet<Character> set1, TreeSet<Character> set2) {
        TreeSet<Character> set = new TreeSet<>(set1);
        set.removeAll(set2);
        return set;
    }

    public TreeSet<Character> intersectionGetterWithChar(TreeSet<Character> set1, TreeSet<Character> set2){
        TreeSet<Character> temp=new TreeSet<>(set1);
        temp.retainAll(set2);
        return temp;
    }

    public TreeSet<Character> intersectionGetterWithCharV2(TreeSet<Character> set1, TreeSet<Character> set2){
        TreeSet<Character> temp=new TreeSet<>();
        temp.addAll(set1);
        temp.retainAll(set2);
        return temp;
    }

    public TreeSet<Character> symmetricGetterWithChar(TreeSet<Character> set1, TreeSet<Character> set2){
        TreeSet<Character> resultSet = new TreeSet<>(set1);
        resultSet.addAll(set2);
        TreeSet<Character> tmpSet = new TreeSet<>(set1);
        tmpSet.retainAll(set2);
        resultSet.removeAll(tmpSet);

        return resultSet;
    }
    
    // Convert Char to String
    public TreeSet<String> unionGetterWithString(TreeSet<String> set1, TreeSet<String> set2) {
        TreeSet<String> set = new TreeSet<>();
        set.addAll(set1);
        set.addAll(set2);
        return set;
    }

    public TreeSet<String> unionGetterWithStringV2(TreeSet<String> set1, TreeSet<String> set2) {
        TreeSet<String> set = new TreeSet<>(set1);
        set.addAll(set2);
        return set;
    }

    public TreeSet<String> differenceGetterWithString(TreeSet<String> set1, TreeSet<String> set2) {
        TreeSet<String> set = new TreeSet<>();
        set.addAll(set1);
        set.removeAll(set2);
        return set;
    }

    public TreeSet<String> differenceGetterWithStringV2(TreeSet<String> set1, TreeSet<String> set2) {
        TreeSet<String> set = new TreeSet<>(set1);
        set.removeAll(set2);
        return set;
    }

    public TreeSet<String> intersectionGetterWithString(TreeSet<String> set1, TreeSet<String> set2){
        TreeSet<String> temp=new TreeSet<>(set1);
        temp.retainAll(set2);
        return temp;
    }

    public TreeSet<String> intersectionGetterWithStringV2(TreeSet<String> set1, TreeSet<String> set2){
        TreeSet<String> temp=new TreeSet<>();
        temp.addAll(set1);
        temp.retainAll(set2);
        return temp;
    }

    public TreeSet<String> symmetricGetterWithString(TreeSet<String> set1, TreeSet<String> set2){
        TreeSet<String> resultSet = new TreeSet<>(set1);
        resultSet.addAll(set2);
        TreeSet<String> tmpSet = new TreeSet<>(set1);
        tmpSet.retainAll(set2);
        resultSet.removeAll(tmpSet);

        return resultSet;
    }
    
    // Convert Char to Integer
    public TreeSet<Integer> unionGetterWithInt(TreeSet<Integer> set1, TreeSet<Integer> set2) {
        TreeSet<Integer> set = new TreeSet<>();
        set.addAll(set1);
        set.addAll(set2);
        return set;
    }

    public TreeSet<Integer> unionGetterWithIntV2(TreeSet<Integer> set1, TreeSet<Integer> set2) {
        TreeSet<Integer> set = new TreeSet<>(set1);
        set.addAll(set2);
        return set;
    }

    public TreeSet<Integer> differenceGetterWithInt(TreeSet<Integer> set1, TreeSet<Integer> set2) {
        TreeSet<Integer> set = new TreeSet<>();
        set.addAll(set1);
        set.removeAll(set2);
        return set;
    }

    public TreeSet<Integer> differenceGetterWithIntV2(TreeSet<Integer> set1, TreeSet<Integer> set2) {
        TreeSet<Integer> set = new TreeSet<>(set1);
        set.removeAll(set2);
        return set;
    }

    public TreeSet<Integer> intersectionGetterWithInt(TreeSet<Integer> set1, TreeSet<Integer> set2){
        TreeSet<Integer> temp=new TreeSet<>(set1);
        temp.retainAll(set2);
        return temp;
    }

    public TreeSet<Integer> intersectionGetterWithIntV2(TreeSet<Integer> set1, TreeSet<Integer> set2){
        TreeSet<Integer> temp=new TreeSet<>();
        temp.addAll(set1);
        temp.retainAll(set2);
        return temp;
    }

    public TreeSet<Integer> symmetricGetterWithInt(TreeSet<Integer> set1, TreeSet<Integer> set2){
        TreeSet<Integer> resultSet = new TreeSet<>(set1);
        resultSet.addAll(set2);
        TreeSet<Integer> tmpSet = new TreeSet<>(set1);
        tmpSet.retainAll(set2);
        resultSet.removeAll(tmpSet);

        return resultSet;
    }
    
    // Convert Char to Double
    public TreeSet<Double> unionGetterWithDouble(TreeSet<Double> set1, TreeSet<Double> set2) {
        TreeSet<Double> set = new TreeSet<>();
        set.addAll(set1);
        set.addAll(set2);
        return set;
    }

    public TreeSet<Double> unionGetterWithDoubleV2(TreeSet<Double> set1, TreeSet<Double> set2) {
        TreeSet<Double> set = new TreeSet<>(set1);
        set.addAll(set2);
        return set;
    }

    public TreeSet<Double> differenceGetterWithDouble(TreeSet<Double> set1, TreeSet<Double> set2) {
        TreeSet<Double> set = new TreeSet<>();
        set.addAll(set1);
        set.removeAll(set2);
        return set;
    }

    public TreeSet<Double> differenceGetterWithDoubleV2(TreeSet<Double> set1, TreeSet<Double> set2) {
        TreeSet<Double> set = new TreeSet<>(set1);
        set.removeAll(set2);
        return set;
    }

    public TreeSet<Double> intersectionGetterWithDouble(TreeSet<Double> set1, TreeSet<Double> set2){
        TreeSet<Double> temp=new TreeSet<>(set1);
        temp.retainAll(set2);
        return temp;
    }

    public TreeSet<Double> intersectionGetterWithDoubleV2(TreeSet<Double> set1, TreeSet<Double> set2){
        TreeSet<Double> temp=new TreeSet<>();
        temp.addAll(set1);
        temp.retainAll(set2);
        return temp;
    }

    public TreeSet<Double> symmetricGetterWithDouble(TreeSet<Double> set1, TreeSet<Double> set2){
        TreeSet<Double> resultSet = new TreeSet<>(set1);
        resultSet.addAll(set2);
        TreeSet<Double> tmpSet = new TreeSet<>(set1);
        tmpSet.retainAll(set2);
        resultSet.removeAll(tmpSet);

        return resultSet;
    }



    // Template 2, totally 5 functions
    public TreeSet<Character> unionWithCharList(List<Character> list1, List<Character> list2){
        TreeSet<Character> set1 = new TreeSet<>(list1);
        TreeSet<Character> set2 = new TreeSet<>(list2);
        set1.addAll(set2);
        return set1;
    }

    public TreeSet<Character> unionWithCharListV2(List<Character> list1, List<Character> list2){
        TreeSet<Character> set1 = new TreeSet<>(list1);
        set1.addAll(list2);
        return set1;
    }

    public TreeSet<Character> differenceWithCharList(List<Character> list1, List<Character> list2){
        TreeSet<Character> set1 = new TreeSet<>(list1);
        TreeSet<Character> set2 = new TreeSet<>(list2);
        set1.removeAll(set2);
        return set1;
    }

    public TreeSet<Character> intersectionWithCharList(List<Character> list1, List<Character> list2){
        TreeSet<Character> set1 = new TreeSet<>(list1);
        TreeSet<Character> set2 = new TreeSet<>(list2);
        set1.retainAll(set2);
        return set1;
    }

    public TreeSet<Character> symmetricWithCharList(List<Character> list1, List<Character> list2){
        TreeSet<Character> set1 = new TreeSet<>(list1);
        TreeSet<Character> set2 = new TreeSet<>(list2);
        TreeSet<Character> resultSet = new TreeSet<>(set1);
        resultSet.addAll(set2);

        TreeSet<Character> tmpSet = new TreeSet<>(set1);
        tmpSet.retainAll(set2);
        resultSet.removeAll(tmpSet);
        return resultSet;
    }
    
    // Convert Char to String
    public TreeSet<String> unionWithStringList(List<String> list1, List<String> list2){
        TreeSet<String> set1 = new TreeSet<>(list1);
        TreeSet<String> set2 = new TreeSet<>(list2);
        set1.addAll(set2);
        return set1;
    }

    public TreeSet<String> unionWithStringListV2(List<String> list1, List<String> list2){
        TreeSet<String> set1 = new TreeSet<>(list1);
        set1.addAll(list2);
        return set1;
    }

    public TreeSet<String> differenceWithStringList(List<String> list1, List<String> list2){
        TreeSet<String> set1 = new TreeSet<>(list1);
        TreeSet<String> set2 = new TreeSet<>(list2);
        set1.removeAll(set2);
        return set1;
    }

    public TreeSet<String> intersectionWithStringList(List<String> list1, List<String> list2){
        TreeSet<String> set1 = new TreeSet<>(list1);
        TreeSet<String> set2 = new TreeSet<>(list2);
        set1.retainAll(set2);
        return set1;
    }

    public TreeSet<String> symmetricWithStringList(List<String> list1, List<String> list2){
        TreeSet<String> set1 = new TreeSet<>(list1);
        TreeSet<String> set2 = new TreeSet<>(list2);
        TreeSet<String> resultSet = new TreeSet<>(set1);
        resultSet.addAll(set2);

        TreeSet<String> tmpSet = new TreeSet<>(set1);
        tmpSet.retainAll(set2);
        resultSet.removeAll(tmpSet);
        return resultSet;
    }

    // Convert Char to Int
    public TreeSet<Integer> unionWithIntList(List<Integer> list1, List<Integer> list2){
        TreeSet<Integer> set1 = new TreeSet<>(list1);
        TreeSet<Integer> set2 = new TreeSet<>(list2);
        set1.addAll(set2);
        return set1;
    }

    public TreeSet<Integer> unionWithIntListV2(List<Integer> list1, List<Integer> list2){
        TreeSet<Integer> set1 = new TreeSet<>(list1);
        set1.addAll(list2);
        return set1;
    }

    public TreeSet<Integer> differenceWithIntList(List<Integer> list1, List<Integer> list2){
        TreeSet<Integer> set1 = new TreeSet<>(list1);
        TreeSet<Integer> set2 = new TreeSet<>(list2);
        set1.removeAll(set2);
        return set1;
    }

    public TreeSet<Integer> intersectionWithIntList(List<Integer> list1, List<Integer> list2){
        TreeSet<Integer> set1 = new TreeSet<>(list1);
        TreeSet<Integer> set2 = new TreeSet<>(list2);
        set1.retainAll(set2);
        return set1;
    }

    public TreeSet<Integer> symmetricWithIntList(List<Integer> list1, List<Integer> list2){
        TreeSet<Integer> set1 = new TreeSet<>(list1);
        TreeSet<Integer> set2 = new TreeSet<>(list2);
        TreeSet<Integer> resultSet = new TreeSet<>(set1);
        resultSet.addAll(set2);

        TreeSet<Integer> tmpSet = new TreeSet<>(set1);
        tmpSet.retainAll(set2);
        resultSet.removeAll(tmpSet);
        return resultSet;
    }
    
    // Convert Char to Double
    public TreeSet<Double> unionWithDoubleList(List<Double> list1, List<Double> list2){
        TreeSet<Double> set1 = new TreeSet<>(list1);
        TreeSet<Double> set2 = new TreeSet<>(list2);
        set1.addAll(set2);
        return set1;
    }

    public TreeSet<Double> unionWithDoubleListV2(List<Double> list1, List<Double> list2){
        TreeSet<Double> set1 = new TreeSet<>(list1);
        set1.addAll(list2);
        return set1;
    }

    public TreeSet<Double> differenceWithDoubleList(List<Double> list1, List<Double> list2){
        TreeSet<Double> set1 = new TreeSet<>(list1);
        TreeSet<Double> set2 = new TreeSet<>(list2);
        set1.removeAll(set2);
        return set1;
    }

    public TreeSet<Double> intersectionWithDoubleList(List<Double> list1, List<Double> list2){
        TreeSet<Double> set1 = new TreeSet<>(list1);
        TreeSet<Double> set2 = new TreeSet<>(list2);
        set1.retainAll(set2);
        return set1;
    }

    public TreeSet<Double> symmetricWithDoubleList(List<Double> list1, List<Double> list2){
        TreeSet<Double> set1 = new TreeSet<>(list1);
        TreeSet<Double> set2 = new TreeSet<>(list2);
        TreeSet<Double> resultSet = new TreeSet<>(set1);
        resultSet.addAll(set2);

        TreeSet<Double> tmpSet = new TreeSet<>(set1);
        tmpSet.retainAll(set2);
        resultSet.removeAll(tmpSet);
        return resultSet;
    }

    // Template 3, Check Empty and Clear
    public void makeEmpty(TreeSet<Object> set){
        if(!set.isEmpty()){
            set.clear();
        }
    }
    //Template 4, Check Contains and Remove
    public void removeIfExistsChar(TreeSet<Character> set, Character c){
        if(set.contains(c)){
            set.remove(c);
        }
    }

    public void removeIfExistsString(TreeSet<String> set, String c){
        if(set.contains(c)){
            set.remove(c);
        }
    }

    public void removeIfExistsInt(TreeSet<Integer> set, Integer c){
        if(set.contains(c)){
            set.remove(c);
        }
    }

    public void removeIfExistsDouble(TreeSet<Double> set, Double c){
        if(set.contains(c)){
            set.remove(c);
        }
    }

    //Template 5, Check Size and return Subset
    public SortedSet<Character> subSetRangeChar(TreeSet<Character> set, int size, Character floor, Character ceil){
        SortedSet<Character> subSet = new TreeSet<>();
        if(set.size() < size) return subSet;
        else{
            subSet = set.subSet(floor,true, ceil,true);
            return subSet;
        }
    }

    public SortedSet<Character> subSetGreaterChar(TreeSet<Character> set, int size, Character floor){
        SortedSet<Character> subSet = new TreeSet<>();
        if(set.size() < size) return subSet;
        else{
            subSet = set.tailSet(floor,true);
            return subSet;
        }
    }

    public SortedSet<Character> subSetLessChar(TreeSet<Character> set, int size, Character ceil){
        SortedSet<Character> subSet = new TreeSet<>();
        if(set.size() < size) return subSet;
        else{
            subSet = set.headSet(ceil,true);
            return subSet;
        }
    }
    
    // todo Convert Char to String
    public SortedSet<String> subSetRangeString(TreeSet<String> set, int size, String floor, String ceil){
        SortedSet<String> subSet = new TreeSet<>();
        if(set.size() < size) return subSet;
        else{
            subSet = set.subSet(floor,true, ceil,true);
            return subSet;
        }
    }

    public SortedSet<String> subSetGreaterString(TreeSet<String> set, int size, String floor){
        SortedSet<String> subSet = new TreeSet<>();
        if(set.size() < size) return subSet;
        else{
            subSet = set.tailSet(floor,true);
            return subSet;
        }
    }

    public SortedSet<String> subSetLessString(TreeSet<String> set, int size, String ceil){
        SortedSet<String> subSet = new TreeSet<>();
        if(set.size() < size) return subSet;
        else{
            subSet = set.headSet(ceil,true);
            return subSet;
        }
    }
    
    // todo Convert Char to Integer
    public SortedSet<Integer> subSetRangeInt(TreeSet<Integer> set, int size, Integer floor, Integer ceil){
        SortedSet<Integer> subSet = new TreeSet<>();
        if(set.size() < size) return subSet;
        else{
            subSet = set.subSet(floor,true, ceil,true);
            return subSet;
        }
    }

    public SortedSet<Integer> subSetGreaterInt(TreeSet<Integer> set, int size, Integer floor){
        SortedSet<Integer> subSet = new TreeSet<>();
        if(set.size() < size) return subSet;
        else{
            subSet = set.tailSet(floor,true);
            return subSet;
        }
    }

    public SortedSet<Integer> subSetLessInt(TreeSet<Integer> set, int size, Integer ceil){
        SortedSet<Integer> subSet = new TreeSet<>();
        if(set.size() < size) return subSet;
        else{
            subSet = set.headSet(ceil,true);
            return subSet;
        }
    }
    
    // todo Convert Char to Double
    public SortedSet<Double> subSetRangeDouble(TreeSet<Double> set, int size, Double floor, Double ceil){
        SortedSet<Double> subSet = new TreeSet<>();
        if(set.size() < size) return subSet;
        else{
            subSet = set.subSet(floor,true, ceil,true);
            return subSet;
        }
    }

    public SortedSet<Double> subSetGreaterDouble(TreeSet<Double> set, int size, Double floor){
        SortedSet<Double> subSet = new TreeSet<>();
        if(set.size() < size) return subSet;
        else{
            subSet = set.tailSet(floor,true);
            return subSet;
        }
    }

    public SortedSet<Double> subSetLessDouble(TreeSet<Double> set, int size, Double ceil){
        SortedSet<Double> subSet = new TreeSet<>();
        if(set.size() < size) return subSet;
        else{
            subSet = set.headSet(ceil,true);
            return subSet;
        }
    }

    // Template 6, Check Size and find ceil and floor
    public Optional<Character> ceilChar(TreeSet<Character> set, int size, Character ceil){
        Optional<Character> c;
        if(set.size() < size) return null;
        else{
            c = Optional.ofNullable(set.ceiling(ceil));
            return c;
        }
    }

    public Optional<Character> floorChar(TreeSet<Character> set, int size, Character floor){
        Optional<Character> c;
        if(set.size() < size) return null;
        else{
            c = Optional.ofNullable(set.floor(floor));
            return c;
        }
    }
    
    // todo Convert Char to String
    public Optional<String> ceilString(TreeSet<String> set, int size, String ceil){
        Optional<String> c;
        if(set.size() < size) return null;
        else{
            c = Optional.ofNullable(set.ceiling(ceil));
            return c;
        }
    }

    public Optional<String> floorString(TreeSet<String> set, int size, String floor){
        Optional<String> c;
        if(set.size() < size) return null;
        else{
            c = Optional.ofNullable(set.floor(floor));
            return c;
        }
    }
    
    // todo Convert Char to Int
    public Optional<Integer> ceilInt(TreeSet<Integer> set, int size, Integer ceil){
        Optional<Integer> c;
        if(set.size() < size) return null;
        else{
            c = Optional.ofNullable(set.ceiling(ceil));
            return c;
        }
    }

    public Optional<Integer> floorInt(TreeSet<Integer> set, int size, Integer floor){
        Optional<Integer> c;
        if(set.size() < size) return null;
        else{
            c = Optional.ofNullable(set.floor(floor));
            return c;
        }
    }
    
    // todo Convert Char to Double
    public Optional<Double> ceilDouble(TreeSet<Double> set, int size, Double ceil){
        Optional<Double> c;
        if(set.size() < size) return null;
        else{
            c = Optional.ofNullable(set.ceiling(ceil));
            return c;
        }
    }

    public Optional<Double> floorDouble(TreeSet<Double> set, int size, Double floor){
        Optional<Double> c;
        if(set.size() < size) return null;
        else{
            c = Optional.ofNullable(set.floor(floor));
            return c;
        }
    }
}
