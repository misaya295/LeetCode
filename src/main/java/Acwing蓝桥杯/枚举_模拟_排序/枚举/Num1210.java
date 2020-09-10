package Acwing蓝桥杯.枚举_模拟_排序.枚举;



/*
小明这些天一直在思考这样一个奇怪而有趣的问题：

在 1∼N 的某个排列中有多少个连号区间呢？

这里所说的连号区间的定义是：

如果区间 [L,R] 里的所有元素（即此排列的第 L 个到第 R 个元素）递增排序后能得到一个长度为 R−L+1 的“连续”数列，则称这个区间连号区间。

当 N 很小的时候，小明可以很快地算出答案，但是当 N 变大的时候，问题就不是那么简单了，现在小明需要你的帮助。

输入格式
第一行是一个正整数 N，表示排列的规模。

第二行是 N 个不同的数字 Pi，表示这 N 个数字的某一排列。

输出格式
输出一个整数，表示不同连号区间的数目。

数据范围
1≤N≤10000,
1≤Pi≤N
输入样例1：
4
3 2 4 1
输出样例1：
7
输入样例2：
5
3 4 2 5 1
输出样例2：
9
样例解释
第一个用例中，有 7 个连号区间分别是：[1,1],[1,2],[1,3],[1,4],[2,2],[3,3],[4,4]
第二个用例中，有 9 个连号区间分别是：[1,1],[1,2],[1,3],[1,4],[1,5],[2,2],[3,3],[4,4],[5,5]
 */
import java.util.Scanner;
public class Num1210 {

    static Scanner scanner = new Scanner(System.in);
    static int N = 10010;
    static int n = scanner.nextInt();

    static int[] a = new int[N];

    static int INF = 10000000;
    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int min = INF;
            int max = -INF;
            for (int j = i; j < n; j++) {

                max = Math.max(max, a[j]);
                min = Math.min(min, a[j]);
                if (max - min == j - i) {
                    res++;
                }

            }
        }
        System.out.println(res);



    }

}
