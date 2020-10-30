package Acwing提高课.DP.最长上升子序列模型;



/*
五一到了，ACM队组织大家去登山观光，队员们发现山上一个有N个景点，并且决定按照顺序来浏览这些景点，即每次所浏览景点的编号都要大于前一个浏览景点的编号。

同时队员们还有另一个登山习惯，就是不连续浏览海拔相同的两个景点，并且一旦开始下山，就不再向上走了。

队员们希望在满足上面条件的同时，尽可能多的浏览景点，你能帮他们找出最多可能浏览的景点数么？

输入格式
第一行包含整数N，表示景点数量。

第二行包含N个整数，表示每个景点的海拔。

输出格式
输出一个整数，表示最多能浏览的景点数。

数据范围
2≤N≤1000
输入样例：
8
186 186 150 200 160 130 197 220
输出样例：
4
 */
import java.util.Scanner;
public class Acwing1014 {
    static int N = 1010;
    static int n;
    static int[] f = new int[N];
    static int[] g = new int[N];
    static int[] a = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i = 1; i <= n; i++) a[i] = sc.nextInt();

        for(int i =1;i <= n;i++){
            f[i] = 1;
            for (int j = 1; j < i; j++) {
                if(a[i] > a[j]) f[i] = Math.max(f[i], f[j] + 1);

            }
        }

        for(int i = n;i >= 1;i--){
            g[i] = 1;
            for (int j = n; j > i; j--) {
                if(a[i] > a[j]) g[i] = Math.max(g[i], g[j] + 1);
            }

        }

        int res = 0;
        for (int i = 1; i <= n; i++) res = Math.max(res, f[i] + g[i] - 1);
        System.out.println(res);

    }

}
