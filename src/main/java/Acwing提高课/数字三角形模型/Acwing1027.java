package Acwing提高课.数字三角形模型;


/*
设有 N×N 的方格图，我们在其中的某些方格中填入正整数，而其它的方格中则放入数字0。如下图所示：

2.gif

某人从图中的左上角 A 出发，可以向下行走，也可以向右行走，直到到达右下角的 B 点。

在走过的路上，他可以取走方格中的数（取走后的方格中将变为数字0）。

此人从 A 点到 B 点共走了两次，试找出两条这样的路径，使得取得的数字和为最大。

输入格式
第一行为一个整数N，表示 N×N 的方格图。

接下来的每行有三个整数，第一个为行号数，第二个为列号数，第三个为在该行、该列上所放的数。

行和列编号从 1 开始。

一行“0 0 0”表示结束。

输出格式
输出一个整数，表示两条路径上取得的最大的和。

数据范围
N≤10
输入样例：
8
2 3 13
2 6 6
3 5 7
4 4 14
5 2 21
5 6 4
6 3 15
7 2 14
0 0 0
输出样例：
67
 */
import java.util.Scanner;
public class Acwing1027 {
    static int N = 15;
    static int n;
    static int[][] w = new int[N][N];
    static int[][][] f = new int[N * 2][N][N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int a=-1, b=-1, c=-1;
        while (b != 0 || a != 0 || c != 0) {

            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            w[a][b] = c;

        }
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                System.out.print(w[i][j] + " ");
//
//            }
//            System.out.println();
//        }

        for (int k = 2; k <= n * 2; k++) {
            for (int i1 = 1; i1 <= n; i1++) {
                for (int i2 = 1; i2 <= n; i2++) {
                    int j1 = k - i1;
                    int j2 = k - i2;
                    if (j1 >= 1 && j1 <= n && j2 >= 1 && j2 <= n) {
                        int t = w[i1][j1];
                        if(i1 != i2) t+=w[i2][j2];
                        f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1 - 1][i2 - 1] + t);
                        f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1 - 1][i2] + t);
                        f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1][i2 - 1] + t);
                        f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1][i2] + t);

                    }
                }

            }
        }

        System.out.println(f[n * 2][n][n]);


    }

}
