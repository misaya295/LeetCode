package 蓝桥杯.shengsai_2018;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 6、标题：递增三元组
 * 给定三个整数数组
 * A = [A1, A2, ... AN],
 * B = [B1, B2, ... BN],
 * C = [C1, C2, ... CN]，
 * 请你统计有多少个三元组(i, j, k) 满足：
 *
 * 1. 1 <= i, j, k <= N
 * 2. Ai < Bj < Ck
 *
 * 【输入格式】
 * 第一行包含一个整数N。
 * 第二行包含N个整数A1, A2, ... AN。
 * 第三行包含N个整数B1, B2, ... BN。
 * 第四行包含N个整数C1, C2, ... CN。
 *
 * 对于30%的数据，1 <= N <= 100
 * 对于60%的数据，1 <= N <= 1000
 * 对于100%的数据，1 <= N <= 100000 0 <= Ai, Bi, Ci <= 100000
 *
 * 【输出格式】
 * 一个整数表示答案
 *
 * 【输入样例】
 * 3
 * 1 1 1
 * 2 2 2
 * 3 3 3
 *
 * 【输出样例】
 * 27
 *
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 256M
 * CPU消耗  < 1000ms
 *
 * 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
 * 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 * 不要使用package语句。不要使用jdk1.7及以上版本的特性。
 * 主类的名字必须是：Main，否则按无效代码处理。
 *
 * 10W的数据规模，3个for的暴力解法O(n^3)肯定超时，不过拿60%已经挺不错了,优化下，最后一层for改为二分，
 * 这样的复杂度O(n^2logn)还是太高，可以再优化一次，把A和B，B和C分开统计，现在在B中二分查找比A[i]大的个数，
 * 同理在C中二分查找比B[i]大的个数,最后所有的这2个数相乘的累加就是ans,复杂度O(nlogn)
 */
public class Main6 {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        int[] C = new int[n];
        int[] B = new int[n];


        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            C[i] = in.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; i < n; j++) {
                if (A[i] < B[j]) {
                    int l =0,r=n-1;

                    while (l <= r) {

                        int m = (l + r) / 2;
                        if (C[m] > B[j]) {
                            r = m - 1;
                        }else{
                            l = m + 1;
                        }

                        ans += n - l;
                    }

                }
            }
        }


        System.out.println(ans);

    }




}
