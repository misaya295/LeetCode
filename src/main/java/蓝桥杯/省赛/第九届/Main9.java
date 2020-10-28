package 蓝桥杯.省赛.第九届;


/*

标题：全球变暖
你有一张某海域NxN像素的照片，"."表示海洋、"#"表示陆地，如下所示：
.......
.##....
.##....
....##.
..####.
...###.
.......
其中"上下左右"四个方向上连在一起的一片陆地组成一座岛屿。例如上图就有2座岛屿。
由于全球变暖导致了海面上升，科学家预测未来几十年，岛屿边缘一个像素的范围会被海水淹没。
具体来说如果一块陆地像素与海洋相邻(上下左右四个相邻像素中有海洋)，它就会被淹没。
例如上图中的海域未来会变成如下样子：
.......
.......
.......
.......
....#..
.......
.......

请你计算：依照科学家的预测，照片中有多少岛屿会被完全淹没。
【输入格式】
第一行包含一个整数N。  (1 <= N <= 1000)
以下N行N列代表一张海域照片。
照片保证第1行、第1列、第N行、第N列的像素都是海洋。
【输出格式】
一个整数表示答案。

【输入样例】
7
0000000
0110000
0110000
0000110
0011110
0001110
0000000

【输出样例】
1




 */

import java.util.Scanner;
public class Main9 {

    static class PII{
        int x,y;

        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static int N =1010;
    static PII[] q = new PII[N * N];
    static char[][] g = new char[N][N];
    static int n;
    static int[][] d= new int[N][N];
    static boolean[][] st = new boolean[N][N];
    static int res = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i = 0; i < n; i++) g[i] = sc.next().toCharArray();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = -1;
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(g[i][j] == '#'  && !st[i][j]) bfs(i, j);
            }
        }
        System.out.println(res);



    }

    static void bfs(int x, int y) {


        int hh = 0, tt = 0;
        int total = 0;
        int bound = 0;
        q[0] = new PII(x, y);
        while (hh <= tt) {
            total++;
            PII t = q[hh++];
            boolean isbound = false;
            d[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int a = t.x + dx[i];
                int b = t.y + dy[i];

                if(a < 0 || a>=n || b< 0|| b>= n) continue;
                if (st[a][b]) continue;
                if (g[a][b] == '.'){
                    isbound = true;
                    continue;
                }
                q[++tt] = new PII(a, b);
                st[a][b] = true;

            }

            if (isbound) {
                bound++;
            }


        }

        if (bound == total && total !=0 && bound !=0) res++;


    }




}
