package Acwing提高课.search.Flood_fill;



/*
1097. 池塘计数
   题目
   提交记录
   讨论
   题解
   视频讲解

农夫约翰有一片 N∗M 的矩形土地。

最近，由于降雨的原因，部分土地被水淹没了。

现在用一个字符矩阵来表示他的土地。

每个单元格内，如果包含雨水，则用”W”表示，如果不含雨水，则用”.”表示。

现在，约翰想知道他的土地中形成了多少片池塘。

每组相连的积水单元格集合可以看作是一片池塘。

每个单元格视为与其上、下、左、右、左上、右上、左下、右下八个邻近单元格相连。

请你输出共有多少片池塘，即矩阵中共有多少片相连的”W”块。

输入格式
第一行包含两个整数 N 和 M。

接下来 N 行，每行包含 M 个字符，字符为”W”或”.”，用以表示矩形土地的积水状况，字符之间没有空格。

输出格式
输出一个整数，表示池塘数目。

数据范围
1≤N,M≤1000
输入样例：
10 12
W........WW.
.WWW.....WWW
....WW...WW.
.........WW.
.........W..
..W......W..
.W.W.....WW.
W.W.W.....W.
.W.W......W.
..W.......W.
输出样例：
3
 */
import java.util.Scanner;
public class Acwing1097 {
    static int N =1010;
    static int n,m;
    static char[][] g = new char[N][N];
    static boolean[][] st = new boolean[N][N];
    static int cnt=0;
    static PII[] q = new PII[N * N];
    static class PII{
        int x;
        int y;
        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static void bfs(int sx, int sy) {
        int hh = 0;
        int tt = 0;
        q[0] = new PII(sx, sy);
        st[sx][sy] = true;
        while (hh <= tt) {
            PII t = q[hh++];
            for (int i = t.x - 1; i <= t.x + 1; i++) {
                for (int j = t.y - 1; j <= t.y + 1; j++) {
                    if(i == t.x && j == t.y) continue;
                    if(i<0 || i >= n|| j <0|| j >= m) continue;
                    if(g[i][j] == '.' || st[i][j]) continue;
                    q[++tt] = new PII(i, j);
                    st[i][j] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++){
            g[i] = sc.next().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(g[i][j] == 'W' && !st[i][j]){
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
