package Acwing提高课.search.DFS;



/*
1116. 马走日
   题目
   提交记录
   讨论
   题解
   视频讲解

马在中国象棋以日字形规则移动。

请编写一段程序，给定 n∗m 大小的棋盘，以及马的初始位置 (x，y)，要求不能重复经过棋盘上的同一个点，计算马可以有多少途径遍历棋盘上的所有点。

输入格式
第一行为整数 T，表示测试数据组数。

每一组测试数据包含一行，为四个整数，分别为棋盘的大小以及初始位置坐标 n,m,x,y。

输出格式
每组测试数据包含一行，为一个整数，表示马能遍历棋盘的途径总数，若无法遍历棋盘上的所有点则输出 0。

数据范围
1≤T≤9,
1≤m,n≤9,
0≤x≤n−1,
0≤y≤m−1
输入样例：
1
5 4 0 0
输出样例：
32
 */
import java.util.Scanner;
public class Acwing1116 {
    static int N = 10;
    static int n, m, x, y;
    static int T;
    static boolean[][] st = new boolean[N][N];
    static int ans;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while (T-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();
            ans = 0;
            dfs(x, y, 1);
            System.out.println(ans);
        }
    }
    private static void dfs(int x, int y, int cnt) {
        if (cnt == n * m) {
            ans++;
            return;
        }
        st[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if (a < 0 || a >= n || b < 0 || b >= m) continue;
            if (st[a][b]) continue;
            cnt++;
            dfs(a, b, cnt);
            cnt--;
            st[a][b] = false;
        }
        st[x][y] = false;
    }
}
