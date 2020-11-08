package Acwing提高课.search.Flood_fill;


import com.sun.media.sound.SoftTuning;

import java.lang.reflect.Array;
import java.util.Arrays;


/*
1076. 迷宫问题
   题目
   提交记录
   讨论
   题解
   视频讲解

给定一个 n×n 的二维数组，如下所示：

int maze[5][5] = {

0, 1, 0, 0, 0,

0, 1, 0, 1, 0,

0, 0, 0, 0, 0,

0, 1, 1, 1, 0,

0, 0, 0, 1, 0,

};
它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。

数据保证至少存在一条从左上角走到右下角的路径。

输入格式
第一行包含整数 n。

接下来 n 行，每行包含 n 个整数 0 或 1，表示迷宫。

输出格式
输出从左上角到右下角的最短路线，如果答案不唯一，输出任意一条路径均可。

按顺序，每行输出一个路径中经过的单元格的坐标，左上角坐标为 (0,0)，右下角坐标为 (n−1,n−1)。

数据范围
0≤n≤1000
输入样例：
5
0 1 0 0 0
0 1 0 1 0
0 0 0 0 0
0 1 1 1 0
0 0 0 1 0
输出样例：
0 0
1 0
2 0
2 1
2 2
2 3
2 4
3 4
4 4
 */
import java.util.Scanner;
public class Acwing1076 {

    static int N=1010;
    static int[][] g = new int[N][N];
    static class PII{
        int x;
        int y;

        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static PII[] q = new PII[N * N];
    static PII[][] pre = new PII[N][N];
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = sc.nextInt();
            }
        }
        bfs(n - 1, n - 1);
        PII end = new PII(0, 0);
        while (true) {
            System.out.printf("%d %d\n", end.x, end.y);
            if (end.x == n-1 && end.y == n-1) break;
            end = pre[end.x][end.y];
        }
    }
    private static void bfs(int sx, int sy) {

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        q[0] = new PII(sx, sy);
        int tt = 0;
        int hh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pre[i][j] = new PII(-1, -1);
            }
        }
        pre[sx][sy] = new PII(0, 0);
        while (hh <= tt) {
            PII t = q[hh++];
            for (int i = 0; i < 4; i++) {
                int a = t.x + dx[i];
                int b = t.y + dy[i];
                if(a < 0|| a>=n|| b  < 0|| b>=n) continue;
                if(g[a][b] != 0) continue;
                if(pre[a][b].x !=-1) continue;
                q[++tt] = new PII(a, b);
                pre[a][b] = t;
            }
        }
    }
}
