package Acwing提高课.DP.背包问题;


/*
有 N 种物品和一个容量是 V 的背包。

物品一共有三类：

第一类物品只能用1次（01背包）；
第二类物品可以用无限次（完全背包）；
第三类物品最多只能用 si 次（多重背包）；
每种体积是 vi，价值是 wi。

求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
输出最大价值。

输入格式
第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。

接下来有 N 行，每行三个整数 vi,wi,si，用空格隔开，分别表示第 i 种物品的体积、价值和数量。

si=−1 表示第 i 种物品只能用1次；
si=0 表示第 i 种物品可以用无限次；
si>0 表示第 i 种物品可以使用 si 次；
输出格式
输出一个整数，表示最大价值。

数据范围
0<N,V≤1000
0<vi,wi≤1000
−1≤si≤1000
输入样例
4 5
1 2 -1
2 4 1
3 4 0
4 5 2
输出样例：
8
 */
import java.util.Scanner;
public class Acwing07 {
    static int N = 10010;
    static int n, m;
    static int v, w, s;
    static int[] f = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            v = sc.nextInt();
            w = sc.nextInt();
            s = sc.nextInt();


            if (s == 0) {
                for (int j = v; j <=m; j++) f[j] = Math.max(f[j], f[j - v] + w);
            } else{

                if(s == -1) s = 1;
                for (int k = 1; k <= s; k *= 2){

                    for (int j = m; j >= k * v; j--) {
                        f[j] = Math.max(f[j], f[j - k * v] + k * w);
                    }
                    s -= k;
                }
                if (s > 0) {
                    for (int j = m; j >= s * v; j--) {
                        f[j] = Math.max(f[j], f[j - s * v] + s * w);
                    }
                }
            }
        }
        System.out.println(f[m]);
    }
}
