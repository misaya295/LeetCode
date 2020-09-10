package Acwing蓝桥杯.枚举_模拟_排序.枚举;

import java.util.Scanner;

/*
给定三个整数数组

A=[A1,A2,…AN],
B=[B1,B2,…BN],
C=[C1,C2,…CN],

请你统计有多少个三元组 (i,j,k) 满足：

1≤i,j,k≤N
Ai<Bj<Ck
输入格式
第一行包含一个整数 N。

第二行包含 N 个整数 A1,A2,…AN。

第三行包含 N 个整数 B1,B2,…BN。

第四行包含 N 个整数 C1,C2,…CN。

输出格式
一个整数表示答案。

数据范围
1≤N≤105,
0≤Ai,Bi,Ci≤105
输入样例：
3
1 1 1
2 2 2
3 3 3
输出样例：
27
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Num1236 {
    static int N = 100010;
    static int[] a = new int[N];
    static int[] b = new int[N];
    static int[] c = new int[N];
    static int[] acnt = new int[N];//acnt[i]表示在A中i这个值出现多少次
    static int[] ccnt = new int[N];//ccnt[i]表示在C中i这个值出现多少次
    static int[] as = new int[N];//记录在A中由多少个数小于B[i]
    static int[] cs = new int[N];//记录在C中由多少个数大于B[i]
    static int[] s = new int[N];//求从1到i中,所有数出现的次数的前缀和
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine().trim());
        String[] s1 = reader.readLine().split(" ");
        String[] s2 = reader.readLine().split(" ");
        String[] s3 = reader.readLine().split(" ");
        for(int i = 1;i <= n;i++) a[i] = Integer.parseInt(s1[i - 1]) + 1;
        for(int i = 1;i <= n;i++) b[i] = Integer.parseInt(s2[i - 1]) + 1;
        for(int i = 1;i <= n;i++) c[i] = Integer.parseInt(s3[i - 1]) + 1;

        //求as[]
        for(int i = 1;i <= n;i++) acnt[a[i]] ++;
        for(int i = 1;i <= N - 1;i++) s[i] = s[i - 1] + acnt[i];
        for(int i = 1;i <= n;i++) as[i] = s[b[i] - 1];

        //求cs[]
        for(int i = 1;i <= n;i++) ccnt[c[i]] ++;
        for(int i = 1;i <= N - 1;i++) s[i] = s[i - 1] + ccnt[i];
        for(int i = 1;i <= n;i++) cs[i] = s[N - 1] - s[b[i]];

        //枚举每个b[i]
        long res = 0;
        for(int i = 1;i <= n;i++) res += (long)as[i] * cs[i];
        System.out.println(res);
    }
}
