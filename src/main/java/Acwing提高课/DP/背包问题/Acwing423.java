package Acwing提高课.DP.背包问题;





/*
423. 采药
   题目
   提交记录
   讨论
   题解
   视频讲解

辰辰是个天资聪颖的孩子，他的梦想是成为世界上最伟大的医师。

为此，他想拜附近最有威望的医师为师。

医师为了判断他的资质，给他出了一个难题。

医师把他带到一个到处都是草药的山洞里对他说：“孩子，这个山洞里有一些不同的草药，采每一株都需要一些时间，每一株也有它自身的价值。我会给你一段时间，在这段时间里，你可以采到一些草药。如果你是一个聪明的孩子，你应该可以让采到的草药的总价值最大。”

如果你是辰辰，你能完成这个任务吗？

输入格式
输入文件的第一行有两个整数T和M，用一个空格隔开，T代表总共能够用来采药的时间，M代表山洞里的草药的数目。

接下来的M行每行包括两个在1到100之间（包括1和100）的整数，分别表示采摘某株草药的时间和这株草药的价值。

输出格式
输出文件包括一行，这一行只包含一个整数，表示在规定的时间内，可以采到的草药的最大总价值。

数据范围
1≤T≤1000,
1≤M≤100
输入样例：
70 3
71 100
69 1
1 2
输出样例：
3
 */
import java.util.Scanner;
public class Acwing423 {
    static int N = 1010;
    static int n, m;
    static int[] v = new int[N];
    static int[] w = new int[N];
//    static int[][] f = new int[N][N];
    static int[] f = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }


        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= v[i]; j--) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);

            }
        }



//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j <= m; j++) {
//                f[i][j] = Math.max(f[i - 1][j], f[i][j]);
//                if (j >= v[i]) {
//                    f[i][j] = Math.max(f[i - 1][j - v[i]] + w[i], f[i][j]);
//                }
//            }
//        }
        System.out.println(f[m]);
//        System.out.println(f[n][m]);
    }
}
