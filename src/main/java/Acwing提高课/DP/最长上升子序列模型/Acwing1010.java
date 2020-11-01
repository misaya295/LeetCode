package Acwing提高课.DP.最长上升子序列模型;



/*
1010. 拦截导弹
   题目
   提交记录
   讨论
   题解
   视频讲解

某国为了防御敌国的导弹袭击，发展出一种导弹拦截系统。

但是这种导弹拦截系统有一个缺陷：虽然它的第一发炮弹能够到达任意的高度，但是以后每一发炮弹都不能高于前一发的高度。

某天，雷达捕捉到敌国的导弹来袭。

由于该系统还在试用阶段，所以只有一套系统，因此有可能不能拦截所有的导弹。

输入导弹依次飞来的高度（雷达给出的高度数据是不大于30000的正整数，导弹数不超过1000），计算这套系统最多能拦截多少导弹，如果要拦截所有导弹最少要配备多少套这种导弹拦截系统。

输入格式
共一行，输入导弹依次飞来的高度。

输出格式
第一行包含一个整数，表示最多能拦截的导弹数。

第二行包含一个整数，表示要拦截所有导弹最少要配备的系统数。

输入样例：
389 207 155 300 299 170 158 65
输出样例：
6
2
 */
import java.util.Scanner;
public class Acwing1010 {
    static int N =1010;
    static int[] a = new int[N];
    static int[] f = new int[N];
    static int[] g = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = s.length;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i]  <= a[j]) f[i] = Math.max(f[i], f[j] + 1);
            }
            res = Math.max(res, f[i]);
        }
        System.out.println(res);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int k = 0;
            while (k < cnt && g[k] < a[i]) k++;
            g[k] = a[i];
            if(k >= cnt) cnt++;
        }
        System.out.println(cnt);
    }


}
