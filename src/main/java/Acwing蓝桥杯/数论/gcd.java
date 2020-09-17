package Acwing蓝桥杯.数论;

/*
欧几里得算法
 */
public class gcd {

    public static int gcd(int a, int b) {
        return b!=0 ? gcd(b, a % b) : a;


    }



    public static void main(String[] args) {

        System.out.println(gcd(20, 4));
    }
}
