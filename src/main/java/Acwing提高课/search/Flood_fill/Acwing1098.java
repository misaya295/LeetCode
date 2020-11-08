package Acwing提高课.search.Flood_fill;


/*
1098. 城堡问题
   题目
   提交记录
   讨论
   题解
   视频讲解

    1   2   3   4   5   6   7
   #############################
 1 #   |   #   |   #   |   |   #
   #####---#####---#---#####---#
 2 #   #   |   #   #   #   #   #
   #---#####---#####---#####---#
 3 #   |   |   #   #   #   #   #
   #---#########---#####---#---#
 4 #   #   |   |   |   |   #   #
   #############################
           (图 1)

   #  = Wall
   |  = No wall
   -  = No wall

   方向：上北下南左西右东。
图1是一个城堡的地形图。

请你编写一个程序，计算城堡一共有多少房间，最大的房间有多大。

城堡被分割成 m∗n个方格区域，每个方格区域可以有0~4面墙。

注意：墙体厚度忽略不计。

输入格式
第一行包含两个整数 m 和 n，分别表示城堡南北方向的长度和东西方向的长度。

接下来 m 行，每行包含 n 个整数，每个整数都表示平面图对应位置的方块的墙的特征。

每个方块中墙的特征由数字 P 来描述，我们用1表示西墙，2表示北墙，4表示东墙，8表示南墙，P 为该方块包含墙的数字之和。

例如，如果一个方块的 P 为3，则 3 = 1 + 2，该方块包含西墙和北墙。

城堡的内墙被计算两次，方块(1,1)的南墙同时也是方块(2,1)的北墙。

输入的数据保证城堡至少有两个房间。

输出格式
共两行，第一行输出房间总数，第二行输出最大房间的面积（方块数）。

数据范围
1≤m,n≤50,
0≤P≤15
输入样例：
4 7
11 6 11 6 3 10 6
7 9 6 13 5 15 5
1 10 12 7 13 7 5
13 11 10 8 10 12 13
输出样例：
5
9
 */
import java.util.Scanner;
public class Acwing1098 {
    static int N =50;
    static int n,m;
    static boolean[][] st = new boolean[N][N];
    static class PII{
        int x;
        int y;

        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static PII[] q = new PII[N * N];
    static int[][] g = new int[N][N];
    private static int bfs(int sx, int sy) {
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};
        int hh = 0;
        int tt = 0;
        int ares = 0;
        q[0] = new PII(sx, sy);
        st[sx][sy] = true;
        while (hh <= tt) {
            PII t = q[hh++];
            ares++;
            for (int i = 0; i < 4; i++) {
                int a = t.x + dx[i];
                int b = t.y + dy[i];
                if(a <0 ||a>=n|| b <0|| b >= m) continue;
                if(st[a][b]) continue;
                if((g[t.x][t.y] >> i & 1) != 0) continue;
                q[++tt] = new PII(a, b);
                st[a][b] = true;
            }
        }
        return ares;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = sc.nextInt();
            }
        }
        int cnt = 0;
        int area = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!st[i][j]) {
                    area = Math.max(area, bfs(i, j));
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(area);
    }

}
