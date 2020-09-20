package Acwing蓝桥杯.复杂DP;




/*
Hecy 又接了个新任务：BE 处理。

BE 中有一类被称为 GBE。

以下是 GBE 的定义：

空表达式是 GBE
如果表达式 A 是 GBE，则 [A] 与 (A) 都是 GBE
如果 A 与 B 都是 GBE，那么 AB 是 GBE
下面给出一个 BE，求至少添加多少字符能使这个 BE 成为 GBE。

注意：BE 是一个仅由(、)、[、]四种字符中的若干种构成的字符串。

输入格式
输入仅一行，为字符串 BE。

输出格式
输出仅一个整数，表示增加的最少字符数。

数据范围
对于所有输入字符串，其长度小于100。

输入样例：
[])
输出样例：
1
 */
import java.util.Scanner;
public class Num1070 {
    static int N = 110;
    static int n;
    static String s;
    static int[][] f = new int[N][N];
    static boolean check(char a,char b)
    {
        if(a == '(' && b == ')') return true;
        if(a == '[' && b == ']') return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        s = scan.next();
        n = s.length();
        for (int len = 2; len <= n; len++) {
            for (int L = 0; L + len - 1 < n; L++) {
                int R = L + len - 1;
                if (check(s.charAt(L), s.charAt(R))) f[L][R] = Math.max(f[L][R], 2 + f[L + 1][R - 1]);
                for (int k = L; k <= R; k++) {
                    f[L][R] = Math.max(f[L][R], f[L][k] + f[k + 1][R]);
                }
            }
        }
        System.out.println(n - f[0][n - 1]);
    }}