package parallel.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomParallel {
    public String getRandString(int maxLength){
        Random eng = new Random();
        int length = 1 + eng.nextInt(maxLength);

        String str = "";
        for(int i = 0; i< length; ++i){
            int num = 65 + eng.nextInt(26);
            str += (char)num;
        }
        return str;
    }

    public List<Integer> getRandInt(int max, int length){
        Random eng = new Random();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<length; ++i){
            list.add(eng.nextInt(max));
        }
        return list;
    }

    public List<Integer> getRandIntRange(int min, int max, int length){
        Random eng = new Random();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<length; ++i){
            int num = min + eng.nextInt(max - min);
            list.add(num);
        }
        return list;
    }

    public List<Double> getRandDouble(int max, int length){
        Random eng = new Random();
        List<Double> list = new ArrayList<>();
        for(int i=0; i<length; ++i){
            Double num = eng.nextDouble(max);
            list.add(num);
        }
        return list;
    }

    public List<Double> getRandDoubleRange(int min, int max, int length){
        Random eng = new Random();
        List<Double> list = new ArrayList<>();
        for(int i=0; i<length; ++i){
            Double num = min + eng.nextDouble(max - min);
            list.add(num);
        }
        return list;
    }
}
