package Acwing蓝桥杯.疑难杂题;



/*
众所周知，小葱同学擅长计算，尤其擅长计算一个数是否是另外一个数的倍数。

但小葱只擅长两个数的情况，当有很多个数之后就会比较苦恼。

现在小葱给了你 n 个数，希望你从这 n 个数中找到三个数，使得这三个数的和是 K 的倍数，且这个和最大。

数据保证一定有解。

输入格式
第一行包括 2 个正整数 n,K。

第二行 n 个正整数，代表给定的 n 个数。

输出格式
输出一行一个整数代表所求的和。

数据范围
1≤n≤105,
1≤K≤103,
给定的 n 个数均不超过 108
输入样例：
4 3
1 2 3 4
输出样例：
9
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
public class Num1234 {

    static int N = 1010;
    static int INF = 0x3f3f3f3f;
    static int n, m;
    static int[][] f = new int[4][N];
    static LinkedList[] a = new LinkedList[N];

    static int mod(int x, int y) {
        return (x % y + y) % y;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for (int i = 0; i <= m; i++) {
            a[i] = new LinkedList<Integer>();
        }
        for (int i = 1; i <= n; i++) {
            int x = scan.nextInt();
            a[x % m].add(x);
        }
        for (int i = 0; i <= 3; i++) Arrays.fill(f[i], -INF);
        f[0][0] = 0;
        for (int i = 0; i <= m; i++) {
            Collections.sort(a[i]);
            Collections.reverse(a[i]);
            //选择前3大
            for (int u = 0; u < Math.min(3, a[i].size()); u++) {
                int x = (int) a[i].get(u);
                //从大到小
                for (int j = 3; j >= 1; j--) {
                    for (int k = 0; k < m; k++)
                        f[j][k] = Math.max(f[j][k], f[j - 1][mod(k - x, m)] + x);
                }
            }
        }
        System.out.println(f[3][0]);

    }
}

