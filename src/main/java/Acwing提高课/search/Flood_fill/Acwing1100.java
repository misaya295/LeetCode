package Acwing提高课.search.Flood_fill;



/*
农夫知道一头牛的位置，想要抓住它。

农夫和牛都位于数轴上，农夫起始位于点 N，牛位于点 K。

农夫有两种移动方式：

从 X 移动到 X−1 或 X+1，每次移动花费一分钟
从 X 移动到 2∗X，每次移动花费一分钟
假设牛没有意识到农夫的行动，站在原地不动。

农夫最少要花多少时间才能抓住牛？

输入格式
共一行，包含两个整数N和K。

输出格式
输出一个整数，表示抓到牛所花费的最少时间。

数据范围
0≤N,K≤105
输入样例：
5 17
输出样例：
4
 */
import java.util.Arrays;
import java.util.Scanner;
public class Acwing1100 {

    static int N = (int) (2e5 + 10);
    static int n, k;
    static int[] q = new int[N];
    static int[] dist = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        System.out.println(bfs());

    }

    private static int bfs() {

        Arrays.fill(dist,-1);
        dist[n] = 0;
        int hh = 0;
        int tt = 0;
        q[0] = n;
        while (hh <= tt) {
            int t = q[hh++];

            if(t== k) return dist[k];

            if (t + 1 <N && dist[t + 1] == -1) {
                dist[t + 1] = dist[t] + 1;
                q[++tt] = t +1;
            }
            if (t - 1 >= 0 && dist[t - 1] == -1) {
                dist[t - 1] = dist[t] + 1;
                q[++tt] = t - 1;
            }
            if (t * 2 < N && dist[t * 2] == -1) {
                dist[t * 2] = dist[t] + 1;
                q[++tt] = t * 2;
            }

        }

        return -1;
    }

}
