package Acwing提高课.DP.背包问题;




/*
1020. 潜水员
潜水员为了潜水要使用特殊的装备。

他有一个带2种气体的气缸：一个为氧气，一个为氮气。

让潜水员下潜的深度需要各种数量的氧和氮。

潜水员有一定数量的气缸。

每个气缸都有重量和气体容量。

潜水员为了完成他的工作需要特定数量的氧和氮。

他完成工作所需气缸的总重的最低限度的是多少？

例如：潜水员有5个气缸。每行三个数字为：氧，氮的（升）量和气缸的重量：

5 60
5
3 36 120
10 25 129
5 50 250
1 45 130
4 20 119
如果潜水员需要5升的氧和60升的氮则总重最小为249（1，2或者4，5号气缸）。

你的任务就是计算潜水员为了完成他的工作需要的气缸的重量的最低值。

输入格式
第一行有2个整数 m，n。它们表示氧，氮各自需要的量。

第二行为整数 k 表示气缸的个数。

此后的 k 行，每行包括ai，bi，ci，3个整数。这些各自是：第 i 个气缸里的氧和氮的容量及气缸重量。

输出格式
仅一行包含一个整数，为潜水员完成工作所需的气缸的重量总和的最低值。

数据范围
1≤m≤21,
1≤n≤79,
1≤k≤1000,
1≤ai≤21,
1≤bi≤79,
1≤ci≤800
输入样例：
5 60
5
3 36 120
10 25 129
5 50 250
1 45 130
4 20 119
输出样例：
249
 */

import java.util.Arrays;
import java.util.Scanner;
public class Acwing1020 {
    static int V1;//氧气
    static int V2;//氮气
    static int N = 22;
    static int M = 80;
    static int[][] f = new int[N][M];
    static int INF = 0x3f3f3f3f;
    static int n,m, k;
    static int v1,v2, w;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < N; i++) Arrays.fill(f[i], INF);
        f[0][0] = 0;
        while (k-- > 0) {
            v1 = sc.nextInt();
            v2 = sc.nextInt();
            w = sc.nextInt();
            for (int j = n; j >= 0; j--) {

                for (int k = m; k >= 0; k--) {
                    f[j][k] = Math.min(f[j][k], f[Math.max(0, j - v1)][Math.max(0, k - v2)] + w);

                }
            }

        }
        System.out.println(f[n][m]);
    }
}
