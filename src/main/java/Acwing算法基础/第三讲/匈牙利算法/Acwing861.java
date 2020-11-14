package Acwing算法基础.第三讲.匈牙利算法;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/*
861. 二分图的最大匹配
   题目
   提交记录
   讨论
   题解
   视频讲解

给定一个二分图，其中左半部包含n1个点（编号1~n1），右半部包含n2个点（编号1~n2），二分图共包含m条边。

数据保证任意一条边的两个端点都不可能在同一部分中。

请你求出二分图的最大匹配数。

二分图的匹配：给定一个二分图G，在G的一个子图M中，M的边集{E}中的任意两条边都不依附于同一个顶点，则称M是一个匹配。

二分图的最大匹配：所有匹配中包含边数最多的一组匹配被称为二分图的最大匹配，其边数即为最大匹配数。

输入格式
第一行包含三个整数 n1、 n2 和 m。

接下来m行，每行包含两个整数u和v，表示左半部点集中的点u和右半部点集中的点v之间存在一条边。

输出格式
输出一个整数，表示二分图的最大匹配数。

数据范围
1≤n1,n2≤500,
1≤u≤n1,
1≤v≤n2,
1≤m≤105
输入样例：
2 2 4
1 1
1 2
2 1
2 2
输出样例：
2

 */
public class Acwing861 {
    static int N =510;
    static int M = 100010;
    static int n1,n2, m;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static int idx;
    static int[] match = new int[N];
    static boolean[] st = new boolean[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h, -1);
        while (m-- > 0) {
            int a;
            int b;
            a = sc.nextInt();
            b = sc.nextInt();
            add(a, b);
        }
        int res = 0;
        for (int i = 1; i <= n1; i++) {
            Arrays.fill(st, false);
            if(find(i)) res++;
        }
        System.out.println(res);
    }
    private static boolean find(int x) {

        for (int i = h[x]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!st[j]) {
                st[j] = true;

                if (match[j] == 0 || find(match[j])) {
                    match[j] = x;
                    return true;
                }
            }
        }
        return false;
    }
    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
