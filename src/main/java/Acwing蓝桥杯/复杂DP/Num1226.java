package Acwing蓝桥杯.复杂DP;


/*
小明几乎每天早晨都会在一家包子铺吃早餐。

他发现这家包子铺有 N 种蒸笼，其中第 i 种蒸笼恰好能放 Ai 个包子。

每种蒸笼都有非常多笼，可以认为是无限笼。

每当有顾客想买 X 个包子，卖包子的大叔就会迅速选出若干笼包子来，使得这若干笼中恰好一共有 X 个包子。

比如一共有 3 种蒸笼，分别能放 3、4 和 5 个包子。

当顾客想买 11 个包子时，大叔就会选 2 笼 3 个的再加 1 笼 5 个的（也可能选出 1 笼 3 个的再加 2 笼 4 个的）。

当然有时包子大叔无论如何也凑不出顾客想买的数量。

比如一共有 3 种蒸笼，分别能放 4、5 和 6 个包子。

而顾客想买 7 个包子时，大叔就凑不出来了。

小明想知道一共有多少种数目是包子大叔凑不出来的。

输入格式
第一行包含一个整数 N。

接下来 N 行，每行包含一个整数 Ai。

输出格式
输出一个整数代表答案。

如果凑不出的数目有无限多个，输出INF。

数据范围
1≤N≤100,
1≤Ai≤100
输入样例1：
2
4
5
输出样例1：
6
输入样例2：
2
4
6
输出样例2：
INF
样例解释
对于样例1，凑不出的数目包括：1, 2, 3, 6, 7, 11。
对于样例2，所有奇数都凑不出来，所以有无限多个。
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Num1226 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N = 100 * 99 - 100 - 99;
    static int v[];
    static boolean f[];

    static void init() {
        f = new boolean[N + 1];
        v = new int[101];
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        init();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(br.readLine());
            f[v[i]] = true;
        }
        int c = v[0];
        for (int i = 1; i < n; i++) c = gcd(c, v[i]);
        if (c == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = v[i]; j <= N; j++)
                    f[j] = f[j] || f[j - v[i]];
            }
            int res = 0;
            for (int i = 1; i <= N; i++) {
                if (!f[i]) res++;
            }
            System.out.println(res);
        } else System.out.println("INF");

    }

}

