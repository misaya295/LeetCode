package Acwing提高课.DP.最长上升子序列模型;


import sun.jvm.hotspot.tools.SysPropsDumper;

import java.util.Scanner;

/*
为了对抗附近恶意国家的威胁，R国更新了他们的导弹防御系统。

一套防御系统的导弹拦截高度要么一直 严格单调 上升要么一直 严格单调 下降。

例如，一套系统先后拦截了高度为3和高度为4的两发导弹，那么接下来该系统就只能拦截高度大于4的导弹。

给定即将袭来的一系列导弹的高度，请你求出至少需要多少套防御系统，就可以将它们全部击落。

输入格式
输入包含多组测试用例。

对于每个测试用例，第一行包含整数n，表示来袭导弹数量。

第二行包含n个不同的整数，表示每个导弹的高度。

当输入测试用例n=0时，表示输入终止，且该用例无需处理。

输出格式
对于每个测试用例，输出一个占据一行的整数，表示所需的防御系统数量。

数据范围
1≤n≤50
输入样例：
5
3 5 2 4 1
0
输出样例：
2
样例解释
对于给出样例，最少需要两套防御系统。

一套击落高度为3,4的导弹，另一套击落高度为5,2,1的导弹。
 */
public class Acwing187 {


    static int N = 60;
    static int n = 5;
    static int[] q = new int[N];
    static int[] up = new int[N];
    static int[] down = new int[N];

    static int ans = 0;
    static void dfs(int u, int su, int sd) {

        if(su+ sd >= ans) return;
        if(u == n) {
            ans = su + sd;
            return;
        }

        //情况1 将当前数当道上升子序列中
        int k = 0;
        while (k < su && up[k] >= q[u]) k++;
        int t = up[k];
        up[k] = q[u];
        if(k < su) dfs(u + 1, su, sd);
        else dfs(u + 1, su + 1, sd);
        up[k] = t;


        //情况2 将当前数放到下降子序列中
        k = 0;
        while (k < sd && down[k] <= q[u]) k++;
        t = down[k];
        down[k] = q[u];
        if (k < sd) dfs(u + 1, su, sd);
        else dfs(u + 1, su, sd + 1);



    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            n=sc.nextInt();
            if(n==0){
                return;
            }
            for(int i=0;i<n;i++){
                q[i]=sc.nextInt();
            }
            ans = n;
            dfs(0, 0, 0);
            System.out.println(ans);

        }
//        for(int i=0;i< n;i++) System.out.print(q[i] + " ");

    }
}
