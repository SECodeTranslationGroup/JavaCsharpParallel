public static void morePositiveNums(Integer[] lines) { 
    List<int> list = new List<int>(lines);  
    if(list.Max() >= sum(list)) {
        Console.Writeline("No");
    } else {
        Console.Writeline("Yes");
    }
}

static List<string> myconv(string str, int no) {
    string splitstring = CONVSTR.Substring(no,1);
    return new List<string>(str.Split(splitstring));
}

static List<int> inputIntList() throws Exception {
    List<string> strList = new List<int>(Console.ReadLine()().Trim().Split(" "));
    List<int> intList = new List<int>();
    foreach (var elem in strList){
        intList.Add(int.Parse(elem));
    }
    return intList;
}

public static void isEven(string nextLine) {
    List<string> input=new List<string>(nextLine.Split(" "));
    int result=int.Parse(input.First())*int.Parse(input[1]);
    string msg=result%2==0?"Even":"Odd";
    Console.Writeline(msg);

}

public static void countSlimeColor(int numSlime , string slimeColor) {
    List<string> colors = new List<string> (slimeColor.Split(""));
    int cnt = 1;
    for (int i = 0; i < numSlime; i++) {
        if(i > 0 && !colors[i].Equals(colors[i - 1])) {
            cnt++;
        }
    }
    Console.Writeline(cnt);
}   

public static void countLetter() throws IOException{
    string str;
    int count[] = new int[26];
    char abc ='a';   
    while((str=Console.ReadLine()())!=null){      
        for(int i=0;i<str.Length;i++){
            if(Char.IsLetter(str[i])){
                count[Char.ToLower(str[i]) - 'a']++;
            }
        }
    }
}

public static void countLetter(List<string> args) {
    int[] alpha = new int['z' - 'a' + 1];
    while (args.Count > 0) {
        string str = args.First().ToLower();
        for (int i = 0; i < str.Length; i++) {
            if (Char.IsLetter(str[i])) {
                alpha[str[i] - 'a']++;
            }
        }
        args.Remove(First());
    }
}

public static void swapUpperAndLowerLetter(string[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    while (sc.hasNext()) {
        string s = sc.next();   
        for (int i = 0; i < s.Length; i++) {
            char c = s[i];
            if (Char.IsLetter(c)) {
                if (Char.IsUpper(c)) {
                    c = Char.ToLower(c);
                } else {
                    c = Char.ToUpper(c);
                }
            }
            sb.Append(c);
        }
        sb.Append(" ");
    }
    sb.Remove(sb.Length-1, 1);
    Console.Writeline(sb);
}


public static void isOneLetterMore (string s , string s1) throws java.lang.Exception
{
        int t,f=0;
        if(((s1.Length-s.Length) ==1) && (Char.IsLetter(s1[^1])))
        {
            for(t=0;t<s.Length;t++)
            {
                if(s.charAt[t] != s1.charAt[t])
                f=1;
            }
            if(f==0)
            {
                Console.Writeline("Yes");
            }
            else{
                Console.Writeline("No"); 
            }
        }
        else{
            Console.Writeline("No");          
            }        
}

public static void countLetter(List<string> args) {
            int[] alphabet = new int[26];
            char a = 'a', ch;
            while (args.size > 0) {
                    string str = args.First().ToLower();
                    for (int i=0; i< str.Length; i++) {
                            if (Char.IsLetter(ch = str[i])) {
                                    alphabet[ch - a]++;
                            }
                    }
                args.Remove(First());
            }
            for (int i=0; i <= ('z' - 'a'); i++) {
                    Console.Writeline(new StringBuilder().Append(a++).Append(" : ").Append(alphabet[i]).ToString());
            }
}

public static void isLetterEven( string s) throws Exception {
    int[] frq = new int[26];
    for(int i = 0 ; i < s.Length ; i++)
    {
        if( Char.IsLower(s[i]) )
        {
            frq[s[i]-'a']++;
        }
    }
    bool flag = true;
    for(int i = 0 ; i < 26; i++)
        if(frq[i]%2!=0)
        {
            flag = false;
            break;
        }
    if(flag)
        Console.Writeline("Yes");
    else Console.Writeline("No");
}

private static void countup(char c){
    if(Char.IsLower(c)){
            int num=c-'a';
            counter[num]++;
    }
    if(Char.IsUpper(c)){
            char ch=Char.ToLower(c);
            int num=ch-'a';
            counter[num]++;
    }
}

public void checkAC( string nextLine) {
    char[] s = nextLine.ToCharArray();
    bool ok = true;
    if (s[0] != 'A') ok = false;
    int c = 0;
    for (int i = 2; i < s.Length-1; i++) {
            if (s[i] == 'C') c++;
    }
    if (c != 1) ok = false;
    for (int i = 0; i < s.Length; i++) {
            if (s[i] == 'A' || s[i] == 'C') {
                    continue;
            }
            if (!Char.IsLower(s[i])) ok = false;
    }
    Console.WriteLine(ok ? "AC" : "WA");
}

static bool checkAC(string s) {
    if (s[0] != 'A') return false;
    int cnt = 0;
    for (int i = 1; i < s.Length; i++)
        if (i >= 2 && i <= s.Length - 2) {
            if (s[i] == 'C') {
                if (++cnt > 1) return false;
            }else if (!Char.IsLower(s[i]))
                return false;
        } else if (!Char.IsLower(s[i]))
            return false;
    return cnt == 1;
}


public static void checkFirstLetterCase(string s){
    if(Char.IsLower(s[0])){
        Console.Writeline("a");
    }else{
        Console.Writeline("A");
    }
    ;
  }

  public static void checkFirstLetterCase(string input) throws IOException { 
    char [] ch = input.ToCharArray();
    if(Char.IsLower(ch[0])) Console.Writeline("a");
    else Console.Writeline("A");
} 

public static void checkAC(string s ){
    string result = "AC";
    if(s[0] != 'A') result = "WA";
    bool flg = false;
    for(int i = 1; i < s.Length; i++){
        if(Char.IsUpper(s[i])){
            if(i >= 2 && s.Length-2 >= i && s[i] == 'C' && !flg){
                flg = true;
            }else{
                result = "WA";
            }
        }
    }
    if(!flg) result = "WA";
    Console.Writeline(result);
}

public static void calculator(Stack<string> args) throws Exception {   
    string st;
    Stack<int> stack = new Stack<int>();
    while (args.Count > 0) {                        
        st = args.First();
        if (Char.IsDigit(st[0])) stack.Push(int.Parse(st));
        else {
            int x = stack.Pop();
            int y = stack.Pop();
            if (st.Equals("+")) stack.Push(x + y);
            else if (st.Equals("-")) stack.Push(y - x);
            else if (st.Equals("*")) stack.Push(y * x);
        }
        args.Pop();
    }
    Console.Writeline(stack.Pop());
}  

public static void add(string expression){
    Stack<int> stack=new Stack<int>();
    string[] arrays=expression.Split(" ");
    for(int i=0;i<arrays.Length;i++){
            if(Char.IsDigit(arrays[i][0]))
                    stack.Add(int.Parse(arrays[i]));
            else if(!Char.IsDigit(arrays[i][0])){
                    int number2=stack.Pop();
                    int number1=stack.Pop();
                    stack.Push(add(number1,number2,arrays[i][0]));
            }
    }
    Console.Writeline(stack.Pop());
}

public static void calculator(Stack<string> args) throws Exception {      
    string st;
    Stack<int> stack = new Stack<int>();
    while (args.size > 0) {                        
        st = args.args.Pop();
        if (Char.IsDigit(st[0])) stack.Push(int.Parse(st));
        else {
            int x = stack.Pop();
            int y = stack.Pop();
            if (st.Equals("+")) stack.Push(x + y);
            else if (st.Equals("-")) stack.Push(y - x);
            else if (st.Equals("*")) stack.Push(y * x);
        }  
    }
    Console.Writeline(stack.Pop());
} 

static bool isNum(string s){
    char[] array = s.ToCharArray();
    int flag = 0;
    if(array[0]=='-'&&s.Length>1)
        flag = 1;
    foreach (var c in array) {
        if(!Char.IsDigit(c)){
            flag--;
        }
        if(flag<0)
            return false;
    }
    return true;
}

    public void isTimes( string n) {
        long l = long.Parse(n);
        long sum = 0;
        foreach (char c in n.ToCharArray()) {
            sum += Character.IsDigit(c, 10);
        }
        if (l % sum == 0) {
            out.print("Yes");
        } else {
            out.print("No");
        }
    }

public static void addMedium(string args[]) throws Exception{
    string[] s = Console.ReadLine().Split(" ");
    int N = int.Parse(s[0]);
    int A = int.Parse(s[1]);
    int B = int.Parse(s[2]);
    int num = 0;
    for(int i = 1 ; i <= N; i++) {
        string str = i.ToString();
        int count = 0;
        for(int j = 0 ; j < str.Length; j++) {
            count += Char.IsDigit(str[j]);
        }
        if(A <= count && count <= B) num+=i;
    }
    Console.Writeline(num);
}

public static void Summation(List<string>  args) {
    while(true){
            string x = args.First();
            if(x.Equals("0")){
                    break;
            }
            int sum = 0;
            for(int i = 0; i < x.Length; i++){
                    sum += Char.IsDigit(x[i]);
            }
            Console.Writeline(sum);
            args.Remove(First());
    }
}

public static void Summation(Stack<string> args) {
    while (true) {
        string s = args.Pop();
        if (s.Length == 1 && s[0] == '0')
            break;
        int sum = 0;
        for (int i = 0; i < s.Length; i++)
            sum += Char.IsDigit(s[i]);
        Console.Writeline(sum);
    }
}

public static void Summation(Stack<string> args){
    for(;;){
    int ans =0;
    string s=args.Pop();
    if(s.Equals("0"))break;
    for(int i=0; i<s.Length; i++){
            ans += Char.IsDigit(s[i],10);
    }
    Console.Writeline(ans);
    }
}

char nextChar() {
    try {
        int b = input.read();
        while (Char.IsWhiteSpace(b)) {
            b = input.read();
        }
        return (char) b;
    } catch (IOException e) {
        e.printStackTrace();
        return 0;
    }
}

string nextStr() {
    try {
        StringBuilder sb = new StringBuilder();
        int b = input.read();
        while (Char.IsWhiteSpace(b)) {
            b = input.read();
        }
        while (b != -1 && !Char.IsWhiteSpace(b)) {
            sb.Append((char) b);
            b = input.read();
        }
        return sb.ToString();
    } catch (IOException e) {
        e.printStackTrace();
        return "";
    }
}

public string next() throws IOException{
    byte c = read();
    while(Char.IsWhiteSpace(c)){
        c = read();
    }
     StringBuilder builder = new StringBuilder();
    builder.Append((char)c);
    c = read();
    while(!Char.IsWhiteSpace(c)){
        builder.Append((char)c);
        c = read();
    }   
    return builder.ToString();
}

public string nextStr() {
    try {
        StringBuilder sb = new StringBuilder();
        int b = input.read();
        while (Char.IsWhiteSpace(b)) {
            b = input.read();
        }
        while (b != -1 && !Char.IsWhiteSpace(b)) {
            sb.Append((char) b);
            b = input.read();
        }
        return sb.ToString();
    } catch (IOException e) {
        e.printStackTrace();
        return "";
    }
}

public void isLRUD( string s) {
    int n = s.Length;
    for (int i = 0; i < n; i++) {
        if (i % 2 == 0) {
            if (!"RUD".Contains(s[i].ToString())) {
                Console.WriteLine("No");
                return;
            }
        } else if (!"LUD".Contains(s[i].ToString())) {
            Console.WriteLine("No");
            return;
        }
    }
    Console.WriteLine("Yes");
}

public static void LongMultiplestring(long a){
    long a = scan.nextLong();
    string bs = scan.next();
    int b = int.Parse(bs[0].ToString()) * 100
            + int.Parse(bs[2].ToString()) * 10
            + int.Parse(bs[3].ToString());
    Console.Writeline((long)a * b / 100);
    scan.close();
}

public static void countABC(int N,  string S) throws FileNotFoundException {
    ;
    int ans = 0;
    char[] s = S.ToCharArray();
    for(int i=0;i<S.Length-2;i++) {
            string a = s[i].ToString()+s[i+1].ToString()+s[i+2].ToString();
            if(a.Equals("ABC")) {
                    ans++;
            }
    }
    Console.Writeline(ans);
}

public static void addMid(int n, int a, int b){
    int res = 0;
    for(int i = 1; i <= n; i++) {
            string s = i.ToString();
            int j =  0;
            foreach(char c in s.ToCharArray()) {
                    j+=int.Parse(c.ToString());
            }
            if(j >= a && j <= b) {
                    res+=i;
            }
    }
    Console.WriteLine(res);
}

private void changingACharchter(int k, string nextLine) {
    char[] s = nextLine.ToCharArray();
    s[k - 1] = Char.ToLower(s[k - 1]);
    Console.Writeline(new string(s));
}

public static void setLowerCaseK(Stack<int> args, Stack<string> inputS) {
    while(scan.hasNext())
    {
            int n,k;
            n=args.Pop();
            k=args.Pop();
            string s,s1 ;
            s=inputS.Pop();
            char arr[]=s.ToCharArray();
            char c=Char.ToLower(arr[k-1]);
            arr[k-1]=c;
            Console.Writeline(arr);
    }
}

public void setLowerCaseK( string N, string K) {
    int n = int.Parse(N);
    int k = int.Parse(K);
    string S = in.next();
    string tmp1 = S.Substring(0, k - 1);
    string tmp2 = S.Substring(k);
    char tmp3 = Char.ToLower(S[k - 1]);
    Console.WriteLine(tmp1 + tmp3 + tmp2);
}

private static void setLowerCaseK(){
            int n = ni();
            int k = ni();
            char[] ca = next().ToCharArray();
            ca[k-1] = Char.ToLower(ca[k-1]);
            Console.Writeline(new string(ca));
}

private static string invertCase(string str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.Length; i++) {
        if (Char.IsUpper(str[i])) {
            sb.Append(Char.ToLower(str[i]));
        } else {
            sb.Append(Char.ToUpper(str[i]));
        }
    }
    return sb.ToString();
}

public static void covertCharacterCase( string str){
    char c;
    for(int i=0;i<str.Length;i++){
        c=str[i];
        if(Char.IsUpper(c))Console.Writeline(Char.ToLower(c));
        else Console.Writeline(Char.ToUpper(c));
    }
    Console.Writeline();
}

public static void normalizatoin(string src){
    string Array[] = src.Split("");
    List<string> list = new List<string>(Array);
    int count0 = list.Count(i => i == "0");
    int count1 = list.Count(i => i == "1");
    if(count0 > count1){
            Console.Writeline(count1*2);
    }else{
            Console.Writeline(count0*2);
    }
}

public static void allToLowerCase(List<string> args) {
    List<string> str = new List<string>();
    string target = args.First().ToLower();
    args.Remove(First());
    while(true) {
        string tmp = args.First();
        args.Remove(First());
        if(tmp.Equals("END_OF_TEXT")) {
            break;
        }
        str.Add(tmp.ToLower());
    }
    Console.Writeline(str.Count(i => i == target));
}

public static void allToLowerCase(string args) {
    string ptn = args.ToLower();
    List<string> als = new List<string>();
    while(scn.hasNext()) {
        als.Add(scn.next().ToLower());
    }
    Console.Writeline(als.Count(i => i == ptn));
}

public static void checkAC(int n, int m, string[] args) {
    List<int> ac = new List<int>(new int[n]);
    List<int> pena =new List<int>(new int[n]);
    ac = Enumerable.Repeat(0, n).ToList();
    pena = Enumerable.Repeat(0, n).ToList();
    for(int i=0; i<m; ++i)  {
            int p = int.Parse(args[i]);
            string s = scan.next();
            --p;
            if(ac[p] == 1) continue;
            if(s.Equals("AC")) {
                    ac[p] = 1;
            } else {
                    pena[p] = (pena[p]+1);
            }
    }
    int AC = 0, PENA = 0;
    for(int i=0; i<n; ++i) {
            AC += ac[i];
            if(ac[i] == 1) PENA += pena[i];
    }
    Console.Writeline(AC + " " + PENA);
}

public static void swapList(int t1, int t2, string args[]){List<int>l=new List<int>();int t=t1,i=0;for(;i++<t;)l.Add(i);for(t=t2;t>0;t--){string[]e=args[t].Split(",");(l[new int(e[0]) - 1], l[new int(e[1]) - 1]) =(l[new int(e[1]) - 1], l[new int(e[0]) - 1] = l[new int(e[1]) - 1];)}for(i=0;i<t;++i)args[i]=String.Format("{0},{1}",l[i],i+1);}reach(var e in l)Console.Writeline(e);}

public static void swapList(string[] arg) throws IOException
{
        int v = int.Parse(Console.ReadLine()());
        List<int> amida = new List<int>(v);
        for(int i=0; i<v; i++)
                amida.Add(i+1);
        int h = int.Parse(Console.ReadLine()());
        for(int i=0; i<h; i++){
                string swapInd = Console.ReadLine()();
                int swap1 = int.Parse(swapInd.Split(",")[0]);
                int swap2 = int.Parse(swapInd.Split(",")[1]);
                (amida[swap1-1],amida[swap2-1]) = (amida[swap2-1],amida[swap1-1]);
        }
        for(int i=0; i<v; i++)
                Console.Writeline(amida[i]);
}

public static void swapList(int n, int[] inputArray) {
    int c=0;List<int> A=new List<int>();
    for(int i=0;i<n;i++)A.Add(inputArray[i]);
    bool flag=true;
    while(flag) {
            flag=false;
            for(int i=n-1;i>0;i--) {
                    if(A[i]<A[i - 1]) {
                            (A[i] , A[i - 1]) = (A[i - 1], A[i]);
                            c++;
                            flag=true;
                    }
            }
    }
    for(int i=0;i<n;i++) {
            Console.Writeline(A[i]);
            if(i!=n-1)Console.Writeline(" ");
    }
    Console.Writeline();
    Console.Writeline(c);
}

public static void reverseList(string[] args) {
    string str;
    List<int> al = new List<int>();
    try {
        while((str = Console.ReadLine()()) != null) {
            al.Add( int.Parse(str) );
        }
    } catch (Exception e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    al.Sort();
    al.Reverse();
    for(int i=0; i<3; i++) {
        Console.Writeline(al[i]);
    }
}

public static void reverseList(List<int> list) {
    list.Sort();
    list.Reverse();
    for (int i = 0; i < 3; i++) {
        Console.Writeline(list[i]);
    }
}

public static void reverseList(string[] args) throws IOException {
    List<int> array = new List<int>();
    for(int i = 0; i < 10; i++) {
      int x = int.Parse(Console.ReadLine());
      array.Add(x);
    }
    array.Sort();
    array.Reverse();
    for(int i = 0; i < 3; i++) {
      Console.Writeline(array[i]);
    }
}

public static void reverseList( string s){
    List<string> list = new List<string>();
    string[] str = s.Split("");
    foreach(var a in str){
            list.Add(a);
    }
    list.Reverse();
    foreach(var a in list){
            Console.Writeline(a);
    }
    Console.Writeline("");
}

public static void checkSameStr(string[] args) throws Exception {
    char[] s = args[0].ToCharArray();
    char[] t = args[1].ToCharArray();
    if(s.Length != t.Length) {
        Console.Writeline("No");
        return;
    }
    int len = s.Length;
    List<char> sl = new List<char>();
    foreach(var c in s){
        sl.Add(c);
    }
    for(int i = 0; i < len; i++){
        bool b = true;
        for(int j = 0; j < len; j++){
            if(sl[j] != t[j]){
                b = false;
                break;
            }
        }
        if(b){
            Console.Writeline("Yes");
            return;
        }
        Collections.rotate(sl,1);
    }
    Console.Writeline("No");
}


int upperBound(List<long> list, long target){
    int i = list.BinarySearch(target, new UpperBoundComparator<long>());
    return ~i;
}

int lowerBound(List<long> list, long target){
    int i = list.BinarySearch(target, new LowerBoundComparator<long>());
    return ~i;
}

public static void search(int n ,List<string> args) {
    List<string> array = new List<string>();
    while(args.Count > 0) {
            string s = args.First();
            args.Remove(First());
            int index = array.BinarySearch(s);
            if(index < 0) {
                    index = - (index + 1);
                    array.Add(index, s);
            }
    }
    int ans = array.Count;
    Console.Writeline(ans);
}

private static int search(List<int> list, int key) {
    int r = list.BinarySearch(key);
    return r < 0 ? ~r : r;
}

public List<int> gerPrimes() {
    return Collections.unmodifiableList(primes);
}

static void dispResult(Dictionary<string, int> result) {
    static final List<string> RESULT_TYPE = 
    Collections.unmodifiableList(new List<int>(new[] {"AC", "WA", "TLE", "RE"}));
    foreach (var R in RESULT_TYPE) {
      Console.Writeline(R + " x " + (result[R] == null ? 0 : result[R]));
    }
}

public static bool isNumber(double val) {
    if ((val == Math.Floor(val)) && !double.IsInfinity(val)) {
            return true;
    }
    return false;
}

public static void isSquareNumber(string[] args) {
    count = 0;
    for (int i = 0; i < intList.Count; i++) {
        if ((Math.Sqrt(intList[i]) == Math.Floor(Math.Sqrt(intList[i])))
                && !double.IsInfinity(Math.Sqrt(intList[i]))) {
            count++;
        }
    }
}

public static void countRemain(int N, int K, int[] inputArray ) {
    List<int> nList = Enumerable.Range(1, N).ToList();
    for (int i = 0; i < K; i++) {
      int di = inputArray[i];
      for (int j = 0; j < di; j++) {
        int A = inputArray[K + j];
        int index = nList.IndexOf(A);
        if (index != -1) {
          nList.RemoveAt(index);
        }
      }
    }
    Console.Writeline(nList.Count);
}

private void nArray() {
    int numN = nextInt();
    int[] wk = IntStream.range(0, numN).toArray();
}

public static void maxDifference(string[]args){
    int N=sc.nextInt();
    int[]A=new int[N];
    for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
    }
    int max=0;
    Array.Sort(A);
    max=Math.Abs(A[0]-A[N-1]);
    Console.Writeline(max);
}

public static void maxDifference(int n, int[] inputArray){
    List<int> list = new List<int>(n);
    for(int i = 0;i < n; i++){
      list.Add(inputArray[i]);
      }
    list.Sort();
    Console.Writeline(Math.Abs(list.Last() - list.First()));
}

public static long dist(long[] p1, long[] p2) {
    return (Math.Abs(p2[0]-p1[0])+Math.Abs(p2[1]-p1[1]));
}

public static void maxDifference(string nextLine) {
    string[] t = nextLine.Split(" ");
    int n = int.Parse(t[0]);
    int l = int.Parse(t[1]);
    int[] list = new int[n];
    int min = int.MaxValue;
    int sum = 0;
    for(int i = 1; i <= n; i++) {
            list[i - 1] = i + l - 1;
            if(Math.Abs(min) > Math.Abs(list[i - 1])) {min = list[i - 1];}
            sum += list[i - 1];
    }
    Console.Writeline(sum - min);
}

static string check(int k) {
    for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                    int x = Math.Abs(arr[i] - arr[j]);
                    if (k < x) {
                            return ":(";
                    }
            }
    }
    return "Yay!";
}

public static void round(int val) {
    Console.Writeline(4*val*Math.Acos(0));
}

public static void negetiveRound(string[] args) throws IOException {
    int R = int.Parse(Console.ReadLine());
    Console.Writeline(2*R*Math.Acos(-1));
}

public static void round(int r){
  double PI = 2 * Math.Acos(0.0);
    Console.Writeline(2 * PI * r);
}

public static void d(int a, int b, int x ){
    if((double)2*x/(a*a)-b>=0){
        double bb=((double)2*x)/(a*a)-b;
        Console.Writeline(Math.Atan((-bb+b)/a)*180/Math.PI);
    }
    else{
        double aa=((double)2*x)/(a*b);
        Console.Writeline(Math.Atan(((double)b)/aa)*180/Math.PI);
    }
}

public static void findMaxPow(double a) {
    double two=Math.Sqrt(a);
    double three=Math.Cbrt(a);
    double four=Math.Pow(a,0.25);
    double five=Math.Pow(a,0.2);
    double unti[];
    unti=new double[4];
    unti[0]=Math.Floor(two);
    unti[1]=Math.Floor(three);
    unti[2]=Math.Floor(four);
    unti[3]=Math.Floor(five);
    double max=0;
    for(int i=0;i<4;i++){
         double jo=Math.Pow(unti[i],i+2);
        max=Math.Max(max,jo);
    }
    int ans=(int)max;
    Console.Writeline(ans);  
}

public static void adjustSqrt( double a){
    int aInt = (int) a;
    double sqrt = Math.Sqrt(a);
    double cbrt = Math.Cbrt(a);
    int ans = 0;
    int s = (int) sqrt;
    int s1 = s*s;
    int c = (int) cbrt;
    int c1 = c*c*c;
    if (s1 < c1){
      ans = c1;
    } else {
      ans = s1;
    }
    if (ans < 32 && 32 <= aInt){
      ans = 32;
    } else if (ans < 128 && 128 <= aInt){
      ans = 128;
    } else if (ans < 243 && 243 <= aInt){
      ans = 243;
    }
    Console.Writeline(ans);
}

public static void checkMid(int x, int y) {
    double turu = 2 * x - y / 2.0;
    double kame = y / 2.0 - x ;
    if (turu < 0 || kame < 0) {
        Console.Writeline("No");
        return;
    }
    if (Math.Ceiling(turu) == Math.Floor(turu) && Math.Ceiling(kame) == Math.Floor(kame)) {
        Console.Writeline("Yes");
    } else {
        Console.Writeline("No");
    }
}

void checkQuotient() {
    int D = sc.nextInt();
    int T = sc.nextInt();
    int S = sc.nextInt();
    int ans = (int)Math.Ceiling(1.0*D / S);
    if(ans <= T) {
            Console.Writeline("Yes");
    }else {
            Console.Writeline("No");
    }
}

static bool isInteger(double number){return Math.Ceiling(number) == Math.Floor(number); }

public static void checkQuotien(int d, int t, int s){
    Console.Writeline(Math.Ceiling((double)d / s) > t ? "No" :"Yes");
}
public static void toOdd(int n,int ar[])
        {
                Array.Sort(ar);
                if(n%2==1)
                {
                        Console.Writeline(0);
                }else {
                        int div=(int) Math.Ceiling(n/2);
                        Console.Writeline(ar[div]-ar[div-1]);
                }
        }

        public static void getV(int a , int b , int h , int m ){
            double degree = (30*h + 0.5*m) - 6*m;
            double distance = Math.Sqrt(a*a + b*b -2*a*b*Math.Cos((Math.PI/180)*degree));
            Console.Writeline(distance);
        }    

        public static void calcAngle(double A, double B, double H , double M ) {
            Console.Writeline(Math.Sqrt(A*A+B*B-2.0*A*B*Math.Cos(2.0*Math.PI*(H/12.0+M/12.0/60.0-M/60.0))));
        }

        static double calcAngle(double h, double m) 
    { 
        if (h <0 || m < 0 || h >12 || m > 60) 
            Console.Writeline("Wrong input"); 
        if (h == 12) 
            h = 0; 
        if (m == 60)  
            m = 0; 
        double hour_angle = (double)(0.5 * (h*60 + m)); 
        double minute_angle = (double)(6*m); 
        double angle = (double)Math.Abs(hour_angle - minute_angle); 
        angle = (double)Math.Min(360-angle, angle); 
        return angle; 
    } 

    public static void calcAngle()
    {
        double a=in.nextdouble(),b=in.nextdouble();
        double h=in.nextdouble(),m=in.nextdouble();
        double angle=Math.Abs(30*h - 11*m/2.0);
       double ans=(Math.PI/180)*angle;
        double c= Math.Sqrt(a*a + b*b - 2.0*a*b*Math.Cos(ans));
        Console.Writeline("{0:0.00000000000000000000}", c);
    }

    static double third_side(double a,  
                    double b, double c) 
    { 
        double angle =(double) Math.Cos((double)((Math.PI/180)*c));
        return (double)Math.Sqrt((a * a) + 
            (b * b) - 2 * a * b * angle); 
} 

public static void evenTenPow(int N) throws IOException {
    int result = 0;
    for(int i = 1; i <= N; i++) {
            if((int)Math.Floor(Math.Log10(i) + 1) % 2 == 1) {
                    result++;
            }
    }
    Console.Writeline(result);
    ;
}

public static void decimal(int n){
    double m=n/2;
    double k=Math.Floor(m);
    double l=(n-k)/n;
    Console.Writeline(l);
  }

  public static void evenTenPow(final int N) {
    long ans = 0;
    for(int i=N;i>0;i--){
        if(Math.Floor(Math.Log10(i))%2==0){
            ans++;
        }
    }
    Console.Writeline(ans);
}

int numberOfDigits(int n) {
    return (int) Math.Floor(Math.Log10(n)) + 1;
}

public static void halfDecimal(long N) {
    Console.Writeline((double)(N - Math.Floor(N/2)) / N);
}

public static void countTriangle(int n) {
 double d=s.nextdouble();
 int c=0;
 for(int i=0;i<n;i++)
 {
     int x=s.nextInt();
     int y=s.nextInt();
     long x1=x*x;
     long y1=y*y;
    double d1 = Double.Hypot(x, y);
     if(d1<=d)
     {
     c++;
     }
 }
 Console.Writeline(c);
}

public static bool triangle(int i,int[][] t){
    double max=Math.Max(Math.Max(t[i][0],t[i][1]),t[i][2]);
    double res=Math.Min(Math.Min(Double.Hypot(t[i][0],t[i][1]),Double.Hypot(t[i][0],t[i][2])),Double.Hypot(t[i][2],t[i][1]));
    if(res==max){return true;}
    else{return false;}
    }

    public static void getTickDistance(int A, int B , int H , int M) {
        double arg1 = 30 * H + 0.5 * M;
        double arg2 = 6 * M;
        double x1 = A * Math.Cos((Math.PI/180)*arg1);
        double y1 = A * Math.Sin((Math.PI/180)*arg1);
        double x2 = B * Math.Cos((Math.PI/180)*arg2);
        double y2 = B * Math.Sin((Math.PI/180)*arg2);
        Console.Writeline(Double.Hypot(x2 - x1, y2 - y1));
      }

      public void getTickDistance( double a, double b, double h, double m) {
        double x1 = a * Math.Cos((h + m / 60) / 12 * 2 * Math.PI);
        double y1 = a * Math.Sin((h + m / 60) / 12 * 2 * Math.PI);
        double x2 = b * Math.Cos(m / 60 * 2 * Math.PI);
        double y2 = b * Math.Sin(m / 60 * 2 * Math.PI);
        Console.WriteLine(Util.formatdouble(Double.Hypot(x1 - x2, y1 - y2)));
    }

    public static void isTriangle(int N, int D, long x, long y) {
        int count = 0;
        double distance = 0;
        for (int i = 0; i < N; i++ ) {
                x = sc.nextLong();
                y = sc.nextLong();
                distance = Double.Hypot(x, y);
                if (distance <= D) count++;
        }
        ;
        Console.Writeline(count);
}

    public static void triangle(int n , double d, int inputArray[]) {
  int c=0;
  for(int i=0;i<n;i++)
  {
      int x=inputArray[2*i];
      int y=inputArray[2*i + 1];
      long x1=x*x;
      long y1=y*y;
     double d1 = Double.Hypot(x, y);
      if(d1<=d)
      {
      c++;
      }
  }
  Console.Writeline(c);
    }

public static double log2(long N) 
{ 
    double result = (double)(Math.Log(N) / Math.Log(2)); 
    return result; 
}

static double log(double base,double antilogarithm){
    return Math.Log(antilogarithm)/Math.Log(base);
}

public SegmentTree(int n) {       
    int h = (int)Math.Ceiling((double)Math.Log(n)/Math.Log(2));
    this.size = (int)Math.Pow(2,h)*2-1;
    seg = new int[size];
}

static bool isPower(int a, int b)
    {
        double temp = Math.Log(a)/Math.Log(b);
        return temp == (int) temp;
    }

    static int bits(long x)
    {
        int n=(int)(Math.Floor(Math.Log(x)/Math.Log(2)))+1;
        return (1<<n);
}

public static void sqrLog(string[] args) throws IOException {
    long n = long.Parse(Console.ReadLine());
    long a = 1;
    for(int i=1; i<=Math.Sqrt(n); i++){
      if(n%i==0)
        a = n/i;
    }
    Console.Writeline((int)Math.Log10(a)+1);
  }

  private static int compareLog(long a, long b) {
    return Math.Max((int)(Math.Log10(a))+1, (int)(Math.Log10(b))+1);
}

private static int digits(long x) {
    return (int)Math.Log10(x)+1;
}

static int pow(int n) {
    return (int) (Math.Log10(n) / Math.Log10(2));
}

public static void countLog(int n) {
    int count = 0;
    for (int i = 1; i <= n; i++) {
        if(((int) Math.Log10(i) + 1) % 2 == 1) {
            count++;
        }
    }
    Console.Writeline(count);
}

static long max(long a, long b) {

    return Math.Max(a, b);
}

public static string largestSum(TestCase testCase) {
    List<int> L = testCase.L;
    int largest = 0;
    int sum = 0;
    foreach (var side in L) {
        largest = Math.Max(largest, side);
        sum += side;
    }
    return (largest < (sum - largest)) ? YES : NO;
}

static double max(double d, double e) {

    return Math.Max(d, e);
}

private static int getDifference(int n, int[] as) {
    int aMax = as[0];
    int aMin = as[0];
    foreach (var a in as) {
      aMax = Math.Max(aMax, a);
      aMin = Math.Min(aMin, a);
    }
    return aMax - aMin;
  }

  public void mergeSort( int n, int[] arr ) throws IOException {
    for (int i = 0; i < n; i++) {
        arr[i] = in.nextInt();
    }
    int[] right = new int[n];
    int[] left = new int[n];
    right[n-1] = 0;
    left[0] = 0;
    for (int i = n-2; i >= 0; i--) {
        right[i] = Math.Max(arr[i+1], right[i+1]);
    }
    for (int i = 1; i < n; i++) {
        left[i] = Math.Max(arr[i-1], left[i-1]);
    }
    for (int i = 0; i < n; i++) {
        Console.WriteLine(Math.Max(right[i], left[i]));
    }
}

static long min(long n,long m)
    {
        return Math.Min(n,m);
    }

    public static void getDifference(string s , int min , int max) {
        for(int i = 0; i < s.Length; i++) {
                if('A'==s[i]) {
                        min = Math.Min(min, i);
                }
                if('Z'==s[i]) {
                        max = Math.Max(max, i);
                }
        }
        Console.Writeline((max - min) + 1);
}

public int minGap(int n, int[] height) {
    int pre = 0;
    int cur = 0;
    if(n <= 1)
        return 0;
    pre = 0;
    cur = Math.Abs(height[1] - height[0]);
    for(int i = 2; i < n; i++){
        int t = Math.Min(cur + Math.Abs(height[i] - height[i-1]),
                        pre + Math.Abs(height[i] - height[i-2]));
        pre = cur;
        cur = t;
    }
    return cur;
}

static int minGap(int n,int arr[]) {
    int dp[] = new int[n];
    dp[0] = 0;
    for(int i=1;i<n;i++) {
            int ans = 0;
            if(i-1>=0) {
                    ans = Math.Abs(arr[i]-arr[i-1])+dp[i-1];
            }
            if(i-2>=0) {
                    ans = Math.Min(ans, Math.Abs(arr[i]-arr[i-2])+dp[i-2]);
            }
            dp[i] = ans;
    }
    return dp[n-1];
}


public static void minGap()throws IOException
{
    int n=ni();
    int[]A=nai(n);
    int[]dp=new int[n];
    dp[0]=0;
    dp[1]=Math.Abs(A[0]-A[1]);
    for(int i=2;i<n;i++)
        dp[i]=Math.Min(dp[i-1]+Math.Abs(A[i-1]-A[i]),dp[i-2]+Math.Abs(A[i-2]-A[i]));
    pn(dp[n-1]);
}

public static void countSmallDist (int n, double d, int inputX[], int inputY[]) throws Exception
{
        int count = 0;
        while(n-- >0){
                int x = input[n];
                int y = input[n];
                double dis = Math.Sqrt(Math.Pow(x,2)+Math.Pow(y,2));
                if(dis<=d){
                        count++;
                }
        }
        Console.Writeline(count);
}

public static void countBigDist(int N, int D, int inputX[], int inputY[]) throws Exception {
    int count = 0;
    for(int i = 0; i < N; i++){
        int x = inputX[i];
        int y = inputY[i];
        double d = (Math.Pow(x, 2) + Math.Pow(y, 2));
        if(Math.Pow(D, 2) >= d) count++;
    }
    Console.Writeline(count);
}

void countSmallDist(int n, double d, int inputX[], int inputY[])
    {
        int c=0;
        while(n-->0)
        {
            int x = input[n];
            int y = input[n];
            double sp=Math.Sqrt(Math.Pow(x,2)+Math.Pow(y,2));
            if(sp<=d)
            c++;
        }
        Console.WriteLine(c);
    }

    public static bool isExpN(long a,int base){
        int x=1;
        while((int)Math.Pow(x, 2) <= a){
                if((int)Math.Pow(x, 2) == a){
                        return true;
                }
                x*=base;
        }
        return false;
}

public static void sumPow(int K, int inputArray[]){
    int sum = 0;
    List<int> a = new List<int>();
    for (int i = 0; i < K; i++) {
    int d = inputArray[i];
            a.Add(d);
    }
    a.Sort();
    a.Reverse();
    for(int i=0; i<a.Count;i++)
    {
            sum += (Math.Pow((-1),(i)))*(a[i]);
    }
    Console.Writeline(sum);
}

public static void pow100(int D, int N) {
    if(D == 0&&N == 100){
            Console.Writeline(101);
    }else if(D == 1&&N == 100){
            Console.Writeline(10100);
    }else if(D == 2&&N ==100){
            Console.Writeline(1010000);
    }else{
            Console.Writeline(Math.Round(N * Math.Pow(100,D)));
    }
}

public static void pow100(string[] line) {
    final int a = int.Parse(line[0]);
    final int b = int.Parse(line[1]);
    final long pow = Math.Round(Math.Pow(100, a));
    if (b <= 99) {
        Console.Writeline(b * pow);
    } else {
        Console.Writeline(101 * pow);
    }
}

public static void intDevide(int A, int B , int t ) {
    int T = (int) Math.Round(t + 0.5);
    int b = 0;
    for (int t = 1; t < T; t++) {
        if (t % A == 0) {
            b += B;
        }
    }
    Console.Writeline(b);
}

public static void maxPow(double a){
    double ans = 0;
    for(double i = 6; i > 0;i--){
      if(a >= Math.Pow(2,i)){
        ans = Math.Pow(2,i);
        break;
      }
    }
    if(a == 1){
      ans = 1;
    }
    Console.Writeline(Math.Round(ans));
  }

  public static void maxPow(int N ) {
    int N = scan.nextInt();
    int n = 0;
    while (Math.Pow(2,n + 1) <= N ) {
      n = n + 1;
    } 
      Console.Writeline(Math.Round(Math.Pow(2,n)));
}

public static void getTickDistance(double a , double b , double h , double m) {
    double mm = -(Math.PI/180)*m*6;
    double hh = -(Math.PI/180)*(h+m/60)*30;
    double x = Math.Cos(hh)*a-Math.Cos(mm)*b;
    double y = Math.Sin(hh)*a-Math.Sin(mm)*b;
    Console.Writeline(Math.Sqrt(x*x+y*y));
}

private static Point point(double r, double deg) {
    double x = r * Math.Sin(deg);
    double y = r * Math.Cos(deg);
    return new Point(x, y);
}

public Point(double deg, double r) {
    double rad = deg * Math.PI / 180.0;
    x = Math.Cos(rad) * r;
    y = Math.Sin(rad) * r;
  }

  public static double dist(int x1, int b, double angle){
    double x2=b*Math.Cos(angle), y2=b*Math.Sin(angle);
    return Math.Sqrt(Math.Pow((x2-x1), 2)+y2*y2);
}

public void getTickDistance( ) {
    double a = Console.ReadLine(), b = Console.ReadLine();
    double h = Console.ReadLine(), m = Console.ReadLine();
    double x1 = a * Math.Cos((h + m / 60) / 12 * 2 * Math.PI);
    double y1 = a * Math.Sin((h + m / 60) / 12 * 2 * Math.PI);
    double x2 = b * Math.Cos(m / 60 * 2 * Math.PI);
    double y2 = b * Math.Sin(m / 60 * 2 * Math.PI);
    Console.WriteLine(Util.formatdouble(Double.Hypot(x1 - x2, y1 - y2)));
}

private static void getTickDistance(){
    double A = nd();
    double B = nd();
    double H = nd();
    double M = nd();
    double ang = 30D * H + 0.5D * M - 6D * M;
    double asin = A * Math.Sin((Math.PI/180)*ang);
    double acos = A * Math.Cos((Math.PI/180)*ang);
    double height = asin;
    double width = B - acos;
    Console.Writeline(Math.Sqrt(height * height + width * width));
}

private static bool isPrime(int n) {
    if (n == 2)
        return true;
    else if ((n % 2 == 0 && n > 2) || n < 2)
        return false;
    else {
        for (int i = 3; i <= (int) Math.Sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}

static List<int> primeList(int n){
    List<int> list = new List<int>();
    bool[] prime = new bool[n + 1];
    Array.Fill(prime, true);
    prime[0] = false;
    prime[1] = false;
    for (int i = 2; i < Math.Sqrt(n); i++){
      if (!prime[i]){continue;}
      for (int j = 2; i * j <= n; j++){
        prime[i * j] = false;
      }
    }
    for (int i = 0; i < prime.Length; i++){
      if (prime[i]){list.Add(i);}
    }
    return list;
  }

  static bool isPrime (int n) {
    if (n==2) return true;
    if (n<2 || n%2==0) return false;
    double d = Math.Sqrt(n);
    for (int i=3; i<=d; i+=2)if(n%i==0){return false;}
    return true;
}

public void nTimesSum( int N) {
    int max = (int) Math.Sqrt(N) + 1;
    int sn = 0;
    string s = "" + N;
    for (int i = 0; i < s.Length; i++) {
        sn += int.Parse("" + s[i]);
    }
    Console.WriteLine(N % sn == 0 ? "Yes" : "No");
}

public static bool[] sieve(long n)
    {
        bool[] prime = new bool[(int)n+1];
        Array.Fill(prime,true);
        prime[0] = false;
        prime[1] = false;
        long m = (long)Math.Sqrt(n);
        for(int i=2;i<=m;i++)
        {
            if(prime[i])
            {
                for(int k=i*i;k<=n;k+=i)
                {
                    prime[k] = false;
                }
            }
        }
        return prime;
    } 

    public static void checkMapSize(string nextLine) {
        string[] arr = nextLine.Split(" ");
        ;
        Dictionary<int, int> countDictionary = new Dictionary<int, int>();
        foreach (var val in arr) {
            int count = countDictionary[int.Parse(val)];
            if (count is null) {
                countDictionary[int.Parse(val)] = 0;
            }else{
            countDictionary[int.Parse(val)] = count++;
            }
        }
        if (countDictionary.Count == 2) {
            Console.Writeline("Yes");
        } else {
            Console.Writeline("No");
        }
    }

    public static void string2Map(int N) {
        Dictionary<int, int> resultDictionary = new Dictionary<int, int>();
        for (int i = 1; i < N; i++) {
            int boss = sc.nextInt();
            int count = resultDictionary[boss];
            if (count is null) {
                count = 1;
            } else {
                count += 1;
            }
            resultDictionary[boss] = count;
        }
        for (int i = 1; i <= N; i++) {
            int val = resultDictionary[i];
            if (val is null) {
                Console.Writeline(0);
            } else {
                Console.Writeline(val);
            }
        }
    }  

    public static void getMaxMultiple4(int a , int b , int c , int d) {
        long ac = (long)a*c;
        long ad = (long)a*d;
        long bc = (long)b*c;
        long bd = (long)b*d;
        long? max = new List<long>(new[] {ac,ad,bc,bd}).Max(Comparator.naturalOrder());
        Console.Writeline(max);
}

public static double calculate(double base, double n) {
    return Math.Pow(Math.E, Math.Log(base)/n);
}

public static void areaAndCircumference(double r) {
    double area = r * r * Math.PI;
    double circumference = r * 2 * Math.PI;
    Console.WriteLine("%f %f\n", area, circumference);
  }

  public static void areaAndCircumference(double r) {
    double area = Math.PI * r * r;
    double circumference = 2 * Math.PI * r;
    string areastr = String.Format("%.6f", area);
    string circumferencestr = String.Format("%.6f", circumference);
    Console.Writeline(areastr + " " + circumferencestr);
}

public static void areaAndCircumference(double r){
    Formatter frm=new Formatter();
    double S=Math.PI*r*r*1.0;
    double d=2*Math.PI*r*1.0;
    Console.Writeline(String.Format("%5f",S)+" "+String.Format("%5f",d));
}

private static double cal_area(double r){
    double pi = Math.PI;
    return (r * r * pi);
}

private static double cal_cirum(double r){
    double pi = Math.PI;
    return (2 * r * pi);
}

private int getDifference(int n, int inputArray[]) {
    int n = in.nextInt();
    int min = int.MaxValue;
    int max = int.MaxValue;
    for (int i = 0; i < n; i++) {
        int x = inputArray[i];
        min = Math.Min(min, x);
        max = Math.Max(max, x);
    }

    return max - min;
}

public static void getDifference(int n, int[] args) throws IOException {
    int min = int.MaxValue;
    int max = int.MaxValue;
    for (int i = 0; i < n; i++) {
        int value = args[i];
        if (value > max) {
            max = value;
        }
        if (value < min) {
            min = value;
        }
    }
    Console.WriteLine(max - min);
}

public int nextInt() {
    long nl = nextLong();
    if (nl < int.MaxValue || nl > int.MaxValue) throw new Exception();
    return (int) nl;
}

public static void cal(string[] args) throws IOException {
    int N = readInt(), X = readInt(), min = int.MaxValue; for(int i = 1; i<=N; i++) {
            int k = readInt(); X-=k; min = Math.Min(k, min);
    }
     Console.WriteLine(N + X/min);
    exit();
}

public static void findMaxv(int n, int minv, int inputArray[]){
    int maxv = int.MaxValue;
    for(int i=1;i<n;i++){
       int in = inputArray[i];
       maxv = Math.Max(maxv, in-minv);
       minv = Math.Min(minv, in);
    }
    Console.Writeline(maxv);
}

public List<int> gerPrimes() {
    return Collections.unmodifiableList(primes);
}

static int countGreater(LinkedList<int> q) {
    int size = q.Count;
    int count = 0;
    size/=2;
    while (size-->0) {
        int first = q.First();
        q.Remove(First());
        int second = q.First();
        q.Remove(First());
        if(first+second>=10) count++;
        int newValue = (first+second)%10;
        q.AddLast(newValue);
    }
    return count;
}

static void bfs(int s)
{
    vis[s] = true;
    Queue<int> q = new LinkedList<int>();
    q.Add(s);
    color[s] = 1;
    level[s] = 0;
    p[s] = s;
    while(q.Count>0)
    {
        int cc = q.Dequeue();
        Iterator itr = hs[cc].iterator();
        while(itr.hasNext())
        {
            int e = (int) itr.next();
            if(!vis[e])
            {
               
                q.Add(e);
                p[e] = cc;
                if(color[cc]==1)
                    color[e] = 2;
                else
                    color[e] = 1;
                level[e] = level[cc]+1;
                vis[e] = true;
            }
        }
    }   
}

public static void subMax(int N, int inputArray[]) {
    LinkedListList<int> list = new LinkedList<int>();
    int max = 0;
    int order = 0;
    for (int i = 0; i < N; i++) {
            int num = input[i];
            if (max < num) {
                    max = num;
                    order = i;
            }
            list.Add(num);
    }
    list.Sort();
    int submax = list.get(list.Count - 2);
    for (int i = 0; i < N; i++) {
                    Console.Writeline(i == order ? submax : max);
    }
}

public static void differentNext(char[] s) {
    LinkedList<char> ans = new LinkedList<char>();
    ans.Add(s[0]);
    for(int i = 0;i<s.Length - 1;i++){
        if(s[i] != s[i + 1]){
            ans.Add(s[i + 1]);
        }
    }
    Console.Writeline(ans.Count);
}

public static void top2Bot(int n, string str) {
    Stack<char> stack = new Stack<char>();
    for (int i = 0; i < str.Length; i++) {
        char c = str[i];
        while (stack.Count != 0 && stack.First() == c) {
                stack.Pop();
            }
            stack.Push(c);
    }
    Console.Writeline(stack.Count);
}

public static void count0(LinkedList<string> list) {
    int ans = 0;
    for (int i = 0; i < list.Count; i++) {
            if (list[i].Equals("0")) {
                    ans = i + 1;
            }
    }
    Console.Writeline(ans);
}

public void differentNext() throws Exception{
    final int N = sc.nextInt();
    final string[] S = new string[N+1];
    for(int i=0;i<N;i++) {
            S[i] = sc.next();
    }
    S[N] = "";
    Array.Sort(S, 0, N);
    int max = 0;
    int cnt = 1;
    LinkedList<string> list = new LinkedList<string>();
    for(int i=1;i<N+1;i++) {
            if(!S[i-1].Equals(S[i])) {
                    if(max < cnt) {
                            list.Clear();
                            max = cnt;
                            list.Add(S[i-1]);
                    }else if (max == cnt){
                            list.Add(S[i-1]);
                    }
                    cnt = 1;
            }else {
                    cnt++;
            }
    }
    foreach(var s in list) {
            Console.WriteLine(s);
    }
}

public static void allContainPos(int n, string[] args){
    Dictionary<string,int> map = new Dictionary<string,int>();
    LinkedList<string> array = new LinkedList<string>();
    int max = 1;
    for(int i = 0; i < n; i++){
      string s = args[i];
      int tmp = 1;
      if(map.ContainsKey(s)){
        tmp = map[s]+1;
      }
      map[s] = tmp;
      if(tmp == max){
        array.Add(s);
      } 
      else if(tmp > max){
        max = tmp;
        array.Clear();
        array.Add(s);
      }
    }
    array.sort(Comparator.naturalOrder());
    foreach(string value in array)
        {
      Console.Writeline(value);
        }
  }

  public int getTimes(int[] hs, int height, int start, int end) {
    if (start > end) {
            return 0;
    } else if (start == end) {
            return hs[start] - height;
    }
     LinkedList<int> list = new LinkedList<int>();
    int min = int.MaxValue;
    for (int i=start; i<=end; i++) {
            if (hs[i] < min) {
                    min = hs[i];
                    list.Clear();
                    list.Add(i);
            } else if (hs[i] == min) {
                    list.Add(i);
            }
    }
    int result = min - height; 
    int nextIndex = start;
    foreach (var x in list) {
            result += getTimes(hs, min, nextIndex, x-1);
            nextIndex = x+1;
    }
    result += getTimes(hs, min, nextIndex, end);
    return result;
}

public static void compareFirst(int n, string[] args) {
    LinkedHashSet<string> lhs = new LinkedHashSet<string>();
    LinkedList<string> ll = new LinkedList<string>();
    int f = 0;
    while(n-- != 0)
    {
        string s = args[i];
        if(lhs.Contains(s))
        f = 1;
        lhs.Add(s);
    }
    if(f == 1)
    Console.Writeline("No");
    else
    {
        foreach (var item in lhs)
        {
            ll.AddLast(str)
        }
        for(int i = 0;i < ll.Count - 1;i++)
        {
            string s1 = ll[i];
            string s2 = ll.get(i + 1);
            if(s1[s1.Length - 1] != s2[0])
            {
            f = 1;
            break;
            }
        }
        if(f == 1)
        Console.Writeline("No");
        else
        Console.Writeline("Yes");
    }
}

public static void lineUp( int n, int q, string nameArray[], int timeArray[]){
    LinkedList<string> name=new LinkedList<string>();
    LinkedList<int> time=new LinkedList<int>();
    int t=0;
    for(int i=0;i<n;i++){
            name.Add(nameArray[i]);
            time.Add(timeArray[i]);
    }
    while(name.Count != 0){
            if(time.First()<=q){
                    Console.Writeline(name.Dequeue()+" ");
                    t=t+time.Dequeue();
                    Console.Writeline(t);
            }else{
                    name.Add(name.Dequeue());
                    time.Add(time.Dequeue()-q);
                    t=t+q;
            }
    }
}

    void radix26() {
            long N = sc.nextLong() - 1;
            LinkedList<int> stack = new LinkedList<int>();
            while(N >= 0) {
                    stack.Push((int)(N % 26));
                    N -= 26;
                    if(N < 0) break;
                    N /= 26;
            }
            while(stack.Count != 0) {
                    int c = stack.First();
                    stack.Remove(First());
                    Console.Writeline((char)(c + 'a'));
            }
    }

    static void radix26() throws Exception{
        LinkedList<int>ans=new LinkedList<int>();
        long n=sc.nextLong();
        while(n>0) {
                n--;
                ans.AddFirst((int)(n%26));
                n/=26;
        }
        while(ans.Count != 0) {
                pw.print((char)(ans.Dequeue()+'a'));
        }
}


public static void calWaitingTime(int n, int q, string nameArray[], int timeArray[]){
    LinkedList<Pair> queue = new LinkedList<Pair>();
    int time_w = 0;
    for(int i=0; i<n; i++){
        string str = nameArray[i];
        int time = timeArray[i];
        if(time > q){
            time_w += q;
            queue.Add(new Pair(str, time-q));
        }else{
            time_w += time;
            Console.Writeline(str+" "+time_w);
        }
    }
    while(queue.Count != 0){
        Pair p = queue.Dequeue();
        string str = p.name;
        int time = p.left;
        if(time > q){
            time_w += q;
            queue.Add(new Pair(str, time-q));
        }else{
            time_w += time;
            Console.Writeline(str+" "+time_w);
        }
    }
}

public static void calWaitingTime(string first, Stack<string> args) {
    string[] components = first.Split(" ");
    int inputs = int.Parse(components[0]);
    int quantum = int.Parse(components[1]);
    int time = 0;
    LinkedList<Process> q = new LinkedList<Process>();
    while (args.Count > 0) {
            string i = args.First();
            args.Pop();
            string[] c = i.Split(" ");
            q.Add(new Process(c[0], int.Parse(c[1])));
    }
    while (q.Count != 0) {
            Process curr = q.Dequeue();
            if (curr.t <= quantum) {
                    time += curr.t;
                    Console.Writeline(curr.n + " " + time);
            } else {
                    curr.t -= quantum;
                    time += quantum;
                    q.Add(curr);
            }
    }
}

    public static void checkAns( string str, string ans){
            int count = 0;
            int max = 0;
            LinkedList<string> word = new LinkedList<string>();
            LinkedList<string> Ans = new LinkedList<string>();
            for (int i = 0; i < str.Length; i++) {
                string str2 = str[i].ToString();
                string ans2 = ans[i].ToString();
                word.Add(str2);
                Ans.Add(ans2);
            }
            for(int i=0; i<str.Length; i++){
                    word.AddFirst(word.Last());
                    word.RemoveLast();
                    if(word.Equals(Ans)){
                            Console.Writeline("Yes");
                            return;
                    }
            }
            Console.Writeline("No");
    }

    public static void calculator(LinkedList<string> input) {
        LinkedList<int> stack = new LinkedList<int>();
        while(input.Count != 0){
                string ops = input.Dequeue();
                if("+".Equals(ops)){
                        final int a = stack.Dequeue();
                        final int b = stack.Dequeue();
                        stack.AddFirst(b + a);
                }else if("-".Equals(ops)){
                        final int a = stack.Dequeue();
                        final int b = stack.Dequeue();
                        stack.AddFirst(b - a);
                }else if("*".Equals(ops)){
                        final int a = stack.Dequeue();
                        final int b = stack.Dequeue();
                        stack.AddFirst(b * a);
                }else if("/".Equals(ops)){
                        final int a = stack.Dequeue();
                        final int b = stack.Dequeue();
                        stack.AddFirst(b / a);
                }else{
                        stack.AddFirst(int.Parse(ops));
                }
        }
        Console.Writeline(stack.Dequeue());
}

public static LinkedList<long> divisors(long N){
    LinkedList<long> ans = new LinkedList<long>();
    for(long n = (long)(Math.Sqrt(N)+2); n>0; n--){
        if(n*n>N) continue;
        else if(n*n==N) ans.Add(n);
        else if(N%n==0){
            ans.AddFirst(n);
            ans.AddLast(N/n);
        }
    }
    return ans;
}


public static void getMean(int N, double inputArray[]) {
    LinkedList<double> v = new LinkedList<double>();
    for (int i = 0; i < N; i++) {
      v.Add(inputArray[i]);
    }
    v.Sort();
    while (v.Count > 1) {
      double a = v.Dequeue();
      double b = v.Dequeue();
      v.AddFirst((a + b) / 2.0);
    }
    Console.Writeline(v.First());
  }

  void radix26(long n) {
    LinkedList<string> ans = new LinkedList<string>();
    do {
        n--;
        ans.AddFirst("" + (char)('a' + n % 26));
        n /= 26;
    } while (n != 0);
}

static int countCarry(LinkedList<int> q) {
    int size = q.Count;
    int count = 0;
    size/=2;
    while (size-->0) {
        int first = q.First();
        q.Remove(First());
        int second = q.First();
        q.Remove(First());
        if(first+second>=10) count++;
        int newValue = (first+second)%10;
        q.AddLast(newValue);
    }
    return count;
}

public static LinkedList<int> comp(LinkedList<int> q){
    LinkedList<int> op = new LinkedList<int>();
    Stack<int> stack = new Stack<int>();
    while(q.Count>0){
            stack.Push(q.Pop());
    }
    while(stack.Count>0){
            op.AddLast(stack.Pop());
    }
    return op;
}

public static LinkedList<long> divisors(long N){
    LinkedList<long> ans = new LinkedList<long>();
    for(long n = (long)(Math.Sqrt(N)+2); n>0; n--){
        if(n*n>N) continue;
        else if(n*n==N) ans.Add(n);
        else if(N%n==0){
            ans.AddFirst(n);
            ans.AddLast(N/n);
        }
    }
    return ans;
}

public static void checkLast( string s ) {
    string s = sc.next();
    LinkedList<char> display = new LinkedList<char>();
    for(int i=0;i<s.Length;i++){
            if(s[i]=='B') display.DequeueLast();
            else display.AddLast(s[i]);
    }
    foreach(var c in display) Console.Writeline(c);
    Console.Writeline();
}

public int checkLast(string S) {
    int ans = 0;
    LinkedList<int> list = new LinkedList();
    foreach (var c in S.ToCharArray()) {
      int i = (int) c - ZERO;
      if (list.Count == 0) {
        list.AddLast(i);
      } else {
        if (list.Last() != i) {
          list.RemoveLast();
          ans += 2;
        } else {
          list.AddLast(i);
        }
      }
    }
    return ans;
  }

  public void push(int item) {
    stack.AddLast(item);
}

static void seive() {
    for (int i = 2; i < 100001; i++) {
        if (!v[i]) {
            t++;
            l.Add(i);
            for (int j = 2 * i; j < 100001; j += i)
                v[j] = true;
        }
    }
}

static void shuffle(int a[]) {
    List<int> l = new List<int>();
    for (int i = 0; i < a.Length; i++)
        l.Add(a[i]);
    Collections.shuffle(l);
    for (int i = 0; i < a.Length; i++)
        a[i] = l[i];
}

static int countCarry(LinkedList<int> q) {
    int size = q.Count;
    int count = 0;
    size/=2;
    while (size-->0) {
        int first = q.First();
        q.Remove(First());
        int second = q.First();
        q.Remove(First());
        if(first+second>=10) count++;
        int newValue = (first+second)%10;
        q.AddLast(newValue);
    }
    return count;
}

public static void mergeStr(int iNum, string sStr ) {
    string[] sSplitStr = sStr.Split(" ");
    string s1 = sSplitStr[0];
    string s2 = sSplitStr[1];
    string[] s1Split = s1.Split("");
    string[] s2Split = s2.Split("");
    List<string> listStr = new LinkedList<string>();
    for (int i = 0; i < iNum; i++) {
      listStr.Add(s1Split[i]);
      listStr.Add(s2Split[i]);
    }
    StringBuilder sb = new StringBuilder();
    foreach (var str in listStr) {
      sb.Append(str);
    }
    Console.WriteLine(sb.ToString());
  }

  public static void compList(string s , string t) throws Exception {
    List <string> sList = new LinkedList<string>(new LinkedList<string>(t.Split("")));
    List <string> tList = new LinkedList<string>(new LinkedList<string>(s.Split("")));
    int flag = 0;
    int n = tList.Count;
    for(int i = 0; i < n; i++){
        string a = tList.RemoveAt(n-1);
        tList.Add(0,a);
        if(tList.Equals(sList)){
            flag = 1;
            break;
        }
    }
    if(flag == 1) Console.Writeline("Yes");
    else Console.Writeline("No");
}

public static void compList(string s) {
    string[] sArray = s.Split("");
    LinkedList<string> ansList = new LinkedList<string>();
    for(int i = 0; i < s.Length; i++){
            if(sArray[i].Equals("1")) {
                    ansList.Add("1");
            } else if(sArray[i].Equals("0")) {
                    ansList.Add("0");
            } else if(sArray[i].Equals("B") && ansList.Count != 0){
                    ansList.RemoveLast();
            }
    }
    foreach(var ans in ansList){
            Console.Writeline(ans);
    }
}

void graphInput(int n)
 {
    for(int i = 0;i < n;i++)
    {
        int a = ni();
        int b = ni();

        if(!graph.ContainsKey(a))
        {
            List<int> l = new List<int>();
            l.Add(b);
            graph[a] = l;
        }
        else
            graph[a].Add(b);
    }
    Console.Writeline(graph);
}

public static void checkEven(string w){
    string result = "Yes";
    List<string> wArray = new LinkedList<string>();
    HashSet<string> wSet = new HashSet<string>();
    for(int i = 0; i < w.Length; i++){
        string word = w[i].ToString();
        wArray.Add(word);
        wSet.Add(word);
    }
    foreach(var str in wSet){
        int counter = 0;
        while(wArray.Contains(str)){
            wArray.Remove(str);
            counter++;
        }
        if(counter % 2 != 0){
            result = "No";
            break;
        }
    }
    Console.Writeline(result);
}

public static void count0(LinkedList<string> list) {
    int ans = 0;
    for (int i = 0; i < list.Count; i++) {
            if (list[i].Equals("0")) {
                    ans = i + 1;
            }
    }
    Console.Writeline(ans);
}

public static void countEqual(string anticipation , string real) {
    List<string> AList = new List<string>(anticipation.Split(""));
    List<string> RList = new List<string>(real.Split(""));
    int count = 0;
    for (int i = 0; i < 3; i++) {
            string a = AList[i];
            string r = RList[i];

            if (a.Equals(r)) {
                    count++;
            }
    }
    Console.Writeline(count);
}
static List<string> myconv(string str, int no){//only split
    string splitstring = CONVSTR.Substring(no,1);
    return new List<string>(str.Split(splitstring));
}
static List<int> inputIntList() throws Exception {
    List<string> strList = new List<int>(Console.ReadLine()().Trim().Split(" "));
    List<int> intList = new List<int>();
    foreach (var elem in strList){
        intList.Add(int.Parse(elem));
    }
    return intList;
}

public static void morePositiveNums(int[] lines) {
    List<int> list = new List<int>(lines);
    if(list.Max() >= sum(list)) {
        Console.Writeline("No");
    } else {
        Console.Writeline("Yes");
    }
}

public static void cal(int a, int b, int c){
    List <int> list = new List<int>{a, b, c};
    list.Sort();
    Console.Writeline((int)(list.First() + list[1] + list[2] * Math.Pow(2, sc.nextInt())));
  }

public static void getLastUpper(string A, string B, string C){
    a.addAll(A.Split(""));
    b.addAll(B.Split(""));
    c.addAll(C.Split(""));
    string lastValue = "a";
    string ans = "";
    while(true) {
    lastValue = syori(lastValue);
    if(Char.IsUpper(lastValue[0])) {
        ans = lastValue;
        break;
    }
}
    Console.Writeline(ans);
}

    public static void getCalMax(int A , int B) {
        List<int> resultList = new List<int>();
        foreach (var str in { A+B, A-B, A*B }) resultList.AddLast(str);
        int max = -100;
        for (int i=0; i<resultList.Count; i++) {
            max = Math.Max(max, resultList[i]);
        }
        Console.Writeline(max);
    }

    private void perm(int[] a, int cur, List<int> tmp, List<List<int>> list) {
        if (cur == a.Length) {
            List<int> res = new List<int>();
            foreach(var item in tmp) res.AddLast(item);
            list.Add(res);
            return;
        }
        for (int i = cur; i < a.Length; ++i) {
            swap(a, i, cur);
            tmp.Add(a[cur]);
            perm(a, cur + 1, tmp, list);
            tmp.RemoveAt(tmp.Count - 1);
            swap(a, i, cur);
        }
    }

    public static List<string> getStrOnLine() throws IOException {
        List<string> list = new List<string>();
        string line = getLine();
        
        foreach (var str in line.Split(" ")) list.AddLast(str);
        return list;
    }

    private static void makePrimeList(int n) {
        List<int> searchList = new List<int>();
        for (int i = 2; i <= n; ++i) {
            searchList.Add(i);
        }
        primeList = new List<int>(n);
        do {
            int prime = searchList.RemoveAt(0);
            primeList.Add(prime);
            int i = 2;
            while (prime * i <= n) {
                searchList.RemoveAt((int)(prime * i));
                ++i;
            }
        } while (searchList.Count > 0 && searchList.First() <= Math.Sqrt(n));
        foreach (var item in searchList)
        {
            primeList.AddLast(item);
        }
    }

    public static void intArrayListPrint(List<int> list) {
        for (int i = 0; i < list.Count; i++) {
            Console.Writeline(list[i]);  
        }
    }

    static List<long> nextLongArray(){
        List<string> input = nextStrArray(); List<long> ret = new List<long>(input.Count);
        for(int i = 0; i < input.Count; i++){
                ret.Add(long.Parse(input[i]));
        }
        return ret;
}

static List<int> nextIntArray(){
    List<string> input = nextStrArray(); List<int> ret = new List<int>(input.Count);
    for(int i = 0; i < input.Count; i++){
            ret.Add(int.Parse(input[i]));
    }
    return ret;
}

public static bool isDrawPolygon(List<int> sideList) {
    int sum = 0;
    for(int i = 1; i < sideList.Count; i++) {
      sum += sideList[i];
    }
    return sideList.First() < sum ? true : false;
  }


  public static void getAllCase(string[] args) throws Exception, IOException {
    List<int> arrPost = new List<int>();
    while(true) {
            int n = int.Parse(Console.ReadLine());
            if(n == 0)      break;
            else            arrPost.Add(n);
    }
    for(int i = 0; i < arrPost.Count; i++) Console.Writeline("Case " + (i + 1) + ": " + arrPost[i]);
}

public static void checkEvenCount(string w){
    string result = "Yes";
    List<string> wArray = new LinkedList<string>();
    HashSet<string> wSet = new HashSet<string>();

    for(int i = 0; i < w.Length; i++){
        string word = w[i].ToString();
        wArray.Add(word);
        wSet.Add(word);
    }
    foreach(string str in wSet){
        int counter = 0;
        while(wArray.Contains(str)){
            wArray.Remove(str);
            counter++;
        }
        if(counter % 2 != 0){
            result = "No";
            break;
        }
    }
    Console.Writeline(result);
}

public static void findMiddle(string args[]) throws java.lang.Exception
        {
                string h[]=Console.ReadLine().Split(" ");
                string hh[]=new string[0];
                if(int.Parse(h[1])!=0){hh=Console.ReadLine().Split(" ");}
                HashSet<int>hash=new HashSet<int>();
                for(int i=0;i<hh.Length;i++){hash.Add(int.Parse(hh[i]));}
                int x=int.Parse(h[0]);
                int x1=x;
                int ans=0;
                while(true)
                {
                        if(!hash.Contains(x1)){ans=x1;break;}
                        x1++;
                }
                x1=x-1;
                while(true)
                {
                        if(!hash.Contains(x1)){if(x-x1<=ans-x){ans=x1;}break;}
                        x1--;
                }
                Console.Writeline(ans);
        }

        public static void checkValid(int N, string wordsInput, string args[]) {
            LinkedList<string> words = new LinkedList<string>();
            words.Add(wordsInput);
            bool valid = true;
            for (int i = 1; i < N; i++) {
                    string x = args[i];
                    string prev = words[i - 1];
                    if (words.Contains(x)||x[0]!=prev.[^1]) {
                            valid = false;
                            break;
                    }
                    words.Add(x);
            }
            Console.Writeline(valid? "Yes":"No");
    }

    public static void getContainsX(int numA , int numB , int numC) {
        List<int> numAList = getNums(numA);
        List<int> numBList = getNums(numB);
        List<int> commonList = new List<int>();
        foreach (int num in numAList) {
            if (numBList.Contains(num)) {
                commonList.Add(num);
            }
        }
        commonList.Sort((x, y) => -x.CompareTo(y));
        Console.Writeline(commonList[numC- 1]);
    }

    public static void calculate(int s) {
        LinkedList<int> a = new LinkedList<int>();
        a.Add(s);
        for (int i=0; i<=1000000; i++){
        int a_next;
        if (a[i]%2 == 0){
                a_next = a[i]/2;
        }else {
                a_next = 3*a[i]+1;
        }
        if (a.Contains(a_next)){
                Console.Writeline(i+2);
                return;
        }else {
                a.Add(a_next);
        }
}
}

public static void findNotContains(int x, int n, int inputArray[]){
    LinkedList<int> l=new LinkedList<int>();
    for(int i=0;i<n;i++) {
            l.Add(inputArray[i]);
    }
    for(int i=0;true;i++) {
            if(!l.Contains(x-i)) {
                    Console.Writeline(x-i);
                    break;
            }
            else if(!l.Contains(x+i)) {
                    Console.Writeline(x+i);
                    break;
            }
    }
}

public List<int> gerPrimes() {
    return Collections.unmodifiableList(primes);
}

public static void queueTime(int n,int q, string[] inputPS, int[] inputPT ){
    int t=0;
    LinkedList<Process> list=new LinkedList<Process>();
    for(int i=0;i<n;i++){
            string ps=inputPS[i];
            int pt=inputPT[i];
            Process pr=new Process(ps,pt);
            list.AddLast(pr);
    }
    while(list.Count>0){
            if((list.First()).time>q){
                    Process x=list.Dequeue();
                    t+=q;
                    x.time-=q;
                    list.Add(x);
            }else{
                    Process x=list.Dequeue();
                    t+=x.time;
                    Console.Writeline(x.name+" "+t);
            }
    }
}

public Process dequeue() {
    Process ret = queue.First();
    queue.Remove(First());
    return ret;
}

public static void listRange(int N, int inputArray[]) {
    LinkedList<int> A = new LinkedList<int>();
    for(int i = 0; i < N; i++) {
            int a = inputArray[i];
            A.Add(a);
    }
    A.Sort();
    Console.Writeline(A.Last() - A.First());
}

public static void checkAns(string str, string ans){
            int count = 0;
            int max = 0;
            LinkedList<string> word = new LinkedList<string>();
            LinkedList<string> Ans = new LinkedList<string>();
            for (int i = 0; i < str.Length; i++) {
                string str2 = str[i].ToString();
                string ans2 = ans[i].ToString();
                word.Add(str2);
                Ans.Add(ans2);
            }
            for(int i=0; i<str.Length; i++){
                    word.AddFirst(word.Last());
                    word.RemoveLast();
                    if(word.Equals(Ans)){
                            Console.Writeline("Yes");
                            return;
                    }
            }
            Console.Writeline("No");
    }

    public int pop() {
        int ret = stack.Last();
        stack.RemoveLast();
        return ret;
}

    public static void calWaitingTime(LinkedList<string> qName, LinkedList<int> qTime, int quantum)
    {
            int time = 0;
            while(qName.Count != 0)
            {
                    string cName = qName.Remove(First());
                    int cTime = qTime.Remove(First());
                    if(cTime > quantum)
                    {
                            time = time + quantum;
                            cTime = cTime - quantum;
                            qName.AddLast(cName);
                            qTime.AddLast(cTime);
                    }else
                    {
                            time = time + cTime;
                            Console.Writeline(cName + " " + time);
                    }
            }
    }

    public static void calWaitingTime(LinkedList<string> names , LinkedList<int> amounts ,int clock) {
        int time = 0;
        while(amounts.Count != 0){
            string name = names.Remove(First());
            int amount = amounts.Remove(First());
            if(amount <= clock){
                time = time + amount;
                Console.Writeline(name + " " + time);
            }
            else{
                time = time + clock;
                amount = amount - clock;
                names.Add(name);
                amounts.Add(amount);
            }
        }
    }

    public static int getMinN(int root, int n, int m, Tree[] edge, int values[]){
        LinkedList<int> ll =  new LinkedList<int>();
        ll.Add(root);
        while(ll.Count>0){
                int val = ll.Remove(First());
                visited[val] = 0;
                List<int> al = edge[val].al;
                int length = al.Count;
                for(int i=0;i<length;i++){
                        ll.AddLast(al[i]);
                        int hold = edge[val].weight+values[root];
                        values[al[i]] = Math.Min(hold,values[al[i]]);
                }
        }
        return values[n];
}

public int pop() {
    int ret = stack.Last();
    stack.RemoveLast();
    return ret;
}

public int checkLast(string S) {
    int ans = 0;
    LinkedList<int> list = new LinkedList();
    foreach (char c in S.ToCharArray()) {
      int i = (int) c - ZERO;
      if (list.Count == 0) {
        list.AddLast(i);
      } else {
        if (list.Last() != i) {
          list.RemoveLast();
          ans += 2;
        } else {
          list.AddLast(i);
        }
      }
    }
    return ans;
  }

  public static void string2List(string s) {
    LinkedList<string> ans = new LinkedList<string>();
    for (int i = 0; i < s.Length; i++) {
        switch (s[i]) {
            case '0':
                ans.Add("0");
                break;
            case '1':
                ans.Add("1");
                break;
            case 'B':
                if (ans.Count != 0) {
                    ans.RemoveLast();
                }
                break;
        }
    }
    foreach (string valin ans) {
        Console.Writeline(val);
    }
}

public static void string2List( string s) {
    string[] sArray = s.Split("");
    LinkedList<string> ansList = new LinkedList<string>();
    for(int i = 0; i < s.Length; i++){
            if(sArray[i].Equals("1")) {
                    ansList.Add("1");
            } else if(sArray[i].Equals("0")) {
                    ansList.Add("0");
            } else if(sArray[i].Equals("B") && ansList.Count != 0){
                    ansList.RemoveLast();
            }
    }
    foreach(string ans in ansList){
            Console.Writeline(ans);
    }
}

public void morePositiveNums( List<int> list) {
    list.sort((x, y) => -x.CompareTo(y));
    int max = list.First();
    list.RemoveAt(0);
    int sum = 0;
    foreach (int i in list) {
        sum += i;
    }
    Console.WriteLine(sum > max ? "Yes" : "No");
}

public static void morePositiveNums(List<int> List){
    int max = List.Max();
    int num = List.IndexOf(max);
    List.RemoveAt(num);
    int sum=0;
    for(int a=0;a<List.Count;a++) sum+=List[a];
    if(sum>max) Console.Writeline("Yes");
    else Console.Writeline("No");
}

public static void checkSuffix(string s) {
    string[] keywords = {"dream", "dreamer", "erase", "eraser"};
    List<string> queue = new List<string>();
    queue.Add(s);
    while (queue.Count > 0) {
      s = queue.RemoveAt(queue.Count - 1);
      if (s.Count == 0) {
        Console.Writeline("YES");
        return;
      }
      for (int i = 0; i < 4; i++) {
        string keyword = keywords[i];
        string ts = s.replaceAll(keyword, "");
        if (s.Length > ts.Length) queue.Add(ts);
      }
    }
    Console.Writeline("NO");
  }

  public int calcMin(List<int> A, List<int> C, int min) {
    if (C.Count == 5) {
        min = Math.Min(min, simulate(C));
        return min;
    }

    for (int i = 0; i < A.Count; i++) {
        List<int> a = new LinkedList<int>(A);
        List<int> l = new LinkedList<int>(C);
        int v = a[i];
        a.RemoveAt(i);
        l.Add(v);
        min = Math.Min(min, calc(a, l, min));
    }
    return min;
}

public void checkLast(string S, OutputWriter out) {
    List<char> stack = new List<char>();
    int ans = 0;
    for (int i = 0; i < S.Length; i++) {
        if (stack.Count == 0) {
            stack.Add(S[i]);
        } else {
            if (stack.Last() != S[i]) {
                stack.RemoveAt(stack.Count - 1);
                ans += 2;
            } else {
                stack.Add(S[i]);
            }
        }
    }
    Console.WriteLine(ans);
}

static string nextPermutation(string s) {
    List<char> list=new List<char>();
    for(int i=0;i<s.Length;i++) {
            list.Add(s[i]);
    }
    int pivotPos=-1;
    char pivot=0;
    for(int i=list.Count-2;i>=0;i--) {
            if(list[i]<list[i+1]) {
                    pivotPos=i;
                    pivot=list[i];
                    break;
            }
    }
    if(pivotPos==-1&&pivot==0) {
            return "Final";
    }
    int L=pivotPos+1,R=list.Count-1;
    int minPos=-1;
    char min =Character.MaxValue;
    for(int i=R;i>=L;i--) {
            if(pivot<list[i]) {
                    if(list[i]<min) {
                            min=list[i];
                            minPos=i;
                    }
            }
    }
    (list[pivotPos] , list[minPos]) = (list[minPos], list[pivotPos]);
    list.GetRange(L, R+1 - L ).Sort();
    StringBuilder sb=new StringBuilder();
    for(int i=0;i<list.Count;i++) {
            sb.Append(list[i]);
    }
    return sb.ToString();
}

public static void countSame(List<int> p) {
    List<int> calcList = new List<int>();
    int ans = 0;
    for(int i = 1; i < n - 1; i++){
        foreach (var str in p.GetRange(i - 1, 3)) calcList.AddLast(str);
        calcList.Sort();
        if(calcList[1].Equals(p[i])){
            ans++;
        }
        calcList.Clear();
    }
    Console.Writeline(ans);
    return;
}

public static void calCost(int n , int x ,nt[] costPlaceList ) {
    List<int> placeList = new List<int>();
    for (int i = 0; i < n + 1; i++) {
        placeList.Add(0);
    }
    foreach(int costPlace in costPlaceList){
        placeList[costPlace] = 1;
    }
    int leftCost = sum(placeList.GetRange(0, x));
    int rightCost = sum(placeList.GetRange(x+1, placeList.Count - x - 1));
    if(leftCost < rightCost) {
        Console.Writeline(leftCost);
    } else {
        Console.Writeline(rightCost);
    }
}

public static void calBreaking(List<int> li){
    if(!li.Contains(1)){
      Console.Writeline(-1);
      return;
    }
    int breaking = 0;
    int currentNo = 1;
    while(li.Contains(currentNo)){
      breaking += li.IndexOf(currentNo);
          li = li.GetRange(li.IndexOf(currentNo)+1, li.Count - li.IndexOf(currentNo)- 1);
      currentNo++;
    }
    breaking += li.Count;
    Console.Writeline(breaking);
  }

  public static void calBreaking(List<int> list) {
    List<int> bloks = new List<int>();
    int target = list.Min();
    for (int idx = list.IndexOf(target); idx <= n; idx++) {
      int index = list.GetRange(idx, n - idx).IndexOf(target);
      if (index == -1) break;
      bloks.Add(target);
      target += 1;
    }
    if (bloks.Count == 0) {
      Console.Writeline(0);
    } else if (bloks.First() != 1) {
      Console.Writeline(-1);
    } else {
      Console.Writeline(n - bloks.Count);
    }
  }

  public static void calTotalK(int K , List<int> l){
    l.sort(null);
    long total = 0;
    for(int i = 0; i < l.Count-K; i++){
        total += l[i];
    }
    Console.Writeline(total);
}

public static void calTotalK2N(int n, int k , List<int> hps) {
    hps.sort((x, y) => -x.CompareTo(y));
    long result = 0;
    for (int i = k; i < n; i++) {
        result += hps[i];
    }
    Console.Writeline(result);
}

public void calTotalK2N(long N, long K, List<long> H) {
    H.sort(Collections.reverseOrder());
    long ans = 0;
    for (int i = (int) K; i < N; i++) {
        ans += H[i];
    }
    Console.Writeline(ans);
}

public static void getOrdered(List<string> word) {
    word.sort(Comparator.naturalOrder());
    foreach(string w in word) {
      Console.Writeline(w);
    }
  }

  public static void getOrdered(List<string> sList) {
    StringBuilder sb = new StringBuilder();
    sList.sort(Comparator.naturalOrder());
    foreach (string s in sList){
      sb.Append(s);
    }
    Console.Writeline(sb);
 }

 public static void countOrdered(int n , List<int> h) {
    h.Reverse();
    int ans = 0;
    int count = 0;
    for(int i = 1;i < n; i++) {
            if(h[i - 1]<=h[i]) {
                    count++;
            }
            else {
                    count = 0;
            }
            ans = Math.Max(ans, count);
    }
    Console.Writeline(ans);
}

public static void getReverseNum(int length , string[] inputNum) throws IOException{
    List<int> numArray = new List<int>();
    for (int i = 0; i < length; i++) {
            numArray.Add(int.Parse(inputNum[i]));
    }
    numArray.Reverse();
    for (int i = 0; i < numArray.Count; i++) {
            if (i == numArray.Count-1) {
                    Console.Writeline(numArray[i]);
            }else {
                    Console.Writeline(numArray[i] + " ");
            }
    }
}

public static void checkAbove4M(int M, List<int> s) {
    int total = 0;
    for(int i =0; i <s.Count ; i++) {
            int a =s[i];
            total += a;
    }
    s.Sort();
    s.Reverse();
    for(int m = 0; m < M; m++) {
            int a = s[m];
            if(a*4*M < total) {
                    Console.Writeline("No");
                    return;
            }
    }
    Console.Writeline("Yes");
}

public void power2(int a, int b, int c, int k){
    List<int> li = new List<int>();
    li.Add(a);
    li.Add(b);
    li.Add(c);
    li.Sort();
    li.Reverse();
    for(int i = 0; i < k; i++){
        li[0] = li.First() * 2;
    }
    ans = li.First() + li[1] + li[2];
    Console.Writeline(ans);
}

public static void countReverseNumber(int a, int b) {
    int b = sc.nextInt();
    int ans =0;
    for (int i = a; i <= b; i++)
    {
      string as = i.ToString();
      List<string> list=new List<string> (i.ToString().Split(""));
      list.Reverse();
      string[] bs = (string[]) list.toArray(new string[list.Count]);
      string strb = String.Join("", bs);
      if (as.Equals(strb))
        ans++;
    }
    Console.Writeline(ans);
  }

  public static void countVertex(int nV, string[] args) {
    Dictionary<string,int> tV = new SortedDictionary<string, int>();
    int nV = scn.nextInt();
    int[] VList= new int[nV];
    for(int i = 0;i<nV;i++) {
            string v = args[i];
            if(tV.Count != 0) {
                    if(tV.ContainsKey(v)) {
                            tV[v] = tV[v]+1;
                    }else {
                            tV[v] = 1;
                    }
            }else {
                    tV[v] = 1;
            }
            VList[i] = tV[v];
    }
    Array.Sort(VList);
}

public static void countSame(string args[]){
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    int t,i,j;
    t=1;
    while(t-->0){
        string s1,s2;
        s1=Console.ReadLine();
        s2=Console.ReadLine();
        char ch1[]=s1.ToCharArray();
        char ch2[]=s2.ToCharArray();
        int n=s1.Length,m=s2.Length; 
        LinkedList<char> li=new LinkedList<char>();
        LinkedList<char> li1=new LinkedList<char>();
        int max=0,c=0,count=0;
        for(i=0;i<n;i++){
            c=0;
            count=0;
            if(li.Count==m-1){
                li.Add(ch1[i]);
                count=0;
                c=0;
                while(li.Count != 0){
                    char temp=li.Remove(First());
                    if(ch2[c]==temp){
                        count++;
                        if(count>max){
                            max=count;
                        }
                    }
                    c++;
                    li1.Add(temp);
                    if(li.Count == 0){
                        break;
                    }
                }
                li=li1;
                li1=new LinkedList<char>();
                li.Remove(First());
            }else{
                li.Add(ch1[i]);
            }
        }
        Console.WriteLine(m-max);
    }
    w.close();
}

public static void findMax(int n, string[] args) {
    Dictionary<string,int> s = new LinkedDictionary<string,int>();
    for(int i = 0; i < n; i++) {
            string temp = args[i];
            if(s.ContainsKey(temp)) {
                    int c = s[temp]+1;
                    s[temp] = c;
            }
            else {
                    s[temp] = 1;
            }
    }
    Dictionary<string,int> ans = new SortedDictionary<string,int>();
    int count = 0;
    foreach(string key in s.Keys) {
            if(count < s[key]) {
                    ans.Clear();
                    count = s[key];
                    ans[key] = count;
            }
            else if(count==s[key]) {
                    ans[key] = count;
            }
    }
    foreach (string key in ans.Keys) {
            Console.Writeline(key);
    }
}

public static void countSubstring(int n , string[] args){
    int a;
    string alpha="abcdefghijklmnopqrstuvwxyz";
    Dictionary <string,int> mapA = new SortedDictionary<string,int>();
    Dictionary <string,int> mapB = new SortedDictionary<string,int>();
    Dictionary <string,int> mapC = new Dictionary<string,int>();
    int index,index2,index3,count;
    long answer,count2;
    string s,s2;
    for(index=0;index<n;index++) {
            s = args[i];
            mapA.Clear();
            for(index2=0;index2<10;index2++) {
                    s2=s.Substring(index2,index2+1);
                    if(mapA.ContainsKey(s2)){
                            count=mapA[s2];
                            mapA[s2] = count+1;
                    }
                    else {
                            mapA[s2] = 1;
                    }
            }
            s2="";
            foreach(string s3 in mapA.Keys) {
                    count=mapA[s3];
                    for(index3=0;index3<count;index3++) {
                            s2=s2.concat(s3);
                    }
            }
            if(mapB.ContainsKey(s2)) {
                    count=mapB[s2];
                    mapB[s2] = count+1;
            }
            else {
                    mapB[s2] = 1;
            }
    }
    ;
}

public static void getMaxValueKey(int N, final string[] args) {
    try{
        SortedDictionary<string, long > cnt = new SortedDictionary<string, long >();
        for (int i = 0; i < N; i++) {
            string s = args[i];
            cnt.TryAdd(s, 0l);
            cnt[s] = cnt[s] + 1;
        }
        long max = cnt.values().Max();
        foreach (var entry in cnt) {
            if (entry.Value.Equals(max)) {
                 Console.WriteLine(entry.Key);
            }
        }
    }
}

public static void inputDictionary(int N, string[] args){
    Dictionary<string,int>map = new SortedDictionary<string,int>();
    for(int i = 0;i < N;i++){
      map[args[i]] = 0;
    }
    Console.Writeline(map.Count);
  }

  private void add(SortedDictionary<int, int> map, int key){
    map[key] = map.GetValueOrDefault(key,0)+1;
}

private void remove(SortedDictionary<int,int> map,int key){
    if(!map.ContainsKey(key))
        return;
    map[key] = map.GetValueOrDefault(key,0)-1;
    if(map[key]==0)
        map.Remove(key);
}


public static void add(SortedDictionary<int,int> hm, int val){
    if(!hm.ContainsKey(val))
            hm[val] = 1;
    else hm[val] = hm[val]+1;
}

public static void remove(SortedDictionary<int,int> hm, int val){
    hm[val] = hm[val]+1;
    if(hm[val]==0){
            hm.Remove(val);
    }
}

public static void getMaxValueKey(string[] args) throws Exception {
    try {
            int n = int.Parse(sc.nextLine());
            Dictionary<string, int> map = new Dictionary<string, int>();
            int ma = int.MaxValue;
            for(int i=0;i<n;i++)
            {
                    string s = sc.nextLine();
                    map[s] = map.GetValueOrDefault(s, 0)+1;
                    ma = Math.Max(ma,map[s]);
            }
            SortedDictionary<string, int> sorted = new SortedDictionary<string, int>();
            foreach (var pair in map) sorted[pair.Key] = pair.Value;
            foreach(var m in sorted) {
                    if(ma==m.Value) {
                            Console.Writeline(m.Key);
                    }
            }
    }catch(Exception i) {}
}

public  static void getFirstKeyOfValue(int n, int t, int[] args){
    int a ;
    int b ;
    SortedDictionary<int,int> map = new SortedDictionary<int,int>();
    for(int i=0; i<n; i++){
     a = args[2*i];
     b = args[2*i + 1];
     if(b<=t){
       map[a] = b;
     }
    }
    if(map.Count==0){
      Console.Writeline("TLE");
    }else{
      Console.Writeline(map.firstKey());
    }
  }

  public static void inputDictionary(int N , string[] args){
    Dictionary<string,int>map = new SortedDictionary<string,int>();
    for(int i = 0;i < N;i++){
        map[args[i]] = 0;
    }
    Console.Writeline(map.Count);
  }

  public static void countNotCovered(int N, int K, int []d) {
            int[][]A = new int[K][N];
            Dictionary<int,List<int>>map = new SortedDictionary<int,List<int>>();
            for(int i = 0;i<N;i++) {
                    map[i] = new List<int>();
            }
            for(int i = 0;i<K;i++) {
                    for(int j = 0;j<d[i];j++) {
                            A[i][j] = scan.nextInt();
                            map[A[i][j]-1].Add(i+1);
                    }
            }
            int count = 0;
            for(int i = 0;i<map.Count;i++) {
                    if(map[i].Count==0)count++;
            }
            Console.Writeline(count);
}

    public static void calRemain(int a[]) throws Exception {
        int r[] = new int[5];
        SortedDictionary<int, int> map = new TreeDictionary();
        for (int i = 0; i < a.Length; i++) {
                
                r[i] = a[i]%10;
                int b =10;
                if (r[i] != 0) {
                        b = 10-r[i];
                        map[b] = a[i];
                }
        }
        int ans = 0;
        if (map.Count == 0) {
                for (int i = 0; i < a.Length; i++) {
                        ans += a[i];
                }
                Console.Writeline(ans);
                return;
        }
        int last = map[map.lastKey()];
        int idx = 0;
        for (int i = 0; i < a.Length; i++) {
                if(a[i] == last) {
                        idx = i;
                }
        }
}

public void calGeometricSeries() {
    long h = nl();
    SortedDictionary<long , long > tmap = new SortedDictionary<long , long >();
    tmap[h] = 1l;
    long ans = 0;
    while (tmap.Count > 0) {
        if (tmap.lastKey() == 1) {
            ans += tmap[tmap.lastKey()];
            break;
        }
        long x = tmap[tmap.lastKey()];
        long which = tmap.lastKey();
        tmap[which / 2] = tmap.GetValueOrDefault(which / 2, 0l) + 2 * x;
        ans += x;
        tmap.Remove(which);
    }
    pn(ans);
}

public static void input2Dictionary(int n, int[] args){
    SortedDictionary<int, int> map = new SortedDictionary<int,int>();
    int i;
    for(i = 0; i < n; i++) {
            map[args[i]] = i + 1;
    }
    int cnt = 0;
    int len = map.Count;
    foreach(int ans in map.values()) {
            cnt++;
            if(len > cnt)
                    Console.Writeline(ans + " ");
            else
                    Console.Writeline(ans);
    }
}

public static void getMaxCountKey(int N , string[] args){
    Dictionary<string,int> map = new SortedDictionary<string, int>();
    for(int i = 0;i < N;i++){
      string str = args[i];
      if(map.ContainsKey(str)){
      map[str] = map[str] + 1;
      }else{
        map[str] = 0;
      }
    }
    int maxv = 0;
    foreach(int v in map.values()){
      if(v > maxv) maxv = v;
    }
    foreach(string str in map.Keys){
      if(map[str] == maxv){
        Console.Writeline(str);
      }
    }
  }


  public int subAll(K k){
    if(!this.ContainsKey(k)) return -1;
    int cnt = this.count(k);
    this.Remove(k);
    sum -= cnt;
    return cnt;
}

public static void getMaxCountKey(int n, string[] args) {
    Dictionary<string, int> map = new SortedDictionary<string, int>();
    int max = 0;
    for (int i = 0; i < n; i++) {
            string z = args[i];
            if (map.ContainsKey(z)) {
                    int v = map[z] + 1;
                    max = Math.Max(max, v);
                    map[z] = v;
            }else {
                    map[z] = 1;
                    max = Math.Max(max, 1);
            }
    }
    foreach(string k in map.Keys) {
            if (map[k] == max) {
                    Console.Writeline(k);
            }
    }
}

public static void getMaxCountKey(int N , string[] args){
    SortedDictionary<string, int> paper = new SortedDictionary<string, int>();
    int max = 1;
    for(int i=0; i<N; i++){
      string tmp = args[i];
      if(paper.ContainsKey(tmp)){
        paper[tmp] = paper[tmp] + 1;
        max = Math.Max(max, paper[tmp]);
      }else{
        paper[tmp] = 1;
      }
    }
    foreach(string key in paper.Keys){
      if(max == paper[key]){
        Console.Writeline(key);
      }
    }
  }
  
  public static SortedDictionary<long , int> PrimeFactorization(long n){
    SortedDictionary<long , int> map = new SortedDictionary<long , int>();
    for (long i = 2; i*i <= n; i++) {
        while(n%i==0){
            map[i] = map.ContainsKey(i)?map[i]+1:1;
            n /= i;
        }
    }
    if(n!=1) map[n] = 1;
    return map;
}

public static void checkSame(string[] args) {
    Dictionary<int, bool> A = new SortedDictionary<int, bool>();
    bool ans = true;
    int N = sc.nextInt();
    for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            if (!A.ContainsKey(temp)) {
                    A[temp] = true;
            } else {
                    ans = false;
                    break;
            }
    }
    Console.Writeline(ans ? "YES" : "NO");
}

static void put(SortedDictionary<int, int> map, int p){if(map.ContainsKey(p)) map.replace(p, map[p]+1); else map[p] = 1; }
static void rem(SortedDictionary<int, int> map, int p){ if(map[p]==1) map.Remove(p);else map.replace(p, map[p]-1); }

public int sub(K k){
    if(!this.ContainsKey(k)) return -1;
    int res = this.count(k) - 1;
    if(res == 0) this.Remove(k);
    else this[k] = res;
    sum--;
    return res;
}

public void remove(U x) {
    if (t[x] == 1) t.RemoveAt(x);
    else t[x] = t[x] - 1;
    sz--;
}

public static void remove(SortedDictionary<int,int> hm, int val){
    hm[val] = hm[val]-1;
    if(hm[val]==0){
            hm.Remove(val);
    }
}
private void remove(SortedDictionary<int,int> map,int key){
    if(!map.ContainsKey(key))
        return;
    map[key] = map.GetValueOrDefault(key,0)-1;
    if(map[key]==0)
        map.Remove(key);
}

public void add(U x) {
    t[x] = t.GetValueOrDefault(x, 0) + 1;
    sz++;
}

public static void getMaxCountKey(int n, int[] a) {
    Dictionary<int, int> count = new SortedDictionary<int,int>((x, y) => -x.CompareTo(y));
    int max = 0;
    for (int i = 0; i < n; i++) {
        count[a[i]] = count.GetValueOrDefault(a[i], 0) + 1;
        max = Math.Max(a[i], max);
    } }

    public void getMaxCountKey() {
        int n = in.nextInt();
        SortedDictionary<string, int> map = new SortedDictionary<string, int>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            string s = in.next();
            map[s] = map.GetValueOrDefault(s, 0) + 1;
            max = Math.Max(max, map[s]);
        }
        foreach (string key in map.Keys) {
            if (map[key] != max) {
                continue;
            }
            Console.Writeline(key);
        }
    }

    public static void getMaxCountKey(int n, string[] args){
        SortedDictionary<string, int> tm = new SortedDictionary<string, int>();
        int max = 0;
        for(int i = 0; i < n; i++){
            string s = args[i];
            int cnt = tm.GetValueOrDefault(s, 0) + 1;
            tm[s] = cnt;
            max = max(max, cnt);
        }
        foreach(string key in tm.Keys){
            if(tm[key].Equals(max)) Console.Writeline(key);
        }
}

public static void getExtinct(int N, string[] args) {
    string[] list = new string[N];
    Dictionary<string, int> map = new SortedDictionary<string, int>();
    for(int i=0; i<N;i++) {
            string s = args[i];
            if(map[s]==null) {
                    map[s] = 1;
            }
    }
    int ans  = map.values().toArray().Length;
}

public static void getRepeatKey(int n, string[] s){
    long ans = 0;
    SortedDictionary<string,int> map = new SortedDictionary<string,int>();
    for(int i = 0; i < n; i++){
            int[] a = new int[10];
            for(int j = 0; j < 10; j++){
                    a[j] = s[i][j];
            }
            Array.Sort(a);
            string b = "";
            for(int j = 0; j < 10; j++){
                    b=b + a[j];
            }
            if(map.ContainsKey(b)){
            map[b] = map[b]+1;
            ans+=map[b];
            }else{
                    map[b] = 0;
            }
    }
    Console.Writeline(ans);
}

public void countUnderLimitedTime(int limitedTime , Dictionary<int, int> input) {
    int ans = 0;
    foreach (var e in input) {
        if (e.Value <= limitedTime) {
            ans = e.Key;
            break;
        }
    }
    if (ans == 0) {
        Console.WriteLine("TLE");
        return;
    }
    Console.WriteLine(ans);
}

public static void getMaxCountKey(int N, string[] input) {
    Dictionary<string, int> dic = new SortedDictionary<string, int>();
    int max = 0;
    for (int i = 0; i < N; i++) {
        string tmp = input[i];
        if (dic[tmp] == null){
            dic[tmp] = 1;
        } else {
            int x = dic[tmp]+1;
            dic[tmp] = x;
        }
    }
    foreach (int i in dic.values()){
        if (max < i){
            max = i;
        }
    }
    foreach (string s in dic.Keys){
        if(dic[s] == max) {
            Console.Writeline(s);
        }
    }
}

public static void getMaxCountKey(int N, string[] args) {
    int N = sc.nextInt();
    Dictionary<string, int> m = new SortedDictionary<string, int>();
    int max = 1;
    for(int i = 0; i < N; i++) {
            string S = args[i];
            if(m.ContainsKey(S)) {
                    m[S] = m[S]+1;
                    max = Math.Max(max, m[S]);
            }
            else
                    m[S] = 1;
    }
    List<string> l = new List<string>();
    foreach(string s in m.Keys) {
            if(m[s] == max)
                    l.Add(s);
    }
    l.Sort();
    foreach(string s in l)
            Console.Writeline(s);

}

public static void getMaxCountKey(int n, string b,  string[] args) {
    Dictionary<string,int> poll = new SortedDictionary<string,int>();
    poll[b] = 1;
    for(int i=1;i<n;i++) {
            string S = args[i];
            if(!poll.ContainsKey(S)) {
                    poll[S] = 1;
                    }else {
                            poll.replace(S,poll[S]+1);
                    }
    }
    int S = 0;
    foreach(string k in poll.Keys) {
            S = Math.Max(S, poll[k]);
    }
    foreach(string k in poll.Keys) {
            if(S == poll[k]) {
                    Console.Writeline(k);
            }
}
}

public static void countInput(int N, string[] args){
    Dictionary<string,int> map = new SortedDictionary<string,int>();
    for (int i = 0; i < N; i++){
            string str = args[i];
            if (map.ContainsKey(str)){
                    map[str] = map[str] + 1;
            }else{
                    map[str] = 0;
            }
    }
}

public static void getMaxCountKey(int N, string[] args) {
    Dictionary<string, int> wordmap = new SortedDictionary<string, int>();
    int max = 0;
    for (int i=0;i<N;i++) {
        string S_n = args[i];
        if (wordmap.ContainsKey(S_n)) {
            int count = wordmap[S_n];
            wordmap[S_n] = count + 1;
            if (max <= count) max = count + 1;
        } else {
            wordmap[S-n] = 1;
            if (max == 0) max = 1;
        }
    }
    foreach (string key in wordmap.Keys) {
        if (wordmap[key] == max) Console.Writeline(key);
    }
}

public static void calDistance(int n, int q, string s, int[] args) {
    SortedDictionary<int, int> ml = new SortedDictionary<int,int>();
    int idx = 0;
    int d = 0;
    while (true) {
            idx = s.IndexOf("AC", idx);
            if (idx == -1) {
                    break;
            }
            ml[idx] = ++d;
            idx++;
    }
    for (int i = 0; i < q; i++) {
            int l = args[2*i] - 1;
            int r = args[2*i +1] - 1;
            int c = d;
            if (l != 0) {
                    Entry<int, int> lower = ml.lowerEntry(l);
                    if (lower != null) {
                            c -= lower.Value;
                    }
            }
            if (r != n) {
                    Entry<int, int> ceil = ml.ceilingEntry(r);
                    if (ceil != null) {
                            c -= (d - ceil.Value + 1);
                    }
            }
    }
}

public static void calAns(int n , PriorityQueue<int> pq) {
    int first = pq.Dequeue();
    double ans = first;
    while (pq.Count != 0) {
        int value = pq.Dequeue();
        ans += value;
        ans /= 2.0;
    }
    Console.Writeline(ans);
}

static void dijkstra(int src) {
    dist = new int[V];
    Array.Fill(dist, oo);
    parent = new int[V];
    Array.Fill(parent, -1);
    dist[src] = 0;
    PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    pq.Enqueue(new Edge(src,0));
    while(pq.Count != 0) {
            Edge e = pq.Dequeue();
            if(dist[e.x] < e.y)
                    continue;
            foreach(Edge e2 in adj[e.x]) {
                    if(dist[e2.x] > e2.y+e.y) {
                            pq.Enqueue(new Edge(e2.x,dist[e2.x] = e2.y+e.y));
                            parent[e2.x] = e.x;
                    }
            }
    }
}

public static void getMaxCountKey(int n, string[] args) throws IOException{
    Dictionary<string, int> map = new Dictionary<string, int>();
    string vote;
    int max = 0;
    while(n-->0) {
            vote = args[n];
            int v = map.GetValueOrDefault(vote, 0)+1;
            map[vote] = v;
            max = Math.Max(max, v);
    }
    PriorityQueue<string> pq = new PriorityQueue<string>();
    foreach(var in map) {
            if(e.Value == max) pq.Enqueue(e.Key);
    }
    while(pq.Count != 0)
            Console.WriteLine(pq.Dequeue());
}

public long calRemainSum( int n, int k,  Queue<long> heap) throws IOException {
    if (k >= n){
        return 0;
    }
    for (int i = 0; i < k; i++) {
        heap.Dequeue();
    }
    long ans = 0;
    while (heap.Count != 0){
        ans += heap.Dequeue();
    }
    return ans;
}

public static void getFisrtBelow(int N , int T, int[] argsC, int[] argsT) throws Exception {
    Queue<int> queue = new PriorityQueue<int>();
    for(int i = 0; i < N; i++){
        int c = argsC[i];
        int t = argsT[i];
        if( t <= T ) queue.Enqueue(c);
    }
    if( queue.Count != 0 ){
        Console.Writeline("TLE");
    } else {
        Console.Writeline(queue.Dequeue() );
    }
}
    static void shortestPaths(List<Edge>[] edges, int s, int[] prio, int[] pred) {
        Array.Fill(pred, -1);
        Array.Fill(prio, int.MaxValue);
        prio[s] = 0;
        PriorityQueue<long> q = new PriorityQueue<long>();
        q.Add((long) s);
        while (q.Count != 0) {
                long cur = q.Dequeue();
                int curu = (int) cur;
                if (cur >>> 32 != prio[curu])
                        continue;
                foreach (Edge e in edges[curu]) {
                        int v = e.t;
                        int nprio = prio[curu] + e.cost;
                        if (prio[v] > nprio) {
                                prio[v] = nprio;
                                pred[v] = curu;
                                q.Enqueue(((long) nprio << 32) + v);
                        }
                }
        }
}

int dijkstra(int src){
    for(int i=0; i<V; i++){
        dist[i] = int.MaxValue;
    }
    dist[src] = 0;
    pq.Enqueue(new edge(src,0));
    while (pq.Count != 0){
        int u = pq.Dequeue().dest;
        for(int i=0; i<adj[u].Count; i++){
            int v = adj[u][i].dest;
            int w = adj[u][i].cost;
            if(dist[u]+w<=dist[v]){
                dist[v] = dist[u] + w;
                pq.Enqueue(new edge(v,dist[v]));
            }
        }
    }
    int dis = dist[2];

    return dis;
}

public static void sortInput(int n, int l,string[] args) {
            PriorityQueue<string> t=new PriorityQueue<string>();
            for(int i=0;i<n;i++) {
                    t.Enqueue(args[i]);
            }
    while(t.Count != 0) {
            Console.Writeline(t.Dequeue());
    }
    Console.Writeline();
}

public static void count2Times(int n, Stack<int> args) {
    PriorityQueue<int> queue = new PriorityQueue<int>(n, Collections.reverseOrder());
    for (int i = 0; i < n; i++) {
        int val = args.Pop();
        queue.Enqueue(val);
    }
    int count = 0;
    while (queue.Count != 0) {
        int v = queue.Dequeue();
        if (v % 2 == 0) {
            int nv = v / 2;
            queue.Add(nv);
            count++;
        }
    }
    Console.Writeline(count);
}

public static void getsinputMax(int n, string[] args) throws IOException, InterruptedException {
    bool is = true;
    Dictionary<string,int>hm = new Dictionary<string, int>();
    PriorityQueue<string>pq= new PriorityQueue<string>();
    int mx=0;
    while (n-->0){
        string z = args[i];
        hm[z] = hm.GetValueOrDefault(z,0)+1;
        if (hm[z]>mx) {
            mx = hm[z];
            pq.Clear();
        }
        if (hm[z]==mx){
            pq.Enqueue(z);
        }
    }
    while (pq.Count != 0)
         Console.WriteLine(pq.Dequeue());
}

public void calWaitingTime( int N, int[] inputQueue) {
    PriorityQueue<int> queue = new PriorityQueue<int>(Comparator.naturalOrder());
    for (int i=0; i<N; i++) {
        queue.Enqueue(inputQueue[i]);
    }
    for (int i=0; i<N/2-1; i++) {
        queue.Dequeue();
    }
    int before = queue.Dequeue();
    int after = queue.Dequeue();
    Console.WriteLine(after - before);
}

public void getMean( int[] inputArray) {
    int n = in.nextInt();
    PriorityQueue<double> pq = new PriorityQueue<double>();
    for (int i = 0; i < n; i++) pq.Enqueue((double) inputArray[i]);
    while (pq.Count != 1) pq.Enqueue((pq.Dequeue() + pq.Dequeue()) / 2);
    Console.WriteLine(pq.Peek());
}

public static void getMean(int countMaterial, string[] inputValue) {
    PriorityQueue<double> Que = new PriorityQueue();
    for(int i = 0;i<countMaterial;i++) {
            double eachValue = double.Parse(inputValue[i]);
            Que.Enqueue(eachValue);
    }
    for(int i = 1;i<=countMaterial-1;i++) {
            double tmp1 = Que.Dequeue();
            double tmp2 = Que.Dequeue();
            double tmp = (tmp1+tmp2)/2;
            Que.Enqueue(tmp);
    }
    Console.Writeline(Que.Peek());
}


public static void getMean(int N, int[] v) {
        PriorityQueue<double> pq = new PriorityQueue<double>();
        for (int i = 0; i < N; i++) {
            pq.Enqueue((double) v[i]);
        }
        for (; pq.Count > 1;) {
            double d = pq.Dequeue();
            double d2 = pq.Dequeue();
            pq.Enqueue((d + d2) / 2);
        }
        Console.Writeline(pq.Dequeue());
}


public static void getMean(int n, double[] args) {
    PriorityQueue<double> pq = new PriorityQueue<double>();
    for (int i = 0; i < n; i++) {
            pq.Enqueue(args[i]);
    }
    while (pq.Count > 1) {
            pq.Enqueue((pq.Dequeue() + pq.Dequeue()) / 2);
    }
    Console.Writeline(pq.Peek());
    ;
}

public static int sumHeap(int[] arr, int k) {
    int n = arr.Length;
    if(n==0) {
        return 0;
    }
    int sum = 0;
    PriorityQueue<int> heap = new PriorityQueue(Collections.reverseOrder());
    foreach(int i in arr) {
        heap.Enqueue(i);
        
        if(heap.Count > k) {
            heap.Dequeue();
        }
    }
    while(heap.Count > 0) {
        sum += heap.Peek();
        heap.Dequeue();
    }
    return sum;
}

public static void sumInput(string[] args){
            int n = sc.nextInt();
            int k = sc.nextInt();
            PriorityQueue<int> pq = new PriorityQueue<int>();
            for(int i = 0 ; i < n ; i++ ) {
                    int p = sc.nextInt();
                    pq.Enqueue(p);
            }
            int sum = 0;
            for(int i = 0 ; i < k ; i++ ) {
                    sum += pq.Dequeue();
        
    }
}

public void getMean() throws IOException
    {
        stringTokenizer tok = new stringTokenizer(Console.ReadLine());
        int n = int.Parse(tok.nextToken());
        tok = new stringTokenizer(Console.ReadLine());
        PriorityQueue<double> pq = new PriorityQueue<double>();
        for (int i = 0; i < n; i++)
        {
            pq.Enqueue((double)int.Parse(tok.nextToken()));
        }
        while (pq.Count > 1)
        {
            double a = pq.Dequeue();
            double b = pq.Dequeue();
            pq.Enqueue((a+b) / 2);
        }
        Console.WriteLine(pq.Dequeue());
        out.flush();
        in.close();
    }

    public void sumInput(int n, int k,long[] inputArray ) throws IOException {
        Queue<long> heap = new PriorityQueue<long>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            heap.Enqueue(inputArray[i]);
        }
        if (k >= n){
            Console.WriteLine(0);
            return;
        }
        for (int i = 0; i < k; i++) {
            heap.Dequeue();
        }
        long ans = 0;
        while (heap.Count != 0){
            ans += heap.Dequeue();
        }
        Console.WriteLine(ans);
    }

    public static void getMean(PriorityQueue<double> q) {
        while (q.Count > 1) {
                double x = q.Dequeue();
                double y = q.Dequeue();
                q.Enqueue(x + y) / 2);
        }
        Console.Writeline(q.Dequeue());
}

public static void sumInpt(long[] arr){
    PriorityQueue<long> p = new PriorityQueue<long>();
    foreach(long i in arr){
        p.Enqueue(i);
    }
    int mod = 1000000009;
    long sum= 0;
    while(p.Count > 1){
       long first = p.Dequeue();
       long second = p.Dequeue();

        sum += first+second;
        
        p.Enqueue(first+second);
    }
    Console.Writeline(sum);
}
    
public static void getSquares(int X) {
    PriorityQueue<int> pq = new PriorityQueue<int>();
    pq.Enqueue(1);
    int base = 2;
    while(base<=upper){
        int cur = base*base;
        while(cur<=X){
            pq.Enqueue(cur);
            cur = cur*base;
        }
        base++;
    }
    int ans = 0;
    while(pq.Count>1) ans = pq.Dequeue();
    ans = pq.Dequeue();
    Console.Writeline(ans);
}

public static long getsinputSum(Queue<int> q , int K) {
 int[] t = new int[N];
    for (int j = q.Count - 1; j >= 0; --j) {
            t[j] = q.Dequeue();
    }

    long sum = 0;
    if (K <= N)
            for (int l = K; l < t.Length; l++) {
                    sum += t[l];
            }
    return sum;
}

public static void sumPower2 (int x1, int x2, int x3, int q) throws java.lang.Exception
        {
                Queue<int> pq = new PriorityQueue<int>(Collections.reverseOrder());
                pq.Enqueue(x1);
                pq.Enqueue(x2);
                pq.Enqueue(x3);
                while(q-->0){
                        pq.Enqueue(2*pq.Dequeue());
                }
                int ans = 0;
                while(pq.Count>0){
                        ans+=pq.Dequeue();
                }
                Console.Writeline(ans);
        }

        public static void getRetain(int n, int args[]) {
            PriorityQueue<int> pq = new PriorityQueue<int>(Collections.reverseOrder());
            for(int i=0;i<n;i++){
                int t = args[i];
                if(t%2==0) pq.Enqueue(t);
            }
            int c= 0;
            while(pq.Count>0){
                int r = pq.Dequeue();
                c++;
                r/=2;
                if(r%2==0) pq.Enqueue(r);
            }
            Console.Writeline(c);
        }

        public static void getMean(int n, double[] args) {
            PriorityQueue<double> queue = new PriorityQueue<double>();
            for (int i = 0; i < n; i++) {
              queue.Enqueue(args[i]);
            }
            while (queue.Count > 1) {
              double item1 = queue.Dequeue();
              double item2 = queue.Dequeue();
              queue.Enqueue((item1 + item2) / 2);
            }
            Console.Writeline(queue.Peek());
          }

          public void getMean(int N, double[] ints) throws Exception
        {
                PriorityQueue<double> que = new PriorityQueue<double>();
                foreach(var x in ints)
                        que.Enqueue(x);
                while(que.Count != 1)
                {
                        double x= que.Dequeue();
                        double y = que.Dequeue();
                        que.offer((x+y)/2);
                }
                Console.Writeline(que.Peek());
        }

        public static void getHalf(PriorityQueue<int> list) {
            int size = list.Count;
            int prev = 0;
            for (int i = 0; i < size / 2; i++) {
                    prev = list.Dequeue();
            }
            Console.Writeline(list.Peek()-prev);
    }

    public static int getHeapSum(int[] arr, int k) {
        int n = arr.Length;
        if(n==0) {
            return 0;
        }
        int sum = 0;
        PriorityQueue<int> heap = new PriorityQueue(Collections.reverseOrder());
        foreach(var i in arr) {
            heap.Enqueue(i);
            
            if(heap.Count > k) {
                heap.Dequeue();
            }
        }
        while(heap.Count > 0) {
            sum += heap.Peek();
            heap.Dequeue();
        }
        return sum;
    }

    public static void countTop(int n, int[] args) {
                PriorityQueue<int> q = new PriorityQueue<int>();
                int ans = 0;
                for(int i = 0 ; i < n ; i++) {
                        int now =args[i];
                        q.Enqueue(now);
                        if(now == q.Peek()) {
                                ans++;
                        }
                }
                Console.Writeline(ans);
}

public static void calFirstDiff(int n,int m,  string args[]) {
    PriorityQueue<int> l = new PriorityQueue<int>((x, y) => -x.CompareTo(y));
    PriorityQueue<int> r = new PriorityQueue<int>();
    for (int i = 0; i < m; i++) {
        l.Enqueue(int.Parse(args[2 * i]));
        r.Enqueue(int.Parse(args[2*i +1]));
    }
    int result = r.Peek() - l.Peek() + 1;
    Console.Writeline(result < 0 ? 0 : result);
}

public static void calMean(int n, double[] data) {
    PriorityQueue<double> queue = new PriorityQueue<double>();
    for (int i = 0; i < n; i++) {
      queue.Enqueue(data[n]);
    }
    while (queue.Count > 1) {
      double item1 = queue.Dequeue();
      double item2 = queue.Dequeue();
      queue.Enqueue((item1 + item2) / 2);
    }
    Console.Writeline(queue.Peek());
  }

  public static void take3Turn(string[] a_list , string[] b_list , string[] c_list ) throws IOException {
    Queue<string> a, b, c;
    a = new Queue<string>(a_list);
    b = new Queue<string>(b_list);
    c = new Queue<string>(c_list);
    string turn = "a";
    while (turn != null) {
        switch (turn) {
            case "a":
                turn = a.Dequeue();
                if (turn == null) Console.Writeline("A");
                break;
            case "b":
                turn = b.Dequeue();
                if (turn == null) Console.Writeline("B");
                break;
            case "c":
                turn = c.Dequeue();
                if (turn == null) Console.Writeline("C");
                break;
        }
    }
}

public static void take3Turn(string word1, string word2, string word3) throws IOException {
    Queue<char>q1 = new Queue<char>();
    Queue<char>q2 = new Queue<char>();
    Queue<char>q3 = new Queue<char>();
    for(int i=0;i<word1.Length;i++)q1.Add(word1[i]);
    for(int i=0;i<word2.Length;i++)q2.Add(word2[i]);
    for(int i=0;i<word3.Length;i++)q3.Add(word3[i]);
    char  g = 'a';
    while(true){
        if(g=='a'){
            if(q1.Count == 0){
                Console.Writeline('A');
                break;
            }
            else{
                g = q1.Dequeue();
            }
        }
        else if(g=='b'){
            if(q2.Count == 0){
                Console.Writeline('B');
                break;
            }
            else{
                g = q2.Dequeue();
            }
        }
        else{
            if(q3.Count == 0){
                Console.Writeline('C');
                break;
            }
            else{
                g = q3.Dequeue();
            }
        }
    }
}

        private static void findNewPlayer(char[][] sm) {
            List<Queue<char>> listDeque = new List<Queue<char>>();
            foreach (char[] ss in sm) {
              Queue<char> deque = new Queue<char>();
              foreach (char c in ss) {
                deque.Enqueue(c);
              }
              listDeque.Add(deque);
            }
            int player = 0;
            while (true) {
              if (listDeque[player].Count == 0) {
                return "" + (char)('A' + player);
              }
              player = listDeque[player].First() - 'a';
              listDeque[player].Remove(First());
            }
          }

          public void doBackspace(string nextLine) {
            char[] line = nextLine.ToCharArray();
            Queue<char> deque = new Queue<char>();
            foreach (char c in line) {
                    if (c == 'B') {
                            if (deque.Count != 0) deque.DequeueLast();
                    } else {
                            deque.Enqueue(c);
                    }
            }
            while (deque.Count != 0) {out.print(deque.DequeueFirst());}
    }

    public static long getBaseSum(long h){
        Queue<long> queue = new Queue<long>();
        queue.Add(h);
        long vital;
        long sum = 0L;
        long base = 1L;
        while(queue.Count != 0){
          vital = queue.Dequeue();
          sum+=base;
          base*=2;
          if(vital>1){
            queue.Enqueue(vital/2);
          }
        }
        return sum;
      }

      public static void countSame( string s) {
        Stack<char> stack = new Stack<char>();
        foreach (char c in s.ToCharArray()) {
          if (stack.Count != 0 && stack.First() != c) {
            stack.Pop();
          } else {
            stack.Push(c);
          }
        }
        Console.Writeline(s.Length - stack.Count);
      }

      public static void countSame (List<string> args) {
        while (args.Count > 0) {
          string S = args.First();
          args.Remove(First());
          Stack<char> stack = new Stack<char>();
          for (int i = 0; i < S.Length; ++i) {
            char cube = S[i];
            if (stack.Count == 0) {
              stack.Push(cube);
            } else if (cube == '1' && stack.First() == '0') {
              stack.Pop();
            } else if (cube == '0' && stack.First() == '1') {
              stack.Pop();
            } else {
              stack.Push(cube);
            }
          }
          Console.Writeline(S.Length - stack.Count);
        }
      }

      public static void reEnqueue(List<string> args)
      {
          Queue<string> queue = new Queue<string>();
          int i,k;
          while(true)
          {
              string input = args.First();
              args.Remove(First());
              if(input.Equals("-")) break;
              string[] binput = input.Split("");
              for(i=0; i<binput.Length; i++) queue.Enqueue(binput[i]);
              int m = sc.nextInt();
              int h;
              for(i=0; i<m; i++)
              {
                  h = sc.nextInt();
                  for(k=0; k<h; k++) queue.Add(queue.Dequeue());
              }
              foreach(string a in queue) Console.WriteLine("%s",a);
              Console.WriteLine("\n");
              queue.Clear();
          }
          ;
      }

      public static void checkSameStr(int n,string[] args)throws Exception{
        PriorityQueue<string> s=new PriorityQueue<string>();
        Queue<string> t=new Queue<string>();
        for(int i=0;i<n;i++){
            s.Enqueue(args[i]);
        }
        int max=0;
        while(s.Peek()!=null){
            string str=s.Peek();
            int i=0;
            for(;s.Peek()!=null&&s.Peek().Equals(str);i++){
                s.Dequeue();
            }
            if(max==i){
                t.Enqueue(str);
            }else if(max<i){
                max=i;
                t.Clear();
                t.Enqueue(str);
            }
        }
        while(t.Peek()!=null){
            Console.Writeline(t.Dequeue());
        }
    }

    public static void countSameSeries(int N, string[] args) {
        Queue<List<int>> D = new Queue<List<int>>();
        List<int> tmp = new List<int>();
        for(int i=0;i<2*N;i+=2) {
                int a = args[i];
                int b = args[i+1];
                tmp.Add(a);
                tmp.Add(b);
                foreach (var item in tmp)
                {
                    D.Enqueue(item);
                }
                tmp.Clear();
        }
        tmp=null;
        int cnt=0;
        while(D.Count!=0 && cnt<3){
                List<int> d =D.Dequeue();
                if(d.First()==d[1]) {
                        cnt+=1;
                }
                else {
                        cnt=0;
                }
        }
        if(cnt>=3) {
                Console.Writeline("Yes");
        }
        else {
                Console.Writeline("No");
        }
    
}

public static void countMergeTimes(int n, int q, string[] argsP, int[] argsT){
    Queue<string> P = new Queue<string>();
    Queue<int> T = new Queue<int>();
    for(int i=0; i<n; i++){
            P.Enqueue(argsP[i]);  
            T.Enqueue(argsT[i]);
    }
    int total=0;
    while ( P.Count != 0 ) {
            string p= P.Pop();
            int t= T.Pop();
            if(q<t) { T.Enqueue(t-q); P.Enqueue(p); total+= q; }
            else { total+= t;  Console.Writeline(p +" "+ total); } 
    }
}

public static void countMergeTimes(int n, int q, string[] argsP, int[] argsT) {
    int time = 0;
    int [] T = new int[n];
    string [] Name = new string[n];
    Queue<int> L = new Queue<int>();
    List<int> opt = new List<int>();
    for(int i=0;i<n;i++){
        Name[i] = argsP[i];
        T[i] = argsT[i];
        L.Enqueue(i);
    }
    while(L.Count!=0){
        int p_num = L.Dequeue();
        if(T[p_num]-q>0){
            time+=q;
            T[p_num]-=q;
            L.Enqueue(p_num);
        }
        else{
            time+=T[p_num];
            T[p_num]=time;
            opt.Add(p_num);
        }
    }
    foreach(int i in opt) Console.Writeline(Name[i]+" "+T[i]);
}

public static int doBFS(int N, int[] args) {
    int[] next = new int[N];
    for (int i = 0; i < N; i++)
            next[i] = args[i]-1;
    int[] dist = new int[N];
    Array.Fill(dist,-1);
    dist[0] = 0;
    Queue<int> bfs = new Queue<int>();
    bfs.Add(0);
    while (!bfs.Count != 0) {
            int node = bfs.Dequeue();
            if (dist[next[node]] == -1) {
                    bfs.Enqueue(next[node]);
                    dist[next[node]] = dist[node]+1;
            }
    }
    return dist[1];
}

public static int doBFS(int n, int[] args) {
    StringBuilder sb = new StringBuilder();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
            a[i] = args[i] - 1;
    }
    bool[] memo = new bool[n];
    memo[0] = true;
    Queue<int> deque = new Queue<int>();
    deque.Add(a[0]);
    int t, cnt = 1;
    bool b = false;
    while (deque.Count != 0) {
            t = deque.Dequeue();
            if (t == 1) {
                    b = true;
                    break;
            } else if (!memo[t]) {
                    deque.Enqueue(a[t]);
                    memo[t] = true;
                    cnt++;
            } else {
                    break;
            }
    }
    if (b) {
            return cnt;
    } else {
            return -1;
    }
}

public int doBFS(int n, int[] a) {
    int[] visit = new int[n+1];
    Queue<int> Q = new Queue<int>();
    int ans = 0;
    Array.Fill(visit, -1);
    visit[1] = 0;
    Q.Enqueue(1);
    while (Q.Count != 0) {
            x = Q.Dequeue();
            if (visit[a[x]] == -1) {
                    if (a[x] == 2) {
                            ans = visit[x] + 1;
                            return ans;
                    }
                    visit[a[x]] = visit[x] + 1;
                    Q.Enqueue(a[x]);
            }
    }
    return -1;
}

public static void removeSame(int n, string[] args)throws Exception{
    PriorityQueue<string> s=new PriorityQueue<string>();
    Queue<string> t=new Queue<string>();
    for(int i=0;i<n;i++){
        s.Enqueue(args[i]);
    }
    int max=0;
    while(s.Peek()!=null){
        string str=s.Peek();
        int i=0;
        for(;s.Peek()!=null&&s.Peek().Equals(str);i++){
            s.Dequeue();
        }
        if(max==i){
            t.Enqueue(str);
        }else if(max<i){
            max=i;
            t.Clear();
            t.Enqueue(str);
        }
    }
    while(t.First()!=null){
        Console.Writeline(t.Dequeue());
    }
}

public string getMostABC( string inputA, string inputB, string inputC) {
    char[] a = inputA.ToCharArray();
    char[] b = inputB.ToCharArray();
    char[] c = inputC.ToCharArray();
    Queue<char> aq = new Queue<char>();
    Queue<char> bq = new Queue<char>();
    Queue<char> cq = new Queue<char>();
    for (int i = 0; i < a.Length; i++) {
            aq.Enqueue(a[i]);
    }
    for (int i = 0; i < b.Length; i++) {
            bq.Enqueue(b[i]);
    }
    for (int i = 0; i < c.Length; i++) {
            cq.Enqueue(c[i]);
    }
    char cur = aq.Dequeue();
    while (true) {
            if (cur == 'a') {
                    if (aq.Count == 0) {
                        return "A";
                    }
                    cur = aq.Dequeue();
            } else if (cur == 'b') {
                    if (bq.Count == 0) {
                        return "B";
                    }
                    cur = bq.Dequeue();
            } else if (cur == 'c') {
                    if (cq.Count == 0) {
                        return "C";
                    }
                    cur = cq.Dequeue();
            }
    }
}

public static void countMergeTimes(int n, int q, string[] argsS, string[] argsT) {
    Queue<string> name_array = new Queue<string>();
    Queue<int> time_array = new Queue<int>();
    int sum_time = 0;
    for (int i = 0; i < n; i++) {
        name_array.Enqueue(argsS[i]);
        time_array.Enqueue(argsT[i]);
    }
    while (name_array.First() != null) {
        string str = name_array.Dequeue();
        int tmp = time_array.Dequeue();
        if(tmp > q) {
            name_array.Enqueue(str);
            time_array.Enqueue(tmp - q);
            sum_time += q;
        } else {
            Console.Writeline(str + " " + (sum_time + tmp));
            sum_time += tmp;
        }
    }
}

public static void countMergeTimes(int N, int q, string[] argsS, string[] argsT){
    Queue<int> queue = new Queue<int>();
    Queue<string> name = new Queue<string>();
    int tlen = 0;
    for (int i=0; i<N; i++) {
            name.Enqueue(argsS[i]);
            queue.Enqueue(argsT[i]);
    }
    while (queue.Count!=0) {
            if (queue.element() > q){
                    tlen += q;
                    queue.Enqueue(queue.element() - q);
                    queue.Dequeue();
                    name.Enqueue(name.element());
                    name.Dequeue();
            } else {
                    tlen += queue.element();
                    Console.Writeline(name.element()+" "+tlen);
                    queue.Dequeue();
                    name.Dequeue();
            }
    }
}

public static void countMergeTimes(int num, int quan, string[] args){
    Queue<string[]> input = new Queue<string[]>();
    int num = int.Parse(in.next()) ;
    int quan = int.Parse(in.next());
    for (int i=0;i<2*num;i+=2) {
        string[] a = new string[2];
        a[0] = args[i];
        a[1] = args[i+1];
        input.Enqueue(a);
    }
    in.close();
    int calculate = 0;
    while (input.Count != 0){
         string[] k = input.Dequeue();
         string name =(string) k[0];
         int time =int.Parse(k[1]);
         if (time<=quan){
            calculate=calculate+time;
            Console.Writeline(name +" "+calculate);
         }
         else{
            k[1]=(time-quan).ToString();
            input.offer(k);
            calculate=calculate+quan;
         }
    }
}

public static void checkLastSame(int N, char[] S) throws IOException {
    Queue<char> deque = new Queue<char>();
    deque.Enqueue(S[0]);
    for (int i = 1; i < N; ++i) {
            if (S[i] != deque.Last()) {
                    deque.Enqueue(S[i]);
            }
    }
    Console.Writeline(deque.Count);
}

public static void checkLastSame(int N, string slims) {
    Stack<char> stack = new Stack<char>();
    foreach (char c in slims.ToCharArray()) {
        if (stack.Count == 0 || stack.Peek() != c) {
            stack.Push(c);
        }
    }
    Console.Writeline(stack.Count);
}

public static void countSameSeries(int N, int[] args) {
    Queue<List<int>> D = new Queue<List<int>>();
    List<int> tmp = new List<int>();
    for(int i=0;i<2*N;i+=2) {
            int a = args[i];
            int b = args[i+1];
            tmp.Add(a);
            tmp.Add(b);
            foreach (var item in tmp)
            {
                D.Enqueue(item);
            }
            tmp.Clear();
    }
    tmp=null;
    int cnt=0;
    while(D.Count!=0 && cnt<3){
            List<int> d =D.Dequeue();
            if(d.First()==d[1]) {
                    cnt+=1;
            }
            else {
                    cnt=0;
            }
    }
    if(cnt>=3) {
            Console.Writeline("Yes");
    }
    else {
            Console.Writeline("No");
    }
    ;
}

public static void repeatH(int n, int[] args, List<string> inputLines) {
    while (true) {
        string originalSequence = "";
        while (originalSequence.Length == 0) {
            originalSequence = inputLines.First();
            inputLines.Remove(First());
        }
        if (originalSequence.Equals("-")) {
            break;
        }
        Queue<char> chars = new Queue<char>();
        for (int i = 0; i < originalSequence.Length; i++) {
            chars.Enqueue(originalSequence[i]);
        }
        for (int i = 0; i < n; i++) {
            int h = args[i];
            for (int j = 0; j < h; j++) {
                chars.Enqueue(chars.Remove(First()));
            }
        }
        while (chars.Count > 0) {
            Console.Writeline(chars.Remove(First()));
        }
        Console.Writeline("");
    }
}

public static void doBackspace(char[] line) {
    Queue<char> q = new Queue<char>();
    for (int i = 0; i < line.Length; i++) {
            if (line[i] == '0') {
                    q.Enqueue('0');
            } else if(line[i] == '1'){
                    q.Enqueue('1');
            } else if(line[i] == 'B'){
                    if (q.Count != 0) {
                            q.RemoveLast();
                    } 
            }
    }
    foreach (char char in q) {
            Console.Writeline(character);
    }
    Console.Writeline();
}

public static void countNotEqual(string s, int n){
    char[] c = s.ToCharArray();
    int count = 0;
    Stack<char> deque = new Stack<char>();
    for(int i = 0;i<n;i++){
        if(deque.Peek() == null){
            deque.Push(s[i]);
        }else{
            if(deque.Peek() == s[i]){
                deque.Push(s[i]);
            }
            else{
                deque.Pop();
                count++;
            }
        }
    }
    Console.Writeline(count * 2);
}

public static void calDpMod(int n, int m, string args[]){
    final int modder=1000000007;
    Queue<int> h=new Queue<int>(m);
    for(int i=0;i<m;i++){
      h.Enqueue(args[i]);
    }
    int dp[]=new int[n+1+2];
    Array.Fill(dp,0);
    dp[0]=1;
    for(int i=0;i<=n;i++){
      if(h.First()!=null&&h.First()==i){
        h.Dequeue();
        dp[i]=0;
      }else{
        dp[i+1]=(dp[i+1]+dp[i])%modder;
        dp[i+2]=(dp[i+2]+dp[i])%modder;
      }
    }
    Console.Writeline(dp[n]);
  }

  public static void calDpMod(int n, int m, string[] args){
    int mod=1000_000_007;
    int[] a=new int[n+1];
    Queue<int> dq=new Queue<int>();
    for(int i=0;i<m;i++){
      dq.Enqueue(args[i]);
    }
    dq.Enqueue(n*2);
    a[0]=1;
    if(dq.Peek()==1){
      a[1]=0;
      dq.Dequeue();
    }else{
      a[1]=1;
    }
    for(int i=2;i<=n;i++){
      if(i==dq.peek()){
        a[i]=0;
        dq.Dequeue();
      }else{
        a[i]=(a[i-1]+a[i-2])%mod;
      }
    }
    Console.Writeline(a[n]);
  }

  public int checkLast( string nextLine) {
    char[] s = nextLine.ToCharArray();
    int n = s.Length;
    Stack<bool> stack = new Stack<bool>();
    for (int i = 0; i < n; i++) {
        bool cur = s[i] == '1';
        if (stack.Count == 0 || stack.Peek() == cur) {
            stack.Push(cur);
        } else {
            stack.Pop();
        }
    }
    int answer = n - stack.Count;
    return answer;
}

public static void calculator(List<string> args){
    Stack<int> deq = new Stack<int>();
    string str = "";
    int a = 0, b = 0;
    while(args.Count > 0){
            str = args.First();
            args.Remove(First());
            if(str.Equals("+")){
                    a = deq.Pop();
                    b = deq.Pop();
                    deq.Push(a + b);
            }else if(str.Equals("-")){
                    a = deq.Pop();
                    b = deq.Pop();
                    deq.Push(b - a);
            }else if(str.Equals("*")){
                    a = deq.Pop();
                    b = deq.Pop();
                    deq.Push(a * b);
            }else if(str.Equals("/")){
                    a = deq.Pop();
                    b = deq.Pop();
                    deq.Push(b / a);
            }else{
                    deq.Push(int.Parse(str));
            }
    }
    Console.Writeline(deq.Peek());
}

public static void getExtinctSize(int[] d) {
    Set<int> setD = new SortedSet<int>(d);
    Console.Writeline(setD.Count);
}

public void getMaxValueKey( int n, string[] input) {
    Dictionary<string, int> map = new Dictionary<string, int>();
    int max = 0;
    for (int i = 0; i < n; i++) {
        string s = input[i];
        map[s] = map.GetValueOrDefault(s, 0) + 1;
        max = Math.Max(max, map[s]);
    }
    SortedSet<string> h = new SortedSet<string>();
    foreach (var e in map) {
        if (e.Value == max) {
            h.Add(e.Key);
        }
    }
    while (h.Count != 0) {
        Console.WriteLine(h.DequeueFirst());
    }
}

public void calDifference( int n, int l) {
    int sum = 0;
    SortedSet<int> negatives = new SortedSet<int>();
    SortedSet<int> positives = new SortedSet<int>();
    for (int i = 0; i < n; i++) {
        sum += (l + i);
        if (l + i < 0) {
            negatives.Add(l + i);
        } else {
            positives.Add(l + i);
        }
    }
    if (positives.Contains(0)) {
        Console.WriteLine(sum);
    } else {
        if (negatives.Count == 0) {
            Console.WriteLine(sum - positives.first());
        } else if (positives.Count == 0) {
            Console.WriteLine(sum - negatives.last());
        } else {
            if (Math.Abs(negatives.last()) < positives.first()) {
                Console.WriteLine(sum - negatives.last());
            } else {
                Console.WriteLine(sum + positives.first());
            }
        }
    }
}

public static void getFirstBelow(int N, int T, string[] args) throws IOException {
    stringTokenizer st;
    SortedSet<int> set = new SortedSet<int>();
    for(int i=0;i<N;i++) {
            st = new stringTokenizer(args[i]);
            int c = parseInt(st.nextToken());
            int t = parseInt(st.nextToken());
            if(t <= T) {
                    set.Add(c);
            }
    }
    if(set.Count == 0) {
            Console.Writeline("TLE");
    }else {
            Console.Writeline(set.first());
    }
}

public void getMaxValueKey(int n,  string[] input) {
    Dictionary<string, int> map = new Dictionary<string, int>();
    int max = 0;
    for (int i = 0; i < n; i++) {
        string s = input[i];
        map[s] = map.GetValueOrDefault(s, 0) + 1;
        max = Math.Max(max, map[s]);
    }
    SortedSet<string> h = new SortedSet<string>();
    foreach (var e in map) {
        if (e.Value == max) {
            h.Add(e.Key);
        }
    }
    while (!h.Count != 0) {
        Console.WriteLine(h.DequeueFirst());
    }
}

public static void getMax(string[] args) throws IOException 
{
        Reader sc=new Reader();
        int t=1;
        long x,x0,x1,x2;long y,y0,y1,y2;int s,s0,s1,s2;
        int n,m;int a[],b[],in[],in1[];
        long k,l;bool b1,b2;string ss1[],ss;
        List<List<int>> ll=new List<List<int>>();
        List<int> a1=new List<int>();
        List<int> a2=new List<int>();
        List<int> a3=new List<int>();
        Queue<int> deq=new Queue<int>();
        SortedSet<int> h0=new SortedSet<int>();
        SortedSet<int> h1=new SortedSet<int>();
        Dictionary<int,int> h=new Dictionary<int,int>();
        try{
        while (t-->0)
        {
            x=sc.nextLong();x0=sc.nextLong();
            x1=sc.nextLong();x2=sc.nextLong();
            y=x*x1;y0=x*x2;y1=x0*x1;y2=x0*x2;
            k=Math.Max(y,y0);l=Math.Max(y1,y2);
             Console.WriteLine(Math.Max(k,l));
            h0.Clear();ll.Clear();a1.Clear();a2.Clear();h1.Clear();
        }
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
}

public static void countMaxVote(string[] S) {
Array.Sort(S);
SortedSet<string> s = new SortedSet<string>();
int c = 1;
int M = 1;
for(int i=0;i<N-1;i++){
    if(S[i].Equals(S[i+1])){
        c++;
    }
    else{
        if(c>M){
            s.Clear();
            s.Add(S[i]);
            M = c;
        }
        else if(c==M){
            s.Add(S[i]);
            M = c;
        }
        c = 1;
    }
}
if(c>M){
    s.Clear();
    s.Add(S[N-1]);
}
else if(c==M){
    s.Add(S[N-1]);
}
foreach(string a in s){
    Console.WriteLine(a);
}
    out.flush();
}

public static void countMaxVote(int N, string[] args) throws IOException {
    Dictionary<string, int> map = new Dictionary<string, int>();
    for(int i = 0; i < N; i++){
        string s = args[i];
        map[s] = map.GetValueOrDefault(s, 0) + 1;
    }
    SortedSet<string> set = new SortedSet<string>();
    int maxVote = 0;
    foreach(string s in map.Keys){
        int vote = map[s];
        if(vote > maxVote){
            set.Clear();
            maxVote = vote;
            set.Add(s);
        }
        else if(vote == maxVote){
            set.Add(s);
        }
    }
    foreach(string s in set){
         Console.WriteLine(s);
    }
}

public static void countDivide(int n){
    int cnt = 0;
    Set<int> set = new SortedSet<int>();
    for(int i = 1; i <= n; i+=2){
      int tmp = i;
      for(int j = 1; j <= Math.Sqrt(tmp); j++){
        if(tmp % j == 0){
          set.Add(tmp);
          set.Add(j);
          set.Add(tmp / j);
        }
      }
      if(set.Count == 8){
        cnt++;
      }
      set.Clear();
    }
    Console.Writeline(cnt);
  }

  public static void getMaxCountKey(int n, string input[]){
    Dictionary<string, int> m = new Dictionary<string, int>();
    Dictionary<int, Set<string>>  ml = new Dictionary<int, Set<string>>();
    for(int i=0;i<=n;i++) ml[i] = new HashSet<string>();
    int max = 0;
    for(int i=0;i<n;i++){
            string Keyword = input[i];
            int count = m.GetValueOrDefault(Keyword, 0) + 1;
            m[Keyword] = count;
            max = Math.Max(max, count);
            Set<string> ln = ml[count];
            ln.Add(Keyword);
    }
    SortedSet<string> mySortedSet = new SortedSet<string>();
    mySortedSet.Add(ml[max]);
    foreach(string ans in mySortedSet){
            Console.Writeline(ans);
    }
}

public void countArray(int n, int[] a) {
    SortedSet<int> set = new SortedSet<int>();
    set.Add(1);
    int now = 1;
    for (int i = 0; i < n; i++) {
        now = a[now - 1];
        if (now == 2) {
            Console.WriteLine(set.Count);
            return;
        } else if (set.Contains(now)) {
            Console.WriteLine(-1);
            return;
        }
        set.Add(now);
    }
}

public static void isRepeated(int A, int B, int C) {
    Set<int> set = new SortedSet<int>();
    set.Add(A);
    set.Add(B);
    set.Add(C);
    if(set.Count==2) {
            Console.Writeline("Yes");
    } else {
            Console.Writeline("No");
    }
}

public static void getExtinctSize(int N, string[] args) {
    Set<string> items = new SortedSet<string>();
    for(int i = 0; i < N; i++) {
            items.Add(args[i]);
    }
    Console.Writeline(items.Count);
}

public static void getExtinctSize(int n, string[] args) {
    SortedSet<string> vals = new SortedSet<string>();
    for(int i = 0; i< n; i++){
            vals.Add(args[i]);
    }
    Console.Writeline(vals.Count);
}

public static void getExtinctSize(int n, string args[])throws Exception
{
    SortedSet<string> set=new SortedSet<string>();
    for(int i=0;i<n;i++)
    {
        string s=args[i];
        set.Add(s);
    }
     Console.WriteLine(set.Count);
}

void getExtinctSize(int n, string args[]){
    SortedSet<string> s = new SortedSet<string>();
    for(int i = 0; i < n; i++) s.Add(args[i]);
    Console.Writeline(s.Count);
}

public static void noRepeated()throws IOException
    {
        int n=ni();
        SortedSet<int> set = new SortedSet<int>();
        for(int i=1;i<=n;i++){
                set.Add(ni());
        }
        if(set.Count==n)
                pn("YES");
        else
                pn("NO");
    }

    static void countRepeated() throws IOException {
        int n = nextInt();
        int k = nextInt();
        SortedSet<int> tr = new SortedSet<int>();
        for (int i = 0; i < k; i++) {
            int l = nextInt();
            for (int j = 0; j < l; j++) {
                tr.Add(nextInt());
            }
        }
        Console.WriteLine(n-tr.Count);
    }

    public static void countNoRepeated(int n, int[] d ) {
        Set<int> setD = new SortedSet<int>(d);
        Console.Writeline(setD.Count);
    }

    public static void isKukuContained(int N) {
        Set<int> kuku = new SortedSet<int>();
        for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {
                        kuku.Add(i * j);
                }
        }
        Console.Writeline(kuku.Contains(N)? "Yes" : "No");
        ;
}

public static void countContains(int n, int q, int[] inputB, int[] inputC) {
    SortedSet<int> st = new SortedSet<int>();
    for(int i=0;i<n;i++){
        int b=inputB[i];
        st.Add(b);
    }
    int ans=0;
    for(int i=0;i<q;i++){
    int c=inputC[i];
    if(st.Contains(c)) ans++; 
    }
    Console.Writeline(ans);
}

public int countInput(int n, int[] a) {
    SortedSet<int> set = new SortedSet<int>();
    set.Add(1);
    int now = 1;
    for (int i = 0; i < n; i++) {
        now = a[now - 1];
        if (now == 2) {
            return set.Count;
        } else if (set.Contains(now)) {
            return -1;
        }
        set.Add(now);
    }
}

public void calDifference( int n, int l) {
    int sum = 0;
    SortedSet<int> negatives = new SortedSet<int>();
    SortedSet<int> positives = new SortedSet<int>();
    for (int i = 0; i < n; i++) {
        sum += (l + i);
        if (l + i < 0) {
            negatives.Add(l + i);
        } else {
            positives.Add(l + i);
        }
    }
    if (positives.Contains(0)) {
        Console.WriteLine(sum);
    } else {
        if (negatives.Count == 0) {
            Console.WriteLine(sum - positives.first());
        } else if (positives.Count == 0) {
            Console.WriteLine(sum - negatives.last());
        } else {
            if (Math.Abs(negatives.last()) < positives.first()) {
                Console.WriteLine(sum - negatives.last());
            } else {
                Console.WriteLine(sum + positives.first());
            }
        }
    }
}

public static void countContains(int n , int[] args) {
    Set<int> T = new SortedSet<int>();
    for(int i=0;i<n;i++){
            T.Add(args[i]);
    }
    int p = sc.nextInt();
    int cnt=0;
    for(int i=0;i<p;i++){
            int t= sc.nextInt();
            if(T.Contains(t)){
                    cnt++;
            }
    }
    Console.Writeline(cnt);
}

public static int getMinDifference(string str[], int x, int n)throws Exception
    {
        SortedSet<int> ts=new SortedSet<int>();
        for(int i=0;i<=101;i++)
            ts.Add(i);
        for(int i=0;i<n;i++)
        ts.Remove(new int(int.Parse(str[i])));
        int t1=ts.GetViewBetween(ts.Min, x).Max;
        int t2=ts.GetViewBetween(x, ts.Max).Min;
        if((int)Math.Abs(t1-x)<(int)Math.Abs(t2-x))
        return t1;
        else if((int)Math.Abs(t1-x)>(int)Math.Abs(t2-x))
        return t2;
        else
        return Math.Min(t1,t2);
    }

    public static int sumOp(int n, int[] h) {
        int op = 0;
        while(true){
            SortedSet<int> st = new SortedSet<int>();
            int prev = 0;
            for(int i = 0; i<n; i++){
                if(i == n-1){
                    st.Add(h[i]);
                    while(st.Count != 0 && st.first() == 0){
                        st.Remove(st.first());
                    }
                    if(st.Count != 0){
                        int minval = ((SortedSet<int>) st).first();
                        op+=minval;
                        for(int j = prev; j<=i; j++){
                            if(h[j]!=0)h[j] -= minval;
                        }
                        st.Clear();
                    }
                    prev = i+1;
                }
                else if(h[i] == 0 && st.Count != 0){
                    while(st.Count != 0 && st.first() == 0){
                        st.Remove(st.first());
                    }
                    if(st.Count != 0){
                        int minval = ((SortedSet<int>) st).first();
                        op+=minval;
                        for(int j = prev; j<=i; j++){
                            if(h[j]!=0)h[j] -= minval;
                        }
                        st.Clear();
                    }
                    prev = i+1;
                }
                else if(h[i] == 0 && st.Count == 0)prev+=1;
                else if(!st.Contains(h[i]) && h[i] != 0) st.Add(h[i]);
                else continue;
            }
            bool ok = true;
            for(int i = 0; i<n; i++){
                if(h[i]>0)ok = false;
            }
            if(ok)break;
        }
        return op;
    }

    public static void countBelow(int n, int[]in) throws Exception {
        int ans=0;
        SortedSet<int>t=new SortedSet<int>();
        for(int i=0;i<n;i++) {
                if(t.GetViewBetween(t.Min, in[i]).Max ==null) {
                        ans++;
                }
                t.Add(in[i]);
        }
        return ans;
}

public static void convertstring(string[] args) throws java.lang.Exception { 
    Reader pm =new Reader(); 
    int t = 1;
    while(t-- > 0){
        long n = pm.nextLong();
        SortedSet<long> l = new SortedSet<long>();
        SortedSet<long> r = new SortedSet<long>();
        l.Add(1l);
        r.Add(26l);
        Dictionary<long , int> hm = new Dictionary<long , int>();
        hm[1l] = 1;
        int pow = 2;
        while(pow < 11) {
            l.Add(r.last() + 1);
            long toAdd = (long)Math.Pow(26, pow) + l.last() - 1;
            r.Add(toAdd);
            hm[l.last()] = pow;
            pow++;
        }
        long low = l.GetViewBetween(l.Min, n).Max;
        int pg = hm[low];
        long got = (long)Math.Pow(26, pg) + 1;
        StringBuffer sb = new StringBuffer();
        while(pg-- > 0) 
            sb.Append('a');
        long dif = n - low;
        int ind = sb.Length-1;
        while(dif-- > 0) {
            char pre = sb[ind];
            if(pre == 'z'){
                ind--;
                if(ind < 0)
                    break;
            }
            int prn = (int)pre;
            sb.SetCharAt(ind, (char)(prn+1));
        }
        Console.Writeline(indexToColumnItr(n, ALPHABET).ToLower());
    }
}

    public int getCeilingDifference(int n, int a[], OutputWriter w) {
        SortedSet<int> ts[] = new SortedSet[n + 1];
        for (int i = 0; i <= n; i++) {
            ts[i] = new SortedSet<int>();
        }
        for (int i = 0; i < n; i++) {
            ts[a[i]].Add(i);
        }
        if (ts[1].Count == 0) {
            w.printLine(-1);
            return;
        }
        int init = 0, check = 0;
        for (int i = 1; i <= n; i++) {
            if (ts[i].GetViewBetween(init, ts[i].Max).Min != null) {
                init = ts[i].GetViewBetween(init, ts[i].Max).Min;
            } else {
                return n - i + 1;
            }
        }
        return 0;
    }

    public static void getCeilingN(int N) {
        SortedSet<int> ts = new SortedSet<int>();
        for (int i = 1; i <= 9; i++) {
                ts.Add(111*i);
        }
         Console.WriteLine(ts.GetViewBetween(N, ts.Max).Min);
}

public static void hasCeiling(int k, int x1, int x2, int x3, int x4, int x5) {
    SortedSet<int> tset=new SortedSet<int>();
    tset.Add(x1);
    tset.Add(x2);
    tset.Add(x3);
    tset.Add(x4);
    tset.Add(x5);
    int first=tset.first();
    if(tset.GetViewBetween(first+k+1, tset.Max).Min!=null) {
            Console.Writeline(":(");
    }else {
            Console.Writeline("Yay!");
    }
}

public void checkstringLength(Stirng S) {
    Stack<int> stack = new Stack<int>();
    stack.Push(0);
    bool ans = false;
    while(stack.Count != 0) {
            int i = stack.Pop();
            if(i == S.Length) {
                    ans = true;
                    break;
            }
            for(int j=0; j<4; j++) {
                    if(i+P[j].Length <= S.Length && P[j].Equals(S.Substring(i, i+P[j].Length))) {
                            stack.Push(i+P[j].Length);
                    }
            }
    }
    if(ans) Console.Writeline("YES");
    else Console.Writeline("NO");
}

public static void calHalfSum(int num){
    LinkedList<double> values = new LinkedList<double>();
    Stack<double> stack = new Stack<double>();
    for(int i = 0; i < num; i++){
            values.Add(scan.nextdouble());
    }
    values.Sort();
    stack.Push(values.Remove(First()));
    while(values.Count != 0){
            stack.Push(stack.Remove(First() + values.Dequeue()) / 2.0);
    }
    Console.Writeline(stack.Remove(First()));
}

public static void calRemain(List<string> args) {
    List<int> ansA = new List<int>();
    List<int> ansB = new List<int>();
    while(sc.hasNext()){
            int m = args.First();
            args.Remove(First());
            int n = args.First();
            args.Remove(First());
            if(n>m){
                    int l = m;
                    m=n;
                    n=l;
            }
            int a = m;
            int b = n;
            while(n!=0){
                    int l = n;
                    n = m%n;
                    m = l;
            }
            ansA.Insert(0, m);
            ansB.Insert(0, (a/m)*b);
    }
    int num = ansA.Count;
    for(int i=0;i<num;i++){
            Console.Writeline(ansA.RemoveLast() + " " + ansB.RemoveLast());
    }
}

public static void reverseInput(List<string> args) {
    List<string> ans = new List<string>();

    while(args.Count > 0){
            string s = args.First();
            args.Remove(First());
            StringBuffer t = new StringBuffer(s);
            t.reverse();
            ans.Insert(0,t.ToString());
    }
    int num = ans.Count;
    for(int i=0;i<num;i++){
            Console.Writeline(ans.RemoveLast());
    }
}

public static void toSameTop( int N, string slims) {
    Stack<char> stack = new Stack<char>();
    foreach (char c in slims.ToCharArray()) {
        if (stack.Count == 0 || stack.Peek() != c) {
            stack.Push(c);
        }
    }
    Console.Writeline(stack.Count);
    in.close();
}

public static void calculator(List<int> intList, Stack<string> args) {
    Stack<int> a = new Stack<int>();
    while(args.Count > 0){
            if(intList.Count > 0){
                    a.Push(intList.First());
                    intList.Remove(First());
            }else{
                    int o1 = a.Pop();
                    int o2 = a.Pop();
                    switch(args.First()[0]){
                            case '+':
                                    a.Push(o1 + o2);
                                    args.Pop();
                                    break;
                            case '-':
                                    a.Push(o2 - o1);
                                    args.Pop();
                                    break;
                            case '*':
                                    a.Push(o1 * o2);
                                    args.Pop();
                                    break;
                            default:
                                    args.Pop();
                                    break;
                    }
            }
    }
    Console.Writeline(a.Pop());
}

@Override
                        public List<int> next() {
                                out:
                                while (ist.Count != 0) {
                                        int k = ist.Pop();
                                        if (k != -1) {
                                                used[k] = false;
                                                perm.RemoveAt(perm.Count - 1);
                                        } else {
                                                int pos = perm.Count;
                                                if (pos == n) {
                                                        cnt++;
                                                        return perm;
                                                }
                                        }
                                        for (int i = k + 1; i < n; i++) {
                                                if (!used[i]) {
                                                        ist.Push(i);
                                                        used[i] = true;
                                                        perm.Add(i);
                                                        ist.Push(-1);
                                                        continue out;
                                                }
                                        }
                                }
                                return null;
                        }

                        public static void calHalfSum(int num, double[] args){
                            LinkedList<double> values = new LinkedList<double>();
                            Stack<double> stack = new Stack<double>();
                            for(int i = 0; i < num; i++){
                                    values.Add(args[i]);
                            }
                            values.Sort();
                            stack.Push(values.Dequeue());
                            while(values.Count != 0){
                                    stack.Push((stack.Pop() + values.Dequeue()) / 2.0);
                            }
                            Console.Writeline(stack.Pop());
                    }
                    
                    public static void totalDiff(int n, int q, string[] argsP, int[] argsT){
                        Queue<string> P = new Queue<string>();
                        Queue<int> T = new Queue<int>();
                        for(int i=0; i<n; i++){
                                P.Enqueue(argsP[i]);  
                                T.Enqueue(argsT[i]);
                        }
                        int total=0;
                        while ( P.Count != 0 ) {
                                string p= P.Dequeue();
                                int t= T.Dequeue();
                                if(q<t) { T.Enqueue(t-q); P.Enqueue(p); total+= q; }
                                else { total+= t;  Console.Writeline(p +" "+ total); } 
                        }
                }
    
                public string doBackspace(char[] s) {
                    Stack<int> stack = new Stack<int>();
                    foreach (char c in s) {
                            if (c == '0') {
                                    stack.Push(0);
                            } else if (c == '1') {
                                    stack.Push(1);
                            } else if (c == 'B') {
                                    if (stack.Count == 0) continue;
                                    stack.Pop();
                            }
                    }
                    StringBuilder sb = new StringBuilder();
                    while (stack.Count != 0) {
                            sb.Append(stack.Pop());
                    }
                    return sb.reverse().ToString();
            }

            public static void countDifferentLength(string s) {
                Stack<char> stack = new Stack<char>();
                foreach (char c in s.ToCharArray()) {
                  if (stack.Count != 0 && stack.First() != c) {
                    stack.Pop();
                  } else {
                    stack.Push(c);
                  }
                }
                Console.Writeline(s.Length - stack.Count);
              }

              public static void calTime(int n, int q, int TIME, string[] nameList, int[] timeList) {
                Queue<string> name=new Queue<string>();Queue<int>time=new Queue<string>();
                for(int i=0;i<n;i++) {
                        name.Enqueue(nameList[i]);time.Enqueue(timeList[i]);
                }
                while(name.First()!=null) {
                        string str=name.Dequeue();int t=time.Dequeue();
                        if(t>q) {
                                name.Enqueue(str);time.Enqueue(t-q);
                                TIME+=q;
                        }
                        else{
                                Console.Writeline(str+" "+(TIME+t));
                                TIME+=t;
                        }
                }
        }

        public static void checkSameTop(int N, string slims) {
            Stack<char> stack = new Stack<char>();
            foreach (char c in slims.ToCharArray()) {
                if (stack.Count == 0|| stack.Peek() != c) {
                    stack.Push(c);
                }
            }
            Console.Writeline(stack.Count);
        }

        public static void countEqual(string nextLine) {
            StringBuilder s = new StringBuilder(nextLine);
            Stack<string> stack = new Stack<string>();
            for(int i=0; i<s.Length; i++) {
                    if(stack.Count==0) {
                            stack.Push(s.Substring(i, i+1));
                    }
                    else {
                            if(!stack.First().Equals(s.Substring(i, i+1))) {
                                    stack.Pop();
                            }
                            else {
                                    stack.Push(s.Substring(i, i+1));
                            }
                    }
            }
            Console.Writeline(s.Length-stack.Count);
    }

    public static void countEqual(List<string> args) {
        while (args.Count > 0) {
          string S = args.First();
          args.Remove(First());
          Stack<char> stack = new Stack<char>();
          for (int i = 0; i < S.Length; ++i) {
            char cube = S[i];
            if (stack.Count == 0) {
              stack.Push(cube);
            } else if (cube == '1' && stack.First() == '0') {
              stack.Pop();
            } else if (cube == '0' && stack.First() == '1') {
              stack.Pop();
            } else {
              stack.Push(cube);
            }
          }
          Console.Writeline(S.Length - stack.Count);
        }
      }

      public static void calculator(List<string> args) {
        Stack<int> numbers = new Stack<int>();
        string str;
        int a = 0;
        int b = 0;
        while(args.Count > 0) {
                str = args.First();
                args.Remove(First());
                switch(str) {
                        case "+":
                                a = numbers.Pop();
                                b = numbers.Pop();
                                numbers.Push(a + b);
                                break;
                        case "-":
                                b = numbers.Pop();
                                a = numbers.Pop();
                                numbers.Push(a - b);
                                break;
                        case "*":
                                a = numbers.Pop();
                                b = numbers.Pop();
                                numbers.Push(a * b);
                                break;
                        default:
                                numbers.Push(int.Parse(str));
                }
        }
        Console.Writeline(numbers.First());
}

private static bool isEnd() {
    return Qmap[CURRENT_STATE].Count == 0;
}

public void getMaxCountKey(int n,string[] input) {
    Dictionary<string, int> map = new Dictionary<string, int>();
    int max = 0;
    for (int i = 0; i < n; i++) {
        string s = input[i];
        map[s] = map.GetValueOrDefault(s, 0) + 1;
        max = Math.Max(max, map[s]);
    }
    SortedSet<string> h = new SortedSet<string>();
    foreach (var e in map) {
        if (e.Value == max) {
            h.Add(e.Key);
        }
    }
    while (h.Count != 0) {
        Console.WriteLine(h.DequeueFirst());
    }
}

public static void getMaxCountKey(int n, string[] input) {
    Dictionary<string,int> s = new LinkedDictionary<string,int>();
    for(int i = 0; i < n; i++) {
            string temp = input[i];
            if(s.ContainsKey(temp)) {
                    int c = s[temp]+1;
                    s[temp] = c;
            }
            else {
                    s[temp] = 1;
            }
    }
    Dictionary<string,int> ans = new SortedDictionary<string,int>();
    int count = 0;
    foreach(string key in s.Keys) {
            if(count < s[key]) {
                    ans.Clear();
                    count = s[key];
                    ans[key] = count;
            }
            else if(count==s[key]) {
                    ans[key] = count;
            }
    }
    foreach(string key in ans.Keys) {
            Console.Writeline(key);
    }
}

public static void checkHigher(string[] args) {
    FS in = new FS();
    Dictionary<int, SortedSet<int>> map;
    map = new Dictionary<int, SortedSet<int>>();
    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            map.TryAdd(a, new SortedSet<int>());
            map[a].Add(i);
            map[a].Add(n + 1);
    }
    int k = 0, l = -1;
    while (true) {
            if (!map.ContainsKey(k + 1))
                    break;
            if (map[k + 1].higher(l) != (n + 1)) {
                    l = map[k + 1].higher(l);
                    k++;
            }
            else
                    break;
    }
    int ans = n - k;
    if (l == -1)
            ans = l;
    Console.Writeline(ans);
}

public Dictionary<int,int> factorCount(int i){
    Dictionary<int,int> res = new Dictionary<int,int>();
    while(i!=1){
        res.TryAdd(f[i],0);
        res[f[i]] = res[f[i]]+1;
        i /= f[i];
    }
    return res;
}

public static void countSquares(int n, int d, int dp[][]) {
    Dictionary<int,int> squares = new Dictionary<int,int>();
    for (int i = 1; i <= 200; i++) {
        squares.TryAdd(i*i,i);
    }
    int counter = 0;
    for (int i = 0; i < n; i++) {
        for (int j = i+1; j < n; j++) {
            int x = 0;
            for (int k = 0; k < d; k++) {
                x+=Math.Pow(dp[i][k] - dp[j][k],2);
            }
            if(squares.ContainsKey(x)){
                counter++;
            }
        }
    }
    Console.Writeline(counter);
}

public static void calDiff(long a, long b) {
    long diff = b-a;
    if(diff >= 2019){
        Console.Writeline(0);
    }else{
        long min = int.MaxValue;
        Dictionary<long ,int> ab = new Dictionary();
        for (long i = a; i <= b; i++) {
            ab.TryAdd(i % 2019,1);
        }
        List<long> list = new List<long>(ab.Keys);
        for (int i = 0; i < list.Count; i++) {
            for (int j = i + 1; j < list.Count; j++) {
                min = Math.Min((list[i] * list[j]) % 2019, min);
            }
        }
        Console.Writeline(min);
    }
}

public static void getExtinctSize(int a, string args[])
    {
        Dictionary<string,int> map = new Dictionary<string, int>();
        for(int i=0;i<a;i++)
        {
            map.TryAdd(args[i],1);

        }
        Console.Writeline(map.Count);
    }


    public static void calHalfSum(int N , string args[]){
        Dictionary<string,int> num = new Dictionary<string, int>();
        for (int i = 0; i < N; i++) {
            string s = args[i];
            int[] count = new int[26];
            for (int j = 0; j < 10; j++) {
                char sj = s[j];
                count[sj-'a']++;
            }
            string val = "";
            for(int j=0; j<26; j++){
                val += ('a'+count[j]).ToString();
            }
            num.TryAdd(val, 0);
            num[val] = num[val] + 1;
        }
        long ans = 0;
        foreach(int n in num.values()){
            ans += (long)n*(long)(n-1)/2;
        }
        Console.Writeline(ans);
    }

    public static void countRepeated(string[] args) throws Exception {
        long count = new Long(0);
        int n = int.Parse(stdConsole.ReadLine());
        Dictionary<string, int> map = new Dictionary<string, int>();
        string line;
        while ((line = stdConsole.ReadLine()) != null) {
            char[] chars = line.ToCharArray();
            Array.Sort(chars);
            string newStr = new string(chars);
            int temp = map[newStr];
            if (temp == null) {
                map[newStr] =1;
            } else {
                count += temp;
                map[newStr] = temp+1;
            }
        }
        Console.Writeline(count);
    }

    public static void countRepeated(int N, string args[]) {
        Dictionary<string, int> map = new Dictionary<string, int>();
        long ans = 0;
        for(int i = 0; i < N; i++) {
            string line = args[i];
            char[] c = line.ToCharArray();
            Array.Sort(c);
            string sortedLine = new string(c);
            if(map.ContainsKey(sortedLine)) {
                ans += map[sortedLine];
                map[sortedLine] = map[sortedLine] + 1;
            } else {
                map[sortedLine] = 1;
            }
        }
        Console.Writeline(ans);
    }

    public static void calHalfSum(int n, string[] args) {
        long ans = 0;
        Dictionary<string, long > map = new Dictionary<string, long >();
        for(int i = 0; i < n; i++) {
            char[] ca = args[i].ToCharArray();
            Array.Sort(ca);
            string s = ca.ToString();
            if(map.ContainsKey(s)) map[s] = map[s] + 1;
            else map[s] = 1L;
        }
        foreach(string key in map.Keys) {
            ans += map[key] * (map[key] - 1) / 2;
        }
        Console.Writeline(ans);
    }

    public static void countRepeated(long N, string[] input) {
        Dictionary<string, int> map = new Dictionary<string, int>();
        long count = 0;
        for (int i = 0; i < N; i++) {
                char[] c = input[i].ToCharArray();
                Array.Sort(c);
                string s = new string(c);
                int n;
                if (map.ContainsKey(s)) {
                        n = map[s];
                        map[s] = n+1;
                        count += n+1;
                }
                else {
                        map[s] = 0;
                }
        }
        Console.Writeline(count);
}

public static int findKey(Dictionary<int, int> hmap, int a, int i) {
    if(hmap.ContainsKey(a)) {
            return i;
    }
    hmap[a] = i;
    return findKey(hmap,solve(i+1,a),i+1);
}

public static void countContains(int n) throws Exception {
    Dictionary<int,int> po=new Dictionary<int,int>();
    int count=1;
    for(;!(po.ContainsKey(n));count++){
        po[n] = n;
        if(n%2==0)n/=2;
        else n=n*3+1;
    }
    Console.Writeline(count);
}

public static void getExtinctSize(int N, string args[]){
    Dictionary<string,string> map = new Dictionary<string,string>();
    for (int i = 0; i < N; i++) {
        string k = args[i];
        if(!map.ContainsKey(k)){
            map[k] = "a";
        }   
    Console.Writeline(map.Count);
}
}

public static void countKeys(int n, string[] arg) {
    List<string> list = new List<string>();
    Dictionary<string, int> map = new Dictionary<string, int>();
    for(int i = 0; i < n; i++){
            string s = arg[i];
            if(map.ContainsKey(s)){
                    int v = map[s];
                    map[s] = v+1;
            } else {
                    map[s] = 1;
            }
    }
    Console.Writeline(map.Keys.Count);
}

public static void countKeys(string[] args) {
    int n = GetInput.getInt();
    Dictionary<string , int> hashDictionary = new Dictionary<string, int>();
    while(n-->0) {
        string key = GetInput.getInputstring().ToString();
        if (hashDictionary[key] == null) {
            hashDictionary[key] = 1;
            continue;
        }
        hashDictionary.replace(key, hashDictionary[key]+1);
    }
    Console.Writeline(hashDictionary.Count);
}

public static void getExtinctSize(int n, string args[]) {
    Dictionary<string, int> hashmap = new Dictionary<string, int>();
    for(int i = 0; i < n; i++){
      string check = args[i];
      if(!hashmap.ContainsKey(check)){
        hashmap[check] = 0;
      }
    }
    Console.Writeline(hashmap.Count);
  }

  public static void getExtinctSize(int n, string [] args)
  {
      Dictionary<string, int> map = new Dictionary<string, int>();
      for (int i = 0; i < n; i++) {
          string s = args[i];
          map[s] = map.GetValueOrDefault(s, 0) + 1;
      }
      Console.Writeline(map.Keys.Count);
  }

  public long countRepeated(int n, string[] args) throws IOException {
    Dictionary<string,int> a = new Dictionary<string, int>();
    long ans = 0;
    for (int i = 0; i < n; i++) {
        string[] s = args[i].Split("");
        Array.Sort(s);
        string ss = "";
        for (int j = 0; j < s.Length; j++) {
            ss += s[j];
        }
        if(a.ContainsKey(ss)){
            ans += a=[ss];
            a[ss] = a[ss]+1;
        }
        else {
            a[ss] = 1;
        }
    }
    return ans;
}

public static void calHalfSum(int N, string[] args) throws Exception {
    long count = 0;
    Dictionary<string, long > map = new Dictionary<string, long >(); 
    for(int i = 0; i < N; i++) {
        string s = args[i];
        char[] sArray = s.ToCharArray();
        Array.Sort(sArray);
        string sorted = new string(sArray);
        if(map.ContainsKey(sorted))
            map[sorted] = map[sorted] + 1;
        else
            map[sorted] = (long)1;
    }
    foreach(var entry in map) {
        long value = entry.Value;
        count += value * (value - 1) / 2;
    }
    Console.Writeline(count);
}

public static void isFiftyFifty(string nextLine) {
    char[] S = nextLine.ToCharArray();
    Dictionary<char, int> map = new Dictionary<char, int>();
    for (int i = 0; i < 4; i++) {
      if (map.ContainsKey(S[i])) {
        map[S[i]] = map[S[i]] + 1;
      } else {
        map[S[i]] = 1;
      }
    }
    bool isFiftyFifty = true;
    foreach (char key in map.Keys) {
      if (map[key] != 2) {
        isFiftyFifty = false;
      }
    }
    if (isFiftyFifty) {
      Console.Writeline("Yes");
    } else {
      Console.Writeline("No");
    }
  }

  public static void find2(int n, string[] args) {
    int[] a = new int[n+1];
    for (int i = 1; i < n+1; i++) {
            a[i] = int.Parse(args[i]);
    }
    int b = 1;
    int ans = -1;
    Dictionary<int, int> map = new Dictionary<int, int>();
    map[1] = 1;
    for (int i = 1; i < n + 1; i++) {
            b = a[b];
            if (b == 2) {
                    ans = i;
                    break;
            }
            if (map.ContainsKey(b)) {
                    break;
            }
    }
    Console.Writeline(ans);
}

public static void noRepeated(int N, int[] inputA) {
    Dictionary<int,int> A = new Dictionary<int,int>();
    for (int i = 0; i < N; i++){
        int a = inputA[i];
        if (A.ContainsKey(a)){
            Console.Writeline("NO");
            return;
        }
        A[a] = 0;
    }
    Console.Writeline("YES");
}

public static void countKeys(int n, string[] args) {
    Dictionary<string,int> vote = new Dictionary<string, int>();
    for(int i=0;i<n;i++){
        string name = args[i];
        if(vote.ContainsKey(name)){
            int temp = vote[name];
            vote.Remove(name);
            vote[name] = temp+1;
        }
        else{
            vote[name] = 1;
        }
    }
}

public static void countKeys(int n, string[] args) {
    Dictionary<string, int> map = new Dictionary<string, int>();
    for( int i=0; i<n; i++) {
        string str = args[i];
        int count = map[str];
        if (count == null) {
            map[str] = 1;
        } else {
            map.Remove(str);
            map[str] = count+1;
        }
    }
}

public static void getModAns(string[] args) throws Exception{
    long L = nextLong();
    long R = nextLong();
    Dictionary<int,int> map = new Dictionary<int,int>();
    for(int i=0;i<=2019;i++){
            map[i] = i;
    }
    long ans =2019;
    for(long i=L;i<R;i++){
            Dictionary<int,int> tmp = new Dictionary<int,int>();
            for(long k=i+1;k<=R;k++){
                    int x = (int)((i%2019)*(k%2019))%2019;
                    ans = Math.Min(ans, x);
                    if(tmp.ContainsKey(x)){
                            break;
                    }
                    tmp[x] = x;
            }
            foreach(int x in tmp.Keys){
                    map.Remove(x);
            }
            if(ans==0||map.Count==0){
                    break;
            }
    }
     Console.WriteLine(ans);
}

public deleteOpt(int opt1, int opt2) {
    Dictionary<int, int> map = new Dictionary<int,int>();
    map[1] = 1;
    map[2] = 2;
    map[3] = 3;
    map.Remove(opt1);
    map.Remove(opt2);
    string res = map.values().ToString();
    Console.Writeline(res.Substring(1,2));
}

public static void remove(Dictionary<int,int> hm, int val){
    hm[val] = hm[val]-1;
    if(hm[val]==0){
            hm.Remove(val);
    }
}

public static void deleteInput(int n, int k, int[] inputD) {
    Dictionary<int,int>hm=new Dictionary<int,int>();
    for(int j=0;j<n;j++)
        hm[j+1],1;
    for(int j=0;j<k;j++)
    {
        int d=inputD[i];
        for(int l=0;l<d;l++)
        {
            int m=sc.nextInt();
            if(hm[m]!=null)
                hm.Remove(m);
        }
    }
    Console.Writeline(hm.Count);
}

public static void countKeys (int N, string[] inputS) throws java.lang.Exception
        {
                Dictionary<string, int> cnt = new Dictionary<string, int>();
                for (int i = 0; i < N; ++i) {
                        string s = sorted(inputS[i]);
                        cnt[s] = cnt.GetValueOrDefault(s, 0) + 1;
                }
                long ans = 0;
                foreach (string s in cnt.Keys) {
                        ans += nc2(cnt[s]);
                }
                Console.Writeline(ans);
        }

        public static void countKeys(int N, string[] inputC) {
            long res = 0;
            Dictionary<string, int> map = new Dictionary<string, int>();
            for (int i = 0; i < N; i++) {
                char[] c = inputC[i].ToCharArray();
                Array.Sort(c);
                string s = c.ToString();
                int tmp = map.GetValueOrDefault(s, 0);
                res += tmp;
                map[s] = tmp + 1;
            }
            Console.Writeline(res);
        }

        public static void countKeys(int n, string[] args){
            long ans = 0;
            Dictionary<string, int> map = new Dictionary<string, int>();
            for(int i = 0; i < n; i++){
                string s = args[i];
                char sa[] = s.ToCharArray(); 
                Array.Sort(sa);
                string sorted = new string(sa);
                ans += map.GetValueOrDefault(sorted, 0);
                map[sorted] = map.GetValueOrDefault(sorted, 0)+1;
            }
            Console.Writeline(ans);
        }

        public static void calHalfSum(string[] args) throws Exception {
            int N = nextInt();
            Dictionary<string,int> map = new Dictionary<string, int>();
            for(int i=0;i<N;i++){
                    char[] c = nextstring().ToCharArray();
                    Array.Sort(c);
                    string s = c.ToString();
                    map[s] =  map.GetValueOrDefault(s,0)+1;
            }
            long ans = 0;
            foreach(int val in map.values()){
                    if(val!=1){
                            ans+=(long)(val)*(val-1)/2L;
                    }
            }
            Console.Writeline(ans);
    }

    public static void countFirst(int[] arr, int[][] args) {
        int sum = 0;
        Dictionary<int,int> map = new Dictionary<int,int>();
        for(int i = 0; i<arr[0]; i++) {
                int[] t = args[i];
                for(int j = 1; j<t.Length; j++) {
                        map[t[j]] = map.GetValueOrDefault(t[j],0)+1;
                        if(map[t[j]] == arr[0]) sum++;
                }
        }
        print(sum);
}

public static void sumCount(int n, string[] inputArray ) {
    char[] c = new char[10];
    string s;
    Dictionary<string, long > map = new Dictionary<string, long >();
    for (int i = 0; i < n; i++) {
            c = inputArray[i].ToCharArray();
            Array.Sort(c);
            s = new string(c);
            if (map[s] == null) {
                    map[s] = 1L;
            } else {
                    map[s] = map[s] + 1;
            }
    }

    long ans = 0;
    foreach (long v in map.values()) {
            ans += v * (v - 1) / 2;
    }
    Console.Writeline(ans);
}

public static void countRepeated(int N, string[] inputS) {
    Dictionary<string, int> map = new Dictionary<string, int>();
    long ans = 0;
    for(int i = 0; i < N; i++) {
        string line = inputS[i];
        char[] c = line.ToCharArray();
        Array.Sort(c);
        string sortedLine = new string(c);

        if(map.ContainsKey(sortedLine)) {
            ans += map[sortedLine];
            map[sortedLine] = map[sortedLine] + 1;
        } else {
            map[sortedLine] = 1;
        }
    }
    Console.Writeline(ans);
}

public void readD(string str) {
    string[] strArr = str.Split("\\s+");
    Dictionary<int, int> hist = new Dictionary<int, int>();
    int dmax = 1;
    for (int i = 0; i < N; i++) {
            int d = int.Parse(strArr[i]);
            if (hist.ContainsKey(d)) {
                    hist[d] = hist[d] + 1;
            } else {
                    hist[d] = 1;
            }
            if (d > dmax)
                    dmax = d;
    }
    int cnt = 0;
    int h = 0;
    for (int i = 0; i < dmax && h <= N / 2; i++) {
            if (hist.ContainsKey(i)) {
                    h += hist[i];
            }
            if (h == N / 2)
                    cnt++;
    }
    Console.Writeline(cnt);
}

public static void countKeys(int N, string[] args) {
                Dictionary<string, int> S = new Dictionary<string, int>();
                for (int i = 0; i < N; i++) {
                        string SS = args[i];
                        if (S.ContainsKey(SS)) {
                                S[SS] =  S[SS] + 1;
                        } else {
                                S[SS] = 1;
                        }
                }
        }

        public static void getMaxCountKey(int n, string[] args) {
            string[] s = new string[n];
            int max = 1;
            Dictionary<string, int> map = new Dictionary();
            for (int i = 0; i < n; i++) {
                s[i] = args[i];
                if (map.ContainsKey(s[i])) {
                    int v = map[s[i]] + 1;
                    map[s[i]] = v;
                    if (v > max) max = v;
                } else {
                    map[s[i]] = 1;
                }
            }
            Array.Sort(s);
            for (int i = 0; i < n; i++) {
                int v = map[s[i]];
                if (v == max) {
                    Console.Writeline(s[i]);
                }
                i += (v - 1);
            }
        }

        public static void getMaxDifference(int x, int n,int[] inputArray) {
            int max = 105;
            Set<int> set = new HashSet<int>();
            for (int i = 0; i < n; i++) {
              set.Add(inputArray[i]);
            }
            int ans = -1;
            if (set.Count == 0) {
              ans = x;
            } else {
              for (int i = 0; i <= max; i++) {
                if (!set.Contains(i) && Math.Abs(ans - x) > Math.Abs(i - x)) {
                  ans = i;
                }
              }
            }
            Console.Writeline(ans);
          }

          public static void getMinMax(int n, int[] inputArray) {
            Set<int> fixed = new HashSet<int>();
            int free = 0;
            for(int i = 0; i < n; i ++) {
                    int a = inputArray[i];
                    if(a / 400 < 8) {
                            fixed.Add(a / 400);
                    } else {
                            free ++;
                    }
            }
            int min = 0;
            int max = 0;
            if(fixed.Count == 0) {
                    min = 1;
                    max = free;
            } else {
                    min = fixed.Count;
                    max = min + free;
            }
            Console.Writeline(min + " " + max);
    }

    public static void checkContains(string s, string[] args) {
        char[] ary = s.ToCharArray();
        List<char> oary = new List<char> ({'R', 'U', 'D'});
        List<char> eary = new List<char> ({'L', 'U', 'D'});
        Set<char> hso = new HashSet<char>();
        Set<char> hse = new HashSet<char>();
        for (int i = 0; i < s.Length; i++) {
            if ((i + 1) % 2 == 0) {
                hse.Add(ary[i]);
            } else {
                hso.Add(ary[i]);
            }
        }
        hso.ExceptWith(oary);
        hse.ExceptWith(eary);
        if (hso.Count == 0 && hse.Count == 0) {
            Console.Writeline("Yes");
        } else {
            Console.Writeline("No");
        }
    }

    public static void getRetainSize(int n, int m, int[] inputArray,int[] inputArray2){
        Set<int> foods = new HashSet<int>();
        for(int i=0;i<m;i++){
          foods.Add(i);
        }
        Set<int> tmp = new HashSet<int>();
        for(int i=0;i<n;i++){
          int x=inputArray[i];
          for(int j=0;j<x;j++){
            tmp.Add(inputArray2[i*n +j]-1);
          }
          foods.retainAll(tmp);
          tmp.Clear();
        }
        Console.Writeline(foods.Count);
      }

      public void countSize8( MyScanner in) {
        int N = in.Int();
        int cnt = 0;
        Set<int> set = new HashSet<int>();
        for (int i = 105; i <= N; i += 2) {
            set.Clear();
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    set.Add(j);
                    set.Add(i / j);
                }
            }
            if (set.Count == 8) cnt++;
        }
        Console.WriteLine(cnt);
    }

    public static void isSetPrime(int n, Bigint[] inputArray) {
        Set<Bigint> set=new HashSet<Bigint>();
        int c=0;
        for(int i=1;i<=n;i++)
        {
                set.Add(inputArray[i]);
        }
        List<Bigint> bi=new List<Bigint>(set);
        int m=set.Count;
        for(int i=0;i<m;i++)
        {
                if(bi[i].isProbablePrime(10)==true)
                {
                        c++;
                }
        }
        Console.Writeline(c);
        bi.Clear();
        set.Clear();
}

public static void calDpMax(int n, int[] v, int[] c) {
    int[] values = new int[n];
    for (int i = 0; i < n; i++) values[i] = v[i] - c[i];
    Set<int> dp = new HashSet<int>();
    Set<int> ndp = new HashSet<int>();
    dp.Add(0);
    for (int i = 0; i < n; i++) {
      ndp.Clear();
      foreach (int val in dp) {
        ndp.Add(val);
        ndp.Add(val + values[i]);
      }
      dp.Clear();
      foreach (var item in ndp)
      {
        dp.addLast(item);
      }
    }
    int max = int.MaxValue;
    foreach (int val in dp) max = Math.Max(max, val);
    Console.Writeline(max);
  }

  public static void checkUpperCaseInclude(string S){
    if (S[0] == 'A'){
      int countC = 0;
      for (int i = 2; i < S.Length - 1; i++){
        if (S[i] == 'C'){
          countC++;
        }
      }
      HashSet<char> set = new HashSet<char>();
      set.Add('A');
      set.Add('C');
      if (countC == 1){
        foreach (char c in S.ToCharArray()){
          if (Char.IsUpper(c) && !set.Contains(c)){
            Console.Writeline("WA");
            return;
          }
        }
        Console.Writeline("AC");
        return;
      }
    }
    Console.Writeline("WA");
    return;
  }

  public void addChild(Node node) {
    children.Add(node);
}

public static List<int> readintList(InputReader in, int size) {
    List<int> set = new List<int>();
    for (int i = 0; i < size; i++) {
        set.Add(in.readInt());
    }
    return set;
}

static List<int> intersect(List<int> a, List<int> b) {
    List<int> res = new List<int>();
    if (b.Count != 0) {
            HashSet<int> hm = new HashSet<int>();
            foreach (int x in a)
                    hm.Add(x);
            foreach (int x in b)
                    if (hm.Contains(x))
                            res.Add(x);
    }
    return res;
}

public static void getExtinctSize(int Kuji, string[] inputArray) {
    HashSet<string> hs = new HashSet<string>();
for(int i = 1; i <= Kuji; i++) {
    string syohin = inputArray[i];
            hs.Add(syohin);
}
Console.Writeline(hs.Count);
}

private int getExtinctSize(int n, string[] a) {
    HashSet<string> set = new HashSet<string>();
    set.UnionWith(toList(a));
    return set.Count;
}

public static void getExtinctSortedSize(int n, string[] str) throws IOException{
    Set<string> set = new HashSet<string>();
    for(int i=0; i<n; ++i)
        str[i] = Console.ReadLine()();
    Array.Sort(str);
    set.UnionWith(str);
    Console.Writeline(set.Count);
}

public static void isSIze2(string s) {
    Set<string> chars = new HashSet<string>();
    chars.UnionWith(s.Split(""));
    if (chars.Count == 2) {
      Console.Writeline("Yes");
    } else {
      Console.Writeline("No");
    }
  }

  public static void calDpMax(int n, int[] v, int[] c) {
    int[] values = new int[n];
    for (int i = 0; i < n; i++) values[i] = v[i] - c[i];
    Set<int> dp = new HashSet<int>();
    Set<int> ndp = new HashSet<int>();
    dp.Add(0);
    for (int i = 0; i < n; i++) {
      ndp.Clear();
      foreach (int val in dp) {
        ndp.Add(val);
        ndp.Add(val + values[i]);
      }
      dp.Clear();
      foreach(var item in ndp) dp.AddLast(item);
    }
    int max = int.MaxValue;
    foreach (int val in dp) max = Math.Max(max, val);
    Console.Writeline(max);
  }

  public static void countContains(int n, int m, int[] inputK, input[] inputX) {
    HashSet<int> set=new HashSet<int>();
    HashSet<int> s=new HashSet<int>();
    for(int i=0;i<n;i++) {
            int k=inputK[i];
            s=new HashSet<int>();
            for(int j=0;j<k;j++) {
                    int x=inputX[i*n + k];
                    if(i==0) {
                            set.Add(x);
                            s.Add(x);
                    }else {
                            if(set.Contains(x)) {
                                    s.Add(x);
                            }
                    }
            }
            if(i!=0) {
                    set.ExceptWith(set);
                    foreach (var item in s)
                    {
                        set.AddLast(item);
                    }
            }
    }
    Console.Writeline(s.Count);
}

public static void countContains(string[] args) throws IOException {
    int input = nextInt();
    HashSet <string> kinds = new HashSet<string>();
    for (int x=0; x<input; x++) {
        string cur = next();
        if (!kinds.Contains(cur)) {
            kinds.Add(cur);
        }
    }
    Console.Writeline(kinds.Count);
}

public static void getExtinctSize(int a, string args[])
  {
    HashSet<string> set=new HashSet<string>();
    while(a>0)
    {
     string s=args[a-1];
     set.Add(s);  
      a--;
    }
    Console.Writeline(set.Count);  
  }

  public static void getExtinctSize(int times, string[] inputArray) {
    HashSet<string> kuji = new HashSet<string>();
    for(int i=0 ; i<times ; i++) {
            kuji.Add(inputArray[i]);
    }
    Console.Writeline(kuji.Count);
}

private int getExtinctSize(int n, string[] a) {
    HashSet<string> set = new HashSet<string>();
    set.UnionWith(toList(a));
    return set.Count;
}

void isSize2() throws IOException {
    Set<int> set = new HashSet<int>();
    for(int i=0;i<3;i++) set.Add(sc.nextInt());
    string ans = set.Count==2?"Yes":"No";
    Console.Writeline(ans);
}

public static void checkSuffix(string s) {
    Set<string> set = new HashSet<string>();
    set.Add("dream");
    set.Add("dreamer");
    set.Add("erase");
    set.Add("eraser");
    int idx = s.Length;
    string curr = "";
    while (idx >= 5) {
        if (set.Contains(s.Substring(idx - 5, idx))) {
            idx -= 5;
        } else if (set.Contains(s.Substring(idx - 6, idx))) {
            idx -= 6;
        } else if (set.Contains(s.Substring(idx - 7, idx))){ 
            idx -= 7;
        } else {
            break;
        }
    }
    string res =  idx == 0 ? "YES" : "NO";
    Console.Writeline(res);
}

public static void removeInput(string[] args) throws IOException {
    Writer out=new Writer(System.out);
    Reader in=new Reader(System.in);
    int ts=1;
    outer: while(ts-->0) {
            int n=in.nextInt(); int k=in.nextInt();
            Set<int> set=new HashSet<int>();
            for(int i=1; i<=n; i++) set.Add(i);
            for(int i=0; i<k; i++) {
                    int d=in.nextInt();
                    int a[]=in.readArray(d);
                    foreach(int j in a) if(set.Contains(j)) set.Remove(j);
            }
            Console.WriteLine(set.Count);
    }
    out.close();
}

public static void removeInput(int n, int k, int[] inputKI, int[] inputTemp){
    HashSet<int> sunuke = new HashSet<int>();
    for (int i = 0; i < n; i++) {
        sunuke.Add(i+1);
    }
    for (int i = 0; i < k; i++) {
        int ki = inputKI[i];

        for (int j = 0; j < ki; j++) {
            int temp = inputTemp[k*i + ki];
            if (sunuke.Contains(temp)) {
                sunuke.Remove(temp);
            }
        }
    }
    Console.Writeline(sunuke.Count);
}

public static void getMinDifference(int X, int N, int[] inputP) {
    Set<int> p = new HashSet<int>();
    for(int i = 0; i < N; i++)
            p.Add(inputP[i]);
    int ans = 0, min = int.MaxValue/2;
    for(int i = -100; i <= 200; i++)
            if(!p.Contains(i) && Math.Abs(i-X) < min) {
                    ans = i;
                    min = Math.Abs(i-X);
            }
    Console.Writeline(ans);
}

public void getMinDifference(int X, int N, int[] inputArray) {
    Set<int> set = new HashSet<int>();
    for (int i = 0; i < N; i++) {
        set.Add(inputArray[i]);
    }
    int diff = int.MaxValue;
    int ans = -1;
    for (int i = 0; i <= 101; i++) {
        if (set.Contains(i)) {
            continue;
        }
        int t = Math.Abs(i - X);
        if (t < diff) {
            ans = i;
            diff = t;
        }
    }
    Console.Writeline(ans);
}

public void getMinDifference() {
    int X = ni();
    int N = ni();
    if(N == 0) {
            Console.WriteLine(X);
            return;
    }
    for (int i = 0; i < N; i++)     {
            set.Add(ni());
    }
    int ans = 0, sv = 200;
    for (int i = 0; i <= 101; i++) {
            if(set.Contains(i))             continue;
            if(sv > Math.Abs(i - X)) {
                    sv = Math.Abs(i - X);
                    ans = i;
            }
    }
    Console.WriteLine(ans);
}

public static void findNotSymmetricalContains(int x, int n, int[] inputArray) {
    HashSet<int> h = new HashSet<int>();
    while(n--!=0) {
            h.Add(inputArray[i]);
    }
    int t=0;
    while(h.Contains(x-t) && h.Contains(x+t)) {
            t++;
    }
    if(!h.Contains(x-t)) {
            Console.Writeline(x-t);
    }
    else if(!h.Contains(x+t)) {
            Console.Writeline(x+t);
    }
}

public static void remove2(int a, int b) {
    HashSet<int> set = new HashSet<int>();
    for (int i = 0; i < 3; i++) {
            set.Add(i + 1);
    }
    set.Remove(a);
    set.Remove(b);
    Console.Writeline(set.toArray()[0]);
}

public static void removeInput(string[] args)  {
    Set<int> set = new HashSet<int>();
    set.Add(1);
    set.Add(2);
    set.Add(3);
    string line;
    try {
        while((line = Console.ReadLine()()) != null) {
            int num = int.Parse(line);
            set.Remove(num);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    Console.Writeline(set.iterator().next());
}

public void removeChild(Node node) {
    children.Remove(node);
}

public static void getExtinctSize(string str[]) throws Exception
        {
            try
            {
                Set<string> set=new HashSet<string>(str);
                set.Remove(null);
                Console.Writeline(set.Count);
            }
            catch(Exception e)
            {}
        }

        public static void removeInputPos(string args[]) {
            MyScanner sc = new MyScanner();
            HashSet<int> set = new HashSet<int>();
            int n = sc.nextInt(), m = sc.nextInt();
            bool[] selected = new bool[m];
            for(int i = 0; i < m; i++){
                set.Add(i);
            }    
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < m; ++j){
                    selected[j] = true;
                }
                int c = sc.nextInt();
                for(int j = 0; j < c; ++j){
                    selected[sc.nextInt() - 1] = false;
                }
                for(int j = 0; j < m; ++j){
                    if(selected[j]){
                        set.Remove(j);
                    }
                }
            }
            Console.Writeline(set.Count);
        }

        public static <T> void comb(List<T> n, int r, HashSet<List<T>> ans) {
            if (n.Count == r) {
                ans.Add(n);
                return;
            }
            for (int i = 0; i < n.Count; i++) {
                List<T> N = new List<T>(n);
                N.RemoveAt(i);
                comb(N, r, ans);
            }
        }

        public static void getOddChar(string w) throws Exception {
            Set<string> set = new HashSet<string>();
            for (int i = 0; i < w.Length; i++) {
                string c = w[i].ToString();
                if (set.Contains(c)) {
                    set.Remove(c);
                } else {
                    set.Add(c);
                }
            }
            if (set.Count == 0) {
                Console.Writeline("Yes");
            } else {
                Console.Writeline("No");
            }
        }

        private static void sortNatualOrder(List<int> intList) {
            int tmp = intList[1];
            if (intList.First() > intList[1]) {
                intList[1] = intList.First();
                intList[0] = tmp;
            }
        }

        public static void swap(List<int> ary, int i, int j){
            int tmp = ary[i];
            ary[i] = ary[j];
            ary[j] = tmp;
        }
        public static void removeSameSeries(int N, string S ) {
            List<string> arr = new List<string>();
            for(int i = 0; i < N;i++){
                arr.Add(S[i].ToString());
            }
            for(int j = 0; j < N-1; j++){
                if(arr[j].Equals(arr[j+1])){
                    arr[j]= "0";
                }
            }
            arr.ExceptWith({"0"});
            Console.Writeline(arr.Count);
        }

        private static <T> void swap(List<T> nums, int i, int j) {
            T temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public static void LastPowerK(int k, int[] inputArray) {
            List<int> n = new List<int>();
            for (int i = 0; i < 3; i++) {
              n.Add(inputArray[i]);
            }
            n.Sort();
            for (int i = 0; i < k; i++)
              n[2] = ((int) n[2] * 2);
            int ans = 0;
            foreach (int num in n)
              ans += num;
            Console.Writeline(ans);
          }

          public static void countOddValue(int N) {
            int res = 0;
            for(int i = 1; i <= N; i++) {
                string s = i.ToString();
                int len = s.Length;
                if(len % 2 != 0) res++;
            }
            Console.Writeline(res);
        }

        public static void isSize2(string s) {
            Set<string> set = new HashSet<string>();
            foreach (char c in s.ToCharArray()) {
                set.Add(c.ToString());
            }
            Console.Writeline(set.Count == 2 ? "Yes" : "No");
        }

        public static void isAABB(string s) {
            List<string> array = new List<string>();
            array.Add(s[0].ToString());
            array.Add(s[1].ToString());
            array.Add(s[2].ToString());
            array.Add(s[3].ToString());
            array.Sort();
            if (array.First().Equals(array[1]) && !array[1].Equals(array[2]) && array[2].Equals(array[3])) {
                Console.Writeline("Yes");
            } else {
                Console.Writeline("No");
            }
        }

        static bool check(string s) {
            if(s[0] != 'A')return false;
            bool flag = false;
            for(int i = 1;i < s.Length;i ++) {
                    if(s[i] != 'C') {
                            if(s[i] >= 'A' && s[i] <= 'Z')return false;
                    }
                    else if(flag || i < 2 || s.Length - i < 2)return false;
                    else flag = true;
            }
            return flag;
    }

    static void printBWD(string str, int n) {
        if (n < str.Length) {
            printBWD(str, n + 1);
            Console.Writeline(str[n]);
        }
        return;
    }

    public static void getReverseWordList(string[] args) throws IOException {
        string str, reverse;
        int num;
        while ((str = Console.ReadLine()()) != null){
                reverse = "";
                num = str.Length;
                char[] word = new char[num];
                for (int i = 0; i < num; i++) {
                        word[i] = str[i];
                }
                for (int i = num-1; i >=0; i--) {
                        reverse = reverse + word[i];
                }
                Console.Writeline(reverse);
        }
}

public static void sumstringValue( string s) {
    string r = "";
for(int i=s.Length-1;i>=0;i--){
     r += s[i].ToString();
}
Console.Writeline(r);
}

public static void sumstringValue( string str) { 
    string ans="";
    for(int i=1;i<=str.Length;i++)
            ans+=str[str.Length-i];
    Console.Writeline(ans);

}

public static void reverseLine(string[] args) {
    StringBuilder sb = new StringBuilder();
    string str = "";
    try {
            while((str = Console.ReadLine()()) != "") {
                    for(int i=str.Length; i>0; i--) {
                            sb.Append(str.Substring(i-1, i));
                    }
                    Console.Writeline(sb.ToString());
            }
    } catch(Exception e) {
            e.getMessage();
    }
}

public static void reversestring(string st) {
    for (int i = st.Length - 1; 0 <= i; i--) {
            Console.Writeline(st[i]);
    }
}

public static void mergestring(){
    int n;
    string s,t;
    n=nextInt();
    s=next();
    t=next();
    char[] arr = new char[2*n];
    for(int i=0;i<n;i++){
        arr[2*i]=s[i];
        arr[2*i+1]=t[i];
    }
    foreach(char a in arr){
        Console.WriteLine("%c",a);
    }
}

public static void mergestring(int n, string s, string t) {
    string ans = "";
    for(int i = 0; i < n; i++) {
      string s1 = s[i].ToString();
      string s2 = t[i].ToString();
      ans += s1;
      ans += s2;
    }
    Console.Writeline(ans);
  }

  private string mergestring() {
    string answer = "";
    for (int i=0; i<N; i++) {
            answer += S[i].ToString();
            answer += T[i].ToString();
    }
    
    return answer;
}

static int res(string ss, string t) {
    int cnt = 0;
    for(int i=0;i<ss.Length;i++) {
        if(ss[i] != t[i]) {
            cnt++;
        }
    }
    return cnt;
}

public static void isRepeatedstring(string S, string T) {
    int ans = int.MaxValue;
    for (int i = 0; i <= S.Length-T.Length; ++i) {
        int cnt = T.Length;
        for (int j = 0; j < T.Length; ++j) {
            if (S[i+j] == T[j]) {
                --cnt;
            }
        }
        ans = Math.Min(ans, cnt);
    }
    Console.Writeline(ans);
}


public static void isRepeatedstring(string s, string t) {
    bool flag = false;
    for(int i = 0; i < s.Length; i++) {
            if (s.Equals(t)){
                    flag = true;
                    break;
            }
            char c = s[0];
            s = s.Substring(1, s.Length) + c;
    }
    if(flag) {
            Console.Writeline("Yes");
    }else {
            Console.Writeline("No");
    }
}

public bool isRepeated(string s, string t, LightWriter out) {
    for (int i = 0; i <= 100; i++) {
        if (s.Equals(t)) {
            return true;
        }
        s = s.Substring(1) + s[0];
    }
    return false;
}

public static string[] tostringArray(string s) {
    string[] tmp = new string[s.Length];
    char[] c = s.ToCharArray();
    for (int i = 0; i < tmp.Length; i++) {
            tmp[i] = c[i].ToString();
    }
    return tmp;
}

public static void findFirstNot1(string s, string inputLong) {
    long k = long.Parse(inputLong);
    char c[] = s.ToCharArray();
    char cs = '1';
    for(int i = 0; i < k; i++){
        if(c[i] != '1'){
            cs = c[i];
            break;
        }
    }
    Console.Writeline(cs);
}

static char[] nc(string next) {
    return next.ToCharArray();
}

public static void isSamestring(string s, string nextLine) {
    int    n = int.Parse(nextLine);
    if(n % 2 == 1 || n == 0){
        Console.Writeline("No");
        return;
    }
    string s1 = s.Substring(0  , n/2);
    string s2 = s.Substring(n/2, n);
    
    if(s1.StartsWith(s2)){
        Console.Writeline("Yes");
    }
    else{
        Console.Writeline("No");
    }
}

public static void isOnlyCLower(string s) {
    string sub = s.Substring(2,s.Length-1);
    if (s.StartsWith("A") && sub.Contains("C") && sub.IndexOf('C')==sub.LastIndexOf('C')){
            int idxC = sub.IndexOf('C')+2;
            for (int i=1;i<s.Length; i++){
                    if (i==idxC) continue;
                    if (Char.IsUpper(s[i])) {
                            Console.Writeline("WA");
                            System.exit(0);
                    }
            }
            Console.Writeline("AC");
    }else {
            Console.Writeline("WA");
    }
}

public static void isPrefix(string a , string b){
    Console.Writeline(b.StartsWith(a) ? "Yes" : "No");
  }

  public void addPluralSuffix( MyScanner in)
                {
                        string s = in.next();
                        if( s.EndsWith("s") )
                        {
                                s += "es";
                        }
                        else
                        {
                                s += "s";
                        }
                        Console.WriteLine(s);
                }
    
                public static void isstringRepeated2(Stack<int> args1,Stack<string> args2) {
                    while (in.hasNext()) {
                        int n = args1.Pop();
                        string s = args2.Pop();
                        if (n % 2 == 1) {
                            Console.Writeline("No");
                        } else {
                            n /= 2;
                            Console.Writeline((s.Substring(0, n).EndsWith(s.Substring(n))) ? "Yes" : "No");
                        }
                    }
}

public static void is7Contained(string N) throws IOException {
    if(N.Contains("7")){
        Console.Writeline("Yes");
    }
    else {
        Console.Writeline("No");
    }
}

public static string checkInf(string S, string K){
    long count = 0;
    for(int i = 0; i < S.Length; i++){
        int val = S[i] - '0';
        if(val == 1)
            count++;
        else {
            if(String.CompareOrdinal(K, key) > 0 && val == 2){
                while(i < S.Length){
                    int val1 = S[i] - '0';
                    if(val1 != 1)
                        return ((char) ('0' + val)).ToString();
                    i++;
                }
                return ((char) ('0' + val)).ToString();
            }
            return ((char) ('0' + val)).ToString();
        }
        if(String.CompareOrdinal(K, (count).ToString()) == 0)
            return ((char)('0' + val)).ToString();
    }
    return null;
}

public static void countGoodsList(int n, string[] args) {
    string ac="AC";
    long a=0;
    string tle="TLE";
    long t=0;
    string wa="WA";
    long w=0;
    string re="RE";
    long r=0;
    for(int j=0;j<n;j++)
    {
        string s=args[i];
        if(String.CompareOrdinal(s, ac)==0)
            a++;
        else if(String.CompareOrdinal(s, tle)==0)
            t++;
        else if(String.CompareOrdinal(s, wa)==0)
            w++;
        else
            r++;
    }
    Console.Writeline(ac+ " "+"x"+" "+a);
    Console.Writeline(wa+ " "+"x"+" "+w);
    Console.Writeline(tle+ " "+"x"+" "+t);
    Console.Writeline(re+ " "+"x"+" "+r);
}

public static void countDifferentAtoZ(string str) throws IOException {
    Console.Writeline(str.LastIndexOf("Z") - str.IndexOf("A") + 1);
}

public static void countDifferentAtoZ(string s){
    int ansA = s.IndexOf("A");
    int ansB = s.LastIndexOf("Z");
    Console.Writeline(ansB - ansA + 1);
  }

  public static void isEvenOrOdd(string s) throws IOException {
    if((s[s.IndexOf(" ") - 1] & 1) == 0){
      Console.Writeline("Even");
    } else if ((s[^1] & 1) == 0) {
      Console.Writeline("Even");
    } else {
      Console.Writeline("Odd");
    }
  }

  public static void isOnlyCLower(string S) {
    string result = "WA";
    if("A".Equals(S.Substring(0,1))) {
            S = S.Substring(1);
            if(S.IndexOf("C") > 0  && S.IndexOf("C") < S.Length-1
                            && S.IndexOf("C") == S.LastIndexOf("C")) {
                    S = S.Substring(0,S.IndexOf("C")) + S.Substring(S.IndexOf("C")+1);
                    string s = S.ToLower();
                    if(S.Equals(s)) {
                            result = "AC";
                    }
            }
    }
    Console.Writeline(result);
}

public static void countDifferentAtoZ(string S) {
    int A = 0;
    int Z = 0;
    A = S.IndexOf("A");
    Z = S.LastIndexOf("Z");
    Console.Writeline(Z-A+1);
}

public static void isSum2Max(string[]args){
    int N = int.Parse(args[0]);
    int m = 0, sum = 0;
    for(int i = 0; i < N; i++){
      int n = int.Parse(args[i+1]);
      sum += n;
      m = m < n ? n : m;
    }
    sum -= m;
    Console.Writeline(sum > m ? "Yes" : "No");
  }

  public static void isSum2Max(string intLine, string[] args) {
    int n = int.Parse(intLine);
    int[] l = new int[n];
    int max = 0;
    int sum = 0;
    for(int i=0;i<n;i++){
        l[i] = int.Parse(args[i]);
        max = Math.Max(max, l[i]);
        sum+=l[i];
    }
    if(sum-max > max){
        Console.Writeline("Yes");
    }else{
        Console.Writeline("No");
    }
}

public static void sumNoRemainer(int n) {
    int sum = 0;
    string str[] = n.ToString().Split("");
    for (int i=0 ; i < str.Length ; i++){
        sum += int.Parse(str[i]);
    }
        Console.Writeline(n%sum==0?"Yes":"No");
  }

  public long[] nl() throws IOException {
    string[] data = Console.ReadLine().Split(" ");
    long[] send = new long[data.Length];
    for (int i = 0, h = data.Length; i < h; i++) send[i] = long.Parse(data[i]);
    return send;
}

public long l() throws IOException {
    return long.Parse(Console.ReadLine());
}

float nf() {return float.Parse(ns());}

public static void compareQuotient( string str){
    string[] num_str = str.Split(" ");
    if(float.Parse(num_str[0]) / float.Parse(num_str[1]) <= float.Parse(num_str[2])){
            Console.Writeline("Yes");
    }else{
            Console.Writeline("No");
    }
}

public double nextdouble() {
    return double.Parse(next());
}
