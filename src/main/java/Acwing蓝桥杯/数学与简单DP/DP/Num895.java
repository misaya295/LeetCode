package Acwing蓝桥杯.数学与简单DP.DP;



/*
895. 最长上升子序列
   题目
   提交记录
   讨论
   题解
   视频讲解

给定一个长度为N的数列，求数值严格单调递增的子序列的长度最长是多少。

输入格式
第一行包含整数N。

第二行包含N个整数，表示完整序列。

输出格式
输出一个整数，表示最大长度。

数据范围
1≤N≤1000，
−109≤数列中的数≤109
输入样例：
7
3 1 2 1 8 5 6
输出样例：
4
 */
import java.util.Scanner;

public class Num895 {


    static Scanner s = new Scanner(System.in);
    static int N = 1010;
    static int n = s.nextInt();
    static int[] w = new int[N];
    static int[]f = new int[N];

    public static void main(String[] args) {
        for (int i = 1; i <= n; i++) {

            w[i] = s.nextInt();
        }

        for (int i = 1; i <= n; i++) {

            f[i] = 1;
            for (int j = 1; j < i; j++) {
                if (w[j] < w[i])
                    f[i] = Math.max(f[i], f[j] + 1);

            }


        }
        int res = 0;
        for (int i = 1; i <= n; i ++) res = Math.max(res, f[i]);
            System.out.println(res);

    }



}
