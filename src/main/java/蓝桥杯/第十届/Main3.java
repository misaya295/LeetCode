package 蓝桥杯.第十届;


import java.util.Scanner;

/**
 *给定数列1, 1, 1, 3, 5, 9, 17, …，从第4 项开始，每项都是前3 项的和。求
 * 第20190324 项的最后4 位数字。
 答案 4659

 */
public class Main3 {


    static int N  =  30190324;

    static int mod =10000;

    static int n;


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] f = new int[n+10];
        f[1]=1;
        f[2]=1;
        f[3]=1;
       for(int i =4;i <= n;i++) f[i] = (f[i-1] + f[i-2]+f[i-3])% mod;



           System.out.print(f[n]);






    }



}
