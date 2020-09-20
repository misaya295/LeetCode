package Acwing蓝桥杯.复杂DP;

/*
W 市的交通规划出现了重大问题，市政府下定决心在全市各大交通路口安排疏导员来疏导密集的车流。

但由于人员不足，W 市市长决定只在最需要安排人员的路口安排人员。

具体来说，W 市的交通网络十分简单，由 n 个交叉路口和 n−1 条街道构成，交叉路口路口编号依次为 0,1,…,n−1 。

任意一条街道连接两个交叉路口，且任意两个交叉路口间都存在一条路径互相连接。

经过长期调查，结果显示，如果一个交叉路口位于 W 市交通网最长路径上，那么这个路口必定拥挤不堪。

所谓最长路径，定义为某条路径 p=(v1,v2,…,vk)，路径经过的路口各不相同，且城市中不存在长度大于 k 的路径（因此最长路径可能不唯一）。

因此 W 市市长想知道哪些路口位于城市交通网的最长路径上。

输入格式
第一行包含一个整数 n。

之后 n−1 行每行两个整数 u,v，表示编号为 u 和 v 的路口间存在着一条街道。

输出格式
输出包括若干行，每行包括一个整数——某个位于最长路径上的路口编号。

为了确保解唯一，请将所有最长路径上的路口编号按编号顺序由小到大依次输出。

数据范围
1≤n≤2×105
输入样例：
10
0 1
0 2
0 4
0 6
0 7
1 3
2 5
4 8
6 9
输出样例：
0
1
2
3
4
5
6
8
9
 */
import java.util.Arrays;
import java.util.Scanner;
public class Num1078 {
    static int N = 2 * 100010,M = 2 * N;
    static int n;
    static int[] d1 = new int[N];//记录某个结点往下走的最大长度
    static int[] d2 = new int[N];//记录某个结点往下走的次大长度
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static int idx = 0;
    static int ans = 0;
    static boolean[] st = new boolean[N];
    static void add(int a,int b)
    {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }
    //返回从该点往下走的最大长度
    static int dfs1(int u,int father)
    {
        int first = 0,second = 0;
        for(int i = h[u];i != -1;i = ne[i])
        {
            int j = e[i];
            if(j == father) continue;
            int d = dfs1(j,u) + 1;
            if(d > d1[u])
            {
                d2[u] = d1[u]; second = first;
                d1[u] = d; first = j;

            }
            else if(d > d2[u])
            {
                d2[u] = d; second = j;
            }
        }
        ans = Math.max(ans, d1[u] + d2[u]);
        return d1[u];
    }
    //从该点往下找最大长度
    static void dfs2(int u)
    {
        st[u] = true;
        for(int i = h[u];i != -1;i = ne[i])
        {
            int j = e[i];
            //最大值
            if(d1[u] == d1[j] + 1) dfs2(j);
        }
    }
    //从该点往下找次大长度
    static void dfs3(int u)
    {
        st[u] = true;
        for(int i = h[u];i != -1;i = ne[i])
        {
            int j = e[i];
            //次大值
            if(d2[u] == d1[j] + 1) dfs2(j);
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        Arrays.fill(h, -1);
        for(int i = 0;i < n - 1;i ++)
        {
            int a = scan.nextInt();
            int b = scan.nextInt();
            add(a,b);
            add(b,a);
        }
        dfs1(0,-1);
        for(int i = 0;i < n ;i ++)
        {
            if(d1[i] + d2[i] == ans)
            {
                dfs2(i);
                dfs3(i);
            }
        }
        for(int i = 0;i < n;i ++)
        {
            if(st[i]) System.out.println(i);
        }
    }
}


