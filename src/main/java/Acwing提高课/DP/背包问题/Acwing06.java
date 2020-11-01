package Acwing提高课.DP.背包问题;


import java.util.Scanner;

/*
6. 多重背包问题 III
   题目
   提交记录
   讨论
   题解
   视频讲解

有 N 种物品和一个容量是 V 的背包。

第 i 种物品最多有 si 件，每件体积是 vi，价值是 wi。

求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
输出最大价值。

输入格式
第一行两个整数，N，V (0<N≤1000, 0<V≤20000)，用空格隔开，分别表示物品种数和背包容积。

接下来有 N 行，每行三个整数 vi,wi,si，用空格隔开，分别表示第 i 种物品的体积、价值和数量。

输出格式
输出一个整数，表示最大价值。

数据范围
0<N≤1000
0<V≤20000
0<vi,wi,si≤20000
提示
本题考查多重背包的单调队列优化方法。

输入样例
4 5
1 2 3
2 4 1
3 4 3
4 5 2
输出样例：
10
难度：困难
时/空限制：1s / 128MB
总通过数：3866
总尝试数：8704
来源：背包九讲
算法标签
 */
public class Acwing06 {
    static int N =20010;
    static int n, m;
    static int v;
    static int w;
    static int s;
    static int[] q = new int[N];
    static int[] g = new int[N];
    static int[] f = new int[N];
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            v = sc.nextInt();
            w = sc.nextInt();
            s = sc.nextInt();
            for (int j = 0; j < v; j++) {
                int hh = 0, tt = -1;
                for (int k = j; k <= m; k += v) {
                    g[k] = f[k];//每次f[k]都可能会更新， 预先保存f[i-1, k]的值
                    if(hh<=tt&&(k-q[hh])/v>s) hh++;//保证保证不超前si个
                    while(hh<=tt&&g[q[tt]]+(k-q[tt])/v*w <f[k]) tt--;//单调队列入队方法
                    q[++tt] = k;
                    f[k] = g[q[hh]]+(k-q[hh])/v*w;
                }


            }

        }

        System.out.println(f[m]);


    }
}