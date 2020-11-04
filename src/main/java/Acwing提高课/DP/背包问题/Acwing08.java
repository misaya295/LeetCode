package Acwing提高课.DP.背包问题;



/*
8. 二维费用的背包问题
   题目
   提交记录
   讨论
   题解
   视频讲解

有 N 件物品和一个容量是 V 的背包，背包能承受的最大重量是 M。

每件物品只能用一次。体积是 vi，重量是 mi，价值是 wi。

求解将哪些物品装入背包，可使物品总体积不超过背包容量，总重量不超过背包可承受的最大重量，且价值总和最大。
输出最大价值。

输入格式
第一行两个整数，N，V,M，用空格隔开，分别表示物品件数、背包容积和背包可承受的最大重量。

接下来有 N 行，每行三个整数 vi,mi,wi，用空格隔开，分别表示第 i 件物品的体积、重量和价值。

输出格式
输出一个整数，表示最大价值。

数据范围
0<N≤1000
0<V,M≤100
0<vi,mi≤100
0<wi≤1000
输入样例
4 5 6
1 2 3
2 4 4
3 4 5
4 5 6
输出样例：
8
难度：中等
时/空限制：1s / 64MB
总通过数：4255
总尝试数：5492
来源：背包九讲
算法标签
 */
import java.util.Scanner;
public class Acwing08 {
    static int N =1010;
    static int V,M,W;
    static int[][] f = new int[N][N];
    static int v,m,w;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        V = sc.nextInt();
        M = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            v = sc.nextInt();
            m = sc.nextInt();
            w = sc.nextInt();
            for (int j = V; j >= v; j--) {
                for (int k = M; k >= m; k--) {
                    f[j][k] = Math.max(f[j][k], f[j - v][k - m] + w);
                }
            }
        }
        System.out.println(f[V][M]);
    }
}
