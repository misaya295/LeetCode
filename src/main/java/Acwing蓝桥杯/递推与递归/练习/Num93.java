package Acwing蓝桥杯.递推与递归.练习;


    import java.util.Scanner;

/**
 * 从 1~n 这 n 个整数中随机选出 m 个，输出所有可能的选择方案。
 *
 * 输入格式
 * 两个整数 n,m ,在同一行用空格隔开。
 *
 * 输出格式
 * 按照从小到大的顺序输出所有方案，每行1个。
 *
 * 首先，同一行内的数升序排列，相邻两个数用一个空格隔开。
 *
 * 其次，对于两个不同的行，对应下标的数一一比较，字典序较小的排在前面（例如1 3 5 7排在1 3 6 8前面）。
 *
 * 数据范围
 * n>0 ,
 * 0≤m≤n ,
 * n+(n−m)≤25
 * 输入样例：
 * 5 3
 * 输出样例：
 * 1 2 3
 * 1 2 4
 * 1 2 5
 * 1 3 4
 * 1 3 5
 * 1 4 5
 * 2 3 4
 * 2 3 5
 * 2 4 5
 * 3 4 5
 */
public class Num93 {

    static Scanner scanner = new Scanner(System.in);
    static int N = 30;
    static int n = scanner.nextInt();
    static int m = scanner.nextInt();
    static int[] way = new int[N];


    public static void main(String[] args) {
        dfs(1, 1);
    }

    public static void dfs(int u, int start) {


        if (u + n - start < m) {
            return;
        }
        if (u == m + 1) {
            for (int i = 1; i <= m; i++) {
                System.out.print(way[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {

            way[u] = i;

            dfs(u + 1, i + 1);

            way[u] = 0;

        }

    }


}
