package Acwing蓝桥杯.双指针_BFS_图论.BFS;

import java.util.Scanner;

/*
有一间长方形的房子，地上铺了红色、黑色两种颜色的正方形瓷砖。

你站在其中一块黑色的瓷砖上，只能向相邻（上下左右四个方向）的黑色瓷砖移动。

请写一个程序，计算你总共能够到达多少块黑色的瓷砖。

输入格式
输入包括多个数据集合。

每个数据集合的第一行是两个整数 W 和 H，分别表示 x 方向和 y 方向瓷砖的数量。

在接下来的 H 行中，每行包括 W 个字符。每个字符表示一块瓷砖的颜色，规则如下

1）‘.’：黑色的瓷砖；
2）‘#’：白色的瓷砖；
3）‘@’：黑色的瓷砖，并且你站在这块瓷砖上。该字符在每个数据集合中唯一出现一次。

当在一行中读入的是两个零时，表示输入结束。

输出格式
对每个数据集合，分别输出一行，显示你从初始位置出发能到达的瓷砖数(记数时包括初始位置的瓷砖)。

数据范围
1≤W,H≤20
输入样例：
6 9
....#.
.....#
......
......
......
......
......
#@...#
.#..#.
0 0
输出样例：
45
 */
import java.util.Arrays;
public class Num1113 {
    static int N = 25;
    static int m;
    static int n;
    static char[][] g = new char[N][N];
    static boolean[][] st = new boolean[N][N];//记录该点是否遍历过
    static int[] dx = new int[] {-1,0,1,0};
    static int[] dy = new int[] {0,1,0,-1};
    static int dfs(int x,int y)
    {
        int cnt = 1;
        st[x][y] = true;
        for(int i = 0;i < 4;i++)
        {
            int a = x + dx[i];
            int b = y + dy[i];
            if(a < 0 || a >= n || b < 0 || b >= m) continue;
            if(g[a][b] != '.') continue;
            if(st[a][b]) continue;
            cnt += dfs(a,b);
        }
        return cnt;
    }
    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext())
        {
            m = scan.nextInt();
            n = scan.nextInt();
            if(m == 0 && n == 0) break;
            int x = 0;
            int y = 0;
            for(int i = 0;i < n;i ++)
            {
                Arrays.fill(st[i], false);
                char[] charArray = scan.next().toCharArray();
                for(int j = 0;j < m;j ++)
                {
                    g[i][j] = charArray[j];
                    if(g[i][j] == '@')
                    {
                        x = i;
                        y = j;
                    }
                }
            }
            System.out.println(dfs(x,y));
        }

    }
}
