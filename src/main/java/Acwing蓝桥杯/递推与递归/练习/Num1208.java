package Acwing蓝桥杯.递推与递归.练习;




/**
 * 小明正在玩一个“翻硬币”的游戏。
 *
 * 桌上放着排成一排的若干硬币。我们用 * 表示正面，用 o 表示反面（是小写字母，不是零）。
 *
 * 比如，可能情形是：**oo***oooo
 *
 * 如果同时翻转左边的两个硬币，则变为：oooo***oooo
 *
 * 现在小明的问题是：如果已知了初始状态和要达到的目标状态，每次只能同时翻转相邻的两个硬币,那么对特定的局面，最少要翻动多少次呢？
 *
 * 我们约定：把翻动相邻的两个硬币叫做一步操作。
 *
 * 输入格式
 * 两行等长的字符串，分别表示初始状态和要达到的目标状态。
 *
 * 输出格式
 * 一个整数，表示最小操作步数
 *
 * 数据范围
 * 输入字符串的长度均不超过100。
 * 数据保证答案一定有解。
 *
 * 输入样例1：
 * **********
 * o****o****
 * 输出样例1：
 * 5
 * 输入样例2：
 * *o**o***o***
 * *o***o**o***
 * 输出样例2：
 * 1
 * 难度：简单
 * 时/空限制：1s / 64MB
 * 总通过数：903
 * 总尝试数：1238
 * 来源：第四届蓝桥杯省赛C++B组
 * 算法标签
 */

import java.util.Scanner;
public class Num1208 {
   static int N = 110 ;
   static char[] start = new char[N];
   static char[] ed = new char[N];



    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);

        start = s.next().toCharArray();
        ed = s.next().toCharArray();



        int res = 0;

        for (int i = 0; i < start.length; i++) {
            if (start[i] != ed[i]) {
                turn(i);
                turn(i + 1);
                res++;
            }
        }

        System.out.println(res);
//        System.out.print(end[i]);

    }

    private static void turn(int i) {

        if (start[i] == '*') {
            start[i] = 'o';
        } else {
            start[i] = '*';
        }


    }


}
