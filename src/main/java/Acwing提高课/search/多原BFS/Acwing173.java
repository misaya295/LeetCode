package Acwing提高课.search.多原BFS;



/*
173. 矩阵距离
   题目
   讨论
   题解
   视频讲解

给定一个N行M列的01矩阵A，A[i][j] 与 A[k][l] 之间的曼哈顿距离定义为：

dist(A[i][j],A[k][l])=|i−k|+|j−l|
输出一个N行M列的整数矩阵B，其中：

B[i][j]=min1≤x≤N,1≤y≤M,A[x][y]=1dist(A[i][j],A[x][y])
输入格式
第一行两个整数n,m。

接下来一个N行M列的01矩阵，数字之间没有空格。

输出格式
一个N行M列的矩阵B，相邻两个整数之间用一个空格隔开。

数据范围
1≤N,M≤1000
输入样例：
3 4
0001
0011
0110
输出样例：
3 2 1 0
2 1 0 0
1 0 0 1
 */
import java.io.*;
public class Acwing173 {
    static  int N=1010;
    static  int n,m;
    static class PII{
        int x;
        int y;
        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static char[][] g = new char[N][N];
    static int[][] d = new int[N][N];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static PII[] q = new PII[N * N];
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] s = in.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        for (int i = 0; i < n; i++) {
            g[i] = in.readLine().toCharArray();
        }

        bfs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                out.write(d[i][j]+ " ");
            }
            out.write("\n");
        }
        out.flush();

    }
    private static void bfs() {
        int hh = 0;
        int tt = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                d[i][j] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '1') {
                    d[i][j] = 0;
                    q[++tt] = new PII(i, j);
                }
            }
        }
        while (hh <= tt) {
            PII t = q[hh++];
            for (int i = 0; i < 4; i++) {
                int a = t.x + dx[i];
                int b = t.y + dy[i];
                if(a<0|| a>= n|| b<0 || b>= m) continue;
                if(d[a][b] !=-1) continue;
                d[a][b] = d[t.x][t.y] + 1;
                q[++tt] = new PII(a, b);
            }

        }
    }
}
