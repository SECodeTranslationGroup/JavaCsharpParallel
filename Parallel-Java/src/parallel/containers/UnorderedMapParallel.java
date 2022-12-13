package parallel.containers;

import org.javatuples.Pair;

import java.util.*;

public class UnorderedMapParallel {
    // T1
    public HashMap<Character, Character> getMapChar(HashMap<Character, Character> map){
        HashMap<Character, Character> m = new HashMap<>(Map.of('a', 'a',
                'b', 'b', 'c', 'c'));
        map = new HashMap<>(m);
        return m;
    }

    // T2
    public void clearMapChar(HashMap<Character, Character> map, int size){
        if(map.isEmpty()) return;
        if(map.size() <= size) map.clear();
    }

    // T3
    public void containsThreeChar(HashMap<Character, Character> map){
        if(map.containsKey('a') && map.containsKey('b') && map.containsKey('c')){
            map.put('d','d');
        }
    }

    // T4
    public void containsDeleteChar(HashMap<Character, Character> map, Character element){
        if(map.containsKey(element)){
            map.remove(element);
        }
    }

    public void containsDeleteListChar(HashMap<Character, Character> map, List<Character> deleteList){
        for(Character element : deleteList){
            if(map.containsKey(element)){
                map.remove(element);
            }
        }
    }

    // T5
    public void tryAddSizeChar(HashMap<Character, Character> map, int size, Character c){
        if(map.size() >= size) return;
        map.putIfAbsent(c, c);
    }

    public void tryAddListChar(HashMap<Character, Character> map, List<Character> list){
        for(Character element : list){
            map.putIfAbsent(element, element);
        }
    }

    // T6
    public List<Character> getValuesListCharWithDefault(HashMap<Character, Character> map, List<Character> keys, Character default_){
        List<Character> values = new ArrayList<>();
        for(Character key : keys){
            Character value = map.getOrDefault(key, default_);
            values.add(value);
        }
        return values;
    }

    // T7
    public List<Optional<Character>> getValuesListCharWithNull(HashMap<Character, Character> map, List<Character> keys){
        List<Optional<Character>> values = new ArrayList<>();
        for(Character key : keys){
            Optional<Character> value = Optional.ofNullable(map.get(key));
            values.add(value);
        }
        return values;
    }

    // T8
    public HashMap<Character, Character> composeMapChar(List<Character> keys, List<Character> values){
        HashMap<Character, Character> map = new HashMap<>();
        if(keys.size() != values.size() || keys.size() == 0) return map;
        else{
            int size = keys.size();
            for(int i=0; i<size; ++i){
                map.put(keys.get(i), values.get(i));
            }
        }
        return map;
    }

    public HashMap<Character, String> composeMapCharString(List<Character> keys, List<String> values){
        HashMap<Character, String> map = new HashMap<>();
        if(keys.size() != values.size() || keys.size() == 0) return map;
        else{
            int size = keys.size();
            for(int i=0; i<size; ++i){
                map.put(keys.get(i), values.get(i));
            }
        }
        return map;
    }

    public HashMap<Character, Character> composeMapsChar(HashMap<Character, Character> map1, HashMap<Character, Character> map2){
        HashMap<Character, Character> map = new HashMap<>();
        for(Map.Entry<Character, Character> ent : map1.entrySet()){
            map.put(ent.getKey(), ent.getValue());
        }

        for(Map.Entry<Character, Character> ent : map2.entrySet()){
            map.putIfAbsent(ent.getKey(), ent.getValue());
        }
        return map;
    }

    // Convert Char to String

    // T1
    public HashMap<String, String> getMapString(HashMap<String, String> map){
        HashMap<String, String> m = new HashMap<>(Map.of("aa", "aa",
                "bb", "bb", "cc", "cc"));
        map = new HashMap<>(m);
        return m;
    }

    // T2
    public void clearMapString(HashMap<String, String> map, int size){
        if(map.isEmpty()) return;
        if(map.size() <= size) map.clear();
    }

    // T3
    public void containsThreeString(HashMap<String, String> map){
        if(map.containsKey("aa") && map.containsKey("bb") && map.containsKey("cc")){
            map.put("dd","dd");
        }
    }

    // T4
    public void containsDeleteString(HashMap<String, String> map, String element){
        if(map.containsKey(element)){
            map.remove(element);
        }
    }

    public void containsDeleteListString(HashMap<String, String> map, List<String> deleteList){
        for(String element : deleteList){
            if(map.containsKey(element)){
                map.remove(element);
            }
        }
    }

    // T5
    public void tryAddSizeString(HashMap<String, String> map, int size, String c){
        if(map.size() >= size) return;
        map.putIfAbsent(c, c);
    }

    public void tryAddListString(HashMap<String, String> map, List<String> list){
        for(String element : list){
            map.putIfAbsent(element, element);
        }
    }

    // T6
    public List<String> getValuesListStringWithDefault(HashMap<String, String> map, List<String> keys, String default_){
        List<String> values = new ArrayList<>();
        for(String key : keys){
            String value = map.getOrDefault(key, default_);
            values.add(value);
        }
        return values;
    }

    // T7
    public List<Optional<String>> getValuesListStringWithNull(HashMap<String, String> map, List<String> keys){
        List<Optional<String>> values = new ArrayList<>();
        for(String key : keys){
            Optional<String> value = Optional.ofNullable(map.get(key));
            values.add(value);
        }
        return values;
    }

    // T8
    public HashMap<String, String> composeMapString(List<String> keys, List<String> values){
        HashMap<String, String> map = new HashMap<>();
        if(keys.size() != values.size() || keys.size() == 0) return map;
        else{
            int size = keys.size();
            for(int i=0; i<size; ++i){
                map.put(keys.get(i), values.get(i));
            }
        }
        return map;
    }

    public HashMap<String, Character> composeMapStringChar(List<String> keys, List<Character> values){
        HashMap<String, Character> map = new HashMap<>();
        if(keys.size() != values.size() || keys.size() == 0) return map;
        else{
            int size = keys.size();
            for(int i=0; i<size; ++i){
                map.put(keys.get(i), values.get(i));
            }
        }
        return map;
    }

    public HashMap<String, String> composeMapsString(HashMap<String, String> map1, HashMap<String, String> map2){
        HashMap<String, String> map = new HashMap<>();
        for(Map.Entry<String, String> ent : map1.entrySet()){
            map.put(ent.getKey(), ent.getValue());
        }

        for(Map.Entry<String, String> ent : map2.entrySet()){
            map.putIfAbsent(ent.getKey(), ent.getValue());
        }
        return map;
    }

    // Convert Char to Int
    // T1
    public HashMap<Integer, Integer> getMapInt(HashMap<Integer, Integer> map){
        HashMap<Integer, Integer> m = new HashMap<>(Map.of(1, 1,
                2, 2, 3, 3));
        map = new HashMap<>(m);
        return m;
    }

    // T2
    public void clearMapInt(HashMap<Integer, Integer> map, int size){
        if(map.isEmpty()) return;
        if(map.size() <= size) map.clear();
    }

    // T3
    public void containsThreeInt(HashMap<Integer, Integer> map){
        if(map.containsKey(1) && map.containsKey(2) && map.containsKey(3)){
            map.put(4,4);
        }
    }

    // T4
    public void containsDeleteInt(HashMap<Integer, Integer> map, Integer element){
        if(map.containsKey(element)){
            map.remove(element);
        }
    }

    public void containsDeleteListInt(HashMap<Integer, Integer> map, List<Integer> deleteList){
        for(Integer element : deleteList){
            if(map.containsKey(element)){
                map.remove(element);
            }
        }
    }

    // T5
    public void tryAddSizeInt(HashMap<Integer, Integer> map, int size, Integer c){
        if(map.size() >= size) return;
        map.putIfAbsent(c, c);
    }

    public void tryAddListInt(HashMap<Integer, Integer> map, List<Integer> list){
        for(Integer element : list){
            map.putIfAbsent(element, element);
        }
    }

    // T6
    public List<Integer> getValuesListIntWithDefault(HashMap<Integer, Integer> map, List<Integer> keys, Integer default_){
        List<Integer> values = new ArrayList<>();
        for(Integer key : keys){
            Integer value = map.getOrDefault(key, default_);
            values.add(value);
        }
        return values;
    }

    // T7
    public List<Optional<Integer>> getValuesListIntWithNull(HashMap<Integer, Integer> map, List<Integer> keys){
        List<Optional<Integer>> values = new ArrayList<>();
        for(Integer key : keys){
            Optional<Integer> value = Optional.ofNullable(map.get(key));
            values.add(value);
        }
        return values;
    }

    // T8
    public HashMap<Integer, Integer> composeMapInt(List<Integer> keys, List<Integer> values){
        HashMap<Integer, Integer> map = new HashMap<>();
        if(keys.size() != values.size() || keys.size() == 0) return map;
        else{
            int size = keys.size();
            for(int i=0; i<size; ++i){
                map.put(keys.get(i), values.get(i));
            }
        }
        return map;
    }

    public HashMap<Integer, String> composeMapIntString(List<Integer> keys, List<String> values){
        HashMap<Integer, String> map = new HashMap<>();
        if(keys.size() != values.size() || keys.size() == 0) return map;
        else{
            int size = keys.size();
            for(int i=0; i<size; ++i){
                map.put(keys.get(i), values.get(i));
            }
        }
        return map;
    }

    public HashMap<Integer, Integer> composeMapsInt(HashMap<Integer, Integer> map1, HashMap<Integer, Integer> map2){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Map.Entry<Integer, Integer> ent : map1.entrySet()){
            map.put(ent.getKey(), ent.getValue());
        }

        for(Map.Entry<Integer, Integer> ent : map2.entrySet()){
            map.putIfAbsent(ent.getKey(), ent.getValue());
        }
        return map;
    }
    
    // Convert Char to Double
    // T1
    public HashMap<Double, Double> getMapDouble(HashMap<Double, Double> map){
        HashMap<Double, Double> m = new HashMap<>(Map.of(1.0, 1.0,
                2.0, 2.0, 3.0, 3.0));
        map = new HashMap<>(m);
        return m;
    }

    // T2
    public void clearMapDouble(HashMap<Double, Double> map, int size){
        if(map.isEmpty()) return;
        if(map.size() <= size) map.clear();
    }

    // T3
    public void containsThreeDouble(HashMap<Double, Double> map){
        if(map.containsKey(1.0) && map.containsKey(2.0) && map.containsKey(3.0)){
            map.put(4.0, 4.0);
        }
    }

    // T4
    public void containsDeleteDouble(HashMap<Double, Double> map, Double element){
        if(map.containsKey(element)){
            map.remove(element);
        }
    }

    public void containsDeleteListDouble(HashMap<Double, Double> map, List<Double> deleteList){
        for(Double element : deleteList){
            if(map.containsKey(element)){
                map.remove(element);
            }
        }
    }

    // T5
    public void tryAddSizeDouble(HashMap<Double, Double> map, int size, Double c){
        if(map.size() >= size) return;
        map.putIfAbsent(c, c);
    }

    public void tryAddListDouble(HashMap<Double, Double> map, List<Double> list){
        for(Double element : list){
            map.putIfAbsent(element, element);
        }
    }

    // T6
    public List<Double> getValuesListDoubleWithDefault(HashMap<Double, Double> map, List<Double> keys, Double default_){
        List<Double> values = new ArrayList<>();
        for(Double key : keys){
            Double value = map.getOrDefault(key, default_);
            values.add(value);
        }
        return values;
    }

    // T7
    public List<Optional<Double>> getValuesListDoubleWithNull(HashMap<Double, Double> map, List<Double> keys){
        List<Optional<Double>> values = new ArrayList<>();
        for(Double key : keys){
            Optional<Double> value = Optional.ofNullable(map.get(key));
            values.add(value);
        }
        return values;
    }

    // T8
    public HashMap<Double, Double> composeMapDouble(List<Double> keys, List<Double> values){
        HashMap<Double, Double> map = new HashMap<>();
        if(keys.size() != values.size() || keys.size() == 0) return map;
        else{
            int size = keys.size();
            for(int i=0; i<size; ++i){
                map.put(keys.get(i), values.get(i));
            }
        }
        return map;
    }

    public HashMap<Double, String> composeMapDoubleString(List<Double> keys, List<String> values){
        HashMap<Double, String> map = new HashMap<>();
        if(keys.size() != values.size() || keys.size() == 0) return map;
        else{
            int size = keys.size();
            for(int i=0; i<size; ++i){
                map.put(keys.get(i), values.get(i));
            }
        }
        return map;
    }

    public HashMap<Double, Double> composeMapsDouble(HashMap<Double, Double> map1, HashMap<Double, Double> map2){
        HashMap<Double, Double> map = new HashMap<>();
        for(Map.Entry<Double, Double> ent : map1.entrySet()){
            map.put(ent.getKey(), ent.getValue());
        }

        for(Map.Entry<Double, Double> ent : map2.entrySet()){
            map.putIfAbsent(ent.getKey(), ent.getValue());
        }
        return map;
    }
}
