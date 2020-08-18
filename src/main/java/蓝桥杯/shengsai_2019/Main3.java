package 蓝桥杯.shengsai_2019;


/**
 *给定数列1, 1, 1, 3, 5, 9, 17, …，从第4 项开始，每项都是前3 项的和。求
 * 第20190324 项的最后4 位数字。
 */
public class Main3 {

    public static void main(String[] args) {


        int[] a = new int[20190325];
        a[1] = 1;
        a[2] = 1;
        a[3] = 1;
        for (int i = 4; i <= 20190324; i++) {
            a[i] = (a[i-1]+a[i-2]+a[i-3]) % 10000;
        }
        System.out.println(a[20190324]);

    }



}
