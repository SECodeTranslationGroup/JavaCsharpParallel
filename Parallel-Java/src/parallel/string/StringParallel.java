package parallel.string;

import java.util.ArrayList;
import java.util.List;

public class StringParallel {
    public String getString(String str, Character c, int size, int start, int count){
        String s = String.valueOf(c).repeat(size);
        String s1 = new String(str.toCharArray(), start, count);
        return s + s1;
    }

    public int findCharIndex(String s, Character c){
        int index = s.indexOf(c);
        int lastIndex = s.lastIndexOf(c);
        return index + lastIndex;
    }

    public int findStrIndex(String s, String str){
        int index = s.indexOf(str);
        int lastIndex = s.lastIndexOf(str);
        return index + lastIndex;
    }

    public List<Integer> toIntList(List<String> strs){
        List<Integer> list = new ArrayList<>();
        for(String s : strs){
            list.add(Integer.parseInt(s));
        }
        return list;
    }

    public List<Float> toFloatList(List<String> strs){
        List<Float> list = new ArrayList<>();
        for(String s : strs){
            list.add(Float.parseFloat(s));
        }
        return list;
    }

    public List<Double> toDoubleList(List<String> strs){
        List<Double> list = new ArrayList<>();
        for(String s : strs){
            list.add(Double.parseDouble(s));
        }
        return list;
    }

    public boolean startsEndsString(String str, String start, String end){
        boolean b1 = str.startsWith(start);
        boolean b2 = str.endsWith(end);
        return b1 && b2;
    }

    public String subString(String str, int index, int length){
        String s = str.substring(index, index + length);
        return s;
    }

    public boolean equalStartEnd(String str){
        Character start = str.charAt(0);
        Character end = str.charAt(str.length() - 1);
        return start == end;
    }

    public boolean containsTwoChar(String str, Character a, Character b){
        boolean b1 = str.contains(String.valueOf(a));
        boolean b2 = str.contains(String.valueOf(b));
        return b1 && b2;
    }

    public boolean containsTwoStrs(String str, String a, String b){
        boolean b1 = str.contains(a);
        boolean b2 = str.contains(b);
        return b1 && b2;
    }

    public String stringBuilderLength(Character c, int length){
        StringBuilder buf = new StringBuilder();
        while(length != 0){
            --length;
            buf.append(c);
        }
        return buf.toString();
    }

    public String trimStringLast(String str, int length){
        StringBuilder buf = new StringBuilder(str);
        buf.delete(buf.length() - length, buf.length());
        return buf.toString();
    }

    public String reString(String str, int position, Character c){
        StringBuilder buf = new StringBuilder(str);
        buf.replace(position, position+1, String.valueOf(c));
        return buf.toString();
    }
}
