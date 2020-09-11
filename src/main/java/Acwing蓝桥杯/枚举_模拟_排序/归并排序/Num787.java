package Acwing蓝桥杯.枚举_模拟_排序.归并排序;



/*
给定你一个长度为n的整数数列。

请你使用归并排序对这个数列按照从小到大进行排序。

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
import java.util.Scanner;

public class Num787 {


    static Scanner scanner = new Scanner(System.in);

    static int n = scanner.nextInt();

    static int N = 100010;

    static int[] q = new int[N];

    static int[] tmp = new int[N];
    public static void main(String[] args) {


        for (int i = 0; i < n; i++) {
            q[i] = scanner.nextInt();

        }


        merge_sort(q, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(q[i]+" ");
        }


    }

    public static void merge_sort(int[] q, int l, int r) {


        if (l >= r) {
            return;
        }


        int mid = l + r >> 1;
        merge_sort(q, l, mid);
        merge_sort(q, mid+1, r);

        int k = 0;
        int i =l ;
        int j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) {tmp[k++] = q[i++]; }
            else { tmp[k++] = q[j++]; }

        }

        while (i <= mid) { tmp[k++] = q[i++]; }
        while ( j <= r){ tmp[k++] = q[j++];}


        for (i = l, j = 0; i <= r; i++, j++) { q[i] = tmp[j]; }
    }


    }




