package parallel.CodeSearchNet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class java2cs {
public static void morePositiveNums(Integer[] lines) { 
    List<Integer> list = Arrays.asList(lines);  
    if(Collections.max(list) >= sum(list)) {
        System.out.println("No");
    } else {
        System.out.println("Yes");
    }
}

static ArrayList<String> myconv(String str, int no) {
    String splitString = CONVSTR.get(no);
    return new ArrayList<String>(Arrays.asList(str.split(splitString)));
}

static List<Integer> inputIntList() throws Exception {
    List<String> strList = Arrays.asList(br.readLine().trim().split(" "));
    List<Integer> intList = new ArrayList<Integer>();
    for (String elem : strList){
        intList.add(Integer.parseInt(elem));
    }
    return intList;
}

public static void isEven(String nextLine) {
    List<String> input=new ArrayList<String>(nextLine.split(" "));
    int result=Integer.valueOf(input.get(0))*Integer.valueOf(input.get(1));
    String msg=result%2==0?"Even":"Odd";
    System.out.println(msg);

}

public static void countSlimeColor(Integer numSlime , String slimeColor) {
    List<String> colors = Arrays.asList(slimeColor.split(""));
    Integer cnt = 1;
    for (int i = 0; i < numSlime; i++) {
        if(i > 0 && !colors.get(i).equals(colors.get(i - 1))) {
            cnt++;
        }
    }
    System.out.println(cnt);
}   

public static void countLetter(BufferedReader br) throws IOException{
    String str;
    int count[] = new int[26];
    char abc ='a';   
    while((str=br.readLine())!=null){      
        for(int i=0;i<str.length();i++){
            if(Character.isLetter(str.charAt(i))){
                count[Character.toLowerCase(str.charAt(i)) - 'a']++;
            }
        }
    }
}

public static void countLetter(List<String> args) {
    int[] alpha = new int['z' - 'a' + 1];
    while (args.size() > 0) {
        String str = args.getFirst().toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                alpha[str.charAt(i) - 'a']++;
            }
        }
        args.removeFirst();
    }
}

public static void swapUpperAndLowerLetter(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    while (sc.hasNext()) {
        String s = sc.next();   
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    c = Character.toLowerCase(c);
                } else {
                    c = Character.toUpperCase(c);
                }
            }
            sb.append(c);
        }
        sb.append(" ");
    }
    sb.delete(sb.length()-1, sb.length());
    System.out.println(sb);
}


public static void isOneLetterMore (String s , String s1) throws java.lang.Exception
{
        int t,f=0;
        if(((s1.length()-s.length()) ==1) && (Character.isLetter(s1.charAt(s1.length()-1))))
        {
            for(t=0;t<s.length();t++)
            {
                if(s.charAt(t) != s1.charAt(t))
                f=1;
            }
            if(f==0)
            {
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
        else{
            System.out.println("No");          
            }        
}

public static void countLetter(List<String> args) {
            int[] alphabet = new int[26];
            char a = 'a', ch;
            while (args.size > 0) {
                    String str = args.getFirst().toLowerCase();
                    for (int i=0; i< str.length(); i++) {
                            if (Character.isLetter(ch = str.charAt(i))) {
                                    alphabet[ch - a]++;
                            }
                    }
                args.removeFirst();
            }
            for (int i=0; i <= ('z' - 'a'); i++) {
                    System.out.println(new StringBuilder().append(a++).append(" : ").append(alphabet[i]).toString());
            }
}

public static void isLetterEven( String s) throws Exception {
    int[] frq = new int[26];
    for(int i = 0 ; i < s.length() ; i++)
    {
        if( Character.isLowerCase(s.charAt(i)) )
        {
            frq[s.charAt(i)-'a']++;
        }
    }
    boolean flag = true;
    for(int i = 0 ; i < 26; i++)
        if(frq[i]%2!=0)
        {
            flag = false;
            break;
        }
    if(flag)
        System.out.println("Yes");
    else System.out.println("No");
}

private static void countup(char c){
    if(Character.isLowerCase(c)){
            int num=c-'a';
            counter[num]++;
    }
    if(Character.isUpperCase(c)){
            char ch=Character.toLowerCase(c);
            int num=ch-'a';
            counter[num]++;
    }
}

public void checkAC(int testNumber, InputReader in, PrintWriter out) {
    char[] s = in.nextString().toCharArray();
    boolean ok = true;
    if (s[0] != 'A') ok = false;
    int c = 0;
    for (int i = 2; i < s.length-1; i++) {
            if (s[i] == 'C') c++;
    }
    if (c != 1) ok = false;
    for (int i = 0; i < s.length; i++) {
            if (s[i] == 'A' || s[i] == 'C') {
                    continue;
            }
            if (!Character.isLowerCase(s[i])) ok = false;
    }
    out.println(ok ? "AC" : "WA");
}

static boolean checkAC(String s) {
    if (s.charAt(0) != 'A') return false;
    int cnt = 0;
    for (int i = 1; i < s.length(); i++)
        if (i >= 2 && i <= s.length() - 2) {
            if (s.charAt(i) == 'C') {
                if (++cnt > 1) return false;
            }else if (!Character.isLowerCase(s.charAt(i)))
                return false;
        } else if (!Character.isLowerCase(s.charAt(i)))
            return false;
    return cnt == 1;
}


public static void checkFirstLetterCase(String s){
    if(Character.isLowerCase(s.charAt(0))){
        System.out.println("a");
    }else{
        System.out.println("A");
    }
    sc.close();
  }

  public static void checkFirstLetterCase(String input) throws IOException { 
    char [] ch = input.toCharArray();
    if(Character.isLowerCase(ch[0])) System.out.println("a");
    else System.out.println("A");
} 

public static void checkAC(String s ){
    String result = "AC";
    if(s.charAt(0) != 'A') result = "WA";
    boolean flg = false;
    for(int i = 1; i < s.length(); i++){
        if(Character.isUpperCase(s.charAt(i))){
            if(i >= 2 && s.length()-2 >= i && s.charAt(i) == 'C' && !flg){
                flg = true;
            }else{
                result = "WA";
            }
        }
    }
    if(!flg) result = "WA";
    System.out.println(result);
}

public static void calculator(ArrayDeque<String> args) throws Exception {   
    String st;
    Stack<Integer> stack = new Stack<Integer>();
    while (args.size() > 0) {                        
        st = args.peek();
        if (Character.isDigit(st.charAt(0))) stack.push(Integer.parseInt(st));
        else {
            int x = stack.pop();
            int y = stack.pop();
            if (st.equals("+")) stack.push(x + y);
            else if (st.equals("-")) stack.push(y - x);
            else if (st.equals("*")) stack.push(y * x);
        }
        args.pop();
    }
    System.out.println(stack.pop());
}  

public static void add(String expression){
    Stack<Integer> stack=new Stack<Integer>();
    String[] arrays=expression.split(" ");
    for(int i=0;i<arrays.length;i++){
            if(Character.isDigit(arrays[i].charAt(0)))
                    stack.add(Integer.parseInt(arrays[i]));
            else if(!Character.isDigit(arrays[i].charAt(0))){
                    int number2=stack.pop();
                    int number1=stack.pop();
                    stack.push(add(number1,number2,arrays[i].charAt(0)));
            }
    }
    System.out.println(stack.pop());
}

public static void calculator(ArrayDeque<String> args) throws Exception {      
    String st;
    Stack<Integer> stack = new Stack<Integer>();
    while (args.size > 0) {                        
        st = args.peek();
        if (Character.isDigit(st.charAt(0))) stack.push(Integer.parseInt(st));
        else {
            int x = stack.pop();
            int y = stack.pop();
            if (st.equals("+")) stack.push(x + y);
            else if (st.equals("-")) stack.push(y - x);
            else if (st.equals("*")) stack.push(y * x);
        }
        args.pop();
    }
    System.out.println(stack.pop());
} 

static boolean isNum(String s){
    char[] array = s.toCharArray();
    int flag = 0;
    if(array[0]=='-'&&s.length()>1)
        flag = 1;
    for (char c : array) {
        if(!Character.isDigit(c)){
            flag--;
        }
        if(flag<0)
            return false;
    }
    return true;
}

    public void isTimes(int testNumber, String n, PrintWriter out) {
        long l = Long.parseLong(n);
        long sum = 0;
        for (char c : n.toCharArray()) {
            sum += Character.digit(c, 10);
        }
        if (l % sum == 0) {
            out.print("Yes");
        } else {
            out.print("No");
        }
    }

public static void addMedium(String args[]) throws Exception{
    BufferedReader stdR = new BufferedReader(new InputStreamReader(System.in));
    String[] s = stdR.readLine().split(" ");
    int N = Integer.parseInt(s[0]);
    int A = Integer.parseInt(s[1]);
    int B = Integer.parseInt(s[2]);
    int num = 0;
    for(int i = 1 ; i <= N; i++) {
        String str = String.valueOf(i);
        int count = 0;
        for(int j = 0 ; j < str.length(); j++) {
            count += Character.digit(str.charAt(j), 10);
        }
        if(A <= count && count <= B) num+=i;
    }
    System.out.println(num);
}

public static void Summation(List<String>  args) {
    while(true){
            String x = args.getFirst();
            if(x.equals("0")){
                    break;
            }
            int sum = 0;
            for(int i = 0; i < x.length(); i++){
                    sum += Character.digit(x.charAt(i), 10);
            }
            System.out.println(sum);
            args.removeFirst();
    }
}

public static void Summation(Queue<String> args) {
    while (true) {
        String s = args.peekFirst();
        args.remove();
        if (s.length() == 1 && s.charAt(0) == '0')
            break;
        int sum = 0;
        for (int i = 0; i < s.length(); i++)
            sum += Character.digit(s.charAt(i), 10);
        System.out.println(sum);
    }
}

public static void Summation(Queue<String> args){
    for(;;){
    int ans =0;
    String s=args.peekFirst();
    args.remove();
    if(s.equals("0"))break;
    for(int i=0; i<s.length(); i++){
            ans += Character.digit(s.charAt(i),10);
    }
    System.out.println(ans);
    }
}

char nextChar() {
    try {
        int b = input.read();
        while (Character.isWhitespace(b)) {
            b = input.read();
        }
        return (char) b;
    } catch (IOException e) {
        e.printStackTrace();
        return 0;
    }
}

String nextStr() {
    try {
        StringBuilder sb = new StringBuilder();
        int b = input.read();
        while (Character.isWhitespace(b)) {
            b = input.read();
        }
        while (b != -1 && !Character.isWhitespace(b)) {
            sb.append((char) b);
            b = input.read();
        }
        return sb.toString();
    } catch (IOException e) {
        e.printStackTrace();
        return "";
    }
}

public String next() throws IOException{
    byte c = read();
    while(Character.isWhitespace(c)){
        c = read();
    }
     StringBuilder builder = new StringBuilder();
    builder.append((char)c);
    c = read();
    while(!Character.isWhitespace(c)){
        builder.append((char)c);
        c = read();
    }   
    return builder.toString();
}

public String nextStr() {
    try {
        StringBuilder sb = new StringBuilder();
        int b = input.read();
        while (Character.isWhitespace(b)) {
            b = input.read();
        }
        while (b != -1 && !Character.isWhitespace(b)) {
            sb.append((char) b);
            b = input.read();
        }
        return sb.toString();
    } catch (IOException e) {
        e.printStackTrace();
        return "";
    }
}

public void isLRUD(int testNumber, InputReader in, PrintWriter out) {
    String s = in.next();
    int n = s.length();
    for (int i = 0; i < n; i++) {
        if (i % 2 == 0) {
            if (!"RUD".contains(Character.toString(s.charAt(i)))) {
                out.println("No");
                return;
            }
        } else if (!"LUD".contains(Character.toString(s.charAt(i)))) {
            out.println("No");
            return;
        }
    }
    out.println("Yes");
}

public static void LongMultipleString(long a){
    long a = scan.nextLong();
    String bs = scan.next();
    int b = Integer.parseInt(Character.toString((bs.charAt(0)))) * 100
            + Integer.parseInt(Character.toString((bs.charAt(2)))) * 10
            + Integer.parseInt(Character.toString((bs.charAt(3))));
    System.out.println((long)a * b / 100);
    scan.close();
}

public static void countABC(int N,  String S) throws FileNotFoundException {
    sc.close();
    int ans = 0;
    char[] s = S.toCharArray();
    for(int i=0;i<S.length()-2;i++) {
            String a = Character.toString(s[i])+Character.toString(s[i+1])+Character.toString(s[i+2]);
            if(a.equals("ABC")) {
                    ans++;
            }
    }
    System.out.println(ans);
}

public static void addMid(int n, int a, int b, PrintWriter out){
    int res = 0;
    for(int i = 1; i <= n; i++) {
            String s = Integer.toString(i);
            int j =  0;
            for(char c : s.toCharArray()) {
                    j+=Integer.parseInt(Character.toString(c));
            }
            if(j >= a && j <= b) {
                    res+=i;
            }
    }
    out.println(res);
}

private void changingACharchter(int k, String nextLine) {
    char[] s = nextLine.toCharArray();
    s[k - 1] = Character.toLowerCase(s[k - 1]);
    System.out.println(new String(s));
}

public static void setLowerCaseK(ArrayDeque<Integer> args, ArrayDeque<String> inputS) {
    while(scan.hasNext())
    {
            int n,k;
            n=args.peek();
            args.pop();
            k=args.peek();
            args.pop();
            String s,s1 ;
            s=inputS.peek();
            inputS.pop();
            char arr[]=s.toCharArray();
            char c=Character.toLowerCase(arr[k-1]);
            arr[k-1]=c;
            System.out.println(arr);
    }
}

public void setLowerCaseK(int testNumber, String N, String K, PrintWriter out) {
    int n = Integer.parseInt(N);
    int k = Integer.parseInt(K);
    String S = in.next();
    String tmp1 = S.substring(0, k - 1);
    String tmp2 = S.substring(k);
    Character tmp3 = Character.toLowerCase(S.charAt(k - 1));
    out.println(tmp1 + tmp3 + tmp2);
}

private static void setLowerCaseK(){
            int n = ni();
            int k = ni();
            char[] ca = next().toCharArray();
            ca[k-1] = Character.toLowerCase(ca[k-1]);
            System.out.println(new String(ca));
}

private static String invertCase(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
        if (Character.isUpperCase(str.charAt(i))) {
            sb.append(Character.toLowerCase(str.charAt(i)));
        } else {
            sb.append(Character.toUpperCase(str.charAt(i)));
        }
    }
    return sb.toString();
}

public static void covertCharacterCase( String str){
    char c;
    for(int i=0;i<str.length();i++){
        c=str.charAt(i);
        if(Character.isUpperCase(c))System.out.print(Character.toLowerCase(c));
        else System.out.print(Character.toUpperCase(c));
    }
    System.out.println();
}

public static void normalizatoin(String src){
    String Array[] = src.split("");
    List<String> list = Arrays.asList(Array);
    int count0 = Collections.frequency(list, "0");
    int count1 = Collections.frequency(list, "1");
    if(count0 > count1){
            System.out.println(count1*2);
    }else{
            System.out.println(count0*2);
    }
}

public static void allToLowerCase(List<String> args) {
    ArrayList<String> str = new ArrayList<>();
    String target = args.getFirst().toLowerCase();
    args.removeFirst();
    while(true) {
        String tmp = args.getFirst();
        args.removeFirst();
        if(tmp.equals("END_OF_TEXT")) {
            break;
        }
        str.add(tmp.toLowerCase());
    }
    sc.close();
    System.out.println(Collections.frequency(str, target));
}

public static void allToLowerCase(String[] args) {
    String ptn = scn.next().toLowerCase();
    ArrayList<String> als = new ArrayList<>();
    while(scn.hasNext()) {
        als.add(scn.next().toLowerCase());
    }
    System.out.println(Collections.frequency(als, ptn));
}

public static void checkAC(int n, int m, String[] args) {
    List<Integer> ac = Arrays.asList(new Integer[n]);
    List<Integer> pena = Arrays.asList(new Integer[n]);
    Collections.fill(ac, 0);
    Collections.fill(pena, 0);
    for(int i=0; i<m; ++i)  {
            int p = Integer.parseInt(args[i]);
            String s = scan.next();
            --p;
            if(ac.get(p) == 1) continue;
            if(s.equals("AC")) {
                    ac.set(p, 1);
            } else {
                    pena.set(p, (pena.get(p)+1));
            }
    }
    scan.close();
    int AC = 0, PENA = 0;
    for(int i=0; i<n; ++i) {
            AC += ac.get(i);
            if(ac.get(i) == 1) PENA += pena.get(i);
    }
    System.out.println(AC + " " + PENA);
}

public static void swapList(int t1, int t2, String args[]){List<Integer>l=new ArrayList<Integer>();int t=t1,i=0;for(;i++<t;)l.add(i);for(t=t2;t>0;t--){String[]e=args[t].split(",");Collections.swap(l, new Integer(e[0])-1, new Integer(e[1])-1);}for(int e:l)System.out.println(e);}

public static void swapList(String[] arg) throws IOException
{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.valueOf(br.readLine());
        ArrayList<Integer> amida = new ArrayList<Integer>(v);
        for(int i=0; i<v; i++)
                amida.add(i+1);
        int h = Integer.valueOf(br.readLine());
        for(int i=0; i<h; i++){
                String swapInd = br.readLine();
                int swap1 = Integer.valueOf(swapInd.split(",")[0]);
                int swap2 = Integer.valueOf(swapInd.split(",")[1]);
                Collections.swap(amida,swap1-1,swap2-1);
        }
        for(int i=0; i<v; i++)
                System.out.println(amida.get(i));
}

public static void swapList(int n, int[] inputArray) {
    int c=0;List<Integer> A=new ArrayList<>();
    for(int i=0;i<n;i++)A.add(inputArray[i]);
    boolean flag=true;
    while(flag) {
            flag=false;
            for(int i=n-1;i>0;i--) {
                    if(A.get(i)<A.get(i-1)) {
                            Collections.swap(A, i, i-1);
                            c++;
                            flag=true;
                    }
            }
    }
    for(int i=0;i<n;i++) {
            System.out.print(A.get(i));
            if(i!=n-1)System.out.print(" ");
    }
    System.out.println();
    System.out.println(c);
}

public static void reverseList(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str;
    ArrayList<Integer> al = new ArrayList<Integer>();
    try {
        while((str = br.readLine()) != null) {
            al.add( Integer.parseInt(str) );
        }
    } catch (NumberFormatException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    Collections.sort(al);
    Collections.reverse(al);
    for(int i=0; i<3; i++) {
        System.out.println(al.get(i));
    }
}

public static void reverseList(List<Integer> list) {
    Collections.sort(list);
    Collections.reverse(list);
    for (int i = 0; i < 3; i++) {
        System.out.println(list.get(i));
    }
}

public static void reverseList(String[] args) throws IOException {
    ArrayList<Integer> array = new ArrayList<Integer>();
    BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    for(int i = 0; i < 10; i++) {
      int x = Integer.valueOf(buf.readLine());
      array.add(x);
    }
    Collections.sort(array);
    Collections.reverse(array);
    for(int i = 0; i < 3; i++) {
      System.out.println(array.get(i));
    }
}

public static void reverseList( String s){
    ArrayList<String> list = new ArrayList<String>();
    String[] str = s.split("");
    for(String a : str){
            list.add(a);
    }
    Collections.reverse(list);
    for(String a : list){
            System.out.print(a);
    }
    System.out.println("");
}

public static void checkSameStr(String[] args) throws Exception {
    char[] s = args[0].toCharArray();
    char[] t = args[1].toCharArray();
    if(s.length != t.length) {
        System.out.println("No");
        return;
    }
    int len = s.length;
    ArrayList<Character> sl = new ArrayList<Character>();
    for(char c : s){
        sl.add(c);
    }
    for(int i = 0; i < len; i++){
        boolean bool = true;
        for(int j = 0; j < len; j++){
            if(sl.get(j) != t[j]){
                bool = false;
                break;
            }
        }
        if(bool){
            System.out.println("Yes");
            return;
        }
        Collections.rotate(sl,1);
    }
    System.out.println("No");
}

static void shuffle(int a[]) {
    List<Integer> l = new ArrayList<>();
    for (int i = 0; i < a.length; i++)
        l.add(a[i]);
    Collections.shuffle(l);
    for (int i = 0; i < a.length; i++)
        a[i] = l.get(i);
}


static void shuffle(long a[])
{
    List<Long> l=new ArrayList<>();
    for(int i=0;i<a.length;i++)
        l.add(a[i]);
    Collections.shuffle(l);
    for(int i=0;i<a.length;i++)
        a[i]=l.get(i);
}

int upperBound(ArrayList<Long> list, Long target){
    int i = Collections.binarySearch(list, target, new UpperBoundComparator<Long>());
    return ~i;
}

int lowerBound(ArrayList<Long> list, Long target){
    int i = Collections.binarySearch(list, target, new LowerBoundComparator<Long>());
    return ~i;
}

public static void search(int n ,List<String> args) {
    ArrayList<String> array = new ArrayList<String>();
    while(args.size() > 0) {
            String s = args.getFirst();
            args.removeFirst();
            int index = Collections.binarySearch(array, s);
            if(index < 0) {
                    index = - (index + 1);
                    array.add(index, s);
            }
    }
    int ans = array.size();
    System.out.println(ans);
}

private static int search(List<Integer> list, int key) {
    int r = Collections.binarySearch(list, key);
    return r < 0 ? ~r : r;
}

public List<Integer> gerPrimes() {
    return Collections.unmodifiableList(primes);
}

static void dispResult(Map<String, Integer> result) {
    static final List<String> RESULT_TYPE = 
    Collections.unmodifiableList(Arrays.asList("AC", "WA", "TLE", "RE"));
    for (String R : RESULT_TYPE) {
      System.out.println(R + " x " + (result.get(R) == null ? 0 : result.get(R)));
    }
}

public static boolean isNumber(double val) {
    if ((val == Math.floor(val)) && !Double.isInfinite(val)) {
            return true;
    }
    return false;
}

public static void isSquareNumber(String[] args) {
    count = 0;
    for (int i = 0; i < intList.size(); i++) {
        if ((Math.sqrt(intList.get(i)) == Math.floor(Math.sqrt(intList.get(i))))
                && !Double.isInfinite(Math.sqrt(intList.get(i)))) {
            count++;
        }
    }
}

public static void countRemain(int N, int K, int[] inputArray ) {
    List<Integer> nList = IntStream.range(1, N + 1).boxed().collect(Collectors.toList());
    for (int i = 0; i < K; i++) {
      int di = inputArray[i];
      for (int j = 0; j < di; j++) {
        int A = inputArray[K + j];
        int index = nList.indexOf(A);
        if (index != -1) {
          nList.remove(index);
        }
      }
    }
    System.out.println(nList.size());
}

private void nArray() {
    int numN = nextInt();
    int[] wk = IntStream.range(0, numN).toArray();
}

public static void maxDifference(String[]args){
    int N=sc.nextInt();
    int[]A=new int[N];
    for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
    }
    int max=0;
    Arrays.sort(A);
    max=Math.abs(A[0]-A[N-1]);
    System.out.println(max);
}

public static void maxDifference(int n, int[] inputArray){
    List<Integer> list = new ArrayList<>(n);
    for(int i = 0;i < n; i++){
      list.add(inputArray[i]);
      }
    Collections.sort(list);
    System.out.println(Math.abs(list.get(list.size() -1) - list.get(0)));
}

public static long dist(long[] p1, long[] p2) {
    return (Math.abs(p2[0]-p1[0])+Math.abs(p2[1]-p1[1]));
}

public static void maxDifference(String nextLine) {
    String[] t = nextLine.split(" ");
    int n = Integer.parseInt(t[0]);
    int l = Integer.parseInt(t[1]);
    int[] list = new int[n];
    int min = Integer.MAX_VALUE;
    int sum = 0;
    for(int i = 1; i <= n; i++) {
            list[i - 1] = i + l - 1;
            if(Math.abs(min) > Math.abs(list[i - 1])) {min = list[i - 1];}
            sum += list[i - 1];
    }
    System.out.println(sum - min);
}

static String check(int k) {
    for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                    int x = Math.abs(arr[i] - arr[j]);
                    if (k < x) {
                            return ":(";
                    }
            }
    }
    return "Yay!";
}

public static void round(int val) {
    System.out.println(4*val*Math.acos(0));
}

public static void negetiveRound(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int R = Integer.parseInt(reader.readLine());
    System.out.println(2*R*Math.acos(-1));
}

public static void round(int r){
  double PI = 2 * Math.acos(0.0);
    System.out.println(2 * PI * r);
}

public static void d(int a, int b, int x ){
    if((double)2*x/(a*a)-b>=0){
        double bb=((double)2*x)/(a*a)-b;
        System.out.println(Math.atan((-bb+b)/a)*180/Math.PI);
    }
    else{
        double aa=((double)2*x)/(a*b);
        System.out.println(Math.atan(((double)b)/aa)*180/Math.PI);
    }
}

public static void findMaxPow(double a) {
    double two=Math.sqrt(a);
    double three=Math.cbrt(a);
    double four=Math.pow(a,0.25);
    double five=Math.pow(a,0.2);
    double unti[];
    unti=new double[4];
    unti[0]=Math.floor(two);
    unti[1]=Math.floor(three);
    unti[2]=Math.floor(four);
    unti[3]=Math.floor(five);
    double max=0;
    for(int i=0;i<4;i++){
         double jo=Math.pow(unti[i],i+2);
        max=Math.max(max,jo);
    }
    int ans=(int)max;
    System.out.println(ans);  
}

public static void adjustSqrt( double a){
    int aInt = (int) a;
    double sqrt = Math.sqrt(a);
    double cbrt = Math.cbrt(a);
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
    System.out.println(ans);
}

public static void checkMid(int x, int y) {
    double turu = 2 * x - y / 2.0;
    double kame = y / 2.0 - x ;
    if (turu < 0 || kame < 0) {
        System.out.println("No");
        return;
    }
    if (Math.ceil(turu) == Math.floor(turu) && Math.ceil(kame) == Math.floor(kame)) {
        System.out.println("Yes");
    } else {
        System.out.println("No");
    }
}

void checkQuotient() {
    int D = sc.nextInt();
    int T = sc.nextInt();
    int S = sc.nextInt();
    int ans = (int)Math.ceil(1.0*D / S);
    if(ans <= T) {
            System.out.println("Yes");
    }else {
            System.out.println("No");
    }
}

static boolean isInteger(double number){return Math.ceil(number) == Math.floor(number); }

public static void checkQuotien(int d, int t, int s){
    System.out.println(Math.ceil((double)d / s) > t ? "No" :"Yes");
}
public static void toOdd(int n,int ar[])
        {
                Arrays.sort(ar);
                if(n%2==1)
                {
                        System.out.println(0);
                }else {
                        int div=(int) Math.ceil(n/2);
                        System.out.println(ar[div]-ar[div-1]);
                }
        }

        public static void getV(int a , int b , int h , int m ){
            double degree = (30*h + 0.5*m) - 6*m;
            double distance = Math.sqrt(a*a + b*b -2*a*b*Math.cos(Math.toRadians(degree)));
            System.out.println(distance);
        }    

        public static void calcAngle(double A, double B, double H , double M ) {
            System.out.println(Math.sqrt(A*A+B*B-2.0*A*B*Math.cos(2.0*Math.PI*(H/12.0+M/12.0/60.0-M/60.0))));
        }

        static double calcAngle(double h, double m) 
    { 
        if (h <0 || m < 0 || h >12 || m > 60) 
            System.out.println("Wrong input"); 
        if (h == 12) 
            h = 0; 
        if (m == 60)  
            m = 0; 
        double hour_angle = (double)(0.5 * (h*60 + m)); 
        double minute_angle = (double)(6*m); 
        double angle = (double)Math.abs(hour_angle - minute_angle); 
        angle = (double)Math.min(360-angle, angle); 
        return angle; 
    } 

    public static void calcAngle()
    {
        DecimalFormat df = new DecimalFormat("#.####################");
        double a=in.nextDouble(),b=in.nextDouble();
        double h=in.nextDouble(),m=in.nextDouble();
        double angle=Math.abs(30*h - 11*m/2.0);
       double ans=Math.toRadians(angle);
        double c= Math.sqrt(a*a + b*b - 2.0*a*b*Math.cos(ans));
        System.out.println(df.format(c));
    }

    static double third_side(double a,  
                    double b, double c) 
    { 
        double angle =(double) Math.cos((double)Math.toRadians(c));
        return (double)Math.sqrt((a * a) + 
            (b * b) - 2 * a * b * angle); 
} 

public static void evenTenPow(int N) throws IOException {
    int result = 0;
    for(int i = 1; i <= N; i++) {
            if((int)Math.floor(Math.log10(i) + 1) % 2 == 1) {
                    result++;
            }
    }
    System.out.println(result);
    sc.close();
}

public static void decimal(int n){
    double m=n/2;
    double k=Math.floor(m);
    double l=(n-k)/n;
    System.out.println(l);
  }

  public static void evenTenPow(final int N) {
    long ans = 0;
    for(int i=N;i>0;i--){
        if(Math.floor(Math.log10(i))%2==0){
            ans++;
        }
    }
    System.out.println(ans);
}

int numberOfDigits(int n) {
    return (int) Math.floor(Math.log10(n)) + 1;
}

public static void halfDecimal(Long N) {
    System.out.println((double)(N - Math.floor(N/2)) / N);
}

public static void countTriangle(int n) {
 double d=s.nextDouble();
 int c=0;
 for(int i=0;i<n;i++)
 {
     int x=s.nextInt();
     int y=s.nextInt();
     long x1=x*x;
     long y1=y*y;
    double d1 = Math.hypot(x, y);
     if(d1<=d)
     {
     c++;
     }
 }
 System.out.println(c);
}

public static boolean triangle(int i,int[][] t){
    double max=Math.max(Math.max(t[i][0],t[i][1]),t[i][2]);
    double res=Math.min(Math.min(Math.hypot(t[i][0],t[i][1]),Math.hypot(t[i][0],t[i][2])),Math.hypot(t[i][2],t[i][1]));
    if(res==max){return true;}
    else{return false;}
    }

    public static void getTickDistance(int A, int B , int H , int M) {
        double arg1 = 30 * H + 0.5 * M;
        double arg2 = 6 * M;
        double x1 = A * Math.cos(Math.toRadians(arg1));
        double y1 = A * Math.sin(Math.toRadians(arg1));
        double x2 = B * Math.cos(Math.toRadians(arg2));
        double y2 = B * Math.sin(Math.toRadians(arg2));
        System.out.println(Math.hypot(x2 - x1, y2 - y1));
      }

      public void getTickDistance(int testNumber, InputReader in, PrintWriter out) {
        double a = in.nextInt(), b = in.nextInt();
        double h = in.nextInt(), m = in.nextInt();
        double x1 = a * Math.cos((h + m / 60) / 12 * 2 * Math.PI);
        double y1 = a * Math.sin((h + m / 60) / 12 * 2 * Math.PI);
        double x2 = b * Math.cos(m / 60 * 2 * Math.PI);
        double y2 = b * Math.sin(m / 60 * 2 * Math.PI);
        out.println(Util.formatDouble(Math.hypot(x1 - x2, y1 - y2)));
    }

    public static void isTriangle(int N, int D, long x, long y) {
        int count = 0;
        double distance = 0;
        for (int i = 0; i < N; i++ ) {
                x = sc.nextLong();
                y = sc.nextLong();
                distance = Math.hypot(x, y);
                if (distance <= D) count++;
        }
        sc.close();
        System.out.println(count);
}

    public static void triangle(int n , double d, int inputArray[]) {
  int c=0;
  for(int i=0;i<n;i++)
  {
      int x=inputArray[2*i];
      int y=inputArray[2*i + 1];
      long x1=x*x;
      long y1=y*y;
     double d1 = Math.hypot(x, y);
      if(d1<=d)
      {
      c++;
      }
  }
  System.out.println(c);
    }

public static double log2(long N) 
{ 
    double result = (double)(Math.log(N) / Math.log(2)); 
    return result; 
}

static double log(double base,double antilogarithm){
    return Math.log(antilogarithm)/Math.log(base);
}

public SegmentTree(int n) {       
    int h = (int)Math.ceil((double)Math.log(n)/Math.log(2));
    this.size = (int)Math.pow(2,h)*2-1;
    seg = new int[size];
}

static boolean isPower(int a, int b)
    {
        double temp = Math.log(a)/Math.log(b);
        return temp == (int) temp;
    }

    static int bits(long x)
    {
        int n=(int)(Math.floor(Math.log(x)/Math.log(2)))+1;
        return (1<<n);
}

public static void sqrLog(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(in.readLine());
    long a = 1;
    for(int i=1; i<=Math.sqrt(n); i++){
      if(n%i==0)
        a = n/i;
    }
    System.out.println((int)Math.log10(a)+1);
  }

  private static int compareLog(long a, long b) {
    return Math.max((int)(Math.log10(a))+1, (int)(Math.log10(b))+1);
}

private static int digits(long x) {
    return (int)Math.log10(x)+1;
}

static int pow(int n) {
    return (int) (Math.log10(n) / Math.log10(2));
}

public static void countLog(int n) {
    int count = 0;
    for (int i = 1; i <= n; i++) {
        if(((int) Math.log10(i) + 1) % 2 == 1) {
            count++;
        }
    }
    System.out.println(count);
}

static long max(long a, long b) {

    return Math.max(a, b);
}

public static String largestSum(TestCase testCase) {
    List<Integer> L = testCase.L;
    int largest = 0;
    int sum = 0;
    for (int side : L) {
        largest = Math.max(largest, side);
        sum += side;
    }
    return (largest < (sum - largest)) ? YES : NO;
}

static double max(double d, double e) {

    return Math.max(d, e);
}

private static int getDifference(int n, int[] as) {
    int aMax = as[0];
    int aMin = as[0];
    for (int a : as) {
      aMax = Math.max(aMax, a);
      aMin = Math.min(aMin, a);
    }
    return aMax - aMin;
  }

  public void mergeSort(int testNumber, InputReader in, PrintWriter out) throws IOException {
    int n = in.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = in.nextInt();
    }
    int[] right = new int[n];
    int[] left = new int[n];
    right[n-1] = 0;
    left[0] = 0;
    for (int i = n-2; i >= 0; i--) {
        right[i] = Math.max(arr[i+1], right[i+1]);
    }
    for (int i = 1; i < n; i++) {
        left[i] = Math.max(arr[i-1], left[i-1]);
    }
    for (int i = 0; i < n; i++) {
        out.println(Math.max(right[i], left[i]));
    }
}

static long min(long n,long m)
    {
        return Math.min(n,m);
    }

    public static void getDifference(String s , int min , int max) {
        for(int i = 0; i < s.length(); i++) {
                if('A'==s.charAt(i)) {
                        min = Math.min(min, i);
                }
                if('Z'==s.charAt(i)) {
                        max = Math.max(max, i);
                }
        }
        System.out.println((max - min) + 1);
}

public int minGap(int n, int[] height) {
    int pre = 0;
    int cur = 0;
    if(n <= 1)
        return 0;
    pre = 0;
    cur = Math.abs(height[1] - height[0]);
    for(int i = 2; i < n; i++){
        int t = Math.min(cur + Math.abs(height[i] - height[i-1]),
                        pre + Math.abs(height[i] - height[i-2]));
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
                    ans = Math.abs(arr[i]-arr[i-1])+dp[i-1];
            }
            if(i-2>=0) {
                    ans = Math.min(ans, Math.abs(arr[i]-arr[i-2])+dp[i-2]);
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
    dp[1]=Math.abs(A[0]-A[1]);
    for(int i=2;i<n;i++)
        dp[i]=Math.min(dp[i-1]+Math.abs(A[i-1]-A[i]),dp[i-2]+Math.abs(A[i-2]-A[i]));
    pn(dp[n-1]);
}

public static void countSmallDist (int n, double d, int inputX[], int inputY[]) throws java.lang.Exception
{
        int count = 0;
        while(n-- >0){
                int x = input[n];
                int y = input[n];
                double dis = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
                if(dis<=d){
                        count++;
                }
        }
        System.out.println(count);
}

public static void countBigDist(int N, int D, int inputX[], int inputY[]) throws Exception {
    int count = 0;
    for(int i = 0; i < N; i++){
        int x = inputX[i];
        int y = inputY[i];
        double d = (Math.pow(x, 2) + Math.pow(y, 2));
        if(Math.pow(D, 2) >= d) count++;
    }
    System.out.println(count);
}

void countSmallDist(int n, double d, int inputX[], int inputY[])
    {
        int c=0;
        while(n-->0)
        {
            int x = input[n];
            int y = input[n];
            double sp=Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
            if(sp<=d)
            c++;
        }
        println(c);
    }

    public static boolean isExpN(long a,int base){
        int x=1;
        while((int)Math.pow(x, 2) <= a){
                if((int)Math.pow(x, 2) == a){
                        return true;
                }
                x*=base;
        }
        return false;
}

public static void sumPow(int K, int inputArray[]){
    int sum = 0;
    List<Integer> a = new ArrayList<>();
    for (int i = 0; i < K; i++) {
    int d = inputArray[i];
            a.add(d);
    }
    Collections.sort(a,Collections.reverseOrder());
    for(int i=0; i<a.size();i++)
    {
            sum += (Math.pow((-1),(i)))*(a.get(i));
    }
    System.out.println(sum);
}

public static void pow100(int D, int N) {
    if(D == 0&&N == 100){
            System.out.println(101);
    }else if(D == 1&&N == 100){
            System.out.println(10100);
    }else if(D == 2&&N ==100){
            System.out.println(1010000);
    }else{
            System.out.println(Math.round(N * Math.pow(100,D)));
    }
}

public static void pow100(String[] line) {
    final int a = Integer.parseInt(line[0]);
    final int b = Integer.parseInt(line[1]);
    final long pow = Math.round(Math.pow(100, a));
    if (b <= 99) {
        System.out.println(b * pow);
    } else {
        System.out.println(101 * pow);
    }
}

public static void intDevide(int A, int B , int t ) {
    int T = (int) Math.round(t + 0.5);
    int b = 0;
    for (int t = 1; t < T; t++) {
        if (t % A == 0) {
            b += B;
        }
    }
    System.out.println(b);
}

public static void maxPow(double a){
    double ans = 0;
    for(double i = 6; i > 0;i--){
      if(a >= Math.pow(2,i)){
        ans = Math.pow(2,i);
        break;
      }
    }
    if(a == 1){
      ans = 1;
    }
    System.out.println(Math.round(ans));
  }

  public static void maxPow(int N ) {
    int N = scan.nextInt();
    int n = 0;
    while (Math.pow(2,n + 1) <= N ) {
      n = n + 1;
    } 
      System.out.println(Math.round(Math.pow(2,n)));
}

public static void getTickDistance(double a , double b , double h , double m) {
    double mm = -Math.toRadians(m)*6;
    double hh = -Math.toRadians(h+m/60)*30;
    double x = Math.cos(hh)*a-Math.cos(mm)*b;
    double y = Math.sin(hh)*a-Math.sin(mm)*b;
    System.out.println(Math.sqrt(x*x+y*y));
}

private static Point point(double r, double deg) {
    double x = r * Math.sin(deg);
    double y = r * Math.cos(deg);
    return new Point(x, y);
}

public Point(double deg, double r) {
    double rad = deg * Math.PI / 180.0;
    x = Math.cos(rad) * r;
    y = Math.sin(rad) * r;
  }

  public static double dist(int x1, int b, double angle){
    double x2=b*Math.cos(angle), y2=b*Math.sin(angle);
    return Math.sqrt(Math.pow((x2-x1), 2)+y2*y2);
}

public void getTickDistance(int testNumber, InputReader in, PrintWriter out) {
    double a = in.nextInt(), b = in.nextInt();
    double h = in.nextInt(), m = in.nextInt();
    double x1 = a * Math.cos((h + m / 60) / 12 * 2 * Math.PI);
    double y1 = a * Math.sin((h + m / 60) / 12 * 2 * Math.PI);
    double x2 = b * Math.cos(m / 60 * 2 * Math.PI);
    double y2 = b * Math.sin(m / 60 * 2 * Math.PI);
    out.println(Util.formatDouble(Math.hypot(x1 - x2, y1 - y2)));
}

private static void getTickDistance(){
    double A = nd();
    double B = nd();
    double H = nd();
    double M = nd();
    double ang = 30D * H + 0.5D * M - 6D * M;
    double asin = A * Math.sin(Math.toRadians(ang));
    double acos = A * Math.cos(Math.toRadians(ang));
    double height = asin;
    double width = B - acos;
    System.out.println(Math.sqrt(height * height + width * width));
}

private static boolean isPrime(int n) {
    if (n == 2)
        return true;
    else if ((n % 2 == 0 && n > 2) || n < 2)
        return false;
    else {
        for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}

static List<Integer> primeList(int n){
    List<Integer> list = new ArrayList<>();
    boolean[] prime = new boolean[n + 1];
    Arrays.fill(prime, true);
    prime[0] = false;
    prime[1] = false;
    for (int i = 2; i < Math.sqrt(n); i++){
      if (!prime[i]){continue;}
      for (int j = 2; i * j <= n; j++){
        prime[i * j] = false;
      }
    }
    for (int i = 0; i < prime.length; i++){
      if (prime[i]){list.add(i);}
    }
    return list;
  }

  static boolean isPrime (int n) {
    if (n==2) return true;
    if (n<2 || n%2==0) return false;
    double d = Math.sqrt(n);
    for (int i=3; i<=d; i+=2)if(n%i==0){return false;}
    return true;
}

public void nTimesSum(int testNumber, int N, PrintWriter out) {
    int max = (int) Math.sqrt(N) + 1;
    int sn = 0;
    String s = "" + N;
    for (int i = 0; i < s.length(); i++) {
        sn += Integer.parseInt("" + s.charAt(i));
    }
    out.println(N % sn == 0 ? "Yes" : "No");
}

public static boolean[] sieve(long n)
    {
        boolean[] prime = new boolean[(int)n+1];
        Arrays.fill(prime,true);
        prime[0] = false;
        prime[1] = false;
        long m = (long)Math.sqrt(n);
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

    public static void checkMapSize(String nextLine) {
        String[] arr = nextLine.split(" ");
        sc.close();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (String val : arr) {
            Integer count = countMap.get(Integer.parseInt(val));
            if (Objects.isNull(count)) {
                countMap.put(Integer.parseInt(val), 0);
            }else{
            countMap.put(Integer.parseInt(val), count++);
            }
        }
        if (countMap.size() == 2) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void string2Map(int N) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 1; i < N; i++) {
            int boss = sc.nextInt();
            Integer count = resultMap.get(boss);
            if (Objects.isNull(count)) {
                count = 1;
            } else {
                count += 1;
            }
            resultMap.put(boss, count);
        }
        for (int i = 1; i <= N; i++) {
            Integer val = resultMap.get(i);
            if (Objects.isNull(val)) {
                System.out.println(0);
            } else {
                System.out.println(val);
            }
        }
    }  

    public static void getMaxMultiple4(int a , int b , int c , int d) {
        long ac = (long)a*c;
        long ad = (long)a*d;
        long bc = (long)b*c;
        long bd = (long)b*d;
        Optional<Long> max = Arrays.asList(ac,ad,bc,bd).stream().max(Comparator.naturalOrder());
        System.out.println(max.get());
}

public static void checkBothTimes(int a , int b , int k) {
    int min = a < b ? a : b;
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 1; i <= min; i++) {
        if (a % i == 0 && b % i == 0) {
            list.add(i);
        }
    }
    Optional<Integer> an = list.stream()
            .sorted(Comparator.reverseOrder())
            .skip(k - 1)
            .findFirst();
    System.out.println(an.orElse(0));
}

public static Double calculate(Double base, Double n) {
    return Math.pow(Math.E, Math.log(base)/n);
}

public static void areaAndCircumference(double r) {
    double area = r * r * Math.PI;
    double circumference = r * 2 * Math.PI;
    System.out.printf("%f %f\n", area, circumference);
  }

  public static void areaAndCircumference(double r) {
    double area = Math.PI * r * r;
    double circumference = 2 * Math.PI * r;
    String areastr = String.format("%.6f", area);
    String circumferencestr = String.format("%.6f", circumference);
    System.out.println(areastr + " " + circumferencestr);
}

public static void areaAndCircumference(double r){
    Formatter frm=new Formatter();
    double S=Math.PI*r*r*1.0;
    double d=2*Math.PI*r*1.0;
    System.out.println(String.format("%5f",S)+" "+String.format("%5f",d));
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
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
        int x = inputArray[i];
        min = Math.min(min, x);
        max = Math.max(max, x);
    }

    return max - min;
}

public static void getDifference(final String[] args) throws IOException {
    FastReader in = new FastReader();
    PrintWriter out = new PrintWriter(System.out, true);
    int n = in.nextInt();
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
        int value = in.nextInt();
        if (value > max) {
            max = value;
        }
        if (value < min) {
            min = value;
        }
    }
    out.println(max - min);
}

public int nextInt() {
    long nl = nextLong();
    if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
    return (int) nl;
}

public static void cal(String[] args) throws IOException {
    int N = readInt(), X = readInt(), min = Integer.MAX_VALUE; for(int i = 1; i<=N; i++) {
            int k = readInt(); X-=k; min = Math.min(k, min);
    }
    println(N + X/min);
    exit();
}

public static void findMaxv(int n, int minv, int inputArray[]){
    int maxv = Integer.MIN_VALUE;
    for(int i=1;i<n;i++){
       int in = inputArray[i];
       maxv = Math.max(maxv, in-minv);
       minv = Math.min(minv, in);
    }
    System.out.println(maxv);
}

public List<Integer> gerPrimes() {
    return Collections.unmodifiableList(primes);
}

static int countGreater(LinkedList<Integer> q) {
    int size = q.size();
    int count = 0;
    size/=2;
    while (size-->0) {
        int first = q.pollFirst();
        int second = q.pollFirst();
        if(first+second>=10) count++;
        int newValue = (first+second)%10;
        q.addLast(newValue);
    }
    return count;
}

static void bfs(int s)
{
    vis[s] = true;
    Queue<Integer> q = new LinkedList<>();
    q.add(s);
    color[s] = 1;
    level[s] = 0;
    p[s] = s;
    while(q.size()>0)
    {
        int cc = q.poll();
        Iterator itr = hs[cc].iterator();
        while(itr.hasNext())
        {
            Integer e = (Integer) itr.next();
            if(!vis[e])
            {
               
                q.add(e);
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
    List<Integer> list = new LinkedList<>();
    int max = 0;
    int order = 0;
    for (int i = 0; i < N; i++) {
            int num = input[i];
            if (max < num) {
                    max = num;
                    order = i;
            }
            list.add(num);
    }
    Collections.sort(list);
    int submax = list.get(list.size() - 2);
    for (int i = 0; i < N; i++) {
                    System.out.println(i == order ? submax : max);
    }
}

public static void differentNext(char[] s) {
    List<Character> ans = new LinkedList<>();
    ans.add(s[0]);
    for(int i = 0;i<s.length - 1;i++){
        if(s[i] != s[i + 1]){
            ans.add(s[i + 1]);
        }
    }
    System.out.println(ans.size());
}

public static void top2Bot(int n, String str) {
    LinkedList<Character> stack = new LinkedList<>();
    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        while (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            }
            stack.push(c);
    }
    System.out.println(stack.size());
}

public static void count0(LinkedList<String> list) {
    int ans = 0;
    for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("0")) {
                    ans = i + 1;
            }
    }
    System.out.println(ans);
}

public void differentNext() throws Exception{
    final int N = sc.nextInt();
    final String[] S = new String[N+1];
    for(int i=0;i<N;i++) {
            S[i] = sc.next();
    }
    S[N] = "";
    Arrays.sort(S, 0, N);
    int max = 0;
    int cnt = 1;
    List<String> list = new LinkedList<String>();
    for(int i=1;i<N+1;i++) {
            if(!S[i-1].equals(S[i])) {
                    if(max < cnt) {
                            list.clear();
                            max = cnt;
                            list.add(S[i-1]);
                    }else if (max == cnt){
                            list.add(S[i-1]);
                    }
                    cnt = 1;
            }else {
                    cnt++;
            }
    }
    for(String s : list) {
            out.println(s);
    }
}

public static void allContainPos(int n, String[] args){
    HashMap<String,Integer> map = new HashMap<String,Integer>();
    LinkedList<String> array = new LinkedList<String>();
    int max = 1;
    for(int i = 0; i < n; i++){
      String s = args[i];
      int tmp = 1;
      if(map.containsKey(s)){
        tmp = map.get(s)+1;
      }
      map.put(s, tmp);
      if(tmp == max){
        array.add(s);
      } 
      else if(tmp > max){
        max = tmp;
        array.clear();
        array.add(s);
      }
    }
    array.sort(Comparator.naturalOrder());
    for(String value : array)
        {
      System.out.println(value);
        }
  }

  public int getTimes(int[] hs, int height, int start, int end) {
    if (start > end) {
            return 0;
    } else if (start == end) {
            return hs[start] - height;
    }
    List<Integer> list = new LinkedList<Integer>();
    int min = Integer.MAX_VALUE;
    for (int i=start; i<=end; i++) {
            if (hs[i] < min) {
                    min = hs[i];
                    list.clear();
                    list.add(i);
            } else if (hs[i] == min) {
                    list.add(i);
            }
    }
    int result = min - height; 
    int nextIndex = start;
    for (int x : list) {
            result += getTimes(hs, min, nextIndex, x-1);
            nextIndex = x+1;
    }
    result += getTimes(hs, min, nextIndex, end);
    return result;
}

public static void compareFirst(int n, String[] args) {
    LinkedHashSet<String> lhs = new LinkedHashSet<>();
    LinkedList<String> ll = new LinkedList<>();
    int f = 0;
    while(n-- != 0)
    {
        String s = args[i];
        if(lhs.contains(s))
        f = 1;
        lhs.add(s);
    }
    if(f == 1)
    System.out.print("No");
    else
    {
        ll.addAll(lhs);
        for(int i = 0;i < ll.size() - 1;i++)
        {
            String s1 = ll.get(i);
            String s2 = ll.get(i + 1);
            if(s1.charAt(s1.length() - 1) != s2.charAt(0))
            {
            f = 1;
            break;
            }
        }
        if(f == 1)
        System.out.print("No");
        else
        System.out.print("Yes");
    }
}

public static void lineUp( int n, int q, String nameArray[], int timeArray[]){
    LinkedList<String> name=new LinkedList<String>();
    LinkedList<Integer> time=new LinkedList<Integer>();
    int t=0;
    for(int i=0;i<n;i++){
            name.add(nameArray[i]);
            time.add(timeArray[i]);
    }
    while(!name.isEmpty()){
            if(time.peek()<=q){
                    System.out.print(name.poll()+" ");
                    t=t+time.poll();
                    System.out.println(t);
            }else{
                    name.add(name.poll());
                    time.add(time.poll()-q);
                    t=t+q;
            }
    }
}

    void radix26() {
            long N = sc.nextLong() - 1;
            LinkedList<Integer> stack = new LinkedList<>();
            while(N >= 0) {
                    stack.push((int)(N % 26));
                    N -= 26;
                    if(N < 0) break;
                    N /= 26;
            }
            while(!stack.isEmpty()) {
                    int c = stack.pollFirst();
                    System.out.print((char)(c + 'a'));
            }
    }

    static void radix26() throws Exception{
        LinkedList<Integer>ans=new LinkedList<>();
        long n=sc.nextLong();
        while(n>0) {
                n--;
                ans.addFirst((int)(n%26));
                n/=26;
        }
        while(!ans.isEmpty()) {
                pw.print((char)(ans.poll()+'a'));
        }
}


public static void calWaitingTime(int n, int q, String nameArray[], int timeArray[]){
    LinkedList<Pair> queue = new LinkedList<>();
    int time_w = 0;
    for(int i=0; i<n; i++){
        String str = nameArray[i];
        int time = timeArray[i];
        if(time > q){
            time_w += q;
            queue.add(new Pair(str, time-q));
        }else{
            time_w += time;
            System.out.println(str+" "+time_w);
        }
    }
    while(!queue.isEmpty()){
        Pair p = queue.poll();
        String str = p.name;
        int time = p.left;
        if(time > q){
            time_w += q;
            queue.add(new Pair(str, time-q));
        }else{
            time_w += time;
            System.out.println(str+" "+time_w);
        }
    }
}

public static void calWaitingTime(String first, ArrayDeque<String> args) {
    String[] components = first.split(" ");
    int inputs = Integer.parseInt(components[0]);
    int quantum = Integer.parseInt(components[1]);
    int time = 0;
    LinkedList<Process> q = new LinkedList<>();
    while (args.size() > 0) {
            String i = args.peek();
            args.pop();
            String[] c = i.split(" ");
            q.add(new Process(c[0], Integer.parseInt(c[1])));
    }
    while (!q.isEmpty()) {
            Process curr = q.poll();
            if (curr.t <= quantum) {
                    time += curr.t;
                    System.out.println(curr.n + " " + time);
            } else {
                    curr.t -= quantum;
                    time += quantum;
                    q.add(curr);
            }
    }
}

    public static void checkAns( String str, String ans){
            int count = 0;
            int max = 0;
            LinkedList<String> word = new LinkedList<String>();
            LinkedList<String> Ans = new LinkedList<String>();
            for (int i = 0; i < str.length(); i++) {
                String str2 = String.valueOf(str.charAt(i));
                String ans2 = String.valueOf(ans.charAt(i));
                word.add(str2);
                Ans.add(ans2);
            }
            for(int i=0; i<str.length(); i++){
                    word.addFirst(word.getLast());
                    word.removeLast();
                    if(word.equals(Ans)){
                            System.out.println("Yes");
                            return;
                    }
            }
            System.out.println("No");
    }

    public static void calculator(LinkedList<String> input) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while(!input.isEmpty()){
                String ops = input.poll();
                if("+".equals(ops)){
                        final int a = stack.poll();
                        final int b = stack.poll();
                        stack.addFirst(b + a);
                }else if("-".equals(ops)){
                        final int a = stack.poll();
                        final int b = stack.poll();
                        stack.addFirst(b - a);
                }else if("*".equals(ops)){
                        final int a = stack.poll();
                        final int b = stack.poll();
                        stack.addFirst(b * a);
                }else if("/".equals(ops)){
                        final int a = stack.poll();
                        final int b = stack.poll();
                        stack.addFirst(b / a);
                }else{
                        stack.addFirst(Integer.parseInt(ops));
                }
        }
        System.out.println(stack.poll());
}

public static LinkedList<Long> divisors(long N){
    LinkedList<Long> ans = new LinkedList<>();
    for(long n = (long)(Math.sqrt(N)+2); n>0; n--){
        if(n*n>N) continue;
        else if(n*n==N) ans.add(n);
        else if(N%n==0){
            ans.addFirst(n);
            ans.addLast(N/n);
        }
    }
    return ans;
}


public static void getMean(int N, double inputArray[]) {
    LinkedList<Double> v = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      v.add(inputArray[i]);
    }
    Collections.sort(v);
    while (v.size() > 1) {
      double a = v.poll();
      double b = v.poll();
      v.addFirst((a + b) / 2.0);
    }
    System.out.println(v.get(0));
  }

  void radix26(long n) {
    LinkedList<String> ans = new LinkedList<>();
    do {
        n--;
        ans.addFirst("" + (char)('a' + n % 26));
        n /= 26;
    } while (n != 0);
}

static int countCarry(LinkedList<Integer> q) {
    int size = q.size();
    int count = 0;
    size/=2;
    while (size-->0) {
        int first = q.pollFirst();
        int second = q.pollFirst();
        if(first+second>=10) count++;
        int newValue = (first+second)%10;
        q.addLast(newValue);
    }
    return count;
}

public static LinkedList<Integer> comp(LinkedList<Integer> q){
    LinkedList<Integer> op = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();
    while(q.size()>0){
            stack.push(q.pop());
    }
    while(stack.size()>0){
            op.addLast(stack.pop());
    }
    return op;
}

public static LinkedList<Long> divisors(long N){
    LinkedList<Long> ans = new LinkedList<>();
    for(long n = (long)(Math.sqrt(N)+2); n>0; n--){
        if(n*n>N) continue;
        else if(n*n==N) ans.add(n);
        else if(N%n==0){
            ans.addFirst(n);
            ans.addLast(N/n);
        }
    }
    return ans;
}

public static void checkLast( String s ) {
    String s = sc.next();
    LinkedList<Character> display = new LinkedList<>();
    for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='B') display.pollLast();
            else display.addLast(s.charAt(i));
    }
    for(char c:display) System.out.print(c);
    System.out.println();
}

public int checkLast(String S) {
    int ans = 0;
    LinkedList<Integer> list = new LinkedList();
    for (char c : S.toCharArray()) {
      int i = (int) c - ZERO;
      if (list.size() == 0) {
        list.addLast(i);
      } else {
        if (list.getLast() != i) {
          list.removeLast();
          ans += 2;
        } else {
          list.addLast(i);
        }
      }
    }
    return ans;
  }

  public void push(int item) {
    stack.addLast(item);
}

static void seive() {
    for (int i = 2; i < 100001; i++) {
        if (!v[i]) {
            t++;
            l.add(i);
            for (int j = 2 * i; j < 100001; j += i)
                v[j] = true;
        }
    }
}

static void shuffle(int a[]) {
    List<Integer> l = new ArrayList<>();
    for (int i = 0; i < a.length; i++)
        l.add(a[i]);
    Collections.shuffle(l);
    for (int i = 0; i < a.length; i++)
        a[i] = l.get(i);
}

static int countCarry(LinkedList<Integer> q) {
    int size = q.size();
    int count = 0;
    size/=2;
    while (size-->0) {
        int first = q.pollFirst();
        int second = q.pollFirst();
        if(first+second>=10) count++;
        int newValue = (first+second)%10;
        q.addLast(newValue);
    }
    return count;
}

public static void mergeStr(int iNum, String sStr ) {
    String[] sSplitStr = sStr.split(" ");
    String s1 = sSplitStr[0];
    String s2 = sSplitStr[1];
    String[] s1Split = s1.split("");
    String[] s2Split = s2.split("");
    List<String> listStr = new LinkedList<String>();
    for (int i = 0; i < iNum; i++) {
      listStr.add(s1Split[i]);
      listStr.add(s2Split[i]);
    }
    StringBuilder sb = new StringBuilder();
    for (String str : listStr) {
      sb.append(str);
    }
    System.out.printf(sb.toString());
  }

  public static void compList(String s , String t) throws Exception {
    List <String> sList = new LinkedList<>(Arrays.asList(t.split("")));
    List <String> tList = new LinkedList<>(Arrays.asList(s.split("")));
    int flag = 0;
    int n = tList.size();
    for(int i = 0; i < n; i++){
        String a = tList.remove(n-1);
        tList.add(0,a);
        if(tList.equals(sList)){
            flag = 1;
            break;
        }
    }
    if(flag == 1) System.out.println("Yes");
    else System.out.println("No");
}

public static void compList(String s) {
    String[] sArray = s.split("");
    LinkedList<String> ansList = new LinkedList<>();
    for(int i = 0; i < s.length(); i++){
            if(sArray[i].equals("1")) {
                    ansList.add("1");
            } else if(sArray[i].equals("0")) {
                    ansList.add("0");
            } else if(sArray[i].equals("B") && ansList.size() != 0){
                    ansList.removeLast();
            }
    }
    for(String ans: ansList){
            System.out.print(ans);
    }
}

void graphInput(int n)
 {
    for(int i = 0;i < n;i++)
    {
        int a = ni();
        int b = ni();

        if(!graph.containsKey(a))
        {
            List<Integer> l = new ArrayList<>();
            l.add(b);
            graph.put(a, l);
        }
        else
            graph.get(a).add(b);
    }
    System.out.println(graph);
}

public static void checkEven(String w){
    String result = "Yes";
    List<String> wArray = new LinkedList<String>();
    HashSet<String> wSet = new HashSet<>();
    for(int i = 0; i < w.length(); i++){
        String word = String.valueOf(w.charAt(i));
        wArray.add(word);
        wSet.add(word);
    }
    for(String str : wSet){
        int counter = 0;
        while(wArray.contains(str)){
            wArray.remove(str);
            counter++;
        }
        if(counter % 2 != 0){
            result = "No";
            break;
        }
    }
    System.out.println(result);
}

public static void count0(LinkedList<String> list) {
    int ans = 0;
    for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("0")) {
                    ans = i + 1;
            }
    }
    System.out.println(ans);
}

public static void countEqual(String anticipation , String real) {
    List<String> AList = Arrays.asList(anticipation.split(""));
    List<String> RList = Arrays.asList(real.split(""));
    int count = 0;
    for (int i = 0; i < 3; i++) {
            String a = AList.get(i);
            String r = RList.get(i);

            if (a.equals(r)) {
                    count++;
            }
    }
    System.out.println(count);
}
static ArrayList<String> myconv(String str, int no){//only split
    String splitString = CONVSTR.get(no);
    return new ArrayList<String>(Arrays.asList(str.split(splitString)));
}
static List<Integer> inputIntList() throws Exception {
    List<String> strList = Arrays.asList(br.readLine().trim().split(" "));
    List<Integer> intList = new ArrayList<Integer>();
    for (String elem : strList){
        intList.add(Integer.parseInt(elem));
    }
    return intList;
}

public static void morePositiveNums(Integer[] lines) {
    List<Integer> list = Arrays.asList(lines);
    if(Collections.max(list) >= sum(list)) {
        System.out.println("No");
    } else {
        System.out.println("Yes");
    }
}

public static void cal(Integer a, Integer b, Integer c){
    List <Integer> list = new ArrayList<>(Arrays.asList(a, b, c));
    Collections.sort(list);
    System.out.println((int)(list.get(0) + list.get(1) + list.get(2) * Math.pow(2, sc.nextInt())));
  }

public static void getLastUpper(String A, String B, String C){
    a.addAll(Arrays.asList(A.split("")));
    b.addAll(Arrays.asList(B.split("")));
    c.addAll(Arrays.asList(C.split("")));
    String lastValue = "a";
    String ans = "";
    while(true) {
    lastValue = syori(lastValue);
    if(Character.isUpperCase(lastValue.charAt(0))) {
        ans = lastValue;
        break;
    }
}
    System.out.println(ans);
}

    public static void getCalMax(int A , int B) {
        List<Integer> resultList = new ArrayList<>();
        resultList.addAll(Arrays.asList(A+B, A-B, A*B)); 
        int max = -100;
        for (int i=0; i<resultList.size(); i++) {
            max = Math.max(max, resultList.get(i));
        }
        System.out.println(max);
    }

    private void perm(int[] a, int cur, List<Integer> tmp, List<List<Integer>> list) {
        if (cur == a.length) {
            List<Integer> res = new ArrayList<>();
            res.addAll(tmp);
            list.add(res);
            return;
        }
        for (int i = cur; i < a.length; ++i) {
            swap(a, i, cur);
            tmp.add(a[cur]);
            perm(a, cur + 1, tmp, list);
            tmp.remove(tmp.size() - 1);
            swap(a, i, cur);
        }
    }

    public static List<String> getStrOnLine() throws IOException {
        List<String> list = new ArrayList<>();
        String line = getLine();
        
        list.addAll(Arrays.asList(line.split(" ")));
        return list;
    }

    private static void makePrimeList(int n) {
        List<Integer> searchList = new ArrayList<>();
        for (int i = 2; i <= n; ++i) {
            searchList.add(i);
        }
        primeList = new ArrayList<>(n);
        do {
            int prime = searchList.remove(0);
            primeList.add(prime);
            int i = 2;
            while (prime * i <= n) {
                searchList.remove((Integer)(prime * i));
                ++i;
            }
        } while (searchList.size() > 0 && searchList.get(0) <= Math.sqrt(n));
        primeList.addAll(searchList);
    }

    public static void intArrayListPrint(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));  
        }
    }

    static ArrayList<Long> nextLongArray(){
        ArrayList<String> input = nextStrArray(); ArrayList<Long> ret = new ArrayList<Long>(input.size());
        for(int i = 0; i < input.size(); i++){
                ret.add(Long.parseLong(input.get(i)));
        }
        return ret;
}

static ArrayList<Integer> nextIntArray(){
    ArrayList<String> input = nextStrArray(); ArrayList<Integer> ret = new ArrayList<Integer>(input.size());
    for(int i = 0; i < input.size(); i++){
            ret.add(Integer.parseInt(input.get(i)));
    }
    return ret;
}

public static boolean isDrawPolygon(List<Integer> sideList) {
    int sum = 0;
    for(int i = 1; i < sideList.size(); i++) {
      sum += sideList.get(i);
    }
    return sideList.get(0) < sum ? true : false;
  }


  public static void getALlCase(String[] args) throws NumberFormatException, IOException {
    ArrayList<Integer> arrPost = new ArrayList<Integer>();
    BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
    while(true) {
            int n = Integer.parseInt(buffReader.readLine());
            if(n == 0)      break;
            else            arrPost.add(n);
    }
    for(int i = 0; i < arrPost.size(); i++) System.out.println("Case " + (i + 1) + ": " + arrPost.get(i));
}

public static void checkEvenCount(String w){
    String result = "Yes";
    List<String> wArray = new LinkedList<String>();
    HashSet<String> wSet = new HashSet<>();

    for(int i = 0; i < w.length(); i++){
        String word = String.valueOf(w.charAt(i));
        wArray.add(word);
        wSet.add(word);
    }
    for(String str : wSet){
        int counter = 0;
        while(wArray.contains(str)){
            wArray.remove(str);
            counter++;
        }
        if(counter % 2 != 0){
            result = "No";
            break;
        }
    }
    System.out.println(result);
}

public static void findMiddle(String args[]) throws java.lang.Exception
        {
                BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
                String h[]=inp.readLine().split(" ");
                String hh[]=new String[0];
                if(Integer.parseInt(h[1])!=0){hh=inp.readLine().split(" ");}
                HashSet<Integer>hash=new HashSet<>();
                for(int i=0;i<hh.length;i++){hash.add(Integer.parseInt(hh[i]));}
                int x=Integer.parseInt(h[0]);
                int x1=x;
                int ans=0;
                while(true)
                {
                        if(!hash.contains(x1)){ans=x1;break;}
                        x1++;
                }
                x1=x-1;
                while(true)
                {
                        if(!hash.contains(x1)){if(x-x1<=ans-x){ans=x1;}break;}
                        x1--;
                }
                System.out.println(ans);
        }

        public static void checkValid(int N, String wordsInput, String args[]) {
            LinkedList<String> words = new LinkedList<String>();
            words.add(wordsInput);
            boolean valid = true;
            for (int i = 1; i < N; i++) {
                    String x = args[i];
                    String prev = words.get(i-1);
                    if (words.contains(x)||x.charAt(0)!=prev.charAt(prev.length()-1)) {
                            valid = false;
                            break;
                    }
                    words.add(x);
            }
            System.out.println(valid? "Yes":"No");
    }

    public static void getContainsX(int numA , int numB , int numC) {
        List<Integer> numAList = getNums(numA);
        List<Integer> numBList = getNums(numB);
        List<Integer> commonList = new ArrayList<>();
        for (int num : numAList) {
            if (numBList.contains(num)) {
                commonList.add(num);
            }
        }
        commonList.sort(Comparator.reverseOrder());
        System.out.println(commonList.get(numC- 1));
    }

    public static void calculate(int s) {
        LinkedList<Integer> a = new LinkedList<Integer>();
        a.add(s);
        for (int i=0; i<=1000000; i++){
        int a_next;
        if (a.get(i)%2 == 0){
                a_next = a.get(i)/2;
        }else {
                a_next = 3*a.get(i)+1;
        }
        if (a.contains(a_next)){
                System.out.println(i+2);
                return;
        }else {
                a.add(a_next);
        }
}
}

public static void findNotContains(int x, int n, int inputArray[]){
    LinkedList<Integer> l=new LinkedList<>();
    for(int i=0;i<n;i++) {
            l.add(inputArray[i]);
    }
    for(int i=0;true;i++) {
            if(!l.contains(x-i)) {
                    System.out.println(x-i);
                    break;
            }
            else if(!l.contains(x+i)) {
                    System.out.println(x+i);
                    break;
            }
    }
}

public List<Integer> gerPrimes() {
    return Collections.unmodifiableList(primes);
}

public static void queueTime(int n,int q, String[] inputPS, int[] inputPT ){
    int t=0;
    LinkedList<Process> list=new LinkedList<Process>();
    for(int i=0;i<n;i++){
            String ps=inputPS[i];
            int pt=inputPT[i];
            Process pr=new Process(ps,pt);
            list.addLast(pr);
    }
    while(list.size()>0){
            if((list.getFirst()).time>q){
                    Process x=list.poll();
                    t+=q;
                    x.time-=q;
                    list.add(x);
            }else{
                    Process x=list.poll();
                    t+=x.time;
                    System.out.println(x.name+" "+t);
            }
    }
}

public Process dequeue() {
    Process ret = queue.getFirst();
    queue.removeFirst();
    return ret;
}

public static void listRange(int N, int inputArray[]) {
    LinkedList<Integer> A = new LinkedList<>();
    for(int i = 0; i < N; i++) {
            int a = inputArray[i];
            A.add(a);
    }
    Collections.sort(A);
    System.out.println(A.getLast() - A.getFirst());
}

public static void checkAns(String str, String ans){
            int count = 0;
            int max = 0;
            LinkedList<String> word = new LinkedList<String>();
            LinkedList<String> Ans = new LinkedList<String>();
            for (int i = 0; i < str.length(); i++) {
                String str2 = String.valueOf(str.charAt(i));
                String ans2 = String.valueOf(ans.charAt(i));
                word.add(str2);
                Ans.add(ans2);
            }
            for(int i=0; i<str.length(); i++){
                    word.addFirst(word.getLast());
                    word.removeLast();
                    if(word.equals(Ans)){
                            System.out.println("Yes");
                            return;
                    }
            }
            System.out.println("No");
    }

    public int pop() {
        int ret = stack.getLast();
        stack.removeLast();
        return ret;
}

    public static void calWaitingTime(LinkedList<String> qName, LinkedList<Integer> qTime, int quantum)
    {
            int time = 0;
            while(qName.size() != 0)
            {
                    String cName = qName.removeFirst();
                    int cTime = qTime.removeFirst();
                    if(cTime > quantum)
                    {
                            time = time + quantum;
                            cTime = cTime - quantum;
                            qName.addLast(cName);
                            qTime.addLast(cTime);
                    }else
                    {
                            time = time + cTime;
                            System.out.println(cName + " " + time);
                    }
            }
    }

    public static void calWaitingTime(LinkedList<String> names , LinkedList<Integer> amounts ,int clock) {
        int time = 0;
        while(!amounts.isEmpty()){
            String name = names.removeFirst();
            int amount = amounts.removeFirst();
            if(amount <= clock){
                time = time + amount;
                System.out.println(name + " " + time);
            }
            else{
                time = time + clock;
                amount = amount - clock;
                names.add(name);
                amounts.add(amount);
            }
        }
    }

    public static int getMinN(int root, int n, int m, Tree[] edge, int values[]){
        LinkedList<Integer> ll =  new LinkedList<>();
        ll.add(root);
        while(ll.size()>0){
                int val = ll.removeFirst();
                visited.put(val,0);
                ArrayList<Integer> al = edge[val].al;
                int length = al.size();
                for(int i=0;i<length;i++){
                        ll.addLast(al.get(i));
                        int hold = edge[val].weight+values[root];
                        values[al.get(i)] = Math.min(hold,values[al.get(i)]);
                }
        }
        return values[n];
}

public int pop() {
    int ret = stack.getLast();
    stack.removeLast();
    return ret;
}

public int checkLast(String S) {
    int ans = 0;
    LinkedList<Integer> list = new LinkedList();
    for (char c : S.toCharArray()) {
      int i = (int) c - ZERO;
      if (list.size() == 0) {
        list.addLast(i);
      } else {
        if (list.getLast() != i) {
          list.removeLast();
          ans += 2;
        } else {
          list.addLast(i);
        }
      }
    }
    return ans;
  }

  public static void string2List(String s) {
    LinkedList<String> ans = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
        switch (s.charAt(i)) {
            case '0':
                ans.add("0");
                break;
            case '1':
                ans.add("1");
                break;
            case 'B':
                if (!ans.isEmpty()) {
                    ans.removeLast();
                }
                break;
        }
    }
    for (String val: ans) {
        System.out.print(val);
    }
}

public static void string2List( String s) {
    String[] sArray = s.split("");
    LinkedList<String> ansList = new LinkedList<>();
    for(int i = 0; i < s.length(); i++){
            if(sArray[i].equals("1")) {
                    ansList.add("1");
            } else if(sArray[i].equals("0")) {
                    ansList.add("0");
            } else if(sArray[i].equals("B") && ansList.size() != 0){
                    ansList.removeLast();
            }
    }
    for(String ans: ansList){
            System.out.print(ans);
    }
}

public void morePositiveNums(int testNumber, List<Integer> list, PrintWriter out) {
    list.sort(Comparator.reverseOrder());
    int max = list.get(0);
    list.remove(0);
    int sum = 0;
    for (int i : list) {
        sum += i;
    }
    out.println(sum > max ? "Yes" : "No");
}

public static void morePositiveNums(ArrayList<Integer> List){
    int max = Collections.max(List);
    int num = List.indexOf(max);
    List.remove(num);
    int sum=0;
    for(int a=0;a<List.size();a++) sum+=List.get(a);
    if(sum>max) System.out.println("Yes");
    else System.out.println("No");
}

public static void checkSuffix(String s) {
    String[] keywords = {"dream", "dreamer", "erase", "eraser"};
    List<String> queue = new ArrayList<String>();
    queue.add(s);
    while (queue.size() > 0) {
      s = queue.remove(queue.size() - 1);
      if (s.isEmpty()) {
        System.out.println("YES");
        return;
      }
      for (int i = 0; i < 4; i++) {
        String keyword = keywords[i];
        String ts = s.replaceAll(keyword, "");
        if (s.length() > ts.length()) queue.add(ts);
      }
    }
    System.out.println("NO");
  }

  public int calcMin(List<Integer> A, List<Integer> C, int min) {
    if (C.size() == 5) {
        min = Math.min(min, simulate(C));
        return min;
    }

    for (int i = 0; i < A.size(); i++) {
        List<Integer> a = new LinkedList<>(A);
        List<Integer> l = new LinkedList<>(C);
        int v = a.get(i);
        a.remove(i);
        l.add(v);
        min = Math.min(min, calc(a, l, min));
    }
    return min;
}

public void checkLast(int testNumber,String S, OutputWriter out) {
    List<Character> stack = new ArrayList<>();
    int ans = 0;
    for (int i = 0; i < S.length(); i++) {
        if (stack.size() == 0) {
            stack.add(S.charAt(i));
        } else {
            if (stack.get(stack.size() - 1) != S.charAt(i)) {
                stack.remove(stack.size() - 1);
                ans += 2;
            } else {
                stack.add(S.charAt(i));
            }
        }
    }
    out.printLine(ans);
}

static String nextPermutation(String s) {
    ArrayList<Character> list=new ArrayList<>();
    for(int i=0;i<s.length();i++) {
            list.add(s.charAt(i));
    }
    int pivotPos=-1;
    char pivot=0;
    for(int i=list.size()-2;i>=0;i--) {
            if(list.get(i)<list.get(i+1)) {
                    pivotPos=i;
                    pivot=list.get(i);
                    break;
            }
    }
    if(pivotPos==-1&&pivot==0) {
            return "Final";
    }
    int L=pivotPos+1,R=list.size()-1;
    int minPos=-1;
    char min =Character.MAX_VALUE;
    for(int i=R;i>=L;i--) {
            if(pivot<list.get(i)) {
                    if(list.get(i)<min) {
                            min=list.get(i);
                            minPos=i;
                    }
            }
    }
    Collections.swap(list, pivotPos, minPos);
    Collections.sort(list.subList(L, R+1));
    StringBuilder sb=new StringBuilder();
    for(int i=0;i<list.size();i++) {
            sb.append(list.get(i));
    }
    return sb.toString();
}

public static void countSame(ArrayList<Integer> p) {
    ArrayList<Integer> calcList = new ArrayList<>();
    int ans = 0;
    for(int i = 1; i < n - 1; i++){
        calcList.addAll(p.subList(i - 1, i + 2));
        Collections.sort(calcList);
        if(calcList.get(1).equals(p.get(i))){
            ans++;
        }
        calcList.clear();
    }
    System.out.println(ans);
    return;
}

public static void calCost(int n , int x ,nt[] costPlaceList ) {
    List<Integer> placeList = new ArrayList<>();
    for (int i = 0; i < n + 1; i++) {
        placeList.add(0);
    }
    for(int costPlace : costPlaceList){
        placeList.set(costPlace, 1);
    }
    int leftCost = sum(placeList.subList(0, x));
    int rightCost = sum(placeList.subList(x+1, placeList.size()));
    if(leftCost < rightCost) {
        System.out.println(leftCost);
    } else {
        System.out.println(rightCost);
    }
}

public static void calBreaking(List<Integer> li){
    if(!li.contains(1)){
      System.out.println(-1);
      return;
    }
    int breaking = 0;
    int currentNo = 1;
    while(li.contains(currentNo)){
      breaking += li.indexOf(currentNo);
          li = li.subList(li.indexOf(currentNo)+1, li.size());
      currentNo++;
    }
    breaking += li.size();
    System.out.println(breaking);
  }

  public static void calBreaking(List<Integer> list) {
    List<Integer> bloks = new ArrayList<>();
    int target = Collections.min(list);
    for (int idx = list.indexOf(target); idx <= n; idx++) {
      int index = list.subList(idx, n).indexOf(target);
      if (index == -1) break;
      bloks.add(target);
      target += 1;
    }
    if (bloks.size() == 0) {
      System.out.println(0);
    } else if (bloks.get(0) != 1) {
      System.out.println(-1);
    } else {
      System.out.println(n - bloks.size());
    }
  }

  public static void calTotalK(int K , ArrayList<Integer> l){
    l.sort(null);
    long total = 0;
    for(int i = 0; i < l.size()-K; i++){
        total += l.get(i);
    }
    System.out.println(total);
}

public static void calTotalK2N(int n, int k , List<Integer> hps) {
    hps.sort(Comparator.reverseOrder());
    long result = 0;
    for (int i = k; i < n; i++) {
        result += hps.get(i);
    }
    System.out.println(result);
}

public void calTotalK2N(long N, long K, List<Long> H) {
    H.sort(Collections.reverseOrder());
    long ans = 0;
    for (int i = (int) K; i < N; i++) {
        ans += H.get(i);
    }
    System.out.println(ans);
}

public static void getOrdered(ArrayList<String> word) {
    word.sort(Comparator.naturalOrder());
    for(String w: word) {
      System.out.print(w);
    }
  }

  public static void getOrdered(List<String> sList) {
    StringBuilder sb = new StringBuilder();
    sList.sort(Comparator.naturalOrder());
    for (String s : sList){
      sb.append(s);
    }
    System.out.println(sb);
 }

 public static void countOrdered(int n , List<Integer> h) {
    Collections.reverse(h);
    int ans = 0;
    int count = 0;
    for(int i = 1;i < n; i++) {
            if(h.get(i-1)<=h.get(i)) {
                    count++;
            }
            else {
                    count = 0;
            }
            ans = Math.max(ans, count);
    }
    System.out.println(ans);
}

public static void getReverseNum(int length , String[] inputNum) throws IOException{
    List<Integer> numArray = new ArrayList<Integer>();
    for (int i = 0; i < length; i++) {
            numArray.add(Integer.parseInt(inputNum[i]));
    }
    Collections.reverse(numArray);
    for (int i = 0; i < numArray.size(); i++) {
            if (i == numArray.size()-1) {
                    System.out.println(numArray.get(i));
            }else {
                    System.out.print(numArray.get(i) + " ");
            }
    }
}

public static void checkAbove4M(int M, List<Integer> s) {
    int total = 0;
    for(int i =0; i <s.size() ; i++) {
            int a =s.get(i);
            total += a;
    }
    Collections.sort(s);
    Collections.reverse(s);
    for(int m = 0; m < M; m++) {
            int a = s.get(m);
            if(a*4*M < total) {
                    System.out.println("No");
                    return;
            }
    }
    System.out.println("Yes");
}

public void power2(int a, int b, int c, int k){
    ArrayList<Integer> li = new ArrayList<Integer>();
    li.add(a);
    li.add(b);
    li.add(c);
    Collections.sort(li);
    Collections.reverse(li);
    for(int i = 0; i < k; i++){
        li.set(0, li.get(0) * 2);
    }
    ans = li.get(0) + li.get(1) + li.get(2);
    System.out.println(ans);
}

public static void countReverseNumber(int a, int b) {
    int b = sc.nextInt();
    int ans =0;
    for (int i = a; i <= b; i++)
    {
      String as = Integer.toString(i);
      List<String> list=Arrays.asList(Integer.toString(i).split(""));
      Collections.reverse(list);
      String[] bs = (String[]) list.toArray(new String[list.size()]);
      String strb = String.join("", bs);
      if (as.equals(strb))
        ans++;
    }
    System.out.println(ans);
  }

  public static void countVertex(int nV, String[] args) {
    Map<String,Integer> tV = new TreeMap<>();
    int nV = scn.nextInt();
    int[] VList= new int[nV];
    for(int i = 0;i<nV;i++) {
            String v = args[i];
            if(!tV.isEmpty()) {
                    if(tV.containsKey(v)) {
                            tV.put(v,tV.get(v)+1);
                    }else {
                            tV.put(v,1);
                    }
            }else {
                    tV.put(v,1);
            }
            VList[i] = tV.get(v);
    }
    Arrays.sort(VList);
}

public static void countSame(String args[]){
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter w = new PrintWriter(outputStream);
    int t,i,j;
    t=1;
    while(t-->0){
        String s1,s2;
        s1=in.next();
        s2=in.next();
        char ch1[]=s1.toCharArray();
        char ch2[]=s2.toCharArray();
        int n=s1.length(),m=s2.length(); 
        LinkedList<Character> li=new LinkedList<>();
        LinkedList<Character> li1=new LinkedList<>();
        int max=0,c=0,count=0;
        for(i=0;i<n;i++){
            c=0;
            count=0;
            if(li.size()==m-1){
                li.add(ch1[i]);
                count=0;
                c=0;
                while(!li.isEmpty()){
                    char temp=li.removeFirst();
                    if(ch2[c]==temp){
                        count++;
                        if(count>max){
                            max=count;
                        }
                    }
                    c++;
                    li1.add(temp);
                    if(li.isEmpty()){
                        break;
                    }
                }
                li=li1;
                li1=new LinkedList<>();
                li.removeFirst();
            }else{
                li.add(ch1[i]);
            }
        }
        w.println(m-max);
    }
    w.close();
}

public static void findMax(int n, String[] args) {
    Map<String,Integer> s = new LinkedHashMap<String,Integer>();
    for(int i = 0; i < n; i++) {
            String temp = args[i];
            if(s.containsKey(temp)) {
                    int c = s.get(temp)+1;
                    s.put(temp, c);
            }
            else {
                    s.put(temp, 1);
            }
    }
    Map<String,Integer> ans = new TreeMap<String,Integer>();
    int count = 0;
    for(String key:s.keySet()) {
            if(count < s.get(key)) {
                    ans.clear();
                    count = s.get(key);
                    ans.put(key, count);
            }
            else if(count==s.get(key)) {
                    ans.put(key, count);
            }
    }
    for(String key:ans.keySet()) {
            System.out.println(key);
    }
}

public static void countSubstring(int n , String[] args){
    int a;
    String alpha="abcdefghijklmnopqrstuvwxyz";
    Map <String,Integer> mapA = new TreeMap<String,Integer>();
    Map <String,Integer> mapB = new TreeMap<String,Integer>();
    Map <String,Integer> mapC = new HashMap<String,Integer>();
    int index,index2,index3,count;
    long answer,count2;
    String s,s2;
    for(index=0;index<n;index++) {
            s = args[i];
            mapA.clear();
            for(index2=0;index2<10;index2++) {
                    s2=s.substring(index2,index2+1);
                    if(mapA.containsKey(s2)){
                            count=mapA.get(s2);
                            mapA.put(s2,count+1);
                    }
                    else {
                            mapA.put(s2,1);
                    }
            }
            s2="";
            for(String s3:mapA.keySet()) {
                    count=mapA.get(s3);
                    for(index3=0;index3<count;index3++) {
                            s2=s2.concat(s3);
                    }
            }
            if(mapB.containsKey(s2)) {
                    count=mapB.get(s2);
                    mapB.put(s2,count+1);
            }
            else {
                    mapB.put(s2,1);
            }
    }
    sc.close();
}

public static void getMaxValueKey(int N, final String[] args) {
    try (final FastWriter writer = new FastWriter()) {
        TreeMap<String, Long> cnt = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String s = args[i];
            cnt.putIfAbsent(s, 0l);
            cnt.put(s, cnt.get(s) + 1);
        }
        long max = Collections.max(cnt.values());
        for (Map.Entry<String, Long> entry : cnt.entrySet()) {
            if (entry.getValue().equals(max)) {
                writer.println(entry.getKey());
            }
        }
    }
}

public static void inputMap(int N, String[] args){
    Map<String,Integer>map = new TreeMap<String,Integer>();
    for(int i = 0;i < N;i++){
      map.put(args[i],0);
    }
    System.out.println(map.size());
  }

  private void add(TreeMap<Integer, Integer> map, int key){
    map.put(key,map.getOrDefault(key,0)+1);
}

private void remove(TreeMap<Integer,Integer> map,int key){
    if(!map.containsKey(key))
        return;
    map.put(key,map.getOrDefault(key,0)-1);
    if(map.get(key)==0)
        map.remove(key);
}


public static void add(TreeMap<Integer,Integer> hm, int val){
    if(!hm.containsKey(val))
            hm.put(val,1);
    else hm.put(val, hm.get(val)+1);
}

public static void remove(TreeMap<Integer,Integer> hm, int val){
    hm.put(val, hm.get(val)-1);
    if(hm.get(val)==0){
            hm.remove(val);
    }
}

public static void getMaxValueKey(String[] args) throws Exception {
    try {
            int n = Integer.parseInt(sc.nextLine());
            Map<String, Integer> map = new HashMap<>();
            int ma = Integer.MIN_VALUE;
            for(int i=0;i<n;i++)
            {
                    String s = sc.nextLine();
                    map.put(s, map.getOrDefault(s, 0)+1);
                    ma = Math.max(ma,map.get(s));
            }
            TreeMap<String, Integer> sorted = new TreeMap<>(); 
            sorted.putAll(map); 
            for(Map.Entry<String, Integer> m:sorted.entrySet()) {
                    if(ma==m.getValue()) {
                            System.out.println(m.getKey());
                    }
            }
    }catch(Exception i) {}
}

public  static void getFirstKeyOfValue(int n, int t, int[] args){
    int a ;
    int b ;
    TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
    for(int i=0; i<n; i++){
     a = args[2*i];
     b = args[2*i + 1];
     if(b<=t){
       map.put(a,b);
     }
    }
    if(map.size()==0){
      System.out.println("TLE");
    }else{
      System.out.println(map.firstKey());
    }
  }

  public static void inputMap(int N , String[] args){
    Map<String,Integer>map = new TreeMap<String,Integer>();
    for(int i = 0;i < N;i++){
      map.put(args[i],0);
    }
    System.out.println(map.size());
  }

  public static void countNotCovered(int N, int K, int []d) {
            int[][]A = new int[K][N];
            Map<Integer,ArrayList<Integer>>map = new TreeMap<Integer,ArrayList<Integer>>();
            for(int i = 0;i<N;i++) {
                    map.put(i,new ArrayList<Integer>());
            }
            for(int i = 0;i<K;i++) {
                    for(int j = 0;j<d[i];j++) {
                            A[i][j] = scan.nextInt();
                            map.get(A[i][j]-1).add(i+1);
                    }
            }
            int count = 0;
            for(int i = 0;i<map.size();i++) {
                    if(map.get(i).size()==0)count++;
            }
            System.out.println(count);
}

    public static void calRemain(int a[]) throws Exception {
        int r[] = new int[5];
        TreeMap<Integer, Integer> map = new TreeMap();
        for (int i = 0; i < a.length; i++) {
                
                r[i] = a[i]%10;
                int b =10;
                if (r[i] != 0) {
                        b = 10-r[i];
                        map.put(b, a[i]);
                }
        }
        int ans = 0;
        if (map.size() == 0) {
                for (int i = 0; i < a.length; i++) {
                        ans += a[i];
                }
                System.out.println(ans);
                return;
        }
        int last = map.get(map.lastKey());
        int idx = 0;
        for (int i = 0; i < a.length; i++) {
                if(a[i] == last) {
                        idx = i;
                }
        }
}

public void calGeometricSeries(int testNumber) {
    long h = nl();
    TreeMap<Long, Long> tmap = new TreeMap<>();
    tmap.put(h, 1l);
    long ans = 0;
    while (tmap.size() > 0) {
        if (tmap.lastKey() == 1) {
            ans += tmap.get(tmap.lastKey());
            break;
        }
        long x = tmap.get(tmap.lastKey());
        long which = tmap.lastKey();
        tmap.put(which / 2, tmap.getOrDefault(which / 2, 0l) + 2 * x);
        ans += x;
        tmap.remove(which);
    }
    pn(ans);
}

public static void input2Map(int n, int[] args){
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int i;
    for(i = 0; i < n; i++) {
            map.put(args[i], i + 1);
    }
    int cnt = 0;
    int len = map.size();
    for(int ans: map.values()) {
            cnt++;
            if(len > cnt)
                    System.out.print(ans + " ");
            else
                    System.out.println(ans);
    }
}

public static void getMaxCountKey(int N , String[] args){
    Map<String,Integer> map = new TreeMap<>();
    for(int i = 0;i < N;i++){
      String str = args[i];
      if(map.containsKey(str)){
      map.put(str,map.get(str) + 1);
      }else{
        map.put(str,0);
      }
    }
    int maxv = 0;
    for(int v : map.values()){
      if(v > maxv) maxv = v;
    }
    for(String str : map.keySet()){
      if(map.get(str) == maxv){
        System.out.println(str);
      }
    }
  }


  public int subAll(K k){
    if(!this.containsKey(k)) return -1;
    int cnt = this.count(k);
    this.remove(k);
    sum -= cnt;
    return cnt;
}

public static void getMaxCountKey(int n, String[] args) {
    Map<String, Integer> map = new TreeMap<>();
    int max = 0;
    for (int i = 0; i < n; i++) {
            String z = args[i];
            if (map.containsKey(z)) {
                    int v = map.get(z) + 1;
                    max = Math.max(max, v);
                    map.put(z, v);
            }else {
                    map.put(z, 1);
                    max = Math.max(max, 1);
            }
    }
    for(String k : map.keySet()) {
            if (map.get(k) == max) {
                    System.out.println(k);
            }
    }
}

public static void getMaxCountKey(int N , String[] args){
    TreeMap<String, Integer> paper = new TreeMap<>();
    int max = 1;
    for(int i=0; i<N; i++){
      String tmp = args[i];
      if(paper.containsKey(tmp)){
        paper.put(tmp, paper.get(tmp) + 1);
        max = Math.max(max, paper.get(tmp));
      }else{
        paper.put(tmp, 1);
      }
    }
    for(String key: paper.keySet()){
      if(max == paper.get(key)){
        System.out.println(key);
      }
    }
  }
  
  public static TreeMap<Long, Integer> PrimeFactorization(long n){
    TreeMap<Long, Integer> map = new TreeMap<>();
    for (long i = 2; i*i <= n; i++) {
        while(n%i==0){
            map.put(i, map.containsKey(i)?map.get(i)+1:1);
            n /= i;
        }
    }
    if(n!=1) map.put(n, 1);
    return map;
}

public static void checkSame(String[] args) {
    Map<Integer, Boolean> A = new TreeMap<Integer, Boolean>();
    boolean ans = true;
    int N = sc.nextInt();
    for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            if (!A.containsKey(temp)) {
                    A.put(temp, true);
            } else {
                    ans = false;
                    break;
            }
    }
    System.out.println(ans ? "YES" : "NO");
}

static void put(TreeMap<Integer, Integer> map, Integer p){if(map.containsKey(p)) map.replace(p, map.get(p)+1); else map.put(p, 1); }
static void rem(TreeMap<Integer, Integer> map, Integer p){ if(map.get(p)==1) map.remove(p);else map.replace(p, map.get(p)-1); }

public int sub(K k){
    if(!this.containsKey(k)) return -1;
    int res = this.count(k) - 1;
    if(res == 0) this.remove(k);
    else this.put(k, res);
    sum--;
    return res;
}

public void remove(U x) {
    if (t.get(x) == 1) t.remove(x);
    else t.put(x, t.get(x) - 1);
    sz--;
}

public static void remove(TreeMap<Integer,Integer> hm, int val){
    hm.put(val, hm.get(val)-1);
    if(hm.get(val)==0){
            hm.remove(val);
    }
}
private void remove(TreeMap<Integer,Integer> map,int key){
    if(!map.containsKey(key))
        return;
    map.put(key,map.getOrDefault(key,0)-1);
    if(map.get(key)==0)
        map.remove(key);
}

public void add(U x) {
    t.put(x, t.getOrDefault(x, 0) + 1);
    sz++;
}

public static void getMaxCountKey(int n, int[] a) {
    Map<Integer, Integer> count = new TreeMap<>(Comparator.reverseOrder());
    int max = 0;
    for (int i = 0; i < n; i++) {
        count.put(a[i], count.getOrDefault(a[i], 0) + 1);
        max = Math.max(a[i], max);
    } }

    public void getMaxCountKey() {
        int n = in.nextInt();
        TreeMap<String, Integer> map = new TreeMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            String s = in.next();
            map.put(s, map.getOrDefault(s, 0) + 1);
            max = Math.max(max, map.get(s));
        }
        for (String key : map.keySet()) {
            if (map.get(key) != max) {
                continue;
            }
            System.out.println(key);
        }
    }

    public static void getMaxCountKey(int n, String[] args){
        TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
        int max = 0;
        for(int i = 0; i < n; i++){
            String s = args[i];
            int cnt = tm.getOrDefault(s, 0) + 1;
            tm.put(s, cnt);
            max = max(max, cnt);
        }
        for(String key : tm.keySet()){
            if(tm.get(key).equals(max)) System.out.println(key);
        }
}

public static void getExtinct(int N, String[] args) {
    String[] list = new String[N];
    Map<String, Integer> map = new TreeMap<String, Integer>();
    for(int i=0; i<N;i++) {
            String s = args[i];
            if(map.get(s)==null) {
                    map.put(s, 1);
            }
    }
    int ans  = map.values().toArray().length;
}

public static void getRepeatKey(int n, String[] s){
    long ans = 0;
    TreeMap<String,Integer> map = new TreeMap<String,Integer>();
    for(int i = 0; i < n; i++){
            int[] a = new int[10];
            for(int j = 0; j < 10; j++){
                    a[j] = s[i].charAt(j);
            }
            Arrays.sort(a);
            String b = "";
            for(int j = 0; j < 10; j++){
                    b=b + a[j];
            }
            if(map.containsKey(b)){
            map.put(b,map.get(b)+1);
            ans+=map.get(b);
            }else{
                    map.put(b,0);
            }
    }
    System.out.print(ans);
}

public void countUnderLimitedTime(int limitedTime , Map<Integer, Integer> input) {
    int ans = 0;
    for (Map.Entry<Integer, Integer> e : input.entrySet()) {
        if (e.getValue() <= limitedTime) {
            ans = e.getKey();
            break;
        }
    }
    if (ans == 0) {
        out.println("TLE");
        return;
    }
    out.println(ans);
}

public static void getMaxCountKey(int N, String[] input) {
    Map<String, Integer> dic = new TreeMap<>();
    int max = 0;
    for (int i = 0; i < N; i++) {
        String tmp = input[i];
        if (dic.get(tmp) == null){
            dic.put(tmp, 1);
        } else {
            int x = dic.get(tmp)+1;
            dic.put(tmp, x);
        }
    }
    for (int i : dic.values()){
        if (max < i){
            max = i;
        }
    }
    for (String s : dic.keySet()){
        if(dic.get(s) == max) {
            System.out.println(s);
        }
    }
}

public static void getMaxCountKey(int N, String[] args) {
    int N = sc.nextInt();
    Map<String, Integer> m = new TreeMap<>();
    int max = 1;
    for(int i = 0; i < N; i++) {
            String S = args[i];
            if(m.containsKey(S)) {
                    m.put(S, m.get(S)+1);
                    max = Math.max(max, m.get(S));
            }
            else
                    m.put(S, 1);
    }
    List<String> l = new ArrayList<>();
    for(String s : m.keySet()) {
            if(m.get(s) == max)
                    l.add(s);
    }
    Collections.sort(l);
    for(String s : l)
            System.out.println(s);

}

public static void getMaxCountKey(int n, String b,  String[] args) {
    Map<String,Integer> poll = new TreeMap<String,Integer>();
    poll.put(b,1);
    for(int i=1;i<n;i++) {
            String S = args[i];
            if(!poll.containsKey(S)) {
                    poll.put(S, 1);
                    }else {
                            poll.replace(S,poll.get(S)+1);
                    }
    }
    int S = 0;
    for(String k:poll.keySet()) {
            S = Math.max(S, poll.get(k));
    }
    for(String k:poll.keySet()) {
            if(S == poll.get(k)) {
                    System.out.println(k);
            }
    }
    scan.close();
}

public static void countInput(int N, String[] args){
    int N = sc.nextInt();
    Map<String,Integer> map = new TreeMap<String,Integer>();
    for (int i = 0; i < N; i++){
            String str = args[i];
            if (map.containsKey(str)){
                    map.put(str, map.get(str) + 1);
            }else{
                    map.put(str,0);
            }
    }
}

public static void getMaxCountKey(int N, String[] args) {
    int N = sc.nextInt();
    Map<String, Integer> wordmap = new TreeMap<>();
    int max = 0;
    for (int i=0;i<N;i++) {
        String S_n = args[i];
        if (wordmap.containsKey(S_n)) {
            int count = wordmap.get(S_n);
            wordmap.put(S_n, count + 1);
            if (max <= count) max = count + 1;
        } else {
            wordmap.put(S_n, 1);
            if (max == 0) max = 1;
        }
    }
    for (String key : wordmap.keySet()) {
        if (wordmap.get(key) == max) System.out.println(key);
    }
}

public static void calDistance(int n, int q, String s, int[] args) {
    TreeMap<Integer, Integer> ml = new TreeMap<>();
    int idx = 0;
    int d = 0;
    while (true) {
            idx = s.indexOf("AC", idx);
            if (idx == -1) {
                    break;
            }
            ml.put(idx, ++d);
            idx++;
    }
    for (int i = 0; i < q; i++) {
            int l = args[2*i] - 1;
            int r = args[2*i +1] - 1;
            int c = d;
            if (l != 0) {
                    Entry<Integer, Integer> lower = ml.lowerEntry(l);
                    if (lower != null) {
                            c -= lower.getValue();
                    }
            }
            if (r != n) {
                    Entry<Integer, Integer> ceil = ml.ceilingEntry(r);
                    if (ceil != null) {
                            c -= (d - ceil.getValue() + 1);
                    }
            }
    }
}

public static void calAns(int n , PriorityQueue<Integer> pq) {
    Integer first = pq.poll();
    double ans = first;
    while (!pq.isEmpty()) {
        Integer value = pq.poll();
        ans += value;
        ans /= 2.0;
    }
    System.out.println(ans);
}

static void dijkstra(int src) {
    dist = new int[V];
    Arrays.fill(dist, oo);
    parent = new int[V];
    Arrays.fill(parent, -1);
    dist[src] = 0;
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    pq.add(new Edge(src,0));
    while(!pq.isEmpty()) {
            Edge e = pq.poll();
            if(dist[e.x] < e.y)
                    continue;
            for(Edge e2:adj[e.x]) {
                    if(dist[e2.x] > e2.y+e.y) {
                            pq.add(new Edge(e2.x,dist[e2.x] = e2.y+e.y));
                            parent[e2.x] = e.x;
                    }
            }
    }
}

public static void getMaxCountKey(int n, String[] args) throws IOException{
    out = new PrintWriter(System.out);
    HashMap<String, Integer> map = new HashMap<>();
    String vote;
    int max = 0;
    while(n-->0) {
            vote = args[n];
            int v = map.getOrDefault(vote, 0)+1;
            map.put(vote, v);
            max = Math.max(max, v);
    }
    PriorityQueue<String> pq = new PriorityQueue<>();
    for(Entry<String, Integer>e:map.entrySet()) {
            if(e.getValue() == max) pq.add(e.getKey());
    }
    while(!pq.isEmpty())
            out.println(pq.poll());
    out.close();
}

public long calRemainSum(int testNumber, int n, int k,  Queue<Long> heap) throws IOException {
    if (k >= n){
        return 0;
    }
    for (int i = 0; i < k; i++) {
        heap.remove();
    }
    long ans = 0;
    while (!heap.isEmpty()){
        ans += heap.remove();
    }
    return ans;
}

public static void getFisrtBelow(int N , int T, int[] argsC, int[] argsT) throws Exception {
    Queue<Integer> queue = new PriorityQueue<>();
    for(int i = 0; i < N; i++){
        int c = argsC[i];
        int t = argsT[i];
        if( t <= T ) queue.add(c);
    }
    if( queue.isEmpty() ){
        System.out.println("TLE");
    } else {
        System.out.println(queue.poll() );
    }
}
    static void shortestPaths(List<Edge>[] edges, int s, int[] prio, int[] pred) {
        Arrays.fill(pred, -1);
        Arrays.fill(prio, Integer.MAX_VALUE);
        prio[s] = 0;
        PriorityQueue<Long> q = new PriorityQueue<>();
        q.add((long) s);
        while (!q.isEmpty()) {
                long cur = q.remove();
                int curu = (int) cur;
                if (cur >>> 32 != prio[curu])
                        continue;
                for (Edge e : edges[curu]) {
                        int v = e.t;
                        int nprio = prio[curu] + e.cost;
                        if (prio[v] > nprio) {
                                prio[v] = nprio;
                                pred[v] = curu;
                                q.add(((long) nprio << 32) + v);
                        }
                }
        }
}

int dijkstra(int src){
    for(int i=0; i<V; i++){
        dist[i] = Integer.MAX_VALUE;
    }
    dist[src] = 0;
    pq.add(new edge(src,0));
    while (!pq.isEmpty()){
        int u = pq.poll().dest;
        for(int i=0; i<adj.get(u).size(); i++){
            int v = adj.get(u).get(i).dest;
            int w = adj.get(u).get(i).cost;
            if(dist[u]+w<=dist[v]){
                dist[v] = dist[u] + w;
                pq.add(new edge(v,dist[v]));
            }
        }
    }
    int dis = dist[2];

    return dis;
}

public static void sortInput(int n, int l,String[] args) {
            PriorityQueue<String> t=new PriorityQueue<>();
            for(int i=0;i<n;i++) {
                    t.add(args[i]);
            }
    while(!t.isEmpty()) {
            System.out.print(t.poll());
    }
    System.out.println();
}

public static void count2Times(int n, ArrayDeque<Integer> args) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(n, Collections.reverseOrder());
    for (int i = 0; i < n; i++) {
        int val = args.peek();
        args.pop();
        queue.add(val);
    }
    int count = 0;
    while (!queue.isEmpty()) {
        int v = queue.poll();
        if (v % 2 == 0) {
            int nv = v / 2;
            queue.add(nv);
            count++;
        }
    }
    System.out.println(count);
}

public static void getsinputMax(int n, String[] args) throws IOException, InterruptedException {
    PrintWriter pw = new PrintWriter(System.out);
    boolean is = true;
    HashMap<String,Integer>hm = new HashMap<>();
    PriorityQueue<String>pq= new PriorityQueue<>();
    int mx=0;
    while (n-->0){
        String z = args[i];
        hm.put(z,hm.getOrDefault(z,0)+1);
        if (hm.get(z)>mx) {
            mx = hm.get(z);
            pq.clear();
        }
        if (hm.get(z)==mx){
            pq.add(z);
        }
    }
    while (!pq.isEmpty())
        pw.println(pq.poll());
    pw.flush();
}

public void calWaitingTime(PrintWriter out, int N, int[] inputQueue) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
    for (int i=0; i<N; i++) {
        queue.add(inputQueue[i]);
    }
    for (int i=0; i<N/2-1; i++) {
        queue.poll();
    }
    int before = queue.poll();
    int after = queue.poll();
    out.println(after - before);
}

public void getMean(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    PriorityQueue<Double> pq = new PriorityQueue<>();
    for (int i = 0; i < n; i++) pq.add((double) in.nextInt());
    while (pq.size() != 1) pq.add((pq.poll() + pq.poll()) / 2);
    out.println(pq.peek());
}

public static void getMean(int countMaterial, String[] inputValue) {
    PriorityQueue<Double> Que = new PriorityQueue();
    for(int i = 0;i<countMaterial;i++) {
            double eachValue = Double.parseDouble(inputValue[i]);
            Que.add(eachValue);
    }
    for(int i = 1;i<=countMaterial-1;i++) {
            double tmp1 = Que.poll();
            double tmp2 = Que.poll();
            double tmp = (tmp1+tmp2)/2;
            Que.add(tmp);
    }
    System.out.println(Que.peek());
}


public static void getMean(int N, int[] v) {
        PriorityQueue<Double> pq = new PriorityQueue<Double>();
        for (int i = 0; i < N; i++) {
            pq.add((double) v[i]);
        }
        for (; pq.size() > 1;) {
            double d = pq.poll();
            double d2 = pq.poll();
            pq.add((d + d2) / 2);
        }
        System.out.println(pq.poll());
}


public static void getMean(int n, Double[] args) {
    PriorityQueue<Double> pq = new PriorityQueue<Double>();
    for (int i = 0; i < n; i++) {
            pq.add(args[i]);
    }
    while (pq.size() > 1) {
            pq.add((pq.poll() + pq.poll()) / 2);
    }
    System.out.println(pq.peek());
    sc.close();
}

public static int sumHeap(int[] arr, int k) {
    int n = arr.length;
    if(n==0) {
        return 0;
    }
    int sum = 0;
    PriorityQueue<Integer> heap = new PriorityQueue(Collections.reverseOrder());
    for(int i: arr) {
        heap.add(i);
        
        if(heap.size() > k) {
            heap.remove();
        }
    }
    while(heap.size() > 0) {
        sum += heap.peek();
        heap.remove();
    }
    return sum;
}

public static void sumInput(String[] args){
            int n = sc.nextInt();
            int k = sc.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i = 0 ; i < n ; i++ ) {
                    int p = sc.nextInt();
                    pq.add(p);
            }
            int sum = 0;
            for(int i = 0 ; i < k ; i++ ) {
                    sum += pq.remove();
        
    }
}

public void getMean() throws IOException
    {
        StringTokenizer tok = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(tok.nextToken());
        tok = new StringTokenizer(in.readLine());
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
        {
            pq.add((double)Integer.parseInt(tok.nextToken()));
        }
        while (pq.size() > 1)
        {
            double a = pq.remove();
            double b = pq.remove();
            pq.add((a+b) / 2);
        }
        out.println(pq.remove());
        out.flush();
        in.close();
    }

    public void sumInput(int testNumber, InputReader in, PrintWriter out) throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();
        Queue<Long> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            heap.add(in.nextLong());
        }
        if (k >= n){
            out.println(0);
            return;
        }
        for (int i = 0; i < k; i++) {
            heap.remove();
        }
        long ans = 0;
        while (!heap.isEmpty()){
            ans += heap.remove();
        }
        out.println(ans);
    }

    public static void getMean(PriorityQueue<Double> q) {
        while (q.size() > 1) {
                double x = q.poll();
                double y = q.poll();
                q.add((x + y) / 2);
        }
        System.out.println(q.poll());
}

public static void sumInpt(long[] arr){
    PriorityQueue<Long> p = new PriorityQueue<>();
    for(long i : arr){
        p.add(i);
    }
    int mod = 1000000009;
    long sum= 0;
    while(p.size() > 1){
       long first = p.poll();
       long second = p.poll();

        sum += first+second;
        
        p.add(first+second);
    }
    System.out.println(sum);
}
    
public static void getSquares(int X) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.add(1);
    int base = 2;
    while(base<=upper){
        int cur = base*base;
        while(cur<=X){
            pq.add(cur);
            cur = cur*base;
        }
        base++;
    }
    int ans = 0;
    while(pq.size()>1) ans = pq.poll();
    ans = pq.poll();
    System.out.println(ans);
}

public static long getsinputSum(Queue<Integer> q , int K) {
 int[] t = new int[N];
    for (int j = q.size() - 1; j >= 0; --j) {
            t[j] = q.poll();
    }

    long sum = 0;
    if (K <= N)
            for (int l = K; l < t.length; l++) {
                    sum += t[l];
            }
    return sum;
}

public static void sumPower2 (int x1, int x2, int x3, int q) throws java.lang.Exception
        {
                Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                pq.add(x1);
                pq.add(x2);
                pq.add(x3);
                while(q-->0){
                        pq.add(2*pq.poll());
                }
                int ans = 0;
                while(pq.size()>0){
                        ans+=pq.poll();
                }
                System.out.println(ans);
        }

        public static void getRetain(int n, int args[]) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int i=0;i<n;i++){
                int t = args[i];
                if(t%2==0) pq.add(t);
            }
            int c= 0;
            while(pq.size()>0){
                int r = pq.poll();
                c++;
                r/=2;
                if(r%2==0) pq.add(r);
            }
            System.out.println(c);
        }

        public static void getMean(int n, Double[] args) {
            PriorityQueue<Double> queue = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
              queue.add(args[i]);
            }
            while (queue.size() > 1) {
              double item1 = queue.poll();
              double item2 = queue.poll();
              queue.add((item1 + item2) / 2);
            }
            System.out.println(queue.peek());
          }

          public void getMean(int N, double[] ints) throws Exception
        {
                PriorityQueue<Double> que = new PriorityQueue<Double>();
                for(double x:ints)
                        que.add(x);
                while(que.size() != 1)
                {
                        double x= que.poll();
                        double y = que.poll();
                        que.offer((x+y)/2);
                }
                System.out.println(que.peek());
        }

        public static void getHalf(PriorityQueue<Integer> list) {
            int size = list.size();
            int prev = 0;
            for (int i = 0; i < size / 2; i++) {
                    prev = list.poll();
            }
            System.out.println(list.peek()-prev);
    }

    public static int getHeapSum(int[] arr, int k) {
        int n = arr.length;
        if(n==0) {
            return 0;
        }
        int sum = 0;
        PriorityQueue<Integer> heap = new PriorityQueue(Collections.reverseOrder());
        for(int i: arr) {
            heap.add(i);
            
            if(heap.size() > k) {
                heap.remove();
            }
        }
        while(heap.size() > 0) {
            sum += heap.peek();
            heap.remove();
        }
        return sum;
    }

    public static void countTop(int n, int[] args) {
                PriorityQueue<Integer> q = new PriorityQueue<>();
                int ans = 0;
                for(int i = 0 ; i < n ; i++) {
                        int now =args[i];
                        q.add(now);
                        if(now == q.peek()) {
                                ans++;
                        }
                }
                System.out.println(ans);
}

public static void calFirstDiff(int n,int m,  String args[]) {
    PriorityQueue<Integer> l = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> r = new PriorityQueue<>();
    for (int i = 0; i < m; i++) {
        l.add(Integer.parseInt(args[2 * i]));
        r.add(Integer.parseInt(args[2*i +1]));
    }
    int result = r.peek() - l.peek() + 1;
    System.out.println(result < 0 ? 0 : result);
}

public static void calMean(int n, Double[] data) {
    PriorityQueue<Double> queue = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      queue.add(data[n]);
    }
    while (queue.size() > 1) {
      double item1 = queue.poll();
      double item2 = queue.poll();
      queue.add((item1 + item2) / 2);
    }
    System.out.println(queue.peek());
  }

  public static void take3Turn(String[] a_list , String[] b_list , String[] c_list ) throws IOException {
    Deque<String> a, b, c;
    a = new ArrayDeque<String>(Arrays.asList(a_list));
    b = new ArrayDeque<String>(Arrays.asList(b_list));
    c = new ArrayDeque<String>(Arrays.asList(c_list));
    String turn = "a";
    while (turn != null) {
        switch (turn) {
            case "a":
                turn = a.poll();
                if (turn == null) System.out.println("A");
                break;
            case "b":
                turn = b.poll();
                if (turn == null) System.out.println("B");
                break;
            case "c":
                turn = c.poll();
                if (turn == null) System.out.println("C");
                break;
        }
    }
}

public static void take3Turn(String word1, String word2, String word3) throws IOException {
    Queue<Character>q1 = new ArrayDeque<>();
    Queue<Character>q2 = new ArrayDeque<>();
    Queue<Character>q3 = new ArrayDeque<>();
    for(int i=0;i<word1.length();i++)q1.add(word1.charAt(i));
    for(int i=0;i<word2.length();i++)q2.add(word2.charAt(i));
    for(int i=0;i<word3.length();i++)q3.add(word3.charAt(i));
    char  g = 'a';
    while(true){
        if(g=='a'){
            if(q1.isEmpty()){
                System.out.println('A');
                break;
            }
            else{
                g = q1.poll();
            }
        }
        else if(g=='b'){
            if(q2.isEmpty()){
                System.out.println('B');
                break;
            }
            else{
                g = q2.poll();
            }
        }
        else{
            if(q3.isEmpty()){
                System.out.println('C');
                break;
            }
            else{
                g = q3.poll();
            }
        }
    }
}

        private static void findNewPlayer(char[][] sm) {
            List<Deque<Character>> listDeque = new ArrayList<>();
            for (char[] ss : sm) {
              Deque<Character> deque = new ArrayDeque<>();
              for (char c : ss) {
                deque.addLast(c);
              }
              listDeque.add(deque);
            }
            int player = 0;
            while (true) {
              if (listDeque.get(player).isEmpty()) {
                return "" + (char)('A' + player);
              }
              player = listDeque.get(player).pollFirst() - 'a';
            }
          }

          public void doBackspace(String nextLine) {
            char[] line = nextLine.toCharArray();
            ArrayDeque<Character> deque = new ArrayDeque<>();
            for (char c : line) {
                    if (c == 'B') {
                            if (!deque.isEmpty()) deque.pollLast();
                    } else {
                            deque.addLast(c);
                    }
            }
            while (!deque.isEmpty()) out.print(deque.pollFirst());
    }

    public static Long getBaseSum(long h){
        Queue<Long> queue = new ArrayDeque<>();
        queue.add(h);
        Long vital;
        Long sum = 0L;
        Long base = 1L;
        while(!queue.isEmpty()){
          vital = queue.poll();
          sum+=base;
          base*=2;
          if(vital>1){
            queue.add(vital/2);
          }
        }
        return sum;
      }

      public static void countSame( String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
          if (!stack.isEmpty() && stack.peek() != c) {
            stack.pop();
          } else {
            stack.push(c);
          }
        }
        System.out.println(s.length() - stack.size());
      }

      public static void countSame (List<String> args) {
        while (args.size() > 0) {
          String S = args.getFirst();
          args.removeFirst();
          ArrayDeque<Character> stack = new ArrayDeque<Character>();
          for (int i = 0; i < S.length(); ++i) {
            char cube = S.charAt(i);
            if (stack.isEmpty()) {
              stack.push(cube);
            } else if (cube == '1' && stack.peek() == '0') {
              stack.pop();
            } else if (cube == '0' && stack.peek() == '1') {
              stack.pop();
            } else {
              stack.push(cube);
            }
          }
          System.out.println(S.length() - stack.size());
        }
      }

      public static void reEnqueue(List<String> args)
      {
          Queue<String> queue = new ArrayDeque<>();
          int i,k;
          while(true)
          {
              String input = args.getFirst();
              args.removeFirst();
              if(input.equals("-")) break;
              String[] binput = input.split("");
              for(i=0; i<binput.length; i++) queue.add(binput[i]);
              int m = sc.nextInt();
              int h;
              for(i=0; i<m; i++)
              {
                  h = sc.nextInt();
                  for(k=0; k<h; k++) queue.add(queue.poll());
              }
              for(String a : queue) System.out.printf("%s",a);
              System.out.printf("\n");
              queue.clear();
          }
          sc.close();
      }

      public static void checkSameStr(int n,String[] args)throws Exception{
        PriorityQueue<String> s=new PriorityQueue<String>();
        Queue<String> t=new ArrayDeque<String>();
        for(int i=0;i<n;i++){
            s.add(args[i]);
        }
        int max=0;
        while(s.peek()!=null){
            String str=s.peek();
            int i=0;
            for(;s.peek()!=null&&s.peek().equals(str);i++){
                s.remove();
            }
            if(max==i){
                t.add(str);
            }else if(max<i){
                max=i;
                t.clear();
                t.add(str);
            }
        }
        while(t.peek()!=null){
            System.out.println(t.remove());
        }
    }

    public static void countSameSeries(int N, String[] args) {
        Deque<List<Integer>> D = new ArrayDeque<>();
        List<Integer> tmp = new ArrayList<Integer>();
        for(int i=0;i<2*N;i+=2) {
                int a = args[i];
                int b = args[i+1];
                tmp.add(a);
                tmp.add(b);
                D.add(tmp.stream().collect(Collectors.toList()));
                tmp.clear();
        }
        tmp=null;
        int cnt=0;
        while(D.size()!=0 && cnt<3){
                List<Integer> d =D.poll();
                if(d.get(0)==d.get(1)) {
                        cnt+=1;
                }
                else {
                        cnt=0;
                }
        }
        if(cnt>=3) {
                System.out.println("Yes");
        }
        else {
                System.out.println("No");
        }
        sc.close();
}

public static void countMergeTimes(int n, int q, String[] argsP, Integer[] argsT){
    Deque<String> P = new ArrayDeque<String>();
    Deque<Integer> T = new ArrayDeque<Integer>();
    for(int i=0; i<n; i++){
            P.add(argsP[i]);  
            T.add(argsT[i]);
    }
    int total=0;
    while ( !P.isEmpty() ) {
            String p= P.pop();
            int t= T.pop();
            if(q<t) { T.add(t-q); P.add(p); total+= q; }
            else { total+= t;  System.out.println(p +" "+ total); } 
    }
}

public static void countMergeTimes(int n, int q, String[] argsP, Integer[] argsT) {
    int time = 0;
    int [] T = new int[n];
    String [] Name = new String[n];
    Queue<Integer> L = new ArrayDeque<>();
    ArrayList<Integer> opt = new ArrayList<>();
    for(int i=0;i<n;i++){
        Name[i] = argsP[i];
        T[i] = argsT[i];
        L.add(i);
    }
    while(L.size()!=0){
        int p_num = L.poll();
        if(T[p_num]-q>0){
            time+=q;
            T[p_num]-=q;
            L.add(p_num);
        }
        else{
            time+=T[p_num];
            T[p_num]=time;
            opt.add(p_num);
        }
    }
    for(int i:opt) System.out.println(Name[i]+" "+T[i]);
}

public static int doBFS(int N, int[] args) {
    int[] next = new int[N];
    for (int i = 0; i < N; i++)
            next[i] = args[i]-1;
    int[] dist = new int[N];
    Arrays.fill(dist,-1);
    dist[0] = 0;
    ArrayDeque<Integer> bfs = new ArrayDeque<Integer>();
    bfs.add(0);
    while (!bfs.isEmpty()) {
            int node = bfs.poll();
            if (dist[next[node]] == -1) {
                    bfs.add(next[node]);
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
    boolean[] memo = new boolean[n];
    memo[0] = true;
    ArrayDeque<Integer> deque = new ArrayDeque<>();
    deque.add(a[0]);
    int t, cnt = 1;
    boolean b = false;
    while (!deque.isEmpty()) {
            t = deque.poll();
            if (t == 1) {
                    b = true;
                    break;
            } else if (!memo[t]) {
                    deque.add(a[t]);
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

public int doBFS(InputReader in, PrintWriter out) {
    int n = in.nextInt(), x;
    int[] a = new int[n+1];
    int[] visit = new int[n+1];
    Queue<Integer> Q = new ArrayDeque<Integer>();
    int ans = 0;
    for (int i=1; i<=n; ++i) {
            a[i] = in.nextInt();
    }
    Arrays.fill(visit, -1);
    visit[1] = 0;
    Q.add(1);
    while (!Q.isEmpty()) {
            x = Q.poll();
            if (visit[a[x]] == -1) {
                    if (a[x] == 2) {
                            ans = visit[x] + 1;
                            return ans;
                    }
                    visit[a[x]] = visit[x] + 1;
                    Q.add(a[x]);
            }
    }
    return -1;
}

public static void removeSame(int n, String[] args)throws Exception{
    PriorityQueue<String> s=new PriorityQueue<String>();
    Queue<String> t=new ArrayDeque<String>();
    for(int i=0;i<n;i++){
        s.add(args[i]);
    }
    int max=0;
    while(s.peek()!=null){
        String str=s.peek();
        int i=0;
        for(;s.peek()!=null&&s.peek().equals(str);i++){
            s.remove();
        }
        if(max==i){
            t.add(str);
        }else if(max<i){
            max=i;
            t.clear();
            t.add(str);
        }
    }
    while(t.peek()!=null){
        System.out.println(t.remove());
    }
}

public String getMostABC(int testNumber, String inputA, String inputB, String inputC) {
    char[] a = inputA.toCharArray();
    char[] b = inputB.toCharArray();
    char[] c = inputC.toCharArray();
    Queue<Character> aq = new ArrayDeque<Character>();
    Queue<Character> bq = new ArrayDeque<Character>();
    Queue<Character> cq = new ArrayDeque<Character>();
    for (int i = 0; i < a.length; i++) {
            aq.add(a[i]);
    }
    for (int i = 0; i < b.length; i++) {
            bq.add(b[i]);
    }
    for (int i = 0; i < c.length; i++) {
            cq.add(c[i]);
    }
    char cur = aq.remove();
    while (true) {
            if (cur == 'a') {
                    if (aq.isEmpty()) {
                        return "A";
                    }
                    cur = aq.remove();
            } else if (cur == 'b') {
                    if (bq.isEmpty()) {
                        return "B";
                    }
                    cur = bq.remove();
            } else if (cur == 'c') {
                    if (cq.isEmpty()) {
                        return "C";
                    }
                    cur = cq.remove();
            }
    }
}

public static void countMergeTimes(int n, int q, String[] argsS, String[] argsT) {
    Queue<String> name_array = new ArrayDeque<String>();
    Queue<Integer> time_array = new ArrayDeque<Integer>();
    int sum_time = 0;
    for (int i = 0; i < n; i++) {
        name_array.add(argsS[i]);
        time_array.add(argsT[i]);
    }
    while (name_array.peek() != null) {
        String str = name_array.remove();
        int tmp = time_array.remove();
        if(tmp > q) {
            name_array.add(str);
            time_array.add(tmp - q);
            sum_time += q;
        } else {
            System.out.println(str + " " + (sum_time + tmp));
            sum_time += tmp;
        }
    }
}

public static void countMergeTimes(int N, int q, String[] argsS, String[] argsT){
    Queue<Integer> queue = new ArrayDeque<Integer>();
    Queue<String> name = new ArrayDeque<String>();
    int tlen = 0;
    for (int i=0; i<N; i++) {
            name.add(argsS[i]);
            queue.add(argsT[i]);
    }
    while (queue.size()!=0) {
            if (queue.element() > q){
                    tlen += q;
                    queue.add(queue.element() - q);
                    queue.remove();
                    name.add(name.element());
                    name.remove();
            } else {
                    tlen += queue.element();
                    System.out.println(name.element()+" "+tlen);
                    queue.remove();
                    name.remove();
            }
    }
}

public static void countMergeTimes(int num, int quan, String[] args){
    Queue<String[]> input = new ArrayDeque<String[]>();
    int num = Integer.parseInt(in.next()) ;
    int quan = Integer.parseInt(in.next());
    for (int i=0;i<2*num;i+=2) {
        String[] a = new String[2];
        a[0] = args[i];
        a[1] = args[i+1];
        input.add(a);
    }
    in.close();
    int calculate = 0;
    while (!input.isEmpty()){
         String[] k = input.remove();
         String name =(String) k[0];
         int time =Integer.parseInt(k[1]);
         if (time<=quan){
            calculate=calculate+time;
            System.out.println(name +" "+calculate);
         }
         else{
            k[1]=Integer.toString((time-quan));
            input.offer(k);
            calculate=calculate+quan;
         }
    }
}

public static void checkLastSame(int N, char[] S) throws IOException {
    Deque<Character> deque = new ArrayDeque<>();
    deque.addLast(S[0]);
    for (int i = 1; i < N; ++i) {
            if (S[i] != deque.getLast()) {
                    deque.addLast(S[i]);
            }
    }
    System.out.println(deque.size());
}

public static void checkLastSame(int N, String slims) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char c: slims.toCharArray()) {
        if (stack.isEmpty() || stack.peek() != c) {
            stack.push(c);
        }
    }
    System.out.println(stack.size());
}

public static void countSameSeries(int N, int[] args) {
    Deque<List<Integer>> D = new ArrayDeque<>();
    List<Integer> tmp = new ArrayList<Integer>();
    for(int i=0;i<2*N;i+=2) {
            int a = args[i];
            int b = args[i+1];
            tmp.add(a);
            tmp.add(b);
            D.add(tmp.stream().collect(Collectors.toList()));
            tmp.clear();
    }
    tmp=null;
    int cnt=0;
    while(D.size()!=0 && cnt<3){
            List<Integer> d =D.poll();
            if(d.get(0)==d.get(1)) {
                    cnt+=1;
            }
            else {
                    cnt=0;
            }
    }
    if(cnt>=3) {
            System.out.println("Yes");
    }
    else {
            System.out.println("No");
    }
    sc.close();
}

public static void repeatH(int n, int[] args, List<String> inputLines) {
    while (true) {
        String originalSequence = "";
        while (originalSequence.length() == 0) {
            originalSequence = inputLines.getFirst();
            inputLines.removeFirst();
        }
        if (originalSequence.equals("-")) {
            break;
        }
        ArrayDeque<Character> chars = new ArrayDeque<Character>();
        for (int i = 0; i < originalSequence.length(); i++) {
            chars.add(originalSequence.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            int h = args[i];
            for (int j = 0; j < h; j++) {
                chars.add(chars.removeFirst());
            }
        }
        while (chars.size() > 0) {
            System.out.print(chars.removeFirst());
        }
        System.out.println("");
    }
}

public static void doBackspace(char[] line) {
    Deque<Character> q = new ArrayDeque<Character>();
    for (int i = 0; i < line.length; i++) {
            if (line[i] == '0') {
                    q.addLast('0');
            } else if(line[i] == '1'){
                    q.addLast('1');
            } else if(line[i] == 'B'){
                    if (q.size() != 0) {
                            q.removeLast();
                    } 
            }
    }
    for (Character character : q) {
            System.out.print(character);
    }
    System.out.println();
}

public static void countNotEqual(String s, int n){
    char[] c = s.toCharArray();
    int count = 0;
    Deque<Character> deque = new ArrayDeque<>();
    for(int i = 0;i<n;i++){
        if(deque.peekFirst() == null){
            deque.addFirst(s.charAt(i));
        }else{
            if(deque.peekFirst() == s.charAt(i)){
                deque.addFirst(s.charAt(i));
            }
            else{
                deque.removeFirst();
                count++;
            }
        }
    }
    System.out.println(count * 2);
}

public static void calDpMod(int n, int m, String args[]){
    final int modder=1000000007;
    Deque<Integer> h=new ArrayDeque<>(m);
    for(int i=0;i<m;i++){
      h.addLast(args[i]);
    }
    int dp[]=new int[n+1+2];
    Arrays.fill(dp,0);
    dp[0]=1;
    for(int i=0;i<=n;i++){
      if(h.peekFirst()!=null&&h.peekFirst()==i){
        h.pollFirst();
        dp[i]=0;
      }else{
        dp[i+1]=(dp[i+1]+dp[i])%modder;
        dp[i+2]=(dp[i+2]+dp[i])%modder;
      }
    }
    System.out.println(dp[n]);
  }

  public static void calDpMod(int n, int m, String[] args){
    int mod=1000_000_007;
    int[] a=new int[n+1];
    Deque<Integer> dq=new ArrayDeque<>();
    for(int i=0;i<m;i++){
      dq.addLast(args[i]);
    }
    dq.addLast(n*2);
    a[0]=1;
    if(dq.peekFirst()==1){
      a[1]=0;
      dq.pollFirst();
    }else{
      a[1]=1;
    }
    for(int i=2;i<=n;i++){
      if(i==dq.peekFirst()){
        a[i]=0;
        dq.pollFirst();
      }else{
        a[i]=(a[i-1]+a[i-2])%mod;
      }
    }
    System.out.println(a[n]);
  }

  public int checkLast(int testNumber, String nextLine) {
    char[] s = nextLine.toCharArray();
    int n = s.length;
    Deque<Boolean> stack = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
        boolean cur = s[i] == '1';
        if (stack.isEmpty() || stack.peekLast() == cur) {
            stack.addLast(cur);
        } else {
            stack.pollLast();
        }
    }
    int answer = n - stack.size();
    return answer;
}

public static void calculator(List<String> args){
    Deque<Integer> deq = new ArrayDeque<Integer>();
    String str = "";
    int a = 0, b = 0;
    while(args.size() > 0){
            str = args.getFirst();
            args.removeFirst();
            if(str.equals("+")){
                    a = deq.pollLast();
                    b = deq.pollLast();
                    deq.addLast(a + b);
            }else if(str.equals("-")){
                    a = deq.pollLast();
                    b = deq.pollLast();
                    deq.addLast(b - a);
            }else if(str.equals("*")){
                    a = deq.pollLast();
                    b = deq.pollLast();
                    deq.addLast(a * b);
            }else if(str.equals("/")){
                    a = deq.pollLast();
                    b = deq.pollLast();
                    deq.addLast(b / a);
            }else{
                    deq.addLast(Integer.parseInt(str));
            }
    }
    System.out.println(deq.peekLast());
}

public static void getExtinctSize(Integer[] d) {
    Set<Integer> setD = new TreeSet<>(Arrays.asList(d));
    System.out.println(setD.size());
}

public void getMaxValueKey(int testNumber, int n, String[] input, PrintWriter out) {
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    int max = 0;
    for (int i = 0; i < n; i++) {
        String s = input[i];
        map.put(s, map.getOrDefault(s, 0) + 1);
        max = Math.max(max, map.get(s));
    }
    TreeSet<String> h = new TreeSet<String>();
    for (Map.Entry<String, Integer> e : map.entrySet()) {
        if (e.getValue() == max) {
            h.add(e.getKey());
        }
    }
    while (!h.isEmpty()) {
        out.println(h.pollFirst());
    }
}

public void calDifference(int testNumber, int n, int l, PrintWriter out) {
    int sum = 0;
    TreeSet<Integer> negatives = new TreeSet<>();
    TreeSet<Integer> positives = new TreeSet<>();
    for (int i = 0; i < n; i++) {
        sum += (l + i);
        if (l + i < 0) {
            negatives.add(l + i);
        } else {
            positives.add(l + i);
        }
    }
    if (positives.contains(0)) {
        out.println(sum);
    } else {
        if (negatives.isEmpty()) {
            out.println(sum - positives.first());
        } else if (positives.isEmpty()) {
            out.println(sum - negatives.last());
        } else {
            if (Math.abs(negatives.last()) < positives.first()) {
                out.println(sum - negatives.last());
            } else {
                out.println(sum + positives.first());
            }
        }
    }
}

public static void getFirstBelow(int N, int T, String[] args) throws IOException {
    StringTokenizer st;
    TreeSet<Integer> set = new TreeSet<Integer>();
    for(int i=0;i<N;i++) {
            st = new StringTokenizer(args[i]);
            int c = parseInt(st.nextToken());
            int t = parseInt(st.nextToken());
            if(t <= T) {
                    set.add(c);
            }
    }
    if(set.isEmpty()) {
            System.out.println("TLE");
    }else {
            System.out.println(set.first());
    }
}

public void getMaxValueKey(int n, int testNumber, String[] input, PrintWriter out) {
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    int max = 0;
    for (int i = 0; i < n; i++) {
        String s = input[i];
        map.put(s, map.getOrDefault(s, 0) + 1);
        max = Math.max(max, map.get(s));
    }
    TreeSet<String> h = new TreeSet<String>();
    for (Map.Entry<String, Integer> e : map.entrySet()) {
        if (e.getValue() == max) {
            h.add(e.getKey());
        }
    }
    while (!h.isEmpty()) {
        out.println(h.pollFirst());
    }
}

public static void getMax(String[] args) throws IOException 
{
        Reader sc=new Reader();
        PrintWriter o = new PrintWriter(System.out);
        int t=1;
        long x,x0,x1,x2;long y,y0,y1,y2;int s,s0,s1,s2;
        int n,m;int a[],b[],in[],in1[];
        long k,l;boolean b1,b2;String ss1[],ss;
        ArrayList<ArrayList<Integer>> ll=new ArrayList<>();
        ArrayList<Integer> a1=new ArrayList<>();
        ArrayList<Integer> a2=new ArrayList<>();
        ArrayList<Integer> a3=new ArrayList<>();
        ArrayDeque<Integer> deq=new ArrayDeque<>();
        TreeSet<Integer> h0=new TreeSet<>();
        TreeSet<Integer> h1=new TreeSet<>();
        HashMap<Integer,Integer> h=new HashMap<>();
        try{
        while (t-->0)
        {
            x=sc.nextLong();x0=sc.nextLong();
            x1=sc.nextLong();x2=sc.nextLong();
            y=x*x1;y0=x*x2;y1=x0*x1;y2=x0*x2;
            k=Math.max(y,y0);l=Math.max(y1,y2);
            o.println(Math.max(k,l));
            h0.clear();ll.clear();a1.clear();a2.clear();h1.clear();
        }
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
o.flush();
o.close();
}

public static void countMaxVote(String[] S) {
    PrintWriter out = new PrintWriter(System.out);
Arrays.sort(S);
TreeSet<String> s = new TreeSet<>();
int c = 1;
int M = 1;
for(int i=0;i<N-1;i++){
    if(S[i].equals(S[i+1])){
        c++;
    }
    else{
        if(c>M){
            s.clear();
            s.add(S[i]);
            M = c;
        }
        else if(c==M){
            s.add(S[i]);
            M = c;
        }
        c = 1;
    }
}
if(c>M){
    s.clear();
    s.add(S[N-1]);
}
else if(c==M){
    s.add(S[N-1]);
}
for(String a :s){
    out.println(a);
}
    out.flush();
}

public static void countMaxVote(int N, String[] args) throws IOException {
    HashMap<String, Integer> map = new HashMap<>();
    for(int i = 0; i < N; i++){
        String s = args[i];
        map.put(s, map.getOrDefault(s, 0) + 1);
    }
    TreeSet<String> set = new TreeSet<>();
    int maxVote = 0;
    for(String s: map.keySet()){
        int vote = map.get(s);
        if(vote > maxVote){
            set.clear();
            maxVote = vote;
            set.add(s);
        }
        else if(vote == maxVote){
            set.add(s);
        }
    }
    for(String s: set){
        println(s);
    }
}

public static void countDivide(int n){
    int cnt = 0;
    Set<Integer> set = new TreeSet<>();
    for(int i = 1; i <= n; i+=2){
      int tmp = i;
      for(int j = 1; j <= Math.sqrt(tmp); j++){
        if(tmp % j == 0){
          set.add(tmp);
          set.add(j);
          set.add(tmp / j);
        }
      }
      if(set.size() == 8){
        cnt++;
      }
      set.clear();
    }
    System.out.println(cnt);
  }

  public static void getMaxCountKey(int n, String input[]){
    Map<String, Integer> m = new HashMap<>();
    Map<Integer, Set<String>>  ml = new HashMap<>();
    for(int i=0;i<=n;i++) ml.put(i, new HashSet<String>());
    int max = 0;
    for(int i=0;i<n;i++){
            String Keyword = input[i];
            int count = m.getOrDefault(Keyword, 0) + 1;
            m.put(Keyword, count);
            max = Math.max(max, count);
            Set<String> ln = ml.get(count);
            ln.add(Keyword);
    }
    TreeSet<String> myTreeSet = new TreeSet<>();
    myTreeSet.addAll(ml.get(max));
    for(String ans: myTreeSet){
            System.out.println(ans);
    }
}

public void countArray(int testNumber,int n, int[] a) {
    TreeSet<Integer> set = new TreeSet<>();
    set.add(1);
    int now = 1;
    for (int i = 0; i < n; i++) {
        now = a[now - 1];
        if (now == 2) {
            out.println(set.size());
            return;
        } else if (set.contains(now)) {
            out.println(-1);
            return;
        }
        set.add(now);
    }
}

public static void isRepeated(int A, int B, int C) {
    Set<Integer> set = new TreeSet<>();
    set.add(A);
    set.add(B);
    set.add(C);
    if(set.size()==2) {
            System.out.println("Yes");
    } else {
            System.out.println("No");
    }
}

public static void getExtinctSize(int N, String[] args) {
    Set<String> items = new TreeSet<String>();
    for(int i = 0; i < N; i++) {
            items.add(args[i]);
    }
    System.out.println(items.size());
}

public static void getExtinctSize(int n, String[] args) {
    TreeSet<String> vals = new TreeSet<>();
    for(int i = 0; i< n; i++){
            vals.add(args[i]);
    }
    System.out.println(vals.size());
}

public static void getExtinctSize(int n, String args[])throws Exception
{
    TreeSet<String> set=new TreeSet<>();
    for(int i=0;i<n;i++)
    {
        String s=args[i];
        set.add(s);
    }
    pw.println(set.size());
}

void getExtinctSize(int n, String args[]){
    TreeSet<String> s = new TreeSet<>();
    for(int i = 0; i < n; i++) s.add(args[i]);
    System.out.println(s.size());
}

public static void noRepeated()throws IOException
    {
        int n=ni();
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i=1;i<=n;i++){
                set.add(ni());
        }
        if(set.size()==n)
                pn("YES");
        else
                pn("NO");
    }

    static void countRepeated() throws IOException {
        int n = nextInt();
        int k = nextInt();
        TreeSet<Integer> tr = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            int l = nextInt();
            for (int j = 0; j < l; j++) {
                tr.add(nextInt());
            }
        }
        out.println(n-tr.size());
    }

    public static void countNoRepeated(int n, Integer[] d ) {
        Set<Integer> setD = new TreeSet<>(Arrays.asList(d));
        System.out.println(setD.size());
    }

    public static void isKukuContained(int N) {
        Set<Integer> kuku = new TreeSet<>();
        for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {
                        kuku.add(i * j);
                }
        }
        System.out.println(kuku.contains(N)? "Yes" : "No");
        sc.close();
}

public static void countContains(int n, int q, int[] inputB, int[] inputC) {
    TreeSet<Integer> st = new TreeSet<>();
    for(int i=0;i<n;i++){
        int b=inputB[i];
        st.add(b);
    }
    int ans=0;
    for(int i=0;i<q;i++){
    int c=inputC[i];
    if(st.contains(c)) ans++; 
    }
    System.out.println(ans);
}

public int countInput(int testNumber,int n, int[] a) {
    TreeSet<Integer> set = new TreeSet<>();
    set.add(1);
    int now = 1;
    for (int i = 0; i < n; i++) {
        now = a[now - 1];
        if (now == 2) {
            return set.size();
        } else if (set.contains(now)) {
            return -1;
        }
        set.add(now);
    }
}

public void calDifference(int testNumber, int n, int l, PrintWriter out) {
    int sum = 0;
    TreeSet<Integer> negatives = new TreeSet<>();
    TreeSet<Integer> positives = new TreeSet<>();
    for (int i = 0; i < n; i++) {
        sum += (l + i);
        if (l + i < 0) {
            negatives.add(l + i);
        } else {
            positives.add(l + i);
        }
    }
    if (positives.contains(0)) {
        out.println(sum);
    } else {
        if (negatives.isEmpty()) {
            out.println(sum - positives.first());
        } else if (positives.isEmpty()) {
            out.println(sum - negatives.last());
        } else {
            if (Math.abs(negatives.last()) < positives.first()) {
                out.println(sum - negatives.last());
            } else {
                out.println(sum + positives.first());
            }
        }
    }
}

public static void countContains(int n , int[] args) {
    Set<Integer> T = new TreeSet<Integer>();
    for(int i=0;i<n;i++){
            T.add(args[i]);
    }
    int p = sc.nextInt();
    int cnt=0;
    for(int i=0;i<p;i++){
            int t= sc.nextInt();
            if(T.contains(t)){
                    cnt++;
            }
    }
    System.out.println(cnt);
}

public static int getMinDifference(String str[], int x, int n)throws Exception
    {
        TreeSet<Integer> ts=new TreeSet<>();
        for(int i=0;i<=101;i++)
            ts.add(i);
        for(int i=0;i<n;i++)
        ts.remove(new Integer(Integer.parseInt(str[i])));
        int t1=ts.floor(x);
        int t2=ts.ceiling(x);
        if((int)Math.abs(t1-x)<(int)Math.abs(t2-x))
        return t1;
        else if((int)Math.abs(t1-x)>(int)Math.abs(t2-x))
        return t2;
        else
        return Math.min(t1,t2);
    }

    public static int sumOp(int n, int[] h) {
        int op = 0;
        while(true){
            SortedSet<Integer> st = new TreeSet<Integer>();
            int prev = 0;
            for(int i = 0; i<n; i++){
                if(i == n-1){
                    st.add(h[i]);
                    while(!st.isEmpty() && st.first() == 0){
                        st.remove(st.first());
                    }
                    if(!st.isEmpty()){
                        int minval = ((TreeSet<Integer>) st).first();
                        op+=minval;
                        for(int j = prev; j<=i; j++){
                            if(h[j]!=0)h[j] -= minval;
                        }
                        st.clear();
                    }
                    prev = i+1;
                }
                else if(h[i] == 0 && !st.isEmpty()){
                    while(!st.isEmpty() && st.first() == 0){
                        st.remove(st.first());
                    }
                    if(!st.isEmpty()){
                        int minval = ((TreeSet<Integer>) st).first();
                        op+=minval;
                        for(int j = prev; j<=i; j++){
                            if(h[j]!=0)h[j] -= minval;
                        }
                        st.clear();
                    }
                    prev = i+1;
                }
                else if(h[i] == 0 && st.isEmpty())prev+=1;
                else if(!st.contains(h[i]) && h[i] != 0) st.add(h[i]);
                else continue;
            }
            boolean ok = true;
            for(int i = 0; i<n; i++){
                if(h[i]>0)ok = false;
            }
            if(ok)break;
        }
        return op;
    }

    public static void countBelow(int n, int[]in) throws Exception {
        int ans=0;
        TreeSet<Integer>t=new TreeSet<Integer>();
        for(int i=0;i<n;i++) {
                if(t.floor(in[i])==null) {
                        ans++;
                }
                t.add(in[i]);
        }
        return ans;
}

public static void convertString(String[] args) throws java.lang.Exception { 
    Reader pm =new Reader(); 
    int t = 1;
    while(t-- > 0){
        long n = pm.nextLong();
        TreeSet<Long> l = new TreeSet<>();
        TreeSet<Long> r = new TreeSet<>();
        l.add(1l);
        r.add(26l);
        HashMap<Long, Integer> hm = new HashMap<>();
        hm.put(1l, 1);
        int pow = 2;
        while(pow < 11) {
            l.add(r.last() + 1);
            long toAdd = (long)Math.pow(26, pow) + l.last() - 1;
            r.add(toAdd);
            hm.put(l.last(), pow);
            pow++;
        }
        long low = l.floor(n);
        int pg = hm.get(low);
        long got = (long)Math.pow(26, pg) + 1;
        StringBuffer sb = new StringBuffer();
        while(pg-- > 0) 
            sb.append('a');
        long dif = n - low;
        int ind = sb.length()-1;
        while(dif-- > 0) {
            char pre = sb.charAt(ind);
            if(pre == 'z'){
                ind--;
                if(ind < 0)
                    break;
            }
            int prn = (int)pre;
            sb.setCharAt(ind, (char)(prn+1));
        }
        System.out.println(indexToColumnItr(n, ALPHABET).toLowerCase());
    }
}

    public int getCeilingDifference(int n, int a[], OutputWriter w) {
        TreeSet<Integer> ts[] = new TreeSet[n + 1];
        for (int i = 0; i <= n; i++) {
            ts[i] = new TreeSet<>();
        }
        for (int i = 0; i < n; i++) {
            ts[a[i]].add(i);
        }
        if (ts[1].size() == 0) {
            w.printLine(-1);
            return;
        }
        int init = 0, check = 0;
        for (int i = 1; i <= n; i++) {
            if (ts[i].ceiling(init) != null) {
                init = ts[i].ceiling(init);
            } else {
                return n - i + 1;
            }
        }
        return 0;
    }

    public static void getCeilingN(int N) {
        TreeSet<Integer> ts = new TreeSet<Integer>();
        for (int i = 1; i <= 9; i++) {
                ts.add(111*i);
        }
        pw.println(ts.ceiling(N));
}

public static void hasCeiling(int k, int x1, int x2, int x3, int x4, int x5) {
    TreeSet<Integer> tset=new TreeSet<>();
    tset.add(x1);
    tset.add(x2);
    tset.add(x3);
    tset.add(x4);
    tset.add(x5);
    int first=tset.first();
    if(tset.ceiling(first+k+1)!=null) {
            System.out.println(":(");
    }else {
            System.out.println("Yay!");
    }
}

public void checkStringLength(Stirng S) {
    ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
    stack.push(0);
    boolean ans = false;
    while(!stack.isEmpty()) {
            int i = stack.pop();
            if(i == S.length()) {
                    ans = true;
                    break;
            }
            for(int j=0; j<4; j++) {
                    if(i+P[j].length() <= S.length() && P[j].equals(S.substring(i, i+P[j].length()))) {
                            stack.push(i+P[j].length());
                    }
            }
    }
    if(ans) System.out.println("YES");
    else System.out.println("NO");
}

public static void calHalfSum(int num){
    LinkedList<Double> values = new LinkedList<>();
    Deque<Double> stack = new ArrayDeque<>();
    for(int i = 0; i < num; i++){
            values.add(scan.nextDouble());
    }
    Collections.sort(values);
    stack.push(values.poll());
    while(!values.isEmpty()){
            stack.push((stack.pop() + values.poll()) / 2.0);
    }
    System.out.println(stack.pop());
}

public static void calRemain(List<String> args) {
    ArrayDeque<Integer> ansA = new ArrayDeque<Integer>();
    ArrayDeque<Integer> ansB = new ArrayDeque<Integer>();
    while(sc.hasNext()){
            int m = args.getFirst();
            args.removeFirst();
            int n = args.getFirst();
            args.removeFirst();
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
            ansA.push(m);
            ansB.push((a/m)*b);
    }
    int num = ansA.size();
    for(int i=0;i<num;i++){
            System.out.println(ansA.pollLast() + " " + ansB.pollLast());
    }
}

public static void reverseInput(List<String> args) {
    ArrayDeque<String> ans = new ArrayDeque<String>();

    while(args.size() > 0){
            String s = args.getFirst();
            args.removeFirst();
            StringBuffer t = new StringBuffer(s);
            t.reverse();
            ans.push(t.toString());
    }
    int num = ans.size();
    for(int i=0;i<num;i++){
            System.out.println(ans.pollLast());
    }
}

public static void toSameTop( int N, String slims) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char c: slims.toCharArray()) {
        if (stack.isEmpty() || stack.peek() != c) {
            stack.push(c);
        }
    }
    System.out.println(stack.size());
    in.close();
}

public static void calculator(List<Integer> intList, ArrayDeque<String> args) {
    ArrayDeque<Integer> a = new ArrayDeque<Integer>();
    while(args.size() > 0){
            if(intList.size() > 0){
                    a.push(intList.getFirst());
                    intList.removeFirst();
            }else{
                    int o1 = a.pop();
                    int o2 = a.pop();
                    switch(args.peek().charAt(0)){
                            case '+':
                                    a.push(o1 + o2);
                                    args.pop();
                                    break;
                            case '-':
                                    a.push(o2 - o1);
                                    args.pop();
                                    break;
                            case '*':
                                    a.push(o1 * o2);
                                    args.pop();
                                    break;
                            default:
                                    args.pop();
                                    break;
                    }
            }
    }
    System.out.println(a.pop());
}

@Override
                        public List<Integer> next() {
                                out:
                                while (!ist.isEmpty()) {
                                        int k = ist.pop();
                                        if (k != -1) {
                                                used[k] = false;
                                                perm.remove(perm.size() - 1);
                                        } else {
                                                int pos = perm.size();
                                                if (pos == n) {
                                                        cnt++;
                                                        return perm;
                                                }
                                        }
                                        for (int i = k + 1; i < n; i++) {
                                                if (!used[i]) {
                                                        ist.push(i);
                                                        used[i] = true;
                                                        perm.add(i);
                                                        ist.push(-1);
                                                        continue out;
                                                }
                                        }
                                }
                                return null;
                        }

                        public static void calHalfSum(int num, Double[] args){
                            LinkedList<Double> values = new LinkedList<>();
                            Deque<Double> stack = new ArrayDeque<>();
                            for(int i = 0; i < num; i++){
                                    values.add(args[i]);
                            }
                            Collections.sort(values);
                            stack.push(values.poll());
                            while(!values.isEmpty()){
                                    stack.push((stack.pop() + values.poll()) / 2.0);
                            }
                            System.out.println(stack.pop());
                    }
                    
                    public static void totalDiff(int n, int q, String[] argsP, int[] argsT){
                        Deque<String> P = new ArrayDeque<String>();
                        Deque<Integer> T = new ArrayDeque<Integer>();
                        for(int i=0; i<n; i++){
                                P.add(argsP[i]);  
                                T.add(argsT[i]);
                        }
                        int total=0;
                        while ( !P.isEmpty() ) {
                                String p= P.pop();
                                int t= T.pop();
                                if(q<t) { T.add(t-q); P.add(p); total+= q; }
                                else { total+= t;  System.out.println(p +" "+ total); } 
                        }
                }
    
                public String doBackspace(char[] s) {
                    Deque<Integer> stack = new ArrayDeque<Integer>();
                    for (char c : s) {
                            if (c == '0') {
                                    stack.push(0);
                            } else if (c == '1') {
                                    stack.push(1);
                            } else if (c == 'B') {
                                    if (stack.isEmpty()) continue;
                                    stack.pop();
                            }
                    }
                    StringBuilder sb = new StringBuilder();
                    while (!stack.isEmpty()) {
                            sb.append(stack.pop());
                    }
                    return sb.reverse().toString();
            }

            public static void countDifferentLength(String s) {
                Deque<Character> stack = new ArrayDeque<>();
                for (char c : s.toCharArray()) {
                  if (!stack.isEmpty() && stack.peek() != c) {
                    stack.pop();
                  } else {
                    stack.push(c);
                  }
                }
                System.out.println(s.length() - stack.size());
              }

              public static void calTime(int n, int q, int TIME, String[] nameList, int[] timeList) {
                Queue<String> name=new ArrayDeque<>();Queue<Integer>time=new ArrayDeque<>();
                for(int i=0;i<n;i++) {
                        name.add(nameList[i]);time.add(timeList[i]);
                }
                while(name.peek()!=null) {
                        String str=name.remove();int t=time.remove();
                        if(t>q) {
                                name.add(str);time.add(t-q);
                                TIME+=q;
                        }
                        else{
                                System.out.println(str+" "+(TIME+t));
                                TIME+=t;
                        }
                }
        }

        public static void checkSameTop(int N, String slims) {
            Deque<Character> stack = new ArrayDeque<>();
            for (char c: slims.toCharArray()) {
                if (stack.isEmpty() || stack.peek() != c) {
                    stack.push(c);
                }
            }
            System.out.println(stack.size());
            in.close();
        }

        public static void countEqual(String nextLine) {
            StringBuilder s = new StringBuilder(nextLine);
            Deque<String> stack = new ArrayDeque<>();
            for(int i=0; i<s.length(); i++) {
                    if(stack.size()==0) {
                            stack.push(s.substring(i, i+1));
                    }
                    else {
                            if(!stack.peek().equals(s.substring(i, i+1))) {
                                    stack.pop();
                            }
                            else {
                                    stack.push(s.substring(i, i+1));
                            }
                    }
            }
            System.out.println(s.length()-stack.size());
    }

    public static void countEqual(List<String> args) {
        while (args.size() > 0) {
          String S = args.getFirst();
          args.removeFirst();
          ArrayDeque<Character> stack = new ArrayDeque<Character>();
          for (int i = 0; i < S.length(); ++i) {
            char cube = S.charAt(i);
            if (stack.isEmpty()) {
              stack.push(cube);
            } else if (cube == '1' && stack.peek() == '0') {
              stack.pop();
            } else if (cube == '0' && stack.peek() == '1') {
              stack.pop();
            } else {
              stack.push(cube);
            }
          }
          System.out.println(S.length() - stack.size());
        }
      }

      public static void calculator(List<String> args) {
        Deque<Integer> numbers = new ArrayDeque<>();
        String str;
        int a = 0;
        int b = 0;
        while(args.size() > 0) {
                str = args.getFirst();
                args.removeFirst();
                switch(str) {
                        case "+":
                                a = numbers.pop();
                                b = numbers.pop();
                                numbers.push(a + b);
                                break;
                        case "-":
                                b = numbers.pop();
                                a = numbers.pop();
                                numbers.push(a - b);
                                break;
                        case "*":
                                a = numbers.pop();
                                b = numbers.pop();
                                numbers.push(a * b);
                                break;
                        default:
                                numbers.push(Integer.parseInt(str));
                }
        }
        System.out.println(numbers.peek());
}

private static boolean isEnd() {
    return Qmap.get(CURRENT_STATE).isEmpty();
}

public void getMaxCountKey(int n,String[] input, PrintWriter out) {
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    int max = 0;
    for (int i = 0; i < n; i++) {
        String s = input[i];
        map.put(s, map.getOrDefault(s, 0) + 1);
        max = Math.max(max, map.get(s));
    }
    TreeSet<String> h = new TreeSet<String>();
    for (Map.Entry<String, Integer> e : map.entrySet()) {
        if (e.getValue() == max) {
            h.add(e.getKey());
        }
    }
    while (!h.isEmpty()) {
        out.println(h.pollFirst());
    }
}

public static void getMaxCountKey(int n, String[] input) {
    Map<String,Integer> s = new LinkedHashMap<String,Integer>();
    for(int i = 0; i < n; i++) {
            String temp = input[i];
            if(s.containsKey(temp)) {
                    int c = s.get(temp)+1;
                    s.put(temp, c);
            }
            else {
                    s.put(temp, 1);
            }
    }
    Map<String,Integer> ans = new TreeMap<String,Integer>();
    int count = 0;
    for(String key:s.keySet()) {
            if(count < s.get(key)) {
                    ans.clear();
                    count = s.get(key);
                    ans.put(key, count);
            }
            else if(count==s.get(key)) {
                    ans.put(key, count);
            }
    }
    for(String key:ans.keySet()) {
            System.out.println(key);
    }
}

public static void checkHigher(String[] args) {
    FS in = new FS();
    HashMap<Integer, TreeSet<Integer>> map;
    map = new HashMap<>();
    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            map.putIfAbsent(a, new TreeSet<>());
            map.get(a).add(i);
            map.get(a).add(n + 1);
    }
    int k = 0, l = -1;
    while (true) {
            if (!map.containsKey(k + 1))
                    break;
            if (map.get(k + 1).higher(l) != (n + 1)) {
                    l = map.get(k + 1).higher(l);
                    k++;
            }
            else
                    break;
    }
    int ans = n - k;
    if (l == -1)
            ans = l;
    System.out.println(ans);
}

public HashMap<Integer,Integer> factorCount(int i){
    HashMap<Integer,Integer> res = new HashMap<>();
    while(i!=1){
        res.putIfAbsent(f[i],0);
        res.put(f[i],res.get(f[i])+1);
        i /= f[i];
    }
    return res;
}

public static void countSquares(int n, int d, int dp[][]) {
    Map<Integer,Integer> squares = new HashMap<>();
    for (int i = 1; i <= 200; i++) {
        squares.putIfAbsent(i*i,i);
    }
    int counter = 0;
    for (int i = 0; i < n; i++) {
        for (int j = i+1; j < n; j++) {
            int x = 0;
            for (int k = 0; k < d; k++) {
                x+=Math.pow(dp[i][k] - dp[j][k],2);
            }
            if(squares.containsKey(x)){
                counter++;
            }
        }
    }
    System.out.println(counter);
}

public static void calDiff(long a, long b) {
    long diff = b-a;
    if(diff >= 2019){
        System.out.println(0);
    }else{
        long min = Integer.MAX_VALUE;
        HashMap<Long,Integer> ab = new HashMap();
        for (long i = a; i <= b; i++) {
            ab.putIfAbsent(i % 2019,1);
        }
        ArrayList<Long> list = new ArrayList<>(ab.keySet());
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                min = Math.min((list.get(i) * list.get(j)) % 2019, min);
            }
        }
        System.out.println(min);
    }
}

public static void getExtinctSize(int a, String args[])
    {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<a;i++)
        {
            map.putIfAbsent(args[i],1);

        }
        System.out.print(map.size());
    }


    public static void calHalfSum(int N , String args[]){
        HashMap<String,Integer> num = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = args[i];
            int[] count = new int[26];
            for (int j = 0; j < 10; j++) {
                char sj = s.charAt(j);
                count[sj-'a']++;
            }
            String val = "";
            for(int j=0; j<26; j++){
                val += String.valueOf('a'+count[j]);
            }
            num.putIfAbsent(val, 0);
            num.put(val,num.get(val) + 1);
        }
        long ans = 0;
        for(Integer n:num.values()){
            ans += (long)n*(long)(n-1)/2;
        }
        System.out.println(ans);
    }

    public static void countRepeated(String[] args) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        Long count = new Long(0);
        Integer n = Integer.parseInt(stdin.readLine());
        Map<String, Integer> map = new HashMap<>();
        String line;
        while ((line = stdin.readLine()) != null) {
            char[] chars = line.toCharArray();
            Arrays.sort(chars);
            String newStr = new String(chars);
            Integer temp = map.get(newStr);
            if (temp == null) {
                map.put(newStr, 1);
            } else {
                count += temp;
                map.put(newStr, temp+1);
            }
        }
        System.out.println(count);
    }

    public static void countRepeated(int N, String args[]) {
        HashMap<String, Integer> map = new HashMap<>();
        long ans = 0;
        for(int i = 0; i < N; i++) {
            String line = args[i];
            char[] c = line.toCharArray();
            Arrays.sort(c);
            String sortedLine = new String(c);
            if(map.containsKey(sortedLine)) {
                ans += map.get(sortedLine);
                map.put(sortedLine, map.get(sortedLine) + 1);
            } else {
                map.put(sortedLine, 1);
            }
        }
        System.out.println(ans);
    }

    public static void calHalfSum(int n, String[] args) {
        long ans = 0;
        Map<String, Long> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            char[] ca = args[i].toCharArray();
            Arrays.sort(ca);
            String s = String.valueOf(ca);
            if(map.containsKey(s)) map.put(s, map.get(s) + 1);
            else map.put(s, 1L);
        }
        for(String key : map.keySet()) {
            ans += map.get(key) * (map.get(key) - 1) / 2;
        }
        System.out.println(ans);
    }

    public static void countRepeated(long N, String[] input) {
        HashMap<String, Integer> map = new HashMap<>();
        long count = 0;
        for (int i = 0; i < N; i++) {
                char[] c = input[i].toCharArray();
                Arrays.sort(c);
                String s = new String(c);
                Integer n;
                if (map.containsKey(s)) {
                        n = map.get(s);
                        map.put(s, n+1);
                        count += n+1;
                }
                else {
                        map.put(s, 0);
                }
        }
        System.out.println(count);
}

public static int findKey(HashMap<Integer, Integer> hmap, int a, int i) {
    if(hmap.containsKey(a)) {
            return i;
    }
    hmap.put(a, i);
    return findKey(hmap,solve(i+1,a),i+1);
}

public static void countContains(int n) throws Exception {
    Map<Integer,Integer> po=new HashMap<Integer,Integer>();
    int count=1;
    for(;!(po.containsKey(n));count++){
        po.put(n,n);
        if(n%2==0)n/=2;
        else n=n*3+1;
    }
    System.out.println(count);
}

public static void getExtinctSize(int N, String args[]){
    HashMap<String,String> map = new HashMap<>();
    for (int i = 0; i < N; i++) {
        String k = args[i];
        if(!map.containsKey(k)){
            map.put(k, "a");
        }   
    System.out.println(map.size());
}
}

public static void countKeys(int n, String[] arg) {
    ArrayList<String> list = new ArrayList<String>();
    Map<String, Integer> map = new HashMap<String, Integer>();
    for(int i = 0; i < n; i++){
            String s = arg[i];
            if(map.containsKey(s)){
                    int v = map.get(s);
                    map.put(s, v+1);
            } else {
                    map.put(s, 1);
            }
    }
    System.out.println(map.keySet().size());
}

public static void countKeys(String[] args) {
    int n = GetInput.getInt();
    HashMap<String , Integer> hashMap = new HashMap<>();
    while(n-->0) {
        String key = GetInput.getInputString().toString();
        if (hashMap.get(key) == null) {
            hashMap.put(key, 1);
            continue;
        }
        hashMap.replace(key, hashMap.get(key)+1);
    }
    System.out.println(hashMap.size());
}

public static void getExtinctSize(int n, String args[]) {
    HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
    for(int i = 0; i < n; i++){
      String check = args[i];
      if(!hashmap.containsKey(check)){
        hashmap.put(check, 0);
      }
    }
    System.out.println(hashmap.size());
  }

  public static void getExtinctSize(int n, String [] args)
  {
      HashMap<String, Integer> map = new HashMap<>();
      for (int i = 0; i < n; i++) {
          String s = args[i];
          map.put(s, map.getOrDefault(s, 0) + 1);
      }
      System.out.println(map.keySet().size());
  }

  public long countRepeated(int n, String[] args) throws IOException {
    HashMap<String,Integer> a = new HashMap<>();
    long ans = 0;
    for (int i = 0; i < n; i++) {
        String[] s = args[i].split("");
        Arrays.sort(s);
        String ss = "";
        for (int j = 0; j < s.length; j++) {
            ss += s[j];
        }
        if(a.containsKey(ss)){
            ans += a.get(ss);
            a.put(ss,a.get(ss)+1);
        }
        else {
            a.put(ss,1);
        }
    }
    return ans;
}

public static void calHalfSum(Integer N, String[] args) throws Exception {
    long count = 0;
    HashMap<String, Long> map = new HashMap<String, Long>(); 
    for(int i = 0; i < N; i++) {
        String s = args[i];
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        String sorted = new String(sArray);
        if(map.containsKey(sorted))
            map.put(sorted, map.get(sorted) + 1);
        else
            map.put(sorted, (long)1);
    }
    for(Entry<String, Long> entry : map.entrySet()) {
        long value = entry.getValue();
        count += value * (value - 1) / 2;
    }
    System.out.println(count);
}

public static void isFiftyFifty(String nextLine) {
    char[] S = nextLine.toCharArray();
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0; i < 4; i++) {
      if (map.containsKey(S[i])) {
        map.put(S[i], map.get(S[i]) + 1);
      } else {
        map.put(S[i], 1);
      }
    }
    boolean isFiftyFifty = true;
    for (char key : map.keySet()) {
      if (map.get(key) != 2) {
        isFiftyFifty = false;
      }
    }
    if (isFiftyFifty) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }

  public static void find2(int n, String[] args) {
    int[] a = new int[n+1];
    for (int i = 1; i < n+1; i++) {
            a[i] = Integer.parseInt(args[i]);
    }
    int b = 1;
    int ans = -1;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    map.put(1, 1);
    for (int i = 1; i < n + 1; i++) {
            b = a[b];
            if (b == 2) {
                    ans = i;
                    break;
            }
            if (map.containsKey(b)) {
                    break;
            }
    }
    System.out.println(ans);
}

public static void noRepeated(int N, int[] inputA) {
    HashMap<Integer,Integer> A = new HashMap<>();
    for (int i = 0; i < N; i++){
        int a = inputA[i];
        if (A.containsKey(a)){
            System.out.println("NO");
            return;
        }
        A.put(a,0);
    }
    System.out.println("YES");
}

public static void countKeys(int n, String[] args) {
    HashMap<String,Integer> vote = new HashMap<>();
    for(int i=0;i<n;i++){
        String name = args[i];
        if(vote.containsKey(name)){
            int temp = vote.get(name);
            vote.remove(name);
            vote.put(name,temp+1);
        }
        else{
            vote.put(name,1);
        }
    }
}

public static void countKeys(int n, String[] args) {
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    for( int i=0; i<n; i++) {
        String str = args[i];
        Integer count = map.get(str);
        if (count == null) {
            map.put(str,1);
        } else {
            map.remove(str);
            map.put(str,count+1);
        }
    }
}

public static void getModAns(String[] args) throws Exception{
    long L = nextLong();
    long R = nextLong();
    HashMap<Integer,Integer> map = new HashMap<>();
    for(int i=0;i<=2019;i++){
            map.put(i, i);
    }
    long ans =2019;
    for(long i=L;i<R;i++){
            HashMap<Integer,Integer> tmp = new HashMap<>();
            for(long k=i+1;k<=R;k++){
                    int x = (int)((i%2019)*(k%2019))%2019;
                    ans = Math.min(ans, x);
                    if(tmp.containsKey(x)){
                            break;
                    }
                    tmp.put(x, x);
            }
            for(int x:tmp.keySet()){
                    map.remove(x);
            }
            if(ans==0||map.size()==0){
                    break;
            }
    }
    pw.println(ans);
}

public deleteOpt(int opt1, int opt2) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(1, 1);
    map.put(2, 2);
    map.put(3, 3);
    map.remove(opt1);
    map.remove(opt2);
    String res = map.values().toString();
    System.out.println(res.substring(1,2));
}

public static void remove(HashMap<Integer,Integer> hm, int val){
    hm.put(val, hm.get(val)-1);
    if(hm.get(val)==0){
            hm.remove(val);
    }
}

public static void deleteInput(int n, int k, int[] inputD) {
    HashMap<Integer,Integer>hm=new HashMap<>();
    for(int j=0;j<n;j++)
        hm.put(j+1,1);
    for(int j=0;j<k;j++)
    {
        int d=inputD[i];
        for(int l=0;l<d;l++)
        {
            int m=sc.nextInt();
            if(hm.get(m)!=null)
                hm.remove(m);
        }
    }
    System.out.println(hm.size());
}

public static void countKeys (int N, String[] inputS) throws java.lang.Exception
        {
                HashMap<String, Integer> cnt = new HashMap<>();
                for (int i = 0; i < N; ++i) {
                        String s = sorted(inputS[i]);
                        cnt.put(s, cnt.getOrDefault(s, 0) + 1);
                }
                long ans = 0;
                for (String s : cnt.keySet()) {
                        ans += nc2(cnt.get(s));
                }
                System.out.println(ans);
        }

        public static void countKeys(int N, String[] inputC) {
            long res = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                char[] c = inputC[i].toCharArray();
                Arrays.sort(c);
                String s = String.valueOf(c);
                int tmp = map.getOrDefault(s, 0);
                res += tmp;
                map.put(s, tmp + 1);
            }
            System.out.println(res);
        }

        public static void countKeys(int n, String[] args){
            long ans = 0;
            HashMap<String, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++){
                String s = args[i];
                char sa[] = s.toCharArray(); 
                Arrays.sort(sa);
                String sorted = new String(sa);
                ans += map.getOrDefault(sorted, 0);
                map.put(sorted, map.getOrDefault(sorted, 0)+1);
            }
            System.out.println(ans);
        }

        public static void calHalfSum(String[] args) throws Exception {
            int N = nextInt();
            HashMap<String,Integer> map = new HashMap<>();
            for(int i=0;i<N;i++){
                    char[] c = nextString().toCharArray();
                    Arrays.sort(c);
                    String s = String.valueOf(c);
                    map.put(s, map.getOrDefault(s,0)+1);
            }
            long ans = 0;
            for(int val:map.values()){
                    if(val!=1){
                            ans+=(long)(val)*(val-1)/2L;
                    }
            }
            System.out.println(ans);
    }

    public static void countFirst(String[] args) {
        FastReader r = new FastReader();
        int[] arr = r.ria();
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<arr[0]; i++) {
                int[] t = r.ria();
                for(int j = 1; j<t.length; j++) {
                        map.put(t[j], map.getOrDefault(t[j],0)+1);
                        if(map.get(t[j]) == arr[0]) sum++;
                }
        }
        print(sum);
}

public static void sumCount(int n, String[] inputArray ) {
    char[] c = new char[10];
    String s;
    HashMap<String, Long> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
            c = inputArray[i].toCharArray();
            Arrays.sort(c);
            s = new String(c);
            if (map.get(s) == null) {
                    map.put(s, 1L);
            } else {
                    map.put(s, map.get(s) + 1);
            }
    }

    long ans = 0;
    for (Long v : map.values()) {
            ans += v * (v - 1) / 2;
    }
    System.out.println(ans);
}

public static void countRepeated(int N, String[] inputS) {
    HashMap<String, Integer> map = new HashMap<>();
    long ans = 0;
    for(int i = 0; i < N; i++) {
        String line = inputS[i];
        char[] c = line.toCharArray();
        Arrays.sort(c);
        String sortedLine = new String(c);

        if(map.containsKey(sortedLine)) {
            ans += map.get(sortedLine);
            map.put(sortedLine, map.get(sortedLine) + 1);
        } else {
            map.put(sortedLine, 1);
        }
    }
    System.out.println(ans);
}

public void readD(String str) {
    String[] strArr = str.split("\\s+");
    HashMap<Integer, Integer> hist = new HashMap<Integer, Integer>();
    int dmax = 1;
    for (int i = 0; i < N; i++) {
            int d = Integer.parseInt(strArr[i]);
            if (hist.containsKey(d)) {
                    hist.put(d, hist.get(d) + 1);
            } else {
                    hist.put(d, 1);
            }
            if (d > dmax)
                    dmax = d;
    }
    int cnt = 0;
    int h = 0;
    for (int i = 0; i < dmax && h <= N / 2; i++) {
            if (hist.containsKey(i)) {
                    h += hist.get(i);
            }
            if (h == N / 2)
                    cnt++;
    }
    System.out.println(cnt);
}

public static void countKeys(int N, String[] args) {
                HashMap<String, Integer> S = new HashMap<String, Integer>();
                for (int i = 0; i < N; i++) {
                        String SS = args[i];
                        if (S.containsKey(SS)) {
                                S.put(SS, S.get(SS) + 1);
                        } else {
                                S.put(SS, 1);
                        }
                }
        }

        public static void getMaxCountKey(int n, String[] args) {
            String[] s = new String[n];
            int max = 1;
            HashMap<String, Integer> map = new HashMap();
            for (int i = 0; i < n; i++) {
                s[i] = args[i];
                if (map.containsKey(s[i])) {
                    int v = map.get(s[i]) + 1;
                    map.put(s[i], v);
                    if (v > max) max = v;
                } else {
                    map.put(s[i], 1);
                }
            }
            Arrays.sort(s);
            for (int i = 0; i < n; i++) {
                int v = map.get(s[i]);
                if (v == max) {
                    System.out.println(s[i]);
                }
                i += (v - 1);
            }
        }

        public static void getMaxDifference(int x, int n,int[] inputArray) {
            int max = 105;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
              set.add(inputArray[i]);
            }
            int ans = -1;
            if (set.isEmpty()) {
              ans = x;
            } else {
              for (int i = 0; i <= max; i++) {
                if (!set.contains(i) && Math.abs(ans - x) > Math.abs(i - x)) {
                  ans = i;
                }
              }
            }
            System.out.println(ans);
          }

          public static void getMinMax(int n, int[] inputArray) {
            Set<Integer> fixed = new HashSet<>();
            int free = 0;
            for(int i = 0; i < n; i ++) {
                    int a = inputArray[i];
                    if(a / 400 < 8) {
                            fixed.add(a / 400);
                    } else {
                            free ++;
                    }
            }
            int min = 0;
            int max = 0;
            if(fixed.isEmpty()) {
                    min = 1;
                    max = free;
            } else {
                    min = fixed.size();
                    max = min + free;
            }
            System.out.println(min + " " + max);
    }

    public static void checkContains(String s, String[] args) {
        char[] ary = s.toCharArray();
        List<Character> oary = Arrays.asList('R', 'U', 'D');
        List<Character> eary = Arrays.asList('L', 'U', 'D');
        Set<Character> hso = new HashSet<>();
        Set<Character> hse = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if ((i + 1) % 2 == 0) {
                hse.add(ary[i]);
            } else {
                hso.add(ary[i]);
            }
        }
        hso.removeAll(oary);
        hse.removeAll(eary);
        if (hso.isEmpty() && hse.isEmpty()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void getRetainSize(int n, int m, int[] inputArray,int[] inputArray2){
        Set<Integer> foods = new HashSet<Integer>();
        for(int i=0;i<m;i++){
          foods.add(i);
        }
        Set<Integer> tmp = new HashSet<Integer>();
        for(int i=0;i<n;i++){
          int x=inputArray[i];
          for(int j=0;j<x;j++){
            tmp.add(inputArray2[i*n +j]-1);
          }
          foods.retainAll(tmp);
          tmp.clear();
        }
        System.out.println(foods.size());
      }

      public void countSize8(int testNumber, MyScanner in, PrintWriter out) {
        int N = in.Int();
        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 105; i <= N; i += 2) {
            set.clear();
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    set.add(j);
                    set.add(i / j);
                }
            }
            if (set.size() == 8) cnt++;
        }
        out.println(cnt);
    }

    public static void isSetPrime(int n, BigInteger[] inputArray) {
        Set<BigInteger> set=new HashSet<BigInteger>();
        int c=0;
        for(int i=1;i<=n;i++)
        {
                set.add(inputArray[i]);
        }
        ArrayList<BigInteger> bi=new ArrayList<BigInteger>(set);
        int m=set.size();
        for(int i=0;i<m;i++)
        {
                if(bi.get(i).isProbablePrime(10)==true)
                {
                        c++;
                }
        }
        System.out.println(c);
        bi.clear();
        set.clear();
}

public static void calDpMax(int n, int[] v, int[] c) {
    int[] values = new int[n];
    for (int i = 0; i < n; i++) values[i] = v[i] - c[i];
    Set<Integer> dp = new HashSet<>();
    Set<Integer> ndp = new HashSet<>();
    dp.add(0);
    for (int i = 0; i < n; i++) {
      ndp.clear();
      for (int val : dp) {
        ndp.add(val);
        ndp.add(val + values[i]);
      }
      dp.clear();
      dp.addAll(ndp);
    }
    int max = Integer.MIN_VALUE;
    for (int val : dp) max = Math.max(max, val);
    System.out.println(max);
  }

  public static void checkUpperCaseInclude(String S){
    if (S.charAt(0) == 'A'){
      int countC = 0;
      for (int i = 2; i < S.length() - 1; i++){
        if (S.charAt(i) == 'C'){
          countC++;
        }
      }
      HashSet<Character> set = new HashSet<>();
      set.add('A');
      set.add('C');
      if (countC == 1){
        for (char c: S.toCharArray()){
          if (Character.isUpperCase(c) && !set.contains(c)){
            System.out.println("WA");
            return;
          }
        }
        System.out.println("AC");
        return;
      }
    }
    System.out.println("WA");
    return;
  }

  public void addChild(Node node) {
    children.add(node);
}

public static List<Integer> readIntegerList(InputReader in, int size) {
    List<Integer> set = new ArrayList<>();
    for (int i = 0; i < size; i++) {
        set.add(in.readInt());
    }
    return set;
}

static ArrayList<Integer> intersect(ArrayList<Integer> a, ArrayList<Integer> b) {
    ArrayList<Integer> res = new ArrayList<>();
    if (b.size() != 0) {
            HashSet<Integer> hm = new HashSet<>();
            for (int x : a)
                    hm.add(x);
            for (int x : b)
                    if (hm.contains(x))
                            res.add(x);
    }
    return res;
}

public static void getExtinctSize(int Kuji, String[] inputArray) {
    HashSet<String> hs = new HashSet<String>();
for(int i = 1; i <= Kuji; i++) {
    String syohin = inputArray[i];
            hs.add(syohin);
}
System.out.println(hs.size());
}

private int getExtinctSize(int n, String[] a) {
    HashSet<String> set = new HashSet<>();
    set.addAll(toArrayList(a));
    return set.size();
}

public static void getExtinctSortedSize(int n, String[] str) throws IOException{
    Set<String> set = new HashSet<>();
    for(int i=0; i<n; ++i)
        str[i] = br.readLine();
    Arrays.sort(str);
    set.addAll(Arrays.asList(str));
    System.out.println(set.size());
}

public static void isSIze2(String s) {
    Set<String> chars = new HashSet<>();
    chars.addAll(Arrays.asList(s.split("")));
    if (chars.size() == 2) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }

  public static void calDpMax(int n, int[] v, int[] c) {
    int[] values = new int[n];
    for (int i = 0; i < n; i++) values[i] = v[i] - c[i];
    Set<Integer> dp = new HashSet<>();
    Set<Integer> ndp = new HashSet<>();
    dp.add(0);
    for (int i = 0; i < n; i++) {
      ndp.clear();
      for (int val : dp) {
        ndp.add(val);
        ndp.add(val + values[i]);
      }
      dp.clear();
      dp.addAll(ndp);
    }
    int max = Integer.MIN_VALUE;
    for (int val : dp) max = Math.max(max, val);
    System.out.println(max);
  }

  public static void countContains(int n, int m, int[] inputK, input[] inputX) {
    HashSet<Integer> set=new HashSet<>();
    HashSet<Integer> s=new HashSet<>();
    for(int i=0;i<n;i++) {
            int k=inputK[i];
            s=new HashSet<>();
            for(int j=0;j<k;j++) {
                    int x=inputX[i*n + k];
                    if(i==0) {
                            set.add(x);
                            s.add(x);
                    }else {
                            if(set.contains(x)) {
                                    s.add(x);
                            }
                    }
            }
            if(i!=0) {
                    set.removeAll(set);
                    set.addAll(s);
            }
    }
    System.out.println(s.size());
}

public static void countContains(String[] args) throws IOException {
    int input = nextInt();
    HashSet <String> kinds = new HashSet<>();
    for (int x=0; x<input; x++) {
        String cur = next();
        if (!kinds.contains(cur)) {
            kinds.add(cur);
        }
    }
    System.out.println(kinds.size());
}

public static void getExtinctSize(int a, String args[])
  {
    HashSet<String> set=new HashSet<>();
    while(a>0)
    {
     String s=args[a-1];
     set.add(s);  
      a--;
    }
    System.out.print(set.size());  
  }

  public static void getExtinctSize(int times, String[] inputArray) {
    HashSet<String> kuji = new HashSet<String>();
    for(int i=0 ; i<times ; i++) {
            kuji.add(inputArray[i]);
    }
    System.out.print(kuji.size());
}

private int getExtinctSize(int n, String[] a) {
    HashSet<String> set = new HashSet<>();
    set.addAll(toArrayList(a));
    return set.size();
}

void isSize2() throws IOException {
    Set<Integer> set = new HashSet<>();
    for(int i=0;i<3;i++) set.add(sc.nextInt());
    String ans = set.size()==2?"Yes":"No";
    System.out.println(ans);
}

public static void checkSuffix(String s) {
    Set<String> set = new HashSet<String>();
    set.add("dream");
    set.add("dreamer");
    set.add("erase");
    set.add("eraser");
    int idx = s.length();
    String curr = "";
    while (idx >= 5) {
        if (set.contains(s.substring(idx - 5, idx))) {
            idx -= 5;
        } else if (set.contains(s.substring(idx - 6, idx))) {
            idx -= 6;
        } else if (set.contains(s.substring(idx - 7, idx))){ 
            idx -= 7;
        } else {
            break;
        }
    }
    String res =  idx == 0 ? "YES" : "NO";
    System.out.println(res);
}

public static void removeInput(String[] args) throws IOException {
    Writer out=new Writer(System.out);
    Reader in=new Reader(System.in);
    int ts=1;
    outer: while(ts-->0) {
            int n=in.nextInt(); int k=in.nextInt();
            Set<Integer> set=new HashSet<>();
            for(int i=1; i<=n; i++) set.add(i);
            for(int i=0; i<k; i++) {
                    int d=in.nextInt();
                    int a[]=in.readArray(d);
                    for(int j: a) if(set.contains(j)) set.remove(j);
            }
            out.println(set.size());
    }
    out.close();
}

public static void removeInput(int n, int k, int[] inputKI, int[] inputTemp){
    HashSet<Integer> sunuke = new HashSet<>();
    for (int i = 0; i < n; i++) {
        sunuke.add(i+1);
    }
    for (int i = 0; i < k; i++) {
        int ki = inputKI[i];

        for (int j = 0; j < ki; j++) {
            int temp = inputTemp[k*i + ki];
            if (sunuke.contains(temp)) {
                sunuke.remove(temp);
            }
        }
    }
    System.out.println(sunuke.size());
}

public static void getMinDifference(int X, int N, int[] inputP) {
    Set<Integer> p = new HashSet<>();
    for(int i = 0; i < N; i++)
            p.add(inputP[i]);
    int ans = 0, min = Integer.MAX_VALUE/2;
    for(int i = -100; i <= 200; i++)
            if(!p.contains(i) && Math.abs(i-X) < min) {
                    ans = i;
                    min = Math.abs(i-X);
            }
    System.out.println(ans);
}

public void getMinDifference(int X, int N, int[] inputArray) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < N; i++) {
        set.add(inputArray[i]);
    }
    int diff = Integer.MAX_VALUE;
    int ans = -1;
    for (int i = 0; i <= 101; i++) {
        if (set.contains(i)) {
            continue;
        }
        int t = Math.abs(i - X);
        if (t < diff) {
            ans = i;
            diff = t;
        }
    }
    System.out.println(ans);
}

public void getMinDifference() {
    int X = ni();
    int N = ni();
    if(N == 0) {
            out.println(X);
            return;
    }
    for (int i = 0; i < N; i++)     {
            set.add(ni());
    }
    int ans = 0, sv = 200;
    for (int i = 0; i <= 101; i++) {
            if(set.contains(i))             continue;
            if(sv > Math.abs(i - X)) {
                    sv = Math.abs(i - X);
                    ans = i;
            }
    }
    out.println(ans);
}

public static void findNotSymmetricalContains(int x, int n, int[] inputArray) {
    HashSet<Integer> h = new HashSet<>();
    while(n--!=0) {
            h.add(inputArray[i]);
    }
    int t=0;
    while(h.contains(x-t) && h.contains(x+t)) {
            t++;
    }
    if(!h.contains(x-t)) {
            System.out.println(x-t);
    }
    else if(!h.contains(x+t)) {
            System.out.println(x+t);
    }
}

public static void remove2(int a, int b) {
    HashSet<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < 3; i++) {
            set.add(i + 1);
    }
    set.remove(a);
    set.remove(b);
    System.out.println(set.toArray()[0]);
}

public static void removeInput(String[] args)  {
    Set<Integer> set = new HashSet<>();
    set.add(1);
    set.add(2);
    set.add(3);
    String line;
    try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
        while((line = br.readLine()) != null) {
            int num = Integer.parseInt(line);
            set.remove(num);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    System.out.println(set.iterator().next());
}

public void removeChild(Node node) {
    children.remove(node);
}

public static void getExtinctSize(String str[]) throws Exception
        {
            try
            {
                Set<String> set=new HashSet<>(Arrays.asList(str));
                set.remove(null);
                System.out.println(set.size());
            }
            catch(Exception e)
            {}
        }

        public static void removeInputPos(String args[]) {
            MyScanner sc = new MyScanner();
            HashSet<Integer> set = new HashSet<Integer>();
            int n = sc.nextInt(), m = sc.nextInt();
            boolean[] selected = new boolean[m];
            for(int i = 0; i < m; i++){
                set.add(i);
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
                        set.remove(j);
                    }
                }
            }
            System.out.println(set.size());
        }

        public static <T> void comb(ArrayList<T> n, Integer r, HashSet<ArrayList<T>> ans) {
            if (n.size() == r) {
                ans.add(n);
                return;
            }
            for (int i = 0; i < n.size(); i++) {
                ArrayList<T> N = new ArrayList<>(n);
                N.remove(i);
                comb(N, r, ans);
            }
        }

        public static void getOddChar(String w) throws Exception {
            Set<String> set = new HashSet<String>();
            for (int i = 0; i < w.length(); i++) {
                String c = String.valueOf(w.charAt(i));
                if (set.contains(c)) {
                    set.remove(c);
                } else {
                    set.add(c);
                }
            }
            if (set.size() == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

        private static void sortNatualOrder(List<Integer> intList) {
            int tmp = intList.get(1);
            if (intList.get(0) > intList.get(1)) {
                intList.set(1, intList.get(0));
                intList.set(0, tmp);
            }
        }

        public static void swap(ArrayList<Integer> ary, int i, int j){
            Integer tmp = ary.get(i);
            ary.set(i, ary.get(j));
            ary.set(j, tmp);
        }
        public static void removeSameSeries(int N, String S ) {
            List<String> arr = new ArrayList<String>();
            for(int i = 0; i < N;i++){
                arr.add(String.valueOf(S.charAt(i)));
            }
            for(int j = 0; j < N-1; j++){
                if(arr.get(j).equals(arr.get(j+1))){
                    arr.set(j, "0");
                }
            }
            arr.removeAll(Arrays.asList("0"));
            System.out.println(arr.size());
        }

        private static <T> void swap(List<T> nums, int i, int j) {
            T temp = nums.get(i);
            nums.set(i,nums.get(j));
            nums.set(j,temp);
        }

        public static void LastPowerK(int k, int[] inputArray) {
            ArrayList<Integer> n = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
              n.add(inputArray[i]);
            }
            Collections.sort(n);
            for (int i = 0; i < k; i++)
              n.set(2, ((Integer) n.get(2) * 2));
            int ans = 0;
            for (Integer num : n)
              ans += num;
            System.out.println(ans);
          }

          public static void countOddValue(int N) {
            int res = 0;
            for(int i = 1; i <= N; i++) {
                String s = String.valueOf(i);
                int len = s.length();
                if(len % 2 != 0) res++;
            }
            System.out.println(res);
        }

        public static void isSize2(String s) {
            Set<String> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                set.add(String.valueOf(c));
            }
            System.out.println(set.size() == 2 ? "Yes" : "No");
        }

        public static void isAABB(String s) {
            List<String> array = new ArrayList<>();
            array.add(String.valueOf(s.charAt(0)));
            array.add(String.valueOf(s.charAt(1)));
            array.add(String.valueOf(s.charAt(2)));
            array.add(String.valueOf(s.charAt(3)));
            Collections.sort(array);
            if (array.get(0).equals(array.get(1)) && !array.get(1).equals(array.get(2)) && array.get(2).equals(array.get(3))) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

        static boolean check(String s) {
            if(s.charAt(0) != 'A')return false;
            boolean flag = false;
            for(int i = 1;i < s.length();i ++) {
                    if(s.charAt(i) != 'C') {
                            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')return false;
                    }
                    else if(flag || i < 2 || s.length() - i < 2)return false;
                    else flag = true;
            }
            return flag;
    }

    static void printBWD(String str, int n) {
        if (n < str.length()) {
            printBWD(str, n + 1);
            System.out.print(str.charAt(n));
        }
        return;
    }

    public static void getReverseWordList(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str, reverse;
        int num;
        while ((str = br.readLine()) != null){
                reverse = "";
                num = str.length();
                char[] word = new char[num];
                for (int i = 0; i < num; i++) {
                        word[i] = str.charAt(i);
                }
                for (int i = num-1; i >=0; i--) {
                        reverse = reverse + word[i];
                }
                System.out.println(reverse);
        }
}

public static void sumStringValue( String s) {
    String r = "";
for(int i=s.length()-1;i>=0;i--){
     r += String.valueOf(s.charAt(i));
}
System.out.println(r);
}

public static void sumStringValue( String str) { 
    String ans="";
    for(int i=1;i<=str.length();i++)
            ans+=str.charAt(str.length()-i);
    System.out.println(ans);

}

public static void reverseLine(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String str = "";
    try {
            while((str = br.readLine()) != "") {
                    for(int i=str.length(); i>0; i--) {
                            sb.append(str.substring(i-1, i));
                    }
                    System.out.println(sb.toString());
            }
    } catch(Exception e) {
            e.getMessage();
    }
}

public static void reverseString(String st) {
    for (int i = st.length() - 1; 0 <= i; i--) {
            System.out.print(st.charAt(i));
    }
}

public static void mergeString(){
    int n;
    String s,t;
    n=nextInt();
    s=next();
    t=next();
    char[] arr = new char[2*n];
    for(int i=0;i<n;i++){
        arr[2*i]=s.charAt(i);
        arr[2*i+1]=t.charAt(i);
    }
    for(char a:arr){
        System.out.printf("%c",a);
    }
}

public static void mergeString(int n, String s, String t) {
    String ans = "";
    for(int i = 0; i < n; i++) {
      String s1 = String.valueOf(s.charAt(i));
      String s2 = String.valueOf(t.charAt(i));
      ans += s1;
      ans += s2;
    }
    System.out.println(ans);
  }

  private String mergeString() {
    String answer = "";
    for (int i=0; i<N; i++) {
            answer += String.valueOf(S.charAt(i));
            answer += String.valueOf(T.charAt(i));
    }
    
    return answer;
}

static int res(String ss, String t) {
    int cnt = 0;
    for(int i=0;i<ss.length();i++) {
        if(ss.charAt(i) != t.charAt(i)) {
            cnt++;
        }
    }
    return cnt;
}

public static void isRepeatedString(String S, String T) {
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i <= S.length()-T.length(); ++i) {
        int cnt = T.length();
        for (int j = 0; j < T.length(); ++j) {
            if (S.charAt(i+j) == T.charAt(j)) {
                --cnt;
            }
        }
        ans = Math.min(ans, cnt);
    }
    System.out.println(ans);
}


public static void isRepeatedString(String s, String t) {
    boolean flag = false;
    for(int i = 0; i < s.length(); i++) {
            if (s.equals(t)){
                    flag = true;
                    break;
            }
            Character c = s.charAt(0);
            s = s.substring(1, s.length()) + c;
    }
    if(flag) {
            System.out.println("Yes");
    }else {
            System.out.println("No");
    }
}

public boolean isRepeated(String s, String t, LightWriter out) {
    for (int i = 0; i <= 100; i++) {
        if (s.equals(t)) {
            return true;
        }
        s = s.substring(1) + s.charAt(0);
    }
    return false;
}

public static String[] toStringArray(String s) {
    String[] tmp = new String[s.length()];
    char[] c = s.toCharArray();
    for (int i = 0; i < tmp.length; i++) {
            tmp[i] = String.valueOf(c[i]);
    }
    return tmp;
}

public static void findFirstNot1(String s, String inputLong) {
    long k = Long.parseLong(inputLong);
    char c[] = s.toCharArray();
    char cs = '1';
    for(int i = 0; i < k; i++){
        if(c[i] != '1'){
            cs = c[i];
            break;
        }
    }
    System.out.println(cs);
}

static char[] nc(String next) {
    return next.toCharArray();
}

public static void isSameString(String s, String nextLine) {
    int    n = Integer.parseInt(nextLine);
    if(n % 2 == 1 || n == 0){
        System.out.println("No");
        return;
    }
    String s1 = s.substring(0  , n/2);
    String s2 = s.substring(n/2, n);
    
    if(s1.startsWith(s2)){
        System.out.println("Yes");
    }
    else{
        System.out.println("No");
    }
}

public static void isOnlyCLower(String s) {
    String sub = s.substring(2,s.length()-1);
    if (s.startsWith("A") && sub.contains("C") && sub.indexOf('C')==sub.lastIndexOf('C')){
            int idxC = sub.indexOf('C')+2;
            for (int i=1;i<s.length(); i++){
                    if (i==idxC) continue;
                    if (Character.isUpperCase(s.charAt(i))) {
                            System.out.println("WA");
                            System.exit(0);
                    }
            }
            System.out.println("AC");
    }else {
            System.out.println("WA");
    }
}

public static void isPrefix(String a , String b){
    System.out.println(b.startsWith(a) ? "Yes" : "No");
  }

  public void addPluralSuffix(int testNumber, MyScanner in, PrintWriter out)
                {
                        String s = in.next();
                        if( s.endsWith("s") )
                        {
                                s += "es";
                        }
                        else
                        {
                                s += "s";
                        }
                        out.println(s);
                }
    
                public static void isStringRepeated2(ArrayDeque<Integer> args1,ArrayDeque<String> args2) {
                    while (in.hasNext()) {
                        int n = args1.peek();
                        args1.pop();
                        String s = args2.peek();
                        args2.pop();
                        if (n % 2 == 1) {
                            System.out.println("No");
                        } else {
                            n /= 2;
                            System.out.println((s.substring(0, n).endsWith(s.substring(n))) ? "Yes" : "No");
                        }
                    }
}

public static void is7Contained(String N) throws IOException {
    if(N.contains("7")){
        System.out.println("Yes");
    }
    else {
        System.out.println("No");
    }
}

public static String checkInf(String S, String K){
    long count = 0;
    for(int i = 0; i < S.length(); i++){
        int val = S.charAt(i) - '0';
        if(val == 1)
            count++;
        else {
            if(K.compareTo(key) > 0 && val == 2){
                while(i < S.length()){
                    int val1 = S.charAt(i) - '0';
                    if(val1 != 1)
                        return String.valueOf((char) ('0' + val));
                    i++;
                }
                return String.valueOf((char) ('0' + val));
            }
            return String.valueOf((char) ('0' + val));
        }
        if(K.compareTo(String.valueOf(count)) == 0)
            return String.valueOf((char)('0' + val));
    }
    return null;
}

public static void countGoodsList(int n, String[] args) {
    String ac="AC";
    long a=0;
    String tle="TLE";
    long t=0;
    String wa="WA";
    long w=0;
    String re="RE";
    long r=0;
    for(int j=0;j<n;j++)
    {
        String s=args[i];
        if(s.compareTo(ac)==0)
            a++;
        else if(s.compareTo(tle)==0)
            t++;
        else if(s.compareTo(wa)==0)
            w++;
        else
            r++;
    }
    System.out.println(ac+ " "+"x"+" "+a);
    System.out.println(wa+ " "+"x"+" "+w);
    System.out.println(tle+ " "+"x"+" "+t);
    System.out.println(re+ " "+"x"+" "+r);
}

public static void countDifferentAtoZ(String str) throws IOException {
    System.out.println(str.lastIndexOf("Z") - str.indexOf("A") + 1);
}

public static void countDifferentAtoZ(String s){
    int ansA = s.indexOf("A");
    int ansB = s.lastIndexOf("Z");
    System.out.println(ansB - ansA + 1);
  }

  public static void isEvenOrOdd(String s) throws IOException {
    if((s.charAt(s.indexOf(" ") - 1) & 1) == 0){
      System.out.println("Even");
    } else if ((s.charAt(s.length() - 1) & 1) == 0) {
      System.out.println("Even");
    } else {
      System.out.println("Odd");
    }
  }

  public static void isOnlyCLower(String S) {
    String result = "WA";
    if("A".equals(S.substring(0,1))) {
            S = S.substring(1);
            if(S.indexOf("C") > 0  && S.indexOf("C") < S.length()-1
                            && S.indexOf("C") == S.lastIndexOf("C")) {
                    S = S.substring(0,S.indexOf("C")) + S.substring(S.indexOf("C")+1);
                    String s = S.toLowerCase();
                    if(S.equals(s)) {
                            result = "AC";
                    }
            }
    }
    System.out.println(result);
}

public static void countDifferentAtoZ(String S) {
    int A = 0;
    int Z = 0;
    A = S.indexOf("A");
    Z = S.lastIndexOf("Z");
    System.out.println(Z-A+1);
}

public static void isSum2Max(String[]args){
    int N = Integer.parseInt(args[0]);
    int m = 0, sum = 0;
    for(int i = 0; i < N; i++){
      int n = Integer.parseInt(args[i+1]);
      sum += n;
      m = m < n ? n : m;
    }
    sum -= m;
    System.out.println(sum > m ? "Yes" : "No");
  }

  public static void isSum2Max(String intLine, String[] args) {
    int n = Integer.parseInt(intLine);
    int[] l = new int[n];
    int max = 0;
    int sum = 0;
    for(int i=0;i<n;i++){
        l[i] = Integer.parseInt(args[i]);
        max = Math.max(max, l[i]);
        sum+=l[i];
    }
    if(sum-max > max){
        System.out.println("Yes");
    }else{
        System.out.println("No");
    }
}

public static void sumNoRemainer(int n) {
    int sum = 0;
    String str[] = String.valueOf(n).split("");
    for (int i=0 ; i < str.length ; i++){
        sum += Integer.parseInt(str[i]);
    }
        System.out.println(n%sum==0?"Yes":"No");
  }

  public long[] nl() throws IOException {
    String[] data = bf.readLine().split(" ");
    long[] send = new long[data.length];
    for (int i = 0, h = data.length; i < h; i++) send[i] = Long.parseLong(data[i]);
    return send;
}

public long l() throws IOException {
    return Long.parseLong(bf.readLine());
}

float nf() {return Float.parseFloat(ns());}

public static void compareQuotient( String str){
    String[] num_str = str.split(" ");
    if(Float.parseFloat(num_str[0]) / Float.parseFloat(num_str[1]) <= Float.parseFloat(num_str[2])){
            System.out.println("Yes");
    }else{
            System.out.println("No");
    }
}

public double nextDouble() {
    return Double.parseDouble(next());
}
}
