using System;

namespace Parallel_Csharp.Parallel.Numbers;

public class Numbers {
    public  double Calculate(double base1, double n) {
        return Math.Pow(Math.E, Math.Log(base1)/n);
    }
    
    public double GetDegree(int x, int a, int b){
        if((double)2*x/(a*a)-b>=0){
            double bb=((double)2*x)/(a*a)-b;
            return (Math.Atan((-bb+b)/a)*180/Math.PI);
        }
        else{
            double aa=((double)2*x)/(a*b);
            return (Math.Atan(((double)b)/aa)*180/Math.PI);
        }
    }
    
    public double Func1(int A, int B, int H, int M){
        double Ax = A * Math.Sin(Math.PI * ((60 * H) + M) / 360);
        double Ay = A * Math.Cos(Math.PI * ((60 * H) + M) / 360);

        double Bx = B * Math.Sin(Math.PI * M / 30);
        double By = B * Math.Cos(Math.PI * M / 30);

        double d_square = (Ax - Bx) * (Ax - Bx) + (Ay - By) * (Ay - By);
        double d = Math.Sqrt(d_square);
        return d;
    }
    
    public void Func2(double x){
        double c = x * x * Math.PI;
        double squ = 2 * Math.PI * x;
        Console.WriteLine($"{c} {squ}");
    }
    
    public void Floyd(int[][] wts) {
        for (int in1 = 0; in1 < wts.Length; in1++) {
            for (int src = 0; src < wts.Length; src++) {
                for (int dest = 0; dest < wts.Length; dest++) {
                    if (in1 != src && in1 != dest && src != dest && wts[in1][dest] != int.MaxValue
                        && wts[src][in1] != int.MaxValue) {
                        if (wts[src][in1] + wts[in1][dest] < wts[src][dest]) {
                            wts[src][dest] = wts[src][in1] + wts[in1][dest];
                        }
                    }
                }
            }
        }
    }
    
    public void UseFloyd()
    {
        int[][] wts = new int [4][];
        wts[0] = new int[4] { int.MaxValue, 2, 8, 10 };
        wts[1] = new int[4] { int.MaxValue, int.MaxValue, 3, 7 };
        wts[2] = new int[4] { int.MaxValue, int.MaxValue, int.MaxValue, 1 };
        wts[3] = new int[4] { int.MaxValue, int.MaxValue, int.MaxValue, int.MaxValue };
        for (int i = 0; i < wts.Length; i++) {
            for (int j = 0; j < wts[0].Length; j++) {
                if (wts[i][j] == int.MaxValue) {
                    Console.Write("NO\t");
                } else {
                    Console.Write(wts[i][j] + "\t");
                }
            }
            Console.WriteLine();
        }
        Floyd(wts);
        Console.WriteLine();
        // Display again
        for (int i = 0; i < wts.Length; i++) {
            for (int j = 0; j < wts[0].Length; j++) {
                if (wts[i][j] == int.MaxValue) {
                    Console.Write("NO\t");
                } else {
                    Console.Write(wts[i][j] + "\t");
                }
            }
            Console.WriteLine();
        }
    }
    
    public int OpNums(int leftVal, int rightVal, String op){
        int result;
        if (op.Equals("+"))
            result = leftVal + rightVal;
        else if (op.Equals("-"))
            result = leftVal - rightVal;
        else if (op.Equals("*"))
            result = leftVal * rightVal;
        else if (op.Equals("/"))
            result = leftVal / rightVal;
        else
            result = int.MinValue;
        return result;
    }
    
    public bool VerifyMinInteger(){
        int i1 = int.MinValue;
        int i = Convert.ToInt32(-Math.Pow(2.0, 31.0));
        return i.Equals(i1);
    }
    
    public short GetShortMax(short[] pixelArray) {
        short max = short.MinValue;
        foreach (short v in pixelArray) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    public short GetShortMin(short[] pixelArray) {
        short min = short.MaxValue;
        foreach (short v in pixelArray) {
            if (v < min) {
                min = v;
            }
        }
        return min;
    }
    
    private long CalcStatPoolNode(long v, int displacement) {
        if (v > short.MaxValue) {
            v = short.MaxValue;
        } else if (v < short.MinValue) {
            v = short.MinValue;
        }
        return ((v & 0x0FFFF) << displacement);
    }
    
    public long getLongMax(long[] pixelArray) {
        long max = long.MinValue;
        foreach (long v in pixelArray) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    public long getLongMin(long[] pixelArray) {
        long min = long.MaxValue;
        foreach (long v in pixelArray) {
            if (v < min) {
                min = v;
            }
        }
        return min;
    }
    
    // Normalisation of RGB values from (0,...,255) to (-128,...,127)
    public byte[] RGBPixel(short red, short green, short blue) {
        byte r = (byte) (red + byte.MinValue);
        byte g = (byte) (green + byte.MinValue);
        byte b = (byte) (blue + byte.MinValue);
        byte[] rgb = {r, g, b};

        return rgb;
    }
    
    public void Write(byte b){}
    public void WritePackedInt(int value) {
        if (value <= 240) {
            Write((byte) value);
        } else if (value <= 2287) {
            Write((byte) ((value - 240) / 256 + 241));
            Write((byte) ((value - 240) % 256));
        } else if (value <= 67823) {
            Write((byte) 249);
            Write((byte) ((value - 2288) / 256));
            Write((byte) ((value - 2288) % 256));
        } else if (value <= 16777215) {
            Write((byte) 250);
            Write((byte) (value & byte.MaxValue));
            Write((byte) ((value >> 8) & byte.MaxValue));
            Write((byte) ((value >> 16) & byte.MaxValue));
        } else {
            Write((byte) 251);
            Write((byte) (value & byte.MaxValue));
            Write((byte) ((value >> 8) & byte.MaxValue));
            Write((byte) ((value >> 16) & byte.MaxValue));
            Write((byte) ((value >> 24) & byte.MaxValue));
        }
    }
    
    public void Dijkstra(int v, float[][] a, float[] dist, int[] prev){
        int n = dist.Length - 1;
        if(v < 1 || v > n)
            return;
        bool[] s = new bool[n + 1];
		
        for(int i = 1; i <= n; i++){
            dist[i] = a[v - 1][i - 1];
            s[i] = false;
            if(dist[i] == float.MaxValue)
                prev[i] = 0;
            else
                prev[i] = v;
        }
        dist[v] = 0;
        s[v] = true;
        for(int i = 1; i < n; i++)
        {
            float temp = float.MaxValue;
            int u = v;
            for(int j = 1; j <= n; j++)
            {
                if(!s[j] && dist[j] < temp)
                {
                    u = j;
                    temp = dist[j];
                }
            }
            s[u] = true;
            for(int j = 1; j <= n; j++){
                if(!s[j] && a[u - 1][j - 1] < float.MaxValue){
                    float newDist = dist[u] + a[u - 1][j - 1];
                    if(newDist < dist[j])
                    {
                        dist[j] = newDist;
                        prev[j] = u;
                    }
                }
            }// end for 找到最小距离加入S并更新其他距离值
        }//end for
    }
    
    public double[] GetT(double phi,double xc, double xpc, double xMin,
        double xMax, double yMin, double yMax){
        double coefX = Math.Sin( Math.PI * phi / 180.0 );
        double coefY = Math.Cos( Math.PI * phi / 180.0 );

        //top right corner
        double[] t = new double[4];
        t[0] = double.MaxValue;
        if ( coefY != 0.0 ) {
            t[0] = ( yMax - xpc ) / coefY;
        }
        t[1] = double.MaxValue;
        if ( coefX != 0.0 ) {
            t[1] = ( xMax - xc ) / coefX;
        }
        t[2] = double.MaxValue;
        if ( coefY != 0.0 ) {
            t[2] = ( yMin - xpc ) / coefY;
        }
        t[3] = double.MaxValue;
        if ( coefX != 0.0 ) {
            t[3] = ( xMin - xc ) / coefX;
        }
        return t;
    }
    
    public double[] GetRealRotatedLimits( double []t, double phi, double xc, double xpc) {
        double coefX = Math.Sin( Math.PI * phi / 180 );
        double coefY = Math.Cos( Math.PI * phi / 180 );
        
        double tTR = double.MaxValue;
        for ( int i = 0; i < 4; i++ ) {
            if ( Math.Abs( tTR ) > Math.Abs( t[i] ) ) {
                tTR = t[i];
            }
        }

        double tBL = double.MaxValue;
        for ( int i = 0; i < 4; i++ ) {
            if ( tTR * t[i] < 0.0 && Math.Abs( tBL ) > Math.Abs( t[i] ) ) {
                tBL = t[i];
            }
        }
        if ( tBL > 0.0 ) {
            double tmp = tBL;
            tBL = tTR;
            tTR = tmp;
        }
        double[] arr = new double[4];
        arr[0] = xc + coefX * tBL;
        arr[1] = xpc + coefY * tBL;
        arr[2] = xc + coefX * tTR;
        arr[3] = xpc + coefY * tTR;
        return arr;
    }
}