package parallel.containers;

import java.util.*;

public class ListP {
    public void makeListToLengthStr(LinkedList<String> list, int length){
        if (list.size() >= length)
            list.subList(length, list.size()).clear();
        else
            list.addAll(Collections.nCopies(length - list.size(), ""));
    }

    public void makeListToLengthInt(LinkedList<Integer> list, int length){
        if (list.size() >= length)
            list.subList(length, list.size()).clear();
        else
            list.addAll(Collections.nCopies(length - list.size(), 0));
    }

    public void makeListToLengthDouble(LinkedList<Double> list, int length){
        if (list.size() >= length)
            list.subList(length, list.size()).clear();
        else
            list.addAll(Collections.nCopies(length - list.size(), 0.0));
    }

    public void makeListToLengthBoolean(LinkedList<Boolean> list, int length){
        if (list.size() >= length)
            list.subList(length, list.size()).clear();
        else
            list.addAll(Collections.nCopies(length - list.size(), true));
    }
    
    public void getRidSameBothEndString(){
        LinkedList<String> strs = new LinkedList<>(Arrays.asList("ab", "ba", "cda", "bas", "ba", "ab"));
        while(strs.size() >= 2){
            String last = strs.getLast();
            String start = strs.getFirst();
            if(last == start){
                strs.removeFirst();
                strs.removeLast();
            }else break;
        }
    }

    public void getRidSameBothEndInt(){
        LinkedList<Integer> strs = new LinkedList<>(Arrays.asList(1, 2, 33, 4, 2, 1));
        while(strs.size() >= 2){
            Integer last = strs.getLast();
            Integer start = strs.getFirst();
            if(last == start){
                strs.removeFirst();
                strs.removeLast();
            }else break;
        }
    }

    public void getRidSameBothEndDouble(){
        LinkedList<Double> strs = new LinkedList<>(Arrays.asList(Double.MAX_VALUE, 0.0, 1.0, 2.0, Double.MAX_VALUE));
        while(strs.size() >= 2){
            Double last = strs.getLast();
            Double start = strs.getFirst();
            if(last == start){
                strs.removeFirst();
                strs.removeLast();
            }else break;
        }
    }

    public void getRidSameBothEndBoolean(){
        LinkedList<Boolean> strs = new LinkedList<>(Arrays.asList(true, false, true, true));
        while(strs.size() >= 2){
            Boolean last = strs.getLast();
            Boolean start = strs.getFirst();
            if(last == start){
                strs.removeFirst();
                strs.removeLast();
            }else break;
        }
    }

    public LinkedList<String> getLinkedListString(){
        LinkedList<String> list = new LinkedList<>();
        Random eng = new Random();

        for(int i=0; i<5; ++i){
            int length = eng.nextInt(5) + 1;
            String str = "";
            for(int j=0; j<length; ++j){
                str += (char)(97 + eng.nextInt(26));
            }
            list.add(str);
        }
        return list;
    }

    public LinkedList<Integer> getLinkedListInt(){
        LinkedList<Integer> list = new LinkedList<>();
        Random eng = new Random();

        for(int i=0; i<5; ++i){
            int num = eng.nextInt(101);
            list.add(num);
        }
        return list;
    }

    public LinkedList<Double> getLinkedListDouble(){
        LinkedList<Double> list = new LinkedList<>();
        Random eng = new Random();

        for(int i=0; i<5; ++i){
            double num = eng.nextDouble(10.0);
            list.add(num);
        }
        return list;
    }

    public LinkedList<Boolean> getLinkedListBoolean(){
        LinkedList<Boolean> list = new LinkedList<>();
        Random eng = new Random();

        for(int i=0; i<5; ++i){
            Boolean b = eng.nextInt(2) != 0;
            list.add(b);
        }
        return list;
    }

    public LinkedList<String> combineListString(LinkedList<String> list, int length){
        int count = length/5;
        while(count != 0){
            --count;
            LinkedList<String> l = getLinkedListString();
            list.addAll(l);
        }
        makeListToLengthStr(list, length);
        return list;
    }

    public LinkedList<Integer> combineListInteger(LinkedList<Integer> list, int length){
        int count = length/5;
        while(count != 0){
            --count;
            LinkedList<Integer> l = getLinkedListInt();
            list.addAll(l);
        }
        makeListToLengthInt(list, length);
        return list;
    }

    public LinkedList<Double> combineListDouble(LinkedList<Double> list, int length){
        int count = length/5;
        while(count != 0){
            --count;
            LinkedList<Double> l = getLinkedListDouble();
            list.addAll(l);
        }
        makeListToLengthDouble(list, length);
        return list;
    }

    public LinkedList<Boolean> combineListBoolean(LinkedList<Boolean> list, int length){
        int count = length/5;
        while(count != 0){
            --count;
            LinkedList<Boolean> l = getLinkedListBoolean();
            list.addAll(l);
        }
        makeListToLengthBoolean(list, length);
        return list;
    }

    public boolean transformListString(List<String> list){
        int length = list.size();
        list.remove(length-1);
        list.remove("aa");

        list.sort(null);
        Collections.reverse(list);
        return list.contains("cc");
    }

    public boolean transformListInt(List<Integer> list){
        int length = list.size();
        list.remove(length-1);
        Integer a = 1;
        list.remove(a);

        list.sort(null);
        Collections.reverse(list);
        return list.contains(2);
    }

    public boolean transformListDouble(List<Double> list){
        int length = list.size();
        list.remove(length-1);
        list.remove(1.0);

        list.sort(null);
        Collections.reverse(list);
        return list.contains(2.0);
    }

}
