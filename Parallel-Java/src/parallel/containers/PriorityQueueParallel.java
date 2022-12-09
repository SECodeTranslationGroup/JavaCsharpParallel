package parallel.containers;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueParallel {
    public PriorityQueue<String> createPQWithStringList(){
        PriorityQueue<String> heap = new PriorityQueue<>(String::compareTo);
        List<String> array = Arrays.asList("Tom", "Bill", "Bob", "Jelly", "Fisher", "Maker");
        heap.addAll(array);
        return heap;
    }

    public PriorityQueue<Integer> createPQWithIntList(){
        PriorityQueue<Integer> heap = new PriorityQueue<>(Integer::compareTo);
        List<Integer> array = Arrays.asList(10, 9, 20, 30, 40, 60);
        heap.addAll(array);
        return heap;
    }

    public PriorityQueue<Double> createPQWithDoubleList(){
        PriorityQueue<Double> heap = new PriorityQueue<>(Double::compareTo);
        List<Double> array = Arrays.asList(10.0, 5.9, 7.8, 10.5, 1.2, 3.4);
        heap.addAll(array);
        return heap;
    }

    public PriorityQueue<String> addCopyPQString(PriorityQueue<String> heap){
        String pivot = "middle";
        PriorityQueue<String> h = new PriorityQueue<>(heap);
        h.add(pivot);
        return h;
    }

    public PriorityQueue<Integer> addCopyPQInt(PriorityQueue<Integer> heap){
        Integer pivot = 100;
        PriorityQueue<Integer> h = new PriorityQueue<>(heap);
        h.add(pivot);
        return h;
    }

    public PriorityQueue<Double> addCopyPQDouble(PriorityQueue<Double> heap){
        Double pivot = 100.0;
        PriorityQueue<Double> h = new PriorityQueue<>(heap);
        h.add(pivot);
        return h;
    }

    public String removePQTopString(PriorityQueue<String> heap){
        String top = "";
        if(!heap.isEmpty()){
            top = heap.peek();
            heap.remove();
        }
        return top;
    }

    public Integer removePQTopInt(PriorityQueue<Integer> heap){
        Integer top = -1;
        if(!heap.isEmpty()){
            top = heap.peek();
            heap.remove();
        }
        return top;
    }

    public Double removePQTopDouble(PriorityQueue<Double> heap){
        Double top = -1.0;
        if(!heap.isEmpty()){
            top = heap.peek();
            heap.remove();
        }
        return top;
    }
    
    public int addStringWithSize(PriorityQueue<String> heap, int size, String a){
        if(heap.size() < size){
            heap.add(a);
        }
        return heap.size();
    }

    public int addIntWithSize(PriorityQueue<Integer> heap, int size, Integer a){
        if(heap.size() < size){
            heap.add(a);
        }
        return heap.size();
    }

    public int addDoubleWithSize(PriorityQueue<Double> heap, int size, Double a){
        if(heap.size() < size){
            heap.add(a);
        }
        return heap.size();
    }

}
