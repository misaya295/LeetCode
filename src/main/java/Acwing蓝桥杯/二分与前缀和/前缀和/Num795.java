package Acwing蓝桥杯.二分与前缀和.前缀和;


import java.util.Scanner;

/*
输入一个长度为n的整数序列。

接下来再输入m个询问，每个询问输入一对l, r。

对于每个询问，输出原序列中从第l个数到第r个数的和。

输入格式
第一行包含两个整数n和m。

第二行包含n个整数，表示整数数列。

接下来m行，每行包含两个整数l和r，表示一个询问的区间范围。

输出格式
共m行，每行输出一个询问的结果。

数据范围
1≤l≤r≤n,
1≤n,m≤100000,
−1000≤数列中元素的值≤1000
输入样例：
5 3
2 1 3 6 4
1 2
1 3
2 4
输出样例：
3
6
10
 */
public class Num795 {

    static Scanner sin = new Scanner(System.in);

    static int n = sin.nextInt();
    static int m = sin.nextInt();
    static int[] a = new int[100010];  //原数组
    static int[] s = new int[100010]; //前缀和数组
    static int l, r;

    public static void main(String[] args) {

        for (int i = 1; i <= n; i++) {
            a[i] = sin.nextInt();
            s[i] = s[i - 1] + a[i];
        }


        while (m > 0) {


            l = sin.nextInt();
            r = sin.nextInt();

            System.out.print(s[r] - s[l - 1]);
            System.out.println();
            m--;

        }









    }






}
