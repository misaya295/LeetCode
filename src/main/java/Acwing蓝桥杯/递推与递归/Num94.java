package Acwing蓝桥杯.递推与递归;


import java.util.Scanner;

/**
 * 把 1~n 这 n 个整数排成一行后随机打乱顺序，输出所有可能的次序。
 *
 * 输入格式
 * 一个整数n。
 *
 * 输出格式
 * 按照从小到大的顺序输出所有方案，每行1个。
 *
 * 首先，同一行相邻两个数用一个空格隔开。
 *
 * 其次，对于两个不同的行，对应下标的数一一比较，字典序较小的排在前面。
 *
 * 数据范围
 * 1≤n≤9
 * 输入样例：
 * 3
 * 输出样例：
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 1 2
 * 3 2 1
 */
public class Num94 {

   static Scanner scanner = new Scanner(System.in);
   static int N = 10;
   static int n = scanner.nextInt();
   static int[] state = new int[N];
   static boolean[] used = new boolean[N];


    public static void main(String[] args) {

        dfs(1);

    }

    public  static void dfs(int u) {

        if (u > n) {

            for (int i = 1; i <= n; i++) {
                System.out.print(state[i]+" ");
            }
            System.out.println();
            return;
        }

        //分支
        for (int i = 1; i <= n; i++) {

            if (!used[i]) {

                state[u] = i;
                used[i] = true;

                dfs(u + 1);
                state[u] = 0;
                used[i] = false;
            }
        }

    }























}
