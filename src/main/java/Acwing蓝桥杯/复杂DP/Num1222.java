package Acwing蓝桥杯.复杂DP;



/*
X星球的考古学家发现了一批古代留下来的密码。

这些密码是由A、B、C、D 四种植物的种子串成的序列。

仔细分析发现，这些密码串当初应该是前后对称的（也就是我们说的镜像串）。

由于年代久远，其中许多种子脱落了，因而可能会失去镜像的特征。

你的任务是：

给定一个现在看到的密码串，计算一下从当初的状态，它要至少脱落多少个种子，才可能会变成现在的样子。

输入格式
共一行，包含一个由大写字母ABCD构成的字符串，表示现在看到的密码串。

输出格式
输出一个整数，表示至少脱落了多少个种子。

数据范围
输入字符串长度不超过1000

输入样例1：
ABCBA
输出样例1：
0
输入样例2：
ABDCDCBABC
输出样例2：
3
 */
import java.util.Scanner;
public class Num1222 {
    static int N = 1010;
    static int[][] f = new int[N][N];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int n = s.length();
        for(int len = 1;len <= n;len ++)
        {
            for(int i = 0;i + len - 1 < n;i ++)
            {
                int j = i + len - 1;

                if(len == 1) f[i][j] = 1;
                else
                {
                    f[i][j] = Math.max(f[i][j - 1], f[i + 1][j]);
                    if(s.charAt(i) == s.charAt(j))
                    {
                        f[i][j] = Math.max(f[i][j], f[i + 1][j - 1] + 2);
                    }

                }

            }
        }

        System.out.println(n - f[0][n - 1]);
    }
}

