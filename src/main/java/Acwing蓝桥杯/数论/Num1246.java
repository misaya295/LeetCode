package Acwing蓝桥杯.数论;




/*
数学老师给小明出了一道等差数列求和的题目。

但是粗心的小明忘记了一部分的数列，只记得其中 N 个整数0 。

现在给出这 N 个整数，小明想知道包含这 N 个整数的最短的等差数列有几项？

输入格式
输入的第一行包含一个整数 N。

第二行包含 N 个整数 A1,A2,···,AN。(注意 A1∼AN 并不一定是按等差数
列中的顺序给出)

输出格式
输出一个整数表示答案。

数据范围
2≤N≤100000,
0≤Ai≤109
输入样例：
5
2 6 4 10 20
输出样例：
10
样例解释
包含 2、6、4、10、20 的最短的等差数列是 2、4、6、8、10、12、14、16、18、20。
 */

import java.util.Arrays;
import java.util.Scanner;
public class Num1246 {

    static Scanner scanner = new Scanner(System.in);
    static int N = 100010;
    static int n = scanner.nextInt();
    static int[] a = new int[N];

    public static void main(String[] args) {

        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();

        Arrays.sort(a, 0, n);

        int d = 0;
        for (int i = 0; i < n; i++) {

            d = gcd(d, a[i] - a[0]);
        }

        if (d == 0) {
            System.out.println(n);

        } else {
            int res = (a[n - 1] - a[0]) / d + 1;
            System.out.println(res);
        }




    }

    public static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;

    }



}
