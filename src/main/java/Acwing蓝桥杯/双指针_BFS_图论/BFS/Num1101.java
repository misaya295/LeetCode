package Acwing蓝桥杯.双指针_BFS_图论.BFS;



/*
阿尔吉侬是一只聪明又慵懒的小白鼠，它最擅长的就是走各种各样的迷宫。

今天它要挑战一个非常大的迷宫，研究员们为了鼓励阿尔吉侬尽快到达终点，就在终点放了一块阿尔吉侬最喜欢的奶酪。

现在研究员们想知道，如果阿尔吉侬足够聪明，它最少需要多少时间就能吃到奶酪。

迷宫用一个 R×C 的字符矩阵来表示。

字符 S 表示阿尔吉侬所在的位置，字符 E 表示奶酪所在的位置，字符 # 表示墙壁，字符 . 表示可以通行。

阿尔吉侬在 1 个单位时间内可以从当前的位置走到它上下左右四个方向上的任意一个位置，但不能走出地图边界。

输入格式
第一行是一个正整数 T，表示一共有 T 组数据。

每一组数据的第一行包含了两个用空格分开的正整数 R 和 C，表示地图是一个 R×C 的矩阵。

接下来的 R 行描述了地图的具体内容，每一行包含了 C 个字符。字符含义如题目描述中所述。保证有且仅有一个 S 和 E。

输出格式
对于每一组数据，输出阿尔吉侬吃到奶酪的最少单位时间。

若阿尔吉侬无法吃到奶酪，则输出“oop!”（只输出引号里面的内容，不输出引号）。

每组数据的输出结果占一行。

数据范围
1<T≤10,
2≤R,C≤200
输入样例：
3
3 4
.S..
###.
..E.
3 4
.S..
.E..
....
3 4
.S..
####
..E.
输出样例：
5
1
oop!

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Num1101 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    //左下右上
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N = 210;
    static int[][] dist = new int[N][N];
    static char[][] chars;

    static class PII {
        int x;
        int y;

        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static PII start, end;
    static int R, C;

    public static void main(String[] args) throws IOException {
        int T = Integer.valueOf(in.readLine().trim());
        while (T-- > 0) {
            String[] s = in.readLine().split(" ");
            R = Integer.valueOf(s[0]);
            C = Integer.valueOf(s[1]);
            chars = new char[R][C];
            for (int i = 0; i < R; i++) {
                chars[i] = in.readLine().toCharArray();
            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (chars[i][j] == 'S') {
                        start = new PII(i, j);
                    }
                    if (chars[i][j] == 'E') {
                        end = new PII(i, j);
                    }
                }
            }
            //bfs搜索
            int bfs = bfs(start, end);
            if (bfs == -1) System.out.println("oop!");
            else System.out.println(bfs);
        }
    }

    static int bfs(PII start, PII end) {
        //初始化距离数组
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                dist[i][j] = -1;
            }
        }
        Queue<PII> q = new LinkedList<PII>();
        q.add(start);
        dist[start.x][start.y] = 0;
        while (q.size() != 0) {
            //出队
            PII head = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = head.x + dx[i];
                int y = head.y + dy[i];
                //判断是否出界
                if (x < 0 || x >= R || y < 0 || y >= C) continue;
                if (chars[x][y] == '#') continue;
                if (dist[x][y] != -1) continue;
                dist[x][y] = dist[head.x][head.y] + 1;
                if (x == end.x && y == end.y) return dist[x][y];
                q.add(new PII(x, y));
            }
        }
        return -1;
    }
}

