namespace Parallel_Csharp.Parallel.Containers;

public class UnorderedSetParallel {
    // T1
    public HashSet<char> GetSetChar(){
        HashSet<char> set = new HashSet<char>();
        for(int i=41; i<51; ++i){
            set.Add((char)i);
        }
        return set;
    }

    // T2
    public HashSet<char> AddListChar(HashSet<char> set, List<char> list){
        foreach(char ele in list){
            if(!set.Contains(ele)){
                set.Add(ele);
            }
        }
        return set;
    }

    // T3
    public HashSet<char> RemoveListChar(HashSet<char> set, List<char> list){
        foreach(char ele in list){
            if(set.Contains(ele)){
                set.Remove(ele);
            }
        }
        return set;
    }

    public HashSet<char> RemoveReverseListChar(HashSet<char> set, List<char> list){
        foreach(char ele in list){
            if(!set.Contains(ele)){
                set.Remove(ele);
            }
        }
        return set;
    }

    // T4
    public HashSet<char> AddTwoListChar(HashSet<char> set, List<char> list1, List<char> list2){
        HashSet<char> result = new HashSet<char>(set);
        result.UnionWith(list1);
        result.UnionWith(list2);
        return result;
    }

    // T5
    public void CombineTwoSetChar(HashSet<char> set1, HashSet<char> set2){
        foreach(char ele in set2){
            set1.Add(ele);
        }
    }

    // T6
    public void IntersectTwoSetChar(HashSet<char> set1, HashSet<char> set2){
        foreach(char ele in set2){
            if(!set1.Contains(ele)){
                set1.Remove(ele);
            }
        }
    }
    
    // todo Convert Char to String
    // T1
    public HashSet<string> GetSetString(){
        HashSet<string> set = new HashSet<string>();
        for(int i=41; i<51; ++i){
            set.Add(Convert.ToString(i));
        }
        return set;
    }

    // T2
    public HashSet<string> AddListString(HashSet<string> set, List<string> list){
        foreach(string ele in list){
            if(!set.Contains(ele)){
                set.Add(ele);
            }
        }
        return set;
    }

    // T3
    public HashSet<string> RemoveListString(HashSet<string> set, List<string> list){
        foreach(string ele in list){
            if(set.Contains(ele)){
                set.Remove(ele);
            }
        }
        return set;
    }

    public HashSet<string> RemoveReverseListString(HashSet<string> set, List<string> list){
        foreach(string ele in list){
            if(!set.Contains(ele)){
                set.Remove(ele);
            }
        }
        return set;
    }

    // T4
    public HashSet<string> AddTwoListString(HashSet<string> set, List<string> list1, List<string> list2){
        HashSet<string> result = new HashSet<string>(set);
        result.UnionWith(list1);
        result.UnionWith(list2);
        return result;
    }

    // T5
    public void CombineTwoSetString(HashSet<string> set1, HashSet<string> set2){
        foreach(string ele in set2){
            set1.Add(ele);
        }
    }

    // T6
    public void IntersectTwoSetString(HashSet<string> set1, HashSet<string> set2){
        foreach(string ele in set2){
            if(!set1.Contains(ele)){
                set1.Remove(ele);
            }
        }
    }
    
    // Convert Char to Int
    // T1
    public HashSet<int> GetSetInt(){
        HashSet<int> set = new HashSet<int>();
        for(int i=41; i<51; ++i){
            set.Add(i);
        }
        return set;
    }

    // T2
    public HashSet<int> AddListInt(HashSet<int> set, List<int> list){
        foreach(int ele in list){
            if(!set.Contains(ele)){
                set.Add(ele);
            }
        }
        return set;
    }

    // T3
    public HashSet<int> RemoveListInt(HashSet<int> set, List<int> list){
        foreach(int ele in list){
            if(set.Contains(ele)){
                set.Remove(ele);
            }
        }
        return set;
    }

    public HashSet<int> RemoveReverseListInt(HashSet<int> set, List<int> list){
        foreach(int ele in list){
            if(!set.Contains(ele)){
                set.Remove(ele);
            }
        }
        return set;
    }

    // T4
    public HashSet<int> AddTwoListInt(HashSet<int> set, List<int> list1, List<int> list2){
        HashSet<int> result = new HashSet<int>(set);
        result.UnionWith(list1);
        result.UnionWith(list2);
        return result;
    }

    // T5
    public void CombineTwoSetInt(HashSet<int> set1, HashSet<int> set2){
        foreach(int ele in set2){
            set1.Add(ele);
        }
    }

    // T6
    public void IntersectTwoSetInt(HashSet<int> set1, HashSet<int> set2){
        foreach(int ele in set2){
            if(!set1.Contains(ele)){
                set1.Remove(ele);
            }
        }
    }
    
    // Convert Char to Double
    // T1
    public HashSet<double> GetSetDouble(){
        HashSet<double> set = new HashSet<double>();
        for(int i=41; i<51; ++i){
            set.Add(i + 0.1);
        }
        return set;
    }

    // T2
    public HashSet<double> AddListDouble(HashSet<double> set, List<double> list){
        foreach(double ele in list){
            if(!set.Contains(ele)){
                set.Add(ele);
            }
        }
        return set;
    }

    // T3
    public HashSet<double> RemoveListDouble(HashSet<double> set, List<double> list){
        foreach(double ele in list){
            if(set.Contains(ele)){
                set.Remove(ele);
            }
        }
        return set;
    }

    public HashSet<double> RemoveReverseListDouble(HashSet<double> set, List<double> list){
        foreach(double ele in list){
            if(!set.Contains(ele)){
                set.Remove(ele);
            }
        }
        return set;
    }

    // T4
    public HashSet<double> AddTwoListDouble(HashSet<double> set, List<double> list1, List<double> list2){
        HashSet<double> result = new HashSet<double>(set);
        result.UnionWith(list1);
        result.UnionWith(list2);
        return result;
    }

    // T5
    public void CombineTwoSetDouble(HashSet<double> set1, HashSet<double> set2){
        foreach(double ele in set2){
            set1.Add(ele);
        }
    }

    // T6
    public void IntersectTwoSetDouble(HashSet<double> set1, HashSet<double> set2){
        foreach(double ele in set2){
            if(!set1.Contains(ele)){
                set1.Remove(ele);
            }
        }
    }
    
    // NT1  
    public HashSet<char> GetFoodSetChar(){
        HashSet<char> set = new HashSet<char>{'a', 'b', 'c'};
        set.Add('d');
        return set;
    }

    public bool ContainsTwoFoodSetChar(HashSet<char> set, char ele1, char ele2){
        bool b1 = set.Contains(ele1);
        bool b2 = set.Contains(ele2);
        return b1 && b2;
    }

    public void ClearSmallSetChar(HashSet<char> set, int length){
        if(set.Count == 0) return;
        if(set.Count <= length)
            set.Clear();
    }
    
    // to String
    public HashSet<string> GetFoodSetString(){
        HashSet<string> set = new HashSet<string>{"aa", "bb", "cc"};
        set.Add("dd");
        return set;
    }

    public bool ContainsTwoFoodSetString(HashSet<string> set, string ele1, string ele2){
        bool b1 = set.Contains(ele1);
        bool b2 = set.Contains(ele2);
        return b1 && b2;
    }

    public void ClearSmallSetString(HashSet<string> set, int length){
        if(set.Count == 0) return;
        if(set.Count <= length)
            set.Clear();
    }
    
    // to int
    public HashSet<int> GetFoodSetInt(){
        HashSet<int> set = new HashSet<int>{1, 2, 3};
        set.Add(4);
        return set;
    }

    public bool ContainsTwoFoodSetInt(HashSet<int> set, int ele1, int ele2){
        bool b1 = set.Contains(ele1);
        bool b2 = set.Contains(ele2);
        return b1 && b2;
    }

    public void ClearSmallSetInt(HashSet<int> set, int length){
        if(set.Count == 0) return;
        if(set.Count <= length)
            set.Clear();
    }
    
    // to double
    public HashSet<double> GetFoodSetDouble(){
        HashSet<double> set = new HashSet<double>{1.0, 2.0, 3.0};
        set.Add(4.0);
        return set;
    }

    public bool ContainsTwoFoodSetDouble(HashSet<double> set, double ele1, double ele2){
        bool b1 = set.Contains(ele1);
        bool b2 = set.Contains(ele2);
        return b1 && b2;
    }

    public void ClearSmallSetDouble(HashSet<double> set, int length){
        if(set.Count == 0) return;
        if(set.Count <= length)
            set.Clear();
    }
}