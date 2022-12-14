package parallel.containers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class UnorderedSetParallel {
    // T1
    public HashSet<Character> getSetChar(){
        HashSet<Character> set = new HashSet<>();
        for(int i=41; i<51; ++i){
            set.add((char)i);
        }
        return set;
    }

    // T2
    public HashSet<Character> addListChar(HashSet<Character> set, List<Character> list){
        for(Character ele : list){
            if(!set.contains(ele)){
                set.add(ele);
            }
        }
        return set;
    }

    // T3
    public HashSet<Character> removeListChar(HashSet<Character> set, List<Character> list){
        for(Character ele : list){
            if(set.contains(ele)){
                set.remove(ele);
            }
        }
        return set;
    }

    public HashSet<Character> removeReverseListChar(HashSet<Character> set, List<Character> list){
        for(Character ele : list){
            if(!set.contains(ele)){
                set.remove(ele);
            }
        }
        return set;
    }

    // T4
    public HashSet<Character> addTwoListChar(HashSet<Character> set, List<Character> list1, List<Character> list2){
        HashSet<Character> result = new HashSet<>(set);
        result.addAll(list1);
        result.addAll(list2);
        return result;
    }

    // T5
    public void combineTwoSetChar(HashSet<Character> set1, HashSet<Character> set2){
        for(Character ele : set2){
            set1.add(ele);
        }
    }

    // T6
    public void intersectTwoSetChar(HashSet<Character> set1, HashSet<Character> set2){
        for(Character ele : set2){
            if(!set1.contains(ele)){
                set1.remove(ele);
            }
        }
    }


    // Convert Char to String
    // T1
    public HashSet<String> getSetString(){
        HashSet<String> set = new HashSet<>();
        for(int i=41; i<51; ++i){
            set.add((String.valueOf(i)));
        }
        return set;
    }

    // T2
    public HashSet<String> addListString(HashSet<String> set, List<String> list){
        for(String ele : list){
            if(!set.contains(ele)){
                set.add(ele);
            }
        }
        return set;
    }

    // T3
    public HashSet<String> removeListString(HashSet<String> set, List<String> list){
        for(String ele : list){
            if(set.contains(ele)){
                set.remove(ele);
            }
        }
        return set;
    }

    public HashSet<String> removeReverseListString(HashSet<String> set, List<String> list){
        for(String ele : list){
            if(!set.contains(ele)){
                set.remove(ele);
            }
        }
        return set;
    }

    // T4
    public HashSet<String> addTwoListString(HashSet<String> set, List<String> list1, List<String> list2){
        HashSet<String> result = new HashSet<>(set);
        result.addAll(list1);
        result.addAll(list2);
        return result;
    }

    // T5
    public void combineTwoSetString(HashSet<String> set1, HashSet<String> set2){
        for(String ele : set2){
            set1.add(ele);
        }
    }

    // T6
    public void intersectTwoSetString(HashSet<String> set1, HashSet<String> set2){
        for(String ele : set2){
            if(!set1.contains(ele)){
                set1.remove(ele);
            }
        }
    }


    // Convert Char to Int
    // T1
    public HashSet<Integer> getSetInt(){
        HashSet<Integer> set = new HashSet<>();
        for(int i=41; i<51; ++i){
            set.add(i);
        }
        return set;
    }

    // T2
    public HashSet<Integer> addListInt(HashSet<Integer> set, List<Integer> list){
        for(Integer ele : list){
            if(!set.contains(ele)){
                set.add(ele);
            }
        }
        return set;
    }

    // T3
    public HashSet<Integer> removeListInt(HashSet<Integer> set, List<Integer> list){
        for(Integer ele : list){
            if(set.contains(ele)){
                set.remove(ele);
            }
        }
        return set;
    }

    public HashSet<Integer> removeReverseListInt(HashSet<Integer> set, List<Integer> list){
        for(Integer ele : list){
            if(!set.contains(ele)){
                set.remove(ele);
            }
        }
        return set;
    }

    // T4
    public HashSet<Integer> addTwoListInt(HashSet<Integer> set, List<Integer> list1, List<Integer> list2){
        HashSet<Integer> result = new HashSet<>(set);
        result.addAll(list1);
        result.addAll(list2);
        return result;
    }

    // T5
    public void combineTwoSetInt(HashSet<Integer> set1, HashSet<Integer> set2){
        for(Integer ele : set2){
            set1.add(ele);
        }
    }

    // T6
    public void intersectTwoSetInt(HashSet<Integer> set1, HashSet<Integer> set2){
        for(Integer ele : set2){
            if(!set1.contains(ele)){
                set1.remove(ele);
            }
        }
    }


    // Convert Char to Double
    // T1
    public HashSet<Double> getSetDouble(){
        HashSet<Double> set = new HashSet<>();
        for(int i=41; i<51; ++i){
            set.add(i + 0.1);
        }
        return set;
    }

    // T2
    public HashSet<Double> addListDouble(HashSet<Double> set, List<Double> list){
        for(Double ele : list){
            if(!set.contains(ele)){
                set.add(ele);
            }
        }
        return set;
    }

    // T3
    public HashSet<Double> removeListDouble(HashSet<Double> set, List<Double> list){
        for(Double ele : list){
            if(set.contains(ele)){
                set.remove(ele);
            }
        }
        return set;
    }

    public HashSet<Double> removeReverseListDouble(HashSet<Double> set, List<Double> list){
        for(Double ele : list){
            if(!set.contains(ele)){
                set.remove(ele);
            }
        }
        return set;
    }

    // T4
    public HashSet<Double> addTwoListDouble(HashSet<Double> set, List<Double> list1, List<Double> list2){
        HashSet<Double> result = new HashSet<>(set);
        result.addAll(list1);
        result.addAll(list2);
        return result;
    }

    // T5
    public void combineTwoSetDouble(HashSet<Double> set1, HashSet<Double> set2){
        for(Double ele : set2){
            set1.add(ele);
        }
    }

    // T6
    public void intersectTwoSetDouble(HashSet<Double> set1, HashSet<Double> set2){
        for(Double ele : set2){
            if(!set1.contains(ele)){
                set1.remove(ele);
            }
        }
    }

    // NT1
    public HashSet<Character> getFoodSetChar(){
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'b', 'c'));
        set.add('d');
        return set;
    }

    public boolean containsTwoFoodSetChar(HashSet<Character> set, Character ele1, Character ele2){
        boolean b1 = set.contains(ele1);
        boolean b2 = set.contains(ele2);
        return b1 && b2;
    }

    public void clearSmallSetChar(HashSet<Character> set, int length){
        if(set.isEmpty()) return;
        if(set.size() <= length)
            set.clear();
    }
    
    // to String
    public HashSet<String> getFoodSetString(){
        HashSet<String> set = new HashSet<>(Arrays.asList("aa", "bb", "cc"));
        set.add("dd");
        return set;
    }

    public boolean containsTwoFoodSetString(HashSet<String> set, String ele1, String ele2){
        boolean b1 = set.contains(ele1);
        boolean b2 = set.contains(ele2);
        return b1 && b2;
    }

    public void clearSmallSetString(HashSet<String> set, int length){
        if(set.isEmpty()) return;
        if(set.size() <= length)
            set.clear();
    }
    
    // to int
    public HashSet<Integer> getFoodSetInt(){
        HashSet<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));
        set.add(4);
        return set;
    }

    public boolean containsTwoFoodSetInt(HashSet<Integer> set, Integer ele1, Integer ele2){
        boolean b1 = set.contains(ele1);
        boolean b2 = set.contains(ele2);
        return b1 && b2;
    }

    public void clearSmallSetInt(HashSet<Integer> set, int length){
        if(set.isEmpty()) return;
        if(set.size() <= length)
            set.clear();
    }
    
    // to double
    public HashSet<Double> getFoodSetDouble(){
        HashSet<Double> set = new HashSet<>(Arrays.asList(1.0, 2.0, 3.0));
        set.add(4.0);
        return set;
    }

    public boolean containsTwoFoodSetDouble(HashSet<Double> set, Double ele1, Double ele2){
        boolean b1 = set.contains(ele1);
        boolean b2 = set.contains(ele2);
        return b1 && b2;
    }

    public void clearSmallSetDouble(HashSet<Double> set, int length){
        if(set.isEmpty()) return;
        if(set.size() <= length)
            set.clear();
    }
}
