package 蓝桥杯.练习系统.基础练习;


/**
 * 资源限制
 * 时间限制：1.0s   内存限制：512.0MB
 * 问题描述
 * 　　153是一个非常特殊的数，它等于它的每位数字的立方和，即153=1*1*1+5*5*5+3*3*3。编程求所有满足这种条件的三位十进制数。
 * 输出格式
 * 　　按从小到大的顺序输出满足条件的三位十进制数，每个数占一行。
 */
public class Main3 {


    public static void main(String[] args) {
        for (int i = 99; i < 999; i++) {
            int a = i % 1000 / 100;
            int b = i % 100 / 10;
            int c = i % 10;


            if (a * a * a + b * b * b + c * c * c == i) {
                System.out.println(i);

            }


        }
    }
}
