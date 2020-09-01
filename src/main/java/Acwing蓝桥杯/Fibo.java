package Acwing蓝桥杯;

import java.util.Scanner;

public class Fibo {


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        System.out.println(f(n));


    }

    public  static int f(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

            return f(n - 1) + f(n - 2);



    }


}
