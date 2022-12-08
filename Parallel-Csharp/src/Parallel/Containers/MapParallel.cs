namespace Parallel_Csharp.Parallel.Containers;

public class MapParallel {
    public SortedDictionary<string,Object> PostSendAllNews(string accessToken,bool is_to_all,int groupId,string mediaId){
        SortedDictionary<string,Object> obj = new SortedDictionary<string,Object>();
        SortedDictionary<string,Object> params1 = new SortedDictionary<string,Object>();
        params1["is_to_all"] = is_to_all;
        params1["group_id"] = groupId;
        obj["filter"] = params1;
        //
        SortedDictionary<string,Object> newsParasm = new SortedDictionary<string,Object>();
        newsParasm["media_id"] = mediaId;
        obj["mpnews"] = newsParasm;
        obj["msgtype"] = "mpnews";
        //
        return obj;
    }

    public SortedDictionary<string,Object> PostSendAllVoice(string accessToken,bool is_to_all,int groupId,string mediaId){
        SortedDictionary<string,Object> obj = new SortedDictionary<string,Object>();
        SortedDictionary<string,Object> params1 = new SortedDictionary<string,Object>();
        params1["is_to_all"] = is_to_all;
        params1["group_id"] = groupId;
        obj["filter"] = params1;
        //
        SortedDictionary<string,Object> newsParasm = new SortedDictionary<string,Object>();
        newsParasm["media_id"] = mediaId;
        obj["voice"] = newsParasm;
        obj["msgtype"] = "voice";
        //
        return obj;
    }

    public SortedDictionary<string,Object> PostSendAllImage(string accessToken,bool is_to_all,int groupId,string mediaId){
        SortedDictionary<string,Object> obj = new SortedDictionary<string,Object>();
        SortedDictionary<string,Object> params1 = new SortedDictionary<string,Object>();
        params1["is_to_all"] = is_to_all;
        params1["group_id"] = groupId;
        obj["filter"] = params1;
        //
        SortedDictionary<string,Object> newsParasm = new SortedDictionary<string,Object>();
        newsParasm["media_id"] = mediaId;
        obj["image"] = newsParasm;
        obj["msgtype"] = "image";
        //

        return obj;
    }


    public void  RemoveAllMappingsFromSortedDictionary() {
        SortedDictionary<string, string> map = new SortedDictionary<string, string>();

        map["key1"] = "Jack";
        map["key2"] = "Rick";
        map["key3"] = "Kate";
        map["key4"] = "Tom";
        map["key5"] = "Steve";
        map["key6"] = "Ram";

        Console.WriteLine("Before: SortedDictionary contains: " + map);
        map.Clear();
        Console.WriteLine("After: SortedDictionary contains: " + map);
    }
    
    public Dictionary<string, string> ToTransMap(int uuid, string repoName, string dirName){
        Dictionary<string, string> arguments = new Dictionary<string, string>();

        arguments.TryAdd("uuid", Convert.ToString(uuid) );
        arguments.TryAdd("repo", repoName );
        arguments.TryAdd("dir", dirName );
        return arguments;
    }
    
    public List<char> ChefAndPickDigit(string a){
        List<char> c = new List<char>();
        Dictionary<char, int> map = new Dictionary<char, int>();
        int i = 0;
        while (i < a.Length) {
            char d = a[i];
            if (map.ContainsKey(d)) {
                map[d] = map[d] + 1;
            } else {
                map[d] = 1;
            }
            i++;
        }
        //  out.println("iterated");
        if (map.ContainsKey('6') && map.ContainsKey('5')) {
            c.Add('A');
        }
        if (map.ContainsKey('6') && map.Count(pair => pair.Key =='6') >= 2) {
            c.Add('B');
        }
        return c;
    }
    
    public List<int> ChefAndPickDigitList(List<int> a){
        List<int> c = new List<int>();
        Dictionary<int, char> map = new Dictionary<int, char>();
        int i = 0;
        while (i < a.Count) {
            int d = a[i];
            if (map.ContainsKey(d)) {
                c.Add(i);
            }
            i++;
        }
        return c;
    }

    public int MapProcessInt(Dictionary<string, int> map)
    {
        string a = "value1";
        string b = "value2";

        int value1 = map.GetValueOrDefault(a, 0);
        int value2 = map.GetValueOrDefault(b, 0);

        return value1 + value2;
    }
    
    public string MapProcessString(Dictionary<string, string> map)
    {
        string a = "value1";
        string b = "value2";

        string value1 = map.GetValueOrDefault(a, "");
        string value2 = map.GetValueOrDefault(b, "");

        return value1 + value2;
    }
    
    public double MapProcessString(Dictionary<string, double> map)
    {
        string a = "value1";
        string b = "value2";

        double value1 = map.GetValueOrDefault(a, 0.0);
        double value2 = map.GetValueOrDefault(b, 0.0);

        return value1 + value2;
    }
    
    public bool MapProcessString(Dictionary<string, bool> map)
    {
        string a = "value1";
        string b = "value2";

        bool value1 = map.GetValueOrDefault(a, false);
        bool value2 = map.GetValueOrDefault(b, false);

        return value1 && value2;
    }
}