package Acwing蓝桥杯.线段数组和树状数组.线段树;




/*
1270. 数列区间最大值


输入一串数字，给你 M 个询问，每次询问就给你两个数字 X,Y，要求你说出 X 到 Y 这段区间内的最大数。

输入格式
第一行两个整数 N,M 表示数字的个数和要询问的次数；

接下来一行为 N 个数；

接下来 M 行，每行都有两个整数 X,Y。

输出格式
输出共 M 行，每行输出一个数。

数据范围
1≤N≤105,
1≤M≤106,
1≤X≤Y≤N,
数列中的数字均不超过231−1
输入样例：
10 2
3 2 4 5 6 8 1 2 9 7
1 4
3 8
输出样例：
5
8
 */
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Num1270 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Scanner sc = new Scanner(System.in);
    static final int  N = 100100;
    static int[] w = new int[N];
    static Node[] tr = new Node[4 * N];
    public static void main(String[] args) throws IOException {
        String[] input = bf.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] str = bf.readLine().split(" ");
        for(int i = 1; i <= n; i++) w[i] = Integer.parseInt(str[i - 1]);

        build(1,1,n);

        while(m -- > 0) {
            String[] s = bf.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            bw.write(query(1,x,y) + "\n");
//          System.out.println();
        }
        bw.close();
    }

    public static void pushUp(int u) {
        tr[u].maxv = Math.max(tr[u << 1].maxv, tr[u << 1 | 1].maxv);
    }

    public static void build(int u, int l, int r) {
        if(l == r)tr[u] = new Node(l,r,w[l]);
        else {
            tr[u] = new Node(l,r,0);
            int mid = l + r >> 1;
            build(u << 1, l , mid);build(u << 1 | 1, mid + 1, r);
            pushUp(u);
        }
    }

    public static int query(int u, int l, int r) {
        if(tr[u].l >= l && tr[u].r <= r) return tr[u].maxv;
        else {
            int mid = tr[u].l + tr[u].r >> 1;
            int maxx = 0;
            if(l <= mid) maxx = query(u << 1,l,r);
            if(r > mid) maxx = Math.max(maxx,query(u << 1 | 1, l, r));
            return maxx;
        }
    }


}
class Node{
    int l,r;
    int maxv;
    Node(int l, int r,int maxv){
        this.l = l;
        this.r = r;
        this.maxv = maxv;
    }
}

