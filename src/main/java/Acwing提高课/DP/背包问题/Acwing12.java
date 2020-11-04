package Acwing提高课.DP.背包问题;



/*
12. 背包问题求具体方案
有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。

第 i 件物品的体积是 vi，价值是 wi。

求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。

输出 字典序最小的方案。这里的字典序是指：所选物品的编号所构成的序列。物品的编号范围是 1…N。

输入格式
第一行两个整数，N，V，用空格隔开，分别表示物品数量和背包容积。

接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 件物品的体积和价值。

输出格式
输出一行，包含若干个用空格隔开的整数，表示最优解中所选物品的编号序列，且该编号序列的字典序最小。

物品编号范围是 1…N。

数据范围
0<N,V≤1000
0<vi,wi≤1000
输入样例
4 5
1 2
2 4
3 4
4 6
输出样例：
1 4
难度：中等
时/空限制：1s / 64MB
总通过数：3004
总尝试数：7491
来源：背包九讲
算法标签
 */
import java.util.Scanner;
public class Acwing12 {
    static int N =1010;
    static int[] v = new int[N];
    static int[] w = new int[N];
    static int[][] f = new int[N][N];
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        for (int i = n; i >= 1; i--) {

            for (int j = 0; j <= m; j++) {
                f[i][j] = f[i + 1][j];
                if(j >= v[i]) f[i][j] = Math.max(f[i][j], f[i +1][j - v[i]] + w[i]);
            }
        }
        int j = m;
        for (int i = 1; i <= n; i++) {
            if (j >= v[i] && f[i][j] == f[i + 1][j - v[i]] + w[i]) {
                System.out.print(i + " ");
                j -= v[i];
            }
        }
    }
}
