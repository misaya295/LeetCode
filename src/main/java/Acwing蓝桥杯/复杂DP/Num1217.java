package Acwing蓝桥杯.复杂DP;
/*
赌圣atm晚年迷恋上了垒骰子，就是把骰子一个垒在另一个上边，不能歪歪扭扭，要垒成方柱体。

经过长期观察，atm 发现了稳定骰子的奥秘：有些数字的面贴着会互相排斥！

我们先来规范一下骰子：1 的对面是 4，2 的对面是 5，3 的对面是 6。

假设有 m 组互斥现象，每组中的那两个数字的面紧贴在一起，骰子就不能稳定的垒起来。

atm想计算一下有多少种不同的可能的垒骰子方式。

两种垒骰子方式相同，当且仅当这两种方式中对应高度的骰子的对应数字的朝向都相同。

由于方案数可能过多，请输出模 109+7 的结果。

输入格式
第一行包含两个整数 n,m，分别表示骰子的数目和排斥的组数。

接下来 m 行，每行两个整数 a,b，表示 a 和 b 数字不能紧贴在一起。

输出格式
共一个数，表示答案模 109+7 的结果。

数据范围
1≤n≤109,
1≤m≤36,
1≤a,b≤6
输入样例：
2 1
1 2
输出样例：
544
 */
import java.math.BigInteger;
import java.util.Scanner;

public class Num1217 {
    public static final int MOD = 1000000007;
    public static int init[] = { -1, 4, 5, 6, 1, 2, 3 }; // 骰子对面
    public static boolean conflict[][] = new boolean[7][7]; // 冲突

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            conflict[a][b] = conflict[b][a] = true;
        }

        // dp[i][j] 代表，i个骰子且最顶面是j的情况种数 并且使用了滚动dp，否则会超空间
        BigInteger dp[][] = new BigInteger[2][7];
        int e = 0;
        for (int i = 1; i < 7; i++)
            dp[e][i] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            e = 1 - e;
            for (int j = 1; j < 7; j++) {
                dp[e][j] = BigInteger.ZERO;
                for (int k = 1; k < 7; k++) {
                    if (!conflict[init[j]][k])
                        dp[e][j] = dp[e][j].add(dp[1 - e][k]).mod(
                                new BigInteger(MOD + ""));

                }
            }
        }

        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i < 7; i++) {
            sum = sum.add(dp[e][i]).mod(new BigInteger(MOD + ""));
        }

        System.out.println(sum.multiply(quickpow(4, n)).mod(
                new BigInteger(MOD + "")));
    }

    // 快速幂
    static BigInteger quickpow(int n, int m) {
        BigInteger n1 = new BigInteger(n + "");

        BigInteger t = BigInteger.ONE;
        while (m > 0) {
            if ((m & 1) == 1)
                t = t.multiply(n1).mod(new BigInteger(MOD + ""));
            n1 = n1.multiply(n1).mod(new BigInteger(MOD + ""));
            m >>= 1;
        }
        return t;
    }
}
