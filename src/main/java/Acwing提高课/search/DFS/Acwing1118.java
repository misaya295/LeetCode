package Acwing提高课.search.DFS;





/*
1118. 分成互质组
   题目
   提交记录
   讨论
   题解
   视频讲解

给定 n 个正整数，将它们分组，使得每组中任意两个数互质。

至少要分成多少个组？

输入格式
第一行是一个正整数 n。

第二行是 n 个不大于10000的正整数。

输出格式
一个正整数，即最少需要的组数。

数据范围
1≤n≤10
输入样例：
6
14 20 33 117 143 175
输出样例：
3
 */
import java.util.Scanner;
public class Acwing1118 {
    static int N = 10;
    static int n;
    static int[] p = new int[N];
    static boolean[] st = new boolean[N];
    static int[][] group = new int[N][N];
    static int ans = N;
    static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
    static boolean check(int[] gruop, int gc, int i) {
        for (int j = 0; j < gc; j++) {
            if (gcd(p[gruop[j]],p[i])>1) return false;
        }
        return true;
    }
    static void dfs(int g,int gc,int tc,int start) {
        if(g >=  ans) return;
        if(tc == n) ans = g;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (!st[i] && check(group[g], gc, i)) {
                st[i] = true;
                group[g][gc] = i;
                dfs(g, gc + 1, tc + 1, i + 1);
                st[i] = false;
                flag = false;
            }
        }
        if (flag) dfs(g + 1, 0, tc, 0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) p[i] = sc.nextInt();
        dfs(1, 0, 0, 0);
        System.out.println(ans);
    }
}
