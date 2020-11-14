package Acwing蓝桥杯.二分与前缀和.前缀和;

import java.util.Scanner;

/*
给定一个长度为 N 的数列，A1,A2,…AN，如果其中一段连续的子序列 Ai,Ai+1,…Aj 之和是 K 的倍数，我们就称这个区间 [i,j] 是 K 倍区间。

你能求出数列中总共有多少个 K 倍区间吗？

输入格式
第一行包含两个整数 N 和 K。

以下 N 行每行包含一个整数 Ai。

输出格式
输出一个整数，代表 K 倍区间的数目。

数据范围
1≤N,K≤100000,
1≤Ai≤100000
输入样例：
5 2
1
2
3
4
5
输出样例：
6
 */
import java.util.*;
public class Num1230 {

    static Scanner s = new Scanner(System.in);
    static long N = s.nextInt();
    static long K = s.nextInt();
    static long[] S = new long[100010];
    static long[] sum = new long[100010];
    public static void main(String[] args) {

        for (int i = 1; i <= N; i++) {

            S[i] = s.nextInt();
            S[i]+=S[i-1];


        }

        //O(n)
        long res = 0;
        sum[0] = 1;
        for (int i = 1; i <= N; i++) {
            res+=sum[(int)(S[i] % K)];
            sum[(int)(S[i] % K)]++;
        }
        System.out.println(res);

        //O(n2)过不了
//            int sum = 0;
//            for (int i = 1; i <= N; i++) {
//                for (int j = 1; j <= i; j++) {
//                    if ((S[i] - S[j - 1]) % K == 0) {
//                        sum++;
//                    }
//                }
//
//            }
//            System.out.println(sum);

    }


}
