package 蓝桥杯.练习系统.基础练习;



/**
 * 问题描述
 * 给出n个数，找出这n个数的最大值，最小值，和。
 *
 * 输入格式
 * 第一行为整数n，表示数的个数。
 *
 * 第二行有n个数，为给定的n个数，每个数的绝对值都小于10000。
 *
 * 输出格式
 * 输出三行，每行一个整数。第一行表示这些数中的最大值，第二行表示这些数中的最小值，第三行表示这些数的和。
 * 样例输入
 * 5
 * 1 3 -2 4 5
 * 样例输出
 * 5
 * -2
 * 11
 * 数据规模与约定
 * 1 <= n <= 10000。
 */


import java.util.*;
public class Main6 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();

        }

        su(arr);

    }


    public static void su(int[] arr) {


        Arrays.sort(arr);
        System.out.println(arr[arr.length-1]);
        System.out.println(arr[0]);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);


    }
}
