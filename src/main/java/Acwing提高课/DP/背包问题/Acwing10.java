package Acwing提高课.DP.背包问题;



/*
有 N 个物品和一个容量是 V 的背包。

物品之间具有依赖关系，且依赖关系组成一棵树的形状。如果选择一个物品，则必须选择它的父节点。

如下图所示：
QQ图片20181018170337.png

如果选择物品5，则必须选择物品1和2。这是因为2是5的父节点，1是2的父节点。

每件物品的编号是 i，体积是 vi，价值是 wi，依赖的父节点编号是 pi。物品的下标范围是 1…N。

求解将哪些物品装入背包，可使物品总体积不超过背包容量，且总价值最大。

输出最大价值。

输入格式
第一行有两个整数 N，V，用空格隔开，分别表示物品个数和背包容量。

接下来有 N 行数据，每行数据表示一个物品。
第 i 行有三个整数 vi,wi,pi，用空格隔开，分别表示物品的体积、价值和依赖的物品编号。
如果 pi=−1，表示根节点。 数据保证所有物品构成一棵树。

输出格式
输出一个整数，表示最大价值。

数据范围
1≤N,V≤100
1≤vi,wi≤100
父节点编号范围：

内部结点：1≤pi≤N;
根节点 pi=−1;
输入样例
5 7
2 3 -1
2 2 1
3 5 1
4 7 2
3 6 2
输出样例：
11
 */


import java.util.Arrays;
import java.util.Scanner;
public class Acwing10 {
    static int N = 110;
    static int n, m;
    static int[][] f = new int[N][N];
    static int[] v = new int[N];
    static int[] w = new int[N];
    static int h[] = new int[N];
    static int ne[] = new int[N];
    static int e[] = new int[N];
    static int idx;
    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    static void dfs(int u) {
        for (int i = h[u]; i != -1; i = ne[i]) {
            int son = e[i];
            dfs(e[i]);

            //分组背包
            for (int j = m - v[u]; j >= 0; j--) {
                for (int k = 0; k <= j; k++) {
                    f[u][j] = Math.max(f[u][j], f[u][j - k] + f[son][k]);
                }
            }
        }

        //将物品u加进去
        for (int i = m; i >= v[u]; i--) f[u][i] = f[u][i - v[u]] + w[u];
        for (int i = 0; i < v[u]; i++) f[u][i] = 0;

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h, -1);
        int root=0;
        for (int i = 1; i <= n; i++) {
            int p;
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            p = sc.nextInt();
            if(p== -1) root = i;
            else add(p, i);
        }

        dfs(root);

        System.out.println(f[root][m]);

    }


}
