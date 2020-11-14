package 蓝桥杯.国赛.国赛_2019;


import java.util.Scanner;

/*
试题 H: 大胖子走迷宫
时间限制: 1.0s 内存限制: 512.0MB 本题总分：20 分
【问题描述】
小明是个大胖子，或者说是个大大胖子，如果说正常人占用 1 × 1 的面积，
小明要占用 5 × 5 的面积。
由于小明太胖了，所以他行动起来很不方便。当玩一些游戏时，小明相比
小伙伴就吃亏很多。
小明的朋友们制定了一个计划，帮助小明减肥。计划的主要内容是带小明
玩一些游戏，让小明在游戏中运动消耗脂肪。走迷宫是计划中的重要环节。
朋友们设计了一个迷宫，迷宫可以看成是一个由 n × n 个方阵组成的方阵，
正常人每次占用方阵中 1 × 1 的区域，而小明要占用 5 × 5 的区域。小明的位置
定义为小明最正中的一个方格。迷宫四周都有障碍物。
为了方便小明，朋友们把迷宫的起点设置在了第 3 行第 3 列，终点设置在
了第 n − 2 行第 n − 2 列。
小明在时刻 0 出发，每单位时间可以向当前位置的上、下、左、右移动单
位 1 的距离，也可以停留在原地不动。小明走迷宫走得很辛苦，如果他在迷宫
里面待的时间很长，则由于消耗了很多脂肪，他会在时刻 k 变成一个胖子，只
占用 3 × 3 的区域。如果待的时间更长，他会在时刻 2k 变成一个正常人，只占
用 1 × 1 的区域。注意，当小明变瘦时迷宫的起点和终点不变。
请问，小明最少多长时间能走到迷宫的终点。注意，小明走到终点时可能
变瘦了也可能没有变瘦。
【输入格式】
输入的第一行包含两个整数 n, k。
接下来 n 行，每行一个由 n 个字符组成的字符串，字符为 + 表示为空地，
字符为 * 表示为阻碍物。
试题 H: 大胖子走迷宫 11
第十届蓝桥杯大赛软件类决赛 Java 大学 B 组
【输出格式】
输出一个整数，表示答案。
【样例输入】
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
【样例输出】
16
【评测用例规模与约定】
对于 30% 的评测用例，1 ≤ n ≤ 50。
对于 60% 的评测用例，1 ≤ n ≤ 100。
对于所有评测用例，1 ≤ n ≤ 300，1 ≤ k ≤ 1000。
 */
public class Main8 {

    static int N = 1010;
    static int n, k;
    static char[][] g = new char[N][N];
    static boolean[][] st = new boolean[N][N];

    static int[] d = {2, 1, 0};
    static class PII {
        int x;
        int y;
        int time;

        public PII(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int[] dx = {0,-1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static PII[] q = new PII[N * N * 3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++) g[i] = sc.next().toCharArray();
        int res = bfs(2, 2);
        System.out.println(res);
    }

    /*
    他会在时刻 k 变成一个胖子，只
    占用 3 × 3 的区域。如果待的时间更长，
    他会在时刻 2k 变成一个正常人，只占
    用 1 × 1 的区域。注意，当小明变瘦时迷宫的起点和终点不变。
     */
    private static int bfs(int x, int y) {
        int hh = 0;
        int tt = 0;
        q[0] = new PII(x, y, 0);
        st[x][y] = true;
        while (hh <= tt) {

            PII t = q[hh++];
//            q[++tt] = new PII(t.x, t.y, t.time+1);
            for (int i = 0; i < 4; i++) {
                int a = t.x + dx[i];
                int b = t.y + dy[i];
                int fat = t.time / k >= 2 ? 0 : d[t.time / k];//判断有多胖
                if(a -fat< 0 || a + fat> n|| b  - fat< 0|| b + fat > n) continue;
                System.out.println(a + " " + b);
                if(st[a][b]) continue;
                boolean flag = false;
                for (int u = a - fat; u <= a + fat; u++) {
                    for (int c = b - fat; c <= b + fat; c++) {
                            if (g[u][c] == '*'){
                                flag = true;
                            }
                    }
                }
                if (flag) continue;
                st[a][b] = true;

                if(a == n-3 && b == n-3) return t.time + 1;
                q[++tt] = new PII(a, b, t.time + 1);
            }

        }
        return -1;
    }
}
