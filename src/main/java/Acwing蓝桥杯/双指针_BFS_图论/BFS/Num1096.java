package Acwing蓝桥杯.双指针_BFS_图论.BFS;



/*
你现在被困在一个三维地牢中，需要找到最快脱离的出路！

地牢由若干个单位立方体组成，其中部分不含岩石障碍可以直接通过，部分包含岩石障碍无法通过。

向北，向南，向东，向西，向上或向下移动一个单元距离均需要一分钟。

你不能沿对角线移动，迷宫边界都是坚硬的岩石，你不能走出边界范围。

请问，你有可能逃脱吗？

如果可以，需要多长时间？

输入格式
输入包含多组测试数据。

每组数据第一行包含三个整数 L,R,C 分别表示地牢层数，以及每一层地牢的行数和列数。

接下来是 L 个 R 行 C 列的字符矩阵，用来表示每一层地牢的具体状况。

每个字符用来描述一个地牢单元的具体状况。

其中, 充满岩石障碍的单元格用”#”表示，不含障碍的空单元格用”.”表示，你的起始位置用”S”表示，终点用”E”表示。

每一个字符矩阵后面都会包含一个空行。

当输入一行为”0 0 0”时，表示输入终止。

输出格式
每组数据输出一个结果，每个结果占一行。

如果能够逃脱地牢，则输出”Escaped in x minute(s).”，其中X为逃脱所需最短时间。

如果不能逃脱地牢，则输出”Trapped!”。

数据范围
1≤L,R,C≤100
输入样例：
3 4 5
S....
.###.
.##..
###.#

#####
#####
##.##
##...

#####
#####
#.###
####E

1 3 3
S##
#E#
###

0 0 0
输出样例：
Escaped in 11 minute(s).
Trapped!
 */

import java.util.Scanner;

public class Num1096 {

    static int N = 110;
    static Scanner scanner = new Scanner(System.in);
    static int l;
    static int r;
    static int c;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static char[][][] g = new char[N][N][N];
    static int[][][] dist = new int[N][N][N];
    static Point[] q = new Point[N * N * N];

    public static void main(String[] args) {

        Point start = null, end = null;
        while (scanner.hasNext()) {

            l = scanner.nextInt();
            r = scanner.nextInt();
            c = scanner.nextInt();


            if (l == 0 && r == 0 && c == 0) {
                break;
            }
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    g[i][j] = scanner.next().toCharArray();


                    for (int k = 0; k < c; k++) {
                        char c = g[i][j][k];
                        if (c == 'S') {
                            start = new Point(i, j, k);
                        } else if (c == 'E') {
                            end = new Point(i, j, k);
                        }
                    }
                }
            }
            int distance = bfs(start, end);
            if (distance == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + distance + " minute(s).");
            }
        }
    }


    public static int bfs(Point start, Point end) {


        for (int i = 0; i < dist.length; i++) {

            for (int j = 0; j < dist[0].length; j++) {

                for (int k = 0; k < dist[1].length; k++) {
                    dist[i][j][k] = -1;
                }

            }

        }


        int hh = 0, tt = 0;
        q[0] = start;
        dist[start.x][start.y][start.z] = 0;
        while (hh <= tt) {
            Point t = q[hh++];

            for (int i = 0; i < 6; i++) {
                int x = t.x + dx[i];
                int y = t.y + dy[i];
                int z = t.z + dz[i];

                if (x < 0 || x >= l || y < 0 || y >= r || z < 0 || z >= c) {
                    continue;
                }
                if (g[x][y][z] == '#') {
                    continue;
                }
                if (dist[x][y][z] != -1) {
                    continue;
                }
                dist[x][y][z] = dist[t.x][t.y][t.z] + 1;
                if (x == end.x && y == end.y && z == end.z) {
                    return dist[x][y][z];
                }
                q[++tt] = new Point(x, y, z);
            }
        }
        return -1;

    }


}

class Point {
    int x, y, z;

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


}
