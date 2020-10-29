package Acwing算法基础.第一讲.快排;




/*

给定一个长度为n的整数数列，以及一个整数k，请用快速选择算法求出数列从小到大排序后的第k个数。

输入格式
第一行包含两个整数 n 和 k。

第二行包含 n 个整数（所有整数均在1~109范围内），表示整数数列。

输出格式
输出一个整数，表示数列的第k小数。

数据范围
1≤n≤100000,
1≤k≤n
输入样例：
5 3
2 4 1 5 3
输出样例：
3

 */
import java.util.*;
public class Num786 {
    static int N = (int) (1e8 + 10);
    static int[] q = new int[N];
    static int n;
    static int k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++) q[i] = sc.nextInt();
        System.out.println(quick_sort(0, n - 1, k));

    }
    private static int quick_sort(int l, int r, int k) {
        if(l == r) return q[l];
        int x = q[l], i = l - 1, j = r + 1;
        while (i < j) {
            while (q[++i] < x);
            while (q[--j] > x);
            if (i < j) {
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        int sl = j - l + 1;
        if (k <= sl) return quick_sort(l, j, k);
        return quick_sort(j + 1, r, k - sl);
    }
}
