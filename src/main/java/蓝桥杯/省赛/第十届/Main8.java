package 蓝桥杯.省赛.第十届;

import java.util.ArrayList;

/**
 * 【问题描述】
 * 小明正在分析一本小说中的人物相关性。他想知道在小说中 Alice 和 Bob
 * 有多少次同时出现。
 * 更准确的说，小明定义 Alice 和 Bob“同时出现”的意思是：在小说文本
 * 中 Alice 和 Bob 之间不超过 K 个字符。
 * 例如以下文本：
 * This is a story about Alice and Bob. Alice wants to send a private message to Bob.
 * 假设 K = 20，则 Alice 和 Bob 同时出现了 2 次，分别是”Alice and Bob”
 * 和”Bob. Alice”。前者 Alice 和 Bob 之间有 5 个字符，后者有 2 个字符。
 * 注意:
 * 1. Alice 和 Bob 是大小写敏感的，alice 或 bob 等并不计算在内。
 * 2. Alice 和 Bob 应为单独的单词，前后可以有标点符号和空格，但是不能
 * 有字母。例如 Bobbi 並不算出现了 Bob。
 * 【输入格式】
 * 第一行包含一个整数 K。
 * 第二行包含一行字符串，只包含大小写字母、标点符号和空格。长度不超
 * 过 1000000。
 * 【输出格式】
 * 输出一个整数，表示 Alice 和 Bob 同时出现的次数。
 * 【样例输入】
 * 20
 * This is a story about Alice and Bob. Alice wants to send a private message to Bob.
 * 试题H: 人物相关性分析 12
 * 第十届蓝桥杯大赛软件类省赛 Java 大学 B 组
 * 【样例输出】
 * 2
 * 【评测用例规模与约定】
 * 对于所有评测用例，1 ≤ K ≤ 1000000。
 */
/*import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;*/
import java.util.*;
public class Main8{
    private static String string;
    private static int ans=0;
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        scanner.useDelimiter("\n");
        int k = scanner.nextInt();
        string = scanner.next();
        for(int i=0;i+5<=string.length();i++) { //获取所有Alice和Bob单词首字母的位置
            if ((i == 0 ||ok(i - 1  )) && ( i + 5 == string.length()|| ok(i + 5)) ) {
                if(string.substring(i, i + 5).equals("Alice")){
                    a.add(i);
                }
            }
        }
        for(int i=0;i+3<=string.length();i++){
            if ((i == 0 || ok(i - 1)) && ( i + 3 == string.length()|| ok(i + 3)) ) {
                if(string.substring(i, i + 3).equals("Bob")){
                    b.add(i);
                }
            }
        }
        for(int i=0;i<a.size();i++){
            int r = 0;
            int l = 0;
            while(r<b.size()&&a.get(i)>b.get(r)){
                r++;
            }
            while(l<r&&a.get(i)>b.get(l)+k+3){
                l++;
            }
            ans+=(r-l);
        }
        for(int i=0;i<b.size();i++){
            int r = 0;
            int l = 0;
            while(r<a.size()&&b.get(i)>a.get(r)){
                r++;
            }
            while(l<r&&b.get(i)>a.get(l)+k+5){
                l++;
            }
            ans+=(r-l);
        }
        System.out.print(ans);
    }
    public static boolean ok(int x){ //判断制定索引处是否为单词 不是单词返回true
        char ch = string.charAt(x);
        if((ch>='A'&&ch<='Z')||(ch>='a'&&ch<='z')){
            return false;
        }else{
            return true;
        }
    }
}