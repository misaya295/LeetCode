package Acwing蓝桥杯.复杂DP;
/*
在X森林里，上帝创建了生命之树。

他给每棵树的每个节点（叶子也称为一个节点）上，都标了一个整数，代表这个点的和谐值。

上帝要在这棵树内选出一个非空节点集 S，使得对于 S 中的任意两个点 a,b，都存在一个点列 {a,v1,v2,…,vk,b} 使得这个点列中的每个点都是 S 里面的元素，且序列中相邻两个点间有一条边相连。

在这个前提下，上帝要使得 S 中的点所对应的整数的和尽量大。

这个最大的和就是上帝给生命之树的评分。

经过 atm 的努力，他已经知道了上帝给每棵树上每个节点上的整数。

但是由于 atm 不擅长计算，他不知道怎样有效的求评分。

他需要你为他写一个程序来计算一棵树的分数。

输入格式
第一行一个整数 n 表示这棵树有 n 个节点。

第二行 n 个整数，依次表示每个节点的评分。

接下来 n−1 行，每行 2 个整数 u,v，表示存在一条 u 到 v 的边。

由于这是一棵树，所以是不存在环的。

树的节点编号从 1 到 n。

输出格式
输出一行一个数，表示上帝给这棵树的分数。

数据范围
1≤n≤105,
每个节点的评分的绝对值均不超过 106。

输入样例：
5
1 -2 -3 4 5
4 2
3 1
1 2
2 5
输出样例：
8
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Num1220 {
    static int N = 100010, M = N * 2;
    static int n;
    static int[] w = new int[N];
    static long[] f = new long[N];
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static int idx = 0;
    static void add(int a,int b)
    {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }
    static void dfs(int u,int father)
    {
        f[u] = w[u];

        for(int i = h[u];i != -1;i = ne[i])
        {
            int j = e[i];
            if(j == father) continue;
            dfs(j,u);
            f[u] += Math.max(f[j],0);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());

        String[] s1 = br.readLine().split(" ");
        for(int i = 1;i <= n;i ++) w[i] = Integer.parseInt(s1[i - 1]);
        Arrays.fill(h, -1);
        for(int i = 0;i < n - 1;i ++)
        {
            String[] s2 = br.readLine().split(" ");
            int a = Integer.parseInt(s2[0]);
            int b = Integer.parseInt(s2[1]);
            add(a,b);
            add(b,a);
        }
        dfs(1,-1);
        long res = f[1];
        for(int i = 2;i <= n;i ++) res = Math.max(res, f[i]);
        System.out.println(res);
    }
}

