package 蓝桥杯.国赛.国赛_2019;


import java.util.HashMap;
import java.util.Map;

/*
试题 E: 序列求和
本题总分：15 分
【问题描述】
学习了约数后，小明对于约数很好奇，他发现，给定一个正整数 t，总是可
以找到含有 t 个约数的整数。小明对于含有 t 个约数的最小数非常感兴趣，并
把它定义为 S t 。
例如 S 1 = 1, S 2 = 2, S 3 = 4, S 4 = 6，S5 =16 · 。
现在小明想知道，前 60 个 S i 的和是多少？即 S 1 + S 2 + · · · + S 60 是多少？
【答案提交】
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一
个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 */
public class Main5 {

    static int n = 1000000;


//    static int cnt;
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {

//            System.out.print(i+"的约数   ");
           int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (i % j == 0) {
//                    System.out.print(j+" ");
                    cnt++;
                }

            }

            if (!map.containsKey(cnt)) {
                map.put(cnt, i);
            } else {
                if (i < map.get(cnt)) {
                    map.put(cnt, i);
                }
            }
//            if (cnt ==5){
//                System.out.println(i);
//                break;
//            }
//            System.out.print("  "+cnt+"个");
//            System.out.println();

        }
        int sum = 0;

        for (int i = 1; i <= 60; i++) {
            if(map.get(i) == null) continue;
            System.out.println(map.get(i));
            sum+=map.get(i);

        }
        System.out.println(sum);


    }







}
