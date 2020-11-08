package Acwing提高课.search.Flood_fill;




/*
188. 武士风度的牛
   题目
   提交记录
   讨论
   题解
   视频讲解

农民John有很多牛，他想交易其中一头被Don称为The Knight的牛。

这头牛有一个独一无二的超能力，在农场里像Knight一样地跳（就是我们熟悉的象棋中马的走法）。

虽然这头神奇的牛不能跳到树上和石头上，但是它可以在牧场上随意跳，我们把牧场用一个x，y的坐标图来表示。

这头神奇的牛像其它牛一样喜欢吃草，给你一张地图，上面标注了The Knight的开始位置，树、灌木、石头以及其它障碍的位置，除此之外还有一捆草。

现在你的任务是，确定The Knight要想吃到草，至少需要跳多少次。

The Knight的位置用’K’来标记，障碍的位置用’*’来标记，草的位置用’H’来标记。

这里有一个地图的例子：

             11 | . . . . . . . . . .
             10 | . . . . * . . . . .
              9 | . . . . . . . . . .
              8 | . . . * . * . . . .
              7 | . . . . . . . * . .
              6 | . . * . . * . . . H
              5 | * . . . . . . . . .
              4 | . . . * . . . * . .
              3 | . K . . . . . . . .
              2 | . . . * . . . . . *
              1 | . . * . . . . * . .
              0 ----------------------
                                    1
                0 1 2 3 4 5 6 7 8 9 0
The Knight 可以按照下图中的A,B,C,D…这条路径用5次跳到草的地方（有可能其它路线的长度也是5）：

             11 | . . . . . . . . . .
             10 | . . . . * . . . . .
              9 | . . . . . . . . . .
              8 | . . . * . * . . . .
              7 | . . . . . . . * . .
              6 | . . * . . * . . . F<
              5 | * . B . . . . . . .
              4 | . . . * C . . * E .
              3 | .>A . . . . D . . .
              2 | . . . * . . . . . *
              1 | . . * . . . . * . .
              0 ----------------------
                                    1
                0 1 2 3 4 5 6 7 8 9 0
注意： 数据保证一定有解。

输入格式
第1行： 两个数，表示农场的列数C(C<=150)和行数R(R<=150)。

第2..R+1行: 每行一个由C个字符组成的字符串，共同描绘出牧场地图。

输出格式
一个整数，表示跳跃的最小次数。

输入样例：
10 11
..........
....*.....
..........
...*.*....
.......*..
..*..*...H
*.........
...*...*..
.K........
...*.....*
..*....*..
输出样例：
5
 */
import java.util.Scanner;
public class Acwing188 {

    static int N = 200;
    static char[][] g = new char[N][N];
    static int[][] d = new int[N][N];
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    static class PII {
        int x;
        int y;

        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;
    static PII[] q = new PII[N * N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        for (int i = 0; i < n; i++) g[i] = sc.next().toCharArray();
        int sx = 0;
        int sy = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 'K') {
                    sx = i;
                    sy = j;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                d[i][j] = -1;
            }
        }
        System.out.println(bfs(sx, sy));
    }

    static int bfs(int sx, int sy) {
        q[0] = new PII(sx, sy);
        int hh = 0;
        int tt = 0;
        d[sx][sy] = 0;
        while (hh <= tt) {
            PII t = q[hh++];
            for (int i = 0; i < 8; i++) {
                int a = t.x + dx[i];
                int b = t.y + dy[i];
                if (a < 0 || a >= n || b < 0 || b >= m) continue;
                if (g[a][b] == '*') continue;
                if (d[a][b] != -1) continue;
                if (g[a][b] == 'H') return d[t.x][t.y] + 1;
                d[a][b] = d[t.x][t.y] + 1;
                q[++tt] = new PII(a, b);

            }
        }
        return -1;
    }
}
