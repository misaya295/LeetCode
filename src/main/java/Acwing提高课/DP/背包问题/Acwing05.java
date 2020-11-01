package Acwing提高课.DP.背包问题;



/*
有 N 种物品和一个容量是 V 的背包。

第 i 种物品最多有 si 件，每件体积是 vi，价值是 wi。

求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
输出最大价值。

输入格式
第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。

接下来有 N 行，每行三个整数 vi,wi,si，用空格隔开，分别表示第 i 种物品的体积、价值和数量。

输出格式
输出一个整数，表示最大价值。

数据范围
0<N≤1000
0<V≤2000
0<vi,wi,si≤2000
提示：
本题考查多重背包的二进制优化方法。

输入样例
4 5
1 2 3
2 4 1
3 4 3
4 5 2
输出样例：
10
 */
import java.util.Scanner;
public class Acwing05 {
    static int N =12010;
    static int n,m;
    static int[] v = new int[N];
    static int[] w = new int[N];
    static int[] f = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int a, b, s;
            a = sc.nextInt();
            b = sc.nextInt();
            s = sc.nextInt();
            int k = 1;
            while (k <= s) {
                cnt++;
                v[cnt] = a * k;
                w[cnt] = b * k;
                s -= k;
                k *= 2;
            }
            if (s > 0
            ) {
                cnt++;
                v[cnt] = a * s;
                w[cnt] = b * s;
            }
        }

        n = cnt;
        for (int i = 1; i <= n; i++) {

            for (int j = m; j >= v[i]; j--) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }

        }
        System.out.println(f[m]);
    }
}
