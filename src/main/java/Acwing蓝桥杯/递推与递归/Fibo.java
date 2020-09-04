package Acwing蓝桥杯.递推与递归;

import java.util.Scanner;

public class Fibo {


    static int[] F = new int[46];



    public static void main(String[] args) {


        Scanner scanne = new Scanner(System.in);
        int n = scanne.nextInt();

        int a = 0, b = 1;
        for (int i = 1; i <= n; i++) {
            int fn = a + b;
            a=b ;
            b = fn;

            System.out.print(fn+" ");
        }



//        Scanner s = new Scanner(System.in);
//
//        int n = s.nextInt();
////        System.out.println(f(n));
//
//        F[1] = 0;
//        F[2] = 1;
//        for (int i = 3; i <= n; i++) {
//            F[i] = F[i - 1] + F[i - 2];
//        }
//
//        for (int i = 1; i <= n; i++) {
//            System.out.print(F[i]+" ");
//
//        }

    }










//    public  static int f(int n) {
//
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//
//            return f(n - 1) + f(n - 2);
//
//
//
//    }


}
