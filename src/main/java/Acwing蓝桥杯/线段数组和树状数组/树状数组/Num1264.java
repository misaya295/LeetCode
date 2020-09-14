package Acwing蓝桥杯.线段数组和树状数组.树状数组;


/*
给定 n 个数组成的一个数列，规定有两种操作，一是修改某个元素，二是求子数列 [a,b] 的连续和。

输入格式
第一行包含两个整数 n 和 m，分别表示数的个数和操作次数。

第二行包含 n 个整数，表示完整数列。

接下来 m 行，每行包含三个整数 k,a,b （k=0，表示求子数列[a,b]的和；k=1，表示第 a 个数加 b）。

数列从 1 开始计数。

输出格式
输出若干行数字，表示 k=0 时，对应的子数列 [a,b] 的连续和。

数据范围
1≤n≤100000,
1≤m≤100000，
1≤a≤b≤n
输入样例：
10 5
1 2 3 4 5 6 7 8 9 10
1 1 5
0 1 3
0 4 8
1 7 5
0 4 8
输出样例：
11
30
35
 */
import java.util.Scanner;

import java.io.*;
import java.util.*;
/**
 * 线段树
 */
public class Num1264{
    static class Node{
        int l, r, sum;
        Node(int sum, int l, int r){
            this.l = l;
            this.r = r;
            this.sum = sum;
        }
    }
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int N = 100010;
    private static int[] arr = new int[N];
    private static Node[] tree = new Node[N * 4];

    public static void main(String[] args) throws IOException{
        String[] ss = br.readLine().split(" ");
        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);
        ss = br.readLine().split(" ");
        for(int i=1 ; i<=n ; i++)
            arr[i] = Integer.parseInt(ss[i-1]);
        initTree(1, 1, n);
        while(m-- != 0){
            ss = br.readLine().split(" ");
            int k = Integer.parseInt(ss[0]);
            int a = Integer.parseInt(ss[1]);
            int b = Integer.parseInt(ss[2]);
            if(k == 1) //add
                add(1, a, b);
            else  //query
                bw.write(query(1, a, b) + "\n");
        }

        bw.close();
        br.close();
    }
    private static void initTree(int u, int l, int r){

        if(l == r){
            tree[u] = new Node(arr[l], l, r);
        }
        else{
            tree[u] = new Node(0, l, r);
            int mid = l + r >> 1;
            initTree(u << 1, l, mid);
            initTree(u << 1 | 1, mid + 1, r);
            pushUp(u);
        }
    }
    private static void pushUp(int u){
        tree[u].sum = tree[u << 1].sum + tree[u << 1 | 1].sum;
    }
    private static void add(int u, int a, int b){
        if(tree[u].l == tree[u].r){
            tree[u].sum += b;
        }else{
            int mid = tree[u].l + tree[u].r >> 1;
            if(a <= mid)
                add(u << 1, a, b);
            else
                add(u << 1 | 1, a, b);
            pushUp(u);
        }
    }
    private static int query(int u, int l, int r){
        if(l <= tree[u].l && r >= tree[u].r)
            return tree[u].sum;
        int mid = tree[u].l + tree[u].r >> 1;
        int sum = 0;
        if(l <= mid)
            sum += query(u << 1, l, r);
        if(r >= mid+1)
            sum += query(u << 1 | 1, l, r);
        return sum;
    }

}



/*
树状数组
 */
//public class Num1264 {
//
//
//    static int N = 100010;
//    static Scanner scanner = new Scanner(System.in);
//    static int n = scanner.nextInt();
//    static int m = scanner.nextInt();
//    static int[] a = new int[N];
//    static int[] tr = new int[N];
//    public static void main(String[] args) {
//        for (int i = 1; i <= n;i++) {
//            a[i] = scanner.nextInt();
//        }
//        for (int i = 1; i <= n; i++) {
//            add(i, a[i]);
//        }
//        while (m-- > 0) {
//            int k, x, y;
//            k = scanner.nextInt();
//            x = scanner.nextInt();
//            y = scanner.nextInt();
//
//            if (k == 0) {
//                System.out.println(query(y) - query(x - 1));
//            } else {
//                add(x, y);
//            }
//        }
//    }
//    public static int lowbit(int x) {
//        return x & -x;
//    }
//    public static void add(int x, int v) {
//        for (int i = x; i <= n; i += lowbit(i)) {
//            tr[i] += v;
//        }
//    }
//    public static int query(int x) {
//        int res = 0;
//        for (int i = x; i > 0; i -= lowbit(i)) {
//            res += tr[i];
//        }
//        return res;
//    }
//}



