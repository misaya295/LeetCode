package 蓝桥杯.第十一届;


import javax.print.MultiDoc;
import java.util.Scanner;

/*
试题 G: 八次求和
时间限制: 1.0s 内存限制: 512.0MB 本题总分：20 分
【问题描述】
给定正整数 n, 求 18 + 28 + · · · + n8 mod 123456789 。其中 mod 表示取
余。
【输入格式】
输入的第一行包含一个整数 n。
【输出格式】
输出一行，包含一个整数，表示答案。
【样例输入】
2
【样例输出】
257
【样例输入】
987654
【样例输出】
43636805
【评测用例规模与约定】
对于 20% 的评测用例，1 ≤ n ≤ 20。
对于 60% 的评测用例，1 ≤ n ≤ 1000。
对于所有评测用例，1 ≤ n ≤ 1000000。
 */
public class Main6 {

    static long mod =123456789;

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long res = 0;
        for (int i = 1; i <= n; i++) {
            res = (res+ qmi(i, 8)) % mod;
        }

        System.out.println(res);


    }

    static long qmi(long a, int b) {

        long ans = 1;
        while (b > 0) {
         if ((b & 1) ==1) ans = (ans * a) % mod;
            a = (a * a) % mod;
            b >>=1;
        }

        return ans;



    }




}
