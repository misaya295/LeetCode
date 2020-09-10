package Acwing蓝桥杯.枚举_模拟_排序.枚举;



/*
小明对数位中含有 2、0、1、9 的数字很感兴趣（不包括前导 0），在 1 到 40 中这样的数包括 1、2、9、10 至 32、39 和 40，共 28 个，他们的和是 574。

请问，在 1 到 n 中，所有这样的数的和是多少？

输入格式
共一行，包含一个整数 n。

输出格式
共一行，包含一个整数，表示满足条件的数的和。

数据范围
1≤n≤10000
输入样例：
40
输出样例：
574
 */
import java.util.Scanner;
public class Num1245 {


    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();

    public static void main(String[] args) {


        int res = 0;

        for (int i = 1; i <= n; i++) {

            int x = i;
            while (x > 0) {

                int t = x % 10;

                x /= 10;
                if (t == 2 || t == 0 || t == 1 || t == 9) {
                    res+=i;
                    break;

                }

            }

        }
        System.out.println(res);


    }
}
