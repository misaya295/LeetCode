package Acwing算法基础.第一讲.快排;

;


/*
给定你一个长度为n的整数数列。

请你使用快速排序对这个数列按照从小到大进行排序。

并将排好序的数列按顺序输出。

输入格式
输入共两行，第一行包含整数 n。

第二行包含 n 个整数（所有整数均在1~109范围内），表示整个数列。

输出格式
输出共一行，包含 n 个整数，表示排好序的数列。

数据范围
1≤n≤100000
输入样例：
5
3 1 2 4 5
输出样例：
1 2 3 4 5
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Num785 {
    static int N = (int) (1e6 + 10);
    static int n;
    static int[] q = new int[N];
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();
        n = Integer.parseInt(s);
        String[] a = bufferedReader.readLine().split(" ");

        for (int i = 0; i < n; i++) q[i] = Integer.parseInt(a[i]);
        quick_sort(q,0,n-1);
        for(int i=0;i < n;i++) System.out.print(q[i]+" ");

    }

    private static void quick_sort(int[] q, int l, int r) {

        if(l >= r) return;
        int x = q[l], i = l - 1, j = r + 1;
        while (i < j){

            do i++; while (q[i] < x);
            do j--; while (q[j] > x);
            if(i < j){

                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;

            }
        }

        quick_sort(q, l, j);
        quick_sort(q, j + 1, r);


    }

}
