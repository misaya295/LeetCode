package Acwing提高课.DP.背包问题;



/*
有一个箱子容量为 V，同时有 n 个物品，每个物品有一个体积（正整数）。

要求 n 个物品中，任取若干个装入箱内，使箱子的剩余空间为最小。

输入格式
第一行是一个整数 V，表示箱子容量。

第二行是一个整数 n，表示物品数。

接下来 n 行，每行一个正整数（不超过10000），分别表示这 n 个物品的各自体积。

输出格式
一个整数，表示箱子剩余空间。

数据范围
0<V≤20000,
0<n≤30
输入样例：
24
6
8
3
12
7
9
7
输出样例：
0
 */
import java.util.Scanner;
public class Acwing1024 {
    static int N =20010;
    static int[] v = new int[N];
    static int n;
    static int m;
    static int[] f = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) v[i] = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= v[i]; j--) {
                f[j] = Math.max(f[j], f[j - v[i]] + v[i]);
            }
        }

        System.out.println(m-f[m]);

    }

}
