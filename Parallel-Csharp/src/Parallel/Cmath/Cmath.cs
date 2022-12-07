using System;
using System.Collections.Generic;

namespace Parallel_Csharp.Parallel.Cmath;

public class Cmath {
    public List<int> RandomColor()
    {
        Random random = new Random();
        int r = (int)(random.NextDouble() * 255) + 1;
        int g = (int)(random.NextDouble() * 255) + 1;
        int b = (int)(random.NextDouble() * 255) + 1;
        List<int> list = new List<int>();
        list.Add(r);
        list.Add(g);
        list.Add(b);
        return list;
    }
    
    public double AbsRemainder(double a, double b){
        double absA = Math.Abs(a);
        double absB = Math.Abs(b);
        return absA % absB;
    }
    
    public double AbsIEEERemainder(double a, double b){
        double absA = Math.Abs(a);
        double absB = Math.Abs(b);
        return Math.IEEERemainder(absA, absB);
    }
    
    // calculate a * (e^b) +c
    public double ExpFmaDouble(double a, double b, double c)
    {
        double d = Math.Exp(b);
        return Math.FusedMultiplyAdd(a, d, c);
    }
    
    public float ExpFmaFloat(float a, float b, float c)
    {
        double d = Math.Exp(b);
        return (float)Math.FusedMultiplyAdd(a, d, c);
    }

    public double HyperbolicSin(double a)
    {
        double ex = Math.Exp(a);
        double e_x = Math.Exp(-a);
        return 0.5 * (ex - e_x);
    }
    
    public double HyperbolicCos(double a)
    {
        double ex = Math.Exp(a);
        double e_x = Math.Exp(-a);
        return 0.5 * (ex + e_x);
    }
    
    public double HyperbolicTan(double a)
    {
        double ex = Math.Exp(a);
        double e_x = Math.Exp(-a);
        return (ex - e_x) / (ex + e_x);
    }
    
    // log b A using lo
    public double LogbA(double a, double b){
        return Math.Log(a)/Math.Log(b);
    }
    
    // log b A using log10
    public double Log10bA(double a, double b){
        return Math.Log10(a)/Math.Log10(b);
    }
    
    public double SqrtSquareSumThree(double x, double y, double z)
    {
        double a = Math.Sqrt(x * x + y * y + z * z);
        return a;
    }

    public double Asinh(double x)
    {
        return Math.Asinh(x);
    }

    public double Acosh(double x)
    {
        return Math.Acosh(x);
    }

    public double Atanh(double x)
    {
        return Math.Atanh(x);
    }

    // sin(a+b)
    public double SinSum(double a, double b)
    {
        double c = Math.Sin(a) * Math.Cos(b);
        double d = Math.Cos(a) * Math.Sin(b);
        return c + d;
    }
    
    // cos(a+b)
    public double CosSum(double a, double b)
    {
        double c = Math.Cos(a) * Math.Cos(b);
        double d = Math.Sin(a) * Math.Sin(b);
        return c - d;
    }
    
    // tan(a+b)
    public double TanSum(double a, double b){
        double c = Math.Tan(a);
        double d = Math.Tan(b);
        return (c + d)/(1.0 - c * d);
    }
    
    // relu
    public double Relu(double x)
    {
        return Math.Max(0.0, x);
    }
    
    // sigmoid
    public double Sigmoid(double x){
        double y = Math.Exp(-x) + 1;
        return Math.Pow(y, -1);
    }
    
    // e^x-1-x
    public double Expm1MinusX(double x)
    {
        double a = Math.Exp(x) - 1;
        return a - x;
    }
    
    public double log1pMinusX(double x){
        double a = Math.Log(x + 1.0);
        return a-x;
    }
    
    // (x^3 + y^3 + z^3)^-3
    public double CbrtCubicThreeSum(double x, double y, double z){
        double a = Math.Pow(x, 3);
        double b = Math.Pow(y, 3);
        double c = Math.Pow(z, 3);
        return Math.Cbrt(a+b+c);
    }
    
    public double ToPolarDegree(double x, double y)
    {
        return Math.Atan2(x, y) / Math.PI * 180.0;
    }
    
    public void ToPolar(double a, double b){
        double distance = Math.Log( Math.Sqrt(a * a + b * b));
        double degree = Math.Atan2( b, a );
        
        Console.WriteLine($"Distance: {distance}, Angle: {degree} %n");
    }

    // arcsin(x + y) - (x^2 + y^2)^-1
    public double Operation1(double x, double y){
        double a = Math.Asin(x + y);
        double b = Math.Pow(x * x + y * y, -1);
        return a-b;
    }
    
    // arccos(x + y) - (x^2 + y^2)^-1
    public double Operation2(double x, double y){
        double a = Math.Acos(x + y);
        double b = Math.Pow(x * x + y * y, -1);
        return a-b;
    }
    
    // arctan(x + y) - (x^2 + y^2)^-1
    public double Operation3(double x, double y){
        double a = Math.Atan(x + y);
        double b = Math.Pow(x * x + y * y, -1);
        return a-b;
    }

    public double Operation4(double x){
        double rcs = x/Math.Pow(10,Math.Floor(Math.Log10(Math.Abs(x)))-(3-1));
        rcs = Math.Round(rcs);
        return rcs;
    }
    
    public double Operation5Sin(double x, double y, double z){
        double u = Math.Sin(Math.Sqrt(2) * Math.PI * x)
                   * Math.Sinh(Math.PI * y) * Math.Sinh(Math.PI * z);
        return u;
    }
    public double Operation5Cos(double x, double y, double z){
        double u = Math.Cos(Math.Sqrt(2) * Math.PI * x)
                   * Math.Cosh(Math.PI * y) * Math.Cosh(Math.PI * z);
        return u;
    }
    public double Operation5Tan(double x, double y, double z){
        double u = Math.Tanh(Math.Sqrt(2) * Math.PI * x)
                   * Math.Tanh(Math.PI * y) * Math.Tanh(Math.PI * z);
        return u;
    }
    
    public int Operation6(int a, int b){
        double c = Math.Log10(a+b)+1;
        return (int)Math.Floor(c);
    }
    
    public bool Operation7(String scLine){
        double[] incomingDouble = new double[3];
        int first = scLine.IndexOf(" ");
        int second = scLine.LastIndexOf(" ");
        double current = 0;

        incomingDouble[0] = Double.Parse(scLine.Substring(0, first));
        incomingDouble[1] = Double.Parse(scLine.Substring(first + 1, second-first));
        incomingDouble[2] = Double.Parse(scLine.Substring(second + 1));

        if(Math.Ceiling(incomingDouble[0]/incomingDouble[2]) <= incomingDouble[1]){
            return true;
        }
        else{
            return false;
        }
    }
    
    public double Operation8(int[] arr, int K){
        double max = 1.0 + arr[0] - arr[arr.Length - 1];
        for (int i = 0; i < arr.Length - 1; i++) {
            max = Double.Max(max, arr[i + 1] - arr[i]);
        }
        return Math.Round((1 - max) * K);
    }
    
    public float Operation9(int i){
        float powerOfTwo   = (float)Math.ScaleB(1.0f, i);
        float neighborDown = (float)Math.BitDecrement(powerOfTwo);
        float neighborUp   = (float)Math.BitIncrement(powerOfTwo);
        return neighborUp + neighborDown;
    }
    
    public double Operation10(double a, double b, double c, double d)
    {
        double e;
        double f;
        if (a == 0.0 && b == 0.0 || c == 0.0 && d == 0.0 || Double.IsInfinity(c) && Double.IsInfinity(d))
        {
            c = Math.CopySign(1.0, c);
            d = Math.CopySign(1.0, d);
            e = a * c + b * d;
            f = b * c - a * d;
            return e + f;
        }
        return 0.0;
    }

    public float RoundDigits(float i, int j) {
        double ten = Math.Pow(10, j);
        return (float) (Math.Round(i * ten) / ten);
    }
    
    public void ToTime(int x){
        int hour = (int)Math.Ceiling(1.0 * x / 3600);
        int minutes = (int)Math.Ceiling((1.0 * x - hour * 3600 ) / 60);
        int second = (x - hour * 3600 - minutes * 60);
        Console.WriteLine(hour + ":" + minutes + ":" +second);
    }

    public String GenerateText(int length, char[] lowercaseLetters,
        char[] uppercaseLetters, char[]symbols){
        String generatedText = "";
        Random random = new Random(0);
        for (int i = 0; i < length; i++) {
            // Randomly choose 1 of the 4 arrays to add text to the end result String
            int array = (int) Math.Ceiling(random.NextDouble() * 3);
            int characterIndex = 0;
            if (array == 1) {
                // Pick random character from the lowercase array to add to the end result
                // String
                characterIndex = (int) Math.Ceiling(random.NextDouble() * (lowercaseLetters.Length - 1));
                generatedText += lowercaseLetters[characterIndex];
            } else if (array == 2) {
                // Pick random character from the uppercase array to add to the end result
                // String
                characterIndex = (int) Math.Ceiling(random.NextDouble() * (uppercaseLetters.Length - 1));
                generatedText += uppercaseLetters[characterIndex];
            } else if (array == 3) {
                // Pick random symbol from the symbols array to add to the end result String
                characterIndex = (int) Math.Ceiling(random.NextDouble() * (symbols.Length - 1));
                generatedText += symbols[characterIndex];
            }
        }
        return generatedText;
    }
    
    public int CalculateDebt(int n){
        double debt = 100000;
        for(int i=0; i<n; i++) {
            debt *= 1.05;
            if(debt % 1000 != 0) {
                debt = (Math.Floor(debt/1000)+1)*1000;
            }
            else {
                debt = Math.Floor(debt);
            }
        }
        return (int)debt;
    }
    
    
    public bool BinarySearch(int key, int n, int[] s) {
        int left = 0;
        int right = n;
        int mid;
        while (left < right) {
            mid = (int) Math.Floor((right + left) / 2.0);
            if (s[mid] == key) {
                return true;
            } else if (key < s[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
    
    public bool IsInteger(double number)
    {return Math.Ceiling(number) == Math.Floor(number); }
    
    public double GetCircumference(double r){
        double res = Math.Round(2 * 3.1415*r*100)/100.0;
        return res;
    }
    
    public void ExampleScaleB()
    {
        double x, result;
        Int32 n;
        x = 3;
        n = 2;
        result = Math.ScaleB(x, n);
        Console.WriteLine($"ScaleB({x}, {n}) = {result}");
 
        x = 5;
        n = 4;
        result = Math.ScaleB(x, n);
        Console.WriteLine($"ScaleB({x}, {n}) = {result}");
    }

    public double FiniteSum(double a, double b){
        if(Double.IsNaN(a) || Double.IsNaN(b)){
            return -0.0;
        }
        if(Double.IsFinite(a) && Double.IsFinite(b)){
            double result = a + b;
            return Double.IsFinite(result)? result : -0.0;
        }
        return -0.0;
    }
}