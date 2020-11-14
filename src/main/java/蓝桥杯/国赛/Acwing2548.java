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
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Acwing2548 {
    static int N = 310;
    static char[][] g = new char[N][N];
    static boolean[][] st = new boolean[N][N];
    static int[] dx = new int[] {0, -1, 0, 1};
    static int[] dy = new int[] {-1, 0, 1, 0};
    //有3种形态，例如长度是5 * 5，则中心是(x, y)，
    //对应的区域是左上角(x - 2, y - 2)，右上角(x + 2, y + 2)，左下角(x - 2, y + 2)，右下角(x + 2, y + 2)
    static int[] d = new int[] {2, 1, 0};
    static int n, k;
    static int bfs()
    {
        Queue<Edge> q = new LinkedList<Edge>();
        q.add(new Edge(3, 3, 0));
        st[3][3] = true;
        while(!q.isEmpty())
        {
            Edge t = q.poll();
            //将源点加入到队列
            q.add(new Edge(t.x, t.y, t.time + 1));

            //枚举4个方向
            for(int i = 0;i < 4;i ++)
            {
                int a = t.x + dx[i], b = t.y + dy[i];
                int fat = t.time / k >= 2 ? 0 : d[t.time / k];//判断有多胖
                if(st[a][b]) continue;
                if(a - fat < 1 || a + fat > n || b - fat < 1 || b + fat > n)
                    continue;
                //判断该区域是否有障碍物
                boolean flag = false;//初始没有障碍物
                for(int u = a - fat;u <= a + fat;u ++)
                    for(int v = b - fat;v <= b + fat;v ++)
                        if(g[u][v] == '*')
                            flag = true;
                if(flag) continue;
                if(a == n - 2 && b == n - 2) return t.time + 1;//到达终点

                st[a][b] = true;
                //加入到队列
                q.add(new Edge(a, b, t.time + 1));
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        k = scan.nextInt();
        for(int i = 1;i <= n;i ++)
        {
            char[] temp = scan.next().toCharArray();
            for(int j = 1;j <= n;j ++)
            {
                g[i][j] = temp[j - 1];
            }
        }

        System.out.println(bfs());
    }
}
class Edge
{
    int x, y, time;
    Edge(int x, int y, int time)
    {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}
