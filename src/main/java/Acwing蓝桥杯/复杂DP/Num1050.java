package Acwing蓝桥杯.复杂DP;



/*
1050. 鸣人的影分身
   题目
   提交记录
   讨论
   题解
   视频讲解

在火影忍者的世界里，令敌人捉摸不透是非常关键的。

我们的主角漩涡鸣人所拥有的一个招数——多重影分身之术——就是一个很好的例子。

影分身是由鸣人身体的查克拉能量制造的，使用的查克拉越多，制造出的影分身越强。

针对不同的作战情况，鸣人可以选择制造出各种强度的影分身，有的用来佯攻，有的用来发起致命一击。

那么问题来了，假设鸣人的查克拉能量为 M，他影分身的个数最多为 N，那么制造影分身时有多少种不同的分配方法？

注意：

影分身可以分配0点能量。
分配方案不考虑顺序，例如：M=7,N=3，那么 (2,2,3) 和 (2,3,2) 被视为同一种方案。
输入格式
第一行是测试数据的数目 t。

以下每行均包含二个整数 M 和 N，以空格分开。

输出格式
对输入的每组数据 M 和 N，用一行输出分配的方法数。

数据范围
0≤t≤20,
1≤M,N≤10
输入样例：
1
7 3
输出样例：
8
 */
import java.util.Scanner;
public class Num1050 {
    static Scanner scanner = new Scanner(System.in);
    static int N = 11;
    static int t = scanner.nextInt();
    static int[][] f = new int[N][N];
    static int n;
    static int m;

    public static void main(String[] args) {
        while (t-- > 0) {
            m = scanner.nextInt();
            n = scanner.nextInt();
            f[0][0] = 1;
            for (int i = 0; i <= m; i++) {

                for (int j = 1; j <= n; j++) {

                    f[i][j] = f[i][j - 1];
                    if (i >= j) {
                        f[i][j] += f[i - j][j];
                    }
                }
            }
            System.out.println(f[m][n]);
        }

    }
}
