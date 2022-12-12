package parallel.containers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class StackParallel {
    // template 1, initialize with list
    public ArrayDeque<Character> GetStackWithCharList(List<Character> list){
        ArrayDeque<Character> stack = new ArrayDeque<>(list);
        return stack;
    }

    public ArrayDeque<String> GetStackWithStringList(List<String> list){
        ArrayDeque<String> stack = new ArrayDeque<>(list);
        return stack;
    }

    public ArrayDeque<Integer> GetStackWithIntList(List<Integer> list){
        ArrayDeque<Integer> stack = new ArrayDeque<>(list);
        return stack;
    }

    public ArrayDeque<Double> GetStackWithDoubleList(List<Double> list){
        ArrayDeque<Double> stack = new ArrayDeque<>(list);
        return stack;
    }

    //Template 2, clear if not empty
    public void makeEmptyChar(ArrayDeque<Character> stack){
        if(!stack.isEmpty()){
            stack.clear();
        }
    }

    // Convert Char to String
    public void makeEmptyString(ArrayDeque<String> stack){
        if(!stack.isEmpty()){
            stack.clear();
        }
    }

    // Convert Char to Int
    public void makeEmptyInt(ArrayDeque<Integer> stack){
        if(!stack.isEmpty()){
            stack.clear();
        }
    }

    // Convert Char to Double
    public void makeEmptyDouble(ArrayDeque<Double> stack){
        if(!stack.isEmpty()){
            stack.clear();
        }
    }

    // Template 3, pop until greater than or less than element
    public void findGreaterChar(ArrayDeque<Character> stack, Character element){
        while(!stack.isEmpty()){
            Character c = stack.peek();
            if(c < element){
                stack.pop();
                return;
            }
        }
    }

    public void findLessChar(ArrayDeque<Character> stack, Character element){
        while(!stack.isEmpty()){
            Character c = stack.peek();
            if(c > element){
                stack.pop();
                return;
            }
        }
    }

    public void findEqualChar(ArrayDeque<Character> stack, Character element){
        while(!stack.isEmpty()){
            Character c = stack.peek();
            if(c == element){
                stack.pop();
                return;
            }
        }
    }

    // Convert Char to String
    public void findGreaterString(ArrayDeque<String> stack, String element){
        while(!stack.isEmpty()){
            String c = stack.peek();
            if(c.compareTo(element) < 0){
                stack.pop();
                return;
            }
        }
    }

    public void findLessString(ArrayDeque<String> stack, String element){
        while(!stack.isEmpty()){
            String c = stack.peek();
            if(c.compareTo(element) > 0){
                stack.pop();
                return;
            }
        }
    }

    public void findEqualString(ArrayDeque<String> stack, String element){
        while(!stack.isEmpty()){
            String c = stack.peek();
            if(c.compareTo(element) == 0){
                stack.pop();
                return;
            }
        }
    }

    // Convert Char to Int
    public void findGreaterInt(ArrayDeque<Integer> stack, Integer element){
        while(!stack.isEmpty()){
            Integer c = stack.peek();
            if(c < element){
                stack.pop();
                return;
            }
        }
    }

    public void findLessInt(ArrayDeque<Integer> stack, Integer element){
        while(!stack.isEmpty()){
            Integer c = stack.peek();
            if(c > element){
                stack.pop();
                return;
            }
        }
    }

    public void findEqualInt(ArrayDeque<Integer> stack, Integer element){
        while(!stack.isEmpty()){
            Integer c = stack.peek();
            if(c == element){
                stack.pop();
                return;
            }
        }
    }

    // Convert Char to Double
    public void findGreaterDouble(ArrayDeque<Double> stack, Double element){
        while(!stack.isEmpty()){
            Double c = stack.peek();
            if(c < element){
                stack.pop();
                return;
            }
        }
    }

    public void findLessDouble(ArrayDeque<Double> stack, Double element){
        while(!stack.isEmpty()){
            Double c = stack.peek();
            if(c > element){
                stack.pop();
                return;
            }
        }
    }

    public void findEqualDouble(ArrayDeque<Double> stack, Double element){
        while(!stack.isEmpty()){
            Double c = stack.peek();
            if(c == element){
                stack.pop();
                return;
            }
        }
    }
    
    // Template 4, push list
    public void pushListChar(ArrayDeque<Character> stack, List<Character> list){
        if(list.isEmpty()) return;
        for(Character c : list){
            stack.push(c);
        }
    }

    // Convert Char to String
    public void pushListString(ArrayDeque<String> stack, List<String> list){
        if(list.isEmpty()) return;
        for(String c : list){
            stack.push(c);
        }
    }

    // Convert Char to Int
    public void pushListInt(ArrayDeque<Integer> stack, List<Integer> list){
        if(list.isEmpty()) return;
        for(Integer c : list){
            stack.push(c);
        }
    }
    
    // Convert Char to Double
    public void pushListDouble(ArrayDeque<Double> stack, List<Double> list){
        if(list.isEmpty()) return;
        for(Double c : list){
            stack.push(c);
        }
    }
    
    //Template 5, pop and equal
    public Boolean popEqualChar(ArrayDeque<Character> stack1, ArrayDeque<Character> stack2){
        if(stack1.isEmpty()) return false;
        else stack1.pop();
        Boolean b = Arrays.equals(stack1.toArray(), stack2.toArray());
        return b;
    }

    // Convert String to String
    public Boolean popEqualString(ArrayDeque<String> stack1, ArrayDeque<String> stack2){
        if(stack1.isEmpty()) return false;
        else stack1.pop();
        Boolean b = Arrays.equals(stack1.toArray(), stack2.toArray());
        return b;
    }
    
    // Convert Char to Int
    public Boolean popEqualInt(ArrayDeque<Integer> stack1, ArrayDeque<Integer> stack2){
        if(stack1.isEmpty()) return false;
        else stack1.pop();
        Boolean b = Arrays.equals(stack1.toArray(), stack2.toArray());
        return b;
    }
    
    // Convert Char to Double
    public Boolean popEqualDouble(ArrayDeque<Double> stack1, ArrayDeque<Double> stack2){
        if(stack1.isEmpty()) return false;
        else stack1.pop();
        Boolean b = Arrays.equals(stack1.toArray(), stack2.toArray());
        return b;
    }
}
