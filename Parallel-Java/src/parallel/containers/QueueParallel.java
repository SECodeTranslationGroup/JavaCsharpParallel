package parallel.containers;

import java.util.ArrayDeque;
import java.util.Arrays;

public class QueueParallel {
    // T1
    public ArrayDeque<Character> getQueueChar(){
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for(int i=0; i<10; ++i){
            queue.add('c');
        }
        return queue;
    }

    // Convert Char to String
    public ArrayDeque<String> getQueueString(){
        ArrayDeque<String> queue = new ArrayDeque<>();
        for(int i=0; i<10; ++i){
            queue.add("aaa");
        }
        return queue;
    }
    
    // Convert Char to Int
    public ArrayDeque<Integer> getQueueInt(){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<10; ++i){
            queue.add(0);
        }
        return queue;
    }
    
    // Convert Char to Double
    public ArrayDeque<Double> getQueueDouble(){
        ArrayDeque<Double> queue = new ArrayDeque<>();
        for(int i=0; i<10; ++i){
            queue.add(0.0);
        }
        return queue;
    }

    // T2
    public ArrayDeque<Character> copyAddChar(ArrayDeque<Character> queue, Character c){
        ArrayDeque<Character> q = new ArrayDeque<>(queue);
        q.add(c);
        return q;
    }

    // Convert Char to String
    public ArrayDeque<String> copyAddString(ArrayDeque<String> queue, String c){
        ArrayDeque<String> q = new ArrayDeque<>(queue);
        q.add(c);
        return q;
    }
    
    // Convert Char to Int
    public ArrayDeque<Integer> copyAddInt(ArrayDeque<Integer> queue, Integer c){
        ArrayDeque<Integer> q = new ArrayDeque<>(queue);
        q.add(c);
        return q;
    }
    
    // Convert Char to Double
    public ArrayDeque<Double> copyAddDouble(ArrayDeque<Double> queue, Double c){
        ArrayDeque<Double> q = new ArrayDeque<>(queue);
        q.add(c);
        return q;
    }
    
    // T3
    public ArrayDeque<Character> toLengthChar(ArrayDeque<Character> queue, int length){
        int size = queue.size();
        while(size < length){
            size++;
            queue.add('a');
        }
        return queue;
    }

    // Convert Char to String
    public ArrayDeque<String> toLengthString(ArrayDeque<String> queue, int length){
        int size = queue.size();
        while(size < length){
            size++;
            queue.add("aa");
        }
        return queue;
    }

    // Convert Char to Int
    public ArrayDeque<Integer> toLengthInt(ArrayDeque<Integer> queue, int length){
        int size = queue.size();
        while(size < length){
            size++;
            queue.add(0);
        }
        return queue;
    }
    
    // Convert Char to Double
    public ArrayDeque<Double> toLengthDouble(ArrayDeque<Double> queue, int length){
        int size = queue.size();
        while(size < length){
            size++;
            queue.add(0.0);
        }
        return queue;
    }
    
    // T4
    public String addTwoChar(ArrayDeque<Character> queue){
        Character a = queue.remove();
        Character b = queue.peekFirst();
        queue.add(a);
        String str = "";
        str += a;
        str += b;
        return str;
    }

    // Convert Char to String
    public String addTwoString(ArrayDeque<String> queue){
        String a = queue.remove();
        String b = queue.peekFirst();
        queue.add(a);
        String str = "";
        str += a;
        str += b;
        return str;
    }
    
    // Convert Char to Int
    public Integer addTwoInt(ArrayDeque<Integer> queue){
        Integer a = queue.remove();
        Integer b = queue.peekFirst();
        queue.add(a);
        Integer str = 0;
        str += a;
        str += b;
        return str;
    }
    
    // Convert Char to Double
    public Double addTwoDouble(ArrayDeque<Double> queue){
        Double a = queue.remove();
        Double b = queue.peekFirst();
        queue.add(a);
        Double str = 0.0;
        str += a;
        str += b;
        return str;
    }
    
    // T5
    public String addAllChar(ArrayDeque<Character> queue){
        String str = "";
        while(!queue.isEmpty()){
            str += queue.remove();
        }
        return str;
    }
    
    // Convert Char to String
    public String addAllString(ArrayDeque<String> queue){
        String str = "";
        while(!queue.isEmpty()){
            str += queue.remove();
        }
        return str;
    }
    
    // Convert Char to Int
    public Integer addAllInt(ArrayDeque<Integer> queue){
        Integer str = 0;
        while(!queue.isEmpty()){
            str += queue.remove();
        }
        return str;
    }
    
    // Convert Char to Double
    public Double addAllDouble(ArrayDeque<Double> queue){
        Double str = 0.0;
        while(!queue.isEmpty()){
            str += queue.remove();
        }
        return str;
    }
    
    // T6
    public ArrayDeque<Character> concatQueueChar(ArrayDeque<Character> queue1, ArrayDeque<Character> queue2){
        ArrayDeque<Character> queue = new ArrayDeque<>(queue1);
        ArrayDeque<Character> tmp = new ArrayDeque<>(queue2);
        while(!tmp.isEmpty()){
            Character c = tmp.remove();
            queue.add(c);
        }
        tmp.clear();
        return queue;
    }
    
    // Convert Char to String
    public ArrayDeque<String> concatQueueString(ArrayDeque<String> queue1, ArrayDeque<String> queue2){
        ArrayDeque<String> queue = new ArrayDeque<>(queue1);
        ArrayDeque<String> tmp = new ArrayDeque<>(queue2);
        while(!tmp.isEmpty()){
            String c = tmp.remove();
            queue.add(c);
        }
        tmp.clear();
        return queue;
    }

    // Convert Char to Int
    public ArrayDeque<Integer> concatQueueInt(ArrayDeque<Integer> queue1, ArrayDeque<Integer> queue2){
        ArrayDeque<Integer> queue = new ArrayDeque<>(queue1);
        ArrayDeque<Integer> tmp = new ArrayDeque<>(queue2);
        while(!tmp.isEmpty()){
            Integer c = tmp.remove();
            queue.add(c);
        }
        tmp.clear();
        return queue;
    }
    
    // Convert Char to Double
    public ArrayDeque<Double> concatQueueDouble(ArrayDeque<Double> queue1, ArrayDeque<Double> queue2){
        ArrayDeque<Double> queue = new ArrayDeque<>(queue1);
        ArrayDeque<Double> tmp = new ArrayDeque<>(queue2);
        while(!tmp.isEmpty()){
            Double c = tmp.remove();
            queue.add(c);
        }
        tmp.clear();
        return queue;
    }

    // T7
    public void dismissQueueChar(ArrayDeque<Character> queue1, ArrayDeque<Character> queue2){
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            Character c1 = queue1.peekFirst();
            Character c2 = queue2.peekFirst();
            if(c1 != c2) return;
            else{
                queue1.remove();
                queue2.remove();
            }
        }
    }
    
    // Convert Char to String
    public void dismissQueueString(ArrayDeque<String> queue1, ArrayDeque<String> queue2){
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            String c1 = queue1.peekFirst();
            String c2 = queue2.peekFirst();
            if(c1.compareTo(c2) != 0) return;
            else{
                queue1.remove();
                queue2.remove();
            }
        }
    }
    
    // Convert Char to Int
    public void dismissQueueInt(ArrayDeque<Integer> queue1, ArrayDeque<Integer> queue2){
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            Integer c1 = queue1.peekFirst();
            Integer c2 = queue2.peekFirst();
            if(c1 != c2) return;
            else{
                queue1.remove();
                queue2.remove();
            }
        }
    }
    
    // Convert Char to Double
    public void dismissQueueDouble(ArrayDeque<Double> queue1, ArrayDeque<Double> queue2){
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            Double c1 = queue1.peekFirst();
            Double c2 = queue2.peekFirst();
            if(c1 != c2) return;
            else{
                queue1.remove();
                queue2.remove();
            }
        }
    }
    
    // T8
    public boolean headTailEqualChar(ArrayDeque<Character> queue){
        Character c1 = queue.peekFirst();
        Character c2 = queue.peekLast();
        if(c1 == c2) return true;
        else return false;
    }
    
    // Convert Char to String
    public boolean headTailEqualString(ArrayDeque<String> queue){
        String c1 = queue.peekFirst();
        String c2 = queue.peekLast();
        if(c1.compareTo(c2) == 0) return true;
        else return false;
    }
    
    // Convert Char to Int
    public boolean headTailEqualInt(ArrayDeque<Integer> queue){
        Integer c1 = queue.peekFirst();
        Integer c2 = queue.peekLast();
        if(c1 == c2) return true;
        else return false;
    }
    
    // Convert Char to Double
    public boolean headTailEqualDouble(ArrayDeque<Double> queue){
        Double c1 = queue.peekFirst();
        Double c2 = queue.peekLast();
        if(c1 == c2) return true;
        else return false;
    }
    
    // T9
    public boolean equalQueueChar(ArrayDeque<Character> queue1, ArrayDeque<Character> queue2){
        if(queue1.size() != queue2.size()) return false;
        else return Arrays.equals(queue1.toArray(), queue2.toArray());
    }

    // Convert Char to String
    public boolean equalQueueString(ArrayDeque<String> queue1, ArrayDeque<String> queue2){
        if(queue1.size() != queue2.size()) return false;
        else return Arrays.equals(queue1.toArray(), queue2.toArray());
    }
    
    // Convert Char to Int
    public boolean equalQueueInt(ArrayDeque<Integer> queue1, ArrayDeque<Integer> queue2){
        if(queue1.size() != queue2.size()) return false;
        else return Arrays.equals(queue1.toArray(), queue2.toArray());
    }
    
    // Convert Char to Double
    public boolean equalQueueDouble(ArrayDeque<Double> queue1, ArrayDeque<Double> queue2){
        if(queue1.size() != queue2.size()) return false;
        else return Arrays.equals(queue1.toArray(), queue2.toArray());
    }

    // NT1
    public void removeToEndChar(ArrayDeque<Character> queue1, Character ele){
        int size = queue1.size();
        for(int i = 0; i< size; ++i){
            if(ele != queue1.peekFirst()){
                Character t = queue1.remove();
                queue1.add(t);
            }
        }
    }

    public void removeUntilChar(ArrayDeque<Character> queue1, Character ele){
        while(!queue1.isEmpty() && queue1.peekFirst() != ele){
            queue1.remove();
        }
    }

    public void removeUntilLengthChar(ArrayDeque<Character> queue1, int length){
        if(queue1.size() <= length) return;
        while(queue1.size() > length){
            queue1.remove();
        }
    }
    
    // to String
    public void removeToEndString(ArrayDeque<String> queue1, String ele){
        int size = queue1.size();
        for(int i = 0; i< size; ++i){
            if(ele != queue1.peekFirst()){
                String t = queue1.remove();
                queue1.add(t);
            }
        }
    }

    public void removeUntilString(ArrayDeque<String> queue1, String ele){
        while(!queue1.isEmpty() && queue1.peekFirst() != ele){
            queue1.remove();
        }
    }

    public void removeUntilLengthString(ArrayDeque<String> queue1, int length){
        if(queue1.size() <= length) return;
        while(queue1.size() > length){
            queue1.remove();
        }
    }
    
    // to Int
    public void removeToEndInt(ArrayDeque<Integer> queue1, Integer ele){
        int size = queue1.size();
        for(int i = 0; i< size; ++i){
            if(ele != queue1.peekFirst()){
                Integer t = queue1.remove();
                queue1.add(t);
            }
        }
    }

    public void removeUntilInt(ArrayDeque<Integer> queue1, Integer ele){
        while(!queue1.isEmpty() && queue1.peekFirst() != ele){
            queue1.remove();
        }
    }

    public void removeUntilLengthInt(ArrayDeque<Integer> queue1, int length){
        if(queue1.size() <= length) return;
        while(queue1.size() > length){
            queue1.remove();
        }
    }
    
    // to Double
    public void removeToEndDouble(ArrayDeque<Double> queue1, Double ele){
        int size = queue1.size();
        for(int i = 0; i< size; ++i){
            if(ele != queue1.peekFirst()){
                Double t = queue1.remove();
                queue1.add(t);
            }
        }
    }

    public void removeUntilDouble(ArrayDeque<Double> queue1, Double ele){
        while(!queue1.isEmpty() && queue1.peekFirst() != ele){
            queue1.remove();
        }
    }

    public void removeUntilLengthDouble(ArrayDeque<Double> queue1, int length){
        if(queue1.size() <= length) return;
        while(queue1.size() > length){
            queue1.remove();
        }
    }

}
