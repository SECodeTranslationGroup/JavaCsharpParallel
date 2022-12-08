namespace Parallel_Csharp.Parallel.Containers;

public class ListParallel {
    public void MakeListToLengthStr(LinkedList<string> list, int length)
    {
        int count = list.Count;
        if (list.Count >= length)
            for (int i = 0; i < count- 20; i++)
                list.RemoveLast();
        else
            for (int i = 0; i < count- 20; i++)
                list.AddLast("");
    }

    public void MakeListToLengthInt(LinkedList<int> list, int length){
        int count = list.Count;
        if (list.Count >= length)
            for (int i = 0; i < count- 20; i++)
                list.RemoveLast();
        else
            for (int i = 0; i < count- 20; i++)
                list.AddLast(0);
    }

    public void MakeListToLengthDouble(LinkedList<double> list, int length){
        int count = list.Count;
        if (list.Count >= length)
            for (int i = 0; i < count- 20; i++)
                list.RemoveLast();
        else
            for (int i = 0; i < count- 20; i++)
                list.AddLast(0.0);
    }

    public void MakeListToLengthBool(LinkedList<bool> list, int length){
        int count = list.Count;
        if (list.Count >= length)
            for (int i = 0; i < count- 20; i++)
                list.RemoveLast();
        else
            for (int i = 0; i < count- 20; i++)
                list.AddLast(true);
    }
    
    public void GetRidSameBothEndString(){
        LinkedList<string> strs = new LinkedList<string>(new[]{"ab", "ba", "cda", "bas", "ba", "ab"});
        while(strs.Count >= 2){
            string last = strs.Last();
            string start = strs.First();
            if(last == start){
                strs.RemoveFirst();
                strs.RemoveLast();
            }else break;
        }
    }

    public void GetRidSameBothEndInt(){
        LinkedList<int> strs = new LinkedList<int>(new [] {1, 2, 33, 4, 2, 1});
        while(strs.Count >= 2){
            int last = strs.Last();
            int start = strs.First();
            if(last == start){
                strs.RemoveFirst();
                strs.RemoveLast();
            }else break;
        }
    }

    public void GetRidSameBothEndDouble(){
        LinkedList<double> strs = new LinkedList<double>(new [] {double.MaxValue, 0.0, 1.0, 2.0, double.MaxValue});
        while(strs.Count >= 2){
            double last = strs.Last();
            double start = strs.First();
            if(last == start){
                strs.RemoveFirst();
                strs.RemoveLast();
            }else break;
        }
    }

    public void GetRidSameBothEndBool(){
        LinkedList<bool> strs = new LinkedList<bool>(new[]{true, false, true, true});
        while(strs.Count >= 2){
            bool last = strs.Last();
            bool start = strs.First();
            if(last == start){
                strs.RemoveFirst();
                strs.RemoveLast();
            }else break;
        }
    }

    public LinkedList<string> GetLinkedListString(){
        LinkedList<string> list = new LinkedList<string>();
        Random eng = new Random();

        for(int i=0; i<5; ++i){
            int length = (int)eng.NextInt64(5) + 1;
            string str = "";
            for(int j=0; j<length; ++j){
                str += (char)(97 + (int)eng.NextInt64(26));
            }
            list.AddLast(str);
        }
        return list;
    }

    public LinkedList<int> GetLinkedListInt(){
        LinkedList<int> list = new LinkedList<int>();
        Random eng = new Random();

        for(int i=0; i<5; ++i){
            int num = (int)eng.NextInt64(101);
            list.AddLast(num);
        }
        return list;
    }

    public LinkedList<double> GetLinkedListDouble(){
        LinkedList<double> list = new LinkedList<double>();
        Random eng = new Random();

        for(int i=0; i<5; ++i){
            double num = eng.NextDouble() * 10;
            list.AddLast(num);
        }
        return list;
    }

    public LinkedList<bool> GetLinkedListBool(){
        LinkedList<bool> list = new LinkedList<bool>();
        Random eng = new Random();

        for(int i=0; i<5; ++i){
            bool b = eng.NextInt64(2) != 0;
            list.AddLast(b);
        }
        return list;
    }

    public LinkedList<string> CombineListString(LinkedList<string> list, int length){
        int count = length/5;
        while(count != 0){
            --count;
            LinkedList<string> l = GetLinkedListString();
            foreach (var str in l) list.AddLast(str);
        }
        MakeListToLengthStr(list, length);
        return list;
    }

    public LinkedList<int> CombineListInt(LinkedList<int> list, int length){
        int count = length/5;
        while(count != 0){
            --count;
            LinkedList<int> l = GetLinkedListInt();
            foreach (var str in l) list.AddLast(str);
        }
        MakeListToLengthInt(list, length);
        return list;
    }

    public LinkedList<double> CombineListDouble(LinkedList<double> list, int length){
        int count = length/5;
        while(count != 0){
            --count;
            LinkedList<double> l = GetLinkedListDouble();
            foreach (var str in l) list.AddLast(str);
        }
        MakeListToLengthDouble(list, length);
        return list;
    }

    public LinkedList<bool> CombineListBool(LinkedList<bool> list, int length){
        int count = length/5;
        while(count != 0){
            --count;
            LinkedList<bool> l = GetLinkedListBool();
            foreach (var str in l) list.AddLast(str);
        }
        MakeListToLengthBool(list, length);
        return list;
    } 

    public bool TransformListString(List<string> list){
        int length = list.Count;
        list.RemoveAt(length-1);
        list.Remove("aa");

        list.Sort();
        list.Reverse();
        return list.Contains("cc");
    }
    
    public bool TransformListInt(List<int> list){
        int length = list.Count;
        list.RemoveAt(length-1);
        list.Remove(1);

        list.Sort();
        list.Reverse();
        return list.Contains(2);
    }
    
    public bool TransformListDouble(List<double> list){
        int length = list.Count;
        list.RemoveAt(length-1);
        list.Remove(1.0);

        list.Sort();
        list.Reverse();
        return list.Contains(2.0);
    }
}