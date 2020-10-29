package 蓝桥杯.国赛.第六届;


import javax.xml.transform.Source;

/*

标题：分机号

X老板脾气古怪，他们公司的电话分机号都是3位数，老板规定，所有号码必须是降序排列，且不能有重复的数位。比如：

751,520,321 都满足要求，而，
766,918,201 就不符合要求。

现在请你计算一下，按照这样的规定，一共有多少个可用的3位分机号码？

请直接提交该数字，不要填写任何多余的内容。


120

 */
public class Main1 {


    /*
    暴力
     */

    public static void main(String[] args) {
        int res = 0;
        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {

                    if (i < j && j < k) {
                        res++;

                    }


                }
            }

        }

        System.out.println(res);
    }





    /*
    dfs
     */
//
//    static int N = 30;
//    static int n , m;
//    static int[] w = new int[N];
//
//    static int total = 0;
//
//    public static void main(String[] args) {
//
//        n = 9;
//        m = 3;
//
//        dfs(1, 0);
//        System.out.println(total);
//    }
//
//    static void dfs(int u, int start) {
//
//        if(u + n - start < m) return;
//
//        if (u == m + 1) {
//            if (w[1] < w[2] && w[2] < w[3]) total++;
//            for (int i = 1; i <= m; i++) {
//                System.out.print(w[i] + " ");
//            }
//            System.out.println();
//            return;
//        }
//
//        for (int i = 0; i <= n; i++) {
//            w[u] = i;
//            dfs(u + 1, i + 1);
//        }
//
//
//    }





}
