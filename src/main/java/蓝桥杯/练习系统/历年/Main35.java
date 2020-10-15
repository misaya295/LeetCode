package 蓝桥杯.练习系统.历年;


import java.util.Collections;
import java.util.Scanner;

/*
资源限制
时间限制：1.0s   内存限制：256.0MB
问题描述
　　考虑一种简单的正则表达式：
　　只由 x ( ) | 组成的正则表达式。
　　小明想求出这个正则表达式能接受的最长字符串的长度。


　　例如 ((xx|xxx)x|(x|xx))xx 能接受的最长字符串是： xxxxxx，长度是6。
输入格式
　　一个由x()|组成的正则表达式。输入长度不超过100，保证合法。
输出格式
　　这个正则表达式能接受的最长字符串的长度。
样例输入
((xx|xxx)x|(x|xx))xx
样例输出
6
数据规模和约定
　　峰值内存消耗（含虚拟机） < 256M
　　CPU消耗 < 1000ms




　　请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。


　　注意：
　　main函数需要返回0;
　　只使用ANSI C/ANSI C++ 标准;
　　不要调用依赖于编译环境或操作系统的特殊函数。
　　所有依赖的函数必须明确地在源文件中 #include <xxx>
　　不能通过工程设置而省略常用头文件。


　　提交程序时，注意选择所期望的语言类型和编译器类型。
 */
public class Main35 {

    static  int  N =110;
    static char[] g= new char[N];
    static  int n=0;
    static int u =0;
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        g =sc.next().toCharArray();
        n= g.length;
        int res =dfs();
        System.out.println(res);

        


    }

    private static int dfs() {




        int res=0;

        while (u < n){


            if (g[u] == '(') {
                u++;
                res += dfs();
                u++;
            } else if (g[u] == '|') {
                u++;
                res = Math.max(res, dfs());

            } else if (g[u] == ')') {
                break;
            } else {
                u++;
                res++;

            }



        }

        return res;
    }


}
