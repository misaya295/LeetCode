package Acwing蓝桥杯.双指针_BFS_图论.BFS;

/*
很久以前，T王国空前繁荣。

为了更好地管理国家，王国修建了大量的快速路，用于连接首都和王国内的各大城市。

为节省经费，T国的大臣们经过思考，制定了一套优秀的修建方案，使得任何一个大城市都能从首都直接或者通过其他大城市间接到达。

同时，如果不重复经过大城市，从首都到达每个大城市的方案都是唯一的。

J是T国重要大臣，他巡查于各大城市之间，体察民情。

所以，从一个城市马不停蹄地到另一个城市成了J最常做的事情。

他有一个钱袋，用于存放往来城市间的路费。

聪明的J发现，如果不在某个城市停下来修整，在连续行进过程中，他所花的路费与他已走过的距离有关，在走第x千米到第x+1千米这一千米中（x是整数），他花费的路费是x+10这么多。也就是说走1千米花费11，走2千米要花费23。

J大臣想知道：他从某一个城市出发，中间不休息，到达另一个城市，所有可能花费的路费中最多是多少呢？

输入格式
输入的第一行包含一个整数 n，表示包括首都在内的T王国的城市数。

城市从 1 开始依次编号，1 号城市为首都。

接下来 n−1 行，描述T国的高速路（T国的高速路一定是 n−1 条）。

每行三个整数 Pi,Qi,Di，表示城市 Pi 和城市 Qi 之间有一条双向高速路，长度为 Di 千米。

输出格式
输出一个整数，表示大臣J最多花费的路费是多少。

数据范围
1≤n≤105,
1≤Pi,Qi≤n,
1≤Di≤1000
输入样例：
5
1  2  2
1  3  1
2  4  5
2  5  4
输出样例：
135
 */

import java.util.*;

public class Num1207{

    static int N=100010;
    static class Node
    {
        int id;
        int w;

        public Node(int id, int w) {
            this.id = id;
            this.w = w;
        }
    }

    static ArrayList[] map = new ArrayList[N];
    static int[] dist = new int[N];



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < N; i++) {
            map[i] = new ArrayList<Node>();
        }

        int n = sc.nextInt();

        while (n-- > 1) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            int dis = sc.nextInt();
//            System.out.println(a+" "+b+" "+dis);
            //领接表
            map[a].add(new Node(b, dis));
            map[b].add(new Node(a, dis));

        }
        dfs(1, -1, 0);

        int u1 = -1;
        int max1 = Integer.MIN_VALUE;
        for(int i=1;i<N;i++) {
            if(dist[i]>max1){
                max1 = dist[i];
                u1 = i;
            }
        }
        dfs(u1,-1,0);
        long max2 = Integer.MIN_VALUE;
        for(int i2=1;i2<N;i2++) {
            if(dist[i2]>max2){
                max2 = dist[i2];
            }
        }
        System.out.println((21+max2)*max2/2);



    }

    private static void dfs(int u, int parent, int distance)
    {
        dist[u] = distance;
        for (Object n : map[u]) {

            Node nn = (Node) n;
            if (nn.id != parent) dfs(nn.id, u, distance + nn.w);
        }
    }


    //    static int N = 100010,M = 200010;
//    static int[] h = new int[N];
//    static int[] e = new int[M];
//    static int[] ne = new int[M];
//    static int[] w = new int[M];
//    static int[] dist = new int[N];
//    static int idx = 0;
//    static void add(int a,int b,int c)
//    {
//        e[idx] = b;
//        w[idx] = c;
//        ne[idx] = h[a];
//        h[a] = idx ++;
//    }
//    static void dfs(int u,int father,int distance)
//    {
//        dist[u] = distance;
//        for(int i = h[u];i != -1;i = ne[i])
//        {
//            int j = e[i];
//            if(j != father)
//                dfs(j,u,distance + w[i]);
//        }
//
//    }
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        Arrays.fill(h,-1);
//        for(int i = 0;i < n - 1;i ++)
//        {
//            int a = scan.nextInt();
//            int b = scan.nextInt();
//            int c = scan.nextInt();
//            add(a,b,c);
//            add(b,a,c);
//        }
//        //找到任意点x找到距离最远的点y
//        dfs(1,-1,0);
//
//        int u = 1;
//        for(int i = 2;i <= n;i ++)
//            if(dist[i] > dist[u])
//                u = i;
//        //找到离y最远的点的距离
//        dfs(u,-1,0);
//        int maxv = dist[1];
//        for(int i = 2;i <= n;i ++)
//        {
//            if(dist[i] > maxv)
//                maxv = dist[i];
//        }
//
//        System.out.println(maxv * 10 + ((long)(maxv + 1) * maxv ) / 2);
//    }
}



