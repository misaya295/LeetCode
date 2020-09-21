package Acwing蓝桥杯.疑难杂题;



/*
给定一个长度为 N 的数组 A=[A1,A2,···AN]，数组中有可能有重复出现的整数。

现在小明要按以下方法将其修改为没有重复整数的数组。

小明会依次修改 A2,A3,···,AN。

当修改 Ai 时，小明会检查 Ai 是否在 A1∼Ai−1 中出现过。

如果出现过，则小明会给 Ai 加上 1；如果新的 Ai 仍在之前出现过，小明会持续给 Ai 加 1，直到 Ai 没有在 A1∼Ai−1 中出现过。

当 AN 也经过上述修改之后，显然 A 数组中就没有重复的整数了。

现在给定初始的 A 数组，请你计算出最终的 A 数组。

输入格式
第一行包含一个整数 N。

第二行包含 N 个整数 A1,A2,···,AN。

输出格式
输出 N 个整数，依次是最终的 A1,A2,···,AN。

数据范围
1≤N≤105,
1≤Ai≤106
输入样例：
5
2 1 1 3 4
输出样例：
2 1 3 4 5
 */
import java.util.Scanner;
public class Nu1242 {
    static int N = 1100010;
    static int[] p = new int[N];
    static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i < N; i++) {
            p[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            int x = scanner.nextInt();

            x = find(x);
            System.out.print(x+" ");
            p[x] = x + 1;
        }
    }
}
