namespace Parallel_Csharp.Parallel.Containers;

public class UnorderedMapParallel {
    // T1
    public Dictionary<char, char> GetMapChar(Dictionary<char, char> map){
        Dictionary<char, char> m = new Dictionary<char, char>{{'a', 'a'},
            {'b', 'b'}, {'c', 'c'}};
        map = new Dictionary<char, char>(m);
        return m;
    }

    // T2
    public void ClearMapChar(Dictionary<char, char> map, int size){
        if(map.Count == 0) return;
        if(map.Count <= size) map.Clear();
    }

    // T3
    public void ContainsThreeChar(Dictionary<char, char> map){
        if(map.ContainsKey('a') && map.ContainsKey('b') && map.ContainsKey('c')){
            map['d'] = 'd';
        }
    }

    // T4
    public void ContainsDeleteChar(Dictionary<char, char> map, char element){
        if(map.ContainsKey(element)){
            map.Remove(element);
        }
    }

    public void ContainsDeleteListChar(Dictionary<char, char> map, List<char> deleteList){
        foreach(char element in deleteList){
            if(map.ContainsKey(element)){
                map.Remove(element);
            }
        }
    }

    // T5
    public void TryAddSizeChar(Dictionary<char, char> map, int size, char c){
        if(map.Count >= size) return;
        map.TryAdd(c, c);
    }

    public void TryAddListChar(Dictionary<char, char> map, List<char> list){
        foreach(char element in list){
            map.TryAdd(element, element);
        }
    }

    // T6
    public List<char> GetValuesListCharWithDefault(Dictionary<char, char> map, List<char> keys, char default_){
        List<char> values = new List<char>();
        foreach(char key in keys){
            char value = map.GetValueOrDefault(key, default_);
            values.Add(value);
        }
        return values;
    }

    // T7
    public List<char ?> GetValuesListCharWithNull(Dictionary<char, char> map, List<char> keys){
        List<char ?> values = new List<char ?>();
        foreach(char key in keys){
            char? value = map.ContainsKey(key)? map[key] : null;
            values.Add(value);
        }
        return values;
    }

    // T8
    public Dictionary<char, char> ComposeMapChar(List<char> keys, List<char> values){
        Dictionary<char, char> map = new Dictionary<char, char>();
        if(keys.Count != values.Count || keys.Count == 0) return map;
        else{
            int size = keys.Count;
            for(int i=0; i<size; ++i){
                map[keys[i]] = values[i];
            }
        }
        return map;
    }

    public Dictionary<char, string> ComposeMapCharString(List<char> keys, List<string> values){
        Dictionary<char, string> map = new Dictionary<char, string>();
        if(keys.Count != values.Count || keys.Count == 0) return map;
        else{
            int size = keys.Count;
            for(int i=0; i<size; ++i){
                map[keys[i]] = values[i];
            }
        }
        return map;
    }
    
    public Dictionary<char, char> ComposeMapsChar(Dictionary<char, char> map1, Dictionary<char, char> map2){
        Dictionary<char, char> map = new Dictionary<char, char>();
        foreach (KeyValuePair<char, char> pair in map1) {
            map[pair.Key] = pair.Value;
        }
        foreach (KeyValuePair<char, char> pair in map2) {
            map.TryAdd(pair.Key, pair.Value);
        }
        return map;
    }
    
    // Convert Char to String
    // T1
    public Dictionary<string, string> GetMapString(Dictionary<string, string> map){
        Dictionary<string, string> m = new Dictionary<string, string>{{"aa", "aa"},
            {"bb", "bb"}, {"cc", "cc"}};
        map = new Dictionary<string, string>(m);
        return m;
    }

    // T2
    public void ClearMapString(Dictionary<string, string> map, int size){
        if(map.Count == 0) return;
        if(map.Count <= size) map.Clear();
    }

    // T3
    public void ContainsThreeString(Dictionary<string, string> map){
        if(map.ContainsKey("aa") && map.ContainsKey("bb") && map.ContainsKey("cc")){
            map["dd"] = "dd";
        }
    }

    // T4
    public void ContainsDeleteString(Dictionary<string, string> map, string element){
        if(map.ContainsKey(element)){
            map.Remove(element);
        }
    }

    public void ContainsDeleteListString(Dictionary<string, string> map, List<string> deleteList){
        foreach(string element in deleteList){
            if(map.ContainsKey(element)){
                map.Remove(element);
            }
        }
    }

    // T5
    public void TryAddSizeString(Dictionary<string, string> map, int size, string c){
        if(map.Count >= size) return;
        map.TryAdd(c, c);
    }

    public void TryAddListString(Dictionary<string, string> map, List<string> list){
        foreach(string element in list){
            map.TryAdd(element, element);
        }
    }

    // T6
    public List<string> GetValuesListStringWithDefault(Dictionary<string, string> map, List<string> keys, string default_){
        List<string> values = new List<string>();
        foreach(string key in keys){
            string value = map.GetValueOrDefault(key, default_);
            values.Add(value);
        }
        return values;
    }

    // T7
    public List<string ?> GetValuesListStringWithNull(Dictionary<string, string> map, List<string> keys){
        List<string ?> values = new List<string ?>();
        foreach(string key in keys){
            string? value = map.GetValueOrDefault(key, null);
            values.Add(value);
        }
        return values;
    }

    // T8
    public Dictionary<string, string> ComposeMapString(List<string> keys, List<string> values){
        Dictionary<string, string> map = new Dictionary<string, string>();
        if(keys.Count != values.Count || keys.Count == 0) return map;
        else{
            int size = keys.Count;
            for(int i=0; i<size; ++i){
                map[keys[i]] = values[i];
            }
        }
        return map;
    }

    public Dictionary<string, char> ComposeMapStringChar(List<string> keys, List<char> values){
        Dictionary<string, char> map = new Dictionary<string, char>();
        if(keys.Count != values.Count || keys.Count == 0) return map;
        else{
            int size = keys.Count;
            for(int i=0; i<size; ++i){
                map[keys[i]] = values[i];
            }
        }
        return map;
    }
    
    public Dictionary<string, string> ComposeMapsString(Dictionary<string, string> map1, Dictionary<string, string> map2){
        Dictionary<string, string> map = new Dictionary<string, string>();
        foreach (KeyValuePair<string, string> pair in map1) {
            map[pair.Key] = pair.Value;
        }
        foreach (KeyValuePair<string, string> pair in map2) {
            map.TryAdd(pair.Key, pair.Value);
        }
        return map;
    }
    
    // Convert Char to Int
    // T1
    public Dictionary<int, int> GetMapInt(Dictionary<int, int> map){
        Dictionary<int, int> m = new Dictionary<int, int>{{1, 1},
            {2, 2}, {3, 3}};
        map = new Dictionary<int, int>(m);
        return m;
    }

    // T2
    public void ClearMapInt(Dictionary<int, int> map, int size){
        if(map.Count == 0) return;
        if(map.Count <= size) map.Clear();
    }

    // T3
    public void ContainsThreeInt(Dictionary<int, int> map){
        if(map.ContainsKey(1) && map.ContainsKey(2) && map.ContainsKey(3)){
            map[4] = 4;
        }
    }

    // T4
    public void ContainsDeleteInt(Dictionary<int, int> map, int element){
        if(map.ContainsKey(element)){
            map.Remove(element);
        }
    }

    public void ContainsDeleteListInt(Dictionary<int, int> map, List<int> deleteList){
        foreach(int element in deleteList){
            if(map.ContainsKey(element)){
                map.Remove(element);
            }
        }
    }

    // T5
    public void TryAddSizeInt(Dictionary<int, int> map, int size, int c){
        if(map.Count >= size) return;
        map.TryAdd(c, c);
    }

    public void TryAddListInt(Dictionary<int, int> map, List<int> list){
        foreach(int element in list){
            map.TryAdd(element, element);
        }
    }

    // T6
    public List<int> GetValuesListIntWithDefault(Dictionary<int, int> map, List<int> keys, int default_){
        List<int> values = new List<int>();
        foreach(int key in keys){
            int value = map.GetValueOrDefault(key, default_);
            values.Add(value);
        }
        return values;
    }

    // T7
    public List<int ?> GetValuesListIntWithNull(Dictionary<int, int> map, List<int> keys){
        List<int ?> values = new List<int ?>();
        foreach(int key in keys){
            int? value = map.ContainsKey(key)? map[key] : null;
            values.Add(value);
        }
        return values;
    }

    // T8
    public Dictionary<int, int> ComposeMapInt(List<int> keys, List<int> values){
        Dictionary<int, int> map = new Dictionary<int, int>();
        if(keys.Count != values.Count || keys.Count == 0) return map;
        else{
            int size = keys.Count;
            for(int i=0; i<size; ++i){
                map[keys[i]] = values[i];
            }
        }
        return map;
    }

    public Dictionary<int, string> ComposeMapIntString(List<int> keys, List<string> values){
        Dictionary<int, string> map = new Dictionary<int, string>();
        if(keys.Count != values.Count || keys.Count == 0) return map;
        else{
            int size = keys.Count;
            for(int i=0; i<size; ++i){
                map[keys[i]] = values[i];
            }
        }
        return map;
    }
    
    public Dictionary<int, int> ComposeMapsInt(Dictionary<int, int> map1, Dictionary<int, int> map2){
        Dictionary<int, int> map = new Dictionary<int, int>();
        foreach (KeyValuePair<int, int> pair in map1) {
            map[pair.Key] = pair.Value;
        }
        foreach (KeyValuePair<int, int> pair in map2) {
            map.TryAdd(pair.Key, pair.Value);
        }
        return map;
    }
    
    // Convert Char to Double
    // T1
    public Dictionary<double, double> GetMapDouble(Dictionary<double, double> map){
        Dictionary<double, double> m = new Dictionary<double, double>{{1.0, 1.0},
            {2.0, 2.0}, {3.0, 3.0}};
        map = new Dictionary<double, double>(m);
        return m;
    }

    // T2
    public void ClearMapDouble(Dictionary<double, double> map, int size){
        if(map.Count == 0) return;
        if(map.Count <= size) map.Clear();
    }

    // T3
    public void ContainsThreeDouble(Dictionary<double, double> map){
        if(map.ContainsKey(1.0) && map.ContainsKey(2.0) && map.ContainsKey(3.0)) {
            map[4.0] = 4.0;
        }
    }

    // T4
    public void ContainsDeleteDouble(Dictionary<double, double> map, double element){
        if(map.ContainsKey(element)){
            map.Remove(element);
        }
    }

    public void ContainsDeleteListDouble(Dictionary<double, double> map, List<double> deleteList){
        foreach(double element in deleteList){
            if(map.ContainsKey(element)){
                map.Remove(element);
            }
        }
    }

    // T5
    public void TryAddSizeDouble(Dictionary<double, double> map, int size, double c){
        if(map.Count >= size) return;
        map.TryAdd(c, c);
    }

    public void TryAddListDouble(Dictionary<double, double> map, List<double> list){
        foreach(double element in list){
            map.TryAdd(element, element);
        }
    }

    // T6
    public List<double> GetValuesListDoubleWithDefault(Dictionary<double, double> map, List<double> keys, double default_){
        List<double> values = new List<double>();
        foreach(double key in keys){
            double value = map.GetValueOrDefault(key, default_);
            values.Add(value);
        }
        return values;
    }

    // T7
    public List<double ?> GetValuesListDoubleWithNull(Dictionary<double, double> map, List<double> keys){
        List<double ?> values = new List<double ?>();
        foreach(double key in keys) {
            double? value = map.ContainsKey(key)? map[key] : null;
            values.Add(value);
        }
        return values;
    }

    // T8
    public Dictionary<double, double> ComposeMapDouble(List<double> keys, List<double> values){
        Dictionary<double, double> map = new Dictionary<double, double>();
        if(keys.Count != values.Count || keys.Count == 0) return map;
        else{
            int size = keys.Count;
            for(int i=0; i<size; ++i){
                map[keys[i]] = values[i];
            }
        }
        return map;
    }

    public Dictionary<double, string> ComposeMapDoubleString(List<double> keys, List<string> values){
        Dictionary<double, string> map = new Dictionary<double, string>();
        if(keys.Count != values.Count || keys.Count == 0) return map;
        else{
            int size = keys.Count;
            for(int i=0; i<size; ++i){
                map[keys[i]] = values[i];
            }
        }
        return map;
    }
    
    public Dictionary<double, double> ComposeMapsDouble(Dictionary<double, double> map1, Dictionary<double, double> map2){
        Dictionary<double, double> map = new Dictionary<double, double>();
        foreach (KeyValuePair<double, double> pair in map1) {
            map[pair.Key] = pair.Value;
        }
        foreach (KeyValuePair<double, double> pair in map2) {
            map.TryAdd(pair.Key, pair.Value);
        }
        return map;
    }
}