package 蓝桥杯.国赛.国赛_2019;


/*
试题 F: 最长子序列
时间限制: 1.0s 内存限制: 512.0MB 本题总分：15 分
【问题描述】
我们称一个字符串 S 包含字符串 T 是指 T 是 S 的一个子序列，即可以从
字符串 S 中抽出若干个字符，它们按原来的顺序组合成一个新的字符串与 T 完
全一样。
给定两个字符串 S 和 T，请问 T 中从第一个字符开始最长连续多少个字符
被 S 包含？
【输入格式】
输入两行，每行一个字符串。第一行的字符串为 S，第二行的字符串为 T。
两个字符串均非空而且只包含大写英文字母。
【输出格式】
输出一个整数，表示答案。
【样例输入】
ABCDEABCD
AABZ
【样例输出】
3
【评测用例规模与约定】
对于 20% 的评测用例，1 ≤ |T| ≤ |S | ≤ 20；
对于 40% 的评测用例，1 ≤ |T| ≤ |S | ≤ 100；
对于所有评测用例，1 ≤ |T| ≤ |S | ≤ 1000。
 */
import java.util.Scanner;
public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s = sc.next().toCharArray();
        char[] t = sc.next().toCharArray();
        int n = s.length;
        int m = t.length;
        int cnt = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == t[j]) {
                j++;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}


