package Acwing蓝桥杯.复杂DP;




/*
大家都知道 Fibonacci 数列吧，f1=1,f2=1,f3=2,f4=3,…,fn=fn−1+fn−2。

现在问题很简单，输入 n 和 m，求 fn 的前 n 项和 Sn mod m。

输入格式
共一行，包含两个整数 n 和 m。

输出格式
输出前 n 项和 Snmodm 的值。

数据范围
1≤n≤2000000000,
1≤m≤1000000010
输入样例：
5 1000
输出样例：
12
 */
import java.util.Scanner;

public class Num1303 {
    static int N = 3;
    static int n,m;
    static void mul(int[] a,int[][] b)
    {
        int[] tmp = new int[N];
        //枚举列
        for(int i = 0;i < N;i ++)
        {
            for(int j = 0;j < N;j ++)//枚举行
            {
                tmp[i] = (int)(tmp[i] + (long)a[j] * b[j][i] % m) % m;
            }
        }

        for(int i = 0;i < N;i ++) a[i] = tmp[i];
    }
    static void mul(int[][] a,int[][] b)
    {
        int[][] tmp = new int[N][N];
        for(int i = 0;i < N;i ++)
            for(int j = 0;j < N;j ++)
                for(int k = 0;k < N;k ++)
                    tmp[i][j] = (int)(tmp[i][j] + (long)a[i][k] * b[k][j] % m) % m;

        for(int i = 0;i < N;i ++)
            for(int j = 0;j < N;j ++)
                a[i][j] = tmp[i][j];
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        int[] f1 = new int[] {1,1,1};
        int[][] a = new int[][] {
                {0,1,0},
                {1,1,1},
                {0,0,1}
        };

        n -- ;

        while(n > 0)
        {
            if((n & 1) == 1) mul(f1,a);// res = res * a
            n >>= 1;
            mul(a,a); // a = a * a
        }
        System.out.println(f1[2]);
    }
}

