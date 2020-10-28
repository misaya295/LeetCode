package 蓝桥杯.国赛;


/*
小明是个大胖子，或者说是个大大胖子，如果说正常人占用 1×1 的面积，小明要占用 5×5 的面积。

由于小明太胖了，所以他行动起来很不方便。

当玩一些游戏时，小明相比小伙伴就吃亏很多。

小明的朋友们制定了一个计划，帮助小明减肥。

计划的主要内容是带小明玩一些游戏，让小明在游戏中运动消耗脂肪。

走迷宫是计划中的重要环节。

朋友们设计了一个迷宫，迷宫可以看成是一个由 n×n 个方阵组成的方阵，正常人每次占用方阵中 1×1 的区域，而小明要占用 5×5 的区域。

小明的位置定义为小明最正中的一个方格。

迷宫四周都有障碍物。

为了方便小明，朋友们把迷宫的起点设置在了第 3 行第 3 列，终点设置在了第 n−2 行第 n−2 列。

小明在时刻 0 出发，每单位时间可以向当前位置的上、下、左、右移动单位 1 的距离，也可以停留在原地不动。

小明走迷宫走得很辛苦，如果他在迷宫里面待的时间很长，则由于消耗了很多脂肪，他会在时刻 k 变成一个胖子，只占用 3×3 的区域。

如果待的时间更长，他会在时刻 2k 变成一个正常人，只占用 1×1 的区域。

注意，当小明变瘦时迷宫的起点和终点不变。

请问，小明最少多长时间能走到迷宫的终点。

注意，小明走到终点时可能变瘦了也可能没有变瘦。

输入格式
输入的第一行包含两个整数 n,k。

接下来 n 行，每行一个由 n 个字符组成的字符串，字符为 + 表示为空地，字符为 * 表示为阻碍物。

输出格式
输出一个整数，表示答案。

数据范围
1≤n≤300,
1≤k≤1000
输入样例：
9 5
+++++++++
+++++++++
+++++++++
+++++++++
+++++++++
***+*****
+++++++++
+++++++++
+++++++++
输出样例：
16
 */
import java.util.*;

public class Acwing2548 {

    static int N =310;
    static int n;
    static int k;
    static class PII{
        int x;
        int y;
        int z;
        public PII(int x, int y,int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int INF = 0x3f3f3f3f;

    static int M = N * N * 3;
    static char[][] g = new char[N][N];
    static int[][][] d = new int[N][N][3];
    static PII[] q = new PII[M];
    static boolean[][][] st = new boolean[N][N][3];
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 1; i <= n; i++) g[i] = sc.next().toCharArray();

        System.out.println(bfs());



    }

    public static boolean check(int x, int y, int z) {

        for (int i = x - z; i <= x + z; i++) {
            if(i < 1 || i> n) return false;
            for (int j = y - z; j <= y + z; j++) {
                if(j < 1 || j> n) return false;
                if(g[i][j] == '*') return false;
            }
        }
        return true;
    }

    private static int bfs() {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= 3; k++) {
                    d[i][j][k] = -1;
                }
            }
        }
        int hh = 0, tt = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};


        d[3][3][2] = 0;
        q[tt++] = new PII(3, 3, 2);
        st[3][3][2] = true;

        while (hh != tt) {

            PII t = q[hh++];
            if(hh == N * N * 3) hh =0;

            int x = t.x, y = t.y, z = t.z;

            st[x][y][z] = false;
            for (int i = 0; i < 4; i++) {

                int a = x + dx[i];
                int b = y + dy[i];
                int c = z;
                int dist = d[x][y][z] + 1;
                while (c >= 0) {

                    dist = Math.max(dist, (2 - c) * k + 1);
                    if (check(a, b, c)) {
                        if (dist < d[a][b][c]) {
                            d[a][b][c] = dist;
                            if (!st[a][b][c]) {
                                q[tt++] = new PII(a, b, c);
                                if (tt== M) tt = 0;
                                st[a][b][c] = true;

                            }
                        }

                    }

                    c--;
                }
            }

        }

        int res = INF;
        for (int i = 0; i < 3; i++) res = Math.min(res, d[n - 2][n - 2][i]);
        return res;





    }


}
