package Acwing提高课.DP.最长上升子序列模型;



/*
1016. 最大上升子序列和
   题目
   提交记录
   讨论
   题解
   视频讲解

一个数的序列 bi，当 b1<b2<…<bS 的时候，我们称这个序列是上升的。

对于给定的一个序列(a1,a2,…,aN)，我们可以得到一些上升的子序列(ai1,ai2,…,aiK)，这里1≤i1<i2<…<iK≤N。

比如，对于序列(1,7,3,5,9,4,8)，有它的一些上升子序列，如(1,7),(3,4,8)等等。

这些子序列中和最大为18，为子序列(1,3,5,9)的和。

你的任务，就是对于给定的序列，求出最大上升子序列和。

注意，最长的上升子序列的和不一定是最大的，比如序列(100,1,2,3)的最大上升子序列和为100，而最长上升子序列为(1,2,3)。

输入格式
输入的第一行是序列的长度N。

第二行给出序列中的N个整数，这些整数的取值范围都在0到10000(可能重复)。

输出格式
输出一个整数，表示最大上升子序列和。

数据范围
1≤N≤1000
输入样例：
7
1 7 3 5 9 4 8
输出样例：
18
 */
import java.util.Scanner;
public class Acwing1016 {
    static int N =10010;
    static int n;
    static int[] a = new int[N];
    static int[] f = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) a[i] = sc.nextInt();
        int res=0;
        for(int i=1;i <=n;i++){
            f[i] = a[i];
            for (int j = 1; j < i; j++) {
                if (a[i] > a[j]) {
                    f[i] = Math.max(f[i], f[j] + a[i]);
                }
            }
            res = Math.max(f[i], res);
        }
        System.out.println(res);
    }

}
