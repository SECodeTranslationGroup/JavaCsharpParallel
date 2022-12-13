package parallel.containers;

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
}
