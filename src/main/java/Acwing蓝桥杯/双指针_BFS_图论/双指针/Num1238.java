package Acwing蓝桥杯.双指针_BFS_图论.双指针;




/*
小明维护着一个程序员论坛。现在他收集了一份”点赞”日志，日志共有 N 行。

其中每一行的格式是：

ts id
表示在 ts 时刻编号 id 的帖子收到一个”赞”。

现在小明想统计有哪些帖子曾经是”热帖”。

如果一个帖子曾在任意一个长度为 D 的时间段内收到不少于 K 个赞，小明就认为这个帖子曾是”热帖”。

具体来说，如果存在某个时刻 T 满足该帖在 [T,T+D) 这段时间内(注意是左闭右开区间)收到不少于 K 个赞，该帖就曾是”热帖”。

给定日志，请你帮助小明统计出所有曾是”热帖”的帖子编号。

输入格式
第一行包含三个整数 N,D,K。

以下 N 行每行一条日志，包含两个整数 ts 和 id。

输出格式
按从小到大的顺序输出热帖 id。

每个 id 占一行。

数据范围
1≤K≤N≤105,
0≤ts,id≤105,
1≤D≤10000
输入样例：
7 10 2
0 1
0 10
10 10
10 1
9 1
100 3
100 3
输出样例：
1
3
10
 */
import java.util.Arrays;
import java.util.Scanner;
public class Num1238 {

    static int N = 100010;
    static Scanner scanner = new Scanner(System.in);
    static int n,d, k;
    static PIIs[] logs = new PIIs[N];
    static  int[] cnt = new int[N];
    static boolean[] st = new boolean[N];


    public static void main(String[] args) {


        n = scanner.nextInt();
        d = scanner.nextInt();
        k = scanner.nextInt();

        for (int i = 0; i < n; i++) {

            int t = scanner.nextInt();int id = scanner.nextInt();
            logs[i] = new PIIs(t, id);

        }
        Arrays.sort(logs,0,n);
        for (int i = 0, j = 0; i < n; i++) {

            int id = logs[i].id;
            cnt[id]++;

            while (logs[i].t - logs[j].t >= d) {
                cnt[logs[j].id]--;
                j++;
            }


            if (cnt[id] >= k) {
                st[id] = true;
            }
        }


        for (int i = 0; i < 100000; i++) {
            if (st[i]) {
                System.out.println(i);
            }
        }


    }





}

class PIIs implements Comparable<PIIs> {

    public int t;
    public int id;

    public PIIs(int t, int id) {
        this.t = t;
        this.id = id;
    }

    @Override
    public int compareTo(PIIs o) {
        return Integer.compare(t,o.t);
    }
}
