package Acwing蓝桥杯.二分与前缀和.二分;



/**
 * 给定一个按照升序排列的长度为n的整数数组，以及 q 个查询。
 *
 * 对于每个查询，返回一个元素k的起始位置和终止位置（位置从0开始计数）。
 *
 * 如果数组中不存在该元素，则返回“-1 -1”。
 *
 * 输入格式
 * 第一行包含整数n和q，表示数组长度和询问个数。
 *
 * 第二行包含n个整数（均在1~10000范围内），表示完整数组。
 *
 * 接下来q行，每行包含一个整数k，表示一个询问元素。
 *
 * 输出格式
 * 共q行，每行包含两个整数，表示所求元素的起始位置和终止位置。
 *
 * 如果数组中不存在该元素，则返回“-1 -1”。
 *
 * 数据范围
 * 1≤n≤100000
 * 1≤q≤10000
 * 1≤k≤10000
 * 输入样例：
 * 6 3
 * 1 2 2 3 3 4
 * 3
 * 4
 * 5
 * 输出样例：
 * 3 4
 * 5 5
 * -1 -1
 */
import java.util.Scanner;
public class Num789 {
    static int N = 10001;
    static int[] q = new int[N];
    static Scanner s = new Scanner(System.in);
    static int n = s.nextInt();
    static int m = s.nextInt();
    public static void main(String[] args) {

        for (int i = 0; i < n;
             i++) {
            q[i] = s.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int x;
            x = s.nextInt();
            if(x < q[0] || x > q[n - 1])
                System.out.println("-1 -1");
            else
            {
                int l = findl(x);
                int r = findR(x);
                if(l <= r)
                    System.out.println(l + " " + r);
                else
                    System.out.println("-1 -1");
            }
        }
    }
    private static int findR(int x) {
        int l =0;
        int r = n - 1;
        while (l < r) {
            int mid = r + l + 1 >> 1;
            if (q[mid] <= x) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    private static int findl(int x) {
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = r + l >> 1;
            if (q[mid] >= x) {
                r = mid ;
            } else {
                l = mid + 1;

            }
        }
        return l;
    }
}
