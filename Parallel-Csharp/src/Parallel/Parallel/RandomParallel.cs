namespace Parallel_Csharp.Parallel.Parallel;

public class RandomParallel {
    public string GetRandString(int maxLength){
        Random eng = new Random();
        int length = eng.Next(1, maxLength);

        string str = "";
        for(int i = 0; i< length; ++i){
            int num = eng.Next(65, 65 + 26);
            str += (char)num;
        }
        return str;
    }

    public List<int> GetRandInt(int max, int length){
        Random eng = new Random();
        List<int> list = new List<int>();
        for(int i=0; i<length; ++i){
            list.Add(eng.Next(max));
        }
        return list;
    }

    public List<int> GetRandIntRange(int min, int max, int length){
        Random eng = new Random();
        List<int> list = new List<int>();
        for(int i=0; i<length; ++i){
            int num = min + eng.Next(min, max);
            list.Add(num);
        }
        return list;
    }

    public List<double> GetRandDouble(int max, int length){
        Random eng = new Random();
        List<double> list = new List<double>();
        for(int i=0; i<length; ++i){
            double num = eng.NextDouble() * max;
            list.Add(num);
        }
        return list;
    }

    public List<double> GetRandDoubleRange(int min, int max, int length){
        Random eng = new Random();
        List<double> list = new List<double>();
        for(int i=0; i<length; ++i){
            double num = min + eng.NextDouble() * (max-min);
            list.Add(num);
        }
        return list;
    }
}