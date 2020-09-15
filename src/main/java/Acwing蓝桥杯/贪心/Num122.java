package Acwing蓝桥杯.贪心;



/*
有n个小朋友坐成一圈，每人有a[i]个糖果。

每人只能给左右两人传递糖果。

每人每次传递一个糖果代价为1。

求使所有人获得均等糖果的最小代价。

输入格式
第一行输入一个正整数n，表示小朋友的个数。

接下来n行，每行一个整数a[i]，表示第i个小朋友初始得到的糖果的颗数。

输出格式
输出一个整数，表示最小代价。

数据范围
1≤n≤1000000
数据保证一定有解。

输入样例：
4
1
2
5
4
输出样例：
4
 */

import java.util.Arrays;
import java.util.Scanner;
public class Num122 {
    static int[] s = new int[1000010];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long sum = 0;
        for(int i = 1;i <= n;i++)
        {
            s[i] = scan.nextInt();
            sum += s[i];
        }
        //求平均值
        int avg = (int) (sum/n);
        //求减去平均值之后的数组的前缀和
        for(int i = 1;i <= n;i++)
        {
            s[i] = s[i] - avg + s[i - 1];
        }
        Arrays.sort(s, 1, n + 1);
        long res = 0;
        for(int i = 1;i <= n;i++) res += Math.abs(s[i] - s[(n + 1)/2]);
        System.out.println(res);
    }
}
