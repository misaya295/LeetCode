package 蓝桥杯.练习系统.基础练习;


import java.util.Scanner;

/**
 * 问题描述
 * 杨辉三角形又称Pascal三角形，它的第i+1行是(a+b)i的展开式的系数。
 *
 *
 * 它的一个重要性质是：三角形中的每个数字等于它两肩上的数字相加。
 *
 *
 * 下面给出了杨辉三角形的前4行：
 *
 *
 *    1
 *
 *
 *   1 1
 *
 *
 *  1 2 1
 *
 *
 * 1 3 3 1
 *
 *
 * 给出n，输出它的前n行。
 */
public class Main4 {


        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int rows = n;

            for(int i =0;i<rows;i++) {
                int number = 1;
                //打印空格字符串
                System.out.println();
                System.out.format("%"+(rows-i)*2+"s","");
                for(int j=0;j<=i;j++) {

                    System.out.format("%4d",number);
                    number = number * (i - j) / (j + 1);
                }
                System.out.println();
            }
        }

}
