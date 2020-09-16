package Acwing蓝桥杯.贪心;



/*
给定 N 个整数 A1,A2,…AN。

请你从中选出 K 个数，使其乘积最大。

请你求出最大的乘积，由于乘积可能超出整型范围，你只需输出乘积除以 1000000009 的余数。

注意，如果 X<0， 我们定义 X 除以 1000000009 的余数是负(−X)除以 1000000009 的余数，即：0−((0−x)%1000000009)
输入格式
第一行包含两个整数 N 和 K。

以下 N 行每行一个整数 Ai。

输出格式
输出一个整数，表示答案。

数据范围
1≤K≤N≤105,
−105≤Ai≤105
输入样例1：
5 3
-100000
-10000
2
100000
10000
输出样例1：
999100009
输入样例2：
5 3
-100000
-100000
-2
-100000
-100000
输出样例2：
-999999829
 */
import java.util.Arrays;
import java.util.Scanner;
public class Num1239 {

    static int MOD = 1000000009;

    static Scanner scanner = new Scanner(System.in);
    static int N = 100010;
    static int n = scanner.nextInt();
    static int k = scanner.nextInt();
    static int[] a = new int[N];


    public static void main(String[] args) {



        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a, 0, n);

        int res = 1;
        int l = 0, r = n - 1;
        int sign = 1;
        if (k % 2 == 1) {

            res = a[r--];
            if (res < 0) {
                sign = -1;
            }
            k--;
        }

        while (k > 0) {
            long x = (long) a[l] * a[l + 1];
            long y = (long) a[r] * a[r - 1];
            if (x * sign > y * sign) {
                res = (int) (x % MOD * res % MOD);
                l += 2;
            } else {
                res=(int) (y % MOD * res % MOD);
                r -= 2;
            }
            k -= 2;

        }
        System.out.println(res);






    }
}
