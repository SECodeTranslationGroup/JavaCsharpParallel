package parallel.containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VectorParallel {
    // T1
    public ArrayList<Character> getListChar(){
        ArrayList<Character> vec1 = new ArrayList<>(Arrays.asList('a','b','c'));
        vec1.add('d');
        return vec1;
    }

    public ArrayList<Character> getNCopyChar(Character ele, int size){
        ArrayList<Character> vec = new ArrayList<>(Collections.nCopies(size, ele));
        return vec;
    }

    // T2
    public void reSizeListChar(ArrayList<Character> vec, int size, Character ele){
        if (vec.size() >= size) {
            vec.subList(size, vec.size()).clear();
        } else {
            vec.addAll(Collections.nCopies(size - vec.size(), ele));
        }
    }

    // T3
    public void clearSizeListChar(ArrayList<Character> vec, int size){
        if(vec.isEmpty()) return;
        if(vec.size() <= size) {
            vec.clear();
        }
    }

    // T4
    public int insertListChar(ArrayList<Character> vec, int index, Character ele){
        if(index > vec.size() || index < 0) return -1;
        vec.add(index, ele);
        return vec.size();
    }

    // T5
    public int insertListCharWithList(ArrayList<Character> vec, int index, List<Character> eles){
        if(index > vec.size() || index < 0) return -1;
        vec.addAll(index, eles);
        return vec.size();
    }

    // T6
    public boolean containsAnyChar(ArrayList<Character> vec, List<Character> eles){
        if(vec.isEmpty() || eles.isEmpty()) return false;
        for(Character ele : eles){
            if(vec.contains(ele))
                return true;
        }
        return false;
    }

    public boolean containsAllChar(ArrayList<Character> vec, List<Character> eles){
        if(vec.isEmpty() || eles.isEmpty()) return false;
        for(Character ele : eles){
            if(!vec.contains(ele))
                return false;
        }
        return true;
    }

    // T7
    public void setListChar(ArrayList<Character> vec, int position , Character v){
        if(position < 0 || position >= vec.size()) return;
        else{
            vec.set(position, v);
        }
    }

    public void setListCharWithList(ArrayList<Character> vec, ArrayList<Integer> position, ArrayList<Character> v){
        if(vec.size() < position.size()) return;
        else{
            for(int i=0; i<position.size(); ++i){
                vec.set(position.get(i), v.get(i));
            }
        }
    }

    // T8
    public void removeListChar(ArrayList<Character> vec, int position){
        if(position < 0 || position >= vec.size()) return;
        vec.remove(position);
    }

    public void removeListCharWithList(ArrayList<Character> vec, List<Integer> positions){
        for(Integer position : positions){
            if(position >= 0 && position < vec.size())
                vec.remove(position);
        }
    }

    public void removeListCharRange(ArrayList<Character> vec, int start, int off){
        if(start < 0 || start >= vec.size()) return;
        if(off < 0 || off >= vec.size()) return;
        if(start >= off) return;
        vec.subList(start, off).clear();
    }

    
    // Convert Char to String
    // T1
    public ArrayList<String> getListString(){
        ArrayList<String> vec1 = new ArrayList<>(Arrays.asList("aa","bb","cc"));
        vec1.add("dd");
        return vec1;
    }

    public ArrayList<String> getNCopyString(String ele, int size){
        ArrayList<String> vec = new ArrayList<>(Collections.nCopies(size, ele));
        return vec;
    }

    // T2
    public void reSizeListString(ArrayList<String> vec, int size, String ele){
        if (vec.size() >= size) {
            vec.subList(size, vec.size()).clear();
        } else {
            vec.addAll(Collections.nCopies(size - vec.size(), ele));
        }
    }

    // T3
    public void clearSizeListString(ArrayList<String> vec, int size){
        if(vec.isEmpty()) return;
        if(vec.size() <= size) {
            vec.clear();
        }
    }

    // T4
    public int insertListString(ArrayList<String> vec, int index, String ele){
        if(index > vec.size() || index < 0) return -1;
        vec.add(index, ele);
        return vec.size();
    }

    // T5
    public int insertListStringWithList(ArrayList<String> vec, int index, List<String> eles){
        if(index > vec.size() || index < 0) return -1;
        vec.addAll(index, eles);
        return vec.size();
    }

    // T6
    public boolean containsAnyString(ArrayList<String> vec, List<String> eles){
        if(vec.isEmpty() || eles.isEmpty()) return false;
        for(String ele : eles){
            if(vec.contains(ele))
                return true;
        }
        return false;
    }

    public boolean containsAllString(ArrayList<String> vec, List<String> eles){
        if(vec.isEmpty() || eles.isEmpty()) return false;
        for(String ele : eles){
            if(!vec.contains(ele))
                return false;
        }
        return true;
    }

    // T7
    public void setListString(ArrayList<String> vec, int position , String v){
        if(position < 0 || position >= vec.size()) return;
        else{
            vec.set(position, v);
        }
    }

    public void setListStringWithList(ArrayList<String> vec, ArrayList<Integer> position, ArrayList<String> v){
        if(vec.size() < position.size()) return;
        else{
            for(int i=0; i<position.size(); ++i){
                vec.set(position.get(i), v.get(i));
            }
        }
    }

    // T8
    public void removeListString(ArrayList<String> vec, int position){
        if(position < 0 || position >= vec.size()) return;
        vec.remove(position);
    }

    public void removeListStringWithList(ArrayList<String> vec, List<Integer> positions){
        for(Integer position : positions){
            if(position >= 0 && position < vec.size())
                vec.remove(position);
        }
    }

    public void removeListStringRange(ArrayList<String> vec, int start, int off){
        if(start < 0 || start >= vec.size()) return;
        if(off < 0 || off >= vec.size()) return;
        if(start >= off) return;
        vec.subList(start, off).clear();
    }


    // Convert Char to Integer
    // T1
    public ArrayList<Integer> getListInt(){
        ArrayList<Integer> vec1 = new ArrayList<>(Arrays.asList(1,2,3));
        vec1.add(4);
        return vec1;
    }

    public ArrayList<Integer> getNCopyInt(Integer ele, int size){
        ArrayList<Integer> vec = new ArrayList<>(Collections.nCopies(size, ele));
        return vec;
    }

    // T2
    public void reSizeListInt(ArrayList<Integer> vec, int size, Integer ele){
        if (vec.size() >= size) {
            vec.subList(size, vec.size()).clear();
        } else {
            vec.addAll(Collections.nCopies(size - vec.size(), ele));
        }
    }

    // T3
    public void clearSizeListInt(ArrayList<Integer> vec, int size){
        if(vec.isEmpty()) return;
        if(vec.size() <= size) {
            vec.clear();
        }
    }

    // T4
    public int insertListInt(ArrayList<Integer> vec, int index, Integer ele){
        if(index > vec.size() || index < 0) return -1;
        vec.add(index, ele);
        return vec.size();
    }

    // T5
    public int insertListIntWithList(ArrayList<Integer> vec, int index, List<Integer> eles){
        if(index > vec.size() || index < 0) return -1;
        vec.addAll(index, eles);
        return vec.size();
    }

    // T6
    public boolean containsAnyInt(ArrayList<Integer> vec, List<Integer> eles){
        if(vec.isEmpty() || eles.isEmpty()) return false;
        for(Integer ele : eles){
            if(vec.contains(ele))
                return true;
        }
        return false;
    }

    public boolean containsAllInt(ArrayList<Integer> vec, List<Integer> eles){
        if(vec.isEmpty() || eles.isEmpty()) return false;
        for(Integer ele : eles){
            if(!vec.contains(ele))
                return false;
        }
        return true;
    }

    // T7
    public void setListInt(ArrayList<Integer> vec, int position , Integer v){
        if(position < 0 || position >= vec.size()) return;
        else{
            vec.set(position, v);
        }
    }

    public void setListIntWithList(ArrayList<Integer> vec, ArrayList<Integer> position, ArrayList<Integer> v){
        if(vec.size() < position.size()) return;
        else{
            for(int i=0; i<position.size(); ++i){
                vec.set(position.get(i), v.get(i));
            }
        }
    }

    // T8
    public void removeListInt(ArrayList<Integer> vec, int position){
        if(position < 0 || position >= vec.size()) return;
        vec.remove(position);
    }

    public void removeListIntWithList(ArrayList<Integer> vec, List<Integer> positions){
        for(Integer position : positions){
            if(position >= 0 && position < vec.size())
                vec.remove(position);
        }
    }

    public void removeListIntRange(ArrayList<Integer> vec, int start, int off){
        if(start < 0 || start >= vec.size()) return;
        if(off < 0 || off >= vec.size()) return;
        if(start >= off) return;
        vec.subList(start, off).clear();
    }


    // Convert Char to Double
    // T1
    public ArrayList<Double> getListDouble(){
        ArrayList<Double> vec1 = new ArrayList<>(Arrays.asList(1.0,2.0,3.0));
        vec1.add(4.0);
        return vec1;
    }

    public ArrayList<Double> getNCopyDouble(Double ele, int size){
        ArrayList<Double> vec = new ArrayList<>(Collections.nCopies(size, ele));
        return vec;
    }

    // T2
    public void reSizeListDouble(ArrayList<Double> vec, int size, Double ele){
        if (vec.size() >= size) {
            vec.subList(size, vec.size()).clear();
        } else {
            vec.addAll(Collections.nCopies(size - vec.size(), ele));
        }
    }

    // T3
    public void clearSizeListDouble(ArrayList<Double> vec, int size){
        if(vec.isEmpty()) return;
        if(vec.size() <= size) {
            vec.clear();
        }
    }

    // T4
    public int insertListDouble(ArrayList<Double> vec, int index, Double ele){
        if(index > vec.size() || index < 0) return -1;
        vec.add(index, ele);
        return vec.size();
    }

    // T5
    public int insertListDoubleWithList(ArrayList<Double> vec, int index, List<Double> eles){
        if(index > vec.size() || index < 0) return -1;
        vec.addAll(index, eles);
        return vec.size();
    }

    // T6
    public boolean containsAnyDouble(ArrayList<Double> vec, List<Double> eles){
        if(vec.isEmpty() || eles.isEmpty()) return false;
        for(Double ele : eles){
            if(vec.contains(ele))
                return true;
        }
        return false;
    }

    public boolean containsAllDouble(ArrayList<Double> vec, List<Double> eles){
        if(vec.isEmpty() || eles.isEmpty()) return false;
        for(Double ele : eles){
            if(!vec.contains(ele))
                return false;
        }
        return true;
    }

    // T7
    public void setListDouble(ArrayList<Double> vec, int position , Double v){
        if(position < 0 || position >= vec.size()) return;
        else{
            vec.set(position, v);
        }
    }

    public void setListDoubleWithList(ArrayList<Double> vec, ArrayList<Integer> position, ArrayList<Double> v){
        if(vec.size() < position.size()) return;
        else{
            for(int i=0; i<position.size(); ++i){
                vec.set(position.get(i), v.get(i));
            }
        }
    }

    // T8
    public void removeListDouble(ArrayList<Double> vec, int position){
        if(position < 0 || position >= vec.size()) return;
        vec.remove(position);
    }

    public void removeListDoubleWithList(ArrayList<Double> vec, List<Integer> positions){
        for(Integer position : positions){
            if(position >= 0 && position < vec.size())
                vec.remove(position);
        }
    }

    public void removeListDoubleRange(ArrayList<Double> vec, int start, int off){
        if(start < 0 || start >= vec.size()) return;
        if(off < 0 || off >= vec.size()) return;
        if(start >= off) return;
        vec.subList(start, off).clear();
    }
}
