package Acwing蓝桥杯.二分与前缀和;




/**
 * 给定一个浮点数n，求它的三次方根。
 *
 * 输入格式
 * 共一行，包含一个浮点数n。
 *
 * 输出格式
 * 共一行，包含一个浮点数，表示问题的解。
 *
 * 注意，结果保留6位小数。
 *
 * 数据范围
 * −10000≤n≤10000
 * 输入样例：
 * 1000.00
 * 输出样例：
 * 10.000000
 */
import java.util.Scanner;
public class Num790 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double n = s.nextDouble();

        double l = -10000;

        double r = 10000;


        while (r - l > 1e-8) {

            double mid = (l + r) / 2;

            if (mid * mid * mid >= n) {

                r = mid;

            } else {
                l = mid;
            }


        }

        System.out.println(String.format("%.6f", l));

    }
}
