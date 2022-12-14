using System.Text;

namespace Parallel_Csharp.Parallel.String;

public class StringParallel { 
    public string GetString(string str, char c, int size, int start, int count){
        string s = new string(c, size);
        string s1 = new string(str.ToCharArray(), start, count);
        return s + s1;
    }

    public int FindCharIndex(string s, char c){
        int index = s.IndexOf(c);
        int lastIndex = s.LastIndexOf(c);
        return index + lastIndex;
    }

    public int FindStrIndex(string s, string str){
        int index = s.IndexOf(str, StringComparison.Ordinal);
        int lastIndex = s.LastIndexOf(str, StringComparison.Ordinal);
        return index + lastIndex;
    }

    public List<int> ToIntList(List<string> strs){
        List<int> list = new List<int>();
        foreach(string s in strs){
            list.Add(int.Parse(s));
        }
        return list;
    }

    public List<float> ToFloatList(List<string> strs){
        List<float> list = new List<float>();
        foreach(string s in strs){
            list.Add(float.Parse(s));
        }
        return list;
    }

    public List<double> ToDoubleList(List<string> strs){
        List<double> list = new List<double>();
        foreach(string s in strs){
            list.Add(double.Parse(s));
        }
        return list;
    }

    public bool StartsEndsString(string str, string start, string end){
        bool b1 = str.StartsWith(start);
        bool b2 = str.EndsWith(end);
        return b1 && b2;
    }

    public string SubString(string str, int index, int length){
        string s = str.Substring(index, length);
        return s;
    }

    public bool EqualStartEnd(string str){
        char start = str[0];
        char end = str[^1];
        return start == end;
    }

    public bool ContainsTwoChar(string str, char a, char b){
        bool b1 = str.Contains(a);
        bool b2 = str.Contains(b);
        return b1 && b2;
    }

    public bool ContainsTwoStrs(string str, string a, string b){
        bool b1 = str.Contains(a);
        bool b2 = str.Contains(b);
        return b1 && b2;
    }
    
    public string StringBuilderLength(char c, int length){
        StringBuilder buf = new StringBuilder();
        while(length != 0){
            --length;
            buf.Append(c);
        }
        return buf.ToString();
    }

    public string TrimStringLast(string str, int length){
        StringBuilder buf = new StringBuilder(str);
        buf.Remove(buf.Length - length, length);
        return buf.ToString();
    }

    public string ReString(string str, int position, char c){
        StringBuilder buf = new StringBuilder(str);
        buf.Remove(position, 1);
        buf.Insert(position, new string(c, 1) );
        return buf.ToString();
    }
}