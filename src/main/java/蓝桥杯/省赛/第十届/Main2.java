package 蓝桥杯.省赛.第十届;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 一个字符串的非空子串是指字符串中长度至少为1 的连续的一段字符组成
 的串。例如，字符串aaab 有非空子串a, b, aa, ab, aaa, aab, aaab，一共7 个。
 注意在计算时，只算本质不同的串的个数。
 请问，字符串0100110001010001 有多少个不同的非空子串？

 这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一
 个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。

答案31
 */


public class Main2 {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String next = sc.next();

        char[] a = next.toCharArray();
        Set<String> set = new HashSet<>();



        for(int i=0;i <a.length;i++){
            String s= String.valueOf(a[i]);
//            System.out.println(s);
            set.add(s);
            for(int j=0;j <i;j++){
                s+=a[j];
//                System.out.println(s);

                set.add(s);
            }

        }


        System.out.println(set.size());

    }

}
