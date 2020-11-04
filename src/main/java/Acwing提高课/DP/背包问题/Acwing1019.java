package Acwing提高课.DP.背包问题;



/*
1019. 庆功会
   题目
   提交记录
   讨论
   题解
   视频讲解

为了庆贺班级在校运动会上取得全校第一名成绩，班主任决定开一场庆功会，为此拨款购买奖品犒劳运动员。

期望拨款金额能购买最大价值的奖品，可以补充他们的精力和体力。

输入格式
第一行二个数n，m，其中n代表希望购买的奖品的种数，m表示拨款金额。

接下来n行，每行3个数，v、w、s，分别表示第I种奖品的价格、价值（价格与价值是不同的概念）和能购买的最大数量（买0件到s件均可）。

输出格式
一行：一个数，表示此次购买能获得的最大的价值（注意！不是价格）。

数据范围
n≤500,m≤6000,
v≤100,w≤1000,s≤10
输入样例：
5 1000
80 20 4
40 50 9
30 50 7
40 30 6
20 20 1
输出样例：
1040
难度：简单
时/空限制：1s / 64MB
总通过数：1313
总尝试数：1741
来源：《信息学奥赛一本通》
算法标签

 */
import java.util.Scanner;
public class Acwing1019 {

    static int N = 6010;

    static int[] f = new int[N];
    static int n, m;
    static int v,w, s;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            v = sc.nextInt();
            w = sc.nextInt();
            s = sc.nextInt();
            for (int j = m; j >= 0; j--) {
                for (int k = 0; k <= s && k * v <= j; k++) f[j] = Math.max(f[j], f[j - k * v] + k * w);
            }
        }

        System.out.println(f[m]);




    }


}
