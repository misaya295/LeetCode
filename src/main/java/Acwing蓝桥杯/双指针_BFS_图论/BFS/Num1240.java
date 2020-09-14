package Acwing蓝桥杯.双指针_BFS_图论.BFS;



/*
给定一棵包含 N 个节点的完全二叉树，树上每个节点都有一个权值，按从上到下、从左到右的顺序依次是 A1,A2,···AN，如下图所示：

QQ截图20191205124611.png

现在小明要把相同深度的节点的权值加在一起，他想知道哪个深度的节点权值之和最大？

如果有多个深度的权值和同为最大，请你输出其中最小的深度。

注：根的深度是 1。

输入格式
第一行包含一个整数 N。

第二行包含 N 个整数 A1,A2,···AN。

输出格式
输出一个整数代表答案。

数据范围
1≤N≤105,
−105≤Ai≤105
输入样例：
7
1 6 5 4 3 2 1
输出样例：
2
 */
import java.util.Scanner;
import java.util.Scanner;
public class Num1240 {
    static Scanner scanner = new Scanner(System.in);
    static int N = 100010;
    static int[] t = new int[N];
    static int n = scanner.nextInt();

    public static void main(String[] args) {


        for (int i = 1; i <= n; i++) {
            t[i] = scanner.nextInt();
        }
        int depth = 0;
        long max = Long.MIN_VALUE;

        for (int d = 1, i = 1; i <= n; i *= 2,d++) {
            long s = 0;
            for (int j = i; j < i + (1 << d - 1)&&j<=n; j++) {
                s += t[j];
            }

            if (s > max) {
                max = s;
                depth = d;
            }

        }


        System.out.println(depth);


    }

}

