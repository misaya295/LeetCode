package Acwing蓝桥杯.递推与递归.练习;


import java.util.Scanner;

/**
 * 100  可以表示为带分数的形式：100=3+69258/714
 * 还可以表示为：100=82+3546/197
 * 注意特征：带分数中，数字 1∼9 分别出现且只出现一次（不包含 0）。
 * <p>
 * 类似这样的带分数，100 有 11 种表示法。
 * <p>
 * 输入格式
 * 一个正整数。
 * <p>
 * 输出格式
 * 输出输入数字用数码 1∼9 不重复不遗漏地组成带分数表示的全部种数。
 * <p>
 * 数据范围
 * 1≤N<106
 * 输入样例1：
 * 100
 * 输出样例1：
 * 11
 * 输入样例2：
 * 105
 * 输出样例2：
 * 6
 */
public class Num1029 {


    static Scanner s = new Scanner(System.in);
    static int n = s.nextInt();
    static int N = 10;
    static int count = 0;
    static boolean[] backup = new boolean[N];
    static boolean[] st = new boolean[N];
    static int[] way = new int[N];

    public static void main(String[] args) {


        dfs(0);
        System.out.println(count);

    }

    private static void dfs(int index) {

        if (index == 9) {

            for (int i = 0; i < 7; i++) {
                for (int j = i + 1; j < 8; j++) {
                    int a = cal(0, i);
                    int b = cal(i + 1, j);
                    int c = cal(j + 1, 8);
                    if (a * c + b == c * n) {
                        count++;
                    }
                }
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {

            if (!st[i]) {
                way[index] = i;
                st[i] = true;
                dfs(index + 1);
                st[i] = false;
                way[index] = 0;
            }
        }

    }

    private static int cal(int left, int right) {


        int res= 0;
        for (int i = left; i <= right; i++) {
            res = res * 10 + way[i];
        }

        return res;
    }


}