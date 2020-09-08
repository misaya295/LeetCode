package Acwing蓝桥杯.数学与简单DP.数学;



/*
1211. 蚂蚁感冒
长 100 厘米的细长直杆子上有 n 只蚂蚁。

它们的头有的朝左，有的朝右。

每只蚂蚁都只能沿着杆子向前爬，速度是 1 厘米/秒。

当两只蚂蚁碰面时，它们会同时掉头往相反的方向爬行。

这些蚂蚁中，有 1 只蚂蚁感冒了。

并且在和其它蚂蚁碰面时，会把感冒传染给碰到的蚂蚁。

请你计算，当所有蚂蚁都爬离杆子时，有多少只蚂蚁患上了感冒。

输入格式
第一行输入一个整数 n, 表示蚂蚁的总数。

接着的一行是 n 个用空格分开的整数 Xi, Xi 的绝对值表示蚂蚁离开杆子左边端点的距离。

正值表示头朝右，负值表示头朝左，数据中不会出现 0 值，也不会出现两只蚂蚁占用同一位置。

其中，第一个数据代表的蚂蚁感冒了。

输出格式
输出1个整数，表示最后感冒蚂蚁的数目。

数据范围
1<n<50,
0<|Xi|<100
输入样例1：
3
5 -2 8
输出样例1：
1
输入样例2：
5
-10 8 -20 12 25
输出样例2：
3
 */
import java.util.Scanner;
public class Num1211 {

    static int N = 55;
    static Scanner s = new Scanner(System.in);
    static int n = s.nextInt();
    static int[] x = new int[N];


    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            x[i] = s.nextInt();
        }

        int left = 0, right = 0; //分别表示左边向右走蚂蚁数量和右边向左走的蚂蚁数量。

        int count = 0;
        for(int i = 1;i < n;i++)
        {
            if(x[i] > 0 && Math.abs(x[i]) < Math.abs(x[0])) left ++;
            else if(x[i] < 0 && Math.abs(x[i]) > Math.abs(x[0])) right ++;
        }
        if((x[0] > 0 && right == 0) || (x[0] < 0 && left == 0 )) System.out.println(1);
        else System.out.println(left + right + 1);



    }




}
