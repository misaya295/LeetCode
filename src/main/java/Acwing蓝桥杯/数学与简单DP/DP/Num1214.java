package Acwing蓝桥杯.数学与简单DP.DP;


/*
1214. 波动数列
   题目
   提交记录
   讨论
   题解
   视频讲解

观察这个数列：

1 3 0 2 -1 1 -2 …

这个数列中后一项总是比前一项增加2或者减少3，且每一项都为整数。

栋栋对这种数列很好奇，他想知道长度为 n 和为 s 而且后一项总是比前一项增加 a 或者减少 b 的整数数列可能有多少种呢？

输入格式
共一行，包含四个整数 n,s,a,b，含义如前面所述。

输出格式
共一行，包含一个整数，表示满足条件的方案数。

由于这个数很大，请输出方案数除以 100000007 的余数。

数据范围
1≤n≤1000,
−109≤s≤109,
1≤a,b≤106
输入样例：
4 10 2 3
输出样例：
2
样例解释
两个满足条件的数列分别是2 4 1 3和7 4 1 -2。
 */
import java.util.Scanner;
public class Num1214 {

    static Scanner scanner = new Scanner(System.in);
    static int mod = 100000007;

    static int n = scanner.nextInt();
    static int s = scanner.nextInt();
    static int a = scanner.nextInt();
    static int b = scanner.nextInt();

    static int[][] f = new int[1010][1010];

    public static int  getMod(int a, int b) {
        return (a % b + b) % b;
    }

    public static void main(String[] args) {


//        s %= n;
//        a %= n;
//        b %= n;


        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {

            for (int j = 0; j <= n; j++) {
                f[i][j] = (f[i - 1][getMod(j - a * i, n)] + f[i - 1][getMod(j + b * i, n)]) % mod;

            }
        }

        System.out.println(f[n - 1][getMod(s, n)]);




    }

}
