package Acwing提高课.DP.背包问题;



/*
1021. 货币系统
   题目
   提交记录
   讨论
   题解
   视频讲解

给你一个n种面值的货币系统，求组成面值为m的货币有多少种方案。

输入格式
第一行，包含两个整数n和m。

接下来n行，每行包含一个整数，表示一种货币的面值。

输出格式
共一行，包含一个整数，表示方案数。

数据范围
n≤15,m≤3000
输入样例：
3 10
1
2
5
输出样例：
10
 */
import java.util.Scanner;
public class Acwing1021 {
    static int N = 20;
    static long[] f = new long[N];
    static int n,m;
    static int v;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m =  sc.nextInt();
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            v = sc.nextInt();
            for (int j = v; j <= m; j++) f[j] += f[j - v];

        }
        System.out.println(f[m]);
    }

}
