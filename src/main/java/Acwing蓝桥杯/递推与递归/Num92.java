package Acwing蓝桥杯.递推与递归;


import java.util.Scanner;

/**
 * 从 1~n 这 n 个整数中随机选取任意多个，输出所有可能的选择方案。
 *
 * 输入格式
 * 输入一个整数n。
 *
 * 输出格式
 * 每行输出一种方案。
 *
 * 同一行内的数必须升序排列，相邻两个数用恰好1个空格隔开。
 *
 * 对于没有选任何数的方案，输出空行。
 *
 * 本题有自定义校验器（SPJ），各行（不同方案）之间的顺序任意。
 *
 * 数据范围
 * 1≤n≤15
 * 输入样例：
 * 3
 * 输出样例：
 *
 * 3
 * 2
 * 2 3
 * 1
 * 1 3
 * 1 2
 * 1 2 3
 */
public class Num92 {
    static   Scanner scanner = new Scanner(System.in);
    static int n = scanner.nextInt();
    /*
    状态，记录每个位置当前的状态 0，还没考虑 1，选 2，不选
     */
    static int[] st = new int[16];

    public static void main(String[] args) {



        dfs(1);



    }

    public static void dfs(int u) {

        if (u > n) {
            for (int i = 1; i <= n; i++) {
                if (st[i] == 1) {
                    System.out.printf(i+" ");

                }

            }
            System.out.println();
            return;
        }
        st[u] =1;
        dfs(u + 1); //第一个分支 选
        st[u] = 0;  // 回溯

        st[u] = 2;
        dfs(u + 1); //第二个分支不选
        st[u] = 0; //回溯




    }


}
