package Acwing蓝桥杯.二分与前缀和;


import java.util.Scanner;

/**
 * 四平方和定理，又称为拉格朗日定理：
 *
 * 每个正整数都可以表示为至多 4 个正整数的平方和。
 *
 * 如果把 0 包括进去，就正好可以表示为 4 个数的平方和。
 *
 * 比如：
 *
 * 5=02+02+12+22
 * 7=12+12+12+22
 * 对于一个给定的正整数，可能存在多种平方和的表示法。
 *
 * 要求你对 4 个数排序：
 *
 * 0≤a≤b≤c≤d
 * 并对所有的可能表示法按 a,b,c,d 为联合主键升序排列，最后输出第一个表示法。
 *
 * 输入格式
 * 输入一个正整数 N。
 *
 * 输出格式
 * 输出4个非负整数，按从小到大排序，中间用空格分开。
 *
 * 数据范围
 * 0<N<5∗106
 * 输入样例：
 * 5
 * 输出样例：
 * 0 0 1 2
 * 难度：简单
 * 时/空限制：1s / 64MB
 * 总通过数：1042
 * 总尝试数：3513
 * 来源：第七届蓝桥杯省赛C++A/B组
 * 算法标签
 * 二分哈希
 */
public class Num1221 {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int a = 0, b = 0, c = 0, d = 0, l = 0, r = n;

        int sum = a * a + b * b + c * c + d * d;

        while (r - l > 1e-8) {

            int mid = l + r >> 1;

            if (sum >= mid) {
                r = mid;
                a--;
                b--;
                c--;
                d--;

            } else {
                l = mid;
                a++;
                b++;
                c++;
                d++;
            }
            if (sum == n) {
                System.out.println(a + " " + b + " " + c + " " + d);
            }
        }



//        for (int a = 0; a < n; a++) {
//            for (int b = 0; b < n; b++) {
//                for (int c = 0; c < n; c++) {
//                    for (int d = 0; d < n; d++) {
//                        if (a * a + b * b + c * c + d * d == n) {
//                            System.out.println(a + " " + b + " " + c + " " + d);
//                            return;
//                        }
//                    }
//                }
//            }
//        }

    }
}
