package Acwing蓝桥杯.贪心;




/*
给定 N 个加号、M 个减号以及 N+M+1 个整数 A1,A2,···,AN+M+1，小明想知道在所有由这 N 个加号、M 个减号以及 N+M+1 个整数凑出的合法的后缀表达式中，结果最大的是哪一个？

请你输出这个最大的结果。

例如使用 123+−，则 “23+1−” 这个后缀表达式结果是 4，是最大的。

输入格式
第一行包含两个整数 N 和 M。

第二行包含 N+M+1 个整数 A1,A2,···,AN+M+1。

输出格式
输出一个整数，代表答案。

数据范围
0≤N,M≤105,
−109≤Ai≤109
输入样例：
1 1
1 2 3
输出样例：
4
 */
import java.util.Arrays;
import java.util.Scanner;
public class Num1247 {
    static Scanner scanner = new Scanner(System.in);
    static int N = scanner.nextInt();
    static int M = scanner.nextInt();
    static int n = N + M + 1;
    static int[] a = new int[n * 2];
    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        long res = 0;
        if (M == 0) {
            for (int i = 0; i < n; i++) {
                res += a[i];
            }
        } else {
            Arrays.sort(a, 0, n);
             res = a[n - 1] - a[0];

            for (int i = 1; i < n-1; i++) {
                res += Math.abs(a[i]);
            }
        }

        System.out.println(res);

    }





}
