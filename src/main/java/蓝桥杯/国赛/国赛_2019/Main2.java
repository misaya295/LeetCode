package 蓝桥杯.国赛.国赛_2019;


import sun.java2d.opengl.CGLSurfaceData;

import java.sql.Ref;
import java.util.Scanner;

/*
试题 B: 平方拆分
本题总分：5 分
【问题描述】
将 2019 拆分为若干个两两不同的完全平方数之和，一共有多少种不同的方
法？
注意交换顺序视为同一种方法，例如 132 + 252 + 352 = 2019 与 132 + 352 +
252 = 2019 视为同一种方法。
【答案提交】
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一
个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 */
public class Main2 {


    static int cnt;
    public static void main(String[] args) {


        dfs(2019, 1, 45);
        System.out.println(cnt);

    }

    private static void dfs(int num, int min, int max) {

        if (num < 0) {
            return;

        }

        if (num == 0) {
            cnt++;
            return;
        }

        for (int i = min; i < max; i++) {


            dfs(num - i * i, i + 1, max);
        }
    }


}
