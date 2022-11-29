package parallel.cmath;

import java.util.ArrayList;
import java.util.List;

public class Cmath {
    public List<Integer> randomColor(){
        List<Integer> list = new ArrayList<Integer>();
        int r = (int)(Math.random()*255)+1;
        int g = (int)(Math.random()*255)+1;
        int b = (int)(Math.random()*255)+1;
        list.add(r);
        list.add(g);
        list.add(b);
        return list;
    }

    public double absRemainder(double a, double b){
        double absA = Math.abs(a);
        double absB = Math.abs(b);
        return absA % absB;
    }

    public double absIEEERemainder(double a, double b){
        double absA = Math.abs(a);
        double absB = Math.abs(b);
        return Math.IEEEremainder(absA, absB);
    }

    // calculate a * (e^b) +c
    public double expFmaDouble(double a, double b, double c){
        double d = Math.exp(b);
        return Math.fma(a, d, c);
    }

    public float expFmaFloat(float a, float b, float c){
        Double d = Math.exp(b);
        Double result = Math.fma(a, d, c);
        return result.floatValue();
    }

    public double hyperbolicSin(double a){
        double ex = Math.exp(a);
        double e_x = Math.exp(-a);
        return 0.5 * (ex - e_x);
    }

    public double hyperbolicCos(double a){
        double ex = Math.exp(a);
        double e_x = Math.exp(-a);
        return 0.5 * (ex + e_x);
    }

    public double hyperbolicTan(double a){
        double ex = Math.exp(a);
        double e_x = Math.exp(-a);
        return (ex - e_x)/(ex + e_x);
    }

    // log b A
    public double logbA(double a, double b){
        return Math.log(a)/Math.log(b);
    }

    // log b A
    public double log10bA(double a, double b){
        return Math.log10(a) / Math.log10(b);
    }

    public double sqrtSquareSumThree(double x, double y, double z){
        double a = Math.hypot(x, y);
        double b = Math.hypot(a, z);
        return b;
    }

    // ln(x + (x^2+1)^+1)
    public double asinh(double x){
        return Math.log(x + Math.hypot(x, 1.0));
    }

    public double acosh(double x){
        return Math.log(x + Math.sqrt(x * x - 1.0));
    }

    public double atanh(double x){
        return 0.5 * Math.log((x+1.0) / (x-1.0));
    }


    // sin(a+b)
    public double sinSum(double a, double b){
        double c = Math.sin(a) * Math.cos(b);
        double d = Math.cos(a) * Math.sin(b);
        return c+d;
    }

    // cos(a+b)
    public double cosSum(double a, double b){
        double c = Math.cos(a) * Math.cos(b);
        double d = Math.sin(a) * Math.sin(b);
        return c-d;
    }

    // tan(a+b)
    public double tanSum(double a, double b){
        double c = Math.tan(a);
        double d = Math.tan(b);
        return (c + d)/(1.0 - c * d);
    }

    // relu
    public double relu(double x){
        return Math.max(0.0, x);
    }

    // sigmoid
    public double sigmoid(double x){
        double y = Math.exp(-x);
        return Math.pow(y+1, -1);
    }

    // e^x-1-x
    public double expm1MinusX(double x){
        double a = Math.expm1(x);
        return a-x;
    }

    // ln(1+x) - x
    public double log1pMinusX(double x){
        double a = Math.log1p(x);
        return a-x;
    }

    // (x^3 + y^3 + z^3)^-3
    public double cbrtCubicThreeSum(double x, double y, double z){
        double a = Math.pow(x, 3);
        double b = Math.pow(y, 3);
        double c = Math.pow(z, 3);
        return Math.cbrt(a+b+c);
    }

    public double toPolarDegree(double x, double y){
        return Math.atan2(x, y)/Math.PI * 180.0;
    }

    public void toPolar(double a, double b){
        double distance = Math.log( Math.hypot( a, b ));
        double degree = Math.atan2( b, a );

        System.out.printf("Distance: %f, Angle: %f %n", distance, degree);
    }

    // arcsin(x + y) - (x^2 + y^2)^-1
    public double operation1(double x, double y){
        double a = Math.asin(x + y);
        double b = Math.pow(x * x + y * y, -1);
        return a-b;
    }

    // arccos(x + y) - (x^2 + y^2)^-1
    public double operation2(double x, double y){
        double a = Math.acos(x + y);
        double b = Math.pow(x * x + y * y, -1);
        return a-b;
    }

    // arctan(x + y) - (x^2 + y^2)^-1
    public double operation3(double x, double y){
        double a = Math.atan(x + y);
        double b = Math.pow(x * x + y * y, -1);
        return a-b;
    }

    public double operation4(double x){
        double rcs = x/Math.pow(10,Math.floor(Math.log10(Math.abs(x)))-(3-1));
        rcs = Math.round(rcs);
        return rcs;
    }

    public double operation5Sin(double x, double y, double z){
        double u = Math.sin(Math.sqrt(2) * Math.PI * x)
                * Math.sinh(Math.PI * y) * Math.sinh(Math.PI * z);
        return u;
    }
    public double operation5Cos(double x, double y, double z){
        double u = Math.cos(Math.sqrt(2) * Math.PI * x)
                * Math.cosh(Math.PI * y) * Math.cosh(Math.PI * z);
        return u;
    }
    public double operation5Tan(double x, double y, double z){
        double u = Math.tanh(Math.sqrt(2) * Math.PI * x)
                * Math.tanh(Math.PI * y) * Math.tanh(Math.PI * z);
        return u;
    }

    public int operation6(int a, int b){
        double c = Math.log10(a+b)+1;
        return (int)Math.floor(c);
    }

    public boolean operation7(String scLine){
        double[] incomingDouble = new double[3];
        int first = scLine.indexOf(" ");
        int second = scLine.lastIndexOf(" ");
        double current = 0;

        incomingDouble[0] = Double.parseDouble(scLine.substring(0, first));
        incomingDouble[1] = Double.parseDouble(scLine.substring(first + 1, second));
        incomingDouble[2] = Double.parseDouble(scLine.substring(second + 1));

        if(Math.ceil(incomingDouble[0]/incomingDouble[2]) <= incomingDouble[1]){
            return true;
        }
        else{
            return false;
        }
    }

    public double operation8(int[] arr, int K){
        double max = 1.0 + arr[0] - arr[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            max = Double.max(max, arr[i + 1] - arr[i]);
        }
        return Math.round((1 - max) * K);
    }

    public float operation9(int i){
        float powerOfTwo   = Math.scalb(1.0f, i);
        float neighborDown = Math.nextDown(powerOfTwo);
        float neighborUp   = Math.nextUp(powerOfTwo);
        return neighborUp + neighborDown;
    }

    public double Operation10(double a, double b, double c, double d)
    {
        double e;
        double f;
        if (a == 0.0 && b == 0.0 || c == 0.0 && d == 0.0 || Double.isInfinite(c) && Double.isInfinite(d))
        {
            c = Math.copySign(1.0, c);
            d = Math.copySign(1.0, d);
            e = a * c + b * d;
            f = b * c - a * d;
            return e + f;
        }
        return 0.0;
    }


    public float roundDigits(float i, int j) {
        double ten = Math.pow(10, j);
        return (float) (Math.round(i * ten) / ten);
    }

    public void toTime(int x){
        int hour = (int)Math.ceil(x / 3600);
        int minutes = (int)Math.ceil((x - hour * 3600 ) / 60);
        int second = (x - hour * 3600 - minutes * 60);
        System.out.println(hour + ":" + minutes + ":" +second);
    }



    public String generateText(int length, char[] lowercaseLetters,
                               char[] uppercaseLetters, char[]symbols){
        String generatedText = "";
        for (int i = 0; i < length; i++) {
            // Randomly choose 1 of the 4 arrays to add text to the end result String
            int array = (int) Math.ceil(Math.random() * 3);
            int characterIndex = 0;
            if (array == 1) {
                // Pick random character from the lowercase array to add to the end result
                // String
                characterIndex = (int) Math.ceil(Math.random() * (lowercaseLetters.length - 1));
                generatedText += lowercaseLetters[characterIndex];
            } else if (array == 2) {
                // Pick random character from the uppercase array to add to the end result
                // String
                characterIndex = (int) Math.ceil(Math.random() * (uppercaseLetters.length - 1));
                generatedText += uppercaseLetters[characterIndex];
            } else if (array == 3) {
                // Pick random symbol from the symbols array to add to the end result String
                characterIndex = (int) Math.ceil(Math.random() * (symbols.length - 1));
                generatedText += symbols[characterIndex];
            }
        }
        return generatedText;
    }

    public int calculateDebt(int n){
        double debt = 100000;
        for(int i=0; i<n; i++) {
            debt *= 1.05;
            if(debt % 1000 != 0) {
                debt = (Math.floor(debt/1000)+1)*1000;
            }
            else {
                debt = Math.floor(debt);
            }
        }
        return (int)debt;
    }

    public boolean binarySearch(int key, int n, int[] s) {
        int left = 0;
        int right = n;
        int mid;
        while (left < right) {
            mid = (int) Math.floor((right + left) / 2.0);
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

    public boolean isInteger(double number)
    {return Math.ceil(number) == Math.floor(number); }

    public double getCircumference(double r){
        double res = Math.round(2 * 3.1415*r*100)/100.0;
        return res;
    }

    public void ExampleScaleB()
    {
        double x, result;
        int n;
        x = 3;
        n = 2;
        result = Math.scalb(x, n);
        System.out.println(String.format("ScaleB(%f, %d) = %f", x, n, result));

        x = 5;
        n = 4;
        result = Math.scalb(x, n);
        System.out.println(String.format("ScaleB(%f, %d) = %f", x, n, result));
    }

    public double finiteSum(double a, double b){
        if(Double.isNaN(a) || Double.isNaN(b)){
            return -0.0;
        }
        if(Double.isFinite(a) && Double.isFinite(b)){
            double result = a + b;
            return Double.isFinite(result)? result : -0.0;
        }
        return -0.0;
    }
}
