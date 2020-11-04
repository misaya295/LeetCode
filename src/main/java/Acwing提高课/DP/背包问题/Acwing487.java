package Acwing提高课.DP.背包问题;


/*
487. 金明的预算方案
   题目
   提交记录
   讨论
   题解
   视频讲解

金明今天很开心，家里购置的新房就要领钥匙了，新房里有一间金明自己专用的很宽敞的房间。

更让他高兴的是，妈妈昨天对他说：“你的房间需要购买哪些物品，怎么布置，你说了算，只要不超过N元钱就行”。

今天一早，金明就开始做预算了，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，下表就是一些主件与附件的例子：

QQ截图20190313024710.png

如果要买归类为附件的物品，必须先买该附件所属的主件。

每个主件可以有0个、1个或2个附件。

附件不再有从属于自己的附件。

金明想买的东西很多，肯定会超过妈妈限定的N元。

于是，他把每件物品规定了一个重要度，分为5等：用整数1~5表示，第5等最重要。

他还从因特网上查到了每件物品的价格（都是10元的整数倍）。

他希望在不超过N元（可以等于N元）的前提下，使每件物品的价格与重要度的乘积的总和最大。

设第j件物品的价格为v[j]，重要度为w[j]，共选中了k件物品，编号依次为j1，j2，…，jk，则所求的总和为：

v[j1]∗w[j1]+v[j2]∗w[j2]+…+v[jk]∗w[jk]（其中*为乘号）

请你帮助金明设计一个满足要求的购物单。

输入格式
输入文件的第1行，为两个正整数，用一个空格隔开：N m，其中N表示总钱数，m为希望购买物品的个数。

从第2行到第m+1行，第j行给出了编号为j-1的物品的基本数据，每行有3个非负整数v p q，其中v表示该物品的价格，p表示该物品的重要度（1~5），q表示该物品是主件还是附件。

如果q=0，表示该物品为主件，如果q>0，表示该物品为附件，q是所属主件的编号。

输出格式
输出文件只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（<200000）。

数据范围
N<32000,m<60,v<10000
输入样例：
1000 5
800 2 0
400 5 1
300 5 1
400 3 0
500 2 0
输出样例：
2200
 */
import java.io.*;
import java.util.*;

public class Acwing487 {

    private static class Good {
        int v;
        int w;

        public Good(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int N = Integer.parseInt(s1[0]);
        int M = Integer.parseInt(s1[1]);
        Good[] master = new Good[N + 1];
        List<Good>[] servent = new ArrayList[N + 1];
        for (int i = 1; i <= M; i++) {
            String[] s2 = br.readLine().split(" ");
            int v = Integer.parseInt(s2[0]);
            int p = Integer.parseInt(s2[1]);
            int q = Integer.parseInt(s2[2]);
            if (q == 0) {
                master[i] = new Good(v, v * p);
                servent[i] = new ArrayList<>();
            } else
                servent[q].add(new Good(v, v * p));
        }
        int[] dp = new int[N + 1];
        for (int i = 0; i < master.length; i++) {
            if (master[i] == null)
                continue;
            for (int j = N; j >= 0; j--) {
                for (int k = 0; k < (1 << servent[i].size()); k++) {
                    int v = master[i].v;
                    int w = master[i].w;
                    for (int t = 0; t < servent[i].size(); t++) {
                        if (((k >> t) & 1) == 1) {
                            v += servent[i].get(t).v;
                            w += servent[i].get(t).w;
                        }
                    }
                    if (j >= v)
                        dp[j] = Math.max(dp[j], dp[j - v] + w);
                }
            }
        }
        System.out.print(dp[N]);
    }
}
