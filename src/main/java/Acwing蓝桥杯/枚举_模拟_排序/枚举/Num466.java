package Acwing蓝桥杯.枚举_模拟_排序.枚举;




/*
在日常生活中，通过年、月、日这三个要素可以表示出一个唯一确定的日期。

牛牛习惯用 8 位数字表示一个日期，其中，前 4 位代表年份，接下来 2 位代表月份，最后 2 位代表日期。

显然：一个日期只有一种表示方法，而两个不同的日期的表示方法不会相同。

牛牛认为，一个日期是回文的，当且仅当表示这个日期的8位数字是回文的。

现在，牛牛想知道：在他指定的两个日期之间（包含这两个日期本身），有多少个真实存在的日期是回文的。

一个 8 位数字是回文的，当且仅当对于所有的 i(1≤i≤8) 从左向右数的第i个数字和第 9−i 个数字（即从右向左数的第 i 个数字）是相同的。

例如：

•对于2016年11月19日，用 8 位数字 20161119 表示，它不是回文的。

•对于2010年1月2日，用 8 位数字 20100102 表示，它是回文的。

•对于2010年10月2日，用 8 位数字 20101002 表示，它不是回文的。

输入格式
输入包括两行，每行包括一个8位数字。

第一行表示牛牛指定的起始日期date1，第二行表示牛牛指定的终止日期date2。保证date1和date2都是真实存在的日期，且年份部分一定为4位数字，且首位数字不为0。

保证date1一定不晚于date2。

输出格式
输出共一行，包含一个整数，表示在date1和date2之间，有多少个日期是回文的。

输入样例：
20110101
20111231
输出样例：
1
 */
import java.util.Scanner;
public class Num466 {

   static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int date1 = Integer.parseInt(scanner.next());
        int date2 = Integer.parseInt(scanner.next());

        int res = 0;


        for (int i = 1000; i < 10000; i++) {
            int date = i, x = i;
            for (int j = 1; j <= 4; j++) {
                date = date * 10 + x % 10;
                x /= 10;
            }
            if (date1 <= date && date <=date2 && check_vail(date)) res++;
        }
        System.out.println(res);

    }

    private static boolean check_vail(int date) {

        int year= date/10000;
        int month = date % 10000 / 100;
        int day = date % 100;

        if (month == 0 || month > 12) {
            return false;
        }
        if (day == 0 || month != 2 && day > days[month]) {
            return false;
        }


        if (month == 2) {

            int leap = 0;
            if (year % 100  != 0 && year % 4 == 0 || year % 400 == 0) leap = 1;
            if (day > 28 + leap) {
                return false;
            }


        }

        return true;



    }


}
