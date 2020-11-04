package Acwing提高课.DP.背包问题;



/*

小明手里有n元钱全部用来买书，书的价格为10元，20元，50元，100元。

问小明有多少种买书方案？（每种书可购买多本）

输入格式
一个整数 n，代表总共钱数。

输出格式
一个整数，代表选择方案种数。

数据范围
0≤n≤1000
输入样例1：
20
输出样例1：
2
输入样例2：
15
输出样例2：
0
输入样例3：
0
输出样例3：
1
 */
import java.util.Scanner;
public class Acwing1023 {
    static int N =1010;
    static int[] v = {10, 20, 50, 100};
    static int m;
    static int[] f = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        f[0] = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= m; j++) {
                if(j >= v[i]) f[j] += f[j - v[i]];
            }
        }
        System.out.println(f[m]);
    }

}
