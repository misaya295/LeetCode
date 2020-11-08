package Acwing提高课.search.Flood_fill;


/*
1106. 山峰和山谷
   题目
   提交记录
   讨论
   题解
   视频讲解

FGD小朋友特别喜欢爬山，在爬山的时候他就在研究山峰和山谷。

为了能够对旅程有一个安排，他想知道山峰和山谷的数量。

给定一个地图，为FGD想要旅行的区域，地图被分为 n×n 的网格，每个格子 (i,j) 的高度 w(i,j) 是给定的。

若两个格子有公共顶点，那么它们就是相邻的格子，如与 (i,j) 相邻的格子有(i−1,j−1),(i−1,j),(i−1,j+1),(i,j−1),(i,j+1),(i+1,j−1),(i+1,j),(i+1,j+1)。

我们定义一个格子的集合 S 为山峰（山谷）当且仅当：

S 的所有格子都有相同的高度。
S 的所有格子都连通。
对于 s 属于 S，与 s 相邻的 s′ 不属于 S，都有 ws>ws′（山峰），或者 ws<ws′（山谷）。
如果周围不存在相邻区域，则同时将其视为山峰和山谷。
你的任务是，对于给定的地图，求出山峰和山谷的数量，如果所有格子都有相同的高度，那么整个地图即是山峰，又是山谷。

输入格式
第一行包含一个正整数 n，表示地图的大小。

接下来一个 n×n 的矩阵，表示地图上每个格子的高度 w。

输出格式
共一行，包含两个整数，表示山峰和山谷的数量。

数据范围
1≤n≤1000,
0≤w≤109
输入样例1：
5
8 8 8 7 7
7 7 8 8 7
7 7 7 7 7
7 8 8 7 8
7 8 8 8 8
输出样例1：
2 1
输入样例2：
5
5 7 8 3 1
5 5 7 6 6
6 6 6 2 8
5 7 2 5 8
7 1 0 1 7
输出样例2：
3 3
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Acwing1106 {
    static int N = 1010;
    static int n;
    static boolean has_higher;
    static boolean has_lower;
    static int[][] g = new int[N][N];
    static boolean[][] st = new boolean[N][N];
    static void bfs(int x,int y)
    {
        Queue<PIIs> q = new LinkedList<PIIs>();
        q.add(new PIIs(x,y));
        st[x][y] = true;
        while(!q.isEmpty())
        {
            PIIs t = q.poll();
            for(int i = t.x - 1;i <= t.x + 1;i ++)
            {
                for(int j = t.y - 1;j <= t.y + 1;j ++)
                {
                    if(i == t.x && j == t.y) continue;
                    if(i < 0 || i >= n || j < 0 || j >= n) continue;
                    /*if(st[i][j]) continue;*/
                    if(g[i][j] != g[t.x][t.y])
                    {
                        if(g[i][j] > g[t.x][t.y]) has_higher = true;
                        else has_lower = true;
                    }
                    else if(!st[i][j])
                    {
                        q.add(new PIIs(i,j));
                        st[i][j] = true;
                    }
                }
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine().trim());
        for(int i = 0;i < n;i ++)
        {
            String[] s1 = reader.readLine().split(" ");
            for(int j = 0;j < n;j ++)
            {
                g[i][j] = Integer.parseInt(s1[j]);
            }
        }
        int peak = 0, valley = 0;
        for(int i = 0;i < n;i ++)
        {
            for(int j = 0;j < n;j ++)
            {
                if(!st[i][j])
                {
                    has_higher = false;
                    has_lower = false;

                    bfs(i,j);
                    if(!has_higher) peak ++;
                    if(!has_lower) valley ++;

                }
            }
        }
        System.out.println(peak + " " + valley);
    }
}
class PIIs
{
    public int x;
    public int y;
    public PIIs(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
}

