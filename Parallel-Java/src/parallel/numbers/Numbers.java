package parallel.numbers;

public class Numbers {
    public double calculate(Double base, Double n) {
        return Math.pow(Math.E, Math.log(base)/n);
    }

    public double getDegree(int x, int a, int b){
        if((double)2*x/(a*a)-b>=0){
            double bb=((double)2*x)/(a*a)-b;
            return (Math.atan((-bb+b)/a)*180/Math.PI);
        }
        else{
            double aa=((double)2*x)/(a*b);
            return (Math.atan(((double)b)/aa)*180/Math.PI);
        }
    }

    public double func1(int A, int B, int H, int M){
        double Ax = A * Math.sin(Math.PI * ((60 * H) + M) / 360);
        double Ay = A * Math.cos(Math.PI * ((60 * H) + M) / 360);

        double Bx = B * Math.sin(Math.PI * M / 30);
        double By = B * Math.cos(Math.PI * M / 30);

        double d_square = (Ax - Bx) * (Ax - Bx) + (Ay - By) * (Ay - By);
        double d = Math.sqrt(d_square);
        return d;
    }

    public void func2(double x){
        double c = x * x * Math.PI;
        double squ = 2 * Math.PI * x;
        System.out.printf("%1.6f %1.6f", c, squ);
    }

    public void floyd(int[][] wts) {
        for (int in = 0; in < wts.length; in++) {
            for (int src = 0; src < wts.length; src++) {
                for (int dest = 0; dest < wts.length; dest++) {
                    if (in != src && in != dest && src != dest && wts[in][dest] != Integer.MAX_VALUE
                            && wts[src][in] != Integer.MAX_VALUE) {
                        if (wts[src][in] + wts[in][dest] < wts[src][dest]) {
                            wts[src][dest] = wts[src][in] + wts[in][dest];
                        }
                    }
                }
            }
        }
    }

    public void useFloyd() {
        int[][] wts = { { Integer.MAX_VALUE, 2, 8, 10 }, { Integer.MAX_VALUE, Integer.MAX_VALUE, 3, 7 },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 1 },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE } };
        for (int i = 0; i < wts.length; i++) {
            for (int j = 0; j < wts[0].length; j++) {
                if (wts[i][j] == Integer.MAX_VALUE) {
                    System.out.print("NO\t");
                } else {
                    System.out.print(wts[i][j] + "\t");
                }
            }
            System.out.println();
        }
        floyd(wts);
        System.out.println();
        // Display again
        for (int i = 0; i < wts.length; i++) {
            for (int j = 0; j < wts[0].length; j++) {
                if (wts[i][j] == Integer.MAX_VALUE) {
                    System.out.print("NO\t");
                } else {
                    System.out.print(wts[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    public int opNums(int leftVal, int rightVal, String op){
        int result;
        if (op.equals("+"))
            result = leftVal + rightVal;
        else if (op.equals("-"))
            result = leftVal - rightVal;
        else if (op.equals("*"))
            result = leftVal * rightVal;
        else if (op.equals("/"))
            result = leftVal / rightVal;
        else
            result = Integer.MIN_VALUE;
        return result;
    }

    public boolean verifyMinInteger(){
        Integer i1 =Integer.MIN_VALUE;
        Integer i = Double.valueOf(-Math.pow(2.0, 31.0)).intValue();
        return i.equals(i1);
    }

    public short getShortMax(short[] pixelArray) {
        short max = Short.MIN_VALUE;
        for (short v : pixelArray) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    public short getShortMin(short[] pixelArray) {
        short min = Short.MAX_VALUE;
        for (short v : pixelArray) {
            if (v < min) {
                min = v;
            }
        }
        return min;
    }

    private long calcStatPoolNode(long v, int displacement) {
        if (v > Short.MAX_VALUE) {
            v = Short.MAX_VALUE;
        } else if (v < Short.MIN_VALUE) {
            v = Short.MIN_VALUE;
        }
        return ((v & 0x0FFFF) << displacement);
    }

    public long getLongMax(long[] pixelArray) {
        long max = Long.MIN_VALUE;
        for (long v : pixelArray) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    public long getLongMin(long[] pixelArray) {
        long min = Long.MAX_VALUE;
        for (long v : pixelArray) {
            if (v < min) {
                min = v;
            }
        }
        return min;
    }

    // Normalisation of RGB values from (0,...,255) to (-128,...,127)
    public byte[] RGBPixel(short red, short green, short blue) {
        byte r = (byte) (red + Byte.MIN_VALUE);
        byte g = (byte) (green + Byte.MIN_VALUE);
        byte b = (byte) (blue + Byte.MIN_VALUE);
        byte[] rgb = {r, g, b};

        return rgb;
    }

    public void write(byte b){}
    public void writePackedInt(int value) {
        if (value <= 240) {
            write((byte) value);
        } else if (value <= 2287) {
            write((byte) ((value - 240) / 256 + 241));
            write((byte) ((value - 240) % 256));
        } else if (value <= 67823) {
            write((byte) 249);
            write((byte) ((value - 2288) / 256));
            write((byte) ((value - 2288) % 256));
        } else if (value <= 16777215) {
            write((byte) 250);
            write((byte) (value & Byte.MAX_VALUE));
            write((byte) ((value >> 8) & Byte.MAX_VALUE));
            write((byte) ((value >> 16) & Byte.MAX_VALUE));
        } else {
            write((byte) 251);
            write((byte) (value & Byte.MAX_VALUE));
            write((byte) ((value >> 8) & Byte.MAX_VALUE));
            write((byte) ((value >> 16) & Byte.MAX_VALUE));
            write((byte) ((value >> 24) & Byte.MAX_VALUE));
        }
    }

    public void dijkstra(int v, float[][] a, float[] dist, int[] prev){
        int n = dist.length - 1;
        if(v < 1 || v > n)
            return;
        boolean[] s = new boolean[n + 1];

        for(int i = 1; i <= n; i++){
            dist[i] = a[v - 1][i - 1];
            s[i] = false;
            if(dist[i] == Float.MAX_VALUE)
                prev[i] = 0;
            else
                prev[i] = v;
        }
        dist[v] = 0;
        s[v] = true;
        for(int i = 1; i < n; i++)
        {
            float temp = Float.MAX_VALUE;
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
                if(!s[j] && a[u - 1][j - 1] < Float.MAX_VALUE){
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

    public double[] getRealRotatedLimits( double phi, double xc, double xpc, double xMin,
                                          double xMax, double yMin, double yMax) {
        double coefX = Math.sin( Math.PI * phi / 180. );
        double coefY = Math.cos( Math.PI * phi / 180. );

        //top right corner
        double[] t = new double[4];
        t[0] = Double.MAX_VALUE;
        if ( coefY != 0. ) {
            t[0] = ( yMax - xpc ) / coefY;
        }
        t[1] = Double.MAX_VALUE;
        if ( coefX != 0. ) {
            t[1] = ( xMax - xc ) / coefX;
        }
        t[2] = Double.MAX_VALUE;
        if ( coefY != 0. ) {
            t[2] = ( yMin - xpc ) / coefY;
        }
        t[3] = Double.MAX_VALUE;
        if ( coefX != 0. ) {
            t[3] = ( xMin - xc ) / coefX;
        }

        double tTR = Double.MAX_VALUE;
        int iTR = -1;
        for ( int i = 0; i < 4; i++ ) {
            if ( Math.abs( tTR ) > Math.abs( t[i] ) ) {
                iTR = i;
                tTR = t[i];
            }
        }

        double tBL = Double.MAX_VALUE;
        int iBL = -1;
        for ( int i = 0; i < 4; i++ ) {
            if ( tTR * t[i] < 0. && Math.abs( tBL ) > Math.abs( t[i] ) ) {
                iBL = i;
                tBL = t[i];
            }
        }
        if ( tBL > 0. ) {
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
