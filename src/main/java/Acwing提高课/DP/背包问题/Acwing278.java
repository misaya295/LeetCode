package Acwing提高课.DP.背包问题;

/*
278. 数字组合
   题目
   提交记录
   讨论
   题解
   视频讲解

给定N个正整数A1,A2,…,AN，从中选出若干个数，使它们的和为M，求有多少种选择方案。

输入格式
第一行包含两个整数N和M。

第二行包含N个整数，表示A1,A2,…,AN。

输出格式
包含一个整数，表示可选方案数。

数据范围
1≤N≤100,
1≤M≤10000,
1≤Ai≤1000
输入样例：
4 4
1 1 2 2
输出样例：
3
 */

import java.util.Scanner;
public class Acwing278 {
    static int M = 1010;
    static int[] f = new int[M];
    static int n,m,v;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            v = sc.nextInt();
            for (int j = m; j >= v; j--) f[j] = f[j] + f[j - v];
        }
        System.out.println(f[m]);
    }
}
