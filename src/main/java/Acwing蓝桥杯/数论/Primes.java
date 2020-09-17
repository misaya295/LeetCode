package Acwing蓝桥杯.数论;


import java.util.Scanner;

/*
筛法求质数
 */
public class Primes {

    static Scanner scanner = new Scanner(System.in);
    static int N =100010;
    static int[] primes = new int[N]; static int cnt; //存所有的质数
    static boolean[] st = new boolean[N]; //当前数没有被筛过
    static int[] minp = new int[N]; //最小质因子

    public static void main(String[] args) {

        get_primes(100000);

        for (int i = 0; i < 20; i++) {
            System.out.println(primes[i]);
        }

    }

    public static void get_primes(int n) {

        for (int i = 2; i <= n; i++) {

            if (!st[i]) {
                primes[cnt++] = i;
                for (int j = 0; primes[j] * i <= n; j++) {
                    int t = primes[j] * i;
                    st[t] = true;
                    minp[t] = primes[j];
                    if (i % primes[j] == 0) break;
                }
            }
        }

    }







}
