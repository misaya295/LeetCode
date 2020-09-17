package Acwing蓝桥杯.数论;


/*
大圣在佛祖的手掌中。

我们假设佛祖的手掌是一个圆圈，圆圈的长为 n，逆时针记为：0,1,2,…,n−1，而大圣每次飞的距离为 d。

现在大圣所在的位置记为 x，而大圣想去的地方在 y。

要你告诉大圣至少要飞多少次才能到达目的地。

注意：孙悟空的筋斗云只沿着逆时针方向翻。

输入格式
有多组测试数据。

第一行是一个正整数 T，表示测试数据的组数；

每组测试数据包括一行，四个非负整数，分别为如来手掌圆圈的长度 n，筋斗所能飞的距离 d，大圣的初始位置 x 和大圣想去的地方 y。

输出格式
对于每组测试数据，输出一行，给出大圣最少要翻多少个筋斗云才能到达目的地。

如果无论翻多少个筋斗云也不能到达，输出 Impossible。

数据范围
2<n<109,
0<d<n,
0≤x,y<n
输入样例：
2
3 2 0 2
3 2 0 1
输出样例：
1
2
 */
import java.io.*;

class Num1299{
    static int exgcd(int a, int b, long[] x, long[] y){
        if(b == 0){
            x[0] = 1;
            y[0] = 0;
            return a;
        }

        int d = exgcd(b, a%b, y, x);
        y[0] -= (a / b) * x[0];
        return d;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());
        while(T-- > 0){
            String[] cur = in.readLine().split(" ");
            int n = Integer.parseInt(cur[0]);
            int d = Integer.parseInt(cur[1]);
            int x = Integer.parseInt(cur[2]);
            int y = Integer.parseInt(cur[3]);

            long[] a = new long[1];
            long[] b = new long[1];
            int gcd = exgcd(n, d, a, b);
            if((y - x) % gcd != 0) System.out.println("Impossible");
            else{
                int c = (y - x) / gcd;
                b[0] *= c;
                n /= gcd;
                System.out.println((b[0] % n + n) % n);
            }
        }
    }
}

