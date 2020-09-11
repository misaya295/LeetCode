package Acwing蓝桥杯.枚举_模拟_排序.模拟;



/*

X星球居民小区的楼房全是一样的，并且按矩阵样式排列。

其楼房的编号为 1,2,3…
当排满一行时，从下一行相邻的楼往反方向排号。

比如：当小区排号宽度为 6 时，开始情形如下：

1  2  3  4  5  6
12 11 10 9  8  7
13 14 15 .....
我们的问题是：已知了两个楼号 m 和 n，需要求出它们之间的最短移动距离（不能斜线方向移动）。

输入格式
输入共一行，包含三个整数 w,m,n，w 为排号宽度，m,n 为待计算的楼号。

输出格式
输出一个整数，表示 m,n 两楼间最短移动距离。

数据范围
1≤w,m,n≤10000,

输入样例：
6 8 2
输出样例：
4
难度：简单
时/空限制：1s / 64MB
总通过数：635
总尝试数：1473
来源：第六届蓝桥杯省赛C++B组
算法标签

 */
import java.util.Scanner;
public class Nun1219 {
    static Scanner sc = new Scanner(System.in);
    static int w= sc.nextInt();
    static int m= sc.nextInt();
    static int n= sc.nextInt();
    public static void main(String[] args) {
        m--;
        n--;
        int x1 = m / w;
        int x2 = n / w;
        int y1 = m % w;
        int y2 = n % w;
        if (x1 % 2 == 0) { y1 = w - 1 - y1; }
        if (x2 % 2 == 0) { y2 = w - 1 - y2;
        }
        System.out.println(Math.abs(x1-x2) + Math.abs(y1-y2));
    }

}




