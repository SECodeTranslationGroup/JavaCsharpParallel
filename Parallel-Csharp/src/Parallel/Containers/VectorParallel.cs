namespace Parallel_Csharp.Parallel.Containers;

public class VectorParallel {
    // T1
    public List<char> GetListChar(){
        List<char> vec1 = new List<char> { 'a','b','c'};
        vec1.Add('d');
        return vec1;
    }

    public List<char> GetNCopyChar(char ele, int size){
        List<char> vec = new List<char>(Enumerable.Repeat(ele, size));
        return vec;
    }

    // T2
    public void ReSizeListChar(List<char> vec, int size, char ele){
        if (vec.Count >= size) {
            vec.RemoveRange(size, vec.Count);
        } else {
            vec.AddRange(Enumerable.Repeat(ele, size - vec.Count));
        }
    }

    // T3
    public void ClearSizeListChar(List<char> vec, int size){
        if(vec.Count == 0) return;
        if(vec.Count <= size) {
            vec.Clear();
        }
    }

    // T4
    public int InsertListChar(List<char> vec, int index, char ele){
        if(index > vec.Count || index < 0) return -1;
        vec.Insert(index, ele);
        return vec.Count;
    }

    // T5
    public int InsertListCharWithList(List<char> vec, int index, List<char> eles){
        if(index > vec.Count || index < 0) return -1;
        vec.InsertRange(index, eles);
        return vec.Count;
    }

    // T6
    public bool ContainsAnyChar(List<char> vec, List<char> eles){
        if(vec.Count == 0 || eles.Count == 0) return false;
        foreach(char ele in eles){
            if(vec.Contains(ele))
                return true;
        }
        return false;
    }

    public bool ContainsAllChar(List<char> vec, List<char> eles){
        if(vec.Count == 0 || eles.Count == 0) return false;
        foreach(char ele in eles){
            if(!vec.Contains(ele))
                return false;
        }
        return true;
    }

    // T7
    public void SetListChar(List<char> vec, int position , char v){
        if(position < 0 || position >= vec.Count) return;
        else{
            vec[position] = v;
        }
    }

    public void SetListCharWithList(List<char> vec, List<int> position, List<char> v){
        if(vec.Count < position.Count) return;
        else{
            for(int i=0; i<position.Count; ++i){
                vec[position[i]] = v[i];
            }
        }
    }

    // T8
    public void RemoveListChar(List<char> vec, int position){
        if(position < 0 || position >= vec.Count) return;
        vec.RemoveAt(position);
    }

    public void RemoveList(List<char> vec, List<int> positions){
        foreach(int position in positions){
            if(position >= 0 && position < vec.Count)
                vec.RemoveAt(position);
        }
    }

    public void RemoveListCharRange(List<char> vec, int start, int off){
        if(start < 0 || start >= vec.Count) return;
        if(off < 0 || off >= vec.Count) return;
        if(start >= off) return;
        vec.RemoveRange(start, off);
    }
    
    // Convert Char to String
    // T1
    public List<string> GetListString(){
        List<string> vec1 = new List<string> { "aa","bb","cc"};
        vec1.Add("dd");
        return vec1;
    }

    public List<string> GetNCopyString(string ele, int size){
        List<string> vec = new List<string>(Enumerable.Repeat(ele, size));
        return vec;
    }

    // T2
    public void ReSizeListString(List<string> vec, int size, string ele){
        if (vec.Count >= size) {
            vec.RemoveRange(size, vec.Count);
        } else {
            vec.AddRange(Enumerable.Repeat(ele, size - vec.Count));
        }
    }

    // T3
    public void ClearSizeListString(List<string> vec, int size){
        if(vec.Count == 0) return;
        if(vec.Count <= size) {
            vec.Clear();
        }
    }

    // T4
    public int InsertListString(List<string> vec, int index, string ele){
        if(index > vec.Count || index < 0) return -1;
        vec.Insert(index, ele);
        return vec.Count;
    }

    // T5
    public int InsertListStringWithList(List<string> vec, int index, List<string> eles){
        if(index > vec.Count || index < 0) return -1;
        vec.InsertRange(index, eles);
        return vec.Count;
    }

    // T6
    public bool ContainsAnyString(List<string> vec, List<string> eles){
        if(vec.Count == 0 || eles.Count == 0) return false;
        foreach(string ele in eles){
            if(vec.Contains(ele))
                return true;
        }
        return false;
    }

    public bool ContainsAllString(List<string> vec, List<string> eles){
        if(vec.Count == 0 || eles.Count == 0) return false;
        foreach(string ele in eles){
            if(!vec.Contains(ele))
                return false;
        }
        return true;
    }

    // T7
    public void SetListString(List<string> vec, int position , string v){
        if(position < 0 || position >= vec.Count) return;
        else{
            vec[position] = v;
        }
    }

    public void SetListStringWithList(List<string> vec, List<int> position, List<string> v){
        if(vec.Count < position.Count) return;
        else{
            for(int i=0; i<position.Count; ++i){
                vec[position[i]] = v[i];
            }
        }
    }

    // T8
    public void RemoveListString(List<string> vec, int position){
        if(position < 0 || position >= vec.Count) return;
        vec.RemoveAt(position);
    }

    public void RemoveList(List<string> vec, List<int> positions){
        foreach(int position in positions){
            if(position >= 0 && position < vec.Count)
                vec.RemoveAt(position);
        }
    }

    public void RemoveListStringRange(List<string> vec, int start, int off){
        if(start < 0 || start >= vec.Count) return;
        if(off < 0 || off >= vec.Count) return;
        if(start >= off) return;
        vec.RemoveRange(start, off);
    }
    
    // Convert Char to Int
    // T1
    public List<int> GetListInt(){
        List<int> vec1 = new List<int> { 1, 2, 3};
        vec1.Add(4);
        return vec1;
    }

    public List<int> GetNCopyInt(int ele, int size){
        List<int> vec = new List<int>(Enumerable.Repeat(ele, size));
        return vec;
    }

    // T2
    public void ReSizeListInt(List<int> vec, int size, int ele){
        if (vec.Count >= size) {
            vec.RemoveRange(size, vec.Count);
        } else {
            vec.AddRange(Enumerable.Repeat(ele, size - vec.Count));
        }
    }

    // T3
    public void ClearSizeListInt(List<int> vec, int size){
        if(vec.Count == 0) return;
        if(vec.Count <= size) {
            vec.Clear();
        }
    }

    // T4
    public int InsertListInt(List<int> vec, int index, int ele){
        if(index > vec.Count || index < 0) return -1;
        vec.Insert(index, ele);
        return vec.Count;
    }

    // T5
    public int InsertListIntWithList(List<int> vec, int index, List<int> eles){
        if(index > vec.Count || index < 0) return -1;
        vec.InsertRange(index, eles);
        return vec.Count;
    }

    // T6
    public bool ContainsAnyInt(List<int> vec, List<int> eles){
        if(vec.Count == 0 || eles.Count == 0) return false;
        foreach(int ele in eles){
            if(vec.Contains(ele))
                return true;
        }
        return false;
    }

    public bool ContainsAllInt(List<int> vec, List<int> eles){
        if(vec.Count == 0 || eles.Count == 0) return false;
        foreach(int ele in eles){
            if(!vec.Contains(ele))
                return false;
        }
        return true;
    }

    // T7
    public void SetListInt(List<int> vec, int position , int v){
        if(position < 0 || position >= vec.Count) return;
        else{
            vec[position] = v;
        }
    }

    public void SetListIntWithList(List<int> vec, List<int> position, List<int> v){
        if(vec.Count < position.Count) return;
        else{
            for(int i=0; i<position.Count; ++i){
                vec[position[i]] = v[i];
            }
        }
    }

    // T8
    public void RemoveListInt(List<int> vec, int position){
        if(position < 0 || position >= vec.Count) return;
        vec.RemoveAt(position);
    }

    public void RemoveList(List<int> vec, List<int> positions){
        foreach(int position in positions){
            if(position >= 0 && position < vec.Count)
                vec.RemoveAt(position);
        }
    }

    public void RemoveListIntRange(List<int> vec, int start, int off){
        if(start < 0 || start >= vec.Count) return;
        if(off < 0 || off >= vec.Count) return;
        if(start >= off) return;
        vec.RemoveRange(start, off);
    }
    
    // Convert Char to Double
    // T1
    public List<double> GetListDouble(){
        List<double> vec1 = new List<double> { 1.0, 2.0, 3.0};
        vec1.Add(4.0);
        return vec1;
    }

    public List<double> GetNCopyDouble(double ele, int size){
        List<double> vec = new List<double>(Enumerable.Repeat(ele, size));
        return vec;
    }

    // T2
    public void ReSizeListDouble(List<double> vec, int size, double ele){
        if (vec.Count >= size) {
            vec.RemoveRange(size, vec.Count);
        } else {
            vec.AddRange(Enumerable.Repeat(ele, size - vec.Count));
        }
    }

    // T3
    public void ClearSizeListDouble(List<double> vec, int size){
        if(vec.Count == 0) return;
        if(vec.Count <= size) {
            vec.Clear();
        }
    }

    // T4
    public int InsertListDouble(List<double> vec, int index, double ele){
        if(index > vec.Count || index < 0) return -1;
        vec.Insert(index, ele);
        return vec.Count;
    }

    // T5
    public int InsertListDoubleWithList(List<double> vec, int index, List<double> eles){
        if(index > vec.Count || index < 0) return -1;
        vec.InsertRange(index, eles);
        return vec.Count;
    }

    // T6
    public bool ContainsAnyDouble(List<double> vec, List<double> eles){
        if(vec.Count == 0 || eles.Count == 0) return false;
        foreach(double ele in eles){
            if(vec.Contains(ele))
                return true;
        }
        return false;
    }

    public bool ContainsAllDouble(List<double> vec, List<double> eles){
        if(vec.Count == 0 || eles.Count == 0) return false;
        foreach(double ele in eles){
            if(!vec.Contains(ele))
                return false;
        }
        return true;
    }

    // T7
    public void SetListDouble(List<double> vec, int position , double v){
        if(position < 0 || position >= vec.Count) return;
        else{
            vec[position] = v;
        }
    }

    public void SetListDoubleWithList(List<double> vec, List<int> position, List<double> v){
        if(vec.Count < position.Count) return;
        else{
            for(int i=0; i<position.Count; ++i){
                vec[position[i]] = v[i];
            }
        }
    }

    // T8
    public void RemoveListDouble(List<double> vec, int position){
        if(position < 0 || position >= vec.Count) return;
        vec.RemoveAt(position);
    }

    public void RemoveList(List<double> vec, List<int> positions){
        foreach(int position in positions){
            if(position >= 0 && position < vec.Count)
                vec.RemoveAt(position);
        }
    }

    public void RemoveListDoubleRange(List<double> vec, int start, int off){
        if(start < 0 || start >= vec.Count) return;
        if(off < 0 || off >= vec.Count) return;
        if(start >= off) return;
        vec.RemoveRange(start, off);
    }
}