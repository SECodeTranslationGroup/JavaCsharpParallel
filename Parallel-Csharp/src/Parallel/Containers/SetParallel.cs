namespace Parallel_Csharp.Parallel.Containers;

public class SetParallel {
    // Template 1, totally 7 functions
    public SortedSet<char> UnionGetterWithChar(SortedSet<char> set1, SortedSet<char> set2) {
        SortedSet<char> set = new SortedSet<char>();
        set.UnionWith(set1);
        set.UnionWith(set2);
        return set;
    }

    public SortedSet<char> UnionGetterWithCharV2(SortedSet<char> set1, SortedSet<char> set2) {
        SortedSet<char> set = new SortedSet<char>(set1);
        set.UnionWith(set2);
        return set;
    }

    public SortedSet<char> DifferenceGetterWithChar(SortedSet<char> set1, SortedSet<char> set2) {
        SortedSet<char> set = new SortedSet<char>();
        set.UnionWith(set1);
        set.ExceptWith(set2);
        return set;
    }

    public SortedSet<char> DifferenceGetterWithCharV2(SortedSet<char> set1, SortedSet<char> set2) {
        SortedSet<char> set = new SortedSet<char>(set1);
        set.ExceptWith(set2);
        return set;
    }

    public SortedSet<char> IntersectionGetterWithChar(SortedSet<char> set1, SortedSet<char> set2){
        SortedSet<char> temp=new SortedSet<char>(set1);
        temp.IntersectWith(set2);
        return temp;
    }

    public SortedSet<char> IntersectionGetterWithCharV2(SortedSet<char> set1, SortedSet<char> set2){
        SortedSet<char> temp=new SortedSet<char>();
        temp.UnionWith(set1);
        temp.IntersectWith(set2);
        return temp;
    }

    public SortedSet<char> SymmetricGetterWithChar(SortedSet<char> set1, SortedSet<char> set2){
        SortedSet<char> resultSet = new SortedSet<char>(set1);
        resultSet.UnionWith(set2);
        SortedSet<char> tmpSet = new SortedSet<char>(set1);
        tmpSet.IntersectWith(set2);
        resultSet.ExceptWith(tmpSet);

        return resultSet;
    }
    
    // Convert Char to String
    public SortedSet<string> UnionGetterWithString(SortedSet<string> set1, SortedSet<string> set2) {
        SortedSet<string> set = new SortedSet<string>();
        set.UnionWith(set1);
        set.UnionWith(set2);
        return set;
    }

    public SortedSet<string> UnionGetterWithStringV2(SortedSet<string> set1, SortedSet<string> set2) {
        SortedSet<string> set = new SortedSet<string>(set1);
        set.UnionWith(set2);
        return set;
    }

    public SortedSet<string> DifferenceGetterWithString(SortedSet<string> set1, SortedSet<string> set2) {
        SortedSet<string> set = new SortedSet<string>();
        set.UnionWith(set1);
        set.ExceptWith(set2);
        return set;
    }

    public SortedSet<string> DifferenceGetterWithStringV2(SortedSet<string> set1, SortedSet<string> set2) {
        SortedSet<string> set = new SortedSet<string>(set1);
        set.ExceptWith(set2);
        return set;
    }

    public SortedSet<string> IntersectionGetterWithString(SortedSet<string> set1, SortedSet<string> set2){
        SortedSet<string> temp=new SortedSet<string>(set1);
        temp.IntersectWith(set2);
        return temp;
    }

    public SortedSet<string> IntersectionGetterWithStringV2(SortedSet<string> set1, SortedSet<string> set2){
        SortedSet<string> temp=new SortedSet<string>();
        temp.UnionWith(set1);
        temp.IntersectWith(set2);
        return temp;
    }

    public SortedSet<string> SymmetricGetterWithString(SortedSet<string> set1, SortedSet<string> set2){
        SortedSet<string> resultSet = new SortedSet<string>(set1);
        resultSet.UnionWith(set2);
        SortedSet<string> tmpSet = new SortedSet<string>(set1);
        tmpSet.IntersectWith(set2);
        resultSet.ExceptWith(tmpSet);

        return resultSet;
    }
    
    // Convert Char to Int
    public SortedSet<int> UnionGetterWithInt(SortedSet<int> set1, SortedSet<int> set2) {
        SortedSet<int> set = new SortedSet<int>();
        set.UnionWith(set1);
        set.UnionWith(set2);
        return set;
    }

    public SortedSet<int> UnionGetterWithIntV2(SortedSet<int> set1, SortedSet<int> set2) {
        SortedSet<int> set = new SortedSet<int>(set1);
        set.UnionWith(set2);
        return set;
    }

    public SortedSet<int> DifferenceGetterWithInt(SortedSet<int> set1, SortedSet<int> set2) {
        SortedSet<int> set = new SortedSet<int>();
        set.UnionWith(set1);
        set.ExceptWith(set2);
        return set;
    }

    public SortedSet<int> DifferenceGetterWithIntV2(SortedSet<int> set1, SortedSet<int> set2) {
        SortedSet<int> set = new SortedSet<int>(set1);
        set.ExceptWith(set2);
        return set;
    }

    public SortedSet<int> IntersectionGetterWithInt(SortedSet<int> set1, SortedSet<int> set2){
        SortedSet<int> temp=new SortedSet<int>(set1);
        temp.IntersectWith(set2);
        return temp;
    }

    public SortedSet<int> IntersectionGetterWithIntV2(SortedSet<int> set1, SortedSet<int> set2){
        SortedSet<int> temp=new SortedSet<int>();
        temp.UnionWith(set1);
        temp.IntersectWith(set2);
        return temp;
    }

    public SortedSet<int> SymmetricGetterWithInt(SortedSet<int> set1, SortedSet<int> set2){
        SortedSet<int> resultSet = new SortedSet<int>(set1);
        resultSet.UnionWith(set2);
        SortedSet<int> tmpSet = new SortedSet<int>(set1);
        tmpSet.IntersectWith(set2);
        resultSet.ExceptWith(tmpSet);

        return resultSet;
    }
    
    // Convert Char to Double
    public SortedSet<double> UnionGetterWithDouble(SortedSet<double> set1, SortedSet<double> set2) {
        SortedSet<double> set = new SortedSet<double>();
        set.UnionWith(set1);
        set.UnionWith(set2);
        return set;
    }

    public SortedSet<double> UnionGetterWithDoubleV2(SortedSet<double> set1, SortedSet<double> set2) {
        SortedSet<double> set = new SortedSet<double>(set1);
        set.UnionWith(set2);
        return set;
    }

    public SortedSet<double> DifferenceGetterWithDouble(SortedSet<double> set1, SortedSet<double> set2) {
        SortedSet<double> set = new SortedSet<double>();
        set.UnionWith(set1);
        set.ExceptWith(set2);
        return set;
    }

    public SortedSet<double> DifferenceGetterWithDoubleV2(SortedSet<double> set1, SortedSet<double> set2) {
        SortedSet<double> set = new SortedSet<double>(set1);
        set.ExceptWith(set2);
        return set;
    }

    public SortedSet<double> IntersectionGetterWithDouble(SortedSet<double> set1, SortedSet<double> set2){
        SortedSet<double> temp=new SortedSet<double>(set1);
        temp.IntersectWith(set2);
        return temp;
    }

    public SortedSet<double> IntersectionGetterWithDoubleV2(SortedSet<double> set1, SortedSet<double> set2){
        SortedSet<double> temp=new SortedSet<double>();
        temp.UnionWith(set1);
        temp.IntersectWith(set2);
        return temp;
    }

    public SortedSet<double> SymmetricGetterWithDouble(SortedSet<double> set1, SortedSet<double> set2){
        SortedSet<double> resultSet = new SortedSet<double>(set1);
        resultSet.UnionWith(set2);
        SortedSet<double> tmpSet = new SortedSet<double>(set1);
        tmpSet.IntersectWith(set2);
        resultSet.ExceptWith(tmpSet);

        return resultSet;
    }
    
    // Template 2, totally 5 functions
    public SortedSet<char> UnionWithCharList(List<char> list1, List<char> list2){
        SortedSet<char> set1 = new SortedSet<char>(list1);
        SortedSet<char> set2 = new SortedSet<char>(list2);
        set1.UnionWith(set2);
        return set1;
    }

    public SortedSet<char> UnionWithCharListV2(List<char> list1, List<char> list2){
        SortedSet<char> set1 = new SortedSet<char>(list1);
        set1.UnionWith(list2);
        return set1;
    }

    public SortedSet<char> DifferenceWithCharList(List<char> list1, List<char> list2){
        SortedSet<char> set1 = new SortedSet<char>(list1);
        SortedSet<char> set2 = new SortedSet<char>(list2);
        set1.ExceptWith(set2);
        return set1;
    }

    public SortedSet<char> IntersectionWithCharList(List<char> list1, List<char> list2){
        SortedSet<char> set1 = new SortedSet<char>(list1);
        SortedSet<char> set2 = new SortedSet<char>(list2);
        set1.IntersectWith(set2);
        return set1;
    }

    public SortedSet<char> SymmetricWithCharList(List<char> list1, List<char> list2){
        SortedSet<char> set1 = new SortedSet<char>(list1);
        SortedSet<char> set2 = new SortedSet<char>(list2);
        SortedSet<char> resultSet = new SortedSet<char>(set1);
        resultSet.UnionWith(set2);

        SortedSet<char> tmpSet = new SortedSet<char>(set1);
        tmpSet.IntersectWith(set2);
        resultSet.ExceptWith(tmpSet);
        return resultSet;
    }
    
    // Convert Char to String
    public SortedSet<string> UnionWithStringList(List<string> list1, List<string> list2){
        SortedSet<string> set1 = new SortedSet<string>(list1);
        SortedSet<string> set2 = new SortedSet<string>(list2);
        set1.UnionWith(set2);
        return set1;
    }

    public SortedSet<string> UnionWithStringListV2(List<string> list1, List<string> list2){
        SortedSet<string> set1 = new SortedSet<string>(list1);
        set1.UnionWith(list2);
        return set1;
    }

    public SortedSet<string> DifferenceWithStringList(List<string> list1, List<string> list2){
        SortedSet<string> set1 = new SortedSet<string>(list1);
        SortedSet<string> set2 = new SortedSet<string>(list2);
        set1.ExceptWith(set2);
        return set1;
    }

    public SortedSet<string> IntersectionWithStringList(List<string> list1, List<string> list2){
        SortedSet<string> set1 = new SortedSet<string>(list1);
        SortedSet<string> set2 = new SortedSet<string>(list2);
        set1.IntersectWith(set2);
        return set1;
    }

    public SortedSet<string> SymmetricWithStringList(List<string> list1, List<string> list2){
        SortedSet<string> set1 = new SortedSet<string>(list1);
        SortedSet<string> set2 = new SortedSet<string>(list2);
        SortedSet<string> resultSet = new SortedSet<string>(set1);
        resultSet.UnionWith(set2);

        SortedSet<string> tmpSet = new SortedSet<string>(set1);
        tmpSet.IntersectWith(set2);
        resultSet.ExceptWith(tmpSet);
        return resultSet;
    }
    
    // Convert Char to Int
    public SortedSet<int> UnionWithIntList(List<int> list1, List<int> list2){
        SortedSet<int> set1 = new SortedSet<int>(list1);
        SortedSet<int> set2 = new SortedSet<int>(list2);
        set1.UnionWith(set2);
        return set1;
    }

    public SortedSet<int> UnionWithIntListV2(List<int> list1, List<int> list2){
        SortedSet<int> set1 = new SortedSet<int>(list1);
        set1.UnionWith(list2);
        return set1;
    }

    public SortedSet<int> DifferenceWithIntList(List<int> list1, List<int> list2){
        SortedSet<int> set1 = new SortedSet<int>(list1);
        SortedSet<int> set2 = new SortedSet<int>(list2);
        set1.ExceptWith(set2);
        return set1;
    }

    public SortedSet<int> IntersectionWithIntList(List<int> list1, List<int> list2){
        SortedSet<int> set1 = new SortedSet<int>(list1);
        SortedSet<int> set2 = new SortedSet<int>(list2);
        set1.IntersectWith(set2);
        return set1;
    }

    public SortedSet<int> SymmetricWithIntList(List<int> list1, List<int> list2){
        SortedSet<int> set1 = new SortedSet<int>(list1);
        SortedSet<int> set2 = new SortedSet<int>(list2);
        SortedSet<int> resultSet = new SortedSet<int>(set1);
        resultSet.UnionWith(set2);

        SortedSet<int> tmpSet = new SortedSet<int>(set1);
        tmpSet.IntersectWith(set2);
        resultSet.ExceptWith(tmpSet);
        return resultSet;
    }
    
    // Convert Char to Double
    public SortedSet<double> UnionWithDoubleList(List<double> list1, List<double> list2){
        SortedSet<double> set1 = new SortedSet<double>(list1);
        SortedSet<double> set2 = new SortedSet<double>(list2);
        set1.UnionWith(set2);
        return set1;
    }

    public SortedSet<double> UnionWithDoubleListV2(List<double> list1, List<double> list2){
        SortedSet<double> set1 = new SortedSet<double>(list1);
        set1.UnionWith(list2);
        return set1;
    }

    public SortedSet<double> DifferenceWithDoubleList(List<double> list1, List<double> list2){
        SortedSet<double> set1 = new SortedSet<double>(list1);
        SortedSet<double> set2 = new SortedSet<double>(list2);
        set1.ExceptWith(set2);
        return set1;
    }

    public SortedSet<double> IntersectionWithDoubleList(List<double> list1, List<double> list2){
        SortedSet<double> set1 = new SortedSet<double>(list1);
        SortedSet<double> set2 = new SortedSet<double>(list2);
        set1.IntersectWith(set2);
        return set1;
    }

    public SortedSet<double> SymmetricWithDoubleList(List<double> list1, List<double> list2){
        SortedSet<double> set1 = new SortedSet<double>(list1);
        SortedSet<double> set2 = new SortedSet<double>(list2);
        SortedSet<double> resultSet = new SortedSet<double>(set1);
        resultSet.UnionWith(set2);

        SortedSet<double> tmpSet = new SortedSet<double>(set1);
        tmpSet.IntersectWith(set2);
        resultSet.ExceptWith(tmpSet);
        return resultSet;
    }
    
    // Template 3, Check Empty and Clear
    public void MakeEmpty(SortedSet<object> set){
        if(set.Count != 0){
            set.Clear();
        }
    }
    
    //Template 4, Check Contains and Remove
    public void RemoveIfExistsChar(SortedSet<char> set, char c){
        if(set.Contains(c)){
            set.Remove(c);
        }
    }

    // Convert Char to String
    public void RemoveIfExistsString(SortedSet<string> set, string c){
        if(set.Contains(c)){
            set.Remove(c);
        }
    }
    
    // todo Convert Char to Int
    public void RemoveIfExistsInt(SortedSet<int> set, int c){
        if(set.Contains(c)){
            set.Remove(c);
        }
    }
    // todo Convert Char to Double
    public void RemoveIfExistsDouble(SortedSet<double> set, double c){
        if(set.Contains(c)){
            set.Remove(c);
        }
    }
    
    //Template 5, Check Size and return Subset
    public SortedSet<char> SubSetRangeChar(SortedSet<char> set, int size, char floor, char ceil){
        SortedSet<char> subSet = new SortedSet<char>();
        if(set.Count < size) return subSet;
        else{
            subSet = new SortedSet<char>(set.GetViewBetween(floor, ceil));
            return subSet;
        }
    }

    public SortedSet<char> SubSetGreaterChar(SortedSet<char> set, int size, char floor){
        SortedSet<char> subSet = new SortedSet<char>();
        if(set.Count < size) return subSet;
        else{
            subSet = new SortedSet<char>(set.GetViewBetween(floor, set.Max));
            return subSet;
        }
    }

    public SortedSet<char> SubSetLessChar(SortedSet<char> set, int size, char ceil){
        SortedSet<char> subSet = new SortedSet<char>();
        if(set.Count < size) return subSet;
        else{
            subSet = new SortedSet<char>(set.GetViewBetween(set.Min, ceil));
            return subSet;
        }
    }
    
    // Convert Char to String
    public SortedSet<string> SubSetRangeString(SortedSet<string> set, int size, string floor, string ceil){
        SortedSet<string> subSet = new SortedSet<string>();
        if(set.Count < size) return subSet;
        else{
            subSet = new SortedSet<string>(set.GetViewBetween(floor, ceil));
            return subSet;
        }
    }

    public SortedSet<string> SubSetGreaterString(SortedSet<string> set, int size, string floor){
        SortedSet<string> subSet = new SortedSet<string>();
        if(set.Count < size) return subSet;
        else{
            subSet = new SortedSet<string>(set.GetViewBetween(floor, set.Max));
            return subSet;
        }
    }

    public SortedSet<string> SubSetLessString(SortedSet<string> set, int size, string ceil){
        SortedSet<string> subSet = new SortedSet<string>();
        if(set.Count < size) return subSet;
        else{
            subSet = new SortedSet<string>(set.GetViewBetween(set.Min, ceil));
            return subSet;
        }
    }
    
    // Convert Char to Int
    public SortedSet<int> SubSetRangeInt(SortedSet<int> set, int size, int floor, int ceil){
        SortedSet<int> subSet = new SortedSet<int>();
        if(set.Count < size) return subSet;
        else{
            subSet = new SortedSet<int>(set.GetViewBetween(floor, ceil));
            return subSet;
        }
    }

    public SortedSet<int> SubSetGreaterInt(SortedSet<int> set, int size, int floor){
        SortedSet<int> subSet = new SortedSet<int>();
        if(set.Count < size) return subSet;
        else{
            subSet = new SortedSet<int>(set.GetViewBetween(floor, set.Max));
            return subSet;
        }
    }

    public SortedSet<int> SubSetLessInt(SortedSet<int> set, int size, int ceil){
        SortedSet<int> subSet = new SortedSet<int>();
        if(set.Count < size) return subSet;
        else{
            subSet = new SortedSet<int>(set.GetViewBetween(set.Min, ceil));
            return subSet;
        }
    }
    
    // Convert Char to Double
    public SortedSet<double> SubSetRangeDouble(SortedSet<double> set, int size, double floor, double ceil){
        SortedSet<double> subSet = new SortedSet<double>();
        if(set.Count < size) return subSet;
        else{
            subSet = new SortedSet<double>(set.GetViewBetween(floor, ceil));
            return subSet;
        }
    }

    public SortedSet<double> SubSetGreaterDouble(SortedSet<double> set, int size, double floor){
        SortedSet<double> subSet = new SortedSet<double>();
        if(set.Count < size) return subSet;
        else{
            subSet = new SortedSet<double>(set.GetViewBetween(floor, set.Max));
            return subSet;
        }
    }

    public SortedSet<double> SubSetLessDouble(SortedSet<double> set, int size, double ceil){
        SortedSet<double> subSet = new SortedSet<double>();
        if(set.Count < size) return subSet;
        else{
            subSet = new SortedSet<double>(set.GetViewBetween(set.Min, ceil));
            return subSet;
        }
    }
    
    // Template 6, Check Size and find ceil and floor
    public char? CeilChar(SortedSet<char> set, int size, char ceil){
        char? c;
        if(set.Count < size) return null;
        else{
            c = set.GetViewBetween(ceil, set.Max).Min;
            return c;
        }
    }

    public char? FloorChar(SortedSet<char> set, int size, char floor){
        char? c;
        if(set.Count < size) return null;
        else{
            c = set.GetViewBetween(set.Min, floor).Max;
            return c;
        }
    }
    
    // todo Convert Char to String
    public string? CeilString(SortedSet<string> set, int size, string ceil){
        string? c;
        if(set.Count < size) return null;
        else{
            c = set.GetViewBetween(ceil, set.Max).Min;
            return c;
        }
    }

    public string? FloorString(SortedSet<string> set, int size, string floor){
        string? c;
        if(set.Count < size) return null;
        else{
            c = set.GetViewBetween(set.Min, floor).Max;
            return c;
        }
    }
    
    // todo Convert Char to Int
    public int? CeilInt(SortedSet<int> set, int size, int ceil){
        int? c;
        if(set.Count < size) return null;
        else{
            c = set.GetViewBetween(ceil, set.Max).Min;
            return c;
        }
    }

    public int? FloorInt(SortedSet<int> set, int size, int floor){
        int? c;
        if(set.Count < size) return null;
        else{
            c = set.GetViewBetween(set.Min, floor).Max;
            return c;
        }
    }
    // todo Convert Char to Double
    public double? CeilDouble(SortedSet<double> set, int size, double ceil){
        double? c;
        if(set.Count < size) return null;
        else{
            c = set.GetViewBetween(ceil, set.Max).Min;
            return c;
        }
    }

    public double? FloorDouble(SortedSet<double> set, int size, double floor){
        double? c;
        if(set.Count < size) return null;
        else{
            c = set.GetViewBetween(set.Min, floor).Max;
            return c;
        }
    }
}