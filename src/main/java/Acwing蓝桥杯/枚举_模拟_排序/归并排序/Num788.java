package Acwing蓝桥杯.枚举_模拟_排序.归并排序;


import com.sun.tools.javah.LLNI;

import java.util.Scanner;
import java.util.Stack;

/*
给定一个长度为n的整数数列，请你计算数列中的逆序对的数量。

逆序对的定义如下：对于数列的第 i 个和第 j 个元素，如果满足 i < j 且 a[i] > a[j]，则其为一个逆序对；否则不是。

输入格式
第一行包含整数n，表示数列的长度。

第二行包含 n 个整数，表示整个数列。

输出格式
输出一个整数，表示逆序对的个数。

数据范围
1≤n≤100000
输入样例：
6
2 3 4 5 6 1
输出样例：
5
 */

public class Num788 {

    static int n;
    static int num[];
    static long res = 0;

    private static void merge_sort(int l, int r) {
        if (l >= r) return;
        int mid = (l + r) / 2;
        int i = l;
        int j = mid + 1;
        merge_sort(l, mid);
        merge_sort(mid + 1, r);
        int tmp[] = new int[r - l + 2];
        int k = 0;
        while (i <= mid && j <= r) {
            if (num[i] <= num[j]) {
                tmp[k++] = num[i++];
            } else {
                tmp[k++] = num[j++];
                res += mid - i + 1;
            }
        }
        while (i <= mid) tmp[k++] = num[i++];
        while (j <= r) tmp[k++] = num[j++];
        for (i = l, j = 0; i <= r; i++)
            num[i] = tmp[j++];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n];
        for (int i = 0; i < n; i++)
            num[i] = sc.nextInt();
        merge_sort(0, n - 1);
        System.out.println(res);
    }
}
