package Acwing蓝桥杯.枚举_模拟_排序.模拟;



/*
小明正在整理一批历史文献。这些历史文献中出现了很多日期。

小明知道这些日期都在1960年1月1日至2059年12月31日。
02/03/04

更加麻烦的是，年份也都省略了前两位，使得文献上的一个日期，存在很多可能的日期与其对应。

比如02/03/04，可能是2002年03月04日、2004年02月03日或2004年03月02日。

给出一个文献上的日期，你能帮助小明判断有哪些可能的日期对其对应吗？

输入格式
一个日期，格式是”AA/BB/CC”。

即每个’/’隔开的部分由两个 0-9 之间的数字（不一定相同）组成。

输出格式
输出若干个不相同的日期，每个日期一行，格式是”yyyy-MM-dd”。

多个日期按从早到晚排列。

数据范围
0≤A,B,C≤9
输入样例：
02/03/04
输出样例：
2002-03-04
2004-02-03
2004-03-02
 */
import java.util.Scanner;
public class Num1229 {

    static int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] next = scanner.next().split("/");
        int a = Integer.parseInt(next[0]);
        int b = Integer.parseInt(next[1]);
        int c = Integer.parseInt(next[2]);


        for (int date = 19600101; date <= 20591231; date++) {

            int year = date / 10000;
            int month = date % 10000 / 100;
            int day = date % 100;
            if (check_vail(year, month, day)) {
                if (
                        year % 100 == a && month == b && day == c
                        || month == a && day == b && year % 100 == c
                        || day == a && month == b && year % 100 == c) {


                    System.out.printf("%d-%02d-%02d\n", year, month, day);


                }
            }

        }

    }

    private static boolean check_vail(int year, int month, int day) {

        int leap =0;
        if (month == 0 || month > 12) {
            return false;
        }

        if (day == 0) {
            return false;
        }

        if (month != 2) {
            if (day > days[month]) {
                return false;
            }
            } else {
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                leap = 1;
            }
            if (day > 28 + leap) {
                return false;
            }


        }
        return true;



    }

}
